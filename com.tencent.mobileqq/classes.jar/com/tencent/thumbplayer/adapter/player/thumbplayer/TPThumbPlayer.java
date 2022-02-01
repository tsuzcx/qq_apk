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
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapAudioDecoderType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapMsgInfo;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapPropertyId;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapSeekMode;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapSwitchDefMode;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapVideoDecoderType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPCommonEnum.NativeErrorType;
import com.tencent.thumbplayer.api.TPCommonEnum.NativeMsgInfo;
import com.tencent.thumbplayer.api.TPCommonEnum.TPOptionalId;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSeekMode;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSwitchDefMode;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamBoolean;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamFloat;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamLong;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamObject;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamQueueInt;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamQueueString;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamString;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPAudioTrackInfo;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleRenderModel;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.caputure.TPThumbCapture;
import com.tencent.thumbplayer.core.common.TPMediaTrackInfo;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.core.player.ITPNativePlayerAudioFrameCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.MediaCodecInfo;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.MediaDrmInfo;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.VideoCropInfo;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.VideoSeiInfo;
import com.tencent.thumbplayer.core.player.ITPNativePlayerPostProcessFrameCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerSubtitleFrameCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerVideoFrameCallback;
import com.tencent.thumbplayer.core.player.TPNativePlayer;
import com.tencent.thumbplayer.core.player.TPNativePlayerInitConfig;
import com.tencent.thumbplayer.core.player.TPNativePlayerProgramInfo;
import com.tencent.thumbplayer.log.TPBaseLogger;
import com.tencent.thumbplayer.log.TPLoggerContext;
import java.util.List;
import java.util.Map;

