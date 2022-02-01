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
  private volatile boolean f = true;
  private volatile boolean g = true ^ this.a;
  private Runnable h = this.b;
  
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
        if (LocationShareLocationManager.b != null) {
          paramTencentLocation = LocationShareLocationManager.b;
        }
      }
      if ((paramTencentLocation.getLatitude() == 0.0D) && (paramTencentLocation.getLongitude() == 0.0D))
      {
        if (this.f)
        {
          this.f = false;
          QLog.e("Q.LocationShare", 1, "[LocationManager] onLocationChanged: invoked. (0,0) detected");
        }
        return;
      }
      LocationShareLocationManager.a(this.e, paramTencentLocation);
    }
    if ((this.g) && (this.h != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.LocationShare", 2, "[LocationManager] onLocationChanged: invoked. remove over time runnable");
      }
      this.c.removeCallbacks(this.h);
      this.h = null;
    }
    if (paramInt != 0)
    {
      paramTencentLocation = this.d.e();
      LocationShareViewModel.a((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null), paramTencentLocation.a(), paramTencentLocation.b(), 1);
    }
    else
    {
      if (this.g)
      {
        this.g = false;
        LocationShareRoomManager.a().a(LocationShareLocationManager.a(this.e).a(), LocationShareLocationManager.a(this.e).b());
      }
      LocationShareLocationManager.a().a(true);
    }
    if ((paramInt == 0) || (HwNetworkUtil.isNetworkAvailable(BaseApplication.getContext()))) {
      MagnifierSDK.b().i().a("requestSoso", new Object[] { Integer.valueOf(-1), Boolean.valueOf(false), "LocationHandler", localInteger, localInteger, localInteger, localInteger });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationShareLocationManager.2
 * JD-Core Version:    0.7.0.1
 */