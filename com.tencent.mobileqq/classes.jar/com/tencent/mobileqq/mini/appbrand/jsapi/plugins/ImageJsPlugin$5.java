package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class ImageJsPlugin$5
  extends BroadcastReceiver
{
  ImageJsPlugin$5(ImageJsPlugin paramImageJsPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    QLog.d("ImageJsPlugin", 2, String.format("receiver.onReceive action=%s", new Object[] { paramContext }));
    if ("micro_api_choose_image".equals(paramContext))
    {
      paramContext = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((ImageJsPlugin.access$300(this.this$0) != null) && (ImageJsPlugin.access$400(this.this$0) > 0)) {
        ImageJsPlugin.access$200(this.this$0, paramContext, ImageJsPlugin.access$300(this.this$0), ImageJsPlugin.access$400(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ImageJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */