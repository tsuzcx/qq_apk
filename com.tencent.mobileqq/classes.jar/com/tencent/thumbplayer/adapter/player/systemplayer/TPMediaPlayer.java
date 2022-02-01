package com.tencent.thumbplayer.adapter.player.systemplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.TrackInfo;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.Map;

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
  
  public int getCurrentPosition()
  {
    try
    {
      int i = super.getCurrentPosition();
      return i;
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
    }
    return 0;
  }
  
  public int getDuration()
  {
    try
    {
      int i = super.getDuration();
      return i;
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
    }
    return 0;
  }
  
  public int getSelectedTrack(int paramInt)
  {
    try
    {
      paramInt = super.getSelectedTrack(paramInt);
      return paramInt;
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
    }
    return 0;
  }
  
  public MediaPlayer.TrackInfo[] getTrackInfo()
  {
    try
    {
      MediaPlayer.TrackInfo[] arrayOfTrackInfo = super.getTrackInfo();
      return arrayOfTrackInfo;
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
    }
    return new MediaPlayer.TrackInfo[0];
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
  
  public void prepare()
  {
    try
    {
      super.prepare();
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
    }
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
  
  public void reset()
  {
    try
    {
      super.reset();
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
    }
  }
  
  public void setDataSource(Context paramContext, Uri paramUri)
  {
    try
    {
      super.setDataSource(paramContext, paramUri);
      return;
    }
    catch (Exception paramContext)
    {
      TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", paramContext);
    }
  }
  
  public void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
  {
    try
    {
      super.setDataSource(paramContext, paramUri, paramMap);
      return;
    }
    catch (Exception paramContext)
    {
      TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", paramContext);
    }
  }
  
  public void setDataSource(FileDescriptor paramFileDescriptor)
  {
    try
    {
      super.setDataSource(paramFileDescriptor);
      return;
    }
    catch (Exception paramFileDescriptor)
    {
      TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", paramFileDescriptor);
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
  
  public void setLooping(boolean paramBoolean)
  {
    try
    {
      super.setLooping(paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
    }
  }
  
  public void setPlaybackParams(PlaybackParams paramPlaybackParams)
  {
    try
    {
      super.setPlaybackParams(paramPlaybackParams);
      return;
    }
    catch (Exception paramPlaybackParams)
    {
      TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", paramPlaybackParams);
    }
  }
  
  public void setSurface(Surface paramSurface)
  {
    try
    {
      super.setSurface(paramSurface);
      return;
    }
    catch (Exception paramSurface)
    {
      TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", paramSurface);
    }
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    try
    {
      super.setVolume(paramFloat1, paramFloat2);
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
    }
  }
  
  public void stop()
  {
    try
    {
      super.stop();
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPMediaPlayer
 * JD-Core Version:    0.7.0.1
 */