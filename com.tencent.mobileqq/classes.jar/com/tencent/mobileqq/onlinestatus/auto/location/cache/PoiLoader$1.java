package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

class PoiLoader$1
  implements Runnable
{
  PoiLoader$1(PoiLoader paramPoiLoader, LatLng paramLatLng, PoiLoader.OnPoiLoadListener paramOnPoiLoadListener) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    if (PoiLoader.a((PoiLoader)localObject, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, PoiLoader.a((PoiLoader)localObject), this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader$OnPoiLoadListener))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[status][poiLoader][");
        ((StringBuilder)localObject).append(PoiLoader.a(this.this$0));
        ((StringBuilder)localObject).append("] loadPoi loadPoiFromMemory. latLng: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
        ((StringBuilder)localObject).append(" onCompleted.");
        QLog.i("PoiLoader", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    localObject = this.this$0;
    if (PoiLoader.b((PoiLoader)localObject, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, PoiLoader.a((PoiLoader)localObject), this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader$OnPoiLoadListener))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[status][poiLoader][");
        ((StringBuilder)localObject).append(PoiLoader.a(this.this$0));
        ((StringBuilder)localObject).append("] loadPoi loadPoiFromDisk. latLng: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
        ((StringBuilder)localObject).append(" onCompleted.");
        QLog.i("PoiLoader", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    localObject = this.this$0;
    PoiLoader.a((PoiLoader)localObject, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, PoiLoader.a((PoiLoader)localObject), this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader$OnPoiLoadListener);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[status][poiLoader][");
      ((StringBuilder)localObject).append(PoiLoader.a(this.this$0));
      ((StringBuilder)localObject).append("] loadPoi loadPoiFromNetwork. latLng: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
      ((StringBuilder)localObject).append(" onCompleted.");
      QLog.i("PoiLoader", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.1
 * JD-Core Version:    0.7.0.1
 */