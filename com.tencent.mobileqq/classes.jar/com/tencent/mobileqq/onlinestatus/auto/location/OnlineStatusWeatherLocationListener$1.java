package com.tencent.mobileqq.onlinestatus.auto.location;

import android.text.TextUtils;
import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiBean;
import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.OnPoiLoadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.util.WeakReference;

class OnlineStatusWeatherLocationListener$1
  implements PoiLoader.OnPoiLoadListener
{
  OnlineStatusWeatherLocationListener$1(OnlineStatusWeatherLocationListener paramOnlineStatusWeatherLocationListener, LatLng paramLatLng, int paramInt) {}
  
  public void a(PoiBean paramPoiBean)
  {
    OnlineStatusWeatherLocationListener.WeatherLocationCallback localWeatherLocationCallback = (OnlineStatusWeatherLocationListener.WeatherLocationCallback)OnlineStatusWeatherLocationListener.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationOnlineStatusWeatherLocationListener).get();
    if (localWeatherLocationCallback == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("OnlineStatusWeatherLocationListener", 2, "[MovementDetector] getPoiWithLatLng error. mCallback is null ");
      }
      return;
    }
    if ((paramPoiBean == null) || (paramPoiBean.adInfo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("OnlineStatusWeatherLocationListener", 2, "[MovementDetector] getPoiWithLatLng error. adInfo is null ");
      }
      localWeatherLocationCallback.a(404, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng.latitude, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng.longitude, "", "", OnlineStatusWeatherLocationListener.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationOnlineStatusWeatherLocationListener), OnlineStatusWeatherLocationListener.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationOnlineStatusWeatherLocationListener));
      return;
    }
    String str1;
    if (TextUtils.isEmpty(paramPoiBean.adInfo.city))
    {
      str1 = "";
      if (!TextUtils.isEmpty(paramPoiBean.adInfo.district)) {
        break label213;
      }
    }
    label213:
    for (String str2 = "";; str2 = paramPoiBean.adInfo.district)
    {
      str1 = str1 + str2;
      localWeatherLocationCallback.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng.latitude, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng.longitude, paramPoiBean.adInfo.adcode, str1, OnlineStatusWeatherLocationListener.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationOnlineStatusWeatherLocationListener), OnlineStatusWeatherLocationListener.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoLocationOnlineStatusWeatherLocationListener));
      return;
      str1 = paramPoiBean.adInfo.city;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.OnlineStatusWeatherLocationListener.1
 * JD-Core Version:    0.7.0.1
 */