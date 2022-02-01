package com.tencent.mobileqq.richmediabrowser.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class BrowserDependImpl$2
  implements DialogInterface.OnClickListener
{
  BrowserDependImpl$2(BrowserDependImpl paramBrowserDependImpl, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((Activity)this.jdField_a_of_type_AndroidContentContext).setResult(8001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.api.impl.BrowserDependImpl.2
 * JD-Core Version:    0.7.0.1
 */