package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import ayrn;
import ayru;
import ayrv;
import com.tencent.qphone.base.util.QLog;

public class PoiLoader$2$1
  implements Runnable
{
  public PoiLoader$2$1(ayrv paramayrv, PoiBean paramPoiBean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PoiLoader", 2, "[status][poiLoader][" + ayru.a(this.jdField_a_of_type_Ayrv.jdField_a_of_type_Ayru) + "] persist. latLng: " + this.jdField_a_of_type_Ayrv.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " poiBean: " + this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean != null) {
      ayru.a(this.jdField_a_of_type_Ayrv.jdField_a_of_type_Ayru).a(this.jdField_a_of_type_Ayrv.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, ayru.a(this.jdField_a_of_type_Ayrv.jdField_a_of_type_Ayru), this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.2.1
 * JD-Core Version:    0.7.0.1
 */