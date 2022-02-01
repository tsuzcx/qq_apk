package com.tencent.mobileqq.onlinestatus.olympic.helper;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class OlympicShareActionSheetHelper$2
  implements DialogInterface.OnCancelListener
{
  OlympicShareActionSheetHelper$2(OlympicShareActionSheetHelper paramOlympicShareActionSheetHelper, OlympicShareHelper.IShareFinishCallback paramIShareFinishCallback) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a;
    if (paramDialogInterface != null) {
      paramDialogInterface.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicShareActionSheetHelper.2
 * JD-Core Version:    0.7.0.1
 */