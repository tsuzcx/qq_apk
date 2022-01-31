package com.tencent.mobileqq.forward;

import aphd;
import apih;
import apii;
import aply;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import tencent.im.oidb.oidb_0xd55.RspBody;

public class ForwardD55Manager$1$1
  implements Runnable
{
  public ForwardD55Manager$1$1(apii paramapii, int paramInt, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    aphd localaphd = new aphd(this.jdField_a_of_type_Int);
    oidb_0xd55.RspBody localRspBody = ForwardUtils.a(this.jdField_a_of_type_ArrayOfByte);
    if (localRspBody != null) {
      aphd.a(localRspBody, this.this$0.jdField_a_of_type_JavaLangString, localaphd);
    }
    ((aply)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(350)).a().a(this.this$0.jdField_a_of_type_Long, localaphd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardD55Manager.1.1
 * JD-Core Version:    0.7.0.1
 */