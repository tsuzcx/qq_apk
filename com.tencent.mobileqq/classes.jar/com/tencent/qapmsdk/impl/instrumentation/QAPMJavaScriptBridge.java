package com.tencent.qapmsdk.impl.instrumentation;

import android.webkit.JavascriptInterface;
import com.tencent.qapmsdk.athena.BreadCrumb;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UrlMeta;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.jserror.JsError;
import com.tencent.qapmsdk.webview.WebViewX5Proxy;

public class QAPMJavaScriptBridge
{
  private static volatile QAPMJavaScriptBridge javaScriptBridge;
  private String breadCrumbId = "";
  
  public static QAPMJavaScriptBridge getInstance()
  {
    if (javaScriptBridge == null) {}
    try
    {
      if (javaScriptBridge == null) {
        javaScriptBridge = new QAPMJavaScriptBridge();
      }
      return javaScriptBridge;
    }
    finally {}
  }
  
  @JavascriptInterface
  public String getAppkey()
  {
    return BaseInfo.userMeta.appKey + "-" + BaseInfo.userMeta.appId;
  }
  
  @JavascriptInterface
  public String getAthenaUrl()
  {
    return BaseInfo.urlMeta.athenaDomain;
  }
  
  @JavascriptInterface
  public boolean getBreadCrumbEnable()
  {
    return BreadCrumb.getInstance().isEnable();
  }
  
  public String getBreadCrumbId()
  {
    return this.breadCrumbId;
  }
  
  @JavascriptInterface
  public String getDeviceId()
  {
    return BaseInfo.userMeta.deviceId;
  }
  
  @JavascriptInterface
  public boolean getJsErrorEnable()
  {
    return JsError.jsErrorEnable();
  }
  
  @JavascriptInterface
  public String getQAPMUrl()
  {
    return BaseInfo.urlMeta.qapmDomain;
  }
  
  @JavascriptInterface
  public String getUin()
  {
    return BaseInfo.userMeta.uin;
  }
  
  @JavascriptInterface
  public boolean getWebMonitorEnable()
  {
    return WebViewX5Proxy.getInstance().canWebMonitorEnable();
  }
  
  @JavascriptInterface
  public void setBreadCrumbId(String paramString)
  {
    this.breadCrumbId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMJavaScriptBridge
 * JD-Core Version:    0.7.0.1
 */