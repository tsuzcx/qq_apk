package com.tencent.mobileqq.webview.swift.component.navigate;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.webview.swift.INavigationProcess;
import com.tencent.qphone.base.util.QLog;

public class WeatherNavigationItem
  implements INavigationProcess
{
  public boolean a(Intent paramIntent, Activity paramActivity, String paramString)
  {
    IWeatherCommApi localIWeatherCommApi = (IWeatherCommApi)QRoute.api(IWeatherCommApi.class);
    if (localIWeatherCommApi.isWeatherArkPageUrl(paramString)) {
      try
      {
        if (!paramIntent.getBooleanExtra("is_to_ark", false))
        {
          paramIntent = localIWeatherCommApi.transformUrlToScheme(paramString);
          if (!TextUtils.isEmpty(paramIntent))
          {
            localIWeatherCommApi.openWeatherByScheme(paramActivity, paramIntent);
            return true;
          }
        }
      }
      catch (Exception paramIntent)
      {
        QLog.i("WeatherNavigationItem", 1, "weather", paramIntent);
      }
    }
    return false;
  }
  
  public boolean b(Intent paramIntent, Activity paramActivity, String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.navigate.WeatherNavigationItem
 * JD-Core Version:    0.7.0.1
 */