package com.tencent.mobileqq.location.net;

import com.tencent.common.app.AppInterface;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.location.LocationShareViewModel;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.monitor.base.IAPMModuleBattery;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

class LocationShareLocationManager$2
  implements TencentLocationListener
{
  private Runnable jdField_b_of_type_JavaLangRunnable = this.jdField_a_of_type_JavaLangRunnable;
  private volatile boolean jdField_b_of_type_Boolean = true;
  private volatile boolean c = true ^ this.jdField_a_of_type_Boolean;
  
  LocationShareLocationManager$2(LocationShareLocationManager paramLocationShareLocationManager, boolean paramBoolean, Runnable paramRunnable, MqqHandler paramMqqHandler, LocationRoom paramLocationRoom) {}
  
  public void onLocationChanged(TencentLocation paramTencentLocation, int paramInt, String paramString)
  {
    Integer localInteger = Integer.valueOf(0);
    if (paramInt == 0)
    {
      LatLng localLatLng = new LatLng(paramTencentLocation.getLatitude(), paramTencentLocation.getLongitude());
      paramTencentLocation = localLatLng;
      if (QLog.isColorLevel())
      {
        paramTencentLocation = localLatLng;
        if (LocationShareLocationManager.a != null) {
          paramTencentLocation = LocationShareLocationManager.a;
        }
      }
      if ((paramTencentLocation.getLatitude() == 0.0D) && (paramTencentLocation.getLongitude() == 0.0D))
      {
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = false;
          QLog.e("Q.LocationShare", 1, "[LocationManager] onLocationChanged: invoked. (0,0) detected");
        }
        return;
      }
      LocationShareLocationManager.a(this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareLocationManager, paramTencentLocation);
    }
    if ((this.c) && (this.jdField_b_of_type_JavaLangRunnable != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.LocationShare", 2, "[LocationManager] onLocationChanged: invoked. remove over time runnable");
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
    if (paramInt != 0)
    {
      paramTencentLocation = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
      LocationShareViewModel.a((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null), paramTencentLocation.a(), paramTencentLocation.a(), 1);
    }
    else
    {
      if (this.c)
      {
        this.c = false;
        LocationShareRoomManager.a().a(LocationShareLocationManager.a(this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareLocationManager).a(), LocationShareLocationManager.a(this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareLocationManager).a());
      }
      LocationShareLocationManager.a().a(true);
    }
    if ((paramInt == 0) || (HwNetworkUtil.isNetworkAvailable(BaseApplication.getContext()))) {
      MagnifierSDK.a().a().a("requestSoso", new Object[] { Integer.valueOf(-1), Boolean.valueOf(false), "LocationHandler", localInteger, localInteger, localInteger, localInteger });
    }
    if (QLog.isColorLevel())
    {
      paramTencentLocation = new StringBuilder();
      paramTencentLocation.append("[LocationManager] onLocationChanged: invoked. errorCode: ");
      paramTencentLocation.append(paramInt);
      paramTencentLocation.append(" errorMsg: ");
      paramTencentLocation.append(paramString);
      QLog.d("Q.LocationShare", 2, paramTencentLocation.toString());
    }
  }
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationShareLocationManager.2
 * JD-Core Version:    0.7.0.1
 */