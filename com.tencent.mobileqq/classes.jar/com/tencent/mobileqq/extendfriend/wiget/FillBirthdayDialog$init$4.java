package com.tencent.mobileqq.extendfriend.wiget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class FillBirthdayDialog$init$4
  implements View.OnClickListener
{
  FillBirthdayDialog$init$4(FillBirthdayDialog paramFillBirthdayDialog) {}
  
  public final void onClick(View paramView)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B08B", "0X800B08B", 1, 0, "", "", "", "");
    this.a.dismiss();
    if (FillBirthdayDialog.a(this.a) != null)
    {
      FillBirthdayDialog.OnConfirmListener localOnConfirmListener = FillBirthdayDialog.a(this.a);
      if (localOnConfirmListener == null) {
        Intrinsics.throwNpe();
      }
      localOnConfirmListener.a(FillBirthdayDialog.a(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.FillBirthdayDialog.init.4
 * JD-Core Version:    0.7.0.1
 */