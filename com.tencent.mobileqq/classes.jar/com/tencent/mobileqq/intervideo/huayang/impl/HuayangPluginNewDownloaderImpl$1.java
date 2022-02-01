package com.tencent.mobileqq.intervideo.huayang.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity;
import com.tencent.mobileqq.intervideo.huayang.IHuayangPluginNewDownloader.HuayangPluginLoadStatusListener;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.intervideo.huayang.MonitorConfig;
import java.util.Map;

class HuayangPluginNewDownloaderImpl$1
  implements Handler.Callback
{
  HuayangPluginNewDownloaderImpl$1(HuayangPluginNewDownloaderImpl paramHuayangPluginNewDownloaderImpl) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1;
    Object localObject2;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 7: 
      paramMessage = new Intent(HuayangPluginNewDownloaderImpl.access$900(this.a), HuayangLoadbackgroudActivity.class);
      paramMessage.putExtra("isPreload", true);
      paramMessage.setFlags(268435456);
      HuayangPluginNewDownloaderImpl.access$900(this.a).startActivity(paramMessage);
      return false;
    case 6: 
      if (HuayangPluginNewDownloaderImpl.access$000(this.a) != null)
      {
        HuayangPluginNewDownloaderImpl.access$000(this.a).a(5, new Object[] { paramMessage.obj });
        return false;
      }
      break;
    case 5: 
      if (HuayangPluginNewDownloaderImpl.access$000(this.a) != null)
      {
        localObject1 = (InstalledPlugin)paramMessage.obj;
        localObject2 = HuayangPluginNewDownloaderImpl.access$000(this.a);
        boolean bool;
        if (paramMessage.arg1 == 1) {
          bool = true;
        } else {
          bool = false;
        }
        ((IHuayangPluginNewDownloader.HuayangPluginLoadStatusListener)localObject2).a(4, new Object[] { localObject1, Boolean.valueOf(bool), Long.valueOf(HuayangPluginNewDownloaderImpl.access$400(this.a)) });
      }
      paramMessage = this.a;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131903616));
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - HuayangPluginNewDownloaderImpl.access$500(this.a));
      HuayangPluginNewDownloaderImpl.access$600(paramMessage, "HuayangPluginNewDownloader", ((StringBuilder)localObject1).toString());
      HuayangPluginNewDownloaderImpl.access$702(this.a, false);
      return false;
    case 4: 
      if ((paramMessage.obj instanceof ProgressFuture))
      {
        double d = ((ProgressFuture)paramMessage.obj).getProgress();
        localObject1 = this.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("收到读取进度的MSG, progress = ");
        ((StringBuilder)localObject2).append(d);
        HuayangPluginNewDownloaderImpl.access$600((HuayangPluginNewDownloaderImpl)localObject1, "HuayangPluginNewDownloader", ((StringBuilder)localObject2).toString());
        HuayangPluginNewDownloaderImpl.access$800(this.a).sendMessage(Message.obtain(HuayangPluginNewDownloaderImpl.access$800(this.a), 1, (int)(d * 100.0D), 0));
        HuayangPluginNewDownloaderImpl.access$800(this.a).sendMessageDelayed(Message.obtain(HuayangPluginNewDownloaderImpl.access$800(this.a), 4, paramMessage.obj), 300L);
        return false;
      }
      break;
    case 3: 
      if (HuayangPluginNewDownloaderImpl.access$000(this.a) != null) {
        HuayangPluginNewDownloaderImpl.access$000(this.a).a(3, new Object[] { paramMessage.obj });
      }
      if (MonitorConfig.a.get(HuayangPluginNewDownloaderImpl.access$300(this.a)) != null)
      {
        Monitor.b(String.valueOf(((MonitorConfig)MonitorConfig.a.get(HuayangPluginNewDownloaderImpl.access$300(this.a))).d));
        return false;
      }
      break;
    case 2: 
      if (HuayangPluginNewDownloaderImpl.access$000(this.a) != null) {
        HuayangPluginNewDownloaderImpl.access$000(this.a).a(2, new Object[] { paramMessage.obj });
      }
      if (MonitorConfig.a.get(HuayangPluginNewDownloaderImpl.access$300(this.a)) != null)
      {
        Monitor.b(String.valueOf(((MonitorConfig)MonitorConfig.a.get(HuayangPluginNewDownloaderImpl.access$300(this.a))).c));
        return false;
      }
      break;
    case 1: 
      int i = paramMessage.arg1;
      if ((i > HuayangPluginNewDownloaderImpl.access$100(this.a)) && (HuayangPluginNewDownloaderImpl.access$000(this.a) != null))
      {
        HuayangPluginNewDownloaderImpl.access$000(this.a).a(1, new Object[] { Integer.valueOf(paramMessage.arg1), Long.valueOf(HuayangPluginNewDownloaderImpl.access$200(this.a)) });
        HuayangPluginNewDownloaderImpl.access$102(this.a, i);
        return false;
      }
      break;
    case 0: 
      if (HuayangPluginNewDownloaderImpl.access$000(this.a) != null) {
        HuayangPluginNewDownloaderImpl.access$000(this.a).a(0, new Object[] { paramMessage.obj });
      }
      break;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.impl.HuayangPluginNewDownloaderImpl.1
 * JD-Core Version:    0.7.0.1
 */