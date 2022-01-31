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
import android.os.Process;
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
import com.tencent.mobileqq.msf.core.ag;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.core.net.n.a;
import com.tencent.mobileqq.msf.core.net.x;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.msf.service.q;
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

public class k
{
  static final String A = "param_NowLocalIp";
  static final String B = "param_sendLocalIp";
  static final String C = "param_Detail";
  static final String D = "param_tokenType";
  public static final String E = "param_reportTime";
  static final String F = "param_LoginConnect";
  static final String G = "param_LastConnCostTime";
  static final String H = "param_connectContinuanceTime";
  static final String I = "kMsfSupportIPFlag";
  static final int J = 0;
  static final int K = 1;
  static final String L = "kMsfConnectedIPFlag";
  static final int M = 0;
  static final int N = 1;
  static final String O = "param_activeIpFamily";
  static HashSet Q = null;
  public static volatile boolean R = false;
  static long S = 0L;
  static long T = 0L;
  static AtomicBoolean U = new AtomicBoolean(false);
  static AtomicBoolean V = new AtomicBoolean(false);
  static Thread W = new l("MsfCheckDeepSleepThread");
  static final String a = "MSF.C.StatReport";
  private static LinkedBlockingQueue ab = new LinkedBlockingQueue(100);
  private static ConcurrentHashMap ac = new ConcurrentHashMap();
  private static long ad = 3600000L;
  private static SimpleDateFormat ag = new SimpleDateFormat("MM.dd HH:mm:ss.SSS");
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
  MsfCore P;
  public k.c X;
  boolean Y = false;
  boolean Z = false;
  boolean aa = false;
  private k.b ae = new k.b();
  private StringBuilder af = new StringBuilder("\nMsf Crash Control info:\n");
  
  public k(MsfCore paramMsfCore)
  {
    this.P = paramMsfCore;
  }
  
