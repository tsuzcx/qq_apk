package com.tencent.tmassistantbase.util.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.tmassistant.common.jce.BypassInterceptConfig;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.k;
import com.tencent.tmdownloader.f;
import com.tencent.tmdownloader.internal.storage.b;
import java.util.ArrayList;
import java.util.Iterator;

public class h
{
  private static h a;
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
    Object localObject = (BypassInterceptConfig)b.a().a("key_bypass_config", BypassInterceptConfig.class);
    if (localObject == null) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("config.status = ");
    localStringBuilder.append(((BypassInterceptConfig)localObject).status);
    localStringBuilder.append("||config.pkgList = [");
    Iterator localIterator = ((BypassInterceptConfig)localObject).pkgList.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append((String)localIterator.next());
      localStringBuilder.append(",");
    }
    localStringBuilder.append("]");
    ab.c("miles", localStringBuilder.toString());
    if (((BypassInterceptConfig)localObject).status == 1)
    {
      ab.c("miles", "<checkPkg> status == 1, allow all pkg");
      return true;
    }
    if ((((BypassInterceptConfig)localObject).pkgList != null) && (((BypassInterceptConfig)localObject).pkgList.contains(paramString)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<checkPkg> pkgList contains ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",allow install");
      ab.c("miles", ((StringBuilder)localObject).toString());
      return true;
    }
    return false;
  }
  
  public static boolean b()
  {
    long l = System.currentTimeMillis();
    BypassInterceptConfig localBypassInterceptConfig = (BypassInterceptConfig)b.a().a("key_bypass_config", BypassInterceptConfig.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("读取配置耗时：");
    localStringBuilder.append(System.currentTimeMillis() - l);
    localStringBuilder.append("ms");
    ab.c("miles", localStringBuilder.toString());
    return (localBypassInterceptConfig != null) && (localBypassInterceptConfig.status != 0);
  }
  
  private void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start inject obj:");
      localStringBuilder.append(localj.a());
      Log.i("HookManager", localStringBuilder.toString());
      localj.b();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("end inject obj:");
      localStringBuilder.append(localj.a());
      Log.i("HookManager", localStringBuilder.toString());
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
      f.a();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Thread.currentThread() == Looper.getMainLooper().getThread() is ");
    boolean bool;
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    ab.c("miles", localStringBuilder.toString());
    if (b())
    {
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
      paramContext = this.d;
      if ((paramContext != null) && (!paramContext.c())) {
        this.d.a(true);
      }
      paramContext = new StringBuilder();
      paramContext.append("<hookAM4Install> time cost:");
      paramContext.append(System.currentTimeMillis() - l);
      ab.c("miles", paramContext.toString());
      k.a().post(new i(this));
      return;
    }
    ab.c("miles", "<hookAM4Install> hook denied");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.a.h
 * JD-Core Version:    0.7.0.1
 */