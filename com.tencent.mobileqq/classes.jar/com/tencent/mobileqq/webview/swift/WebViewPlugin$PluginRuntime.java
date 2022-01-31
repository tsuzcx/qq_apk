package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import java.lang.ref.WeakReference;

public class WebViewPlugin$PluginRuntime
{
  WeakReference a;
  WeakReference b;
  WeakReference c;
  WeakReference d = null;
  WeakReference e = null;
  
  public WebViewPlugin$PluginRuntime(Activity paramActivity, AppInterface paramAppInterface)
  {
    this.c = new WeakReference(paramActivity);
    this.b = new WeakReference(paramAppInterface);
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
    if (this.a != null) {
      return (CustomWebView)this.a.get();
    }
    return null;
  }
  
  public AppInterface a()
  {
    return (AppInterface)this.b.get();
  }
  
  public WebUiBaseInterface a(Activity paramActivity)
  {
    if (this.d != null) {
      return (WebUiBaseInterface)this.d.get();
    }
    return null;
  }
  
  public WebViewFragment a()
  {
    if (this.e != null) {
      return (WebViewFragment)this.e.get();
    }
    return null;
  }
  
  public void a(WebViewFragment paramWebViewFragment)
  {
    if (paramWebViewFragment != null)
    {
      this.e = new WeakReference(paramWebViewFragment);
      this.d = new WeakReference(paramWebViewFragment);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime
 * JD-Core Version:    0.7.0.1
 */