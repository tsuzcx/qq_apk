package com.tencent.tmassistantbase.util.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.tmassistant.common.jce.BypassInterceptConfig;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.storage.b;
import java.util.ArrayList;
import java.util.Iterator;

public class h
{
  private static h a = null;
  private ArrayList<j> b = new ArrayList();
  private boolean c = false;
  private d d;
  
  public static h a()
  {
    try
    {
      if (a == null) {
        a = new h();
      }
      h localh = a;
      return localh;
    }
    finally {}
  }
  
  private void a(j paramj)
  {
    if (this.b.contains(paramj))
    {
      Log.i("HookManager", "addHook. hookObject already exist.");
      return;
    }
    this.b.add(paramj);
  }
  
  public static boolean a(String paramString)
  {
    BypassInterceptConfig localBypassInterceptConfig = (BypassInterceptConfig)b.a().a("key_bypass_config", BypassInterceptConfig.class);
    if (localBypassInterceptConfig == null) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("config.status = ");
    localStringBuilder.append(localBypassInterceptConfig.status);
    localStringBuilder.append("||config.pkgList = [");
    Iterator localIterator = localBypassInterceptConfig.pkgList.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append((String)localIterator.next());
      localStringBuilder.append(",");
    }
    localStringBuilder.append("]");
    r.c("miles", localStringBuilder.toString());
    if (localBypassInterceptConfig.status == 1)
    {
      r.c("miles", "<checkPkg> status == 1, allow all pkg");
      return true;
    }
    if ((localBypassInterceptConfig.pkgList != null) && (localBypassInterceptConfig.pkgList.contains(paramString)))
    {
      r.c("miles", "<checkPkg> pkgList contains " + paramString + ",allow install");
      return true;
    }
    return false;
  }
  
  public static boolean b()
  {
    long l = System.currentTimeMillis();
    BypassInterceptConfig localBypassInterceptConfig = (BypassInterceptConfig)b.a().a("key_bypass_config", BypassInterceptConfig.class);
    r.c("miles", "读取配置耗时：" + (System.currentTimeMillis() - l) + "ms");
    return (localBypassInterceptConfig != null) && (localBypassInterceptConfig.status != 0);
  }
  
  private void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      Log.i("HookManager", "start inject obj:" + localj.a());
      localj.b();
      Log.i("HookManager", "end inject obj:" + localj.a());
    }
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    if (GlobalUtil.getInstance().getContext() == null)
    {
      GlobalUtil.getInstance().setContext(paramContext.getApplicationContext());
      com.tencent.tmdownloader.f.a();
    }
    StringBuilder localStringBuilder = new StringBuilder().append("Thread.currentThread() == Looper.getMainLooper().getThread() is ");
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {}
    for (boolean bool = true;; bool = false)
    {
      r.c("miles", bool);
      if (!b()) {
        break;
      }
      long l = System.currentTimeMillis();
      if (!this.c)
      {
        if (this.b.contains(this.d)) {
          this.b.remove(this.d);
        }
        this.d = new d(paramContext);
        a(this.d);
        c();
        this.c = true;
      }
      if ((this.d != null) && (!this.d.c())) {
        this.d.a(true);
      }
      r.c("miles", "<hookAM4Install> time cost:" + (System.currentTimeMillis() - l));
      com.tencent.tmassistantbase.util.f.a().post(new i(this));
      return;
    }
    r.c("miles", "<hookAM4Install> hook denied");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.a.h
 * JD-Core Version:    0.7.0.1
 */