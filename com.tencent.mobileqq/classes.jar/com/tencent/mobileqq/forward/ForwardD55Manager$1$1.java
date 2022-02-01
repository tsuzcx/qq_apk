package com.tencent.mobileqq.forward;

import auxp;
import auym;
import auyn;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import tencent.im.oidb.oidb_0xd55.RspBody;

public class ForwardD55Manager$1$1
  implements Runnable
{
  public ForwardD55Manager$1$1(auyn paramauyn, byte[] paramArrayOfByte, int paramInt) {}
  
  public void run()
  {
    auxp localauxp = new auxp();
    oidb_0xd55.RspBody localRspBody = ForwardUtils.a(this.jdField_a_of_type_ArrayOfByte);
    if (localRspBody != null) {
      auxp.a(localRspBody, this.jdField_a_of_type_Auyn.jdField_a_of_type_JavaLangString, localauxp);
    }
    auym.a(this.jdField_a_of_type_Auyn.jdField_a_of_type_Auym, this.jdField_a_of_type_Int);
    auym.a(this.jdField_a_of_type_Auyn.jdField_a_of_type_Auym, localauxp);
    this.jdField_a_of_type_Auyn.jdField_a_of_type_Auym.a(this.jdField_a_of_type_Auyn.jdField_a_of_type_Long, localauxp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardD55Manager.1.1
 * JD-Core Version:    0.7.0.1
 */