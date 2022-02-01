package com.tencent.mobileqq.onlinestatus.auto.location;

import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

class PoiCache$PoiKey
{
  private LatLng jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng;
  
  public PoiCache$PoiKey(PoiCache paramPoiCache, LatLng paramLatLng)
  {
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng = paramLatLng;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    double d;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (PoiKey)paramObject;
      d = LocationUtil.a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, paramObject.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
      if (QLog.isColorLevel()) {
        QLog.d("PoiCache", 2, "[status][poiCache][" + PoiCache.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationPoiCache) + "] equals? this.latLng: " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " that.latLng: " + paramObject.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " distance: " + d + " validDistance: " + PoiCache.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationPoiCache));
      }
    } while (d < PoiCache.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationPoiCache));
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.PoiCache.PoiKey
 * JD-Core Version:    0.7.0.1
 */