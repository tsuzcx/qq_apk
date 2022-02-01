package com.tencent.mobileqq.vas.hippy;

import com.tencent.mobileqq.vas.hippyhelper.HippyJSBHelper;
import com.tencent.mobileqq.vas.hippyhelper.IHippyJsbInvokeAdapter;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public class HippyCallBackListenerWebViewPlugin
  extends WebViewPlugin
{
  private final HippyJSBHelper a = HippyJSBHelper.b();
  
  public void callJs(String paramString)
  {
    this.a.a().onCallJs(paramString);
  }
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    this.a.a().onCallJs(paramVarArgs);
  }
  
  public void callJs4OpenApi(JsBridgeListener paramJsBridgeListener, int paramInt, String paramString)
  {
    this.a.a().onCallJs(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.HippyCallBackListenerWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */