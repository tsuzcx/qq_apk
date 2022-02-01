package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import ayrq;
import ayru;
import ayrx;
import ayry;
import com.tencent.qphone.base.util.QLog;

public class PoiLoader$4$1
  implements Runnable
{
  public PoiLoader$4$1(ayrx paramayrx, PoiBean paramPoiBean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PoiLoader", 2, "[status][poiLoader][" + ayru.a(this.jdField_a_of_type_Ayrx.jdField_a_of_type_Ayru) + "] loadPoiFromNetwork. latLng: " + this.jdField_a_of_type_Ayrx.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " poiBean: " + this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean != null) {
      ayru.a(this.jdField_a_of_type_Ayrx.jdField_a_of_type_Ayru).a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean.latLng, this.jdField_a_of_type_Ayrx.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean);
    }
    this.jdField_a_of_type_Ayrx.jdField_a_of_type_Ayry.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.4.1
 * JD-Core Version:    0.7.0.1
 */