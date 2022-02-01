package com.tencent.mobileqq.imaxad;

import avfr;
import avfw;
import com.tencent.mobileqq.app.QQAppInterface;
import nuk;

public class ImaxAdDeleteManager$1
  implements Runnable
{
  public ImaxAdDeleteManager$1(avfr paramavfr, nuk paramnuk, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    nuk localnuk2 = this.jdField_a_of_type_Nuk;
    nuk localnuk1 = localnuk2;
    if (localnuk2 == null) {
      localnuk1 = nuk.a(avfw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_JavaLangString));
    }
    avfr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), localnuk1, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdDeleteManager.1
 * JD-Core Version:    0.7.0.1
 */