package com.tencent.qqmini.sdk.core.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bglv;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.ProcessUtil;
import com.tencent.qqmini.sdk.utils.StorageUtil;

class LogJsPlugin$1$1
  implements DialogInterface.OnClickListener
{
  LogJsPlugin$1$1(LogJsPlugin.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    StorageUtil.getPreference().edit().putBoolean(this.this$1.this$0.mMiniAppContext.a().appId + "_debug", this.this$1.val$enableDebug);
    ProcessUtil.exitProcess(this.this$1.this$0.mMiniAppContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.LogJsPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */