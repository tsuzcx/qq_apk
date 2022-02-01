package com.tencent.mobileqq.onlinestatus.location;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.os.MqqHandler;

class LocationHandler$2
  implements TencentLocationListener
{
  private volatile boolean jdField_a_of_type_Boolean = true;
  private Runnable b = this.jdField_a_of_type_JavaLangRunnable;
  
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
      if ((localLatLng1.getLatitude() == 0.0D) && (localLatLng1.getLongitude() == 0.0D)) {
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = false;
          QLog.e("LocationHandler", 1, "[LocationManager] onLocationChanged: invoked. (0,0) detected");
        }
      }
    }
    do
    {
      return;
      LocationHandler.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationHandler, paramTencentLocation);
      if (this.b != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LocationHandler", 2, "[LocationManager] onLocationChanged: invoked. remove over time runnable");
        }
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.b);
        this.b = null;
      }
      if (paramInt == 0) {
        LocationHandler.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationLocationHandler, true);
      }
    } while (!QLog.isColorLevel());
    QLog.d("LocationHandler", 2, "[LocationManager] onLocationChanged: invoked. errorCode: " + paramInt + " errorMsg: " + paramString);
  }
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.location.LocationHandler.2
 * JD-Core Version:    0.7.0.1
 */