package com.tencent.mobileqq.intervideo;

import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.core.common.Logger;

class IVLoggerFactory$IVLogger
  implements Logger
{
  private String b;
  
  IVLoggerFactory$IVLogger(IVLoggerFactory paramIVLoggerFactory, String paramString)
  {
    this.b = paramString;
  }
  
  private void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    String str = String.valueOf(this.b);
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if ((paramInt != 4) && (paramInt != 5)) {
            return;
          }
          if (paramThrowable == null)
          {
            QLog.d(str, 4, paramString);
            return;
          }
          QLog.d(str, 4, paramString, paramThrowable);
          return;
        }
        if (paramThrowable == null)
        {
          QLog.i(str, 2, paramString);
          return;
        }
        QLog.i(str, 2, paramString, paramThrowable);
        return;
      }
      if (paramThrowable == null)
      {
        QLog.w(str, 1, paramString);
        return;
      }
      QLog.w(str, 1, paramString, paramThrowable);
      return;
    }
    if (paramThrowable == null)
    {
      QLog.e(str, 1, paramString);
      return;
    }
    QLog.e(str, 1, paramString, paramThrowable);
  }
  
  public void debug(String paramString)
  {
    a(4, paramString, null);
  }
  
  public void debug(String paramString, Object paramObject)
  {
    a(4, MessageFormatter.a(paramString, paramObject).a(), null);
  }
  
  public void debug(String paramString, Object paramObject1, Object paramObject2)
  {
    a(4, MessageFormatter.a(paramString, paramObject1, paramObject2).a(), null);
  }
  
  public void debug(String paramString, Throwable paramThrowable)
  {
    a(4, paramString, paramThrowable);
  }
  
  public void debug(String paramString, Object... paramVarArgs)
  {
    a(4, MessageFormatter.a(paramString, paramVarArgs).a(), null);
  }
  
  public void error(String paramString)
  {
    a(1, paramString, null);
  }
  
  public void error(String paramString, Object paramObject)
  {
    a(1, MessageFormatter.a(paramString, paramObject).a(), null);
  }
  
  public void error(String paramString, Object paramObject1, Object paramObject2)
  {
    a(1, MessageFormatter.a(paramString, paramObject1, paramObject2).a(), null);
  }
  
  public void error(String paramString, Throwable paramThrowable)
  {
    a(1, paramString, paramThrowable);
  }
  
  public void error(String paramString, Object... paramVarArgs)
  {
    a(1, MessageFormatter.a(paramString, paramVarArgs).a(), null);
  }
  
  public String getName()
  {
    return this.b;
  }
  
  public void info(String paramString)
  {
    a(3, paramString, null);
  }
  
  public void info(String paramString, Object paramObject)
  {
    a(3, MessageFormatter.a(paramString, paramObject).a(), null);
  }
  
  public void info(String paramString, Object paramObject1, Object paramObject2)
  {
    a(3, MessageFormatter.a(paramString, paramObject1, paramObject2).a(), null);
  }
  
  public void info(String paramString, Throwable paramThrowable)
  {
    a(3, paramString, paramThrowable);
  }
  
  public void info(String paramString, Object... paramVarArgs)
  {
    a(3, MessageFormatter.a(paramString, paramVarArgs).a(), null);
  }
  
  public boolean isDebugEnabled()
  {
    return QLog.isDevelopLevel();
  }
  
  public boolean isErrorEnabled()
  {
    return QLog.getUIN_REPORTLOG_LEVEL() >= 1;
  }
  
  public boolean isInfoEnabled()
  {
    return QLog.isColorLevel();
  }
  
  public boolean isTraceEnabled()
  {
    return QLog.isDevelopLevel();
  }
  
  public boolean isWarnEnabled()
  {
    return QLog.getUIN_REPORTLOG_LEVEL() >= 1;
  }
  
  public void trace(String paramString)
  {
    a(5, paramString, null);
  }
  
  public void trace(String paramString, Object paramObject)
  {
    a(5, MessageFormatter.a(paramString, paramObject).a(), null);
  }
  
  public void trace(String paramString, Object paramObject1, Object paramObject2)
  {
    a(5, MessageFormatter.a(paramString, paramObject1, paramObject2).a(), null);
  }
  
  public void trace(String paramString, Throwable paramThrowable)
  {
    a(5, paramString, paramThrowable);
  }
  
  public void trace(String paramString, Object... paramVarArgs)
  {
    a(5, MessageFormatter.a(paramString, paramVarArgs).a(), null);
  }
  
  public void warn(String paramString)
  {
    a(2, paramString, null);
  }
  
  public void warn(String paramString, Object paramObject)
  {
    a(2, MessageFormatter.a(paramString, paramObject).a(), null);
  }
  
  public void warn(String paramString, Object paramObject1, Object paramObject2)
  {
    a(2, MessageFormatter.a(paramString, paramObject1, paramObject2).a(), null);
  }
  
  public void warn(String paramString, Throwable paramThrowable)
  {
    a(2, paramString, paramThrowable);
  }
  
  public void warn(String paramString, Object... paramVarArgs)
  {
    a(2, MessageFormatter.a(paramString, paramVarArgs).a(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.IVLoggerFactory.IVLogger
 * JD-Core Version:    0.7.0.1
 */