package com.tencent.xweb.sys;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import androidx.annotation.UiThread;
import com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtWebView;
import com.tencent.xweb.WebView.PreInitCallback;
import java.util.concurrent.atomic.AtomicBoolean;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

class SysWebFactory$a
{
  private static boolean a = false;
  private static boolean b = false;
  private static Boolean c;
  private static final AtomicBoolean d = new AtomicBoolean(false);
  
  public static void a(Context paramContext, WebView.PreInitCallback paramPreInitCallback)
  {
    try
    {
      boolean bool = a;
      if (bool) {
        return;
      }
      if (!e())
      {
        a = true;
        if (paramPreInitCallback != null) {
          paramPreInitCallback.a();
        }
        return;
      }
      if (d.get())
      {
        if (paramPreInitCallback != null) {
          paramPreInitCallback.a();
        }
      }
      else
      {
        paramContext = new SysWebFactory.a.1(paramPreInitCallback);
        if (Looper.getMainLooper() == Looper.myLooper()) {
          paramContext.run();
        } else {
          new Handler(Looper.getMainLooper()).post(paramContext);
        }
      }
      return;
    }
    finally {}
  }
  
  public static void a(WebViewExtensionListener paramWebViewExtensionListener)
  {
    b = true;
  }
  
  public static void a(boolean paramBoolean)
  {
    XWalkEnvironment.getMMKVSharedPreferences("SysWebFactory.preIniter").edit().putBoolean("isEnforceMainLooper", paramBoolean).apply();
  }
  
  public static boolean a()
  {
    return a;
  }
  
  public static boolean b()
  {
    return b;
  }
  
  public static boolean c()
  {
    if (!e()) {
      return true;
    }
    return d.get();
  }
  
  private static boolean e()
  {
    if (c == null) {
      c = Boolean.valueOf(XWalkEnvironment.getMMKVSharedPreferences("SysWebFactory.preIniter").getBoolean("isEnforceMainLooper", false));
    }
    return c.booleanValue();
  }
  
  @UiThread
  private static void f()
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (!d.getAndSet(true))
      {
        long l = SystemClock.elapsedRealtime();
        CookieManager.getInstance();
        CookieSyncManager.createInstance(XWalkEnvironment.getApplicationContext());
        new DtWebView(XWalkEnvironment.getApplicationContext()).destroy();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ensureSystemWebViewGlobalLooper cost=");
        localStringBuilder.append(SystemClock.elapsedRealtime() - l);
        localStringBuilder.append("ms");
        Log.i("SysWebFactory.preIniter", localStringBuilder.toString());
      }
      return;
    }
    throw new IllegalStateException("Calling WebView methods on another thread than the UI thread.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.sys.SysWebFactory.a
 * JD-Core Version:    0.7.0.1
 */