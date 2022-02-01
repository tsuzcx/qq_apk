package com.tencent.qqmini.sdk.manager;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class GameGrowthGuardianManager$1
  implements Runnable
{
  GameGrowthGuardianManager$1(MiniAppInfo paramMiniAppInfo, Context paramContext) {}
  
  public void run()
  {
    MiniAppInfo localMiniAppInfo = this.val$miniAppInfo;
    localMiniAppInfo.gameAdsTotalTime = 0;
    GameGrowthGuardianManager.access$000(this.val$context, localMiniAppInfo, 11);
    GameGrowthGuardianManager.access$102(System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.1
 * JD-Core Version:    0.7.0.1
 */