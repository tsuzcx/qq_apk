package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import bekr;
import beld;
import bene;

class InternalJSPlugin$6
  implements Runnable
{
  InternalJSPlugin$6(InternalJSPlugin paramInternalJSPlugin, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, bekr parambekr) {}
  
  public void run()
  {
    beld.a(this.val$activity, 230, "提示", String.format("即将下载「%s」到手机", new Object[] { this.val$appName }), "取消", "允许", new InternalJSPlugin.6.1(this), new InternalJSPlugin.6.2(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InternalJSPlugin.6
 * JD-Core Version:    0.7.0.1
 */