package com.tencent.timi.game.smoba.impl.util.gamecore;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.timi.game.scheme.tools.SchemeUtil;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;

final class GameCoreUtil$2
  implements DialogInterface.OnClickListener
{
  GameCoreUtil$2(GameInstallCheckCallback paramGameInstallCheckCallback, Activity paramActivity, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a;
    if (paramDialogInterface != null) {
      paramDialogInterface.b();
    }
    if (!SchemeUtil.c(this.b, this.c))
    {
      Logger.c("GameCoreUtil", "isGameInstalled  gotoSysBrowser error");
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append("请前往手机应用商店下载 ");
      paramDialogInterface.append(this.d);
      CustomToastView.a(paramDialogInterface.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.util.gamecore.GameCoreUtil.2
 * JD-Core Version:    0.7.0.1
 */