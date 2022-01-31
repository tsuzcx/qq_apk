package com.tencent.mobileqq.microapp.appbrand.page;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import beej;
import befh;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.microapp.widget.ProgressView;
import com.tencent.smtt.sdk.WebView;
import xsm;

public class ProgressWebView$MiniAppWebviewBuilder
  extends beej
  implements befh
{
  ProgressView progressView;
  
  public ProgressWebView$MiniAppWebviewBuilder(Context paramContext, Activity paramActivity, AppInterface paramAppInterface, TouchWebView paramTouchWebView)
  {
    super(paramContext, paramActivity, paramAppInterface);
    this.mWebview = paramTouchWebView;
  }
  
  public void buildBottomBar() {}
  
  public void buildContentView(Bundle paramBundle) {}
  
  public void buildData() {}
  
  public void buildLayout()
  {
    this.progressView = new ProgressView(this.mWebview.getContext());
    this.progressView.setLayoutParams(new ViewGroup.LayoutParams(-1, xsm.a(this.mWebview.getContext(), 3.0F)));
    this.progressView.b(Color.parseColor("#12B7F5"));
    this.mWebview.addView(this.progressView);
  }
  
  public void buildTitleBar() {}
  
  public void buildWebView(AppInterface paramAppInterface)
  {
    super.buildBaseWebView(paramAppInterface);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    if (paramInt == 100) {
      this.progressView.setVisibility(8);
    }
    for (;;)
    {
      super.onProgressChanged(paramWebView, paramInt);
      return;
      this.progressView.a(paramInt);
    }
  }
  
  public void preInitWebviewPlugin() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.ProgressWebView.MiniAppWebviewBuilder
 * JD-Core Version:    0.7.0.1
 */