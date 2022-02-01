package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ImageJsPlugin$7
  extends BroadcastReceiver
{
  ImageJsPlugin$7(ImageJsPlugin paramImageJsPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    QLog.d("ImageJsPlugin", 2, String.format("receiver.onReceive action=%s", new Object[] { paramContext }));
    ArrayList localArrayList;
    int i;
    if ("micro_api_choose_image".equals(paramContext))
    {
      localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if (ImageJsPlugin.access$100(this.this$0))
      {
        i = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
        paramIntent = new StringBuilder();
        if (localArrayList != null) {
          break label155;
        }
      }
    }
    label155:
    for (paramContext = "empty";; paramContext = localArrayList.toString())
    {
      QLog.d("ImageJsPlugin", 4, paramContext + " : " + i);
      if (i == 0) {
        ImageJsPlugin.access$702(this.this$0, true);
      }
      if ((ImageJsPlugin.access$800(this.this$0) != null) && (ImageJsPlugin.access$900(this.this$0) > 0)) {
        ImageJsPlugin.access$300(this.this$0, localArrayList, ImageJsPlugin.access$800(this.this$0), ImageJsPlugin.access$900(this.this$0));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ImageJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */