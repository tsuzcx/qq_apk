package com.tencent.mobileqq.qqlive.api.impl.message;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveAnnouncePushListener;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.push.api.IQQLivePushCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.ilive.commonNotify.commonNotify.nano.ExtData;
import com.tencent.trpcprotocol.qlive.live_lottery_server.announce.nano.AnnouncePushMsg;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

class QQLiveAnnounceMsgServiceImpl$1
  implements IQQLivePushCallback
{
  QQLiveAnnounceMsgServiceImpl$1(QQLiveAnnounceMsgServiceImpl paramQQLiveAnnounceMsgServiceImpl) {}
  
  public void onRecv(int paramInt, byte[] paramArrayOfByte, LiveMsgExtInfo paramLiveMsgExtInfo)
  {
    if (paramArrayOfByte != null) {}
    try
    {
      paramArrayOfByte = ExtData.a(paramArrayOfByte);
      if (paramArrayOfByte.a != 18)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("IQQLiveAnnounceMsgService", 4, "get LOW_PRIORITY_MESSAGE but not follow");
        return;
      }
      paramLiveMsgExtInfo = AnnouncePushMsg.a(paramArrayOfByte.c);
      paramArrayOfByte = new AnnouncePushMessage();
      paramArrayOfByte.roomId = paramLiveMsgExtInfo.a;
      paramArrayOfByte.uid = paramLiveMsgExtInfo.b;
      paramArrayOfByte.announce = paramLiveMsgExtInfo.c;
      paramLiveMsgExtInfo = QQLiveAnnounceMsgServiceImpl.access$000(this.this$0).iterator();
      while (paramLiveMsgExtInfo.hasNext()) {
        ((IQQLiveAnnouncePushListener)paramLiveMsgExtInfo.next()).a(paramArrayOfByte);
      }
    }
    catch (InvalidProtocolBufferNanoException paramArrayOfByte)
    {
      label111:
      break label111;
    }
    QLog.e("IQQLiveAnnounceMsgService", 4, "QQLive AnnouncePushMsg onReceive data parse fail");
    paramArrayOfByte = QQLiveAnnounceMsgServiceImpl.access$000(this.this$0).iterator();
    while (paramArrayOfByte.hasNext()) {
      ((IQQLiveAnnouncePushListener)paramArrayOfByte.next()).a(-1, "QQLive AnnouncePushMsg onReceive data parse fail");
    }
    QLog.e("IQQLiveAnnounceMsgService", 4, "QQLive AnnouncePushMsg onReceive data null");
    paramArrayOfByte = QQLiveAnnounceMsgServiceImpl.access$000(this.this$0).iterator();
    while (paramArrayOfByte.hasNext()) {
      ((IQQLiveAnnouncePushListener)paramArrayOfByte.next()).a(-1, "QQLive AnnouncePushMsg onReceive data null");
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.message.QQLiveAnnounceMsgServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */