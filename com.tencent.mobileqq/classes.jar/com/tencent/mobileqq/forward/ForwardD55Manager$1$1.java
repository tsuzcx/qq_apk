package com.tencent.mobileqq.forward;

import aryj;
import arzn;
import arzo;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import tencent.im.oidb.oidb_0xd55.RspBody;

public class ForwardD55Manager$1$1
  implements Runnable
{
  public ForwardD55Manager$1$1(arzo paramarzo, byte[] paramArrayOfByte, int paramInt) {}
  
  public void run()
  {
    aryj localaryj = new aryj();
    oidb_0xd55.RspBody localRspBody = ForwardUtils.a(this.jdField_a_of_type_ArrayOfByte);
    if (localRspBody != null) {
      aryj.a(localRspBody, this.jdField_a_of_type_Arzo.jdField_a_of_type_JavaLangString, localaryj);
    }
    arzn.a(this.jdField_a_of_type_Arzo.jdField_a_of_type_Arzn, this.jdField_a_of_type_Int);
    arzn.a(this.jdField_a_of_type_Arzo.jdField_a_of_type_Arzn, localaryj);
    this.jdField_a_of_type_Arzo.jdField_a_of_type_Arzn.a(this.jdField_a_of_type_Arzo.jdField_a_of_type_Long, localaryj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardD55Manager.1.1
 * JD-Core Version:    0.7.0.1
 */