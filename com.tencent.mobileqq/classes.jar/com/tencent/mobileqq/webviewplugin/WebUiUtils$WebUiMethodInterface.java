package com.tencent.mobileqq.webviewplugin;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;

public abstract interface WebUiUtils$WebUiMethodInterface
  extends WebUiBaseInterface
{
  public abstract String getCurrentUrl();
  
  public abstract CustomWebView getWebView();
  
  public abstract boolean isActivityResume();
  
  public abstract void showActionSheet();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface
 * JD-Core Version:    0.7.0.1
 */