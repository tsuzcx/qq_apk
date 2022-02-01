package com.tencent.qqmini.sdk.manager;

import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.R.string;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.widget.MiniToast;

class GameGrowthGuardianManager$GuardInstructionDialogLogout
  extends GameGrowthGuardianManager.GuardInstructionDialog
  implements GameGrowthGuardianManager.DialogStateChecker.Callback
{
  private static final long DELAY_DO_EXIT = 1000L;
  private final GameGrowthGuardianManager.DialogStateChecker mDialogStateChecker = new GameGrowthGuardianManager.DialogStateChecker(this, this);
  
  GameGrowthGuardianManager$GuardInstructionDialogLogout(INTERFACE.GuardInstruction paramGuardInstruction, Context paramContext, MiniAppInfo paramMiniAppInfo)
  {
    super(paramGuardInstruction, paramContext, paramMiniAppInfo);
  }
  
  protected GameGrowthGuardianManager.DialogAction getPositiveDialogAction()
  {
    return new GameGrowthGuardianManager.DialogAction(R.string.mini_sdk_msg_unsupport_i_know, new GameGrowthGuardianManager.GuardInstructionDialogLogout.1(this));
  }
  
  protected String getReportSubActionType()
  {
    return "loginout";
  }
  
  public void onDialogStateInvalid()
  {
    Context localContext = getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDialogStateInvalid: context=");
    localStringBuilder.append(localContext);
    localStringBuilder.append(", msg=");
    localStringBuilder.append(getGuardInstruction().msg.get());
    QMLog.d("GameGrowthGuardianManager", localStringBuilder.toString());
    if (localContext != null) {
      MiniToast.makeText(localContext, R.string.mini_sdk_guard_force_logout, 1).show();
    }
    ThreadManager.getUIHandler().postDelayed(new GameGrowthGuardianManager.GuardInstructionDialogLogout.2(this), 1000L);
  }
  
  protected void onDismissDialogInner(Dialog paramDialog)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDismissDialogInner:");
    localStringBuilder.append(paramDialog);
    QMLog.d("GameGrowthGuardianManager", localStringBuilder.toString());
    this.mDialogStateChecker.b();
  }
  
  protected void onDismissForReport(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new StringBuilder();
    paramDialogInterface.append("onDismissDialog:");
    paramDialogInterface.append(this);
    QMLog.d("GameGrowthGuardianManager", paramDialogInterface.toString());
  }
  
  protected void onPreShowDialog(Dialog paramDialog)
  {
    paramDialog = new StringBuilder();
    paramDialog.append("onPreShowDialog:");
    paramDialog.append(this);
    QMLog.d("GameGrowthGuardianManager", paramDialog.toString());
    this.mDialogStateChecker.a();
  }
  
  protected void onShowForReport(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new StringBuilder();
    paramDialogInterface.append("onShowDialog:");
    paramDialogInterface.append(this);
    QMLog.d("GameGrowthGuardianManager", paramDialogInterface.toString());
    this.mDialogStateChecker.a();
    performReport("expo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialogLogout
 * JD-Core Version:    0.7.0.1
 */