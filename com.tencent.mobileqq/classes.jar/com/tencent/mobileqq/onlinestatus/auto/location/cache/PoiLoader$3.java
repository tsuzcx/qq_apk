package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

class PoiLoader$3
  implements PoiLoader.OnPoiLoadListener
{
  PoiLoader$3(PoiLoader paramPoiLoader, LatLng paramLatLng, int paramInt, PoiLoader.OnPoiLoadListener paramOnPoiLoadListener) {}
  
  public void a(PoiBean paramPoiBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PoiLoader", 2, "[status][poiLoader][" + PoiLoader.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader) + "] loadPoiFromDisk. latLng: " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " poiBean: " + paramPoiBean);
    }
    if (paramPoiBean != null) {
      PoiLoader.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader).a(paramPoiBean.latLng, this.jdField_a_of_type_Int, paramPoiBean);
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader$OnPoiLoadListener.a(paramPoiBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.3
 * JD-Core Version:    0.7.0.1
 */