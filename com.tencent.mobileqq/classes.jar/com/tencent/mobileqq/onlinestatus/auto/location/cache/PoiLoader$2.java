package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.os.MqqHandler;

class PoiLoader$2
  implements PoiLoader.OnPoiLoadListener
{
  PoiLoader$2(PoiLoader paramPoiLoader, LatLng paramLatLng) {}
  
  public void a(PoiBean paramPoiBean)
  {
    ThreadManager.getSubThreadHandler().post(new PoiLoader.2.1(this, paramPoiBean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.2
 * JD-Core Version:    0.7.0.1
 */