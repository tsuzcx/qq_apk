package com.tencent.mobileqq.widget;

import bhsi;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class ArcImageView$1
  implements Runnable
{
  public void run()
  {
    MobileQQ localMobileQQ = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication();
    int i = bhsi.d(localMobileQQ);
    boolean bool = bhsi.a(localMobileQQ, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), i, this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, this.jdField_a_of_type_JavaLangString + " show redDot: " + bool);
    }
    this.this$0.a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ArcImageView.1
 * JD-Core Version:    0.7.0.1
 */