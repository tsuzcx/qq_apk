package com.tencent.mobileqq.forward;

import arua;
import arve;
import arvf;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import tencent.im.oidb.oidb_0xd55.RspBody;

public class ForwardD55Manager$1$1
  implements Runnable
{
  public ForwardD55Manager$1$1(arvf paramarvf, byte[] paramArrayOfByte, int paramInt) {}
  
  public void run()
  {
    arua localarua = new arua();
    oidb_0xd55.RspBody localRspBody = ForwardUtils.a(this.jdField_a_of_type_ArrayOfByte);
    if (localRspBody != null) {
      arua.a(localRspBody, this.jdField_a_of_type_Arvf.jdField_a_of_type_JavaLangString, localarua);
    }
    arve.a(this.jdField_a_of_type_Arvf.jdField_a_of_type_Arve, this.jdField_a_of_type_Int);
    arve.a(this.jdField_a_of_type_Arvf.jdField_a_of_type_Arve, localarua);
    this.jdField_a_of_type_Arvf.jdField_a_of_type_Arve.a(this.jdField_a_of_type_Arvf.jdField_a_of_type_Long, localarua);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardD55Manager.1.1
 * JD-Core Version:    0.7.0.1
 */