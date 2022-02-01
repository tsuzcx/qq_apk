package com.tencent.mobileqq.weather.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.weather.api.listener.WeatherUpdateListener;
import mqq.app.AppActivity;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={"all"})
public abstract interface IWeatherRuntimeService
  extends IRuntimeService
{
  public abstract long getConfigVersion();
  
  public abstract void setWeatherUpdateListener(WeatherUpdateListener paramWeatherUpdateListener);
  
  public abstract boolean unzipResource(long paramLong, String paramString);
  
  public abstract void updateWeatherInfo(AppActivity paramAppActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weather.api.IWeatherRuntimeService
 * JD-Core Version:    0.7.0.1
 */