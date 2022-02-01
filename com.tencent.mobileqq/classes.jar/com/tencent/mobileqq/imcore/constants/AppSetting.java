package com.tencent.mobileqq.imcore.constants;

public final class AppSetting
{
  public static boolean isDebugVersion;
  public static boolean isGooglePlayVersion = false;
  public static boolean isGrayVersion;
  public static boolean isPublicVersion = false;
  public static volatile boolean logcatDBOperation = false;
  
  static
  {
    isDebugVersion = true;
    isGrayVersion = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.constants.AppSetting
 * JD-Core Version:    0.7.0.1
 */