package com.tencent.qqmini.miniapp.core.page;

import Override;
import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

class BrandPageWebview$3
  extends WebChromeClient
{
  BrandPageWebview$3(BrandPageWebview paramBrandPageWebview) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    if (paramConsoleMessage != null)
    {
      if (paramConsoleMessage.messageLevel() != ConsoleMessage.MessageLevel.ERROR) {
        break label80;
      }
      QMLog.e("TAG_CHROMIUM", "PageWebView: " + paramConsoleMessage.message() + " line:" + paramConsoleMessage.lineNumber() + "  page:" + BrandPageWebview.access$400(this.this$0));
    }
    for (;;)
    {
      return super.onConsoleMessage(paramConsoleMessage);
      label80:
      if (paramConsoleMessage.messageLevel() == ConsoleMessage.MessageLevel.WARNING) {
        QMLog.w("TAG_CHROMIUM", "PageWebView: " + paramConsoleMessage.message() + " line:" + paramConsoleMessage.lineNumber() + "  page:" + BrandPageWebview.access$400(this.this$0));
      } else {
        QMLog.i("TAG_CHROMIUM", "PageWebView: " + paramConsoleMessage.message());
      }
    }
  }
  
  public void onHideCustomView()
  {
    QMLog.d("miniapp-embedded", "onHideCustomView " + Thread.currentThread());
    if (this.this$0.customViewCallback == null) {
      return;
    }
    BrandPageWebview.access$600(this.this$0).postDelayed(new BrandPageWebview.3.1(this), 200L);
  }
  
  @Override
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    if (JsBridgeController.getInstance().shouldIntercept(paramWebView, paramString2, paramString1, paramJsPromptResult)) {
      return true;
    }
    return super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
  }
  
  @Override
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
    super.onProgressChanged(paramWebView, paramInt);
  }
  
  public void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    QMLog.d("miniapp-embedded", "onShowCustomView ： " + paramView + "; " + Thread.currentThread());
    if (this.this$0.customViewCallback != null)
    {
      paramCustomViewCallback.onCustomViewHidden();
      return;
    }
    QMLog.d("miniapp-embedded", "onShowCustomView begin");
    if ((this.this$0.customContainer == null) && (BrandPageWebview.access$500(this.this$0) != null))
    {
      this.this$0.customContainer = new FrameLayout(BrandPageWebview.access$500(this.this$0).getContext());
      this.this$0.customContainer.setBackgroundColor(-16777216);
      Activity localActivity = BrandPageWebview.access$500(this.this$0).getAttachedActivity();
      if (localActivity != null) {
        ((ViewGroup)localActivity.getWindow().getDecorView()).addView(this.this$0.customContainer, new ViewGroup.LayoutParams(-1, -1));
      }
    }
    if (this.this$0.customContainer != null)
    {
      this.this$0.customContainer.addView(paramView);
      this.this$0.customContainer.setVisibility(0);
    }
    this.this$0.mFullscreenView = paramView;
    this.this$0.customViewCallback = paramCustomViewCallback;
    this.this$0.isFullScreen = true;
    QMLog.d("miniapp-embedded", "onShowCustomView end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.BrandPageWebview.3
 * JD-Core Version:    0.7.0.1
 */