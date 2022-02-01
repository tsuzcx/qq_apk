package com.tencent.mobileqq.qassistant.wake;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class QQAssistantGuiderUtil
{
  public static final String a;
  private static boolean a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/tencent/MobileQQ/HelloQQCache/");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    jdField_a_of_type_Boolean = true;
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
    try
    {
      SharedPreferences.Editor localEditor = MobileQQ.sMobileQQ.getSharedPreferences("qq_assistant_sp_key", 0).edit();
      localEditor.putBoolean("need_open_guider", paramBoolean);
      localEditor.apply();
    }
    catch (Exception localException)
    {
      QLog.e("WakeManager", 4, localException.getMessage());
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setNeedOpenGuide:");
      localStringBuilder.append(jdField_a_of_type_Boolean);
      QLog.d("WakeManager", 2, localStringBuilder.toString());
    }
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_Boolean) {
      try
      {
        jdField_a_of_type_Boolean = MobileQQ.sMobileQQ.getSharedPreferences("qq_assistant_sp_key", 0).getBoolean("need_open_guider", true);
      }
      catch (Exception localException)
      {
        QLog.e("WakeManager", 4, localException.getMessage());
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getNeedOpenGuide:");
      localStringBuilder.append(jdField_a_of_type_Boolean);
      QLog.d("WakeManager", 2, localStringBuilder.toString());
    }
    return jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.QQAssistantGuiderUtil
 * JD-Core Version:    0.7.0.1
 */