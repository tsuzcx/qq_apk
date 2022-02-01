package com.tencent.mobileqq.webview.swift.component;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.Map;

final class SwiftBrowserTBSHandler$10
  implements Runnable
{
  SwiftBrowserTBSHandler$10(String paramString1, String paramString2, WebView paramWebView, int paramInt1, int paramInt2, String paramString3) {}
  
  public void run()
  {
    Object localObject;
    if (!TextUtils.isEmpty(this.a))
    {
      localObject = new HashMap();
      ((Map)localObject).put("TYPE", "4");
      ((Map)localObject).put("mimeType", "text/html");
      ((Map)localObject).put("encoding", "utf-8");
      ((Map)localObject).put("baseUrl", this.b);
      this.c.getX5WebViewExtension().preLoad(this.a, this.d, this.e, (Map)localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("webView.getX5WebViewExtension().preLoad offline data:");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append(", sha1: ");
        ((StringBuilder)localObject).append(this.f);
        QLog.d("SwiftBrowserTBSHandler", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      this.c.getX5WebViewExtension().preLoad(this.b, this.d, this.e, null);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("webView.getX5WebViewExtension().preLoad: ");
        ((StringBuilder)localObject).append(this.b);
        QLog.d("SwiftBrowserTBSHandler", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.10
 * JD-Core Version:    0.7.0.1
 */