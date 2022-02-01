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
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (PoiKey)paramObject;
      double d = LocationUtil.a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, paramObject.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][poiCache][");
        localStringBuilder.append(PoiCache.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationPoiCache));
        localStringBuilder.append("] equals? this.latLng: ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
        localStringBuilder.append(" that.latLng: ");
        localStringBuilder.append(paramObject.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
        localStringBuilder.append(" distance: ");
        localStringBuilder.append(d);
        localStringBuilder.append(" validDistance: ");
        localStringBuilder.append(PoiCache.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationPoiCache));
        QLog.d("PoiCache", 2, localStringBuilder.toString());
      }
      return d < PoiCache.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationPoiCache);
    }
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.PoiCache.PoiKey
 * JD-Core Version:    0.7.0.1
 */