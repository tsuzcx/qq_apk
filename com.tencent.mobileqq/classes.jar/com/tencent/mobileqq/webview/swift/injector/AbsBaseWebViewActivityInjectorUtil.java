package com.tencent.mobileqq.webview.swift.injector;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.webview.swift.AbsBaseWebViewActivityImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AbsBaseWebViewActivityInjectorUtil
{
  @ConfigInject(configPath="/Business/webview/src/main/resources/Inject_abs_base_web_view_activity.yml", version=2)
  public static ArrayList<Class<? extends IAbsBaseWebViewActivityInjector>> a = new ArrayList();
  
  static
  {
    a.add(AbsBaseWebViewActivityImpl.class);
  }
  
  public static IAbsBaseWebViewActivityInjector a()
  {
    try
    {
      if ((a != null) && (a.size() > 0))
      {
        IAbsBaseWebViewActivityInjector localIAbsBaseWebViewActivityInjector = (IAbsBaseWebViewActivityInjector)((Class)a.get(0)).newInstance();
        return localIAbsBaseWebViewActivityInjector;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AbsBaseWebViewActivityInjectorUtil", 1, "registerAbsBaseWebViewActivityInjector Fail,", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.injector.AbsBaseWebViewActivityInjectorUtil
 * JD-Core Version:    0.7.0.1
 */