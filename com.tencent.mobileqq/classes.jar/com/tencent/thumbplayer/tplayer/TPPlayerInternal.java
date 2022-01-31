package com.tencent.thumbplayer.tplayer;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPCDNURLInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPProtocolInfo;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.TPReadWriteLock;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class TPPlayerInternal
  implements ITPPlayListener
{
  private static final int API_CALL_TIME_OUT_MS = 500;
  private static final boolean ENV_DEBUG = false;
  private static final int MSG_ADD_AUDIO_SOURCE = 7;
  private static final int MSG_ADD_SUBTITLE_SOURCE = 6;
  private static final int MSG_CAPTURE_VIDEO = 30;
  private static final int MSG_DESELECT_TRACK = 36;
  private static final int MSG_DOWN_LOAD_CDN_INFO_UPDATE = 73;
  private static final int MSG_DOWN_LOAD_CDN_URL_EXPERIED = 76;
  private static final int MSG_DOWN_LOAD_CDN_URL_UPDATE = 72;
  private static final int MSG_DOWN_LOAD_ERROR = 71;
  private static final int MSG_DOWN_LOAD_FINISH = 70;
  private static final int MSG_DOWN_LOAD_LONG_GET_PLAY_INFO = 82;
  private static final int MSG_DOWN_LOAD_PLAY_BACK = 77;
  private static final int MSG_DOWN_LOAD_PROGRESS_UPDARE = 83;
  private static final int MSG_DOWN_LOAD_PROTOCOL_UPDATE = 75;
  private static final int MSG_DOWN_LOAD_STATUS_UPDATE = 74;
  private static final int MSG_DOWN_LOAD_STRING_GET_PLAY_INFO = 84;
  private static final int MSG_GET_PROGRAMINFO = 33;
  private static final int MSG_GET_PROPERTY_LONG = 27;
  private static final int MSG_GET_PROPERTY_STRING = 28;
  private static final int MSG_GET_TRACKINFO = 23;
  private static final int MSG_GET_VIDEO_HEIGHT = 22;
  private static final int MSG_GET_VIDEO_WIDTH = 21;
  private static final int MSG_INDEX = 0;
  private static final int MSG_PAUSE = 12;
  private static final int MSG_PREPARE_ASYNC = 10;
  private static final int MSG_RELEASE = 15;
  private static final int MSG_RESET = 14;
  private static final int MSG_SEEK_TO = 16;
  private static final int MSG_SELECT_PROGRAM = 32;
  private static final int MSG_SELECT_TRACK = 8;
  private static final int MSG_SET_AUDIO_GAIN_RATIO = 18;
  private static final int MSG_SET_DATA_SOURCE = 5;
  private static final int MSG_SET_LOOPBACK = 35;
  private static final int MSG_SET_LOOPBACK_WITH_PARAM = 20;
  private static final int MSG_SET_OUTPUT_MUTE = 17;
  private static final int MSG_SET_PLAYER_PARAMS = 1;
  private static final int MSG_SET_SPEED_RATIO = 19;
  private static final int MSG_SET_SURFACE = 4;
  private static final int MSG_SET_VIDEO_INFO = 29;
  private static final int MSG_START = 11;
  private static final int MSG_STOP = 13;
  private static final int MSG_SWITCH_DEF = 31;
  private static final int MSG_UPDATE_VIDEO_INFO = 34;
  private static final String TAG = "TPThumbPlayer[TPPlayerInternal.java]";
  private TPPlayerInternal.EventHandler mEventHandler;
  private TPReadWriteLock mLock;
  private Object mLongPlayinfo;
  private Looper mLooper;
  private Object mPlayBackResult;
  private TPThreadSwitchCommons.TPProgramInfoResult mProgramInfoResult;
  private long mPropertyLongResult;
  private String mPropertyStringResult;
  private Object mStringPlayinfo;
  private TPPlayerInternal.ITPPlayerSwitchThreadListener mTPSwitchThreadListener;
  private TPThreadSwitchCommons.TPTrackInfoResult mTrackInfoResult;
  private TPThreadSwitchCommons.TPVideoSizeResult mVideoSizeResult;
  
  TPPlayerInternal(Context paramContext, Looper paramLooper, TPPlayerInternal.ITPPlayerSwitchThreadListener paramITPPlayerSwitchThreadListener)
  {
    this.mLooper = paramLooper;
    this.mEventHandler = new TPPlayerInternal.EventHandler(this, paramLooper);
    this.mTPSwitchThreadListener = paramITPPlayerSwitchThreadListener;
    this.mLock = new TPReadWriteLock();
    this.mVideoSizeResult = new TPThreadSwitchCommons.TPVideoSizeResult();
    this.mTrackInfoResult = new TPThreadSwitchCommons.TPTrackInfoResult();
    this.mProgramInfoResult = new TPThreadSwitchCommons.TPProgramInfoResult();
  }
  
  private void handleCommonGetMessage(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      unWriteLockAndConditionIfFromEventHandler(paramBoolean);
      return;
      this.mVideoSizeResult.width = this.mTPSwitchThreadListener.handleGetVideoWidth();
      continue;
      this.mVideoSizeResult.height = this.mTPSwitchThreadListener.handleGetVideoHeight();
      continue;
      this.mTrackInfoResult.trackInfos = this.mTPSwitchThreadListener.handleGetTrackInfo();
      continue;
      this.mPropertyLongResult = this.mTPSwitchThreadListener.handleGetPropertyLong(paramInt2);
      continue;
      this.mPropertyStringResult = this.mTPSwitchThreadListener.handleGetPropertyString(paramInt2);
      continue;
      this.mProgramInfoResult.programInfos = this.mTPSwitchThreadListener.handleGetProgramInfo();
    }
  }
  
  private void handleEventMessage(Message paramMessage, boolean paramBoolean)
  {
    if ((paramMessage.what != 83) && (paramMessage.what != 73) && (paramMessage.what != 74)) {
      TPLogUtil.i("TPThumbPlayer[TPPlayerInternal.java]", "internalMessage " + messageToCommand(paramMessage.what));
    }
    switch (paramMessage.what)
    {
    case 2: 
    case 3: 
    case 9: 
    case 24: 
    case 25: 
    case 26: 
    case 34: 
    case 37: 
    case 38: 
    case 39: 
    case 40: 
    case 41: 
    case 42: 
    case 43: 
    case 44: 
    case 45: 
    case 46: 
    case 47: 
    case 48: 
    case 49: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
    case 58: 
    case 59: 
    case 60: 
    case 61: 
    case 62: 
    case 63: 
    case 64: 
    case 65: 
    case 66: 
    case 67: 
    case 68: 
    case 69: 
    case 78: 
    case 79: 
    case 80: 
    case 81: 
    default: 
    case 1: 
    case 4: 
    case 5: 
    case 29: 
    case 30: 
    case 6: 
    case 7: 
    case 8: 
    case 36: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 35: 
    case 31: 
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              this.mTPSwitchThreadListener.handleSetPlayerOptionParams((TPOptionalParam)paramMessage.obj);
              return;
              this.mTPSwitchThreadListener.handleSetSurface((Surface)paramMessage.obj);
              return;
              this.mTPSwitchThreadListener.handleSetDataSource((TPThreadSwitchCommons.TPDataSourceParams)paramMessage.obj);
              return;
              this.mTPSwitchThreadListener.handlerSetVideoInfo((TPVideoInfo)paramMessage.obj);
              return;
              this.mTPSwitchThreadListener.handlerCaptureVideo(((TPThreadSwitchCommons.TPVideoCaptureParams)paramMessage.obj).params, ((TPThreadSwitchCommons.TPVideoCaptureParams)paramMessage.obj).callBack);
              return;
              paramMessage = (TPThreadSwitchCommons.TPSubTitleParams)paramMessage.obj;
            } while (paramMessage == null);
            this.mTPSwitchThreadListener.handleAddSubTitle(paramMessage.url, paramMessage.mimeType, paramMessage.name, paramMessage.downloadParamData);
            return;
            paramMessage = (TPThreadSwitchCommons.TPAudioTrackSourceParams)paramMessage.obj;
          } while (paramMessage == null);
          this.mTPSwitchThreadListener.handleAddAudioSource(paramMessage.url, paramMessage.name, paramMessage.dlParamData);
          return;
          this.mTPSwitchThreadListener.handleSelectTrack(paramMessage.arg1, paramMessage.arg2);
          return;
          this.mTPSwitchThreadListener.handleDeselectTrack(paramMessage.arg1, paramMessage.arg2);
          return;
          this.mTPSwitchThreadListener.handlePrepareAsync();
          return;
          this.mTPSwitchThreadListener.handleStart();
          return;
          this.mTPSwitchThreadListener.handlePause();
          return;
          this.mTPSwitchThreadListener.handleStop();
          unWriteLockAndConditionIfFromEventHandler(paramBoolean);
          return;
          this.mTPSwitchThreadListener.handleReset();
          unWriteLockAndConditionIfFromEventHandler(paramBoolean);
          return;
          this.mTPSwitchThreadListener.handleRelease();
          unWriteLockAndConditionIfFromEventHandler(paramBoolean);
          this.mEventHandler.removeCallbacksAndMessages(null);
          return;
          this.mTPSwitchThreadListener.handleSeekTo(paramMessage.arg1, paramMessage.arg2);
          return;
          this.mTPSwitchThreadListener.handleSetOutputMute(((Boolean)paramMessage.obj).booleanValue());
          return;
          this.mTPSwitchThreadListener.handleSetAudioGainRatio(((Float)paramMessage.obj).floatValue());
          return;
          this.mTPSwitchThreadListener.handleSetPlaySpeedRatio(((Float)paramMessage.obj).floatValue());
          return;
          paramMessage = (TPThreadSwitchCommons.TPLoopbackParams)paramMessage.obj;
        } while (paramMessage == null);
        this.mTPSwitchThreadListener.handleSetLoopback(paramMessage.isLoopback, paramMessage.loopStartPositionMs, paramMessage.loopEndPositionMs);
        return;
        this.mTPSwitchThreadListener.handleSetLoopback(((Boolean)paramMessage.obj).booleanValue());
        return;
        paramMessage = (TPThreadSwitchCommons.TPSwitchDefParams)paramMessage.obj;
      } while (paramMessage == null);
      if (!TextUtils.isEmpty(paramMessage.url))
      {
        this.mTPSwitchThreadListener.handleSwitchDef(paramMessage.url, paramMessage.defID, paramMessage.videoInfo, paramMessage.mode);
        return;
      }
      this.mTPSwitchThreadListener.handleSwitchDef(paramMessage.mediaAsset, paramMessage.defID, paramMessage.videoInfo, paramMessage.mode);
      return;
    case 32: 
      this.mTPSwitchThreadListener.handleSelectProgram(paramMessage.arg1, paramMessage.arg2);
      return;
    case 21: 
    case 22: 
    case 23: 
    case 27: 
    case 28: 
    case 33: 
      handleCommonGetMessage(paramMessage.what, paramMessage.arg1, paramBoolean);
      return;
    case 70: 
      this.mTPSwitchThreadListener.handleOnDownloadFinish();
      return;
    case 71: 
      this.mTPSwitchThreadListener.handleOnDownloadError(paramMessage.arg1, paramMessage.arg2, (String)paramMessage.obj);
      return;
    case 72: 
      this.mTPSwitchThreadListener.handleOnDownloadCdnUrlUpdate((String)paramMessage.obj);
      return;
    case 73: 
      paramMessage = (TPPlayerMsg.TPCDNURLInfo)paramMessage.obj;
      this.mTPSwitchThreadListener.handleOnDownloadCdnUrlInfoUpdate(paramMessage.url, paramMessage.cdnIp, paramMessage.uIp, paramMessage.errorStr);
      return;
    case 74: 
      this.mTPSwitchThreadListener.handleOnDownloadStatusUpdate(paramMessage.arg1);
      return;
    case 75: 
      paramMessage = (TPPlayerMsg.TPProtocolInfo)paramMessage.obj;
      this.mTPSwitchThreadListener.handleOnDownloadProtocolUpdate(paramMessage.protocolName, paramMessage.protocolVersion);
      return;
    case 76: 
      this.mTPSwitchThreadListener.handleOnDownloadCdnUrlExpired((Map)paramMessage.obj);
      return;
    case 77: 
      paramMessage = (TPThreadSwitchCommons.TPOnPlayCallBackParams)paramMessage.obj;
      this.mPlayBackResult = this.mTPSwitchThreadListener.handleOnPlayCallback(paramMessage.messageType, paramMessage.ext1, paramMessage.ext2, paramMessage.ext3, paramMessage.ext4);
      unWriteLockAndConditionIfFromEventHandler(paramBoolean);
      return;
    case 82: 
      this.mLongPlayinfo = this.mTPSwitchThreadListener.handleGetPlayInfo(((Long)paramMessage.obj).longValue());
      unWriteLockAndConditionIfFromEventHandler(paramBoolean);
      return;
    case 83: 
      paramMessage = (TPPlayerMsg.TPDownLoadProgressInfo)paramMessage.obj;
      this.mTPSwitchThreadListener.handleOnDownloadProgressUpdate((int)paramMessage.playableDurationMS, paramMessage.downloadSpeedKBps, paramMessage.currentDownloadSize, paramMessage.totalFileSize);
      return;
    }
    this.mStringPlayinfo = this.mTPSwitchThreadListener.handleGetPlayInfo((String)paramMessage.obj);
    unWriteLockAndConditionIfFromEventHandler(paramBoolean);
  }
  
  private void internalMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    readLockIfNeed();
    if (this.mEventHandler == null)
    {
      TPLogUtil.i("TPThumbPlayer[TPPlayerInternal.java]", messageToCommand(paramInt1) + " , send failed , handler null");
      unReadLockIfNeed();
      return;
    }
    if ((paramBoolean1) && (paramObject == null))
    {
      TPLogUtil.i("TPThumbPlayer[TPPlayerInternal.java]", messageToCommand(paramInt1) + ", send failed , params null");
      unReadLockIfNeed();
      return;
    }
    if (paramBoolean2) {
      this.mEventHandler.removeMessages(paramInt1);
    }
    Message localMessage = this.mEventHandler.obtainMessage();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    localMessage.obj = paramObject;
    if (isSameLooper()) {
      handleEventMessage(localMessage, false);
    }
    for (;;)
    {
      unReadLockIfNeed();
      return;
      this.mEventHandler.sendMessageDelayed(localMessage, paramLong);
    }
  }
  
  private void internalWLockWait(String paramString, long paramLong)
  {
    if (isSameLooper()) {
      return;
    }
    internalWLockWaitNormal(paramLong);
  }
  
  private void internalWLockWaitDebug(String paramString, long paramLong)
  {
    long l = System.currentTimeMillis();
    boolean bool = this.mLock.writeLockCondWait(paramLong);
    paramLong = System.currentTimeMillis();
    paramString = new StringBuilder().append("api ：").append(paramString).append(" , notified , coast time : ").append(paramLong - l).append(", is timeout :'");
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      TPLogUtil.i("TPThumbPlayer[TPPlayerInternal.java]", bool);
      return;
    }
  }
  
  private void internalWLockWaitNormal(long paramLong)
  {
    this.mLock.writeLockCondWait(paramLong);
  }
  
  private boolean isSameLooper()
  {
    return Looper.myLooper() == this.mLooper;
  }
  
  private String messageToCommand(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    case 3: 
    case 9: 
    case 24: 
    case 25: 
    case 26: 
    case 34: 
    case 37: 
    case 38: 
    case 39: 
    case 40: 
    case 41: 
    case 42: 
    case 43: 
    case 44: 
    case 45: 
    case 46: 
    case 47: 
    case 48: 
    case 49: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
    case 58: 
    case 59: 
    case 60: 
    case 61: 
    case 62: 
    case 63: 
    case 64: 
    case 65: 
    case 66: 
    case 67: 
    case 68: 
    case 69: 
    case 70: 
    case 71: 
    case 72: 
    default: 
      return "[tpPlayer] -> " + paramInt;
    case 1: 
      return "[tpPlayer] -> set player params";
    case 4: 
      return "[tpPlayer] -> set surface";
    case 5: 
      return "[tpPlayer] -> set data source";
    case 6: 
      return "[tpPlayer] -> set subtitle source";
    case 7: 
      return "[tpPlayer] -> add audio source";
    case 8: 
      return "[tpPlayer] -> add select track";
    case 36: 
      return "[tpPlayer] -> deselect track";
    case 10: 
      return "[tpPlayer] -> prepare async";
    case 11: 
      return "[tpPlayer] -> start";
    case 12: 
      return "[tpPlayer] -> pause";
    case 13: 
      return "[tpPlayer] -> stop";
    case 14: 
      return "[tpPlayer] -> reset";
    case 15: 
      return "[tpPlayer] -> release";
    case 16: 
      return "[tpPlayer] -> seek to";
    case 17: 
      return "[tpPlayer] -> set output mute";
    case 18: 
      return "[tpPlayer] -> set audio gain ratio";
    case 19: 
      return "[tpPlayer] -> set speed ratio";
    case 35: 
      return "[tpPlayer] -> set loopback";
    case 21: 
      return "[tpPlayer] -> get video width";
    case 22: 
      return "[tpPlayer] -> get video height";
    case 23: 
      return "[tpPlayer] -> get track info";
    case 27: 
      return "[tpPlayer] -> get property long";
    case 28: 
      return "[tpPlayer] -> get property string";
    case 29: 
      return "[tpPlayer] -> set video info";
    case 30: 
      return "[tpPlayer] -> capture video";
    case 31: 
      return "[tpPlayer] -> switch def";
    case 32: 
      return "[tpPlayer] -> select program";
    case 33: 
      return "[tpPlayer] -> get program";
    case 20: 
      return "[tpPlayer] -> set loopback with param";
    }
    return "[tpPlayer] -> cdn info update";
  }
  
  private void readLockIfNeed()
  {
    if (!isSameLooper()) {
      this.mLock.readLock().lock();
    }
  }
  
  private void unReadLockIfNeed()
  {
    if (!isSameLooper()) {
      this.mLock.readLock().unlock();
    }
  }
  
  private void unWriteLockAndConditionIfFromEventHandler(boolean paramBoolean)
  {
    writeLockIfFromEventHandler(paramBoolean);
    writeLockCondSignalAllIfFromEventHandler(paramBoolean);
    unWriteLockIfFromeEventHandler(paramBoolean);
  }
  
  private void unWriteLockIfFromeEventHandler(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mLock.unWriteLock();
    }
  }
  
  private void unWriteLockIfNeed()
  {
    if (!isSameLooper()) {
      this.mLock.unWriteLock();
    }
  }
  
  private void writeLockCondSignalAllIfFromEventHandler(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mLock.writeLockCondSignalAll();
    }
  }
  
  private void writeLockIfFromEventHandler(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mLock.write();
    }
  }
  
  private void writeLockIfNeed()
  {
    if (!isSameLooper()) {
      this.mLock.write();
    }
  }
  
  void addAudioTrackSource(String paramString1, String paramString2, TPDownloadParamData paramTPDownloadParamData)
  {
    TPThreadSwitchCommons.TPAudioTrackSourceParams localTPAudioTrackSourceParams = new TPThreadSwitchCommons.TPAudioTrackSourceParams();
    localTPAudioTrackSourceParams.url = paramString1;
    localTPAudioTrackSourceParams.name = paramString2;
    localTPAudioTrackSourceParams.dlParamData = paramTPDownloadParamData;
    internalMessage(7, 0, 0, localTPAudioTrackSourceParams, true, false, 0L);
  }
  
  void addSubtitleSource(String paramString1, String paramString2, String paramString3, TPDownloadParamData paramTPDownloadParamData)
  {
    TPThreadSwitchCommons.TPSubTitleParams localTPSubTitleParams = new TPThreadSwitchCommons.TPSubTitleParams();
    localTPSubTitleParams.url = paramString1;
    localTPSubTitleParams.mimeType = paramString2;
    localTPSubTitleParams.name = paramString3;
    localTPSubTitleParams.downloadParamData = paramTPDownloadParamData;
    internalMessage(6, 0, 0, localTPSubTitleParams, true, false, 0L);
  }
  
  void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    TPLogUtil.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : captureVideo");
    TPThreadSwitchCommons.TPVideoCaptureParams localTPVideoCaptureParams = new TPThreadSwitchCommons.TPVideoCaptureParams();
    localTPVideoCaptureParams.callBack = paramTPCaptureCallBack;
    localTPVideoCaptureParams.params = paramTPCaptureParams;
    internalMessage(30, 0, 0, localTPVideoCaptureParams, true, false, 0L);
  }
  
  void deselectTrack(int paramInt, long paramLong)
  {
    internalMessage(36, paramInt, (int)paramLong, null, false, false, 0L);
  }
  
  public long getAdvRemainTime()
  {
    try
    {
      long l = this.mTPSwitchThreadListener.handleGetAdvRemainTime();
      return l;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
    }
    return 0L;
  }
  
  int getBufferPercent()
  {
    try
    {
      int i = this.mTPSwitchThreadListener.handleGetBufferPercent();
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
    }
    return 0;
  }
  
  public int getCurrentPlayClipNo()
  {
    try
    {
      int i = this.mTPSwitchThreadListener.handleGetCurrentPlayClipNo();
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
    }
    return 0;
  }
  
  public long getCurrentPosition()
  {
    return getCurrentPositionMs();
  }
  
  long getCurrentPositionMs()
  {
    try
    {
      long l = this.mTPSwitchThreadListener.handleGetCurrentPositionMs();
      return l;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
    }
    return 0L;
  }
  
  long getDurationMs()
  {
    try
    {
      long l = this.mTPSwitchThreadListener.handleGetDurationMs();
      return l;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
    }
    return 0L;
  }
  
  public Object getPlayInfo(long paramLong)
  {
    writeLockIfNeed();
    internalMessage(82, 0, 0, Long.valueOf(paramLong), false, false, 0L);
    internalWLockWait("getPlayInfo long", 500L);
    unWriteLockIfNeed();
    return this.mLongPlayinfo;
  }
  
  public Object getPlayInfo(String paramString)
  {
    writeLockIfNeed();
    internalMessage(84, 0, 0, paramString, false, false, 0L);
    internalWLockWait("getPlayInfo key", 500L);
    unWriteLockIfNeed();
    return this.mStringPlayinfo;
  }
  
  public long getPlayerBufferLength()
  {
    try
    {
      long l = this.mTPSwitchThreadListener.handleGetPlayerBufferLength();
      return l;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayerInternal.java]", localThrowable);
    }
    return 0L;
  }
  
  TPProgramInfo[] getProgramInfo()
  {
    writeLockIfNeed();
    this.mProgramInfoResult.reset();
    TPLogUtil.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get program info");
    internalMessage(33, 0, 0, null, false, false, 0L);
    internalWLockWait("get programInfo", 500L);
    unWriteLockIfNeed();
    return this.mProgramInfoResult.programInfos;
  }
  
  long getPropertyLong(int paramInt)
  {
    writeLockIfNeed();
    this.mPropertyLongResult = 0L;
    TPLogUtil.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get property long");
    internalMessage(27, paramInt, 0, null, false, false, 0L);
    internalWLockWait("get property long", 500L);
    unWriteLockIfNeed();
    return this.mPropertyLongResult;
  }
  
  String getPropertyString(int paramInt)
  {
    writeLockIfNeed();
    this.mPropertyStringResult = null;
    TPLogUtil.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get property string");
    internalMessage(28, paramInt, 0, null, false, false, 0L);
    internalWLockWait("get property string", 500L);
    unWriteLockIfNeed();
    return this.mPropertyStringResult;
  }
  
  TPTrackInfo[] getTrackInfo()
  {
    writeLockIfNeed();
    this.mTrackInfoResult.reset();
    TPLogUtil.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get trackInfo");
    internalMessage(23, 0, 0, null, false, false, 0L);
    internalWLockWait("get trackInfo", 500L);
    unWriteLockIfNeed();
    return this.mTrackInfoResult.trackInfos;
  }
  
  int getVideoHeight()
  {
    writeLockIfNeed();
    internalMessage(22, 0, 0, null, false, false, 0L);
    internalWLockWait("get video height", 500L);
    unWriteLockIfNeed();
    return this.mVideoSizeResult.height;
  }
  
  int getVideoWidth()
  {
    writeLockIfNeed();
    internalMessage(21, 0, 0, null, false, false, 0L);
    internalWLockWait("get video width", 500L);
    unWriteLockIfNeed();
    return this.mVideoSizeResult.width;
  }
  
  public void onDownloadCdnUrlExpired(Map<String, String> paramMap)
  {
    internalMessage(76, 0, 0, paramMap, false, false, 0L);
  }
  
  public void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    TPPlayerMsg.TPCDNURLInfo localTPCDNURLInfo = new TPPlayerMsg.TPCDNURLInfo();
    localTPCDNURLInfo.url = paramString1;
    localTPCDNURLInfo.cdnIp = paramString2;
    localTPCDNURLInfo.uIp = paramString3;
    localTPCDNURLInfo.errorStr = paramString4;
    internalMessage(73, 0, 0, localTPCDNURLInfo, false, false, 0L);
  }
  
  public void onDownloadCdnUrlUpdate(String paramString)
  {
    internalMessage(72, 0, 0, paramString, false, false, 0L);
  }
  
  public void onDownloadError(int paramInt1, int paramInt2, String paramString)
  {
    internalMessage(71, paramInt1, paramInt2, paramString, false, false, 0L);
  }
  
  public void onDownloadFinish()
  {
    internalMessage(70, 0, 0, null, false, false, 0L);
  }
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    paramString = new TPPlayerMsg.TPDownLoadProgressInfo();
    paramString.playableDurationMS = paramInt1;
    paramString.downloadSpeedKBps = paramInt2;
    paramString.currentDownloadSize = paramLong1;
    paramString.totalFileSize = paramLong2;
    internalMessage(83, 0, 0, paramString, false, false, 0L);
  }
  
  public void onDownloadProtocolUpdate(String paramString1, String paramString2)
  {
    TPPlayerMsg.TPProtocolInfo localTPProtocolInfo = new TPPlayerMsg.TPProtocolInfo();
    localTPProtocolInfo.protocolVersion = paramString2;
    localTPProtocolInfo.protocolName = paramString1;
    internalMessage(75, 0, 0, localTPProtocolInfo, false, false, 0L);
  }
  
  public void onDownloadStatusUpdate(int paramInt)
  {
    internalMessage(74, paramInt, 0, null, false, false, 0L);
  }
  
  public Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    writeLockIfNeed();
    TPThreadSwitchCommons.TPOnPlayCallBackParams localTPOnPlayCallBackParams = new TPThreadSwitchCommons.TPOnPlayCallBackParams();
    localTPOnPlayCallBackParams.messageType = paramInt;
    localTPOnPlayCallBackParams.ext1 = paramObject1;
    localTPOnPlayCallBackParams.ext2 = paramObject2;
    localTPOnPlayCallBackParams.ext3 = paramObject3;
    localTPOnPlayCallBackParams.ext4 = paramObject4;
    internalMessage(77, 0, 0, localTPOnPlayCallBackParams, false, false, 0L);
    internalWLockWait("onPlayCallback", 500L);
    unWriteLockIfNeed();
    return this.mPlayBackResult;
  }
  
  void pause()
  {
    internalMessage(12, 0, 0, null, false, false, 0L);
  }
  
  void prepareAsync()
  {
    internalMessage(10, 0, 0, null, false, false, 0L);
  }
  
  void release()
  {
    writeLockIfNeed();
    TPLogUtil.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : release");
    internalMessage(15, 0, 0, null, false, false, 0L);
    internalWLockWait("release", 500L);
    unWriteLockIfNeed();
  }
  
  void reset()
  {
    writeLockIfNeed();
    TPLogUtil.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : reset");
    internalMessage(14, 0, 0, null, false, false, 0L);
    internalWLockWait("reset", 500L);
    unWriteLockIfNeed();
  }
  
  void seekTo(int paramInt)
  {
    internalMessage(16, paramInt, 0, null, false, false, 0L);
  }
  
  void seekTo(int paramInt1, int paramInt2)
  {
    internalMessage(16, paramInt1, paramInt2, null, false, false, 0L);
  }
  
  void selectProgram(int paramInt, long paramLong)
  {
    internalMessage(32, paramInt, (int)paramLong, null, false, false, 0L);
  }
  
  void selectTrack(int paramInt, long paramLong)
  {
    internalMessage(8, paramInt, (int)paramLong, null, false, false, 0L);
  }
  
  void setAudioGainRatio(float paramFloat)
  {
    internalMessage(18, 0, 0, Float.valueOf(paramFloat), false, true, 0L);
  }
  
  void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    TPThreadSwitchCommons.TPDataSourceParams localTPDataSourceParams = new TPThreadSwitchCommons.TPDataSourceParams();
    localTPDataSourceParams.pfd = paramParcelFileDescriptor;
    internalMessage(5, 0, 0, localTPDataSourceParams, true, false, 0L);
  }
  
  void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    TPThreadSwitchCommons.TPDataSourceParams localTPDataSourceParams = new TPThreadSwitchCommons.TPDataSourceParams();
    localTPDataSourceParams.mediaAsset = paramITPMediaAsset;
    internalMessage(5, 0, 0, localTPDataSourceParams, true, false, 0L);
  }
  
  void setDataSource(String paramString)
  {
    TPThreadSwitchCommons.TPDataSourceParams localTPDataSourceParams = new TPThreadSwitchCommons.TPDataSourceParams();
    localTPDataSourceParams.url = paramString;
    internalMessage(5, 0, 0, localTPDataSourceParams, true, false, 0L);
  }
  
  void setDataSource(String paramString, Map<String, String> paramMap)
  {
    TPThreadSwitchCommons.TPDataSourceParams localTPDataSourceParams = new TPThreadSwitchCommons.TPDataSourceParams();
    localTPDataSourceParams.url = paramString;
    localTPDataSourceParams.httpHeader = paramMap;
    internalMessage(5, 0, 0, localTPDataSourceParams, true, false, 0L);
  }
  
  void setLoopback(boolean paramBoolean)
  {
    internalMessage(35, 0, 0, Boolean.valueOf(paramBoolean), true, true, 0L);
  }
  
  void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    TPThreadSwitchCommons.TPLoopbackParams localTPLoopbackParams = new TPThreadSwitchCommons.TPLoopbackParams();
    localTPLoopbackParams.isLoopback = paramBoolean;
    localTPLoopbackParams.loopStartPositionMs = paramLong1;
    localTPLoopbackParams.loopEndPositionMs = paramLong2;
    internalMessage(20, 0, 0, localTPLoopbackParams, true, true, 0L);
  }
  
  void setOutputMute(boolean paramBoolean)
  {
    internalMessage(17, 0, 0, Boolean.valueOf(paramBoolean), false, true, 0L);
  }
  
  void setPlaySpeedRatio(float paramFloat)
  {
    internalMessage(19, 0, 0, Float.valueOf(paramFloat), false, true, 0L);
  }
  
  void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    internalMessage(1, 0, 0, paramTPOptionalParam, true, false, 0L);
  }
  
  void setSurface(Surface paramSurface)
  {
    internalMessage(4, 0, 0, paramSurface, false, false, 0L);
  }
  
  public void setVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    internalMessage(29, 0, 0, paramTPVideoInfo, true, false, 0L);
  }
  
  void start()
  {
    internalMessage(11, 0, 0, null, false, false, 0L);
  }
  
  void stop()
  {
    writeLockIfNeed();
    TPLogUtil.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : stop");
    internalMessage(13, 0, 0, null, false, false, 0L);
    internalWLockWait("stop", 500L);
    unWriteLockIfNeed();
  }
  
  void switchDefinition(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    TPThreadSwitchCommons.TPSwitchDefParams localTPSwitchDefParams = new TPThreadSwitchCommons.TPSwitchDefParams();
    localTPSwitchDefParams.mediaAsset = paramITPMediaAsset;
    localTPSwitchDefParams.defID = paramLong;
    localTPSwitchDefParams.videoInfo = paramTPVideoInfo;
    localTPSwitchDefParams.mode = paramInt;
    internalMessage(31, 0, 0, localTPSwitchDefParams, true, true, 0L);
  }
  
  void switchDefinition(String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    TPThreadSwitchCommons.TPSwitchDefParams localTPSwitchDefParams = new TPThreadSwitchCommons.TPSwitchDefParams();
    localTPSwitchDefParams.url = paramString;
    localTPSwitchDefParams.defID = paramLong;
    localTPSwitchDefParams.videoInfo = paramTPVideoInfo;
    localTPSwitchDefParams.mode = paramInt;
    internalMessage(31, 0, 0, localTPSwitchDefParams, true, true, 0L);
  }
  
  void updateVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    internalMessage(34, 0, 0, paramTPVideoInfo, false, true, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.TPPlayerInternal
 * JD-Core Version:    0.7.0.1
 */