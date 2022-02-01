package com.tencent.qqmini.sdk.core.proxy.service;

import android.media.MediaPlayer;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnBufferingUpdateListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnErrorListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnLoopStartListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnPreparedListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnVideoSizeChangedListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class DefaultMediaPlayer
  implements IMediaPlayer
{
  public static final String LOG_TAG = "DefaultMediaPlayer";
  MediaPlayer mMediaPlayer = new MediaPlayer();
  
  public long getCurrentPosition()
  {
    return this.mMediaPlayer.getCurrentPosition();
  }
  
  public long getDuration()
  {
    return this.mMediaPlayer.getDuration();
  }
  
  public int getVideoHeight()
  {
    return this.mMediaPlayer.getVideoHeight();
  }
  
  public int getVideoWidth()
  {
    return this.mMediaPlayer.getVideoWidth();
  }
  
  public boolean isLooping()
  {
    return this.mMediaPlayer.isLooping();
  }
  
  public boolean isPlaying()
  {
    return this.mMediaPlayer.isPlaying();
  }
  
  public void pause()
  {
    this.mMediaPlayer.pause();
  }
  
  public void prepareAsync()
  {
    this.mMediaPlayer.prepareAsync();
  }
  
  public void release()
  {
    this.mMediaPlayer.release();
  }
  
  public void reset()
  {
    this.mMediaPlayer.reset();
  }
  
  public void seekTo(long paramLong)
  {
    this.mMediaPlayer.seekTo((int)paramLong);
  }
  
  public void setDataSource(String paramString)
  {
    this.mMediaPlayer.setDataSource(paramString);
  }
  
  public void setDisplay(SurfaceHolder paramSurfaceHolder)
  {
    this.mMediaPlayer.setDisplay(paramSurfaceHolder);
  }
  
  public void setLooping(boolean paramBoolean)
  {
    this.mMediaPlayer.setLooping(paramBoolean);
  }
  
  public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener)
  {
    this.mMediaPlayer.setOnBufferingUpdateListener(new DefaultMediaPlayer.3(this, paramOnBufferingUpdateListener));
  }
  
  public void setOnCompletionListener(IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.mMediaPlayer.setOnCompletionListener(new DefaultMediaPlayer.2(this, paramOnCompletionListener));
  }
  
  public void setOnErrorListener(IMediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.mMediaPlayer.setOnErrorListener(new DefaultMediaPlayer.6(this, paramOnErrorListener));
  }
  
  public void setOnInfoListener(IMediaPlayer.OnInfoListener paramOnInfoListener)
  {
    this.mMediaPlayer.setOnInfoListener(new DefaultMediaPlayer.7(this, paramOnInfoListener));
  }
  
  public void setOnLoopStartListener(IMediaPlayer.OnLoopStartListener paramOnLoopStartListener)
  {
    QMLog.w("DefaultMediaPlayer", "setOnLoopStartListener is not supported!");
  }
  
  public void setOnPreparedListener(IMediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.mMediaPlayer.setOnPreparedListener(new DefaultMediaPlayer.1(this, paramOnPreparedListener));
  }
  
  public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.mMediaPlayer.setOnSeekCompleteListener(new DefaultMediaPlayer.4(this, paramOnSeekCompleteListener));
  }
  
  public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    this.mMediaPlayer.setOnVideoSizeChangedListener(new DefaultMediaPlayer.5(this, paramOnVideoSizeChangedListener));
  }
  
  public void setRate(float paramFloat)
  {
    QMLog.w("DefaultMediaPlayer", "setRate:" + paramFloat + " is not supported");
  }
  
  public void setScreenOnWhilePlaying(boolean paramBoolean)
  {
    this.mMediaPlayer.setScreenOnWhilePlaying(paramBoolean);
  }
  
  public void setSurface(Surface paramSurface)
  {
    this.mMediaPlayer.setSurface(paramSurface);
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    this.mMediaPlayer.setVolume(paramFloat1, paramFloat2);
  }
  
  public void start()
  {
    this.mMediaPlayer.start();
  }
  
  public void stop()
  {
    this.mMediaPlayer.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.DefaultMediaPlayer
 * JD-Core Version:    0.7.0.1
 */