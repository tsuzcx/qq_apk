package com.tencent.mobileqq.location.api.impl;

import com.tencent.mobileqq.location.api.ILocationUtilApi;
import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.ui.MapUtils;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.Collection;

public class LocationUtilApiImpl
  implements ILocationUtilApi
{
  public LatLng getCenterLatLng(Collection<LocationItem> paramCollection)
  {
    return MapUtils.a(paramCollection);
  }
  
  public String getClassName()
  {
    return LocationHandler.class.getName();
  }
  
  public double getDistance(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    return MapUtils.a(paramLatLng1, paramLatLng2);
  }
  
  public String getDurationText(double paramDouble)
  {
    return MapUtils.a(paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.api.impl.LocationUtilApiImpl
 * JD-Core Version:    0.7.0.1
 */