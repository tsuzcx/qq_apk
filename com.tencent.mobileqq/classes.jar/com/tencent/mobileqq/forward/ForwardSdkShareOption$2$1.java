package com.tencent.mobileqq.forward;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class ForwardSdkShareOption$2$1
  implements UpCallBack
{
  ForwardSdkShareOption$2$1(ForwardSdkShareOption.2 param2) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    if ((paramSendResult != null) && (QLog.isColorLevel())) {
      QLog.d("ForwardOption.ForwardSdkShareOption", 2, new Object[] { "upCallBack updateMsg info =", paramSendResult.toString() });
    }
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    ForwardStatisticsReporter.b("KEY_STAGE_2_UPLOAD_IMAGE");
    ForwardSdkShareOption.a(this.a.this$0, this.a.this$0.a, paramSendResult, this.a.b, this.a.c, this.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkShareOption.2.1
 * JD-Core Version:    0.7.0.1
 */