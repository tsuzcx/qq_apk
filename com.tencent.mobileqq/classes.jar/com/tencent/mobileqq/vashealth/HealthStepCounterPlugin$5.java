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
    QQToast localQQToast = new QQToast(this.this$0.mRuntime.a().getContext());
    QQToast.a(this.this$0.mRuntime.a().getContext(), HardCodeUtil.a(2131705477), 0).b((int)(localQQToast.a() * 2.5D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthStepCounterPlugin.5
 * JD-Core Version:    0.7.0.1
 */