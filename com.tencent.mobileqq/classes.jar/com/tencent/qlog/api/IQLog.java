package com.tencent.qlog.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQLog
  extends QRouteApi
{
  public static final int CLR = 2;
  public static final int DEV = 4;
  public static final int USR = 1;
  
  public abstract void d(String paramString1, int paramInt, String paramString2);
  
  public abstract void d(String paramString1, int paramInt, String paramString2, Throwable paramThrowable);
  
  public abstract void d(String paramString, int paramInt, Throwable paramThrowable, Object... paramVarArgs);
  
  public abstract void d(String paramString, int paramInt, byte[] paramArrayOfByte, Throwable paramThrowable);
  
  public abstract void d(String paramString, int paramInt, Object... paramVarArgs);
  
  public abstract void e(String paramString1, int paramInt, String paramString2);
  
  public abstract void e(String paramString1, int paramInt, String paramString2, Throwable paramThrowable);
  
  public abstract void e(String paramString, int paramInt, Throwable paramThrowable, Object... paramVarArgs);
  
  public abstract void e(String paramString, int paramInt, byte[] paramArrayOfByte, Throwable paramThrowable);
  
  public abstract void e(String paramString, int paramInt, Object... paramVarArgs);
  
  public abstract void i(String paramString1, int paramInt, String paramString2);
  
  public abstract void i(String paramString1, int paramInt, String paramString2, Throwable paramThrowable);
  
  public abstract boolean isColorLevel();
  
  public abstract boolean isDevelopLevel();
  
  public abstract void w(String paramString1, int paramInt, String paramString2);
  
  public abstract void w(String paramString1, int paramInt, String paramString2, Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qlog.api.IQLog
 * JD-Core Version:    0.7.0.1
 */