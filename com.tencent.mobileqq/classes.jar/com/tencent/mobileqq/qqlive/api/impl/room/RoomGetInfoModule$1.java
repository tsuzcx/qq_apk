package com.tencent.mobileqq.qqlive.api.impl.room;

import com.tencent.mobileqq.qqlive.callback.room.audience.GetRoomInfoCallback;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.mobileqq.qqlive.utils.LiveInfoProvider;
import com.tencent.qlive.iliveMetricsSvr.nano.GetRealTimeMetricsRsp;

class RoomGetInfoModule$1
  extends QQLiveBusinessObserver
{
  RoomGetInfoModule$1(RoomGetInfoModule paramRoomGetInfoModule, GetRoomInfoCallback paramGetRoomInfoCallback) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    if (paramBoolean) {
      try
      {
        paramQQLiveRspData = GetRealTimeMetricsRsp.a(paramQQLiveRspData.a());
        this.val$callback.a(LiveInfoProvider.a(paramQQLiveRspData));
        return;
      }
      catch (Exception paramQQLiveRspData)
      {
        this.val$callback.a(-1, paramQQLiveRspData.getMessage());
        return;
      }
    }
    this.val$callback.a(paramQQLiveRspData.c(), paramQQLiveRspData.e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.RoomGetInfoModule.1
 * JD-Core Version:    0.7.0.1
 */