package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;

class EmojiUiPlugin$4
  implements Runnable
{
  EmojiUiPlugin$4(EmojiUiPlugin paramEmojiUiPlugin) {}
  
  public void run()
  {
    this.this$0.progressDialog = new QQProgressDialog(this.this$0.mRuntime.a(), ((QQBrowserActivity)this.this$0.mRuntime.a()).getTitleBarHeight());
    this.this$0.progressDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin.4
 * JD-Core Version:    0.7.0.1
 */