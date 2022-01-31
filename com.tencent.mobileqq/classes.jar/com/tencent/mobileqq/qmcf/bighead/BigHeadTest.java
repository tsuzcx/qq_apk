package com.tencent.mobileqq.qmcf.bighead;

import java.io.File;

public class BigHeadTest
{
  private static final String bigHeadPath = "/sdcard/bigHead/";
  private static final String commonPrefix = "/sdcard/bigHead/output/";
  
  static
  {
    try
    {
      System.loadLibrary("Native");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
  
  public static String getCommonPrefix()
  {
    return "/sdcard/bigHead/output/";
  }
  
  public static String getModelPath()
  {
    return "/sdcard/bigHead/Android_net256.txt";
  }
  
  public static String getParamPath()
  {
    return "/sdcard/bigHead/change_4.3.bin";
  }
  
  public static void testInit()
  {
    File localFile = new File("/sdcard/bigHead/output/");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qmcf.bighead.BigHeadTest
 * JD-Core Version:    0.7.0.1
 */