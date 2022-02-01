package com.tencent.qqmini.sdk.widget.media;

import android.app.Activity;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnControllerClickListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnErrorListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoPreparedListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoViewInitListener;

public abstract interface IVideoPlayer
{
  public abstract void captureImageInTime(int paramInt1, int paramInt2);
  
  public abstract AbsVideoPlayer getAbsVideoPlayer();
  
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
  
  public abstract void setOutputMute(boolean paramBoolean);
  
  public abstract void setUpPlayer(MiniAppVideoConfig paramMiniAppVideoConfig, AbsVideoPlayer.OnVideoViewInitListener paramOnVideoViewInitListener, AbsVideoPlayer.OnControllerClickListener paramOnControllerClickListener, AbsVideoPlayer.OnVideoPreparedListener paramOnVideoPreparedListener, AbsVideoPlayer.OnCompletionListener paramOnCompletionListener, AbsVideoPlayer.OnErrorListener paramOnErrorListener, AbsVideoPlayer.OnInfoListener paramOnInfoListener, AbsVideoPlayer.OnSeekCompleteListener paramOnSeekCompleteListener);
  
  public abstract void start();
  
  public abstract void startPlayDanmu();
  
  public abstract void stop();
  
  public abstract void updateMute(MiniAppVideoConfig paramMiniAppVideoConfig);
  
  public abstract void updateObjFit(MiniAppVideoConfig paramMiniAppVideoConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.IVideoPlayer
 * JD-Core Version:    0.7.0.1
 */