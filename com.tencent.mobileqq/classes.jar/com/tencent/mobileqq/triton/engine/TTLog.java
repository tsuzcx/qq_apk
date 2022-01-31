package com.tencent.mobileqq.triton.engine;

import com.tencent.mobileqq.triton.jni.TTNativeCall;
import com.tencent.mobileqq.triton.jni.TTNativeModule;
import com.tencent.mobileqq.triton.sdk.ITLog;

@TTNativeModule(name="TTLog")
public class TTLog
{
  private static ITLog sDefLog = new TTLog.1();
  private static ITLog sLogProxy;
  
  public static int d(String paramString1, String paramString2)
  {
    return getLog().d(paramString1, paramString2);
  }
  
  public static int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return getLog().d(paramString1, paramString2, paramThrowable);
  }
  
  public static int e(String paramString1, String paramString2)
  {
    return getLog().e(paramString1, paramString2);
  }
  
  public static int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return getLog().e(paramString1, paramString2, paramThrowable);
  }
  
  public static ITLog getLog()
  {
    if (sLogProxy != null) {
      return sLogProxy;
    }
    return sDefLog;
  }
  
  public static int i(String paramString1, String paramString2)
  {
    return getLog().i(paramString1, paramString2);
  }
  
  public static int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return getLog().i(paramString1, paramString2, paramThrowable);
  }
  
  public static void init(ITLog paramITLog)
  {
    sLogProxy = paramITLog;
  }
  
  @TTNativeCall
  public static void printNativeLog(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte1 = new String(paramArrayOfByte1);
    paramArrayOfByte2 = new String(paramArrayOfByte2);
    getLog().printNativeLog(paramInt, paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static int w(String paramString1, String paramString2)
  {
    return getLog().w(paramString1, paramString2);
  }
  
  public static int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return getLog().w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.TTLog
 * JD-Core Version:    0.7.0.1
 */