package com.tencent.mobileqq.forward;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import tencent.im.msg.im_msg_body.RichText;

class ForwardMultServerShare$2$1
  implements UpCallBack
{
  ForwardMultServerShare$2$1(ForwardMultServerShare.2 param2) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult != null) {
      QLog.d(ForwardMultServerShare.a(), 1, "requestImageShare updateMsg info =" + paramSendResult);
    }
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    this.a.jdField_a_of_type_JavaUtilMap.put(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord, paramSendResult);
    QLog.d(ForwardMultServerShare.a(), 1, new Object[] { "requestImageShare onSend result =", paramSendResult, ", isTimeOut=", Boolean.valueOf(ForwardMultServerShare.a(this.a.this$0)) });
    if (this.a.jdField_a_of_type_JavaUtilMap.size() == ForwardMultServerShare.a(this.a.this$0).size())
    {
      ForwardStatisticsReporter.b("KEY_STAGE_2_UPLOAD_IMAGE_MULT");
      ForwardMultServerShare.a(this.a.this$0, this.a.jdField_a_of_type_JavaUtilMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardMultServerShare.2.1
 * JD-Core Version:    0.7.0.1
 */