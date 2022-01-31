package com.tencent.mobileqq.imaxad;

import astq;
import astv;
import com.tencent.mobileqq.app.QQAppInterface;
import nlo;

public class ImaxAdDeleteManager$1
  implements Runnable
{
  public ImaxAdDeleteManager$1(astq paramastq, nlo paramnlo, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    nlo localnlo2 = this.jdField_a_of_type_Nlo;
    nlo localnlo1 = localnlo2;
    if (localnlo2 == null) {
      localnlo1 = nlo.a(astv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_JavaLangString));
    }
    astq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), localnlo1, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdDeleteManager.1
 * JD-Core Version:    0.7.0.1
 */