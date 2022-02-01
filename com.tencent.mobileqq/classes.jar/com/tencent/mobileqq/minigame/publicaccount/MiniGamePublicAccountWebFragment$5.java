package com.tencent.mobileqq.minigame.publicaccount;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.widget.LinearLayout;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.smtt.sdk.WebView;

class MiniGamePublicAccountWebFragment$5
  extends MiniGamePublicAccountWebViewBuilder
{
  MiniGamePublicAccountWebFragment$5(MiniGamePublicAccountWebFragment paramMiniGamePublicAccountWebFragment, Context paramContext, Activity paramActivity, AppInterface paramAppInterface, TouchWebView paramTouchWebView)
  {
    super(paramContext, paramActivity, paramAppInterface, paramTouchWebView);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    this.this$0.parsePageEndTime = SystemClock.elapsedRealtime();
    super.onPageFinished(paramWebView, paramString);
    MiniGamePublicAccountWebFragment.access$1100(this.this$0).setVisibility(0);
    MiniGamePublicAccountWebFragment.access$1200(this.this$0).setVisibility(8);
    int i = MiniGamePublicAccountWebFragment.access$400(this.this$0);
    this.this$0.notifyWebHeaderHeight(i);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.this$0.loadUrlEndTime = SystemClock.elapsedRealtime();
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.5
 * JD-Core Version:    0.7.0.1
 */