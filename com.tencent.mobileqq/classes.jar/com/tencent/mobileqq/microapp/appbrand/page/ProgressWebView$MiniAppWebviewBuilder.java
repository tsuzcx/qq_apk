package com.tencent.mobileqq.microapp.appbrand.page;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import bidf;
import biec;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.smtt.sdk.WebView;

public class ProgressWebView$MiniAppWebviewBuilder
  extends bidf
  implements biec
{
  public ProgressWebView$MiniAppWebviewBuilder(Context paramContext, Activity paramActivity, AppInterface paramAppInterface, TouchWebView paramTouchWebView)
  {
    super(paramContext, paramActivity, paramAppInterface);
    this.mWebview = paramTouchWebView;
  }
  
  public void buildBottomBar() {}
  
  public void buildContentView(Bundle paramBundle) {}
  
  public void buildData() {}
  
  public void buildLayout() {}
  
  public void buildTitleBar() {}
  
  public void buildWebView(AppInterface paramAppInterface)
  {
    super.buildBaseWebView(paramAppInterface);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
  }
  
  public void preInitWebviewPlugin() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.ProgressWebView.MiniAppWebviewBuilder
 * JD-Core Version:    0.7.0.1
 */