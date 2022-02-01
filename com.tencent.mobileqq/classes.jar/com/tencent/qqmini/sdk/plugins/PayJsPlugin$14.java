package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqmini.sdk.widget.MiniToast;

class PayJsPlugin$14
  implements Runnable
{
  PayJsPlugin$14(PayJsPlugin paramPayJsPlugin, String paramString1, String paramString2, RequestEvent paramRequestEvent, Activity paramActivity, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("payparmas_callback_sn", this.val$callbackSn);
    ((Bundle)localObject).putString("payparmas_json", PayJsPlugin.access$1800(this.this$0, this.val$payJson));
    ((Bundle)localObject).putInt("payparmas_paytype", 1);
    ((Bundle)localObject).putLong("payparmas_h5_start", System.currentTimeMillis());
    ((Bundle)localObject).putInt("payparmas_request_code", 6);
    ((Bundle)localObject).putString("payparmas_sdk_pf", PayJsPlugin.access$1900(this.this$0, this.val$payJson));
    PayProxy localPayProxy = (PayProxy)ProxyManager.get(PayProxy.class);
    if (localPayProxy == null)
    {
      PayJsPlugin.access$700(this.this$0, this.val$req, null, "not support pay");
      return;
    }
    localObject = localPayProxy.midasPay(this.val$activity, PayJsPlugin.access$1800(this.this$0, this.val$payJson), PayJsPlugin.access$2000(this.this$0, this.val$req, this.val$toolConsume, this.val$callbackSn), (Bundle)localObject);
    int i;
    if (localObject != null) {
      i = ((Bundle)localObject).getInt("retCode", 0);
    } else {
      i = 0;
    }
    if ((localObject != null) && (i != 0)) {
      PayJsPlugin.access$700(this.this$0, this.val$req, null, "");
    }
    localObject = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    if ((localObject != null) && (((MiniAppProxy)localObject).isDebugVersion())) {
      MiniToast.makeText(this.val$activity, 0, "【仅debug可见】使用native支付", 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PayJsPlugin.14
 * JD-Core Version:    0.7.0.1
 */