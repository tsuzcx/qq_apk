package com.tencent.mobileqq.onlinestatus.weather;

import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class OnlineStatusWeatherDisplayInfo$2
{
  OnlineStatusWeatherDisplayInfo$2(OnlineStatusWeatherDisplayInfo paramOnlineStatusWeatherDisplayInfo) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    DialogUtil.a(OnlineStatusWeatherDisplayInfo.b(this.a), 2131896422, 2131896423);
  }
  
  @QQPermissionGrant(1)
  public void grant() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.weather.OnlineStatusWeatherDisplayInfo.2
 * JD-Core Version:    0.7.0.1
 */