package com.tencent.mobileqq.onlinestatus.auto.location;

import android.content.Intent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class LocationUtil
{
  private static double a(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }
  
  private static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble1 = a(paramDouble1);
    paramDouble3 = a(paramDouble3);
    paramDouble2 = a(paramDouble2);
    paramDouble4 = a(paramDouble4);
    double d = Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D);
    return Math.asin(Math.sqrt(Math.cos(paramDouble1) * Math.cos(paramDouble3) * Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D) + d)) * 2.0D * 6378137.0D;
  }
  
  public static double a(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    return a(paramLatLng1.latitude, paramLatLng1.longitude, paramLatLng2.latitude, paramLatLng2.longitude);
  }
  
  public static void a(int paramInt, Intent paramIntent, OnlineStatusWeatherLocationListener.WeatherLocationCallback paramWeatherLocationCallback)
  {
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new OnlineStatusWeatherLocationListener(paramInt, paramIntent, paramWeatherLocationCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.LocationUtil
 * JD-Core Version:    0.7.0.1
 */