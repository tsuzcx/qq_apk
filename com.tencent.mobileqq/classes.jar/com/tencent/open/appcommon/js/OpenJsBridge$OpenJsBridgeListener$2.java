package com.tencent.open.appcommon.js;

import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

class OpenJsBridge$OpenJsBridgeListener$2
  implements Runnable
{
  OpenJsBridge$OpenJsBridgeListener$2(OpenJsBridge.OpenJsBridgeListener paramOpenJsBridgeListener, String paramString, WebView paramWebView) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onNoMatchMethod]AsyncInterface_end:javascript:window.JsBridge&&JsBridge.callback('interface.");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("',{guid:");
    ((StringBuilder)localObject).append(this.this$0.e);
    ((StringBuilder)localObject).append(",'r':-2,'data':'no such method'});");
    LogUtility.b("OpenJsBridge", ((StringBuilder)localObject).toString());
    try
    {
      localObject = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript:window.JsBridge&&JsBridge.callback('interface.");
      localStringBuilder.append(this.a);
      localStringBuilder.append("',{guid:");
      localStringBuilder.append(this.this$0.e);
      localStringBuilder.append(",'r':-2,'data':'no such method'});");
      ((WebView)localObject).loadUrl(localStringBuilder.toString());
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.js.OpenJsBridge.OpenJsBridgeListener.2
 * JD-Core Version:    0.7.0.1
 */