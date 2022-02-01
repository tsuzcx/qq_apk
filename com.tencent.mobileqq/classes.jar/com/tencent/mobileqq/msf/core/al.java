package com.tencent.mobileqq.msf.core;

import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.a.g.a;
import com.tencent.mobileqq.msf.core.d.j.a;
import com.tencent.mobileqq.msf.core.net.j;
import com.tencent.mobileqq.msf.core.net.x;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class al
  extends j.a
{
  public static final String a = "WeaknetNew";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 4;
  public static final int e = 8;
  public static final int f = 16;
  public static final int g = 32;
  public static final int h = 64;
  private static final String o = "dim_msf_EvtWeakNetworkNetConnQuality";
  private static final String p = "dim_msf_EvtWeakNetworkNetChatMsgCost";
  private static g.a z = ;
  private boolean A = false;
  private al.f B = null;
  public al.e i = new al.e(this);
  public al.a j = new al.a(this);
  public al.a k = new al.a(this);
  public al.a l = new al.a(this);
  public al.a m = new al.a(this);
  private final Handler q = q.b();
  private boolean r = true;
  private boolean s = false;
  private int t = 0;
  private WeakReference u = null;
  private WeakReference v = null;
  private WeakReference w = null;
  private WeakReference x = null;
  private int y = -1;
  
  public static al a()
  {
    return al.d.a();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 0) && (paramInt2 > 0))
    {
      localObject = new StringBuffer(128);
      ((StringBuffer)localObject).append(Thread.currentThread().getName());
      ((StringBuffer)localObject).append(" WeaknetChanged ");
      ((StringBuffer)localObject).append(b(paramInt3));
      ((StringBuffer)localObject).append(", Normal to Weaknet, reason:(");
      ((StringBuffer)localObject).append(Integer.toHexString(paramInt1));
      ((StringBuffer)localObject).append(", ");
      ((StringBuffer)localObject).append(Integer.toHexString(paramInt2));
      ((StringBuffer)localObject).append(")");
      QLog.i("WeaknetNew", 1, ((StringBuffer)localObject).toString());
      b(paramInt1, paramInt2, paramInt3);
      localObject = this.B;
      if (localObject != null) {
        ((al.f)localObject).a(paramInt2);
      }
      i();
      this.r = true;
      q();
      this.i.p = com.tencent.mobileqq.msf.sdk.a.a.a(BaseApplication.getContext());
      this.i.t = SystemClock.elapsedRealtime();
      this.i.v = r();
      return;
    }
    if ((paramInt1 > 0) && (paramInt2 == 0))
    {
      localObject = new StringBuffer(128);
      ((StringBuffer)localObject).append(Thread.currentThread().getName());
      ((StringBuffer)localObject).append(" WeaknetChanged ");
      ((StringBuffer)localObject).append(b(paramInt3));
      ((StringBuffer)localObject).append(", Weaknet to Normal, reason:(");
      ((StringBuffer)localObject).append(Integer.toHexString(paramInt1));
      ((StringBuffer)localObject).append(", ");
      ((StringBuffer)localObject).append(Integer.toHexString(paramInt2));
      ((StringBuffer)localObject).append(")");
      QLog.i("WeaknetNew", 1, ((StringBuffer)localObject).toString());
      b(paramInt1, paramInt2, paramInt3);
      localObject = this.B;
      if (localObject != null) {
        ((al.f)localObject).b(paramInt1);
      }
      this.r = false;
      this.i.u = SystemClock.elapsedRealtime();
      j();
      k();
      return;
    }
    if ((paramInt1 > 0) && (paramInt2 > 0) && (paramInt1 != paramInt2))
    {
      localObject = new StringBuffer(128);
      ((StringBuffer)localObject).append(Thread.currentThread().getName());
      ((StringBuffer)localObject).append(" WeaknetChanged ");
      ((StringBuffer)localObject).append(b(paramInt3));
      ((StringBuffer)localObject).append(", Weaknet to Weaknet, reason:(");
      ((StringBuffer)localObject).append(Integer.toHexString(paramInt1));
      ((StringBuffer)localObject).append(", ");
      ((StringBuffer)localObject).append(Integer.toHexString(paramInt2));
      ((StringBuffer)localObject).append(")");
      QLog.i("WeaknetNew", 1, ((StringBuffer)localObject).toString());
      q();
      return;
    }
    Object localObject = new StringBuffer(128);
    ((StringBuffer)localObject).append(Thread.currentThread().getName());
    ((StringBuffer)localObject).append("WeaknetChanged ");
    ((StringBuffer)localObject).append(b(paramInt3));
    ((StringBuffer)localObject).append(", unknow to unknow, reason:(");
    ((StringBuffer)localObject).append(Integer.toHexString(paramInt1));
    ((StringBuffer)localObject).append(", ");
    ((StringBuffer)localObject).append(Integer.toHexString(paramInt2));
    ((StringBuffer)localObject).append(")");
    QLog.i("WeaknetNew", 1, ((StringBuffer)localObject).toString());
    b(paramInt1, paramInt2, paramInt3);
    q();
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, boolean paramBoolean, long paramLong) {}
  
  public static void a(String paramString)
  {
    FromServiceMsg localFromServiceMsg = new FromServiceMsg(NetConnInfoCenter.msfCore.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_connWeakNet_New");
    localFromServiceMsg.setMsgSuccess();
    localFromServiceMsg.setMsfCommand(MsfCommand.onConnWeakNetNew);
    localFromServiceMsg.setBusinessFail(0, paramString);
    MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
    NetConnInfoCenter.msfCore.addRespToQuque(null, localFromServiceMsg);
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3) {}
  
  private boolean b(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
  
  private void c(int paramInt)
  {
    for (;;)
    {
      int n;
      try
      {
        n = this.t;
        if (1 == paramInt)
        {
          if ((this.i.e <= 0L) || (this.i.e <= z.c)) {
            break label302;
          }
          n |= 0x1;
        }
        else if (2 == paramInt)
        {
          if (this.i.h - this.i.g <= z.d) {
            break label310;
          }
          n |= 0x2;
        }
        else if (4 == paramInt)
        {
          if ((this.i.j < z.e) || (this.i.k < z.f)) {
            break label318;
          }
          n |= 0x4;
        }
        else if (8 == paramInt)
        {
          if (this.i.m <= 0L) {
            break label326;
          }
          if (this.i.m >= this.i.o) {
            n |= 0x8;
          } else if (this.i.m <= this.i.n) {
            break label356;
          }
        }
        else if (16 == paramInt)
        {
          if ((this.i.p == 0) || (Math.abs(this.i.p) >= z.h)) {
            break label334;
          }
          n |= 0x10;
        }
        else
        {
          if (32 != paramInt) {
            break label350;
          }
          if (this.i.r <= z.i) {
            break label342;
          }
          n |= 0x20;
        }
        if (n != this.t) {
          a(this.t, n, paramInt);
        }
        this.t = n;
        return;
      }
      finally {}
      label302:
      n &= 0xFFFFFFFE;
      continue;
      label310:
      n &= 0xFFFFFFFD;
      continue;
      label318:
      n &= 0xFFFFFFFB;
      continue;
      label326:
      n &= 0xFFFFFFF7;
      continue;
      label334:
      n &= 0xFFFFFFEF;
      continue;
      label342:
      n &= 0xFFFFFFDF;
      continue;
      label350:
      if (64 == paramInt) {
        label356:
        n = 0;
      }
    }
  }
  
  private void i()
  {
    this.k.a();
    this.m.a();
    this.j.a();
    this.l.a();
  }
  
  private void j()
  {
    h();
    if (c())
    {
      long l1 = this.k.b;
      long l2 = this.m.b;
      long l3 = this.i.u - this.i.t;
      a("weaknetReason", String.valueOf(Integer.toHexString(this.t)));
      a("weaknetCost", String.valueOf(l3));
      a("sendTotal", String.valueOf(this.j.a));
      a("ssoCount", String.valueOf(this.k.a));
      a("ssoAvgCost", String.valueOf(l1));
      a("msgSendTotal", String.valueOf(this.l.a));
      a("msgCount", String.valueOf(this.m.a));
      a("msgAvgCost", String.valueOf(l2));
      a("screen", String.valueOf(this.y));
      a("connCost", String.valueOf(this.i.e));
      a("pingCost", String.valueOf(this.i.h - this.i.g));
      a("Trtt", String.valueOf(this.i.l));
      a("RTTm", String.valueOf(this.i.m));
      a("wifiSignal", String.valueOf(this.i.p));
      Object localObject = this.i.q;
      String str = "null";
      if (localObject == null) {
        localObject = "null";
      } else {
        localObject = this.i.q;
      }
      a("ssid", (String)localObject);
      if (this.i.v == null) {
        localObject = str;
      } else {
        localObject = this.i.v;
      }
      a("networks", (String)localObject);
      a("type", String.valueOf(z.a));
      a("isCrossOper", String.valueOf(com.tencent.mobileqq.a.a.a.b));
      boolean bool;
      if (this.t > 0) {
        bool = true;
      } else {
        bool = false;
      }
      a("dim_msf_EvtWeakNetworkNetConnQuality", bool, l3, 0L);
      if (this.t > 0) {
        bool = true;
      } else {
        bool = false;
      }
      a("EvtWeakNetwork", bool, l3, 0L);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("report EventCode=dim_msf_EvtWeakNetworkNetConnQuality reason=");
        ((StringBuilder)localObject).append(Integer.toHexString(this.t));
        ((StringBuilder)localObject).append(" weaknetCost=");
        ((StringBuilder)localObject).append(this.i.u - this.i.t);
        ((StringBuilder)localObject).append(" screen=");
        ((StringBuilder)localObject).append(this.y);
        ((StringBuilder)localObject).append(" connCost=");
        ((StringBuilder)localObject).append(this.i.e);
        ((StringBuilder)localObject).append(" pingCost=");
        ((StringBuilder)localObject).append(this.i.h - this.i.g);
        ((StringBuilder)localObject).append(" wifiSig=");
        ((StringBuilder)localObject).append(this.i.p);
        ((StringBuilder)localObject).append(" ssoTotal=");
        ((StringBuilder)localObject).append(this.j.a);
        ((StringBuilder)localObject).append(" ssoSucc=");
        ((StringBuilder)localObject).append(this.k.a);
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append(this.j.a);
        ((StringBuilder)localObject).append(" msgSucc=");
        ((StringBuilder)localObject).append(this.m.a);
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append(this.l.a);
        ((StringBuilder)localObject).append(" ssoAvgCost=");
        ((StringBuilder)localObject).append(this.k.b);
        ((StringBuilder)localObject).append(" msgAvgCost=");
        ((StringBuilder)localObject).append(this.m.b);
        QLog.d("WeaknetNew", 2, ((StringBuilder)localObject).toString());
      }
    }
    i();
  }
  
  private void k()
  {
    if (this.i.a)
    {
      Object localObject1 = this.w;
      if ((localObject1 == null) || (((WeakReference)localObject1).get() == null)) {}
      try
      {
        if ((this.w == null) || (this.w.get() == null)) {
          this.w = new WeakReference(new al.h(this, null));
        }
        if (this.w.get() != null)
        {
          l();
          ((al.h)this.w.get()).d = false;
          this.q.postDelayed((Runnable)this.w.get(), z.g);
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(Thread.currentThread().getName());
          ((StringBuilder)localObject1).append(" startWeakNetworkSsoCheck wifiConned=");
          ((StringBuilder)localObject1).append(this.i.a);
          QLog.d("WeaknetNew", 2, ((StringBuilder)localObject1).toString());
          return;
        }
      }
      finally {}
    }
  }
  
  private void l()
  {
    Object localObject = this.w;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      ((al.h)this.w.get()).d = true;
      this.q.removeCallbacks((Runnable)this.w.get());
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(Thread.currentThread().getName());
        ((StringBuilder)localObject).append(" stopWeakNetworkSsoCheck");
        QLog.d("WeaknetNew", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void m()
  {
    if (!a(32))
    {
      Object localObject1 = this.x;
      if ((localObject1 == null) || (((WeakReference)localObject1).get() == null)) {}
      try
      {
        if ((this.x == null) || (this.x.get() == null)) {
          this.x = new WeakReference(new al.g(this, null));
        }
        if (((al.g)this.x.get()).a.compareAndSet(false, true))
        {
          n();
          ((al.g)this.x.get()).b = false;
          this.q.postDelayed((Runnable)this.x.get(), z.i);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(Thread.currentThread().getName());
            ((StringBuilder)localObject1).append(" startQuickSendCheck wifiConned=");
            ((StringBuilder)localObject1).append(this.i.a);
            QLog.d("WeaknetNew", 2, ((StringBuilder)localObject1).toString());
            return;
          }
        }
      }
      finally {}
    }
  }
  
  private void n()
  {
    Object localObject = this.x;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      this.q.removeCallbacks((Runnable)this.x.get());
      ((al.g)this.x.get()).b = true;
      ((al.g)this.x.get()).a.set(false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(Thread.currentThread().getName());
        ((StringBuilder)localObject).append(" stopQuickSendCheck");
        QLog.d("WeaknetNew", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void o()
  {
    if (!a(1))
    {
      Object localObject1 = this.u;
      if ((localObject1 == null) || (((WeakReference)localObject1).get() == null)) {}
      try
      {
        if ((this.u == null) || (this.u.get() == null)) {
          this.u = new WeakReference(new al.c(this));
        }
        if (((al.c)this.u.get()).a.compareAndSet(false, true))
        {
          this.q.removeCallbacks((Runnable)this.u.get());
          this.q.postDelayed((Runnable)this.u.get(), z.c);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(Thread.currentThread().getName());
            ((StringBuilder)localObject1).append(" startConnCheck oldReason=");
            ((StringBuilder)localObject1).append(Integer.toHexString(this.t));
            QLog.d("WeaknetNew", 2, ((StringBuilder)localObject1).toString());
            return;
          }
        }
      }
      finally {}
    }
  }
  
  private void p()
  {
    Object localObject = this.u;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      this.q.removeCallbacks((Runnable)this.u.get());
      ((al.c)this.u.get()).a.set(false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(Thread.currentThread().getName());
        ((StringBuilder)localObject).append(" stopConnCheck");
        QLog.d("WeaknetNew", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void q()
  {
    p();
    n();
    l();
    WeakReference localWeakReference = this.v;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      this.q.removeCallbacks((Runnable)this.v.get());
    }
  }
  
  private String r()
  {
    NetworkInfo[] arrayOfNetworkInfo = j.a();
    if ((arrayOfNetworkInfo != null) && (arrayOfNetworkInfo.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append(arrayOfNetworkInfo.length);
      localStringBuilder.append("#");
      int i1 = arrayOfNetworkInfo.length;
      int n = 0;
      while (n < i1)
      {
        NetworkInfo localNetworkInfo = arrayOfNetworkInfo[n];
        if (localNetworkInfo.getDetailedState() == NetworkInfo.DetailedState.CONNECTED)
        {
          localStringBuilder.append(localNetworkInfo.getTypeName());
          localStringBuilder.append(",");
          localStringBuilder.append(localNetworkInfo.getDetailedState());
          localStringBuilder.append(",");
          localStringBuilder.append(j.a(localNetworkInfo));
          localStringBuilder.append(",");
          boolean bool = localNetworkInfo.isAvailable();
          String str2 = "1";
          String str1;
          if (bool) {
            str1 = "1";
          } else {
            str1 = "0";
          }
          localStringBuilder.append(str1);
          localStringBuilder.append(",");
          if (localNetworkInfo.isFailover()) {
            str1 = str2;
          } else {
            str1 = "0";
          }
          localStringBuilder.append(str1);
          localStringBuilder.append("|");
        }
        n += 1;
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.i.p = ((short)paramInt2);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onWifiSignalChanged old=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" current=");
      localStringBuilder.append(paramInt2);
      QLog.d("WeaknetNew", 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt, long paramLong, x paramx)
  {
    this.i.d = System.currentTimeMillis();
    Object localObject = this.i;
    ((al.e)localObject).e = (((al.e)localObject).d - this.i.c);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onConnFailed type=");
      ((StringBuilder)localObject).append(NetConnInfoCenter.getSystemNetStateString());
      ((StringBuilder)localObject).append(" connTotalCost=");
      ((StringBuilder)localObject).append(this.i.e);
      ((StringBuilder)localObject).append(" connErrCost=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" connError=");
      ((StringBuilder)localObject).append(paramx);
      ((StringBuilder)localObject).append(" oldReason=");
      ((StringBuilder)localObject).append(String.valueOf(Integer.toHexString(this.t)));
      QLog.d("WeaknetNew", 2, ((StringBuilder)localObject).toString());
    }
    c(1);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.i.a)
    {
      if (this.i.f == paramLong1)
      {
        this.i.h = System.currentTimeMillis();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[");
        ((StringBuilder)localObject).append(Thread.currentThread().getName());
        ((StringBuilder)localObject).append("] onPingRecved ssoSeq=");
        ((StringBuilder)localObject).append(paramLong1);
        ((StringBuilder)localObject).append(" pingSend=");
        ((StringBuilder)localObject).append(this.i.g);
        ((StringBuilder)localObject).append(" pingRecv=");
        ((StringBuilder)localObject).append(this.i.h);
        ((StringBuilder)localObject).append(" cost=");
        ((StringBuilder)localObject).append(this.i.h - this.i.g);
        QLog.d("WeaknetNew", 1, ((StringBuilder)localObject).toString());
        localObject = this.v;
        if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
          this.q.removeCallbacks((Runnable)this.v.get());
        }
        c(2);
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("WARN: [");
      ((StringBuilder)localObject).append(Thread.currentThread().getName());
      ((StringBuilder)localObject).append("] onPingRecved sendSsoSeq=");
      ((StringBuilder)localObject).append(this.i.f);
      ((StringBuilder)localObject).append(" recvSsoSeq=");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(" out of order");
      QLog.w("WeaknetNew", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(al.f paramf)
  {
    this.B = paramf;
  }
  
  public void a(com.tencent.qphone.base.a parama)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConnClose reason=");
      localStringBuilder.append(parama);
      localStringBuilder.append(" conn=");
      if (this.i.a) {
        parama = "wifi";
      } else if (this.i.b) {
        parama = "mobile";
      } else {
        parama = "unknown";
      }
      localStringBuilder.append(parama);
      QLog.d("WeaknetNew", 2, localStringBuilder.toString());
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    if (this.i.a)
    {
      Object localObject = this.v;
      if ((localObject == null) || (((WeakReference)localObject).get() == null)) {}
      try
      {
        if ((this.v == null) || (this.v.get() == null)) {
          this.v = new WeakReference(new al.b(this));
        }
        localObject = (al.b)this.v.get();
        al.e locale = this.i;
        long l1 = paramToServiceMsg.getRequestSsoSeq();
        locale.f = l1;
        ((al.b)localObject).b = l1;
        paramToServiceMsg = (al.b)this.v.get();
        localObject = this.i;
        l1 = System.currentTimeMillis();
        ((al.e)localObject).g = l1;
        paramToServiceMsg.a = l1;
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("onPingSent ssoSeq=");
        paramToServiceMsg.append(this.i.f);
        paramToServiceMsg.append(" pingSend=");
        paramToServiceMsg.append(this.i.g);
        QLog.d("WeaknetNew", 1, paramToServiceMsg.toString());
        paramToServiceMsg = this.v;
        if ((paramToServiceMsg != null) && (paramToServiceMsg.get() != null))
        {
          this.q.removeCallbacks((Runnable)this.v.get());
          this.q.postDelayed((Runnable)this.v.get(), 3001L);
          return;
        }
      }
      finally {}
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (this.i.a)
    {
      Object localObject;
      long l1;
      if ((this.r) && (paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
      {
        localObject = paramToServiceMsg.getAttribute("__timestamp_msf2net_for_weaknet");
        if (localObject != null)
        {
          l1 = System.currentTimeMillis() - ((Long)localObject).longValue();
          if (l1 > 0L)
          {
            localObject = this.k;
            ((al.a)localObject).b = (((al.a)localObject).b / (this.k.a + 1) * this.k.a + l1 / (this.k.a + 1));
            localObject = this.k;
            ((al.a)localObject).a += 1;
          }
        }
      }
      if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
      {
        if (c())
        {
          paramToServiceMsg.getAttributes().put("attr_weaknet_sent_flag", Boolean.valueOf(true));
          paramFromServiceMsg.getAttributes().put("attr_weaknet_sent_flag", Boolean.valueOf(true));
        }
        double d1;
        double d2;
        if (((this.i.s > 0) && (paramFromServiceMsg.getRequestSsoSeq() == this.i.s)) || (this.i.i == 0L))
        {
          l1 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net_for_weaknet", Long.valueOf(this.i.d))).longValue();
          this.i.i = (System.currentTimeMillis() - l1);
          if (this.i.i > 0L)
          {
            localObject = this.i;
            d1 = ((al.e)localObject).e;
            Double.isNaN(d1);
            d2 = this.i.i;
            Double.isNaN(d2);
            ((al.e)localObject).l = ((d1 * 0.3D + d2 * 0.7D));
            localObject = this.i;
            ((al.e)localObject).m = ((al.e)localObject).i;
            localObject = this.i;
            ((al.e)localObject).n = Math.max(((al.e)localObject).l * 2L, z.k);
            localObject = this.i;
            ((al.e)localObject).o = Math.max(((al.e)localObject).l * 3L, z.j);
            if ((this.i.n > z.j) || (this.i.o < z.k))
            {
              this.i.n = z.k;
              this.i.o = z.j;
            }
          }
          if (paramFromServiceMsg.getRequestSsoSeq() != this.i.s)
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("WARN: firstSendSsoseq=");
            paramFromServiceMsg.append(this.i.s);
            paramFromServiceMsg.append(" firstRecvSsoSeq=");
            paramFromServiceMsg.append(paramToServiceMsg.getRequestSsoSeq());
            paramFromServiceMsg.append(" out of order");
            QLog.w("WeaknetNew", 1, paramFromServiceMsg.toString());
            this.i.s = paramToServiceMsg.getRequestSsoSeq();
          }
          paramToServiceMsg = new StringBuilder(128);
          paramToServiceMsg.append("onRecvFirst ssoSeq=");
          paramToServiceMsg.append(this.i.s);
          paramToServiceMsg.append(" TC=");
          paramToServiceMsg.append(this.i.e);
          paramToServiceMsg.append(" pingCost=");
          paramToServiceMsg.append(this.i.h - this.i.g);
          paramToServiceMsg.append(" TP=");
          paramToServiceMsg.append(this.i.i);
          paramToServiceMsg.append(" Trtt=");
          paramToServiceMsg.append(this.i.l);
          paramToServiceMsg.append(" Rttm=");
          paramToServiceMsg.append(this.i.m);
          paramToServiceMsg.append(" windows=(");
          paramToServiceMsg.append(this.i.n);
          paramToServiceMsg.append(",");
          paramToServiceMsg.append(this.i.o);
          paramToServiceMsg.append(")");
          QLog.d("WeaknetNew", 1, paramToServiceMsg.toString());
          return;
        }
        if ((this.i.i > 0L) && (paramFromServiceMsg.isSuccess()))
        {
          localObject = paramFromServiceMsg.getAttribute("__timestamp_net2msf");
          paramToServiceMsg = paramToServiceMsg.getAttribute("__timestamp_msf2net_for_weaknet");
          if ((localObject != null) && (paramToServiceMsg != null))
          {
            l1 = ((Long)localObject).longValue() - ((Long)paramToServiceMsg).longValue();
            d1 = this.i.m;
            Double.isNaN(d1);
            d2 = l1;
            Double.isNaN(d2);
            long l2 = (d1 * 0.6D + d2 * 0.4D);
            if ((l1 > 0L) && (l2 > 0L))
            {
              this.i.m = l2;
              int n = this.t;
              c(8);
              if (n != this.t)
              {
                if (!c())
                {
                  paramToServiceMsg = new StringBuilder();
                  paramToServiceMsg.append(Thread.currentThread().getName());
                  paramToServiceMsg.append(" Restore Normal ssoSeq=");
                  paramToServiceMsg.append(paramFromServiceMsg.getRequestSsoSeq());
                  paramToServiceMsg.append(" serviceCmd=");
                  paramToServiceMsg.append(paramFromServiceMsg.getServiceCmd());
                  paramToServiceMsg.append(" RTTm=");
                  paramToServiceMsg.append(this.i.m);
                  QLog.d("WeaknetNew", 1, paramToServiceMsg.toString());
                  return;
                }
                if (a(8))
                {
                  paramToServiceMsg = new StringBuilder();
                  paramToServiceMsg.append(Thread.currentThread().getName());
                  paramToServiceMsg.append(" Enter weaknet ssoSeq=");
                  paramToServiceMsg.append(paramFromServiceMsg.getRequestSsoSeq());
                  paramToServiceMsg.append(" serviceCmd=");
                  paramToServiceMsg.append(paramFromServiceMsg.getServiceCmd());
                  paramToServiceMsg.append(" RTTm=");
                  paramToServiceMsg.append(this.i.m);
                  QLog.d("WeaknetNew", 1, paramToServiceMsg.toString());
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, com.tencent.mobileqq.msf.core.quicksend.g paramg) {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean, int paramInt)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (!TextUtils.isEmpty(paramFromServiceMsg.getUin())) && (!"0".equals(paramFromServiceMsg.getUin())))
    {
      if (!"MessageSvc.PbSendMsg".equals(paramFromServiceMsg.getServiceCmd())) {
        return;
      }
      long l1;
      if ((this.r) && (paramFromServiceMsg.isSuccess()))
      {
        if (c())
        {
          paramToServiceMsg.getAttributes().put("attr_weaknet_sent_flag", Boolean.valueOf(true));
          paramFromServiceMsg.getAttributes().put("attr_weaknet_sent_flag", Boolean.valueOf(true));
        }
        l1 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net_for_weaknet", Long.valueOf(0L))).longValue();
        if (l1 > 0L)
        {
          l1 = System.currentTimeMillis() - l1;
          if (l1 > 0L)
          {
            al.a locala = this.m;
            locala.b = (locala.b / (this.m.a + 1) * this.m.a + l1 / (this.m.a + 1));
            locala = this.m;
            locala.a += 1;
          }
        }
      }
      if ((paramToServiceMsg.getAttributes().containsKey("attr_weaknet_sent_flag")) || (paramFromServiceMsg.getAttributes().containsKey("attr_weaknet_sent_flag")))
      {
        l1 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net_for_weaknet", Long.valueOf(0L))).longValue();
        if (l1 > 0L) {
          a(paramFromServiceMsg, paramBoolean, System.currentTimeMillis() - l1);
        }
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    if (paramToServiceMsg != null)
    {
      if (!paramToServiceMsg.getAttributes().containsKey("__timestamp_msf2net_for_weaknet")) {
        paramToServiceMsg.addAttribute("__timestamp_msf2net_for_weaknet", Long.valueOf(System.currentTimeMillis()));
      }
      if (c()) {
        paramToServiceMsg.getAttributes().put("attr_weaknet_sent_flag", Boolean.valueOf(true));
      }
    }
    if ((this.i.a) && (paramToServiceMsg != null))
    {
      if ((this.r) && (paramToServiceMsg.isNeedCallback()))
      {
        al.a locala = this.j;
        locala.a += 1;
      }
      if ((this.i.s == 0) && (paramToServiceMsg.isNeedCallback()) && (paramToServiceMsg.getAttribute("__timestamp_msf2net_for_weaknet") != null))
      {
        this.i.s = paramToServiceMsg.getRequestSsoSeq();
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("onSendFirst ssoSeq=");
          paramToServiceMsg.append(this.i.s);
          paramToServiceMsg.append(" msf2net=");
          paramToServiceMsg.append(System.currentTimeMillis());
          QLog.d("WeaknetNew", 2, paramToServiceMsg.toString());
        }
      }
    }
  }
  
  public void a(Socket paramSocket, int paramInt)
  {
    Object localObject = this.i;
    ((al.e)localObject).a = true;
    ((al.e)localObject).b = false;
    ((al.e)localObject).q = NetConnInfoCenter.getLastWifiSSID();
    this.i.d = System.currentTimeMillis();
    localObject = this.i;
    ((al.e)localObject).e = Math.min(((al.e)localObject).d - this.i.c, paramInt);
    localObject = this.i;
    ((al.e)localObject).c = 0L;
    ((al.e)localObject).s = 0;
    ((al.e)localObject).i = 0L;
    p();
    c(1);
    k();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onWifiConnected socket=");
      ((StringBuilder)localObject).append(paramSocket);
      ((StringBuilder)localObject).append(" connCost=");
      ((StringBuilder)localObject).append(this.i.e);
      ((StringBuilder)localObject).append(" oldReason=");
      ((StringBuilder)localObject).append(String.valueOf(Integer.toHexString(this.t)));
      QLog.d("WeaknetNew", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.y = 1;
    } else {
      this.y = 0;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onScreenOn mIsScreenOn=");
      localStringBuilder.append(paramBoolean);
      QLog.d("WeaknetNew", 2, localStringBuilder.toString());
    }
  }
  
  public boolean a(int paramInt)
  {
    return b(this.t, paramInt);
  }
  
  public g.a b()
  {
    return z;
  }
  
  public String b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(32);
    if (paramInt > 0)
    {
      localStringBuilder.append("(");
      localStringBuilder.append(Integer.toHexString(paramInt));
      localStringBuilder.append(")");
    }
    else
    {
      localStringBuilder.append("unknow");
    }
    return localStringBuilder.toString();
  }
  
  public void b(ToServiceMsg paramToServiceMsg)
  {
    if ((this.r) && (paramToServiceMsg != null) && (!((Boolean)paramToServiceMsg.getAttribute("chat_msg_sent_flag", Boolean.valueOf(false))).booleanValue()))
    {
      paramToServiceMsg.getAttributes().put("chat_msg_sent_flag", Boolean.valueOf(true));
      paramToServiceMsg = this.l;
      paramToServiceMsg.a += 1;
    }
  }
  
  public void b(Socket paramSocket, int paramInt)
  {
    this.i.a();
    Object localObject = this.i;
    ((al.e)localObject).b = true;
    ((al.e)localObject).a = false;
    this.r = false;
    l();
    n();
    p();
    c(64);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMobileConnected socket=");
      ((StringBuilder)localObject).append(paramSocket);
      ((StringBuilder)localObject).append(" connCost=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("WeaknetNew", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void c(ToServiceMsg paramToServiceMsg)
  {
    if (!this.i.a) {
      return;
    }
    if (paramToServiceMsg != null)
    {
      if (paramToServiceMsg.getAttribute("attr_quick_send_time") == null) {
        paramToServiceMsg.getAttributes().put("attr_quick_send_time", Long.valueOf(SystemClock.elapsedRealtime()));
      }
      m();
    }
  }
  
  public boolean c()
  {
    return this.t > 0;
  }
  
  public void d()
  {
    if (this.i.c == 0L)
    {
      this.i.c = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onConnPrepare type=");
        localStringBuilder.append(NetConnInfoCenter.getSystemNetStateString());
        localStringBuilder.append(" connStart=");
        localStringBuilder.append(this.i.c);
        QLog.d("WeaknetNew", 2, localStringBuilder.toString());
      }
      o();
    }
  }
  
  public void e()
  {
    this.y = 0;
    if (QLog.isColorLevel()) {
      QLog.d("WeaknetNew", 2, "onScreenOff");
    }
  }
  
  public void f()
  {
    if (this.q != null) {
      q();
    }
    this.i = null;
    this.k = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.al
 * JD-Core Version:    0.7.0.1
 */