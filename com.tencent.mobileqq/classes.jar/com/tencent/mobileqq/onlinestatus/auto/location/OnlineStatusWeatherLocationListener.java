package com.tencent.mobileqq.onlinestatus.auto.location;

import android.content.Intent;
import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.util.WeakReference;

public class OnlineStatusWeatherLocationListener
  extends SosoInterfaceOnLocationListener
{
  private static PoiLoader d = new PoiLoader("weather", 1000, 3, 1);
  private int a;
  private Intent b;
  private WeakReference<OnlineStatusWeatherLocationListener.WeatherLocationCallback> c;
  
  public OnlineStatusWeatherLocationListener(int paramInt, Intent paramIntent, OnlineStatusWeatherLocationListener.WeatherLocationCallback paramWeatherLocationCallback)
  {
    super(0, true, true, 60000L, false, false, "official_location");
    this.a = paramInt;
    this.b = paramIntent;
    this.c = new WeakReference(paramWeatherLocationCallback);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (this.c.get() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("OnlineStatusWeatherLocationListener", 2, "[MovementDetector] onLocationFinish error. mCallback is null ");
      }
      return;
    }
    if ((paramSosoLbsInfo != null) && (paramInt == 0))
    {
      LatLng localLatLng = new LatLng(paramSosoLbsInfo.mLocation.mLat02, paramSosoLbsInfo.mLocation.mLon02);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[MovementDetector] onLocationFinish invoked. latLng : ");
        localStringBuilder.append(localLatLng);
        localStringBuilder.append(" errCode : ");
        localStringBuilder.append(paramInt);
        QLog.e("OnlineStatusWeatherLocationListener", 2, localStringBuilder.toString());
      }
      try
      {
        d.a(localLatLng, new OnlineStatusWeatherLocationListener.1(this, localLatLng, paramSosoLbsInfo, paramInt));
        return;
      }
      catch (Throwable paramSosoLbsInfo)
      {
        QLog.e("OnlineStatusWeatherLocationListener", 1, "getPoiWithLatLngError", paramSosoLbsInfo);
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      paramSosoLbsInfo = new StringBuilder();
      paramSosoLbsInfo.append("[MovementDetector] onLocationFinish error. errCode : ");
      paramSosoLbsInfo.append(paramInt);
      QLog.e("OnlineStatusWeatherLocationListener", 2, paramSosoLbsInfo.toString());
    }
    ((OnlineStatusWeatherLocationListener.WeatherLocationCallback)this.c.get()).a(paramInt, 0.0D, 0.0D, "", "", this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.OnlineStatusWeatherLocationListener
 * JD-Core Version:    0.7.0.1
 */