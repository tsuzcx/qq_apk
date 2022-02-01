package com.tencent.mobileqq.webview.swift.injector;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.webview.swift.WebViewSurfaceInjectorImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class WebViewSurfaceInjectorUtils
{
  @ConfigInject(configPath="/Business/webview/src/main/resources/Inject_webview_surface.yml", version=2)
  public static ArrayList<Class<? extends IWebViewSurfaceInjector>> a = new ArrayList();
  
  static
  {
    a.add(WebViewSurfaceInjectorImpl.class);
  }
  
  public static IWebViewSurfaceInjector a()
  {
    try
    {
      if ((a != null) && (a.size() > 0))
      {
        IWebViewSurfaceInjector localIWebViewSurfaceInjector = (IWebViewSurfaceInjector)((Class)a.get(0)).newInstance();
        return localIWebViewSurfaceInjector;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("WebViewSurfaceInjectorUtils", 1, "registerWebViewSurfaceInjectors Fail,", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.injector.WebViewSurfaceInjectorUtils
 * JD-Core Version:    0.7.0.1
 */