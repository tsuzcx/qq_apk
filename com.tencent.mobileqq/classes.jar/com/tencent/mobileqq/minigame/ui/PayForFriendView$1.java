package com.tencent.mobileqq.minigame.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.webviewwrapper.QzoneWebViewBaseBuilder;

class PayForFriendView$1
  extends QzoneWebViewBaseBuilder
{
  PayForFriendView$1(PayForFriendView paramPayForFriendView, Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface, boolean paramBoolean)
  {
    super(paramContext, paramActivity, paramIntent, paramAppInterface, paramBoolean);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    QLog.d("[minigame] PayForFriendView", 1, "checkPayForFriendLogic EVENT_LOAD_FINISH at " + System.currentTimeMillis());
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    QLog.d("[minigame] PayForFriendView", 1, "checkPayForFriendLogic EVENT_LOAD_START at " + System.currentTimeMillis());
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.PayForFriendView.1
 * JD-Core Version:    0.7.0.1
 */