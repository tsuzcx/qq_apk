package com.tencent.qqmini.minigame.api;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.triton.sdk.callback.DialogCallback;

class QQEnvImp$3
  implements DialogInterface.OnClickListener
{
  QQEnvImp$3(QQEnvImp paramQQEnvImp, DialogCallback paramDialogCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.val$dialogCallback.onCancel();
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.api.QQEnvImp.3
 * JD-Core Version:    0.7.0.1
 */