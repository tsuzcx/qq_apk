package com.tencent.mobileqq.minigame.manager;

import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingRsp;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import bglp;
import bgpa;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

abstract class GameGrowthGuardianManager$GuardInstructionDialog
{
  private final Context mContext;
  private final INTERFACE.GuardInstruction mGuardInstruction;
  private INTERFACE.StJudgeTimingRsp mJudgeTimingRsp;
  private final MiniAppConfig mMiniAppConfig;
  private DialogInterface.OnDismissListener mOnDismissListener;
  
  GameGrowthGuardianManager$GuardInstructionDialog(INTERFACE.GuardInstruction paramGuardInstruction, Context paramContext, MiniAppConfig paramMiniAppConfig)
  {
    this.mGuardInstruction = paramGuardInstruction;
    this.mContext = paramContext;
    this.mMiniAppConfig = paramMiniAppConfig;
  }
  
  static void tryBuildAndShow(Context paramContext, MiniAppConfig paramMiniAppConfig, INTERFACE.StJudgeTimingRsp paramStJudgeTimingRsp, int paramInt)
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
          localObject1 = new GameGrowthGuardianManager.GuardInstructionDialogTips((INTERFACE.GuardInstruction)localObject1, paramContext, paramMiniAppConfig);
          if (localObject1 == null) {
            continue;
          }
          ((GuardInstructionDialog)localObject1).setJudgeTimingRsp(paramStJudgeTimingRsp);
          ((GuardInstructionDialog)localObject1).setOnDismissListener(new GameGrowthGuardianManager.GuardInstructionDialog.1(paramContext, paramMiniAppConfig, paramStJudgeTimingRsp, paramInt));
          ((GuardInstructionDialog)localObject1).buildAndShow();
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("GameGrowthGuardianManag", 1, "tryBuildAndShow", localException);
          Object localObject2 = null;
          continue;
          if (((INTERFACE.GuardInstruction)localObject2).type.get() == 2)
          {
            localObject2 = new GameGrowthGuardianManager.GuardInstructionDialogLogout((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppConfig);
          }
          else if (((INTERFACE.GuardInstruction)localObject2).type.get() == 3)
          {
            localObject2 = new GameGrowthGuardianManager.GuardInstructionDialogOpenUrl((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppConfig);
          }
          else if (((INTERFACE.GuardInstruction)localObject2).type.get() == 6)
          {
            localObject2 = new GameGrowthGuardianManager.GuardInstructionDialogIncomeTips((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppConfig);
          }
          else if (((INTERFACE.GuardInstruction)localObject2).type.get() == 7)
          {
            QLog.d("GameGrowthGuardianManag", 1, "tryBuildAndShow() called with: modal = " + ((INTERFACE.GuardInstruction)localObject2).modal.get());
            if (((INTERFACE.GuardInstruction)localObject2).modal.get() == 0) {
              localObject2 = new GameGrowthGuardianManager.GuardInstructionDialogSkippedRealNameAuthenticate((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppConfig);
            } else {
              localObject2 = new GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppConfig);
            }
          }
          else
          {
            QLog.w("GameGrowthGuardianManag", 2, "tryBuildAndShow not create and show dialog for " + ((INTERFACE.GuardInstruction)localObject2).type.get());
            tryBuildAndShow(paramContext, paramMiniAppConfig, paramStJudgeTimingRsp, paramInt + 1);
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
    bgpa localbgpa = bglp.a(getContext(), 230).setTitle(getGuardInstruction().title.get()).setMessage(getGuardInstruction().msg.get());
    if (getPositiveDialogAction() != null) {
      localbgpa.setPositiveButton(getPositiveDialogAction().getStringResId(), getPositiveDialogAction().getOnClickListener());
    }
    if (getNegativeDialogAction() != null) {
      localbgpa.setNegativeButton(getNegativeDialogAction().getStringResId(), getNegativeDialogAction().getOnClickListener());
    }
    GameGrowthGuardianManager.GuardInstructionDialog.2 local2 = new GameGrowthGuardianManager.GuardInstructionDialog.2(this);
    localbgpa.setOnShowListener(new GameGrowthGuardianManager.GuardInstructionDialog.3(this, local2));
    localbgpa.setOnDismissListener(new GameGrowthGuardianManager.GuardInstructionDialog.4(this, local2));
    localbgpa.setCancelable(false);
    localbgpa.show();
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  INTERFACE.GuardInstruction getGuardInstruction()
  {
    return this.mGuardInstruction;
  }
  
  public MiniAppConfig getMiniAppConfig()
  {
    return this.mMiniAppConfig;
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
    QLog.d("GameGrowthGuardianManag", 1, "onBackgroundForReport() called");
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
      if (this.mJudgeTimingRsp != null) {}
      for (String str5 = String.valueOf(this.mJudgeTimingRsp.nextDuration.get());; str5 = null)
      {
        if (getMiniAppConfig() != null) {}
        for (String str6 = MiniProgramLpReportDC04239.getAppType(getMiniAppConfig());; str6 = null)
        {
          MiniProgramLpReportDC04239.report(getMiniAppConfig(), str6, null, getReportActionType(), getReportSubActionType(), paramString, str1, str2, str3, str4, str5);
          QLog.d("GameGrowthGuardianManag", 1, "performReport called with action = " + getReportActionType() + ",subaction = " + getReportSubActionType() + ",reserves = " + paramString + ",reserves2 = " + str1 + ",reserves3 = " + str2 + ",reserves4 = " + str3 + ",reserves5 = " + str4 + ",reserves6 = " + str5);
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
    this.mJudgeTimingRsp = paramStJudgeTimingRsp;
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.mOnDismissListener = paramOnDismissListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameGrowthGuardianManager.GuardInstructionDialog
 * JD-Core Version:    0.7.0.1
 */