package com.tencent.qqmini.sdk.manager;

import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingRsp;
import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

final class GameGrowthGuardianManager$2
  implements AsyncResult
{
  GameGrowthGuardianManager$2(MiniAppInfo paramMiniAppInfo, Context paramContext, int paramInt) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      try
      {
        paramJSONObject = (INTERFACE.StJudgeTimingRsp)paramJSONObject.get("response");
        if (paramJSONObject != null) {
          QMLog.d("GameGrowthGuardianManager", "onReceived() called with: success = [" + paramBoolean + "], stJudgeTimingRsp = [ next = " + paramJSONObject.nextDuration.get() + ", " + paramJSONObject.loginTraceId.get() + ", " + paramJSONObject.loginInstructions.size() + ", " + paramJSONObject.timingTraceId.get() + ", " + paramJSONObject.timingInstructions.size() + "]");
        }
        if ((this.val$miniAppInfo.isEngineTypeMiniApp()) && (!GameWnsUtils.enableInstructionsForMiniApp()))
        {
          QMLog.e("GameGrowthGuardianManager", "disable Instructions for miniApp!!");
          return;
        }
        if (paramJSONObject == null) {
          break label244;
        }
        if (!paramJSONObject.loginInstructions.isEmpty())
        {
          Iterator localIterator = paramJSONObject.loginInstructions.get().iterator();
          while (localIterator.hasNext()) {
            ((INTERFACE.GuardInstruction)localIterator.next()).type.set(7);
          }
          paramJSONObject.timingInstructions.get().addAll(0, paramJSONObject.loginInstructions.get());
        }
      }
      catch (Exception paramJSONObject)
      {
        QMLog.e("GameGrowthGuardianManager", "JudgeTiming error ", paramJSONObject);
        return;
      }
      GameGrowthGuardianManager.access$202(paramJSONObject.extInfo);
      label244:
      if (!GameGrowthGuardianManager.access$300())
      {
        QMLog.e("GameGrowthGuardianManager", "not in foreground, not allowed to show dialog or send heartbeat");
        return;
      }
      GameGrowthGuardianManager.GuardInstructionDialog.tryBuildAndShow(this.val$context, this.val$miniAppInfo, paramJSONObject, 0);
      if ((this.val$judgeTimingRequestFactType == 11) || (this.val$judgeTimingRequestFactType == 12))
      {
        if ((paramJSONObject != null) && (paramJSONObject.nextDuration.get() > 0)) {}
        for (int i = paramJSONObject.nextDuration.get();; i = 300)
        {
          GameGrowthGuardianManager.access$402(new GameGrowthGuardianManager.2.1(this));
          ThreadManager.getUIHandler().postDelayed(GameGrowthGuardianManager.access$400(), TimeUnit.SECONDS.toMillis(i));
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.2
 * JD-Core Version:    0.7.0.1
 */