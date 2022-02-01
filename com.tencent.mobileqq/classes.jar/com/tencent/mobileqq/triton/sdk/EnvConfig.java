package com.tencent.mobileqq.triton.sdk;

import android.util.DisplayMetrics;
import java.util.Map;
import java.util.Set;

public class EnvConfig
{
  private String mJSPath;
  private Version mJSVersion;
  private LogConfig mLogConfig = new LogConfig();
  private SystemConfig mSystemConfig = new SystemConfig();
  private String mTritonPath;
  private Version mTritonVersion;
  
  public DisplayMetrics getDisplayMetrics()
  {
    return this.mSystemConfig.mDisplayMetrics;
  }
  
  public String getJSPath()
  {
    return this.mJSPath;
  }
  
  public Version getJSVersion()
  {
    return this.mJSVersion;
  }
  
  public LogConfig getLogConfig()
  {
    return this.mLogConfig;
  }
  
  public int getScreenRefreshRate()
  {
    return this.mSystemConfig.mScreenRefreshRate;
  }
  
  public String getTritonPath()
  {
    return this.mTritonPath;
  }
  
  public Version getTritonVersion()
  {
    return this.mTritonVersion;
  }
  
  public void setDisplayMetrics(DisplayMetrics paramDisplayMetrics)
  {
    this.mSystemConfig.mDisplayMetrics = paramDisplayMetrics;
  }
  
  public void setJSPath(String paramString)
  {
    this.mJSPath = paramString;
  }
  
  public void setJSVersion(Version paramVersion)
  {
    this.mJSVersion = paramVersion;
  }
  
  public void setLogConfig(Map<String, Set<String>> paramMap1, Map<String, Set<String>> paramMap2)
  {
    LogConfig localLogConfig = this.mLogConfig;
    localLogConfig.whiteList = paramMap1;
    localLogConfig.blackList = paramMap2;
  }
  
  public void setScreenRefreshRate(int paramInt)
  {
    this.mSystemConfig.mScreenRefreshRate = paramInt;
  }
  
  public void setTritonPath(String paramString)
  {
    this.mTritonPath = paramString;
  }
  
  public void setTritonVersion(Version paramVersion)
  {
    this.mTritonVersion = paramVersion;
  }
  
  public String toString()
  {
    return "EnvConfig{tritonPath='" + this.mTritonPath + '\'' + ", tritonVersion=" + this.mTritonVersion + ", JSPath='" + this.mJSPath + '\'' + ", JSVersion=" + this.mJSVersion + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.EnvConfig
 * JD-Core Version:    0.7.0.1
 */