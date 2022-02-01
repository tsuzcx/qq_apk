package com.tencent.mobileqq.webview.swift.component;

import com.tencent.biz.cookie.WeatherBrowserCookieInjector;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.webview.cookie.IBrowserCookieInjector;
import java.util.ArrayList;

public class SwiftBrowserCookieInjectorUtil
{
  @ConfigInject(configPath="/Business/webview/src/main/resources/Inject_browser_cookie_business.yml", version=1)
  public static ArrayList<Class<? extends IBrowserCookieInjector>> a = new ArrayList();
  
  static
  {
    a.add(WeatherBrowserCookieInjector.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieInjectorUtil
 * JD-Core Version:    0.7.0.1
 */