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
    DialogUtil.a(OnlineStatusWeatherDisplayInfo.b(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusWeatherOnlineStatusWeatherDisplayInfo), 2131698416, 2131698417);
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusWeatherOnlineStatusWeatherDisplayInfo.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.weather.OnlineStatusWeatherDisplayInfo.3
 * JD-Core Version:    0.7.0.1
 */