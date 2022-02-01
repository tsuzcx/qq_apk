package com.tencent.mobileqq.qqlive.anchor.room;

import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperFastResume;
import com.tencent.mobileqq.qqlive.anchor.util.QQLiveAnchorSSOHelper;
import com.tencent.mobileqq.qqlive.anchor.util.QQLiveAnchorThrowable;
import com.tencent.mobileqq.qqlive.api.anchor.QQLiveAnchorRoomState;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPublishStream;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.StartNewRsp;

class QQLiveAnchorRoom$5
  extends QQLiveBusinessObserver
{
  QQLiveAnchorRoom$5(QQLiveAnchorRoom paramQQLiveAnchorRoom) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    if (!QQLiveAnchorRoom.f(this.a))
    {
      if (this.a.e != QQLiveAnchorRoomState.STATE_PUBLISH_ING) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("push stream recieve, type:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", success:");
        localStringBuilder.append(paramBoolean);
        QLog.d("QQLiveAnchor_BaseRoom", 1, localStringBuilder.toString());
      }
      try
      {
        QQLiveAnchorSSOHelper.a(paramInt, paramBoolean, paramQQLiveRspData);
        paramQQLiveRspData = StartNewRsp.a(paramQQLiveRspData.a());
        if (paramQQLiveRspData.a == 0)
        {
          this.a.a(QQLiveAnchorRoomState.STATE_PUBLISH_READY);
          this.a.d.a(new QQLiveAnchorDataPublishStream(true, null));
          this.a.a(QQLiveAnchorRoomState.STATE_LIVE_ING);
          this.a.j.a(this.a.a, this.a);
          QQLiveAnchorRoom.a(this.a, this.a.l);
          return;
        }
        throw new QQLiveAnchorThrowable("push stream rsp error", paramQQLiveRspData.a, "");
      }
      catch (Throwable paramQQLiveRspData)
      {
        QLog.e("QQLiveAnchor_BaseRoom", 1, "push stream error:", paramQQLiveRspData);
        this.a.a(QQLiveAnchorRoomState.STATE_PUBLISH_FAILED);
        paramQQLiveRspData = QQLiveAnchorThrowable.covert(6260, paramQQLiveRspData);
        this.a.d.a(new QQLiveAnchorDataPublishStream(false, paramQQLiveRspData));
        this.a.d.a(paramQQLiveRspData);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom.5
 * JD-Core Version:    0.7.0.1
 */