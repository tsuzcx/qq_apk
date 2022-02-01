package com.tencent.mobileqq.onlinestatus.weather;

import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager;
import mqq.app.AppRuntime;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class OnlineStatusWeatherDisplayInfo$1
{
  OnlineStatusWeatherDisplayInfo$1(OnlineStatusWeatherDisplayInfo paramOnlineStatusWeatherDisplayInfo, boolean paramBoolean) {}
  
  @QQPermissionDenied(1)
  public void denied() {}
  
  @QQPermissionGrant(1)
  public void grant()
  {
    if (this.a) {
      ((OnlineStatusDataManager)((IOnlineStatusManagerService)OnlineStatusWeatherDisplayInfo.a(this.b).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusDataManager.class)).b(9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.weather.OnlineStatusWeatherDisplayInfo.1
 * JD-Core Version:    0.7.0.1
 */