package com.tencent.mobileqq.weather.webpage;

import android.view.View;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "y", "<anonymous parameter 2>", "<anonymous parameter 3>", "<anonymous parameter 4>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onScrollChanged"}, k=3, mv={1, 1, 16})
final class WeatherWebViewFragment$initView$1
  implements TouchWebView.OnScrollChangedListener
{
  WeatherWebViewFragment$initView$1(WeatherWebViewFragment paramWeatherWebViewFragment) {}
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("showPreview scrollChangedListener  y: ");
      paramView.append(paramInt2);
      paramView.append(", arkLoadState：");
      paramView.append(WeatherWebViewFragment.b(this.a));
      QLog.d("WeatherWebViewFragment", 2, paramView.toString());
    }
    WeatherWebViewFragment.c(this.a).scrollTo(0, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.webpage.WeatherWebViewFragment.initView.1
 * JD-Core Version:    0.7.0.1
 */