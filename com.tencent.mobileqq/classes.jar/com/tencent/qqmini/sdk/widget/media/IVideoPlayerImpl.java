package com.tencent.qqmini.sdk.widget.media;

import android.app.Activity;
import android.util.Log;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoViewInitListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class IVideoPlayerImpl
  implements IVideoPlayer
{
  private static final String TAG = "IVideoPlayerImpl";
  private AbsVideoPlayer absVideoPlayer = null;
  private Activity activity;
  
  public IVideoPlayerImpl(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  private void updatePlayerListener(MiniAppVideoPlayerListenerHolder paramMiniAppVideoPlayerListenerHolder)
  {
    if (paramMiniAppVideoPlayerListenerHolder != null)
    {
      if (paramMiniAppVideoPlayerListenerHolder.onControllerClickListener != null) {
        this.absVideoPlayer.setOnControllerClickListener(paramMiniAppVideoPlayerListenerHolder.onControllerClickListener);
      }
      if (paramMiniAppVideoPlayerListenerHolder.onVideoPreparedListener != null) {
        this.absVideoPlayer.setOnVideoPreparedListener(paramMiniAppVideoPlayerListenerHolder.onVideoPreparedListener);
      }
      if (paramMiniAppVideoPlayerListenerHolder.onCompletionListener != null) {
        this.absVideoPlayer.setOnCompletionListener(paramMiniAppVideoPlayerListenerHolder.onCompletionListener);
      }
      if (paramMiniAppVideoPlayerListenerHolder.onErrorListener != null) {
        this.absVideoPlayer.setOnErrorListener(paramMiniAppVideoPlayerListenerHolder.onErrorListener);
      }
      if (paramMiniAppVideoPlayerListenerHolder.onInfoListener != null) {
        this.absVideoPlayer.setOnInfoListener(paramMiniAppVideoPlayerListenerHolder.onInfoListener);
      }
      if (paramMiniAppVideoPlayerListenerHolder.onSeekCompleteListener != null) {
        this.absVideoPlayer.setOnSeekCompleteListener(paramMiniAppVideoPlayerListenerHolder.onSeekCompleteListener);
      }
      if (paramMiniAppVideoPlayerListenerHolder.onCaptureImageListener != null) {
        this.absVideoPlayer.setOnCaptureImageListener(paramMiniAppVideoPlayerListenerHolder.onCaptureImageListener);
      }
    }
  }
  
  public void captureImageInTime(int paramInt1, int paramInt2)
  {
    this.absVideoPlayer.captureImageInTime(paramInt1, paramInt2);
  }
  
  public void createVideoView(AbsVideoPlayer.OnVideoViewInitListener paramOnVideoViewInitListener)
  {
    if (this.absVideoPlayer == null)
    {
      localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      if (localObject == null) {
        break label47;
      }
    }
    label47:
    for (Object localObject = ((ChannelProxy)localObject).getVideoPlayer();; localObject = null)
    {
      this.absVideoPlayer = ((AbsVideoPlayer)localObject);
      if (this.absVideoPlayer != null) {
        break;
      }
      QMLog.e("IVideoPlayerImpl", "initPlayer absVideoPlayer is null, return.");
      return;
    }
    this.absVideoPlayer.createVideoView(this.activity, paramOnVideoViewInitListener);
  }
  
  public long getCurrentPostion()
  {
    return this.absVideoPlayer.getCurrentPostion();
  }
  
  public long getDuration()
  {
    return this.absVideoPlayer.getDuration();
  }
  
  public boolean getOutputMute()
  {
    return this.absVideoPlayer.getOutputMute();
  }
  
  public int getVideoHeight()
  {
    return this.absVideoPlayer.getVideoHeight();
  }
  
  public int getVideoWidth()
  {
    return this.absVideoPlayer.getVideoWidth();
  }
  
  public boolean isPlaying()
  {
    return this.absVideoPlayer.isPlaying();
  }
  
  public void openMediaPlayerByUrl(Activity paramActivity, String paramString, long paramLong)
  {
    this.absVideoPlayer.openMediaPlayerByUrl(paramActivity, paramString, paramLong);
  }
  
  public void pause()
  {
    this.absVideoPlayer.pause();
  }
  
  public void release()
  {
    this.absVideoPlayer.release();
  }
  
  public void seekTo(int paramInt)
  {
    this.absVideoPlayer.seekTo(paramInt);
  }
  
  public void setOnCaptureImageListener(AbsVideoPlayer.OnCaptureImageListener paramOnCaptureImageListener)
  {
    this.absVideoPlayer.setOnCaptureImageListener(paramOnCaptureImageListener);
  }
  
  public void setupPlayer(MiniAppVideoConfig paramMiniAppVideoConfig, MiniAppVideoPlayerListenerHolder paramMiniAppVideoPlayerListenerHolder)
  {
    updatePlayerListener(paramMiniAppVideoPlayerListenerHolder);
    this.absVideoPlayer.setLoopback(paramMiniAppVideoConfig.loop);
    paramMiniAppVideoPlayerListenerHolder = this.absVideoPlayer;
    if ("contain".equals(paramMiniAppVideoConfig.objectFit)) {}
    for (int i = 0;; i = 1)
    {
      paramMiniAppVideoPlayerListenerHolder.setXYaxis(i);
      return;
    }
  }
  
  public void start()
  {
    this.absVideoPlayer.start();
  }
  
  public void startPlayDanmu()
  {
    this.absVideoPlayer.startPlayDanmu();
  }
  
  public void stop()
  {
    this.absVideoPlayer.stop();
  }
  
  public void updateMute(MiniAppVideoConfig paramMiniAppVideoConfig)
  {
    if ((this.absVideoPlayer != null) && (this.absVideoPlayer.getOutputMute() != paramMiniAppVideoConfig.muted))
    {
      Log.i("IVideoPlayerImpl", "initSetting: set mute " + paramMiniAppVideoConfig.muted);
      this.absVideoPlayer.setOutputMute(paramMiniAppVideoConfig.muted);
    }
  }
  
  public void updateObjFit(MiniAppVideoConfig paramMiniAppVideoConfig)
  {
    if (this.absVideoPlayer != null)
    {
      if (!"contain".equals(paramMiniAppVideoConfig.objectFit)) {
        break label28;
      }
      this.absVideoPlayer.setXYaxis(0);
    }
    label28:
    while (!"fill".equals(paramMiniAppVideoConfig.objectFit)) {
      return;
    }
    this.absVideoPlayer.setXYaxis(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.IVideoPlayerImpl
 * JD-Core Version:    0.7.0.1
 */