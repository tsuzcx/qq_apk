package com.tencent.mobileqq.qqexpand.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class FillBirthdayDialog$init$2
  implements View.OnClickListener
{
  FillBirthdayDialog$init$2(FillBirthdayDialog paramFillBirthdayDialog) {}
  
  public final void onClick(View paramView)
  {
    if (this.a.isShowing())
    {
      this.a.dismiss();
      if (FillBirthdayDialog.b(this.a) != null)
      {
        paramView = FillBirthdayDialog.b(this.a);
        if (paramView == null) {
          Intrinsics.throwNpe();
        }
        paramView.a();
      }
      ReportController.b(null, "dc00898", "", "", "0X800B08B", "0X800B08B", 2, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.FillBirthdayDialog.init.2
 * JD-Core Version:    0.7.0.1
 */