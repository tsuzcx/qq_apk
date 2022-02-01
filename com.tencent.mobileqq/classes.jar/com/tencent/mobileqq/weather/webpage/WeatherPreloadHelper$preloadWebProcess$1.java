package com.tencent.mobileqq.weather.webpage;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.weather.WeatherDCReportHelper;
import com.tencent.mobileqq.webview.util.WebProcessStartListener;
import kotlin.Metadata;
import mqq.app.AppRuntime;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuccess", "", "onResult"}, k=3, mv={1, 1, 16})
final class WeatherPreloadHelper$preloadWebProcess$1
  implements WebProcessStartListener
{
  WeatherPreloadHelper$preloadWebProcess$1(AppRuntime paramAppRuntime, boolean paramBoolean) {}
  
  public final void onResult(boolean paramBoolean)
  {
    if (paramBoolean) {
      localObject = "new_folder_prestart_success";
    } else {
      localObject = "new_folder_prestart_fail";
    }
    WeatherDCReportHelper.a().a((AppInterface)this.a, (String)localObject);
    Object localObject = WeatherPreloadHelper.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preloadWebProcess isSuccess ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" isWebProcessExist ");
    localStringBuilder.append(this.b);
    WeatherPreloadHelper.a((WeatherPreloadHelper)localObject, localStringBuilder.toString());
    if (paramBoolean) {
      WeatherPreloadHelper.a(WeatherPreloadHelper.a, (AppInterface)this.a);
    }
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = -4001;
    }
    int j = i;
    if (i == -4001)
    {
      j = i;
      if (this.b) {
        j = -4000;
      }
    }
    WeatherPreloadHelper.a(WeatherPreloadHelper.a, (AppInterface)this.a, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.webpage.WeatherPreloadHelper.preloadWebProcess.1
 * JD-Core Version:    0.7.0.1
 */