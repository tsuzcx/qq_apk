package com.tencent.mobileqq.location.net;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.ui.LocationShareController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.monitor.base.IAPMModuleBattery;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.os.MqqHandler;

class LocationHandler$4
  implements TencentLocationListener
{
  private Runnable jdField_b_of_type_JavaLangRunnable;
  private volatile boolean jdField_b_of_type_Boolean = true;
  private volatile boolean c;
  
  LocationHandler$4(LocationHandler paramLocationHandler, boolean paramBoolean, Runnable paramRunnable, MqqHandler paramMqqHandler, LocationRoom paramLocationRoom)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.c = paramBoolean;
      this.jdField_b_of_type_JavaLangRunnable = this.jdField_a_of_type_JavaLangRunnable;
      return;
    }
  }
  
  public void onLocationChanged(TencentLocation paramTencentLocation, int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      LatLng localLatLng = new LatLng(paramTencentLocation.getLatitude(), paramTencentLocation.getLongitude());
      paramTencentLocation = localLatLng;
      if (QLog.isColorLevel())
      {
        paramTencentLocation = localLatLng;
        if (LocationHandler.a != null) {
          paramTencentLocation = LocationHandler.a;
        }
      }
      if ((paramTencentLocation.getLatitude() == 0.0D) && (paramTencentLocation.getLongitude() == 0.0D))
      {
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = false;
          QLog.e("LocationHandler", 1, "[LocationManager] onLocationChanged: invoked. (0,0) detected");
        }
        return;
      }
      LocationHandler.a(this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler, paramTencentLocation);
    }
    if ((this.c) && (this.jdField_b_of_type_JavaLangRunnable != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "[LocationManager] onLocationChanged: invoked. remove over time runnable");
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
    if (paramInt != 0)
    {
      paramTencentLocation = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
      LocationShareController.a(LocationHandler.a(this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler), paramTencentLocation.a(), paramTencentLocation.a(), 1);
    }
    for (;;)
    {
      if ((paramInt == 0) || (HwNetworkUtil.isNetworkAvailable(BaseApplication.getContext()))) {
        MagnifierSDK.a().a().a("requestSoso", new Object[] { Integer.valueOf(-1), Boolean.valueOf(false), "LocationHandler", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("LocationHandler", 2, "[LocationManager] onLocationChanged: invoked. errorCode: " + paramInt + " errorMsg: " + paramString);
      return;
      if (this.c)
      {
        this.c = false;
        this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler.a(LocationHandler.a(this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler).a(), LocationHandler.a(this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler).a());
      }
      LocationHandler.a(this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler, true);
    }
  }
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationHandler.4
 * JD-Core Version:    0.7.0.1
 */