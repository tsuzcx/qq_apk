package com.tencent.timi.game.liveroom.impl.share.timishare;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

final class TimiGameShareUtil$4
  implements DialogInterface.OnDismissListener
{
  TimiGameShareUtil$4(DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    DialogInterface.OnDismissListener localOnDismissListener = this.a;
    if (localOnDismissListener != null) {
      localOnDismissListener.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.share.timishare.TimiGameShareUtil.4
 * JD-Core Version:    0.7.0.1
 */