package com.tencent.mobileqq.qqlive.anchor.room;

import com.tencent.mobileqq.qqlive.anchor.util.QQLiveAnchorSSOHelper;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.protobuf.MediaHeartBeat.nano.SendHeartBeatRsp;

class QQLiveAnchorRoom$1$1
  extends QQLiveBusinessObserver
{
  QQLiveAnchorRoom$1$1(QQLiveAnchorRoom.1 param1) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    try
    {
      QQLiveAnchorSSOHelper.a(paramInt, paramBoolean, paramQQLiveRspData);
      paramQQLiveRspData = SendHeartBeatRsp.a(paramQQLiveRspData.a());
      if (paramQQLiveRspData.a == 0)
      {
        if (paramQQLiveRspData.b > 0) {
          this.a.this$0.l = (paramQQLiveRspData.b * 1000);
        }
        this.a.this$0.p = 0L;
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("heart result error: ");
        localStringBuilder.append(paramQQLiveRspData.a);
        localStringBuilder.append(", ");
        localStringBuilder.append(paramQQLiveRspData.b);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
    catch (Throwable paramQQLiveRspData)
    {
      QLog.e("QQLiveAnchor_BaseRoom", 1, "heart failed: ", paramQQLiveRspData);
      QQLiveAnchorRoom.c(this.a.this$0);
      QQLiveAnchorRoom.a(this.a.this$0, this.a.this$0.l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom.1.1
 * JD-Core Version:    0.7.0.1
 */