package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.webview.swift.JsBridgeListener;

public class VasWebviewJsPluginV2$JsData
{
  String[] args;
  String callbackId;
  JsBridgeListener listener;
  String url;
  
  public VasWebviewJsPluginV2$JsData(String paramString1, JsBridgeListener paramJsBridgeListener, String paramString2, String[] paramArrayOfString)
  {
    this.listener = paramJsBridgeListener;
    this.url = paramString2;
    this.args = paramArrayOfString;
    this.callbackId = paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPluginV2.JsData
 * JD-Core Version:    0.7.0.1
 */