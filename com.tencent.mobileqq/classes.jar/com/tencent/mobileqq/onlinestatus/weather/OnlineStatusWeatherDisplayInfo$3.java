package com.tencent.mobileqq.onlinestatus.weather;

import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class OnlineStatusWeatherDisplayInfo$3
{
  OnlineStatusWeatherDisplayInfo$3(OnlineStatusWeatherDisplayInfo paramOnlineStatusWeatherDisplayInfo, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    DialogUtil.a(OnlineStatusWeatherDisplayInfo.c(this.b), 2131896422, 2131896423);
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    this.b.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.weather.OnlineStatusWeatherDisplayInfo.3
 * JD-Core Version:    0.7.0.1
 */