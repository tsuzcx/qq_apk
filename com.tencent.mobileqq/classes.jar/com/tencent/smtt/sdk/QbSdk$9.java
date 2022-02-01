package com.tencent.smtt.sdk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

final class QbSdk$9
  implements DialogInterface.OnDismissListener
{
  QbSdk$9(ValueCallback paramValueCallback) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a;
    if (paramDialogInterface != null) {
      paramDialogInterface.onReceiveValue("TbsReaderDialogClosed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk.9
 * JD-Core Version:    0.7.0.1
 */