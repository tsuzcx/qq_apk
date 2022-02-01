package com.tencent.mobileqq.forward;

import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class ForwardSDKB77Sender$1
  implements UpCallBack
{
  ForwardSDKB77Sender$1(ForwardSDKB77Sender paramForwardSDKB77Sender, Bundle paramBundle, long paramLong) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upCallBack updateMsg info =");
    if (paramSendResult == null) {
      paramSendResult = "null";
    } else {
      paramSendResult = paramSendResult.toString();
    }
    localStringBuilder.append(paramSendResult);
    QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, localStringBuilder.toString());
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "upCallBack onSend result=", paramSendResult });
    ForwardSDKB77Sender.a(this.c, paramSendResult, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSDKB77Sender.1
 * JD-Core Version:    0.7.0.1
 */