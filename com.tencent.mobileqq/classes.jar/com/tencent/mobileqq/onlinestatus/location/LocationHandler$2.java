package com.tencent.mobileqq.onlinestatus.location;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.os.MqqHandler;

class LocationHandler$2
  implements TencentLocationListener
{
  private volatile boolean d = true;
  private Runnable e = this.a;
  
  LocationHandler$2(LocationHandler paramLocationHandler, Runnable paramRunnable, MqqHandler paramMqqHandler) {}
  
  public void onLocationChanged(TencentLocation paramTencentLocation, int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      LatLng localLatLng2 = new LatLng(paramTencentLocation.getLatitude(), paramTencentLocation.getLongitude());
      LatLng localLatLng1 = localLatLng2;
      if (QLog.isColorLevel())
      {
        localLatLng1 = localLatLng2;
        if (LocationHandler.a != null) {
          localLatLng1 = LocationHandler.a;
        }
      }
      if ((localLatLng1.getLatitude() == 0.0D) && (localLatLng1.getLongitude() == 0.0D))
      {
        if (this.d)
        {
          this.d = false;
          QLog.e("LocationHandler", 1, "[LocationManager] onLocationChanged: invoked. (0,0) detected");
        }
        return;
      }
      LocationHandler.a(this.c, paramTencentLocation);
    }
    if (this.e != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "[LocationManager] onLocationChanged: invoked. remove over time runnable");
      }
      this.b.removeCallbacks(this.e);
      this.e = null;
    }
    if (paramInt == 0) {
      LocationHandler.a(this.c, true);
    }
    if (QLog.isColorLevel())
    {
      paramTencentLocation = new StringBuilder();
      paramTencentLocation.append("[LocationManager] onLocationChanged: invoked. errorCode: ");
      paramTencentLocation.append(paramInt);
      paramTencentLocation.append(" errorMsg: ");
      paramTencentLocation.append(paramString);
      QLog.d("LocationHandler", 2, paramTencentLocation.toString());
    }
  }
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.location.LocationHandler.2
 * JD-Core Version:    0.7.0.1
 */