package com.tencent.qqmini.sdk.manager;

import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.R.string;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.widget.MiniToast;

class GameGrowthGuardianManager$GuardInstructionDialogRealNameAuthenticate
  extends GameGrowthGuardianManager.GuardInstructionDialog
  implements GameGrowthGuardianManager.DialogStateChecker.Callback
{
  private final GameGrowthGuardianManager.DialogStateChecker mDialogStateChecker = new GameGrowthGuardianManager.DialogStateChecker(this, this);
  
  GameGrowthGuardianManager$GuardInstructionDialogRealNameAuthenticate(INTERFACE.GuardInstruction paramGuardInstruction, Context paramContext, MiniAppInfo paramMiniAppInfo)
  {
    super(paramGuardInstruction, paramContext, paramMiniAppInfo);
  }
  
  private void jumpToRealNameAuthPage()
  {
    Object localObject = getContext();
    if (((localObject instanceof Activity)) && (getGuardInstruction() != null))
    {
      MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      localObject = (Activity)localObject;
      Intent localIntent = new Intent();
      localIntent.putExtra("url", getGuardInstruction().url.get());
      localMiniAppProxy.startBrowserActivity((Context)localObject, localIntent);
    }
  }
  
  protected GameGrowthGuardianManager.DialogAction getNegativeDialogAction()
  {
    return new GameGrowthGuardianManager.DialogAction(R.string.mini_sdk_exit_game, new GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate.1(this));
  }
  
  protected GameGrowthGuardianManager.DialogAction getPositiveDialogAction()
  {
    return new GameGrowthGuardianManager.DialogAction(R.string.mini_sdk_qb_tenpay_tenpay_shiming_title, new GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate.2(this));
  }
  
  protected String getReportSubActionType()
  {
    return "off_idAlert";
  }
  
  public void onDialogStateInvalid()
  {
    Context localContext = getContext();
    if (localContext != null) {
      MiniToast.makeText(localContext, R.string.mini_sdk_real_name_toast_desc, 0).show();
    }
    jumpToRealNameAuthPage();
  }
  
  protected void onDismissDialogInner(Dialog paramDialog)
  {
    this.mDialogStateChecker.b();
  }
  
  protected void onPreShowDialog(Dialog paramDialog)
  {
    this.mDialogStateChecker.a();
  }
  
  protected void onShowForReport(DialogInterface paramDialogInterface)
  {
    performReport("expo");
    this.mDialogStateChecker.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate
 * JD-Core Version:    0.7.0.1
 */