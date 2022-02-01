package com.tencent.mobileqq.webview.swift.injector;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.webprocess.WebProcessReceiverInjectorImpl;
import com.tencent.mobileqq.webview.util.IWebProcessReceiverInjector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class WebProcessReceiverInjectUtil
{
  @ConfigInject(configPath="/Business/webview/src/main/resources/Inject_web_process_receiver.yml", version=2)
  public static ArrayList<Class<? extends IWebProcessReceiverInjector>> a = new ArrayList();
  
  static
  {
    a.add(WebProcessReceiverInjectorImpl.class);
  }
  
  public static IWebProcessReceiverInjector a()
  {
    try
    {
      if ((a != null) && (a.size() > 0))
      {
        IWebProcessReceiverInjector localIWebProcessReceiverInjector = (IWebProcessReceiverInjector)((Class)a.get(0)).newInstance();
        return localIWebProcessReceiverInjector;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("WebProcessReceiverInjectUtil", 1, "registerWebProcessReceiverInject Fail,", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.injector.WebProcessReceiverInjectUtil
 * JD-Core Version:    0.7.0.1
 */