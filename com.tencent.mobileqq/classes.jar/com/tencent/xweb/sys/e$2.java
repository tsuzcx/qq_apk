package com.tencent.xweb.sys;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.extension.video.b;
import com.tencent.xweb.u;
import com.tencent.xweb.util.h;
import org.xwalk.core.Log;

class e$2
  extends WebChromeClient
{
  e$2(e parame) {}
  
  public View getVideoLoadingProgressView()
  {
    if (this.a.d != null) {
      return this.a.d.d();
    }
    return LayoutInflater.from(this.a.a.getContext()).inflate(2131629634, null);
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onConsoleMessage ");
    localStringBuilder.append(paramConsoleMessage.message());
    Log.i("SysWebView", localStringBuilder.toString());
    if (this.a.d != null) {
      return this.a.d.a(paramConsoleMessage);
    }
    return super.onConsoleMessage(paramConsoleMessage);
  }
  
  public void onGeolocationPermissionsHidePrompt()
  {
    Log.i("SysWebView", "onGeolocationPermissionsHidePrompt");
    if (this.a.d != null)
    {
      this.a.d.a();
      return;
    }
    super.onGeolocationPermissionsHidePrompt();
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    Log.i("SysWebView", "onGeolocationPermissionsShowPrompt");
    if (this.a.d != null)
    {
      this.a.d.a(paramString, paramCallback);
      return;
    }
    super.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
  }
  
  public void onHideCustomView()
  {
    Log.i("SysWebView", "onHideCustomView");
    e locale = this.a;
    boolean bool = false;
    e.a(locale, false);
    if (this.a.d != null) {
      bool = this.a.d.o_();
    }
    if (bool)
    {
      Log.i("SysWebView", "onHideCustomView isHandled:true");
      return;
    }
    if (e.a(this.a) != null)
    {
      e.a(this.a).a();
      return;
    }
    if (this.a.d != null)
    {
      this.a.d.c();
      return;
    }
    super.onHideCustomView();
  }
  
  public boolean onJsAlert(android.webkit.WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    Log.i("SysWebView", "onJsAlert");
    if (this.a.d != null) {
      return this.a.d.c(this.a.a, paramString1, paramString2, new c.e(paramJsResult));
    }
    return super.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
  }
  
  public boolean onJsConfirm(android.webkit.WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    Log.i("SysWebView", "onJsConfirm");
    if (this.a.d != null) {
      return this.a.d.d(this.a.a, paramString1, paramString2, new c.e(paramJsResult));
    }
    return super.onJsConfirm(paramWebView, paramString1, paramString2, paramJsResult);
  }
  
  public boolean onJsPrompt(android.webkit.WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    Log.i("SysWebView", "onJsPrompt");
    if (this.a.d != null) {
      return this.a.d.a(this.a.a, paramString1, paramString2, paramString3, new c.d(paramJsPromptResult));
    }
    return super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
  }
  
  public void onProgressChanged(android.webkit.WebView paramWebView, int paramInt)
  {
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
    if (this.a.d != null)
    {
      this.a.d.b(this.a.a, paramInt);
      return;
    }
    super.onProgressChanged(paramWebView, paramInt);
  }
  
  public void onReceivedTitle(android.webkit.WebView paramWebView, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceivedTitle: ");
    ((StringBuilder)localObject).append(paramString);
    Log.i("SysWebView", ((StringBuilder)localObject).toString());
    if (e.a(this.a) != null)
    {
      localObject = e.a(this.a);
      boolean bool;
      if (this.a.a.getFullscreenVideoKind() == WebView.a.c) {
        bool = true;
      } else {
        bool = false;
      }
      ((b)localObject).a(true, bool);
    }
    if (this.a.d != null)
    {
      this.a.d.a(this.a.a, paramString);
      return;
    }
    super.onReceivedTitle(paramWebView, paramString);
  }
  
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    Log.i("SysWebView", "onShowCustomView");
    e.a(this.a, true);
    boolean bool;
    if (this.a.d != null) {
      bool = this.a.d.a(paramView, paramCustomViewCallback);
    } else {
      bool = false;
    }
    h.o();
    if (bool)
    {
      Log.i("SysWebView", "onShowCustomView isHandled:true");
      return;
    }
    if (e.a(this.a) != null)
    {
      e.a(this.a).a(paramView, paramCustomViewCallback);
      return;
    }
    if (this.a.d != null)
    {
      this.a.d.b(paramView, paramCustomViewCallback);
      return;
    }
    super.onShowCustomView(paramView, paramCustomViewCallback);
  }
  
  public boolean onShowFileChooser(android.webkit.WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    Log.i("SysWebView", "onShowFileChooser last method");
    if (this.a.d != null) {
      return this.a.d.a(this.a.a, paramValueCallback, new c.c(paramFileChooserParams));
    }
    return super.onShowFileChooser(paramWebView, paramValueCallback, paramFileChooserParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.sys.e.2
 * JD-Core Version:    0.7.0.1
 */