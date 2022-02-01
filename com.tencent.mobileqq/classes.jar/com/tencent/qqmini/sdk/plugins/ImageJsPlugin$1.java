package com.tencent.qqmini.sdk.plugins;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class ImageJsPlugin$1
  extends BroadcastReceiver
{
  ImageJsPlugin$1(ImageJsPlugin paramImageJsPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    QMLog.d("ImageJsPlugin", String.format("receiver.onReceive action=%s", new Object[] { paramContext }));
    if ("micro_api_choose_image".equals(paramContext))
    {
      paramContext = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((ImageJsPlugin.access$000(this.this$0) != null) && (ImageJsPlugin.access$000(this.this$0).callbackId > 0))
      {
        paramIntent = this.this$0;
        ImageJsPlugin.access$100(paramIntent, paramContext, ImageJsPlugin.access$000(paramIntent));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ImageJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */