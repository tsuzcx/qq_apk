package com.tencent.mobileqq.location.api;

import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.Collection;

@QAPI(process={"all"})
public abstract interface ILocationUtilApi
  extends QRouteApi
{
  public abstract LatLng getCenterLatLng(Collection<LocationItem> paramCollection);
  
  public abstract String getClassName();
  
  public abstract double getDistance(LatLng paramLatLng1, LatLng paramLatLng2);
  
  public abstract String getDurationText(double paramDouble);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.api.ILocationUtilApi
 * JD-Core Version:    0.7.0.1
 */