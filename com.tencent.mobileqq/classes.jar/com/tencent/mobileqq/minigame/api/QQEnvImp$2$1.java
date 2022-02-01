package com.tencent.mobileqq.minigame.api;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.triton.sdk.callback.DialogCallback;

class QQEnvImp$2$1
  implements DialogInterface.OnClickListener
{
  QQEnvImp$2$1(QQEnvImp.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$1.val$dialogCallback.onConfirm();
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.QQEnvImp.2.1
 * JD-Core Version:    0.7.0.1
 */