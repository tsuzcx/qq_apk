package com.tencent.mobileqq.qqlive.data.config;

public class QQLiveSDKConfig
{
  public boolean isDebug;
  public boolean isTestEnv;
  public int streamType;
  public String version;
  public int versionCode;
  
  public static QQLiveSDKConfig.Builder createBuilder()
  {
    return new QQLiveSDKConfig.Builder(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.config.QQLiveSDKConfig
 * JD-Core Version:    0.7.0.1
 */