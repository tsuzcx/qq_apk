package com.tencent.mobileqq.cmshow.crossengine.util;

import com.tencent.crossengine.log.LogDelegate;
import com.tencent.crossengine.log.LogDelegate.Level;
import com.tencent.qphone.base.util.QLog;

public class CELogger
  implements LogDelegate
{
  public void a(LogDelegate.Level paramLevel, String paramString1, String paramString2, Throwable paramThrowable)
  {
    int i = CELogger.1.a[paramLevel.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          QLog.e(paramString1, 1, paramString2, paramThrowable);
          return;
        }
        QLog.w(paramString1, 1, paramString2, paramThrowable);
        return;
      }
      QLog.i(paramString1, 1, paramString2, paramThrowable);
      return;
    }
    QLog.d(paramString1, 1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.util.CELogger
 * JD-Core Version:    0.7.0.1
 */