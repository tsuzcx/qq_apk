package com.tencent.mobileqq.webview.build;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;

public abstract interface IWebViewBuilder
{
  public abstract void buildBottomBar();
  
  public abstract void buildContentView(Bundle paramBundle);
  
  public abstract void buildData();
  
  public abstract void buildLayout();
  
  public abstract void buildTitleBar();
  
  public abstract void buildWebView(AppInterface paramAppInterface);
  
  public abstract void preInitWebviewPlugin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.build.IWebViewBuilder
 * JD-Core Version:    0.7.0.1
 */