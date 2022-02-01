package com.tencent.mobileqq.debug;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k=3, mv={1, 1, 16})
final class DatongVerifyManager$showVerifyToggleDialog$dialog$2
  implements DialogInterface.OnClickListener
{
  public static final 2 a = new 2();
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    DatongVerifyManager.a(DatongVerifyManager.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.debug.DatongVerifyManager.showVerifyToggleDialog.dialog.2
 * JD-Core Version:    0.7.0.1
 */