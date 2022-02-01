package com.tencent.xweb.sys;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebViewDatabase;
import com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtWebView;
import com.tencent.xweb.JsRuntime.JsRuntimeType;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.ad;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;
import com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal;
import com.tencent.xweb.internal.IJsRuntime;
import com.tencent.xweb.internal.IWebStorage;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.internal.l.a;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;

public class SysWebFactory
  implements l.a
{
  private static final String TAG = "XWEB.SysWebFactory";
  static SysWebFactory sInstance;
  
  public static SysWebFactory getInstance()
  {
    if (sInstance == null)
    {
      ad.b();
      sInstance = new SysWebFactory();
    }
    return sInstance;
  }
  
  private static <T> T runOnUiThreadBlocking(Callable<T> paramCallable)
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {
      return paramCallable.call();
    }
    paramCallable = new FutureTask(paramCallable);
    new Handler(Looper.getMainLooper()).post(paramCallable);
    return paramCallable.get();
  }
  
  public void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    try
    {
      localObject = new DtWebView(paramContext);
      if (Build.VERSION.SDK_INT >= 11)
      {
        ((android.webkit.WebView)localObject).removeJavascriptInterface("searchBoxJavaBridge_");
        ((android.webkit.WebView)localObject).removeJavascriptInterface("accessibility");
        ((android.webkit.WebView)localObject).removeJavascriptInterface("accessibilityTraversal");
      }
      ((android.webkit.WebView)localObject).clearCache(true);
      if (paramBoolean)
      {
        CookieSyncManager.createInstance(paramContext);
        CookieManager.getInstance().removeAllCookie();
      }
      WebViewDatabase.getInstance(paramContext).clearUsernamePassword();
      WebViewDatabase.getInstance(paramContext).clearHttpAuthUsernamePassword();
      WebViewDatabase.getInstance(paramContext).clearFormData();
      WebStorage.getInstance().deleteAllData();
      WebIconDatabase.getInstance().removeAllIcons();
      return;
    }
    catch (Exception paramContext)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearAllWebViewCache failed ");
      ((StringBuilder)localObject).append(paramContext.getMessage());
      Log.e("SysWebFactory", ((StringBuilder)localObject).toString());
    }
  }
  
  public IWebView createWebView(com.tencent.xweb.WebView paramWebView)
  {
    try
    {
      paramWebView = new e(paramWebView);
      return paramWebView;
    }
    catch (Throwable paramWebView)
    {
      String str = paramWebView.getMessage();
      if ((str != null) && (str.contains("Calling View methods on another thread than the UI thread.")))
      {
        Log.e("XWEB.SysWebFactory", "setNeedEnforceMainLooper=true", paramWebView);
        SysWebFactory.a.a(true);
      }
      throw paramWebView;
    }
  }
  
  public IWebStorage createWebviewStorage()
  {
    return null;
  }
  
  public Object excute(String paramString, Object[] paramArrayOfObject)
  {
    if (paramString != null)
    {
      if (paramString.isEmpty()) {
        return null;
      }
      if (paramString.equals("STR_CMD_GET_DEBUG_VIEW")) {
        return null;
      }
      if (!paramString.equals("STR_CMD_GET_UPDATER")) {}
    }
    return null;
  }
  
  public CookieInternal.ICookieManagerInternal getCookieManager()
  {
    if (SysWebFactory.a.c()) {
      return new a();
    }
    try
    {
      CookieInternal.ICookieManagerInternal localICookieManagerInternal = (CookieInternal.ICookieManagerInternal)runOnUiThreadBlocking(new SysWebFactory.1(this));
      return localICookieManagerInternal;
    }
    catch (Exception localException)
    {
      Log.e("XWEB.SysWebFactory", "getCookieManager", localException);
    }
    return new a();
  }
  
  public CookieInternal.ICookieSyncManagerInternal getCookieSyncManager()
  {
    if (SysWebFactory.a.c()) {
      return new b();
    }
    try
    {
      CookieInternal.ICookieSyncManagerInternal localICookieSyncManagerInternal = (CookieInternal.ICookieSyncManagerInternal)runOnUiThreadBlocking(new SysWebFactory.2(this));
      return localICookieSyncManagerInternal;
    }
    catch (Exception localException)
    {
      Log.e("XWEB.SysWebFactory", "getCookieSyncManager", localException);
    }
    return new b();
  }
  
  public IJsRuntime getJsCore(JsRuntime.JsRuntimeType paramJsRuntimeType, Context paramContext)
  {
    return null;
  }
  
  public IWebViewDatabase getWebViewDatabase()
  {
    return new f();
  }
  
  public boolean hasInited()
  {
    return SysWebFactory.a.a();
  }
  
  public boolean hasInitedCallback()
  {
    return SysWebFactory.a.b();
  }
  
  public void initCallback(WebViewExtensionListener paramWebViewExtensionListener)
  {
    SysWebFactory.a.a(paramWebViewExtensionListener);
  }
  
  public void initEnviroment(Context paramContext) {}
  
  public void initInterface() {}
  
  public boolean initWebviewCore(Context paramContext, WebView.PreInitCallback paramPreInitCallback)
  {
    ad.b();
    SysWebFactory.a.a(paramContext, paramPreInitCallback);
    return true;
  }
  
  public boolean isCoreReady()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.sys.SysWebFactory
 * JD-Core Version:    0.7.0.1
 */