package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import azkn;
import azkr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class PoiLoader$1
  implements Runnable
{
  public PoiLoader$1(azkn paramazkn, LatLng paramLatLng, azkr paramazkr) {}
  
  public void run()
  {
    if (azkn.a(this.this$0, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, azkn.a(this.this$0), this.jdField_a_of_type_Azkr)) {
      if (QLog.isColorLevel()) {
        QLog.i("PoiLoader", 2, "[status][poiLoader][" + azkn.a(this.this$0) + "] loadPoi loadPoiFromMemory. latLng: " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " onCompleted.");
      }
    }
    do
    {
      do
      {
        return;
        if (!azkn.b(this.this$0, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, azkn.a(this.this$0), this.jdField_a_of_type_Azkr)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("PoiLoader", 2, "[status][poiLoader][" + azkn.a(this.this$0) + "] loadPoi loadPoiFromDisk. latLng: " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " onCompleted.");
      return;
      azkn.a(this.this$0, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, azkn.a(this.this$0), this.jdField_a_of_type_Azkr);
    } while (!QLog.isColorLevel());
    QLog.i("PoiLoader", 2, "[status][poiLoader][" + azkn.a(this.this$0) + "] loadPoi loadPoiFromNetwork. latLng: " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " onCompleted.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.1
 * JD-Core Version:    0.7.0.1
 */