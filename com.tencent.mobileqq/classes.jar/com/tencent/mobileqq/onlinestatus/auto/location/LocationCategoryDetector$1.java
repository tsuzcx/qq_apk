package com.tencent.mobileqq.onlinestatus.auto.location;

import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiBean;
import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.OnPoiLoadListener;
import com.tencent.qphone.base.util.QLog;

class LocationCategoryDetector$1
  implements PoiLoader.OnPoiLoadListener
{
  LocationCategoryDetector$1(LocationCategoryDetector paramLocationCategoryDetector) {}
  
  public void a(PoiBean paramPoiBean)
  {
    try
    {
      this.a.a(paramPoiBean);
      return;
    }
    catch (Throwable paramPoiBean)
    {
      QLog.e("LocationCategoryDetector", 1, "getPoiResultError", paramPoiBean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.LocationCategoryDetector.1
 * JD-Core Version:    0.7.0.1
 */