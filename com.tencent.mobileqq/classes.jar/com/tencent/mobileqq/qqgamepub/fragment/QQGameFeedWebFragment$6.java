package com.tencent.mobileqq.qqgamepub.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.widget.LinearLayout;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqgamepub.web.QQGameWebViewBuilder;
import com.tencent.mobileqq.qqgamepub.web.view.QQGamePubWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

class QQGameFeedWebFragment$6
  extends QQGameWebViewBuilder
{
  QQGameFeedWebFragment$6(QQGameFeedWebFragment paramQQGameFeedWebFragment, Context paramContext, Activity paramActivity, AppInterface paramAppInterface, TouchWebView paramTouchWebView)
  {
    super(paramContext, paramActivity, paramAppInterface, paramTouchWebView);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    this.a.i = SystemClock.elapsedRealtime();
    this.a.e = System.currentTimeMillis();
    super.onPageFinished(paramWebView, paramString);
    QQGameFeedWebFragment.a(this.a).setVisibility(0);
    QQGameFeedWebFragment.a(this.a).setVisibility(8);
    QLog.d("GameWebPage", 4, "-->web onPageFinished");
    try
    {
      QQGameFeedWebFragment.b(this.a);
      return;
    }
    catch (Throwable paramWebView)
    {
      paramWebView.printStackTrace();
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.a.g = SystemClock.elapsedRealtime();
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment.6
 * JD-Core Version:    0.7.0.1
 */