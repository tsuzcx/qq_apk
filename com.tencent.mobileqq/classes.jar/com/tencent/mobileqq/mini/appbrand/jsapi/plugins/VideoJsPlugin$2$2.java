package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class VideoJsPlugin$2$2
  implements DialogInterface.OnClickListener
{
  VideoJsPlugin$2$2(VideoJsPlugin.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VideoJsPlugin.access$300(this.this$1.this$0, this.this$1.this$0.jsPluginEngine.getActivityContext(), this.this$1.val$duration, this.this$1.val$compressed);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VideoJsPlugin.2.2
 * JD-Core Version:    0.7.0.1
 */