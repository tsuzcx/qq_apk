package com.tencent.mobileqq.weather.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IWeatherReportApi
  extends QRouteApi
{
  public abstract void onWeatherPushMessageArrive(AppInterface paramAppInterface, MessageRecord paramMessageRecord);
  
  public abstract void reportWeather(AppInterface paramAppInterface, String paramString);
  
  public abstract void reportWeatherMessageClick(AppInterface paramAppInterface, MessageRecord paramMessageRecord);
  
  public abstract void reportWeatherMessageExpose(AppInterface paramAppInterface, MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.api.IWeatherReportApi
 * JD-Core Version:    0.7.0.1
 */