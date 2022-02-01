package com.tencent.mobileqq.webview.swift.injector;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatisticInjectorImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class SwiftBrowserStatisticInjectorUtil
{
  @ConfigInject(configPath="/Business/webview/src/main/resources/Inject_web_statistic.yml", version=2)
  public static ArrayList<Class<? extends ISwiftBrowserStatisticInjector>> a = new ArrayList();
  
  static
  {
    a.add(SwiftBrowserStatisticInjectorImpl.class);
  }
  
  public static ISwiftBrowserStatisticInjector a()
  {
    try
    {
      if ((a != null) && (a.size() > 0))
      {
        ISwiftBrowserStatisticInjector localISwiftBrowserStatisticInjector = (ISwiftBrowserStatisticInjector)((Class)a.get(0)).newInstance();
        return localISwiftBrowserStatisticInjector;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SwiftBrowserStatisticInjectorUtil", 1, "registerSwiftBrowserStatisticInjector Fail,", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.injector.SwiftBrowserStatisticInjectorUtil
 * JD-Core Version:    0.7.0.1
 */