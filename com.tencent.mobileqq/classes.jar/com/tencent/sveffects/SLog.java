package com.tencent.sveffects;

public class SLog
{
  public static void d(String paramString1, String paramString2)
  {
    SdkContext.getInstance().getLogger().d(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    SdkContext.getInstance().getLogger().e(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    SdkContext.getInstance().getLogger().e(paramString1, paramString2, paramThrowable);
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    SdkContext.getInstance().getLogger().e(paramString, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    SdkContext.getInstance().getLogger().i(paramString1, paramString2);
  }
  
  public static final boolean isEnable()
  {
    return SdkContext.getInstance().getLogger().isEnable();
  }
  
  public static void w(String paramString1, String paramString2)
  {
    SdkContext.getInstance().getLogger().w(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sveffects.SLog
 * JD-Core Version:    0.7.0.1
 */