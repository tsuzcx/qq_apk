package com.tencent.mobileqq.shortvideo.util;

import aiiu;
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
  private aiiu jdField_a_of_type_Aiiu;
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
        this.jdField_a_of_type_Aiiu = null;
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
          if (this.jdField_a_of_type_Aiiu == null)
          {
            this.jdField_a_of_type_Aiiu = new aiiu(this, null);
            this.jdField_a_of_type_Aiiu.start();
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
          this.jdField_a_of_type_Aiiu = null;
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
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 31	com/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnonnull +9 -> 19
    //   13: iload_2
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 31	com/tencent/mobileqq/shortvideo/util/SimpleAudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   23: invokevirtual 40	android/media/MediaPlayer:isPlaying	()Z
    //   26: istore_1
    //   27: goto -12 -> 15
    //   30: astore_3
    //   31: iload_2
    //   32: istore_1
    //   33: invokestatic 68	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/SdkContext;
    //   36: invokevirtual 71	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/Logger;
    //   39: invokeinterface 75 1 0
    //   44: ifeq -29 -> 15
    //   47: invokestatic 68	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/SdkContext;
    //   50: invokevirtual 71	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/Logger;
    //   53: ldc 77
    //   55: ldc 138
    //   57: aload_3
    //   58: invokeinterface 129 4 0
    //   63: iload_2
    //   64: istore_1
    //   65: goto -50 -> 15
    //   68: astore_3
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_3
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	SimpleAudioPlayer
    //   14	51	1	bool1	boolean
    //   1	63	2	bool2	boolean
    //   8	2	3	localMediaPlayer	MediaPlayer
    //   30	28	3	localIllegalStateException	java.lang.IllegalStateException
    //   68	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   19	27	30	java/lang/IllegalStateException
    //   4	9	68	finally
    //   19	27	68	finally
    //   33	63	68	finally
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
    this.jdField_a_of_type_Aiiu = null;
    a();
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Aiiu = null;
    a();
    SdkContext.a().a().a("SimpleAudioPlayer", "playSimpleAudio " + this.jdField_a_of_type_JavaLangString + "onError: " + paramInt1 + "," + paramInt2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.SimpleAudioPlayer
 * JD-Core Version:    0.7.0.1
 */