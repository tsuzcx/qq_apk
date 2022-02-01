package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import axxv;
import axxz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class PoiLoader$1
  implements Runnable
{
  public PoiLoader$1(axxv paramaxxv, LatLng paramLatLng, axxz paramaxxz) {}
  
  public void run()
  {
    if (axxv.a(this.this$0, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, axxv.a(this.this$0), this.jdField_a_of_type_Axxz)) {
      if (QLog.isColorLevel()) {
        QLog.i("PoiLoader", 2, "[status][poiLoader][" + axxv.a(this.this$0) + "] loadPoi loadPoiFromMemory. latLng: " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " onCompleted.");
      }
    }
    do
    {
      do
      {
        return;
        if (!axxv.b(this.this$0, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, axxv.a(this.this$0), this.jdField_a_of_type_Axxz)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("PoiLoader", 2, "[status][poiLoader][" + axxv.a(this.this$0) + "] loadPoi loadPoiFromDisk. latLng: " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " onCompleted.");
      return;
      axxv.a(this.this$0, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, axxv.a(this.this$0), this.jdField_a_of_type_Axxz);
    } while (!QLog.isColorLevel());
    QLog.i("PoiLoader", 2, "[status][poiLoader][" + axxv.a(this.this$0) + "] loadPoi loadPoiFromNetwork. latLng: " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " onCompleted.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.1
 * JD-Core Version:    0.7.0.1
 */