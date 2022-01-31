package com.tencent.youtu.android.rapidnet;

public class SuperresolutionLog
{
  static ILogCallbackInterface sCallback;
  
  public static void printLog(int paramInt, String paramString1, String paramString2)
  {
    if (sCallback != null) {
      sCallback.printLog(paramInt, paramString1, paramString2);
    }
  }
  
  public static void setLogCallback(ILogCallbackInterface paramILogCallbackInterface)
  {
    sCallback = paramILogCallbackInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.android.rapidnet.SuperresolutionLog
 * JD-Core Version:    0.7.0.1
 */