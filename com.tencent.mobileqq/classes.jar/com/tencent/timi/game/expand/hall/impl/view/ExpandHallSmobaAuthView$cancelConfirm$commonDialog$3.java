package com.tencent.timi.game.expand.hall.impl.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"}, k=3, mv={1, 1, 16})
final class ExpandHallSmobaAuthView$cancelConfirm$commonDialog$3
  implements DialogInterface.OnDismissListener
{
  ExpandHallSmobaAuthView$cancelConfirm$commonDialog$3(ExpandHallSmobaAuthView paramExpandHallSmobaAuthView) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!ExpandHallSmobaAuthView.b(this.a))
    {
      paramDialogInterface = ExpandHallSmobaAuthView.c(this.a);
      if (paramDialogInterface != null) {
        ExpandHallSmobaAuthView.a(this.a, paramDialogInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.view.ExpandHallSmobaAuthView.cancelConfirm.commonDialog.3
 * JD-Core Version:    0.7.0.1
 */