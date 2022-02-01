package com.tencent.mobileqq.intervideo.groupvideo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.intervideo.huayang.IHuayangJsPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class GVideoWebPlugin$2
  extends BroadcastReceiver
{
  GVideoWebPlugin$2(GVideoWebPlugin paramGVideoWebPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int j = paramIntent.getIntExtra("key_state", -1);
    int k;
    int i;
    if (paramContext.equals(((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).getDownloadNotifyAction("com.tencent.od")))
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("state:");
        paramContext.append(j);
        QLog.e("GroupVideoManager.GVideoWebPlugin", 2, paramContext.toString());
      }
      paramContext = IVPluginLoader.a;
      k = paramContext.length;
      i = 0;
    }
    for (;;)
    {
      if ((i >= k) || ((j == paramContext[i]) && (GVideoWebPlugin.a(this.a).isShowing()))) {}
      try
      {
        GVideoWebPlugin.a(this.a).dismiss();
        label121:
        i += 1;
        continue;
        return;
      }
      catch (Throwable paramIntent)
      {
        break label121;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GVideoWebPlugin.2
 * JD-Core Version:    0.7.0.1
 */