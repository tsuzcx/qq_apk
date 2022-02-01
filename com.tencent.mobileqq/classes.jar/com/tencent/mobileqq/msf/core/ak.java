package com.tencent.mobileqq.msf.core;

import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.a.g;
import com.tencent.mobileqq.msf.core.a.g.a;
import com.tencent.mobileqq.msf.core.c.j.a;
import com.tencent.mobileqq.msf.core.net.j;
import com.tencent.mobileqq.msf.core.net.x;
import com.tencent.mobileqq.msf.core.quicksend.f;
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

public class ak
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
  private static g.a z = ;
  private boolean A = false;
  private ak.f B = null;
  public ak.e i = new ak.e(this);
  public ak.a j = new ak.a(this);
  public ak.a k = new ak.a(this);
  public ak.a l = new ak.a(this);
  public ak.a m = new ak.a(this);
  private final Handler q = q.b();
  private boolean r = true;
  private boolean s = false;
  private int t = 0;
  private WeakReference u = null;
  private WeakReference v = null;
  private WeakReference w = null;
  private WeakReference x = null;
  private int y = -1;
  
  public static ak a()
  {
    return ak.d.a();
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
        this.w = new WeakReference(new ak.h(this, null));
      }
      if (this.w.get() != null)
      {
        l();
        ((ak.h)this.w.get()).d = false;
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
      ((ak.h)this.w.get()).d = true;
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
        this.x = new WeakReference(new ak.g(this, null));
      }
      if (((ak.g)this.x.get()).a.compareAndSet(false, true))
      {
        n();
        ((ak.g)this.x.get()).b = false;
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
      ((ak.g)this.x.get()).b = true;
      ((ak.g)this.x.get()).a.set(false);
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
        this.u = new WeakReference(new ak.c(this));
      }
      if (((ak.c)this.u.get()).a.compareAndSet(false, true))
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
      ((ak.c)this.u.get()).a.set(false);
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
    NetworkInfo[] arrayOfNetworkInfo = j.a();
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
          localStringBuilder2 = localStringBuilder1.append(localNetworkInfo.getTypeName()).append(",").append(localNetworkInfo.getDetailedState()).append(",").append(j.a(localNetworkInfo)).append(",");
          if (!localNetworkInfo.isAvailable()) {
            break label175;
          }
          str = "1";
          label129:
          localStringBuilder2 = localStringBuilder2.append(str).append(",");
          if (!localNetworkInfo.isFailover()) {
            break label181;
          }
        }
        label175:
        label181:
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
  
  public void a(int paramInt, long paramLong, x paramx)
  {
    this.i.d = System.currentTimeMillis();
    this.i.e = (this.i.d - this.i.c);
    if (QLog.isColorLevel()) {
      QLog.d("WeaknetNew", 2, "onConnFailed type=" + NetConnInfoCenter.getSystemNetStateString() + " connTotalCost=" + this.i.e + " connErrCost=" + paramLong + " connError=" + paramx + " oldReason=" + String.valueOf(Integer.toHexString(this.t)));
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
  
  public void a(ak.f paramf)
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
        this.v = new WeakReference(new ak.b(this));
      }
      Object localObject = (ak.b)this.v.get();
      ak.e locale = this.i;
      long l1 = paramToServiceMsg.getRequestSsoSeq();
      locale.f = l1;
      ((ak.b)localObject).b = l1;
      paramToServiceMsg = (ak.b)this.v.get();
      localObject = this.i;
      l1 = System.currentTimeMillis();
      ((ak.e)localObject).g = l1;
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
            ((ak.a)localObject).b = (l1 / (this.k.a + 1) + l2 * l3);
            localObject = this.k;
            ((ak.a)localObject).a += 1;
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
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, f paramf) {}
  
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
              ak.a locala = this.m;
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
        ak.a locala = this.j;
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
  
  public g.a b()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ak
 * JD-Core Version:    0.7.0.1
 */