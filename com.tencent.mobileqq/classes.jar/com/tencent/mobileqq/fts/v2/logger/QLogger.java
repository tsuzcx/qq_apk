package com.tencent.mobileqq.fts.v2.logger;

import com.tencent.qphone.base.util.QLog;

public class QLogger
  implements ILogger
{
  public void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1, paramString2, paramString3, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    if ("i".equals(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.i(paramString1, 2, paramString3, paramThrowable);
      }
    }
    else if ("d".equals(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.d(paramString1, 2, paramString3, paramThrowable);
      }
    }
    else
    {
      if ("w".equals(paramString2))
      {
        QLog.w(paramString1, 2, paramString3, paramThrowable);
        return;
      }
      if ("e".equals(paramString2))
      {
        QLog.e(paramString1, 2, paramString3, paramThrowable);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i(paramString1, 2, paramString3, paramThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.v2.logger.QLogger
 * JD-Core Version:    0.7.0.1
 */