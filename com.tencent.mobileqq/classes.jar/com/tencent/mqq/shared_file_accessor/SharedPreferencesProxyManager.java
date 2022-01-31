package com.tencent.mqq.shared_file_accessor;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.HandlerThread;
import android.os.Looper;
import android.provider.Settings.System;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SharedPreferencesProxyManager
{
  private static SharedPreferencesProxyManager a = null;
  public static String sSystemSpExceptionMsg = null;
  private Map b = new ConcurrentHashMap(5);
  private Map c = new ConcurrentHashMap(5);
  private g d = null;
  private HandlerThread e = null;
  private WeakReference f = null;
  
  private void c()
  {
    try
    {
      if ((this.e == null) || (!this.e.isAlive()))
      {
        if ((this.e != null) && (!this.e.isAlive())) {
          this.e.quit();
        }
        this.e = new HandlerThread("sp_worker", 0);
        this.e.start();
      }
      return;
    }
    finally {}
  }
  
  public static SharedPreferencesProxyManager getInstance()
  {
    if (a != null) {
      return a;
    }
    try
    {
      if (a == null) {
        a = new SharedPreferencesProxyManager();
      }
      return a;
    }
    finally {}
  }
  
  final Context a()
  {
    return (Context)this.f.get();
  }
  
  final Looper b()
  {
    return this.e.getLooper();
  }
  
  public g getCache()
  {
    return null;
  }
  
  public SharedPreferences getProxy(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString == null) {
      str = "null";
    }
    if (((paramInt & 0x4) == 4) && (!p.a)) {}
    for (localMap = this.c;; localMap = this.b)
    {
      SharedPreferences localSharedPreferences = (SharedPreferences)localMap.get(str);
      paramString = localSharedPreferences;
      if (localSharedPreferences == null) {}
      try
      {
        localSharedPreferences = (SharedPreferences)localMap.get(str);
        paramString = localSharedPreferences;
        if (localSharedPreferences == null)
        {
          paramString = new n(this.f, str, paramInt);
          localMap.put(str, paramString);
        }
        return paramString;
      }
      finally {}
    }
  }
  
  public SharedPreferencesProxyManager init(Context paramContext)
  {
    if (paramContext == null) {}
    try
    {
      Log.e("SpUtils", "init context is null. ", new RuntimeException());
      if ((this.f == null) && (paramContext != null))
      {
        p.a(paramContext);
        this.f = new WeakReference(paramContext.getApplicationContext());
        c();
      }
      return this;
    }
    finally {}
  }
  
  public void notifyLoginABegin() {}
  
  public void setCatLogEnabled(boolean paramBoolean) {}
  
  public void setStrategy(String paramString)
  {
    Context localContext = (Context)this.f.get();
    int i = 0;
    int j = 0;
    if (paramString != null) {}
    try
    {
      i = Integer.valueOf(paramString).intValue();
      if (localContext != null) {
        Settings.System.putInt(localContext.getContentResolver(), "com.tencent.mobileqq.sp_strategy", i);
      }
      return;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public void setTimeLogEnabled(boolean paramBoolean) {}
  
  public void trySave()
  {
    if (this.f == null) {}
    for (;;)
    {
      return;
      if (p.a) {
        try
        {
          Iterator localIterator = this.b.entrySet().iterator();
          while (localIterator.hasNext())
          {
            SharedPreferences localSharedPreferences = (SharedPreferences)((Map.Entry)localIterator.next()).getValue();
            if ((localSharedPreferences instanceof n)) {
              ((n)localSharedPreferences).a();
            }
          }
          p.b((Context)this.f.get());
        }
        catch (Throwable localThrowable) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager
 * JD-Core Version:    0.7.0.1
 */