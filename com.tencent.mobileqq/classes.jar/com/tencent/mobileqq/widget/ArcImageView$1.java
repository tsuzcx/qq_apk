package com.tencent.mobileqq.widget;

import bbkb;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class ArcImageView$1
  implements Runnable
{
  public void run()
  {
    MobileQQ localMobileQQ = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication();
    int i = bbkb.e(localMobileQQ);
    boolean bool = bbkb.a(localMobileQQ, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), i, this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, this.jdField_a_of_type_JavaLangString + " show redDot: " + bool);
    }
    this.this$0.a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ArcImageView.1
 * JD-Core Version:    0.7.0.1
 */