public class TPThumbPlayer
  implements ITPPlayerBase
{
  private static final int EVENT_MSG_ASYNC_CALL = 1;
  private static final int EVENT_MSG_ON_ERROR = 4;
  private static final int EVENT_MSG_ON_INFO_LONG = 2;
  private static final int EVENT_MSG_ON_INFO_OBJECT = 3;
  private static final String TAG = "TPThumbPlayer";
  private TPThumbPlayer.EventHandler mEventHandler;
  private ITPCapture mImageGenerator;
  private TPBaseLogger mLogger;
  private ITPNativePlayerAudioFrameCallback mNativeAudioFrameCallback = new TPThumbPlayer.2(this);
  private TPNativePlayerInitConfig mNativeInitConfig;
  private ITPNativePlayerMessageCallback mNativeMessageCallback = new TPThumbPlayer.1(this);
  private ITPNativePlayerPostProcessFrameCallback mNativePostProcessFrameCallback = new TPThumbPlayer.5(this);
  private ITPNativePlayerSubtitleFrameCallback mNativeSubtitleFrameCallback = new TPThumbPlayer.4(this);
  private ITPNativePlayerVideoFrameCallback mNativeVideoFrameCallback = new TPThumbPlayer.3(this);
  private TPNativePlayer mPlayer;
  private TPPlayerBaseListeners mPlayerListenerReps;
  private TPSubtitleData mSubtitleData = new TPSubtitleData();
  
  public TPThumbPlayer(Context paramContext, TPLoggerContext paramTPLoggerContext)
  {
    this.mLogger = new TPBaseLogger(paramTPLoggerContext, "TPThumbPlayer");
    this.mPlayer = new TPNativePlayer(paramContext);
    this.mPlayer.setMessageCallback(this.mNativeMessageCallback);
    this.mPlayer.setAudioFrameCallback(this.mNativeAudioFrameCallback);
    this.mPlayer.setVideoFrameCallback(this.mNativeVideoFrameCallback);
    this.mPlayer.setSubtitleFrameCallback(this.mNativeSubtitleFrameCallback);
    this.mPlayer.setPostProcessFrameCallback(this.mNativePostProcessFrameCallback);
    this.mNativeInitConfig = new TPNativePlayerInitConfig();
    this.mPlayerListenerReps = new TPPlayerBaseListeners(this.mLogger.getTag());
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
    this.mPlayerListenerReps.onInfo(TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapMsgInfo.class, paramOnASyncCallResultInfo.callType), paramOnASyncCallResultInfo.errorType, paramOnASyncCallResultInfo.errorCode, Long.valueOf(paramOnASyncCallResultInfo.opaque));
  }
  
  private void handleOnComplete()
  {
    this.mPlayerListenerReps.onCompletion();
  }
  
  private void handleOnInfoLongNoConvertToListener(@TPCommonEnum.NativeErrorType int paramInt, TPThumbPlayer.OnInfoLongInfo paramOnInfoLongInfo)
  {
    int i = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapMsgInfo.class, paramInt);
    StringBuilder localStringBuilder;
    if (i < 0)
    {
      paramOnInfoLongInfo = this.mLogger;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("msgType:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", cannot convert to thumbPlayer Info");
      paramOnInfoLongInfo.warn(localStringBuilder.toString());
      return;
    }
    long l1 = paramOnInfoLongInfo.lParam1;
    long l2 = paramOnInfoLongInfo.lParam2;
    if (i != 203)
    {
      if (i != 204)
      {
        paramOnInfoLongInfo = this.mLogger;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("unhandled thumbPlayerInfo=");
        localStringBuilder.append(i);
        paramOnInfoLongInfo.warn(localStringBuilder.toString());
        break label157;
      }
      paramInt = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapVideoDecoderType.class, (int)paramOnInfoLongInfo.lParam1);
    }
    else
    {
      paramInt = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapAudioDecoderType.class, (int)paramOnInfoLongInfo.lParam1);
    }
    l1 = paramInt;
    label157:
    this.mPlayerListenerReps.onInfo(i, l1, l2, null);
  }
  
  private void handleOnInfoObjectNoConvertToListener(@TPCommonEnum.NativeMsgInfo int paramInt, TPThumbPlayer.OnInfoObjectInfo paramOnInfoObjectInfo)
  {
    int i = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapMsgInfo.class, paramInt);
    if (i < 0)
    {
      paramOnInfoObjectInfo = this.mLogger;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("msgType:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", cannot convert to thumbPlayer Info");
      paramOnInfoObjectInfo.warn(((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = paramOnInfoObjectInfo.objParam;
    if (i != 500)
    {
      if (i != 505)
      {
        if (i != 502)
        {
          if ((i == 503) && (paramOnInfoObjectInfo.objParam != null)) {
            localObject = TPThumbPlayerUtils.convert2TPVideoSeiInfo((ITPNativePlayerMessageCallback.VideoSeiInfo)paramOnInfoObjectInfo.objParam);
          }
        }
        else if (paramOnInfoObjectInfo.objParam != null) {
          localObject = TPThumbPlayerUtils.convert2TPMediaCodecInfo((ITPNativePlayerMessageCallback.MediaCodecInfo)paramOnInfoObjectInfo.objParam);
        }
      }
      else if (paramOnInfoObjectInfo.objParam != null) {
        localObject = TPThumbPlayerUtils.convert2TPMediaDrmInfo((ITPNativePlayerMessageCallback.MediaDrmInfo)paramOnInfoObjectInfo.objParam);
      }
    }
    else if (paramOnInfoObjectInfo.objParam != null) {
      localObject = TPThumbPlayerUtils.convert2TPVideoCropInfo((ITPNativePlayerMessageCallback.VideoCropInfo)paramOnInfoObjectInfo.objParam);
    }
    this.mPlayerListenerReps.onInfo(i, 0L, 0L, localObject);
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
      localTPProgramInfo.url = paramTPNativePlayerProgramInfo.url;
      localTPProgramInfo.bandwidth = paramTPNativePlayerProgramInfo.bandwidth;
      localTPProgramInfo.resolution = paramTPNativePlayerProgramInfo.resolution;
      localTPProgramInfo.programId = paramTPNativePlayerProgramInfo.programId;
      localTPProgramInfo.actived = paramTPNativePlayerProgramInfo.actived;
      return localTPProgramInfo;
    }
    return null;
  }
  
  private void setPlayerInitConfigWithParamBoolean(@TPCommonEnum.TPOptionalId int paramInt, TPOptionalParam.OptionalParamBoolean paramOptionalParamBoolean)
  {
    Object localObject = TPNativeKeyMapUtil.convertToNativeOptionalId(paramInt);
    if (((TPThumbPlayerUtils.OptionIdMapping)localObject).isIllegal())
    {
      paramOptionalParamBoolean = this.mLogger;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("player optionalIdMapping boolean is invalid, not found in array, id: ");
      ((StringBuilder)localObject).append(paramInt);
      paramOptionalParamBoolean.error(((StringBuilder)localObject).toString());
      return;
    }
    if (((TPThumbPlayerUtils.OptionIdMapping)localObject).getOptionalIDType() != 3)
    {
      paramOptionalParamBoolean = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("optionID type:");
      localStringBuilder.append(((TPThumbPlayerUtils.OptionIdMapping)localObject).getOptionalIDType());
      localStringBuilder.append(" is not implement");
      paramOptionalParamBoolean.error(localStringBuilder.toString());
      return;
    }
    this.mNativeInitConfig.setBool(((TPThumbPlayerUtils.OptionIdMapping)localObject).getNativePlayerOptionalID(), paramOptionalParamBoolean.value);
  }
  
  private void setPlayerInitConfigWithParamFloat(@TPCommonEnum.TPOptionalId int paramInt, TPOptionalParam.OptionalParamFloat paramOptionalParamFloat)
  {
    Object localObject = TPNativeKeyMapUtil.convertToNativeOptionalId(paramInt);
    if (((TPThumbPlayerUtils.OptionIdMapping)localObject).isIllegal())
    {
      paramOptionalParamFloat = this.mLogger;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("player optionalIdMapping float is invalid, not found in array, id: ");
      ((StringBuilder)localObject).append(paramInt);
      paramOptionalParamFloat.error(((StringBuilder)localObject).toString());
      return;
    }
    if (7 != ((TPThumbPlayerUtils.OptionIdMapping)localObject).getOptionalIDType())
    {
      paramOptionalParamFloat = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("optionID:");
      localStringBuilder.append(((TPThumbPlayerUtils.OptionIdMapping)localObject).getNativePlayerOptionalID());
      localStringBuilder.append(" is not float");
      paramOptionalParamFloat.error(localStringBuilder.toString());
      return;
    }
    this.mNativeInitConfig.setFloat(((TPThumbPlayerUtils.OptionIdMapping)localObject).getNativePlayerOptionalID(), paramOptionalParamFloat.value);
  }
  
  private void setPlayerInitConfigWithParamLong(@TPCommonEnum.TPOptionalId int paramInt, TPOptionalParam.OptionalParamLong paramOptionalParamLong)
  {
    Object localObject1 = TPNativeKeyMapUtil.convertToNativeOptionalId(paramInt);
    if (((TPThumbPlayerUtils.OptionIdMapping)localObject1).isIllegal())
    {
      paramOptionalParamLong = this.mLogger;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("player optionalIdMapping long is invalid, not found in array, id: ");
      ((StringBuilder)localObject1).append(paramInt);
      paramOptionalParamLong.error(((StringBuilder)localObject1).toString());
      return;
    }
    paramInt = ((TPThumbPlayerUtils.OptionIdMapping)localObject1).getOptionalIDType();
    boolean bool = true;
    if (paramInt != 1)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          paramOptionalParamLong = this.mLogger;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("optionID type:");
          ((StringBuilder)localObject2).append(((TPThumbPlayerUtils.OptionIdMapping)localObject1).getOptionalIDType());
          ((StringBuilder)localObject2).append(" is not implement");
          paramOptionalParamLong.error(((StringBuilder)localObject2).toString());
          return;
        }
        this.mNativeInitConfig.setInt(((TPThumbPlayerUtils.OptionIdMapping)localObject1).getNativePlayerOptionalID(), (int)paramOptionalParamLong.value);
        return;
      }
      Object localObject2 = this.mNativeInitConfig;
      paramInt = ((TPThumbPlayerUtils.OptionIdMapping)localObject1).getNativePlayerOptionalID();
      if (paramOptionalParamLong.value <= 0L) {
        bool = false;
      }
      ((TPNativePlayerInitConfig)localObject2).setBool(paramInt, bool);
      return;
    }
    this.mNativeInitConfig.setLong(((TPThumbPlayerUtils.OptionIdMapping)localObject1).getNativePlayerOptionalID(), paramOptionalParamLong.value);
  }
  
  private void setPlayerInitConfigWithParamQueueInt(@TPCommonEnum.TPOptionalId int paramInt, TPOptionalParam.OptionalParamQueueInt paramOptionalParamQueueInt)
  {
    Object localObject = TPNativeKeyMapUtil.convertToNativeOptionalId(paramInt);
    if (((TPThumbPlayerUtils.OptionIdMapping)localObject).isIllegal())
    {
      paramOptionalParamQueueInt = this.mLogger;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("player optionalIdMapping queue_int is invalid, not found in array, id: ");
      ((StringBuilder)localObject).append(paramInt);
      paramOptionalParamQueueInt.error(((StringBuilder)localObject).toString());
      return;
    }
    if ((paramOptionalParamQueueInt.queueValue != null) && (paramOptionalParamQueueInt.queueValue.length != 0))
    {
      if (((TPThumbPlayerUtils.OptionIdMapping)localObject).getOptionalIDType() != 5)
      {
        paramOptionalParamQueueInt = this.mLogger;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("optionID type:");
        localStringBuilder.append(((TPThumbPlayerUtils.OptionIdMapping)localObject).getOptionalIDType());
        localStringBuilder.append(" is not implement");
        paramOptionalParamQueueInt.error(localStringBuilder.toString());
        return;
      }
      paramInt = 0;
      while (paramInt < paramOptionalParamQueueInt.queueValue.length)
      {
        this.mNativeInitConfig.addQueueInt(((TPThumbPlayerUtils.OptionIdMapping)localObject).getNativePlayerOptionalID(), paramOptionalParamQueueInt.queueValue[paramInt]);
        paramInt += 1;
      }
      return;
    }
    paramOptionalParamQueueInt = this.mLogger;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("queueint params is empty in");
    ((StringBuilder)localObject).append(paramInt);
    paramOptionalParamQueueInt.error(((StringBuilder)localObject).toString());
  }
  
  private void setPlayerInitConfigWithParamQueueString(@TPCommonEnum.TPOptionalId int paramInt, TPOptionalParam.OptionalParamQueueString paramOptionalParamQueueString)
  {
    Object localObject = TPNativeKeyMapUtil.convertToNativeOptionalId(paramInt);
    if (((TPThumbPlayerUtils.OptionIdMapping)localObject).isIllegal())
    {
      paramOptionalParamQueueString = this.mLogger;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("player optionalIdMapping queue_string is invalid, not found in array, id: ");
      ((StringBuilder)localObject).append(paramInt);
      paramOptionalParamQueueString.error(((StringBuilder)localObject).toString());
      return;
    }
    if ((paramOptionalParamQueueString.queueValue != null) && (paramOptionalParamQueueString.queueValue.length != 0))
    {
      if (((TPThumbPlayerUtils.OptionIdMapping)localObject).getOptionalIDType() != 6)
      {
        paramOptionalParamQueueString = this.mLogger;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("optionID type:");
        localStringBuilder.append(((TPThumbPlayerUtils.OptionIdMapping)localObject).getOptionalIDType());
        localStringBuilder.append(" is not implement");
        paramOptionalParamQueueString.error(localStringBuilder.toString());
        return;
      }
      paramInt = 0;
      while (paramInt < paramOptionalParamQueueString.queueValue.length)
      {
        this.mNativeInitConfig.addQueueString(((TPThumbPlayerUtils.OptionIdMapping)localObject).getNativePlayerOptionalID(), paramOptionalParamQueueString.queueValue[paramInt]);
        paramInt += 1;
      }
      return;
    }
    paramOptionalParamQueueString = this.mLogger;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("queue String params is empty in");
    ((StringBuilder)localObject).append(paramInt);
    paramOptionalParamQueueString.error(((StringBuilder)localObject).toString());
  }
  
  private void setPlayerInitConfigWithParamString(int paramInt, TPOptionalParam.OptionalParamString paramOptionalParamString)
  {
    this.mLogger.error("init string param type is not implement coz native init config no string setting");
  }
  
  private void setPlayerOptionWithParamBoolean(@TPCommonEnum.TPOptionalId int paramInt, TPOptionalParam.OptionalParamBoolean paramOptionalParamBoolean)
  {
    Object localObject1 = TPNativeKeyMapUtil.convertToNativeOptionalId(paramInt);
    if (((TPThumbPlayerUtils.OptionIdMapping)localObject1).isIllegal())
    {
      paramOptionalParamBoolean = this.mLogger;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("player optionalIdMapping string is invalid, not found in array, id: ");
      ((StringBuilder)localObject1).append(paramInt);
      paramOptionalParamBoolean.error(((StringBuilder)localObject1).toString());
      return;
    }
    if (((TPThumbPlayerUtils.OptionIdMapping)localObject1).getOptionalIDType() != 3)
    {
      paramOptionalParamBoolean = this.mLogger;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("optionID type:");
      ((StringBuilder)localObject2).append(((TPThumbPlayerUtils.OptionIdMapping)localObject1).getOptionalIDType());
      ((StringBuilder)localObject2).append(" is not implement");
      paramOptionalParamBoolean.error(((StringBuilder)localObject2).toString());
      return;
    }
    Object localObject2 = this.mPlayer;
    paramInt = ((TPThumbPlayerUtils.OptionIdMapping)localObject1).getNativePlayerOptionalID();
    long l;
    if (paramOptionalParamBoolean.value) {
      l = 1L;
    } else {
      l = 0L;
    }
    ((TPNativePlayer)localObject2).setOptionLong(paramInt, l, 0L);
  }
  
  private void setPlayerOptionWithParamLong(@TPCommonEnum.TPOptionalId int paramInt, TPOptionalParam.OptionalParamLong paramOptionalParamLong)
  {
    Object localObject = TPNativeKeyMapUtil.convertToNativeOptionalId(paramInt);
    if (((TPThumbPlayerUtils.OptionIdMapping)localObject).isIllegal())
    {
      paramOptionalParamLong = this.mLogger;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("player optionalIdMapping long is invalid, not found in array, id: ");
      ((StringBuilder)localObject).append(paramInt);
      paramOptionalParamLong.error(((StringBuilder)localObject).toString());
      return;
    }
    paramInt = ((TPThumbPlayerUtils.OptionIdMapping)localObject).getOptionalIDType();
    if ((paramInt != 1) && (paramInt != 3) && (paramInt != 4))
    {
      paramOptionalParamLong = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("optionID type:");
      localStringBuilder.append(((TPThumbPlayerUtils.OptionIdMapping)localObject).getOptionalIDType());
      localStringBuilder.append(" is not implement");
      paramOptionalParamLong.error(localStringBuilder.toString());
      return;
    }
    this.mPlayer.setOptionLong(((TPThumbPlayerUtils.OptionIdMapping)localObject).getNativePlayerOptionalID(), paramOptionalParamLong.value, paramOptionalParamLong.param1);
  }
  
  private void setPlayerOptionWithParamObject(int paramInt, TPOptionalParam.OptionalParamObject paramOptionalParamObject)
  {
    Object localObject = TPNativeKeyMapUtil.convertToNativeOptionalId(paramInt);
    if (localObject == null)
    {
      paramOptionalParamObject = this.mLogger;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("player optionaIdMapping object is invalid, not found in array, id: ");
      ((StringBuilder)localObject).append(paramInt);
      paramOptionalParamObject.error(((StringBuilder)localObject).toString());
      return;
    }
    if (((TPThumbPlayerUtils.OptionIdMapping)localObject).getNativePlayerOptionalID() != 1001)
    {
      paramOptionalParamObject = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("optionID type:");
      localStringBuilder.append(((TPThumbPlayerUtils.OptionIdMapping)localObject).getOptionalIDType());
      localStringBuilder.append(" is not implement");
      paramOptionalParamObject.error(localStringBuilder.toString());
      return;
    }
    paramOptionalParamObject = TPThumbPlayerUtils.convert2TPNativeSubtitleRenderParams((TPSubtitleRenderModel)paramOptionalParamObject.objectValue);
    this.mPlayer.setOptionObject(((TPThumbPlayerUtils.OptionIdMapping)localObject).getNativePlayerOptionalID(), paramOptionalParamObject);
  }
  
  private void setPlayerOptionWithParamString(@TPCommonEnum.TPOptionalId int paramInt, TPOptionalParam.OptionalParamString paramOptionalParamString)
  {
    Object localObject = TPNativeKeyMapUtil.convertToNativeOptionalId(paramInt);
    if (((TPThumbPlayerUtils.OptionIdMapping)localObject).isIllegal())
    {
      paramOptionalParamString = this.mLogger;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("player optionalIdMapping string is invalid, not found in array, id: ");
      ((StringBuilder)localObject).append(paramInt);
      paramOptionalParamString.error(((StringBuilder)localObject).toString());
      return;
    }
    if (((TPThumbPlayerUtils.OptionIdMapping)localObject).getOptionalIDType() != 2)
    {
      paramOptionalParamString = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("optionID type:");
      localStringBuilder.append(((TPThumbPlayerUtils.OptionIdMapping)localObject).getOptionalIDType());
      localStringBuilder.append(" is not implement");
      paramOptionalParamString.error(localStringBuilder.toString());
      return;
    }
    this.mPlayer.setOptionObject(((TPThumbPlayerUtils.OptionIdMapping)localObject).getNativePlayerOptionalID(), paramOptionalParamString.value);
  }
  
  private void throwExceptionIfPlayerReleased()
  {
    if (this.mPlayer != null) {
      return;
    }
    throw new IllegalStateException("player has release");
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
    this.mLogger.info("addAudioTrackSource");
    if (this.mPlayer == null)
    {
      this.mLogger.warn("player has released, return");
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
    this.mLogger.info("addSubtitleSource");
    paramString2 = this.mPlayer;
    if (paramString2 == null)
    {
      this.mLogger.warn("player has released, return");
      return;
    }
    paramString2.addSubtitleTrackSource(paramString1, paramString3);
  }
  
  public void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("captureVideo, params");
    localStringBuilder.append(paramTPCaptureParams);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    if (this.mImageGenerator != null)
    {
      localObject = new TPImageGeneratorParams();
      ((TPImageGeneratorParams)localObject).width = paramTPCaptureParams.width;
      ((TPImageGeneratorParams)localObject).height = paramTPCaptureParams.height;
      ((TPImageGeneratorParams)localObject).format = paramTPCaptureParams.format;
      ((TPImageGeneratorParams)localObject).requestedTimeMsToleranceAfter = paramTPCaptureParams.requestedTimeMsToleranceAfter;
      ((TPImageGeneratorParams)localObject).requestedTimeMsToleranceBefore = paramTPCaptureParams.requestedTimeMsToleranceBefore;
      this.mImageGenerator.generateImageAsyncAtTime(paramTPCaptureParams.requestedTimeMs, (TPImageGeneratorParams)localObject, paramTPCaptureCallBack);
      return;
    }
    paramTPCaptureCallBack.onCaptureVideoFailed(1000013);
  }
  
  public void deselectTrack(int paramInt, long paramLong)
  {
    this.mLogger.info("selectTrack");
    TPNativePlayer localTPNativePlayer = this.mPlayer;
    if (localTPNativePlayer == null)
    {
      this.mLogger.warn("player has released, return");
      return;
    }
    localTPNativePlayer.deselectTrackAsync(paramInt, paramLong);
  }
  
  public long getCurrentPositionMs()
  {
    TPNativePlayer localTPNativePlayer = this.mPlayer;
    if (localTPNativePlayer == null)
    {
      this.mLogger.info("player has released, return 0");
      return 0L;
    }
    return localTPNativePlayer.getCurrentPositionMs();
  }
  
  public long getDurationMs()
  {
    TPNativePlayer localTPNativePlayer = this.mPlayer;
    if (localTPNativePlayer == null)
    {
      this.mLogger.info("player has released, return 0");
      return 0L;
    }
    return localTPNativePlayer.getDurationMs();
  }
  
  public int getNativePlayerId()
  {
    TPNativePlayer localTPNativePlayer = this.mPlayer;
    if (localTPNativePlayer != null) {
      return localTPNativePlayer.getNativePlayerId();
    }
    return 0;
  }
  
  public long getPlayableDurationMs()
  {
    TPNativePlayer localTPNativePlayer = this.mPlayer;
    if (localTPNativePlayer == null)
    {
      this.mLogger.info("player has released, return 0");
      return 0L;
    }
    return localTPNativePlayer.getBufferedDurationMs() + this.mPlayer.getCurrentPositionMs();
  }
  
  public TPProgramInfo[] getProgramInfo()
  {
    this.mLogger.info("getProgramInfo");
    Object localObject2 = this.mPlayer;
    Object localObject1 = null;
    if (localObject2 == null)
    {
      this.mLogger.info("player has released, return 0");
      return null;
    }
    TPNativePlayerProgramInfo[] arrayOfTPNativePlayerProgramInfo = ((TPNativePlayer)localObject2).getProgramInfo();
    if (arrayOfTPNativePlayerProgramInfo != null)
    {
      if (arrayOfTPNativePlayerProgramInfo.length < 1) {
        return null;
      }
      localObject2 = new TPProgramInfo[arrayOfTPNativePlayerProgramInfo.length];
      int i = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= arrayOfTPNativePlayerProgramInfo.length) {
          break;
        }
        localObject2[i] = programInfoConvert(arrayOfTPNativePlayerProgramInfo[i]);
        i += 1;
      }
    }
    return localObject1;
  }
  
  public long getPropertyLong(int paramInt)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getPropertyLong:");
    localStringBuilder.append(paramInt);
    localTPBaseLogger.info(localStringBuilder.toString());
    throwExceptionIfPlayerReleased();
    paramInt = TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapPropertyId.class, paramInt);
    if (paramInt < 0)
    {
      this.mLogger.warn("paramId not found, return -1");
      return -1L;
    }
    return this.mPlayer.getPropertyLong(paramInt);
  }
  
  public String getPropertyString(int paramInt)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getPropertyString:");
    localStringBuilder.append(paramInt);
    localTPBaseLogger.info(localStringBuilder.toString());
    throwExceptionIfPlayerReleased();
    try
    {
      int i = TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapPropertyId.class, paramInt);
      if (i < 0)
      {
        localTPBaseLogger = this.mLogger;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getPropertyString, tpToNativeValue(TPNativeKeyMap.MapPropertyId.class,");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("), return");
        localStringBuilder.append(i);
        localTPBaseLogger.warn(localStringBuilder.toString());
        return "";
      }
      return this.mPlayer.getPropertyString(i);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label123:
      break label123;
    }
    this.mLogger.warn("paramId not found, return");
    return "";
  }
  
  public TPTrackInfo[] getTrackInfo()
  {
    this.mLogger.info("getTrackInfo");
    Object localObject2 = this.mPlayer;
    Object localObject1 = null;
    if (localObject2 == null)
    {
      this.mLogger.info("player has released, return 0");
      return null;
    }
    TPMediaTrackInfo[] arrayOfTPMediaTrackInfo = ((TPNativePlayer)localObject2).getTrackInfo();
    if (arrayOfTPMediaTrackInfo != null)
    {
      if (arrayOfTPMediaTrackInfo.length < 1) {
        return null;
      }
      localObject2 = new TPTrackInfo[arrayOfTPMediaTrackInfo.length];
      int i = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= arrayOfTPMediaTrackInfo.length) {
          break;
        }
        localObject2[i] = trackInfoConvert(arrayOfTPMediaTrackInfo[i]);
        i += 1;
      }
    }
    return localObject1;
  }
  
  public int getVideoHeight()
  {
    this.mLogger.info("getVideoHeight");
    TPNativePlayer localTPNativePlayer = this.mPlayer;
    if (localTPNativePlayer == null)
    {
      this.mLogger.info("player has released, return 0");
      return 0;
    }
    return localTPNativePlayer.getVideoHeight();
  }
  
  public int getVideoWidth()
  {
    this.mLogger.info("getVideoWidth");
    TPNativePlayer localTPNativePlayer = this.mPlayer;
    if (localTPNativePlayer == null)
    {
      this.mLogger.info("player has released, return 0");
      return 0;
    }
    return localTPNativePlayer.getVideoWidth();
  }
  
  public void pause()
  {
    this.mLogger.info("pause");
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.pause() == 0) {
      return;
    }
    throw new IllegalStateException("pause failed!!");
  }
  
  public void prepare()
  {
    this.mLogger.info("prepare");
    throwExceptionIfPlayerReleased();
    this.mPlayer.setInitConfig(this.mNativeInitConfig);
    if (this.mPlayer.prepare() == 0) {
      return;
    }
    throw new IllegalStateException("prepare failed!!");
  }
  
  public void prepareAsync()
  {
    this.mLogger.info("prepareAsync");
    throwExceptionIfPlayerReleased();
    this.mPlayer.setInitConfig(this.mNativeInitConfig);
    if (this.mPlayer.prepareAsync() == 0) {
      return;
    }
    throw new IllegalStateException("prepareAsync failed!!");
  }
  
  public void release()
  {
    this.mLogger.info("release");
    Object localObject = this.mPlayer;
    if (localObject != null)
    {
      ((TPNativePlayer)localObject).release();
      this.mPlayer = null;
    }
    localObject = this.mImageGenerator;
    if (localObject != null)
    {
      ((ITPCapture)localObject).release();
      this.mImageGenerator = null;
    }
    localObject = this.mEventHandler;
    if (localObject != null)
    {
      ((TPThumbPlayer.EventHandler)localObject).removeCallbacksAndMessages(null);
      this.mEventHandler = null;
    }
  }
  
  public void reset()
  {
    this.mLogger.info("reset");
    if (this.mPlayer == null)
    {
      this.mLogger.warn("reset, player has released.");
      return;
    }
    this.mLogger.info("reset before");
    this.mPlayer.reset();
    TPThumbPlayer.EventHandler localEventHandler = this.mEventHandler;
    if (localEventHandler != null) {
      localEventHandler.removeCallbacksAndMessages(null);
    }
    this.mLogger.info("reset after");
  }
  
  public void seekTo(int paramInt)
  {
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seekTo:");
    localStringBuilder.append(paramInt);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.seekToAsync(paramInt, 1, 0L) == 0) {
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("seek to position:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" failed!!");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void seekTo(int paramInt1, @TPCommonEnum.TPSeekMode int paramInt2)
  {
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seekTo:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" mode:");
    localStringBuilder.append(paramInt2);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.seekToAsync(paramInt1, TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapSeekMode.class, paramInt2), 0L) == 0) {
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("seek to position:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" failed!!");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void selectProgram(int paramInt, long paramLong)
  {
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("selectProgram, programIndex:");
    localStringBuilder.append(paramInt);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    localObject = this.mPlayer;
    if (localObject == null)
    {
      this.mLogger.warn("player has released, return");
      return;
    }
    ((TPNativePlayer)localObject).selectProgramAsync(paramInt, paramLong);
  }
  
  public void selectTrack(int paramInt, long paramLong)
  {
    this.mLogger.info("selectTrack");
    TPNativePlayer localTPNativePlayer = this.mPlayer;
    if (localTPNativePlayer == null)
    {
      this.mLogger.warn("player has released, return");
      return;
    }
    localTPNativePlayer.selectTrackAsync(paramInt, paramLong);
  }
  
  public void setAudioGainRatio(float paramFloat)
  {
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAudioGainRatio:");
    localStringBuilder.append(paramFloat);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    localObject = this.mPlayer;
    if (localObject == null)
    {
      this.mLogger.warn("player has released, return");
      return;
    }
    ((TPNativePlayer)localObject).setAudioVolume(paramFloat);
  }
  
  public void setAudioNormalizeVolumeParams(String paramString)
  {
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAudioNormalizeVolumeParams:");
    localStringBuilder.append(paramString);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    localObject = this.mPlayer;
    if (localObject == null)
    {
      this.mLogger.warn("player has released, return");
      return;
    }
    ((TPNativePlayer)localObject).setAudioNormalizeVolumeParams(paramString);
  }
  
  public void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor != null)
    {
      int i = paramParcelFileDescriptor.detachFd();
      paramParcelFileDescriptor.close();
      TPBaseLogger localTPBaseLogger = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDataSource: ");
      localStringBuilder.append(paramParcelFileDescriptor);
      localStringBuilder.append(", fd:");
      localStringBuilder.append(i);
      localTPBaseLogger.info(localStringBuilder.toString());
      throwExceptionIfPlayerReleased();
      if (this.mPlayer.setDataSource(i) == 0)
      {
        this.mImageGenerator = new TPThumbCapture(i);
        return;
      }
      throw new IllegalStateException("setDataSource url pfd failed!!");
    }
    throw new IllegalStateException("setDataSource url pfd is null!!");
  }
  
  public void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setDataSource: ");
    localStringBuilder.append(paramITPMediaAsset);
    localTPBaseLogger.info(localStringBuilder.toString());
    throwExceptionIfPlayerReleased();
    if (paramITPMediaAsset != null)
    {
      paramITPMediaAsset = paramITPMediaAsset.getUrl();
      if (this.mPlayer.setDataSource(paramITPMediaAsset) == 0)
      {
        this.mImageGenerator = new TPThumbCapture(paramITPMediaAsset);
        return;
      }
      throw new IllegalStateException("setDataSource mediaAsset failed!!");
    }
    throw new IllegalStateException("media asset is null!");
  }
  
  public void setDataSource(String paramString)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setDataSource: ");
    localStringBuilder.append(paramString);
    localTPBaseLogger.info(localStringBuilder.toString());
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.setDataSource(paramString) == 0)
    {
      this.mImageGenerator = new TPThumbCapture(paramString);
      return;
    }
    throw new IllegalStateException("setDataSource url failed!!");
  }
  
  public void setDataSource(String paramString, Map<String, String> paramMap)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setDataSource: ");
    localStringBuilder.append(paramString);
    localTPBaseLogger.info(localStringBuilder.toString());
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.setDataSource(paramString, paramMap) == 0)
    {
      this.mImageGenerator = new TPThumbCapture(paramString);
      return;
    }
    throw new IllegalStateException("setDataSource url and header failed!!");
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLoopback:");
    localStringBuilder.append(paramBoolean);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    localObject = this.mPlayer;
    if (localObject == null)
    {
      this.mLogger.warn("player has released, return");
      return;
    }
    ((TPNativePlayer)localObject).setLoopback(paramBoolean, 0L, -1L);
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLoopback:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" loopStartPositionMs:");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(" loopEndPositionMs:");
    localStringBuilder.append(paramLong2);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    localObject = this.mPlayer;
    if (localObject == null)
    {
      this.mLogger.warn("player has released, return");
      return;
    }
    if (((TPNativePlayer)localObject).setLoopback(paramBoolean, paramLong1, paramLong2) == 0) {
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
    this.mPlayerListenerReps.setOnSubtitleFrameOutListener(paramIOnSubtitleFrameOutListener);
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
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setOutputMute:");
    localStringBuilder.append(paramBoolean);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    localObject = this.mPlayer;
    if (localObject == null)
    {
      this.mLogger.warn("player has released, return");
      return;
    }
    ((TPNativePlayer)localObject).setAudioMute(paramBoolean);
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPlaySpeedRatio:");
    localStringBuilder.append(paramFloat);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    localObject = this.mPlayer;
    if (localObject == null)
    {
      this.mLogger.warn("player has released, return");
      return;
    }
    ((TPNativePlayer)localObject).setPlaybackRate(paramFloat);
  }
  
  public void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPlayerOptionalParam:");
    localStringBuilder.append(paramTPOptionalParam);
    localTPBaseLogger.info(localStringBuilder.toString());
    if (this.mPlayer == null)
    {
      this.mLogger.warn("player has released, return");
      return;
    }
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
    if (paramTPOptionalParam.getParamType() == 6)
    {
      if (paramTPOptionalParam.getKey() < 500) {
        setPlayerInitConfigWithParamFloat(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamFloat());
      }
    }
    else
    {
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
      if (paramTPOptionalParam.getParamType() == 4)
      {
        if (paramTPOptionalParam.getKey() < 500) {
          setPlayerInitConfigWithParamQueueInt(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamQueueInt());
        }
      }
      else if (paramTPOptionalParam.getParamType() == 5)
      {
        if (paramTPOptionalParam.getKey() < 500) {
          setPlayerInitConfigWithParamQueueString(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamQueueString());
        }
      }
      else
      {
        if (paramTPOptionalParam.getParamType() != 7) {
          break label312;
        }
        if (paramTPOptionalParam.getKey() < 500) {
          return;
        }
        setPlayerOptionWithParamObject(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamObject());
      }
    }
    return;
    label312:
    this.mLogger.warn("optionalParam param type is unknown, return");
  }
  
  public void setSurface(Surface paramSurface)
  {
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSurface, surface is null ? : ");
    boolean bool;
    if (paramSurface == null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    localObject = this.mPlayer;
    if (localObject == null)
    {
      this.mLogger.warn("player has released, return");
      return;
    }
    if (((TPNativePlayer)localObject).setVideoSurface(paramSurface) == 0) {
      return;
    }
    throw new IllegalStateException("setSurface failed!!");
  }
  
  public void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SurfaceHolder, surfaceHolder is null ? : ");
    boolean bool;
    if (paramSurfaceHolder == null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localTPBaseLogger.info(localStringBuilder.toString());
    if (this.mPlayer == null)
    {
      this.mLogger.warn("player has released, return");
      return;
    }
    if ((paramSurfaceHolder != null) && (paramSurfaceHolder.getSurface() == null))
    {
      this.mLogger.error("SurfaceHolder，err.");
      return;
    }
    if (paramSurfaceHolder == null) {
      paramSurfaceHolder = null;
    } else {
      paramSurfaceHolder = paramSurfaceHolder.getSurface();
    }
    if (this.mPlayer.setVideoSurface(paramSurfaceHolder) == 0) {
      return;
    }
    throw new IllegalStateException("setSurface failed!!");
  }
  
  public void start()
  {
    this.mLogger.info("start");
    throwExceptionIfPlayerReleased();
    if (this.mPlayer.start() == 0) {
      return;
    }
    throw new IllegalStateException("start failed!!");
  }
  
  public void stop()
  {
    this.mLogger.info("stop");
    throwExceptionIfPlayerReleased();
    this.mLogger.info("stop before");
    int i = this.mPlayer.stop();
    this.mLogger.info("stop after");
    if (i == 0) {
      return;
    }
    throw new IllegalStateException("stop failed!!");
  }
  
  public void switchDefinition(ITPMediaAsset paramITPMediaAsset, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("switchDefinition mediaAsset:");
    localStringBuilder.append(paramITPMediaAsset);
    localStringBuilder.append(" opaque:");
    localStringBuilder.append(paramLong);
    localTPBaseLogger.info(localStringBuilder.toString());
    throwExceptionIfPlayerReleased();
    if (paramITPMediaAsset != null)
    {
      paramInt = TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapSwitchDefMode.class, paramInt);
      if (this.mPlayer.switchDefinitionAsync(paramITPMediaAsset.getUrl(), paramInt, paramLong) == 0)
      {
        this.mImageGenerator = new TPThumbCapture(paramITPMediaAsset.getUrl());
        return;
      }
      throw new IllegalStateException("switchDefinition in invalid state");
    }
  }
  
  public void switchDefinition(String paramString, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
  {
    Object localObject = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("switchDefinition url:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" opaque:");
    localStringBuilder.append(paramLong);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    throwExceptionIfPlayerReleased();
    paramInt = TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapSwitchDefMode.class, paramInt);
    if (this.mPlayer.switchDefinitionAsync(paramString, paramInt, paramLong) == 0)
    {
      localObject = this.mImageGenerator;
      if (localObject != null)
      {
        ((ITPCapture)localObject).release();
        this.mImageGenerator = null;
      }
      this.mImageGenerator = new TPThumbCapture(paramString);
      return;
    }
    throw new IllegalStateException("switchDefinition in invalid state");
  }
  
  public void switchDefinition(String paramString, Map<String, String> paramMap, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
  {
    TPBaseLogger localTPBaseLogger = this.mLogger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("switchDefinition url:");
    localStringBuilder.append(paramString);
    localStringBuilder.append("httpHeader:");
    localStringBuilder.append(paramMap);
    localStringBuilder.append(" opaque:");
    localStringBuilder.append(paramLong);
    localTPBaseLogger.info(localStringBuilder.toString());
    throwExceptionIfPlayerReleased();
    paramInt = TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapSwitchDefMode.class, paramInt);
    if (this.mPlayer.switchDefinitionAsync(paramString, paramMap, paramInt, paramLong) == 0)
    {
      paramMap = this.mImageGenerator;
      if (paramMap != null)
      {
        paramMap.release();
        this.mImageGenerator = null;
      }
      this.mImageGenerator = new TPThumbCapture(paramString);
      return;
    }
    throw new IllegalStateException("switchDefinition in invalid state");
  }
  
  public void updateLoggerContext(TPLoggerContext paramTPLoggerContext)
  {
    this.mLogger.updateContext(new TPLoggerContext(paramTPLoggerContext, "TPThumbPlayer"));
    if (paramTPLoggerContext != null) {
      this.mPlayerListenerReps.updateTag(this.mLogger.getTPLoggerContext().getTag());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayer
 * JD-Core Version:    0.7.0.1
 */