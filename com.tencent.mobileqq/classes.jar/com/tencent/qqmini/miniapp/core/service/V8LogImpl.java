package com.tencent.qqmini.miniapp.core.service;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.v8rt.engine.ILog;

public class V8LogImpl
  implements ILog
{
  static final String TAG = "MIV8RT";
  
  public int d(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MIV8RT/");
    localStringBuilder.append(paramString1);
    QMLog.d(localStringBuilder.toString(), paramString2, null);
    return 0;
  }
  
  public int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MIV8RT/");
    localStringBuilder.append(paramString1);
    QMLog.d(localStringBuilder.toString(), paramString2, paramThrowable);
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MIV8RT/");
    localStringBuilder.append(paramString1);
    QMLog.e(localStringBuilder.toString(), paramString2);
    return 0;
  }
  
  public int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MIV8RT/");
    localStringBuilder.append(paramString1);
    QMLog.e(localStringBuilder.toString(), paramString2, paramThrowable);
    return 0;
  }
  
  public int i(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MIV8RT/");
    localStringBuilder.append(paramString1);
    QMLog.i(localStringBuilder.toString(), paramString2);
    return 0;
  }
  
  public int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MIV8RT/");
    localStringBuilder.append(paramString1);
    QMLog.i(localStringBuilder.toString(), paramString2, paramThrowable);
    return 0;
  }
  
  public void printNativeLog(int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MIV8RT/");
    localStringBuilder.append(paramString1);
    paramString1 = localStringBuilder.toString();
    int i = paramInt;
    if (paramInt >= 100) {
      i = paramInt - 100 + 2;
    }
    if (i <= 2)
    {
      QMLog.d(paramString1, paramString2);
      return;
    }
    if (i == 3)
    {
      QMLog.i(paramString1, paramString2);
      return;
    }
    if (i == 4)
    {
      QMLog.w(paramString1, paramString2);
      return;
    }
    if (i == 5) {
      QMLog.e(paramString1, paramString2);
    }
  }
  
  public int w(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MIV8RT/");
    localStringBuilder.append(paramString1);
    QMLog.w(localStringBuilder.toString(), paramString2);
    return 0;
  }
  
  public int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MIV8RT/");
    localStringBuilder.append(paramString1);
    QMLog.w(localStringBuilder.toString(), paramString2, paramThrowable);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.V8LogImpl
 * JD-Core Version:    0.7.0.1
 */