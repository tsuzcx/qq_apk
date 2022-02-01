package com.tencent.qqmini.minigame.manager;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class GameCloseManager$1
  implements DialogInterface.OnClickListener
{
  GameCloseManager$1(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.val$onIKnowOnClickListener != null) {
      this.val$onIKnowOnClickListener.onClick(paramDialogInterface, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.GameCloseManager.1
 * JD-Core Version:    0.7.0.1
 */