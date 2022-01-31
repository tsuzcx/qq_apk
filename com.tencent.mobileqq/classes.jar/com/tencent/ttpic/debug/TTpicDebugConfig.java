package com.tencent.ttpic.debug;

public class TTpicDebugConfig
{
  private static final String DEBUG_TXT = "/sdcard/ttpicconfig.txt";
  private static final String TAG = "TTpicDebugConfig";
  private static boolean isDetectGender = true;
  
  public static void initDebugTxt()
  {
    new Thread(new TTpicDebugConfig.1()).start();
  }
  
  public static boolean isDetectGender()
  {
    return isDetectGender;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.debug.TTpicDebugConfig
 * JD-Core Version:    0.7.0.1
 */