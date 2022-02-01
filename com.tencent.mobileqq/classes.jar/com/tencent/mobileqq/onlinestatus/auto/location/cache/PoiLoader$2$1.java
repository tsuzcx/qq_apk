package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import azea;
import azeh;
import azei;
import com.tencent.qphone.base.util.QLog;

public class PoiLoader$2$1
  implements Runnable
{
  public PoiLoader$2$1(azei paramazei, PoiBean paramPoiBean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PoiLoader", 2, "[status][poiLoader][" + azeh.a(this.jdField_a_of_type_Azei.jdField_a_of_type_Azeh) + "] persist. latLng: " + this.jdField_a_of_type_Azei.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " poiBean: " + this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean != null) {
      azeh.a(this.jdField_a_of_type_Azei.jdField_a_of_type_Azeh).a(this.jdField_a_of_type_Azei.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, azeh.a(this.jdField_a_of_type_Azei.jdField_a_of_type_Azeh), this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.2.1
 * JD-Core Version:    0.7.0.1
 */