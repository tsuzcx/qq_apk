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
  private static PoiLoader jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader = new PoiLoader("weather", 1000, 3, 1);
  private int jdField_a_of_type_Int;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private WeakReference<OnlineStatusWeatherLocationListener.WeatherLocationCallback> jdField_a_of_type_MqqUtilWeakReference;
  
  public OnlineStatusWeatherLocationListener(int paramInt, Intent paramIntent, OnlineStatusWeatherLocationListener.WeatherLocationCallback paramWeatherLocationCallback)
  {
    super(0, true, true, 60000L, false, false, "official_location");
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramWeatherLocationCallback);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("OnlineStatusWeatherLocationListener", 2, "[MovementDetector] onLocationFinish error. mCallback is null ");
      }
      return;
    }
    if ((paramSosoLbsInfo != null) && (paramInt == 0))
    {
      paramSosoLbsInfo = new LatLng(paramSosoLbsInfo.mLocation.mLat02, paramSosoLbsInfo.mLocation.mLon02);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[MovementDetector] onLocationFinish invoked. latLng : ");
        localStringBuilder.append(paramSosoLbsInfo);
        localStringBuilder.append(" errCode : ");
        localStringBuilder.append(paramInt);
        QLog.e("OnlineStatusWeatherLocationListener", 2, localStringBuilder.toString());
      }
      try
      {
        jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationCachePoiLoader.a(paramSosoLbsInfo, new OnlineStatusWeatherLocationListener.1(this, paramSosoLbsInfo, paramInt));
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
    ((OnlineStatusWeatherLocationListener.WeatherLocationCallback)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramInt, 0.0D, 0.0D, "", "", this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.OnlineStatusWeatherLocationListener
 * JD-Core Version:    0.7.0.1
 */