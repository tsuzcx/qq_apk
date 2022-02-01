package com.tencent.mobileqq.msf.core.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.ad;
import com.tencent.mobileqq.msf.core.d.j;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.core.net.utils.MsfPullConfigUtil;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.msf.service.u;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.msf.service.protocol.pb.StatSvcSimpleGet.RspBody;
import com.tencent.msf.service.protocol.push.SvcReqRegister;
import com.tencent.msf.service.protocol.push.VendorPushInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.ROMUtil;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class e
{
  public static final String a = "StatSvc.register";
  public static final String b = "MSF.C.PushManager:PushCoder";
  public static long c = 0L;
  public static long d = 0L;
  public static boolean e = false;
  public static String j = "StatSvc.get";
  public static String k = "StatSvc.SimpleGet";
  static boolean n = false;
  public static final String o = "com.tencent.mobileqq.msf.WatchdogForInfoLogin";
  private static String p = "SvcReqRegister";
  private static String q = "PushService";
  private static byte r = 0;
  private static boolean s = false;
  private static int t = -1;
  private static String v = "PullUnreadMsgCount";
  private static String w = "MessageSvc";
  private static String x = "SvcReqGet";
  private static String y = "PushService";
  private static final BroadcastReceiver z = new f();
  private int A = 0;
  private long B = 0L;
  private int C = 0;
  g f;
  volatile boolean g = false;
  long h = 0L;
  int i = 0;
  long l = 0L;
  int m = 0;
  private final String u = "unrtime";
  
  public e(g paramg)
  {
    this.f = paramg;
  }
  
  long a(String paramString)
  {
    return BaseApplication.getContext().getSharedPreferences("unrtime", 0).getLong(paramString, 0L);
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    if (this.B == 0L) {
      this.B = l1;
    }
    Object localObject;
    if ((this.C >= 5) && (l1 - this.B < 600000L))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("watchdog mStartWatchdogForInfoLoginRetryCount:");
        ((StringBuilder)localObject).append(this.C);
        ((StringBuilder)localObject).append(" time:");
        ((StringBuilder)localObject).append(l1 - this.B);
        QLog.d("MSF.C.PushManager:PushCoder", 2, ((StringBuilder)localObject).toString());
        QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog launch QQ Process too much stop.");
      }
      return;
    }
    if (this.C == 5)
    {
      this.C = 0;
      this.B = l1;
    }
    this.C += 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("watchdog startWatchdogForInfoLogin mnWatchdogForInfoLoginRetryCount:");
      ((StringBuilder)localObject).append(this.A);
      QLog.d("MSF.C.PushManager:PushCoder", 2, ((StringBuilder)localObject).toString());
    }
    if (!n)
    {
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.tencent.mobileqq.msf.WatchdogForInfoLogin");
      BaseApplication.getContext().registerReceiver(z, (IntentFilter)localObject);
      n = true;
    }
    MsfService.getCore().mbIsInfoLoginGetted.set(false);
    this.A = 0;
    try
    {
      localObject = new Intent("com.tencent.mobileqq.msf.WatchdogForInfoLogin");
      localObject = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, (Intent)localObject, 0);
      ((AlarmManager)BaseApplication.getContext().getSystemService("alarm")).set(0, System.currentTimeMillis() + 10000L, (PendingIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.PushManager:PushCoder", 1, "watchdog startWatchdogForInfoLogin excep!", localException);
    }
  }
  
  void a(a parama, ToServiceMsg paramToServiceMsg, boolean paramBoolean, RegPushReason paramRegPushReason)
  {
    if (parama.k == null) {
      return;
    }
    if ((com.tencent.mobileqq.msf.core.a.a.am()) && (!com.tencent.mobileqq.msf.core.a.a.a(parama.k.uin)))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append(parama.k.uin);
        paramToServiceMsg.append(" is booting and can not autoRegisterPush,return.");
        QLog.d("MSF.C.PushManager:PushCoder", 2, paramToServiceMsg.toString());
      }
      return;
    }
    boolean bool = a(paramRegPushReason);
    if ((!bool) && (!paramBoolean) && (this.g) && (System.currentTimeMillis() - parama.e < 30000L))
    {
      parama = new StringBuilder();
      parama.append("also send pushRegister, return. ");
      parama.append(bool ^ true);
      parama.append(" ");
      parama.append(paramBoolean ^ true);
      parama.append(" ");
      parama.append(this.g);
      QLog.d("MSF.C.PushManager:PushCoder", 1, parama.toString());
      return;
    }
    if (paramBoolean) {}
    try
    {
      a(paramToServiceMsg.getUin(), System.currentTimeMillis());
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        long l1;
        long l2;
        long l3;
        Object localObject1;
        Object localObject2;
        label380:
        continue;
        int i1 = 1;
        continue;
        i1 = 0;
        continue;
        byte b1 = 0;
      }
    }
    if (paramToServiceMsg != null)
    {
      l1 = a(paramToServiceMsg.getUin());
      if (l1 != 0L)
      {
        l2 = System.currentTimeMillis();
        l3 = l2 - l1;
        if (l3 > 0L)
        {
          l3 /= 1000L;
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("unRegtime", String.valueOf(l1));
          ((HashMap)localObject1).put("now", String.valueOf(l2));
          ((HashMap)localObject1).put("uin", paramToServiceMsg.getUin());
          if (this.f.c.getStatReporter() != null) {
            this.f.c.getStatReporter().a("Msf.RegInterTime", true, l3, 0L, (Map)localObject1, false, false);
          }
        }
        a(paramToServiceMsg.getUin(), 0L);
        break label380;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("get reginterv error ");
        ((StringBuilder)localObject1).append(localObject2);
        QLog.d("MSF.C.PushManager:PushCoder", 1, ((StringBuilder)localObject1).toString(), (Throwable)localObject2);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ConfigManager.isAutoStarting():");
      ((StringBuilder)localObject1).append(com.tencent.mobileqq.msf.core.a.a.am());
      QLog.d("MSF.C.PushManager:PushCoder", 2, ((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject2 = new UniPacket(true);
      ((UniPacket)localObject2).setServantName(q);
      ((UniPacket)localObject2).setFuncName(p);
      localObject1 = new SvcReqRegister();
      ((SvcReqRegister)localObject1).cConnType = r;
      ((SvcReqRegister)localObject1).lBid = parama.c;
      ((SvcReqRegister)localObject1).lUin = Long.parseLong(parama.k.uin);
      ((SvcReqRegister)localObject1).iStatus = parama.k.iStatus;
      ((SvcReqRegister)localObject1).bKikPC = parama.k.bKikPC;
      ((SvcReqRegister)localObject1).bKikWeak = parama.k.bKikWeak;
      ((SvcReqRegister)localObject1).timeStamp = parama.k.timeStamp;
      ((SvcReqRegister)localObject1).iLargeSeq = parama.k.iLargeSeq;
      if (!a(paramRegPushReason)) {
        break label1628;
      }
      i1 = 0;
      ((SvcReqRegister)localObject1).bRegType = ((byte)i1);
      if (paramRegPushReason != RegPushReason.setOnlineStatus) {
        break label1634;
      }
      i1 = 1;
      ((SvcReqRegister)localObject1).bIsSetStatus = ((byte)i1);
      ((SvcReqRegister)localObject1).uExtOnlineStatus = parama.k.extStatus;
      if (MsfSdkUtils.isBatteryOnlineStatus(parama.k)) {
        ((SvcReqRegister)localObject1).iBatteryStatus = MsfSdkUtils.getSendBatteryStatus(parama.k.batteryCapacity, parama.k.powerConnect);
      } else {
        ((SvcReqRegister)localObject1).iBatteryStatus = 0;
      }
      try
      {
        ((SvcReqRegister)localObject1).iOSVersion = Integer.parseInt(Build.VERSION.SDK);
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      if (NetConnInfoCenter.isMobileConn()) {
        ((SvcReqRegister)localObject1).cNetType = 0;
      } else if (NetConnInfoCenter.isWifiConn()) {
        ((SvcReqRegister)localObject1).cNetType = 1;
      }
      ((SvcReqRegister)localObject1).vecGuid = NetConnInfoCenter.GUID;
      ((SvcReqRegister)localObject1).strDevName = Build.MODEL;
      ((SvcReqRegister)localObject1).strDevType = Build.MODEL;
      ((SvcReqRegister)localObject1).strOSVer = Build.VERSION.RELEASE;
      if (!paramBoolean)
      {
        ((SvcReqRegister)localObject1).uNewSSOIp = d;
        ((SvcReqRegister)localObject1).uOldSSOIp = c;
        ((SvcReqRegister)localObject1).strVendorName = ROMUtil.getRomName();
        ((SvcReqRegister)localObject1).strVendorOSName = ROMUtil.getRomVersion(20);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("register online report ");
          ((StringBuilder)localObject3).append(((SvcReqRegister)localObject1).strVendorName);
          ((StringBuilder)localObject3).append(" ");
          ((StringBuilder)localObject3).append(((SvcReqRegister)localObject1).strVendorOSName);
          QLog.d("MSF.C.PushManager:PushCoder", 2, ((StringBuilder)localObject3).toString());
        }
      }
      ((SvcReqRegister)localObject1).bytes_0x769_reqbody = MsfPullConfigUtil.pullConfigRequest(false);
      if (SettingCloneUtil.readValue(BaseApplication.getContext(), parama.k.uin, null, "qqsetting_qrlogin_set_mute", false)) {
        ((SvcReqRegister)localObject1).bSetMute = 1;
      } else {
        ((SvcReqRegister)localObject1).bSetMute = 0;
      }
      i1 = BaseApplication.getContext().getThirdPushType();
      if (i1 > 0)
      {
        localObject3 = new VendorPushInfo();
        ((VendorPushInfo)localObject3).uVendorType = i1;
        ((SvcReqRegister)localObject1).stVendorPushInfo = ((VendorPushInfo)localObject3);
        if (i1 == 3)
        {
          localObject3 = MsfCore.sCore.getMainAccount();
          bool = b.b(BaseApplication.getContext(), (String)localObject3);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("HPush_msf-pushCoder msgNotificationEnabled = ");
          ((StringBuilder)localObject3).append(bool);
          QLog.d("MSF.C.PushManager:PushCoder", 1, ((StringBuilder)localObject3).toString());
          if (!bool) {
            break label1640;
          }
          b1 = 1;
          ((SvcReqRegister)localObject1).cNotifySwitch = b1;
        }
      }
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("HPush_msf-pushCoder.vendor_push_type:");
      ((StringBuilder)localObject3).append(i1);
      QLog.d("MSF.C.PushManager:PushCoder", 1, ((StringBuilder)localObject3).toString());
      ((UniPacket)localObject2).put(p, localObject1);
      localObject2 = ((UniPacket)localObject2).encode();
      localObject3 = new ToServiceMsg("", parama.k.uin, "StatSvc.register");
      ((ToServiceMsg)localObject3).setAppId(parama.a);
      if (paramToServiceMsg != null)
      {
        ((ToServiceMsg)localObject3).setAppSeq(paramToServiceMsg.getAppSeq());
        ((ToServiceMsg)localObject3).addAttribute("to_srcCmd", paramToServiceMsg.getServiceCmd());
        i1 = paramToServiceMsg.extraData.getInt("oldStatus", 0);
        ((ToServiceMsg)localObject3).extraData.putInt("oldStatus", i1);
      }
      ((ToServiceMsg)localObject3).setRequestSsoSeq(MsfCore.getNextSeq());
      ((ToServiceMsg)localObject3).putWupBuffer((byte[])localObject2);
      ((ToServiceMsg)localObject3).setTimeout(30000L);
      ((ToServiceMsg)localObject3).addAttribute("regPushReason", paramRegPushReason.toString());
      if (paramBoolean) {
        ((ToServiceMsg)localObject3).setMsfCommand(MsfCommand._msf_UnRegPush);
      } else {
        ((ToServiceMsg)localObject3).setMsfCommand(MsfCommand._msf_RegPush);
      }
      MsfSdkUtils.addToMsgProcessName(parama.b, (ToServiceMsg)localObject3);
      g.v = true;
      this.h = System.currentTimeMillis();
      this.f.c.sendSsoMsg((ToServiceMsg)localObject3);
      parama.e = System.currentTimeMillis();
      if (paramBoolean)
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handlerPush send ");
        paramToServiceMsg.append(MD5.toMD5(parama.k.uin));
        paramToServiceMsg.append(" unregister push id ");
        paramToServiceMsg.append(parama.c);
        paramToServiceMsg.append(" pushStatus:");
        paramToServiceMsg.append(parama.k.iStatus);
        paramToServiceMsg.append(" bRegType:");
        paramToServiceMsg.append(((SvcReqRegister)localObject1).bRegType);
        paramToServiceMsg.append(" extStatus:");
        paramToServiceMsg.append(parama.k.extStatus);
        paramToServiceMsg.append(" batter:");
        paramToServiceMsg.append(((SvcReqRegister)localObject1).iBatteryStatus);
        QLog.d("MSF.C.PushManager:PushCoder", 1, paramToServiceMsg.toString());
      }
      else
      {
        this.g = true;
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handlerPush send ");
        paramToServiceMsg.append(MD5.toMD5(parama.k.uin));
        paramToServiceMsg.append(" register push id ");
        paramToServiceMsg.append(parama.c);
        paramToServiceMsg.append(" pushStatus:");
        paramToServiceMsg.append(parama.k.iStatus);
        paramToServiceMsg.append(" bRegType:");
        paramToServiceMsg.append(((SvcReqRegister)localObject1).bRegType);
        paramToServiceMsg.append(" timeStamp:");
        paramToServiceMsg.append(((SvcReqRegister)localObject1).timeStamp);
        paramToServiceMsg.append(" newIP:");
        paramToServiceMsg.append(d);
        paramToServiceMsg.append(" oldIP:");
        paramToServiceMsg.append(c);
        paramToServiceMsg.append(",regPushReason:");
        paramToServiceMsg.append(paramRegPushReason.toString());
        paramToServiceMsg.append(" extStatus:");
        paramToServiceMsg.append(parama.k.extStatus);
        paramToServiceMsg.append(" battery:");
        paramToServiceMsg.append(((SvcReqRegister)localObject1).iBatteryStatus);
        QLog.d("MSF.C.PushManager:PushCoder", 1, paramToServiceMsg.toString());
      }
    }
    catch (Exception parama)
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("send registerPush error ");
      paramToServiceMsg.append(parama);
      QLog.d("MSF.C.PushManager:PushCoder", 1, paramToServiceMsg.toString(), parama);
    }
    this.f.a();
  }
  
  void a(a parama, boolean paramBoolean)
  {
    Object localObject1;
    if ((com.tencent.mobileqq.msf.core.a.a.u) && (!paramBoolean))
    {
      long l1 = this.f.g() + this.f.e();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("sendMsgPushQuery, check time now=");
        ((StringBuilder)localObject1).append(g.h.format(Long.valueOf(System.currentTimeMillis())));
        ((StringBuilder)localObject1).append(", shouldSendQueryTime=");
        ((StringBuilder)localObject1).append(g.h.format(Long.valueOf(l1)));
        QLog.d("MSF.C.PushManager:PushCoder", 2, ((StringBuilder)localObject1).toString());
      }
      if (System.currentTimeMillis() < l1)
      {
        this.f.a(l1 - System.currentTimeMillis());
        return;
      }
    }
    Object localObject3;
    try
    {
      if (this.f.h() > 0L) {
        g.l = SystemClock.elapsedRealtime() - this.f.h();
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("alarmTime: ");
        ((StringBuilder)localObject1).append(g.l);
        ((StringBuilder)localObject1).append(" ,lastRecvSsoPacketTimeForSimpleGet=");
        ((StringBuilder)localObject1).append(this.f.h());
        QLog.d("MSF.C.PushManager:PushCoder", 2, ((StringBuilder)localObject1).toString());
      }
      if ((com.tencent.mobileqq.msf.core.a.a.v) && (g.l > com.tencent.mobileqq.msf.core.a.a.bm()))
      {
        localObject1 = MsfService.getCore().getAccountCenter().i();
        if ((com.tencent.mobileqq.msf.core.a.a.w) && (Long.parseLong((String)localObject1) % 2L != 0L))
        {
          this.f.E = SystemClock.elapsedRealtime();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("wakeup too long, but not close conn:");
          ((StringBuilder)localObject1).append(g.l);
          QLog.d("MSF.C.PushManager:PushCoder", 1, ((StringBuilder)localObject1).toString());
        }
        else
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("try closeConn closeByAlarmWakeUpTooLong by a exceeded time to wakeup alarm :");
          ((StringBuilder)localObject3).append(g.l);
          QLog.d("MSF.C.PushManager:PushCoder", 1, ((StringBuilder)localObject3).toString());
          this.f.c.sender.b.a(com.tencent.qphone.base.a.D);
          if (this.f.c.getStatReporter() != null) {
            this.f.c.getStatReporter().a("1", (String)localObject1, true, 0L);
          }
        }
      }
      if ((com.tencent.mobileqq.msf.core.a.a.v) && (g.l > com.tencent.mobileqq.msf.core.a.a.bn()) && (g.l <= com.tencent.mobileqq.msf.core.a.a.bm())) {
        this.f.G = SystemClock.elapsedRealtime();
      }
    }
    catch (Exception localException1)
    {
      QLog.d("MSF.C.PushManager:PushCoder", 1, "do PreDetectionAlarmTimeAlpha error!", localException1);
    }
    if (parama.k != null)
    {
      Object localObject2;
      if ((parama.k.uin != null) && (parama.c > 0L))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.f.d);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(NetConnInfoCenter.getSystemNetworkType());
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(NetConnInfoCenter.getCurrentAPN());
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - this.l);
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new ToServiceMsg("", parama.k.uin, k);
        ((ToServiceMsg)localObject3).setAppId(parama.a);
        ((ToServiceMsg)localObject3).setTimeout(30000L);
        ((ToServiceMsg)localObject3).setMsfCommand(MsfCommand._msf_queryPush);
        ((ToServiceMsg)localObject3).setRequestSsoSeq(MsfCore.getNextSeq());
        if (g.l > 0L)
        {
          ((ToServiceMsg)localObject3).addAttribute("_attr_alarm_elapsed_time", Long.valueOf(g.l));
          g.l = 0L;
        }
        MsfSdkUtils.addToMsgProcessName(parama.b, (ToServiceMsg)localObject3);
        try
        {
          this.f.c.sendSsoMsg((ToServiceMsg)localObject3);
        }
        catch (Exception localException2)
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("query push error ");
          localStringBuilder2.append(localException2);
          QLog.w("MSF.C.PushManager:PushCoder", 1, localStringBuilder2.toString(), localException2);
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("send ");
          localStringBuilder1.append(parama.k.uin);
          localStringBuilder1.append(" query push id ");
          localStringBuilder1.append(parama.c);
          localStringBuilder1.append(" model:");
          localStringBuilder1.append((String)localObject2);
          QLog.d("MSF.C.PushManager:PushCoder", 2, localStringBuilder1.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("pushUin is ");
        ((StringBuilder)localObject2).append(parama.k.uin);
        ((StringBuilder)localObject2).append(", queryPushId is ");
        ((StringBuilder)localObject2).append(parama.c);
        ((StringBuilder)localObject2).append(". no query");
        QLog.d("MSF.C.PushManager:PushCoder", 2, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = u.c();
    try
    {
      if (paramFromServiceMsg.isSuccess())
      {
        localObject = new UniPacket(true);
        ((UniPacket)localObject).decode(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = (com.tencent.msf.service.protocol.a.b)((UniPacket)localObject).getByClass("resp_PullUnreadMsgCount", new com.tencent.msf.service.protocol.a.b());
        if ((paramFromServiceMsg != null) && ((paramFromServiceMsg.c > 0L) || (paramFromServiceMsg.d > 0L) || (paramFromServiceMsg.e > 0L)))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("UnreadMsg getted, call QQ process now resp.c2c_count:");
            ((StringBuilder)localObject).append(paramFromServiceMsg.c);
            ((StringBuilder)localObject).append(" resp.group_count :");
            ((StringBuilder)localObject).append(paramFromServiceMsg.d);
            ((StringBuilder)localObject).append(" resp.discuss_count");
            ((StringBuilder)localObject).append(paramFromServiceMsg.e);
            QLog.d("MSF.C.PushManager:PushCoder", 2, ((StringBuilder)localObject).toString());
          }
          c(paramToServiceMsg);
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("UnreadMsg getted,  resp.c2c_count:");
          ((StringBuilder)localObject).append(paramFromServiceMsg.c);
          ((StringBuilder)localObject).append(" resp.group_count :");
          ((StringBuilder)localObject).append(paramFromServiceMsg.d);
          ((StringBuilder)localObject).append(" resp.discuss_count");
          ((StringBuilder)localObject).append(paramFromServiceMsg.e);
          QLog.d("MSF.C.PushManager:PushCoder", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager:PushCoder", 2, "UnreadMsg timeout, call QQ process now");
        }
        c(paramToServiceMsg);
        return;
      }
    }
    catch (Throwable paramFromServiceMsg)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handle unreadmsg error ");
      ((StringBuilder)localObject).append(paramFromServiceMsg);
      QLog.d("MSF.C.PushManager:PushCoder", 1, ((StringBuilder)localObject).toString(), paramFromServiceMsg);
      c(paramToServiceMsg);
    }
  }
  
  /* Error */
  void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 824
    //   4: invokevirtual 827	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   7: checkcast 334	java/lang/Long
    //   10: invokevirtual 830	java/lang/Long:longValue	()J
    //   13: lstore 18
    //   15: lload 18
    //   17: aload_0
    //   18: getfield 81	com/tencent/mobileqq/msf/core/push/e:h	J
    //   21: lcmp
    //   22: ifle +8 -> 30
    //   25: aload_0
    //   26: iconst_0
    //   27: putfield 79	com/tencent/mobileqq/msf/core/push/e:g	Z
    //   30: invokestatic 124	java/lang/System:currentTimeMillis	()J
    //   33: lload 18
    //   35: lsub
    //   36: lstore 16
    //   38: aload_1
    //   39: aload_2
    //   40: invokestatic 833	com/tencent/mobileqq/msf/core/d/j:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)J
    //   43: lstore 20
    //   45: aload_2
    //   46: invokevirtual 790	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   49: istore 22
    //   51: iload 22
    //   53: ifne +31 -> 84
    //   56: iconst_0
    //   57: istore 6
    //   59: ldc2_w 834
    //   62: lstore 10
    //   64: iconst_m1
    //   65: istore 5
    //   67: aconst_null
    //   68: astore 24
    //   70: ldc2_w 834
    //   73: lstore 8
    //   75: iconst_m1
    //   76: istore 4
    //   78: iconst_m1
    //   79: istore 7
    //   81: goto +473 -> 554
    //   84: aload_2
    //   85: invokevirtual 793	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   88: astore 23
    //   90: aload 23
    //   92: ifnull +459 -> 551
    //   95: aload_2
    //   96: invokevirtual 793	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   99: arraylength
    //   100: iconst_5
    //   101: if_icmpge +6 -> 107
    //   104: goto +447 -> 551
    //   107: new 307	com/qq/jce/wup/UniPacket
    //   110: dup
    //   111: iconst_1
    //   112: invokespecial 309	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   115: astore 23
    //   117: aload 23
    //   119: aload_2
    //   120: invokevirtual 793	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   123: invokevirtual 796	com/qq/jce/wup/UniPacket:decode	([B)V
    //   126: aload 23
    //   128: ldc_w 837
    //   131: new 839	com/tencent/msf/service/protocol/push/SvcRespRegister
    //   134: dup
    //   135: invokespecial 840	com/tencent/msf/service/protocol/push/SvcRespRegister:<init>	()V
    //   138: invokevirtual 804	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   141: checkcast 839	com/tencent/msf/service/protocol/push/SvcRespRegister
    //   144: astore 23
    //   146: aload 23
    //   148: getfield 843	com/tencent/msf/service/protocol/push/SvcRespRegister:strClientIP	Ljava/lang/String;
    //   151: invokestatic 844	com/tencent/mobileqq/msf/core/ad:c	(Ljava/lang/String;)V
    //   154: aload 23
    //   156: getfield 847	com/tencent/msf/service/protocol/push/SvcRespRegister:iClientPort	I
    //   159: invokestatic 849	com/tencent/mobileqq/msf/core/ad:d	(I)V
    //   162: aload 23
    //   164: getfield 852	com/tencent/msf/service/protocol/push/SvcRespRegister:bUpdateFlag	B
    //   167: istore 4
    //   169: aload 23
    //   171: getfield 853	com/tencent/msf/service/protocol/push/SvcRespRegister:timeStamp	J
    //   174: lstore 8
    //   176: aload 23
    //   178: getfield 856	com/tencent/msf/service/protocol/push/SvcRespRegister:cReplyCode	B
    //   181: istore_3
    //   182: aload 23
    //   184: getfield 857	com/tencent/msf/service/protocol/push/SvcRespRegister:iStatus	I
    //   187: istore 5
    //   189: aload 23
    //   191: getfield 860	com/tencent/msf/service/protocol/push/SvcRespRegister:lServerTime	J
    //   194: lstore 10
    //   196: lload 10
    //   198: lconst_0
    //   199: lcmp
    //   200: ifle +19 -> 219
    //   203: aload 23
    //   205: getfield 860	com/tencent/msf/service/protocol/push/SvcRespRegister:lServerTime	J
    //   208: invokestatic 863	com/tencent/mobileqq/msf/core/NetConnInfoCenter:handleGetServerTimeResp	(J)V
    //   211: goto +8 -> 219
    //   214: astore 24
    //   216: goto +228 -> 444
    //   219: aload 23
    //   221: getfield 864	com/tencent/msf/service/protocol/push/SvcRespRegister:uExtOnlineStatus	J
    //   224: lstore 12
    //   226: iload_3
    //   227: ifne +18 -> 245
    //   230: aload 23
    //   232: getfield 867	com/tencent/msf/service/protocol/push/SvcRespRegister:uClientBatteryGetInterval	J
    //   235: lstore 14
    //   237: goto +13 -> 250
    //   240: astore 24
    //   242: goto +190 -> 432
    //   245: ldc2_w 834
    //   248: lstore 14
    //   250: lload 12
    //   252: lstore 10
    //   254: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: istore 22
    //   259: iload 22
    //   261: ifeq +51 -> 312
    //   264: ldc 11
    //   266: iconst_2
    //   267: iconst_4
    //   268: anewarray 4	java/lang/Object
    //   271: dup
    //   272: iconst_0
    //   273: ldc_w 869
    //   276: aastore
    //   277: dup
    //   278: iconst_1
    //   279: iload_3
    //   280: invokestatic 874	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   283: aastore
    //   284: dup
    //   285: iconst_2
    //   286: ldc_w 876
    //   289: aastore
    //   290: dup
    //   291: iconst_3
    //   292: lload 14
    //   294: invokestatic 667	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   297: aastore
    //   298: invokestatic 879	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   301: goto +11 -> 312
    //   304: astore 24
    //   306: iload_3
    //   307: istore 7
    //   309: goto +193 -> 502
    //   312: invokestatic 882	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   315: ifeq +1655 -> 1970
    //   318: new 134	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   325: astore 24
    //   327: aload 24
    //   329: ldc_w 884
    //   332: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 24
    //   338: aload 23
    //   340: getfield 860	com/tencent/msf/service/protocol/push/SvcRespRegister:lServerTime	J
    //   343: invokevirtual 149	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 24
    //   349: aload_0
    //   350: getfield 99	com/tencent/mobileqq/msf/core/push/e:f	Lcom/tencent/mobileqq/msf/core/push/g;
    //   353: getfield 287	com/tencent/mobileqq/msf/core/push/g:c	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   356: getfield 887	com/tencent/mobileqq/msf/core/MsfCore:timeFormatter	Ljava/text/SimpleDateFormat;
    //   359: aload 23
    //   361: getfield 860	com/tencent/msf/service/protocol/push/SvcRespRegister:lServerTime	J
    //   364: ldc2_w 263
    //   367: lmul
    //   368: invokestatic 667	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   371: invokevirtual 673	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   374: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: ldc 11
    //   380: iconst_4
    //   381: aload 24
    //   383: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   389: goto +3 -> 392
    //   392: aload 23
    //   394: getfield 890	com/tencent/msf/service/protocol/push/SvcRespRegister:bytes_0x769_rspbody	[B
    //   397: iconst_0
    //   398: invokestatic 894	com/tencent/mobileqq/msf/core/net/utils/MsfPullConfigUtil:parseConfigResponse	([BZ)V
    //   401: iconst_1
    //   402: istore 6
    //   404: aload 23
    //   406: astore 24
    //   408: iload_3
    //   409: istore 7
    //   411: goto +143 -> 554
    //   414: astore 24
    //   416: iload_3
    //   417: istore 7
    //   419: goto +83 -> 502
    //   422: astore 24
    //   424: iload_3
    //   425: istore 7
    //   427: goto +75 -> 502
    //   430: astore 24
    //   432: lload 12
    //   434: lstore 10
    //   436: iload_3
    //   437: istore 7
    //   439: goto +63 -> 502
    //   442: astore 24
    //   444: iload_3
    //   445: istore 7
    //   447: goto +50 -> 497
    //   450: astore 24
    //   452: iload_3
    //   453: istore 7
    //   455: goto +39 -> 494
    //   458: astore 24
    //   460: goto +31 -> 491
    //   463: astore 24
    //   465: ldc2_w 834
    //   468: lstore 8
    //   470: goto +21 -> 491
    //   473: astore 24
    //   475: goto +8 -> 483
    //   478: astore 24
    //   480: aconst_null
    //   481: astore 23
    //   483: ldc2_w 834
    //   486: lstore 8
    //   488: iconst_m1
    //   489: istore 4
    //   491: iconst_m1
    //   492: istore 7
    //   494: iconst_m1
    //   495: istore 5
    //   497: ldc2_w 834
    //   500: lstore 10
    //   502: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   505: ifeq +17 -> 522
    //   508: ldc 11
    //   510: iconst_2
    //   511: ldc_w 896
    //   514: aload 24
    //   516: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   519: goto +3 -> 522
    //   522: iconst_0
    //   523: istore 6
    //   525: aload 23
    //   527: astore 24
    //   529: goto +25 -> 554
    //   532: astore 23
    //   534: goto +5 -> 539
    //   537: astore 23
    //   539: ldc_w 898
    //   542: astore 25
    //   544: aload 23
    //   546: astore 24
    //   548: goto +1337 -> 1885
    //   551: goto -495 -> 56
    //   554: aload_1
    //   555: ifnull +36 -> 591
    //   558: aload_1
    //   559: invokevirtual 902	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   562: ldc_w 592
    //   565: invokevirtual 906	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   568: ifeq +23 -> 591
    //   571: aload_1
    //   572: ldc_w 592
    //   575: invokevirtual 827	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   578: checkcast 271	java/lang/String
    //   581: astore 23
    //   583: goto +13 -> 596
    //   586: astore 23
    //   588: goto -49 -> 539
    //   591: ldc_w 898
    //   594: astore 23
    //   596: lload 16
    //   598: lstore 12
    //   600: iload 6
    //   602: ifeq +952 -> 1554
    //   605: iconst_1
    //   606: putstatic 908	com/tencent/mobileqq/msf/core/push/e:e	Z
    //   609: aload_0
    //   610: iconst_0
    //   611: putfield 87	com/tencent/mobileqq/msf/core/push/e:i	I
    //   614: aload_0
    //   615: invokestatic 124	java/lang/System:currentTimeMillis	()J
    //   618: putfield 89	com/tencent/mobileqq/msf/core/push/e:l	J
    //   621: aload_1
    //   622: invokevirtual 912	com/tencent/qphone/base/remote/ToServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   625: astore 25
    //   627: getstatic 599	com/tencent/mobileqq/msf/sdk/MsfCommand:_msf_UnRegPush	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   630: astore 26
    //   632: aload 25
    //   634: aload 26
    //   636: if_acmpne +61 -> 697
    //   639: new 134	java/lang/StringBuilder
    //   642: dup
    //   643: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   646: astore 25
    //   648: aload 25
    //   650: ldc_w 914
    //   653: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: pop
    //   657: aload 25
    //   659: aload_2
    //   660: invokevirtual 915	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   663: invokestatic 626	com/tencent/qphone/base/util/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   666: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: pop
    //   670: ldc 11
    //   672: iconst_1
    //   673: aload 25
    //   675: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   678: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   681: goto +151 -> 832
    //   684: astore 24
    //   686: aload 23
    //   688: astore 25
    //   690: aload 24
    //   692: astore 23
    //   694: goto -150 -> 544
    //   697: new 134	java/lang/StringBuilder
    //   700: dup
    //   701: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   704: astore 25
    //   706: aload 25
    //   708: ldc_w 917
    //   711: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: pop
    //   715: aload 25
    //   717: aload_2
    //   718: invokevirtual 915	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   721: invokestatic 626	com/tencent/qphone/base/util/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   724: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: pop
    //   728: aload 25
    //   730: ldc_w 919
    //   733: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: pop
    //   737: aload 25
    //   739: iload 4
    //   741: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   744: pop
    //   745: aload 25
    //   747: ldc_w 921
    //   750: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: pop
    //   754: aload 25
    //   756: lload 8
    //   758: invokevirtual 149	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   761: pop
    //   762: aload 25
    //   764: ldc_w 923
    //   767: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: pop
    //   771: aload 25
    //   773: iload 7
    //   775: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   778: pop
    //   779: aload 25
    //   781: ldc_w 925
    //   784: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: pop
    //   788: aload 25
    //   790: iload 5
    //   792: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   795: pop
    //   796: aload 25
    //   798: ldc_w 927
    //   801: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: pop
    //   805: aload 25
    //   807: aload 23
    //   809: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: pop
    //   813: ldc 11
    //   815: iconst_1
    //   816: aload 25
    //   818: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   821: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   824: aload_0
    //   825: aload_1
    //   826: invokestatic 930	com/tencent/mobileqq/msf/service/u:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Ljava/lang/String;
    //   829: invokevirtual 932	com/tencent/mobileqq/msf/core/push/e:b	(Ljava/lang/String;)V
    //   832: aload_1
    //   833: invokestatic 930	com/tencent/mobileqq/msf/service/u:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Ljava/lang/String;
    //   836: astore 25
    //   838: aload_0
    //   839: getfield 99	com/tencent/mobileqq/msf/core/push/e:f	Lcom/tencent/mobileqq/msf/core/push/g;
    //   842: getfield 935	com/tencent/mobileqq/msf/core/push/g:i	Ljava/util/concurrent/ConcurrentHashMap;
    //   845: aload 25
    //   847: invokevirtual 941	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   850: checkcast 220	com/tencent/mobileqq/msf/core/push/a
    //   853: astore 25
    //   855: aload 25
    //   857: ifnull +472 -> 1329
    //   860: aload 25
    //   862: aload_0
    //   863: getfield 99	com/tencent/mobileqq/msf/core/push/e:f	Lcom/tencent/mobileqq/msf/core/push/g;
    //   866: getfield 287	com/tencent/mobileqq/msf/core/push/g:c	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   869: getfield 944	com/tencent/mobileqq/msf/core/MsfCore:nowSocketConnAdd	Ljava/lang/String;
    //   872: putfield 946	com/tencent/mobileqq/msf/core/push/a:i	Ljava/lang/String;
    //   875: aload 25
    //   877: invokestatic 124	java/lang/System:currentTimeMillis	()J
    //   880: putfield 948	com/tencent/mobileqq/msf/core/push/a:f	J
    //   883: iload 5
    //   885: ifle +149 -> 1034
    //   888: aload 25
    //   890: getfield 223	com/tencent/mobileqq/msf/core/push/a:k	Lcom/tencent/mobileqq/msf/sdk/PushRegisterInfo;
    //   893: astore 26
    //   895: aload 26
    //   897: ifnull +64 -> 961
    //   900: aload 25
    //   902: getfield 223	com/tencent/mobileqq/msf/core/push/a:k	Lcom/tencent/mobileqq/msf/sdk/PushRegisterInfo;
    //   905: getfield 343	com/tencent/mobileqq/msf/sdk/PushRegisterInfo:iStatus	I
    //   908: iload 5
    //   910: if_icmpeq +51 -> 961
    //   913: ldc 11
    //   915: iconst_1
    //   916: ldc_w 950
    //   919: iconst_2
    //   920: anewarray 4	java/lang/Object
    //   923: dup
    //   924: iconst_0
    //   925: aload 25
    //   927: getfield 223	com/tencent/mobileqq/msf/core/push/a:k	Lcom/tencent/mobileqq/msf/sdk/PushRegisterInfo;
    //   930: getfield 343	com/tencent/mobileqq/msf/sdk/PushRegisterInfo:iStatus	I
    //   933: invokestatic 953	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   936: aastore
    //   937: dup
    //   938: iconst_1
    //   939: iload 5
    //   941: invokestatic 953	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   944: aastore
    //   945: invokestatic 956	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   948: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   951: aload 25
    //   953: getfield 223	com/tencent/mobileqq/msf/core/push/a:k	Lcom/tencent/mobileqq/msf/sdk/PushRegisterInfo;
    //   956: iload 5
    //   958: putfield 343	com/tencent/mobileqq/msf/sdk/PushRegisterInfo:iStatus	I
    //   961: aload 25
    //   963: getfield 223	com/tencent/mobileqq/msf/core/push/a:k	Lcom/tencent/mobileqq/msf/sdk/PushRegisterInfo;
    //   966: ifnull +1007 -> 1973
    //   969: aload 25
    //   971: getfield 223	com/tencent/mobileqq/msf/core/push/a:k	Lcom/tencent/mobileqq/msf/sdk/PushRegisterInfo;
    //   974: getfield 375	com/tencent/mobileqq/msf/sdk/PushRegisterInfo:extStatus	J
    //   977: lload 10
    //   979: lcmp
    //   980: ifeq +993 -> 1973
    //   983: ldc 11
    //   985: iconst_1
    //   986: ldc_w 950
    //   989: iconst_2
    //   990: anewarray 4	java/lang/Object
    //   993: dup
    //   994: iconst_0
    //   995: aload 25
    //   997: getfield 223	com/tencent/mobileqq/msf/core/push/a:k	Lcom/tencent/mobileqq/msf/sdk/PushRegisterInfo;
    //   1000: getfield 375	com/tencent/mobileqq/msf/sdk/PushRegisterInfo:extStatus	J
    //   1003: invokestatic 667	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1006: aastore
    //   1007: dup
    //   1008: iconst_1
    //   1009: lload 10
    //   1011: invokestatic 667	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1014: aastore
    //   1015: invokestatic 956	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1018: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1021: aload 25
    //   1023: getfield 223	com/tencent/mobileqq/msf/core/push/a:k	Lcom/tencent/mobileqq/msf/sdk/PushRegisterInfo;
    //   1026: lload 10
    //   1028: putfield 375	com/tencent/mobileqq/msf/sdk/PushRegisterInfo:extStatus	J
    //   1031: goto +942 -> 1973
    //   1034: aload_1
    //   1035: ifnull +938 -> 1973
    //   1038: aload_1
    //   1039: getfield 564	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   1042: ldc_w 566
    //   1045: iconst_0
    //   1046: invokevirtual 572	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   1049: istore 4
    //   1051: new 134	java/lang/StringBuilder
    //   1054: dup
    //   1055: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1058: astore 25
    //   1060: aload 25
    //   1062: ldc_w 958
    //   1065: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: pop
    //   1069: aload 25
    //   1071: iload 4
    //   1073: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1076: pop
    //   1077: ldc 11
    //   1079: iconst_1
    //   1080: aload 25
    //   1082: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1085: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1088: aload_2
    //   1089: getfield 962	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1092: ldc_w 964
    //   1095: iload 4
    //   1097: invokestatic 953	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1100: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1103: pop
    //   1104: goto +3 -> 1107
    //   1107: aload 24
    //   1109: ifnull +155 -> 1264
    //   1112: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1115: ifeq +103 -> 1218
    //   1118: new 134	java/lang/StringBuilder
    //   1121: dup
    //   1122: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1125: astore 25
    //   1127: aload 25
    //   1129: ldc_w 966
    //   1132: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: pop
    //   1136: aload 25
    //   1138: aload 24
    //   1140: getfield 969	com/tencent/msf/service/protocol/push/SvcRespRegister:iHelloInterval	I
    //   1143: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1146: pop
    //   1147: aload 25
    //   1149: ldc_w 971
    //   1152: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1155: pop
    //   1156: aload 25
    //   1158: aload_0
    //   1159: getfield 99	com/tencent/mobileqq/msf/core/push/e:f	Lcom/tencent/mobileqq/msf/core/push/g;
    //   1162: invokevirtual 659	com/tencent/mobileqq/msf/core/push/g:e	()J
    //   1165: invokevirtual 149	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1168: pop
    //   1169: aload 25
    //   1171: ldc_w 973
    //   1174: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1177: pop
    //   1178: aload 25
    //   1180: getstatic 664	com/tencent/mobileqq/msf/core/push/g:h	Ljava/text/SimpleDateFormat;
    //   1183: invokestatic 124	java/lang/System:currentTimeMillis	()J
    //   1186: aload 24
    //   1188: getfield 969	com/tencent/msf/service/protocol/push/SvcRespRegister:iHelloInterval	I
    //   1191: sipush 1000
    //   1194: imul
    //   1195: i2l
    //   1196: ladd
    //   1197: invokestatic 667	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1200: invokevirtual 673	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   1203: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: pop
    //   1207: ldc 11
    //   1209: iconst_2
    //   1210: aload 25
    //   1212: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1215: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1218: invokestatic 976	com/tencent/mobileqq/msf/core/a/a:aQ	()Z
    //   1221: ifeq +9 -> 1230
    //   1224: getstatic 979	com/tencent/mobileqq/msf/core/net/a/b:e	Z
    //   1227: ifeq +20 -> 1247
    //   1230: aload_0
    //   1231: getfield 99	com/tencent/mobileqq/msf/core/push/e:f	Lcom/tencent/mobileqq/msf/core/push/g;
    //   1234: aload 24
    //   1236: getfield 969	com/tencent/msf/service/protocol/push/SvcRespRegister:iHelloInterval	I
    //   1239: sipush 1000
    //   1242: imul
    //   1243: i2l
    //   1244: putfield 981	com/tencent/mobileqq/msf/core/push/g:D	J
    //   1247: aload_0
    //   1248: getfield 99	com/tencent/mobileqq/msf/core/push/e:f	Lcom/tencent/mobileqq/msf/core/push/g;
    //   1251: aload_0
    //   1252: getfield 99	com/tencent/mobileqq/msf/core/push/e:f	Lcom/tencent/mobileqq/msf/core/push/g;
    //   1255: invokevirtual 659	com/tencent/mobileqq/msf/core/push/g:e	()J
    //   1258: invokevirtual 677	com/tencent/mobileqq/msf/core/push/g:a	(J)V
    //   1261: goto +68 -> 1329
    //   1264: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1267: ifeq +45 -> 1312
    //   1270: new 134	java/lang/StringBuilder
    //   1273: dup
    //   1274: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1277: astore 24
    //   1279: aload 24
    //   1281: ldc_w 983
    //   1284: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1287: pop
    //   1288: aload 24
    //   1290: aload_0
    //   1291: getfield 99	com/tencent/mobileqq/msf/core/push/e:f	Lcom/tencent/mobileqq/msf/core/push/g;
    //   1294: invokevirtual 659	com/tencent/mobileqq/msf/core/push/g:e	()J
    //   1297: invokevirtual 149	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1300: pop
    //   1301: ldc 11
    //   1303: iconst_2
    //   1304: aload 24
    //   1306: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1309: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1312: aload_0
    //   1313: getfield 99	com/tencent/mobileqq/msf/core/push/e:f	Lcom/tencent/mobileqq/msf/core/push/g;
    //   1316: aload_0
    //   1317: getfield 99	com/tencent/mobileqq/msf/core/push/e:f	Lcom/tencent/mobileqq/msf/core/push/g;
    //   1320: invokevirtual 659	com/tencent/mobileqq/msf/core/push/g:e	()J
    //   1323: invokevirtual 677	com/tencent/mobileqq/msf/core/push/g:a	(J)V
    //   1326: goto +3 -> 1329
    //   1329: aload_2
    //   1330: getfield 962	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1333: ldc_w 985
    //   1336: lload 10
    //   1338: invokestatic 667	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1341: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1344: pop
    //   1345: aload_1
    //   1346: invokevirtual 912	com/tencent/qphone/base/remote/ToServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1349: astore 24
    //   1351: getstatic 606	com/tencent/mobileqq/msf/sdk/MsfCommand:_msf_RegPush	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1354: astore 25
    //   1356: aload 24
    //   1358: aload 25
    //   1360: if_acmpne +13 -> 1373
    //   1363: aload_2
    //   1364: getstatic 988	com/tencent/mobileqq/msf/sdk/MsfCommand:registerPush	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1367: invokevirtual 989	com/tencent/qphone/base/remote/FromServiceMsg:setMsfCommand	(Lcom/tencent/mobileqq/msf/sdk/MsfCommand;)V
    //   1370: goto +39 -> 1409
    //   1373: aload_1
    //   1374: invokevirtual 912	com/tencent/qphone/base/remote/ToServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1377: astore 24
    //   1379: getstatic 599	com/tencent/mobileqq/msf/sdk/MsfCommand:_msf_UnRegPush	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1382: astore 25
    //   1384: aload 24
    //   1386: aload 25
    //   1388: if_acmpne +13 -> 1401
    //   1391: aload_2
    //   1392: getstatic 992	com/tencent/mobileqq/msf/sdk/MsfCommand:unRegisterPush	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1395: invokevirtual 989	com/tencent/qphone/base/remote/FromServiceMsg:setMsfCommand	(Lcom/tencent/mobileqq/msf/sdk/MsfCommand;)V
    //   1398: goto +11 -> 1409
    //   1401: aload_2
    //   1402: aload_1
    //   1403: invokevirtual 912	com/tencent/qphone/base/remote/ToServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1406: invokevirtual 989	com/tencent/qphone/base/remote/FromServiceMsg:setMsfCommand	(Lcom/tencent/mobileqq/msf/sdk/MsfCommand;)V
    //   1409: aload_1
    //   1410: invokevirtual 902	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   1413: ldc_w 553
    //   1416: invokevirtual 906	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1419: istore 22
    //   1421: iload 22
    //   1423: ifeq +18 -> 1441
    //   1426: aload_0
    //   1427: getfield 99	com/tencent/mobileqq/msf/core/push/e:f	Lcom/tencent/mobileqq/msf/core/push/g;
    //   1430: getfield 287	com/tencent/mobileqq/msf/core/push/g:c	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1433: aload_1
    //   1434: aload_2
    //   1435: invokevirtual 995	com/tencent/mobileqq/msf/core/MsfCore:addRespToQuque	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   1438: goto +23 -> 1461
    //   1441: aload_1
    //   1442: invokestatic 930	com/tencent/mobileqq/msf/service/u:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Ljava/lang/String;
    //   1445: aload_2
    //   1446: invokestatic 999	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:addFromMsgProcessName	(Ljava/lang/String;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   1449: aload_0
    //   1450: getfield 99	com/tencent/mobileqq/msf/core/push/e:f	Lcom/tencent/mobileqq/msf/core/push/g;
    //   1453: getfield 287	com/tencent/mobileqq/msf/core/push/g:c	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1456: aconst_null
    //   1457: aload_2
    //   1458: invokevirtual 995	com/tencent/mobileqq/msf/core/MsfCore:addRespToQuque	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   1461: aload_0
    //   1462: getfield 99	com/tencent/mobileqq/msf/core/push/e:f	Lcom/tencent/mobileqq/msf/core/push/g;
    //   1465: getfield 287	com/tencent/mobileqq/msf/core/push/g:c	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1468: invokevirtual 291	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/d/j;
    //   1471: ifnull +498 -> 1969
    //   1474: aload_0
    //   1475: getfield 99	com/tencent/mobileqq/msf/core/push/e:f	Lcom/tencent/mobileqq/msf/core/push/g;
    //   1478: getfield 287	com/tencent/mobileqq/msf/core/push/g:c	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1481: invokevirtual 291	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/d/j;
    //   1484: astore 24
    //   1486: aload_2
    //   1487: invokevirtual 1002	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailCode	()I
    //   1490: istore 4
    //   1492: aload_1
    //   1493: invokevirtual 912	com/tencent/qphone/base/remote/ToServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1496: astore 25
    //   1498: getstatic 599	com/tencent/mobileqq/msf/sdk/MsfCommand:_msf_UnRegPush	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1501: astore 26
    //   1503: aload 25
    //   1505: aload 26
    //   1507: if_acmpne +9 -> 1516
    //   1510: iconst_1
    //   1511: istore 22
    //   1513: goto +6 -> 1519
    //   1516: iconst_0
    //   1517: istore 22
    //   1519: aload 24
    //   1521: iconst_1
    //   1522: lload 12
    //   1524: iload 4
    //   1526: lload 20
    //   1528: iload 22
    //   1530: aload 23
    //   1532: invokevirtual 1005	com/tencent/mobileqq/msf/core/d/j:a	(ZJIJZLjava/lang/String;)V
    //   1535: return
    //   1536: astore 24
    //   1538: goto +333 -> 1871
    //   1541: astore 24
    //   1543: aload 23
    //   1545: astore 25
    //   1547: aload 24
    //   1549: astore 23
    //   1551: goto -1007 -> 544
    //   1554: lload 18
    //   1556: aload_0
    //   1557: getfield 81	com/tencent/mobileqq/msf/core/push/e:h	J
    //   1560: lcmp
    //   1561: ifle +415 -> 1976
    //   1564: aload_0
    //   1565: getfield 79	com/tencent/mobileqq/msf/core/push/e:g	Z
    //   1568: ifne +408 -> 1976
    //   1571: iconst_0
    //   1572: putstatic 614	com/tencent/mobileqq/msf/core/push/g:v	Z
    //   1575: aload_0
    //   1576: getfield 87	com/tencent/mobileqq/msf/core/push/e:i	I
    //   1579: istore 4
    //   1581: iload 4
    //   1583: iconst_2
    //   1584: if_icmple +117 -> 1701
    //   1587: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1590: istore 22
    //   1592: iload 22
    //   1594: ifeq +85 -> 1679
    //   1597: new 134	java/lang/StringBuilder
    //   1600: dup
    //   1601: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1604: astore 24
    //   1606: aload 24
    //   1608: ldc_w 1007
    //   1611: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1614: pop
    //   1615: aload 24
    //   1617: aload_0
    //   1618: getfield 87	com/tencent/mobileqq/msf/core/push/e:i	I
    //   1621: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1624: pop
    //   1625: aload 24
    //   1627: ldc_w 1009
    //   1630: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1633: pop
    //   1634: aload 24
    //   1636: getstatic 664	com/tencent/mobileqq/msf/core/push/g:h	Ljava/text/SimpleDateFormat;
    //   1639: aload_0
    //   1640: getfield 99	com/tencent/mobileqq/msf/core/push/e:f	Lcom/tencent/mobileqq/msf/core/push/g;
    //   1643: invokevirtual 659	com/tencent/mobileqq/msf/core/push/g:e	()J
    //   1646: invokestatic 124	java/lang/System:currentTimeMillis	()J
    //   1649: ladd
    //   1650: invokestatic 667	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1653: invokevirtual 673	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   1656: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1659: pop
    //   1660: ldc 11
    //   1662: iconst_2
    //   1663: aload 24
    //   1665: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1668: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1671: goto +8 -> 1679
    //   1674: astore 24
    //   1676: goto -133 -> 1543
    //   1679: aload_0
    //   1680: iconst_0
    //   1681: putfield 87	com/tencent/mobileqq/msf/core/push/e:i	I
    //   1684: aload_0
    //   1685: getfield 99	com/tencent/mobileqq/msf/core/push/e:f	Lcom/tencent/mobileqq/msf/core/push/g;
    //   1688: aload_0
    //   1689: getfield 99	com/tencent/mobileqq/msf/core/push/e:f	Lcom/tencent/mobileqq/msf/core/push/g;
    //   1692: invokevirtual 659	com/tencent/mobileqq/msf/core/push/g:e	()J
    //   1695: invokevirtual 677	com/tencent/mobileqq/msf/core/push/g:a	(J)V
    //   1698: goto +102 -> 1800
    //   1701: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1704: ifeq +73 -> 1777
    //   1707: new 134	java/lang/StringBuilder
    //   1710: dup
    //   1711: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1714: astore 24
    //   1716: aload 24
    //   1718: ldc_w 1007
    //   1721: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1724: pop
    //   1725: aload 24
    //   1727: aload_0
    //   1728: getfield 87	com/tencent/mobileqq/msf/core/push/e:i	I
    //   1731: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1734: pop
    //   1735: aload 24
    //   1737: ldc_w 1011
    //   1740: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1743: pop
    //   1744: aload 24
    //   1746: getstatic 664	com/tencent/mobileqq/msf/core/push/g:h	Ljava/text/SimpleDateFormat;
    //   1749: invokestatic 124	java/lang/System:currentTimeMillis	()J
    //   1752: ldc2_w 1012
    //   1755: ladd
    //   1756: invokestatic 667	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1759: invokevirtual 673	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   1762: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1765: pop
    //   1766: ldc 11
    //   1768: iconst_2
    //   1769: aload 24
    //   1771: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1774: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1777: aload_0
    //   1778: aload_0
    //   1779: getfield 87	com/tencent/mobileqq/msf/core/push/e:i	I
    //   1782: iconst_1
    //   1783: iadd
    //   1784: putfield 87	com/tencent/mobileqq/msf/core/push/e:i	I
    //   1787: aload_0
    //   1788: getfield 99	com/tencent/mobileqq/msf/core/push/e:f	Lcom/tencent/mobileqq/msf/core/push/g;
    //   1791: ldc2_w 1012
    //   1794: invokevirtual 677	com/tencent/mobileqq/msf/core/push/g:a	(J)V
    //   1797: goto +3 -> 1800
    //   1800: aload_0
    //   1801: getfield 99	com/tencent/mobileqq/msf/core/push/e:f	Lcom/tencent/mobileqq/msf/core/push/g;
    //   1804: getfield 287	com/tencent/mobileqq/msf/core/push/g:c	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1807: invokevirtual 291	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/d/j;
    //   1810: ifnull +159 -> 1969
    //   1813: aload_0
    //   1814: getfield 99	com/tencent/mobileqq/msf/core/push/e:f	Lcom/tencent/mobileqq/msf/core/push/g;
    //   1817: getfield 287	com/tencent/mobileqq/msf/core/push/g:c	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1820: invokevirtual 291	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/d/j;
    //   1823: astore 24
    //   1825: aload_2
    //   1826: invokevirtual 1002	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailCode	()I
    //   1829: istore 4
    //   1831: aload_1
    //   1832: invokevirtual 912	com/tencent/qphone/base/remote/ToServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1835: getstatic 599	com/tencent/mobileqq/msf/sdk/MsfCommand:_msf_UnRegPush	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1838: if_acmpne +141 -> 1979
    //   1841: iconst_1
    //   1842: istore 22
    //   1844: goto +3 -> 1847
    //   1847: aload 24
    //   1849: iconst_0
    //   1850: lload 12
    //   1852: iload 4
    //   1854: lload 20
    //   1856: iload 22
    //   1858: aload 23
    //   1860: invokevirtual 1005	com/tencent/mobileqq/msf/core/d/j:a	(ZJIJZLjava/lang/String;)V
    //   1863: return
    //   1864: astore 24
    //   1866: goto +5 -> 1871
    //   1869: astore 24
    //   1871: aload 23
    //   1873: astore 25
    //   1875: goto +10 -> 1885
    //   1878: astore 24
    //   1880: ldc_w 898
    //   1883: astore 25
    //   1885: aload_0
    //   1886: getfield 99	com/tencent/mobileqq/msf/core/push/e:f	Lcom/tencent/mobileqq/msf/core/push/g;
    //   1889: getfield 287	com/tencent/mobileqq/msf/core/push/g:c	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1892: invokevirtual 291	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/d/j;
    //   1895: ifnull +56 -> 1951
    //   1898: aload_0
    //   1899: getfield 99	com/tencent/mobileqq/msf/core/push/e:f	Lcom/tencent/mobileqq/msf/core/push/g;
    //   1902: getfield 287	com/tencent/mobileqq/msf/core/push/g:c	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1905: invokevirtual 291	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/d/j;
    //   1908: astore 23
    //   1910: aload_2
    //   1911: invokevirtual 1002	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailCode	()I
    //   1914: istore 4
    //   1916: aload_1
    //   1917: invokevirtual 912	com/tencent/qphone/base/remote/ToServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1920: getstatic 599	com/tencent/mobileqq/msf/sdk/MsfCommand:_msf_UnRegPush	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1923: if_acmpne +9 -> 1932
    //   1926: iconst_1
    //   1927: istore 22
    //   1929: goto +6 -> 1935
    //   1932: iconst_0
    //   1933: istore 22
    //   1935: aload 23
    //   1937: iconst_0
    //   1938: lload 16
    //   1940: iload 4
    //   1942: lload 20
    //   1944: iload 22
    //   1946: aload 25
    //   1948: invokevirtual 1005	com/tencent/mobileqq/msf/core/d/j:a	(ZJIJZLjava/lang/String;)V
    //   1951: aload_0
    //   1952: getfield 99	com/tencent/mobileqq/msf/core/push/e:f	Lcom/tencent/mobileqq/msf/core/push/g;
    //   1955: astore_1
    //   1956: aload_1
    //   1957: aload_1
    //   1958: invokevirtual 659	com/tencent/mobileqq/msf/core/push/g:e	()J
    //   1961: invokevirtual 677	com/tencent/mobileqq/msf/core/push/g:a	(J)V
    //   1964: aload 24
    //   1966: invokevirtual 1014	java/lang/Throwable:printStackTrace	()V
    //   1969: return
    //   1970: goto -1578 -> 392
    //   1973: goto -866 -> 1107
    //   1976: goto -176 -> 1800
    //   1979: iconst_0
    //   1980: istore 22
    //   1982: goto -135 -> 1847
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1985	0	this	e
    //   0	1985	1	paramToServiceMsg	ToServiceMsg
    //   0	1985	2	paramFromServiceMsg	FromServiceMsg
    //   181	272	3	b1	byte
    //   76	1865	4	i1	int
    //   65	892	5	i2	int
    //   57	544	6	i3	int
    //   79	695	7	i4	int
    //   73	684	8	l1	long
    //   62	1275	10	l2	long
    //   224	1627	12	l3	long
    //   235	58	14	l4	long
    //   36	1903	16	l5	long
    //   13	1542	18	l6	long
    //   43	1900	20	l7	long
    //   49	1932	22	bool	boolean
    //   88	438	23	localObject1	Object
    //   532	1	23	localThrowable1	Throwable
    //   537	8	23	localThrowable2	Throwable
    //   581	1	23	str	String
    //   586	1	23	localThrowable3	Throwable
    //   594	1342	23	localObject2	Object
    //   68	1	24	localObject3	Object
    //   214	1	24	localException1	Exception
    //   240	1	24	localException2	Exception
    //   304	1	24	localException3	Exception
    //   325	82	24	localObject4	Object
    //   414	1	24	localException4	Exception
    //   422	1	24	localException5	Exception
    //   430	1	24	localException6	Exception
    //   442	1	24	localException7	Exception
    //   450	1	24	localException8	Exception
    //   458	1	24	localException9	Exception
    //   463	1	24	localException10	Exception
    //   473	1	24	localException11	Exception
    //   478	37	24	localException12	Exception
    //   527	20	24	localObject5	Object
    //   684	551	24	localThrowable4	Throwable
    //   1277	243	24	localObject6	Object
    //   1536	1	24	localThrowable5	Throwable
    //   1541	7	24	localThrowable6	Throwable
    //   1604	60	24	localStringBuilder	StringBuilder
    //   1674	1	24	localThrowable7	Throwable
    //   1714	134	24	localObject7	Object
    //   1864	1	24	localThrowable8	Throwable
    //   1869	1	24	localThrowable9	Throwable
    //   1878	87	24	localThrowable10	Throwable
    //   542	1405	25	localObject8	Object
    //   630	876	26	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   203	211	214	java/lang/Exception
    //   230	237	240	java/lang/Exception
    //   264	301	304	java/lang/Exception
    //   336	389	414	java/lang/Exception
    //   392	401	414	java/lang/Exception
    //   312	336	422	java/lang/Exception
    //   254	259	430	java/lang/Exception
    //   189	196	442	java/lang/Exception
    //   219	226	442	java/lang/Exception
    //   182	189	450	java/lang/Exception
    //   176	182	458	java/lang/Exception
    //   169	176	463	java/lang/Exception
    //   146	169	473	java/lang/Exception
    //   117	146	478	java/lang/Exception
    //   189	196	532	java/lang/Throwable
    //   203	211	532	java/lang/Throwable
    //   219	226	532	java/lang/Throwable
    //   230	237	532	java/lang/Throwable
    //   254	259	532	java/lang/Throwable
    //   264	301	532	java/lang/Throwable
    //   312	336	532	java/lang/Throwable
    //   336	389	532	java/lang/Throwable
    //   392	401	532	java/lang/Throwable
    //   502	519	532	java/lang/Throwable
    //   95	104	537	java/lang/Throwable
    //   107	117	537	java/lang/Throwable
    //   117	146	537	java/lang/Throwable
    //   146	169	537	java/lang/Throwable
    //   169	176	537	java/lang/Throwable
    //   176	182	537	java/lang/Throwable
    //   182	189	537	java/lang/Throwable
    //   558	583	586	java/lang/Throwable
    //   639	681	684	java/lang/Throwable
    //   860	883	684	java/lang/Throwable
    //   888	895	684	java/lang/Throwable
    //   900	961	684	java/lang/Throwable
    //   961	1031	684	java/lang/Throwable
    //   1038	1104	684	java/lang/Throwable
    //   1112	1218	684	java/lang/Throwable
    //   1218	1230	684	java/lang/Throwable
    //   1230	1247	684	java/lang/Throwable
    //   1247	1261	684	java/lang/Throwable
    //   1264	1312	684	java/lang/Throwable
    //   1312	1326	684	java/lang/Throwable
    //   1363	1370	684	java/lang/Throwable
    //   1391	1398	684	java/lang/Throwable
    //   1426	1438	684	java/lang/Throwable
    //   609	614	1536	java/lang/Throwable
    //   605	609	1541	java/lang/Throwable
    //   614	632	1541	java/lang/Throwable
    //   697	832	1541	java/lang/Throwable
    //   832	855	1541	java/lang/Throwable
    //   1329	1356	1541	java/lang/Throwable
    //   1373	1384	1541	java/lang/Throwable
    //   1401	1409	1541	java/lang/Throwable
    //   1409	1421	1541	java/lang/Throwable
    //   1441	1461	1541	java/lang/Throwable
    //   1461	1503	1541	java/lang/Throwable
    //   1519	1535	1674	java/lang/Throwable
    //   1597	1671	1674	java/lang/Throwable
    //   1679	1698	1864	java/lang/Throwable
    //   1701	1777	1864	java/lang/Throwable
    //   1777	1797	1864	java/lang/Throwable
    //   1800	1841	1864	java/lang/Throwable
    //   1847	1863	1864	java/lang/Throwable
    //   1554	1581	1869	java/lang/Throwable
    //   1587	1592	1869	java/lang/Throwable
    //   45	51	1878	java/lang/Throwable
    //   84	90	1878	java/lang/Throwable
  }
  
  void a(String paramString, long paramLong)
  {
    BaseApplication.getContext().getSharedPreferences("unrtime", 0).edit().putLong(paramString, paramLong).commit();
  }
  
  boolean a(RegPushReason paramRegPushReason)
  {
    return (paramRegPushReason == RegPushReason.appRegister) || (paramRegPushReason == RegPushReason.fillRegProxy) || (paramRegPushReason == RegPushReason.createDefaultRegInfo) || (paramRegPushReason == RegPushReason.setOnlineStatus);
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("watchdog startWatchdogCallback mnWatchdogForInfoLoginRetryCount:");
      ((StringBuilder)localObject).append(this.A);
      QLog.d("MSF.C.PushManager:PushCoder", 2, ((StringBuilder)localObject).toString());
    }
    String str = MsfSdkUtils.getProcessName(BaseApplication.getContext());
    Object localObject = str;
    if (str != null)
    {
      localObject = str;
      if (str.indexOf(":") > 0) {
        localObject = str.substring(0, str.indexOf(":"));
      }
    }
    localObject = (a)this.f.i.get(localObject);
    if ((localObject != null) && (((a)localObject).k != null) && (MsfService.getCore().getUinPushStatus(((a)localObject).k.uin) != 95))
    {
      if (MsfService.getCore().mbIsInfoLoginGetted.get())
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("watchdog startWatchdogCallback mbIsInfoLoginGetted:");
          ((StringBuilder)localObject).append(MsfService.getCore().mbIsInfoLoginGetted);
          ((StringBuilder)localObject).append(" ok");
          QLog.d("MSF.C.PushManager:PushCoder", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      if (u.b())
      {
        if (this.A < 6)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("watchdog startWatchdogCallback QQProcessRunning mnWatchdogForInfoLoginRetryCount:");
            ((StringBuilder)localObject).append(this.A);
            QLog.d("MSF.C.PushManager:PushCoder", 2, ((StringBuilder)localObject).toString());
          }
          this.A += 1;
          try
          {
            localObject = new Intent("com.tencent.mobileqq.msf.WatchdogForInfoLogin");
            localObject = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, (Intent)localObject, 0);
            ((AlarmManager)BaseApplication.getContext().getSystemService("alarm")).set(0, System.currentTimeMillis() + 10000L, (PendingIntent)localObject);
            return;
          }
          catch (Exception localException)
          {
            QLog.d("MSF.C.PushManager:PushCoder", 1, "watchdog startWatchdogCallback excep!", localException);
            return;
          }
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("watchdog startWatchdogCallback QQProcessRunning mnWatchdogForInfoLoginRetryCount:");
          localStringBuilder.append(this.A);
          QLog.d("MSF.C.PushManager:PushCoder", 2, localStringBuilder.toString());
        }
        return;
      }
      QLog.d("MSF.C.PushManager:PushCoder", 1, "watchdog startWatchdogCallback QQProcess killed restart now");
      c(u.c());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog startWatchdogCallback in 95 status do not start QQ Process");
    }
  }
  
  void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = u.b(paramToServiceMsg);
    if ((a)this.f.i.get(str) != null)
    {
      long l1 = System.currentTimeMillis();
      long l2 = ((Long)paramToServiceMsg.getAttribute("__timestamp_app2msf")).longValue();
      long l3 = j.a(paramToServiceMsg, paramFromServiceMsg);
      try
      {
        if (paramFromServiceMsg.isSuccess())
        {
          this.f.c(SystemClock.elapsedRealtime());
          paramToServiceMsg = new byte[paramFromServiceMsg.getWupBuffer().length - 4];
          System.arraycopy(paramFromServiceMsg.getWupBuffer(), 4, paramToServiceMsg, 0, paramToServiceMsg.length);
          paramFromServiceMsg = new StatSvcSimpleGet.RspBody();
          paramFromServiceMsg.mergeFrom(paramToServiceMsg);
          this.m = 0;
          if ((!com.tencent.mobileqq.msf.core.a.a.aQ()) || (com.tencent.mobileqq.msf.core.net.a.b.e)) {
            this.f.D = (paramFromServiceMsg.uint32_hello_interval.get() * 1000);
          }
          this.f.a(this.f.e());
          ad.c(paramFromServiceMsg.str_clientip.get());
          return;
        }
        if (this.f.c.getStatReporter() != null) {
          this.f.c.getStatReporter().a(false, l1 - l2, paramFromServiceMsg.getBusinessFailCode(), l3);
        }
        this.f.a(180000L);
        return;
      }
      catch (Throwable paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        paramToServiceMsg = this.f;
        paramToServiceMsg.a(paramToServiceMsg.e());
      }
    }
  }
  
  void b(String paramString)
  {
    if (com.tencent.mobileqq.msf.service.e.a())
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" is running, no need send SvcRequestPullUnreadMsgCountReq");
        QLog.d("MSF.C.PushManager:PushCoder", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    paramString = (a)this.f.i.get(paramString);
    if (MsfService.getCore().getUinPushStatus(paramString.k.uin) == 95)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager:PushCoder", 2, "on recvOfflineMsg status don't start QQ");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager:PushCoder", 2, "QQ not running, send SvcRequestPullUnreadMsgCountReq now");
    }
    Object localObject1 = new UniPacket(true);
    ((UniPacket)localObject1).setServantName(w);
    ((UniPacket)localObject1).setFuncName(v);
    Object localObject2 = new com.tencent.msf.service.protocol.a.a();
    ((com.tencent.msf.service.protocol.a.a)localObject2).a = true;
    ((com.tencent.msf.service.protocol.a.a)localObject2).b = true;
    ((com.tencent.msf.service.protocol.a.a)localObject2).c = true;
    ((UniPacket)localObject1).put("req_PullUnreadMsgCount", localObject2);
    localObject2 = new ToServiceMsg("", paramString.k.uin, "MessageSvc.PullUnreadMsgCount");
    ((ToServiceMsg)localObject2).setAppId(paramString.a);
    ((ToServiceMsg)localObject2).setTimeout(30000L);
    ((ToServiceMsg)localObject2).setRequestSsoSeq(MsfCore.getNextSeq());
    ((ToServiceMsg)localObject2).setNeedCallback(true);
    ((ToServiceMsg)localObject2).setTimeout(30000L);
    ((ToServiceMsg)localObject2).putWupBuffer(((UniPacket)localObject1).encode());
    try
    {
      this.f.c.sendSsoMsg((ToServiceMsg)localObject2);
      return;
    }
    catch (Exception paramString)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("query push error ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.w("MSF.C.PushManager:PushCoder", 1, ((StringBuilder)localObject1).toString(), paramString);
    }
  }
  
  void c(String paramString)
  {
    g.t = true;
    a();
    NetConnInfoCenter.callQQProcess(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.push.e
 * JD-Core Version:    0.7.0.1
 */