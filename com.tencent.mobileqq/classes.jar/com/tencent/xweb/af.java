package com.tencent.xweb;

import android.content.Context;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.internal.l.a;
import com.tencent.xweb.util.IXWebLogClient;
import com.tencent.xweb.util.h;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

public class af
{
  static boolean a = false;
  static boolean b = false;
  
  public static void a()
  {
    try
    {
      boolean bool = a;
      if (bool) {
        return;
      }
      a = true;
      l.a locala = l.a(WebView.c.b);
      if (locala != null) {
        locala.initInterface();
      }
      locala = l.a(WebView.c.c);
      if (locala != null) {
        locala.initInterface();
      }
      return;
    }
    finally {}
  }
  
  private static void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      boolean bool = b;
      if (bool) {
        return;
      }
      XWalkEnvironment.init(paramContext);
      l.a locala = l.a(WebView.c.b);
      if (locala != null) {
        locala.initEnviroment(paramContext);
      }
      locala = l.a(WebView.c.c);
      if (locala != null) {
        locala.initEnviroment(paramContext);
      }
      b = true;
      return;
    }
    finally {}
  }
  
  public static void a(Context paramContext, IXWebLogClient paramIXWebLogClient, ISharedPreferenceProvider paramISharedPreferenceProvider, ab paramab, WebViewExtensionListener paramWebViewExtensionListener)
  {
    if (paramIXWebLogClient != null) {}
    try
    {
      Log.SetLogCallBack(paramIXWebLogClient);
      if (paramab != null) {
        h.a(paramab);
      }
      if (paramISharedPreferenceProvider != null) {
        ad.a(paramISharedPreferenceProvider);
      }
      a(paramContext);
      if (paramWebViewExtensionListener != null) {
        l.a(WebView.c.b).initCallback(paramWebViewExtensionListener);
      }
      if (paramWebViewExtensionListener != null) {
        l.a(WebView.c.c).initCallback(paramWebViewExtensionListener);
      }
      XWebCoreContentProvider.a();
      return;
    }
    finally
    {
      label77:
      break label77;
    }
    throw paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.af
 * JD-Core Version:    0.7.0.1
 */