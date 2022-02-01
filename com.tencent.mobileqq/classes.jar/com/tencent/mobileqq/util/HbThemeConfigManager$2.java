package com.tencent.mobileqq.util;

import android.util.Base64;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class HbThemeConfigManager$2
  implements Runnable
{
  HbThemeConfigManager$2(HbThemeConfigManager paramHbThemeConfigManager, String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    synchronized ()
    {
      if (QLog.isColorLevel()) {
        QLog.d("HbThemeConfigManager", 2, "update hbTheme config: " + this.jdField_a_of_type_JavaLangString);
      }
      FileUtils.a(HbThemeConfigManager.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "hbThemeConfig.cfg", Base64.encodeToString(this.jdField_a_of_type_JavaLangString.getBytes(), 0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.HbThemeConfigManager.2
 * JD-Core Version:    0.7.0.1
 */