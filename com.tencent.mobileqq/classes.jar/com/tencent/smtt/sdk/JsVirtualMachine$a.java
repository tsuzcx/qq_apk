package com.tencent.smtt.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import java.net.URL;

class JsVirtualMachine$a
  implements IX5JsContext
{
  private WebView a;
  
  public JsVirtualMachine$a(Context paramContext)
  {
    this.a = new WebView(paramContext);
    this.a.getSettings().setJavaScriptEnabled(true);
  }
  
  public void a()
  {
    WebView localWebView = this.a;
    if (localWebView == null) {
      return;
    }
    localWebView.onPause();
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    WebView localWebView = this.a;
    if (localWebView == null) {
      return;
    }
    localWebView.addJavascriptInterface(paramObject, paramString);
    this.a.loadUrl("about:blank");
  }
  
  public void b()
  {
    WebView localWebView = this.a;
    if (localWebView == null) {
      return;
    }
    localWebView.onResume();
  }
  
  public void destroy()
  {
    WebView localWebView = this.a;
    if (localWebView == null) {
      return;
    }
    localWebView.clearHistory();
    this.a.clearCache(true);
    this.a.loadUrl("about:blank");
    this.a.freeMemory();
    this.a.pauseTimers();
    this.a.destroy();
    this.a = null;
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback, URL paramURL)
  {
    paramURL = this.a;
    if (paramURL == null) {
      return;
    }
    if (paramValueCallback == null) {
      paramValueCallback = null;
    } else {
      paramValueCallback = new JsVirtualMachine.a.1(this, paramValueCallback);
    }
    paramURL.evaluateJavascript(paramString, paramValueCallback);
  }
  
  public IX5JsValue evaluateScript(String paramString, URL paramURL)
  {
    paramURL = this.a;
    if (paramURL == null) {
      return null;
    }
    paramURL.evaluateJavascript(paramString, null);
    return null;
  }
  
  public void evaluateScriptAsync(String paramString, ValueCallback<IX5JsValue> paramValueCallback, URL paramURL)
  {
    paramURL = this.a;
    if (paramURL == null) {
      return;
    }
    if (paramValueCallback == null) {
      paramValueCallback = null;
    } else {
      paramValueCallback = new JsVirtualMachine.a.2(this, paramValueCallback);
    }
    paramURL.evaluateJavascript(paramString, paramValueCallback);
  }
  
  public byte[] getNativeBuffer(int paramInt)
  {
    return null;
  }
  
  public int getNativeBufferId()
  {
    return -1;
  }
  
  public void removeJavascriptInterface(String paramString)
  {
    WebView localWebView = this.a;
    if (localWebView == null) {
      return;
    }
    localWebView.removeJavascriptInterface(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsVirtualMachine.a
 * JD-Core Version:    0.7.0.1
 */