package com.tencent.qqmini.sdk.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.utils.ProcessUtil;

class LogJsPlugin$1$1
  implements DialogInterface.OnClickListener
{
  LogJsPlugin$1$1(LogJsPlugin.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = StorageUtil.getPreference().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LogJsPlugin.access$100(this.this$1.this$0).getMiniAppInfo().appId);
    localStringBuilder.append("_debug");
    paramDialogInterface.putBoolean(localStringBuilder.toString(), this.this$1.val$enableDebug).commit();
    ProcessUtil.exitProcess(LogJsPlugin.access$200(this.this$1.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.LogJsPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */