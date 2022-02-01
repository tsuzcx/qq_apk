package com.tencent.open.appcommon.js;

import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

class OpenJsBridge$OpenJsBridgeListener$1
  implements Runnable
{
  OpenJsBridge$OpenJsBridgeListener$1(OpenJsBridge.OpenJsBridgeListener paramOpenJsBridgeListener, String paramString1, String paramString2, WebView paramWebView) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onOpenComplete]AsyncInterface_end:javascript:window.JsBridge&&JsBridge.callback('interface.");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("',{guid:");
    ((StringBuilder)localObject).append(this.this$0.e);
    ((StringBuilder)localObject).append(",'r':0,'data':");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("});");
    LogUtility.b("OpenJsBridge", ((StringBuilder)localObject).toString());
    try
    {
      localObject = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript:window.JsBridge&&JsBridge.callback('interface.");
      localStringBuilder.append(this.a);
      localStringBuilder.append("',{guid:");
      localStringBuilder.append(this.this$0.e);
      localStringBuilder.append(",'r':0,'data':");
      localStringBuilder.append(this.b);
      localStringBuilder.append("});");
      ((WebView)localObject).loadUrl(localStringBuilder.toString());
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.js.OpenJsBridge.OpenJsBridgeListener.1
 * JD-Core Version:    0.7.0.1
 */