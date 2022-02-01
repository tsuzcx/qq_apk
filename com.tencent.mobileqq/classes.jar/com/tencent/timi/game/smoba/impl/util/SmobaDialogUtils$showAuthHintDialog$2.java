package com.tencent.timi.game.smoba.impl.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.base.ui.LoadingUtils;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.AuthToGetSmobaInfoCallback;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.BindSmobaAccountCallback;
import com.tencent.timi.game.smoba.impl.auth.AgreeAuthServlet;
import com.tencent.timi.game.smoba.impl.auth.AgreeAuthServlet.Companion;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k=3, mv={1, 1, 16})
final class SmobaDialogUtils$showAuthHintDialog$2
  implements DialogInterface.OnClickListener
{
  SmobaDialogUtils$showAuthHintDialog$2(QBaseActivity paramQBaseActivity, IUserSmobaInfoService.AuthToGetSmobaInfoCallback paramAuthToGetSmobaInfoCallback, boolean paramBoolean, IUserSmobaInfoService.BindSmobaAccountCallback paramBindSmobaAccountCallback) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Logger.a("SmobaDialogUtils_", "do auth!");
    LoadingUtils localLoadingUtils = LoadingUtils.a;
    Intrinsics.checkExpressionValueIsNotNull(paramDialogInterface, "dialog");
    localLoadingUtils.a(paramDialogInterface);
    AgreeAuthServlet.a.a((RequestListener)new SmobaDialogUtils.showAuthHintDialog.2.1(this, paramDialogInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.util.SmobaDialogUtils.showAuthHintDialog.2
 * JD-Core Version:    0.7.0.1
 */