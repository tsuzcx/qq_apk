package com.tencent.qqmini.minigame.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.utils.MiniAppLauncher;
import cooperation.vip.pb.TianShuAccess.AdItem;

final class MiniGameAdBannerPopup$6
  implements View.OnClickListener
{
  MiniGameAdBannerPopup$6(Dialog paramDialog, Context paramContext, String paramString1, MiniAppProxy paramMiniAppProxy, TianShuAccess.AdItem paramAdItem, String paramString2) {}
  
  public void onClick(View paramView)
  {
    this.val$dialog.dismiss();
    if (((this.val$context instanceof Activity)) && (!TextUtils.isEmpty(this.val$jumpUrl)))
    {
      if (!MiniAppLauncher.isMiniAppUrl(this.val$jumpUrl)) {
        break label76;
      }
      MiniSDK.startMiniApp((Activity)this.val$context, this.val$jumpUrl, 2094, null);
    }
    for (;;)
    {
      MiniGameAdBannerPopup.access$300(this.val$adItem, this.val$type, 102);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label76:
      Intent localIntent = new Intent();
      localIntent.putExtra("url", this.val$jumpUrl);
      this.val$miniAppProxy.startBrowserActivity((Activity)this.val$context, localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.MiniGameAdBannerPopup.6
 * JD-Core Version:    0.7.0.1
 */