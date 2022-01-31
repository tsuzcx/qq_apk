package com.tencent.mobileqq.microapp.appbrand.utils;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.microapp.apkg.f;
import com.tencent.mobileqq.microapp.app.b;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.microapp.appbrand.page.ProgressWebView;
import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.concurrent.ConcurrentHashMap;

public class p
{
  private static final String d = p.class.getSimpleName();
  private static volatile p h;
  public ServiceWebview a;
  public PageWebview b;
  public ProgressWebView c;
  private ConcurrentHashMap e = new ConcurrentHashMap();
  private ConcurrentHashMap f = new ConcurrentHashMap();
  private ConcurrentHashMap g = new ConcurrentHashMap();
  private MutableContextWrapper i;
  private int j;
  
  public static p a()
  {
    if (h == null) {}
    try
    {
      if (h == null) {
        h = new p();
      }
      return h;
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
    ProgressWebView localProgressWebView = (ProgressWebView)this.g.remove(paramString);
    if (localProgressWebView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(d, 2, "create new PageWebview when getPageWebview");
      }
      paramString = new ProgressWebView(this.i);
    }
    for (;;)
    {
      paramString.htmlId = paramInt;
      return paramString;
      paramString = localProgressWebView;
      if (QLog.isColorLevel())
      {
        QLog.d(d, 2, "get cache PageWebview when getPageWebview");
        paramString = localProgressWebView;
      }
    }
  }
  
  public ServiceWebview a(String paramString)
  {
    ServiceWebview localServiceWebview = (ServiceWebview)this.f.remove(paramString);
    paramString = localServiceWebview;
    if (localServiceWebview == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(d, 2, "create new PageWebview when getServiceWebview");
      }
      paramString = new ServiceWebview(this.i);
    }
    return paramString;
  }
  
  public void a(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "---initFistWebview----");
    }
    this.i = new MutableContextWrapper(paramActivity);
    this.a = new ServiceWebview(this.i);
    this.b = new PageWebview(this.i);
    this.c = new ProgressWebView(this.i);
  }
  
  public void a(Activity paramActivity, f paramf)
  {
    paramActivity = new MutableContextWrapper(paramActivity);
    PageWebview localPageWebview = new PageWebview(paramActivity);
    localPageWebview.apkgInfo = paramf;
    localPageWebview.loadHtml();
    this.e.put(paramf.d, localPageWebview);
    if (this.g.isEmpty())
    {
      paramActivity = new ProgressWebView(paramActivity);
      this.g.put(paramf.d, paramActivity);
    }
  }
  
  public void a(Context paramContext, f paramf)
  {
    if (this.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(d, 2, "create new ServiceWebview when initWebviewEnv");
      }
      this.a = new ServiceWebview(paramContext);
      this.a.apkgInfo = paramf;
      this.a.initJSGlobalConfig();
      this.f.put(paramf.d, this.a);
      this.j = 0;
      if (this.b != null) {
        break label184;
      }
      if (QLog.isColorLevel()) {
        QLog.d(d, 2, "create new PageWebview when initWebviewEnv");
      }
      this.b = new PageWebview(this.i);
    }
    for (;;)
    {
      this.b.apkgInfo = paramf;
      this.a.pageWebviewId = this.j;
      this.b.loadHtml();
      this.e.put(paramf.d, this.b);
      this.g.put(paramf.d, this.c);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(d, 2, "get cache ServiceWebview when initWebviewEnv");
      break;
      label184:
      if (QLog.isColorLevel()) {
        QLog.d(d, 2, "get cache PageWebview when initWebviewEnv");
      }
    }
  }
  
  public void a(PageWebview paramPageWebview, Context paramContext)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(d, 2, "----recyclePageWebview----");
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
        if ((this.e == null) || (!this.e.contains(paramPageWebview))) {
          continue;
        }
        this.e.remove(paramPageWebview);
        return;
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(d, 1, "destroy error:" + paramContext.getMessage());
          }
        }
      }
    }
  }
  
  public void a(ProgressWebView paramProgressWebView, Context paramContext)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(d, 2, "----recyclePageWebview----");
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
        if ((this.g == null) || (!this.g.contains(paramProgressWebView))) {
          continue;
        }
        this.g.remove(paramProgressWebView);
        return;
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(d, 1, "destroy error:" + paramContext.getMessage());
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
      if ((this.f != null) && (this.f.contains(paramServiceWebview))) {
        this.f.remove(paramServiceWebview);
      }
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(d, 1, "destroy error:" + paramContext.getMessage());
        }
      }
    }
  }
  
  public PageWebview b(String paramString)
  {
    PageWebview localPageWebview = (PageWebview)this.e.remove(paramString);
    if (localPageWebview == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(d, 2, "create new PageWebview when getPageWebview");
      }
      paramString = new PageWebview(this.i);
      paramString.loadHtml();
    }
    for (;;)
    {
      int k = this.j + 1;
      this.j = k;
      paramString.pageWebviewId = k;
      return paramString;
      paramString = localPageWebview;
      if (QLog.isColorLevel())
      {
        QLog.d(d, 2, "get cache PageWebview when getPageWebview");
        paramString = localPageWebview;
      }
    }
  }
  
  public void b()
  {
    try
    {
      if (this.e != null)
      {
        this.e.clear();
        this.e = null;
      }
      if (this.f != null)
      {
        this.f.clear();
        this.f = null;
      }
      this.j = 0;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.utils.p
 * JD-Core Version:    0.7.0.1
 */