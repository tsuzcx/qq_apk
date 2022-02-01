package com.tencent.qqmini.miniapp.core.page;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

class BrandPageWebview$2
  extends WebChromeClient
{
  BrandPageWebview$2(BrandPageWebview paramBrandPageWebview) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    if (paramConsoleMessage != null)
    {
      StringBuilder localStringBuilder;
      if (paramConsoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("PageWebView: ");
        localStringBuilder.append(paramConsoleMessage.message());
        localStringBuilder.append(" line:");
        localStringBuilder.append(paramConsoleMessage.lineNumber());
        localStringBuilder.append("  page:");
        localStringBuilder.append(BrandPageWebview.access$200(this.this$0));
        QMLog.e("TAG_CHROMIUM", localStringBuilder.toString());
      }
      else if (paramConsoleMessage.messageLevel() == ConsoleMessage.MessageLevel.WARNING)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("PageWebView: ");
        localStringBuilder.append(paramConsoleMessage.message());
        localStringBuilder.append(" line:");
        localStringBuilder.append(paramConsoleMessage.lineNumber());
        localStringBuilder.append("  page:");
        localStringBuilder.append(BrandPageWebview.access$200(this.this$0));
        QMLog.w("TAG_CHROMIUM", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("PageWebView: ");
        localStringBuilder.append(paramConsoleMessage.message());
        QMLog.i("TAG_CHROMIUM", localStringBuilder.toString());
      }
    }
    return super.onConsoleMessage(paramConsoleMessage);
  }
  
  public void onHideCustomView()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onHideCustomView ");
    localStringBuilder.append(Thread.currentThread());
    QMLog.d("miniapp-embedded", localStringBuilder.toString());
    if (this.this$0.customViewCallback == null) {
      return;
    }
    BrandPageWebview.access$400(this.this$0).postDelayed(new BrandPageWebview.2.1(this), 200L);
  }
  
  @Override
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
    super.onProgressChanged(paramWebView, paramInt);
  }
  
  public void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onShowCustomView ： ");
    ((StringBuilder)localObject).append(paramView);
    ((StringBuilder)localObject).append("; ");
    ((StringBuilder)localObject).append(Thread.currentThread());
    QMLog.d("miniapp-embedded", ((StringBuilder)localObject).toString());
    if (this.this$0.customViewCallback != null)
    {
      paramCustomViewCallback.onCustomViewHidden();
      return;
    }
    QMLog.d("miniapp-embedded", "onShowCustomView begin");
    if ((this.this$0.customContainer == null) && (BrandPageWebview.access$300(this.this$0) != null))
    {
      localObject = this.this$0;
      ((BrandPageWebview)localObject).customContainer = new FrameLayout(BrandPageWebview.access$300((BrandPageWebview)localObject).getContext());
      this.this$0.customContainer.setBackgroundColor(-16777216);
      localObject = BrandPageWebview.access$300(this.this$0).getAttachedActivity();
      if (localObject != null) {
        ((ViewGroup)((Activity)localObject).getWindow().getDecorView()).addView(this.this$0.customContainer, new ViewGroup.LayoutParams(-1, -1));
      }
    }
    if (this.this$0.customContainer != null)
    {
      this.this$0.customContainer.addView(paramView);
      this.this$0.customContainer.setVisibility(0);
    }
    localObject = this.this$0;
    ((BrandPageWebview)localObject).mFullscreenView = paramView;
    ((BrandPageWebview)localObject).customViewCallback = paramCustomViewCallback;
    ((BrandPageWebview)localObject).isFullScreen = true;
    QMLog.d("miniapp-embedded", "onShowCustomView end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.BrandPageWebview.2
 * JD-Core Version:    0.7.0.1
 */