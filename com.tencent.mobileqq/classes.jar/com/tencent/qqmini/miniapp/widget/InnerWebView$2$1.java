package com.tencent.qqmini.miniapp.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.smtt.export.external.interfaces.JsResult;

class InnerWebView$2$1
  implements DialogInterface.OnClickListener
{
  InnerWebView$2$1(InnerWebView.2 param2, JsResult paramJsResult) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.val$jsResult.confirm();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.InnerWebView.2.1
 * JD-Core Version:    0.7.0.1
 */