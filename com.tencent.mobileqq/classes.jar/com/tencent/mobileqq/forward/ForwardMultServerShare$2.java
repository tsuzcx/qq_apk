package com.tencent.mobileqq.forward;

import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import java.util.Map;

class ForwardMultServerShare$2
  implements Runnable
{
  ForwardMultServerShare$2(ForwardMultServerShare paramForwardMultServerShare, ResultRecord paramResultRecord, Map paramMap) {}
  
  public void run()
  {
    StructMsgForImageShare.sendAndUploadImageShare(ForwardMultServerShare.a(this.this$0), (StructMsgForImageShare)ForwardMultServerShare.a(this.this$0), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord.uin, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord.uinType, null, 0, new ForwardMultServerShare.2.1(this), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardMultServerShare.2
 * JD-Core Version:    0.7.0.1
 */