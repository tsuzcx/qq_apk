package com.tencent.mobileqq.onlinestatus.view;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.StatusVisibleFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/onlinestatus/view/WeatherView$bindTextView$2$1"}, k=3, mv={1, 1, 16})
final class WeatherView$bindTextView$$inlined$apply$lambda$1
  implements View.OnClickListener
{
  WeatherView$bindTextView$$inlined$apply$lambda$1(WeatherView paramWeatherView, Ref.ObjectRef paramObjectRef, boolean paramBoolean) {}
  
  public final void onClick(View paramView)
  {
    if (this.c) {
      ReportHelperKt.a("0X800AF49", 2, null, null, 12, null);
    } else {
      ReportHelperKt.a("0X800AF49", 1, null, null, 12, null);
    }
    StatusVisibleFragment.a((Activity)this.a.c(), WeatherView.b(this.a), 2, 1030);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.WeatherView.bindTextView..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */