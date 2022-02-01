package com.tencent.mobileqq.intervideo.groupvideo;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.IPluginEnterManager;
import com.tencent.mobileqq.intervideo.shadow.PluginProcessKiller;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Map;

class IVPluginLoader$1
  implements Runnable
{
  IVPluginLoader$1(IVPluginLoader paramIVPluginLoader, String paramString1, String paramString2, String paramString3, String paramString4, Map paramMap) {}
  
  public void run()
  {
    ((IPluginEnterManager)QRoute.api(IPluginEnterManager.class)).switchBiz(this.a, (PluginProcessKiller)IVPluginLoader.a(this.this$0));
    ThreadManagerV2.getUIHandlerV2().post(new IVPluginLoader.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.IVPluginLoader.1
 * JD-Core Version:    0.7.0.1
 */