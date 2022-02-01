package com.tencent.superplayer.player;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.superplayer.api.SuperPlayerAudioInfo;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;

class SuperPlayerMgrInternal
{
  private static final int MSG_INDEX = 0;
  private static final int MSG_OPEN_MEDIA_PLAYER = 1;
  private static final int MSG_PAUSE = 13;
  private static final int MSG_PAUSE_DOWNLOAD = 89;
  private static final int MSG_RELEASE = 21;
  private static final int MSG_RESET = 15;
  private static final int MSG_RESUME_DOWNLOAD = 90;
  private static final int MSG_SEEK_TO = 23;
  private static final int MSG_SEEK_TO_BY_MODE = 24;
  private static final int MSG_SET_AUDIO_GAIN_RATIO = 31;
  private static final int MSG_SET_AUDIO_POST_PARAMS = 93;
  private static final int MSG_SET_BUSINESS_DOWNLOAD_STRATEGY = 92;
  private static final int MSG_SET_LOOPBACK = 29;
  private static final int MSG_SET_LOOPBACK_WITH_POSITION = 85;
  private static final int MSG_SET_OUTPUT_MUTE = 27;
  private static final int MSG_SET_PLAY_SPEED_RATIO = 9;
  private static final int MSG_SET_SURFACE = 6;
  private static final int MSG_SET_X_Y_AXIS = 8;
  private static final int MSG_START = 12;
  private static final int MSG_STOP = 14;
  private static final int MSG_SWITCH_DEFINITION = 88;
  private static final int MSG_UPDATE_PLAYER_VIDEO_VIEW = 5;
  private SuperPlayerMgrInternal.EventHandler mEventHandler;
  private SuperPlayerMgrInternal.SPlayerManagerInternalListener mHandleListener;
  private String mLogTag;
  private Looper mLooper;
  
  SuperPlayerMgrInternal(String paramString, Looper paramLooper, SuperPlayerMgrInternal.SPlayerManagerInternalListener paramSPlayerManagerInternalListener)
  {
    this.mLogTag = paramString;
    this.mLooper = paramLooper;
    this.mEventHandler = new SuperPlayerMgrInternal.EventHandler(this, this.mLooper, null);
    this.mHandleListener = paramSPlayerManagerInternalListener;
  }
  
  private void internalMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (paramBoolean2) {
      this.mEventHandler.removeMessages(paramInt1);
    }
    Message localMessage = this.mEventHandler.obtainMessage();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    localMessage.obj = paramObject;
    this.mEventHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void internalMessage(int paramInt, Object paramObject)
  {
    internalMessage(paramInt, 0, 0, paramObject, false, false, 0L);
  }
  
  int captureImageInTime(long paramLong, int paramInt1, int paramInt2)
  {
    return this.mHandleListener.handleCaptureImageInTime(paramLong, paramInt1, paramInt2);
  }
  
  int captureImageInTime(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return this.mHandleListener.handleCaptureImageInTime(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  int getBufferPercent()
  {
    return this.mHandleListener.handleGetBufferPercent();
  }
  
  long getCurrentPositionMs()
  {
    return this.mHandleListener.handleGetCurrentPosition();
  }
  
  long getDurationMs()
  {
    return this.mHandleListener.handleGetDuration();
  }
  
  MediaInfo getMediaInfo()
  {
    return this.mHandleListener.handleGetMediaInfo();
  }
  
  long getPlayedTime()
  {
    return this.mHandleListener.handleGetPlayedTime();
  }
  
  String getStreamDumpInfo()
  {
    return this.mHandleListener.handleGetStreamDumpInfo();
  }
  
  int getVideoHeight()
  {
    return this.mHandleListener.handleGetVideoHeight();
  }
  
  int getVideoRotation()
  {
    return this.mHandleListener.handleGetVideoRotation();
  }
  
  int getVideoWidth()
  {
    return this.mHandleListener.handleGetVideoWidth();
  }
  
  boolean isBuffering()
  {
    return this.mHandleListener.handleIsBuffering();
  }
  
  boolean isLoopBack()
  {
    return this.mHandleListener.handleIsLoopback();
  }
  
  boolean isOutputMute()
  {
    return this.mHandleListener.handleGetOutputMute();
  }
  
  boolean isPausing()
  {
    return this.mHandleListener.handleIsPausing();
  }
  
  boolean isPlaying()
  {
    return this.mHandleListener.handleIsPlaying();
  }
  
  void openMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong, SuperPlayerOption paramSuperPlayerOption)
  {
    SuperPlayerMgrCommons.OpenMediaParams localOpenMediaParams = new SuperPlayerMgrCommons.OpenMediaParams();
    localOpenMediaParams.context = paramContext;
    localOpenMediaParams.videoInfo = paramSuperPlayerVideoInfo;
    localOpenMediaParams.startPositionMilsec = paramLong;
    localOpenMediaParams.playerOption = paramSuperPlayerOption;
    internalMessage(1, localOpenMediaParams);
  }
  
  void pause()
  {
    internalMessage(13, null);
  }
  
  void pauseDownload()
  {
    internalMessage(89, null);
  }
  
  void release()
  {
    internalMessage(21, null);
  }
  
  void reset()
  {
    internalMessage(15, null);
  }
  
  void resumeDownload()
  {
    internalMessage(90, null);
  }
  
  void seekTo(int paramInt)
  {
    internalMessage(23, paramInt, 0, null, false, false, 0L);
  }
  
  void seekTo(int paramInt1, int paramInt2)
  {
    internalMessage(24, paramInt1, paramInt2, null, false, false, 0L);
  }
  
  void setAudioPostFrameOptionInfo(SuperPlayerAudioInfo paramSuperPlayerAudioInfo)
  {
    internalMessage(93, paramSuperPlayerAudioInfo);
  }
  
  public void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    internalMessage(92, new int[] { paramInt1, paramInt2, paramInt3, paramInt4 });
  }
  
  void setLoopback(boolean paramBoolean)
  {
    internalMessage(29, Boolean.valueOf(paramBoolean));
  }
  
  void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    SuperPlayerMgrCommons.LoopbackParams localLoopbackParams = new SuperPlayerMgrCommons.LoopbackParams();
    localLoopbackParams.isLoopback = paramBoolean;
    localLoopbackParams.loopStartPositionMs = paramLong1;
    localLoopbackParams.loopEndPositionMs = paramLong2;
    internalMessage(85, localLoopbackParams);
  }
  
  void setOutputMute(boolean paramBoolean)
  {
    internalMessage(27, Boolean.valueOf(paramBoolean));
  }
  
  void setPlaySpeedRatio(float paramFloat)
  {
    internalMessage(9, Float.valueOf(paramFloat));
  }
  
  void setSurface(Surface paramSurface)
  {
    internalMessage(6, paramSurface);
  }
  
  void setXYaxis(int paramInt)
  {
    internalMessage(8, paramInt, 0, null, false, false, 0L);
  }
  
  void start()
  {
    internalMessage(12, null);
  }
  
  void stop()
  {
    internalMessage(14, null);
  }
  
  void switchDefinition(String paramString)
  {
    internalMessage(88, paramString);
  }
  
  void updatePlayerVideoView(ISPlayerVideoView paramISPlayerVideoView)
  {
    internalMessage(5, paramISPlayerVideoView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerMgrInternal
 * JD-Core Version:    0.7.0.1
 */