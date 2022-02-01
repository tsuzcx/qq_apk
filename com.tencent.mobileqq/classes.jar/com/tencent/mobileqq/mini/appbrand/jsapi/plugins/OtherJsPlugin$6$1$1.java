package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.qphone.base.util.QLog;

class OtherJsPlugin$6$1$1
  implements OtherJsPlugin.AddColorSignListener
{
  OtherJsPlugin$6$1$1(OtherJsPlugin.6.1 param1) {}
  
  public void onAddColorSign(boolean paramBoolean)
  {
    QLog.d(OtherJsPlugin.access$000(), 1, "onAddColorSign:" + paramBoolean);
    if (paramBoolean)
    {
      this.this$2.this$1.this$0.jsPluginEngine.callbackJsEventOK(this.this$2.this$1.val$webview, this.this$2.this$1.val$eventName, null, this.this$2.this$1.val$callbackId);
      return;
    }
    this.this$2.this$1.this$0.jsPluginEngine.callbackJsEventFail(this.this$2.this$1.val$webview, this.this$2.this$1.val$eventName, null, this.this$2.this$1.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OtherJsPlugin.6.1.1
 * JD-Core Version:    0.7.0.1
 */