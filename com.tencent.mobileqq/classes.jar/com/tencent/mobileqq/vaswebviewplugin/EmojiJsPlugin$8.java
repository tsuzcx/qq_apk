package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebViewProviderInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;

class EmojiJsPlugin$8
  implements Runnable
{
  EmojiJsPlugin$8(EmojiJsPlugin paramEmojiJsPlugin) {}
  
  public void run()
  {
    WebUiUtils.WebViewProviderInterface localWebViewProviderInterface = this.this$0.mRuntime.a();
    if ((localWebViewProviderInterface != null) && (localWebViewProviderInterface.getWebTitleBarInterface() != null))
    {
      EmojiJsPlugin localEmojiJsPlugin = this.this$0;
      localEmojiJsPlugin.progressDialog = new QQProgressDialog(localEmojiJsPlugin.mRuntime.a(), localWebViewProviderInterface.getWebTitleBarInterface().a());
      this.this$0.progressDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */