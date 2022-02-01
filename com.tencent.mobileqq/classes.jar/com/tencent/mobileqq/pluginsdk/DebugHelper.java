package com.tencent.mobileqq.pluginsdk;

import com.tencent.qphone.base.util.QLog;

public class DebugHelper
{
  public static final String TAG = "plugin_tag";
  public static boolean sDebug = true;
  
  public static void debug(String paramString)
  {
    debug("plugin_tag", paramString);
  }
  
  public static void debug(String paramString1, String paramString2)
  {
    debug(paramString1, paramString2, null);
  }
  
  public static void debug(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((sDebug) && (QLog.isColorLevel()))
    {
      if (paramThrowable == null)
      {
        QLog.d(paramString1, 2, paramString2);
        return;
      }
      QLog.d(paramString1, 2, paramString2, paramThrowable);
    }
  }
  
  public static void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, paramString);
    }
  }
  
  public static void log(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public static void log(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.DebugHelper
 * JD-Core Version:    0.7.0.1
 */