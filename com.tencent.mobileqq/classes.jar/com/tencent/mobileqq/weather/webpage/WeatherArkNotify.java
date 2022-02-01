package com.tencent.mobileqq.weather.webpage;

import android.text.TextUtils;
import com.tencent.mobileqq.ark.module.IAppNotifyCallback;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/weather/webpage/WeatherArkNotify;", "Lcom/tencent/mobileqq/ark/module/IAppNotifyCallback;", "viewModel", "Lcom/tencent/mobileqq/weather/webpage/WeatherWebArkViewModel;", "(Lcom/tencent/mobileqq/weather/webpage/WeatherWebArkViewModel;)V", "notify", "", "appName", "", "eventName", "params", "Companion", "qq-weather-impl_release"}, k=1, mv={1, 1, 16})
public final class WeatherArkNotify
  implements IAppNotifyCallback
{
  public static final WeatherArkNotify.Companion a;
  private final WeatherWebArkViewModel a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherArkNotify$Companion = new WeatherArkNotify.Companion(null);
  }
  
  public WeatherArkNotify(@NotNull WeatherWebArkViewModel paramWeatherWebArkViewModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherWebArkViewModel = paramWeatherWebArkViewModel;
  }
  
  public boolean a(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notify --->  appName: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", eventName: ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", params: ");
      localStringBuilder.append(paramString3);
      QLog.d("WeatherArkNotify", 2, localStringBuilder.toString());
    }
    try
    {
      if (TextUtils.equals((CharSequence)paramString1, (CharSequence)"com.tencent.weather_v2"))
      {
        if (paramString2 == null) {
          return true;
        }
        int i = paramString2.hashCode();
        if (i != 6648771)
        {
          if (i != 1166327072) {
            return true;
          }
          if (paramString2.equals("notify_web_msg"))
          {
            this.jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherWebArkViewModel.a(paramString3);
            return true;
          }
        }
        else if (paramString2.equals("notify_client_msg"))
        {
          this.jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherWebArkViewModel.b(paramString3);
          return true;
        }
      }
    }
    catch (Throwable paramString1)
    {
      QLog.d("WeatherArkNotify", 1, paramString1, new Object[0]);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weather.webpage.WeatherArkNotify
 * JD-Core Version:    0.7.0.1
 */