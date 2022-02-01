package com.tencent.mobileqq.msf.core.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.ac;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.c.j.c;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class a
  extends BroadcastReceiver
{
  public static final String a = "storeflow";
  public static final String b = "key_storeflow";
  private static final String c = "StandbyModeManager";
  private static final int h = 10001;
  private static final String n = "standbyMode";
  private static final String o = "enterTime";
  private static final String p = "enterTimeSys";
  private static final String q = "contiousTime";
  private static final String r = "disconnCount";
  private AtomicBoolean d = new AtomicBoolean(false);
  private AtomicBoolean e = new AtomicBoolean(false);
  private AtomicInteger f = new AtomicInteger(0);
  private HashSet g = new HashSet(64);
  private MsfCore i;
  private d j;
  private long k = 0L;
  private long l = 0L;
  private String m = "0";
  private Handler s = new c(this);
  
  public a(MsfCore paramMsfCore)
  {
    this.i = paramMsfCore;
    i();
    this.j = new d(paramMsfCore);
    new b(this, "StandbyModeInit").start();
  }
  
  private void c(String paramString)
  {
    if (this.d.get())
    {
      QLog.d("StandbyModeManager", 1, "exitStandbyMode");
      long l1 = SystemClock.elapsedRealtime();
      long l2 = System.currentTimeMillis();
      HashMap localHashMap = new HashMap();
      localHashMap.put("account", h());
      localHashMap.put("contious", String.valueOf(l1 - this.k));
      localHashMap.put("disconnCount", String.valueOf(this.f.get()));
      localHashMap.put("notifyReconnect", String.valueOf(this.e.get()));
      localHashMap.put("exitReason", paramString);
      localHashMap.put("start", String.valueOf(this.l));
      localHashMap.put("end", String.valueOf(l2));
      if (this.i.getStatReporter() != null) {
        this.i.getStatReporter().a("dim.Msf.StandbyModeExit", true, 0L, 0L, localHashMap, false, false);
      }
      this.j.a();
      BaseApplication.getContext().getSharedPreferences("standbyMode", 0).edit().putLong("enterTime", 0L).putLong("enterTimeSys", 0L).putLong("enterTimeSys", 0L).putInt("disconnCount", 0).commit();
      this.k = 0L;
      this.m = "0";
      this.f.set(0);
      this.d.set(false);
      if ((this.i.sender.b.b()) && (this.e.get()))
      {
        QLog.d("StandbyModeManager", 1, "notifyConnOpened when exitStandbyMode");
        NetConnInfoCenter.onConnOpened(this.i.sender.b.m().toString(), this.i.nowSocketConnAdd);
        if (this.i.sender.b.n())
        {
          QLog.d("StandbyModeManager", 1, "notifyFirestMsgRecved when exitStandbyMode");
          NetConnInfoCenter.onRecvFirstResp();
        }
      }
      this.e.set(false);
    }
  }
  
  private void i()
  {
    this.g.add("GrayUinPro.Check");
    this.g.add("cmd_openConn");
    this.g.add("StatSvc.register");
    this.g.add("StatSvc.SimpleGet");
    this.g.add("wtlogin.");
    this.g.add("login.");
    this.g.add("Heartbeat.Alive");
    this.g.add("ConfigPushSvc.PushResp");
    this.g.add("SSO.HelloPush");
    this.g.add("MessageSvc.");
    this.g.add("OnlinePush.");
    this.g.add("PbMessageSvc.");
    this.g.add("ImgStore.GroupPicUp");
    this.g.add("ImgStore.GroupPicDown");
    this.g.add("PttStore.GroupPttUp");
    this.g.add("PttStore.GroupPttDown");
    this.g.add("LongConn.OffPicUp");
    this.g.add("LongConn.OffPicDown");
    this.g.add("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500");
    this.g.add("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200");
    this.g.add("OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_APPLY_DOWNLOAD-1200");
    this.g.add("MultiMsg.ApplyUp");
    this.g.add("MultiMsg.ApplyDown");
    this.g.add("PttCenterSvr.ShortVideoUpReq");
    this.g.add("PttCenterSvr.ShortVideoDownReq");
    this.g.add("PttCenterSvr.GroupShortVideoUpReq");
    this.g.add("PttCenterSvr.GroupShortVideoDownReq");
    this.g.add("EqqAccountSvc.get_eqq_detail");
    this.g.add("hrtxformqq.getUsrSimpleInfo");
    this.g.add("PubAccountSvc.get_detail_info");
    this.g.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600");
    this.g.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700");
    this.g.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800");
    this.g.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200");
    this.g.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_FILE_QUERY-1400");
    this.g.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100");
    this.g.add("VideoCCSvc.PutInfo");
    this.g.add("SharpSvr.s2cack");
    this.g.add("SharpSvr.c2s");
    this.g.add("MultiVideo.s2cack");
    this.g.add("SharpSvr.s2cackMSF");
    this.g.add("VideoSvc.Ack");
    this.g.add("QQWifiSvc.AvailQQWiFi");
    this.g.add("QQWifiSvc.QQWiFiJarInfo");
    this.g.add("QQWifiSvc.wifiReport");
    this.g.add("QQWifiSvc.getAccount");
    this.g.add("QQWifiSvc.ReportWiFiStatus");
    this.g.add("QQWifiSvc.getNearWiFi");
    this.g.add("QQWifiSvc.getNearbyAvailWiFiInfo");
    a(com.tencent.mobileqq.msf.core.a.a.av());
  }
  
  private void j()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("standbyMode", 0);
    long l1 = localSharedPreferences.getLong("enterTime", 0L);
    long l2 = localSharedPreferences.getLong("enterTimeSys", 0L);
    long l3 = localSharedPreferences.getLong("contiousTime", 0L);
    int i1 = localSharedPreferences.getInt("disconnCount", 0);
    if ((l1 > 0L) && (l2 > 0L) && (this.i.getStatReporter() != null))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("account", h());
      localHashMap.put("contious", String.valueOf(l3));
      localHashMap.put("disconnCount", String.valueOf(i1));
      localHashMap.put("notifyReconnect", String.valueOf(false));
      localHashMap.put("exitReason", "crashed");
      localHashMap.put("start", String.valueOf(this.l));
      localHashMap.put("end", String.valueOf(l2 + l3));
      this.i.getStatReporter().a("dim.Msf.StandbyModeExit", true, 0L, 0L, localHashMap, false, false);
    }
    localSharedPreferences.edit().putLong("enterTime", 0L).putLong("enterTimeSys", 0L).putLong("enterTimeSys", 0L).putInt("disconnCount", 0).commit();
  }
  
  private void k()
  {
    this.s.removeMessages(10001);
    c("screeOn");
    if ((MsfCore.sCore != null) && (MsfCore.sCore.quicksender != null))
    {
      com.tencent.mobileqq.a.a.a.a().a(n());
      MsfCore.sCore.quicksender.b(true);
    }
  }
  
  private void l()
  {
    if (!this.d.get()) {
      if (o())
      {
        this.s.removeMessages(10001);
        if (!p()) {
          this.s.sendEmptyMessageDelayed(10001, com.tencent.mobileqq.msf.core.a.a.o());
        }
      }
    }
    for (;;)
    {
      if ((MsfCore.sCore != null) && (MsfCore.sCore.quicksender != null))
      {
        com.tencent.mobileqq.a.a.a.a().d();
        MsfCore.sCore.quicksender.h();
      }
      return;
      QLog.d("StandbyModeManager", 1, "stop try start standby by lockScreenMsg ON when screenoff");
      continue;
      QLog.d("StandbyModeManager", 1, "stop try start standby by mobileOff ON when screenoff");
      continue;
      QLog.d("StandbyModeManager", 1, "stop try start standby by alreadyActive ON when screenoff");
    }
  }
  
  private void m()
  {
    if (this.d.compareAndSet(false, true))
    {
      QLog.d("StandbyModeManager", 1, "enterStandbyMode");
      this.m = h();
      this.k = SystemClock.elapsedRealtime();
      this.l = System.currentTimeMillis();
      HashMap localHashMap = new HashMap();
      localHashMap.put("account", this.m);
      if (this.i.getStatReporter() != null) {
        this.i.getStatReporter().a("dim.Msf.StandbyModeEnter", true, 0L, 0L, localHashMap, false, false);
      }
      BaseApplication.getContext().getSharedPreferences("standbyMode", 0).edit().putLong("enterTime", this.k).putLong("enterTimeSys", this.l).putLong("enterTimeSys", 0L).putInt("disconnCount", 0).commit();
    }
  }
  
  private boolean n()
  {
    PowerManager localPowerManager = (PowerManager)BaseApplication.getContext().getSystemService("power");
    if (localPowerManager != null) {
      try
      {
        boolean bool = localPowerManager.isScreenOn();
        return bool;
      }
      catch (NullPointerException localNullPointerException)
      {
        QLog.d("StandbyModeManager", 1, "Maybe IPowerManager is null");
        return false;
      }
    }
    QLog.d("StandbyModeManager", 1, "Get PowerService is null");
    return false;
  }
  
  private boolean o()
  {
    return NetConnInfoCenter.isMobileConn();
  }
  
  private boolean p()
  {
    String str = this.i.getAccountCenter().i();
    if ((TextUtils.isEmpty(str)) || ("0".equals(str)))
    {
      QLog.d("StandbyModeManager", 1, "can't know current main account");
      return true;
    }
    return SettingCloneUtil.readValue(BaseApplication.getContext(), str, "锁屏显示消息弹框", "qqsetting_lock_screen_whenexit_key", true);
  }
  
  public void a()
  {
    if (this.d.get()) {
      BaseApplication.getContext().getSharedPreferences("standbyMode", 0).edit().putLong("contiousTime", this.k - SystemClock.elapsedRealtime()).putInt("disconnCount", this.f.get()).commit();
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    this.j.a(paramToServiceMsg);
  }
  
  public void a(String[] paramArrayOfString)
  {
    if ((this.g != null) && (paramArrayOfString != null))
    {
      int i2 = paramArrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = paramArrayOfString[i1];
        this.g.add(str);
        i1 += 1;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      int i1;
      do
      {
        return false;
        if (this.g.contains(paramString)) {
          return true;
        }
        i1 = paramString.indexOf(".");
      } while (i1 <= 0);
      paramString = paramString.substring(0, i1) + ".";
    } while (!this.g.contains(paramString));
    return true;
  }
  
  public void b(ToServiceMsg paramToServiceMsg)
  {
    this.j.b(paramToServiceMsg);
  }
  
  public boolean b()
  {
    return (com.tencent.mobileqq.msf.core.a.a.aw()) && (this.d.get());
  }
  
  public boolean b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || ("0".equals(paramString)))
    {
      QLog.d("StandbyModeManager", 1, "can't know current main account");
      return true;
    }
    return SettingCloneUtil.readValue(BaseApplication.getContext(), paramString, "锁屏显示消息弹框", "qqsetting_lock_screen_whenexit_key", true);
  }
  
  public HashSet c()
  {
    return this.g;
  }
  
  public void d()
  {
    QLog.d("StandbyModeManager", 1, "onMobileOn");
    if (!this.d.get())
    {
      if (!n())
      {
        this.s.removeMessages(10001);
        if (!p())
        {
          this.s.obtainMessage().obj = this.i.getAccountCenter().i();
          this.s.sendEmptyMessageDelayed(10001, com.tencent.mobileqq.msf.core.a.a.o());
          return;
        }
        QLog.d("StandbyModeManager", 1, "stop try start standby by lockScreenMsg ON when mobileOn");
        return;
      }
      QLog.d("StandbyModeManager", 1, "stop try start standby by screenOn ON when mobileOn");
      return;
    }
    QLog.d("StandbyModeManager", 1, "stop try start standby by alreadyActive ON when mobileOn");
  }
  
  public void e()
  {
    QLog.d("StandbyModeManager", 1, "onWifiOn");
    this.s.removeMessages(10001);
    c("wifiOn");
  }
  
  public void f()
  {
    if (this.d.get())
    {
      QLog.d("StandbyModeManager", 1, "onConnClosed");
      this.f.incrementAndGet();
    }
  }
  
  public void g()
  {
    if (this.d.get())
    {
      QLog.d("StandbyModeManager", 1, "onConnOpened");
      this.e.compareAndSet(false, true);
    }
  }
  
  public String h()
  {
    if ((this.i.getAccountCenter() != null) && (this.i.getAccountCenter().i() != null) && (this.i.getAccountCenter().i().length() >= 4)) {
      return this.i.getAccountCenter().i();
    }
    return "0";
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      QLog.d("StandbyModeManager", 1, "onReceive intent==null");
    }
    do
    {
      return;
      paramContext = paramIntent.getAction();
      QLog.d("StandbyModeManager", 1, "onReceive action: " + paramContext);
      if ((this.i.getStatReporter() != null) && (this.i.statReporter.Y == null)) {
        this.i.statReporter.Y = new j.c();
      }
      if ("android.intent.action.SCREEN_ON".equals(paramContext))
      {
        if ((this.i.getStatReporter() != null) && (this.i.statReporter.Y != null)) {
          this.i.statReporter.Y.e = 0L;
        }
        k();
        return;
      }
    } while (!"android.intent.action.SCREEN_OFF".equals(paramContext));
    if ((this.i.getStatReporter() != null) && (this.i.statReporter.Y != null))
    {
      this.i.statReporter.Y.e = System.currentTimeMillis();
      this.i.statReporter.Y.f = 0L;
    }
    l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.d.a
 * JD-Core Version:    0.7.0.1
 */