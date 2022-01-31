package com.tencent.qqmini.sdk.core.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import begz;
import bfgs;
import bfgv;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class LogJsPlugin$1$1
  implements DialogInterface.OnClickListener
{
  LogJsPlugin$1$1(LogJsPlugin.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bfgv.a().edit().putBoolean(this.this$1.this$0.mMiniAppContext.a().appId + "_debug", this.this$1.val$enableDebug);
    bfgs.a(this.this$1.this$0.mMiniAppContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.LogJsPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */