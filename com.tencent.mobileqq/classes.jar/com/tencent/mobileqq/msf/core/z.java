package com.tencent.mobileqq.msf.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.core.c.k.c;
import com.tencent.mobileqq.msf.core.net.b.o;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.core.push.g;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.a.a.b;
import com.tencent.mobileqq.msf.sdk.a.a.c;
import com.tencent.mobileqq.msf.service.l;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.security.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class z
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
  
  private z()
  {
    QLog.i("MSF.D.NetCenterNewImpl", 1, BaseApplication.processName + " create NetConnInfoCenterNewImpl instance");
    this.i = new com.tencent.mobileqq.msf.sdk.a.a();
    this.i.a(this);
    this.i.a(x.d());
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
        b.getStatReporter().a("dim.Msf.NoNetInfoConnSucc", false, 0L, 0L, localHashMap, false, false);
      }
      E();
    }
  }
  
  private void G()
  {
    F();
    aj.c("");
    aj.d(0);
    I();
    if ((b != null) && (b.pushManager != null)) {
      b.pushManager.c();
    }
  }
  
  private void H()
  {
    if ((o()) && (b != null) && (b.standbyModeManager != null)) {
      b.standbyModeManager.d();
    }
  }
  
  private void I()
  {
    if ((b != null) && (b.sender != null) && (b.getStatReporter() != null)) {
      b.getStatReporter().i();
    }
  }
  
  private void J()
  {
    if (b != null)
    {
      localToServiceMsg = new ToServiceMsg("", "0", "login.time");
      localToServiceMsg.setMsfCommand(MsfCommand.getServerTime);
      if (b.sender.k() == -1)
      {
        i1 = 100;
        localToServiceMsg.setAppId(i1);
        localToServiceMsg.setTimeout(30000L);
        localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
        localUniPacket = new UniPacket(true);
        localUniPacket.setServantName("test");
        localUniPacket.setFuncName("cmdstr");
        locald = new d(1, 15, MsfCore.getNextSeq(), 1, "0", b.sender.k(), String.valueOf(b.sender.k()), "123", 0);
        localc = new com.tencent.msf.service.protocol.security.c();
        localc.a = ((int)(System.currentTimeMillis() / 1000L));
        localUniPacket.put("RequestHeader", locald);
        localUniPacket.put("RequestGetServerTime", localc);
        localToServiceMsg.putWupBuffer(localUniPacket.encode());
        b.sender.b(localToServiceMsg);
      }
    }
    while (!QLog.isDevelopLevel()) {
      for (;;)
      {
        ToServiceMsg localToServiceMsg;
        UniPacket localUniPacket;
        d locald;
        com.tencent.msf.service.protocol.security.c localc;
        return;
        int i1 = b.sender.k();
      }
    }
    QLog.d("MSF.D.NetCenterNewImpl", 4, "msfCore not inited. can not send checkServerTimeMsg.");
  }
  
  private void K()
  {
    if (b != null)
    {
      localToServiceMsg = new ToServiceMsg("", "0", "Client.CorrectTime");
      localToServiceMsg.setMsfCommand(MsfCommand.getServerTime);
      if (b.sender.k() == -1)
      {
        i1 = 100;
        localToServiceMsg.setAppId(i1);
        localToServiceMsg.setTimeout(30000L);
        localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
        localToServiceMsg.addAttribute("__base_tag_isAppMsg", Boolean.valueOf(true));
        localToServiceMsg.putWupBuffer(MsfSdkUtils.convertInt2Bytes(4));
        b.sender.b(localToServiceMsg);
      }
    }
    while (!QLog.isDevelopLevel()) {
      for (;;)
      {
        ToServiceMsg localToServiceMsg;
        return;
        int i1 = b.sender.k();
      }
    }
    QLog.d("MSF.D.NetCenterNewImpl", 4, "msfCore not inited. can not send checkServerTimeMsg.");
  }
  
  private void L()
  {
    int i1;
    if (Math.random() <= 0.01D)
    {
      i1 = 1;
      if (i1 == 0) {}
    }
    label362:
    label367:
    label372:
    for (;;)
    {
      try
      {
        SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("dozeWhiteList", 0);
        long l1 = localSharedPreferences.getLong("keyDozeLastTime", 0L);
        if (Math.abs(System.currentTimeMillis() - l1) >= 86400000L)
        {
          if (Build.VERSION.SDK_INT < 23) {
            break label367;
          }
          if (((PowerManager)BaseApplication.getContext().getSystemService("power")).isIgnoringBatteryOptimizations("com.tencent.mobileqq"))
          {
            i1 = 1;
            break label372;
            if (Build.VERSION.SDK_INT < 24) {
              break label362;
            }
            i2 = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getRestrictBackgroundStatus();
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder(30);
              ((StringBuilder)localObject).append("report:");
              ((StringBuilder)localObject).append(", ").append(i1);
              ((StringBuilder)localObject).append(", ").append(Build.MODEL);
              ((StringBuilder)localObject).append(", ").append(Build.MANUFACTURER);
              ((StringBuilder)localObject).append(", ").append(i2);
              QLog.d("MSF.D.NetCenterNewImpl", 1, ((StringBuilder)localObject).toString());
            }
            Object localObject = new HashMap(10);
            ((HashMap)localObject).put("osVersion", Build.VERSION.SDK_INT + "");
            ((HashMap)localObject).put("ignoreBat", String.valueOf(i1));
            ((HashMap)localObject).put("model", Build.MODEL);
            ((HashMap)localObject).put("manufacture", Build.MANUFACTURER);
            ((HashMap)localObject).put("restrictBgStatus", String.valueOf(i2));
            b.statReporter.a("EvtDozeWhiteList", true, 0L, 0L, (Map)localObject, false, false);
          }
        }
        else
        {
          localSharedPreferences.edit().putLong("keyDozeLastTime", System.currentTimeMillis()).commit();
          return;
          i1 = 0;
          break;
        }
        i1 = 0;
      }
      catch (Throwable localThrowable)
      {
        QLog.d("MSF.D.NetCenterNewImpl", 1, "report doze whiteList exception ", localThrowable);
        return;
      }
      int i2 = -1;
      continue;
      i1 = -1;
    }
  }
  
  public static z a()
  {
    return z.a.a();
  }
  
  private void a(String paramString, int paramInt)
  {
    if ((b != null) && (b.sender != null))
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
        if (!bool) {
          break label147;
        }
        try
        {
          Object localObject1 = (WifiManager)BaseApplication.getContext().getApplicationContext().getSystemService("wifi");
          if (localObject1 != null)
          {
            localObject1 = ((WifiManager)localObject1).getConnectionInfo();
            if (localObject1 == null) {
              continue;
            }
            i1 = 1;
            if (((WifiInfo)localObject1).getBSSID() == null) {
              continue;
            }
            i2 = 1;
            if ((i2 & i1) != 0) {
              this.e = WifiManager.calculateSignalLevel(((WifiInfo)localObject1).getRssi(), 32);
            }
          }
        }
        catch (Exception localException)
        {
          int i1;
          int i2;
          QLog.d("MSF.D.NetCenterNewImpl", 1, "check WifiState error " + localException, localException);
          this.h = false;
          continue;
        }
        com.tencent.mobileqq.a.a.a.a().a(0, this.e);
        return;
      }
      finally {}
      i1 = 0;
      continue;
      i2 = 0;
      continue;
      label147:
      this.e = 0;
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
      WifiInfo localWifiInfo = ((WifiManager)BaseApplication.getContext().getSystemService("wifi")).getConnectionInfo();
      if (localWifiInfo != null)
      {
        int i1 = localWifiInfo.getIpAddress();
        if (QLog.isColorLevel()) {
          QLog.d("MSF.D.NetCenterNewImpl", 2, "wifiConnected localAddress " + i1 + "(" + NetConnInfoCenter.intToInetAddress(i1).getHostAddress() + "), " + localWifiInfo.toString());
        }
        if ((b != null) && (b.getStatReporter() != null)) {
          b.getStatReporter().a(localWifiInfo);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    D();
    a(this.i.k(), paramInt);
    G();
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.D.NetCenterNewImpl", 4, "handleGetServerTimeResp servertime is " + paramLong);
    }
    NetConnInfoCenter.servetTimeSecondInterv = paramLong - System.currentTimeMillis() / 1000L;
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(this.j, 0).edit();
    localEditor.putLong("servetTimeDiff", NetConnInfoCenter.servetTimeSecondInterv);
    localEditor.commit();
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.NetCenterNewImpl", 2, "set serverTime is " + b.timeFormatter.format(Long.valueOf(System.currentTimeMillis() + NetConnInfoCenter.servetTimeSecondInterv * 1000L)));
    }
    MsfCore.initAppProMsg("*", b.sender.k());
  }
  
  public void a(Context paramContext)
  {
    Object localObject = new z.c(this, null);
    ((TelephonyManager)paramContext.getSystemService("phone")).listen((PhoneStateListener)localObject, 256);
    localObject = new z.d(this, null);
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
    if ((b != null) || (b.pushManager != null)) {
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
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.NetCenterNewImpl", 2, "SSID changed, new ssid :  " + paramString2 + " old ssid: " + paramString1);
      }
      if ((b != null) && (b.ssoListManager != null)) {
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
  
  protected void b(Context paramContext)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    if ((MsfCore.sCore == null) || (MsfCore.sCore.statReporter == null)) {
      return;
    }
    paramContext = (PowerManager)paramContext.getSystemService("power");
    for (;;)
    {
      try
      {
        localMethod = paramContext.getClass().getMethod("isDeviceIdleMode", new Class[0]);
        localMethod.setAccessible(true);
        bool2 = ((Boolean)localMethod.invoke(paramContext, new Object[0])).booleanValue();
        bool1 = bool3;
      }
      catch (Exception paramContext)
      {
        Method localMethod;
        boolean bool4;
        boolean bool2 = false;
        paramContext.printStackTrace();
        QLog.d("MSF.D.NetCenterNewImpl", 1, paramContext, new Object[0]);
        b.statReporter.a(bool2, 0L, 0L, 0L, 0L, bool1, false);
        return;
      }
      try
      {
        localMethod = paramContext.getClass().getMethod("isPowerSaveMode", new Class[0]);
        bool1 = bool3;
        localMethod.setAccessible(true);
        bool1 = bool3;
        bool3 = ((Boolean)localMethod.invoke(paramContext, new Object[0])).booleanValue();
        bool1 = bool3;
        localMethod = paramContext.getClass().getMethod("isInteractive", new Class[0]);
        bool1 = bool3;
        localMethod.setAccessible(true);
        bool1 = bool3;
        bool4 = ((Boolean)localMethod.invoke(paramContext, new Object[0])).booleanValue();
        l1 = 0L;
        l2 = 0L;
        l6 = 0L;
        if (b.statReporter.Y == null) {
          b.statReporter.Y = new k.c();
        }
        b.statReporter.Y.a = bool2;
        if (!bool2) {
          break label640;
        }
        b.statReporter.Y.b = System.currentTimeMillis();
        if (b.statReporter.Y.c > 0L) {
          l1 = System.currentTimeMillis() - b.statReporter.Y.c;
        }
        l3 = l6;
        if (b.statReporter.Y.e > 0L)
        {
          l4 = System.currentTimeMillis() - b.statReporter.Y.e;
          l3 = l6;
          l2 = l4;
          if (b.statReporter.Y.f > 0L)
          {
            l3 = b.statReporter.Y.f - b.statReporter.Y.e;
            l2 = l4;
          }
        }
        l5 = l1;
        l6 = l3;
        l4 = l2;
        if (b.pushManager == null) {
          break label788;
        }
        QLog.d("MSF.D.NetCenterNewImpl", 1, "MSF_Alive_Log do register alarm by device ,interval = " + b.pushManager.e());
        b.pushManager.a(b.pushManager.e());
        b.pushManager.p = System.currentTimeMillis();
        l5 = 0L;
        l4 = l3;
        l3 = l5;
      }
      catch (Exception paramContext)
      {
        continue;
        l3 = 0L;
        l1 = l5;
        l2 = l4;
        l4 = l6;
        continue;
      }
      paramContext = new StringBuilder(128);
      paramContext.append("MSF_Alive_Log deviceIdleChanged: isDeviceIdleMode=").append(bool2);
      paramContext.append(" takeTimes=").append(l1);
      paramContext.append(" alarmCost=").append(l3);
      paramContext.append(" connFailCost=").append(l4);
      paramContext.append(" screenOffCost=").append(l2);
      paramContext.append(" isPowerSaveMode=").append(bool3);
      paramContext.append(" isInteractive=").append(bool4);
      QLog.d("MSF.D.NetCenterNewImpl", 1, paramContext.toString());
      if (l1 <= 0L) {
        break;
      }
      b.statReporter.a(bool2, l1, l3, l2, l4, bool3, bool4);
      return;
      label640:
      b.statReporter.Y.c = System.currentTimeMillis();
      b.statReporter.Y.e = 0L;
      b.statReporter.Y.f = 0L;
      l5 = l1;
      l4 = l2;
      if (b.statReporter.Y.b <= 0L) {
        break label788;
      }
      l1 = System.currentTimeMillis();
      l4 = b.statReporter.Y.b;
      l3 = b.statReporter.Y.d;
      b.statReporter.Y.d = 0L;
      if (b.pushManager != null) {
        b.pushManager.p = 0L;
      }
      l1 -= l4;
      l4 = 0L;
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && ((paramString1 == null) || (!paramString1.equals(paramString2))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.NetCenterNewImpl", 2, "Mobile APN changed, load sso list new apn :  " + paramString2 + " old apn: " + paramString1);
      }
      if ((b != null) && (b.ssoListManager != null)) {
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
      QLog.w("MSF.D.NetCenterNewImpl", 1, "checkConnInfo refresh held 2min!!! enter=" + l1 + " now=" + System.currentTimeMillis());
      MsfCore.sCore.statReporter.a("", 0L);
    }
  }
  
  public void c(Context paramContext)
  {
    z.b localb = new z.b(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
    paramContext.registerReceiver(localb, localIntentFilter);
  }
  
  public void c(String paramString1, String paramString2)
  {
    NetConnInfoCenter.socketConnState = 2;
    if (b == null)
    {
      QLog.d("MSF.D.NetCenterNewImpl", 1, "onConnOpened, return by msfCore null");
      return;
    }
    b.pushManager.d();
    if (l.a) {
      l.a(null);
    }
    if ((b.standbyModeManager != null) && (!b.standbyModeManager.b()))
    {
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(b.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_connOpened");
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localFromServiceMsg.setMsfCommand(MsfCommand.onConnOpened);
      localFromServiceMsg.addAttribute("resp_connopen_serverAdd", paramString1);
      localFromServiceMsg.addAttribute("resp_connopen_localAdd", paramString2);
      if (b.pushManager.b()) {
        localFromServiceMsg.addAttribute("resp_needBootApp", Integer.valueOf(1));
      }
      MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
      b.addRespToQuque(null, localFromServiceMsg);
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
    if ((b != null) && (b.sender != null)) {
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
    if ((b != null) && (b.standbyModeManager != null) && (!b.standbyModeManager.b()))
    {
      NetConnInfoCenter.socketConnState = 3;
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(b.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_connAllFailed");
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localFromServiceMsg.setMsfCommand(MsfCommand.onOepnConnAllFailed);
      if (b.pushManager.b()) {
        localFromServiceMsg.addAttribute("resp_needBootApp", Integer.valueOf(1));
      }
      MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
      b.addRespToQuque(null, localFromServiceMsg);
    }
    for (;;)
    {
      if ((b != null) && (b.sender != null)) {
        b.sender.b.g.b();
      }
      return;
      QLog.d("MSF.D.NetCenterNewImpl", 1, "onOepnConnAllFailed, stop notify by standby");
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
    if ((n()) && (b != null) && (b.sender != null)) {
      b.sender.b.g.a(this.i.k());
    }
    if ((b.standbyModeManager != null) && (!b.standbyModeManager.b()))
    {
      NetConnInfoCenter.socketConnState = 4;
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(b.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_recvFirstResp");
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localFromServiceMsg.setMsfCommand(MsfCommand.onReceFirstResp);
      if (b.pushManager.b()) {
        localFromServiceMsg.addAttribute("resp_needBootApp", Integer.valueOf(1));
      }
      MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
      b.addRespToQuque(null, localFromServiceMsg);
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
    int i1 = 0;
    if (n()) {
      i1 = this.i.i();
    }
    while (!o()) {
      return i1;
    }
    return this.i.g() + 10000;
  }
  
  public int x()
  {
    return this.i.i();
  }
  
  public void y()
  {
    System.currentTimeMillis();
    long l1 = SystemClock.elapsedRealtime();
    if ((l1 - this.y > 0L) && (l1 - this.y <= com.tencent.mobileqq.msf.core.a.a.K()))
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
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if ((this.w == 0L) || (l1 - this.w > 600000L))
      {
        this.w = l1;
        this.x = 0;
      }
      l = l2;
      if (MsfStore.getNativeConfigStore() == null) {
        break;
      }
      MsfStore.getNativeConfigStore().n_setConfig("recordSysTimeKey", String.valueOf(l2));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.NetCenterNewImpl", 2, "also send checkTimeMsg " + this.x);
      }
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
        String str;
        if ((-1L == l) && (MsfStore.getNativeConfigStore() != null))
        {
          str = MsfStore.getNativeConfigStore().getConfig("recordSysTimeKey");
          if (str == null) {}
        }
        try
        {
          l = Long.parseLong(str);
          l1 = System.currentTimeMillis();
          if (-1L != l)
          {
            if (l1 <= l + com.tencent.mobileqq.msf.core.a.a.L() + Math.random() * com.tencent.mobileqq.msf.core.a.a.M()) {
              return;
            }
            y();
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.D.NetCenterNewImpl", 2, "get lastCheckTime catch Exception " + localException1);
            }
          }
        }
      }
      return;
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.D.NetCenterNewImpl", 2, "checkRecordTime catch Exception " + localException2);
        return;
        l = l1;
        if (MsfStore.getNativeConfigStore() != null)
        {
          MsfStore.getNativeConfigStore().n_setConfig("recordSysTimeKey", String.valueOf(l));
          return;
          if (0L == m) {
            m = l1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.z
 * JD-Core Version:    0.7.0.1
 */