package com.tencent.mobileqq.qqgamepub.web.delegate;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqgamepub.web.GameWebCostLogic;
import com.tencent.mobileqq.qqgamepub.web.QQGameWebViewBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

class QQGameWebViewDelegate$1
  extends QQGameWebViewBuilder
{
  QQGameWebViewDelegate$1(QQGameWebViewDelegate paramQQGameWebViewDelegate, Context paramContext, Activity paramActivity, AppInterface paramAppInterface, TouchWebView paramTouchWebView, GameWebCostLogic paramGameWebCostLogic)
  {
    super(paramContext, paramActivity, paramAppInterface, paramTouchWebView);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    this.a.d();
    QLog.d("QQGameWebViewDelegate", 4, "-->web onPageFinished");
    this.a.j();
    QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "preDownloadDnflutter", null, null);
    ThreadManagerV2.getUIHandlerV2().post(new QQGameWebViewDelegate.1.1(this, paramWebView, paramString));
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    this.a.c();
    if (QQGameWebViewDelegate.a(this.b) != null) {
      QQGameWebViewDelegate.a(this.b).a(paramWebView, paramString, paramBitmap);
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.web.delegate.QQGameWebViewDelegate.1
 * JD-Core Version:    0.7.0.1
 */