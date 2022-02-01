package com.tencent.qqmini.minigame.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.sdk.launcher.ui.OnAppCloseAction;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;

final class GameCapsuleButtonClickListener$4
  implements DialogInterface.OnClickListener
{
  GameCapsuleButtonClickListener$4(OnAppCloseAction paramOnAppCloseAction) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.val$action.negativeButtonListener != null) {
      this.val$action.negativeButtonListener.onClick(paramDialogInterface, paramInt);
    }
    SDKMiniProgramLpReportDC04239.report("sdk_popup", "close", "click", this.val$action.negativeButtonClickReportStr, null, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.widget.GameCapsuleButtonClickListener.4
 * JD-Core Version:    0.7.0.1
 */