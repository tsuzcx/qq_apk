package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

final class QQUtils$2
  implements Runnable
{
  QQUtils$2(boolean paramBoolean, QQAppInterface paramQQAppInterface, int paramInt, String paramString) {}
  
  public void run()
  {
    String str1;
    String str2;
    if (this.jdField_a_of_type_Boolean)
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131719390);
      str2 = "0";
    }
    else
    {
      str1 = null;
      str2 = "1";
    }
    if (str1 != null) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2, str1, 0).b(this.jdField_a_of_type_Int);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Fast_launch", "Fast_launch_creat", 0, 0, this.jdField_a_of_type_JavaLangString, str2, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQUtils.2
 * JD-Core Version:    0.7.0.1
 */