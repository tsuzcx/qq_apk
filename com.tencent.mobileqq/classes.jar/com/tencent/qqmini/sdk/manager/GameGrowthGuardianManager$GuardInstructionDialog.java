package com.tencent.qqmini.sdk.manager;

import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingRsp;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;

abstract class GameGrowthGuardianManager$GuardInstructionDialog
{
  private final Context context;
  private final INTERFACE.GuardInstruction guardInstruction;
  private INTERFACE.StJudgeTimingRsp judgeTimingRsp;
  private final MiniAppInfo miniAppInfo;
  private DialogInterface.OnDismissListener onDismissListener;
  
  GameGrowthGuardianManager$GuardInstructionDialog(INTERFACE.GuardInstruction paramGuardInstruction, Context paramContext, MiniAppInfo paramMiniAppInfo)
  {
    this.guardInstruction = paramGuardInstruction;
    this.context = paramContext;
    this.miniAppInfo = paramMiniAppInfo;
  }
  
  static void tryBuildAndShow(Context paramContext, MiniAppInfo paramMiniAppInfo, INTERFACE.StJudgeTimingRsp paramStJudgeTimingRsp, int paramInt)
  {
    if ((paramContext == null) || (paramStJudgeTimingRsp == null) || (paramStJudgeTimingRsp.timingInstructions.isEmpty())) {}
    for (;;)
    {
      return;
      try
      {
        if (paramInt >= paramStJudgeTimingRsp.timingInstructions.size()) {
          continue;
        }
        Object localObject1 = (INTERFACE.GuardInstruction)paramStJudgeTimingRsp.timingInstructions.get(paramInt);
        if (localObject1 == null) {
          continue;
        }
        if (((INTERFACE.GuardInstruction)localObject1).type.get() == 1)
        {
          localObject1 = new GameGrowthGuardianManager.GuardInstructionDialogTips((INTERFACE.GuardInstruction)localObject1, paramContext, paramMiniAppInfo);
          if (localObject1 == null) {
            continue;
          }
          ((GuardInstructionDialog)localObject1).setJudgeTimingRsp(paramStJudgeTimingRsp);
          ((GuardInstructionDialog)localObject1).setOnDismissListener(new GameGrowthGuardianManager.GuardInstructionDialog.1(paramContext, paramMiniAppInfo, paramStJudgeTimingRsp, paramInt));
          ((GuardInstructionDialog)localObject1).buildAndShow();
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QMLog.e("GameGrowthGuardianManager", "tryBuildAndShow", localException);
          Object localObject2 = null;
          continue;
          if (((INTERFACE.GuardInstruction)localObject2).type.get() == 2)
          {
            localObject2 = new GameGrowthGuardianManager.GuardInstructionDialogLogout((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppInfo);
          }
          else if (((INTERFACE.GuardInstruction)localObject2).type.get() == 3)
          {
            localObject2 = new GameGrowthGuardianManager.GuardInstructionDialogOpenUrl((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppInfo);
          }
          else if (((INTERFACE.GuardInstruction)localObject2).type.get() == 6)
          {
            localObject2 = new GameGrowthGuardianManager.GuardInstructionDialogIncomeTips((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppInfo);
          }
          else if (((INTERFACE.GuardInstruction)localObject2).type.get() == 7)
          {
            QMLog.d("GameGrowthGuardianManager", "tryBuildAndShow() called with: modal = " + ((INTERFACE.GuardInstruction)localObject2).modal.get());
            if (((INTERFACE.GuardInstruction)localObject2).modal.get() == 0) {
              localObject2 = new GameGrowthGuardianManager.GuardInstructionDialogSkippedRealNameAuthenticate((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppInfo);
            } else {
              localObject2 = new GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppInfo);
            }
          }
          else
          {
            QMLog.w("GameGrowthGuardianManager", "tryBuildAndShow not create and show dialog for " + ((INTERFACE.GuardInstruction)localObject2).type.get());
            tryBuildAndShow(paramContext, paramMiniAppInfo, paramStJudgeTimingRsp, paramInt + 1);
            localObject2 = null;
          }
        }
      }
    }
  }
  
  void buildAndShow()
  {
    if ((getContext() == null) || (getGuardInstruction() == null)) {
      return;
    }
    MiniCustomDialog localMiniCustomDialog = DialogUtil.createCustomDialog(getContext(), 230).setTitle(getGuardInstruction().title.get()).setMessage(getGuardInstruction().msg.get());
    if (getPositiveDialogAction() != null) {
      localMiniCustomDialog.setPositiveButton(getPositiveDialogAction().getStringResId(), getPositiveDialogAction().getOnClickListener());
    }
    if (getNegativeDialogAction() != null) {
      localMiniCustomDialog.setNegativeButton(getNegativeDialogAction().getStringResId(), getNegativeDialogAction().getOnClickListener());
    }
    localMiniCustomDialog.setOnShowListener(new GameGrowthGuardianManager.GuardInstructionDialog.3(this, new GameGrowthGuardianManager.GuardInstructionDialog.2(this)));
    localMiniCustomDialog.setOnDismissListener(new GameGrowthGuardianManager.GuardInstructionDialog.4(this));
    localMiniCustomDialog.setCancelable(false);
    localMiniCustomDialog.show();
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  INTERFACE.GuardInstruction getGuardInstruction()
  {
    return this.guardInstruction;
  }
  
  public MiniAppInfo getMiniAppInfo()
  {
    return this.miniAppInfo;
  }
  
  protected GameGrowthGuardianManager.DialogAction getNegativeDialogAction()
  {
    return null;
  }
  
  protected GameGrowthGuardianManager.DialogAction getPositiveDialogAction()
  {
    return null;
  }
  
  String getReportActionType()
  {
    return "sys_alert";
  }
  
  protected String getReportSubActionType()
  {
    return null;
  }
  
  protected void onBackgroundForReport()
  {
    QMLog.d("GameGrowthGuardianManager", "onBackgroundForReport() called");
    performReport("hide");
  }
  
  protected void onDismissForReport(DialogInterface paramDialogInterface) {}
  
  protected void onShowForReport(DialogInterface paramDialogInterface) {}
  
  protected void performReport(String paramString)
  {
    String str1;
    String str2;
    String str3;
    String str4;
    if (getGuardInstruction() != null)
    {
      str1 = getGuardInstruction().ruleName.get();
      str2 = String.valueOf(getGuardInstruction().type.get());
      str3 = String.valueOf(getGuardInstruction().modal.get());
      str4 = getGuardInstruction().msg.get();
    }
    for (;;)
    {
      if (this.judgeTimingRsp != null) {}
      for (String str5 = String.valueOf(this.judgeTimingRsp.nextDuration.get());; str5 = null)
      {
        if (getMiniAppInfo() != null) {}
        for (String str6 = SDKMiniProgramLpReportDC04239.getAppType(getMiniAppInfo());; str6 = null)
        {
          SDKMiniProgramLpReportDC04239.report(getMiniAppInfo(), str6, null, getReportActionType(), getReportSubActionType(), paramString, str1, str2, str3, str4, str5);
          QMLog.d("GameGrowthGuardianManager", "performReport called with action = " + getReportActionType() + ",subaction = " + getReportSubActionType() + ",reserves = " + paramString + ",reverses2 = " + str1 + ",reverses3 = " + str2 + ",reverses4 = " + str3 + ",reverses5 = " + str4 + ",reserves6 = " + str5);
          return;
        }
      }
      str4 = null;
      str3 = null;
      str2 = null;
      str1 = null;
    }
  }
  
  public void setJudgeTimingRsp(INTERFACE.StJudgeTimingRsp paramStJudgeTimingRsp)
  {
    this.judgeTimingRsp = paramStJudgeTimingRsp;
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.onDismissListener = paramOnDismissListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog
 * JD-Core Version:    0.7.0.1
 */