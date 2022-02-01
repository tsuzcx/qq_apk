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
import com.tencent.mobileqq.msf.core.ad;
import com.tencent.mobileqq.msf.core.aj;
import com.tencent.mobileqq.msf.core.d.j;
import com.tencent.mobileqq.msf.core.g;
import com.tencent.mobileqq.msf.core.h;
import com.tencent.mobileqq.msf.core.i;
import com.tencent.mobileqq.msf.core.net.d.a.k;
import com.tencent.mobileqq.msf.core.net.l;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
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
  public e f = new e();
  Handler h = new d(this);
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
    return b(paramLong) ^ true;
  }
  
  public static boolean g()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  private void h(ToServiceMsg paramToServiceMsg)
  {
    com.tencent.mobileqq.msf.core.net.d.a.a().a(paramToServiceMsg, new c(this));
  }
  
  public static void i()
  {
    if ((g()) && (com.tencent.mobileqq.msf.core.a.a.bu()) && (com.tencent.mobileqq.a.a.a.b()))
    {
      NetConnInfoCenter.checkConnInfo();
      if (!NetConnInfoCenter.isMobileConn()) {
        l.a(BaseApplication.getContext());
      }
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    if (!j(paramToServiceMsg))
    {
      b(paramToServiceMsg);
      return;
    }
    this.j.lightSender.a(paramToServiceMsg);
    if ((this.j.lightTcpSender != null) && (g()) && (com.tencent.mobileqq.a.a.a.b())) {
      this.j.lightTcpSender.b(paramToServiceMsg);
    }
    if (k.a().b(paramToServiceMsg))
    {
      MsfService.core.getStatReporter().a("MSF_WN_HttpSendCount", true, 0L, 0L, new TreeMap(), false, false);
      if (QLog.isDebugVersion()) {
        QLog.d("[ReportBeacon]", 1, "HttpSend.");
      }
    }
  }
  
  public static void j()
  {
    if ((MsfCore.sCore.lightTcpSender != null) && (com.tencent.mobileqq.msf.core.a.a.bu()) && (MsfCore.sCore.lightTcpSender.a())) {
      MsfCore.sCore.lightTcpSender.b();
    }
  }
  
  private boolean j(ToServiceMsg paramToServiceMsg)
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
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("tryResendMsg fail, refuse quick send cmd: ");
      ((StringBuilder)localObject1).append(paramToServiceMsg.getServiceCmd());
      ((StringBuilder)localObject1).append(" ssoSeq: ");
      ((StringBuilder)localObject1).append(paramToServiceMsg.getRequestSsoSeq());
      ((StringBuilder)localObject1).append(" by blacklist");
      QLog.d("MSF.C.QuickSendManager", 1, ((StringBuilder)localObject1).toString());
      return false;
    }
    if ((paramToServiceMsg.isQuickSendEnable()) && (QuickSendStrategy.getStragegyArgs(paramToServiceMsg.getQuickSendStrategy()) != null))
    {
      if (!this.m.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq())))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("tryResendMsg fail, sendQueue don't contain msg, cmd: ");
        ((StringBuilder)localObject1).append(paramToServiceMsg.getServiceCmd());
        ((StringBuilder)localObject1).append(" ssoSeq: ");
        ((StringBuilder)localObject1).append(paramToServiceMsg.getRequestSsoSeq());
        QLog.d("MSF.C.QuickSendManager", 1, ((StringBuilder)localObject1).toString());
        return false;
      }
      int i1;
      if (paramToServiceMsg.getAttributes().containsKey("attr_quick_send_resend_time")) {
        i1 = ((Integer)paramToServiceMsg.getAttributes().get("attr_quick_send_resend_time")).intValue();
      } else {
        i1 = 0;
      }
      localObject1 = QuickSendStrategy.getStragegyArgs(paramToServiceMsg.getQuickSendStrategy());
      if ((i1 >= 0) && (i1 <= ((a)localObject1).c))
      {
        Object localObject2 = paramToServiceMsg.getAttributes();
        int i2 = i1 + 1;
        ((HashMap)localObject2).put("attr_quick_send_resend_time", Integer.valueOf(i2));
        long l1 = ((a)localObject1).b;
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
              l2 = ((a)localObject1).a - 1000L;
            }
          }
        }
        i();
        localObject2 = this.h.obtainMessage();
        ((Message)localObject2).what = 1;
        ((Message)localObject2).arg1 = paramToServiceMsg.getRequestSsoSeq();
        this.h.sendMessageDelayed((Message)localObject2, l2);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("tryResendMsg cmd:");
          ((StringBuilder)localObject2).append(paramToServiceMsg.getServiceCmd());
          ((StringBuilder)localObject2).append(" ssoSeq:");
          ((StringBuilder)localObject2).append(paramToServiceMsg.getRequestSsoSeq());
          ((StringBuilder)localObject2).append(" resendIndex: ");
          ((StringBuilder)localObject2).append(i2);
          ((StringBuilder)localObject2).append(" delayed: ");
          ((StringBuilder)localObject2).append(((a)localObject1).b);
          QLog.d("MSF.C.QuickSendManager", 2, ((StringBuilder)localObject2).toString());
        }
        return true;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("tryResendMsg fail, msg has resend ");
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append(" times, cmd: ");
      ((StringBuilder)localObject1).append(paramToServiceMsg.getServiceCmd());
      ((StringBuilder)localObject1).append(" ssoSeq: ");
      ((StringBuilder)localObject1).append(i1);
      QLog.d("MSF.C.QuickSendManager", 1, ((StringBuilder)localObject1).toString());
      return false;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("tryResendMsg fail, refuse quick send cmd: ");
    ((StringBuilder)localObject1).append(paramToServiceMsg.getServiceCmd());
    ((StringBuilder)localObject1).append(" ssoSeq: ");
    ((StringBuilder)localObject1).append(paramToServiceMsg.getRequestSsoSeq());
    ((StringBuilder)localObject1).append(" by quickSendStrategy error");
    QLog.d("MSF.C.QuickSendManager", 1, ((StringBuilder)localObject1).toString());
    return false;
  }
  
  private void k()
  {
    FromServiceMsg localFromServiceMsg = new FromServiceMsg(this.j.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_wake_from_deep_sleep");
    localFromServiceMsg.setMsgSuccess();
    localFromServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
    MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
    this.j.addRespToQuque(null, localFromServiceMsg);
    QLog.d("MSF.C.QuickSendManager", 1, new Object[] { "[sendWakeFromDsMsg] msg: ", com.tencent.mobileqq.msf.core.b.a.a(localFromServiceMsg) });
  }
  
  private boolean l()
  {
    boolean bool = BaseApplication.getContext().getSharedPreferences("common_sp_for_msf", 4).getBoolean("isSendQuickHBBackToForeground", false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isSendQuickHBBackToForeground = ");
    localStringBuilder.append(bool);
    QLog.d("MSF.C.QuickSendManager", 1, localStringBuilder.toString());
    return bool;
  }
  
  public Map a()
  {
    return this.m;
  }
  
  public void a(long paramLong)
  {
    Object localObject;
    if (!c(paramLong))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("quick heart beat has sending, timeout = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", so return.");
      QLog.d("MSF.C.QuickSendManager", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (this.j.sender.b.b())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendQuickHeartBeat, timeout = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("MSF.C.QuickSendManager", 1, ((StringBuilder)localObject).toString());
      a(paramLong, true);
      localObject = new ToServiceMsg("", "0", "Heartbeat.Ping");
      ((ToServiceMsg)localObject).setMsfCommand(MsfCommand._msf_QuickHeartBeat);
      ((ToServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
      ((ToServiceMsg)localObject).setAppId(this.j.getMsfAppid());
      ((ToServiceMsg)localObject).putWupBuffer(new byte[] { 0, 0, 0, 4 });
      ((ToServiceMsg)localObject).setTimeout(paramLong);
      ((ToServiceMsg)localObject).getAttributes().put("quickSendDetectTime", Long.valueOf(SystemClock.elapsedRealtime()));
      this.j.sender.a((ToServiceMsg)localObject);
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
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("addQuickSendQueue fail, refuse quick send cmd: ");
      localStringBuilder.append(paramToServiceMsg.getServiceCmd());
      localStringBuilder.append(" ssoSeq: ");
      localStringBuilder.append(paramToServiceMsg.getRequestSsoSeq());
      localStringBuilder.append(" by blacklist");
      QLog.d("MSF.C.QuickSendManager", 1, localStringBuilder.toString());
      return;
    }
    if ((paramToServiceMsg.isQuickSendEnable()) && (QuickSendStrategy.getStragegyArgs(paramToServiceMsg.getQuickSendStrategy()) != null))
    {
      if (this.m.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq())))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("addQuickSendQueue fail, msg has quick send, cmd: ");
        localStringBuilder.append(paramToServiceMsg.getServiceCmd());
        localStringBuilder.append(" ssoSeq: ");
        localStringBuilder.append(paramToServiceMsg.getRequestSsoSeq());
        QLog.d("MSF.C.QuickSendManager", 1, localStringBuilder.toString());
        return;
      }
      paramToServiceMsg.getAttributes().put("attr_quick_send", Boolean.valueOf(true));
      paramToServiceMsg.getAttributes().put("light_sender_type", Integer.valueOf(1));
      paramToServiceMsg.getAttributes().put("attr_quick_send_resend_time", Integer.valueOf(0));
      this.m.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
      i(paramToServiceMsg);
      h(paramToServiceMsg);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addQuickSendQueue fail, refuse quick send cmd: ");
    localStringBuilder.append(paramToServiceMsg.getServiceCmd());
    localStringBuilder.append(" ssoSeq: ");
    localStringBuilder.append(paramToServiceMsg.getRequestSsoSeq());
    localStringBuilder.append(" by quickSendStrategy error");
    QLog.d("MSF.C.QuickSendManager", 1, localStringBuilder.toString());
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.isQuickSendEnable())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("onRecvNormalResp, cmd: ");
      paramFromServiceMsg.append(paramToServiceMsg.getServiceCmd());
      paramFromServiceMsg.append(" ssoSeq: ");
      paramFromServiceMsg.append(paramToServiceMsg.getRequestSsoSeq());
      QLog.d("MSF.C.QuickSendManager", 1, paramFromServiceMsg.toString());
      b(paramToServiceMsg);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    if (paramToServiceMsg == null)
    {
      QLog.d("MSF.C.QuickSendManager", 1, "onRecvResp toMsg is null");
      return;
    }
    StringBuilder localStringBuilder;
    if (paramFromServiceMsg == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvResp quicksend fail, cmd: ");
      localStringBuilder.append(paramToServiceMsg.getServiceCmd());
      localStringBuilder.append(" ssoSeq: ");
      localStringBuilder.append(paramToServiceMsg.getRequestSsoSeq());
      localStringBuilder.append(" fromMsg is null");
      QLog.d("MSF.C.QuickSendManager", 1, localStringBuilder.toString());
    }
    else if (!paramFromServiceMsg.isSuccess())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvResp quicksend fail, cmd: ");
      localStringBuilder.append(paramToServiceMsg.getServiceCmd());
      localStringBuilder.append(" ssoSeq: ");
      localStringBuilder.append(paramToServiceMsg.getRequestSsoSeq());
      localStringBuilder.append(" code: ");
      localStringBuilder.append(paramFromServiceMsg.getBusinessFailCode());
      localStringBuilder.append(" failmsg: ");
      localStringBuilder.append(paramFromServiceMsg.getBusinessFailMsg());
      QLog.d("MSF.C.QuickSendManager", 1, localStringBuilder.toString());
      if (paramFromServiceMsg.getBusinessFailCode() == 2901) {
        b(paramToServiceMsg);
      }
    }
    else if (this.m.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq())))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvResp quicksend succ, cmd: ");
      localStringBuilder.append(paramToServiceMsg.getServiceCmd());
      localStringBuilder.append(" ssoSeq: ");
      localStringBuilder.append(paramToServiceMsg.getRequestSsoSeq());
      QLog.d("MSF.C.QuickSendManager", 1, localStringBuilder.toString());
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvResp quicksend succ occurred 2901, cmd: ");
      localStringBuilder.append(paramToServiceMsg.getServiceCmd());
      localStringBuilder.append(" ssoSeq: ");
      localStringBuilder.append(paramToServiceMsg.getRequestSsoSeq());
      QLog.d("MSF.C.QuickSendManager", 1, localStringBuilder.toString());
    }
    for (;;)
    {
      try
      {
        aj.a(paramToServiceMsg, paramFromServiceMsg, true);
        com.tencent.mobileqq.a.a.a.a().a(paramToServiceMsg, paramFromServiceMsg, true, 0);
        if (com.tencent.mobileqq.msf.core.a.a.aH())
        {
          if (paramInt != 1) {
            break label546;
          }
          bool = true;
          com.tencent.mobileqq.a.a.d.a(paramToServiceMsg, paramFromServiceMsg, bool);
        }
        if ((this.j.quicksender != null) && (this.j.quicksender.d(paramToServiceMsg))) {
          this.j.quicksender.f.b(paramToServiceMsg, paramFromServiceMsg);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      b(paramToServiceMsg);
      paramFromServiceMsg.getAttributes().put("_attr_send_by_quickHttp", Boolean.valueOf(true));
      paramFromServiceMsg.setAppId(paramToServiceMsg.getAppId());
      paramFromServiceMsg.setAppSeq(paramToServiceMsg.getAppSeq());
      paramFromServiceMsg.setMsfCommand(paramToServiceMsg.getMsfCommand());
      this.j.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
      if (this.j.statReporter != null)
      {
        paramToServiceMsg = this.j.statReporter;
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
          bool = true;
        } else {
          bool = false;
        }
        paramToServiceMsg.a("EvtQuickSend", bool, 0L, 0L, new HashMap(), true, false);
      }
      return;
      label546:
      boolean bool = false;
    }
  }
  
  /* Error */
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 9
    //   3: lload 9
    //   5: lstore 7
    //   7: aload_1
    //   8: ifnull +57 -> 65
    //   11: lload 9
    //   13: lstore 7
    //   15: aload_1
    //   16: invokevirtual 369	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   19: ldc_w 557
    //   22: invokevirtual 372	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   25: ifeq +40 -> 65
    //   28: aload_1
    //   29: invokevirtual 369	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   32: ldc_w 557
    //   35: invokevirtual 373	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast 125	java/lang/Long
    //   41: invokevirtual 201	java/lang/Long:longValue	()J
    //   44: lstore 11
    //   46: lload 9
    //   48: lstore 7
    //   50: lload 11
    //   52: lconst_0
    //   53: lcmp
    //   54: ifle +11 -> 65
    //   57: invokestatic 562	android/os/SystemClock:elapsedRealtime	()J
    //   60: lload 11
    //   62: lsub
    //   63: lstore 7
    //   65: aload_2
    //   66: invokevirtual 599	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailCode	()I
    //   69: istore 5
    //   71: iconst_1
    //   72: istore 4
    //   74: iload 5
    //   76: sipush 1002
    //   79: if_icmpne +351 -> 430
    //   82: invokestatic 424	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: istore 6
    //   87: iconst_2
    //   88: istore 5
    //   90: iload 6
    //   92: ifeq +43 -> 135
    //   95: new 322	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 323	java/lang/StringBuilder:<init>	()V
    //   102: astore_2
    //   103: aload_2
    //   104: ldc_w 660
    //   107: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_2
    //   112: aload_1
    //   113: invokevirtual 663	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload_2
    //   118: ldc_w 665
    //   121: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: ldc 27
    //   127: iconst_2
    //   128: aload_2
    //   129: invokevirtual 343	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 298	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: iload_3
    //   136: ifeq +32 -> 168
    //   139: invokestatic 424	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq +12 -> 154
    //   145: ldc 27
    //   147: iconst_2
    //   148: ldc_w 667
    //   151: invokestatic 298	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aload_0
    //   155: aload_1
    //   156: iconst_0
    //   157: invokespecial 669	com/tencent/mobileqq/msf/core/quicksend/b:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Z)V
    //   160: iconst_3
    //   161: istore 4
    //   163: iconst_0
    //   164: istore_3
    //   165: goto +285 -> 450
    //   168: aload_0
    //   169: getfield 94	com/tencent/mobileqq/msf/core/quicksend/b:j	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   172: getfield 515	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   175: getfield 520	com/tencent/mobileqq/msf/core/ad:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   178: invokevirtual 523	com/tencent/mobileqq/msf/core/net/n:b	()Z
    //   181: ifne +27 -> 208
    //   184: invokestatic 424	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq +12 -> 199
    //   190: ldc 27
    //   192: iconst_2
    //   193: ldc_w 671
    //   196: invokestatic 298	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: aload_0
    //   200: aload_1
    //   201: iconst_0
    //   202: invokespecial 669	com/tencent/mobileqq/msf/core/quicksend/b:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Z)V
    //   205: goto -42 -> 163
    //   208: invokestatic 562	android/os/SystemClock:elapsedRealtime	()J
    //   211: lstore 9
    //   213: lload 9
    //   215: aload_0
    //   216: getfield 71	com/tencent/mobileqq/msf/core/quicksend/b:p	J
    //   219: invokestatic 674	com/tencent/mobileqq/msf/core/a/a:H	()J
    //   222: ladd
    //   223: lcmp
    //   224: ifle +185 -> 409
    //   227: aload_0
    //   228: lload 9
    //   230: putfield 71	com/tencent/mobileqq/msf/core/quicksend/b:p	J
    //   233: new 322	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 323	java/lang/StringBuilder:<init>	()V
    //   240: astore_2
    //   241: aload_2
    //   242: ldc_w 676
    //   245: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload_2
    //   250: invokestatic 681	java/lang/System:currentTimeMillis	()J
    //   253: invokevirtual 435	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload_2
    //   258: ldc_w 683
    //   261: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload_2
    //   266: lload 9
    //   268: invokevirtual 435	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload_2
    //   273: ldc_w 685
    //   276: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: ldc 27
    //   282: iconst_1
    //   283: aload_2
    //   284: invokevirtual 343	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 298	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: aload_0
    //   291: getfield 94	com/tencent/mobileqq/msf/core/quicksend/b:j	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   294: getfield 515	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   297: getfield 520	com/tencent/mobileqq/msf/core/ad:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   300: getstatic 691	com/tencent/qphone/base/a:A	Lcom/tencent/qphone/base/a;
    //   303: invokevirtual 694	com/tencent/mobileqq/msf/core/net/n:a	(Lcom/tencent/qphone/base/a;)V
    //   306: iload 5
    //   308: istore 4
    //   310: aload_1
    //   311: ifnull +57 -> 368
    //   314: iload 5
    //   316: istore 4
    //   318: aload_1
    //   319: invokevirtual 151	com/tencent/qphone/base/remote/ToServiceMsg:getTimeout	()J
    //   322: ldc2_w 23
    //   325: lcmp
    //   326: ifne +42 -> 368
    //   329: iload 5
    //   331: istore 4
    //   333: aload_0
    //   334: getfield 94	com/tencent/mobileqq/msf/core/quicksend/b:j	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   337: invokevirtual 276	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/d/j;
    //   340: ifnull +28 -> 368
    //   343: aload_0
    //   344: getfield 94	com/tencent/mobileqq/msf/core/quicksend/b:j	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   347: invokevirtual 276	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/d/j;
    //   350: invokevirtual 696	com/tencent/mobileqq/msf/core/d/j:l	()V
    //   353: iload 5
    //   355: istore 4
    //   357: goto +11 -> 368
    //   360: astore_2
    //   361: iload 5
    //   363: istore 4
    //   365: goto +20 -> 385
    //   368: aload_0
    //   369: aload_1
    //   370: iconst_0
    //   371: invokespecial 669	com/tencent/mobileqq/msf/core/quicksend/b:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Z)V
    //   374: goto +24 -> 398
    //   377: astore_2
    //   378: goto +23 -> 401
    //   381: astore_2
    //   382: iconst_0
    //   383: istore 4
    //   385: ldc 27
    //   387: iconst_1
    //   388: ldc_w 698
    //   391: aload_2
    //   392: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   395: goto -27 -> 368
    //   398: goto -235 -> 163
    //   401: aload_0
    //   402: aload_1
    //   403: iconst_0
    //   404: invokespecial 669	com/tencent/mobileqq/msf/core/quicksend/b:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Z)V
    //   407: aload_2
    //   408: athrow
    //   409: aload_0
    //   410: aload_1
    //   411: iconst_0
    //   412: invokespecial 669	com/tencent/mobileqq/msf/core/quicksend/b:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Z)V
    //   415: ldc 27
    //   417: iconst_1
    //   418: ldc_w 703
    //   421: invokestatic 298	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   424: iconst_0
    //   425: istore 4
    //   427: goto -264 -> 163
    //   430: ldc 27
    //   432: iconst_1
    //   433: ldc_w 705
    //   436: invokestatic 298	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   439: aload_0
    //   440: aload_1
    //   441: iconst_0
    //   442: invokespecial 669	com/tencent/mobileqq/msf/core/quicksend/b:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Z)V
    //   445: iconst_1
    //   446: istore_3
    //   447: iconst_0
    //   448: istore 4
    //   450: aload_0
    //   451: getfield 94	com/tencent/mobileqq/msf/core/quicksend/b:j	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   454: getfield 655	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   457: ifnull +170 -> 627
    //   460: new 371	java/util/HashMap
    //   463: dup
    //   464: invokespecial 658	java/util/HashMap:<init>	()V
    //   467: astore_2
    //   468: aload_0
    //   469: getfield 94	com/tencent/mobileqq/msf/core/quicksend/b:j	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   472: invokevirtual 709	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
    //   475: ifnull +24 -> 499
    //   478: aload_2
    //   479: ldc_w 711
    //   482: aload_0
    //   483: getfield 94	com/tencent/mobileqq/msf/core/quicksend/b:j	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   486: invokevirtual 709	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
    //   489: invokevirtual 715	com/tencent/mobileqq/msf/core/auth/b:i	()Ljava/lang/String;
    //   492: invokevirtual 381	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   495: pop
    //   496: goto +21 -> 517
    //   499: aload_2
    //   500: ldc_w 711
    //   503: aload_0
    //   504: getfield 94	com/tencent/mobileqq/msf/core/quicksend/b:j	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   507: getfield 515	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   510: invokevirtual 717	com/tencent/mobileqq/msf/core/ad:l	()Ljava/lang/String;
    //   513: invokevirtual 381	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   516: pop
    //   517: new 322	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 323	java/lang/StringBuilder:<init>	()V
    //   524: astore 13
    //   526: aload 13
    //   528: ldc_w 527
    //   531: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: aload 13
    //   537: iload 4
    //   539: invokevirtual 338	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: aload_2
    //   544: ldc_w 719
    //   547: aload 13
    //   549: invokevirtual 343	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   552: invokevirtual 381	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   555: pop
    //   556: aload_1
    //   557: ifnull +12 -> 569
    //   560: aload_1
    //   561: invokevirtual 151	com/tencent/qphone/base/remote/ToServiceMsg:getTimeout	()J
    //   564: lstore 9
    //   566: goto +8 -> 574
    //   569: ldc2_w 720
    //   572: lstore 9
    //   574: aload_2
    //   575: ldc_w 723
    //   578: lload 9
    //   580: invokestatic 726	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   583: invokevirtual 381	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   586: pop
    //   587: aload_0
    //   588: getfield 94	com/tencent/mobileqq/msf/core/quicksend/b:j	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   591: getfield 655	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   594: ldc_w 728
    //   597: iload_3
    //   598: lload 7
    //   600: lconst_0
    //   601: aload_2
    //   602: iconst_1
    //   603: iconst_0
    //   604: invokevirtual 286	com/tencent/mobileqq/msf/core/d/j:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   607: aload_0
    //   608: getfield 94	com/tencent/mobileqq/msf/core/quicksend/b:j	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   611: getfield 655	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   614: ldc_w 730
    //   617: iload_3
    //   618: lload 7
    //   620: lconst_0
    //   621: aload_2
    //   622: iconst_0
    //   623: iconst_0
    //   624: invokevirtual 286	com/tencent/mobileqq/msf/core/d/j:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   627: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	628	0	this	b
    //   0	628	1	paramToServiceMsg	ToServiceMsg
    //   0	628	2	paramFromServiceMsg	FromServiceMsg
    //   0	628	3	paramBoolean	boolean
    //   72	466	4	i1	int
    //   69	293	5	i2	int
    //   85	6	6	bool	boolean
    //   5	614	7	l1	long
    //   1	578	9	l2	long
    //   44	17	11	l3	long
    //   524	24	13	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   318	329	360	java/lang/Exception
    //   333	353	360	java/lang/Exception
    //   233	306	377	finally
    //   318	329	377	finally
    //   333	353	377	finally
    //   385	395	377	finally
    //   233	306	381	java/lang/Exception
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) || (l())) {
      d();
    }
    if (paramBoolean) {
      k();
    }
  }
  
  public boolean a(int paramInt)
  {
    return this.m.contains(Integer.valueOf(paramInt));
  }
  
  public void b()
  {
    String[] arrayOfString = com.tencent.mobileqq.msf.core.a.a.ae();
    if (arrayOfString == null) {
      return;
    }
    int i2 = arrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str = arrayOfString[i1];
      this.l.add(str);
      i1 += 1;
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null) {
      try
      {
        f(paramToServiceMsg);
        if (this.m.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))) {
          this.m.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
        }
        if (MsfCore.sCore.lightTcpSender != null) {
          MsfCore.sCore.lightTcpSender.a(paramToServiceMsg);
        }
      }
      finally {}
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((g()) && (com.tencent.mobileqq.msf.core.a.a.bu())) {
      j();
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
  
  public void c()
  {
    this.t.set(false);
  }
  
  public boolean c(ToServiceMsg paramToServiceMsg)
  {
    boolean bool2 = false;
    if (paramToServiceMsg == null) {
      return false;
    }
    boolean bool1;
    if (!this.m.contains(paramToServiceMsg))
    {
      bool1 = bool2;
      if (MsfCore.sCore.lightTcpSender != null)
      {
        bool1 = bool2;
        if (!MsfCore.sCore.lightTcpSender.c(paramToServiceMsg)) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public void d()
  {
    long l1 = SystemClock.elapsedRealtime();
    boolean bool;
    if ((i.a().f()) && (l1 - this.s > 120000L) && (this.t.compareAndSet(false, true))) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      a(2000L);
      this.s = l1;
    }
    QLog.d("MSF.C.QuickSendManager", 1, new Object[] { "[sendQuickHeartbeatIfNeed] need: ", Boolean.valueOf(bool) });
  }
  
  public boolean d(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return false;
    }
    if (g(paramToServiceMsg)) {
      paramToServiceMsg.setQuickSend(true, 1);
    }
    return (!this.l.contains(paramToServiceMsg.getServiceCmd())) && (paramToServiceMsg.isQuickSendEnable()) && (QuickSendStrategy.getStragegyArgs(paramToServiceMsg.getQuickSendStrategy()) != null);
  }
  
  public void e()
  {
    MsfCore.sCore.lightSender.a();
    if (MsfCore.sCore.lightTcpSender != null) {
      MsfCore.sCore.lightTcpSender.c();
    }
  }
  
  public void e(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      a locala = QuickSendStrategy.getStragegyArgs(paramToServiceMsg.getQuickSendStrategy());
      if ((locala != null) && (locala.a >= 1000L))
      {
        b.a locala1 = new b.a(this, paramToServiceMsg);
        if (com.tencent.mobileqq.msf.core.a.a.aH()) {
          this.q.postDelayed(locala1, 1000L);
        } else {
          this.q.postDelayed(locala1, locala.a);
        }
        paramToServiceMsg.getAttributes().put("to_msgtimeoutCallbacker", locala1);
      }
    }
  }
  
  public void f()
  {
    MsfCore.sCore.lightSender.b();
    if (MsfCore.sCore.lightTcpSender != null) {
      MsfCore.sCore.lightTcpSender.d();
    }
  }
  
  public void f(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg != null) && (paramToServiceMsg.getAttributes().containsKey("to_msgtimeoutCallbacker")))
    {
      QLog.d("MSF.C.QuickSendManager", 1, "remove timoutchecker for msg");
      Runnable localRunnable = (Runnable)paramToServiceMsg.getAttributes().get("to_msgtimeoutCallbacker");
      this.q.removeCallbacks(localRunnable);
      paramToServiceMsg.getAttributes().remove("to_msgtimeoutCallbacker");
    }
  }
  
  public boolean g(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return false;
    }
    Object localObject = paramToServiceMsg.getServiceCmd();
    if (("MessageSvc.PbSendMsg".equals(localObject)) || ("ImgStore.GroupPicUp".equals(localObject)) || ("ImgStore.GroupPicDown".equals(localObject)) || ("LongConn.OffPicUp".equals(localObject)) || ("LongConn.OffPicDown".equals(localObject)))
    {
      localObject = QuickSendStrategy.getStragegyArgs(1);
      if (localObject != null)
      {
        if (((a)localObject).a < paramToServiceMsg.getTimeout()) {
          return (!"MessageSvc.PbSendMsg".equals(paramToServiceMsg.getServiceCmd())) || (paramToServiceMsg.getAttributes().containsKey("normal_msg"));
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("no try quicksend request ssoseq: ");
        ((StringBuilder)localObject).append(paramToServiceMsg.getRequestSsoSeq());
        ((StringBuilder)localObject).append(" by timeout error");
        QLog.d("MSF.C.QuickSendManager", 1, ((StringBuilder)localObject).toString());
      }
    }
    return false;
  }
  
  public void h()
  {
    if ((g()) && (com.tencent.mobileqq.msf.core.a.a.bu())) {
      b(30000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.quicksend.b
 * JD-Core Version:    0.7.0.1
 */