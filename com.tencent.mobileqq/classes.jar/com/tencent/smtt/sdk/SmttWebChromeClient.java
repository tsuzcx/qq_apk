package com.tencent.smtt.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.FileChooserParams;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.WebViewTransport;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.QuotaUpdater;
import com.tencent.smtt.export.external.proxy.X5ProxyWebChromeClient;

class SmttWebChromeClient
  extends X5ProxyWebChromeClient
{
  private WebChromeClient mChromeClient;
  private WebView mWebView;
  
  public SmttWebChromeClient(IX5WebChromeClient paramIX5WebChromeClient, WebView paramWebView, WebChromeClient paramWebChromeClient)
  {
    super(paramIX5WebChromeClient);
    this.mWebView = paramWebView;
    this.mChromeClient = paramWebChromeClient;
  }
  
  public Bitmap getDefaultVideoPoster()
  {
    return this.mChromeClient.getDefaultVideoPoster();
  }
  
  public void getVisitedHistory(android.webkit.ValueCallback<String[]> paramValueCallback) {}
  
  public void onCloseWindow(IX5WebViewBase paramIX5WebViewBase)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mChromeClient.onCloseWindow(this.mWebView);
  }
  
  public void onConsoleMessage(String paramString1, int paramInt, String paramString2) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    return this.mChromeClient.onConsoleMessage(paramConsoleMessage);
  }
  
  public boolean onCreateWindow(final IX5WebViewBase paramIX5WebViewBase, boolean paramBoolean1, boolean paramBoolean2, final Message paramMessage)
  {
    paramIX5WebViewBase = this.mWebView;
    paramIX5WebViewBase.getClass();
    paramIX5WebViewBase = new WebView.WebViewTransport(paramIX5WebViewBase);
    paramMessage = Message.obtain(paramMessage.getTarget(), new Runnable()
    {
      public void run()
      {
        WebView localWebView = paramIX5WebViewBase.getWebView();
        if (localWebView != null) {
          ((IX5WebViewBase.WebViewTransport)paramMessage.obj).setWebView(localWebView.getX5WebView());
        }
        paramMessage.sendToTarget();
      }
    });
    paramMessage.obj = paramIX5WebViewBase;
    return this.mChromeClient.onCreateWindow(this.mWebView, paramBoolean1, paramBoolean2, paramMessage);
  }
  
  public void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, QuotaUpdater paramQuotaUpdater)
  {
    this.mChromeClient.onExceededDatabaseQuota(paramString1, paramString2, paramLong1, paramLong2, paramLong3, new QuotaUpdaterImpl(paramQuotaUpdater));
  }
  
  public void onGeolocationPermissionsHidePrompt()
  {
    this.mChromeClient.onGeolocationPermissionsHidePrompt();
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    this.mChromeClient.onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
  }
  
  public void onHideCustomView()
  {
    this.mChromeClient.onHideCustomView();
  }
  
  public boolean onJsAlert(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    return this.mChromeClient.onJsAlert(this.mWebView, paramString1, paramString2, paramJsResult);
  }
  
  public boolean onJsBeforeUnload(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    return this.mChromeClient.onJsBeforeUnload(this.mWebView, paramString1, paramString2, paramJsResult);
  }
  
  public boolean onJsConfirm(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    return this.mChromeClient.onJsConfirm(this.mWebView, paramString1, paramString2, paramJsResult);
  }
  
  public boolean onJsPrompt(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    return this.mChromeClient.onJsPrompt(this.mWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
  }
  
  public boolean onJsTimeout()
  {
    return this.mChromeClient.onJsTimeout();
  }
  
  public void onProgressChanged(IX5WebViewBase paramIX5WebViewBase, int paramInt)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mChromeClient.onProgressChanged(this.mWebView, paramInt);
  }
  
  public void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, QuotaUpdater paramQuotaUpdater)
  {
    this.mChromeClient.onReachedMaxAppCacheSize(paramLong1, paramLong2, new QuotaUpdaterImpl(paramQuotaUpdater));
  }
  
  public void onReceivedIcon(IX5WebViewBase paramIX5WebViewBase, Bitmap paramBitmap)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mChromeClient.onReceivedIcon(this.mWebView, paramBitmap);
  }
  
  public void onReceivedTitle(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mChromeClient.onReceivedTitle(this.mWebView, paramString);
  }
  
  public void onReceivedTouchIconUrl(IX5WebViewBase paramIX5WebViewBase, String paramString, boolean paramBoolean)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mChromeClient.onReceivedTouchIconUrl(this.mWebView, paramString, paramBoolean);
  }
  
  public void onRequestFocus(IX5WebViewBase paramIX5WebViewBase)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mChromeClient.onRequestFocus(this.mWebView);
  }
  
  public void onShowCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.mChromeClient.onShowCustomView(paramView, paramInt, paramCustomViewCallback);
  }
  
  public void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.mChromeClient.onShowCustomView(paramView, paramCustomViewCallback);
  }
  
  public boolean onShowFileChooser(IX5WebViewBase paramIX5WebViewBase, final android.webkit.ValueCallback<Uri[]> paramValueCallback, final IX5WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    paramValueCallback = new ValueCallback()
    {
      public void onReceiveValue(Uri[] paramAnonymousArrayOfUri)
      {
        paramValueCallback.onReceiveValue(paramAnonymousArrayOfUri);
      }
    };
    paramFileChooserParams = new WebChromeClient.FileChooserParams()
    {
      public Intent createIntent()
      {
        return paramFileChooserParams.createIntent();
      }
      
      public String[] getAcceptTypes()
      {
        return paramFileChooserParams.getAcceptTypes();
      }
      
      public String getFilenameHint()
      {
        return paramFileChooserParams.getFilenameHint();
      }
      
      public int getMode()
      {
        return paramFileChooserParams.getMode();
      }
      
      public CharSequence getTitle()
      {
        return paramFileChooserParams.getTitle();
      }
      
      public boolean isCaptureEnabled()
      {
        return paramFileChooserParams.isCaptureEnabled();
      }
    };
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    return this.mChromeClient.onShowFileChooser(this.mWebView, paramValueCallback, paramFileChooserParams);
  }
  
  public void openFileChooser(final android.webkit.ValueCallback<Uri[]> paramValueCallback, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.mChromeClient.openFileChooser(new ValueCallback()
    {
      public void onReceiveValue(Uri paramAnonymousUri)
      {
        paramValueCallback.onReceiveValue(new Uri[] { paramAnonymousUri });
      }
    }, paramString1, paramString2);
  }
  
  class QuotaUpdaterImpl
    implements WebStorage.QuotaUpdater
  {
    QuotaUpdater mQuotaUpdater;
    
    QuotaUpdaterImpl(QuotaUpdater paramQuotaUpdater)
    {
      this.mQuotaUpdater = paramQuotaUpdater;
    }
    
    public void updateQuota(long paramLong)
    {
      this.mQuotaUpdater.updateQuota(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.SmttWebChromeClient
 * JD-Core Version:    0.7.0.1
 */