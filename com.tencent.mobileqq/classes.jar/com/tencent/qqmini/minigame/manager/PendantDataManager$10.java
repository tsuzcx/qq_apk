package com.tencent.qqmini.minigame.manager;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import java.util.Map;

final class PendantDataManager$10
  implements Runnable
{
  PendantDataManager$10(String paramString) {}
  
  public void run()
  {
    PendantDataManager.access$600().put("ext3", this.a);
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).springHbReport("xiaoyouxi_red_rain_icon", 0, PendantDataManager.RESULT, PendantDataManager.access$600(), "clk");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.PendantDataManager.10
 * JD-Core Version:    0.7.0.1
 */