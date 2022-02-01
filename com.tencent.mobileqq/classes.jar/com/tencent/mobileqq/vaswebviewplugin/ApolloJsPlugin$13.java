package com.tencent.mobileqq.vaswebviewplugin;

import bifw;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;

class ApolloJsPlugin$13
  implements Runnable
{
  ApolloJsPlugin$13(ApolloJsPlugin paramApolloJsPlugin, int paramInt) {}
  
  public void run()
  {
    if ((this.this$0.mRuntime != null) && (this.this$0.mRuntime.a() != null))
    {
      TouchWebView localTouchWebView = (TouchWebView)this.this$0.mRuntime.a();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, "[IPC_APOLLO_DOWNLOAD_GAME] callJs: window.onGameDownloadProgress(" + this.val$percent + ")");
      }
      if (localTouchWebView != null) {
        localTouchWebView.callJs("window.onGameDownloadProgress &&　window.onGameDownloadProgress(" + this.val$percent + ")");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.13
 * JD-Core Version:    0.7.0.1
 */