package com.tencent.mobileqq.forward;

import aqaq;
import aqbu;
import aqbv;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import tencent.im.oidb.oidb_0xd55.RspBody;

public class ForwardD55Manager$1$1
  implements Runnable
{
  public ForwardD55Manager$1$1(aqbv paramaqbv, byte[] paramArrayOfByte, int paramInt) {}
  
  public void run()
  {
    aqaq localaqaq = new aqaq();
    oidb_0xd55.RspBody localRspBody = ForwardUtils.a(this.jdField_a_of_type_ArrayOfByte);
    if (localRspBody != null) {
      aqaq.a(localRspBody, this.jdField_a_of_type_Aqbv.jdField_a_of_type_JavaLangString, localaqaq);
    }
    aqbu.a(this.jdField_a_of_type_Aqbv.jdField_a_of_type_Aqbu, this.jdField_a_of_type_Int);
    aqbu.a(this.jdField_a_of_type_Aqbv.jdField_a_of_type_Aqbu, localaqaq);
    this.jdField_a_of_type_Aqbv.jdField_a_of_type_Aqbu.a(this.jdField_a_of_type_Aqbv.jdField_a_of_type_Long, localaqaq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardD55Manager.1.1
 * JD-Core Version:    0.7.0.1
 */