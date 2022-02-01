package com.tencent.mobileqq.weather.hippy;

import android.app.Activity;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qwallet.utils.FlymeOSStatusBarFontUtils;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class WeatherMainHippyFragment$updateTitleLayout$2
  implements Runnable
{
  WeatherMainHippyFragment$updateTitleLayout$2(WeatherMainHippyFragment paramWeatherMainHippyFragment, HippyMap paramHippyMap) {}
  
  public final void run()
  {
    try
    {
      Object localObject = this.a.getString("navTintColor");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        int i = Color.parseColor((String)localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("color ：");
        ((StringBuilder)localObject).append(i);
        QLog.i("WeatherMainHippyFragment", 1, ((StringBuilder)localObject).toString());
        WeatherMainHippyFragment.a(this.this$0, i);
        WeatherMainHippyFragment.b(this.this$0, i);
        WeatherMainHippyFragment.c(this.this$0, i);
      }
      localObject = this.a.getString("navBgColor");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        WeatherMainHippyFragment.a(this.this$0).setBackgroundColor(Color.parseColor((String)localObject));
      }
      if (this.a.getInt("isStatusDark") == 1)
      {
        FlymeOSStatusBarFontUtils.a((Activity)this.this$0.getActivity(), true);
        return;
      }
      FlymeOSStatusBarFontUtils.a((Activity)this.this$0.getActivity(), false);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("WeatherMainHippyFragment", 1, (Throwable)localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.hippy.WeatherMainHippyFragment.updateTitleLayout.2
 * JD-Core Version:    0.7.0.1
 */