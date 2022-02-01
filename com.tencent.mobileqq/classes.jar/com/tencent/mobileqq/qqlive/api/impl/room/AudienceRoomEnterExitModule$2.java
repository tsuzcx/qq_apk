package com.tencent.mobileqq.qqlive.api.impl.room;

import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qphone.base.util.QLog;

class AudienceRoomEnterExitModule$2
  extends QQLiveBusinessObserver
{
  AudienceRoomEnterExitModule$2(AudienceRoomEnterExitModule paramAudienceRoomEnterExitModule, ExitRoomCallback paramExitRoomCallback) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    if (paramBoolean)
    {
      paramQQLiveRspData = this.val$callback;
      if (paramQQLiveRspData != null) {
        paramQQLiveRspData.onComplete(0, "");
      }
      QLog.d("AudienceRoomEnterExitModule", 1, "exitRoom success id");
      return;
    }
    Object localObject = this.val$callback;
    if (localObject != null) {
      ((ExitRoomCallback)localObject).onComplete(5108, "sso return failed");
    }
    if (paramQQLiveRspData != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("exitRoom failed code is ");
      ((StringBuilder)localObject).append(paramQQLiveRspData.c());
      ((StringBuilder)localObject).append(" msg is ");
      ((StringBuilder)localObject).append(paramQQLiveRspData.e());
      QLog.e("AudienceRoomEnterExitModule", 1, ((StringBuilder)localObject).toString());
      return;
    }
    QLog.e("AudienceRoomEnterExitModule", 1, "RspData is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.AudienceRoomEnterExitModule.2
 * JD-Core Version:    0.7.0.1
 */