package com.tencent.mobileqq.config.business;

public class OpenSdkSwitchConfBean
{
  private OpenSdkSwitchConfBean.OpenSdkSwitchConfig a;
  private String b;
  
  public OpenSdkSwitchConfBean()
  {
    this.b = "";
    this.a = new OpenSdkSwitchConfBean.OpenSdkSwitchConfig();
  }
  
  public OpenSdkSwitchConfBean(String paramString, OpenSdkSwitchConfBean.OpenSdkSwitchConfig paramOpenSdkSwitchConfig)
  {
    this.b = paramString;
    this.a = paramOpenSdkSwitchConfig;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public OpenSdkSwitchConfBean.OpenSdkSwitchConfig b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.OpenSdkSwitchConfBean
 * JD-Core Version:    0.7.0.1
 */