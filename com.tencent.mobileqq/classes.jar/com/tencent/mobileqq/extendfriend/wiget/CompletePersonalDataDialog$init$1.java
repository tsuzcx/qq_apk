package com.tencent.mobileqq.extendfriend.wiget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class CompletePersonalDataDialog$init$1
  implements View.OnClickListener
{
  CompletePersonalDataDialog$init$1(CompletePersonalDataDialog paramCompletePersonalDataDialog) {}
  
  public final void onClick(View paramView)
  {
    if (this.a.isShowing())
    {
      this.a.dismiss();
      ReportController.b(null, "dc00898", "", "", "0X800B08A", "0X800B08A", 6, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.CompletePersonalDataDialog.init.1
 * JD-Core Version:    0.7.0.1
 */