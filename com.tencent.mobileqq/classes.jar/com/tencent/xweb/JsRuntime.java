package com.tencent.xweb;

import android.content.Context;
import org.xwalk.core.XWalkEnvironment;

public class JsRuntime
{
  public static JsRuntime.JsRuntimeType a;
  private static String b = "";
  
  public static JsRuntime.JsRuntimeType a()
  {
    return a;
  }
  
  public static JsRuntime.JsRuntimeType a(JsRuntime.JsRuntimeType paramJsRuntimeType, String paramString, Context paramContext)
  {
    v.a(paramContext);
    paramContext = paramString;
    if (paramString == null) {
      paramContext = "";
    }
    if (v.a().l() != JsRuntime.JsRuntimeType.a)
    {
      paramJsRuntimeType = v.a().l();
      paramString = new StringBuilder();
      paramString.append("use hardcode jscore type = ");
      paramString.append(paramJsRuntimeType);
      XWalkEnvironment.addXWalkInitializeLog("XWeb", paramString.toString());
    }
    else if (a.c(paramContext) != JsRuntime.JsRuntimeType.a)
    {
      paramJsRuntimeType = a.c(paramContext);
      paramString = new StringBuilder();
      paramString.append("module ");
      paramString.append(paramContext);
      paramString.append("use cmd jscore type = ");
      paramString.append(paramJsRuntimeType);
      XWalkEnvironment.addXWalkInitializeLog("XWeb", paramString.toString());
    }
    if (WebView.getCurWebType() == WebView.c.c)
    {
      paramString = paramJsRuntimeType;
      if (JsRuntime.JsRuntimeType.b != paramJsRuntimeType)
      {
        paramString = paramJsRuntimeType;
        if (JsRuntime.JsRuntimeType.f != paramJsRuntimeType) {
          return JsRuntime.JsRuntimeType.i;
        }
      }
    }
    else if (WebView.getCurWebType() == WebView.c.b)
    {
      paramString = paramJsRuntimeType;
      if (JsRuntime.JsRuntimeType.h != paramJsRuntimeType)
      {
        paramString = paramJsRuntimeType;
        if (JsRuntime.JsRuntimeType.g != paramJsRuntimeType)
        {
          paramString = paramJsRuntimeType;
          if (JsRuntime.JsRuntimeType.b != paramJsRuntimeType) {
            return JsRuntime.JsRuntimeType.i;
          }
        }
      }
    }
    else
    {
      paramString = paramJsRuntimeType;
      if (WebView.getCurWebType() == WebView.c.d)
      {
        paramString = paramJsRuntimeType;
        if (JsRuntime.JsRuntimeType.b != paramJsRuntimeType) {
          paramString = JsRuntime.JsRuntimeType.i;
        }
      }
    }
    return paramString;
  }
  
  public static String b()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.JsRuntime
 * JD-Core Version:    0.7.0.1
 */