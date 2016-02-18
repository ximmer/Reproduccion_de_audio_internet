package com.example.upam.reproduccion_de_audio_internet;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;


public class MainActivity extends ActionBarActivity implements MediaPlayer.OnPreparedListener {

    private MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void ejecutar(View v){
mp= new MediaPlayer();
        mp.setOnPreparedListener(this);
        try {
            mp.setDataSource( "http://www.javaya.com.ar/recursos/gato.mp3");
            mp.prepare ();
            mp.start ();
        } catch (IOException s) {
        }
        Toast t=Toast.makeText(this,"Espere un momento mientras carga el mp3",Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mp.start();
    }



}
