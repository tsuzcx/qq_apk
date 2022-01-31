package com.tencent.thumbplayer.adapter.player.systemplayer;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.view.SurfaceHolder;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.lang.reflect.Field;

public class TPMediaPlayer
  extends MediaPlayer
{
  private static final String TAG = "TPThumbPlayer[TPMediaPlayer.java]";
  
  protected void finalize()
  {
    try
    {
      super.finalize();
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
    }
  }
  
  public int getVideoHeight()
  {
    try
    {
      int i = super.getVideoHeight();
      return i;
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
    }
    return 0;
  }
  
  public int getVideoWidth()
  {
    try
    {
      int i = super.getVideoWidth();
      return i;
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
    }
    return 0;
  }
  
  public void release()
  {
    try
    {
      if (("N1W".equalsIgnoreCase(Build.MODEL)) || ("X909T".equalsIgnoreCase(Build.MODEL)) || ("X909".equalsIgnoreCase(Build.MODEL)) || ("N1T".equalsIgnoreCase(Build.MODEL)))
      {
        super.setOnPreparedListener(null);
        super.setOnCompletionListener(null);
        super.setOnErrorListener(null);
        super.setOnInfoListener(null);
        super.setOnBufferingUpdateListener(null);
        super.setOnSeekCompleteListener(null);
        super.setOnVideoSizeChangedListener(null);
        ((Handler)super.getClass().getDeclaredField("mA2dpHandler").get(this)).removeCallbacksAndMessages(null);
      }
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        try
        {
          super.release();
          return;
        }
        catch (Exception localException)
        {
          TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
        }
        localNoSuchFieldException = localNoSuchFieldException;
        TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", localNoSuchFieldException);
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", localIllegalAccessException);
      }
    }
  }
  
  public void setDisplay(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      super.setDisplay(paramSurfaceHolder);
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", paramSurfaceHolder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPMediaPlayer
 * JD-Core Version:    0.7.0.1
 */