package com.tencent.mobileqq.qqlive.data.config;

public class ConfigData$Builder
{
  private ConfigData configData = new ConfigData();
  
  public ConfigData build()
  {
    return this.configData;
  }
  
  public Builder setLiveAppId(String paramString)
  {
    ConfigData.access$102(this.configData, paramString);
    return this;
  }
  
  public Builder setLiveAppKey(String paramString)
  {
    ConfigData.access$202(this.configData, paramString);
    return this;
  }
  
  public Builder setLiveClientType(int paramInt)
  {
    ConfigData.access$302(this.configData, paramInt);
    return this;
  }
  
  public Builder setOpenSdkAppId(String paramString)
  {
    ConfigData.access$402(this.configData, paramString);
    return this;
  }
  
  public Builder setSmartEyeAppId(String paramString)
  {
    ConfigData.access$602(this.configData, paramString);
    return this;
  }
  
  public Builder setTrtcAppId(String paramString)
  {
    ConfigData.access$502(this.configData, paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.config.ConfigData.Builder
 * JD-Core Version:    0.7.0.1
 */