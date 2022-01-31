package com.tencent.mobileqq.util;

import android.util.Base64;
import bazb;
import bbdx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class HbThemeConfigManager$2
  implements Runnable
{
  public HbThemeConfigManager$2(bazb parambazb, String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    synchronized ()
    {
      if (QLog.isColorLevel()) {
        QLog.d("HbThemeConfigManager", 2, "update hbTheme config: " + this.jdField_a_of_type_JavaLangString);
      }
      bbdx.a(bazb.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "hbThemeConfig.cfg", Base64.encodeToString(this.jdField_a_of_type_JavaLangString.getBytes(), 0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.util.HbThemeConfigManager.2
 * JD-Core Version:    0.7.0.1
 */