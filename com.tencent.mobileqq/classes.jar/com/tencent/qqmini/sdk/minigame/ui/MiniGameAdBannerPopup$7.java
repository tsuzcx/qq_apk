package com.tencent.qqmini.sdk.minigame.ui;

import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import cooperation.vip.pb.TianShuAccess.AdItem;

final class MiniGameAdBannerPopup$7
  implements Runnable
{
  MiniGameAdBannerPopup$7(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt) {}
  
  public void run()
  {
    ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).tianshuReport(this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.ui.MiniGameAdBannerPopup.7
 * JD-Core Version:    0.7.0.1
 */