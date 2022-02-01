package com.tencent.mobileqq.forward;

import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class ForwardSDKB77Sender$5
  implements UpCallBack
{
  ForwardSDKB77Sender$5(ForwardSDKB77Sender paramForwardSDKB77Sender, Bundle paramBundle, long paramLong) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("upCallBack updateMsg info =");
    if (paramSendResult == null) {}
    for (paramSendResult = "null";; paramSendResult = paramSendResult.toString())
    {
      QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, paramSendResult);
      return;
    }
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "upCallBack onSend result=", paramSendResult });
    ForwardSDKB77Sender.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSDKB77Sender, paramSendResult, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSDKB77Sender.5
 * JD-Core Version:    0.7.0.1
 */