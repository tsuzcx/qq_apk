package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

class DiskLoader$1
  implements PoiLoader.OnPoiLoadListener
{
  DiskLoader$1(DiskLoader paramDiskLoader, LatLng paramLatLng, int paramInt, PoiBean paramPoiBean) {}
  
  public void a(PoiBean paramPoiBean)
  {
    if (QLog.isColorLevel())
    {
      String str = Loader.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][poiLoader][");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCacheDiskLoader.b);
      localStringBuilder.append("] diskPut [fail already exist]. latLng: ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
      localStringBuilder.append(" acceptAccuracy: ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" put: ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiBean);
      localStringBuilder.append(" cache: ");
      localStringBuilder.append(paramPoiBean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.DiskLoader.1
 * JD-Core Version:    0.7.0.1
 */