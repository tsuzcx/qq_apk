package com.tencent.sveffects;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qphone.base.util.QLog;

public class SvEffectSdkInitor$QQLogger
  implements Logger
{
  public void d(String paramString1, String paramString2)
  {
    AEQLog.a(paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2)
  {
    AEQLog.d(paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AEQLog.a(paramString1, paramString2, paramThrowable);
  }
  
  public void e(String paramString, Throwable paramThrowable)
  {
    AEQLog.a(paramString, paramThrowable);
  }
  
  public void i(String paramString1, String paramString2)
  {
    AEQLog.b(paramString1, paramString2);
  }
  
  public boolean isEnable()
  {
    return QLog.isColorLevel();
  }
  
  public void w(String paramString1, String paramString2)
  {
    AEQLog.c(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQLogger
 * JD-Core Version:    0.7.0.1
 */