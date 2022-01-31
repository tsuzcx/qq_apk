package com.tencent.qqmini.sdk.core.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bfhj;

class DebugJsPlugin$1
  implements DialogInterface.OnClickListener
{
  DebugJsPlugin$1(DebugJsPlugin paramDebugJsPlugin, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DebugJsPlugin.access$100(this.this$0).edit().putBoolean(DebugJsPlugin.access$000(this.this$0) + "_deubg", this.val$enableDebug);
    bfhj.a(this.this$0.mMiniAppContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.DebugJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */