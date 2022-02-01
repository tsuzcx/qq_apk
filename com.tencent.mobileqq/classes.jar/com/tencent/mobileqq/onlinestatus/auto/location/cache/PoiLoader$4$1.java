package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import com.tencent.qphone.base.util.QLog;

class PoiLoader$4$1
  implements Runnable
{
  PoiLoader$4$1(PoiLoader.4 param4, PoiBean paramPoiBean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PoiLoader", 2, "[status][poiLoader][" + PoiLoader.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader$4.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader) + "] loadPoiFromNetwork. latLng: " + this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader$4.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " poiBean: " + this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean != null) {
      PoiLoader.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader$4.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader).a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean.latLng, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader$4.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean);
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader$4.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader$OnPoiLoadListener.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.4.1
 * JD-Core Version:    0.7.0.1
 */