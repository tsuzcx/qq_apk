package com.tencent.qqmini.minigame.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.sdk.launcher.ui.OnAppCloseAction;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;

final class GameCapsuleButtonClickListener$2
  implements DialogInterface.OnClickListener
{
  GameCapsuleButtonClickListener$2(OnAppCloseAction paramOnAppCloseAction) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.val$action.positiveButtonListener != null) {
      this.val$action.positiveButtonListener.onClick(paramDialogInterface, paramInt);
    }
    SDKMiniProgramLpReportDC04239.report("sdk_popup", "action", "click", this.val$action.positiveButtonClickReportStr, null, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.widget.GameCapsuleButtonClickListener.2
 * JD-Core Version:    0.7.0.1
 */