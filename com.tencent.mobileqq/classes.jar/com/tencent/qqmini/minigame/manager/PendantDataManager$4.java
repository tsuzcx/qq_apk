package com.tencent.qqmini.minigame.manager;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import cooperation.vip.pb.TianShuAccess.AdItem;

final class PendantDataManager$4
  implements Runnable
{
  PendantDataManager$4(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt) {}
  
  public void run()
  {
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).tianshuReport(this.val$adItem, this.val$type, this.val$reportActionId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.PendantDataManager.4
 * JD-Core Version:    0.7.0.1
 */