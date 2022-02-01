package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview;

import android.content.Context;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import java.util.Iterator;
import java.util.List;

class LiteLiveSdkWebViewBaseBuilder$2
  implements Runnable
{
  LiteLiveSdkWebViewBaseBuilder$2(LiteLiveSdkWebViewBaseBuilder paramLiteLiveSdkWebViewBaseBuilder, Context paramContext) {}
  
  public void run()
  {
    if (this.this$0.mWebview == null) {
      return;
    }
    Iterator localIterator = LiteLiveSdkWebViewBaseBuilder.g().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = this.this$0.mWebview.getPluginEngine().b((String)localObject);
      if ((localObject instanceof LiteLiveJsInterface)) {
        ((LiteLiveJsInterface)localObject).onInitJsAdapter(LiteLiveSdkWebViewBaseBuilder.a(this.this$0));
      }
    }
    LiteLiveSdkWebViewBaseBuilder.a(this.this$0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.LiteLiveSdkWebViewBaseBuilder.2
 * JD-Core Version:    0.7.0.1
 */