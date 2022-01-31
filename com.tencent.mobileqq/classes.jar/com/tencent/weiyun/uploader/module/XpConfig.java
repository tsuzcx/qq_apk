package com.tencent.weiyun.uploader.module;

import android.os.Environment;
import com.tencent.weiyun.uploader.IConfig;
import java.io.File;

public class XpConfig
{
  public static final String DEFAULT_QUA = "";
  public static final String DEFAULT_REFER = "tencent";
  public static final int DEFAULT_REPORT_PERCENT = 5;
  public static final String DEFAULT_TERMINAL = "android";
  public static final String DEFAULT_USER_AGENT = "android-tencent";
  public static final String DEFAULT_VERSION = "1.0";
  private static IConfig sRealConfig = null;
  
  public static String getCachePath()
  {
    if (sRealConfig != null) {
      return sRealConfig.getCachePath();
    }
    return Environment.getDataDirectory().getAbsolutePath();
  }
  
  public static String getCurrentUin()
  {
    if (sRealConfig != null) {
      return String.valueOf(sRealConfig.getCurrentUin());
    }
    return "0";
  }
  
  public static int getIsp()
  {
    if (sRealConfig != null) {
      return sRealConfig.getIsp();
    }
    return 0;
  }
  
  public static String getQUA()
  {
    if (sRealConfig != null) {
      return sRealConfig.getQUA();
    }
    return "";
  }
  
  public static String getRefer()
  {
    if (sRealConfig != null) {
      return sRealConfig.getRefer();
    }
    return "tencent";
  }
  
  public static int getReportPercent()
  {
    if (sRealConfig != null) {
      return sRealConfig.getReportPercent();
    }
    return 5;
  }
  
  public static String getTerminal()
  {
    if (sRealConfig != null) {
      return sRealConfig.getTerminal();
    }
    return "android";
  }
  
  public static String getUserAgent()
  {
    if (sRealConfig != null) {
      return sRealConfig.getUserAgent();
    }
    return "android-tencent";
  }
  
  public static String getVersion()
  {
    if (sRealConfig != null) {
      return sRealConfig.getVersion();
    }
    return "1.0";
  }
  
  public static boolean isRdm()
  {
    return (sRealConfig != null) && (sRealConfig.isRdm());
  }
  
  public static void setConfig(IConfig paramIConfig)
  {
    sRealConfig = paramIConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weiyun.uploader.module.XpConfig
 * JD-Core Version:    0.7.0.1
 */