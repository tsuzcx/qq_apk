package com.tencent.qqmini.sdk.minigame.manager;

import android.os.Bundle;
import bevi;
import bevl;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class GameReportManager$1
  implements Runnable
{
  public GameReportManager$1(bevl parambevl) {}
  
  public void run()
  {
    if (!bevl.a(this.this$0))
    {
      MiniAppInfo localMiniAppInfo = bevi.a().a();
      new Bundle().putParcelable("app_config", localMiniAppInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.manager.GameReportManager.1
 * JD-Core Version:    0.7.0.1
 */