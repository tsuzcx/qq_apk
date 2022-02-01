package com.tencent.mobileqq.config.api.impl;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.qphone.base.util.BaseApplication;

public class AppSettingApiImpl
  implements IAppSettingApi
{
  public String buildNum()
  {
    return "5770";
  }
  
  public boolean enableTalkBack()
  {
    return AppSetting.e;
  }
  
  public int getAppId()
  {
    return AppSetting.d();
  }
  
  public String getPublishVersionString()
  {
    return AppSetting.a(BaseApplication.getContext());
  }
  
  public String getReportVersionName()
  {
    return "8.8.17.5770";
  }
  
  public String getSubVersion()
  {
    return "8.8.17";
  }
  
  public String getVersion()
  {
    return AppSetting.h();
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
    return AppSetting.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.api.impl.AppSettingApiImpl
 * JD-Core Version:    0.7.0.1
 */