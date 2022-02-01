package com.tencent.mobileqq.qqlive.trtc.utils;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveScreenCaptureParams;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import com.tencent.trtc.TRTCCloudDef.TRTCScreenShareParams;
import com.tencent.trtc.TRTCCloudDef.TRTCSwitchRoomConfig;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoEncParam;

public class TRTCConvertHelper
{
  public static int a(int paramInt)
  {
    if (3 == paramInt) {
      return 112;
    }
    if (4 == paramInt) {
      return 114;
    }
    if (2 == paramInt) {
      return 110;
    }
    if (1 == paramInt) {
      return 108;
    }
    if (paramInt == 0) {
      return 106;
    }
    return 112;
  }
  
  public static TRTCCloudDef.TRTCParams a(@NonNull QQLiveRoomParams paramQQLiveRoomParams)
  {
    if (paramQQLiveRoomParams.getUserSig() != null)
    {
      TRTCCloudDef.TRTCParams localTRTCParams = new TRTCCloudDef.TRTCParams();
      localTRTCParams.userId = paramQQLiveRoomParams.getUserId();
      localTRTCParams.userSig = paramQQLiveRoomParams.getUserSig();
      localTRTCParams.role = d(paramQQLiveRoomParams.getRoleType());
      localTRTCParams.roomId = ((int)paramQQLiveRoomParams.getRoomId());
      localTRTCParams.streamId = paramQQLiveRoomParams.getStreamId();
      localTRTCParams.userDefineRecordId = paramQQLiveRoomParams.getUserDefineRecordId();
      localTRTCParams.businessInfo = paramQQLiveRoomParams.getBussinessInfo();
      return localTRTCParams;
    }
    throw new IllegalArgumentException("UserSig is null");
  }
  
  public static TRTCCloudDef.TRTCScreenShareParams a(QQLiveScreenCaptureParams paramQQLiveScreenCaptureParams)
  {
    if (paramQQLiveScreenCaptureParams == null) {
      return new TRTCCloudDef.TRTCScreenShareParams();
    }
    TRTCCloudDef.TRTCScreenShareParams localTRTCScreenShareParams = new TRTCCloudDef.TRTCScreenShareParams();
    localTRTCScreenShareParams.floatingView = paramQQLiveScreenCaptureParams.getFloatingView();
    return localTRTCScreenShareParams;
  }
  
  public static TRTCCloudDef.TRTCVideoEncParam a(TRTCVideoQualityParams paramTRTCVideoQualityParams)
  {
    if (paramTRTCVideoQualityParams == null) {
      return new TRTCCloudDef.TRTCVideoEncParam();
    }
    TRTCCloudDef.TRTCVideoEncParam localTRTCVideoEncParam = new TRTCCloudDef.TRTCVideoEncParam();
    localTRTCVideoEncParam.videoResolution = a(paramTRTCVideoQualityParams.getVideoResolution());
    localTRTCVideoEncParam.videoBitrate = paramTRTCVideoQualityParams.getVideoBitRate();
    localTRTCVideoEncParam.minVideoBitrate = paramTRTCVideoQualityParams.getMinVideoBitRate();
    localTRTCVideoEncParam.videoFps = paramTRTCVideoQualityParams.getVideoFps();
    localTRTCVideoEncParam.enableAdjustRes = paramTRTCVideoQualityParams.isEnableAdjustRes();
    localTRTCVideoEncParam.videoResolutionMode = b(paramTRTCVideoQualityParams.getVideoResolutionMode());
    return localTRTCVideoEncParam;
  }
  
  public static int b(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    if (1 == paramInt) {}
    return 1;
  }
  
  public static TRTCCloudDef.TRTCSwitchRoomConfig b(@NonNull QQLiveRoomParams paramQQLiveRoomParams)
  {
    if (paramQQLiveRoomParams.getUserSig() != null)
    {
      TRTCCloudDef.TRTCSwitchRoomConfig localTRTCSwitchRoomConfig = new TRTCCloudDef.TRTCSwitchRoomConfig();
      localTRTCSwitchRoomConfig.roomId = ((int)paramQQLiveRoomParams.getRoomId());
      localTRTCSwitchRoomConfig.userSig = paramQQLiveRoomParams.getUserSig();
      return localTRTCSwitchRoomConfig;
    }
    throw new IllegalArgumentException("userSig is null");
  }
  
  public static int c(int paramInt)
  {
    if (paramInt != 0)
    {
      int i = 2;
      if (paramInt != 2)
      {
        i = 3;
        if (paramInt != 3) {
          return 1;
        }
      }
      return i;
    }
    return 0;
  }
  
  public static int d(int paramInt)
  {
    if (paramInt == 1) {
      return 21;
    }
    return 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.utils.TRTCConvertHelper
 * JD-Core Version:    0.7.0.1
 */