package com.tencent.mobileqq.webview.swift.injector;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.webview.swift.INavigationProcess;
import com.tencent.mobileqq.webview.swift.component.navigate.AIONavigationItem;
import com.tencent.mobileqq.webview.swift.component.navigate.PublicAccountNavigationItem;
import com.tencent.mobileqq.webview.swift.component.navigate.WeatherNavigationItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class SwiftBrowserNavigatorInjectUtil
{
  @ConfigInject(configPath="/Business/webview/src/main/resources/Inject_web_navigation.yml", version=2)
  public static ArrayList<Class<? extends INavigationProcess>> a = new ArrayList();
  
  static
  {
    a.add(PublicAccountNavigationItem.class);
    a.add(WeatherNavigationItem.class);
    a.add(AIONavigationItem.class);
  }
  
  public static ArrayList<INavigationProcess> a()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      if (a == null) {
        return localArrayList;
      }
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((Class)localIterator.next()).newInstance());
      }
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SwiftBrowserNavigatorInjectUtil", 1, "registerNavigationItems Fail,", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.injector.SwiftBrowserNavigatorInjectUtil
 * JD-Core Version:    0.7.0.1
 */