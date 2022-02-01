package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import azkg;
import azkn;
import azko;
import com.tencent.qphone.base.util.QLog;

public class PoiLoader$2$1
  implements Runnable
{
  public PoiLoader$2$1(azko paramazko, PoiBean paramPoiBean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PoiLoader", 2, "[status][poiLoader][" + azkn.a(this.jdField_a_of_type_Azko.jdField_a_of_type_Azkn) + "] persist. latLng: " + this.jdField_a_of_type_Azko.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " poiBean: " + this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean != null) {
      azkn.a(this.jdField_a_of_type_Azko.jdField_a_of_type_Azkn).a(this.jdField_a_of_type_Azko.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, azkn.a(this.jdField_a_of_type_Azko.jdField_a_of_type_Azkn), this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.2.1
 * JD-Core Version:    0.7.0.1
 */