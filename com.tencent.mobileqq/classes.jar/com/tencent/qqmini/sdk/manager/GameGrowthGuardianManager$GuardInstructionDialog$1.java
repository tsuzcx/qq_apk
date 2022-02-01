package com.tencent.qqmini.sdk.manager;

import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingRsp;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class GameGrowthGuardianManager$GuardInstructionDialog$1
  implements DialogInterface.OnDismissListener
{
  GameGrowthGuardianManager$GuardInstructionDialog$1(Context paramContext, MiniAppInfo paramMiniAppInfo, INTERFACE.StJudgeTimingRsp paramStJudgeTimingRsp, int paramInt) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    GameGrowthGuardianManager.GuardInstructionDialog.tryBuildAndShow(this.val$context, this.val$miniAppInfo, this.val$judgeTimingRsp, this.val$currentIndexOfInstruction + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog.1
 * JD-Core Version:    0.7.0.1
 */