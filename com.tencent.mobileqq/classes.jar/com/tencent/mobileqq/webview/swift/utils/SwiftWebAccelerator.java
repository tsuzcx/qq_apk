package com.tencent.mobileqq.webview.swift.utils;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.injector.ISwiftWebAcceleratorInjector;
import com.tencent.mobileqq.webview.swift.injector.SwiftWebAcceleratorInjectorUtil;
import com.tencent.mobileqq.webview.swift.scheduler.SwiftBrowserStateMachineScheduler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SwiftWebAccelerator
{
  public static final Object d = new Object();
  private static SwiftWebAccelerator f;
  private static ISwiftWebAcceleratorInjector g;
  public int a = 0;
  public boolean b = false;
  public int c = 0;
  final SwiftBrowserStateMachineScheduler e = new SwiftBrowserStateMachineScheduler(new SwiftWebAccelerator.1(this));
  
  private SwiftWebAccelerator()
  {
    g = SwiftWebAcceleratorInjectorUtil.a();
  }
  
  public static SwiftWebAccelerator a()
  {
    if (f == null) {
      try
      {
        if (f == null) {
          f = new SwiftWebAccelerator();
        }
      }
      finally {}
    }
    return f;
  }
  
  public static void c()
  {
    long l = System.currentTimeMillis();
    if (WebViewPluginEngine.f == null)
    {
      ThreadManager.postImmediately(new SwiftWebAccelerator.7(l), null, false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_SwiftWebAccelerator", 2, "preCreateWebViewPluginEngine preload success");
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (!this.b)
      {
        Bundle localBundle = paramBundle;
        if (paramBundle == null) {
          localBundle = new Bundle();
        }
        this.c = localBundle.getInt("_accelerator_mode_", 0);
        this.e.b();
        this.e.a(localBundle);
        paramBundle = new StringBuilder();
        paramBundle.append("smartSchedule restart and new mode is ");
        paramBundle.append(this.c);
        paramBundle.append(".");
        QLog.i("WebLog_SwiftWebAccelerator", 1, paramBundle.toString());
        return;
      }
      QLog.i("WebLog_SwiftWebAccelerator", 1, "smartSchedule say no because is in real world now.");
      return;
    }
    new Handler(Looper.getMainLooper()).post(new SwiftWebAccelerator.2(this, paramBundle));
  }
  
  public int b(Bundle paramBundle)
  {
    this.a |= 0x1;
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    boolean bool;
    if (localObject != null)
    {
      localObject = ((AppRuntime)localObject).getAccount();
      BaseApplication localBaseApplication = MobileQQ.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_x5_config_");
      localStringBuilder.append((String)localObject);
      bool = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 4).getBoolean("key_x5_init_sub_thread", true);
    }
    else
    {
      bool = true;
    }
    long l = System.currentTimeMillis();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initX5Environment start! ");
    ((StringBuilder)localObject).append(bool);
    QLog.i("WebLog_SwiftWebAccelerator", 1, ((StringBuilder)localObject).toString());
    if (bool)
    {
      ThreadManager.postImmediately(new SwiftWebAccelerator.3(this, l, paramBundle), null, false);
      return -1;
    }
    SwiftWebAccelerator.TbsAccelerator.b();
    SwiftBrowserStatistics.af = System.currentTimeMillis() - l;
    paramBundle = new StringBuilder();
    paramBundle.append("initX5Environment on main thread, cost ");
    paramBundle.append(SwiftBrowserStatistics.af);
    paramBundle.append("ms.");
    QLog.i("WebLog_SwiftWebAccelerator", 1, paramBundle.toString());
    return 1;
  }
  
  public void b()
  {
    if (!this.b)
    {
      QLog.i("WebLog_SwiftWebAccelerator", 1, "switch 2 RealWorld and cancel state machine schedule.");
      this.b = true;
      this.e.b();
    }
  }
  
  public int c(Bundle paramBundle)
  {
    this.a |= 0x2;
    long l = System.currentTimeMillis();
    SwiftReuseTouchWebView.b(MobileQQ.getContext()).a(true);
    SwiftBrowserStatistics.ag = System.currentTimeMillis() - l;
    paramBundle = new StringBuilder();
    paramBundle.append("doMainStep_CreateWebView:create webview cost ");
    paramBundle.append(SwiftBrowserStatistics.ag);
    paramBundle.append("ms.");
    QLog.i("WebLog_SwiftWebAccelerator", 1, paramBundle.toString());
    return 1;
  }
  
  public int d(Bundle paramBundle)
  {
    this.a |= 0x4;
    long l = System.currentTimeMillis();
    Object localObject2 = (String)WebAccelerateHelper.getInstance().getWebViewFeatureConfigs().get("preloadUrl");
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      if (!((String)localObject2).startsWith("http:"))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).startsWith("https:")) {}
      }
      else
      {
        localObject1 = localObject2;
        if (((String)localObject2).startsWith("http:"))
        {
          localObject2 = ((String)localObject2).replace("http:", "https:");
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("WebLog_SwiftWebAccelerator", 2, "WarnUpWebView replace https");
            localObject1 = localObject2;
          }
        }
        localObject2 = SwiftReuseTouchWebView.b(MobileQQ.getContext());
        Intent localIntent = new Intent();
        localIntent.putExtra("ignoreLoginWeb", true);
        ((SwiftReuseTouchWebView)localObject2).setIntent(localIntent);
        ((SwiftReuseTouchWebView)localObject2).loadUrlOriginal((String)localObject1);
        new Handler(Looper.getMainLooper()).postDelayed(new SwiftWebAccelerator.4(this, (SwiftReuseTouchWebView)localObject2), 300L);
      }
    }
    SwiftBrowserStatistics.ah = System.currentTimeMillis() - l;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("tendocpreload doMainStep_WarnUpWebView:load ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(", cost ");
    ((StringBuilder)localObject2).append(SwiftBrowserStatistics.ah);
    ((StringBuilder)localObject2).append("ms.");
    QLog.i("WebLog_SwiftWebAccelerator", 1, ((StringBuilder)localObject2).toString());
    localObject1 = g;
    if (localObject1 != null) {
      ((ISwiftWebAcceleratorInjector)localObject1).a(paramBundle);
    }
    return 1;
  }
  
  public int e(Bundle paramBundle)
  {
    this.a |= 0x10;
    long l = System.currentTimeMillis();
    Object localObject2 = (String)WebAccelerateHelper.getInstance().getWebViewFeatureConfigs().get("preloadUrl");
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      if (!((String)localObject2).startsWith("http:"))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).startsWith("https:")) {}
      }
      else
      {
        paramBundle = (Bundle)localObject2;
        if (((String)localObject2).startsWith("http:"))
        {
          localObject1 = ((String)localObject2).replace("http:", "https:");
          paramBundle = (Bundle)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("WebLog_SwiftWebAccelerator", 2, "SetCookie replace https");
            paramBundle = (Bundle)localObject1;
          }
        }
        localObject2 = SwiftBrowserCookieMonster.c(paramBundle);
        localObject1 = paramBundle;
        if (localObject2 != null)
        {
          ((SwiftBrowserCookieMonster)localObject2).a(paramBundle, null, null, null);
          localObject1 = paramBundle;
        }
      }
    }
    paramBundle = new StringBuilder();
    paramBundle.append("doMainStep_SetCookie:pre set cookie(");
    paramBundle.append((String)localObject1);
    paramBundle.append("), cost ");
    paramBundle.append(System.currentTimeMillis() - l);
    paramBundle.append("ms.");
    QLog.i("WebLog_SwiftWebAccelerator", 1, paramBundle.toString());
    return 1;
  }
  
  public int f(Bundle paramBundle)
  {
    this.a |= 0x8;
    long l = System.currentTimeMillis();
    if (WebAccelerateHelper.preloadBrowserView == null)
    {
      WebAccelerateHelper.preInflaterBrowserView();
      SwiftBrowserStatistics.ai = System.currentTimeMillis() - l;
      paramBundle = new StringBuilder();
      paramBundle.append("doMainStep_CreateBrowserView, cost = ");
      paramBundle.append(SwiftBrowserStatistics.ai);
      paramBundle.append("ms.");
      QLog.i("WebLog_SwiftWebAccelerator", 1, paramBundle.toString());
      return 1;
    }
    return 0;
  }
  
  public void g(Bundle paramBundle)
  {
    this.a |= 0x400;
    ThreadManager.postImmediately(new SwiftWebAccelerator.5(this, System.currentTimeMillis(), paramBundle), null, false);
  }
  
  public void h(Bundle paramBundle)
  {
    this.a |= 0x800;
    ThreadManager.postImmediately(new SwiftWebAccelerator.6(this, System.currentTimeMillis(), paramBundle), null, false);
  }
  
  public void i(Bundle paramBundle)
  {
    this.a |= 0x1000;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator
 * JD-Core Version:    0.7.0.1
 */