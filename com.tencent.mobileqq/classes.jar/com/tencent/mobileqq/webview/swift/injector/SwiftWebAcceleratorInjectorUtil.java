package com.tencent.mobileqq.webview.swift.injector;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAcceleratorInjectorImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class SwiftWebAcceleratorInjectorUtil
{
  @ConfigInject(configPath="/Business/webview/src/main/resources/Inject_web_accelerator.yml", version=2)
  public static ArrayList<Class<? extends ISwiftWebAcceleratorInjector>> a = new ArrayList();
  
  static
  {
    a.add(SwiftWebAcceleratorInjectorImpl.class);
  }
  
  public static ISwiftWebAcceleratorInjector a()
  {
    try
    {
      if ((a != null) && (a.size() > 0))
      {
        ISwiftWebAcceleratorInjector localISwiftWebAcceleratorInjector = (ISwiftWebAcceleratorInjector)((Class)a.get(0)).newInstance();
        return localISwiftWebAcceleratorInjector;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SwiftWebAcceleratorInjectorUtil", 1, "registerSwiftWebAcceleratorInjector Fail,", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.injector.SwiftWebAcceleratorInjectorUtil
 * JD-Core Version:    0.7.0.1
 */