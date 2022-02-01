package com.tencent.mobileqq.intervideo.groupvideo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.intervideo.huayang.IHuayangJsPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class IVPluginLoader$2
  extends BroadcastReceiver
{
  IVPluginLoader$2(IVPluginLoader paramIVPluginLoader) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int j = paramIntent.getIntExtra("key_state", -1);
    if (IVPluginLoader.b(this.a)) {
      IVPluginLoader.a(this.a, j);
    }
    if (paramContext.equals(((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).getDownloadNotifyAction(IVPluginLoader.c(this.a))))
    {
      paramContext = (PluginLoadListener)IVPluginLoader.d(this.a).get();
      if (paramContext != null) {
        paramContext.a(j, paramIntent.getExtras());
      } else if (QLog.isColorLevel()) {
        QLog.e("GroupVideoManager.IVPluginLoader", 2, "loadListener null");
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("state:");
        paramContext.append(j);
        QLog.d("GroupVideoManager.IVPluginLoader", 2, paramContext.toString());
      }
      paramContext = IVPluginLoader.a;
      int k = paramContext.length;
      int i = 0;
      while (i < k)
      {
        if ((j == paramContext[i]) && (IVPluginLoader.e(this.a)))
        {
          IVPluginLoader.c().unregisterReceiver(this.a.b);
          IVPluginLoader.a(this.a, false);
        }
        i += 1;
      }
      if ((IVPluginLoader.f(this.a)) && (j == 4))
      {
        IVPluginLoader.c().unregisterReceiver(this.a.b);
        IVPluginLoader.a(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.IVPluginLoader.2
 * JD-Core Version:    0.7.0.1
 */