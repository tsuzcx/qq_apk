package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.content.Context;

public abstract class AbsVideoPlayer
{
  public static final int PLAYER_INFO_ENDOF_BUFFERING = 22;
  public static final int PLAYER_INFO_START_BUFFERING = 21;
  
  public abstract int captureImageInTime(int paramInt1, int paramInt2);
  
  public abstract void createVideoView(Context paramContext, AbsVideoPlayer.OnVideoViewInitListener paramOnVideoViewInitListener);
  
  public abstract long getCurrentPostion();
  
  public abstract long getDuration();
  
  public abstract boolean getOutputMute();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract boolean isPlaying();
  
  public abstract void openMediaPlayerByUrl(Context paramContext, String paramString, long paramLong);
  
  public abstract void pause();
  
  public abstract void release();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void setLoopback(boolean paramBoolean);
  
  public abstract void setOnCaptureImageListener(AbsVideoPlayer.OnCaptureImageListener paramOnCaptureImageListener);
  
  public abstract void setOnCompletionListener(AbsVideoPlayer.OnCompletionListener paramOnCompletionListener);
  
  public abstract void setOnControllerClickListener(AbsVideoPlayer.OnControllerClickListener paramOnControllerClickListener);
  
  public abstract void setOnErrorListener(AbsVideoPlayer.OnErrorListener paramOnErrorListener);
  
  public abstract void setOnInfoListener(AbsVideoPlayer.OnInfoListener paramOnInfoListener);
  
  public abstract void setOnSeekCompleteListener(AbsVideoPlayer.OnSeekCompleteListener paramOnSeekCompleteListener);
  
  public abstract void setOnVideoPreparedListener(AbsVideoPlayer.OnVideoPreparedListener paramOnVideoPreparedListener);
  
  public abstract boolean setOutputMute(boolean paramBoolean);
  
  public abstract void setXYaxis(int paramInt);
  
  public abstract void start();
  
  public abstract void startPlayDanmu();
  
  public abstract void stop();
  
  public abstract void stopPlayDanmu();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
 * JD-Core Version:    0.7.0.1
 */