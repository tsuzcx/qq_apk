package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ImageJsPlugin$2$2
  implements DialogInterface.OnClickListener
{
  ImageJsPlugin$2$2(ImageJsPlugin.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ImageJsPlugin.access$200(this.this$1.this$0, this.this$1.this$0.jsPluginEngine.getActivityContext(), this.this$1.val$count, ImageJsPlugin.access$100(this.this$1.this$0));
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ImageJsPlugin.2.2
 * JD-Core Version:    0.7.0.1
 */