package com.tencent.mobileqq.shortvideo.util;

import aiea;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.sveffects.Logger;
import com.tencent.sveffects.SdkContext;
import java.io.File;

public class SimpleAudioPlayer
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener
{
  public static int a;
  private aiea jdField_a_of_type_Aiea;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private String jdField_a_of_type_JavaLangString;
  private volatile int b = jdField_a_of_type_Int;
  private int c = -1;
  
  static
  {
    jdField_a_of_type_Int = -999;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        this.jdField_a_of_type_Aiea = null;
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
  }
  
  private boolean b(String paramString, int paramInt)
  {
    boolean bool = false;
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    label261:
    for (;;)
    {
      try
      {
        long l = System.currentTimeMillis();
        this.jdField_a_of_type_JavaLangString = paramString;
        if (!b(paramString))
        {
          if (SdkContext.a().a().a()) {
            SdkContext.a().a().d("SimpleAudioPlayer", "file not found, " + paramString);
          }
          a();
          return bool;
        }
        try
        {
          b();
          this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
          this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
          this.c = i;
          this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
          this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
          if (this.jdField_a_of_type_Aiea == null)
          {
            this.jdField_a_of_type_Aiea = new aiea(this, null);
            this.jdField_a_of_type_Aiea.start();
          }
          if (!SdkContext.a().a().a()) {
            break label261;
          }
          SdkContext.a().a().d("SimpleAudioPlayer", "play music time = " + (System.currentTimeMillis() - l));
        }
        catch (Exception paramString)
        {
          if (SdkContext.a().a().a()) {
            SdkContext.a().a().a("SimpleAudioPlayer", "play on error, ", paramString);
          }
          onError(this.jdField_a_of_type_AndroidMediaMediaPlayer, 0, 0);
        }
        continue;
        bool = true;
      }
      finally {}
    }
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())
        {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
          this.jdField_a_of_type_Aiea = null;
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
        this.b = jdField_a_of_type_Int;
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying());
  }
  
  public boolean a(String paramString)
  {
    return b(paramString, 0);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return b(paramString, paramInt);
  }
  
  public boolean b(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (paramString.length() <= 0L));
    return true;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.jdField_a_of_type_Aiea = null;
    a();
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Aiea = null;
    a();
    SdkContext.a().a().a("SimpleAudioPlayer", "playSimpleAudio " + this.jdField_a_of_type_JavaLangString + "onError: " + paramInt1 + "," + paramInt2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.SimpleAudioPlayer
 * JD-Core Version:    0.7.0.1
 */