package com.tencent.mobileqq.mini.manager;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.model.AppDetainConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick", "com/tencent/mobileqq/mini/manager/MiniAppDetainManager$showDetainDialog$1$2"}, k=3, mv={1, 1, 16})
final class MiniAppDetainManager$showDetainDialog$$inlined$apply$lambda$2
  implements DialogInterface.OnClickListener
{
  MiniAppDetainManager$showDetainDialog$$inlined$apply$lambda$2(AppDetainConfig paramAppDetainConfig, DialogInterface.OnClickListener paramOnClickListener, MiniAppConfig paramMiniAppConfig, IMiniAppContext paramIMiniAppContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.$miniRuntime$inlined.isMiniGame()) {
      MiniAppDetainManager.access$handleJumpForMiniApp(MiniAppDetainManager.INSTANCE, this.$miniRuntime$inlined, this.$detainConfig$inlined.getOpenLink(), this.$detainConfig$inlined.getOpenType());
    }
    paramDialogInterface.dismiss();
    paramDialogInterface = MiniAppDetainManager.INSTANCE;
    MiniAppConfig localMiniAppConfig = this.$miniAppConfig$inlined;
    Intrinsics.checkExpressionValueIsNotNull(localMiniAppConfig, "miniAppConfig");
    MiniAppDetainManager.access$reportDialogRightBtnClick(paramDialogInterface, localMiniAppConfig, this.$detainConfig$inlined.getEnterButton(), this.$detainConfig$inlined.getOpenLink());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniAppDetainManager.showDetainDialog..inlined.apply.lambda.2
 * JD-Core Version:    0.7.0.1
 */