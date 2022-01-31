package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.util.StorageUtil;

class LogJsPlugin$2$1
  implements DialogInterface.OnClickListener
{
  LogJsPlugin$2$1(LogJsPlugin.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    StorageUtil.getPreference().edit().putBoolean(this.this$1.this$0.jsPluginEngine.appBrandRuntime.appId + "_debug", this.this$1.val$enableDebug);
    AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().exitProcess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.LogJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */