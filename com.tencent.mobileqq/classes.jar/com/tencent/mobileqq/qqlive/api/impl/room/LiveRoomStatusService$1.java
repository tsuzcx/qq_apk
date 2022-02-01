package com.tencent.mobileqq.qqlive.api.impl.room;

import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.push.api.IQQLivePushCallback;
import com.tencent.mobileqq.qqlive.utils.IOUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.push.ProtocolVideoState.nano.RoomVideoStateBroadcast;
import java.io.ByteArrayInputStream;

class LiveRoomStatusService$1
  implements IQQLivePushCallback
{
  LiveRoomStatusService$1(LiveRoomStatusService paramLiveRoomStatusService) {}
  
  public void onRecv(int paramInt, byte[] paramArrayOfByte, LiveMsgExtInfo paramLiveMsgExtInfo)
  {
    try
    {
      paramArrayOfByte = IOUtil.b(new ByteArrayInputStream(paramArrayOfByte), true);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
      {
        LiveRoomStatusService.access$000(this.this$0, RoomVideoStateBroadcast.a(paramArrayOfByte));
        return;
      }
      QLog.e("AudienceRoomStatusModule", 1, "onRecv status error data == null");
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramLiveMsgExtInfo = new StringBuilder();
      paramLiveMsgExtInfo.append("onRecv status error ");
      paramLiveMsgExtInfo.append(paramArrayOfByte.getMessage());
      QLog.e("AudienceRoomStatusModule", 1, paramLiveMsgExtInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.LiveRoomStatusService.1
 * JD-Core Version:    0.7.0.1
 */