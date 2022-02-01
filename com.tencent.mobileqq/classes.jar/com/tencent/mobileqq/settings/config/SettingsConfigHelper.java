package com.tencent.mobileqq.settings.config;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class SettingsConfigHelper
{
  private static long jdField_a_of_type_Long = 0L;
  private static boolean jdField_a_of_type_Boolean = false;
  
  public static void a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setUseNewSettings useNewSettings=%s ");
    localStringBuilder.append(paramBoolean);
    QLog.d("SettingsConfigHelper", 1, localStringBuilder.toString());
    if (paramAppInterface == null) {
      return;
    }
    paramAppInterface = paramAppInterface.getPreferences().edit();
    paramAppInterface.putBoolean("sp_key_use_new_settings", paramBoolean);
    paramAppInterface.apply();
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    if (paramAppInterface != null)
    {
      long l = paramAppInterface.getLongAccountUin();
      if (jdField_a_of_type_Long != l)
      {
        jdField_a_of_type_Boolean = paramAppInterface.getPreferences().getBoolean("sp_key_use_new_settings", false);
        jdField_a_of_type_Long = l;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SettingsConfigHelper", 2, String.format("getUseNewSettings init useNewSettings=%s", new Object[] { Boolean.valueOf(jdField_a_of_type_Boolean) }));
    }
    return jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.config.SettingsConfigHelper
 * JD-Core Version:    0.7.0.1
 */