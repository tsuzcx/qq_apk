package com.tencent.mobileqq.qqlive.api.impl.message;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener;
import com.tencent.mobileqq.qqlive.data.follow.FollowPushMessage;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.push.api.IQQLivePushCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.ilive.commonNotify.commonNotify.nano.ExtData;
import com.tencent.trpcprotocol.qlive.relationchain_svr.relationchain_svr.nano.LiveFollowPushMsg;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

class QQLiveFollowMsgServiceImpl$1
  implements IQQLivePushCallback
{
  QQLiveFollowMsgServiceImpl$1(QQLiveFollowMsgServiceImpl paramQQLiveFollowMsgServiceImpl) {}
  
  public void onRecv(int paramInt, byte[] paramArrayOfByte, LiveMsgExtInfo paramLiveMsgExtInfo)
  {
    if (paramArrayOfByte != null) {}
    try
    {
      paramArrayOfByte = ExtData.a(paramArrayOfByte);
      if (paramArrayOfByte.a != 19)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("IQQLiveFollowMsgService", 4, "get LOW_PRIORITY_MESSAGE but not follow");
        return;
      }
      paramLiveMsgExtInfo = LiveFollowPushMsg.a(paramArrayOfByte.c);
      paramArrayOfByte = new FollowPushMessage();
      paramArrayOfByte.uid = paramLiveMsgExtInfo.a;
      paramArrayOfByte.nick = paramLiveMsgExtInfo.b;
      paramArrayOfByte.toUid = paramLiveMsgExtInfo.c;
      paramArrayOfByte.icon = paramLiveMsgExtInfo.e;
      if (paramLiveMsgExtInfo.d == 0) {
        paramArrayOfByte.type = 0;
      } else {
        paramArrayOfByte.type = 1;
      }
      paramLiveMsgExtInfo = QQLiveFollowMsgServiceImpl.access$000(this.this$0).iterator();
      while (paramLiveMsgExtInfo.hasNext()) {
        ((IQQLiveReceiveFollowListener)paramLiveMsgExtInfo.next()).a(paramArrayOfByte);
      }
    }
    catch (InvalidProtocolBufferNanoException paramArrayOfByte)
    {
      label139:
      break label139;
    }
    QLog.e("IQQLiveFollowMsgService", 4, "QQLive LiveFollowPushMsg onReceive data parse fail");
    paramArrayOfByte = QQLiveFollowMsgServiceImpl.access$000(this.this$0).iterator();
    while (paramArrayOfByte.hasNext()) {
      ((IQQLiveReceiveFollowListener)paramArrayOfByte.next()).a(-1, "QQLive LiveFollowPushMsg onReceive data parse fail");
    }
    QLog.e("IQQLiveFollowMsgService", 4, "followPushReceiver get push data null");
    paramArrayOfByte = QQLiveFollowMsgServiceImpl.access$000(this.this$0).iterator();
    while (paramArrayOfByte.hasNext()) {
      ((IQQLiveReceiveFollowListener)paramArrayOfByte.next()).a(-1, "followPushReceiver get push data null");
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.message.QQLiveFollowMsgServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */