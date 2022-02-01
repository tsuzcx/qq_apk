package com.tencent.mobileqq.minigame.ui;

import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.tianshu.TianShuManager;

final class MiniGameAdBannerPopup$6
  implements Runnable
{
  MiniGameAdBannerPopup$6(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt) {}
  
  public void run()
  {
    TianShuManager.getInstance().report(MiniGameAdBannerPopup.access$400(this.val$adItem, this.val$type, this.val$reportActionId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.MiniGameAdBannerPopup.6
 * JD-Core Version:    0.7.0.1
 */