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
  private static boolean b = true;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/tencent/MobileQQ/HelloQQCache/");
    a = localStringBuilder.toString();
  }
  
  public static void a(boolean paramBoolean)
  {
    b = paramBoolean;
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
      localStringBuilder.append(b);
      QLog.d("WakeManager", 2, localStringBuilder.toString());
    }
  }
  
  public static boolean a()
  {
    if (b) {
      try
      {
        b = MobileQQ.sMobileQQ.getSharedPreferences("qq_assistant_sp_key", 0).getBoolean("need_open_guider", true);
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
      localStringBuilder.append(b);
      QLog.d("WakeManager", 2, localStringBuilder.toString());
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.QQAssistantGuiderUtil
 * JD-Core Version:    0.7.0.1
 */