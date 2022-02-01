package com.tencent.mobileqq.vas.qvip.fragment;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.vas.qvip.view.QQVipWebview;
import com.tencent.mobileqq.vas.qvip.web.QQVipWebViewBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

class QQVipFeedWedFragment$1
  extends QQVipWebViewBuilder
{
  QQVipFeedWedFragment$1(QQVipFeedWedFragment paramQQVipFeedWedFragment, Context paramContext, Activity paramActivity, AppInterface paramAppInterface, TouchWebView paramTouchWebView)
  {
    super(paramContext, paramActivity, paramAppInterface, paramTouchWebView);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    QQVipFeedWedFragment.a(this.a).onPageFinish(paramString);
    paramWebView = ObjectAnimator.ofFloat(QQVipFeedWedFragment.a(this.a), "alpha", new float[] { 0.0F, 1.0F });
    paramWebView.setDuration(300L);
    paramWebView.start();
    QLog.d("QQVipFeedWedFragment", 1, "onPageFinished : " + (SystemClock.elapsedRealtime() - this.a.b));
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.a.b = SystemClock.elapsedRealtime();
    this.a.c = (this.a.b - this.a.a);
    QLog.d("QQVipFeedWedFragment", 1, "loadUrlTime : " + this.a.c);
    QQVipFeedWedFragment.a(this.a).setVisibility(0);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.fragment.QQVipFeedWedFragment.1
 * JD-Core Version:    0.7.0.1
 */