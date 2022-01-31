package com.tencent.superplayer.player;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnAudioPcmDataListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnDefinitionInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnTVideoNetInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoOutputFrameListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.view.ISPlayerVideoView;

class SuperPlayerMgrInternal
  implements ISuperPlayer
{
  private static final int MSG_CAPTURE_IMAGE_IN_TIME = 33;
  private static final int MSG_GET_CUR_NET_VIDEO_INFO = 46;
  private static final int MSG_GET_DOWNLOAD_SPEED = 38;
  private static final int MSG_GET_DURATION = 37;
  private static final int MSG_GET_HLS_TAG_INFO = 40;
  private static final int MSG_GET_MEDIAINFO = 86;
  private static final int MSG_GET_OUTPUT_MUTE = 28;
  private static final int MSG_GET_PLAYED_TIME = 45;
  private static final int MSG_GET_STREAM_DUMP_INFO = 54;
  private static final int MSG_GET_VIDEO_HEIGHT = 43;
  private static final int MSG_GET_VIDEO_ROTATION = 44;
  private static final int MSG_GET_VIDEO_WIDTH = 42;
  private static final int MSG_GET_VR_CONTROLL = 84;
  private static final int MSG_INDEX = 0;
  private static final int MSG_IS_LOOP_BACK = 30;
  private static final int MSG_IS_PAUSING = 50;
  private static final int MSG_IS_PLAYING = 49;
  private static final int MSG_ON_CLICK_PAUSE = 10;
  private static final int MSG_ON_REAL_TIME_INFO_CHANGE = 82;
  private static final int MSG_OPEN_MEDIA_PLAYER = 1;
  private static final int MSG_PAUSE = 13;
  private static final int MSG_PAUSE_DOWNLOAD = 89;
  private static final int MSG_RELEASE = 21;
  private static final int MSG_RESET = 15;
  private static final int MSG_RESUME_DOWNLOAD = 90;
  private static final int MSG_SAVE_REPORT = 57;
  private static final int MSG_SEEK_TO = 23;
  private static final int MSG_SEEK_TO_BY_MODE = 24;
  private static final int MSG_SET_AUDIO_GAIN_RATIO = 31;
  private static final int MSG_SET_LOOPBACK = 29;
  private static final int MSG_SET_LOOPBACK_WITH_POSITION = 85;
  private static final int MSG_SET_NEXT_PLAYER_VIDEO_INFO = 83;
  private static final int MSG_SET_ON_AUDIO_PCM_DATA_LISTENER = 80;
  private static final int MSG_SET_ON_CAPTURE_IMAGE_LISTENER = 71;
  private static final int MSG_SET_ON_COMPLETION_LISTENER = 67;
  private static final int MSG_SET_ON_DEFINITION_INFO_LISTENER = 87;
  private static final int MSG_SET_ON_ERROR_LISTENER = 72;
  private static final int MSG_SET_ON_GET_USER_INFO_LISTENER = 74;
  private static final int MSG_SET_ON_INFO_LISTENER = 73;
  private static final int MSG_SET_ON_NET_VIDEO_INFO_LISTENER = 66;
  private static final int MSG_SET_ON_SEEK_COMPLETE_LISTENER = 70;
  private static final int MSG_SET_ON_TVIDEO_NETINFO_UPDATE = 91;
  private static final int MSG_SET_ON_VIDEO_OUTPUT_FRAME_LISTENER = 79;
  private static final int MSG_SET_ON_VIDEO_PREPARED_LISTENER = 65;
  private static final int MSG_SET_ON_VIDEO_SIZE_CHANGED_LISTENER = 76;
  private static final int MSG_SET_OUTPUT_MUTE = 27;
  private static final int MSG_SET_PLAY_SPEED_RATIO = 9;
  private static final int MSG_SET_SURFACE = 6;
  private static final int MSG_SET_VIDEO_SCALE_PARAM = 7;
  private static final int MSG_SET_X_Y_AXIS = 8;
  private static final int MSG_START = 12;
  private static final int MSG_STOP = 14;
  private static final int MSG_SWITCH_DEFINITION = 88;
  private static final int MSG_UPDATE_PLAYER_VIDEO_VIEW = 5;
  private long mAdCurrentPosition;
  private int mBufferPercent;
  private int mCaptureImageInTimeResult;
  private int mDownloadSpeed;
  private SuperPlayerMgrInternal.EventHandler mEventHandler;
  private SuperPlayerMgrInternal.SPlayerManagerInternalListener mHandleListener;
  private String mHlsTagInfo;
  private boolean mIsLoopBack;
  private boolean mIsOutPutMute;
  private boolean mIsVideoPausing;
  private boolean mIsVideoPlaying;
  private String mLogTag;
  private Looper mLooper;
  private MediaInfo mMediaInfo;
  private boolean mSetOutPutMuteResult;
  private String mStreamDumpInfo;
  private long mVideoCurrentPosition;
  private long mVideoDuration;
  private int mVideoHeight;
  private long mVideoPlayedTime;
  private int mVideoRotation;
  private int mVideoWidth;
  
  public SuperPlayerMgrInternal(String paramString, Looper paramLooper, SuperPlayerMgrInternal.SPlayerManagerInternalListener paramSPlayerManagerInternalListener)
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
  
  public int captureImageInTime(long paramLong, int paramInt1, int paramInt2)
  {
    LogUtil.i(this.mLogTag, "captureImageInTime, positionMs:" + paramLong + ", width:" + paramInt1 + ", height:" + paramInt2);
    return this.mHandleListener.handleCaptureImageInTime(paramLong, paramInt1, paramInt2);
  }
  
  public int captureImageInTime(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    LogUtil.i(this.mLogTag, "captureImageInTime, positionMs:" + paramLong + ", width:" + paramInt1 + ", height:" + paramInt2 + ", requestedTimeMsToleranceBefore:" + paramInt3 + ", requestedTimeMsToleranceAfter:" + paramInt4 + " ,requestedTimeLimit:" + paramInt5);
    return this.mHandleListener.handleCaptureImageInTime(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public int getBufferPercent()
  {
    return this.mHandleListener.handleGetBufferPercent();
  }
  
  public long getCurrentPositionMs()
  {
    return this.mHandleListener.handleGetCurrentPosition();
  }
  
  public long getDurationMs()
  {
    return this.mHandleListener.handleGetDuration();
  }
  
  public MediaInfo getMediaInfo()
  {
    return this.mHandleListener.handleGetMediaInfo();
  }
  
  public long getPlayedTime()
  {
    return this.mHandleListener.handleGetPlayedTime();
  }
  
  public String getStreamDumpInfo()
  {
    LogUtil.i(this.mLogTag, "getStreamDumpInfo");
    return this.mHandleListener.handleGetStreamDumpInfo();
  }
  
  public int getVideoHeight()
  {
    return this.mHandleListener.handleGetVideoHeight();
  }
  
  public int getVideoRotation()
  {
    return this.mHandleListener.handleGetVideoRotation();
  }
  
  public int getVideoWidth()
  {
    return this.mHandleListener.handleGetVideoWidth();
  }
  
  public boolean isLoopBack()
  {
    return this.mHandleListener.handleIsLoopback();
  }
  
  public boolean isOutputMute()
  {
    return this.mHandleListener.handleGetOutputMute();
  }
  
  public boolean isPausing()
  {
    return this.mHandleListener.handleIsPausing();
  }
  
  public boolean isPlaying()
  {
    return this.mHandleListener.handleIsPlaying();
  }
  
  public void openMediaPlayer(Context paramContext, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong)
  {
    SuperPlayerMgrCommons.OpenMediaParams localOpenMediaParams = new SuperPlayerMgrCommons.OpenMediaParams();
    localOpenMediaParams.context = paramContext;
    localOpenMediaParams.videoInfo = paramSuperPlayerVideoInfo;
    localOpenMediaParams.startPositionMilsec = paramLong;
    internalMessage(1, localOpenMediaParams);
  }
  
  public void pause()
  {
    LogUtil.i(this.mLogTag, "pause");
    internalMessage(13, null);
  }
  
  public void pauseDownload()
  {
    internalMessage(89, null);
  }
  
  public void release()
  {
    LogUtil.i(this.mLogTag, "release");
    internalMessage(21, null);
  }
  
  public void reset()
  {
    LogUtil.i(this.mLogTag, "reset");
    internalMessage(15, null);
  }
  
  public void resumeDownload()
  {
    internalMessage(90, null);
  }
  
  public void seekTo(int paramInt)
  {
    LogUtil.i(this.mLogTag, "seekTo:" + paramInt);
    internalMessage(23, paramInt, 0, null, false, false, 0L);
  }
  
  public void seekTo(int paramInt1, int paramInt2)
  {
    LogUtil.i(this.mLogTag, "seekTo:" + paramInt1 + ", mode:" + paramInt2);
    internalMessage(24, paramInt1, paramInt2, null, false, false, 0L);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    LogUtil.i(this.mLogTag, "setLoopback:" + paramBoolean);
    internalMessage(29, Boolean.valueOf(paramBoolean));
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    LogUtil.i(this.mLogTag, "setLoopback:" + paramBoolean + ", loopStartPositionMs:" + paramLong1 + ", loopEndPositionMs:" + paramLong2);
    SuperPlayerMgrCommons.LoopbackParams localLoopbackParams = new SuperPlayerMgrCommons.LoopbackParams();
    localLoopbackParams.isLoopback = paramBoolean;
    localLoopbackParams.loopStartPositionMs = paramLong1;
    localLoopbackParams.loopEndPositionMs = paramLong2;
    internalMessage(85, localLoopbackParams);
  }
  
  public void setOnAudioPcmDataListener(ISuperPlayer.OnAudioPcmDataListener paramOnAudioPcmDataListener)
  {
    internalMessage(80, paramOnAudioPcmDataListener);
  }
  
  public void setOnCaptureImageListener(ISuperPlayer.OnCaptureImageListener paramOnCaptureImageListener)
  {
    internalMessage(71, paramOnCaptureImageListener);
  }
  
  public void setOnCompletionListener(ISuperPlayer.OnCompletionListener paramOnCompletionListener)
  {
    internalMessage(67, paramOnCompletionListener);
  }
  
  public void setOnDefinitionInfoListener(ISuperPlayer.OnDefinitionInfoListener paramOnDefinitionInfoListener)
  {
    internalMessage(87, paramOnDefinitionInfoListener);
  }
  
  public void setOnErrorListener(ISuperPlayer.OnErrorListener paramOnErrorListener)
  {
    internalMessage(72, paramOnErrorListener);
  }
  
  public void setOnInfoListener(ISuperPlayer.OnInfoListener paramOnInfoListener)
  {
    internalMessage(73, paramOnInfoListener);
  }
  
  public void setOnSeekCompleteListener(ISuperPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    internalMessage(70, paramOnSeekCompleteListener);
  }
  
  public void setOnTVideoNetInfoUpdateListener(ISuperPlayer.OnTVideoNetInfoListener paramOnTVideoNetInfoListener)
  {
    internalMessage(91, paramOnTVideoNetInfoListener);
  }
  
  public void setOnVideoOutputFrameListener(ISuperPlayer.OnVideoOutputFrameListener paramOnVideoOutputFrameListener)
  {
    internalMessage(79, paramOnVideoOutputFrameListener);
  }
  
  public void setOnVideoPreparedListener(ISuperPlayer.OnVideoPreparedListener paramOnVideoPreparedListener)
  {
    internalMessage(65, paramOnVideoPreparedListener);
  }
  
  public void setOnVideoSizeChangedListener(ISuperPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    internalMessage(76, paramOnVideoSizeChangedListener);
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    LogUtil.i(this.mLogTag, "setOutputMute:" + paramBoolean);
    internalMessage(27, Boolean.valueOf(paramBoolean));
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    LogUtil.i(this.mLogTag, "handleSetPlaySpeedRatio, speedRatio:" + paramFloat);
    internalMessage(9, Float.valueOf(paramFloat));
  }
  
  public void setSurface(Surface paramSurface)
  {
    LogUtil.i(this.mLogTag, "setSurface");
    internalMessage(6, paramSurface);
  }
  
  public void setXYaxis(int paramInt)
  {
    LogUtil.i(this.mLogTag, "setXYaxis, type:" + paramInt);
    internalMessage(8, paramInt, 0, null, false, false, 0L);
  }
  
  public void start()
  {
    LogUtil.i(this.mLogTag, "start");
    internalMessage(12, null);
  }
  
  public void stop()
  {
    LogUtil.i(this.mLogTag, "stop");
    internalMessage(14, null);
  }
  
  public void switchDefinition(String paramString)
  {
    internalMessage(88, paramString);
  }
  
  public void updatePlayerVideoView(ISPlayerVideoView paramISPlayerVideoView)
  {
    LogUtil.i(this.mLogTag, "updatePlayerVideoView");
    internalMessage(5, paramISPlayerVideoView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerMgrInternal
 * JD-Core Version:    0.7.0.1
 */