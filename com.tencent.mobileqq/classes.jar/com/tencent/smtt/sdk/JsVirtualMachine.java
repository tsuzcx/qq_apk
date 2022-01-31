package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;

public final class JsVirtualMachine
{
  private final Context mContext;
  private final HashSet<WeakReference<X5JsContextFallback>> mJsContexts = new HashSet();
  private final IX5JsVirtualMachine mVirtualMachine;
  
  public JsVirtualMachine(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public JsVirtualMachine(Context paramContext, Looper paramLooper)
  {
    this.mContext = paramContext;
    this.mVirtualMachine = X5JsCore.createVirtualMachine(paramContext, paramLooper);
  }
  
  protected IX5JsContext createJsContext()
  {
    if (this.mVirtualMachine == null)
    {
      X5JsContextFallback localX5JsContextFallback = new X5JsContextFallback(this.mContext);
      this.mJsContexts.add(new WeakReference(localX5JsContextFallback));
      return localX5JsContextFallback;
    }
    return this.mVirtualMachine.createJsContext();
  }
  
  public void destroy()
  {
    if (this.mVirtualMachine != null) {
      this.mVirtualMachine.destroy();
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.mJsContexts.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((X5JsContextFallback)localWeakReference.get()).destroy();
        }
      }
    }
  }
  
  public Looper getLooper()
  {
    if (this.mVirtualMachine != null) {
      return this.mVirtualMachine.getLooper();
    }
    return Looper.myLooper();
  }
  
  public boolean isFallback()
  {
    return this.mVirtualMachine == null;
  }
  
  public void onPause()
  {
    if (this.mVirtualMachine != null) {
      this.mVirtualMachine.onPause();
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.mJsContexts.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((X5JsContextFallback)localWeakReference.get()).onPause();
        }
      }
    }
  }
  
  public void onResume()
  {
    if (this.mVirtualMachine != null) {
      this.mVirtualMachine.onResume();
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.mJsContexts.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((X5JsContextFallback)localWeakReference.get()).onResume();
        }
      }
    }
  }
  
  private static class X5JsContextFallback
    implements IX5JsContext
  {
    private WebView mWebView;
    
    public X5JsContextFallback(Context paramContext)
    {
      this.mWebView = new WebView(paramContext);
      this.mWebView.getSettings().setJavaScriptEnabled(true);
    }
    
    public void addJavascriptInterface(Object paramObject, String paramString)
    {
      if (this.mWebView == null) {
        return;
      }
      this.mWebView.addJavascriptInterface(paramObject, paramString);
      this.mWebView.loadUrl("about:blank");
    }
    
    public void destroy()
    {
      if (this.mWebView == null) {
        return;
      }
      this.mWebView.clearHistory();
      this.mWebView.clearCache(true);
      this.mWebView.loadUrl("about:blank");
      this.mWebView.freeMemory();
      this.mWebView.pauseTimers();
      this.mWebView.destroy();
      this.mWebView = null;
    }
    
    public void evaluateJavascript(String paramString, final android.webkit.ValueCallback<String> paramValueCallback, URL paramURL)
    {
      if (this.mWebView == null) {
        return;
      }
      paramURL = this.mWebView;
      if (paramValueCallback == null) {}
      for (paramValueCallback = null;; paramValueCallback = new ValueCallback()
          {
            public void onReceiveValue(String paramAnonymousString)
            {
              paramValueCallback.onReceiveValue(paramAnonymousString);
            }
          })
      {
        paramURL.evaluateJavascript(paramString, paramValueCallback);
        return;
      }
    }
    
    public IX5JsValue evaluateScript(String paramString, URL paramURL)
    {
      if (this.mWebView == null) {
        return null;
      }
      this.mWebView.evaluateJavascript(paramString, null);
      return null;
    }
    
    public void evaluateScriptAsync(String paramString, final android.webkit.ValueCallback<IX5JsValue> paramValueCallback, URL paramURL)
    {
      if (this.mWebView == null) {
        return;
      }
      paramURL = this.mWebView;
      if (paramValueCallback == null) {}
      for (paramValueCallback = null;; paramValueCallback = new ValueCallback()
          {
            public void onReceiveValue(String paramAnonymousString)
            {
              paramValueCallback.onReceiveValue(null);
            }
          })
      {
        paramURL.evaluateJavascript(paramString, paramValueCallback);
        return;
      }
    }
    
    public void onPause()
    {
      if (this.mWebView == null) {
        return;
      }
      this.mWebView.onPause();
    }
    
    public void onResume()
    {
      if (this.mWebView == null) {
        return;
      }
      this.mWebView.onResume();
    }
    
    public void removeJavascriptInterface(String paramString)
    {
      if (this.mWebView == null) {
        return;
      }
      this.mWebView.removeJavascriptInterface(paramString);
    }
    
    public void setExceptionHandler(android.webkit.ValueCallback<IX5JsError> paramValueCallback) {}
    
    public void setName(String paramString) {}
    
    public void setPerContextData(Object paramObject) {}
    
    public void stealValueFromOtherCtx(String paramString1, IX5JsContext paramIX5JsContext, String paramString2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsVirtualMachine
 * JD-Core Version:    0.7.0.1
 */