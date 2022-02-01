package com.tencent.thumbplayer.adapter.player.thumbplayer;

import android.content.Context;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.thumbplayer.adapter.TPPlayerBaseListeners;
import com.tencent.thumbplayer.adapter.player.ITPCapture;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBase;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioPcmOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioProcessOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnCompletionListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnInfoListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnPreparedListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoProcessOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamBoolean;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamFloat;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamLong;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamQueueInt;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamQueueString;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamString;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPAudioTrackInfo;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.caputure.TPThumbCapture;
import com.tencent.thumbplayer.composition.TPMediaComposition;
import com.tencent.thumbplayer.composition.TPMediaCompositionTrack;
import com.tencent.thumbplayer.composition.TPMediaCompositionTrackClip;
import com.tencent.thumbplayer.composition.TPMediaDRMAsset;
import com.tencent.thumbplayer.core.common.TPMediaTrackInfo;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.core.player.ITPNativePlayerAudioFrameCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.MediaCodecInfo;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.VideoCropInfo;
import com.tencent.thumbplayer.core.player.ITPNativePlayerPostProcessFrameCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerSubtitleFrameCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerVideoFrameCallback;
import com.tencent.thumbplayer.core.player.TPNativePlayer;
import com.tencent.thumbplayer.core.player.TPNativePlayerInitConfig;
import com.tencent.thumbplayer.core.player.TPNativePlayerProgramInfo;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TPThumbPlayer
  implements ITPPlayerBase
{
  private static final int EVENT_MSG_ASYNC_CALL = 1;
  private static final int EVENT_MSG_ON_ERROR = 4;
  private static final int EVENT_MSG_ON_INFO_LONG = 2;
  private static final int EVENT_MSG_ON_INFO_OBJECT = 3;
  private static String STAG = "TPThumbPlayer[TPThumbPlayer.java]";
  private static AtomicInteger mPlayerIndex = new AtomicInteger();
  private String TAG = STAG;
  private TPThumbPlayer.EventHandler mEventHandler;
  private ITPCapture mImageGenerator;
  private ITPNativePlayerAudioFrameCallback mNativeAudioFrameCallback = new TPThumbPlayer.2(this);
  private TPNativePlayerInitConfig mNativeInitConfig;
  private ITPNativePlayerMessageCallback mNativeMessageCallback = new TPThumbPlayer.1(this);
  private ITPNativePlayerPostProcessFrameCallback mNativePostProcessFrameCallback = new TPThumbPlayer.5(this);
  private ITPNativePlayerSubtitleFrameCallback mNativeSubtitleFrameCallback = new TPThumbPlayer.4(this);
  private ITPNativePlayerVideoFrameCallback mNativeVideoFrameCallback = new TPThumbPlayer.3(this);
  private TPNativePlayer mPlayer;
  private TPPlayerBaseListeners mPlayerListenerReps;
  private TPSubtitleData mSubtitleData = new TPSubtitleData();
  
  public TPThumbPlayer(Context paramContext)
  {
    this.mPlayer = new TPNativePlayer(paramContext);
    this.mPlayer.setMessageCallback(this.mNativeMessageCallback);
    this.mPlayer.setAudioFrameCallback(this.mNativeAudioFrameCallback);
    this.mPlayer.setVideoFrameCallback(this.mNativeVideoFrameCallback);
    this.mPlayer.setSubtitleFrameCallback(this.mNativeSubtitleFrameCallback);
    this.mPlayer.setPostProcessFrameCallback(this.mNativePostProcessFrameCallback);
    this.mNativeInitConfig = new TPNativePlayerInitConfig();
    this.mPlayerListenerReps = new TPPlayerBaseListeners(this.TAG);
    paramContext = Looper.myLooper();
    if (paramContext != null)
    {
      this.mEventHandler = new TPThumbPlayer.EventHandler(this, paramContext, this);
      return;
    }
    paramContext = Looper.getMainLooper();
    if (paramContext != null)
    {
      this.mEventHandler = new TPThumbPlayer.EventHandler(this, paramContext, this);
      return;
    }
    this.mEventHandler = null;
  }
  
  private void handleCommonASyncCallResult(TPThumbPlayer.OnASyncCallResultInfo paramOnASyncCallResultInfo)
  {
    this.mPlayerListenerReps.onInfo(TPThumbPlayerUtils.convert2ThumbPlayerInfo(paramOnASyncCallResultInfo.callType), paramOnASyncCallResultInfo.errorType, paramOnASyncCallResultInfo.errorCode, Long.valueOf(paramOnASyncCallResultInfo.opaque));
  }
  
  private void handleOnComplete()
  {
    this.mPlayerListenerReps.onCompletion();
  }
  
  private void handleOnInfoLongNoConvertToListner(int paramInt, TPThumbPlayer.OnInfoLongInfo paramOnInfoLongInfo)
  {
    int i = TPThumbPlayerUtils.convert2ThumbPlayerInfo(paramInt);
    if (i < 0)
    {
      TPLogUtil.w(this.TAG, "msgType:" + paramInt + ", connot convert to thumbPlayer Info");
      return;
    }
    long l1 = paramOnInfoLongInfo.lParam1;
    long l2 = paramOnInfoLongInfo.lParam2;
    switch (i)
    {
    }
    for (;;)
    {
      this.mPlayerListenerReps.onInfo(i, l1, l2, null);
      return;
      l1 = TPThumbPlayerUtils.convert2TPDecoderType((int)paramOnInfoLongInfo.lParam1);
    }
  }
  
  private void handleOnInfoObjectNoConvertToListner(int paramInt, TPThumbPlayer.OnInfoObjectInfo paramOnInfoObjectInfo)
  {
    int i = TPThumbPlayerUtils.convert2ThumbPlayerInfo(paramInt);
    if (i < 0)
    {
      TPLogUtil.w(this.TAG, "msgType:" + paramInt + ", connot convert to thumbPlayer Info");
      return;
    }
    Object localObject2 = paramOnInfoObjectInfo.objParam;
    Object localObject1 = localObject2;
    switch (i)
    {
    default: 
      localObject1 = localObject2;
    }
    for (;;)
    {
      this.mPlayerListenerReps.onInfo(i, 0L, 0L, localObject1);
      return;
      localObject1 = localObject2;
      if (paramOnInfoObjectInfo.objParam != null)
      {
        localObject1 = TPThumbPlayerUtils.convert2TPVideoCropInfo((ITPNativePlayerMessageCallback.VideoCropInfo)paramOnInfoObjectInfo.objParam);
        continue;
        localObject1 = localObject2;
        if (paramOnInfoObjectInfo.objParam != null) {
          localObject1 = TPThumbPlayerUtils.convert2TPMediaCodecInfo((ITPNativePlayerMessageCallback.MediaCodecInfo)paramOnInfoObjectInfo.objParam);
        }
      }
    }
  }
  
  private void handleOnPrepared()
  {
    this.mPlayerListenerReps.onPrepared();
  }
  
  private void handleOnSeekComplete()
  {
    this.mPlayerListenerReps.onSeekComplete();
  }
  
  private void handleOnVideoSizeChanged(long paramLong1, long paramLong2)
  {
    this.mPlayerListenerReps.onVideoSizeChanged(paramLong1, paramLong2);
  }
  
  private TPProgramInfo programInfoConvert(TPNativePlayerProgramInfo paramTPNativePlayerProgramInfo)
  {
    if (paramTPNativePlayerProgramInfo != null)
    {
      TPProgramInfo localTPProgramInfo = new TPProgramInfo();
      localTPProgramInfo.name = paramTPNativePlayerProgramInfo.name;
      localTPProgramInfo.bandwidth = paramTPNativePlayerProgramInfo.bandwidth;
      localTPProgramInfo.resolution = paramTPNativePlayerProgramInfo.resolution;
      return localTPProgramInfo;
    }
    return null;
  }
  
  private void setPlayerInitConfigWithParamBoolean(int paramInt, TPOptionalParam.OptionalParamBoolean paramOptionalParamBoolean)
  {
    TPThumbPlayerUtils.OptionIdMapping localOptionIdMapping = TPThumbPlayerUtils.convert2NativeOptionaID(paramInt);
    if (localOptionIdMapping == null)
    {
      TPLogUtil.e(this.TAG, "player optionaIdMapping is invalid, not found in array, id: " + paramInt);
      return;
    }
    switch (localOptionIdMapping.getmOptionalIDType())
    {
    default: 
      TPLogUtil.e(this.TAG, "optionID type:" + localOptionIdMapping.getmOptionalIDType() + " is not implement");
      return;
    }
    this.mNativeInitConfig.setBool(localOptionIdMapping.getNativePlayerOptionalID(), paramOptionalParamBoolean.value);
  }
  
  private void setPlayerInitConfigWithParamFloat(int paramInt, TPOptionalParam.OptionalParamFloat paramOptionalParamFloat)
  {
    TPThumbPlayerUtils.OptionIdMapping localOptionIdMapping = TPThumbPlayerUtils.convert2NativeOptionaID(paramInt);
    if (localOptionIdMapping == null)
    {
      TPLogUtil.e(this.TAG, "player optionaIdMapping is invalid, not found in array, id: " + paramInt);
      return;
    }
    if (7 != localOptionIdMapping.getmOptionalIDType())
    {
      TPLogUtil.e(this.TAG, "optionID:" + localOptionIdMapping.getNativePlayerOptionalID() + " is not float");
      return;
    }
    this.mNativeInitConfig.setFloat(localOptionIdMapping.getNativePlayerOptionalID(), paramOptionalParamFloat.value);
  }
  
  private void setPlayerInitConfigWithParamLong(int paramInt, TPOptionalParam.OptionalParamLong paramOptionalParamLong)
  {
    TPThumbPlayerUtils.OptionIdMapping localOptionIdMapping = TPThumbPlayerUtils.convert2NativeOptionaID(paramInt);
    if (localOptionIdMapping == null)
    {
      TPLogUtil.e(this.TAG, "player optionaIdMapping is invalid, not found in array, id: " + paramInt);
      return;
    }
    switch (localOptionIdMapping.getmOptionalIDType())
    {
    case 2: 
    default: 
      TPLogUtil.e(this.TAG, "optionID type:" + localOptionIdMapping.getmOptionalIDType() + " is not implement");
      return;
    case 1: 
      this.mNativeInitConfig.setLong(localOptionIdMapping.getNativePlayerOptionalID(), paramOptionalParamLong.value);
      return;
    case 4: 
      this.mNativeInitConfig.setInt(localOptionIdMapping.getNativePlayerOptionalID(), (int)paramOptionalParamLong.value);
      return;
    }
    TPNativePlayerInitConfig localTPNativePlayerInitConfig = this.mNativeInitConfig;
    paramInt = localOptionIdMapping.getNativePlayerOptionalID();
    if (paramOptionalParamLong.value > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      localTPNativePlayerInitConfig.setBool(paramInt, bool);
      return;
    }
  }
  
  private void setPlayerInitConfigWithParamQueueInt(int paramInt, TPOptionalParam.OptionalParamQueueInt paramOptionalParamQueueInt)
  {
    TPThumbPlayerUtils.OptionIdMapping localOptionIdMapping = TPThumbPlayerUtils.convert2NativeOptionaID(paramInt);
    if (localOptionIdMapping == null) {
      TPLogUtil.e(this.TAG, "player optionaIdMapping is invalid, not found in array, id: " + paramInt);
    }
    for (;;)
    {
      return;
      if ((paramOptionalParamQueueInt.queueValue == null) || (paramOptionalParamQueueInt.queueValue.length == 0))
      {
        TPLogUtil.e(this.TAG, "queueint params is empty in" + paramInt);
        return;
      }
      switch (localOptionIdMapping.getmOptionalIDType())
      {
      default: 
        TPLogUtil.e(this.TAG, "optionID type:" + localOptionIdMapping.getmOptionalIDType() + " is not implement");
        return;
      }
      paramInt = 0;
      while (paramInt < paramOptionalParamQueueInt.queueValue.length)
      {
        this.mNativeInitConfig.addQueueInt(localOptionIdMapping.getNativePlayerOptionalID(), paramOptionalParamQueueInt.queueValue[paramInt]);
        paramInt += 1;
      }
    }
  }
  
  private void setPlayerInitConfigWithParamQueueString(int paramInt, TPOptionalParam.OptionalParamQueueString paramOptionalParamQueueString)
  {
    TPThumbPlayerUtils.OptionIdMapping localOptionIdMapping = TPThumbPlayerUtils.convert2NativeOptionaID(paramInt);
    if (localOptionIdMapping == null) {
      TPLogUtil.e(this.TAG, "player optionaIdMapping is invalid, not found in array, id: " + paramInt);
    }
    for (;;)
    {
      return;
      if ((paramOptionalParamQueueString.queueValue == null) || (paramOptionalParamQueueString.queueValue.length == 0))
      {
        TPLogUtil.e(this.TAG, "queue String params is empty in" + paramInt);
        return;
      }
      switch (localOptionIdMapping.getmOptionalIDType())
      {
      default: 
        TPLogUtil.e(this.TAG, "optionID type:" + localOptionIdMapping.getmOptionalIDType() + " is not implement");
        return;
      }
      paramInt = 0;
      while (paramInt < paramOptionalParamQueueString.queueValue.length)
      {
        this.mNativeInitConfig.addQueueString(localOptionIdMapping.getNativePlayerOptionalID(), paramOptionalParamQueueString.queueValue[paramInt]);
        paramInt += 1;
      }
    }
  }
  
  private void setPlayerInitConfigWithParamString(int paramInt, TPOptionalParam.OptionalParamString paramOptionalParamString)
  {
    TPLogUtil.e(this.TAG, "init string param type is not implement coz native init config no string setting");
  }
  
  private void setPlayerOptionWithParamBoolean(int paramInt, TPOptionalParam.OptionalParamBoolean paramOptionalParamBoolean)
  {
    TPThumbPlayerUtils.OptionIdMapping localOptionIdMapping = TPThumbPlayerUtils.convert2NativeOptionaID(paramInt);
    if (localOptionIdMapping == null)
    {
      TPLogUtil.e(this.TAG, "player optionaIdMapping is invalid, not found in array, id: " + paramInt);
      return;
    }
    switch (localOptionIdMapping.getmOptionalIDType())
    {
    default: 
      TPLogUtil.e(this.TAG, "optionID type:" + localOptionIdMapping.getmOptionalIDType() + " is not implement");
      return;
    }
    TPNativePlayer localTPNativePlayer = this.mPlayer;
    paramInt = localOptionIdMapping.getNativePlayerOptionalID();
    if (paramOptionalParamBoolean.value) {}
    for (long l = 1L;; l = 0L)
    {
      localTPNativePlayer.setOptionLong(paramInt, l, 0L);
      return;
    }
  }
  
  private void setPlayerOptionWithParamLong(int paramInt, TPOptionalParam.OptionalParamLong paramOptionalParamLong)
  {
    TPThumbPlayerUtils.OptionIdMapping localOptionIdMapping = TPThumbPlayerUtils.convert2NativeOptionaID(paramInt);
    if (localOptionIdMapping == null)
    {
      TPLogUtil.e(this.TAG, "player optionaIdMapping is invalid, not found in array, id: " + paramInt);
      return;
    }
    switch (localOptionIdMapping.getmOptionalIDType())
    {
    case 2: 
    default: 
      TPLogUtil.e(this.TAG, "optionID type:" + localOptionIdMapping.getmOptionalIDType() + " is not implement");
      return;
    case 1: 
      this.mPlayer.setOptionLong(localOptionIdMapping.getNativePlayerOptionalID(), paramOptionalParamLong.value, paramOptionalParamLong.param1);
      return;
    case 4: 
      this.mPlayer.setOptionLong(localOptionIdMapping.getNativePlayerOptionalID(), paramOptionalParamLong.value, paramOptionalParamLong.param1);
      return;
    }
    this.mPlayer.setOptionLong(localOptionIdMapping.getNativePlayerOptionalID(), paramOptionalParamLong.value, paramOptionalParamLong.param1);
  }
  
  private void setPlayerOptionWithParamString(int paramInt, TPOptionalParam.OptionalParamString paramOptionalParamString)
  {
    TPThumbPlayerUtils.OptionIdMapping localOptionIdMapping = TPThumbPlayerUtils.convert2NativeOptionaID(paramInt);
    if (localOptionIdMapping == null)
    {
      TPLogUtil.e(this.TAG, "player optionaIdMapping is invalid, not found in array, id: " + paramInt);
      return;
    }
    switch (localOptionIdMapping.getmOptionalIDType())
    {
    default: 
      TPLogUtil.e(this.TAG, "optionID type:" + localOptionIdMapping.getmOptionalIDType() + " is not implement");
      return;
    }
    this.mPlayer.setOptionObject(localOptionIdMapping.getNativePlayerOptionalID(), paramOptionalParamString.value);
  }
  
  private void throwExceptionIfPlayerReleased()
  {
    if (this.mPlayer == null) {
      throw new IllegalStateException("player has release");
    }
  }
  
  private TPTrackInfo trackInfoConvert(TPMediaTrackInfo paramTPMediaTrackInfo)
  {
    TPTrackInfo localTPTrackInfo = new TPTrackInfo();
    localTPTrackInfo.name = paramTPMediaTrackInfo.trackName;
    localTPTrackInfo.trackType = paramTPMediaTrackInfo.trackType;
    localTPTrackInfo.isExclusive = paramTPMediaTrackInfo.isExclusive;
    localTPTrackInfo.isSelected = paramTPMediaTrackInfo.isSelected;
    localTPTrackInfo.isInternal = paramTPMediaTrackInfo.isInternal;
    return localTPTrackInfo;
  }
  
  public void addAudioTrackSource(String paramString1, String paramString2, List<TPOptionalParam> paramList)
  {
    TPLogUtil.i(this.TAG, "addAudioTrackSource");
    if (this.mPlayer == null)
    {
      TPLogUtil.w(this.TAG, "player has released, return");
      return;
    }
    paramList = new TPPlayerMsg.TPAudioTrackInfo();
    paramList.audioTrackUrl = paramString1;
    paramString1 = this.mPlayerListenerReps;
    if (paramString1 != null) {
      paramString1.onInfo(1012, 0L, 0L, paramList);
    }
    this.mPlayer.addAudioTrackSource(paramList.proxyUrl, paramString2);
  }
  
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    TPLogUtil.i(this.TAG, "addSubtitleSource");
    if (this.mPlayer == null)
    {
      TPLogUtil.w(this.TAG, "player has released, return");
      return;
    }
    this.mPlayer.addSubtitleTrackSource(paramString1, paramString3);
  }
  
  public void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    TPLogUtil.i(this.TAG, "captureVideo, params" + paramTPCaptureParams);
    if (this.mImageGenerator != null)
    {
      TPImageGeneratorParams localTPImageGeneratorParams = new TPImageGeneratorParams();
      localTPImageGeneratorParams.width = paramTPCaptureParams.width;
      localTPImageGeneratorParams.height = paramTPCaptureParams.height;
      localTPImageGeneratorParams.format = paramTPCaptureParams.format;
      localTPImageGeneratorParams.requestedTimeMsToleranceAfter = paramTPCaptureParams.requestedTimeMsToleranceAfter;
      localTPImageGeneratorParams.requestedTimeMsToleranceBefore = paramTPCaptureParams.requestedTimeMsToleranceBefore;
      this.mImageGenerator.generateImageAsyncAtTime(paramTPCaptureParams.requestedTimeMs, localTPImageGeneratorParams, paramTPCaptureCallBack);
      return;
    }
    paramTPCaptureCallBack.onCaptureVideoFailed(1000013);
  }
  
  public void deselectTrack(int paramInt, long paramLong)
  {
    TPLogUtil.i(this.TAG, "selectTrack");
    if (this.mPlayer == null)
    {
      TPLogUtil.w(this.TAG, "player has released, return");
      return;
    }
    this.mPlayer.deselectTrackAsync(paramInt, paramLong);
  }
  
  public long getCurrentPositionMs()
  {
    if (this.mPlayer == null)
    {
      TPLogUtil.i(this.TAG, "player has released, return 0");
      return 0L;
    }
    return this.mPlayer.getCurrentPositionMs();
  }
  
  public long getDurationMs()
  {
    if (this.mPlayer == null)
    {
      TPLogUtil.i(this.TAG, "player has released, return 0");
      return 0L;
    }
    return this.mPlayer.getDurationMs();
  }
  
  public int getNativePlayerId()
  {
    if (this.mPlayer != null) {
      return this.mPlayer.getNativePlayerId();
    }
    return 0;
  }
  
  public long getPlayableDurationMs()
  {
    if (this.mPlayer == null)
    {
      TPLogUtil.i(this.TAG, "player has released, return 0");
      return 0L;
    }
    return this.mPlayer.getBufferedDurationMs() + this.mPlayer.getCurrentPositionMs();
  }
  
  public TPProgramInfo[] getProgramInfo()
  {
    TPLogUtil.i(this.TAG, "getProgramInfo");
    if (this.mPlayer == null) {
      TPLogUtil.i(this.TAG, "player has released, return 0");
    }
    TPNativePlayerProgramInfo[] arrayOfTPNativePlayerProgramInfo;
    do
    {
      return null;
      arrayOfTPNativePlayerProgramInfo = this.mPlayer.getProgramInfo();
    } while ((arrayOfTPNativePlayerProgramInfo == null) || (arrayOfTPNativePlayerProgramInfo.length < 1));
    TPProgramInfo[] arrayOfTPProgramInfo = new TPProgramInfo[arrayOfTPNativePlayerProgramInfo.length];
    int i = 0;
    while (i < arrayOfTPNativePlayerProgramInfo.length)
    {
      arrayOfTPProgramInfo[i] = programInfoConvert(arrayOfTPNativePlayerProgramInfo[i]);
      i += 1;
    }
    return arrayOfTPProgramInfo;
  }
  
  public long getPropertyLong(int paramInt)
  {
    TPLogUtil.i(this.TAG, "getPropertyLong:" + paramInt);
    throwExceptionIfPlayerReleased();
    paramInt = TPThumbPlayerUtils.convert2NativePropertyID(paramInt);
    if (paramInt < 0)
    {
      TPLogUtil.w(this.TAG, "paramId not found, return -1");
      return -1L;
    }
    return this.mPlayer.getPropertyLong(paramInt);
  }
  
  public String getPropertyString(int paramInt)
  {
    TPLogUtil.i(this.TAG, "getPropertyString:" + paramInt);
    throwExceptionIfPlayerReleased();
    paramInt = TPThumbPlayerUtils.convert2NativePropertyID(paramInt);
    if (paramInt < 0)
    {
      TPLogUtil.w(this.TAG, "paramId not found, return");
      return "";
    }
    return this.mPlayer.getPropertyString(paramInt);
  }
  
  public TPTrackInfo[] getTrackInfo()
  {
    TPLogUtil.i(this.TAG, "getTrackInfo");
    if (this.mPlayer == null) {
      TPLogUtil.i(this.TAG, "player has released, return 0");
    }
    TPMediaTrackInfo[] arrayOfTPMediaTrackInfo;
    do
    {
      return null;
      arrayOfTPMediaTrackInfo = this.mPlayer.getTrackInfo();
    } while ((arrayOfTPMediaTrackInfo == null) || (arrayOfTPMediaTrackInfo.length < 1));
    TPTrackInfo[] arrayOfTPTrackInfo = new TPTrackInfo[arrayOfTPMediaTrackInfo.length];
    int i = 0;
    while (i < arrayOfTPMediaTrackInfo.length)
    {
      arrayOfTPTrackInfo[i] = trackInfoConvert(arrayOfTPMediaTrackInfo[i]);
      i += 1;
    }
    return arrayOfTPTrackInfo;
  }
  
  public int getVideoHeight()
  {
    TPLogUtil.i(this.TAG, "getVideoHeight");
    if (this.mPlayer == null)
    {
      TPLogUtil.i(this.TAG, "player has released, return 0");
      return 0;
    }
    return this.mPlayer.getVideoHeight();
  }
  
  public int getVideoWidth()
  {
    TPLogUtil.i(this.TAG, "getVideoWidth");
    if (this.mPlayer == null)
    {
      TPLogUtil.i(this.TAG, "player has released, return 0");
      return 0;
    }
    return this.mPlayer.getVideoWidth();
  }
  
  public void pause()
  {
    TPLogUtil.i(this.TAG, "pause");
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.pause() != 0) {
      throw new IllegalStateException("pause failed!!");
    }
  }
  
  public void prepare()
  {
    TPLogUtil.i(this.TAG, "prepare");
    throwExceptionIfPlayerReleased();
    this.mPlayer.setInitConfig(this.mNativeInitConfig);
    if (this.mPlayer.prepare() != 0) {
      throw new IllegalStateException("prepare failed!!");
    }
  }
  
  public void prepareAsync()
  {
    TPLogUtil.i(this.TAG, "prepareAsync");
    throwExceptionIfPlayerReleased();
    this.mPlayer.setInitConfig(this.mNativeInitConfig);
    if (this.mPlayer.prepareAsync() != 0) {
      throw new IllegalStateException("prepareAsync failed!!");
    }
  }
  
  public void release()
  {
    TPLogUtil.i(this.TAG, "release");
    if (this.mPlayer == null)
    {
      TPLogUtil.w(this.TAG, "player has released, return");
      return;
    }
    this.mPlayer.release();
    this.mPlayer = null;
    this.mImageGenerator.release();
  }
  
  public void reset()
  {
    TPLogUtil.i(this.TAG, "reset");
    throwExceptionIfPlayerReleased();
    TPLogUtil.i(this.TAG, "reset before");
    this.mPlayer.reset();
    TPLogUtil.i(this.TAG, "reset after");
  }
  
  public void seekTo(int paramInt)
  {
    TPLogUtil.i(this.TAG, "seekTo:" + paramInt);
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.seekToAsync(paramInt, 1, 0L) != 0) {
      throw new IllegalStateException("seek to position:" + paramInt + " failed!!");
    }
  }
  
  public void seekTo(int paramInt1, int paramInt2)
  {
    TPLogUtil.i(this.TAG, "seekTo:" + paramInt1 + " mode:" + paramInt2);
    throwExceptionIfPlayerReleased();
    paramInt2 = TPThumbPlayerUtils.convert2NativeSeekMode(paramInt2);
    if (this.mPlayer.seekToAsync(paramInt1, paramInt2, 0L) != 0) {
      throw new IllegalStateException("seek to position:" + paramInt1 + " failed!!");
    }
  }
  
  public void selectProgram(int paramInt, long paramLong)
  {
    TPLogUtil.i(this.TAG, "selectProgram, programIndex:" + paramInt);
    if (this.mPlayer == null)
    {
      TPLogUtil.w(this.TAG, "player has released, return");
      return;
    }
    this.mPlayer.selectProgramAsync(paramInt, paramLong);
  }
  
  public void selectTrack(int paramInt, long paramLong)
  {
    TPLogUtil.i(this.TAG, "selectTrack");
    if (this.mPlayer == null)
    {
      TPLogUtil.w(this.TAG, "player has released, return");
      return;
    }
    this.mPlayer.selectTrackAsync(paramInt, paramLong);
  }
  
  public void setAudioGainRatio(float paramFloat)
  {
    TPLogUtil.i(this.TAG, "setAudioGainRatio:" + paramFloat);
    if (this.mPlayer == null)
    {
      TPLogUtil.w(this.TAG, "player has released, return");
      return;
    }
    this.mPlayer.setAudioVolume(paramFloat);
  }
  
  public void setAudioNormalizeVolumeParams(String paramString)
  {
    TPLogUtil.i(this.TAG, "setAudioNormalizeVolumeParams:" + paramString);
    if (this.mPlayer == null)
    {
      TPLogUtil.w(this.TAG, "player has released, return");
      return;
    }
    this.mPlayer.setAudioNormalizeVolumeParams(paramString);
  }
  
  public void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    TPLogUtil.i(this.TAG, "setDataSource: " + paramParcelFileDescriptor);
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.setDataSource(paramParcelFileDescriptor.getFd()) != 0) {
      throw new IllegalStateException("setDataSource url pfd failed!!");
    }
    this.mImageGenerator = new TPThumbCapture(paramParcelFileDescriptor.getFd());
  }
  
  public void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    TPLogUtil.i(this.TAG, "setDataSource: " + paramITPMediaAsset);
    throwExceptionIfPlayerReleased();
    if (paramITPMediaAsset == null) {
      throw new IllegalStateException("media asset is null!");
    }
    if ((!(paramITPMediaAsset instanceof TPMediaComposition)) && (!(paramITPMediaAsset instanceof TPMediaCompositionTrack)) && (!(paramITPMediaAsset instanceof TPMediaCompositionTrackClip)) && (!(paramITPMediaAsset instanceof TPMediaDRMAsset))) {
      throw new IllegalStateException("media asset is illegal source!");
    }
    paramITPMediaAsset = paramITPMediaAsset.getUrl();
    if (this.mPlayer.setDataSource(paramITPMediaAsset) != 0) {
      throw new IllegalStateException("setDataSource mediaAsset failed!!");
    }
    this.mImageGenerator = new TPThumbCapture(paramITPMediaAsset);
  }
  
  public void setDataSource(String paramString)
  {
    TPLogUtil.i(this.TAG, "setDataSource: " + paramString);
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.setDataSource(paramString) != 0) {
      throw new IllegalStateException("setDataSource url failed!!");
    }
    this.mImageGenerator = new TPThumbCapture(paramString);
  }
  
  public void setDataSource(String paramString, Map<String, String> paramMap)
  {
    TPLogUtil.i(this.TAG, "setDataSource: " + paramString);
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.setDataSource(paramString) != 0) {
      throw new IllegalStateException("setDataSource url and header failed!!");
    }
    this.mImageGenerator = new TPThumbCapture(paramString);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    TPLogUtil.i(this.TAG, "setLoopback:" + paramBoolean);
    if (this.mPlayer == null)
    {
      TPLogUtil.w(this.TAG, "player has released, return");
      return;
    }
    this.mPlayer.setLoopback(paramBoolean, 0L, -1L);
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    TPLogUtil.i(this.TAG, "setLoopback:" + paramBoolean + " loopStartPositionMs:" + paramLong1 + " loopEndPositionMs:" + paramLong2);
    if (this.mPlayer == null) {
      TPLogUtil.w(this.TAG, "player has released, return");
    }
    while (this.mPlayer.setLoopback(paramBoolean, paramLong1, paramLong2) == 0) {
      return;
    }
    throw new IllegalStateException("set loopback failed!!");
  }
  
  public void setOnAudioPcmOutputListener(ITPPlayerBaseListener.IOnAudioPcmOutListener paramIOnAudioPcmOutListener)
  {
    this.mPlayerListenerReps.setOnAudioPcmOutListener(paramIOnAudioPcmOutListener);
  }
  
  public void setOnAudioProcessOutputListener(ITPPlayerBaseListener.IOnAudioProcessOutListener paramIOnAudioProcessOutListener)
  {
    this.mPlayerListenerReps.setOnAudioProcessFrameListener(paramIOnAudioProcessOutListener);
  }
  
  public void setOnCompletionListener(ITPPlayerBaseListener.IOnCompletionListener paramIOnCompletionListener)
  {
    this.mPlayerListenerReps.setOnCompletionListener(paramIOnCompletionListener);
  }
  
  public void setOnErrorListener(ITPPlayerBaseListener.IOnErrorListener paramIOnErrorListener)
  {
    this.mPlayerListenerReps.setOnErrorListener(paramIOnErrorListener);
  }
  
  public void setOnInfoListener(ITPPlayerBaseListener.IOnInfoListener paramIOnInfoListener)
  {
    this.mPlayerListenerReps.setOnInfoListener(paramIOnInfoListener);
  }
  
  public void setOnPreparedListener(ITPPlayerBaseListener.IOnPreparedListener paramIOnPreparedListener)
  {
    this.mPlayerListenerReps.setOnPreparedListener(paramIOnPreparedListener);
  }
  
  public void setOnSeekCompleteListener(ITPPlayerBaseListener.IOnSeekCompleteListener paramIOnSeekCompleteListener)
  {
    this.mPlayerListenerReps.setOnSeekCompleteListener(paramIOnSeekCompleteListener);
  }
  
  public void setOnSubtitleDataListener(ITPPlayerBaseListener.IOnSubtitleDataListener paramIOnSubtitleDataListener)
  {
    this.mPlayerListenerReps.setOnSubtitleDataListener(paramIOnSubtitleDataListener);
  }
  
  public void setOnSubtitleFrameOutListener(ITPPlayerBaseListener.IOnSubtitleFrameOutListener paramIOnSubtitleFrameOutListener)
  {
    this.mPlayerListenerReps.setOnSubtitleFrameOutLisener(paramIOnSubtitleFrameOutListener);
  }
  
  public void setOnVideoFrameOutListener(ITPPlayerBaseListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener)
  {
    this.mPlayerListenerReps.setOnVideoFrameOutListener(paramIOnVideoFrameOutListener);
  }
  
  public void setOnVideoProcessOutputListener(ITPPlayerBaseListener.IOnVideoProcessOutListener paramIOnVideoProcessOutListener)
  {
    this.mPlayerListenerReps.setOnVideoProcessFrameListener(paramIOnVideoProcessOutListener);
  }
  
  public void setOnVideoSizeChangedListener(ITPPlayerBaseListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener)
  {
    this.mPlayerListenerReps.setOnVideoSizeChangedListener(paramIOnVideoSizeChangedListener);
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    TPLogUtil.i(this.TAG, "setOutputMute:" + paramBoolean);
    if (this.mPlayer == null)
    {
      TPLogUtil.w(this.TAG, "player has released, return");
      return;
    }
    this.mPlayer.setAudioMute(paramBoolean);
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    TPLogUtil.i(this.TAG, "setPlaySpeedRatio:" + paramFloat);
    if (this.mPlayer == null)
    {
      TPLogUtil.w(this.TAG, "player has released, return");
      return;
    }
    this.mPlayer.setPlaybackRate(paramFloat);
  }
  
  public void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    TPLogUtil.i(this.TAG, "setPlayerOptionalParam:" + paramTPOptionalParam);
    if (this.mPlayer == null) {
      TPLogUtil.w(this.TAG, "player has released, return");
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramTPOptionalParam.getParamType() == 1)
          {
            if (paramTPOptionalParam.getKey() < 500)
            {
              setPlayerInitConfigWithParamBoolean(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamBoolean());
              return;
            }
            setPlayerOptionWithParamBoolean(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamBoolean());
            return;
          }
          if (paramTPOptionalParam.getParamType() == 2)
          {
            if (paramTPOptionalParam.getKey() < 500)
            {
              setPlayerInitConfigWithParamLong(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamLong());
              return;
            }
            setPlayerOptionWithParamLong(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamLong());
            return;
          }
          if (paramTPOptionalParam.getParamType() != 6) {
            break;
          }
        } while (paramTPOptionalParam.getKey() >= 500);
        setPlayerInitConfigWithParamFloat(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamFloat());
        return;
        if (paramTPOptionalParam.getParamType() == 3)
        {
          if (paramTPOptionalParam.getKey() < 500)
          {
            setPlayerInitConfigWithParamString(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamString());
            return;
          }
          setPlayerOptionWithParamString(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamString());
          return;
        }
        if (paramTPOptionalParam.getParamType() != 4) {
          break;
        }
      } while (paramTPOptionalParam.getKey() >= 500);
      setPlayerInitConfigWithParamQueueInt(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamQueueInt());
      return;
      if (paramTPOptionalParam.getParamType() != 5) {
        break;
      }
    } while (paramTPOptionalParam.getKey() >= 500);
    setPlayerInitConfigWithParamQueueString(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamQueueString());
    return;
    TPLogUtil.w(this.TAG, "optionalParam param type is unknow, return");
  }
  
  public void setSurface(Surface paramSurface)
  {
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("setSurface, surface is null ? : ");
    boolean bool;
    if (paramSurface == null)
    {
      bool = true;
      TPLogUtil.i(str, bool);
      if (this.mPlayer != null) {
        break label62;
      }
      TPLogUtil.w(this.TAG, "player has released, return");
    }
    label62:
    while (this.mPlayer.setVideoSurface(paramSurface) == 0)
    {
      return;
      bool = false;
      break;
    }
    throw new IllegalStateException("setSurface failed!!");
  }
  
  public void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("SurfaceHolder, surfaceHolder is null ? : ");
    boolean bool;
    if (paramSurfaceHolder == null)
    {
      bool = true;
      TPLogUtil.i(str, bool);
      if (this.mPlayer != null) {
        break label62;
      }
      TPLogUtil.w(this.TAG, "player has released, return");
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      label62:
      if ((paramSurfaceHolder != null) && (paramSurfaceHolder.getSurface() == null))
      {
        TPLogUtil.e(this.TAG, "SurfaceHolder，err.");
        return;
      }
      if (paramSurfaceHolder == null) {}
      for (paramSurfaceHolder = null; this.mPlayer.setVideoSurface(paramSurfaceHolder) != 0; paramSurfaceHolder = paramSurfaceHolder.getSurface()) {
        throw new IllegalStateException("setSurface failed!!");
      }
    }
  }
  
  public void start()
  {
    TPLogUtil.i(this.TAG, "start");
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.start() != 0) {
      throw new IllegalStateException("start failed!!");
    }
  }
  
  public void stop()
  {
    TPLogUtil.i(this.TAG, "stop");
    throwExceptionIfPlayerReleased();
    TPLogUtil.i(this.TAG, "stop before");
    int i = this.mPlayer.stop();
    TPLogUtil.i(this.TAG, "stop after");
    if (i != 0) {
      throw new IllegalStateException("stop failed!!");
    }
  }
  
  public void switchDefinition(ITPMediaAsset paramITPMediaAsset, int paramInt, long paramLong)
  {
    TPLogUtil.i(this.TAG, "switchDefinition mediaAsset:" + paramITPMediaAsset + " opaque:" + paramLong);
    throwExceptionIfPlayerReleased();
    if (paramITPMediaAsset != null)
    {
      paramInt = TPThumbPlayerUtils.convert2NativeSwitchMode(paramInt);
      if (this.mPlayer.switchDefinitionAsync(paramITPMediaAsset.getUrl(), paramInt, paramLong) != 0) {
        throw new IllegalStateException("switchDefinition in invalid state");
      }
      this.mImageGenerator = new TPThumbCapture(paramITPMediaAsset.getUrl());
    }
  }
  
  public void switchDefinition(String paramString, int paramInt, long paramLong)
  {
    TPLogUtil.i(this.TAG, "switchDefinition url:" + paramString + " opaque:" + paramLong);
    throwExceptionIfPlayerReleased();
    paramInt = TPThumbPlayerUtils.convert2NativeSwitchMode(paramInt);
    if (this.mPlayer.switchDefinitionAsync(paramString, paramInt, paramLong) != 0) {
      throw new IllegalStateException("switchDefinition in invalid state");
    }
    this.mImageGenerator = new TPThumbCapture(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayer
 * JD-Core Version:    0.7.0.1
 */