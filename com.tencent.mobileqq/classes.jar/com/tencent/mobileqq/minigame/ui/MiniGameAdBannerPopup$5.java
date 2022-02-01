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
import cooperation.vip.pb.TianShuAccess.AdItem;

final class MiniGameAdBannerPopup$5
  implements View.OnClickListener
{
  MiniGameAdBannerPopup$5(Dialog paramDialog, Context paramContext, String paramString1, TianShuAccess.AdItem paramAdItem, String paramString2) {}
  
  public void onClick(View paramView)
  {
    this.val$dialog.dismiss();
    if (((this.val$context instanceof Activity)) && (!TextUtils.isEmpty(this.val$jumpUrl))) {
      if (MiniAppLauncher.isMiniAppUrl(this.val$jumpUrl))
      {
        MiniAppLauncher.startMiniApp(this.val$context, this.val$jumpUrl, 2094, null);
      }
      else
      {
        paramView = (Activity)this.val$context;
        paramView.startActivity(new Intent(paramView, QQBrowserActivity.class).putExtra("url", this.val$jumpUrl));
      }
    }
    MiniGameAdBannerPopup.access$300(this.val$adItem, this.val$type, 102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.MiniGameAdBannerPopup.5
 * JD-Core Version:    0.7.0.1
 */