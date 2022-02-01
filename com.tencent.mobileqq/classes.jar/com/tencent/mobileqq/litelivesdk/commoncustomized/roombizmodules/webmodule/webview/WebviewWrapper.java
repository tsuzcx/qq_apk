package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.LiteLiveJsProvider;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.App;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.CloseGuard;
import cooperation.qzone.webviewwrapper.IWebviewListener;
import cooperation.qzone.webviewwrapper.IWebviewWrapper;

public class WebviewWrapper
  implements IWebviewWrapper
{
  protected Context a;
  protected TouchWebView b;
  protected LiteLiveSdkWebViewBaseBuilder c;
  protected final CloseGuard d = CloseGuard.get();
  private boolean e;
  private JsBizAdapter f;
  private LiteLiveJsProvider g;
  private LiveBusinessJsInterface h;
  private View i;
  private App j;
  
  public WebviewWrapper(Context paramContext, JsBizAdapter paramJsBizAdapter, LiteLiveJsProvider paramLiteLiveJsProvider, LiveBusinessJsInterface paramLiveBusinessJsInterface, View paramView)
  {
    this(paramContext, false, paramJsBizAdapter, paramLiteLiveJsProvider, paramLiveBusinessJsInterface, paramView);
  }
  
  public WebviewWrapper(Context paramContext, boolean paramBoolean, JsBizAdapter paramJsBizAdapter, LiteLiveJsProvider paramLiteLiveJsProvider, LiveBusinessJsInterface paramLiveBusinessJsInterface, View paramView)
  {
    this.e = paramBoolean;
    this.a = paramContext;
    this.f = paramJsBizAdapter;
    this.g = paramLiteLiveJsProvider;
    this.h = paramLiveBusinessJsInterface;
    this.i = paramView;
    preInit();
  }
  
  public LiteLiveJsProvider a()
  {
    return this.g;
  }
  
  public void a(Context paramContext, JsBizAdapter paramJsBizAdapter)
  {
    LiteLiveSdkWebViewBaseBuilder localLiteLiveSdkWebViewBaseBuilder = this.c;
    if (localLiteLiveSdkWebViewBaseBuilder != null) {
      localLiteLiveSdkWebViewBaseBuilder.a(paramContext, paramJsBizAdapter);
    }
  }
  
  public void a(App paramApp)
  {
    this.j = paramApp;
  }
  
  public App b()
  {
    return this.j;
  }
  
  public void c()
  {
    QLog.i("WebviewWrapper", 1, "ilivetime WebViewDirector start ");
    new WebViewDirector(this.c).a(null, LiteLiveSdkWebViewPluginManager.a().b(), null);
    QLog.i("WebviewWrapper", 1, "ilivetime WebViewDirector end ");
  }
  
  public void callJs(String paramString)
  {
    LiteLiveSdkWebViewBaseBuilder localLiteLiveSdkWebViewBaseBuilder = this.c;
    if (localLiteLiveSdkWebViewBaseBuilder != null) {
      localLiteLiveSdkWebViewBaseBuilder.a(paramString);
    }
  }
  
  protected void finalize()
  {
    try
    {
      this.d.warnIfOpen();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public WebView getWebview()
  {
    return this.b;
  }
  
  public void onDestroy()
  {
    this.d.close();
    onDetach();
    LiteLiveSdkWebViewBaseBuilder localLiteLiveSdkWebViewBaseBuilder = this.c;
    if (localLiteLiveSdkWebViewBaseBuilder != null) {
      localLiteLiveSdkWebViewBaseBuilder.f();
    }
    this.b = null;
    this.a = null;
  }
  
  public void onDetach()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((TouchWebView)localObject).getParent();
      if ((localObject != null) && ((localObject instanceof ViewGroup))) {
        ((ViewGroup)localObject).removeAllViewsInLayout();
      }
    }
  }
  
  public void onInit(Activity paramActivity, Intent paramIntent, String paramString, IWebviewListener paramIWebviewListener)
  {
    this.d.open("onDestroy");
    this.c = new LiteLiveSdkWebViewBaseBuilder(this.a, paramActivity, paramIntent, LiteLiveSdkWebViewPluginManager.a().b(), false, this.f, this.g, this.h, this.i);
    this.b.setVisibility(4);
    this.c.a(this.b);
    this.c.a(new WebviewWrapper.1(this, paramIWebviewListener));
  }
  
  public void onPause()
  {
    LiteLiveSdkWebViewBaseBuilder localLiteLiveSdkWebViewBaseBuilder = this.c;
    if (localLiteLiveSdkWebViewBaseBuilder != null) {
      localLiteLiveSdkWebViewBaseBuilder.e();
    }
  }
  
  public void onResume()
  {
    LiteLiveSdkWebViewBaseBuilder localLiteLiveSdkWebViewBaseBuilder = this.c;
    if (localLiteLiveSdkWebViewBaseBuilder != null) {
      localLiteLiveSdkWebViewBaseBuilder.d();
    }
  }
  
  public void onWebViewReady(Intent paramIntent, boolean paramBoolean)
  {
    String str2;
    String str1;
    int k;
    if (paramIntent != null)
    {
      if (this.b == null) {
        return;
      }
      str2 = paramIntent.getStringExtra("wns_proxy_http_data");
      str1 = paramIntent.getStringExtra("url");
      boolean bool1 = TextUtils.isEmpty(str2);
      if ((bool1) && (TextUtils.isEmpty(str1))) {
        return;
      }
      if ((!paramBoolean) && (bool1)) {
        return;
      }
      boolean bool2 = paramIntent.getBooleanExtra("key_wns_cache_hit", false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("LiteLiveSdk load Url: ");
        ((StringBuilder)localObject).append(str1);
        ((StringBuilder)localObject).append(", wns proxy html hit caches:");
        ((StringBuilder)localObject).append(bool2);
        QLog.i("WebviewWrapper", 2, ((StringBuilder)localObject).toString());
      }
      if (bool2)
      {
        QLog.i("WebviewWrapper", 2, "bHitCache is true");
        return;
      }
      if ((paramBoolean) && (bool1))
      {
        this.b.loadUrl(str1);
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("LiteLiveSdk load Url: ");
          paramIntent.append(str1);
          paramIntent.append(", wns proxy html return failed!");
          QLog.i("WebviewWrapper", 2, paramIntent.toString());
        }
        return;
      }
      Object localObject = this.b.getUrl();
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!"about:blank".equals(localObject))) {
        k = 0;
      } else {
        k = 1;
      }
      if (k != 0) {}
    }
    try
    {
      if (!paramIntent.getBooleanExtra("need_force_refresh", false)) {
        break label289;
      }
      QLog.i("WebviewWrapper", 2, "isCurrentUrlEmpty loadDataWithBaseURL");
      WebSoPlugin.a(this.b, str1, str2);
    }
    catch (Exception paramIntent)
    {
      label280:
      break label280;
    }
    QLog.e("WebviewWrapper", 1, "onwebview ready exception", paramIntent);
    label289:
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("load Url: ");
      paramIntent.append(str1);
      paramIntent.append(", htmlBody(true), currentUrl(");
      paramIntent.append(k ^ 0x1);
      paramIntent.append(")");
      QLog.i("WebviewWrapper", 2, paramIntent.toString());
    }
  }
  
  public void preInit()
  {
    if (this.b == null)
    {
      long l = System.currentTimeMillis();
      if (this.e) {
        QbSdk.forceSysWebView();
      }
      this.b = WebViewPool.a.b();
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject = this.b.getSettings();
        if (localObject != null)
        {
          ((WebSettings)localObject).setUserAgentString("");
          ((WebSettings)localObject).setMixedContentMode(0);
          ((WebSettings)localObject).setMixedContentMode(0);
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("new TouchWebView cost ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      QLog.i("WebviewWrapper", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void setOnWebviewTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    TouchWebView localTouchWebView = this.b;
    if (localTouchWebView != null) {
      localTouchWebView.setOnTouchListener(paramOnTouchListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebviewWrapper
 * JD-Core Version:    0.7.0.1
 */