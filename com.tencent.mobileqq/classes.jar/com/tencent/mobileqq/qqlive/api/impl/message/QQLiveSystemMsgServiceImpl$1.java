package com.tencent.mobileqq.qqlive.api.impl.message;

import android.text.TextUtils;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.livechatcheck.nano.PushMsg_SystemNotice;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveReceiveMessageListener;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.push.api.IQQLivePushCallback;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

class QQLiveSystemMsgServiceImpl$1
  implements IQQLivePushCallback
{
  QQLiveSystemMsgServiceImpl$1(QQLiveSystemMsgServiceImpl paramQQLiveSystemMsgServiceImpl) {}
  
  public void onRecv(int paramInt, byte[] paramArrayOfByte, LiveMsgExtInfo paramLiveMsgExtInfo)
  {
    if (paramInt == 255)
    {
      if (paramArrayOfByte == null) {
        return;
      }
      try
      {
        String str = new String(PushMsg_SystemNotice.a(paramArrayOfByte).b, Charset.forName("UTF-8"));
        if (!TextUtils.isEmpty(str))
        {
          paramArrayOfByte = new LiveMessageData();
          paramArrayOfByte.mMessageType = 4;
          paramArrayOfByte.mRawTipStr = str;
          paramArrayOfByte.mMsgExtInfo = paramLiveMsgExtInfo;
          paramLiveMsgExtInfo = QQLiveSystemMsgServiceImpl.access$000(this.this$0).iterator();
          while (paramLiveMsgExtInfo.hasNext()) {
            ((IQQLiveReceiveMessageListener)paramLiveMsgExtInfo.next()).a(paramArrayOfByte);
          }
        }
        return;
      }
      catch (InvalidProtocolBufferNanoException paramArrayOfByte)
      {
        paramLiveMsgExtInfo = new StringBuilder();
        paramLiveMsgExtInfo.append("initSystemNoticeMsgListener error:");
        paramLiveMsgExtInfo.append(paramArrayOfByte.getMessage());
        QLog.e("QQLiveSystemMsgService", 1, paramLiveMsgExtInfo.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.message.QQLiveSystemMsgServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */