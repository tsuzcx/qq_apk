package com.tencent.superplayer.player;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;
import java.util.LinkedList;
import java.util.Queue;

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
  private static final int MSG_SET_BUSINESS_DOWNLOAD_STRATEGY = 92;
  private static final int MSG_SET_LOOPBACK = 29;
  private static final int MSG_SET_LOOPBACK_WITH_POSITION = 85;
  private static final int MSG_SET_OUTPUT_MUTE = 27;
  private static final int MSG_SET_PLAY_SPEED_RATIO = 9;
  private static final int MSG_SET_SURFACE = 6;
  private static final int MSG_START = 12;
  private static final int MSG_STOP = 14;
  private static final int MSG_SWITCH_DEFINITION = 88;
  private static final int MSG_UPDATE_PLAYER_VIDEO_VIEW = 5;
  private SuperPlayerMgrInternal.EventHandler mEventHandler;
  private SuperPlayerMgrInternal.SPlayerManagerInternalListener mHandleListener;
  private volatile boolean mIsNeedBlockMessage = true;
  private volatile boolean mIsReleased = false;
  private String mLogTag;
  private Looper mLooper;
  private Queue<Message> mPendingMessages = new LinkedList();
  
  SuperPlayerMgrInternal(String paramString, Looper paramLooper, SuperPlayerMgrInternal.SPlayerManagerInternalListener paramSPlayerManagerInternalListener)
  {
    this.mLogTag = paramString;
    this.mLooper = paramLooper;
    this.mEventHandler = new SuperPlayerMgrInternal.EventHandler(this, this.mLooper, null);
    this.mHandleListener = paramSPlayerManagerInternalListener;
  }
  
  private void internalMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    try
    {
      boolean bool = this.mIsReleased;
      if (bool) {
        return;
      }
      Message localMessage = this.mEventHandler.obtainMessage();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      if (isNeedBlockMessage(paramInt1))
      {
        this.mPendingMessages.offer(localMessage);
        return;
      }
      if (paramInt1 == 21)
      {
        this.mIsReleased = true;
        this.mPendingMessages.clear();
      }
      this.mEventHandler.sendMessage(localMessage);
      while (!this.mPendingMessages.isEmpty())
      {
        paramObject = (Message)this.mPendingMessages.poll();
        if (paramObject != null) {
          this.mEventHandler.sendMessage(paramObject);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramObject;
    }
  }
  
  private void internalMessage(int paramInt, Object paramObject)
  {
    internalMessage(paramInt, 0, 0, paramObject);
  }
  
  private boolean isNeedBlockMessage(int paramInt)
  {
    if ((this.mIsNeedBlockMessage) && ((paramInt == 1) || (paramInt == 21))) {
      this.mIsNeedBlockMessage = false;
    }
    return this.mIsNeedBlockMessage;
  }
  
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    this.mHandleListener.handleAddSubtitleSource(paramString1, paramString2, paramString3);
  }
  
  int captureImageInTime(long paramLong, int paramInt1, int paramInt2)
  {
    return this.mHandleListener.handleCaptureImageInTime(paramLong, paramInt1, paramInt2);
  }
  
  int captureImageInTime(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return this.mHandleListener.handleCaptureImageInTime(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public void deselectTrack(int paramInt, long paramLong)
  {
    this.mHandleListener.handleDeselectTrack(paramInt, paramLong);
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
  
  public long getFileSizeBytes()
  {
    return this.mHandleListener.handleGetFileSizeBytes();
  }
  
  MediaInfo getMediaInfo()
  {
    return this.mHandleListener.handleGetMediaInfo();
  }
  
  public TPProgramInfo[] getProgramInfo()
  {
    return this.mHandleListener.handleGetProgramInfo();
  }
  
  String getStreamDumpInfo()
  {
    return this.mHandleListener.handleGetStreamDumpInfo();
  }
  
  public TPTrackInfo[] getTrackInfo()
  {
    return this.mHandleListener.handleGetTrackInfo();
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
    internalMessage(23, paramInt, 0, null);
  }
  
  void seekTo(int paramInt1, int paramInt2)
  {
    internalMessage(24, paramInt1, paramInt2, null);
  }
  
  public void selectProgram(int paramInt, long paramLong)
  {
    this.mHandleListener.handleSelectProgram(paramInt, paramLong);
  }
  
  public void selectTrack(int paramInt, long paramLong)
  {
    this.mHandleListener.handleSelectTrack(paramInt, paramLong);
  }
  
  void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    internalMessage(92, new int[] { paramInt1, paramInt2, paramInt3, paramInt4 });
  }
  
  void setIsNeedBlockMessage(boolean paramBoolean)
  {
    try
    {
      this.mIsNeedBlockMessage = paramBoolean;
      if (!this.mIsNeedBlockMessage) {
        while (!this.mPendingMessages.isEmpty())
        {
          Message localMessage = (Message)this.mPendingMessages.poll();
          if (localMessage != null) {
            this.mEventHandler.sendMessage(localMessage);
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerMgrInternal
 * JD-Core Version:    0.7.0.1
 */