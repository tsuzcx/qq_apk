package com.tencent.mobileqq.webview.swift;

import com.tencent.mobileqq.Doraemon.NativeApiManagerImpl;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.webview.nativeapi.INativeApiMangerInjector;
import java.util.ArrayList;

public class WebViewEngineInjectorUtil
{
  @ConfigInject(configPath="/Business/webview/src/main/resources/Inject_plugin_engine.yml", version=2)
  public static ArrayList<Class<? extends INativeApiMangerInjector>> a = new ArrayList();
  
  static
  {
    a.add(NativeApiManagerImpl.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewEngineInjectorUtil
 * JD-Core Version:    0.7.0.1
 */