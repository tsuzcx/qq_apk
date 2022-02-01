package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.IPayResultCallBack;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.PayResponse;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class PayJsPlugin$13
  implements PayProxy.IPayResultCallBack
{
  PayJsPlugin$13(PayJsPlugin paramPayJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onPayCallBack(PayProxy.PayResponse paramPayResponse)
  {
    PayJsPlugin.access$1700(this.this$0, paramPayResponse, this.val$req);
  }
  
  public void payNeedLogin()
  {
    QMLog.e("PayJsPlugin", "handleMidasMonthCardPay payNeedLogin");
    PayJsPlugin.access$700(this.this$0, this.val$req, null, "payNeedLogin");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PayJsPlugin.13
 * JD-Core Version:    0.7.0.1
 */