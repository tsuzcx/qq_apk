package com.tencent.qqmini.sdk.minigame.manager;

import android.os.Bundle;
import bdqa;
import bdqc;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class GameReportManager$1
  implements Runnable
{
  public GameReportManager$1(bdqc parambdqc) {}
  
  public void run()
  {
    if (!bdqc.a(this.this$0))
    {
      MiniAppInfo localMiniAppInfo = bdqa.a().a();
      new Bundle().putParcelable("app_config", localMiniAppInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.manager.GameReportManager.1
 * JD-Core Version:    0.7.0.1
 */