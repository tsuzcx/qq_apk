package com.tencent.mobileqq.webviewplugin;

import android.view.View.OnClickListener;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;

public abstract interface WebUiUtils$WebViewProviderInterface
  extends WebUiBaseInterface
{
  public abstract WebViewWrapper createWebViewWrapper(boolean paramBoolean);
  
  public abstract View.OnClickListener getOnclickListener();
  
  public abstract WebUiUtils.WebShareInterface getWebShareInterface();
  
  public abstract WebUiUtils.WebTitleBarInterface getWebTitleBarInterface();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebUiUtils.WebViewProviderInterface
 * JD-Core Version:    0.7.0.1
 */