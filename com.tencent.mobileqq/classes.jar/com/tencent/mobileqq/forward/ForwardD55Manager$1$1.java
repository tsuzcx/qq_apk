package com.tencent.mobileqq.forward;

import atks;
import atlq;
import atlr;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import tencent.im.oidb.oidb_0xd55.RspBody;

public class ForwardD55Manager$1$1
  implements Runnable
{
  public ForwardD55Manager$1$1(atlr paramatlr, byte[] paramArrayOfByte, int paramInt) {}
  
  public void run()
  {
    atks localatks = new atks();
    oidb_0xd55.RspBody localRspBody = ForwardUtils.parseOIDBD55RspBody(this.jdField_a_of_type_ArrayOfByte);
    if (localRspBody != null) {
      atks.a(localRspBody, this.jdField_a_of_type_Atlr.jdField_a_of_type_JavaLangString, localatks);
    }
    atlq.a(this.jdField_a_of_type_Atlr.jdField_a_of_type_Atlq, this.jdField_a_of_type_Int);
    atlq.a(this.jdField_a_of_type_Atlr.jdField_a_of_type_Atlq, localatks);
    this.jdField_a_of_type_Atlr.jdField_a_of_type_Atlq.a(this.jdField_a_of_type_Atlr.jdField_a_of_type_Long, localatks);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardD55Manager.1.1
 * JD-Core Version:    0.7.0.1
 */