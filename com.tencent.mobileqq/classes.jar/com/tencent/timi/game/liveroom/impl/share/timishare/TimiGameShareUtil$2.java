package com.tencent.timi.game.liveroom.impl.share.timishare;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;

final class TimiGameShareUtil$2
  implements DialogInterface.OnShowListener
{
  TimiGameShareUtil$2(DialogInterface.OnShowListener paramOnShowListener) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    DialogInterface.OnShowListener localOnShowListener = this.a;
    if (localOnShowListener != null) {
      localOnShowListener.onShow(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.share.timishare.TimiGameShareUtil.2
 * JD-Core Version:    0.7.0.1
 */