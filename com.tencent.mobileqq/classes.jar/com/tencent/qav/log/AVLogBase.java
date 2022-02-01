package com.tencent.qav.log;

import com.tencent.qphone.base.util.QLog;

public class AVLogBase
{
  public void a(String paramString1, String paramString2)
  {
    QLog.e("AVLOG_" + paramString1, 1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.e("AVLOG_" + paramString1, 1, paramString2, paramThrowable);
  }
  
  public void b(String paramString1, String paramString2)
  {
    QLog.w("AVLOG_" + paramString1, 1, paramString2);
  }
  
  public void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.w("AVLOG_" + paramString1, 1, paramString2, paramThrowable);
  }
  
  public void c(String paramString1, String paramString2)
  {
    QLog.d("AVLOG_" + paramString1, 2, paramString2);
  }
  
  public void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.i("AVLOG_" + paramString1, 1, paramString2, paramThrowable);
  }
  
  public void d(String paramString1, String paramString2)
  {
    QLog.i("AVLOG_" + paramString1, 1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qav.log.AVLogBase
 * JD-Core Version:    0.7.0.1
 */