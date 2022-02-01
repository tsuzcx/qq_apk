package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;

public class BridgeInterface
{
  public static final String JS_OBJECT_NAME = "DTJsBridgeInterface";
  private Object mWebView;
  
  public BridgeInterface(Object paramObject)
  {
    this.mWebView = paramObject;
  }
  
  @JavascriptInterface
  public String bridgeCall(String paramString)
  {
    String str = JsBridgeController.getInstance().shouldIntercept(this.mWebView, paramString, "");
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = JsBridgeCall.getResponse(500, "");
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.BridgeInterface
 * JD-Core Version:    0.7.0.1
 */