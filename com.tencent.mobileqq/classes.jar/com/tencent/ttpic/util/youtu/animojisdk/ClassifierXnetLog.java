package com.tencent.ttpic.util.youtu.animojisdk;

public class ClassifierXnetLog
{
  static ILogCallbackInterface sCallback;
  
  public static void printLog(int paramInt, String paramString1, String paramString2)
  {
    ILogCallbackInterface localILogCallbackInterface = sCallback;
    if (localILogCallbackInterface != null) {
      localILogCallbackInterface.printLog(paramInt, paramString1, paramString2);
    }
  }
  
  public static void setLogCallback(ILogCallbackInterface paramILogCallbackInterface)
  {
    sCallback = paramILogCallbackInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.animojisdk.ClassifierXnetLog
 * JD-Core Version:    0.7.0.1
 */