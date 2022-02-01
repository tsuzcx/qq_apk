package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import axxo;
import axxv;
import axxw;
import com.tencent.qphone.base.util.QLog;

public class PoiLoader$2$1
  implements Runnable
{
  public PoiLoader$2$1(axxw paramaxxw, PoiBean paramPoiBean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PoiLoader", 2, "[status][poiLoader][" + axxv.a(this.jdField_a_of_type_Axxw.jdField_a_of_type_Axxv) + "] persist. latLng: " + this.jdField_a_of_type_Axxw.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " poiBean: " + this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean != null) {
      axxv.a(this.jdField_a_of_type_Axxw.jdField_a_of_type_Axxv).a(this.jdField_a_of_type_Axxw.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, axxv.a(this.jdField_a_of_type_Axxw.jdField_a_of_type_Axxv), this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.2.1
 * JD-Core Version:    0.7.0.1
 */