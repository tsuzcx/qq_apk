package com.tencent.mobileqq.onlinestatus.view;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationLauncher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/onlinestatus/view/ConstellationView$bindTextView$2$1"}, k=3, mv={1, 1, 16})
final class ConstellationView$bindTextView$$inlined$apply$lambda$1
  implements View.OnClickListener
{
  ConstellationView$bindTextView$$inlined$apply$lambda$1(ConstellationView paramConstellationView, String paramString) {}
  
  public final void onClick(View paramView)
  {
    ConstellationLauncher.c.a((Activity)this.a.c(), "VAL_FROM_STATUS_MSG_TAB");
    ReportHelperKt.a("0X800AF45", 0, null, null, 14, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.ConstellationView.bindTextView..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */