package org.light.utils;

import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class LightLogUtil
{
  private static ILightLogger mLogger;
  private static int minPriority;
  
  public static void d(String paramString1, String paramString2)
  {
    if (3 < minPriority) {
      return;
    }
    ILightLogger localILightLogger = mLogger;
    if (localILightLogger == null)
    {
      Log.d(paramString1, paramString2);
      return;
    }
    localILightLogger.log(3, paramString1, paramString2);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (3 < minPriority) {
      return;
    }
    ILightLogger localILightLogger = mLogger;
    if (localILightLogger == null)
    {
      Log.d(paramString1, paramString2, paramThrowable);
      return;
    }
    localILightLogger.log(3, paramString1, paramString2, paramThrowable);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (6 < minPriority) {
      return;
    }
    ILightLogger localILightLogger = mLogger;
    if (localILightLogger == null)
    {
      Log.e(paramString1, paramString2);
      return;
    }
    localILightLogger.log(6, paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (6 < minPriority) {
      return;
    }
    ILightLogger localILightLogger = mLogger;
    if (localILightLogger == null)
    {
      Log.e(paramString1, paramString2, paramThrowable);
      return;
    }
    localILightLogger.log(6, paramString1, paramString2);
  }
  
  public static void e(Throwable paramThrowable)
  {
    paramThrowable.printStackTrace();
  }
  
  public static String getString(ByteBuffer paramByteBuffer)
  {
    try
    {
      paramByteBuffer = Charset.forName("UTF-8").decode(paramByteBuffer.asReadOnlyBuffer()).toString();
      return paramByteBuffer;
    }
    catch (Exception paramByteBuffer)
    {
      paramByteBuffer.printStackTrace();
    }
    return "";
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (4 < minPriority) {
      return;
    }
    ILightLogger localILightLogger = mLogger;
    if (localILightLogger == null)
    {
      Log.i(paramString1, paramString2);
      return;
    }
    localILightLogger.log(4, paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (4 < minPriority) {
      return;
    }
    ILightLogger localILightLogger = mLogger;
    if (localILightLogger == null)
    {
      Log.i(paramString1, paramString2, paramThrowable);
      return;
    }
    localILightLogger.log(4, paramString1, paramString2, paramThrowable);
  }
  
  public static void initLogger() {}
  
  public static void initLogger(ILightLogger paramILightLogger)
  {
    setLightLogger(paramILightLogger);
    nativeInitLogger();
  }
  
  static native void nativeDestroyLogger();
  
  static native void nativeInitLogger();
  
  static native void nativeSetMinPriority(int paramInt);
  
  public static void setLightLogger(ILightLogger paramILightLogger)
  {
    mLogger = paramILightLogger;
  }
  
  public static void setLogInfo(int paramInt, ByteBuffer paramByteBuffer)
  {
    Object localObject = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get((byte[])localObject);
    localObject = new String((byte[])localObject);
    int i = ((String)localObject).indexOf(":");
    if (i == -1) {
      return;
    }
    paramByteBuffer = ((String)localObject).substring(0, i);
    localObject = ((String)localObject).substring(i + 1);
    if (paramInt < minPriority) {
      return;
    }
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if (paramInt != 6) {
              return;
            }
            e(paramByteBuffer, (String)localObject);
            return;
          }
          w(paramByteBuffer, (String)localObject);
          return;
        }
        i(paramByteBuffer, (String)localObject);
        return;
      }
      d(paramByteBuffer, (String)localObject);
      return;
    }
    v(paramByteBuffer, (String)localObject);
  }
  
  public static void setMinPriority(int paramInt)
  {
    minPriority = paramInt;
    nativeSetMinPriority(paramInt);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (2 < minPriority) {
      return;
    }
    ILightLogger localILightLogger = mLogger;
    if (localILightLogger == null)
    {
      Log.v(paramString1, paramString2);
      return;
    }
    localILightLogger.log(2, paramString1, paramString2);
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (2 < minPriority) {
      return;
    }
    ILightLogger localILightLogger = mLogger;
    if (localILightLogger == null)
    {
      Log.v(paramString1, paramString2, paramThrowable);
      return;
    }
    localILightLogger.log(2, paramString1, paramString2, paramThrowable);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (5 < minPriority) {
      return;
    }
    ILightLogger localILightLogger = mLogger;
    if (localILightLogger == null)
    {
      Log.w(paramString1, paramString2);
      return;
    }
    localILightLogger.log(5, paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (5 < minPriority) {
      return;
    }
    ILightLogger localILightLogger = mLogger;
    if (localILightLogger == null)
    {
      Log.w(paramString1, paramString2, paramThrowable);
      return;
    }
    localILightLogger.log(5, paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.utils.LightLogUtil
 * JD-Core Version:    0.7.0.1
 */