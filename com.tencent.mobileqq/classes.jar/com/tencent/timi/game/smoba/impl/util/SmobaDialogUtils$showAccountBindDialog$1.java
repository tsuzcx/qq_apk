package com.tencent.timi.game.smoba.impl.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.BindSmobaAccountCallback;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k=3, mv={1, 1, 16})
final class SmobaDialogUtils$showAccountBindDialog$1
  implements DialogInterface.OnClickListener
{
  SmobaDialogUtils$showAccountBindDialog$1(IUserSmobaInfoService.BindSmobaAccountCallback paramBindSmobaAccountCallback) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a;
    if (paramDialogInterface != null) {
      paramDialogInterface.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.util.SmobaDialogUtils.showAccountBindDialog.1
 * JD-Core Version:    0.7.0.1
 */