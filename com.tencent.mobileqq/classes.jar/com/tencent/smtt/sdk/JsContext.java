package com.tencent.smtt.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import java.net.URL;

public final class JsContext
{
  private final IX5JsContext mContext;
  private ExceptionHandler mExceptionHandler;
  private String mName;
  private final JsVirtualMachine mVirtualMachine;
  
  public JsContext(Context paramContext)
  {
    this(new JsVirtualMachine(paramContext));
  }
  
  public JsContext(JsVirtualMachine paramJsVirtualMachine)
  {
    if (paramJsVirtualMachine == null) {
      throw new IllegalArgumentException("The virtualMachine value can not be null");
    }
    this.mVirtualMachine = paramJsVirtualMachine;
    this.mContext = this.mVirtualMachine.createJsContext();
    try
    {
      this.mContext.setPerContextData(this);
      return;
    }
    catch (AbstractMethodError paramJsVirtualMachine) {}
  }
  
  public static JsContext current()
  {
    return (JsContext)X5JsCore.currentContextData();
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    this.mContext.addJavascriptInterface(paramObject, paramString);
  }
  
  public void destroy()
  {
    this.mContext.destroy();
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    evaluateJavascript(paramString, paramValueCallback, null);
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback, URL paramURL)
  {
    this.mContext.evaluateJavascript(paramString, paramValueCallback, paramURL);
  }
  
  public JsValue evaluateScript(String paramString)
  {
    return evaluateScript(paramString, null);
  }
  
  public JsValue evaluateScript(String paramString, URL paramURL)
  {
    paramString = this.mContext.evaluateScript(paramString, paramURL);
    if (paramString == null) {
      return null;
    }
    return new JsValue(this, paramString);
  }
  
  public void evaluateScriptAsync(String paramString, final ValueCallback<JsValue> paramValueCallback, URL paramURL)
  {
    if (paramValueCallback == null) {}
    for (paramValueCallback = null;; paramValueCallback = new ValueCallback()
        {
          public void onReceiveValue(IX5JsValue paramAnonymousIX5JsValue)
          {
            ValueCallback localValueCallback = paramValueCallback;
            if (paramAnonymousIX5JsValue == null) {}
            for (paramAnonymousIX5JsValue = null;; paramAnonymousIX5JsValue = new JsValue(JsContext.this, paramAnonymousIX5JsValue))
            {
              localValueCallback.onReceiveValue(paramAnonymousIX5JsValue);
              return;
            }
          }
        })
    {
      this.mContext.evaluateScriptAsync(paramString, paramValueCallback, paramURL);
      return;
    }
  }
  
  public ExceptionHandler exceptionHandler()
  {
    return this.mExceptionHandler;
  }
  
  public String name()
  {
    return this.mName;
  }
  
  public void removeJavascriptInterface(String paramString)
  {
    this.mContext.removeJavascriptInterface(paramString);
  }
  
  public void setExceptionHandler(ExceptionHandler paramExceptionHandler)
  {
    this.mExceptionHandler = paramExceptionHandler;
    if (paramExceptionHandler == null)
    {
      this.mContext.setExceptionHandler(null);
      return;
    }
    this.mContext.setExceptionHandler(new ValueCallback()
    {
      public void onReceiveValue(IX5JsError paramAnonymousIX5JsError)
      {
        JsContext.this.mExceptionHandler.handleException(JsContext.this, new JsError(paramAnonymousIX5JsError));
      }
    });
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
    this.mContext.setName(paramString);
  }
  
  public void stealValueFromOtherCtx(String paramString1, JsContext paramJsContext, String paramString2)
  {
    this.mContext.stealValueFromOtherCtx(paramString1, paramJsContext.mContext, paramString2);
  }
  
  public JsVirtualMachine virtualMachine()
  {
    return this.mVirtualMachine;
  }
  
  public static abstract interface ExceptionHandler
  {
    public abstract void handleException(JsContext paramJsContext, JsError paramJsError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsContext
 * JD-Core Version:    0.7.0.1
 */