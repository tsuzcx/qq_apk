package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.os.Bundle;
import bekr;
import com.tencent.qqmini.sdk.core.proxy.PayProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;

class PayJsPlugin$9
  implements Runnable
{
  PayJsPlugin$9(PayJsPlugin paramPayJsPlugin, String paramString1, String paramString2, Activity paramActivity, bekr parambekr, boolean paramBoolean) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("payparmas_callback_sn", this.val$callbackSn);
    localBundle.putString("payparmas_json", PayJsPlugin.access$400(this.this$0, this.val$payJson));
    localBundle.putInt("payparmas_paytype", 1);
    localBundle.putLong("payparmas_h5_start", System.currentTimeMillis());
    localBundle.putInt("payparmas_request_code", 6);
    localBundle.putString("payparmas_sdk_pf", PayJsPlugin.access$500(this.this$0));
    localBundle = ((PayProxy)ProxyManager.get(PayProxy.class)).midasPay(this.val$activity, PayJsPlugin.access$400(this.this$0, this.val$payJson), new PayJsPlugin.9.1(this), localBundle);
    if (localBundle != null) {}
    for (int i = localBundle.getInt("retCode", 0);; i = 0)
    {
      if ((localBundle != null) && (i != 0)) {
        PayJsPlugin.access$200(this.this$0, this.val$req, null, "");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.PayJsPlugin.9
 * JD-Core Version:    0.7.0.1
 */