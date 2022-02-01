package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.Map;

class HuayangPluginNewDownloader$1
  implements Handler.Callback
{
  HuayangPluginNewDownloader$1(HuayangPluginNewDownloader paramHuayangPluginNewDownloader) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 5: 
    case 6: 
    case 4: 
      label461:
      do
      {
        do
        {
          do
          {
            do
            {
              int i;
              do
              {
                do
                {
                  return false;
                } while (HuayangPluginNewDownloader.a(this.a) == null);
                HuayangPluginNewDownloader.a(this.a).a(0, new Object[] { paramMessage.obj });
                return false;
                i = paramMessage.arg1;
              } while ((i <= HuayangPluginNewDownloader.a(this.a)) || (HuayangPluginNewDownloader.a(this.a) == null));
              HuayangPluginNewDownloader.a(this.a).a(1, new Object[] { Integer.valueOf(paramMessage.arg1), Long.valueOf(HuayangPluginNewDownloader.a(this.a)) });
              HuayangPluginNewDownloader.a(this.a, i);
              return false;
              if (HuayangPluginNewDownloader.a(this.a) != null) {
                HuayangPluginNewDownloader.a(this.a).a(2, new Object[] { paramMessage.obj });
              }
            } while (MonitorConfig.a.get(HuayangPluginNewDownloader.a(this.a)) == null);
            Monitor.b(String.valueOf(((MonitorConfig)MonitorConfig.a.get(HuayangPluginNewDownloader.a(this.a))).b));
            return false;
            if (HuayangPluginNewDownloader.a(this.a) != null) {
              HuayangPluginNewDownloader.a(this.a).a(3, new Object[] { paramMessage.obj });
            }
          } while (MonitorConfig.a.get(HuayangPluginNewDownloader.a(this.a)) == null);
          Monitor.b(String.valueOf(((MonitorConfig)MonitorConfig.a.get(HuayangPluginNewDownloader.a(this.a))).c));
          return false;
          InstalledPlugin localInstalledPlugin;
          HuayangPluginNewDownloader.HuayangPluginLoadStatusListener localHuayangPluginLoadStatusListener;
          if (HuayangPluginNewDownloader.a(this.a) != null)
          {
            localInstalledPlugin = (InstalledPlugin)paramMessage.obj;
            localHuayangPluginLoadStatusListener = HuayangPluginNewDownloader.a(this.a);
            if (paramMessage.arg1 != 1) {
              break label461;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            localHuayangPluginLoadStatusListener.a(4, new Object[] { localInstalledPlugin, Boolean.valueOf(bool), Long.valueOf(HuayangPluginNewDownloader.b(this.a)) });
            HuayangPluginNewDownloader.a(this.a, "HuayangPluginNewDownloader", HardCodeUtil.a(2131705665) + (System.currentTimeMillis() - HuayangPluginNewDownloader.c(this.a)));
            HuayangPluginNewDownloader.a(this.a, false);
            return false;
          }
        } while (HuayangPluginNewDownloader.a(this.a) == null);
        HuayangPluginNewDownloader.a(this.a).a(5, new Object[] { paramMessage.obj });
        return false;
      } while (!(paramMessage.obj instanceof ProgressFuture));
      double d = ((ProgressFuture)paramMessage.obj).getProgress();
      HuayangPluginNewDownloader.a(this.a, "HuayangPluginNewDownloader", "收到读取进度的MSG, progress = " + d);
      HuayangPluginNewDownloader.a(this.a).sendMessage(Message.obtain(HuayangPluginNewDownloader.a(this.a), 1, (int)(d * 100.0D), 0));
      HuayangPluginNewDownloader.a(this.a).sendMessageDelayed(Message.obtain(HuayangPluginNewDownloader.a(this.a), 4, paramMessage.obj), 300L);
      return false;
    }
    paramMessage = new Intent(HuayangPluginNewDownloader.a(this.a), HuayangLoadbackgroudActivity.class);
    paramMessage.putExtra("isPreload", true);
    paramMessage.setFlags(268435456);
    HuayangPluginNewDownloader.a(this.a).startActivity(paramMessage);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloader.1
 * JD-Core Version:    0.7.0.1
 */