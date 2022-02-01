package com.tencent.mobileqq.minigame.manager;

import android.app.Application.ActivityLifecycleCallbacks;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class GameGrowthGuardianManager$GuardInstructionDialog$4
  implements DialogInterface.OnDismissListener
{
  GameGrowthGuardianManager$GuardInstructionDialog$4(GameGrowthGuardianManager.GuardInstructionDialog paramGuardInstructionDialog, Application.ActivityLifecycleCallbacks paramActivityLifecycleCallbacks) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.this$0.onDismissForReport(paramDialogInterface);
    try
    {
      AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getApp().unregisterActivityLifecycleCallbacks(this.val$lifecycleCallbacks);
      if (GameGrowthGuardianManager.GuardInstructionDialog.access$200(this.this$0) != null) {
        GameGrowthGuardianManager.GuardInstructionDialog.access$200(this.this$0).onDismiss(paramDialogInterface);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("GameGrowthGuardianManag", 1, localThrowable, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameGrowthGuardianManager.GuardInstructionDialog.4
 * JD-Core Version:    0.7.0.1
 */