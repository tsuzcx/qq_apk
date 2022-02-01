package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.R.string;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;

class LogJsPlugin$1
  implements Runnable
{
  LogJsPlugin$1(LogJsPlugin paramLogJsPlugin, boolean paramBoolean) {}
  
  public void run()
  {
    DialogUtil.createCustomDialog(LogJsPlugin.access$000(this.this$0).getAttachedActivity(), 230, "重启后生效", null, R.string.mini_sdk_cancel, R.string.mini_sdk_ok, new LogJsPlugin.1.1(this), null).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.LogJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */