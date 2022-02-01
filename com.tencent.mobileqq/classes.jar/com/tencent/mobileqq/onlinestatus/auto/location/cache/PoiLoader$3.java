package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

class PoiLoader$3
  implements PoiLoader.OnPoiLoadListener
{
  PoiLoader$3(PoiLoader paramPoiLoader, LatLng paramLatLng, int paramInt, PoiLoader.OnPoiLoadListener paramOnPoiLoadListener) {}
  
  public void a(PoiBean paramPoiBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][poiLoader][");
      localStringBuilder.append(PoiLoader.b(this.d));
      localStringBuilder.append("] loadPoiFromDisk. latLng: ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" poiBean: ");
      localStringBuilder.append(paramPoiBean);
      QLog.d("PoiLoader", 2, localStringBuilder.toString());
    }
    if (paramPoiBean != null) {
      this.d.a.a(paramPoiBean.latLng, this.b, paramPoiBean);
    }
    this.c.a(paramPoiBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.3
 * JD-Core Version:    0.7.0.1
 */