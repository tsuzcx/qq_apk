package com.tencent.smtt.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import java.net.URL;

class JsVirtualMachine$X5JsContextFallback
  implements IX5JsContext
{
  private WebView mWebView;
  
  public JsVirtualMachine$X5JsContextFallback(Context paramContext)
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
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback, URL paramURL)
  {
    if (this.mWebView == null) {
      return;
    }
    paramURL = this.mWebView;
    if (paramValueCallback == null) {}
    for (paramValueCallback = null;; paramValueCallback = new JsVirtualMachine.X5JsContextFallback.1(this, paramValueCallback))
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
  
  public void evaluateScriptAsync(String paramString, ValueCallback<IX5JsValue> paramValueCallback, URL paramURL)
  {
    if (this.mWebView == null) {
      return;
    }
    paramURL = this.mWebView;
    if (paramValueCallback == null) {}
    for (paramValueCallback = null;; paramValueCallback = new JsVirtualMachine.X5JsContextFallback.2(this, paramValueCallback))
    {
      paramURL.evaluateJavascript(paramString, paramValueCallback);
      return;
    }
  }
  
  public byte[] getNativeBuffer(int paramInt)
  {
    return null;
  }
  
  public int getNativeBufferId()
  {
    return -1;
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
  
  public void setExceptionHandler(ValueCallback<IX5JsError> paramValueCallback) {}
  
  public void setName(String paramString) {}
  
  public int setNativeBuffer(int paramInt, byte[] paramArrayOfByte)
  {
    return -1;
  }
  
  public void setPerContextData(Object paramObject) {}
  
  public void stealValueFromOtherCtx(String paramString1, IX5JsContext paramIX5JsContext, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsVirtualMachine.X5JsContextFallback
 * JD-Core Version:    0.7.0.1
 */