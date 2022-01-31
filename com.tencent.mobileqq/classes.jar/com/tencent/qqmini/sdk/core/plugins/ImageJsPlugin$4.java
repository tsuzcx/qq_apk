package com.tencent.qqmini.sdk.core.plugins;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import bgok;
import com.tencent.qqmini.sdk.log.QMLog;

class ImageJsPlugin$4
  extends BroadcastReceiver
{
  ImageJsPlugin$4(ImageJsPlugin paramImageJsPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    QMLog.d("ImageJsPlugin", String.format("receiver.onReceive action=%s", new Object[] { paramContext }));
    if ("micro_api_choose_image".equals(paramContext))
    {
      paramContext = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((ImageJsPlugin.access$300(this.this$0) != null) && (ImageJsPlugin.access$300(this.this$0).b > 0)) {
        ImageJsPlugin.access$100(this.this$0, paramContext, ImageJsPlugin.access$300(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ImageJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */