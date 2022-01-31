package com.tencent.mobileqq.minigame.manager;

import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingRsp;
import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdHelper.MiniAppCmdCallback;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

final class GameGrowthGuardianManager$2
  implements MiniAppSSOCmdHelper.MiniAppCmdCallback<INTERFACE.StJudgeTimingRsp>
{
  GameGrowthGuardianManager$2(Context paramContext, MiniAppConfig paramMiniAppConfig, int paramInt) {}
  
  public void onReceived(boolean paramBoolean, INTERFACE.StJudgeTimingRsp paramStJudgeTimingRsp)
  {
    if (paramStJudgeTimingRsp != null) {
      QLog.d("GameGrowthGuardianManag", 1, "onReceived() called with: success = [" + paramBoolean + "], stJudgeTimingRsp = [ next = " + paramStJudgeTimingRsp.nextDuration.get() + ", " + paramStJudgeTimingRsp.loginTraceId.get() + ", " + paramStJudgeTimingRsp.loginInstructions.size() + ", " + paramStJudgeTimingRsp.timingTraceId.get() + ", " + paramStJudgeTimingRsp.timingInstructions.size() + "]");
    }
    if (!paramBoolean) {}
    do
    {
      return;
      if ((paramStJudgeTimingRsp != null) && (!paramStJudgeTimingRsp.loginInstructions.isEmpty()))
      {
        Iterator localIterator = paramStJudgeTimingRsp.loginInstructions.get().iterator();
        while (localIterator.hasNext()) {
          ((INTERFACE.GuardInstruction)localIterator.next()).type.set(7);
        }
        paramStJudgeTimingRsp.timingInstructions.get().addAll(0, paramStJudgeTimingRsp.loginInstructions.get());
      }
      GameGrowthGuardianManager.GuardInstructionDialog.tryBuildAndShow(this.val$context, this.val$miniAppConfig, paramStJudgeTimingRsp, 0);
    } while ((this.val$judgeTimingRequestFactType != 11) && (this.val$judgeTimingRequestFactType != 12));
    int j = 300;
    int i = j;
    if (paramStJudgeTimingRsp != null)
    {
      i = j;
      if (paramStJudgeTimingRsp.nextDuration.get() > 0) {
        i = paramStJudgeTimingRsp.nextDuration.get();
      }
    }
    GameGrowthGuardianManager.access$502(new GameGrowthGuardianManager.2.1(this));
    ThreadManagerV2.getUIHandlerV2().postDelayed(GameGrowthGuardianManager.access$500(), TimeUnit.SECONDS.toMillis(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameGrowthGuardianManager.2
 * JD-Core Version:    0.7.0.1
 */