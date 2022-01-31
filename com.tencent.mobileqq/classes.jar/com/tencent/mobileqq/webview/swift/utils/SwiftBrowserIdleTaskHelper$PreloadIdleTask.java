package com.tencent.mobileqq.webview.swift.utils;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.qphone.base.util.QLog;

public class SwiftBrowserIdleTaskHelper$PreloadIdleTask
  extends SwiftBrowserIdleTaskHelper.IdleTask
{
  public SwiftBrowserIdleTaskHelper$PreloadIdleTask(int paramInt)
  {
    super(paramInt);
  }
  
  public int a()
  {
    if (WebAccelerateHelper.preloadBrowserView == null)
    {
      WebAccelerateHelper.preInflaterBrowserView();
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserIdleTaskHelper", 2, "preloadBrowserView on idle.");
      }
    }
    do
    {
      return 2;
      if (SwiftReuseTouchWebView.c != 0) {
        break;
      }
      SwiftReuseTouchWebView.a(BaseApplicationImpl.sApplication).b(true);
    } while (!QLog.isColorLevel());
    QLog.d("SwiftBrowserIdleTaskHelper", 2, "preload Webview on idle.");
    return 2;
    long l;
    if (SwiftBrowserIdleTaskHelper.a() < 5)
    {
      l = System.currentTimeMillis();
      if (System.currentTimeMillis() > SwiftBrowserIdleTaskHelper.a() + 10000L)
      {
        SwiftBrowserIdleTaskHelper.a();
        SwiftBrowserIdleTaskHelper.b();
        SwiftBrowserIdleTaskHelper.a(l);
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserIdleTaskHelper", 2, "downloadX5KernelIfNeeded on idle.");
        }
      }
    }
    for (;;)
    {
      return 1;
      if (QLog.isColorLevel())
      {
        QLog.d("SwiftBrowserIdleTaskHelper", 2, "not need check because time limit:" + l + " - " + SwiftBrowserIdleTaskHelper.a() + " < 10s.");
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserIdleTaskHelper", 2, "not need check because count limit:" + SwiftBrowserIdleTaskHelper.a() + ">=" + 5 + ".");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper.PreloadIdleTask
 * JD-Core Version:    0.7.0.1
 */