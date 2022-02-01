package com.tencent.mobileqq.webview.swift.utils;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.util.ITbsDownloader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsDownloader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class SwiftBrowserIdleTaskHelper
{
  static WeakReference<ITbsDownloader> a;
  private static long d;
  private static int e;
  private static SwiftBrowserIdleTaskHelper f;
  private static final ArrayList<SwiftBrowserIdleTaskHelper.IdleTask> g = new ArrayList(5);
  boolean b = false;
  final MessageQueue.IdleHandler c = new SwiftBrowserIdleTaskHelper.1(this);
  
  public static SwiftBrowserIdleTaskHelper a()
  {
    if (f == null) {
      try
      {
        if (f == null) {
          f = new SwiftBrowserIdleTaskHelper();
        }
      }
      finally {}
    }
    return f;
  }
  
  public static void a(ITbsDownloader paramITbsDownloader)
  {
    a = new WeakReference(paramITbsDownloader);
  }
  
  static void b()
  {
    try
    {
      Util.f("downloadX5KernelIfNeeded");
      ITbsDownloader localITbsDownloader = (ITbsDownloader)a.get();
      if (localITbsDownloader != null)
      {
        localObject = WebAccelerateHelper.getInstance().getTBSDpcParam();
        if ((localObject != null) && (((String)localObject).charAt(0) == '1') && ("CN".equals(Locale.getDefault().getCountry())))
        {
          if (TbsDownloader.needDownload(BaseApplication.getContext(), false, false, new SwiftBrowserIdleTaskHelper.2()))
          {
            localITbsDownloader.a(false);
            QLog.i("SwiftBrowserIdleTaskHelper", 1, "call downloadX5Kernel on idle:download tbs.");
          }
        }
        else
        {
          e = 5;
          QLog.i("SwiftBrowserIdleTaskHelper", 1, "call downloadX5Kernel on idle: no need download tbs.");
        }
      }
      Util.g("downloadX5KernelIfNeeded");
      return;
    }
    catch (Throwable localThrowable)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadX5Kernel error:");
      ((StringBuilder)localObject).append(localThrowable.getMessage());
      QLog.e("SwiftBrowserIdleTaskHelper", 1, ((StringBuilder)localObject).toString());
      Util.g("downloadX5KernelIfNeeded");
    }
  }
  
  public void a(SwiftBrowserIdleTaskHelper.IdleTask paramIdleTask)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      Iterator localIterator = g.iterator();
      while (localIterator.hasNext()) {
        if (((SwiftBrowserIdleTaskHelper.IdleTask)localIterator.next()).b == paramIdleTask.b) {
          return;
        }
      }
      g.add(paramIdleTask);
      if ((!g.isEmpty()) && (!this.b))
      {
        this.b = true;
        Looper.myQueue().addIdleHandler(this.c);
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    Iterator localIterator = g.iterator();
    while (localIterator.hasNext())
    {
      SwiftBrowserIdleTaskHelper.IdleTask localIdleTask = (SwiftBrowserIdleTaskHelper.IdleTask)localIterator.next();
      if (localIdleTask.b == paramInt)
      {
        g.remove(localIdleTask);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper
 * JD-Core Version:    0.7.0.1
 */