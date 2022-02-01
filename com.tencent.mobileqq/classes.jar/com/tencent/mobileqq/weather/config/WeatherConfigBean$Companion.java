package com.tencent.mobileqq.weather.config;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/weather/config/WeatherConfigBean$Companion;", "", "()V", "PRELOAD_AD_KEY", "", "TAG", "parse", "Lcom/tencent/mobileqq/weather/config/WeatherConfigBean;", "content", "qq-weather-impl_release"}, k=1, mv={1, 1, 16})
public final class WeatherConfigBean$Companion
{
  @JvmStatic
  @NotNull
  public final WeatherConfigBean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "content");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parse from:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(' ');
      QLog.d("WeatherConfigBean", 2, ((StringBuilder)localObject).toString());
    }
    for (;;)
    {
      try
      {
        if (new JSONObject(paramString).optInt("ConfigEnableWeatherPreloadAd", 1) == 1)
        {
          bool = true;
          localObject = new WeatherConfigBean(bool);
          return localObject;
        }
      }
      catch (JSONException localJSONException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("error parse weather manage content:");
        localStringBuilder.append(paramString);
        QLog.e("WeatherConfigBean", 1, localStringBuilder.toString(), (Throwable)localJSONException);
        return new WeatherConfigBean(false, 1, null);
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weather.config.WeatherConfigBean.Companion
 * JD-Core Version:    0.7.0.1
 */