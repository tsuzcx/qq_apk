package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class HuayangPluginLauncher$1
  implements Handler.Callback
{
  HuayangPluginLauncher$1(HuayangPluginLauncher paramHuayangPluginLauncher) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return false;
        }
        localObject = HuayangPluginLauncher.access$000(this.a).iterator();
        while (((Iterator)localObject).hasNext())
        {
          IHuayangPluginLauncher.HuayangPluginLauncherListener localHuayangPluginLauncherListener = (IHuayangPluginLauncher.HuayangPluginLauncherListener)((Iterator)localObject).next();
          boolean bool;
          if (paramMessage.arg1 == 0) {
            bool = true;
          } else {
            bool = false;
          }
          localHuayangPluginLauncherListener.a(bool, (Throwable)paramMessage.obj);
        }
        localObject = new Intent(((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).getDownloadNotifyAction(HuayangPluginLauncher.access$100(this.a).c));
        if (paramMessage.arg1 == 0)
        {
          if (((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).isODPkg(HuayangPluginLauncher.access$100(this.a).c)) {
            i = 9;
          } else {
            i = 8;
          }
          ((Intent)localObject).putExtra("key_state", i);
          HuayangPluginLauncher.access$200(this.a).sendBroadcast((Intent)localObject);
          if (MonitorConfig.a.get(HuayangPluginLauncher.access$300(this.a)) != null)
          {
            Monitor.b(String.valueOf(((MonitorConfig)MonitorConfig.a.get(HuayangPluginLauncher.access$300(this.a))).g));
            return false;
          }
        }
        else
        {
          if (((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).isODPkg(HuayangPluginLauncher.access$100(this.a).c)) {
            Monitor.a("2691708");
          } else if (((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).isHyPkg(HuayangPluginLauncher.access$100(this.a).c)) {
            Monitor.a("2597726");
          } else if (MonitorConfig.a.get(HuayangPluginLauncher.access$300(this.a)) != null) {
            Monitor.b(String.valueOf(((MonitorConfig)MonitorConfig.a.get(HuayangPluginLauncher.access$300(this.a))).f));
          }
          ((IHuayangCrashReport)QRoute.api(IHuayangCrashReport.class)).report((Throwable)paramMessage.obj);
          ((Intent)localObject).putExtra("key_state", 7);
          HuayangPluginLauncher.access$200(this.a).sendBroadcast((Intent)localObject);
          return false;
        }
      }
      else
      {
        paramMessage = new Intent(((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).getDownloadNotifyAction(HuayangPluginLauncher.access$100(this.a).c));
        paramMessage.putExtra("key_state", 6);
        HuayangPluginLauncher.access$200(this.a).sendBroadcast(paramMessage);
        if (MonitorConfig.a.get(HuayangPluginLauncher.access$300(this.a)) != null)
        {
          Monitor.b(String.valueOf(((MonitorConfig)MonitorConfig.a.get(HuayangPluginLauncher.access$300(this.a))).e));
          return false;
        }
      }
    }
    else
    {
      localObject = HuayangPluginLauncher.access$000(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IHuayangPluginLauncher.HuayangPluginLauncherListener)((Iterator)localObject).next()).a(paramMessage.arg1);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher.1
 * JD-Core Version:    0.7.0.1
 */