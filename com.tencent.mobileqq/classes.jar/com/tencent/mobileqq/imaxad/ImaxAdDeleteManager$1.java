package com.tencent.mobileqq.imaxad;

import auku;
import aukz;
import com.tencent.mobileqq.app.QQAppInterface;
import nxq;

public class ImaxAdDeleteManager$1
  implements Runnable
{
  public ImaxAdDeleteManager$1(auku paramauku, nxq paramnxq, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    nxq localnxq2 = this.jdField_a_of_type_Nxq;
    nxq localnxq1 = localnxq2;
    if (localnxq2 == null) {
      localnxq1 = nxq.a(aukz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_JavaLangString));
    }
    auku.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), localnxq1, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdDeleteManager.1
 * JD-Core Version:    0.7.0.1
 */