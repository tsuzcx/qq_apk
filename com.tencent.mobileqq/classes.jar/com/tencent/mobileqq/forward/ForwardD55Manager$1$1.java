package com.tencent.mobileqq.forward;

import aqas;
import aqbw;
import aqbx;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import tencent.im.oidb.oidb_0xd55.RspBody;

public class ForwardD55Manager$1$1
  implements Runnable
{
  public ForwardD55Manager$1$1(aqbx paramaqbx, byte[] paramArrayOfByte, int paramInt) {}
  
  public void run()
  {
    aqas localaqas = new aqas();
    oidb_0xd55.RspBody localRspBody = ForwardUtils.a(this.jdField_a_of_type_ArrayOfByte);
    if (localRspBody != null) {
      aqas.a(localRspBody, this.jdField_a_of_type_Aqbx.jdField_a_of_type_JavaLangString, localaqas);
    }
    aqbw.a(this.jdField_a_of_type_Aqbx.jdField_a_of_type_Aqbw, this.jdField_a_of_type_Int);
    aqbw.a(this.jdField_a_of_type_Aqbx.jdField_a_of_type_Aqbw, localaqas);
    this.jdField_a_of_type_Aqbx.jdField_a_of_type_Aqbw.a(this.jdField_a_of_type_Aqbx.jdField_a_of_type_Long, localaqas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardD55Manager.1.1
 * JD-Core Version:    0.7.0.1
 */