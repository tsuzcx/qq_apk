package com.tencent.mobileqq.qqlive.anchor.room;

import com.tencent.mobileqq.qqlive.callback.room.audience.RoomInfoListener;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.push.api.IQQLivePushCallback;
import com.tencent.mobileqq.qqlive.utils.LiveInfoProvider;
import com.tencent.qlive.iliveMetricsSvr.nano.GetRealTimeMetricsRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class RoomInfoService$1
  implements IQQLivePushCallback
{
  RoomInfoService$1(RoomInfoService paramRoomInfoService) {}
  
  public void onRecv(int paramInt, byte[] paramArrayOfByte, LiveMsgExtInfo paramLiveMsgExtInfo)
  {
    try
    {
      paramArrayOfByte = LiveInfoProvider.a(GetRealTimeMetricsRsp.a(paramArrayOfByte));
      paramLiveMsgExtInfo = RoomInfoService.a(this.a).iterator();
      while (paramLiveMsgExtInfo.hasNext()) {
        ((RoomInfoListener)paramLiveMsgExtInfo.next()).a(paramArrayOfByte);
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramLiveMsgExtInfo = new StringBuilder();
      paramLiveMsgExtInfo.append("onRecv info error ");
      paramLiveMsgExtInfo.append(paramArrayOfByte.getMessage());
      QLog.e("AudienceRoomInfoModule", 1, paramLiveMsgExtInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.RoomInfoService.1
 * JD-Core Version:    0.7.0.1
 */