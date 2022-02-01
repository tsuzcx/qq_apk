package com.tencent.mobileqq.qqlive.api.impl.message;

import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.push.api.IQQLivePushCallback;
import com.tencent.protobuf.newRoomsvrPushmsg.nano.PushUserEnterRoom;
import com.tencent.qphone.base.util.QLog;

class QQLiveEnterRoomServiceImpl$1
  implements IQQLivePushCallback
{
  QQLiveEnterRoomServiceImpl$1(QQLiveEnterRoomServiceImpl paramQQLiveEnterRoomServiceImpl) {}
  
  public void onRecv(int paramInt, byte[] paramArrayOfByte, LiveMsgExtInfo paramLiveMsgExtInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQLiveEnterRoomService", 1, "get 0xc8 enter room message push");
    }
    try
    {
      paramArrayOfByte = PushUserEnterRoom.a(paramArrayOfByte);
      if (paramArrayOfByte.a == null) {
        return;
      }
      if (paramArrayOfByte.c == 1) {
        QQLiveEnterRoomServiceImpl.access$200(this.this$0, QQLiveEnterRoomServiceImpl.access$000(this.this$0), paramArrayOfByte, QQLiveEnterRoomServiceImpl.access$100(this.this$0));
      }
      QQLiveEnterRoomServiceImpl.access$300(this.this$0, paramArrayOfByte, QQLiveEnterRoomServiceImpl.access$100(this.this$0));
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramLiveMsgExtInfo = new StringBuilder();
      paramLiveMsgExtInfo.append("get 0xc8 enter room message error msg is ");
      paramLiveMsgExtInfo.append(paramArrayOfByte.getMessage());
      QLog.e("QQLiveEnterRoomService", 1, paramLiveMsgExtInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.message.QQLiveEnterRoomServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */