package com.tencent.mobileqq.widget;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class ArcImageView$2
  implements Runnable
{
  public void run()
  {
    MobileQQ localMobileQQ = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication();
    int i = SharedPreUtils.e(localMobileQQ);
    if (SharedPreUtils.a(localMobileQQ, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), i, this.jdField_a_of_type_JavaLangString))
    {
      SharedPreUtils.a(localMobileQQ, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), i, this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, this.jdField_a_of_type_JavaLangString + " close redDot");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ArcImageView.2
 * JD-Core Version:    0.7.0.1
 */