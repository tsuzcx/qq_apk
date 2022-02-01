package com.tencent.mobileqq.onlinestatus.auto.location;

import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

class PoiCache$PoiKey
{
  private LatLng b;
  
  public PoiCache$PoiKey(PoiCache paramPoiCache, LatLng paramLatLng)
  {
    this.b = paramLatLng;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (PoiKey)paramObject;
      double d = LocationUtil.a(this.b, paramObject.b);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][poiCache][");
        localStringBuilder.append(PoiCache.a(this.a));
        localStringBuilder.append("] equals? this.latLng: ");
        localStringBuilder.append(this.b);
        localStringBuilder.append(" that.latLng: ");
        localStringBuilder.append(paramObject.b);
        localStringBuilder.append(" distance: ");
        localStringBuilder.append(d);
        localStringBuilder.append(" validDistance: ");
        localStringBuilder.append(PoiCache.b(this.a));
        QLog.d("PoiCache", 2, localStringBuilder.toString());
      }
      return d < PoiCache.b(this.a);
    }
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.PoiCache.PoiKey
 * JD-Core Version:    0.7.0.1
 */