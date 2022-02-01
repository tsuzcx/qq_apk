package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;

class InternalJSPlugin$8
  implements Runnable
{
  InternalJSPlugin$8(InternalJSPlugin paramInternalJSPlugin, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    DialogUtil.createCustomDialog(this.val$activity, 230, "提示", String.format("即将下载「%s」到手机", new Object[] { this.val$appName }), "取消", "允许", new InternalJSPlugin.8.1(this), new InternalJSPlugin.8.2(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InternalJSPlugin.8
 * JD-Core Version:    0.7.0.1
 */