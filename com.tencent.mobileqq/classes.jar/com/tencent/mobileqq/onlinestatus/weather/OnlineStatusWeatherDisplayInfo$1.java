package com.tencent.mobileqq.onlinestatus.weather;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.onlinestatus.OnlineStatusManager;
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
    if (this.jdField_a_of_type_Boolean) {
      ((OnlineStatusManager)OnlineStatusWeatherDisplayInfo.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusWeatherOnlineStatusWeatherDisplayInfo).getManager(QQManagerFactory.ONLINE_STATUS_MANAGER)).a(9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.weather.OnlineStatusWeatherDisplayInfo.1
 * JD-Core Version:    0.7.0.1
 */