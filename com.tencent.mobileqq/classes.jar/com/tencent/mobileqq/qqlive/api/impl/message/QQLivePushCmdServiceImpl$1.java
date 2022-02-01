package com.tencent.mobileqq.qqlive.api.impl.message;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.push.api.IQQLivePushCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.ilive.commonNotify.commonNotify.nano.ExtData;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

class QQLivePushCmdServiceImpl$1
  implements IQQLivePushCallback
{
  QQLivePushCmdServiceImpl$1(QQLivePushCmdServiceImpl paramQQLivePushCmdServiceImpl) {}
  
  public void onRecv(int paramInt, byte[] paramArrayOfByte, LiveMsgExtInfo paramLiveMsgExtInfo)
  {
    if (paramArrayOfByte != null) {}
    try
    {
      paramArrayOfByte = ExtData.a(paramArrayOfByte);
      paramLiveMsgExtInfo = (CopyOnWriteArraySet)QQLivePushCmdServiceImpl.access$000(this.this$0).get(Integer.valueOf(paramArrayOfByte.a));
      if (paramLiveMsgExtInfo != null)
      {
        paramLiveMsgExtInfo = paramLiveMsgExtInfo.iterator();
        while (paramLiveMsgExtInfo.hasNext()) {
          ((IQQCmdPushCallback)paramLiveMsgExtInfo.next()).a(paramArrayOfByte.c);
        }
      }
      QLog.e("IQQLivePushCmdService", 4, "find this cmd get result null");
      return;
    }
    catch (InvalidProtocolBufferNanoException paramArrayOfByte)
    {
      label78:
      break label78;
    }
    QLog.e("IQQLivePushCmdService", 4, "parse data error");
    return;
    QLog.e("IQQLivePushCmdService", 4, "receive data null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.message.QQLivePushCmdServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */