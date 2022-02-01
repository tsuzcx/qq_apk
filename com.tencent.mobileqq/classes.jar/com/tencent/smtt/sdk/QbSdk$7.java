package com.tencent.smtt.sdk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

final class QbSdk$7
  implements DialogInterface.OnDismissListener
{
  QbSdk$7(ValueCallback paramValueCallback) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a != null) {
      this.a.onReceiveValue("TbsReaderDialogClosed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk.7
 * JD-Core Version:    0.7.0.1
 */