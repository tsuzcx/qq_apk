package com.tencent.qqmini.minigame.manager;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class GameCloseManager$2
  implements DialogInterface.OnClickListener
{
  GameCloseManager$2(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    DialogInterface.OnClickListener localOnClickListener = this.val$onLeaveGameClickListener;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramDialogInterface, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.GameCloseManager.2
 * JD-Core Version:    0.7.0.1
 */