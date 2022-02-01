package com.tencent.mobileqq.msf.core.quicksend;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.aj;
import com.tencent.mobileqq.msf.core.ap;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.core.g;
import com.tencent.mobileqq.msf.core.h;
import com.tencent.mobileqq.msf.core.net.l;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class b
{
  public static final String a = "attr_quick_send";
  public static final String b = "attr_quick_send_resend_time";
  public static final String c = "attr_quick_send_time";
  public static final String d = "attr_quick_xg_send_resend_time";
  public static final int e = 3;
  public static final long g = 2000L;
  private static final String i = "MSF.C.QuickSendManager";
  private static final String n = "isSendQuickHBBackToForeground";
  private static final long r = 120000L;
  public d f = new d();
  Handler h = new c(this);
  private MsfCore j;
  private final int k = 1;
  private HashSet l = new HashSet();
  private ConcurrentHashMap m = new ConcurrentHashMap();
  private ConcurrentHashMap o = new ConcurrentHashMap();
  private long p = 0L;
  private volatile Handler q;
  private long s = 0L;
  private AtomicBoolean t = new AtomicBoolean(true);
  
  public b(MsfCore paramMsfCore)
  {
    this.j = paramMsfCore;
    this.m.clear();
    paramMsfCore = new HandlerThread("MsfCoreHttpTimeoutChecker", 5);
    paramMsfCore.start();
    this.q = new Handler(paramMsfCore.getLooper());
    b();
  }
  
  private void a(long paramLong, boolean paramBoolean)
  {
    AtomicBoolean localAtomicBoolean = (AtomicBoolean)this.o.get(Long.valueOf(paramLong));
    if (localAtomicBoolean == null)
    {
      localAtomicBoolean = new AtomicBoolean(paramBoolean);
      this.o.put(Long.valueOf(paramLong), localAtomicBoolean);
      return;
    }
    localAtomicBoolean.set(paramBoolean);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    a(paramToServiceMsg.getTimeout(), paramBoolean);
  }
  
  public static void b(int paramInt)
  {
    if ((MsfCore.sCore.lightTcpSender != null) && (com.tencent.mobileqq.msf.core.a.a.bu()) && (MsfCore.sCore.lightTcpSender.a())) {
      MsfCore.sCore.lightTcpSender.a(paramInt);
    }
  }
  
  private boolean c(long paramLong)
  {
    Iterator localIterator = this.o.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Long)localIterator.next();
      if (((Long)localObject).longValue() < paramLong)
      {
        localObject = (AtomicBoolean)this.o.get(localObject);
        if ((localObject != null) && (((AtomicBoolean)localObject).get())) {
          return false;
        }
      }
    }
    if (!b(paramLong)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {}
    do
    {
      return;
      if (!g(paramToServiceMsg))
      {
        h(paramToServiceMsg);
        return;
      }
      this.j.lightSender.a(paramToServiceMsg);
    } while ((this.j.lightTcpSender == null) || (!f()) || (!com.tencent.mobileqq.a.a.a.b()));
    this.j.lightTcpSender.b(paramToServiceMsg);
  }
  
  public static boolean f()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  private boolean g(ToServiceMsg paramToServiceMsg)
  {
    if (TextUtils.isEmpty(paramToServiceMsg.getServiceCmd()))
    {
      QLog.d("MSF.C.QuickSendManager", 1, "tryResendMsg fail, cmd is null ");
      return false;
    }
    if (!paramToServiceMsg.isNeedCallback())
    {
      QLog.d("MSF.C.QuickSendManager", 1, "tryResendMsg fail, request don't need callback ");
      return false;
    }
    if (this.l.contains(paramToServiceMsg.getServiceCmd()))
    {
      QLog.d("MSF.C.QuickSendManager", 1, "tryResendMsg fail, refuse quick send cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq() + " by blacklist");
      return false;
    }
    if ((!paramToServiceMsg.isQuickSendEnable()) || (QuickSendStrategy.getStragegyArgs(paramToServiceMsg.getQuickSendStrategy()) == null))
    {
      QLog.d("MSF.C.QuickSendManager", 1, "tryResendMsg fail, refuse quick send cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq() + " by quickSendStrategy error");
      return false;
    }
    if (!this.m.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq())))
    {
      QLog.d("MSF.C.QuickSendManager", 1, "tryResendMsg fail, sendQueue don't contain msg, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq());
      return false;
    }
    if (paramToServiceMsg.getAttributes().containsKey("attr_quick_send_resend_time")) {}
    for (int i1 = ((Integer)paramToServiceMsg.getAttributes().get("attr_quick_send_resend_time")).intValue();; i1 = 0)
    {
      a locala = QuickSendStrategy.getStragegyArgs(paramToServiceMsg.getQuickSendStrategy());
      if ((i1 < 0) || (i1 > locala.c))
      {
        QLog.d("MSF.C.QuickSendManager", 1, "tryResendMsg fail, msg has resend " + i1 + " times, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + i1);
        return false;
      }
      paramToServiceMsg.getAttributes().put("attr_quick_send_resend_time", Integer.valueOf(i1 + 1));
      long l1 = locala.b;
      if (i1 < com.tencent.mobileqq.msf.core.a.a.aG()) {
        l1 = com.tencent.mobileqq.msf.core.a.a.aF();
      }
      long l2 = l1;
      if (com.tencent.mobileqq.msf.core.a.a.aH())
      {
        l2 = l1;
        if (i1 == 0)
        {
          l2 = l1;
          if (paramToServiceMsg.getServiceCmd().equals("MessageSvc.PbSendMsg")) {
            l2 = locala.a - 1000L;
          }
        }
      }
      h();
      Message localMessage = this.h.obtainMessage();
      localMessage.what = 1;
      localMessage.arg1 = paramToServiceMsg.getRequestSsoSeq();
      this.h.sendMessageDelayed(localMessage, l2);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.QuickSendManager", 2, "tryResendMsg cmd:" + paramToServiceMsg.getServiceCmd() + " ssoSeq:" + paramToServiceMsg.getRequestSsoSeq() + " resendIndex: " + (i1 + 1) + " delayed: " + locala.b);
      }
      return true;
    }
  }
  
  public static void h()
  {
    if ((f()) && (com.tencent.mobileqq.msf.core.a.a.bu()) && (com.tencent.mobileqq.a.a.a.b()))
    {
      NetConnInfoCenter.checkConnInfo();
      if (!NetConnInfoCenter.isMobileConn()) {
        l.a(BaseApplication.getContext());
      }
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null) {}
    try
    {
      d(paramToServiceMsg);
      if (this.m.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))) {
        this.m.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
      }
      if (MsfCore.sCore.lightTcpSender != null) {
        MsfCore.sCore.lightTcpSender.a(paramToServiceMsg);
      }
      return;
    }
    finally {}
  }
  
  public static void i()
  {
    if ((MsfCore.sCore.lightTcpSender != null) && (com.tencent.mobileqq.msf.core.a.a.bu()) && (MsfCore.sCore.lightTcpSender.a())) {
      MsfCore.sCore.lightTcpSender.b();
    }
  }
  
  private boolean j()
  {
    boolean bool = BaseApplication.getContext().getSharedPreferences("common_sp_for_msf", 4).getBoolean("isSendQuickHBBackToForeground", false);
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.QuickSendManager", 2, "isSendQuickHBBackToForeground = " + bool);
    }
    return bool;
  }
  
  public Map a()
  {
    return this.m;
  }
  
  public void a(long paramLong)
  {
    if (!c(paramLong))
    {
      QLog.d("MSF.C.QuickSendManager", 1, "quick heart beat has sending, timeout = " + paramLong + ", so return.");
      return;
    }
    if (this.j.sender.b.b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.QuickSendManager", 2, "sendQuickHeartBeat, timeout = " + paramLong);
      }
      a(paramLong, true);
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "Heartbeat.Ping");
      localToServiceMsg.setMsfCommand(MsfCommand._msf_QuickHeartBeat);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.setAppId(this.j.getMsfAppid());
      localToServiceMsg.putWupBuffer(new byte[] { 0, 0, 0, 4 });
      localToServiceMsg.setTimeout(paramLong);
      localToServiceMsg.getAttributes().put("quickSendDetectTime", Long.valueOf(SystemClock.elapsedRealtime()));
      this.j.sender.a(localToServiceMsg);
      return;
    }
    a(paramLong, false);
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    if (TextUtils.isEmpty(paramToServiceMsg.getServiceCmd()))
    {
      QLog.d("MSF.C.QuickSendManager", 1, "addQuickSendQueue fail, cmd is null ");
      return;
    }
    if (!paramToServiceMsg.isNeedCallback())
    {
      QLog.d("MSF.C.QuickSendManager", 1, "addQuickSendQueue fail, request don't need callback ");
      return;
    }
    if (this.l.contains(paramToServiceMsg.getServiceCmd()))
    {
      QLog.d("MSF.C.QuickSendManager", 1, "addQuickSendQueue fail, refuse quick send cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq() + " by blacklist");
      return;
    }
    if ((!paramToServiceMsg.isQuickSendEnable()) || (QuickSendStrategy.getStragegyArgs(paramToServiceMsg.getQuickSendStrategy()) == null))
    {
      QLog.d("MSF.C.QuickSendManager", 1, "addQuickSendQueue fail, refuse quick send cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq() + " by quickSendStrategy error");
      return;
    }
    if (this.m.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq())))
    {
      QLog.d("MSF.C.QuickSendManager", 1, "addQuickSendQueue fail, msg has quick send, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq());
      return;
    }
    paramToServiceMsg.getAttributes().put("attr_quick_send", Boolean.valueOf(true));
    paramToServiceMsg.getAttributes().put("light_sender_type", Integer.valueOf(1));
    paramToServiceMsg.getAttributes().put("attr_quick_send_resend_time", Integer.valueOf(0));
    this.m.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
    f(paramToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.isQuickSendEnable())
    {
      QLog.d("MSF.C.QuickSendManager", 1, "onRecvNormalResp, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq());
      h(paramToServiceMsg);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    boolean bool = false;
    if (paramToServiceMsg == null) {
      QLog.d("MSF.C.QuickSendManager", 1, "onRecvResp toMsg is null");
    }
    do
    {
      return;
      if (paramFromServiceMsg == null)
      {
        QLog.d("MSF.C.QuickSendManager", 1, "onRecvResp quicksend fail, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq() + " fromMsg is null");
        return;
      }
      if (paramFromServiceMsg.isSuccess()) {
        break;
      }
      QLog.d("MSF.C.QuickSendManager", 1, "onRecvResp quicksend fail, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq() + " code: " + paramFromServiceMsg.getBusinessFailCode() + " failmsg: " + paramFromServiceMsg.getBusinessFailMsg());
    } while (paramFromServiceMsg.getBusinessFailCode() != 2901);
    h(paramToServiceMsg);
    return;
    if (this.m.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))) {
      QLog.d("MSF.C.QuickSendManager", 1, "onRecvResp quicksend succ, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq());
    }
    for (;;)
    {
      try
      {
        ap.a(paramToServiceMsg, paramFromServiceMsg, true);
        com.tencent.mobileqq.a.a.a.a().a(paramToServiceMsg, paramFromServiceMsg, true, 0);
        if (com.tencent.mobileqq.msf.core.a.a.aH())
        {
          if (paramInt == 1) {
            bool = true;
          }
          com.tencent.mobileqq.a.a.d.a(paramToServiceMsg, paramFromServiceMsg, bool);
        }
        if ((this.j.quicksender != null) && (this.j.quicksender.b(paramToServiceMsg))) {
          this.j.quicksender.f.b(paramToServiceMsg, paramFromServiceMsg);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      h(paramToServiceMsg);
      paramFromServiceMsg.getAttributes().put("_attr_send_by_quickHttp", Boolean.valueOf(true));
      paramFromServiceMsg.setAppId(paramToServiceMsg.getAppId());
      paramFromServiceMsg.setAppSeq(paramToServiceMsg.getAppSeq());
      paramFromServiceMsg.setMsfCommand(paramToServiceMsg.getMsfCommand());
      this.j.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
      return;
      QLog.d("MSF.C.QuickSendManager", 1, "onRecvResp quicksend succ occurred 2901, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq());
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    long l2 = 0L;
    boolean bool = false;
    long l1 = l2;
    if (paramToServiceMsg != null)
    {
      l1 = l2;
      if (paramToServiceMsg.getAttributes().containsKey("quickSendDetectTime"))
      {
        long l3 = ((Long)paramToServiceMsg.getAttributes().get("quickSendDetectTime")).longValue();
        l1 = l2;
        if (l3 > 0L) {
          l1 = SystemClock.elapsedRealtime() - l3;
        }
      }
    }
    if (paramFromServiceMsg.getBusinessFailCode() == 1002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.QuickSendManager", 2, "handleQuickHeartbeat wait " + paramToServiceMsg + " timeout.");
      }
      if (paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.QuickSendManager", 2, "new conn has created, stop quick detectind");
        }
        a(paramToServiceMsg, false);
        i1 = 3;
        paramBoolean = bool;
        if (this.j.statReporter != null)
        {
          paramFromServiceMsg = new HashMap();
          if (this.j.getAccountCenter() == null) {
            break label557;
          }
          paramFromServiceMsg.put("account", this.j.getAccountCenter().i());
          label193:
          paramFromServiceMsg.put("closeType", "" + i1);
          if (paramToServiceMsg == null) {
            break label578;
          }
        }
      }
    }
    label557:
    label578:
    for (l2 = paramToServiceMsg.getTimeout();; l2 = -1L)
    {
      for (;;)
      {
        paramFromServiceMsg.put("timeout", String.valueOf(l2));
        this.j.statReporter.a("msf_send_quick_hb", paramBoolean, l1, 0L, paramFromServiceMsg, true, false);
        this.j.statReporter.a("dim.Msf.QuickSendDetect", paramBoolean, l1, 0L, paramFromServiceMsg, false, false);
        return;
        if (!this.j.sender.b.b())
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.QuickSendManager", 2, "conn is also closed, stop quick detecting");
          }
          a(paramToServiceMsg, false);
          i1 = 1;
          paramBoolean = bool;
          break;
        }
        l2 = SystemClock.elapsedRealtime();
        if (l2 > this.p + com.tencent.mobileqq.msf.core.a.a.H())
        {
          this.p = l2;
          try
          {
            QLog.d("MSF.C.QuickSendManager", 1, "handleQuickHeartbeat disconn: " + System.currentTimeMillis() + " mLastDetectDisconnTime:" + l2 + " closeConn closeByNetDetectFailedNew");
            this.j.sender.b.a(com.tencent.qphone.base.a.A);
            i2 = 2;
            i1 = i2;
            if (paramToServiceMsg != null) {
              i1 = i2;
            }
          }
          catch (Exception paramFromServiceMsg)
          {
            for (;;)
            {
              paramFromServiceMsg = paramFromServiceMsg;
              i1 = 0;
              QLog.d("MSF.C.QuickSendManager", 1, "handleQuickHeartbeat disconn error", paramFromServiceMsg);
            }
          }
          finally
          {
            a(paramToServiceMsg, false);
          }
        }
      }
      a(paramToServiceMsg, false);
      QLog.d("MSF.C.QuickSendManager", 1, "handleQuickHeartbeat stop disconn by too frequency.");
      i1 = 0;
      paramBoolean = bool;
      break;
      QLog.d("MSF.C.QuickSendManager", 1, "recv Quick heart resp.now conn is alive.");
      a(paramToServiceMsg, false);
      paramBoolean = true;
      i1 = 0;
      break;
      paramFromServiceMsg.put("account", this.j.sender.j());
      break label193;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      b(j());
    }
  }
  
  public boolean a(int paramInt)
  {
    return this.m.contains(Integer.valueOf(paramInt));
  }
  
  public void b()
  {
    String[] arrayOfString = com.tencent.mobileqq.msf.core.a.a.ae();
    if (arrayOfString == null) {}
    for (;;)
    {
      return;
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = arrayOfString[i1];
        this.l.add(str);
        i1 += 1;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    long l1 = SystemClock.elapsedRealtime();
    if ((q.a().d()) && (l1 - this.s > 120000L) && ((this.t.compareAndSet(false, true)) || (paramBoolean)))
    {
      a(2000L);
      this.s = l1;
    }
  }
  
  public boolean b(long paramLong)
  {
    AtomicBoolean localAtomicBoolean2 = (AtomicBoolean)this.o.get(Long.valueOf(paramLong));
    AtomicBoolean localAtomicBoolean1 = localAtomicBoolean2;
    if (localAtomicBoolean2 == null)
    {
      localAtomicBoolean1 = new AtomicBoolean();
      this.o.put(Long.valueOf(paramLong), localAtomicBoolean1);
    }
    return localAtomicBoolean1.get();
  }
  
  public boolean b(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {}
    do
    {
      return false;
      if (e(paramToServiceMsg)) {
        paramToServiceMsg.setQuickSend(true, 1);
      }
    } while ((this.l.contains(paramToServiceMsg.getServiceCmd())) || (!paramToServiceMsg.isQuickSendEnable()) || (QuickSendStrategy.getStragegyArgs(paramToServiceMsg.getQuickSendStrategy()) == null));
    return true;
  }
  
  public void c()
  {
    this.t.set(false);
  }
  
  public void c(ToServiceMsg paramToServiceMsg)
  {
    a locala;
    b.a locala1;
    if (paramToServiceMsg != null)
    {
      locala = QuickSendStrategy.getStragegyArgs(paramToServiceMsg.getQuickSendStrategy());
      if ((locala != null) && (locala.a >= 1000L))
      {
        locala1 = new b.a(this, paramToServiceMsg);
        if (!com.tencent.mobileqq.msf.core.a.a.aH()) {
          break label68;
        }
        this.q.postDelayed(locala1, 1000L);
      }
    }
    for (;;)
    {
      paramToServiceMsg.getAttributes().put("to_msgtimeoutCallbacker", locala1);
      return;
      label68:
      this.q.postDelayed(locala1, locala.a);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if ((f()) && (com.tencent.mobileqq.msf.core.a.a.bu())) {
      i();
    }
  }
  
  public void d()
  {
    MsfCore.sCore.lightSender.a();
    if (MsfCore.sCore.lightTcpSender != null) {
      MsfCore.sCore.lightTcpSender.c();
    }
  }
  
  public void d(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg != null) && (paramToServiceMsg.getAttributes().containsKey("to_msgtimeoutCallbacker")))
    {
      QLog.d("MSF.C.QuickSendManager", 1, "remove timoutchecker for msg");
      Runnable localRunnable = (Runnable)paramToServiceMsg.getAttributes().get("to_msgtimeoutCallbacker");
      this.q.removeCallbacks(localRunnable);
      paramToServiceMsg.getAttributes().remove("to_msgtimeoutCallbacker");
    }
  }
  
  public void e()
  {
    MsfCore.sCore.lightSender.b();
    if (MsfCore.sCore.lightTcpSender != null) {
      MsfCore.sCore.lightTcpSender.d();
    }
  }
  
  public boolean e(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {}
    do
    {
      Object localObject;
      do
      {
        do
        {
          return false;
          localObject = paramToServiceMsg.getServiceCmd();
        } while ((!"MessageSvc.PbSendMsg".equals(localObject)) && (!"ImgStore.GroupPicUp".equals(localObject)) && (!"ImgStore.GroupPicDown".equals(localObject)) && (!"LongConn.OffPicUp".equals(localObject)) && (!"LongConn.OffPicDown".equals(localObject)));
        localObject = QuickSendStrategy.getStragegyArgs(1);
      } while (localObject == null);
      if (((a)localObject).a >= paramToServiceMsg.getTimeout()) {
        break;
      }
    } while (("MessageSvc.PbSendMsg".equals(paramToServiceMsg.getServiceCmd())) && (!paramToServiceMsg.getAttributes().containsKey("normal_msg")));
    return true;
    QLog.d("MSF.C.QuickSendManager", 1, "no try quicksend request ssoseq: " + paramToServiceMsg.getRequestSsoSeq() + " by timeout error");
    return false;
  }
  
  public void g()
  {
    if ((f()) && (com.tencent.mobileqq.msf.core.a.a.bu())) {
      b(30000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.quicksend.b
 * JD-Core Version:    0.7.0.1
 */