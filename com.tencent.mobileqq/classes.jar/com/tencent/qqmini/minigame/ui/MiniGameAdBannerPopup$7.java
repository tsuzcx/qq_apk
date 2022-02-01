package com.tencent.qqmini.minigame.ui;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import cooperation.vip.pb.TianShuAccess.AdItem;

final class MiniGameAdBannerPopup$7
  implements Runnable
{
  MiniGameAdBannerPopup$7(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt) {}
  
  public void run()
  {
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).tianshuReport(this.val$adItem, this.val$type, this.val$reportActionId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.MiniGameAdBannerPopup.7
 * JD-Core Version:    0.7.0.1
 */