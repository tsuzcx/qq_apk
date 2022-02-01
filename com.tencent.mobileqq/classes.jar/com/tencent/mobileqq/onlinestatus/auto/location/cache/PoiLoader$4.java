package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.os.MqqHandler;

class PoiLoader$4
  implements PoiLoader.OnPoiLoadListener
{
  PoiLoader$4(PoiLoader paramPoiLoader, LatLng paramLatLng, int paramInt, PoiLoader.OnPoiLoadListener paramOnPoiLoadListener) {}
  
  public void a(PoiBean paramPoiBean)
  {
    ThreadManager.getSubThreadHandler().post(new PoiLoader.4.1(this, paramPoiBean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.4
 * JD-Core Version:    0.7.0.1
 */