package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import azeh;
import azel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class PoiLoader$1
  implements Runnable
{
  public PoiLoader$1(azeh paramazeh, LatLng paramLatLng, azel paramazel) {}
  
  public void run()
  {
    if (azeh.a(this.this$0, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, azeh.a(this.this$0), this.jdField_a_of_type_Azel)) {
      if (QLog.isColorLevel()) {
        QLog.i("PoiLoader", 2, "[status][poiLoader][" + azeh.a(this.this$0) + "] loadPoi loadPoiFromMemory. latLng: " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " onCompleted.");
      }
    }
    do
    {
      do
      {
        return;
        if (!azeh.b(this.this$0, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, azeh.a(this.this$0), this.jdField_a_of_type_Azel)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("PoiLoader", 2, "[status][poiLoader][" + azeh.a(this.this$0) + "] loadPoi loadPoiFromDisk. latLng: " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " onCompleted.");
      return;
      azeh.a(this.this$0, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, azeh.a(this.this$0), this.jdField_a_of_type_Azel);
    } while (!QLog.isColorLevel());
    QLog.i("PoiLoader", 2, "[status][poiLoader][" + azeh.a(this.this$0) + "] loadPoi loadPoiFromNetwork. latLng: " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " onCompleted.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.1
 * JD-Core Version:    0.7.0.1
 */