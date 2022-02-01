package com.tencent.xweb.internal;

import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.util.g;
import com.tencent.xweb.util.h;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class l
{
  static l.a a;
  static l.a b;
  static l.a c;
  
  public static IWebView a(WebView.c paramc, WebView paramWebView)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("try to create webview  = ");
    ((StringBuilder)localObject).append(paramc);
    Log.i("WebViewWrapperFactory", ((StringBuilder)localObject).toString());
    b localb = b.a("CREATE_WEBVIEW", paramc);
    localb.a();
    StringBuilder localStringBuilder = null;
    localObject = localStringBuilder;
    try
    {
      if (a(paramc) == null)
      {
        localObject = localStringBuilder;
        paramWebView = new StringBuilder();
        localObject = localStringBuilder;
        paramWebView.append("the kind of ");
        localObject = localStringBuilder;
        paramWebView.append(paramc);
        localObject = localStringBuilder;
        paramWebView.append(" this provider does not exist!");
        localObject = localStringBuilder;
        Log.e("WebViewWrapperFactory", paramWebView.toString());
        return null;
      }
      localObject = localStringBuilder;
      paramWebView = a(paramc).createWebView(paramWebView);
      if (paramWebView != null)
      {
        localObject = paramWebView;
        localb.b();
        return paramWebView;
      }
      localObject = paramWebView;
      localStringBuilder = new StringBuilder();
      localObject = paramWebView;
      localStringBuilder.append("create webview failed type = ");
      localObject = paramWebView;
      localStringBuilder.append(paramc);
      localObject = paramWebView;
      XWalkEnvironment.addXWalkInitializeLog("WebViewWrapperFactory", localStringBuilder.toString());
      return paramWebView;
    }
    catch (Exception paramWebView)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("create webview with exception  type = ");
      localStringBuilder.append(paramc);
      localStringBuilder.append(", error msg:");
      localStringBuilder.append(paramWebView.getMessage());
      XWalkEnvironment.addXWalkInitializeLog("WebViewWrapperFactory", localStringBuilder.toString());
      h.e(paramc);
    }
    return localObject;
  }
  
  public static l.a a(WebView.c paramc)
  {
    if (paramc == WebView.c.b)
    {
      if (a == null)
      {
        paramc = g.a("com.tencent.xweb.xwalk.XWalkWebFactory", "getInstance");
        if ((paramc != null) && ((paramc instanceof l.a)))
        {
          a = (l.a)paramc;
        }
        else
        {
          Log.e("WebViewWrapperFactory", "find com.tencent.xweb.XWalkWebFactory failed");
          return null;
        }
      }
      return a;
    }
    if (paramc == WebView.c.c)
    {
      if (b == null)
      {
        paramc = g.a("com.tencent.xweb.x5.X5WebFactory", "getInstance");
        if ((paramc != null) && ((paramc instanceof l.a)))
        {
          b = (l.a)paramc;
        }
        else
        {
          Log.e("WebViewWrapperFactory", "find X5WebFactory failed");
          return null;
        }
      }
      return b;
    }
    if (paramc == WebView.c.d)
    {
      if (c == null)
      {
        paramc = g.a("com.tencent.xweb.sys.SysWebFactory", "getInstance");
        if ((paramc != null) && ((paramc instanceof l.a)))
        {
          c = (l.a)paramc;
        }
        else
        {
          Log.e("WebViewWrapperFactory", "find SysWebFactory failed");
          return null;
        }
      }
      return c;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.internal.l
 * JD-Core Version:    0.7.0.1
 */