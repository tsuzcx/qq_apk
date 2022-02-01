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
    DialogUtil.a(OnlineStatusWeatherDisplayInfo.a(this.a), 2131698482, 2131698483);
  }
  
  @QQPermissionGrant(1)
  public void grant() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.weather.OnlineStatusWeatherDisplayInfo.2
 * JD-Core Version:    0.7.0.1
 */