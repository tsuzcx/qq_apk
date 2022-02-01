package com.tencent.mobileqq.webview;

import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
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
    boolean bool2 = false;
    AuthorizeConfig localAuthorizeConfig = AuthorizeConfig.a();
    boolean bool1 = bool2;
    if (localAuthorizeConfig.e(paramString))
    {
      bool1 = bool2;
      if (!localAuthorizeConfig.f(paramString)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 1L;
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if (!AuthorizeConfig.a().d()) {
      return false;
    }
    if (("http".equals(paramString2)) && (a(paramString1)))
    {
      paramString2 = (WebViewFragment)this.mRuntime.a();
      if ((paramString2 != null) && (paramString2.mStatistics != null)) {
        paramString2.mStatistics.C = true;
      }
      paramString2 = "https" + paramString1.substring("http".length());
      CustomWebView localCustomWebView = this.mRuntime.a();
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("need switch url=").append(Util.b(paramString1, new String[0]));
        if (localCustomWebView != null) {
          break label158;
        }
      }
      label158:
      for (paramString1 = ", view==null";; paramString1 = "")
      {
        QLog.i("forceHttps", 2, paramString1);
        if (localCustomWebView == null) {
          break;
        }
        localCustomWebView.loadUrl(paramString2);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebForceHttpsPlugin
 * JD-Core Version:    0.7.0.1
 */