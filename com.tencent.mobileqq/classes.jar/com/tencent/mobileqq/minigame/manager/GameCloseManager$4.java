package com.tencent.mobileqq.minigame.manager;

import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;

final class GameCloseManager$4
  implements View.OnClickListener
{
  GameCloseManager$4(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2, Dialog paramDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    MiniProgramLpReportDC04239.reportByDropGuideDialog(this.val$miniAppConfig, "xiala_popup", "popup", "expo", this.val$mode, this.val$location);
    this.val$dialog.dismiss();
    paramView = this.val$closeListener;
    if (paramView != null) {
      paramView.onClick(this.val$dialog, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameCloseManager.4
 * JD-Core Version:    0.7.0.1
 */