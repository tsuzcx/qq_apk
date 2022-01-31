package com.tencent.mobileqq.msf.core.quicksend;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.af;
import com.tencent.mobileqq.msf.core.aj;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.f;
import com.tencent.mobileqq.msf.core.g;
import com.tencent.mobileqq.msf.core.net.k;
import com.tencent.mobileqq.msf.core.net.m;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class b
{
  public static final String a = "attr_quick_send";
  public static final String b = "attr_quick_send_resend_time";
  public static final String c = "attr_quick_send_time";
  public static final String d = "attr_quick_xg_send_resend_time";
  public static final int e = 3;
  public d f = new d();
  Handler g = new c(this);
  private String h = "QuickSendManager";
  private MsfCore i;
  private final int j = 1;
  private HashSet k = new HashSet();
  private ConcurrentHashMap l = new ConcurrentHashMap();
  private AtomicBoolean m = new AtomicBoolean();
  private long n;
  private volatile Handler o;
  
  public b(MsfCore paramMsfCore)
  {
    this.i = paramMsfCore;
    this.l.clear();
    paramMsfCore = new HandlerThread("MsfCoreHttpTimeoutChecker", 5);
    paramMsfCore.start();
    this.o = new Handler(paramMsfCore.getLooper());
    b();
  }
  
  public static void b(int paramInt)
  {
    if ((MsfCore.sCore.lightTcpSender != null) && (com.tencent.mobileqq.msf.core.a.a.bt()) && (MsfCore.sCore.lightTcpSender.a())) {
      MsfCore.sCore.lightTcpSender.a(paramInt);
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
      this.i.lightSender.a(paramToServiceMsg);
    } while ((this.i.lightTcpSender == null) || (!f()) || (!com.tencent.mobileqq.a.a.a.b()));
    this.i.lightTcpSender.b(paramToServiceMsg);
  }
  
  public static boolean f()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  private boolean g(ToServiceMsg paramToServiceMsg)
  {
    if (TextUtils.isEmpty(paramToServiceMsg.getServiceCmd()))
    {
      QLog.d(this.h, 1, "tryResendMsg fail, cmd is null ");
      return false;
    }
    if (!paramToServiceMsg.isNeedCallback())
    {
      QLog.d(this.h, 1, "tryResendMsg fail, request don't need callback ");
      return false;
    }
    if (this.k.contains(paramToServiceMsg.getServiceCmd()))
    {
      QLog.d(this.h, 1, "tryResendMsg fail, refuse quick send cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq() + " by blacklist");
      return false;
    }
    if ((!paramToServiceMsg.isQuickSendEnable()) || (QuickSendStrategy.getStragegyArgs(paramToServiceMsg.getQuickSendStrategy()) == null))
    {
      QLog.d(this.h, 1, "tryResendMsg fail, refuse quick send cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq() + " by quickSendStrategy error");
      return false;
    }
    if (!this.l.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq())))
    {
      QLog.d(this.h, 1, "tryResendMsg fail, sendQueue don't contain msg, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq());
      return false;
    }
    if (paramToServiceMsg.getAttributes().containsKey("attr_quick_send_resend_time")) {}
    for (int i1 = ((Integer)paramToServiceMsg.getAttributes().get("attr_quick_send_resend_time")).intValue();; i1 = 0)
    {
      a locala = QuickSendStrategy.getStragegyArgs(paramToServiceMsg.getQuickSendStrategy());
      if ((i1 < 0) || (i1 > locala.c))
      {
        QLog.d(this.h, 1, "tryResendMsg fail, msg has resend " + i1 + " times, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + i1);
        return false;
      }
      paramToServiceMsg.getAttributes().put("attr_quick_send_resend_time", Integer.valueOf(i1 + 1));
      long l1 = locala.b;
      if (i1 < com.tencent.mobileqq.msf.core.a.a.aF()) {
        l1 = com.tencent.mobileqq.msf.core.a.a.aE();
      }
      long l2 = l1;
      if (com.tencent.mobileqq.msf.core.a.a.aG())
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
      Message localMessage = this.g.obtainMessage();
      localMessage.what = 1;
      localMessage.arg1 = paramToServiceMsg.getRequestSsoSeq();
      this.g.sendMessageDelayed(localMessage, l2);
      if (QLog.isColorLevel()) {
        QLog.d(this.h, 2, "tryResendMsg cmd:" + paramToServiceMsg.getServiceCmd() + " ssoSeq:" + paramToServiceMsg.getRequestSsoSeq() + " resendIndex: " + (i1 + 1) + " delayed: " + locala.b);
      }
      return true;
    }
  }
  
  public static void h()
  {
    if ((f()) && (com.tencent.mobileqq.msf.core.a.a.bt()) && (com.tencent.mobileqq.a.a.a.b()))
    {
      NetConnInfoCenter.checkConnInfo();
      if (!NetConnInfoCenter.isMobileConn()) {
        k.a(BaseApplication.getContext());
      }
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null) {}
    try
    {
      d(paramToServiceMsg);
      if (this.l.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))) {
        this.l.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
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
    if ((MsfCore.sCore.lightTcpSender != null) && (com.tencent.mobileqq.msf.core.a.a.bt()) && (MsfCore.sCore.lightTcpSender.a())) {
      MsfCore.sCore.lightTcpSender.b();
    }
  }
  
  public Map a()
  {
    return this.l;
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    if (TextUtils.isEmpty(paramToServiceMsg.getServiceCmd()))
    {
      QLog.d(this.h, 1, "addQuickSendQueue fail, cmd is null ");
      return;
    }
    if (!paramToServiceMsg.isNeedCallback())
    {
      QLog.d(this.h, 1, "addQuickSendQueue fail, request don't need callback ");
      return;
    }
    if (this.k.contains(paramToServiceMsg.getServiceCmd()))
    {
      QLog.d(this.h, 1, "addQuickSendQueue fail, refuse quick send cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq() + " by blacklist");
      return;
    }
    if ((!paramToServiceMsg.isQuickSendEnable()) || (QuickSendStrategy.getStragegyArgs(paramToServiceMsg.getQuickSendStrategy()) == null))
    {
      QLog.d(this.h, 1, "addQuickSendQueue fail, refuse quick send cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq() + " by quickSendStrategy error");
      return;
    }
    if (this.l.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq())))
    {
      QLog.d(this.h, 1, "addQuickSendQueue fail, msg has quick send, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq());
      return;
    }
    paramToServiceMsg.getAttributes().put("attr_quick_send", Boolean.valueOf(true));
    paramToServiceMsg.getAttributes().put("light_sender_type", Integer.valueOf(1));
    paramToServiceMsg.getAttributes().put("attr_quick_send_resend_time", Integer.valueOf(0));
    this.l.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
    f(paramToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.isQuickSendEnable())
    {
      QLog.d(this.h, 1, "onRecvNormalResp, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq());
      h(paramToServiceMsg);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    boolean bool = false;
    if (paramToServiceMsg == null) {
      QLog.d(this.h, 1, "onRecvResp toMsg is null");
    }
    do
    {
      return;
      if (paramFromServiceMsg == null)
      {
        QLog.d(this.h, 1, "onRecvResp quicksend fail, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq() + " fromMsg is null");
        return;
      }
      if (paramFromServiceMsg.isSuccess()) {
        break;
      }
      QLog.d(this.h, 1, "onRecvResp quicksend fail, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq() + " code: " + paramFromServiceMsg.getBusinessFailCode() + " failmsg: " + paramFromServiceMsg.getBusinessFailMsg());
    } while (paramFromServiceMsg.getBusinessFailCode() != 2901);
    h(paramToServiceMsg);
    return;
    if (this.l.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))) {
      QLog.d(this.h, 1, "onRecvResp quicksend succ, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq());
    }
    for (;;)
    {
      try
      {
        aj.a(paramToServiceMsg, paramFromServiceMsg, true);
        com.tencent.mobileqq.a.a.a.a().a(paramToServiceMsg, paramFromServiceMsg, true, 0);
        if (com.tencent.mobileqq.msf.core.a.a.aG())
        {
          if (paramInt == 1) {
            bool = true;
          }
          com.tencent.mobileqq.a.a.d.a(paramToServiceMsg, paramFromServiceMsg, bool);
        }
        if ((this.i.quicksender != null) && (this.i.quicksender.b(paramToServiceMsg))) {
          this.i.quicksender.f.b(paramToServiceMsg, paramFromServiceMsg);
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
      this.i.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
      return;
      QLog.d(this.h, 1, "onRecvResp quicksend succ occurred 2901, cmd: " + paramToServiceMsg.getServiceCmd() + " ssoSeq: " + paramToServiceMsg.getRequestSsoSeq());
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
    int i1;
    if (paramFromServiceMsg.getBusinessFailCode() == 1002)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.h, 2, "handleQuickHeartbeat wait " + paramToServiceMsg + " timeout.");
      }
      if (paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.h, 2, "new conn has created, stop quick detectind");
        }
        this.m.set(false);
        i1 = 3;
        paramBoolean = bool;
        if (this.i.statReporter != null)
        {
          paramToServiceMsg = new HashMap();
          if (this.i.getAccountCenter() == null) {
            break label500;
          }
          paramToServiceMsg.put("account", this.i.getAccountCenter().i());
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        paramToServiceMsg.put("closeType", "" + i1);
        this.i.statReporter.a("dim.Msf.QuickSendDetect", paramBoolean, l1, 0L, paramToServiceMsg, false, false);
        return;
        if (!this.i.sender.a.b())
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.h, 2, "conn is also closed, stop quick detecting");
          }
          this.m.set(false);
          i1 = 1;
          paramBoolean = bool;
          break;
        }
        l2 = SystemClock.elapsedRealtime();
        if (l2 > this.n + com.tencent.mobileqq.msf.core.a.a.G())
        {
          this.n = l2;
          try
          {
            QLog.d(this.h, 1, "handleQuickHeartbeat disconn: " + System.currentTimeMillis() + " mLastDetectDisconnTime:" + l2 + " closeConn closeByNetDetectFailedNew");
            this.i.sender.a.a(com.tencent.qphone.base.a.A);
            i1 = 2;
            this.m.set(false);
            paramBoolean = bool;
            break;
          }
          catch (Exception paramToServiceMsg)
          {
            QLog.d(this.h, 1, "handleQuickHeartbeat disconn error", paramToServiceMsg);
            this.m.set(false);
            i1 = 0;
            paramBoolean = bool;
            break;
          }
          finally
          {
            this.m.set(false);
          }
        }
      }
      this.m.set(false);
      QLog.d(this.h, 1, "handleQuickHeartbeat stop disconn by too frequency.");
      i1 = 0;
      paramBoolean = bool;
      break;
      QLog.d(this.h, 1, "recv Quick heart resp.now conn is alive.");
      this.m.set(false);
      paramBoolean = true;
      i1 = 0;
      break;
      label500:
      paramToServiceMsg.put("account", this.i.sender.i());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((f()) && (com.tencent.mobileqq.msf.core.a.a.bt())) {
      i();
    }
  }
  
  public boolean a(int paramInt)
  {
    return this.l.contains(Integer.valueOf(paramInt));
  }
  
  public void b()
  {
    String[] arrayOfString = com.tencent.mobileqq.msf.core.a.a.ad();
    if (arrayOfString == null) {}
    for (;;)
    {
      return;
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = arrayOfString[i1];
        this.k.add(str);
        i1 += 1;
      }
    }
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
    } while ((this.k.contains(paramToServiceMsg.getServiceCmd())) || (!paramToServiceMsg.isQuickSendEnable()) || (QuickSendStrategy.getStragegyArgs(paramToServiceMsg.getQuickSendStrategy()) == null));
    return true;
  }
  
  public void c()
  {
    if (this.m.get())
    {
      QLog.d(this.h, 1, "quick heart beat has sending, return.");
      return;
    }
    if (this.i.sender.a.b())
    {
      this.m.set(true);
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "Heartbeat.Ping");
      localToServiceMsg.setMsfCommand(MsfCommand._msf_QuickHeartBeat);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.setAppId(this.i.getMsfAppid());
      localToServiceMsg.putWupBuffer(new byte[] { 0, 0, 0, 4 });
      localToServiceMsg.setTimeout(com.tencent.mobileqq.msf.core.a.a.F());
      localToServiceMsg.getAttributes().put("quickSendDetectTime", Long.valueOf(SystemClock.elapsedRealtime()));
      this.i.sender.a(localToServiceMsg);
      return;
    }
    this.m.set(false);
  }
  
  public void c(ToServiceMsg paramToServiceMsg)
  {
    a locala;
    a locala1;
    if (paramToServiceMsg != null)
    {
      locala = QuickSendStrategy.getStragegyArgs(paramToServiceMsg.getQuickSendStrategy());
      if ((locala != null) && (locala.a >= 1000L))
      {
        locala1 = new a(paramToServiceMsg);
        if (!com.tencent.mobileqq.msf.core.a.a.aG()) {
          break label68;
        }
        this.o.postDelayed(locala1, 1000L);
      }
    }
    for (;;)
    {
      paramToServiceMsg.getAttributes().put("to_msgtimeoutCallbacker", locala1);
      return;
      label68:
      this.o.postDelayed(locala1, locala.a);
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
      QLog.d(this.h, 1, "remove timoutchecker for msg");
      Runnable localRunnable = (Runnable)paramToServiceMsg.getAttributes().get("to_msgtimeoutCallbacker");
      this.o.removeCallbacks(localRunnable);
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
    QLog.d(this.h, 1, "no try quicksend request ssoseq: " + paramToServiceMsg.getRequestSsoSeq() + " by timeout error");
    return false;
  }
  
  public void g()
  {
    if ((f()) && (com.tencent.mobileqq.msf.core.a.a.bt())) {
      b(30000);
    }
  }
  
  class a
    implements Runnable
  {
    private ToServiceMsg b;
    
    public a(ToServiceMsg paramToServiceMsg)
    {
      this.b = paramToServiceMsg;
    }
    
    public void run()
    {
      if (this.b == null) {
        QLog.d(b.b(b.this), 1, "req null, return.");
      }
      for (;;)
      {
        return;
        try
        {
          if ((b.c(b.this).quicksender != null) && (b.c(b.this).quicksender.b(this.b))) {
            b.c(b.this).quicksender.f.b(this.b);
          }
          b.this.a(this.b);
          a locala = QuickSendStrategy.getStragegyArgs(this.b.getQuickSendStrategy());
          if ((com.tencent.mobileqq.msf.core.a.a.bo()) && (locala != null) && (locala.d)) {
            b.this.c();
          }
          if ((!com.tencent.mobileqq.msf.core.a.a.aG()) || (!this.b.getServiceCmd().equals("MessageSvc.PbSendMsg"))) {
            continue;
          }
          com.tencent.mobileqq.a.a.d.a(this.b);
          return;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localThrowable.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.quicksend.b
 * JD-Core Version:    0.7.0.1
 */