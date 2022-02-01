package com.tencent.mobileqq.qqexpand.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.statistics.ReportController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"}, k=3, mv={1, 1, 16})
final class FillBirthdayDialog$init$3
  implements DialogInterface.OnCancelListener
{
  FillBirthdayDialog$init$3(FillBirthdayDialog paramFillBirthdayDialog) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (FillBirthdayDialog.a(this.a) != null)
    {
      paramDialogInterface = FillBirthdayDialog.a(this.a);
      if (paramDialogInterface == null) {
        Intrinsics.throwNpe();
      }
      paramDialogInterface.a();
    }
    ReportController.b(null, "dc00898", "", "", "0X800B08B", "0X800B08B", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.FillBirthdayDialog.init.3
 * JD-Core Version:    0.7.0.1
 */