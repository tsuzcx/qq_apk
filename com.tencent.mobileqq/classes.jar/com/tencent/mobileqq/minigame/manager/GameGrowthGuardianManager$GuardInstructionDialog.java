package com.tencent.mobileqq.minigame.manager;

import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingRsp;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import bbcv;
import bbgg;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

abstract class GameGrowthGuardianManager$GuardInstructionDialog
{
  private final Context context;
  private final INTERFACE.GuardInstruction guardInstruction;
  private INTERFACE.StJudgeTimingRsp judgeTimingRsp;
  private final MiniAppConfig miniAppConfig;
  private DialogInterface.OnDismissListener onDismissListener;
  
  GameGrowthGuardianManager$GuardInstructionDialog(INTERFACE.GuardInstruction paramGuardInstruction, Context paramContext, MiniAppConfig paramMiniAppConfig)
  {
    this.guardInstruction = paramGuardInstruction;
    this.context = paramContext;
    this.miniAppConfig = paramMiniAppConfig;
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
            localObject2 = new GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppConfig);
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
    bbgg localbbgg = bbcv.a(getContext(), 230).setTitle(getGuardInstruction().title.get()).setMessage(getGuardInstruction().msg.get());
    if (getPositiveDialogAction() != null) {
      localbbgg.setPositiveButton(getPositiveDialogAction().getStringResId(), getPositiveDialogAction().getOnClickListener());
    }
    if (getNegativeDialogAction() != null) {
      localbbgg.setNegativeButton(getNegativeDialogAction().getStringResId(), getNegativeDialogAction().getOnClickListener());
    }
    localbbgg.setOnShowListener(new GameGrowthGuardianManager.GuardInstructionDialog.2(this));
    localbbgg.setOnDismissListener(new GameGrowthGuardianManager.GuardInstructionDialog.3(this));
    localbbgg.setCancelable(false);
    localbbgg.show();
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  INTERFACE.GuardInstruction getGuardInstruction()
  {
    return this.guardInstruction;
  }
  
  public MiniAppConfig getMiniAppConfig()
  {
    return this.miniAppConfig;
  }
  
  protected GameGrowthGuardianManager.DialogAction getNegativeDialogAction()
  {
    return null;
  }
  
  protected GameGrowthGuardianManager.DialogAction getPositiveDialogAction()
  {
    return null;
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
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameGrowthGuardianManager.GuardInstructionDialog
 * JD-Core Version:    0.7.0.1
 */