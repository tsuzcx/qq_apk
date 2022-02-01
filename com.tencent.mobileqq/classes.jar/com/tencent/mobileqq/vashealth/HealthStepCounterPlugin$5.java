package com.tencent.mobileqq.vashealth;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;

class HealthStepCounterPlugin$5
  implements Runnable
{
  HealthStepCounterPlugin$5(HealthStepCounterPlugin paramHealthStepCounterPlugin) {}
  
  public void run()
  {
    QQToast localQQToast1 = new QQToast(this.this$0.mRuntime.a().getContext());
    QQToast localQQToast2 = QQToast.a(this.this$0.mRuntime.a().getContext(), HardCodeUtil.a(2131705550), 0);
    double d = localQQToast1.a();
    Double.isNaN(d);
    localQQToast2.b((int)(d * 2.5D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthStepCounterPlugin.5
 * JD-Core Version:    0.7.0.1
 */