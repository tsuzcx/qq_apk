package com.tencent.smtt.sdk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

final class QbSdk$8
  implements DialogInterface.OnDismissListener
{
  QbSdk$8(ValueCallback paramValueCallback) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.val$callback != null) {
      this.val$callback.onReceiveValue("TbsReaderDialogClosed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk.8
 * JD-Core Version:    0.7.0.1
 */