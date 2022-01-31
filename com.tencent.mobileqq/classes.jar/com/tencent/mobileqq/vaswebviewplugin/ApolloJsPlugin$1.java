package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor;

class ApolloJsPlugin$1
  implements Runnable
{
  ApolloJsPlugin$1(ApolloJsPlugin paramApolloJsPlugin, String paramString) {}
  
  public void run()
  {
    this.this$0.mInterceptor = ApolloUrlInterceptor.a(false, this.val$innerUrl);
    ApolloJsPlugin.access$002(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */