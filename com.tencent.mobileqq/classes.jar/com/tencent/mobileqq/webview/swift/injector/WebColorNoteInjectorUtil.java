package com.tencent.mobileqq.webview.swift.injector;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.webview.swift.WebColorNoteInjectImpl;
import com.tencent.mobileqq.webview.util.IWebColorNoteInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class WebColorNoteInjectorUtil
{
  @ConfigInject(configPath="/Business/webview/src/main/resources/Inject_web_color_note.yml", version=2)
  public static ArrayList<Class<? extends IWebColorNoteInject>> a = new ArrayList();
  
  static
  {
    a.add(WebColorNoteInjectImpl.class);
  }
  
  public static IWebColorNoteInject a()
  {
    try
    {
      if ((a != null) && (a.size() > 0))
      {
        IWebColorNoteInject localIWebColorNoteInject = (IWebColorNoteInject)((Class)a.get(0)).newInstance();
        return localIWebColorNoteInject;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("WebColorNoteInjectorUtil", 1, "registerColorNoteInjector Fail,", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.injector.WebColorNoteInjectorUtil
 * JD-Core Version:    0.7.0.1
 */