package com.tencent.mobileqq.weather.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;

@QAPI(process={"all"})
public abstract interface IWeatherHippyApi
  extends QRouteApi
{
  public abstract boolean canPreloadHippy();
  
  public abstract HippyAPIProvider createHippyProvider();
  
  public abstract boolean hasNewMessage();
  
  public abstract boolean isWeatherModule(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.api.IWeatherHippyApi
 * JD-Core Version:    0.7.0.1
 */