  public static byte a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    int i2 = 0;
    int i3;
    label26:
    int i4;
    if (o())
    {
      i1 = 1;
      i3 = (byte)i1;
      if (!n()) {
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
          Iterator localIterator = ac.entrySet().iterator();
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
      if (p()) {
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
    localStringBuilder.append(paramd.c()).append(":").append(paramd.f());
    return localStringBuilder.toString();
  }
  
  private void a(long paramLong1, long paramLong2, int paramInt)
  {
    String str = "EvtPacketLossRat";
    if (paramInt == 1) {
      str = "EvtPacketLossRatV4";
    }
    for (;;)
    {
      paramInt = NetConnInfoCenter.getActiveNetIpFamily(false);
      HashMap localHashMap = new HashMap();
      localHashMap.put("packetLossRat", String.valueOf((float)paramLong1 * 0.75F / (float)paramLong2));
      localHashMap.put("activeIpfamily", String.valueOf(paramInt));
      if (MsfService.getCore().getStatReporter() != null) {
        MsfService.getCore().getStatReporter().a(str, true, 0L, 0L, localHashMap, false, false);
      }
      return;
      if (paramInt == 2) {
        str = "EvtPacketLossRatV6";
      }
    }
  }
  
  public static void a(String paramString1, boolean paramBoolean, int paramInt, String paramString2) {}
  
  public static long b(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (!paramBoolean) {}
    while (paramLong1 >= paramLong2) {
      return 0L;
    }
    Iterator localIterator = ac.entrySet().iterator();
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
    while (!ab.isEmpty())
    {
      RdmReq localRdmReq;
      StringBuilder localStringBuilder;
      Map localMap;
      long l1;
      label70:
      try
      {
        localRdmReq = (RdmReq)ab.take();
        if (localRdmReq == null) {
          continue;
        }
        localStringBuilder = new StringBuilder();
        localMap = localRdmReq.params;
        if (localMap != null) {
          l1 = SystemClock.elapsedRealtime();
        }
      }
      catch (Exception localException) {}
      try
      {
        l2 = Long.parseLong((String)localMap.get("param_reportTime"));
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label70;
      }
      long l2 = l1 - localRdmReq.elapse;
      int i1 = a(paramBoolean, l2, l1);
      localMap.put("param_runStatus", String.valueOf(i1));
      if ((i1 & 0x4) == 0) {}
      for (boolean bool = false;; bool = true)
      {
        localMap.put("param_deepSleep", String.valueOf(b(bool, l2, l1)));
        localMap.remove("param_reportTime");
        Iterator localIterator = localMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localStringBuilder.append("k=").append((String)localEntry.getKey()).append(", v=").append((String)localEntry.getValue()).append("; ");
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("MSF.C.StatReport", 2, "report RQD error " + localException, localException);
        break;
      }
      if (("actC2CPicDownloadV1".equalsIgnoreCase(localException.eventName)) || ("actC2CPicSmallDownV1".equalsIgnoreCase(localException.eventName)) || ("actGroupPicDownloadV1".equalsIgnoreCase(localException.eventName)) || ("actGroupPicSmallDownV1".equalsIgnoreCase(localException.eventName)))
      {
        localMap.put("param_msfcheck_result", String.valueOf(localException.isSucceed));
        UserAction.onUserAction("check_" + localException.eventName, true, localException.elapse, localException.size, localMap, localException.isRealTime);
      }
      UserAction.onUserAction(localException.eventName, localException.isSucceed, localException.elapse, localException.size, localMap, localException.isRealTime);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.StatReport", 2, "report RQD IMEI:" + t.d() + " eventName=" + localException.eventName + " isSucceed:" + localException.isSucceed + " elapse:" + localException.elapse + " size:" + localException.size + " isRealTime:" + localException.isRealTime + " isMerge:" + localException.isMerge + " params:" + localStringBuilder.toString());
      }
    }
  }
  
  private static boolean n()
  {
    return !MsfSdkUtils.isTopActivity(BaseApplication.getContext());
  }
  
  private static boolean o()
  {
    return !MsfSdkUtils.isScreenOn(BaseApplication.getContext());
  }
  
  private static boolean p()
  {
    boolean bool = false;
    if (Settings.System.getInt(BaseApplication.getContext().getContentResolver(), "airplane_mode_on", 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  void a()
  {
    String str = com.tencent.mobileqq.msf.core.a.a.af();
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      Object localObject = new JSONObject(str);
      this.ae.a = ((JSONObject)localObject).getBoolean("control_switch");
      this.ae.b = ((JSONObject)localObject).getInt("control_window");
      this.ae.c = ((JSONObject)localObject).getInt("control_freq");
      localObject = this.af.append("initCrashControl");
      ((StringBuilder)localObject).append(",controlJson=").append(str);
      ((StringBuilder)localObject).append(",switch=").append(this.ae.a);
      ((StringBuilder)localObject).append(",window=").append(this.ae.b);
      ((StringBuilder)localObject).append(",Freq=").append(this.ae.c);
      ((StringBuilder)localObject).append("\n");
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        this.ae.a();
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
      b.a(BaseApplication.getContext()).reportKVEvent("msf.core.DeadObjectException", localProperties);
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
      if (Q == null) {
        Q = new HashSet();
      }
      if (!Q.contains(paramString)) {}
    }
    else
    {
      return;
    }
    Q.add(paramString);
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
      if (R)
      {
        R = false;
        h();
      }
      if (!com.tencent.mobileqq.msf.core.a.a.s.contains(paramString)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.StatReport", 2, paramString + " is not need report.");
    return;
    if ((paramMap == null) || (!paramBoolean1)) {}
    for (;;)
    {
      int i1;
      Object localObject;
      try
      {
        if ((this.P != null) && (this.P.sender != null) && (this.P.sender.b != null)) {
          paramMap.put("param_isConnected", String.valueOf(this.P.sender.b.l().c()));
        }
        paramMap.put("param_NetworkOperator", t.l());
        i1 = NetConnInfoCenter.getSystemNetworkType();
        paramMap.put("param_NetworkInfo", String.valueOf(i1));
        if (!paramMap.containsKey(BaseConstants.RDM_NoChangeFailCode)) {
          break label438;
        }
        paramMap.remove(BaseConstants.RDM_NoChangeFailCode);
        paramMap.put("param_SsoServerIp", ag.E);
        paramMap.put("param_GatewayrIp", ag.o());
        if (!paramMap.containsKey("param_reportTime")) {
          paramMap.put("param_reportTime", String.valueOf(SystemClock.elapsedRealtime()));
        }
        boolean bool = this.P.getSsoListManager().d();
        i1 = this.P.sender.b.f();
        if (!bool) {
          break label459;
        }
        localObject = String.valueOf(1);
        paramMap.put("kMsfSupportIPFlag", localObject);
        if (i1 != 2) {
          break label468;
        }
        localObject = String.valueOf(1);
        paramMap.put("kMsfConnectedIPFlag", localObject);
        localObject = new RdmReq();
        ((RdmReq)localObject).eventName = paramString;
        ((RdmReq)localObject).elapse = paramLong1;
        ((RdmReq)localObject).size = paramLong2;
        ((RdmReq)localObject).isSucceed = paramBoolean1;
        ((RdmReq)localObject).isRealTime = paramBoolean2;
        ((RdmReq)localObject).isMerge = paramBoolean3;
        ((RdmReq)localObject).params = paramMap;
        if ((ab.offer(localObject)) || (!QLog.isColorLevel())) {
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
      label438:
      if (i1 == 0)
      {
        paramMap.put("param_FailCode", "900");
        continue;
        label459:
        localObject = String.valueOf(0);
        continue;
        label468:
        localObject = String.valueOf(0);
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
      localHashMap.put("SSOIP" + i1, ((n.a)paramArrayList.get(i1)).a);
      localHashMap.put("ConnTestSsoResult" + i1, String.valueOf(((n.a)paramArrayList.get(i1)).b));
      localHashMap.put("errorDetail" + i1, ((n.a)paramArrayList.get(i1)).c);
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
      if (o()) {
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
    localHashMap.put("param_NowLocalIp", ag.F);
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
      if (o()) {
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
    if (o())
    {
      a("dim.Msf.BG.UnRigisterPushResult", paramBoolean1, paramLong1, paramLong2, localHashMap, false, false);
      return;
    }
    a("dim.Msf.UnRigisterPushResult", paramBoolean1, paramLong1, paramLong2, localHashMap, false, false);
  }
  
  public void a(boolean paramBoolean1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean2, ArrayList paramArrayList, int paramInt)
  {
    if (!NetConnInfoCenter.isWifiOrMobileConn()) {}
    Object localObject2;
    label301:
    label582:
    label608:
    do
    {
      do
      {
        do
        {
          return;
        } while (paramArrayList.size() <= 0);
        Object localObject1 = "" + this.P.getMsfAppid();
        localObject1 = (String)localObject1 + "|1";
        localObject2 = com.tencent.mobileqq.msf.core.c.f(BaseApplication.getContext()) + "." + com.tencent.mobileqq.msf.core.c.e(BaseApplication.getContext());
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
          localObject1 = (String)localObject1 + ":" + false;
          localObject1 = (String)localObject1 + "|" + paramLong1;
          localObject1 = (String)localObject1 + "|" + paramLong2;
          localObject1 = (String)localObject1 + "|" + paramLong3;
          localObject1 = (String)localObject1 + "|" + paramBoolean2;
          if (!paramBoolean1) {
            break label608;
          }
        }
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
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("param_LoginConnect", paramArrayList);
        try
        {
          ((HashMap)localObject2).put("param_totalmemory", MsfSdkUtils.getTotalMemory());
        }
        catch (Exception paramArrayList)
        {
          try
          {
            ((HashMap)localObject2).put("param_Resolution", MsfSdkUtils.getResolutionString(BaseApplication.getContext()));
          }
          catch (Exception paramArrayList)
          {
            try
            {
              ((HashMap)localObject2).put("param_runStatus_new", String.valueOf(n.n));
            }
            catch (Exception paramArrayList)
            {
              try
              {
                for (;;)
                {
                  ((HashMap)localObject2).put("param_LastConnCostTime", String.valueOf(paramLong4));
                  try
                  {
                    localObject1 = this.P.getSsoListManager().f();
                    paramArrayList = (ArrayList)localObject1;
                    if (TextUtils.isEmpty((CharSequence)localObject1)) {
                      paramArrayList = "policy_default";
                    }
                    ((HashMap)localObject2).put("policy_id", paramArrayList);
                  }
                  catch (Exception paramArrayList)
                  {
                    for (;;)
                    {
                      QLog.d("MSF.C.StatReport", 1, "get policy_id error " + paramArrayList.toString());
                    }
                  }
                  if (QLog.isColorLevel())
                  {
                    QLog.d("MSF.C.StatReport", 2, "get report status " + (String)((HashMap)localObject2).get("param_runStatus"));
                    QLog.d("MSF.C.StatReport", 2, "get report new status " + String.valueOf(n.n));
                  }
                  paramInt = NetConnInfoCenter.getActiveNetIpFamily(true);
                  ((HashMap)localObject2).put("param_activeIpFamily", paramInt + "");
                  if (paramLong3 == -1L) {
                    break label1117;
                  }
                  a("msf_connAndRecv", paramBoolean1, paramLong1 + paramLong3, 0L, (Map)localObject2, false, false);
                  paramInt = this.P.sender.b.f();
                  if (paramInt != 1) {
                    break label1093;
                  }
                  a("msf_connAndRecv_ipv4", paramBoolean1, paramLong1 + paramLong3, 0L, (Map)localObject2, false, false);
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
              }
            }
          }
        }
      } while (paramInt != 2);
      a("msf_connAndRecv_ipv6", paramBoolean1, paramLong1 + paramLong3, 0L, (Map)localObject2, false, false);
      return;
      a("msf_connAndRecv", paramBoolean1, paramLong1, 0L, (Map)localObject2, false, false);
      paramInt = this.P.sender.b.f();
      if (paramInt == 1)
      {
        a("msf_connAndRecv_ipv4", paramBoolean1, paramLong1, 0L, (Map)localObject2, false, false);
        return;
      }
    } while (paramInt != 2);
    label1093:
    label1117:
    a("msf_connAndRecv_ipv6", paramBoolean1, paramLong1, 0L, (Map)localObject2, false, false);
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
      if (o())
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
    if (!this.Z) {
      this.Z = true;
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
            b.a(BaseApplication.getContext()).a("msf.cmd.Evt10008", (Map)localObject1, 0);
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
        if (((com.tencent.mobileqq.msf.core.net.a)paramArrayList.get(paramArrayList.size() - 1)).e != x.m) {
          break label201;
        }
        i2 = 1;
        i1 = i4;
      }
    }
    for (;;)
    {
      localHashMap.put("param_GatewayIp", ag.o());
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
      if (((com.tencent.mobileqq.msf.core.net.a)paramArrayList.get(paramArrayList.size() - 1)).e == x.i)
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
      if (o())
      {
        a("dim.Msf.BG.ConnDefaultElapsedTime", paramBoolean3, paramLong, 0, localHashMap, false, false);
        return;
      }
      a("dim.Msf.ConnDefaultElapsedTime", paramBoolean3, paramLong, 0, localHashMap, false, false);
      return;
    }
    if (o())
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
    if (!this.ae.a) {
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
    this.af.append("doCrashControl startTime=").append(ag.format(new Date(l1))).append(",currenttime=").append(ag.format(new Date(l2))).append(",crashCount=").append(i1).append("\n");
    if ((l1 <= 0L) || (l2 <= l1) || (i1 < 0) || (l2 - l1 > this.ae.b * 1000))
    {
      i1 = 1;
      l1 = l2;
    }
    for (;;)
    {
      if (i1 > this.ae.c) {
        this.Y = true;
      }
      if (this.Y)
      {
        QLog.d("MSF.C.StatReport", 1, "doCrashControl crashCount=" + i1 + ",shouldStopMsf=" + this.Y);
        BaseApplication localBaseApplication = BaseApplication.getContext();
        localBaseApplication.stopService(new Intent(localBaseApplication, MsfService.class));
      }
      this.af.append("doCrashControl shouldStopMsf=").append(this.Y).append("\n");
      localSharedPreferences.edit().putLong("starttime", l1).putInt("crashcount", i1).putBoolean("shouldStopMsf", this.Y).commit();
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
      paramToServiceMsg = str + "_" + String.valueOf(System.currentTimeMillis()) + "_" + q.b(paramToServiceMsg) + "_" + q.a(paramFromServiceMsg);
      paramFromServiceMsg = new HashMap();
      paramFromServiceMsg.put("errmsg", paramToServiceMsg);
      b.a(BaseApplication.getContext()).a("msf_sendMsgToApp_processIsNull", paramFromServiceMsg, 0);
      return;
    }
    catch (Throwable paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
    }
  }
  
  public void b(String paramString)
  {
    if (!this.aa) {
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
        b.a(BaseApplication.getContext()).a("msf_monitor_invalidSocket", localHashMap, 0);
        return;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    int i1;
    HashMap localHashMap;
    String str;
    if ((this.P != null) && (this.P.sender != null) && (this.P.sender.b != null))
    {
      i1 = this.P.sender.b.l().j();
      int i2 = NetConnInfoCenter.getActiveNetIpFamily(false);
      localHashMap = new HashMap();
      localHashMap.put("activeIpfamily", String.valueOf(i2));
      str = "EvtRegisterProxySucc";
      if (i1 != 1) {
        break label117;
      }
      str = "EvtRegisterProxySuccV4";
    }
    for (;;)
    {
      if (MsfService.getCore().getStatReporter() != null) {
        MsfService.getCore().getStatReporter().a(str, paramBoolean, 0L, 0L, localHashMap, false, false);
      }
      return;
      label117:
      if (i1 == 2) {
        str = "EvtRegisterProxySuccV6";
      }
    }
  }
  
  public final boolean c()
  {
    return U.get();
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.P != null)
    {
      HashMap localHashMap = new HashMap();
      if (MsfService.getCore().getStatReporter() != null) {
        MsfService.getCore().getStatReporter().a("EvtDeepSleep", paramBoolean, 0L, 0L, localHashMap, false, false);
      }
    }
  }
  
  public final boolean d()
  {
    return V.get();
  }
  
  public void e()
  {
    if (V.get()) {
      return;
    }
    long l1 = System.currentTimeMillis();
    Object localObject = new m(this);
    try
    {
      CrashStrategyBean localCrashStrategyBean = new CrashStrategyBean();
      localCrashStrategyBean.setUploadSpotCrash(false);
      localCrashStrategyBean.setMaxStackFrame(6);
      CrashReport.initCrashReport(BaseApplication.getContext(), (CrashHandleListener)localObject, null, false, localCrashStrategyBean);
      localObject = BaseApplication.getContext().getDir("tombs", 0).getAbsolutePath();
      CrashReport.initNativeCrashReport(BaseApplication.getContext(), (String)localObject, true);
      CrashReport.filterSysLog(true, true);
      V.set(true);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.StatReport", 2, "init RQD finished, cost=" + (System.currentTimeMillis() - l1));
      }
      this.af.append("\nCurrent process id=").append(Process.myPid());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.w("MSF.C.StatReport", 1, "init RQD error " + localThrowable, localThrowable);
    }
  }
  
  public void f()
  {
    if (!U.get())
    {
      ad = com.tencent.mobileqq.msf.core.a.a.m();
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
      W.start();
      U.set(true);
      if (t.k == 0) {}
      for (boolean bool = false;; bool = true)
      {
        a("dim.Msf.IMEIReading", bool, t.k, 0L, null, false, false);
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
  
  public void k()
  {
    if ((this.P != null) && (this.P.sender != null) && (this.P.sender.b != null)) {
      a(this.P.sender.b.l().l(), this.P.sender.b.l().k(), this.P.sender.b.l().j());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.k
 * JD-Core Version:    0.7.0.1
 */