package com.tencent.superplayer.player;

import android.content.Context;
import android.view.Surface;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;

abstract interface SuperPlayerMgrInternal$SPlayerManagerInternalListener
{
  public abstract void handleAddSubtitleSource(String paramString1, String paramString2, String paramString3);
  
  public abstract int handleCaptureImageInTime(long paramLong, int paramInt1, int paramInt2);
  
  public abstract int handleCaptureImageInTime(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract void handleDeselectTrack(int paramInt, long paramLong);
  
  public abstract int handleGetBufferPercent();
  
  public abstract long handleGetCurrentPosition();
  
  public abstract long handleGetDuration();
  
  public abstract long handleGetFileSizeBytes();
  
  public abstract MediaInfo handleGetMediaInfo();
  
  public abstract TPProgramInfo[] handleGetProgramInfo();
  
  public abstract String handleGetStreamDumpInfo();
  
  public abstract TPTrackInfo[] handleGetTrackInfo();
  
  public abstract int handleGetVideoHeight();
  
  public abstract int handleGetVideoRotation();
  
  public abstract int handleGetVideoWidth();
  
  public abstract boolean handleIsBuffering();
  
  public abstract void handleOpenMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong, SuperPlayerOption paramSuperPlayerOption);
  
  public abstract void handlePause();
  
  public abstract void handlePauseDownload();
  
  public abstract void handleRelease();
  
  public abstract void handleReset();
  
  public abstract void handleResumeDownload();
  
  public abstract void handleSeekTo(int paramInt);
  
  public abstract void handleSeekTo(int paramInt1, int paramInt2);
  
  public abstract void handleSelectProgram(int paramInt, long paramLong);
  
  public abstract void handleSelectTrack(int paramInt, long paramLong);
  
  public abstract void handleSetBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void handleSetLoopback(boolean paramBoolean);
  
  public abstract void handleSetLoopback(boolean paramBoolean, long paramLong1, long paramLong2);
  
  public abstract boolean handleSetOutputMute(boolean paramBoolean);
  
  public abstract void handleSetPlaySpeedRatio(float paramFloat);
  
  public abstract void handleSetSurface(Surface paramSurface);
  
  public abstract void handleStart();
  
  public abstract void handleStop();
  
  public abstract void handleSwitchDefinition(String paramString);
  
  public abstract void handleUpdatePlayerVideoView(ISPlayerVideoView paramISPlayerVideoView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerMgrInternal.SPlayerManagerInternalListener
 * JD-Core Version:    0.7.0.1
 */