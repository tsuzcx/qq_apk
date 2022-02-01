package com.tencent.mobileqq.minigame.manager;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;

class GameCloseManager$ChangeAllOnClickListener$1$1$1
  implements View.OnClickListener
{
  GameCloseManager$ChangeAllOnClickListener$1$1$1(GameCloseManager.ChangeAllOnClickListener.1.1 param1, MiniAppInfo paramMiniAppInfo) {}
  
  public void onClick(View paramView)
  {
    GameCloseManager.access$100(this.val$miniAppInfo, null, this.this$2.this$1.this$0.dialog, 0, this.this$2.this$1.this$0.closeListener, GameCloseManager.ChangeAllOnClickListener.access$000(this.this$2.this$1.this$0), true);
    MiniProgramLpReportDC04239.reportAsync(GameCloseManager.ChangeAllOnClickListener.access$700(this.this$2.this$1.this$0), "minigame_popup", "icon", "click", this.val$miniAppInfo.appId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameCloseManager.ChangeAllOnClickListener.1.1.1
 * JD-Core Version:    0.7.0.1
 */