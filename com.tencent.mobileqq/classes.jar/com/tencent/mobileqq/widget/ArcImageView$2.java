package com.tencent.mobileqq.widget;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

class ArcImageView$2
  implements Runnable
{
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication();
    int i = SharedPreUtils.e((Context)localObject);
    if (SharedPreUtils.a((Context)localObject, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), i, this.jdField_a_of_type_JavaLangString))
    {
      SharedPreUtils.a((Context)localObject, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), i, this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append(" close redDot");
        QLog.d("Q.recent", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ArcImageView.2
 * JD-Core Version:    0.7.0.1
 */