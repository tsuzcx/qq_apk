package com.tencent.qqmini.miniapp.core.service;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.v8rt.engine.ILog;

public class V8LogImpl
  implements ILog
{
  String TAG = "MIV8RT";
  
  public int d(String paramString1, String paramString2)
  {
    QMLog.d(this.TAG + "/" + paramString1, paramString2, null);
    return 0;
  }
  
  public int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QMLog.d(this.TAG + "/" + paramString1, paramString2, paramThrowable);
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    QMLog.e(this.TAG + "/" + paramString1, paramString2);
    return 0;
  }
  
  public int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QMLog.e(this.TAG + "/" + paramString1, paramString2, paramThrowable);
    return 0;
  }
  
  public int i(String paramString1, String paramString2)
  {
    QMLog.i(this.TAG + "/" + paramString1, paramString2);
    return 0;
  }
  
  public int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QMLog.i(this.TAG + "/" + paramString1, paramString2, paramThrowable);
    return 0;
  }
  
  public void printNativeLog(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = this.TAG + "/" + paramString1;
    int i;
    if (paramInt >= 100)
    {
      i = paramInt - 100 + 2;
      if (i > 2) {
        break label65;
      }
      QMLog.d(paramString1, paramString2);
    }
    for (;;)
    {
      if (paramInt >= 100) {}
      return;
      i = paramInt;
      break;
      label65:
      if (i == 3) {
        QMLog.i(paramString1, paramString2);
      } else if (i == 4) {
        QMLog.w(paramString1, paramString2);
      } else if (i == 5) {
        QMLog.e(paramString1, paramString2);
      }
    }
  }
  
  public int w(String paramString1, String paramString2)
  {
    QMLog.w(this.TAG + "/" + paramString1, paramString2);
    return 0;
  }
  
  public int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QMLog.w(this.TAG + "/" + paramString1, paramString2, paramThrowable);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.V8LogImpl
 * JD-Core Version:    0.7.0.1
 */