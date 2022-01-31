package com.tencent.qqmini.proxyimpl;

import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.oskplayer.player.OskExoMediaPlayer;
import com.tencent.qqmini.sdk.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.core.proxy.IMediaPlayer.OnBufferingUpdateListener;
import com.tencent.qqmini.sdk.core.proxy.IMediaPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.core.proxy.IMediaPlayer.OnErrorListener;
import com.tencent.qqmini.sdk.core.proxy.IMediaPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.core.proxy.IMediaPlayer.OnLoopStartListener;
import com.tencent.qqmini.sdk.core.proxy.IMediaPlayer.OnPreparedListener;
import com.tencent.qqmini.sdk.core.proxy.IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.core.proxy.IMediaPlayer.OnVideoSizeChangedListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.InternalOperationException;

public class MediaPlayerImpl
  implements IMediaPlayer
{
  OskExoMediaPlayer mMediaPlayer = new OskExoMediaPlayer();
  
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
    try
    {
      this.mMediaPlayer.pause();
      return;
    }
    catch (IMediaPlayer.InternalOperationException localInternalOperationException)
    {
      throw new IllegalStateException(localInternalOperationException);
    }
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
    this.mMediaPlayer.seekTo(paramLong);
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
    this.mMediaPlayer.setOnBufferingUpdateListener(new MediaPlayerImpl.3(this, paramOnBufferingUpdateListener));
  }
  
  public void setOnCompletionListener(IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.mMediaPlayer.setOnCompletionListener(new MediaPlayerImpl.2(this, paramOnCompletionListener));
  }
  
  public void setOnErrorListener(IMediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.mMediaPlayer.setOnErrorListener(new MediaPlayerImpl.6(this, paramOnErrorListener));
  }
  
  public void setOnInfoListener(IMediaPlayer.OnInfoListener paramOnInfoListener)
  {
    this.mMediaPlayer.setOnInfoListener(new MediaPlayerImpl.7(this, paramOnInfoListener));
  }
  
  public void setOnLoopStartListener(IMediaPlayer.OnLoopStartListener paramOnLoopStartListener)
  {
    this.mMediaPlayer.setOnLoopStartListener(new MediaPlayerImpl.8(this, paramOnLoopStartListener));
  }
  
  public void setOnPreparedListener(IMediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.mMediaPlayer.setOnPreparedListener(new MediaPlayerImpl.1(this, paramOnPreparedListener));
  }
  
  public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.mMediaPlayer.setOnSeekCompleteListener(new MediaPlayerImpl.4(this, paramOnSeekCompleteListener));
  }
  
  public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    this.mMediaPlayer.setOnVideoSizeChangedListener(new MediaPlayerImpl.5(this, paramOnVideoSizeChangedListener));
  }
  
  public void setRate(float paramFloat)
  {
    this.mMediaPlayer.setRate(paramFloat);
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
    try
    {
      this.mMediaPlayer.start();
      return;
    }
    catch (IMediaPlayer.InternalOperationException localInternalOperationException)
    {
      throw new IllegalStateException(localInternalOperationException);
    }
  }
  
  public void stop()
  {
    this.mMediaPlayer.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MediaPlayerImpl
 * JD-Core Version:    0.7.0.1
 */