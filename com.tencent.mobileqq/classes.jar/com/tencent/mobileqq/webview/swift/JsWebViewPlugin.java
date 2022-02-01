package com.tencent.mobileqq.webview.swift;

import java.lang.reflect.Method;

@Deprecated
public abstract class JsWebViewPlugin
  extends WebViewPlugin
{
  public JsWebViewPlugin()
  {
    this.mPluginNameSpace = getNameSpace();
  }
  
  protected Method getJsMethod(String paramString1, String paramString2, int paramInt)
  {
    if (!getNameSpace().equals(paramString1)) {
      return null;
    }
    paramString1 = getClass().getDeclaredMethods();
    int j = paramString1.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = paramString1[i];
      if ((localMethod.getName().equals(paramString2)) && (localMethod.getParameterTypes().length == paramInt)) {
        return localMethod;
      }
      i += 1;
    }
    return null;
  }
  
  protected abstract String getNameSpace();
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramString2 = getJsMethod(paramString2, paramString3, paramVarArgs.length);
    if (paramString2 != null) {}
    try
    {
      if (paramVarArgs.length == 0) {
        paramString1 = paramString2.invoke(this, new Object[0]);
      } else {
        paramString1 = paramString2.invoke(this, paramVarArgs);
      }
      paramString2 = paramString2.getReturnType();
      if ((paramString2 != Void.TYPE) && (paramString2 != Void.class))
      {
        if (paramJsBridgeListener != null) {
          if (paramJsBridgeListener.a) {
            callJs4OpenApi(paramJsBridgeListener, 0, JsBridgeListener.a(0, paramString1, null));
          } else {
            paramJsBridgeListener.a(paramString1);
          }
        }
      }
      else if (paramJsBridgeListener != null) {
        if (paramJsBridgeListener.a) {
          callJs4OpenApi(paramJsBridgeListener, 0, JsBridgeListener.a(0, null, null));
        } else {
          paramJsBridgeListener.a(null);
        }
      }
      return true;
    }
    catch (Exception paramJsBridgeListener) {}
    return false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.JsWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */