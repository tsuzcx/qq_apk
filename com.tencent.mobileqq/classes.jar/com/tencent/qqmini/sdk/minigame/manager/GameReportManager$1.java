package com.tencent.qqmini.sdk.minigame.manager;

import android.os.Bundle;
import bguw;

public class GameReportManager$1
  implements Runnable
{
  public GameReportManager$1(bguw parambguw) {}
  
  public void run()
  {
    if (!bguw.a(this.this$0)) {
      new Bundle().putParcelable("app_config", bguw.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.manager.GameReportManager.1
 * JD-Core Version:    0.7.0.1
 */