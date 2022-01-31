package com.tencent.qqmini.sdk.minigame.manager;

import android.os.Bundle;
import bgzd;

public class GameReportManager$1
  implements Runnable
{
  public GameReportManager$1(bgzd parambgzd) {}
  
  public void run()
  {
    if (!bgzd.a(this.this$0)) {
      new Bundle().putParcelable("app_config", bgzd.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.manager.GameReportManager.1
 * JD-Core Version:    0.7.0.1
 */