package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;

class EmojiJsPlugin$8
  implements Runnable
{
  EmojiJsPlugin$8(EmojiJsPlugin paramEmojiJsPlugin) {}
  
  public void run()
  {
    WebUiBaseInterface localWebUiBaseInterface = this.this$0.mRuntime.a(this.this$0.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebTitleBarInterface)))
    {
      this.this$0.progressDialog = new QQProgressDialog(this.this$0.mRuntime.a(), ((WebUiUtils.WebTitleBarInterface)localWebUiBaseInterface).b());
      this.this$0.progressDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */