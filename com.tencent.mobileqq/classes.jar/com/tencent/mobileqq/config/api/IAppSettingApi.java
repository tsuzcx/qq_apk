package com.tencent.mobileqq.config.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAppSettingApi
  extends QRouteApi
{
  public abstract String buildNum();
  
  public abstract boolean enableTalkBack();
  
  public abstract int getAppId();
  
  public abstract String getPublishVersionString();
  
  public abstract String getReportVersionName();
  
  public abstract String getSubVersion();
  
  public abstract String getVersion();
  
  public abstract boolean isDebugVersion();
  
  public abstract boolean isGrayVersion();
  
  public abstract boolean isPublicVersion();
  
  public abstract boolean isUITest();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.api.IAppSettingApi
 * JD-Core Version:    0.7.0.1
 */