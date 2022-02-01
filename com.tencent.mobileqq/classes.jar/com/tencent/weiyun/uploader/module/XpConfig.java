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
  private static IConfig sRealConfig;
  
  public static String getCachePath()
  {
    IConfig localIConfig = sRealConfig;
    if (localIConfig != null) {
      return localIConfig.getCachePath();
    }
    return Environment.getDataDirectory().getAbsolutePath();
  }
  
  public static String getCurrentUin()
  {
    IConfig localIConfig = sRealConfig;
    if (localIConfig != null) {
      return String.valueOf(localIConfig.getCurrentUin());
    }
    return "0";
  }
  
  public static int getIsp()
  {
    IConfig localIConfig = sRealConfig;
    if (localIConfig != null) {
      return localIConfig.getIsp();
    }
    return 0;
  }
  
  public static String getQUA()
  {
    IConfig localIConfig = sRealConfig;
    if (localIConfig != null) {
      return localIConfig.getQUA();
    }
    return "";
  }
  
  public static String getRefer()
  {
    IConfig localIConfig = sRealConfig;
    if (localIConfig != null) {
      return localIConfig.getRefer();
    }
    return "tencent";
  }
  
  public static int getReportPercent()
  {
    IConfig localIConfig = sRealConfig;
    if (localIConfig != null) {
      return localIConfig.getReportPercent();
    }
    return 5;
  }
  
  public static String getTerminal()
  {
    IConfig localIConfig = sRealConfig;
    if (localIConfig != null) {
      return localIConfig.getTerminal();
    }
    return "android";
  }
  
  public static String getUserAgent()
  {
    IConfig localIConfig = sRealConfig;
    if (localIConfig != null) {
      return localIConfig.getUserAgent();
    }
    return "android-tencent";
  }
  
  public static String getVersion()
  {
    IConfig localIConfig = sRealConfig;
    if (localIConfig != null) {
      return localIConfig.getVersion();
    }
    return "1.0";
  }
  
  public static boolean isRdm()
  {
    IConfig localIConfig = sRealConfig;
    return (localIConfig != null) && (localIConfig.isRdm());
  }
  
  public static void setConfig(IConfig paramIConfig)
  {
    sRealConfig = paramIConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.uploader.module.XpConfig
 * JD-Core Version:    0.7.0.1
 */