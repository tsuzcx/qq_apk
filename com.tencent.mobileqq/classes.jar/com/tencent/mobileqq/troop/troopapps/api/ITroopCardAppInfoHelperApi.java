package com.tencent.mobileqq.troop.troopapps.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={""})
public abstract interface ITroopCardAppInfoHelperApi
  extends QRouteApi
{
  public abstract void destroy();
  
  public abstract boolean getAppInfoBriefList(String paramString, ITroopCardAppInfoHelperApi.IGetAppInfoCB paramIGetAppInfoCB);
  
  public abstract boolean getAppInfoBriefList(String paramString, ITroopCardAppInfoHelperApi.IGetAppInfoCB paramIGetAppInfoCB, boolean paramBoolean);
  
  public abstract void init(AppRuntime paramAppRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.api.ITroopCardAppInfoHelperApi
 * JD-Core Version:    0.7.0.1
 */