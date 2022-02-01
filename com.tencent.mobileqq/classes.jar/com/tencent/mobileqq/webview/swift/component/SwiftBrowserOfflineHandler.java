package com.tencent.mobileqq.webview.swift.component;

import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class SwiftBrowserOfflineHandler
{
  public static final LruCache<String, SwiftBrowserOfflineHandler> a = new LruCache(8);
  public static final AtomicInteger g = new AtomicInteger(1);
  public final CopyOnWriteArrayList<SwiftBrowserOfflineHandler.CheckOfflineCallback> b = new CopyOnWriteArrayList();
  public final AuthorizeConfig c;
  public String d;
  public final AtomicInteger e = new AtomicInteger(0);
  public final AtomicInteger f = new AtomicInteger(1);
  
  SwiftBrowserOfflineHandler(String paramString)
  {
    this.d = paramString;
    this.c = AuthorizeConfig.a();
  }
  
  public static SwiftBrowserOfflineHandler a(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return null;
      }
      if (!paramString.startsWith("http"))
      {
        bool = paramString.startsWith("https");
        if (!bool) {
          return null;
        }
      }
      String str = "";
      try
      {
        Uri localUri = Uri.parse(paramString);
        paramString = str;
        if (localUri.isHierarchical()) {
          paramString = localUri.getQueryParameter("_bid");
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        paramString = str;
      }
      paramString = b(paramString);
      return paramString;
    }
    finally {}
  }
  
  public static SwiftBrowserOfflineHandler b(String paramString)
  {
    Object localObject = null;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        SwiftBrowserOfflineHandler localSwiftBrowserOfflineHandler = (SwiftBrowserOfflineHandler)a.get(paramString);
        localObject = localSwiftBrowserOfflineHandler;
        if (localSwiftBrowserOfflineHandler == null)
        {
          localObject = new SwiftBrowserOfflineHandler(paramString);
          a.put(paramString, localObject);
        }
      }
      return localObject;
    }
    finally {}
  }
  
  void a()
  {
    this.f.compareAndSet(2, 3);
    new Handler(Looper.getMainLooper()).post(new SwiftBrowserOfflineHandler.3(this));
  }
  
  public void a(SwiftBrowserOfflineHandler.CheckOfflineCallback paramCheckOfflineCallback, String paramString)
  {
    if ((this.f.get() == 3) && (paramCheckOfflineCallback != null))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("now offline bid is ready, ");
        paramString.append(this.d);
        paramString.append(", mode is ");
        paramString.append(this.e.get());
        QLog.i("SwiftBrowserOfflineHandler", 2, paramString.toString());
      }
      paramCheckOfflineCallback.onCheckOfflineFinish(this.e.get());
      return;
    }
    if ((paramCheckOfflineCallback != null) && (!this.b.contains(paramCheckOfflineCallback))) {
      this.b.add(paramCheckOfflineCallback);
    }
    paramCheckOfflineCallback = new SwiftBrowserOfflineHandler.1(this, paramString);
    if (this.f.compareAndSet(1, 2))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("post thread to check offline, bid = ");
        paramString.append(this.d);
        QLog.i("SwiftBrowserOfflineHandler", 2, paramString.toString());
      }
      ThreadManager.postImmediately(paramCheckOfflineCallback, new SwiftBrowserOfflineHandler.2(this), false);
    }
  }
  
  public void b()
  {
    if (g.compareAndSet(1, 2))
    {
      Object localObject1 = this.c.c("ex_offline", "");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ((String)localObject1).split(",");
        Object localObject2 = Build.BRAND;
        String str2 = Build.MODEL;
        String str1 = Build.VERSION.RELEASE;
        localObject2 = new StringBuffer((String)localObject2);
        ((StringBuffer)localObject2).append(" ");
        ((StringBuffer)localObject2).append(str2);
        str2 = ((StringBuffer)localObject2).toString().toLowerCase();
        ((StringBuffer)localObject2).append(" ");
        ((StringBuffer)localObject2).append(str1);
        str1 = ((StringBuffer)localObject2).toString().toLowerCase();
        int i = 0;
        int j = localObject1.length;
        while (i < j)
        {
          localObject2 = localObject1[i].toLowerCase();
          if ((((String)localObject2).contains(str2)) && (str1.startsWith((String)localObject2)))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("*****offline can not use!!! ");
            ((StringBuilder)localObject1).append(str1);
            QLog.e("SwiftBrowserOfflineHandler", 1, ((StringBuilder)localObject1).toString());
            g.compareAndSet(2, 4);
            return;
          }
          i += 1;
        }
      }
      g.compareAndSet(2, 3);
    }
  }
  
  public boolean c()
  {
    return this.f.get() == 3;
  }
  
  public void d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("now reset bid cache! ");
    localStringBuilder.append(this.d);
    QLog.w("SwiftBrowserOfflineHandler", 1, localStringBuilder.toString());
    this.e.set(0);
    this.f.set(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler
 * JD-Core Version:    0.7.0.1
 */