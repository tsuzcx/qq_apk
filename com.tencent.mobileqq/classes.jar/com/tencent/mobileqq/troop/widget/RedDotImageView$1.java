package com.tencent.mobileqq.troop.widget;

import bdne;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class RedDotImageView$1
  implements Runnable
{
  public void run()
  {
    MobileQQ localMobileQQ = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication();
    int i = bdne.e(localMobileQQ);
    boolean bool = bdne.a(localMobileQQ, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), i, this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, this.jdField_a_of_type_JavaLangString + " show redDot: " + bool);
    }
    this.this$0.a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RedDotImageView.1
 * JD-Core Version:    0.7.0.1
 */