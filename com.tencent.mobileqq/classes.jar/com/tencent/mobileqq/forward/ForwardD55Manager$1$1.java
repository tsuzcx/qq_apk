package com.tencent.mobileqq.forward;

import aufu;
import augp;
import augq;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import tencent.im.oidb.oidb_0xd55.RspBody;

public class ForwardD55Manager$1$1
  implements Runnable
{
  public ForwardD55Manager$1$1(augq paramaugq, byte[] paramArrayOfByte, int paramInt) {}
  
  public void run()
  {
    aufu localaufu = new aufu();
    oidb_0xd55.RspBody localRspBody = ForwardUtils.a(this.jdField_a_of_type_ArrayOfByte);
    if (localRspBody != null) {
      aufu.a(localRspBody, this.jdField_a_of_type_Augq.jdField_a_of_type_JavaLangString, localaufu);
    }
    augp.a(this.jdField_a_of_type_Augq.jdField_a_of_type_Augp, this.jdField_a_of_type_Int);
    augp.a(this.jdField_a_of_type_Augq.jdField_a_of_type_Augp, localaufu);
    this.jdField_a_of_type_Augq.jdField_a_of_type_Augp.a(this.jdField_a_of_type_Augq.jdField_a_of_type_Long, localaufu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardD55Manager.1.1
 * JD-Core Version:    0.7.0.1
 */