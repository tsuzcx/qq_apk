package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import com.tencent.qphone.base.util.QLog;

class PoiLoader$4$1
  implements Runnable
{
  PoiLoader$4$1(PoiLoader.4 param4, PoiBean paramPoiBean) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][poiLoader][");
      localStringBuilder.append(PoiLoader.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader$4.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader));
      localStringBuilder.append("] loadPoiFromNetwork. latLng: ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader$4.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
      localStringBuilder.append(" poiBean: ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean);
      QLog.d("PoiLoader", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean != null) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader$4.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader.a.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean.latLng, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader$4.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean);
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader$4.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader$OnPoiLoadListener.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.4.1
 * JD-Core Version:    0.7.0.1
 */