package com.tencent.mobileqq.mini.manager;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.model.AppDetainConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick", "com/tencent/mobileqq/mini/manager/MiniAppDetainManager$showDetainDialog$1$1"}, k=3, mv={1, 1, 16})
final class MiniAppDetainManager$showDetainDialog$$inlined$apply$lambda$1
  implements DialogInterface.OnClickListener
{
  MiniAppDetainManager$showDetainDialog$$inlined$apply$lambda$1(AppDetainConfig paramAppDetainConfig, DialogInterface.OnClickListener paramOnClickListener, MiniAppConfig paramMiniAppConfig, IMiniAppContext paramIMiniAppContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    Object localObject = this.$onCloseClickedListener$inlined;
    if (localObject != null) {
      ((DialogInterface.OnClickListener)localObject).onClick(paramDialogInterface, paramInt);
    }
    paramDialogInterface = MiniAppDetainManager.INSTANCE;
    localObject = this.$miniAppConfig$inlined;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "miniAppConfig");
    MiniAppDetainManager.access$reportDialogLeftBtnClick(paramDialogInterface, (MiniAppConfig)localObject, this.$detainConfig$inlined.getExitButton());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniAppDetainManager.showDetainDialog..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */