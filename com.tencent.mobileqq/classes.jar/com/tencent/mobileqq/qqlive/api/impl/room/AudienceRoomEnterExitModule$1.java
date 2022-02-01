package com.tencent.mobileqq.qqlive.api.impl.room;

import com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback;
import com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo;
import com.tencent.mobileqq.qqlive.sso.BaseSsoCallback;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.mobileqq.qqlive.utils.LiveInfoProvider;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.roomAccess.nano.EnterRoomReply;

class AudienceRoomEnterExitModule$1
  extends BaseSsoCallback
{
  AudienceRoomEnterExitModule$1(AudienceRoomEnterExitModule paramAudienceRoomEnterExitModule, EnterRoomInfo paramEnterRoomInfo, EnterAudienceRoomCallback paramEnterAudienceRoomCallback) {}
  
  private void callFailed(int paramInt, String paramString)
  {
    if (this.val$roomInfo.getRoomId() != this.this$0.currentInfo.getRoomId())
    {
      QLog.e("AudienceRoomEnterExitModule", 1, "this response is not match currentRoom");
      return;
    }
    EnterAudienceRoomCallback localEnterAudienceRoomCallback = this.val$callback;
    if (localEnterAudienceRoomCallback != null) {
      localEnterAudienceRoomCallback.onFailed(paramInt, paramString);
    }
  }
  
  public void onBusinessFailed(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterRoom businessFailed:");
    localStringBuilder.append(paramInt);
    QLog.e("AudienceRoomEnterExitModule", 1, localStringBuilder.toString());
    callFailed(paramInt, paramString);
  }
  
  public void onFailed(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterRoom failed:");
    localStringBuilder.append(paramInt);
    QLog.e("AudienceRoomEnterExitModule", 1, localStringBuilder.toString());
    callFailed(paramInt, paramString);
  }
  
  public void onProxyRequestSuccess(int paramInt, QQLiveRspData paramQQLiveRspData)
  {
    if (this.val$roomInfo.getRoomId() != this.this$0.currentInfo.getRoomId())
    {
      QLog.e("AudienceRoomEnterExitModule", 1, "this response is not match currentRoom");
      return;
    }
    try
    {
      paramQQLiveRspData = LiveInfoProvider.a(EnterRoomReply.a(paramQQLiveRspData.a()));
      this.this$0.liveInfo = paramQQLiveRspData;
      this.val$callback.onSuccess(paramQQLiveRspData);
      return;
    }
    catch (Exception paramQQLiveRspData)
    {
      this.val$callback.onFailed(-3301, paramQQLiveRspData.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.AudienceRoomEnterExitModule.1
 * JD-Core Version:    0.7.0.1
 */