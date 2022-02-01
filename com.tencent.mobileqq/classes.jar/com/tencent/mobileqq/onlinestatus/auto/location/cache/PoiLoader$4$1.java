package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import axxr;
import axxv;
import axxy;
import axxz;
import com.tencent.qphone.base.util.QLog;

public class PoiLoader$4$1
  implements Runnable
{
  public PoiLoader$4$1(axxy paramaxxy, PoiBean paramPoiBean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PoiLoader", 2, "[status][poiLoader][" + axxv.a(this.jdField_a_of_type_Axxy.jdField_a_of_type_Axxv) + "] loadPoiFromNetwork. latLng: " + this.jdField_a_of_type_Axxy.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " poiBean: " + this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean != null) {
      axxv.a(this.jdField_a_of_type_Axxy.jdField_a_of_type_Axxv).a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean.latLng, this.jdField_a_of_type_Axxy.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean);
    }
    this.jdField_a_of_type_Axxy.jdField_a_of_type_Axxz.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.4.1
 * JD-Core Version:    0.7.0.1
 */