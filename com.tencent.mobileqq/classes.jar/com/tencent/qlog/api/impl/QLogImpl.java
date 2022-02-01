package com.tencent.qlog.api.impl;

import com.tencent.qlog.api.IQLog;
import com.tencent.qphone.base.util.QLog;

public class QLogImpl
  implements IQLog
{
  public void d(String paramString1, int paramInt, String paramString2)
  {
    QLog.d(paramString1, paramInt, paramString2);
  }
  
  public void d(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    QLog.d(paramString1, paramInt, paramString2, paramThrowable);
  }
  
  public void d(String paramString, int paramInt, Throwable paramThrowable, Object... paramVarArgs)
  {
    QLog.d(paramString, paramInt, paramThrowable, paramVarArgs);
  }
  
  public void d(String paramString, int paramInt, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    QLog.d(paramString, paramInt, paramArrayOfByte, paramThrowable);
  }
  
  public void d(String paramString, int paramInt, Object... paramVarArgs)
  {
    QLog.d(paramString, paramInt, paramVarArgs);
  }
  
  public void e(String paramString1, int paramInt, String paramString2)
  {
    QLog.e(paramString1, paramInt, paramString2);
  }
  
  public void e(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    QLog.e(paramString1, paramInt, paramString2, paramThrowable);
  }
  
  public void e(String paramString, int paramInt, Throwable paramThrowable, Object... paramVarArgs)
  {
    QLog.e(paramString, paramInt, paramThrowable, paramVarArgs);
  }
  
  public void e(String paramString, int paramInt, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    QLog.e(paramString, paramInt, new Object[] { paramArrayOfByte, paramThrowable });
  }
  
  public void e(String paramString, int paramInt, Object... paramVarArgs)
  {
    QLog.e(paramString, paramInt, paramVarArgs);
  }
  
  public void i(String paramString1, int paramInt, String paramString2)
  {
    QLog.i(paramString1, paramInt, paramString2);
  }
  
  public void i(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    QLog.i(paramString1, paramInt, paramString2, paramThrowable);
  }
  
  public boolean isColorLevel()
  {
    return QLog.isColorLevel();
  }
  
  public boolean isDevelopLevel()
  {
    return QLog.isDevelopLevel();
  }
  
  public void w(String paramString1, int paramInt, String paramString2)
  {
    QLog.w(paramString1, paramInt, paramString2);
  }
  
  public void w(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    QLog.w(paramString1, paramInt, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qlog.api.impl.QLogImpl
 * JD-Core Version:    0.7.0.1
 */