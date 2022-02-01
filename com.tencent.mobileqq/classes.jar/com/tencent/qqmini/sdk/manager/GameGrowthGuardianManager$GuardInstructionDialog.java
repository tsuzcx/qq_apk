package com.tencent.qqmini.sdk.manager;

import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingRsp;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Process;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;
import java.lang.ref.WeakReference;

abstract class GameGrowthGuardianManager$GuardInstructionDialog
{
  private static GuardInstructionDialog sPreDialogWrapper;
  private final WeakReference<Context> ctxRef;
  private WeakReference<Dialog> dialogRef;
  private final INTERFACE.GuardInstruction guardInstruction;
  private INTERFACE.StJudgeTimingRsp judgeTimingRsp;
  private final MiniAppInfo miniAppInfo;
  private DialogInterface.OnDismissListener onDismissListener;
  
  GameGrowthGuardianManager$GuardInstructionDialog(INTERFACE.GuardInstruction paramGuardInstruction, Context paramContext, MiniAppInfo paramMiniAppInfo)
  {
    this.guardInstruction = paramGuardInstruction;
    this.ctxRef = new WeakReference(paramContext);
    this.miniAppInfo = paramMiniAppInfo;
    this.dialogRef = new WeakReference(null);
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
      if (paramGuardInstruction.type.get() != 7) {
        break label255;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tryBuildAndShow() called with: modal = ");
      ((StringBuilder)localObject).append(paramGuardInstruction.modal.get());
      QMLog.d("GameGrowthGuardianManager", ((StringBuilder)localObject).toString());
      if (paramGuardInstruction.modal.get() == 0) {
        paramGuardInstruction = new GameGrowthGuardianManager.GuardInstructionDialogSkippedRealNameAuthenticate(paramGuardInstruction, paramContext, paramMiniAppInfo);
      } else {
        paramGuardInstruction = new GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate(paramGuardInstruction, paramContext, paramMiniAppInfo);
      }
    }
    Object localObject = sPreDialogWrapper;
    if (localObject != null) {
      ((GuardInstructionDialog)localObject).dismissInner();
    }
    sPreDialogWrapper = paramGuardInstruction;
    paramGuardInstruction.setJudgeTimingRsp(paramStJudgeTimingRsp);
    paramGuardInstruction.setOnDismissListener(new GameGrowthGuardianManager.GuardInstructionDialog.1(paramContext, paramMiniAppInfo, paramStJudgeTimingRsp, paramInt));
    paramGuardInstruction.buildAndShow();
    return;
    label255:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tryBuildAndShow not create and show dialog for ");
    ((StringBuilder)localObject).append(paramGuardInstruction.type.get());
    QMLog.w("GameGrowthGuardianManager", ((StringBuilder)localObject).toString());
    tryBuildAndShow(paramContext, paramMiniAppInfo, paramStJudgeTimingRsp, paramInt + 1);
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
    Object localObject = getContext();
    if (localObject != null)
    {
      if (getGuardInstruction() == null) {
        return;
      }
      localObject = DialogUtil.createCustomDialog((Context)localObject, 230).setTitle(getGuardInstruction().title.get()).setMessage(getGuardInstruction().msg.get());
      this.dialogRef = new WeakReference(localObject);
      if (getPositiveDialogAction() != null) {
        ((MiniCustomDialog)localObject).setPositiveButton(getPositiveDialogAction().getStringResId(), getPositiveDialogAction().getOnClickListener());
      }
      if (getNegativeDialogAction() != null) {
        ((MiniCustomDialog)localObject).setNegativeButton(getNegativeDialogAction().getStringResId(), getNegativeDialogAction().getOnClickListener());
      }
      ((MiniCustomDialog)localObject).setOnShowListener(new GameGrowthGuardianManager.GuardInstructionDialog.3(this, new GameGrowthGuardianManager.GuardInstructionDialog.2(this)));
      ((MiniCustomDialog)localObject).setOnDismissListener(new GameGrowthGuardianManager.GuardInstructionDialog.4(this));
      ((MiniCustomDialog)localObject).setCancelable(false);
      onPreShowDialog((Dialog)localObject);
      ((MiniCustomDialog)localObject).show();
    }
  }
  
  protected final void dismissInner()
  {
    Dialog localDialog = (Dialog)this.dialogRef.get();
    if (localDialog != null)
    {
      localDialog.dismiss();
      onDismissDialogInner(localDialog);
    }
  }
  
  protected final void doExit()
  {
    try
    {
      Context localContext = getContext();
      if ((localContext instanceof Activity))
      {
        ((Activity)localContext).finish();
        return;
      }
      Process.killProcess(Process.myPid());
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("GameGrowthGuardianManager", "doExit", localThrowable);
    }
  }
  
  public Context getContext()
  {
    return (Context)this.ctxRef.get();
  }
  
  public Dialog getDialog()
  {
    return (Dialog)this.dialogRef.get();
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
  
  protected void onDismissDialogInner(Dialog paramDialog) {}
  
  protected void onDismissForReport(DialogInterface paramDialogInterface) {}
  
  protected void onPreShowDialog(Dialog paramDialog) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog
 * JD-Core Version:    0.7.0.1
 */