package com.tencent.mobileqq.utils;

import awqx;
import bbmy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public final class QQUtils$2
  implements Runnable
{
  public QQUtils$2(boolean paramBoolean, QQAppInterface paramQQAppInterface, int paramInt, String paramString) {}
  
  public void run()
  {
    String str1 = null;
    if (this.jdField_a_of_type_Boolean) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131654069);
    }
    for (String str2 = "0";; str2 = "1")
    {
      if (str1 != null) {
        bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2, str1, 0).b(this.jdField_a_of_type_Int);
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Fast_launch", "Fast_launch_creat", 0, 0, this.jdField_a_of_type_JavaLangString, str2, "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQUtils.2
 * JD-Core Version:    0.7.0.1
 */