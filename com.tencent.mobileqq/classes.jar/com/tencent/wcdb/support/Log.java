package com.tencent.wcdb.support;

public class Log
{
  private static Log.LogCallback a;
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    Log.LogCallback localLogCallback = a;
    if (localLogCallback != null)
    {
      localLogCallback.println(paramInt, paramString1, paramString2);
      return;
    }
    nativePrintLn(paramInt, paramString1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(6, paramString1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    a(6, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a(5, paramString1, paramString2);
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    a(5, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static void c(String paramString1, String paramString2)
  {
    a(4, paramString1, paramString2);
  }
  
  public static void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    a(4, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  private static native void nativePrintLn(int paramInt, String paramString1, String paramString2);
  
  private static native void nativeSetLogger(int paramInt, Log.LogCallback paramLogCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.support.Log
 * JD-Core Version:    0.7.0.1
 */