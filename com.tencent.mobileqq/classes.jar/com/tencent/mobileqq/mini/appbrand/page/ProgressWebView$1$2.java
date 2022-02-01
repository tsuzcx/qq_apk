package com.tencent.mobileqq.mini.appbrand.page;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.smtt.export.external.interfaces.JsResult;

class ProgressWebView$1$2
  implements DialogInterface.OnClickListener
{
  ProgressWebView$1$2(ProgressWebView.1 param1, JsResult paramJsResult) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.val$jsResult.confirm();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.1.2
 * JD-Core Version:    0.7.0.1
 */