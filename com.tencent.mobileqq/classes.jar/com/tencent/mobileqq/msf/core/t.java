package com.tencent.mobileqq.msf.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.d.j;
import com.tencent.mobileqq.msf.core.net.b.o;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.core.push.g;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.a.a.b;
import com.tencent.mobileqq.msf.sdk.a.a.c;
import com.tencent.mobileqq.msf.service.l;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.security.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class t
  implements a.b, a.c
{
  public static final String a = "MSF.D.NetCenterNewImpl";
  public static MsfCore b;
  public static final String c = "recordSysTimeKey";
  public static final int d = 100;
  private static final String k = "servetTimeDiff";
  private static long l = -1L;
  private static long m = 0L;
  private static final String n = "dozeWhiteList";
  private static final String o = "keyDozeLastTime";
  private static final long p = 86400000L;
  int e;
  int f;
  int g;
  boolean h = true;
  private com.tencent.mobileqq.msf.sdk.a.a i;
  private String j = "MSF.C.NetConnInfoCenter";
  private ThreadLocal q = new ThreadLocal();
  private AtomicBoolean r = new AtomicBoolean(false);
  private ThreadLocal s = new ThreadLocal();
  private boolean t = false;
  private AtomicBoolean u = new AtomicBoolean();
  private long v = 0L;
  private long w = 0L;
  private int x = 0;
  private long y = 0L;
  
  private t()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.processName);
    localStringBuilder.append(" create NetConnInfoCenterNewImpl instance");
    QLog.i("MSF.D.NetCenterNewImpl", 1, localStringBuilder.toString());
    this.i = new com.tencent.mobileqq.msf.sdk.a.a();
    this.i.a(this);
    this.i.a(q.d());
  }
  
  private void E()
  {
    this.u.set(false);
    this.v = 0L;
  }
  
  private void F()
  {
    if ((this.i.i() > 0) && (this.u.get()))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_Reason", String.valueOf((System.currentTimeMillis() - this.v) / 1000L));
      localHashMap.put("param_connecttrycount", String.valueOf(this.i.i()));
      if (b.getStatReporter() != null) {
        b.getStatReporter().a("dim_Msf_NoNetInfoConnSucc", false, 0L, 0L, localHashMap, false, false);
      }
      E();
    }
  }
  
  private void G()
  {
    F();
    ad.c("");
    ad.d(0);
    I();
    MsfCore localMsfCore = b;
    if ((localMsfCore != null) && (localMsfCore.pushManager != null)) {
      b.pushManager.c();
    }
  }
  
  private void H()
  {
    if (o())
    {
      MsfCore localMsfCore = b;
      if ((localMsfCore != null) && (localMsfCore.standbyModeManager != null)) {
        b.standbyModeManager.d();
      }
    }
  }
  
  private void I()
  {
    MsfCore localMsfCore = b;
    if ((localMsfCore != null) && (localMsfCore.sender != null) && (b.getStatReporter() != null)) {
      b.getStatReporter().i();
    }
  }
  
  private void J()
  {
    if (b != null)
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "login.time");
      localToServiceMsg.setMsfCommand(MsfCommand.getServerTime);
      int i1;
      if (b.sender.m() == -1) {
        i1 = 100;
      } else {
        i1 = b.sender.m();
      }
      localToServiceMsg.setAppId(i1);
      localToServiceMsg.setTimeout(30000L);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setServantName("test");
      localUniPacket.setFuncName("cmdstr");
      d locald = new d(1, 15, MsfCore.getNextSeq(), 1, "0", b.sender.m(), String.valueOf(b.sender.m()), "123", 0);
      com.tencent.msf.service.protocol.security.c localc = new com.tencent.msf.service.protocol.security.c();
      localc.a = ((int)(System.currentTimeMillis() / 1000L));
      localUniPacket.put("RequestHeader", locald);
      localUniPacket.put("RequestGetServerTime", localc);
      localToServiceMsg.putWupBuffer(localUniPacket.encode());
      b.sender.b(localToServiceMsg);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.D.NetCenterNewImpl", 4, "msfCore not inited. can not send checkServerTimeMsg.");
    }
  }
  
  private void K()
  {
    if (b != null)
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "Client.CorrectTime");
      localToServiceMsg.setMsfCommand(MsfCommand.getServerTime);
      int i1;
      if (b.sender.m() == -1) {
        i1 = 100;
      } else {
        i1 = b.sender.m();
      }
      localToServiceMsg.setAppId(i1);
      localToServiceMsg.setTimeout(30000L);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.addAttribute("__base_tag_isAppMsg", Boolean.valueOf(true));
      localToServiceMsg.putWupBuffer(MsfSdkUtils.convertInt2Bytes(4));
      b.sender.b(localToServiceMsg);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.D.NetCenterNewImpl", 4, "msfCore not inited. can not send checkServerTimeMsg.");
    }
  }
  
  private void L()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static t a()
  {
    return t.a.a();
  }
  
  private void a(String paramString, int paramInt)
  {
    MsfCore localMsfCore = b;
    if ((localMsfCore != null) && (localMsfCore.sender != null))
    {
      b.sender.b.g.a(paramString, paramInt);
      if (b.standbyModeManager != null) {
        b.standbyModeManager.e();
      }
    }
  }
  
  public int A()
  {
    if ((this.e == 0) && (n())) {
      D();
    }
    return this.e;
  }
  
  public int B()
  {
    return this.g;
  }
  
  public int C()
  {
    return this.f;
  }
  
  public void D()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.h;
        if (bool) {
          try
          {
            Object localObject1 = (WifiManager)BaseApplication.getContext().getApplicationContext().getSystemService("wifi");
            if (localObject1 == null) {
              continue;
            }
            localObject1 = NetworkMonitor.getConnectionInfo((WifiManager)localObject1);
            if (localObject1 == null) {
              break label161;
            }
            i1 = 1;
            if (((WifiInfo)localObject1).getBSSID() == null) {
              break label166;
            }
            i2 = 1;
            if ((i1 & i2) == 0) {
              continue;
            }
            this.e = WifiManager.calculateSignalLevel(((WifiInfo)localObject1).getRssi(), 32);
          }
          catch (Exception localException)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("check WifiState error ");
            localStringBuilder.append(localException);
            QLog.d("MSF.D.NetCenterNewImpl", 1, localStringBuilder.toString(), localException);
            this.h = false;
          }
        } else {
          this.e = 0;
        }
        com.tencent.mobileqq.a.a.a.a().a(0, this.e);
        return;
      }
      finally {}
      label161:
      int i1 = 0;
      continue;
      label166:
      int i2 = 0;
    }
  }
  
  public String a(boolean paramBoolean)
  {
    return this.i.b(paramBoolean);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.NetCenterNewImpl", 2, "wifiConnected");
    }
    try
    {
      WifiInfo localWifiInfo = NetworkMonitor.getConnectionInfo((WifiManager)BaseApplication.getContext().getSystemService("wifi"));
      if (localWifiInfo != null)
      {
        int i1 = localWifiInfo.getIpAddress();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("wifiConnected localAddress ");
          localStringBuilder.append(i1);
          localStringBuilder.append("(");
          localStringBuilder.append(NetConnInfoCenter.intToInetAddress(i1).getHostAddress());
          localStringBuilder.append("), ");
          localStringBuilder.append(localWifiInfo.toString());
          QLog.d("MSF.D.NetCenterNewImpl", 2, localStringBuilder.toString());
        }
        if ((b != null) && (b.getStatReporter() != null)) {
          b.getStatReporter().a(localWifiInfo);
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    D();
    a(this.i.k(), paramInt);
    G();
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(long paramLong)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleGetServerTimeResp servertime is ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("MSF.D.NetCenterNewImpl", 4, ((StringBuilder)localObject).toString());
    }
    NetConnInfoCenter.servetTimeSecondInterv = paramLong - System.currentTimeMillis() / 1000L;
    Object localObject = BaseApplication.getContext().getSharedPreferences(this.j, 0).edit();
    ((SharedPreferences.Editor)localObject).putLong("servetTimeDiff", NetConnInfoCenter.servetTimeSecondInterv);
    ((SharedPreferences.Editor)localObject).commit();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("set serverTime is ");
      ((StringBuilder)localObject).append(b.timeFormatter.format(Long.valueOf(System.currentTimeMillis() + NetConnInfoCenter.servetTimeSecondInterv * 1000L)));
      QLog.d("MSF.D.NetCenterNewImpl", 2, ((StringBuilder)localObject).toString());
    }
    MsfCore.initAppProMsg("*", b.sender.m());
  }
  
  public void a(Context paramContext)
  {
    Object localObject = new t.c(this, null);
    ((TelephonyManager)paramContext.getSystemService("phone")).listen((PhoneStateListener)localObject, 256);
    localObject = new t.d(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.RSSI_CHANGED");
    paramContext.registerReceiver((BroadcastReceiver)localObject, localIntentFilter);
  }
  
  public void a(Context paramContext, NetworkInfo paramNetworkInfo, boolean paramBoolean)
  {
    this.q.set(Boolean.valueOf(paramBoolean));
    if (this.r.compareAndSet(false, true)) {
      this.i.a(paramContext, paramNetworkInfo);
    }
  }
  
  public void a(MsfCore paramMsfCore)
  {
    b = paramMsfCore;
    NetConnInfoCenter.servetTimeSecondInterv = BaseApplication.getContext().getSharedPreferences(this.j, 0).getLong("servetTimeDiff", 0L);
    a(BaseApplication.getContext());
    if (Build.VERSION.SDK_INT >= 23) {
      c(BaseApplication.getContext());
    }
  }
  
  public void a(com.tencent.qphone.base.a parama)
  {
    NetConnInfoCenter.socketConnState = 1;
    MsfCore localMsfCore = b;
    if ((localMsfCore != null) || (localMsfCore.pushManager != null)) {
      try
      {
        b.pushManager.a(parama);
        if ((b.standbyModeManager != null) && (!b.standbyModeManager.b()))
        {
          parama = new FromServiceMsg(b.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_connClosed");
          parama.setMsgSuccess();
          parama.setMsfCommand(MsfCommand.onConnClosed);
          MsfSdkUtils.addFromMsgProcessName("*", parama);
          b.addRespToQuque(null, parama);
          return;
        }
        QLog.d("MSF.D.NetCenterNewImpl", 1, "onConnClosed, stop notify by standby");
        return;
      }
      catch (Exception parama)
      {
        QLog.d("MSF.D.NetCenterNewImpl", 1, "", parama);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && ((paramString1 == null) || (!paramString1.equals(paramString2))))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("SSID changed, new ssid :  ");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(" old ssid: ");
        localStringBuilder.append(paramString1);
        QLog.d("MSF.D.NetCenterNewImpl", 2, localStringBuilder.toString());
      }
      paramString1 = b;
      if ((paramString1 != null) && (paramString1.ssoListManager != null)) {
        b.ssoListManager.c();
      }
    }
  }
  
  public String b(boolean paramBoolean)
  {
    return this.i.c(paramBoolean);
  }
  
  public void b()
  {
    long l1 = SystemClock.uptimeMillis();
    this.s.set(Long.valueOf(l1));
  }
  
  /* Error */
  protected void b(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 651	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3: ifnull +774 -> 777
    //   6: getstatic 651	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   9: getfield 655	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   12: ifnonnull +4 -> 16
    //   15: return
    //   16: aload_1
    //   17: ldc_w 657
    //   20: invokevirtual 407	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   23: checkcast 659	android/os/PowerManager
    //   26: astore_1
    //   27: aload_1
    //   28: invokevirtual 663	java/lang/Object:getClass	()Ljava/lang/Class;
    //   31: ldc_w 665
    //   34: iconst_0
    //   35: anewarray 667	java/lang/Class
    //   38: invokevirtual 671	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   41: astore 15
    //   43: aload 15
    //   45: iconst_1
    //   46: invokevirtual 676	java/lang/reflect/Method:setAccessible	(Z)V
    //   49: aload 15
    //   51: aload_1
    //   52: iconst_0
    //   53: anewarray 4	java/lang/Object
    //   56: invokevirtual 680	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   59: checkcast 330	java/lang/Boolean
    //   62: invokevirtual 683	java/lang/Boolean:booleanValue	()Z
    //   65: istore_2
    //   66: aload_1
    //   67: invokevirtual 663	java/lang/Object:getClass	()Ljava/lang/Class;
    //   70: ldc_w 685
    //   73: iconst_0
    //   74: anewarray 667	java/lang/Class
    //   77: invokevirtual 671	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   80: astore 15
    //   82: aload 15
    //   84: iconst_1
    //   85: invokevirtual 676	java/lang/reflect/Method:setAccessible	(Z)V
    //   88: aload 15
    //   90: aload_1
    //   91: iconst_0
    //   92: anewarray 4	java/lang/Object
    //   95: invokevirtual 680	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   98: checkcast 330	java/lang/Boolean
    //   101: invokevirtual 683	java/lang/Boolean:booleanValue	()Z
    //   104: istore_3
    //   105: aload_1
    //   106: invokevirtual 663	java/lang/Object:getClass	()Ljava/lang/Class;
    //   109: ldc_w 687
    //   112: iconst_0
    //   113: anewarray 667	java/lang/Class
    //   116: invokevirtual 671	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   119: astore 15
    //   121: aload 15
    //   123: iconst_1
    //   124: invokevirtual 676	java/lang/reflect/Method:setAccessible	(Z)V
    //   127: aload 15
    //   129: aload_1
    //   130: iconst_0
    //   131: anewarray 4	java/lang/Object
    //   134: invokevirtual 680	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   137: checkcast 330	java/lang/Boolean
    //   140: invokevirtual 683	java/lang/Boolean:booleanValue	()Z
    //   143: istore 4
    //   145: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   148: getfield 655	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   151: getfield 691	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   154: ifnonnull +19 -> 173
    //   157: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   160: getfield 655	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   163: new 693	com/tencent/mobileqq/msf/core/d/j$c
    //   166: dup
    //   167: invokespecial 694	com/tencent/mobileqq/msf/core/d/j$c:<init>	()V
    //   170: putfield 691	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   173: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   176: getfield 655	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   179: getfield 691	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   182: iload_2
    //   183: putfield 696	com/tencent/mobileqq/msf/core/d/j$c:a	Z
    //   186: iload_2
    //   187: ifeq +247 -> 434
    //   190: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   193: getfield 655	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   196: getfield 691	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   199: invokestatic 161	java/lang/System:currentTimeMillis	()J
    //   202: putfield 698	com/tencent/mobileqq/msf/core/d/j$c:b	J
    //   205: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   208: getfield 655	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   211: getfield 691	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   214: getfield 700	com/tencent/mobileqq/msf/core/d/j$c:c	J
    //   217: lconst_0
    //   218: lcmp
    //   219: ifle +24 -> 243
    //   222: invokestatic 161	java/lang/System:currentTimeMillis	()J
    //   225: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   228: getfield 655	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   231: getfield 691	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   234: getfield 700	com/tencent/mobileqq/msf/core/d/j$c:c	J
    //   237: lsub
    //   238: lstore 7
    //   240: goto +6 -> 246
    //   243: lconst_0
    //   244: lstore 7
    //   246: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   249: getfield 655	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   252: getfield 691	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   255: getfield 702	com/tencent/mobileqq/msf/core/d/j$c:e	J
    //   258: lconst_0
    //   259: lcmp
    //   260: ifle +74 -> 334
    //   263: invokestatic 161	java/lang/System:currentTimeMillis	()J
    //   266: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   269: getfield 655	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   272: getfield 691	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   275: getfield 702	com/tencent/mobileqq/msf/core/d/j$c:e	J
    //   278: lsub
    //   279: lstore 9
    //   281: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   284: getfield 655	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   287: getfield 691	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   290: getfield 704	com/tencent/mobileqq/msf/core/d/j$c:f	J
    //   293: lconst_0
    //   294: lcmp
    //   295: ifle +33 -> 328
    //   298: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   301: getfield 655	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   304: getfield 691	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   307: getfield 704	com/tencent/mobileqq/msf/core/d/j$c:f	J
    //   310: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   313: getfield 655	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   316: getfield 691	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   319: getfield 702	com/tencent/mobileqq/msf/core/d/j$c:e	J
    //   322: lsub
    //   323: lstore 5
    //   325: goto +16 -> 341
    //   328: lconst_0
    //   329: lstore 5
    //   331: goto +10 -> 341
    //   334: lconst_0
    //   335: lstore 9
    //   337: lload 9
    //   339: lstore 5
    //   341: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   344: getfield 216	com/tencent/mobileqq/msf/core/MsfCore:pushManager	Lcom/tencent/mobileqq/msf/core/push/g;
    //   347: ifnull +73 -> 420
    //   350: new 99	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   357: astore_1
    //   358: aload_1
    //   359: ldc_w 706
    //   362: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload_1
    //   367: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   370: getfield 216	com/tencent/mobileqq/msf/core/MsfCore:pushManager	Lcom/tencent/mobileqq/msf/core/push/g;
    //   373: invokevirtual 708	com/tencent/mobileqq/msf/core/push/g:e	()J
    //   376: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: ldc 12
    //   382: iconst_1
    //   383: aload_1
    //   384: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokestatic 323	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   390: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   393: getfield 216	com/tencent/mobileqq/msf/core/MsfCore:pushManager	Lcom/tencent/mobileqq/msf/core/push/g;
    //   396: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   399: getfield 216	com/tencent/mobileqq/msf/core/MsfCore:pushManager	Lcom/tencent/mobileqq/msf/core/push/g;
    //   402: invokevirtual 708	com/tencent/mobileqq/msf/core/push/g:e	()J
    //   405: invokevirtual 710	com/tencent/mobileqq/msf/core/push/g:a	(J)V
    //   408: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   411: getfield 216	com/tencent/mobileqq/msf/core/MsfCore:pushManager	Lcom/tencent/mobileqq/msf/core/push/g;
    //   414: invokestatic 161	java/lang/System:currentTimeMillis	()J
    //   417: putfield 712	com/tencent/mobileqq/msf/core/push/g:p	J
    //   420: lload 9
    //   422: lstore 11
    //   424: lconst_0
    //   425: lstore 9
    //   427: lload 5
    //   429: lstore 13
    //   431: goto +149 -> 580
    //   434: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   437: getfield 655	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   440: getfield 691	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   443: invokestatic 161	java/lang/System:currentTimeMillis	()J
    //   446: putfield 700	com/tencent/mobileqq/msf/core/d/j$c:c	J
    //   449: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   452: getfield 655	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   455: getfield 691	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   458: lconst_0
    //   459: putfield 702	com/tencent/mobileqq/msf/core/d/j$c:e	J
    //   462: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   465: getfield 655	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   468: getfield 691	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   471: lconst_0
    //   472: putfield 704	com/tencent/mobileqq/msf/core/d/j$c:f	J
    //   475: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   478: getfield 655	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   481: getfield 691	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   484: getfield 698	com/tencent/mobileqq/msf/core/d/j$c:b	J
    //   487: lconst_0
    //   488: lcmp
    //   489: ifle +70 -> 559
    //   492: invokestatic 161	java/lang/System:currentTimeMillis	()J
    //   495: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   498: getfield 655	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   501: getfield 691	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   504: getfield 698	com/tencent/mobileqq/msf/core/d/j$c:b	J
    //   507: lsub
    //   508: lstore 5
    //   510: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   513: getfield 655	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   516: getfield 691	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   519: getfield 714	com/tencent/mobileqq/msf/core/d/j$c:d	J
    //   522: lstore 7
    //   524: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   527: getfield 655	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   530: getfield 691	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   533: lconst_0
    //   534: putfield 714	com/tencent/mobileqq/msf/core/d/j$c:d	J
    //   537: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   540: getfield 216	com/tencent/mobileqq/msf/core/MsfCore:pushManager	Lcom/tencent/mobileqq/msf/core/push/g;
    //   543: ifnull +13 -> 556
    //   546: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   549: getfield 216	com/tencent/mobileqq/msf/core/MsfCore:pushManager	Lcom/tencent/mobileqq/msf/core/push/g;
    //   552: lconst_0
    //   553: putfield 712	com/tencent/mobileqq/msf/core/push/g:p	J
    //   556: goto +10 -> 566
    //   559: lconst_0
    //   560: lstore 5
    //   562: lload 5
    //   564: lstore 7
    //   566: lconst_0
    //   567: lstore 11
    //   569: lconst_0
    //   570: lstore 13
    //   572: lload 7
    //   574: lstore 9
    //   576: lload 5
    //   578: lstore 7
    //   580: new 99	java/lang/StringBuilder
    //   583: dup
    //   584: sipush 128
    //   587: invokespecial 716	java/lang/StringBuilder:<init>	(I)V
    //   590: astore_1
    //   591: aload_1
    //   592: ldc_w 718
    //   595: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: aload_1
    //   600: iload_2
    //   601: invokevirtual 721	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   604: pop
    //   605: aload_1
    //   606: ldc_w 723
    //   609: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: aload_1
    //   614: lload 7
    //   616: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: aload_1
    //   621: ldc_w 725
    //   624: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload_1
    //   629: lload 9
    //   631: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: aload_1
    //   636: ldc_w 727
    //   639: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: pop
    //   643: aload_1
    //   644: lload 13
    //   646: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: aload_1
    //   651: ldc_w 729
    //   654: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: pop
    //   658: aload_1
    //   659: lload 11
    //   661: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   664: pop
    //   665: aload_1
    //   666: ldc_w 731
    //   669: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: pop
    //   673: aload_1
    //   674: iload_3
    //   675: invokevirtual 721	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   678: pop
    //   679: aload_1
    //   680: ldc_w 733
    //   683: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: pop
    //   687: aload_1
    //   688: iload 4
    //   690: invokevirtual 721	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   693: pop
    //   694: ldc 12
    //   696: iconst_1
    //   697: aload_1
    //   698: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   701: invokestatic 323	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   704: lload 7
    //   706: lconst_0
    //   707: lcmp
    //   708: ifle +24 -> 732
    //   711: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   714: getfield 655	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   717: iload_2
    //   718: lload 7
    //   720: lload 9
    //   722: lload 11
    //   724: lload 13
    //   726: iload_3
    //   727: iload 4
    //   729: invokevirtual 736	com/tencent/mobileqq/msf/core/d/j:a	(ZJJJJZZ)V
    //   732: return
    //   733: astore_1
    //   734: goto +12 -> 746
    //   737: astore_1
    //   738: goto +6 -> 744
    //   741: astore_1
    //   742: iconst_0
    //   743: istore_2
    //   744: iconst_0
    //   745: istore_3
    //   746: aload_1
    //   747: invokevirtual 482	java/lang/Exception:printStackTrace	()V
    //   750: ldc 12
    //   752: iconst_1
    //   753: aload_1
    //   754: iconst_0
    //   755: anewarray 4	java/lang/Object
    //   758: invokestatic 739	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   761: getstatic 182	com/tencent/mobileqq/msf/core/t:b	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   764: getfield 655	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   767: iload_2
    //   768: lconst_0
    //   769: lconst_0
    //   770: lconst_0
    //   771: lconst_0
    //   772: iload_3
    //   773: iconst_0
    //   774: invokevirtual 736	com/tencent/mobileqq/msf/core/d/j:a	(ZJJJJZZ)V
    //   777: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	778	0	this	t
    //   0	778	1	paramContext	Context
    //   65	703	2	bool1	boolean
    //   104	669	3	bool2	boolean
    //   143	585	4	bool3	boolean
    //   323	254	5	l1	long
    //   238	481	7	l2	long
    //   279	442	9	l3	long
    //   422	301	11	l4	long
    //   429	296	13	l5	long
    //   41	87	15	localMethod	java.lang.reflect.Method
    // Exception table:
    //   from	to	target	type
    //   105	145	733	java/lang/Exception
    //   66	105	737	java/lang/Exception
    //   27	66	741	java/lang/Exception
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && ((paramString1 == null) || (!paramString1.equals(paramString2))))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Mobile APN changed, load sso list new apn :  ");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(" old apn: ");
        localStringBuilder.append(paramString1);
        QLog.d("MSF.D.NetCenterNewImpl", 2, localStringBuilder.toString());
      }
      paramString1 = b;
      if ((paramString1 != null) && (paramString1.ssoListManager != null)) {
        b.ssoListManager.b();
      }
    }
  }
  
  public int c(boolean paramBoolean)
  {
    return this.i.a(paramBoolean);
  }
  
  public void c()
  {
    this.r.set(false);
    long l1 = ((Long)this.s.get()).longValue();
    if ((!this.t) && (Math.abs(SystemClock.uptimeMillis() - ((Long)this.s.get()).longValue()) > 120000L))
    {
      this.t = true;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkConnInfo refresh held 2min!!! enter=");
      localStringBuilder.append(l1);
      localStringBuilder.append(" now=");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.w("MSF.D.NetCenterNewImpl", 1, localStringBuilder.toString());
      MsfCore.sCore.statReporter.a("", 0L);
    }
  }
  
  public void c(Context paramContext)
  {
    t.b localb = new t.b(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
    paramContext.registerReceiver(localb, localIntentFilter);
  }
  
  public void c(String paramString1, String paramString2)
  {
    NetConnInfoCenter.socketConnState = 2;
    Object localObject = b;
    if (localObject == null)
    {
      QLog.d("MSF.D.NetCenterNewImpl", 1, "onConnOpened, return by msfCore null");
      return;
    }
    ((MsfCore)localObject).pushManager.d();
    if (l.a) {
      l.a(null);
    }
    if ((b.standbyModeManager != null) && (!b.standbyModeManager.b()))
    {
      localObject = new FromServiceMsg(b.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_connOpened");
      ((FromServiceMsg)localObject).setMsgSuccess();
      ((FromServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
      ((FromServiceMsg)localObject).setMsfCommand(MsfCommand.onConnOpened);
      ((FromServiceMsg)localObject).addAttribute("resp_connopen_serverAdd", paramString1);
      ((FromServiceMsg)localObject).addAttribute("resp_connopen_localAdd", paramString2);
      if (b.pushManager.b()) {
        ((FromServiceMsg)localObject).addAttribute("resp_needBootApp", Integer.valueOf(1));
      }
      MsfSdkUtils.addFromMsgProcessName("*", (FromServiceMsg)localObject);
      b.addRespToQuque(null, (FromServiceMsg)localObject);
      return;
    }
    if (b.standbyModeManager != null) {
      b.standbyModeManager.g();
    }
    QLog.d("MSF.D.NetCenterNewImpl", 1, "onConnOpened, stop notify by standby");
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.NetCenterNewImpl", 2, "wifiDisConnected");
    }
    MsfCore localMsfCore = b;
    if ((localMsfCore != null) && (localMsfCore.sender != null)) {
      b.sender.b.g.a();
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.NetCenterNewImpl", 2, "mobileConnected");
    }
    H();
    G();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.NetCenterNewImpl", 2, "mobileDisConnected");
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.NetCenterNewImpl", 2, "unknowConnected");
    }
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.NetCenterNewImpl", 2, "unknowDisConnected");
    }
  }
  
  public boolean i()
  {
    return this.i.e();
  }
  
  public void j()
  {
    this.v = System.currentTimeMillis();
    this.u.set(true);
  }
  
  public int k()
  {
    if (n()) {
      return 2;
    }
    if (o()) {
      return 1;
    }
    return 0;
  }
  
  public NetworkInfo l()
  {
    return this.i.f();
  }
  
  public boolean m()
  {
    return (this.i.a()) || (this.i.b());
  }
  
  public boolean n()
  {
    return this.i.a();
  }
  
  public boolean o()
  {
    return this.i.b();
  }
  
  public void p()
  {
    Object localObject = b;
    if ((localObject != null) && (((MsfCore)localObject).standbyModeManager != null) && (!b.standbyModeManager.b()))
    {
      NetConnInfoCenter.socketConnState = 3;
      localObject = new FromServiceMsg(b.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_connAllFailed");
      ((FromServiceMsg)localObject).setMsgSuccess();
      ((FromServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
      ((FromServiceMsg)localObject).setMsfCommand(MsfCommand.onOepnConnAllFailed);
      if (b.pushManager.b()) {
        ((FromServiceMsg)localObject).addAttribute("resp_needBootApp", Integer.valueOf(1));
      }
      MsfSdkUtils.addFromMsgProcessName("*", (FromServiceMsg)localObject);
      b.addRespToQuque(null, (FromServiceMsg)localObject);
    }
    else
    {
      QLog.d("MSF.D.NetCenterNewImpl", 1, "onOepnConnAllFailed, stop notify by standby");
    }
    localObject = b;
    if ((localObject != null) && (((MsfCore)localObject).sender != null)) {
      b.sender.b.g.b();
    }
  }
  
  public String q()
  {
    return this.i.j();
  }
  
  public String r()
  {
    return this.i.k();
  }
  
  public void s()
  {
    Object localObject;
    if (n())
    {
      localObject = b;
      if ((localObject != null) && (((MsfCore)localObject).sender != null)) {
        b.sender.b.g.a(this.i.k());
      }
    }
    if ((b.standbyModeManager != null) && (!b.standbyModeManager.b()))
    {
      NetConnInfoCenter.socketConnState = 4;
      localObject = new FromServiceMsg(b.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_recvFirstResp");
      ((FromServiceMsg)localObject).setMsgSuccess();
      ((FromServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
      ((FromServiceMsg)localObject).setMsfCommand(MsfCommand.onReceFirstResp);
      if (b.pushManager.b()) {
        ((FromServiceMsg)localObject).addAttribute("resp_needBootApp", Integer.valueOf(1));
      }
      MsfSdkUtils.addFromMsgProcessName("*", (FromServiceMsg)localObject);
      b.addRespToQuque(null, (FromServiceMsg)localObject);
      return;
    }
    QLog.d("MSF.D.NetCenterNewImpl", 1, "onRecvFirstResp, stop notify by standby");
  }
  
  public int t()
  {
    return this.i.g();
  }
  
  public String u()
  {
    return this.i.l();
  }
  
  public String v()
  {
    return this.i.h();
  }
  
  public int w()
  {
    if (n()) {
      return this.i.i();
    }
    if (o()) {
      return this.i.g() + 10000;
    }
    return 0;
  }
  
  public int x()
  {
    return this.i.i();
  }
  
  public void y()
  {
    System.currentTimeMillis();
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.y;
    if ((l1 - l2 > 0L) && (l1 - l2 <= com.tencent.mobileqq.msf.core.a.a.K()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.NetCenterNewImpl", 2, "quit to checkTimeMsg too frequency.");
      }
      return;
    }
    if (this.x < 10)
    {
      K();
      this.x += 1;
      this.y = l1;
    }
    else if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("also send checkTimeMsg ");
      localStringBuilder.append(this.x);
      QLog.d("MSF.D.NetCenterNewImpl", 2, localStringBuilder.toString());
    }
    l2 = System.currentTimeMillis();
    long l3 = this.w;
    if ((l3 == 0L) || (l1 - l3 > 600000L))
    {
      this.w = l1;
      this.x = 0;
    }
    l = l2;
    if (MsfStore.getNativeConfigStore() != null) {
      MsfStore.getNativeConfigStore().n_setConfig("recordSysTimeKey", String.valueOf(l2));
    }
  }
  
  public void z()
  {
    try
    {
      long l1 = SystemClock.elapsedRealtime();
      if ((0L != m) && (l1 > m + com.tencent.mobileqq.msf.core.a.a.N()))
      {
        m = l1;
        l1 = l;
        if ((-1L == l1) && (MsfStore.getNativeConfigStore() != null))
        {
          String str = MsfStore.getNativeConfigStore().getConfig("recordSysTimeKey");
          if (str != null) {
            try
            {
              l = Long.parseLong(str);
            }
            catch (Exception localException1)
            {
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("get lastCheckTime catch Exception ");
                localStringBuilder.append(localException1);
                QLog.d("MSF.D.NetCenterNewImpl", 2, localStringBuilder.toString());
              }
            }
          }
        }
        l1 = System.currentTimeMillis();
        if (-1L != l)
        {
          double d1 = l1;
          double d2 = l + com.tencent.mobileqq.msf.core.a.a.L();
          double d3 = Math.random();
          l1 = com.tencent.mobileqq.msf.core.a.a.M();
          double d4 = l1;
          Double.isNaN(d4);
          Double.isNaN(d2);
          if (d1 > d2 + d3 * d4) {
            y();
          }
        }
        else
        {
          l = l1;
          if (MsfStore.getNativeConfigStore() != null) {
            MsfStore.getNativeConfigStore().n_setConfig("recordSysTimeKey", String.valueOf(l));
          }
        }
      }
      else if (0L == m)
      {
        m = l1;
        return;
      }
    }
    catch (Exception localException2)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkRecordTime catch Exception ");
        localStringBuilder.append(localException2);
        QLog.d("MSF.D.NetCenterNewImpl", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.t
 * JD-Core Version:    0.7.0.1
 */