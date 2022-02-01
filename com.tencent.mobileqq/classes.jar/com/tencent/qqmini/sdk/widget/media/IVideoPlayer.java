package com.tencent.qqmini.sdk.widget.media;

import android.app.Activity;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoViewInitListener;

public abstract interface IVideoPlayer
{
  public abstract void captureImageInTime(int paramInt1, int paramInt2);
  
  public abstract void createVideoView(AbsVideoPlayer.OnVideoViewInitListener paramOnVideoViewInitListener);
  
  public abstract long getCurrentPostion();
  
  public abstract long getDuration();
  
  public abstract boolean getOutputMute();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract boolean isPlaying();
  
  public abstract void openMediaPlayerByUrl(Activity paramActivity, String paramString, long paramLong);
  
  public abstract void pause();
  
  public abstract void release();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void setOnCaptureImageListener(AbsVideoPlayer.OnCaptureImageListener paramOnCaptureImageListener);
  
  public abstract void setupPlayer(MiniAppVideoConfig paramMiniAppVideoConfig, MiniAppVideoPlayerListenerHolder paramMiniAppVideoPlayerListenerHolder);
  
  public abstract void start();
  
  public abstract void startPlayDanmu();
  
  public abstract void stop();
  
  public abstract void updateMute(MiniAppVideoConfig paramMiniAppVideoConfig);
  
  public abstract void updateObjFit(MiniAppVideoConfig paramMiniAppVideoConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.IVideoPlayer
 * JD-Core Version:    0.7.0.1
 */