package com.tencent.thumbplayer.adapter.player.thumbplayer;

import android.content.Context;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import com.tencent.thumbplayer.adapter.TPPlayerBaseListeners;
import com.tencent.thumbplayer.adapter.player.ITPCapture;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBase;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioPcmOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnCompletionListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnInfoListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnPreparedListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamBoolean;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamLong;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamQueueInt;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamQueueString;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamString;
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
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.VideoCropInfo;
import com.tencent.thumbplayer.core.player.ITPNativePlayerVideoFrameCallback;
import com.tencent.thumbplayer.core.player.TPNativePlayer;
import com.tencent.thumbplayer.core.player.TPNativePlayerInitConfig;
import com.tencent.thumbplayer.core.player.TPNativePlayerProgramInfo;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.Map;

public class TPThumbPlayer
  implements ITPPlayerBase
{
  private static final int EVENT_MSG_ASYNC_CALL = 1;
  private static final int EVENT_MSG_ON_ERROR = 4;
  private static final int EVENT_MSG_ON_INFO_LONG = 2;
  private static final int EVENT_MSG_ON_INFO_OBJECT = 3;
  private static String TAG = "TPThumbPlayer[TPThumbPlayer.java]";
  private TPThumbPlayer.EventHandler mEventHandler;
  private ITPCapture mImageGenerator;
  private ITPNativePlayerAudioFrameCallback mNativeAudioFrameCallback = new TPThumbPlayer.2(this);
  private TPNativePlayerInitConfig mNativeInitConfig;
  private ITPNativePlayerMessageCallback mNativeMessageCallback = new TPThumbPlayer.1(this);
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
    this.mNativeInitConfig = new TPNativePlayerInitConfig();
    this.mPlayerListenerReps = new TPPlayerBaseListeners(TAG);
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
      TPLogUtil.w(TAG, "msgType:" + paramInt + ", connot convert to thumbPlayer Info");
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
      TPLogUtil.w(TAG, "msgType:" + paramInt + ", connot convert to thumbPlayer Info");
      return;
    }
    Object localObject = paramOnInfoObjectInfo.objParam;
    switch (i)
    {
    }
    for (;;)
    {
      this.mPlayerListenerReps.onInfo(i, 0L, 0L, localObject);
      return;
      if (paramOnInfoObjectInfo.objParam != null) {
        localObject = TPThumbPlayerUtils.convert2TPVideoCropInfo((ITPNativePlayerMessageCallback.VideoCropInfo)paramOnInfoObjectInfo.objParam);
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
      return localTPProgramInfo;
    }
    return null;
  }
  
  private void setPlayerInitConfigWithParamBoolean(int paramInt, TPOptionalParam.OptionalParamBoolean paramOptionalParamBoolean)
  {
    TPThumbPlayerUtils.OptionIdMapping localOptionIdMapping = TPThumbPlayerUtils.convert2NativeOptionaID(paramInt);
    if (localOptionIdMapping == null)
    {
      TPLogUtil.e(TAG, "player optionaIdMapping is invalid, not found in array, id: " + paramInt);
      return;
    }
    switch (localOptionIdMapping.getmOptionalIDType())
    {
    default: 
      TPLogUtil.e(TAG, "optionID type:" + localOptionIdMapping.getmOptionalIDType() + " is not implement");
      return;
    }
    this.mNativeInitConfig.setBool(localOptionIdMapping.getNativePlayerOptionalID(), paramOptionalParamBoolean.value);
  }
  
  private void setPlayerInitConfigWithParamLong(int paramInt, TPOptionalParam.OptionalParamLong paramOptionalParamLong)
  {
    TPThumbPlayerUtils.OptionIdMapping localOptionIdMapping = TPThumbPlayerUtils.convert2NativeOptionaID(paramInt);
    if (localOptionIdMapping == null)
    {
      TPLogUtil.e(TAG, "player optionaIdMapping is invalid, not found in array, id: " + paramInt);
      return;
    }
    switch (localOptionIdMapping.getmOptionalIDType())
    {
    case 2: 
    default: 
      TPLogUtil.e(TAG, "optionID type:" + localOptionIdMapping.getmOptionalIDType() + " is not implement");
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
      TPLogUtil.e(TAG, "player optionaIdMapping is invalid, not found in array, id: " + paramInt);
    }
    for (;;)
    {
      return;
      if ((paramOptionalParamQueueInt.queueValue == null) || (paramOptionalParamQueueInt.queueValue.length == 0))
      {
        TPLogUtil.e(TAG, "queueint params is empty in" + paramInt);
        return;
      }
      switch (localOptionIdMapping.getmOptionalIDType())
      {
      default: 
        TPLogUtil.e(TAG, "optionID type:" + localOptionIdMapping.getmOptionalIDType() + " is not implement");
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
      TPLogUtil.e(TAG, "player optionaIdMapping is invalid, not found in array, id: " + paramInt);
    }
    for (;;)
    {
      return;
      if ((paramOptionalParamQueueString.queueValue == null) || (paramOptionalParamQueueString.queueValue.length == 0))
      {
        TPLogUtil.e(TAG, "queue String params is empty in" + paramInt);
        return;
      }
      switch (localOptionIdMapping.getmOptionalIDType())
      {
      default: 
        TPLogUtil.e(TAG, "optionID type:" + localOptionIdMapping.getmOptionalIDType() + " is not implement");
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
    TPLogUtil.e(TAG, "init string param type is not implement coz native init config no string setting");
  }
  
  private void setPlayerOptionWithParamBoolean(int paramInt, TPOptionalParam.OptionalParamBoolean paramOptionalParamBoolean)
  {
    TPThumbPlayerUtils.OptionIdMapping localOptionIdMapping = TPThumbPlayerUtils.convert2NativeOptionaID(paramInt);
    if (localOptionIdMapping == null)
    {
      TPLogUtil.e(TAG, "player optionaIdMapping is invalid, not found in array, id: " + paramInt);
      return;
    }
    switch (localOptionIdMapping.getmOptionalIDType())
    {
    default: 
      TPLogUtil.e(TAG, "optionID type:" + localOptionIdMapping.getmOptionalIDType() + " is not implement");
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
      TPLogUtil.e(TAG, "player optionaIdMapping is invalid, not found in array, id: " + paramInt);
      return;
    }
    switch (localOptionIdMapping.getmOptionalIDType())
    {
    case 2: 
    default: 
      TPLogUtil.e(TAG, "optionID type:" + localOptionIdMapping.getmOptionalIDType() + " is not implement");
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
      TPLogUtil.e(TAG, "player optionaIdMapping is invalid, not found in array, id: " + paramInt);
      return;
    }
    switch (localOptionIdMapping.getmOptionalIDType())
    {
    default: 
      TPLogUtil.e(TAG, "optionID type:" + localOptionIdMapping.getmOptionalIDType() + " is not implement");
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
  
  public void addAudioTrackSource(String paramString1, String paramString2)
  {
    TPLogUtil.i(TAG, "addAudioTrackSource");
    if (this.mPlayer == null)
    {
      TPLogUtil.w(TAG, "player has released, return");
      return;
    }
    this.mPlayer.addAudioTrackSource(paramString1, paramString2);
  }
  
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    TPLogUtil.i(TAG, "addSubtitleSource");
    if (this.mPlayer == null)
    {
      TPLogUtil.w(TAG, "player has released, return");
      return;
    }
    this.mPlayer.addSubtitleTrackSource(paramString1, paramString3);
  }
  
  public void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    TPLogUtil.i(TAG, "captureVideo, params" + paramTPCaptureParams);
    if (this.mImageGenerator != null)
    {
      TPImageGeneratorParams localTPImageGeneratorParams = new TPImageGeneratorParams();
      localTPImageGeneratorParams.width = paramTPCaptureParams.width;
      localTPImageGeneratorParams.height = paramTPCaptureParams.height;
      localTPImageGeneratorParams.format = paramTPCaptureParams.format;
      localTPImageGeneratorParams.requestedTimeMsToleranceAfter = paramTPCaptureParams.requestedTimeMsToleranceAfter;
      localTPImageGeneratorParams.requestedTimeMsToleranceBefore = paramTPCaptureParams.requestedTimeMsToleranceBefore;
      this.mImageGenerator.generateImageAsyncAtTime(getCurrentPositionMs(), localTPImageGeneratorParams, paramTPCaptureCallBack);
      return;
    }
    paramTPCaptureCallBack.onCaptureVideoFailed(1000013);
  }
  
  public void deselectTrack(int paramInt, long paramLong)
  {
    TPLogUtil.i(TAG, "selectTrack");
    if (this.mPlayer == null)
    {
      TPLogUtil.w(TAG, "player has released, return");
      return;
    }
    this.mPlayer.deselectTrackAsync(paramInt, paramLong);
  }
  
  public int getBufferPercent()
  {
    if (this.mPlayer == null)
    {
      TPLogUtil.i(TAG, "player has released, return 0");
      return 0;
    }
    if (this.mPlayer.getDurationMs() <= 0L)
    {
      TPLogUtil.w(TAG, "bufferPercent is not large than 0, return 0");
      return 0;
    }
    return (int)(100.0F * (float)this.mPlayer.getBufferedDurationMs() / (float)this.mPlayer.getDurationMs());
  }
  
  public long getCurrentPositionMs()
  {
    if (this.mPlayer == null)
    {
      TPLogUtil.i(TAG, "player has released, return 0");
      return 0L;
    }
    return this.mPlayer.getCurrentPositionMs();
  }
  
  public long getDurationMs()
  {
    if (this.mPlayer == null)
    {
      TPLogUtil.i(TAG, "player has released, return 0");
      return 0L;
    }
    return this.mPlayer.getDurationMs();
  }
  
  public TPProgramInfo[] getProgramInfo()
  {
    TPLogUtil.i(TAG, "getProgramInfo");
    if (this.mPlayer == null) {
      TPLogUtil.i(TAG, "player has released, return 0");
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
    TPLogUtil.i(TAG, "getPropertyLong:" + paramInt);
    throwExceptionIfPlayerReleased();
    paramInt = TPThumbPlayerUtils.convert2NativePropertyID(paramInt);
    if (paramInt < 0)
    {
      TPLogUtil.w(TAG, "paramId not found, return -1");
      return -1L;
    }
    return this.mPlayer.getPropertyLong(paramInt);
  }
  
  public String getPropertyString(int paramInt)
  {
    TPLogUtil.i(TAG, "getPropertyString:" + paramInt);
    throwExceptionIfPlayerReleased();
    paramInt = TPThumbPlayerUtils.convert2NativePropertyID(paramInt);
    if (paramInt < 0)
    {
      TPLogUtil.w(TAG, "paramId not found, return");
      return "";
    }
    return this.mPlayer.getPropertyString(paramInt);
  }
  
  public TPTrackInfo[] getTrackInfo()
  {
    TPLogUtil.i(TAG, "getTrackInfo");
    if (this.mPlayer == null) {
      TPLogUtil.i(TAG, "player has released, return 0");
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
    TPLogUtil.i(TAG, "getVideoHeight");
    if (this.mPlayer == null)
    {
      TPLogUtil.i(TAG, "player has released, return 0");
      return 0;
    }
    return this.mPlayer.getVideoHeight();
  }
  
  public int getVideoWidth()
  {
    TPLogUtil.i(TAG, "getVideoWidth");
    if (this.mPlayer == null)
    {
      TPLogUtil.i(TAG, "player has released, return 0");
      return 0;
    }
    return this.mPlayer.getVideoWidth();
  }
  
  public void pause()
  {
    TPLogUtil.i(TAG, "pause");
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.pause() != 0) {
      throw new IllegalStateException("pause failed!!");
    }
  }
  
  public void prepare()
  {
    TPLogUtil.i(TAG, "prepare");
    throwExceptionIfPlayerReleased();
    this.mPlayer.setInitConfig(this.mNativeInitConfig);
    if (this.mPlayer.prepare() != 0) {
      throw new IllegalStateException("prepare failed!!");
    }
  }
  
  public void prepareAsync()
  {
    TPLogUtil.i(TAG, "prepareAsync");
    throwExceptionIfPlayerReleased();
    this.mPlayer.setInitConfig(this.mNativeInitConfig);
    if (this.mPlayer.prepareAsync() != 0) {
      throw new IllegalStateException("prepareAsync failed!!");
    }
  }
  
  public void release()
  {
    TPLogUtil.i(TAG, "release");
    if (this.mPlayer == null)
    {
      TPLogUtil.w(TAG, "player has released, return");
      return;
    }
    this.mPlayer.release();
    this.mPlayer = null;
    this.mImageGenerator.release();
  }
  
  public void reset()
  {
    TPLogUtil.i(TAG, "reset");
    throwExceptionIfPlayerReleased();
    TPLogUtil.i(TAG, "reset before");
    this.mPlayer.reset();
    TPLogUtil.i(TAG, "reset after");
  }
  
  public void seekTo(int paramInt)
  {
    TPLogUtil.i(TAG, "seekTo:" + paramInt);
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.seekToAsync(paramInt, 1, 0L) != 0) {
      throw new IllegalStateException("seek to position:" + paramInt + " failed!!");
    }
  }
  
  public void seekTo(int paramInt1, int paramInt2)
  {
    TPLogUtil.i(TAG, "seekTo:" + paramInt1 + " mode:" + paramInt2);
    throwExceptionIfPlayerReleased();
    paramInt2 = TPThumbPlayerUtils.convert2NativeSeekMode(paramInt2);
    if (this.mPlayer.seekToAsync(paramInt1, paramInt2, 0L) != 0) {
      throw new IllegalStateException("seek to position:" + paramInt1 + " failed!!");
    }
  }
  
  public void selectProgram(int paramInt, long paramLong)
  {
    TPLogUtil.i(TAG, "selectProgram");
    if (this.mPlayer == null)
    {
      TPLogUtil.w(TAG, "player has released, return");
      return;
    }
    this.mPlayer.selectProgramAsync(paramInt, paramLong);
  }
  
  public void selectTrack(int paramInt, long paramLong)
  {
    TPLogUtil.i(TAG, "selectTrack");
    if (this.mPlayer == null)
    {
      TPLogUtil.w(TAG, "player has released, return");
      return;
    }
    this.mPlayer.selectTrackAsync(paramInt, paramLong);
  }
  
  public void setAudioGainRatio(float paramFloat)
  {
    TPLogUtil.i(TAG, "setAudioGainRatio:" + paramFloat);
    if (this.mPlayer == null)
    {
      TPLogUtil.w(TAG, "player has released, return");
      return;
    }
    this.mPlayer.setAudioVolume(paramFloat);
  }
  
  public void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    TPLogUtil.i(TAG, "setDataSource: " + paramParcelFileDescriptor);
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.setDataSource(paramParcelFileDescriptor.getFd()) != 0) {
      throw new IllegalStateException("setDataSource url pfd failed!!");
    }
    this.mImageGenerator = new TPThumbCapture(paramParcelFileDescriptor.getFd());
  }
  
  public void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    TPLogUtil.i(TAG, "setDataSource: " + paramITPMediaAsset);
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
    TPLogUtil.i(TAG, "setDataSource: " + paramString);
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.setDataSource(paramString) != 0) {
      throw new IllegalStateException("setDataSource url failed!!");
    }
    this.mImageGenerator = new TPThumbCapture(paramString);
  }
  
  public void setDataSource(String paramString, Map<String, String> paramMap)
  {
    TPLogUtil.i(TAG, "setDataSource: " + paramString);
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.setDataSource(paramString) != 0) {
      throw new IllegalStateException("setDataSource url and header failed!!");
    }
    this.mImageGenerator = new TPThumbCapture(paramString);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    TPLogUtil.i(TAG, "setLoopback:" + paramBoolean);
    if (this.mPlayer == null)
    {
      TPLogUtil.w(TAG, "player has released, return");
      return;
    }
    this.mPlayer.setLoopback(paramBoolean, 0L, -1L);
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    TPLogUtil.i(TAG, "setLoopback:" + paramBoolean + " loopStartPositionMs:" + paramLong1 + " loopEndPositionMs:" + paramLong2);
    if (this.mPlayer == null) {
      TPLogUtil.w(TAG, "player has released, return");
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
  
  public void setOnVideoFrameOutListener(ITPPlayerBaseListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener)
  {
    this.mPlayerListenerReps.setOnVideoFrameOutListener(paramIOnVideoFrameOutListener);
  }
  
  public void setOnVideoSizeChangedListener(ITPPlayerBaseListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener)
  {
    this.mPlayerListenerReps.setOnVideoSizeChangedListener(paramIOnVideoSizeChangedListener);
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    TPLogUtil.i(TAG, "setOutputMute:" + paramBoolean);
    if (this.mPlayer == null)
    {
      TPLogUtil.w(TAG, "player has released, return");
      return;
    }
    this.mPlayer.setAudioMute(paramBoolean);
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    TPLogUtil.i(TAG, "setPlaySpeedRatio:" + paramFloat);
    if (this.mPlayer == null)
    {
      TPLogUtil.w(TAG, "player has released, return");
      return;
    }
    this.mPlayer.setPlaybackRate(paramFloat);
  }
  
  public void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    TPLogUtil.i(TAG, "setPlayerOptionalParam:" + paramTPOptionalParam);
    if (this.mPlayer == null) {
      TPLogUtil.w(TAG, "player has released, return");
    }
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
    TPLogUtil.w(TAG, "optionalParam param type is unknow, return");
  }
  
  public void setSurface(Surface paramSurface)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("setSurface， surface is null ? : ");
    boolean bool;
    if (paramSurface == null)
    {
      bool = true;
      TPLogUtil.i(str, bool);
      if (this.mPlayer != null) {
        break label60;
      }
      TPLogUtil.w(TAG, "player has released, return");
    }
    label60:
    while (this.mPlayer.setVideoSurface(paramSurface) == 0)
    {
      return;
      bool = false;
      break;
    }
    throw new IllegalStateException("setSurface failed!!");
  }
  
  public void start()
  {
    TPLogUtil.i(TAG, "start");
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.start() != 0) {
      throw new IllegalStateException("start failed!!");
    }
  }
  
  public void stop()
  {
    TPLogUtil.i(TAG, "stop");
    throwExceptionIfPlayerReleased();
    TPLogUtil.i(TAG, "stop before");
    int i = this.mPlayer.stop();
    TPLogUtil.i(TAG, "stop after");
    if (i != 0) {
      throw new IllegalStateException("stop failed!!");
    }
  }
  
  public void switchDefinition(ITPMediaAsset paramITPMediaAsset, long paramLong)
  {
    TPLogUtil.i(TAG, "switchDefinition mediaAsset:" + paramITPMediaAsset + " opaque:" + paramLong);
    throwExceptionIfPlayerReleased();
    if (paramITPMediaAsset != null)
    {
      if (this.mPlayer.switchDefinitionAsync(paramITPMediaAsset.getUrl(), paramLong) != 0) {
        throw new IllegalStateException("switchDefinition in invalid state");
      }
      this.mImageGenerator = new TPThumbCapture(paramITPMediaAsset.getUrl());
    }
  }
  
  public void switchDefinition(String paramString, long paramLong)
  {
    TPLogUtil.i(TAG, "switchDefinition url:" + paramString + " opaque:" + paramLong);
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.switchDefinitionAsync(paramString, paramLong) != 0) {
      throw new IllegalStateException("switchDefinition in invalid state");
    }
    this.mImageGenerator = new TPThumbCapture(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayer
 * JD-Core Version:    0.7.0.1
 */