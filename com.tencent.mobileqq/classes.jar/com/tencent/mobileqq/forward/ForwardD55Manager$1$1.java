package com.tencent.mobileqq.forward;

import aupn;
import auql;
import auqm;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import tencent.im.oidb.oidb_0xd55.RspBody;

public class ForwardD55Manager$1$1
  implements Runnable
{
  public ForwardD55Manager$1$1(auqm paramauqm, byte[] paramArrayOfByte, int paramInt) {}
  
  public void run()
  {
    aupn localaupn = new aupn();
    oidb_0xd55.RspBody localRspBody = ForwardUtils.parseOIDBD55RspBody(this.jdField_a_of_type_ArrayOfByte);
    if (localRspBody != null) {
      aupn.a(localRspBody, this.jdField_a_of_type_Auqm.jdField_a_of_type_JavaLangString, localaupn);
    }
    auql.a(this.jdField_a_of_type_Auqm.jdField_a_of_type_Auql, this.jdField_a_of_type_Int);
    auql.a(this.jdField_a_of_type_Auqm.jdField_a_of_type_Auql, localaupn);
    this.jdField_a_of_type_Auqm.jdField_a_of_type_Auql.a(this.jdField_a_of_type_Auqm.jdField_a_of_type_Long, localaupn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardD55Manager.1.1
 * JD-Core Version:    0.7.0.1
 */