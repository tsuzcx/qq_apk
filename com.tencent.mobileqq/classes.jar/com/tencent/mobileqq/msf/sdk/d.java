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
    if ((QLog.isColorLevel()) && (!h()))
    {
      String str = e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshNetworkIfNot bInit=");
      localStringBuilder.append(this.k.get());
      localStringBuilder.append(" bRefreshing=");
      localStringBuilder.append(this.l.get());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.k.compareAndSet(false, true))
    {
      this.l.set(true);
      a(null, false);
      return;
    }
    if (((!h()) || ((h()) && (i() == null))) && (System.currentTimeMillis() - d >= 5000L) && (this.l.compareAndSet(false, true)))
    {
      d = System.currentTimeMillis();
      a(null, true);
    }
  }
  
  public void a(Context paramContext, INetEventHandler paramINetEventHandler)
  {
    String str = e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("registerNetEventHandler ");
    if (paramINetEventHandler == null) {
      paramContext = "null";
    } else {
      paramContext = Integer.toHexString(paramINetEventHandler.hashCode());
    }
    localStringBuilder.append(paramContext);
    QLog.d(str, 1, localStringBuilder.toString());
    if (paramINetEventHandler != null) {
      this.j.addIfAbsent(paramINetEventHandler);
    }
  }
  
  public void a(Context paramContext, INetInfoHandler paramINetInfoHandler)
  {
    String str = e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("registerNetInfoHandler ");
    if (paramINetInfoHandler == null) {
      paramContext = "null";
    } else {
      paramContext = Integer.toHexString(paramINetInfoHandler.hashCode());
    }
    localStringBuilder.append(paramContext);
    QLog.d(str, 1, localStringBuilder.toString());
    if (paramINetInfoHandler != null) {
      this.i.addIfAbsent(paramINetInfoHandler);
    }
  }
  
  public void a(NetworkInfo paramNetworkInfo, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    boolean bool = h();
    int n;
    if (this.f.f() == null) {
      n = 1;
    } else {
      n = 0;
    }
    this.f.a(BaseApplication.getContext(), paramNetworkInfo);
    if (paramBoolean)
    {
      NetworkInfo localNetworkInfo = this.f.f();
      Object localObject1;
      if ((localNetworkInfo != null) && (localNetworkInfo.getDetailedState() == NetworkInfo.DetailedState.CONNECTED))
      {
        paramNetworkInfo = e;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkNetEvent isNetSupport=");
        ((StringBuilder)localObject1).append(h());
        ((StringBuilder)localObject1).append(", but net detailed state is CONNECTED");
        QLog.i(paramNetworkInfo, 1, ((StringBuilder)localObject1).toString());
        paramNetworkInfo = e;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkNetEvent current netInfo: ");
        ((StringBuilder)localObject1).append(localNetworkInfo);
        QLog.i(paramNetworkInfo, 1, ((StringBuilder)localObject1).toString());
        paramNetworkInfo = new HashMap();
        paramNetworkInfo.put("processName", MsfServiceSdk.get().processName);
        paramNetworkInfo.put("netType", String.valueOf(localNetworkInfo.getType()));
        localObject1 = new RdmReq();
        ((RdmReq)localObject1).eventName = "CheckNetIsValid";
        ((RdmReq)localObject1).elapse = (System.currentTimeMillis() - l1);
        ((RdmReq)localObject1).isSucceed = true;
        ((RdmReq)localObject1).isRealTime = true;
        ((RdmReq)localObject1).params = paramNetworkInfo;
        try
        {
          paramNetworkInfo = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), (RdmReq)localObject1);
          MsfServiceSdk.get().sendMsg(paramNetworkInfo);
        }
        catch (Exception paramNetworkInfo)
        {
          paramNetworkInfo.printStackTrace();
        }
      }
      if ((bool) && (n != 0))
      {
        Object localObject2 = e;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("WARN: checkNetEvent exception, isNetSupport=");
        localStringBuilder.append(bool);
        localStringBuilder.append(" sysNetType=");
        localObject1 = "null";
        if (localNetworkInfo == null) {
          paramNetworkInfo = "null";
        } else {
          paramNetworkInfo = Integer.valueOf(localNetworkInfo.getType());
        }
        localStringBuilder.append(paramNetworkInfo);
        localStringBuilder.append(" android=");
        localStringBuilder.append(Build.VERSION.SDK_INT);
        localStringBuilder.append("_");
        localStringBuilder.append(Build.VERSION.RELEASE);
        localStringBuilder.append(" vendor=");
        localStringBuilder.append(Build.MANUFACTURER);
        localStringBuilder.append("_");
        localStringBuilder.append(Build.MODEL);
        localStringBuilder.append(" connexp=true");
        QLog.i((String)localObject2, 1, localStringBuilder.toString());
        localObject2 = new HashMap();
        if (localNetworkInfo == null) {
          paramNetworkInfo = (NetworkInfo)localObject1;
        } else {
          paramNetworkInfo = Integer.valueOf(localNetworkInfo.getType());
        }
        ((HashMap)localObject2).put("sysNetworkInfo", String.valueOf(paramNetworkInfo));
        paramNetworkInfo = new StringBuilder();
        paramNetworkInfo.append(Build.VERSION.SDK_INT);
        paramNetworkInfo.append("_");
        paramNetworkInfo.append(Build.VERSION.RELEASE);
        ((HashMap)localObject2).put("android", String.valueOf(paramNetworkInfo.toString()));
        paramNetworkInfo = new StringBuilder();
        paramNetworkInfo.append(Build.MANUFACTURER);
        paramNetworkInfo.append("_");
        paramNetworkInfo.append(Build.MODEL);
        ((HashMap)localObject2).put("vendor", String.valueOf(paramNetworkInfo.toString()));
        ((HashMap)localObject2).put("connexp", String.valueOf(true));
        paramNetworkInfo = new RdmReq();
        paramNetworkInfo.eventName = "CheckNetIsValid2";
        paramNetworkInfo.elapse = (System.currentTimeMillis() - l1);
        paramNetworkInfo.isSucceed = true;
        paramNetworkInfo.isRealTime = true;
        paramNetworkInfo.params = ((Map)localObject2);
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
    String str;
    StringBuilder localStringBuilder;
    if (paramINetEventHandler == null)
    {
      localObject = new Exception("unRegisterNetEventHandler null");
      str = e;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("unRegisterNetEventHandler ");
      localStringBuilder.append(MsfSdkUtils.getStackTraceString((Throwable)localObject));
      QLog.d(str, 1, localStringBuilder.toString());
    }
    else
    {
      str = e;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("unRegisterNetInfoHandler ");
      if (paramINetEventHandler == null) {
        localObject = "null";
      } else {
        localObject = Integer.toHexString(paramINetEventHandler.hashCode());
      }
      localStringBuilder.append((String)localObject);
      QLog.d(str, 1, localStringBuilder.toString());
    }
    if (paramINetEventHandler != null) {
      return this.j.remove(paramINetEventHandler);
    }
    return false;
  }
  
  public boolean a(INetInfoHandler paramINetInfoHandler)
  {
    Object localObject1;
    Object localObject2;
    StringBuilder localStringBuilder;
    if (paramINetInfoHandler == null)
    {
      localObject1 = new Exception("unRegisterNetInfoHandler null");
      localObject2 = e;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("unRegisterNetInfoHandler ");
      localStringBuilder.append(MsfSdkUtils.getStackTraceString((Throwable)localObject1));
      QLog.d((String)localObject2, 1, localStringBuilder.toString());
    }
    else
    {
      localObject2 = e;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("unRegisterNetInfoHandler ");
      if (paramINetInfoHandler == null) {
        localObject1 = "null";
      } else {
        localObject1 = Integer.toHexString(paramINetInfoHandler.hashCode());
      }
      localStringBuilder.append((String)localObject1);
      QLog.d((String)localObject2, 1, localStringBuilder.toString());
    }
    if (paramINetInfoHandler != null)
    {
      boolean bool = this.i.remove(paramINetInfoHandler);
      if (!bool)
      {
        localObject1 = e;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("unRegisterNetInfoHandler failed memory leak: ");
        ((StringBuilder)localObject2).append(paramINetInfoHandler);
        QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        paramINetInfoHandler = new Exception("unRegisterNetInfoHandler do not exist object");
        localObject1 = e;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("unRegisterNetInfoHandler ");
        ((StringBuilder)localObject2).append(MsfSdkUtils.getStackTraceString(paramINetInfoHandler));
        QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      return bool;
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
    if (d()) {
      return this.f.i();
    }
    if (e()) {
      return this.f.g() + 10000;
    }
    return 0;
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
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onNetChangeEvent ");
      ((StringBuilder)localObject2).append(paramBoolean);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.j.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (INetEventHandler)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((INetEventHandler)localObject2).onNetChangeEvent(paramBoolean);
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
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onNetMobile2Wifi ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.i.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (INetInfoHandler)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((INetInfoHandler)localObject2).onNetMobile2Wifi(paramString);
      }
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onNetNone2Mobile ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.i.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (INetInfoHandler)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((INetInfoHandler)localObject2).onNetNone2Mobile(paramString);
      }
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onNetNone2Wifi ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.i.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (INetInfoHandler)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((INetInfoHandler)localObject2).onNetNone2Wifi(paramString);
      }
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onNetWifi2Mobile ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.i.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (INetInfoHandler)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((INetInfoHandler)localObject2).onNetWifi2Mobile(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.d
 * JD-Core Version:    0.7.0.1
 */