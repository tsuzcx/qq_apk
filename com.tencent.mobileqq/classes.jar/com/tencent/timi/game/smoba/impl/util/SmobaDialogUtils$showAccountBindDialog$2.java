package com.tencent.timi.game.smoba.impl.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.BindSmobaAccountCallback;
import com.tencent.timi.game.smoba.impl.widget.SmobaAccountSelectView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k=3, mv={1, 1, 16})
final class SmobaDialogUtils$showAccountBindDialog$2
  implements DialogInterface.OnClickListener
{
  SmobaDialogUtils$showAccountBindDialog$2(SmobaAccountSelectView paramSmobaAccountSelectView, IUserSmobaInfoService.BindSmobaAccountCallback paramBindSmobaAccountCallback, QBaseActivity paramQBaseActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SmobaDialogUtils localSmobaDialogUtils = SmobaDialogUtils.a;
    SmobaAccountSelectView localSmobaAccountSelectView = this.a;
    IUserSmobaInfoService.BindSmobaAccountCallback localBindSmobaAccountCallback = this.b;
    QBaseActivity localQBaseActivity = this.c;
    Intrinsics.checkExpressionValueIsNotNull(paramDialogInterface, "dialog");
    SmobaDialogUtils.a(localSmobaDialogUtils, localSmobaAccountSelectView, localBindSmobaAccountCallback, localQBaseActivity, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.util.SmobaDialogUtils.showAccountBindDialog.2
 * JD-Core Version:    0.7.0.1
 */