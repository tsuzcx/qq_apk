package com.tencent.mobileqq.ecshop.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ecshop.view.EcshopNewPageWebViewBuilder;
import com.tencent.mobileqq.ecshop.view.EcshopWebview;
import com.tencent.smtt.sdk.WebView;

class EcshopTabFragment$1
  extends EcshopNewPageWebViewBuilder
{
  EcshopTabFragment$1(EcshopTabFragment paramEcshopTabFragment, Context paramContext, Activity paramActivity, AppInterface paramAppInterface, TouchWebView paramTouchWebView, String paramString)
  {
    super(paramContext, paramActivity, paramAppInterface, paramTouchWebView, paramString);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    EcshopTabFragment.a(this.a).setVisibility(0);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.widget.EcshopTabFragment.1
 * JD-Core Version:    0.7.0.1
 */