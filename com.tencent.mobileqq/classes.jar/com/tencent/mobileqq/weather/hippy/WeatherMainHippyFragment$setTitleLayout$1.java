package com.tencent.mobileqq.weather.hippy;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class WeatherMainHippyFragment$setTitleLayout$1
  implements View.OnClickListener
{
  WeatherMainHippyFragment$setTitleLayout$1(WeatherMainHippyFragment paramWeatherMainHippyFragment) {}
  
  public final void onClick(View paramView)
  {
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.hippy.WeatherMainHippyFragment.setTitleLayout.1
 * JD-Core Version:    0.7.0.1
 */