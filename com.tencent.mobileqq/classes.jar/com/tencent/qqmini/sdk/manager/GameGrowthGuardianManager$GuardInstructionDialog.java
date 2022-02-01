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
  
  private static void buildGuardianDialog(Context paramContext, MiniAppInfo paramMiniAppInfo, INTERFACE.StJudgeTimingRsp paramStJudgeTimingRsp, int paramInt, INTERFACE.GuardInstruction paramGuardInstruction)
  {
    if (paramGuardInstruction.type.get() == 1)
    {
      paramGuardInstruction = new GameGrowthGuardianManager.GuardInstructionDialogTips(paramGuardInstruction, paramContext, paramMiniAppInfo);
    }
    else if (paramGuardInstruction.type.get() == 2)
    {
      paramGuardInstruction = new GameGrowthGuardianManager.GuardInstructionDialogLogout(paramGuardInstruction, paramContext, paramMiniAppInfo);
    }
    else if (paramGuardInstruction.type.get() == 3)
    {
      paramGuardInstruction = new GameGrowthGuardianManager.GuardInstructionDialogOpenUrl(paramGuardInstruction, paramContext, paramMiniAppInfo);
    }
    else if (paramGuardInstruction.type.get() == 6)
    {
      paramGuardInstruction = new GameGrowthGuardianManager.GuardInstructionDialogIncomeTips(paramGuardInstruction, paramContext, paramMiniAppInfo);
    }
    else
    {
      StringBuilder localStringBuilder;
      if (paramGuardInstruction.type.get() == 7)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("tryBuildAndShow() called with: modal = ");
        localStringBuilder.append(paramGuardInstruction.modal.get());
        QMLog.d("GameGrowthGuardianManager", localStringBuilder.toString());
        if (paramGuardInstruction.modal.get() == 0) {
          paramGuardInstruction = new GameGrowthGuardianManager.GuardInstructionDialogSkippedRealNameAuthenticate(paramGuardInstruction, paramContext, paramMiniAppInfo);
        } else {
          paramGuardInstruction = new GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate(paramGuardInstruction, paramContext, paramMiniAppInfo);
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("tryBuildAndShow not create and show dialog for ");
        localStringBuilder.append(paramGuardInstruction.type.get());
        QMLog.w("GameGrowthGuardianManager", localStringBuilder.toString());
        tryBuildAndShow(paramContext, paramMiniAppInfo, paramStJudgeTimingRsp, paramInt + 1);
        paramGuardInstruction = null;
      }
    }
    if (paramGuardInstruction != null)
    {
      paramGuardInstruction.setJudgeTimingRsp(paramStJudgeTimingRsp);
      paramGuardInstruction.setOnDismissListener(new GameGrowthGuardianManager.GuardInstructionDialog.1(paramContext, paramMiniAppInfo, paramStJudgeTimingRsp, paramInt));
      paramGuardInstruction.buildAndShow();
    }
  }
  
  static void tryBuildAndShow(Context paramContext, MiniAppInfo paramMiniAppInfo, INTERFACE.StJudgeTimingRsp paramStJudgeTimingRsp, int paramInt)
  {
    if ((paramContext != null) && (paramStJudgeTimingRsp != null))
    {
      if (paramStJudgeTimingRsp.timingInstructions.isEmpty()) {
        return;
      }
      Object localObject = null;
      try
      {
        if (paramInt < paramStJudgeTimingRsp.timingInstructions.size())
        {
          INTERFACE.GuardInstruction localGuardInstruction = (INTERFACE.GuardInstruction)paramStJudgeTimingRsp.timingInstructions.get(paramInt);
          localObject = localGuardInstruction;
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        QMLog.e("GameGrowthGuardianManager", "tryBuildAndShow", localException);
        if (localObject != null) {
          buildGuardianDialog(paramContext, paramMiniAppInfo, paramStJudgeTimingRsp, paramInt, localObject);
        }
      }
    }
  }
  
  void buildAndShow()
  {
    if (getContext() != null)
    {
      if (getGuardInstruction() == null) {
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
    Object localObject1 = getGuardInstruction();
    Object localObject6 = null;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (localObject1 != null)
    {
      localObject2 = getGuardInstruction().ruleName.get();
      int i = getGuardInstruction().type.get();
      int j = getGuardInstruction().modal.get();
      localObject1 = getGuardInstruction().msg.get();
      localObject3 = String.valueOf(i);
      localObject4 = String.valueOf(j);
    }
    else
    {
      localObject5 = null;
      localObject1 = localObject5;
      localObject2 = localObject1;
      localObject4 = localObject2;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject5;
    }
    Object localObject5 = this.judgeTimingRsp;
    if (localObject5 != null) {
      localObject5 = String.valueOf(((INTERFACE.StJudgeTimingRsp)localObject5).nextDuration.get());
    } else {
      localObject5 = null;
    }
    if (getMiniAppInfo() != null) {
      localObject6 = SDKMiniProgramLpReportDC04239.getAppType(getMiniAppInfo());
    }
    SDKMiniProgramLpReportDC04239.report(getMiniAppInfo(), (String)localObject6, null, getReportActionType(), getReportSubActionType(), paramString, (String)localObject2, (String)localObject3, (String)localObject4, (String)localObject1, (String)localObject5);
    localObject6 = new StringBuilder();
    ((StringBuilder)localObject6).append("performReport called with action = ");
    ((StringBuilder)localObject6).append(getReportActionType());
    ((StringBuilder)localObject6).append(",subaction = ");
    ((StringBuilder)localObject6).append(getReportSubActionType());
    ((StringBuilder)localObject6).append(",reserves = ");
    ((StringBuilder)localObject6).append(paramString);
    ((StringBuilder)localObject6).append(",reverses2 = ");
    ((StringBuilder)localObject6).append((String)localObject2);
    ((StringBuilder)localObject6).append(",reverses3 = ");
    ((StringBuilder)localObject6).append((String)localObject3);
    ((StringBuilder)localObject6).append(",reverses4 = ");
    ((StringBuilder)localObject6).append((String)localObject4);
    ((StringBuilder)localObject6).append(",reverses5 = ");
    ((StringBuilder)localObject6).append((String)localObject1);
    ((StringBuilder)localObject6).append(",reserves6 = ");
    ((StringBuilder)localObject6).append((String)localObject5);
    QMLog.d("GameGrowthGuardianManager", ((StringBuilder)localObject6).toString());
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