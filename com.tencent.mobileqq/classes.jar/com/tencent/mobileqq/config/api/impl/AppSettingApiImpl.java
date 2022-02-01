package com.tencent.mobileqq.config.api.impl;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.config.api.IAppSettingApi;

public class AppSettingApiImpl
  implements IAppSettingApi
{
  public String buildNum()
  {
    return "5105";
  }
  
  public boolean enableTalkBack()
  {
    return AppSetting.d;
  }
  
  public String getReportVersionName()
  {
    return "8.5.5.5105";
  }
  
  public String getSubVersion()
  {
    return "8.5.5";
  }
  
  public String getVersion()
  {
    return AppSetting.f();
  }
  
  public boolean isDebugVersion()
  {
    return false;
  }
  
  public boolean isGrayVersion()
  {
    return false;
  }
  
  public boolean isPublicVersion()
  {
    return true;
  }
  
  public boolean isUITest()
  {
    return AppSetting.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.api.impl.AppSettingApiImpl
 * JD-Core Version:    0.7.0.1
 */