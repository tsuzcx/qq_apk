package com.tencent.mobileqq.imaxad;

import aqiv;
import aqja;
import com.tencent.mobileqq.app.QQAppInterface;
import mxu;

public class ImaxAdDeleteManager$1
  implements Runnable
{
  public ImaxAdDeleteManager$1(aqiv paramaqiv, mxu parammxu, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    mxu localmxu2 = this.jdField_a_of_type_Mxu;
    mxu localmxu1 = localmxu2;
    if (localmxu2 == null) {
      localmxu1 = mxu.a(aqja.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_JavaLangString));
    }
    aqiv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), localmxu1, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdDeleteManager.1
 * JD-Core Version:    0.7.0.1
 */