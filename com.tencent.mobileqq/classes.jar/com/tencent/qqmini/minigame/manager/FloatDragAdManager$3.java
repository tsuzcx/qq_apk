package com.tencent.qqmini.minigame.manager;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import cooperation.vip.pb.TianShuAccess.AdItem;

class FloatDragAdManager$3
  implements Runnable
{
  FloatDragAdManager$3(FloatDragAdManager paramFloatDragAdManager, TianShuAccess.AdItem paramAdItem, String paramString, int paramInt) {}
  
  public void run()
  {
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).tianshuReport(this.val$adItem, this.val$type, this.val$reportActionId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.FloatDragAdManager.3
 * JD-Core Version:    0.7.0.1
 */