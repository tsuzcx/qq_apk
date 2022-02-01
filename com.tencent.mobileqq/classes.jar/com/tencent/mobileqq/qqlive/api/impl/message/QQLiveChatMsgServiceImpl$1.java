package com.tencent.mobileqq.qqlive.api.impl.message;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveReceiveMessageListener;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.SpeakerInfo;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.push.api.IQQLivePushCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

class QQLiveChatMsgServiceImpl$1
  implements IQQLivePushCallback
{
  QQLiveChatMsgServiceImpl$1(QQLiveChatMsgServiceImpl paramQQLiveChatMsgServiceImpl, IQQLiveSDK paramIQQLiveSDK) {}
  
  public void onRecv(int paramInt, byte[] paramArrayOfByte, LiveMsgExtInfo paramLiveMsgExtInfo)
  {
    paramArrayOfByte = QQLiveChatMsgServiceImpl.access$000(this.this$0, paramArrayOfByte);
    long l = this.val$sdkImpl.getLoginModule().getLoginInfo().uid;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.mSpeakerInfo.mSpeakId == l) {
        return;
      }
      paramArrayOfByte.mMsgExtInfo = paramLiveMsgExtInfo;
      if (QLog.isColorLevel())
      {
        paramLiveMsgExtInfo = new StringBuilder();
        paramLiveMsgExtInfo.append("get 0x21 chat message push, speaker: ");
        paramLiveMsgExtInfo.append(paramArrayOfByte.mSpeakerInfo.mSpeakId);
        paramLiveMsgExtInfo.append("\n messageId = ");
        paramLiveMsgExtInfo.append(paramArrayOfByte.mMessageId);
        QLog.i("QQLiveChatMsgService", 4, paramLiveMsgExtInfo.toString());
      }
      paramLiveMsgExtInfo = QQLiveChatMsgServiceImpl.access$100(this.this$0).iterator();
      while (paramLiveMsgExtInfo.hasNext()) {
        ((IQQLiveReceiveMessageListener)paramLiveMsgExtInfo.next()).a(paramArrayOfByte);
      }
    }
    QLog.e("QQLiveChatMsgService", 4, "parse data failed!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.message.QQLiveChatMsgServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */