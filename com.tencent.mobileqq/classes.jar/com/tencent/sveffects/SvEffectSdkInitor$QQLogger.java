package com.tencent.sveffects;

import com.tencent.qphone.base.util.QLog;

public class SvEffectSdkInitor$QQLogger
  implements Logger
{
  public void a(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 2, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.e(paramString1, 2, paramString2, paramThrowable);
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    QLog.e(paramString, 2, paramThrowable, new Object[0]);
  }
  
  public boolean a()
  {
    return QLog.isColorLevel();
  }
  
  public void b(String paramString1, String paramString2)
  {
    QLog.w(paramString1, 2, paramString2);
  }
  
  public void c(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 2, paramString2);
  }
  
  public void d(String paramString1, String paramString2)
  {
    QLog.d(paramString1, 2, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQLogger
 * JD-Core Version:    0.7.0.1
 */