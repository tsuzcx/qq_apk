package com.tencent.superplayer.api;

import android.content.Context;
import com.tencent.superplayer.player.MediaInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;

public abstract interface ISuperPlayer
{
  public abstract int captureImageInTime(long paramLong, int paramInt1, int paramInt2);
  
  public abstract int captureImageInTime(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract long getCurrentPositionMs();
  
  public abstract long getDurationMs();
  
  public abstract MediaInfo getMediaInfo();
  
  public abstract long getPlayedTime();
  
  public abstract String getStreamDumpInfo();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoRotation();
  
  public abstract int getVideoWidth();
  
  public abstract boolean isLoopBack();
  
  public abstract boolean isOutputMute();
  
  public abstract boolean isPausing();
  
  public abstract boolean isPlaying();
  
  public abstract void openMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong);
  
  public abstract void openMediaPlayerByUrl(Context paramContext, String paramString, long paramLong);
  
  public abstract void openMediaPlayerByUrl(Context paramContext, String paramString1, long paramLong, String paramString2, String paramString3);
  
  public abstract void openMediaPlayerByUrl(Context paramContext, String[] paramArrayOfString, long paramLong, String paramString1, String paramString2);
  
  public abstract void pause();
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void seekTo(int paramInt1, int paramInt2);
  
  public abstract void setLoopback(boolean paramBoolean);
  
  public abstract void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2);
  
  public abstract void setOnAudioPcmDataListener(ISuperPlayer.OnAudioPcmDataListener paramOnAudioPcmDataListener);
  
  public abstract void setOnCaptureImageListener(ISuperPlayer.OnCaptureImageListener paramOnCaptureImageListener);
  
  public abstract void setOnCompletionListener(ISuperPlayer.OnCompletionListener paramOnCompletionListener);
  
  public abstract void setOnErrorListener(ISuperPlayer.OnErrorListener paramOnErrorListener);
  
  public abstract void setOnInfoListener(ISuperPlayer.OnInfoListener paramOnInfoListener);
  
  public abstract void setOnSeekCompleteListener(ISuperPlayer.OnSeekCompleteListener paramOnSeekCompleteListener);
  
  public abstract void setOnVideoOutputFrameListener(ISuperPlayer.OnVideoOutputFrameListener paramOnVideoOutputFrameListener);
  
  public abstract void setOnVideoPreparedListener(ISuperPlayer.OnVideoPreparedListener paramOnVideoPreparedListener);
  
  public abstract void setOnVideoSizeChangedListener(ISuperPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener);
  
  public abstract void setOutputMute(boolean paramBoolean);
  
  public abstract void setPlaySpeedRatio(float paramFloat);
  
  public abstract void setXYaxis(int paramInt);
  
  public abstract void start();
  
  public abstract void stop();
  
  public abstract void updatePlayerVideoView(ISPlayerVideoView paramISPlayerVideoView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.api.ISuperPlayer
 * JD-Core Version:    0.7.0.1
 */