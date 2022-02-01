package com.tencent.qqmini.minigame.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.OnRaffleSuccessListener;

class RaffleSuccessDialog$8
  implements DialogInterface.OnClickListener
{
  RaffleSuccessDialog$8(RaffleSuccessDialog paramRaffleSuccessDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (RaffleSuccessDialog.access$000(this.a) != null) {
      RaffleSuccessDialog.access$000(this.a).onCloseCancel();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.RaffleSuccessDialog.8
 * JD-Core Version:    0.7.0.1
 */