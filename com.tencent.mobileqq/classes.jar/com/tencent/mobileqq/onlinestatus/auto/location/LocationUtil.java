package com.tencent.mobileqq.onlinestatus.auto.location;

import android.content.Intent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class LocationUtil
{
  private static SosoLbsInfo a;
  private static String b;
  private static String c;
  
  private static double a(double paramDouble)
  {
    return paramDouble * 3.141592653589793D / 180.0D;
  }
  
  private static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble1 = a(paramDouble1);
    paramDouble3 = a(paramDouble3);
    paramDouble2 = a(paramDouble2);
    paramDouble4 = a(paramDouble4);
    return Math.asin(Math.sqrt(Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D) + Math.cos(paramDouble1) * Math.cos(paramDouble3) * Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D))) * 2.0D * 6378137.0D;
  }
  
  public static double a(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    return a(paramLatLng1.latitude, paramLatLng1.longitude, paramLatLng2.latitude, paramLatLng2.longitude);
  }
  
  public static void a(int paramInt, Intent paramIntent, OnlineStatusWeatherLocationListener.WeatherLocationCallback paramWeatherLocationCallback)
  {
    boolean bool = paramIntent.getBooleanExtra("isAppForeground", false);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[status][LocationUtil] isAppForeground : ");
      ((StringBuilder)localObject).append(bool);
      QLog.e("LocationHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (bool)
    {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new OnlineStatusWeatherLocationListener(paramInt, paramIntent, paramWeatherLocationCallback));
      return;
    }
    Object localObject = a;
    if ((localObject != null) && (b != null) && (c != null))
    {
      localObject = new LatLng(((SosoLbsInfo)localObject).mLocation.mLat02, a.mLocation.mLon02);
      paramWeatherLocationCallback.a(0, ((LatLng)localObject).latitude, ((LatLng)localObject).longitude, b, c, paramInt, paramIntent);
    }
  }
  
  public static void a(SosoLbsInfo paramSosoLbsInfo, String paramString1, String paramString2)
  {
    a = paramSosoLbsInfo;
    b = paramString1;
    c = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.LocationUtil
 * JD-Core Version:    0.7.0.1
 */