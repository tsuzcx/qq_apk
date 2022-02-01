package com.tencent.mobileqq.minigame.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.pb.TianShuAccess.AdItem;

final class MiniGameAdBannerPopup$4
  implements View.OnClickListener
{
  MiniGameAdBannerPopup$4(Dialog paramDialog, TianShuAccess.AdItem paramAdItem, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.val$dialog.dismiss();
    MiniGameAdBannerPopup.access$300(this.val$adItem, this.val$type, 122);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.MiniGameAdBannerPopup.4
 * JD-Core Version:    0.7.0.1
 */