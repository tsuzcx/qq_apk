package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.pm.PackageManager;
import bdfz;
import bdgk;
import bdik;

class InternalJSPlugin$5
  implements Runnable
{
  InternalJSPlugin$5(InternalJSPlugin paramInternalJSPlugin, Activity paramActivity, String paramString1, String paramString2, PackageManager paramPackageManager, String paramString3, bdfz parambdfz) {}
  
  public void run()
  {
    bdgk.a(this.val$activity, 230, null, String.format("即将离开QQ，打开「%s」", new Object[] { this.val$appName }), "取消", "允许", new InternalJSPlugin.5.1(this), new InternalJSPlugin.5.2(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InternalJSPlugin.5
 * JD-Core Version:    0.7.0.1
 */