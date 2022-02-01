package com.tencent.mobileqq.msf.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.msf.sdk.a.a;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class d
  implements INetEventHandler, INetInfoHandler
{
  public static final int a = 254;
  public static final int b = 100;
  public static final String c = "com.tencent.mobileqq.msf.bd.netchange";
  public static long d = 0L;
  private static String e = "MSF.D.AppNetInfoNewImpl";
  private a f = new a();
  private Handler g;
  private HandlerThread h;
  private CopyOnWriteArrayList i = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList j = new CopyOnWriteArrayList();
  private AtomicBoolean k = new AtomicBoolean(false);
  private AtomicBoolean l = new AtomicBoolean(false);
  private BroadcastReceiver m = new e(this);
  
  public d()
  {
    this.f.a(this);
    this.f.a(this);
    this.f.a(new d.a(this, null));
    this.h = new HandlerThread("AppNetHandlerThread");
    this.h.start();
    this.g = new Handler(this.h.getLooper());
    this.f.a(this.g);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.msf.bd.netchange");
    BaseApplication.getContext().registerReceiver(this.m, localIntentFilter);
    a();
  }
  
  public void a()
  {
    if ((QLog.isColorLevel()) && (!h())) {
      QLog.d(e, 2, "refreshNetworkIfNot bInit=" + this.k.get() + " bRefreshing=" + this.l.get());
    }
    if (this.k.compareAndSet(false, true))
    {
      this.l.set(true);
      a(null, false);
    }
    while (((h()) && ((!h()) || (i() != null))) || (System.currentTimeMillis() - d < 5000L) || (!this.l.compareAndSet(false, true))) {
      return;
    }
    d = System.currentTimeMillis();
    a(null, true);
  }
  
  public void a(Context paramContext, INetEventHandler paramINetEventHandler)
  {
    String str = e;
    StringBuilder localStringBuilder = new StringBuilder().append("registerNetEventHandler ");
    if (paramINetEventHandler == null) {}
    for (paramContext = "null";; paramContext = Integer.toHexString(paramINetEventHandler.hashCode()))
    {
      QLog.d(str, 1, paramContext);
      if (paramINetEventHandler != null) {
        this.j.addIfAbsent(paramINetEventHandler);
      }
      return;
    }
  }
  
  public void a(Context paramContext, INetInfoHandler paramINetInfoHandler)
  {
    String str = e;
    StringBuilder localStringBuilder = new StringBuilder().append("registerNetInfoHandler ");
    if (paramINetInfoHandler == null) {}
    for (paramContext = "null";; paramContext = Integer.toHexString(paramINetInfoHandler.hashCode()))
    {
      QLog.d(str, 1, paramContext);
      if (paramINetInfoHandler != null) {
        this.i.addIfAbsent(paramINetInfoHandler);
      }
      return;
    }
  }
  
  public void a(NetworkInfo paramNetworkInfo, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    boolean bool = h();
    int n;
    if (this.f.f() == null) {
      n = 1;
    }
    for (;;)
    {
      this.f.a(BaseApplication.getContext(), paramNetworkInfo);
      NetworkInfo localNetworkInfo;
      Object localObject;
      if (paramBoolean)
      {
        localNetworkInfo = this.f.f();
        if ((localNetworkInfo != null) && (localNetworkInfo.getDetailedState() == NetworkInfo.DetailedState.CONNECTED))
        {
          QLog.i(e, 1, "checkNetEvent isNetSupport=" + h() + ", but net detailed state is CONNECTED");
          QLog.i(e, 1, "checkNetEvent current netInfo: " + localNetworkInfo);
          paramNetworkInfo = new HashMap();
          paramNetworkInfo.put("processName", MsfServiceSdk.get().processName);
          paramNetworkInfo.put("netType", String.valueOf(localNetworkInfo.getType()));
          localObject = new RdmReq();
          ((RdmReq)localObject).eventName = "CheckNetIsValid";
          ((RdmReq)localObject).elapse = (System.currentTimeMillis() - l1);
          ((RdmReq)localObject).isSucceed = true;
          ((RdmReq)localObject).isRealTime = true;
          ((RdmReq)localObject).params = paramNetworkInfo;
        }
      }
      try
      {
        paramNetworkInfo = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), (RdmReq)localObject);
        MsfServiceSdk.get().sendMsg(paramNetworkInfo);
        if ((bool) && (n != 0))
        {
          localObject = e;
          StringBuilder localStringBuilder = new StringBuilder().append("WARN: checkNetEvent exception, isNetSupport=").append(bool).append(" sysNetType=");
          if (localNetworkInfo != null) {
            break label541;
          }
          paramNetworkInfo = "null";
          QLog.i((String)localObject, 1, paramNetworkInfo + " android=" + Build.VERSION.SDK_INT + "_" + Build.VERSION.RELEASE + " vendor=" + Build.MANUFACTURER + "_" + Build.MODEL + " connexp=true");
          localObject = new HashMap();
          if (localNetworkInfo != null) {
            break label553;
          }
          paramNetworkInfo = "null";
          ((HashMap)localObject).put("sysNetworkInfo", String.valueOf(paramNetworkInfo));
          ((HashMap)localObject).put("android", String.valueOf(Build.VERSION.SDK_INT + "_" + Build.VERSION.RELEASE));
          ((HashMap)localObject).put("vendor", String.valueOf(Build.MANUFACTURER + "_" + Build.MODEL));
          ((HashMap)localObject).put("connexp", String.valueOf(true));
          paramNetworkInfo = new RdmReq();
          paramNetworkInfo.eventName = "CheckNetIsValid2";
          paramNetworkInfo.elapse = (System.currentTimeMillis() - l1);
          paramNetworkInfo.isSucceed = true;
          paramNetworkInfo.isRealTime = true;
          paramNetworkInfo.params = ((Map)localObject);
        }
        try
        {
          paramNetworkInfo = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramNetworkInfo);
          MsfServiceSdk.get().sendMsg(paramNetworkInfo);
          return;
        }
        catch (Exception paramNetworkInfo)
        {
          paramNetworkInfo.printStackTrace();
        }
        n = 0;
      }
      catch (Exception paramNetworkInfo)
      {
        for (;;)
        {
          paramNetworkInfo.printStackTrace();
          continue;
          label541:
          paramNetworkInfo = Integer.valueOf(localNetworkInfo.getType());
          continue;
          label553:
          paramNetworkInfo = Integer.valueOf(localNetworkInfo.getType());
        }
      }
    }
  }
  
  public boolean a(NetworkInfo paramNetworkInfo)
  {
    return this.f.a(paramNetworkInfo);
  }
  
  public boolean a(INetEventHandler paramINetEventHandler)
  {
    Object localObject;
    if (paramINetEventHandler == null)
    {
      localObject = new Exception("unRegisterNetEventHandler null");
      QLog.d(e, 1, "unRegisterNetEventHandler " + MsfSdkUtils.getStackTraceString((Throwable)localObject));
      if (paramINetEventHandler != null) {
        return this.j.remove(paramINetEventHandler);
      }
    }
    else
    {
      String str = e;
      StringBuilder localStringBuilder = new StringBuilder().append("unRegisterNetInfoHandler ");
      if (paramINetEventHandler == null) {}
      for (localObject = "null";; localObject = Integer.toHexString(paramINetEventHandler.hashCode()))
      {
        QLog.d(str, 1, (String)localObject);
        break;
      }
    }
    return false;
  }
  
  public boolean a(INetInfoHandler paramINetInfoHandler)
  {
    Object localObject;
    if (paramINetInfoHandler == null)
    {
      localObject = new Exception("unRegisterNetInfoHandler null");
      QLog.d(e, 1, "unRegisterNetInfoHandler " + MsfSdkUtils.getStackTraceString((Throwable)localObject));
      if (paramINetInfoHandler != null)
      {
        boolean bool = this.i.remove(paramINetInfoHandler);
        if (!bool)
        {
          QLog.d(e, 1, "unRegisterNetInfoHandler failed memory leak: " + paramINetInfoHandler);
          paramINetInfoHandler = new Exception("unRegisterNetInfoHandler do not exist object");
          QLog.d(e, 1, "unRegisterNetInfoHandler " + MsfSdkUtils.getStackTraceString(paramINetInfoHandler));
        }
        return bool;
      }
    }
    else
    {
      String str = e;
      StringBuilder localStringBuilder = new StringBuilder().append("unRegisterNetInfoHandler ");
      if (paramINetInfoHandler == null) {}
      for (localObject = "null";; localObject = Integer.toHexString(paramINetInfoHandler.hashCode()))
      {
        QLog.d(str, 1, (String)localObject);
        break;
      }
    }
    return false;
  }
  
  public a b()
  {
    return this.f;
  }
  
  public String c()
  {
    return this.f.l();
  }
  
  public boolean d()
  {
    return this.f.a();
  }
  
  public boolean e()
  {
    return this.f.b();
  }
  
  public int f()
  {
    return this.f.c();
  }
  
  public int g()
  {
    return this.f.d();
  }
  
  public boolean h()
  {
    return this.f.e();
  }
  
  public NetworkInfo i()
  {
    return this.f.f();
  }
  
  public int j()
  {
    int n = 0;
    if (d()) {
      n = this.f.i();
    }
    while (!e()) {
      return n;
    }
    return this.f.g() + 10000;
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d(e, 2, "release");
    }
    BaseApplication.getContext().unregisterReceiver(this.m);
    this.f.a(null);
    this.f.a(null);
    this.f.a(null);
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(e, 2, "onNetChangeEvent " + paramBoolean);
    }
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
    {
      INetEventHandler localINetEventHandler = (INetEventHandler)localIterator.next();
      if (localINetEventHandler != null) {
        localINetEventHandler.onNetChangeEvent(paramBoolean);
      }
    }
  }
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d(e, 2, "onNetMobile2None");
    }
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      INetInfoHandler localINetInfoHandler = (INetInfoHandler)localIterator.next();
      if (localINetInfoHandler != null) {
        localINetInfoHandler.onNetMobile2None();
      }
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(e, 2, "onNetMobile2Wifi " + paramString);
    }
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      INetInfoHandler localINetInfoHandler = (INetInfoHandler)localIterator.next();
      if (localINetInfoHandler != null) {
        localINetInfoHandler.onNetMobile2Wifi(paramString);
      }
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(e, 2, "onNetNone2Mobile " + paramString);
    }
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      INetInfoHandler localINetInfoHandler = (INetInfoHandler)localIterator.next();
      if (localINetInfoHandler != null) {
        localINetInfoHandler.onNetNone2Mobile(paramString);
      }
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(e, 2, "onNetNone2Wifi " + paramString);
    }
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      INetInfoHandler localINetInfoHandler = (INetInfoHandler)localIterator.next();
      if (localINetInfoHandler != null) {
        localINetInfoHandler.onNetNone2Wifi(paramString);
      }
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(e, 2, "onNetWifi2Mobile " + paramString);
    }
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      INetInfoHandler localINetInfoHandler = (INetInfoHandler)localIterator.next();
      if (localINetInfoHandler != null) {
        localINetInfoHandler.onNetWifi2Mobile(paramString);
      }
    }
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d(e, 2, "onNetWifi2None");
    }
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      INetInfoHandler localINetInfoHandler = (INetInfoHandler)localIterator.next();
      if (localINetInfoHandler != null) {
        localINetInfoHandler.onNetWifi2None();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.d
 * JD-Core Version:    0.7.0.1
 */