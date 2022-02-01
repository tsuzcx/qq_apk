package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import aevv;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivityForTool;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.minigame.ui.MiniGamePayFragment;

class PayJsPlugin$11
  implements Runnable
{
  PayJsPlugin$11(PayJsPlugin paramPayJsPlugin, String paramString1, String paramString2, boolean paramBoolean, int paramInt, String paramString3, Activity paramActivity) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("payparmas_callback_sn", this.val$callbackSn);
    localBundle.putString("payparmas_json", PayJsPlugin.access$700(this.this$0, this.val$payJson));
    localBundle.putInt("payparmas_paytype", 1);
    localBundle.putLong("payparmas_h5_start", System.currentTimeMillis());
    if (this.val$toolConsume)
    {
      MiniAppController.getInstance().setActivityResultListener(new PayJsPlugin.11.1(this));
      localIntent = new Intent();
      localIntent.putExtras(localBundle);
      localIntent.putExtra("mini_event_seq", this.val$seq);
      localIntent.putExtra("mini_event_name", this.val$eventName);
      aevv.a(this.val$activity, localIntent, PublicTransFragmentActivityForTool.class, MiniGamePayFragment.class, 3002);
    }
    while (PayBridgeActivity.a(AppLoaderFactory.getAppLoaderManager().getMiniAppInterface(), this.val$activity, this.this$0.payRecevicer, 6, localBundle).getInt("retCode", -1) == 0)
    {
      Intent localIntent;
      return;
    }
    PayJsPlugin.access$200(this.this$0, this.val$seq, this.val$eventName, null, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.PayJsPlugin.11
 * JD-Core Version:    0.7.0.1
 */