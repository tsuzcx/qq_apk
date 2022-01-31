package com.tencent.mobileqq.msf.core;

import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.a.f.a;
import com.tencent.mobileqq.msf.core.c.j.a;
import com.tencent.mobileqq.msf.core.net.i;
import com.tencent.mobileqq.msf.core.net.v;
import com.tencent.mobileqq.msf.core.quicksend.b;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
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
  private static final String o = "dim.msf.EvtWeakNetworkNetConnQuality";
  private static final String p = "dim.msf.EvtWeakNetworkNetChatMsgCost";
  private static f.a z = ;
  private boolean A;
  private f B;
  public e i = new e();
  public a j = new a();
  public a k = new a();
  public a l = new a();
  public a m = new a();
  private final Handler q = u.b();
  private boolean r = true;
  private boolean s;
  private int t = 0;
  private WeakReference u;
  private WeakReference v;
  private WeakReference w;
  private WeakReference x;
  private int y = -1;
  
  public static al a()
  {
    return d.a();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 0) && (paramInt2 > 0))
    {
      localStringBuffer = new StringBuffer(128);
      localStringBuffer.append(Thread.currentThread().getName()).append(" WeaknetChanged ").append(b(paramInt3)).append(", Normal to Weaknet, reason:(").append(Integer.toHexString(paramInt1)).append(", ").append(Integer.toHexString(paramInt2)).append(")");
      QLog.i("WeaknetNew", 1, localStringBuffer.toString());
      b(paramInt1, paramInt2, paramInt3);
      if (this.B != null) {
        this.B.a(paramInt2);
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
      localStringBuffer = new StringBuffer(128);
      localStringBuffer.append(Thread.currentThread().getName()).append(" WeaknetChanged ").append(b(paramInt3)).append(", Weaknet to Normal, reason:(").append(Integer.toHexString(paramInt1)).append(", ").append(Integer.toHexString(paramInt2)).append(")");
      QLog.i("WeaknetNew", 1, localStringBuffer.toString());
      b(paramInt1, paramInt2, paramInt3);
      if (this.B != null) {
        this.B.b(paramInt1);
      }
      this.r = false;
      this.i.u = SystemClock.elapsedRealtime();
      j();
      k();
      return;
    }
    if ((paramInt1 > 0) && (paramInt2 > 0) && (paramInt1 != paramInt2))
    {
      localStringBuffer = new StringBuffer(128);
      localStringBuffer.append(Thread.currentThread().getName()).append(" WeaknetChanged ").append(b(paramInt3)).append(", Weaknet to Weaknet, reason:(").append(Integer.toHexString(paramInt1)).append(", ").append(Integer.toHexString(paramInt2)).append(")");
      QLog.i("WeaknetNew", 1, localStringBuffer.toString());
      q();
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer(128);
    localStringBuffer.append(Thread.currentThread().getName()).append("WeaknetChanged ").append(b(paramInt3)).append(", unknow to unknow, reason:(").append(Integer.toHexString(paramInt1)).append(", ").append(Integer.toHexString(paramInt2)).append(")");
    QLog.i("WeaknetNew", 1, localStringBuffer.toString());
    b(paramInt1, paramInt2, paramInt3);
    q();
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, boolean paramBoolean, long paramLong) {}
  
  private void b(int paramInt1, int paramInt2, int paramInt3) {}
  
  private boolean b(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
  
  private void c(int paramInt)
  {
    int n = 0;
    for (;;)
    {
      int i1;
      try
      {
        i1 = this.t;
        if (1 == paramInt)
        {
          if ((this.i.e > 0L) && (this.i.e > z.c))
          {
            n = i1 | 0x1;
            if (n != this.t) {
              a(this.t, n, paramInt);
            }
            this.t = n;
            return;
          }
          n = i1 & 0xFFFFFFFE;
          continue;
        }
        if (2 == paramInt)
        {
          if (this.i.h - this.i.g > z.d) {
            n = i1 | 0x2;
          }
        }
        else
        {
          if (4 == paramInt)
          {
            if ((this.i.j < z.e) || (this.i.k < z.f)) {
              break label342;
            }
            n = i1 | 0x4;
            continue;
          }
          if (8 == paramInt)
          {
            if (this.i.m <= 0L) {
              break label355;
            }
            if (this.i.m >= this.i.o)
            {
              n = i1 | 0x8;
              continue;
            }
            if (this.i.m <= this.i.n) {
              continue;
            }
            break label350;
          }
          if (16 == paramInt)
          {
            if (this.i.p == 0) {
              break label371;
            }
            if (Math.abs(this.i.p) >= z.h) {
              break label363;
            }
            n = i1 | 0x10;
            continue;
          }
          if (32 == paramInt)
          {
            long l1 = this.i.r;
            n = z.i;
            if (l1 > n)
            {
              n = i1 | 0x20;
              continue;
            }
            n = i1 & 0xFFFFFFDF;
            continue;
          }
          if (64 != paramInt) {
            break label350;
          }
          continue;
        }
        n = i1 & 0xFFFFFFFD;
      }
      finally {}
      continue;
      label342:
      n = i1 & 0xFFFFFFFB;
      continue;
      label350:
      n = i1;
      continue;
      label355:
      n = i1 & 0xFFFFFFF7;
      continue;
      label363:
      n = i1 & 0xFFFFFFEF;
      continue;
      label371:
      n = i1 & 0xFFFFFFEF;
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
    long l3;
    String str;
    if (c())
    {
      long l1 = this.k.b;
      long l2 = this.m.b;
      l3 = this.i.u - this.i.t;
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
      if (this.i.q != null) {
        break label616;
      }
      str = "null";
      a("ssid", str);
      if (this.i.v != null) {
        break label628;
      }
      str = "null";
      label309:
      a("networks", str);
      a("type", String.valueOf(z.a));
      a("isCrossOper", String.valueOf(com.tencent.mobileqq.a.a.a.b));
      if (this.t <= 0) {
        break label640;
      }
    }
    label640:
    for (boolean bool = true;; bool = false)
    {
      a("dim.msf.EvtWeakNetworkNetConnQuality", bool, l3, 0L);
      if (QLog.isColorLevel()) {
        QLog.d("WeaknetNew", 2, "report EventCode=dim.msf.EvtWeakNetworkNetConnQuality reason=" + Integer.toHexString(this.t) + " weaknetCost=" + (this.i.u - this.i.t) + " screen=" + this.y + " connCost=" + this.i.e + " pingCost=" + (this.i.h - this.i.g) + " wifiSig=" + this.i.p + " ssoTotal=" + this.j.a + " ssoSucc=" + this.k.a + "/" + this.j.a + " msgSucc=" + this.m.a + "/" + this.l.a + " ssoAvgCost=" + this.k.b + " msgAvgCost=" + this.m.b);
      }
      i();
      return;
      label616:
      str = this.i.q;
      break;
      label628:
      str = this.i.v;
      break label309;
    }
  }
  
  private void k()
  {
    if (this.i.a) {
      if ((this.w != null) && (this.w.get() != null)) {}
    }
    try
    {
      if ((this.w == null) || (this.w.get() == null)) {
        this.w = new WeakReference(new h(null));
      }
      if (this.w.get() != null)
      {
        l();
        ((h)this.w.get()).d = false;
        this.q.postDelayed((Runnable)this.w.get(), z.g);
      }
      if (QLog.isColorLevel()) {
        QLog.d("WeaknetNew", 2, Thread.currentThread().getName() + " startWeakNetworkSsoCheck wifiConned=" + this.i.a);
      }
      return;
    }
    finally {}
  }
  
  private void l()
  {
    if ((this.w == null) || (this.w.get() == null)) {}
    do
    {
      return;
      ((h)this.w.get()).d = true;
      this.q.removeCallbacks((Runnable)this.w.get());
    } while (!QLog.isColorLevel());
    QLog.d("WeaknetNew", 2, Thread.currentThread().getName() + " stopWeakNetworkSsoCheck");
  }
  
  private void m()
  {
    if (!a(32)) {
      if ((this.x != null) && (this.x.get() != null)) {}
    }
    try
    {
      if ((this.x == null) || (this.x.get() == null)) {
        this.x = new WeakReference(new g(null));
      }
      if (((g)this.x.get()).a.compareAndSet(false, true))
      {
        n();
        ((g)this.x.get()).b = false;
        this.q.postDelayed((Runnable)this.x.get(), z.i);
        if (QLog.isColorLevel()) {
          QLog.d("WeaknetNew", 2, Thread.currentThread().getName() + " startQuickSendCheck wifiConned=" + this.i.a);
        }
      }
      return;
    }
    finally {}
  }
  
  private void n()
  {
    if ((this.x == null) || (this.x.get() == null)) {}
    do
    {
      return;
      this.q.removeCallbacks((Runnable)this.x.get());
      ((g)this.x.get()).b = true;
      ((g)this.x.get()).a.set(false);
    } while (!QLog.isColorLevel());
    QLog.d("WeaknetNew", 2, Thread.currentThread().getName() + " stopQuickSendCheck");
  }
  
  private void o()
  {
    if (!a(1)) {
      if ((this.u != null) && (this.u.get() != null)) {}
    }
    try
    {
      if ((this.u == null) || (this.u.get() == null)) {
        this.u = new WeakReference(new c());
      }
      if (((c)this.u.get()).a.compareAndSet(false, true))
      {
        this.q.removeCallbacks((Runnable)this.u.get());
        this.q.postDelayed((Runnable)this.u.get(), z.c);
        if (QLog.isColorLevel()) {
          QLog.d("WeaknetNew", 2, Thread.currentThread().getName() + " startConnCheck oldReason=" + Integer.toHexString(this.t));
        }
      }
      return;
    }
    finally {}
  }
  
  private void p()
  {
    if ((this.u == null) || (this.u.get() == null)) {}
    do
    {
      return;
      this.q.removeCallbacks((Runnable)this.u.get());
      ((c)this.u.get()).a.set(false);
    } while (!QLog.isColorLevel());
    QLog.d("WeaknetNew", 2, Thread.currentThread().getName() + " stopConnCheck");
  }
  
  private void q()
  {
    p();
    n();
    l();
    if ((this.v != null) && (this.v.get() != null)) {
      this.q.removeCallbacks((Runnable)this.v.get());
    }
  }
  
  private String r()
  {
    NetworkInfo[] arrayOfNetworkInfo = i.a();
    if ((arrayOfNetworkInfo != null) && (arrayOfNetworkInfo.length > 0))
    {
      StringBuilder localStringBuilder1 = new StringBuilder(128);
      localStringBuilder1.append(arrayOfNetworkInfo.length).append("#");
      int i1 = arrayOfNetworkInfo.length;
      int n = 0;
      if (n < i1)
      {
        NetworkInfo localNetworkInfo = arrayOfNetworkInfo[n];
        StringBuilder localStringBuilder2;
        if (localNetworkInfo.getDetailedState() == NetworkInfo.DetailedState.CONNECTED)
        {
          localStringBuilder2 = localStringBuilder1.append(localNetworkInfo.getTypeName()).append(",").append(localNetworkInfo.getDetailedState()).append(",").append(i.a(localNetworkInfo)).append(",");
          if (!localNetworkInfo.isAvailable()) {
            break label175;
          }
          str = "1";
          label129:
          localStringBuilder2 = localStringBuilder2.append(str).append(",");
          if (!localNetworkInfo.isFailover()) {
            break label182;
          }
        }
        label175:
        label182:
        for (String str = "1";; str = "0")
        {
          localStringBuilder2.append(str).append("|");
          n += 1;
          break;
          str = "0";
          break label129;
        }
      }
      return localStringBuilder1.toString();
    }
    return "";
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.i.p = ((short)paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("WeaknetNew", 2, "onWifiSignalChanged old=" + paramInt1 + " current=" + paramInt2);
    }
  }
  
  public void a(int paramInt, long paramLong, v paramv)
  {
    this.i.d = System.currentTimeMillis();
    this.i.e = (this.i.d - this.i.c);
    if (QLog.isColorLevel()) {
      QLog.d("WeaknetNew", 2, "onConnFailed type=" + NetConnInfoCenter.getSystemNetStateString() + " connTotalCost=" + this.i.e + " connErrCost=" + paramLong + " connError=" + paramv + " oldReason=" + String.valueOf(Integer.toHexString(this.t)));
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
        QLog.d("WeaknetNew", 1, "[" + Thread.currentThread().getName() + "] onPingRecved ssoSeq=" + paramLong1 + " pingSend=" + this.i.g + " pingRecv=" + this.i.h + " cost=" + (this.i.h - this.i.g));
        if ((this.v != null) && (this.v.get() != null)) {
          this.q.removeCallbacks((Runnable)this.v.get());
        }
        c(2);
      }
    }
    else {
      return;
    }
    QLog.w("WeaknetNew", 1, "WARN: [" + Thread.currentThread().getName() + "] onPingRecved sendSsoSeq=" + this.i.f + " recvSsoSeq=" + paramLong1 + " out of order");
  }
  
  public void a(f paramf)
  {
    this.B = paramf;
  }
  
  public void a(com.tencent.qphone.base.a parama)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onConnClose reason=").append(parama).append(" conn=");
      if (!this.i.a) {
        break label59;
      }
      parama = "wifi";
    }
    for (;;)
    {
      QLog.d("WeaknetNew", 2, parama);
      return;
      label59:
      if (this.i.b) {
        parama = "mobile";
      } else {
        parama = "unknown";
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    if (this.i.a) {
      if ((this.v != null) && (this.v.get() != null)) {}
    }
    try
    {
      if ((this.v == null) || (this.v.get() == null)) {
        this.v = new WeakReference(new b());
      }
      Object localObject = (b)this.v.get();
      e locale = this.i;
      long l1 = paramToServiceMsg.getRequestSsoSeq();
      locale.f = l1;
      ((b)localObject).b = l1;
      paramToServiceMsg = (b)this.v.get();
      localObject = this.i;
      l1 = System.currentTimeMillis();
      ((e)localObject).g = l1;
      paramToServiceMsg.a = l1;
      QLog.d("WeaknetNew", 1, "onPingSent ssoSeq=" + this.i.f + " pingSend=" + this.i.g);
      if ((this.v != null) && (this.v.get() != null))
      {
        this.q.removeCallbacks((Runnable)this.v.get());
        this.q.postDelayed((Runnable)this.v.get(), 3001L);
      }
      return;
    }
    finally {}
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject;
    long l1;
    long l2;
    if (this.i.a)
    {
      if ((this.r) && (paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
      {
        localObject = paramToServiceMsg.getAttribute("__timestamp_msf2net_for_weaknet");
        if (localObject != null)
        {
          l1 = System.currentTimeMillis() - ((Long)localObject).longValue();
          if (l1 > 0L)
          {
            localObject = this.k;
            l2 = this.k.b / (this.k.a + 1);
            long l3 = this.k.a;
            ((a)localObject).b = (l1 / (this.k.a + 1) + l2 * l3);
            localObject = this.k;
            ((a)localObject).a += 1;
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
        if (((this.i.s <= 0) || (paramFromServiceMsg.getRequestSsoSeq() != this.i.s)) && (this.i.i != 0L)) {
          break label691;
        }
        l1 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net_for_weaknet", Long.valueOf(this.i.d))).longValue();
        this.i.i = (System.currentTimeMillis() - l1);
        if (this.i.i > 0L)
        {
          this.i.l = ((0.3D * this.i.e + 0.7D * this.i.i));
          this.i.m = this.i.i;
          this.i.n = Math.max(2L * this.i.l, z.k);
          this.i.o = Math.max(3L * this.i.l, z.j);
          if ((this.i.n > z.j) || (this.i.o < z.k))
          {
            this.i.n = z.k;
            this.i.o = z.j;
          }
        }
        if (paramFromServiceMsg.getRequestSsoSeq() != this.i.s)
        {
          QLog.w("WeaknetNew", 1, "WARN: firstSendSsoseq=" + this.i.s + " firstRecvSsoSeq=" + paramToServiceMsg.getRequestSsoSeq() + " out of order");
          this.i.s = paramToServiceMsg.getRequestSsoSeq();
        }
        paramToServiceMsg = new StringBuilder(128);
        paramToServiceMsg.append("onRecvFirst ssoSeq=").append(this.i.s).append(" TC=").append(this.i.e).append(" pingCost=").append(this.i.h - this.i.g).append(" TP=").append(this.i.i).append(" Trtt=").append(this.i.l).append(" Rttm=").append(this.i.m).append(" windows=(").append(this.i.n).append(",").append(this.i.o).append(")");
        QLog.d("WeaknetNew", 1, paramToServiceMsg.toString());
      }
    }
    label690:
    label691:
    do
    {
      int n;
      do
      {
        do
        {
          do
          {
            break label690;
            break label690;
            do
            {
              return;
            } while ((this.i.i <= 0L) || (!paramFromServiceMsg.isSuccess()));
            localObject = paramFromServiceMsg.getAttribute("__timestamp_net2msf");
            paramToServiceMsg = paramToServiceMsg.getAttribute("__timestamp_msf2net_for_weaknet");
          } while ((localObject == null) || (paramToServiceMsg == null));
          l1 = ((Long)localObject).longValue() - ((Long)paramToServiceMsg).longValue();
          l2 = (0.6D * this.i.m + 0.4D * l1);
        } while ((l1 <= 0L) || (l2 <= 0L));
        this.i.m = l2;
        n = this.t;
        c(8);
      } while (n == this.t);
      if (!c())
      {
        QLog.d("WeaknetNew", 1, Thread.currentThread().getName() + " Restore Normal ssoSeq=" + paramFromServiceMsg.getRequestSsoSeq() + " serviceCmd=" + paramFromServiceMsg.getServiceCmd() + " RTTm=" + this.i.m);
        return;
      }
    } while (!a(8));
    QLog.d("WeaknetNew", 1, Thread.currentThread().getName() + " Enter weaknet ssoSeq=" + paramFromServiceMsg.getRequestSsoSeq() + " serviceCmd=" + paramFromServiceMsg.getServiceCmd() + " RTTm=" + this.i.m);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, com.tencent.mobileqq.msf.core.quicksend.f paramf) {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean, int paramInt)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (TextUtils.isEmpty(paramFromServiceMsg.getUin())) || ("0".equals(paramFromServiceMsg.getUin())) || (!"MessageSvc.PbSendMsg".equals(paramFromServiceMsg.getServiceCmd()))) {}
    long l1;
    do
    {
      do
      {
        return;
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
              a locala = this.m;
              long l2 = this.m.b / (this.m.a + 1);
              long l3 = this.m.a;
              locala.b = (l1 / (this.m.a + 1) + l2 * l3);
              locala = this.m;
              locala.a += 1;
            }
          }
        }
      } while ((!paramToServiceMsg.getAttributes().containsKey("attr_weaknet_sent_flag")) && (!paramFromServiceMsg.getAttributes().containsKey("attr_weaknet_sent_flag")));
      l1 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net_for_weaknet", Long.valueOf(0L))).longValue();
    } while (l1 <= 0L);
    a(paramFromServiceMsg, paramBoolean, System.currentTimeMillis() - l1);
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
        a locala = this.j;
        locala.a += 1;
      }
      if ((this.i.s == 0) && (paramToServiceMsg.isNeedCallback()) && (paramToServiceMsg.getAttribute("__timestamp_msf2net_for_weaknet") != null))
      {
        this.i.s = paramToServiceMsg.getRequestSsoSeq();
        if (QLog.isColorLevel()) {
          QLog.d("WeaknetNew", 2, "onSendFirst ssoSeq=" + this.i.s + " msf2net=" + System.currentTimeMillis());
        }
      }
    }
  }
  
  public void a(Socket paramSocket, int paramInt)
  {
    this.i.a = true;
    this.i.b = false;
    this.i.q = NetConnInfoCenter.getLastWifiSSID();
    this.i.d = System.currentTimeMillis();
    this.i.e = Math.min(this.i.d - this.i.c, paramInt);
    this.i.c = 0L;
    this.i.s = 0;
    this.i.i = 0L;
    p();
    c(1);
    k();
    if (QLog.isColorLevel()) {
      QLog.d("WeaknetNew", 2, "onWifiConnected socket=" + paramSocket + " connCost=" + this.i.e + " oldReason=" + String.valueOf(Integer.toHexString(this.t)));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.y = 1;; this.y = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WeaknetNew", 2, "onScreenOn mIsScreenOn=" + paramBoolean);
      }
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    return b(this.t, paramInt);
  }
  
  public f.a b()
  {
    return z;
  }
  
  public String b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(32);
    if (paramInt > 0)
    {
      localStringBuilder.append("(").append(Integer.toHexString(paramInt));
      localStringBuilder.append(")");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("unknow");
    }
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
    this.i.b = true;
    this.i.a = false;
    this.r = false;
    l();
    n();
    p();
    c(64);
    if (QLog.isColorLevel()) {
      QLog.d("WeaknetNew", 2, "onMobileConnected socket=" + paramSocket + " connCost=" + paramInt);
    }
  }
  
  public void c(ToServiceMsg paramToServiceMsg)
  {
    if (!this.i.a) {}
    while (paramToServiceMsg == null) {
      return;
    }
    if (paramToServiceMsg.getAttribute("attr_quick_send_time") == null) {
      paramToServiceMsg.getAttributes().put("attr_quick_send_time", Long.valueOf(SystemClock.elapsedRealtime()));
    }
    m();
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
      if (QLog.isColorLevel()) {
        QLog.d("WeaknetNew", 2, "onConnPrepare type=" + NetConnInfoCenter.getSystemNetStateString() + " connStart=" + this.i.c);
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
  
  class a
  {
    int a;
    long b;
    
    a() {}
    
    public void a()
    {
      this.a = 0;
      this.b = 0L;
    }
  }
  
  public class b
    implements Runnable
  {
    long a = 0L;
    long b = 0L;
    
    public b() {}
    
    public void run()
    {
      if ((al.this.i.a) && (this.b > 0L) && (this.a > 0L)) {
        al.this.a(this.b, System.currentTimeMillis() - this.a);
      }
    }
  }
  
  public class c
    implements Runnable
  {
    public final AtomicBoolean a = new AtomicBoolean(false);
    
    public c() {}
    
    public void run()
    {
      if (al.this.i.c > 0L)
      {
        al.this.i.e = (System.currentTimeMillis() - al.this.i.c);
        if (QLog.isColorLevel()) {
          QLog.d("WeaknetNew", 2, "CheckConnTimer conn cost=" + al.this.i.e + " oldReason=" + Integer.toHexString(al.a(al.this)));
        }
        al.a(al.this, 1);
        al.b(al.this);
      }
    }
  }
  
  private static class d
  {
    private static final al a = new al(null);
  }
  
  class e
  {
    boolean a;
    boolean b;
    long c;
    long d;
    long e;
    long f;
    long g;
    long h;
    long i;
    short j;
    short k;
    long l;
    long m;
    long n;
    long o;
    int p;
    String q;
    long r;
    int s;
    long t = 0L;
    long u = 0L;
    String v;
    
    e() {}
    
    public void a()
    {
      this.a = false;
      this.e = 0L;
      this.d = 0L;
      this.c = 0L;
      this.f = 0L;
      this.g = 0L;
      this.h = 0L;
      this.k = 0;
      this.j = 0;
      this.m = 0L;
      this.l = 0L;
      this.p = 0;
      this.s = 0;
      this.i = 0L;
      this.r = 0L;
      this.u = 0L;
      this.t = 0L;
      this.q = null;
      this.v = null;
    }
  }
  
  public static abstract interface f
  {
    public abstract void a(int paramInt);
    
    public abstract void b(int paramInt);
  }
  
  private class g
    implements Runnable
  {
    public volatile AtomicBoolean a = new AtomicBoolean(false);
    public boolean b;
    
    private g() {}
    
    public void run()
    {
      boolean bool = false;
      if (this.b) {}
      int i;
      do
      {
        return;
        i = MsfCore.sCore.quicksender.a().size();
      } while ((MsfCore.sCore.quicksender.a() == null) || (i <= 0) || (i >= 100));
      Object localObject = MsfCore.sCore.quicksender.a().values();
      long l1;
      if ((localObject != null) && (((Collection)localObject).size() > 0))
      {
        localObject = ((Collection)localObject).iterator();
        l1 = 0L;
        label89:
        if (((Iterator)localObject).hasNext())
        {
          ToServiceMsg localToServiceMsg = (ToServiceMsg)((Iterator)localObject).next();
          if (localToServiceMsg != null)
          {
            l1 = ((Long)localToServiceMsg.getAttribute("attr_quick_send_time", Long.valueOf(0L))).longValue();
            long l2 = SystemClock.elapsedRealtime() - l1;
            l1 = l2;
            if (l2 > al.g().i)
            {
              bool = true;
              i = localToServiceMsg.getRequestSsoSeq();
              l1 = l2;
            }
          }
        }
      }
      for (;;)
      {
        if (bool)
        {
          al.this.i.r = l1;
          al.a(al.this, 32);
          if (QLog.isColorLevel()) {
            QLog.d("WeaknetNew", 2, "weaknet quickSendCheck reason=" + Integer.toHexString(al.a(al.this)) + " ssoSeq=" + i + " timeout=" + bool);
          }
        }
        if ((al.this.a(32)) || (MsfCore.sCore.quicksender.a().size() <= 0) || (al.c(al.this) == null) || (al.c(al.this).get() == null)) {
          break;
        }
        al.d(al.this).postDelayed((Runnable)al.c(al.this).get(), al.g().i);
        return;
        break label89;
        i = 0;
        continue;
        i = 0;
        l1 = 0L;
      }
    }
  }
  
  private class h
    implements Runnable
  {
    static final short a = 10;
    final HashMap b = new HashMap(10);
    StringBuilder c = null;
    boolean d = false;
    
    private h() {}
    
    public void run()
    {
      if (this.d) {
        return;
      }
      try
      {
        Object localObject4;
        int i;
        if (MsfCore.sCore.sender.c.size() >= al.g().e)
        {
          this.b.clear();
          localObject4 = MsfCore.sCore.sender.c.values().iterator();
          i = 0;
        }
        for (;;)
        {
          Object localObject3;
          Object localObject1;
          if (((Iterator)localObject4).hasNext())
          {
            ToServiceMsg localToServiceMsg = (ToServiceMsg)((Iterator)localObject4).next();
            if (!localToServiceMsg.isNeedCallback()) {
              continue;
            }
            localObject3 = localToServiceMsg.getAttribute("__timestamp_msf2net_for_weaknet");
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              localObject3 = localToServiceMsg.getAttribute("__timestamp_msf2net");
              localObject1 = localObject3;
              if (localObject3 == null)
              {
                localObject3 = localToServiceMsg.getAttribute("__timestamp_addSendQueue");
                localObject1 = localObject3;
                if (localObject3 == null)
                {
                  localObject1 = localToServiceMsg.getAttribute("__timestamp_app2msf");
                  if (localObject1 == null) {
                    continue;
                  }
                }
              }
            }
            long l = ((Long)localObject1).longValue();
            if ((l <= 0L) || (System.currentTimeMillis() - l <= al.g().g)) {
              break label736;
            }
            if (this.b.size() < 10)
            {
              i = (short)(i + 1);
              this.b.put(localToServiceMsg.getServiceCmd(), Integer.valueOf(localToServiceMsg.getRequestSsoSeq()));
              break label736;
            }
          }
          if ((i >= al.g().e) && (al.g().f >= 0))
          {
            al.this.i.j = i;
            al.this.i.k = ((short)this.b.size());
            al.a(al.this, 4);
            if (QLog.isColorLevel())
            {
              this.c = new StringBuilder(512);
              this.c.append("wakenet ssoCheck current:" + Integer.toHexString(al.a(al.this)) + " sendQueue:" + MsfCore.sCore.sender.c.size() + " detectQueue:" + MsfCore.sCore.sender.e.size() + " waitQueue:" + MsfCore.sCore.sender.f.size() + " delayWaitQueue:" + MsfCore.sCore.sender.g.size() + " bnbc: \n");
              localObject1 = this.b.keySet().iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject3 = (String)((Iterator)localObject1).next();
                localObject4 = (Integer)this.b.get(localObject3);
                this.c.append(" ssoSeq:").append(localObject4).append(" serviceCmd:").append((String)localObject3).append("\n");
              }
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("WeaknetNew", 1, localThrowable.getMessage(), localThrowable);
        }
        return;
        QLog.d("WeaknetNew", 2, this.c.toString());
        this.c = null;
        return;
      }
      finally
      {
        if ((al.e(al.this) != null) && (al.e(al.this).get() != null)) {
          al.d(al.this).postDelayed((Runnable)al.e(al.this).get(), al.g().g);
        }
        this.b.clear();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.al
 * JD-Core Version:    0.7.0.1
 */