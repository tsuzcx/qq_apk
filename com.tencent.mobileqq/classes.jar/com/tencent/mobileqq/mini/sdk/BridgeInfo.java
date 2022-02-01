package com.tencent.mobileqq.mini.sdk;

import com.tencent.mobileqq.mini.webview.JsRuntime;

public class BridgeInfo
{
  public int callbackId;
  private JsRuntime webview;
  
  public BridgeInfo(JsRuntime paramJsRuntime, int paramInt)
  {
    this.webview = paramJsRuntime;
    this.callbackId = paramInt;
  }
  
  public JsRuntime getWebView()
  {
    return this.webview;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.BridgeInfo
 * JD-Core Version:    0.7.0.1
 */