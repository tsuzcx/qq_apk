package com.tencent.timi.game.liveroom.impl.share.timishare;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class TimiGameShareUtil$3
  implements DialogInterface.OnCancelListener
{
  TimiGameShareUtil$3(DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    DialogInterface.OnCancelListener localOnCancelListener = this.a;
    if (localOnCancelListener != null) {
      localOnCancelListener.onCancel(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.share.timishare.TimiGameShareUtil.3
 * JD-Core Version:    0.7.0.1
 */