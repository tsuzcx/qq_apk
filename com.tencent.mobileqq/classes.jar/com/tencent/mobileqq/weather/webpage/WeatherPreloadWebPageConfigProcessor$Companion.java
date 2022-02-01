package com.tencent.mobileqq.weather.webpage;

import com.tencent.mobileqq.config.QConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/weather/webpage/WeatherPreloadWebPageConfigProcessor$Companion;", "", "()V", "CONFIG_ID", "", "TAG", "", "enablePreloadWebProcess", "", "qq-weather-impl_release"}, k=1, mv={1, 1, 16})
public final class WeatherPreloadWebPageConfigProcessor$Companion
{
  public final boolean a()
  {
    Object localObject = QConfigManager.a().a(638);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QConfigManager.getSingle…n().loadConObj(CONFIG_ID)");
    return ((WeatherPreloadWebPageConfigProcessor.Config)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weather.webpage.WeatherPreloadWebPageConfigProcessor.Companion
 * JD-Core Version:    0.7.0.1
 */