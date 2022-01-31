package com.tencent.mobileqq.minigame.manager;

import android.content.Context;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;

final class GameGrowthGuardianManager$1
  implements Runnable
{
  GameGrowthGuardianManager$1(Context paramContext, MiniAppConfig paramMiniAppConfig) {}
  
  public void run()
  {
    GameRuntimeLoader localGameRuntimeLoader = GameRuntimeLoaderManager.g().getBindRuntimeLoader(this.val$context);
    if ((localGameRuntimeLoader != null) && (localGameRuntimeLoader.getGameInfoManager().getMiniAppConfig() != null)) {
      localGameRuntimeLoader.getGameInfoManager().getMiniAppConfig().gameAdsTotalTime = 0;
    }
    GameGrowthGuardianManager.access$300(this.val$context, this.val$miniAppConfig, 11);
    GameGrowthGuardianManager.access$402(System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameGrowthGuardianManager.1
 * JD-Core Version:    0.7.0.1
 */