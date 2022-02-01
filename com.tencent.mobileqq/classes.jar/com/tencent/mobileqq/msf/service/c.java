package com.tencent.mobileqq.msf.service;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.push.g;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class c
{
  private static final String l = "MSF.S.AppProcessInfo";
  volatile boolean a = true;
  volatile long b = 0L;
  volatile boolean c = false;
  volatile long d = 0L;
  volatile boolean e = false;
  volatile long f = 0L;
  String g;
  String h;
  ConcurrentLinkedQueue i = new ConcurrentLinkedQueue();
  public v j = null;
  volatile boolean k = false;
  private IMsfServiceCallbacker m;
  private IBinder.DeathRecipient n;
  private final Object o = new Object();
  
  private void b(IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    synchronized (this.o)
    {
      c(paramIMsfServiceCallbacker);
      return;
    }
  }
  
  private void c(IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    e();
    this.m = paramIMsfServiceCallbacker;
    d();
  }
  
  private void d()
  {
    try
    {
      if (this.m != null)
      {
        if (this.n == null) {
          this.n = new d(this);
        }
        this.m.asBinder().linkToDeath(this.n, 0);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MSF.S.AppProcessInfo", 1, "registerCallbackDeathRecipient fail.", localThrowable);
    }
  }
  
  private void e()
  {
    try
    {
      if ((this.m != null) && (this.n != null)) {
        this.m.asBinder().unlinkToDeath(this.n, 0);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MSF.S.AppProcessInfo", 1, "unregisterCallbackDeathRecipient fail.", localThrowable);
    }
  }
  
  public String a()
  {
    return this.g + "," + b() + "," + this.a;
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (this.j != null) {
      this.j.a(paramInt, paramLong1, paramLong2);
    }
  }
  
  public void a(int paramInt, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getUin();
    if (this.j != null) {
      this.j.a(paramInt);
    }
    while ((paramInt != 0) || (TextUtils.isEmpty(this.h))) {
      return;
    }
    paramInt = e.e.getUinPushStatus(str);
    u.a(BaseApplication.getContext(), this.g, str, this.h, paramInt, paramFromServiceMsg);
    MsfService.getCore().pushManager.j.a();
  }
  
  public void a(IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    if ((paramIMsfServiceCallbacker == this.m) && (paramIMsfServiceCallbacker != null)) {
      synchronized (this.o)
      {
        if (paramIMsfServiceCallbacker == this.m)
        {
          c(null);
          this.a = false;
          this.c = false;
          this.k = false;
          QLog.d("MSF.S.AppProcessInfo", 1, String.format("setAppDisConnected appProcessName = %s, isAppConnected = %s, halfCloseStatus = %s, keepProcessAlive = %s, preCallback = %s", new Object[] { this.g, Boolean.valueOf(this.a), Boolean.valueOf(this.c), Boolean.valueOf(this.k), Integer.toHexString(paramIMsfServiceCallbacker.hashCode()) }));
        }
        return;
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.i.add(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
    e.d.a();
  }
  
  public void a(Exception paramException, boolean paramBoolean) {}
  
  public void a(String paramString)
  {
    this.h = paramString;
  }
  
  public void a(String paramString1, String paramString2, IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    this.g = paramString1;
    a(paramString2);
    if (paramIMsfServiceCallbacker != null)
    {
      b(paramIMsfServiceCallbacker);
      this.a = true;
    }
    for (;;)
    {
      this.d = 0L;
      this.c = false;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.S.AppProcessInfo", 2, String.format("onAppBind appProcessName=%s isAppConnected=%s halfCloseStatus=%s keepProcessAlive=%s", new Object[] { paramString1, Boolean.valueOf(this.a), Boolean.valueOf(this.c), Boolean.valueOf(this.k) }));
      }
      if ((MsfService.getCore() != null) && (MsfService.getCore().getStatReporter() != null))
      {
        paramString2 = new HashMap();
        paramString2.put("appProcessName", paramString1);
        if (MsfService.getCore().getStatReporter() != null) {
          MsfService.getCore().getStatReporter().a("dim.Msf.AppConnectFail", this.a, 0L, 0L, paramString2, false, false);
        }
      }
      if (this.j != null) {
        this.j.a(paramIMsfServiceCallbacker);
      }
      return;
      if (c() == null) {
        this.a = false;
      } else {
        this.a = true;
      }
    }
  }
  
  public String b()
  {
    return this.h;
  }
  
  public IMsfServiceCallbacker c()
  {
    return this.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.c
 * JD-Core Version:    0.7.0.1
 */