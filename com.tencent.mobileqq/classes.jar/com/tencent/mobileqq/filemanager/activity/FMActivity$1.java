package com.tencent.mobileqq.filemanager.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class FMActivity$1
  implements DialogInterface.OnClickListener
{
  FMActivity$1(FMActivity paramFMActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.setResult(8001);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMActivity.1
 * JD-Core Version:    0.7.0.1
 */