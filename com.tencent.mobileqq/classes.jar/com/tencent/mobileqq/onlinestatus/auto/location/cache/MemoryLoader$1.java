package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

class MemoryLoader$1
  implements PoiLoader.OnPoiLoadListener
{
  MemoryLoader$1(MemoryLoader paramMemoryLoader, LatLng paramLatLng, int paramInt, PoiBean paramPoiBean) {}
  
  public void a(PoiBean paramPoiBean)
  {
    if (QLog.isColorLevel()) {
      QLog.e(Loader.a, 2, "[status][poiLoader][" + this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCacheMemoryLoader.b + "] memPut [fail already exist]. latLng: " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " acceptAccuracy: " + this.jdField_a_of_type_Int + " put: " + this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean + " cache: " + paramPoiBean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.MemoryLoader.1
 * JD-Core Version:    0.7.0.1
 */