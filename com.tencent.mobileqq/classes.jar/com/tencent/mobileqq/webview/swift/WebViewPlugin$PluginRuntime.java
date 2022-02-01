package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebViewProviderInterface;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class WebViewPlugin$PluginRuntime
{
  WeakReference<CustomWebView> a;
  WeakReference<AppRuntime> b;
  WeakReference<Activity> c;
  WeakReference<WebUiBaseInterface> d = null;
  WeakReference<WebViewProvider> e = null;
  
  public WebViewPlugin$PluginRuntime(Activity paramActivity, AppRuntime paramAppRuntime)
  {
    this.c = new WeakReference(paramActivity);
    this.b = new WeakReference(paramAppRuntime);
    if ((paramActivity instanceof WebUiBaseInterface)) {
      this.d = new WeakReference((WebUiBaseInterface)paramActivity);
    }
  }
  
  public Activity a()
  {
    return (Activity)this.c.get();
  }
  
  public CustomWebView a()
  {
    WeakReference localWeakReference = this.a;
    if (localWeakReference != null) {
      return (CustomWebView)localWeakReference.get();
    }
    return null;
  }
  
  @Deprecated
  public AppInterface a()
  {
    return (AppInterface)this.b.get();
  }
  
  public WebUiBaseInterface a(Activity paramActivity)
  {
    paramActivity = this.d;
    if (paramActivity != null) {
      return (WebUiBaseInterface)paramActivity.get();
    }
    return null;
  }
  
  public WebViewProvider a()
  {
    WeakReference localWeakReference = this.e;
    if (localWeakReference != null) {
      return (WebViewProvider)localWeakReference.get();
    }
    return null;
  }
  
  public WebUiUtils.WebViewProviderInterface a()
  {
    WeakReference localWeakReference = this.d;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && ((this.d.get() instanceof WebUiUtils.WebViewProviderInterface))) {
      return (WebUiUtils.WebViewProviderInterface)this.d.get();
    }
    return null;
  }
  
  public AppRuntime a()
  {
    return (AppRuntime)this.b.get();
  }
  
  public void a(WebUiBaseInterface paramWebUiBaseInterface)
  {
    if (paramWebUiBaseInterface != null) {
      this.d = new WeakReference(paramWebUiBaseInterface);
    }
  }
  
  public void a(WebViewProvider paramWebViewProvider)
  {
    if (paramWebViewProvider != null)
    {
      this.e = new WeakReference(paramWebViewProvider);
      this.d = new WeakReference(paramWebViewProvider);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime
 * JD-Core Version:    0.7.0.1
 */