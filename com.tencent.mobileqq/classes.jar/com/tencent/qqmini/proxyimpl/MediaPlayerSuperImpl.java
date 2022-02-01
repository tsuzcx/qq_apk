package com.tencent.qqmini.proxyimpl;

import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnBufferingUpdateListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnErrorListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnLoopStartListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnPreparedListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnVideoSizeChangedListener;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;

public class MediaPlayerSuperImpl
  implements IMediaPlayer
{
  private ISuperPlayer a;
  private ISPlayerVideoView b;
  private SuperPlayerVideoInfo c;
  private String d = "MediaPlayerSuperImpl";
  
  public MediaPlayerSuperImpl()
  {
    if ((this.b == null) || (this.a == null)) {
      try
      {
        QLog.i(this.d, 1, "[createPlayerVideoView]");
        this.b = SuperPlayerFactory.createPlayerVideoView(BaseApplication.getContext());
        this.a = SuperPlayerFactory.createMediaPlayer(BaseApplication.getContext(), 114, this.b);
        this.b.addViewCallBack(new MediaPlayerSuperImpl.1(this));
        return;
      }
      catch (Exception localException)
      {
        QLog.e(this.d, 1, "[init superPlayer error]", localException);
        this.b = null;
        this.a = null;
      }
    }
  }
  
  public int getBufferPercent()
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer == null)
    {
      QLog.e(this.d, 1, "[getBufferPercent error] mMediaPlayer is null.");
      return 0;
    }
    return localISuperPlayer.getBufferPercent();
  }
  
  public long getCurrentPosition()
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer == null)
    {
      QLog.e(this.d, 1, "[getCurrentPosition error], mMediaPlayer is null.");
      return -1L;
    }
    return localISuperPlayer.getCurrentPositionMs();
  }
  
  public long getDuration()
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer == null)
    {
      QLog.e(this.d, 1, "[getDuration error], mMediaPlayer is null.");
      return -1L;
    }
    return localISuperPlayer.getDurationMs();
  }
  
  public int getVideoHeight()
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer == null)
    {
      QLog.e(this.d, 1, "[getVideoHight error] mMediaPlayer is null.");
      return -1;
    }
    return localISuperPlayer.getVideoHeight();
  }
  
  public int getVideoWidth()
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer == null)
    {
      QLog.e(this.d, 1, "[getVideoWidth error] mMediaPlayer is null.");
      return -1;
    }
    return localISuperPlayer.getVideoWidth();
  }
  
  public boolean isLooping()
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer == null)
    {
      QLog.e(this.d, 1, "[isLooping error] mMediaPlayer is null.");
      return false;
    }
    return localISuperPlayer.isLoopBack();
  }
  
  public boolean isPlaying()
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer == null)
    {
      QLog.e(this.d, 1, "[isPlaying error] mMediaPlayer is null.");
      return false;
    }
    return localISuperPlayer.isPlaying();
  }
  
  public boolean isSuperPlayer()
  {
    return true;
  }
  
  public void pause()
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer == null)
    {
      QLog.e(this.d, 1, "[pause error] mMediaPlayer is null.");
      return;
    }
    localISuperPlayer.pause();
  }
  
  public void prepareAsync()
  {
    ISuperPlayer localISuperPlayer = this.a;
    if ((localISuperPlayer != null) && (this.c != null))
    {
      localISuperPlayer.openMediaPlayer(BaseApplication.getContext(), this.c, 0L);
      return;
    }
    QLog.e(this.d, 1, "[openMediaPlayer error] mMediaPlayer/videoInfo is null.");
  }
  
  public void release()
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer == null)
    {
      QLog.e(this.d, 1, "[release error], mMediaPlayer is null.");
      return;
    }
    localISuperPlayer.release();
  }
  
  public void reset()
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer == null)
    {
      QLog.e(this.d, 1, "[reset error], mMediaPlayer is null.");
      return;
    }
    localISuperPlayer.reset();
  }
  
  public void seekTo(long paramLong)
  {
    int i = (int)paramLong;
    if (i != -2147483648)
    {
      ISuperPlayer localISuperPlayer = this.a;
      if (localISuperPlayer != null)
      {
        localISuperPlayer.seekTo(i);
        return;
      }
    }
    QLog.e(this.d, 1, "[seekTo error] mMediaPlayer is null or invalid params.");
  }
  
  public void setDataSource(String paramString)
  {
    if (this.a == null)
    {
      QLog.e(this.d, 1, "[startPlay(setDataSource) error] mMediaPlayer is null.");
      return;
    }
    String str = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[startPlay] url = ");
    localStringBuilder.append(paramString);
    QLog.i(str, 1, localStringBuilder.toString());
    this.c = SuperPlayerFactory.createVideoInfoForUrl(paramString, 100, null);
  }
  
  public void setDisplay(SurfaceHolder paramSurfaceHolder) {}
  
  public void setDrmDataSource(String paramString1, String paramString2, String paramString3)
  {
    if (this.a == null)
    {
      QLog.e(this.d, 1, "[startPlay(setDataSource) error] mMediaPlayer is null.");
      return;
    }
    String str = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[startPlay drm] url = ");
    localStringBuilder.append(paramString1);
    QLog.i(str, 1, localStringBuilder.toString());
    this.c = SuperPlayerFactory.createVideoInfoForDRM(0, paramString1, 102, paramString2, paramString3);
  }
  
  public void setLooping(boolean paramBoolean)
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer == null)
    {
      QLog.e(this.d, 1, "[setLooping error] mMediaPlayer is null.");
      return;
    }
    localISuperPlayer.setLoopback(paramBoolean);
  }
  
  public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener) {}
  
  public void setOnCompletionListener(IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer == null)
    {
      QLog.e(this.d, 1, "[setOnCompletionListener error], mMediaPlayer is null.");
      return;
    }
    localISuperPlayer.setOnCompletionListener(new MediaPlayerSuperImpl.3(this, paramOnCompletionListener));
  }
  
  public void setOnErrorListener(IMediaPlayer.OnErrorListener paramOnErrorListener)
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer == null)
    {
      QLog.e(this.d, 1, "[setOnErrorListener error] mMediaPlayer is null.");
      return;
    }
    localISuperPlayer.setOnErrorListener(new MediaPlayerSuperImpl.6(this, paramOnErrorListener));
  }
  
  public void setOnInfoListener(IMediaPlayer.OnInfoListener paramOnInfoListener)
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer == null)
    {
      QLog.e(this.d, 1, "[setOnInfoListener error] mMediaPlayer is null.");
      return;
    }
    localISuperPlayer.setOnInfoListener(new MediaPlayerSuperImpl.7(this, paramOnInfoListener));
  }
  
  public void setOnLoopStartListener(IMediaPlayer.OnLoopStartListener paramOnLoopStartListener) {}
  
  public void setOnPreparedListener(IMediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer == null)
    {
      QLog.e(this.d, 1, "[setOnPreparedListener error], mMediaPlayer is null.");
      return;
    }
    localISuperPlayer.setOnVideoPreparedListener(new MediaPlayerSuperImpl.2(this, paramOnPreparedListener));
  }
  
  public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer == null)
    {
      QLog.e(this.d, 1, "[setOnSeekCompleteListener error] mMediaPlayer is null.");
      return;
    }
    localISuperPlayer.setOnSeekCompleteListener(new MediaPlayerSuperImpl.4(this, paramOnSeekCompleteListener));
  }
  
  public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer == null)
    {
      QLog.e(this.d, 1, "[setOnVideoSizeChangedListener error] mMediaPlayer is null.");
      return;
    }
    localISuperPlayer.setOnVideoSizeChangedListener(new MediaPlayerSuperImpl.5(this, paramOnVideoSizeChangedListener));
  }
  
  public void setRate(float paramFloat)
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer == null)
    {
      QLog.e(this.d, 1, "[setRate error] mMediaPlayer is null.");
      return;
    }
    localISuperPlayer.setPlaySpeedRatio(paramFloat);
  }
  
  public void setScreenOnWhilePlaying(boolean paramBoolean) {}
  
  public void setSurface(Surface paramSurface)
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer == null)
    {
      QLog.e(this.d, 1, "[setSurface error] mMediaPlayer is null.");
      return;
    }
    localISuperPlayer.setSurface(paramSurface);
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    if (this.a == null)
    {
      QLog.e(this.d, 1, "[setVolume error], mMediaPlayer is null.");
      return;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFloat1 == 0.0F)
    {
      bool1 = bool2;
      if (paramFloat2 == 0.0F) {
        bool1 = true;
      }
    }
    this.a.setOutputMute(bool1);
  }
  
  public void start()
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer == null)
    {
      QLog.e(this.d, 1, "[start error] mMediaPlayer is null.");
      return;
    }
    localISuperPlayer.start();
  }
  
  public void stop()
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer == null)
    {
      QLog.e(this.d, 1, "[stop error] mMediaPlayer is null.");
      return;
    }
    localISuperPlayer.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MediaPlayerSuperImpl
 * JD-Core Version:    0.7.0.1
 */