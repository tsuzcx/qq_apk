package com.tencent.mobileqq.weather.hippy;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/weather/hippy/QQWeatherModule;", "get"}, k=3, mv={1, 1, 16})
final class QQWeatherApiProvider$getNativeModules$1<T>
  implements Provider<QQWeatherModule>
{
  QQWeatherApiProvider$getNativeModules$1(HippyEngineContext paramHippyEngineContext) {}
  
  @NotNull
  public final QQWeatherModule a()
  {
    return new QQWeatherModule(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.hippy.QQWeatherApiProvider.getNativeModules.1
 * JD-Core Version:    0.7.0.1
 */