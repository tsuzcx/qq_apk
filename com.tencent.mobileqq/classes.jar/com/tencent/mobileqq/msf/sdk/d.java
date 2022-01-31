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
import com.tencent.mobileqq.msf.sdk.a.a.d;
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
  public static final String a = "com.tencent.mobileqq.msf.bd.netchange";
  public static long b;
  private static String c = "MSF.D.AppNetInfoNewImpl";
  private a d = new a();
  private Handler e;
  private HandlerThread f;
  private CopyOnWriteArrayList g = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList h = new CopyOnWriteArrayList();
  private AtomicBoolean i = new AtomicBoolean(false);
  private AtomicBoolean j = new AtomicBoolean(false);
  private BroadcastReceiver k = new e(this);
  
  public d()
  {
    this.d.a(this);
    this.d.a(this);
    this.d.a(new a(null));
    this.f = new HandlerThread("AppNetHandlerThread");
    this.f.start();
    this.e = new Handler(this.f.getLooper());
    this.d.a(this.e);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.msf.bd.netchange");
    BaseApplication.getContext().registerReceiver(this.k, localIntentFilter);
    a();
  }
  
  public void a()
  {
    if ((QLog.isColorLevel()) && (!h())) {
      QLog.d(c, 2, "refreshNetworkIfNot bInit=" + this.i.get() + " bRefreshing=" + this.j.get());
    }
    if (this.i.compareAndSet(false, true))
    {
      this.j.set(true);
      a(null, false);
    }
    while (((h()) && ((!h()) || (i() != null))) || (System.currentTimeMillis() - b < 5000L) || (!this.j.compareAndSet(false, true))) {
      return;
    }
    b = System.currentTimeMillis();
    a(null, true);
  }
  
  public void a(Context paramContext, INetEventHandler paramINetEventHandler)
  {
    String str = c;
    StringBuilder localStringBuilder = new StringBuilder().append("registerNetEventHandler ");
    if (paramINetEventHandler == null) {}
    for (paramContext = "null";; paramContext = Integer.toHexString(paramINetEventHandler.hashCode()))
    {
      QLog.d(str, 1, paramContext);
      if (paramINetEventHandler != null) {
        this.h.addIfAbsent(paramINetEventHandler);
      }
      return;
    }
  }
  
  public void a(Context paramContext, INetInfoHandler paramINetInfoHandler)
  {
    String str = c;
    StringBuilder localStringBuilder = new StringBuilder().append("registerNetInfoHandler ");
    if (paramINetInfoHandler == null) {}
    for (paramContext = "null";; paramContext = Integer.toHexString(paramINetInfoHandler.hashCode()))
    {
      QLog.d(str, 1, paramContext);
      if (paramINetInfoHandler != null) {
        this.g.addIfAbsent(paramINetInfoHandler);
      }
      return;
    }
  }
  
  public void a(NetworkInfo paramNetworkInfo, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    boolean bool = h();
    int m;
    if (this.d.f() == null) {
      m = 1;
    }
    for (;;)
    {
      this.d.a(BaseApplication.getContext(), paramNetworkInfo);
      NetworkInfo localNetworkInfo;
      Object localObject;
      if (paramBoolean)
      {
        localNetworkInfo = this.d.f();
        if ((localNetworkInfo != null) && (localNetworkInfo.getDetailedState() == NetworkInfo.DetailedState.CONNECTED))
        {
          QLog.i(c, 1, "checkNetEvent isNetSupport=" + h() + ", but net detailed state is CONNECTED");
          QLog.i(c, 1, "checkNetEvent current netInfo: " + localNetworkInfo);
          paramNetworkInfo = new HashMap();
          paramNetworkInfo.put("processName", MsfServiceSdk.get().processName);
          paramNetworkInfo.put("netType", String.valueOf(localNetworkInfo.getType()));
          localObject = new RdmReq();
          ((RdmReq)localObject).eventName = "CheckNetIsValid";
          ((RdmReq)localObject).elapse = (System.currentTimeMillis() - l);
          ((RdmReq)localObject).isSucceed = true;
          ((RdmReq)localObject).isRealTime = true;
          ((RdmReq)localObject).params = paramNetworkInfo;
        }
      }
      try
      {
        paramNetworkInfo = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), (RdmReq)localObject);
        MsfServiceSdk.get().sendMsg(paramNetworkInfo);
        if ((bool) && (m != 0))
        {
          localObject = c;
          StringBuilder localStringBuilder = new StringBuilder().append("WARN: checkNetEvent exception, isNetSupport=").append(bool).append(" sysNetType=");
          if (localNetworkInfo != null) {
            break label540;
          }
          paramNetworkInfo = "null";
          QLog.i((String)localObject, 1, paramNetworkInfo + " android=" + Build.VERSION.SDK_INT + "_" + Build.VERSION.RELEASE + " vendor=" + Build.MANUFACTURER + "_" + Build.MODEL + " connexp=true");
          localObject = new HashMap();
          if (localNetworkInfo != null) {
            break label552;
          }
          paramNetworkInfo = "null";
          ((HashMap)localObject).put("sysNetworkInfo", String.valueOf(paramNetworkInfo));
          ((HashMap)localObject).put("android", String.valueOf(Build.VERSION.SDK_INT + "_" + Build.VERSION.RELEASE));
          ((HashMap)localObject).put("vendor", String.valueOf(Build.MANUFACTURER + "_" + Build.MODEL));
          ((HashMap)localObject).put("connexp", String.valueOf(true));
          paramNetworkInfo = new RdmReq();
          paramNetworkInfo.eventName = "CheckNetIsValid2";
          paramNetworkInfo.elapse = (System.currentTimeMillis() - l);
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
        m = 0;
      }
      catch (Exception paramNetworkInfo)
      {
        for (;;)
        {
          paramNetworkInfo.printStackTrace();
          continue;
          label540:
          paramNetworkInfo = Integer.valueOf(localNetworkInfo.getType());
          continue;
          label552:
          paramNetworkInfo = Integer.valueOf(localNetworkInfo.getType());
        }
      }
    }
  }
  
  public boolean a(NetworkInfo paramNetworkInfo)
  {
    return this.d.a(paramNetworkInfo);
  }
  
  public boolean a(INetEventHandler paramINetEventHandler)
  {
    Object localObject;
    if (paramINetEventHandler == null)
    {
      localObject = new Exception("unRegisterNetEventHandler null");
      QLog.d(c, 1, "unRegisterNetEventHandler " + MsfSdkUtils.getStackTraceString((Throwable)localObject));
      if (paramINetEventHandler != null) {
        return this.h.remove(paramINetEventHandler);
      }
    }
    else
    {
      String str = c;
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
      QLog.d(c, 1, "unRegisterNetInfoHandler " + MsfSdkUtils.getStackTraceString((Throwable)localObject));
      if (paramINetInfoHandler != null)
      {
        boolean bool = this.g.remove(paramINetInfoHandler);
        if (!bool)
        {
          QLog.d(c, 1, "unRegisterNetInfoHandler failed memory leak: " + paramINetInfoHandler);
          paramINetInfoHandler = new Exception("unRegisterNetInfoHandler do not exist object");
          QLog.d(c, 1, "unRegisterNetInfoHandler " + MsfSdkUtils.getStackTraceString(paramINetInfoHandler));
        }
        return bool;
      }
    }
    else
    {
      String str = c;
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
    return this.d;
  }
  
  public String c()
  {
    return this.d.l();
  }
  
  public boolean d()
  {
    return this.d.a();
  }
  
  public boolean e()
  {
    return this.d.b();
  }
  
  public int f()
  {
    return this.d.c();
  }
  
  public int g()
  {
    return this.d.d();
  }
  
  public boolean h()
  {
    return this.d.e();
  }
  
  public NetworkInfo i()
  {
    return this.d.f();
  }
  
  public int j()
  {
    int m = 0;
    if (d()) {
      m = this.d.i();
    }
    while (!e()) {
      return m;
    }
    return this.d.g() + 10000;
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "release");
    }
    BaseApplication.getContext().unregisterReceiver(this.k);
    this.d.a(null);
    this.d.a(null);
    this.d.a(null);
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "onNetChangeEvent " + paramBoolean);
    }
    Iterator localIterator = this.h.iterator();
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
      QLog.d(c, 2, "onNetMobile2None");
    }
    Iterator localIterator = this.g.iterator();
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
      QLog.d(c, 2, "onNetMobile2Wifi " + paramString);
    }
    Iterator localIterator = this.g.iterator();
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
      QLog.d(c, 2, "onNetNone2Mobile " + paramString);
    }
    Iterator localIterator = this.g.iterator();
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
      QLog.d(c, 2, "onNetNone2Wifi " + paramString);
    }
    Iterator localIterator = this.g.iterator();
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
      QLog.d(c, 2, "onNetWifi2Mobile " + paramString);
    }
    Iterator localIterator = this.g.iterator();
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
      QLog.d(c, 2, "onNetWifi2None");
    }
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      INetInfoHandler localINetInfoHandler = (INetInfoHandler)localIterator.next();
      if (localINetInfoHandler != null) {
        localINetInfoHandler.onNetWifi2None();
      }
    }
  }
  
  private class a
    extends a.d
  {
    private a() {}
    
    public void b()
    {
      d.a(d.this).set(true);
      if (QLog.isColorLevel()) {
        QLog.d(d.l(), 2, "startRefresh ");
      }
    }
    
    public void c()
    {
      d.a(d.this).set(false);
      if (QLog.isColorLevel()) {
        QLog.d(d.l(), 2, "refreshFinished ");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.d
 * JD-Core Version:    0.7.0.1
 */