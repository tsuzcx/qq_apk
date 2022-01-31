package com.tencent.mobileqq.minigame.manager;

import android.app.Application.ActivityLifecycleCallbacks;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class GameGrowthGuardianManager$GuardInstructionDialog$3
  implements DialogInterface.OnShowListener
{
  GameGrowthGuardianManager$GuardInstructionDialog$3(GameGrowthGuardianManager.GuardInstructionDialog paramGuardInstructionDialog, Application.ActivityLifecycleCallbacks paramActivityLifecycleCallbacks) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    this.this$0.onShowForReport(paramDialogInterface);
    GameGrowthGuardianManager.access$100(this.this$0.getMiniAppConfig(), GameGrowthGuardianManager.GuardInstructionDialog.access$000(this.this$0), this.this$0.getGuardInstruction());
    try
    {
      AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getApp().registerActivityLifecycleCallbacks(this.val$lifecycleCallbacks);
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      QLog.e("GameGrowthGuardianManag", 1, paramDialogInterface, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameGrowthGuardianManager.GuardInstructionDialog.3
 * JD-Core Version:    0.7.0.1
 */