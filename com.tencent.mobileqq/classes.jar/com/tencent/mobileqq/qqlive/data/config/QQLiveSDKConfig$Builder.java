package com.tencent.mobileqq.qqlive.data.config;

public class QQLiveSDKConfig$Builder
{
  private QQLiveSDKConfig config = new QQLiveSDKConfig(null);
  
  private boolean checkConfigParams()
  {
    return true;
  }
  
  public QQLiveSDKConfig build()
  {
    if ((this.config.isDebug) && (!checkConfigParams())) {
      throw new RuntimeException("config params error");
    }
    return this.config;
  }
  
  public Builder debug(boolean paramBoolean)
  {
    this.config.isDebug = paramBoolean;
    return this;
  }
  
  public Builder streamType(int paramInt)
  {
    this.config.streamType = paramInt;
    return this;
  }
  
  public Builder testEnv(boolean paramBoolean)
  {
    this.config.isTestEnv = paramBoolean;
    return this;
  }
  
  public Builder version(String paramString)
  {
    this.config.version = paramString;
    return this;
  }
  
  public Builder versionCode(int paramInt)
  {
    this.config.versionCode = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.config.QQLiveSDKConfig.Builder
 * JD-Core Version:    0.7.0.1
 */