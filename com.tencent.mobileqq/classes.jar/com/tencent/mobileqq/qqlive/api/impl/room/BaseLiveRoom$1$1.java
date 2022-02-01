package com.tencent.mobileqq.qqlive.api.impl.room;

import com.tencent.mobileqq.qqlive.anchor.util.QQLiveAnchorSSOHelper;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.pbexit_heart_list_room.nano.UserHeartBeatRsp;

class BaseLiveRoom$1$1
  extends QQLiveBusinessObserver
{
  BaseLiveRoom$1$1(BaseLiveRoom.1 param1) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("heart receive, type:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", success:");
      localStringBuilder.append(paramBoolean);
      QLog.d("BaseLiveRoom", 1, localStringBuilder.toString());
    }
    try
    {
      QQLiveAnchorSSOHelper.a(paramInt, paramBoolean, paramQQLiveRspData);
      paramQQLiveRspData = UserHeartBeatRsp.a(paramQQLiveRspData.a());
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("heart result:");
        localStringBuilder.append(paramQQLiveRspData.a);
        QLog.d("BaseLiveRoom", 1, localStringBuilder.toString());
      }
      if (paramQQLiveRspData.a > 0) {
        this.this$1.this$0.commonRoomHeartInterval = paramQQLiveRspData.a;
      }
    }
    catch (Throwable paramQQLiveRspData)
    {
      QLog.e("BaseLiveRoom", 1, "heart failed: ", paramQQLiveRspData);
    }
    BaseLiveRoom.access$000(this.this$1.this$0, this.this$1.this$0.commonRoomHeartInterval);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom.1.1
 * JD-Core Version:    0.7.0.1
 */