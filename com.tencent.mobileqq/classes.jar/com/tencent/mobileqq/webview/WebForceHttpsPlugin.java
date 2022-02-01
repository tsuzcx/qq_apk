package com.tencent.mobileqq.webview;

import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.qphone.base.util.QLog;

public class WebForceHttpsPlugin
  extends WebViewPlugin
{
  public WebForceHttpsPlugin()
  {
    this.mPluginNameSpace = "forceHttps";
  }
  
  private boolean a(String paramString)
  {
    AuthorizeConfig localAuthorizeConfig = AuthorizeConfig.a();
    if (localAuthorizeConfig.j(paramString)) {
      return localAuthorizeConfig.k(paramString) ^ true;
    }
    return false;
  }
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 1L;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if (!AuthorizeConfig.a().h()) {
      return false;
    }
    if (("http".equals(paramString2)) && (a(paramString1)))
    {
      paramString2 = (SwiftBrowserStatistics)getBrowserComponent(-2);
      if (paramString2 != null) {
        paramString2.aU = true;
      }
      paramString2 = new StringBuilder();
      paramString2.append("https");
      paramString2.append(paramString1.substring(4));
      paramString2 = paramString2.toString();
      CustomWebView localCustomWebView = this.mRuntime.a();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("need switch url=");
        localStringBuilder.append(Util.b(paramString1, new String[0]));
        if (localCustomWebView == null) {
          paramString1 = ", view==null";
        } else {
          paramString1 = "";
        }
        localStringBuilder.append(paramString1);
        QLog.i("forceHttps", 2, localStringBuilder.toString());
      }
      if (localCustomWebView != null)
      {
        localCustomWebView.loadUrl(paramString2);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebForceHttpsPlugin
 * JD-Core Version:    0.7.0.1
 */