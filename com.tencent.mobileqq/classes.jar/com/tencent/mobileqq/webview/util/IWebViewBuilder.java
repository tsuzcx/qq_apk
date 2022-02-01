package com.tencent.mobileqq.webview.util;

import android.os.Bundle;
import mqq.app.AppRuntime;

public abstract interface IWebViewBuilder
{
  public abstract void buildBottomBar();
  
  public abstract void buildContentView(Bundle paramBundle);
  
  public abstract void buildData();
  
  public abstract void buildLayout();
  
  public abstract void buildTitleBar();
  
  public abstract void buildWebView(AppRuntime paramAppRuntime);
  
  public abstract void preInitWebviewPlugin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.util.IWebViewBuilder
 * JD-Core Version:    0.7.0.1
 */