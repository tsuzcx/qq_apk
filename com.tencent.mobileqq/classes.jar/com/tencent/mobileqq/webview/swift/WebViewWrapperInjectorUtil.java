package com.tencent.mobileqq.webview.swift;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.webview.WebViewWrapperInjector;
import java.util.ArrayList;

public class WebViewWrapperInjectorUtil
{
  @ConfigInject(configPath="/Business/webview/src/main/resources/Inject_webview_wrapper.yml", version=2)
  public static ArrayList<Class<? extends IWebViewWrapperInjector>> a = new ArrayList();
  
  static
  {
    a.add(WebViewWrapperInjector.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewWrapperInjectorUtil
 * JD-Core Version:    0.7.0.1
 */