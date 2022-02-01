package com.tencent.mobileqq.onlinestatus.view;

import android.os.Bundle;
import com.tencent.mobileqq.onlinestatus.weather.WeatherObserver;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/onlinestatus/view/WeatherView$initData$1", "Lcom/tencent/mobileqq/onlinestatus/weather/WeatherObserver;", "receiveReqWeather", "", "success", "", "bundle", "Landroid/os/Bundle;", "qqonlinestatus-impl_release"}, k=1, mv={1, 1, 16})
public final class WeatherView$initData$1
  extends WeatherObserver
{
  public void a(boolean paramBoolean, @Nullable Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bundle: ");
      localStringBuilder.append(paramBundle);
      paramBundle = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" success: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("WeatherView", 2, new Object[] { "receiveReqWeather: called. ", paramBundle, localStringBuilder.toString() });
    }
    if (paramBoolean) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.WeatherView.initData.1
 * JD-Core Version:    0.7.0.1
 */