package com.tencent.mobileqq.qqlive.api.impl.room;

import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.ExitRoomType;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.mobileqq.qqlive.sso.QQLiveCallbackObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.iliveRoomDispatch.nano.LeaveRoomReq;
import com.tencent.qqlive.roomAccess.nano.EnterRoomRequest;

class AudienceRoomEnterExitModule
{
  private static final String TAG = "AudienceRoomEnterExitModule";
  EnterRoomInfo currentInfo = null;
  LiveInfo liveInfo = null;
  
  void enterRoom(EnterRoomInfo paramEnterRoomInfo, IQQLiveSDK paramIQQLiveSDK, EnterAudienceRoomCallback paramEnterAudienceRoomCallback)
  {
    this.currentInfo = paramEnterRoomInfo;
    EnterRoomRequest localEnterRoomRequest = new EnterRoomRequest();
    localEnterRoomRequest.a = paramEnterRoomInfo.getRoomId();
    localEnterRoomRequest.g = paramEnterRoomInfo.getChannelId();
    localEnterRoomRequest.d = paramEnterRoomInfo.getVideoFormat();
    localEnterRoomRequest.f = paramEnterRoomInfo.getProgramId();
    localEnterRoomRequest.h = paramEnterRoomInfo.getTransData();
    localEnterRoomRequest.b = paramEnterRoomInfo.getDeviceId();
    if (!TextUtils.isEmpty(paramEnterRoomInfo.getExtraData())) {
      localEnterRoomRequest.e = paramEnterRoomInfo.getExtraData().getBytes();
    }
    if (!TextUtils.isEmpty(paramEnterRoomInfo.getSource())) {
      localEnterRoomRequest.c = paramEnterRoomInfo.getSource().getBytes();
    }
    if (paramIQQLiveSDK == null)
    {
      QLog.e("AudienceRoomEnterExitModule", 1, "try exitRoom but liveSDK is null!");
      if (paramEnterAudienceRoomCallback != null) {
        paramEnterAudienceRoomCallback.onFailed(5108, "liveSDK is null");
      }
      return;
    }
    paramIQQLiveSDK = paramIQQLiveSDK.getExtModule("sso_module");
    if ((paramIQQLiveSDK instanceof IQQLiveSsoModule))
    {
      paramEnterRoomInfo = new QQLiveCallbackObserver(new AudienceRoomEnterExitModule.1(this, paramEnterRoomInfo, paramEnterAudienceRoomCallback));
      ((IQQLiveSsoModule)paramIQQLiveSDK).a("trpc.qlive.room_access.RoomAccess", "EnterRoom", MessageNano.toByteArray(localEnterRoomRequest), paramEnterRoomInfo);
      return;
    }
    QLog.e("AudienceRoomEnterExitModule", 1, "try exitRoom but ssoModule is null!");
    if (paramEnterAudienceRoomCallback != null) {
      paramEnterAudienceRoomCallback.onFailed(5108, "ssoModule is null");
    }
  }
  
  void exitRoom(IQQLiveSDK paramIQQLiveSDK, ExitRoomCallback paramExitRoomCallback)
  {
    if (this.currentInfo == null)
    {
      QLog.e("AudienceRoomEnterExitModule", 1, "exitRoom failed currentInfo is null");
      return;
    }
    LeaveRoomReq localLeaveRoomReq = new LeaveRoomReq();
    localLeaveRoomReq.a = this.currentInfo.getRoomId();
    localLeaveRoomReq.b = ExitRoomType.UserLeave.ordinal();
    if (paramIQQLiveSDK == null)
    {
      QLog.e("AudienceRoomEnterExitModule", 1, "try exitRoom but liveSDK is null!");
      if (paramExitRoomCallback != null) {
        paramExitRoomCallback.onComplete(5108, "liveSDK is null");
      }
      return;
    }
    paramIQQLiveSDK = paramIQQLiveSDK.getExtModule("sso_module");
    if ((paramIQQLiveSDK instanceof IQQLiveSsoModule))
    {
      ((IQQLiveSsoModule)paramIQQLiveSDK).a("trpc.qlive.room_dispatch.RoomDispatch", "LeaveRoom", MessageNano.toByteArray(localLeaveRoomReq), new AudienceRoomEnterExitModule.2(this, paramExitRoomCallback));
      return;
    }
    QLog.e("AudienceRoomEnterExitModule", 1, "try exitRoom but ssoModule is null!");
    if (paramExitRoomCallback != null) {
      paramExitRoomCallback.onComplete(5108, "ssoModule is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.AudienceRoomEnterExitModule
 * JD-Core Version:    0.7.0.1
 */