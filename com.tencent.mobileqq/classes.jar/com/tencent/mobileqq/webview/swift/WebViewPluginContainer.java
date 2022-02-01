package com.tencent.mobileqq.webview.swift;

import android.content.Intent;

public abstract interface WebViewPluginContainer
{
  public abstract int pluginStartActivityForResult(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte);
  
  public abstract int switchRequestCode(WebViewPlugin paramWebViewPlugin, byte paramByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewPluginContainer
 * JD-Core Version:    0.7.0.1
 */