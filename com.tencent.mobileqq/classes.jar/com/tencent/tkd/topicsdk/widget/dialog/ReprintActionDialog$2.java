package com.tencent.tkd.topicsdk.widget.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"}, k=3, mv={1, 1, 16})
final class ReprintActionDialog$2
  implements DialogInterface.OnDismissListener
{
  ReprintActionDialog$2(ReprintActionDialog paramReprintActionDialog) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a.a();
    if (paramDialogInterface != null) {
      paramDialogInterface = (Unit)paramDialogInterface.invoke(Boolean.valueOf(ReprintActionDialog.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.dialog.ReprintActionDialog.2
 * JD-Core Version:    0.7.0.1
 */