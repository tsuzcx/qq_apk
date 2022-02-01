package com.tencent.mobileqq.webview.swift.injector;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSInjectorImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class SwiftBrowserTBSInjectorUtil
{
  @ConfigInject(configPath="/Business/webview/src/main/resources/Inject_web_tbs.yml", version=2)
  public static ArrayList<Class<? extends ISwiftBrowserTBSInjector>> a = new ArrayList();
  
  static
  {
    a.add(SwiftBrowserTBSInjectorImpl.class);
  }
  
  public static ISwiftBrowserTBSInjector a()
  {
    try
    {
      if ((a != null) && (a.size() > 0))
      {
        ISwiftBrowserTBSInjector localISwiftBrowserTBSInjector = (ISwiftBrowserTBSInjector)((Class)a.get(0)).newInstance();
        return localISwiftBrowserTBSInjector;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SwiftBrowserTBSInjectorUtil", 1, "registerSwiftBrowserTBSInjector Fail,", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.injector.SwiftBrowserTBSInjectorUtil
 * JD-Core Version:    0.7.0.1
 */