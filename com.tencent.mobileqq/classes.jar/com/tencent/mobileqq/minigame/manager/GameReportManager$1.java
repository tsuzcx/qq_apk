package com.tencent.mobileqq.minigame.manager;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;

class GameReportManager$1
  implements Runnable
{
  GameReportManager$1(GameReportManager paramGameReportManager) {}
  
  public void run()
  {
    if ((!GameReportManager.access$000(this.this$0)) && (GameReportManager.access$100(this.this$0) != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("app_config", GameReportManager.access$100(this.this$0));
      QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "launch_report_js_error", localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameReportManager.1
 * JD-Core Version:    0.7.0.1
 */