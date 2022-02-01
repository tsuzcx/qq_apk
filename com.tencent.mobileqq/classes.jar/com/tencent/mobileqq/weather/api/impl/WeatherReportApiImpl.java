package com.tencent.mobileqq.weather.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.weather.WeatherDCReportHelper;
import com.tencent.mobileqq.weather.api.IWeatherReportApi;
import com.tencent.mobileqq.weather.webpage.WeatherWebPageHelper;

public class WeatherReportApiImpl
  implements IWeatherReportApi
{
  public void onWeatherPushMessageArrive(AppInterface paramAppInterface, MessageRecord paramMessageRecord)
  {
    WeatherDCReportHelper.a().a(paramAppInterface, paramMessageRecord);
    WeatherWebPageHelper.a(paramMessageRecord);
  }
  
  public void reportWeather(AppInterface paramAppInterface, String paramString)
  {
    WeatherDCReportHelper.a().a(paramAppInterface, "aio_page_arrive");
  }
  
  public void reportWeatherMessageClick(AppInterface paramAppInterface, MessageRecord paramMessageRecord)
  {
    WeatherDCReportHelper.a().c(paramAppInterface, paramMessageRecord);
  }
  
  public void reportWeatherMessageExpose(AppInterface paramAppInterface, MessageRecord paramMessageRecord)
  {
    WeatherDCReportHelper.a().b(paramAppInterface, paramMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.api.impl.WeatherReportApiImpl
 * JD-Core Version:    0.7.0.1
 */