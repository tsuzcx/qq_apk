package com.tencent.mobileqq.config.business;

public class OpenSdkRandomConfBean
{
  private OpenSdkRandomConfBean.OpenSdkRandomConfig a;
  private String b;
  
  public OpenSdkRandomConfBean()
  {
    this.b = "";
    this.a = new OpenSdkRandomConfBean.OpenSdkRandomConfig();
  }
  
  public OpenSdkRandomConfBean(String paramString, OpenSdkRandomConfBean.OpenSdkRandomConfig paramOpenSdkRandomConfig)
  {
    this.b = paramString;
    this.a = paramOpenSdkRandomConfig;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public OpenSdkRandomConfBean.OpenSdkRandomConfig b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.OpenSdkRandomConfBean
 * JD-Core Version:    0.7.0.1
 */