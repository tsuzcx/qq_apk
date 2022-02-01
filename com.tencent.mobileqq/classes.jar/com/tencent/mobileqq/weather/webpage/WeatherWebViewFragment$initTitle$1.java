package com.tencent.mobileqq.weather.webpage;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class WeatherWebViewFragment$initTitle$1
  implements View.OnClickListener
{
  WeatherWebViewFragment$initTitle$1(WeatherWebViewFragment paramWeatherWebViewFragment) {}
  
  public final void onClick(View paramView)
  {
    WeatherWebViewFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weather.webpage.WeatherWebViewFragment.initTitle.1
 * JD-Core Version:    0.7.0.1
 */