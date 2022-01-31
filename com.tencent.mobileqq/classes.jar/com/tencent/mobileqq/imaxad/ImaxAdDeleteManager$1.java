package com.tencent.mobileqq.imaxad;

import arda;
import ardf;
import com.tencent.mobileqq.app.QQAppInterface;
import niv;

public class ImaxAdDeleteManager$1
  implements Runnable
{
  public ImaxAdDeleteManager$1(arda paramarda, niv paramniv, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    niv localniv2 = this.jdField_a_of_type_Niv;
    niv localniv1 = localniv2;
    if (localniv2 == null) {
      localniv1 = niv.a(ardf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_JavaLangString));
    }
    arda.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), localniv1, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdDeleteManager.1
 * JD-Core Version:    0.7.0.1
 */