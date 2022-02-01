package com.tencent.mobileqq.webview.swift.utils;

import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.qphone.base.util.BaseApplication;
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
      return 2;
    }
    if (SwiftReuseTouchWebView.c == 0)
    {
      SwiftReuseTouchWebView.a(BaseApplication.getContext()).a(true);
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserIdleTaskHelper", 2, "preload Webview on idle.");
      }
      return 2;
    }
    StringBuilder localStringBuilder;
    if (SwiftBrowserIdleTaskHelper.a() < 5)
    {
      long l = System.currentTimeMillis();
      if (System.currentTimeMillis() > SwiftBrowserIdleTaskHelper.a() + 10000L)
      {
        SwiftBrowserIdleTaskHelper.a();
        SwiftBrowserIdleTaskHelper.b();
        SwiftBrowserIdleTaskHelper.a(l);
        if (QLog.isColorLevel())
        {
          QLog.d("SwiftBrowserIdleTaskHelper", 2, "downloadX5KernelIfNeeded on idle.");
          return 1;
        }
      }
      else if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("not need check because time limit:");
        localStringBuilder.append(l);
        localStringBuilder.append(" - ");
        localStringBuilder.append(SwiftBrowserIdleTaskHelper.a());
        localStringBuilder.append(" < 10s.");
        QLog.d("SwiftBrowserIdleTaskHelper", 2, localStringBuilder.toString());
        return 1;
      }
    }
    else if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("not need check because count limit:");
      localStringBuilder.append(SwiftBrowserIdleTaskHelper.a());
      localStringBuilder.append(">=");
      localStringBuilder.append(5);
      localStringBuilder.append(".");
      QLog.d("SwiftBrowserIdleTaskHelper", 2, localStringBuilder.toString());
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper.PreloadIdleTask
 * JD-Core Version:    0.7.0.1
 */