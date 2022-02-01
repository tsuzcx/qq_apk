package com.tencent.mobileqq.weather.api.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.weather.WeatherServlet;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.weather.util.WeatherHelper;
import com.tencent.mobileqq.weather.webpage.WeatherPreloadHelper;
import com.tencent.mobileqq.weather.webpage.WeatherWebPageHelper;
import mqq.app.AppActivity;

public class WeatherCommApiImpl
  implements IWeatherCommApi
{
  public void asyncInitGdtDeviceInfo() {}
  
  public String getGdtDeviceInfoBase64()
  {
    return WeatherWebPageHelper.a();
  }
  
  public boolean isWeatherArkPageUrl(String paramString)
  {
    return WeatherHelper.b(paramString);
  }
  
  public boolean isWeatherPA(String paramString)
  {
    return WeatherHelper.a(paramString);
  }
  
  public void openWeatherByScheme(Context paramContext, String paramString)
  {
    WeatherWebPageHelper.a(paramContext, paramString);
  }
  
  public void openWeatherWebPage(Context paramContext, String paramString1, String paramString2)
  {
    WeatherWebPageHelper.a(paramContext, paramString1, paramString2);
  }
  
  public void preloadWebProcessAsync(int paramInt)
  {
    WeatherPreloadHelper.a(paramInt);
  }
  
  public boolean startNewWeatherWebPageActivity(Context paramContext, AppInterface paramAppInterface)
  {
    return WeatherWebPageHelper.a(paramContext, paramAppInterface);
  }
  
  public boolean startNewWeatherWebPageActivity(Context paramContext, AppInterface paramAppInterface, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
  {
    return WeatherWebPageHelper.a(paramContext, paramAppInterface, paramBoolean1, paramString1, paramBoolean2, paramString2);
  }
  
  public void startNewWeatherWebPageActivityByFollowState(Context paramContext, AppInterface paramAppInterface, int paramInt, String paramString)
  {
    WeatherWebPageHelper.a(paramContext, paramAppInterface, paramInt, paramString);
  }
  
  public void startWeatherWebPageActivity(Context paramContext, AppInterface paramAppInterface, int paramInt, String paramString)
  {
    WeatherWebPageHelper.b(paramContext, paramAppInterface, paramInt, paramString);
  }
  
  public String transformUrlToScheme(String paramString)
  {
    return WeatherWebPageHelper.a(paramString);
  }
  
  public void translate(AppInterface paramAppInterface, int paramInt1, int paramInt2, AppActivity paramAppActivity)
  {
    WeatherServlet.a(paramAppInterface, paramInt1, paramInt2, paramAppActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weather.api.impl.WeatherCommApiImpl
 * JD-Core Version:    0.7.0.1
 */