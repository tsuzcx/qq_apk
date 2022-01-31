package com.tencent.mobileqq.imaxad;

import ardc;
import ardh;
import com.tencent.mobileqq.app.QQAppInterface;
import nis;

public class ImaxAdDeleteManager$1
  implements Runnable
{
  public ImaxAdDeleteManager$1(ardc paramardc, nis paramnis, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    nis localnis2 = this.jdField_a_of_type_Nis;
    nis localnis1 = localnis2;
    if (localnis2 == null) {
      localnis1 = nis.a(ardh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_JavaLangString));
    }
    ardc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), localnis1, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdDeleteManager.1
 * JD-Core Version:    0.7.0.1
 */