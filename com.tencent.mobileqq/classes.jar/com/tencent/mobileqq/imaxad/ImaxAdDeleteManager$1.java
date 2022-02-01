package com.tencent.mobileqq.imaxad;

import avqp;
import avqu;
import com.tencent.mobileqq.app.QQAppInterface;
import oeq;

public class ImaxAdDeleteManager$1
  implements Runnable
{
  public ImaxAdDeleteManager$1(avqp paramavqp, oeq paramoeq, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    oeq localoeq2 = this.jdField_a_of_type_Oeq;
    oeq localoeq1 = localoeq2;
    if (localoeq2 == null) {
      localoeq1 = oeq.a(avqu.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_JavaLangString));
    }
    avqp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), localoeq1, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdDeleteManager.1
 * JD-Core Version:    0.7.0.1
 */