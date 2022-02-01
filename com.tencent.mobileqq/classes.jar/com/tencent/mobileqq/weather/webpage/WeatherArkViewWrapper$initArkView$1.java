package com.tencent.mobileqq.weather.webpage;

import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/weather/webpage/WeatherArkViewWrapper$initArkView$1", "Lcom/tencent/ark/ArkViewImplement$LoadCallback;", "onLoadFailed", "", "state", "", "errCode", "msg", "", "canRetry", "", "onLoadState", "qq-weather-impl_release"}, k=1, mv={1, 1, 16})
public final class WeatherArkViewWrapper$initArkView$1
  implements ArkViewImplement.LoadCallback
{
  public void onLoadFailed(int paramInt1, int paramInt2, @Nullable String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  public void onLoadState(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initArkView onLoadState : state -> ");
    localStringBuilder.append(paramInt);
    QLog.i("WeatherWebArkWrapper", 1, localStringBuilder.toString());
    if (paramInt == 1) {
      this.a.setArkLoaded(true);
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("state = ");
    localStringBuilder.append(paramInt);
    WeatherPreloadHelper.a(4, localStringBuilder.toString());
    if (paramInt != -1)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1) {
          return;
        }
        WeatherArkViewWrapper.a(this.a);
        return;
      }
      WeatherArkViewWrapper.c(this.a);
      return;
    }
    WeatherArkViewWrapper.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weather.webpage.WeatherArkViewWrapper.initArkView.1
 * JD-Core Version:    0.7.0.1
 */