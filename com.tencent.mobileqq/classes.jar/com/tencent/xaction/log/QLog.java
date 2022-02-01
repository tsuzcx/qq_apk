package com.tencent.xaction.log;

import android.util.Log;

public class QLog
{
  private static IQLog a;
  public static boolean a = false;
  
  public static void a(IQLog paramIQLog)
  {
    jdField_a_of_type_ComTencentXactionLogIQLog = paramIQLog;
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    d(paramString1, paramInt, paramString2, null);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    IQLog localIQLog = jdField_a_of_type_ComTencentXactionLogIQLog;
    if (localIQLog != null)
    {
      localIQLog.a(6, paramString1, paramInt, paramString2, paramThrowable);
      return;
    }
    if (jdField_a_of_type_Boolean) {
      Log.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void b(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    IQLog localIQLog = jdField_a_of_type_ComTencentXactionLogIQLog;
    if (localIQLog != null)
    {
      localIQLog.a(5, paramString1, paramInt, paramString2, paramThrowable);
      return;
    }
    if (jdField_a_of_type_Boolean) {
      Log.w(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void c(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    IQLog localIQLog = jdField_a_of_type_ComTencentXactionLogIQLog;
    if (localIQLog != null)
    {
      localIQLog.a(4, paramString1, paramInt, paramString2, paramThrowable);
      return;
    }
    if (jdField_a_of_type_Boolean) {
      Log.i(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void d(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    IQLog localIQLog = jdField_a_of_type_ComTencentXactionLogIQLog;
    if (localIQLog != null)
    {
      localIQLog.a(3, paramString1, paramInt, paramString2, paramThrowable);
      return;
    }
    if (jdField_a_of_type_Boolean) {
      Log.d(paramString1, paramString2, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.log.QLog
 * JD-Core Version:    0.7.0.1
 */