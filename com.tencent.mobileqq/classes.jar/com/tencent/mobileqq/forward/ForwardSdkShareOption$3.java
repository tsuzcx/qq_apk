package com.tencent.mobileqq.forward;

import apln;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;

public class ForwardSdkShareOption$3
  implements Runnable
{
  public ForwardSdkShareOption$3(apln paramapln, AbsStructMsg paramAbsStructMsg, String paramString, int paramInt) {}
  
  public void run()
  {
    StructMsgForImageShare.sendAndUploadImageShare(this.this$0.a, (StructMsgForImageShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkShareOption.3
 * JD-Core Version:    0.7.0.1
 */