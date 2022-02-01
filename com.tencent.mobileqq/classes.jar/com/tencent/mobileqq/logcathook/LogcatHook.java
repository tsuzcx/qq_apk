package com.tencent.mobileqq.logcathook;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class LogcatHook
{
  public static AtomicBoolean a;
  public static boolean a;
  public static boolean b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    try
    {
      int i = BaseApplicationImpl.getApplication().getSharedPreferences("suspend_thread_pref_file", 0).getInt("enable_syslog_key", 0);
      if ((i == 1) && (!b))
      {
        jdField_a_of_type_Boolean = true;
        return;
      }
      if ((i == 2) && (!jdField_a_of_type_Boolean))
      {
        b = true;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      jdField_a_of_type_Boolean = false;
      b = false;
    }
  }
  
  public static void a()
  {
    ThreadManager.getSubThreadHandler().post(new LogcatHook.1());
  }
  
  private static native void hookLogcat(boolean paramBoolean);
  
  public static native void updateLogFilePath(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.logcathook.LogcatHook
 * JD-Core Version:    0.7.0.1
 */