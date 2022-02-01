package com.tencent.mobileqq.minigame.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.pb.TianShuAccess.AdItem;

final class MiniGameAdBannerPopup$5
  implements View.OnClickListener
{
  MiniGameAdBannerPopup$5(Dialog paramDialog, Context paramContext, String paramString1, TianShuAccess.AdItem paramAdItem, String paramString2) {}
  
  public void onClick(View paramView)
  {
    this.val$dialog.dismiss();
    if (((this.val$context instanceof Activity)) && (!TextUtils.isEmpty(this.val$jumpUrl)))
    {
      if (!MiniAppLauncher.isMiniAppUrl(this.val$jumpUrl)) {
        break label74;
      }
      MiniAppLauncher.startMiniApp(this.val$context, this.val$jumpUrl, 2094, null);
    }
    for (;;)
    {
      MiniGameAdBannerPopup.access$300(this.val$adItem, this.val$type, 102);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label74:
      Activity localActivity = (Activity)this.val$context;
      localActivity.startActivity(new Intent(localActivity, QQBrowserActivity.class).putExtra("url", this.val$jumpUrl));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.MiniGameAdBannerPopup.5
 * JD-Core Version:    0.7.0.1
 */