package com.tencent.superplayer.api;

import android.content.Context;
import android.view.Surface;
import com.tencent.superplayer.player.MediaInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;
import java.util.Map;

public abstract interface ISuperPlayer
{
  public abstract void addExtReportData(String paramString1, String paramString2);
  
  public abstract void addExtReportData(Map<String, String> paramMap);
  
  public abstract void addSubtitleSource(String paramString1, String paramString2, String paramString3);
  
  public abstract int captureImageInTime(long paramLong, int paramInt1, int paramInt2);
  
  public abstract int captureImageInTime(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract void deselectTrack(int paramInt, long paramLong);
  
  public abstract int getBufferPercent();
  
  public abstract int getCurrentPlayerState();
  
  public abstract long getCurrentPositionMs();
  
  public abstract long getDurationMs();
  
  public abstract long getFileSizeBytes();
  
  public abstract MediaInfo getMediaInfo();
  
  public abstract TPProgramInfo[] getProgramInfo();
  
  public abstract String getStreamDumpInfo();
  
  public abstract String getToken();
  
  public abstract TPTrackInfo[] getTrackInfo();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoRotation();
  
  public abstract ISPlayerVideoView getVideoView();
  
  public abstract int getVideoWidth();
  
  public abstract boolean isBuffering();
  
  public abstract boolean isLoopBack();
  
  public abstract boolean isOutputMute();
  
  public abstract boolean isPausing();
  
  public abstract boolean isPlaying();
  
  public abstract void onPrePlayViewShow();
  
  public abstract void openMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong);
  
  public abstract void openMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong, SuperPlayerOption paramSuperPlayerOption);
  
  public abstract void pause();
  
  public abstract void pauseDownload();
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void resumeDownload();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void seekTo(int paramInt1, int paramInt2);
  
  public abstract void selectProgram(int paramInt, long paramLong);
  
  public abstract void selectTrack(int paramInt, long paramLong);
  
  public abstract void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setLoopback(boolean paramBoolean);
  
  public abstract void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2);
  
  public abstract void setOnAudioFrameOutputListener(ISuperPlayer.OnAudioFrameOutputListener paramOnAudioFrameOutputListener);
  
  public abstract void setOnCaptureImageListener(ISuperPlayer.OnCaptureImageListener paramOnCaptureImageListener);
  
  public abstract void setOnCompletionListener(ISuperPlayer.OnCompletionListener paramOnCompletionListener);
  
  public abstract void setOnDefinitionInfoListener(ISuperPlayer.OnDefinitionInfoListener paramOnDefinitionInfoListener);
  
  public abstract void setOnErrorListener(ISuperPlayer.OnErrorListener paramOnErrorListener);
  
  public abstract void setOnInfoListener(ISuperPlayer.OnInfoListener paramOnInfoListener);
  
  public abstract void setOnSeekCompleteListener(ISuperPlayer.OnSeekCompleteListener paramOnSeekCompleteListener);
  
  public abstract void setOnSubtitleDataListener(ISuperPlayer.OnSubtitleDataListener paramOnSubtitleDataListener);
  
  public abstract void setOnTVideoNetInfoUpdateListener(ISuperPlayer.OnTVideoNetInfoListener paramOnTVideoNetInfoListener);
  
  public abstract void setOnVideoFrameOutputListener(ISuperPlayer.OnVideoFrameOutputListener paramOnVideoFrameOutputListener);
  
  public abstract void setOnVideoPreparedListener(ISuperPlayer.OnVideoPreparedListener paramOnVideoPreparedListener);
  
  public abstract void setOnVideoSizeChangedListener(ISuperPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener);
  
  public abstract void setOutputMute(boolean paramBoolean);
  
  public abstract void setPlaySpeedRatio(float paramFloat);
  
  public abstract void setPlayerActive();
  
  public abstract void setReportContentId(String paramString);
  
  public abstract void setSurface(Surface paramSurface);
  
  public abstract void setXYaxis(int paramInt);
  
  public abstract void start();
  
  public abstract void stop();
  
  public abstract void switchDefinition(String paramString);
  
  public abstract void updatePlayerVideoView(ISPlayerVideoView paramISPlayerVideoView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.api.ISuperPlayer
 * JD-Core Version:    0.7.0.1
 */