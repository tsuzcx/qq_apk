package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ImageJsPlugin$2$1
  implements DialogInterface.OnClickListener
{
  ImageJsPlugin$2$1(ImageJsPlugin.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ImageJsPlugin.access$000(this.this$1.this$0, this.this$1.this$0.jsPluginEngine.getActivityContext(), this.this$1.val$webview, this.this$1.val$callbackId);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ImageJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */