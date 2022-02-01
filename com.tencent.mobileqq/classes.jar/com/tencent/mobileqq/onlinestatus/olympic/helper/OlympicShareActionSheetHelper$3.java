package com.tencent.mobileqq.onlinestatus.olympic.helper;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class OlympicShareActionSheetHelper$3
  implements DialogInterface.OnDismissListener
{
  OlympicShareActionSheetHelper$3(OlympicShareActionSheetHelper paramOlympicShareActionSheetHelper, OlympicShareHelper.IShareFinishCallback paramIShareFinishCallback) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a;
    if (paramDialogInterface != null) {
      paramDialogInterface.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicShareActionSheetHelper.3
 * JD-Core Version:    0.7.0.1
 */