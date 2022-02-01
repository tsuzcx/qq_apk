package com.tencent.mobileqq.microapp.appbrand.b;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.app.b;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.microapp.appbrand.page.ProgressWebView;
import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.concurrent.ConcurrentHashMap;

public class h
{
  private static final String a = h.class.getSimpleName();
  private static volatile h e;
  private ConcurrentHashMap b = new ConcurrentHashMap();
  private ConcurrentHashMap c = new ConcurrentHashMap();
  private ConcurrentHashMap d = new ConcurrentHashMap();
  private MutableContextWrapper f;
  private int g;
  
  public static h a()
  {
    if (e == null) {}
    try
    {
      if (e == null) {
        e = new h();
      }
      return e;
    }
    finally {}
  }
  
  private void a(WebView paramWebView)
  {
    paramWebView.stopLoading();
    paramWebView.loadUrl("about:blank");
    paramWebView.clearHistory();
    paramWebView.clearView();
    paramWebView.destroy();
    ((MutableContextWrapper)paramWebView.getContext()).setBaseContext(BaseApplicationImpl.context);
  }
  
  public ProgressWebView a(String paramString, int paramInt)
  {
    ProgressWebView localProgressWebView = (ProgressWebView)this.d.remove(paramString);
    if (localProgressWebView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "create new PageWebview when getPageWebview");
      }
      paramString = new ProgressWebView(this.f);
    }
    for (;;)
    {
      paramString.htmlId = paramInt;
      return paramString;
      paramString = localProgressWebView;
      if (QLog.isColorLevel())
      {
        QLog.d(a, 2, "get cache PageWebview when getPageWebview");
        paramString = localProgressWebView;
      }
    }
  }
  
  public ServiceWebview a(String paramString)
  {
    ServiceWebview localServiceWebview = (ServiceWebview)this.c.remove(paramString);
    paramString = localServiceWebview;
    if (localServiceWebview == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "create new PageWebview when getServiceWebview");
      }
      paramString = new ServiceWebview(this.f);
    }
    return paramString;
  }
  
  public void a(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "---initFistWebview----");
    }
    this.f = new MutableContextWrapper(paramActivity);
    new ServiceWebview(this.f);
    new PageWebview(this.f);
    new ProgressWebView(this.f);
  }
  
  public void a(Activity paramActivity, c paramc)
  {
    paramActivity = new MutableContextWrapper(paramActivity);
    PageWebview localPageWebview = new PageWebview(paramActivity);
    localPageWebview.apkgInfo$5475ea27 = paramc;
    localPageWebview.loadHtml();
    this.b.put(paramc.d, localPageWebview);
    if (this.d.isEmpty())
    {
      paramActivity = new ProgressWebView(paramActivity);
      this.d.put(paramc.d, paramActivity);
    }
  }
  
  public void a(PageWebview paramPageWebview, Context paramContext)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(a, 2, "----recyclePageWebview----");
    }
    b.a().a("hideKeyboard");
    if (paramPageWebview == null) {}
    for (;;)
    {
      return;
      if (!"about:blank".equals(paramPageWebview.getUrl())) {}
      try
      {
        paramPageWebview.clearUp();
        a(paramPageWebview);
        if ((this.b == null) || (!this.b.contains(paramPageWebview))) {
          continue;
        }
        this.b.remove(paramPageWebview);
        return;
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(a, 1, "destroy error:" + paramContext.getMessage());
          }
        }
      }
    }
  }
  
  public void a(ProgressWebView paramProgressWebView, Context paramContext)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(a, 2, "----recyclePageWebview----");
    }
    b.a().a("hideKeyboard");
    if (paramProgressWebView == null) {}
    for (;;)
    {
      return;
      if (!"about:blank".equals(paramProgressWebView.getUrl())) {}
      try
      {
        a(paramProgressWebView);
        if ((this.d == null) || (!this.d.contains(paramProgressWebView))) {
          continue;
        }
        this.d.remove(paramProgressWebView);
        return;
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(a, 1, "destroy error:" + paramContext.getMessage());
          }
        }
      }
    }
  }
  
  public void a(ServiceWebview paramServiceWebview, Context paramContext)
  {
    if (!"about:blank".equals(paramServiceWebview.getUrl())) {}
    try
    {
      paramServiceWebview.clearUp();
      a(paramServiceWebview);
      if ((this.c != null) && (this.c.contains(paramServiceWebview))) {
        this.c.remove(paramServiceWebview);
      }
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(a, 1, "destroy error:" + paramContext.getMessage());
        }
      }
    }
  }
  
  public PageWebview b(String paramString)
  {
    PageWebview localPageWebview = (PageWebview)this.b.remove(paramString);
    if (localPageWebview == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "create new PageWebview when getPageWebview");
      }
      paramString = new PageWebview(this.f);
      paramString.loadHtml();
    }
    for (;;)
    {
      int i = this.g + 1;
      this.g = i;
      paramString.pageWebviewId = i;
      return paramString;
      paramString = localPageWebview;
      if (QLog.isColorLevel())
      {
        QLog.d(a, 2, "get cache PageWebview when getPageWebview");
        paramString = localPageWebview;
      }
    }
  }
  
  public void b()
  {
    try
    {
      if (this.b != null)
      {
        this.b.clear();
        this.b = null;
      }
      if (this.c != null)
      {
        this.c.clear();
        this.c = null;
      }
      this.g = 0;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.b.h
 * JD-Core Version:    0.7.0.1
 */