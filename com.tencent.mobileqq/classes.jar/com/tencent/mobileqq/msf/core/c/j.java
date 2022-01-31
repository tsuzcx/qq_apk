package com.tencent.mobileqq.msf.core.c;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.feedback.anr.ANRReport;
import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.feedback.eup.CrashStrategyBean;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.af;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.c;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.msf.core.net.m;
import com.tencent.mobileqq.msf.core.net.m.a;
import com.tencent.mobileqq.msf.core.net.v;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class j
{
  static final String A = "param_NowLocalIp";
  static final String B = "param_sendLocalIp";
  static final String C = "param_Detail";
  static final String D = "param_tokenType";
  public static final String E = "param_reportTime";
  static final String F = "param_LoginConnect";
  static final String G = "param_LastConnCostTime";
  static final String H = "param_connectContinuanceTime";
  static HashSet J;
  public static volatile boolean K = false;
  static long L = 0L;
  static long M = 0L;
  static AtomicBoolean N = new AtomicBoolean(false);
  static AtomicBoolean O = new AtomicBoolean(false);
  static Thread P = new k("MsfCheckDeepSleepThread");
  private static LinkedBlockingQueue U = new LinkedBlockingQueue(100);
  private static ConcurrentHashMap V = new ConcurrentHashMap();
  private static long W = 3600000L;
  private static SimpleDateFormat Z = new SimpleDateFormat("MM.dd HH:mm:ss.SSS");
  static final String a = "MSF.C.StatReport";
  public static final String b = "param_Reason";
  public static final String c = "param_connecttrycount";
  static final String d = "param_sendTime";
  static final String e = "param_connResult";
  static final String f = "param_connFailReason";
  static final String g = "param_connNetType";
  static final String h = "param_connOpenNetType";
  static final String i = "param_connElapseTime";
  static final String j = "param_localIp";
  static final String k = "param_NetworkStatus";
  static final String l = "param_ssoInfo";
  static final String m = "param_liveTime";
  static final String n = "param_sendBytes";
  static final String o = "param_recvBytes";
  static final String p = "param_runStatus";
  static final String q = "param_deepSleep";
  static final String r = "param_runStatus_new";
  static final String s = "param_isDefaultList";
  static final String t = "param_isConnected";
  static final String u = "param_uin";
  static final String v = "param_src";
  static final String w = "param_imei";
  static final String x = "param_FailCode";
  static final String y = "param_SsoServerIp";
  static final String z = "param_GatewayIp";
  MsfCore I;
  public c Q;
  boolean R = false;
  boolean S = false;
  boolean T = false;
  private b X = new b();
  private StringBuilder Y = new StringBuilder("Msf Crash Control info:\n");
  
  public j(MsfCore paramMsfCore)
  {
    this.I = paramMsfCore;
  }
  
  public static byte a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    int i2 = 0;
    int i3;
    label26:
    int i4;
    if (n())
    {
      i1 = 1;
      i3 = (byte)i1;
      if (!m()) {
        break label251;
      }
      i1 = 2;
      i4 = (byte)i1;
      boolean bool = paramBoolean;
      if (!paramBoolean)
      {
        bool = paramBoolean;
        if (paramLong1 <= paramLong2)
        {
          Iterator localIterator = V.entrySet().iterator();
          Map.Entry localEntry;
          do
          {
            bool = paramBoolean;
            if (!localIterator.hasNext()) {
              break;
            }
            localEntry = (Map.Entry)localIterator.next();
          } while ((paramLong1 >= ((Long)localEntry.getValue()).longValue()) || (paramLong2 <= ((Long)localEntry.getKey()).longValue()));
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.StatReport", 2, "find deep sleep. report time:[" + paramLong1 + ", " + paramLong2 + "], sleep time:[" + localEntry.getKey() + ", " + localEntry.getValue() + "]");
          }
          bool = true;
        }
      }
      if (!bool) {
        break label257;
      }
    }
    label257:
    for (int i1 = 4;; i1 = 0)
    {
      int i5 = (byte)i1;
      i1 = i2;
      if (o()) {
        i1 = 8;
      }
      return (byte)(i5 | i3 | i4 | (byte)i1);
      i1 = 0;
      break;
      label251:
      i1 = 0;
      break label26;
    }
  }
  
  public static long a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramToServiceMsg != null)
    {
      l1 = l2;
      if (paramToServiceMsg.getWupBuffer() != null) {
        l1 = 0L + paramToServiceMsg.getWupBuffer().length;
      }
    }
    l2 = l1;
    if (paramFromServiceMsg != null)
    {
      l2 = l1;
      if (paramFromServiceMsg.getWupBuffer() != null) {
        l2 = l1 + paramFromServiceMsg.getWupBuffer().length;
      }
    }
    return l2;
  }
  
  private String a(d paramd)
  {
    if (paramd == null) {
      return "null EndpointKey";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramd.b()).append("://");
    localStringBuilder.append(paramd.c()).append(":").append(paramd.d());
    return localStringBuilder.toString();
  }
  
  public static void a(String paramString1, boolean paramBoolean, int paramInt, String paramString2) {}
  
  public static long b(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (!paramBoolean) {}
    while (paramLong1 >= paramLong2) {
      return 0L;
    }
    Iterator localIterator = V.entrySet().iterator();
    long l1 = 0L;
    Map.Entry localEntry;
    if (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      if ((paramLong1 >= ((Long)localEntry.getKey()).longValue()) && (paramLong1 <= ((Long)localEntry.getValue()).longValue()))
      {
        if (paramLong2 <= ((Long)localEntry.getValue()).longValue()) {
          return paramLong2 - paramLong1;
        }
        l1 = ((Long)localEntry.getValue()).longValue() + l1 - paramLong1;
      }
    }
    for (;;)
    {
      break;
      if (paramLong1 < ((Long)localEntry.getKey()).longValue()) {
        if ((paramLong2 >= ((Long)localEntry.getKey()).longValue()) && (paramLong2 <= ((Long)localEntry.getValue()).longValue()))
        {
          l1 = l1 + paramLong2 - ((Long)localEntry.getKey()).longValue();
        }
        else if (paramLong2 > ((Long)localEntry.getValue()).longValue())
        {
          l1 = l1 + ((Long)localEntry.getValue()).longValue() - ((Long)localEntry.getKey()).longValue();
          continue;
          return l1;
        }
      }
    }
  }
  
  static void b(boolean paramBoolean)
  {
    while (!U.isEmpty())
    {
      StringBuilder localStringBuilder;
      Map localMap;
      for (;;)
      {
        try
        {
          RdmReq localRdmReq = (RdmReq)U.take();
          if (localRdmReq == null) {
            break;
          }
          localStringBuilder = new StringBuilder();
          localMap = localRdmReq.params;
          if (localMap == null) {
            break label262;
          }
          long l1 = Long.parseLong((String)localMap.get("param_reportTime"));
          long l2 = l1 - localRdmReq.elapse;
          int i1 = a(paramBoolean, l2, l1);
          localMap.put("param_runStatus", String.valueOf(i1));
          if ((i1 & 0x4) != 0) {
            break label257;
          }
          bool = false;
          localMap.put("param_deepSleep", String.valueOf(b(bool, l2, l1)));
          localMap.remove("param_reportTime");
          Iterator localIterator = localMap.entrySet().iterator();
          if (!localIterator.hasNext()) {
            break label262;
          }
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localStringBuilder.append("k=").append((String)localEntry.getKey()).append(", v=").append((String)localEntry.getValue()).append("; ");
          continue;
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        catch (Exception localException) {}
        QLog.w("MSF.C.StatReport", 2, "report RQD error " + localException, localException);
        break;
        label257:
        boolean bool = true;
      }
      label262:
      UserAction.onUserAction(localException.eventName, localException.isSucceed, localException.elapse, localException.size, localMap, localException.isRealTime);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.StatReport", 2, "report RQD IMEI:" + t.d() + " eventName=" + localException.eventName + " isSucceed:" + localException.isSucceed + " elapse:" + localException.elapse + " size:" + localException.size + " isRealTime:" + localException.isRealTime + " isMerge:" + localException.isMerge + " params:" + localStringBuilder.toString());
      }
    }
  }
  
  private static boolean m()
  {
    return !MsfSdkUtils.isTopActivity(BaseApplication.getContext());
  }
  
  private static boolean n()
  {
    return !MsfSdkUtils.isScreenOn(BaseApplication.getContext());
  }
  
  private static boolean o()
  {
    boolean bool = false;
    if (Settings.System.getInt(BaseApplication.getContext().getContentResolver(), "airplane_mode_on", 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  void a()
  {
    String str = com.tencent.mobileqq.msf.core.a.a.ae();
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      Object localObject = new JSONObject(str);
      this.X.a = ((JSONObject)localObject).getBoolean("control_switch");
      this.X.b = ((JSONObject)localObject).getInt("control_window");
      this.X.c = ((JSONObject)localObject).getInt("control_freq");
      localObject = this.Y.append("initCrashControl");
      ((StringBuilder)localObject).append(",controlJson=").append(str);
      ((StringBuilder)localObject).append(",switch=").append(this.X.a);
      ((StringBuilder)localObject).append(",window=").append(this.X.b);
      ((StringBuilder)localObject).append(",Freq=").append(this.X.c);
      ((StringBuilder)localObject).append("\n");
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        this.X.a();
        QLog.d("MSF.C.StatReport", 1, "initCrashControl parse json throws an exception, so reset.");
      }
    }
  }
  
  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    if (NetConnInfoCenter.isWifiOrMobileConn())
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      a("dim.Msf.TokenExpired", false, paramLong1, paramLong2, localHashMap, false, false);
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    String str = "" + paramLong;
    str = str + "|";
    paramString1 = str + paramString1;
    paramString1 = paramString1 + "|";
    paramString1 = paramString1 + paramString2;
    paramString2 = new HashMap();
    paramString2.put("param_connectContinuanceTime", paramString1);
    a("msf_connectContinuanceTime", false, paramLong, 0L, paramString2, false, false);
  }
  
  public void a(WifiInfo paramWifiInfo)
  {
    int i2;
    label45:
    int i3;
    if ((paramWifiInfo.getBSSID() == null) || (paramWifiInfo.getIpAddress() == 0) || (paramWifiInfo.getSupplicantState() != SupplicantState.COMPLETED))
    {
      if (paramWifiInfo.getBSSID() != null) {
        break label106;
      }
      i1 = 1;
      i2 = (byte)i1;
      if (paramWifiInfo.getIpAddress() != 0) {
        break label111;
      }
      i1 = 2;
      i3 = (byte)i1;
      if (paramWifiInfo.getSupplicantState() == SupplicantState.COMPLETED) {
        break label116;
      }
    }
    label106:
    label111:
    label116:
    for (int i1 = 4;; i1 = 0)
    {
      i1 = (byte)i1;
      paramWifiInfo = new HashMap();
      paramWifiInfo.put("param_FailCode", String.valueOf((i1 | i2 | i3) + 5000));
      a("dim.Msf.WifiNoConnection", false, 0L, 0L, paramWifiInfo, true, false);
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label45;
    }
  }
  
  public void a(String paramString)
  {
    UserAction.setUserID(paramString);
    CrashReport.setUserId(BaseApplication.getContext(), paramString);
  }
  
  public void a(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("pm_uin", MsfService.getCore().getAccountCenter().i());
      localHashMap.put("pm_cmd", paramString);
      localHashMap.put("pm_ssoseq", String.valueOf(paramInt1));
      localHashMap.put("pm_failcode", String.valueOf(paramInt2));
      localHashMap.put("pm_sendwupsize", String.valueOf(paramLong2));
      localHashMap.put("pm_recvwupsize", String.valueOf(paramLong3));
      localHashMap.put("pm_reqpacksize", String.valueOf(paramLong4));
      localHashMap.put("pm_senddataerror", String.valueOf(paramBoolean));
      localHashMap.put("pm_imsi", t.e());
      localHashMap.put("pm_nettype", String.valueOf(NetConnInfoCenter.getSystemNetworkType()));
      paramInt1 = com.tencent.mobileqq.a.a.a.c;
      com.tencent.mobileqq.a.a.a.c = 0;
      localHashMap.put("pm_reqCount", String.valueOf(paramInt1));
      localHashMap.put("param_FailCode", String.valueOf(paramInt2));
      localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
      a("ReqQualitySendError", false, paramLong1, paramLong4, localHashMap, false, false);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString, long paramLong) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      String str = String.valueOf(System.currentTimeMillis() + "_" + paramString1 + "_" + paramString2 + " " + paramString3 + "_" + paramString4);
      Properties localProperties = new Properties();
      localProperties.put("uin", String.valueOf(paramString1));
      localProperties.put("type", String.valueOf(paramString3));
      localProperties.put("msg", String.valueOf(str));
      localProperties.put("exception", String.valueOf(paramString4));
      localProperties.put("processName", String.valueOf(paramString2));
      a.a(BaseApplication.getContext()).reportKVEvent("msf.core.DeadObjectException", localProperties);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong)
  {
    a(paramString1, paramString2, paramBoolean, paramLong, 0L, 0L, 0L, 0L, 0L);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.StatReport", 2, "reportCloseConnForAlarm type:" + paramString1 + ",isEffective:" + paramBoolean + ",saveTime:" + paramLong1);
    }
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_reportType", paramString1);
      localHashMap.put("param_uin", paramString2);
      localHashMap.put("param_saveCost", String.valueOf(paramLong1));
      localHashMap.put("param_isEffective", String.valueOf(paramBoolean));
      if (!paramBoolean)
      {
        localHashMap.put("param_timeforten", String.valueOf(paramLong2));
        localHashMap.put("param_timeforsix", String.valueOf(paramLong3));
        localHashMap.put("param_timeforalarm", String.valueOf(paramLong4));
        localHashMap.put("param_timeforlastrecv", String.valueOf(paramLong5));
        localHashMap.put("param_timeforcloseconn", String.valueOf(paramLong6));
      }
      a("dim.Msf.CloseConnForAlarm", false, paramLong1, 0L, localHashMap, false, false);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.d("MSF.C.StatReport", 1, "reportCloseConnForAlarm error!", paramString1);
    }
  }
  
  public void a(String paramString, boolean paramBoolean, long paramLong1, int paramInt, long paramLong2)
  {
    if (NetConnInfoCenter.isWifiOrMobileConn())
    {
      if (J == null) {
        J = new HashSet();
      }
      if (!J.contains(paramString)) {}
    }
    else
    {
      return;
    }
    J.add(paramString);
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uin", paramString);
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    a("dim.Msf.UserGrayfail", paramBoolean, paramLong1, paramLong2, localHashMap, false, false);
  }
  
  public void a(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!c()) {}
    do
    {
      return;
      if (K)
      {
        K = false;
        h();
      }
      if (!com.tencent.mobileqq.msf.core.a.a.r.contains(paramString)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.StatReport", 2, paramString + " is not need report.");
    return;
    if ((paramMap == null) || (!paramBoolean1)) {}
    for (;;)
    {
      int i1;
      try
      {
        if ((this.I != null) && (this.I.sender != null) && (this.I.sender.a != null)) {
          paramMap.put("param_isConnected", String.valueOf(this.I.sender.a.o().b()));
        }
        paramMap.put("param_NetworkOperator", t.l());
        i1 = NetConnInfoCenter.getSystemNetworkType();
        paramMap.put("param_NetworkInfo", String.valueOf(i1));
        if (!paramMap.containsKey(BaseConstants.RDM_NoChangeFailCode)) {
          break label364;
        }
        paramMap.remove(BaseConstants.RDM_NoChangeFailCode);
        paramMap.put("param_SsoServerIp", af.G);
        paramMap.put("param_GatewayrIp", af.n());
        if (!paramMap.containsKey("param_reportTime")) {
          paramMap.put("param_reportTime", String.valueOf(SystemClock.elapsedRealtime()));
        }
        RdmReq localRdmReq = new RdmReq();
        localRdmReq.eventName = paramString;
        localRdmReq.elapse = paramLong1;
        localRdmReq.size = paramLong2;
        localRdmReq.isSucceed = paramBoolean1;
        localRdmReq.isRealTime = paramBoolean2;
        localRdmReq.isMerge = paramBoolean3;
        localRdmReq.params = paramMap;
        if ((U.offer(localRdmReq)) || (!QLog.isColorLevel())) {
          break;
        }
        QLog.e("MSF.C.StatReport", 2, "wait queue is full!");
        return;
      }
      catch (Exception paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("MSF.C.StatReport", 2, "report RQD error " + paramString, paramString);
      return;
      label364:
      if (i1 == 0) {
        paramMap.put("param_FailCode", "900");
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(4015));
    localHashMap.put("param_Reason", String.valueOf(paramBoolean));
    a("Msf.LoginRespTimeout", false, 0L, 0L, localHashMap, false, false);
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("timeConnectTestServerDiff", String.valueOf(paramLong));
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      localHashMap.put("SSOIP" + i1, ((m.a)paramArrayList.get(i1)).a);
      localHashMap.put("ConnTestSsoResult" + i1, String.valueOf(((m.a)paramArrayList.get(i1)).b));
      localHashMap.put("errorDetail" + i1, ((m.a)paramArrayList.get(i1)).c);
      i1 += 1;
    }
    localHashMap.put("respcode", String.valueOf(paramInt));
    a("msf_netStateWhileSSOListCannotConnBDOK5", paramBoolean, 0L, 0L, localHashMap, true, false);
  }
  
  public void a(boolean paramBoolean, long paramLong1, int paramInt, long paramLong2)
  {
    HashMap localHashMap;
    if (NetConnInfoCenter.isWifiOrMobileConn())
    {
      localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt + 3300));
      if (n()) {
        a("dim.Msf.BG.PushQueryResult", paramBoolean, paramLong1, paramLong2, localHashMap, false, false);
      }
    }
    else
    {
      return;
    }
    a("dim.Msf.PushQueryResult", paramBoolean, paramLong1, paramLong2, localHashMap, false, false);
  }
  
  public void a(boolean paramBoolean1, long paramLong1, int paramInt, long paramLong2, String paramString1, String paramString2, boolean paramBoolean2, long paramLong3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt + 3000));
    localHashMap.put("param_SsoServerIp", paramString1);
    localHashMap.put("param_sendLocalIp", paramString2);
    localHashMap.put("param_NowLocalIp", af.H);
    localHashMap.put("param_Reason", String.valueOf(paramBoolean2));
    localHashMap.put("param_sendTime", String.valueOf(paramLong3));
    a("Msf.CommonLogin", paramBoolean1, paramLong1, paramLong2, localHashMap, false, false);
  }
  
  public void a(boolean paramBoolean1, long paramLong1, int paramInt, long paramLong2, boolean paramBoolean2, String paramString)
  {
    HashMap localHashMap;
    if (NetConnInfoCenter.isWifiOrMobileConn())
    {
      localHashMap = new HashMap();
      localHashMap.put("param_Reason", paramString);
      if (paramBoolean2) {
        break label85;
      }
      localHashMap.put("param_FailCode", String.valueOf(paramInt + 3100));
      if (n()) {
        a("dim.Msf.BG.RigisterPushResult", paramBoolean1, paramLong1, paramLong2, localHashMap, false, false);
      }
    }
    else
    {
      return;
    }
    a("dim.Msf.RigisterPushResult", paramBoolean1, paramLong1, paramLong2, localHashMap, false, false);
    return;
    label85:
    localHashMap.put("param_FailCode", String.valueOf(paramInt + 3200));
    if (n())
    {
      a("dim.Msf.BG.UnRigisterPushResult", paramBoolean1, paramLong1, paramLong2, localHashMap, false, false);
      return;
    }
    a("dim.Msf.UnRigisterPushResult", paramBoolean1, paramLong1, paramLong2, localHashMap, false, false);
  }
  
  public void a(boolean paramBoolean1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean2, ArrayList paramArrayList, int paramInt)
  {
    if (!NetConnInfoCenter.isWifiOrMobileConn()) {}
    while (paramArrayList.size() <= 0) {
      return;
    }
    Object localObject1 = "" + this.I.getMsfAppid();
    localObject1 = (String)localObject1 + "|1";
    Object localObject2 = c.f(BaseApplication.getContext()) + "." + c.e(BaseApplication.getContext());
    localObject1 = (String)localObject1 + "|" + (String)localObject2;
    localObject2 = (com.tencent.mobileqq.msf.core.net.a)paramArrayList.get(paramArrayList.size() - 1);
    localObject2 = (String)localObject1 + "|" + ((com.tencent.mobileqq.msf.core.net.a)localObject2).g;
    localObject1 = t.e();
    if ((localObject1 != null) && (((String)localObject1).length() >= 5))
    {
      localObject2 = (String)localObject2 + "|" + ((String)localObject1).substring(0, 3);
      localObject1 = (String)localObject2 + ":" + ((String)localObject1).substring(3, 5);
      localObject2 = t.i();
      if (localObject2 == null) {
        break label582;
      }
      localObject1 = (String)localObject1 + ":" + (String)localObject2;
      label301:
      localObject1 = (String)localObject1 + ":" + false;
      localObject1 = (String)localObject1 + "|" + paramLong1;
      localObject1 = (String)localObject1 + "|" + paramLong2;
      localObject1 = (String)localObject1 + "|" + paramLong3;
      localObject1 = (String)localObject1 + "|" + paramBoolean2;
      if (!paramBoolean1) {
        break label608;
      }
    }
    label582:
    label608:
    for (localObject1 = (String)localObject1 + "|1";; localObject1 = (String)localObject1 + "|" + paramInt)
    {
      localObject2 = paramArrayList.iterator();
      for (paramArrayList = (ArrayList)localObject1; ((Iterator)localObject2).hasNext(); paramArrayList = paramArrayList + "|" + ((com.tencent.mobileqq.msf.core.net.a)localObject1).a()) {
        localObject1 = (com.tencent.mobileqq.msf.core.net.a)((Iterator)localObject2).next();
      }
      localObject1 = (String)localObject2 + "|000";
      localObject1 = (String)localObject1 + ":00";
      break;
      localObject1 = (String)localObject1 + ":000";
      break label301;
    }
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("param_LoginConnect", paramArrayList);
    try
    {
      ((HashMap)localObject1).put("param_totalmemory", MsfSdkUtils.getTotalMemory());
    }
    catch (Exception paramArrayList)
    {
      try
      {
        ((HashMap)localObject1).put("param_Resolution", MsfSdkUtils.getResolutionString(BaseApplication.getContext()));
      }
      catch (Exception paramArrayList)
      {
        try
        {
          ((HashMap)localObject1).put("param_runStatus_new", String.valueOf(m.s));
        }
        catch (Exception paramArrayList)
        {
          try
          {
            for (;;)
            {
              ((HashMap)localObject1).put("param_LastConnCostTime", String.valueOf(paramLong4));
              if (QLog.isColorLevel())
              {
                QLog.d("MSF.C.StatReport", 2, "get report status " + (String)((HashMap)localObject1).get("param_runStatus"));
                QLog.d("MSF.C.StatReport", 2, "get report new status " + String.valueOf(m.s));
              }
              if (paramLong3 == -1L) {
                break;
              }
              a("msf_connAndRecv", paramBoolean1, paramLong1 + paramLong3, 0L, (Map)localObject1, false, false);
              return;
              paramArrayList = paramArrayList;
              QLog.d("MSF.C.StatReport", 1, "getTotalMemoey error " + paramArrayList);
              continue;
              paramArrayList = paramArrayList;
              QLog.d("MSF.C.StatReport", 1, "getResilution error " + paramArrayList);
              continue;
              paramArrayList = paramArrayList;
              QLog.d("MSF.C.StatReport", 1, "get new status error " + paramArrayList.toString());
            }
          }
          catch (Exception paramArrayList)
          {
            for (;;)
            {
              QLog.d("MSF.C.StatReport", 1, "get last conncost error " + paramArrayList.toString());
            }
            a("msf_connAndRecv", paramBoolean1, paramLong1, 0L, (Map)localObject1, false, false);
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean2, boolean paramBoolean3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("isDeviceIdleMode", String.valueOf(paramBoolean1));
    localHashMap.put("takeTimes", String.valueOf(paramLong1));
    localHashMap.put("isPowerSaveMode", String.valueOf(paramBoolean2));
    localHashMap.put("isInteractive", String.valueOf(paramBoolean3));
    localHashMap.put("sdkVersion", String.valueOf(Build.VERSION.SDK_INT));
    if (paramLong2 > 0L) {
      localHashMap.put("alarmCost", String.valueOf(paramLong2));
    }
    if (paramLong3 > 0L)
    {
      localHashMap.put("screenOffCost", String.valueOf(paramLong3));
      if (paramLong4 > 0L) {
        localHashMap.put("connFailCost", String.valueOf(paramLong4));
      }
    }
    a("dim.msf.deviceidle_status", true, paramLong1, 0L, localHashMap, false, false);
  }
  
  public void a(boolean paramBoolean, long paramLong1, d paramd, com.tencent.qphone.base.a parama, int paramInt, long paramLong2, long paramLong3, long paramLong4, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_connOpenNetType", String.valueOf(paramInt));
    localHashMap.put("param_ssoInfo", a(paramd));
    localHashMap.put("param_liveTime", String.valueOf(paramLong2));
    localHashMap.put("param_sendBytes", String.valueOf(paramLong3));
    localHashMap.put("param_recvBytes", String.valueOf(paramLong4));
    localHashMap.put("param_FailCode", String.valueOf(parama.ordinal() + 4900));
    localHashMap.put("param_Reason", parama.toString());
    paramd = "" + paramLong1;
    paramd = paramd + "|";
    paramd = paramd + paramString1;
    paramd = paramd + "|";
    localHashMap.put("param_connectContinuanceTime", paramd + paramString2);
    try
    {
      localHashMap.put("param_uin", MsfService.getCore().getAccountCenter().i());
      if (n())
      {
        a("dim.Msf.BG.ConnClose", paramBoolean, paramLong1, 0, localHashMap, false, false);
        return;
      }
    }
    catch (Exception paramd)
    {
      for (;;)
      {
        QLog.d("MSF.C.StatReport", 1, "getMainAccout error!", paramd);
      }
      a("dim.Msf.ConnClose", paramBoolean, paramLong1, 0, localHashMap, false, false);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ssolist", paramString);
    localHashMap.put("SSOListToConnectEndTime", "" + paramLong);
    a("msf_justGetSSOListButCannotConn", paramBoolean, paramLong, 0L, localHashMap, true, false);
  }
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (!this.S) {
      this.S = true;
    }
    for (;;)
    {
      try
      {
        Object localObject2 = new StringBuilder().append(MsfCore.sCore.getAccountCenter().i()).append("_").append(String.valueOf(System.currentTimeMillis())).append("_");
        Object localObject1;
        if (paramBoolean)
        {
          localObject1 = paramToServiceMsg.getShortStringForLog();
          localObject2 = (String)localObject1;
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("uin", MsfCore.sCore.getAccountCenter().i());
          ((HashMap)localObject1).put("time", String.valueOf(System.currentTimeMillis()));
          ((HashMap)localObject1).put("msg", localObject2);
          if (paramFromServiceMsg == null) {
            break label233;
          }
          paramFromServiceMsg = paramFromServiceMsg.getStringForLog();
          ((HashMap)localObject1).put("from", paramFromServiceMsg);
          if (paramToServiceMsg != null)
          {
            paramToServiceMsg = paramToServiceMsg.getStringForLog();
            ((HashMap)localObject1).put("to", paramToServiceMsg);
            a.a(BaseApplication.getContext()).a("msf.cmd.Evt10008", (Map)localObject1, 0);
            if (MsfService.getCore().getStatReporter() == null) {
              break label232;
            }
            MsfService.getCore().getStatReporter().a("msf.cmd.Evt10008", true, 0L, 0L, (Map)localObject1, false, false);
          }
        }
        else
        {
          localObject1 = paramFromServiceMsg.getShortStringForLog();
          continue;
        }
        paramToServiceMsg = "null";
        continue;
        return;
      }
      catch (Throwable paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
      label232:
      label233:
      paramFromServiceMsg = "null";
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, long paramLong1, int paramInt, long paramLong2, String paramString2, String paramString3)
  {
    if (NetConnInfoCenter.isWifiOrMobileConn())
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      localHashMap.put("param_tokenType", String.valueOf(paramString2));
      localHashMap.put("param_uin", paramString1);
      localHashMap.put("param_src", paramString3);
      localHashMap.put("param_imei", t.d());
      a("dim.Msf.RenewToken_3", paramBoolean, paramLong1, paramLong2, localHashMap, false, false);
      if ((paramInt != 0) && (MsfService.getCore().mtaReporter != null)) {
        MsfService.getCore().mtaReporter.a("dim.Msf.RenewToken_3", localHashMap);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString, Object paramObject) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong, ArrayList paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int i3 = 0;
    int i4 = 0;
    int i1 = i4;
    int i2 = i3;
    if (!paramBoolean3)
    {
      i1 = i4;
      i2 = i3;
      if (paramArrayList.size() > 0)
      {
        localHashMap.put("param_Reason", String.valueOf(((com.tencent.mobileqq.msf.core.net.a)paramArrayList.get(paramArrayList.size() - 1)).e));
        if (((com.tencent.mobileqq.msf.core.net.a)paramArrayList.get(paramArrayList.size() - 1)).e != v.m) {
          break label201;
        }
        i2 = 1;
        i1 = i4;
      }
    }
    for (;;)
    {
      localHashMap.put("param_GatewayIp", af.n());
      localHashMap.put("param_FailCode", String.valueOf(paramArrayList.size()));
      localObject = new StringBuilder();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        com.tencent.mobileqq.msf.core.net.a locala = (com.tencent.mobileqq.msf.core.net.a)paramArrayList.next();
        ((StringBuilder)localObject).append(locala.toString() + "|");
      }
      label201:
      i1 = i4;
      i2 = i3;
      if (((com.tencent.mobileqq.msf.core.net.a)paramArrayList.get(paramArrayList.size() - 1)).e == v.i)
      {
        i1 = 1;
        i2 = i3;
      }
    }
    Object localObject = ((StringBuilder)localObject).toString();
    paramArrayList = (ArrayList)localObject;
    if (((String)localObject).endsWith("|")) {
      paramArrayList = ((String)localObject).substring(0, ((String)localObject).length() - 1);
    }
    localHashMap.put("param_connResult", paramArrayList);
    if (!paramBoolean3)
    {
      localHashMap.put("param_localIp", t.n());
      localHashMap.put("param_NetworkStatus", g());
    }
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        a("dim.Msf.MutilConnDefaultElapsedTime", paramBoolean3, paramLong, 0, localHashMap, true, false);
        return;
      }
      a("dim.Msf.MutilConnElapsedTime", paramBoolean3, paramLong, 0, localHashMap, false, false);
      return;
    }
    if (paramBoolean2)
    {
      if (n())
      {
        a("dim.Msf.BG.ConnDefaultElapsedTime", paramBoolean3, paramLong, 0, localHashMap, false, false);
        return;
      }
      a("dim.Msf.ConnDefaultElapsedTime", paramBoolean3, paramLong, 0, localHashMap, false, false);
      return;
    }
    if (n())
    {
      if (i2 != 0)
      {
        a("dim.Msf.BG.ConnFailByUnreachable", paramBoolean3, paramLong, 0, localHashMap, false, false);
        return;
      }
      if (i1 != 0)
      {
        a("dim.Msf.BG.ConnFailByPermission", paramBoolean3, paramLong, 0, localHashMap, false, false);
        return;
      }
      a("dim.Msf.BG.ConnElapsedTime", paramBoolean3, paramLong, 0, localHashMap, false, false);
      return;
    }
    if (i2 != 0)
    {
      a("dim.Msf.ConnFailByUnreachable", paramBoolean3, paramLong, 0, localHashMap, false, false);
      return;
    }
    if (i1 != 0)
    {
      a("dim.Msf.ConnFailByPermission", paramBoolean3, paramLong, 0, localHashMap, false, false);
      return;
    }
    a("dim.Msf.ConnElapsedTime", paramBoolean3, paramLong, 0, localHashMap, false, false);
  }
  
  void b()
  {
    if (!this.X.a) {
      QLog.d("MSF.C.StatReport", 1, "doCrashControl crash control is off..");
    }
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      localSharedPreferences = BaseApplication.getContext().getSharedPreferences("msf_crashcontrol", 0);
    } while (localSharedPreferences == null);
    long l1 = localSharedPreferences.getLong("starttime", 0L);
    int i1 = localSharedPreferences.getInt("crashcount", 0);
    long l2 = System.currentTimeMillis();
    this.Y.append("doCrashControl startTime=").append(Z.format(new Date(l1))).append(",currenttime=").append(Z.format(new Date(l2))).append(",crashCount=").append(i1).append("\n");
    if ((l1 <= 0L) || (l2 <= l1) || (i1 < 0) || (l2 - l1 > this.X.b * 1000))
    {
      i1 = 1;
      l1 = l2;
    }
    for (;;)
    {
      if (i1 > this.X.c) {
        this.R = true;
      }
      if (this.R)
      {
        QLog.d("MSF.C.StatReport", 1, "doCrashControl crashCount=" + i1 + ",shouldStopMsf=" + this.R);
        BaseApplication localBaseApplication = BaseApplication.getContext();
        localBaseApplication.stopService(new Intent(localBaseApplication, MsfService.class));
      }
      this.Y.append("doCrashControl shouldStopMsf=").append(this.R).append("\n");
      localSharedPreferences.edit().putLong("starttime", l1).putInt("crashcount", i1).putBoolean("shouldStopMsf", this.R).commit();
      return;
      i1 += 1;
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    try
    {
      String str = paramToServiceMsg.getUin();
      if (TextUtils.isEmpty(str)) {
        return;
      }
      paramToServiceMsg = str + "_" + String.valueOf(System.currentTimeMillis()) + "_" + com.tencent.mobileqq.msf.service.l.b(paramToServiceMsg) + "_" + com.tencent.mobileqq.msf.service.l.a(paramFromServiceMsg);
      paramFromServiceMsg = new HashMap();
      paramFromServiceMsg.put("errmsg", paramToServiceMsg);
      a.a(BaseApplication.getContext()).a("msf_sendMsgToApp_processIsNull", paramFromServiceMsg, 0);
      return;
    }
    catch (Throwable paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
    }
  }
  
  public void b(String paramString)
  {
    if (!this.T) {
      try
      {
        String str = MsfCore.sCore.getAccountCenter().i();
        if (TextUtils.isEmpty(str)) {
          return;
        }
        str = str + "_" + String.valueOf(System.currentTimeMillis());
        HashMap localHashMap = new HashMap();
        localHashMap.put("uin", MsfCore.sCore.getAccountCenter().i());
        localHashMap.put("msg", str);
        localHashMap.put("sockImpl", paramString);
        localHashMap.put("androidVer", String.valueOf(Build.VERSION.SDK_INT));
        a.a(BaseApplication.getContext()).a("msf_monitor_invalidSocket", localHashMap, 0);
        return;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public final boolean c()
  {
    return N.get();
  }
  
  public final boolean d()
  {
    return O.get();
  }
  
  public void e()
  {
    if (O.get()) {}
    for (;;)
    {
      return;
      long l1 = System.currentTimeMillis();
      Object localObject = new l(this);
      try
      {
        CrashStrategyBean localCrashStrategyBean = new CrashStrategyBean();
        localCrashStrategyBean.setUploadSpotCrash(false);
        localCrashStrategyBean.setMaxStackFrame(6);
        CrashReport.initCrashReport(BaseApplication.getContext(), (CrashHandleListener)localObject, null, false, localCrashStrategyBean);
        localObject = BaseApplication.getContext().getDir("tombs", 0).getAbsolutePath();
        CrashReport.initNativeCrashReport(BaseApplication.getContext(), (String)localObject, true);
        O.set(true);
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.C.StatReport", 2, "init RQD finished, cost=" + (System.currentTimeMillis() - l1));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.w("MSF.C.StatReport", 1, "init RQD error " + localThrowable, localThrowable);
      }
    }
  }
  
  public void f()
  {
    if (!N.get())
    {
      W = com.tencent.mobileqq.msf.core.a.a.m();
      try
      {
        localObject = BaseApplication.getContext().getSharedPreferences("msf_crashcontrol", 0);
        if ((localObject != null) && (((SharedPreferences)localObject).getBoolean("shouldStopMsf", false)))
        {
          a("actMsfStopMsf", true, 0L, 0L, null, true, false);
          ((SharedPreferences)localObject).edit().putBoolean("shouldStopMsf", false).commit();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject;
          long l1;
          localException.printStackTrace();
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.w("MSF.C.StatReport", 1, "init beacon error " + localThrowable, localThrowable);
        return;
      }
      l1 = System.currentTimeMillis();
      UserAction.initUserAction(BaseApplication.getContext(), true, 1200L);
      localObject = BaseApplication.getContext().getAppData("channel_id");
      if ((localObject != null) && ((localObject instanceof String))) {
        UserAction.setChannelID((String)localObject);
      }
      UserAction.closeUseInfoEvent();
      UserAction.setAutoLaunchEventUsable(true);
      ANRReport.stopANRMonitor();
      P.start();
      N.set(true);
      if (t.j == 0) {}
      for (boolean bool = false;; bool = true)
      {
        a("dim.Msf.IMEIReading", bool, t.j, 0L, null, false, false);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MSF.C.StatReport", 2, "init beacon finished, cost=" + (System.currentTimeMillis() - l1));
        return;
      }
    }
  }
  
  String g()
  {
    int i3 = 0;
    int i2 = 0;
    NetworkInfo localNetworkInfo = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
    if (localNetworkInfo != null)
    {
      int i4;
      if (localNetworkInfo.isAvailable())
      {
        i1 = 1;
        i4 = (byte)i1;
        if (!localNetworkInfo.isConnected()) {
          break label107;
        }
      }
      label107:
      for (int i1 = 2;; i1 = 0)
      {
        int i5 = (byte)i1;
        i1 = i3;
        if (NetConnInfoCenter.isMobileNetworkInfo(localNetworkInfo))
        {
          i1 = i2;
          if (((TelephonyManager)BaseApplication.getContext().getSystemService("phone")).getDataState() == 2) {
            i1 = 4;
          }
          i1 = (byte)i1;
        }
        return String.valueOf((byte)(i5 | i4 | i1));
        i1 = 0;
        break;
      }
    }
    return "-1";
  }
  
  public void h()
  {
    a("dim.Msf.AUTOBOTTING", true, 0L, 0L, new HashMap(), false, false);
  }
  
  public void i() {}
  
  public void j() {}
  
  public static class a
  {
    HashMap n = null;
    
    public void a(String paramString)
    {
      a.a(BaseApplication.getContext()).a(paramString, this.n);
    }
    
    public void a(String paramString, int paramInt)
    {
      a.a(BaseApplication.getContext()).a(paramString, this.n, paramInt);
    }
    
    public void a(String paramString1, String paramString2)
    {
      if (this.n == null) {
        this.n = new HashMap();
      }
      this.n.put(paramString1, paramString2);
    }
    
    public void a(String paramString, boolean paramBoolean, long paramLong1, long paramLong2)
    {
      if (MsfService.getCore().getStatReporter() != null) {
        MsfService.getCore().getStatReporter().a(paramString, paramBoolean, paramLong1, paramLong2, this.n, false, false);
      }
    }
    
    public void a(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2, boolean paramBoolean3)
    {
      if (MsfService.getCore().getStatReporter() != null) {
        MsfService.getCore().getStatReporter().a(paramString, paramBoolean1, paramLong1, paramLong2, this.n, paramBoolean2, paramBoolean3);
      }
    }
    
    public void h()
    {
      if (this.n != null) {
        this.n.clear();
      }
    }
  }
  
  static class b
  {
    boolean a = true;
    int b = 86400;
    int c = 20;
    
    void a()
    {
      this.a = true;
      this.b = 86400;
      this.c = 20;
    }
  }
  
  public static class c
  {
    public boolean a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
  }
  
  public static class d
  {
    private int a;
    private int b;
    
    public void a()
    {
      this.a = 0;
      this.b = 0;
    }
    
    public boolean a(String paramString, int paramInt1, int paramInt2)
    {
      if (this.a == 0) {
        if (paramInt1 >= 20) {
          this.a = paramInt1;
        }
      }
      for (;;)
      {
        return false;
        if (paramInt1 >= this.a)
        {
          this.a = paramInt1;
          this.b += 1;
          if (this.b >= 20) {
            return true;
          }
        }
        else
        {
          a();
        }
      }
    }
    
    public int b()
    {
      return this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.j
 * JD-Core Version:    0.7.0.1
 */