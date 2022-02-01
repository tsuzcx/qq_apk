package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

class PoiLoader$1
  implements Runnable
{
  PoiLoader$1(PoiLoader paramPoiLoader, LatLng paramLatLng, PoiLoader.OnPoiLoadListener paramOnPoiLoadListener) {}
  
  public void run()
  {
    if (PoiLoader.a(this.this$0, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, PoiLoader.a(this.this$0), this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader$OnPoiLoadListener)) {
      if (QLog.isColorLevel()) {
        QLog.i("PoiLoader", 2, "[status][poiLoader][" + PoiLoader.a(this.this$0) + "] loadPoi loadPoiFromMemory. latLng: " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " onCompleted.");
      }
    }
    do
    {
      do
      {
        return;
        if (!PoiLoader.b(this.this$0, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, PoiLoader.a(this.this$0), this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader$OnPoiLoadListener)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("PoiLoader", 2, "[status][poiLoader][" + PoiLoader.a(this.this$0) + "] loadPoi loadPoiFromDisk. latLng: " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " onCompleted.");
      return;
      PoiLoader.a(this.this$0, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, PoiLoader.a(this.this$0), this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader$OnPoiLoadListener);
    } while (!QLog.isColorLevel());
    QLog.i("PoiLoader", 2, "[status][poiLoader][" + PoiLoader.a(this.this$0) + "] loadPoi loadPoiFromNetwork. latLng: " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " onCompleted.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.1
 * JD-Core Version:    0.7.0.1
 */