package com.tencent.mobileqq.uftransfer.depend;

import com.tencent.qphone.base.util.QLog;

public class UFTLog
{
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.d(paramString1, paramInt, paramString2);
  }
  
  public static boolean a()
  {
    return QLog.isDevelopLevel();
  }
  
  public static void b(String paramString1, int paramInt, String paramString2)
  {
    QLog.i(paramString1, paramInt, paramString2);
  }
  
  public static void c(String paramString1, int paramInt, String paramString2)
  {
    QLog.w(paramString1, paramInt, paramString2);
  }
  
  public static void d(String paramString1, int paramInt, String paramString2)
  {
    QLog.e(paramString1, paramInt, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.depend.UFTLog
 * JD-Core Version:    0.7.0.1
 */