package com.tencent.mobileqq.qqlive.anchor.room.helper;

import com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSO;
import com.tencent.mobileqq.qqlive.anchor.util.QQLiveAnchorSSOHelper;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.protobuf.iliveStreamControl.nano.GetLiveStreamsReq;

public class QQLiveAnchorHelperThirdPush
{
  private boolean a = false;
  private boolean b = false;
  
  public void a(IQQLiveSDK paramIQQLiveSDK, QQLiveAnchorRoomInfo paramQQLiveAnchorRoomInfo, QQLiveAnchorAutoCheckPullPlayParams paramQQLiveAnchorAutoCheckPullPlayParams, IQQLiveAnchorRoomThirdPushCallback paramIQQLiveAnchorRoomThirdPushCallback)
  {
    if (this.a)
    {
      QLog.e("QQLiveAnchor_thirdpush", 1, "gettingPushUrl, ignore");
      return;
    }
    this.a = true;
    try
    {
      paramIQQLiveAnchorRoomThirdPushCallback.k();
      QQLiveAnchorSSO.a(paramIQQLiveSDK, QQLiveAnchorSSOHelper.a(paramQQLiveAnchorRoomInfo), new QQLiveAnchorHelperThirdPush.1(this, paramQQLiveAnchorRoomInfo, paramIQQLiveAnchorRoomThirdPushCallback, paramQQLiveAnchorAutoCheckPullPlayParams, paramIQQLiveSDK));
      return;
    }
    catch (Throwable paramIQQLiveSDK)
    {
      QLog.e("QQLiveAnchor_thirdpush", 1, paramIQQLiveSDK, new Object[0]);
      this.a = false;
    }
  }
  
  public void b(IQQLiveSDK paramIQQLiveSDK, QQLiveAnchorRoomInfo paramQQLiveAnchorRoomInfo, QQLiveAnchorAutoCheckPullPlayParams paramQQLiveAnchorAutoCheckPullPlayParams, IQQLiveAnchorRoomThirdPushCallback paramIQQLiveAnchorRoomThirdPushCallback)
  {
    if (this.b)
    {
      QLog.e("QQLiveAnchor_thirdpush", 1, "gettingPullUrl, ignore");
      return;
    }
    this.b = true;
    try
    {
      paramIQQLiveAnchorRoomThirdPushCallback.j();
      GetLiveStreamsReq localGetLiveStreamsReq = new GetLiveStreamsReq();
      localGetLiveStreamsReq.c = paramQQLiveAnchorRoomInfo.uid;
      localGetLiveStreamsReq.d = paramQQLiveAnchorRoomInfo.roomData.id;
      localGetLiveStreamsReq.f = 1;
      localGetLiveStreamsReq.e = QQLiveAnchorSSOHelper.b(paramIQQLiveSDK.getAppId());
      Object localObject = null;
      paramQQLiveAnchorAutoCheckPullPlayParams = localObject;
      if (paramQQLiveAnchorRoomInfo != null)
      {
        paramQQLiveAnchorAutoCheckPullPlayParams = localObject;
        if (paramQQLiveAnchorRoomInfo.thirdPushInfo != null) {
          paramQQLiveAnchorAutoCheckPullPlayParams = paramQQLiveAnchorRoomInfo.thirdPushInfo.rtmpUrl;
        }
      }
      QQLiveAnchorSSO.a(paramIQQLiveSDK, paramQQLiveAnchorAutoCheckPullPlayParams, localGetLiveStreamsReq, new QQLiveAnchorHelperThirdPush.2(this, paramQQLiveAnchorRoomInfo, paramIQQLiveAnchorRoomThirdPushCallback));
      return;
    }
    catch (Throwable paramIQQLiveSDK)
    {
      QLog.e("QQLiveAnchor_thirdpush", 1, paramIQQLiveSDK, new Object[0]);
      this.b = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperThirdPush
 * JD-Core Version:    0.7.0.1
 */