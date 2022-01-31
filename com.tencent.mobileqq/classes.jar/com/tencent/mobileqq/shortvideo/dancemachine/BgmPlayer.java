package com.tencent.mobileqq.shortvideo.dancemachine;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import java.io.IOException;

public class BgmPlayer
  implements MediaPlayer.OnPreparedListener
{
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
  private boolean jdField_a_of_type_Boolean = false;
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
        return;
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.BgmPlayer
 * JD-Core Version:    0.7.0.1
 */