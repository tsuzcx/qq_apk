package com.tencent.superplayer.player;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.superplayer.api.ISuperPlayer.OnAudioPcmDataListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoOutputFrameListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;

public abstract interface SPlayerManagerInternal$SPlayerManagerInternalListener
{
  public abstract int handleCaptureImageInTime(long paramLong, int paramInt1, int paramInt2);
  
  public abstract int handleCaptureImageInTime(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract long handleGetCurrentPosition();
  
  public abstract int handleGetDownloadSpeed(int paramInt);
  
  public abstract long handleGetDuration();
  
  public abstract MediaInfo handleGetMediaInfo();
  
  public abstract boolean handleGetOutputMute();
  
  public abstract long handleGetPlayedTime();
  
  public abstract String handleGetStreamDumpInfo();
  
  public abstract int handleGetVideoHeight();
  
  public abstract int handleGetVideoRotation();
  
  public abstract int handleGetVideoWidth();
  
  public abstract boolean handleIsLoopback();
  
  public abstract boolean handleIsPausing();
  
  public abstract boolean handleIsPlaying();
  
  public abstract boolean handleOnKeyEvent(KeyEvent paramKeyEvent);
  
  public abstract boolean handleOnTouchEvent(View paramView, MotionEvent paramMotionEvent);
  
  public abstract void handleOpenMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong);
  
  public abstract void handleOpenMediaPlayerByUrl(Context paramContext, String[] paramArrayOfString, long paramLong, String paramString1, String paramString2);
  
  public abstract void handlePause();
  
  public abstract void handleRelease();
  
  public abstract void handleReset();
  
  public abstract void handleSeekTo(int paramInt);
  
  public abstract void handleSeekTo(int paramInt1, int paramInt2);
  
  public abstract void handleSetAudioGainRatio(float paramFloat);
  
  public abstract void handleSetLoopback(boolean paramBoolean);
  
  public abstract void handleSetLoopback(boolean paramBoolean, long paramLong1, long paramLong2);
  
  public abstract void handleSetOnAudioPcmDataListener(ISuperPlayer.OnAudioPcmDataListener paramOnAudioPcmDataListener);
  
  public abstract void handleSetOnCaptureImageListener(ISuperPlayer.OnCaptureImageListener paramOnCaptureImageListener);
  
  public abstract void handleSetOnCompletionListener(ISuperPlayer.OnCompletionListener paramOnCompletionListener);
  
  public abstract void handleSetOnErrorListener(ISuperPlayer.OnErrorListener paramOnErrorListener);
  
  public abstract void handleSetOnInfoListener(ISuperPlayer.OnInfoListener paramOnInfoListener);
  
  public abstract void handleSetOnSeekCompleteListener(ISuperPlayer.OnSeekCompleteListener paramOnSeekCompleteListener);
  
  public abstract void handleSetOnVideoOutputFrameListener(ISuperPlayer.OnVideoOutputFrameListener paramOnVideoOutputFrameListener);
  
  public abstract void handleSetOnVideoPreparedListener(ISuperPlayer.OnVideoPreparedListener paramOnVideoPreparedListener);
  
  public abstract void handleSetOnVideoSizeChangedListener(ISuperPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener);
  
  public abstract boolean handleSetOutputMute(boolean paramBoolean);
  
  public abstract void handleSetPlaySpeedRatio(float paramFloat);
  
  public abstract void handleSetXYaxis(int paramInt);
  
  public abstract void handleStart();
  
  public abstract void handleStop();
  
  public abstract void handleUpdatePlayerVideoView(ISPlayerVideoView paramISPlayerVideoView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.SPlayerManagerInternal.SPlayerManagerInternalListener
 * JD-Core Version:    0.7.0.1
 */