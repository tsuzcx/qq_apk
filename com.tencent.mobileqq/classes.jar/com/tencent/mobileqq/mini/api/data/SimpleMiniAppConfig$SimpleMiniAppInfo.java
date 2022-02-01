package com.tencent.mobileqq.mini.api.data;

import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import com.tencent.mobileqq.pb.PBStringField;

public class SimpleMiniAppConfig$SimpleMiniAppInfo
{
  public String appId;
  public String developerDesc;
  public int engineType;
  public String iconUrl;
  public String name;
  public int reportType;
  public INTERFACE.StApiAppInfo stApiAppInfo;
  public int verType;
  public String via;
  
  public static SimpleMiniAppInfo from(INTERFACE.StApiAppInfo paramStApiAppInfo)
  {
    if (paramStApiAppInfo == null) {
      return null;
    }
    SimpleMiniAppInfo localSimpleMiniAppInfo = new SimpleMiniAppInfo();
    localSimpleMiniAppInfo.stApiAppInfo = paramStApiAppInfo;
    localSimpleMiniAppInfo.appId = paramStApiAppInfo.appId.get();
    localSimpleMiniAppInfo.name = paramStApiAppInfo.appName.get();
    localSimpleMiniAppInfo.iconUrl = paramStApiAppInfo.icon.get();
    localSimpleMiniAppInfo.developerDesc = paramStApiAppInfo.desc.get();
    return localSimpleMiniAppInfo;
  }
  
  public boolean isEngineTypeMiniApp()
  {
    return this.engineType == 0;
  }
  
  public boolean isEngineTypeMiniGame()
  {
    return this.engineType == 1;
  }
  
  public void setEngineType(int paramInt)
  {
    this.engineType = paramInt;
  }
  
  public void setReportType(int paramInt)
  {
    this.reportType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig.SimpleMiniAppInfo
 * JD-Core Version:    0.7.0.1
 */