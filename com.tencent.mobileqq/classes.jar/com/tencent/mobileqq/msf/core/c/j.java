package com.tencent.mobileqq.msf.core.c;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.Looper;
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
import com.tencent.mobileqq.msf.core.ac;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.msf.core.net.m;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.core.net.n.a;
import com.tencent.mobileqq.msf.core.net.x;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.msf.service.u;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MSFInterfaceAdapter;
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
  static final String I = "kMsfSupportIPFlag";
  static final int J = 0;
  static final int K = 1;
  static final String L = "kMsfConnectedIPFlag";
  static final int M = 0;
  static final int N = 1;
  static final String O = "param_activeIpFamily";
  static final String P = "IPv6_from_server";
  static HashSet R;
  public static volatile boolean S = false;
  static long T = 0L;
  static long U = 0L;
  static AtomicBoolean V;
  static AtomicBoolean W;
  static Thread X = new k("MsfCheckDeepSleepThread");
  static final String a = "MSF.C.StatReport";
  private static final String ac = "q_consume_time";
  private static final String ad = "q_length";
  private static LinkedBlockingQueue ae = new LinkedBlockingQueue(100);
  private static ConcurrentHashMap af = new ConcurrentHashMap();
  private static long ag = 3600000L;
  private static final int ah = 5000;
  private static final Object ai;
  private static final Object aj;
  private static SimpleDateFormat am = new SimpleDateFormat("MM.dd HH:mm:ss.SSS");
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
  MsfCore Q;
  public j.c Y;
  boolean Z = false;
  boolean aa = false;
  boolean ab = false;
  private j.b ak = new j.b();
  private StringBuilder al = new StringBuilder("\nMsf Crash Control info:\n");
  
  static
  {
    S = false;
    T = 0L;
    U = 0L;
    V = new AtomicBoolean(false);
    W = new AtomicBoolean(false);
    ai = new Object();
    aj = new Object();
  }
  
  public j(MsfCore paramMsfCore)
  {
    this.Q = paramMsfCore;
  }
  
  public static byte a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    int i3 = (byte)r();
    boolean bool = q();
    int i2 = 0;
    if (bool) {
      i1 = 2;
    } else {
      i1 = 0;
    }
    int i4 = (byte)i1;
    bool = paramBoolean;
    if (!paramBoolean)
    {
      bool = paramBoolean;
      if (paramLong1 <= paramLong2)
      {
        Object localObject = af.entrySet().iterator();
        Map.Entry localEntry;
        do
        {
          bool = paramBoolean;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localEntry = (Map.Entry)((Iterator)localObject).next();
        } while ((paramLong1 >= ((Long)localEntry.getValue()).longValue()) || (paramLong2 <= ((Long)localEntry.getKey()).longValue()));
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("find deep sleep. report time:[");
          ((StringBuilder)localObject).append(paramLong1);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(paramLong2);
          ((StringBuilder)localObject).append("], sleep time:[");
          ((StringBuilder)localObject).append(localEntry.getKey());
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(localEntry.getValue());
          ((StringBuilder)localObject).append("]");
          QLog.d("MSF.C.StatReport", 2, ((StringBuilder)localObject).toString());
        }
        bool = true;
      }
    }
    if (bool) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    int i5 = (byte)i1;
    int i1 = i2;
    if (s()) {
      i1 = 8;
    }
    return (byte)(i5 | i3 | i4 | (byte)i1);
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
    localStringBuilder.append(paramd.b());
    localStringBuilder.append("://");
    localStringBuilder.append(paramd.c());
    localStringBuilder.append(":");
    localStringBuilder.append(paramd.f());
    return localStringBuilder.toString();
  }
  
  private void a(long paramLong1, long paramLong2, int paramInt)
  {
    String str;
    if (paramInt == 1) {
      str = "EvtPacketLossRatV4";
    } else if (paramInt == 2) {
      str = "EvtPacketLossRatV6";
    } else {
      str = "EvtPacketLossRat";
    }
    paramInt = NetConnInfoCenter.getActiveNetIpFamily(false);
    HashMap localHashMap = new HashMap();
    localHashMap.put("packetLossRat", String.valueOf((float)paramLong1 * 0.75F / (float)paramLong2));
    localHashMap.put("activeIpfamily", String.valueOf(paramInt));
    if (MsfService.getCore().getStatReporter() != null) {
      MsfService.getCore().getStatReporter().a(str, true, 0L, 0L, localHashMap, false, false);
    }
  }
  
  public static void a(String paramString1, boolean paramBoolean, int paramInt, String paramString2) {}
  
  public static long b(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    long l1 = 0L;
    if (!paramBoolean) {
      return 0L;
    }
    if (paramLong1 >= paramLong2) {
      return 0L;
    }
    Iterator localIterator = af.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((paramLong1 >= ((Long)localEntry.getKey()).longValue()) && (paramLong1 <= ((Long)localEntry.getValue()).longValue()))
      {
        if (paramLong2 <= ((Long)localEntry.getValue()).longValue()) {
          return paramLong2 - paramLong1;
        }
        l1 = l1 + ((Long)localEntry.getValue()).longValue() - paramLong1;
      }
      else if (paramLong1 < ((Long)localEntry.getKey()).longValue())
      {
        long l2;
        if ((paramLong2 >= ((Long)localEntry.getKey()).longValue()) && (paramLong2 <= ((Long)localEntry.getValue()).longValue()))
        {
          l1 += paramLong2;
          l2 = ((Long)localEntry.getKey()).longValue();
        }
        else
        {
          if (paramLong2 <= ((Long)localEntry.getValue()).longValue()) {
            continue;
          }
          l1 += ((Long)localEntry.getValue()).longValue();
          l2 = ((Long)localEntry.getKey()).longValue();
        }
        l1 -= l2;
      }
    }
    return l1;
  }
  
  static void b(boolean paramBoolean)
  {
    while (!ae.isEmpty())
    {
      RdmReq localRdmReq;
      StringBuilder localStringBuilder;
      Object localObject2;
      long l1;
      label70:
      try
      {
        localRdmReq = (RdmReq)ae.take();
        if (localRdmReq == null) {
          continue;
        }
        localStringBuilder = new StringBuilder();
        localObject2 = localRdmReq.params;
        if (localObject2 != null) {
          l1 = SystemClock.elapsedRealtime();
        }
      }
      catch (Exception localException) {}
      try
      {
        l2 = Long.parseLong((String)((Map)localObject2).get("param_reportTime"));
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label70;
        bool = true;
        break label112;
      }
      long l2 = l1 - localRdmReq.elapse;
      int i1 = a(paramBoolean, l2, l1);
      ((Map)localObject2).put("param_runStatus", String.valueOf(i1));
      if ((i1 & 0x4) != 0) {
        break label652;
      }
      bool = false;
      label112:
      ((Map)localObject2).put("param_deepSleep", String.valueOf(b(bool, l2, l1)));
      ((Map)localObject2).remove("param_reportTime");
      Iterator localIterator = ((Map)localObject2).entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append("k=");
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append(", v=");
        localStringBuilder.append((String)localEntry.getValue());
        localStringBuilder.append("; ");
      }
      ((Map)localObject2).put("q_consume_time", String.valueOf(localRdmReq.elapse));
      ((Map)localObject2).put("q_length", String.valueOf(localRdmReq.size));
      if (("actC2CPicDownloadV1".equalsIgnoreCase(localRdmReq.eventName)) || ("actC2CPicSmallDownV1".equalsIgnoreCase(localRdmReq.eventName)) || ("actGroupPicDownloadV1".equalsIgnoreCase(localRdmReq.eventName)) || ("actGroupPicSmallDownV1".equalsIgnoreCase(localRdmReq.eventName)))
      {
        ((Map)localObject2).put("param_msfcheck_result", String.valueOf(localRdmReq.isSucceed));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("check_");
        localStringBuilder.append(localRdmReq.eventName);
        UserAction.onUserAction(localStringBuilder.toString(), true, localRdmReq.elapse, localRdmReq.size, (Map)localObject2, localRdmReq.isRealTime);
      }
      if (TextUtils.isEmpty(localRdmReq.appKey)) {
        UserAction.onUserAction(localRdmReq.eventName, localRdmReq.isSucceed, localRdmReq.elapse, localRdmReq.size, (Map)localObject2, localRdmReq.isRealTime, localRdmReq.isImmediatelyUpload);
      } else {
        UserAction.onUserActionToTunnel(localRdmReq.appKey, localRdmReq.eventName, localRdmReq.isSucceed, localRdmReq.elapse, localRdmReq.size, (Map)localObject2, localRdmReq.isRealTime, localRdmReq.isImmediatelyUpload);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("report RQD IMEI:");
        ((StringBuilder)localObject2).append(o.d());
        ((StringBuilder)localObject2).append(" ");
        ((StringBuilder)localObject2).append(localRdmReq.toString());
        QLog.d("MSF.C.StatReport", 2, ((StringBuilder)localObject2).toString());
        continue;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("report RQD error ");
          ((StringBuilder)localObject2).append(localException);
          QLog.w("MSF.C.StatReport", 2, ((StringBuilder)localObject2).toString(), localException);
        }
      }
    }
    synchronized (aj)
    {
      aj.notifyAll();
      return;
    }
  }
  
  private static boolean q()
  {
    return MsfSdkUtils.isTopActivity(BaseApplication.getContext()) ^ true;
  }
  
  private static boolean r()
  {
    return MsfSdkUtils.isScreenOn(BaseApplication.getContext()) ^ true;
  }
  
  private static boolean s()
  {
    ContentResolver localContentResolver = BaseApplication.getContext().getContentResolver();
    boolean bool = false;
    if (Settings.System.getInt(localContentResolver, "airplane_mode_on", 0) != 0) {
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
      localObject = new JSONObject(str);
      this.ak.a = ((JSONObject)localObject).getBoolean("control_switch");
      this.ak.b = ((JSONObject)localObject).getInt("control_window");
      this.ak.c = ((JSONObject)localObject).getInt("control_freq");
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label65:
      break label65;
    }
    this.ak.a();
    QLog.d("MSF.C.StatReport", 1, "initCrashControl parse json throws an exception, so reset.");
    localObject = this.al;
    ((StringBuilder)localObject).append("initCrashControl");
    ((StringBuilder)localObject).append(",controlJson=");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(",switch=");
    ((StringBuilder)localObject).append(this.ak.a);
    ((StringBuilder)localObject).append(",window=");
    ((StringBuilder)localObject).append(this.ak.b);
    ((StringBuilder)localObject).append(",Freq=");
    ((StringBuilder)localObject).append(this.ak.c);
    ((StringBuilder)localObject).append("\n");
  }
  
  public void a(long paramLong)
  {
    int i1 = this.Q.sender.b.l().j();
    String str;
    if (i1 == 1) {
      str = "msf_IPv4_send_msg";
    } else if (i1 == 2) {
      str = "msf_IPv6_send_msg";
    } else {
      str = "msf_send_msg";
    }
    HashMap localHashMap = new HashMap();
    if (MsfService.getCore().getStatReporter() != null) {
      MsfService.getCore().getStatReporter().a(str, true, paramLong, 0L, localHashMap, false, false);
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramLong);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("|");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramString1);
    paramString1 = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("|");
    paramString1 = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(paramString2);
    paramString1 = ((StringBuilder)localObject).toString();
    paramString2 = new HashMap();
    paramString2.put("param_connectContinuanceTime", paramString1);
    a("msf_connectContinuanceTime", false, paramLong, 0L, paramString2, false, false);
  }
  
  public void a(WifiInfo paramWifiInfo)
  {
    if ((paramWifiInfo.getBSSID() == null) || (paramWifiInfo.getIpAddress() == 0) || (paramWifiInfo.getSupplicantState() != SupplicantState.COMPLETED))
    {
      String str = paramWifiInfo.getBSSID();
      int i2 = 0;
      if (str == null) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      int i3 = (byte)i1;
      if (paramWifiInfo.getIpAddress() == 0) {
        i1 = 2;
      } else {
        i1 = 0;
      }
      int i4 = (byte)i1;
      int i1 = i2;
      if (paramWifiInfo.getSupplicantState() != SupplicantState.COMPLETED) {
        i1 = 4;
      }
      i1 = (byte)i1;
      paramWifiInfo = new HashMap();
      paramWifiInfo.put("param_FailCode", String.valueOf((i1 | i3 | i4) + 5000));
      a("dim.Msf.WifiNoConnection", false, 0L, 0L, paramWifiInfo, true, false);
    }
  }
  
  public void a(String paramString)
  {
    UserAction.setUserID(paramString);
    CrashReport.setUserId(BaseApplication.getContext(), paramString);
    QLog.d("MSF.C.StatReport", 1, new Object[] { "setUserId = ", paramString });
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
      localHashMap.put("pm_imsi", o.e());
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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramString4);
      localObject = String.valueOf(((StringBuilder)localObject).toString());
      HashMap localHashMap = new HashMap();
      localHashMap.put("uin", String.valueOf(paramString1));
      localHashMap.put("type", String.valueOf(paramString3));
      localHashMap.put("msg", String.valueOf(localObject));
      localHashMap.put("exception", String.valueOf(paramString4));
      localHashMap.put("processName", String.valueOf(paramString2));
      a("msf.core.DeadObjectException", true, 0L, 0L, localHashMap, false, false);
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportCloseConnForAlarm type:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",isEffective:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",saveTime:");
      ((StringBuilder)localObject).append(paramLong1);
      QLog.d("MSF.C.StatReport", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("param_reportType", paramString1);
      ((HashMap)localObject).put("param_uin", paramString2);
      ((HashMap)localObject).put("param_saveCost", String.valueOf(paramLong1));
      ((HashMap)localObject).put("param_isEffective", String.valueOf(paramBoolean));
      if (!paramBoolean)
      {
        ((HashMap)localObject).put("param_timeforten", String.valueOf(paramLong2));
        ((HashMap)localObject).put("param_timeforsix", String.valueOf(paramLong3));
        ((HashMap)localObject).put("param_timeforalarm", String.valueOf(paramLong4));
        ((HashMap)localObject).put("param_timeforlastrecv", String.valueOf(paramLong5));
        ((HashMap)localObject).put("param_timeforcloseconn", String.valueOf(paramLong6));
      }
      a("dim.Msf.CloseConnForAlarm", false, paramLong1, 0L, (Map)localObject, false, false);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.d("MSF.C.StatReport", 1, "reportCloseConnForAlarm error!", paramString1);
    }
  }
  
  public void a(String arg1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, Map paramMap, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (!c()) {
      return;
    }
    if (S)
    {
      S = false;
      h();
    }
    if (com.tencent.mobileqq.msf.core.a.a.s.contains(paramString2))
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append(paramString2);
        ???.append(" is not need report.");
        QLog.d("MSF.C.StatReport", 2, ???.toString());
      }
      return;
    }
    if ((paramMap == null) || (!paramBoolean1)) {}
    try
    {
      if ((this.Q != null) && (this.Q.sender != null) && (this.Q.sender.b != null)) {
        paramMap.put("param_isConnected", String.valueOf(this.Q.sender.b.l().c()));
      }
      paramMap.put("param_NetworkOperator", o.l());
      int i1 = NetConnInfoCenter.getSystemNetworkType();
      paramMap.put("param_NetworkInfo", String.valueOf(i1));
      if (paramMap.containsKey(BaseConstants.RDM_NoChangeFailCode)) {
        paramMap.remove(BaseConstants.RDM_NoChangeFailCode);
      } else if (i1 == 0) {
        paramMap.put("param_FailCode", "900");
      }
      paramMap.put("param_SsoServerIp", ac.E);
      paramMap.put("param_GatewayrIp", ac.q());
      if (!paramMap.containsKey("param_reportTime")) {
        paramMap.put("param_reportTime", String.valueOf(SystemClock.elapsedRealtime()));
      }
      boolean bool = this.Q.getSsoListManager().d();
      i1 = this.Q.sender.b.f();
      if (bool) {
        localObject = String.valueOf(1);
      } else {
        localObject = String.valueOf(0);
      }
      paramMap.put("kMsfSupportIPFlag", localObject);
      if (i1 == 2) {
        localObject = String.valueOf(1);
      } else {
        localObject = String.valueOf(0);
      }
      paramMap.put("kMsfConnectedIPFlag", localObject);
      Object localObject = new RdmReq();
      ((RdmReq)localObject).eventName = paramString2;
      ((RdmReq)localObject).elapse = paramLong1;
      ((RdmReq)localObject).size = paramLong2;
      ((RdmReq)localObject).isSucceed = paramBoolean1;
      ((RdmReq)localObject).isRealTime = paramBoolean2;
      ((RdmReq)localObject).isMerge = paramBoolean4;
      ((RdmReq)localObject).params = paramMap;
      ((RdmReq)localObject).appKey = ???;
      ((RdmReq)localObject).isImmediatelyUpload = paramBoolean3;
      if (!ae.offer(localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.StatReport", 2, "wait queue is full, try notify to start report");
        }
        synchronized (ai)
        {
          ai.notifyAll();
          if (Looper.getMainLooper() != Looper.myLooper())
          {
            try
            {
              synchronized (aj)
              {
                aj.wait(5000L);
              }
            }
            catch (InterruptedException paramString2)
            {
              paramString2.printStackTrace();
              if ((!ae.offer(localObject)) && (QLog.isColorLevel())) {
                QLog.d("MSF.C.StatReport", 2, "offer fail finally");
              }
              return;
            }
            throw paramString2;
          }
        }
      }
      return;
    }
    catch (Exception ???)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("report RQD error ");
        paramString2.append(???);
        QLog.w("MSF.C.StatReport", 2, paramString2.toString(), ???);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean, long paramLong1, int paramInt, long paramLong2)
  {
    if (NetConnInfoCenter.isWifiOrMobileConn())
    {
      if (R == null) {
        R = new HashSet();
      }
      if (R.contains(paramString)) {
        return;
      }
      R.add(paramString);
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_uin", paramString);
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      a("dim.Msf.UserGrayfail", paramBoolean, paramLong1, paramLong2, localHashMap, false, false);
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    a("", paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, false, paramBoolean3);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SSOIP");
      localStringBuilder.append(i1);
      localHashMap.put(localStringBuilder.toString(), ((n.a)paramArrayList.get(i1)).a);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ConnTestSsoResult");
      localStringBuilder.append(i1);
      localHashMap.put(localStringBuilder.toString(), String.valueOf(((n.a)paramArrayList.get(i1)).b));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("errorDetail");
      localStringBuilder.append(i1);
      localHashMap.put(localStringBuilder.toString(), ((n.a)paramArrayList.get(i1)).c);
      i1 += 1;
    }
    localHashMap.put("respcode", String.valueOf(paramInt));
    a("msf_netStateWhileSSOListCannotConnBDOK5", paramBoolean, 0L, 0L, localHashMap, true, false);
  }
  
  public void a(boolean paramBoolean, long paramLong1, int paramInt, long paramLong2)
  {
    if (NetConnInfoCenter.isWifiOrMobileConn())
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt + 3300));
      if (r())
      {
        a("dim.Msf.BG.PushQueryResult", paramBoolean, paramLong1, paramLong2, localHashMap, false, false);
        return;
      }
      a("dim.Msf.PushQueryResult", paramBoolean, paramLong1, paramLong2, localHashMap, false, false);
    }
  }
  
  public void a(boolean paramBoolean1, long paramLong1, int paramInt, long paramLong2, String paramString1, String paramString2, boolean paramBoolean2, long paramLong3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt + 3000));
    localHashMap.put("param_SsoServerIp", paramString1);
    localHashMap.put("param_sendLocalIp", paramString2);
    localHashMap.put("param_NowLocalIp", ac.F);
    localHashMap.put("param_Reason", String.valueOf(paramBoolean2));
    localHashMap.put("param_sendTime", String.valueOf(paramLong3));
    a("Msf.CommonLogin", paramBoolean1, paramLong1, paramLong2, localHashMap, false, false);
  }
  
  public void a(boolean paramBoolean1, long paramLong1, int paramInt, long paramLong2, boolean paramBoolean2, String paramString)
  {
    if (NetConnInfoCenter.isWifiOrMobileConn())
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_Reason", paramString);
      if (!paramBoolean2)
      {
        localHashMap.put("param_FailCode", String.valueOf(paramInt + 3100));
        if (r())
        {
          a("dim.Msf.BG.RigisterPushResult", paramBoolean1, paramLong1, paramLong2, localHashMap, false, false);
          return;
        }
        a("dim.Msf.RigisterPushResult", paramBoolean1, paramLong1, paramLong2, localHashMap, false, false);
        return;
      }
      localHashMap.put("param_FailCode", String.valueOf(paramInt + 3200));
      if (r())
      {
        a("dim.Msf.BG.UnRigisterPushResult", paramBoolean1, paramLong1, paramLong2, localHashMap, false, false);
        return;
      }
      a("dim.Msf.UnRigisterPushResult", paramBoolean1, paramLong1, paramLong2, localHashMap, false, false);
    }
  }
  
  public void a(boolean paramBoolean1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean2, ArrayList paramArrayList, int paramInt)
  {
    if (!NetConnInfoCenter.isWifiOrMobileConn()) {
      return;
    }
    if (paramArrayList.size() <= 0) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(this.Q.getMsfAppid());
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("|1");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(com.tencent.mobileqq.msf.core.c.f(BaseApplication.getContext()));
    ((StringBuilder)localObject2).append(".");
    ((StringBuilder)localObject2).append(com.tencent.mobileqq.msf.core.c.e(BaseApplication.getContext()));
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("|");
    localStringBuilder.append((String)localObject2);
    localObject1 = localStringBuilder.toString();
    localObject2 = (com.tencent.mobileqq.msf.core.net.a)paramArrayList.get(paramArrayList.size() - 1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("|");
    localStringBuilder.append(((com.tencent.mobileqq.msf.core.net.a)localObject2).g);
    localObject2 = localStringBuilder.toString();
    localObject1 = o.e();
    if ((localObject1 != null) && (((String)localObject1).length() >= 5))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("|");
      localStringBuilder.append(((String)localObject1).substring(0, 3));
      localObject2 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(":");
      localStringBuilder.append(((String)localObject1).substring(3, 5));
      localObject1 = localStringBuilder.toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("|000");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(":00");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    localObject2 = o.i();
    if (localObject2 != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(":");
      localStringBuilder.append((String)localObject2);
      localObject1 = localStringBuilder.toString();
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(":000");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(":");
    ((StringBuilder)localObject2).append(false);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(paramLong1);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(paramLong2);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(paramLong3);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(paramBoolean2);
    localObject1 = ((StringBuilder)localObject2).toString();
    if (paramBoolean1)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("|1");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(paramInt);
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localObject2 = (com.tencent.mobileqq.msf.core.net.a)paramArrayList.next();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("|");
      localStringBuilder.append(((com.tencent.mobileqq.msf.core.net.a)localObject2).a());
      localObject1 = localStringBuilder.toString();
    }
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("param_LoginConnect", localObject1);
    try
    {
      ((HashMap)localObject2).put("param_totalmemory", MsfSdkUtils.getTotalMemory());
    }
    catch (Exception paramArrayList)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getTotalMemoey error ");
      ((StringBuilder)localObject1).append(paramArrayList);
      QLog.d("MSF.C.StatReport", 1, ((StringBuilder)localObject1).toString());
    }
    try
    {
      ((HashMap)localObject2).put("param_Resolution", MsfSdkUtils.getResolutionString(BaseApplication.getContext()));
    }
    catch (Exception paramArrayList)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getResilution error ");
      ((StringBuilder)localObject1).append(paramArrayList);
      QLog.d("MSF.C.StatReport", 1, ((StringBuilder)localObject1).toString());
    }
    try
    {
      ((HashMap)localObject2).put("param_runStatus_new", String.valueOf(n.n));
    }
    catch (Exception paramArrayList)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("get new status error ");
      ((StringBuilder)localObject1).append(paramArrayList.toString());
      QLog.d("MSF.C.StatReport", 1, ((StringBuilder)localObject1).toString());
    }
    try
    {
      ((HashMap)localObject2).put("param_LastConnCostTime", String.valueOf(paramLong4));
    }
    catch (Exception paramArrayList)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("get last conncost error ");
      ((StringBuilder)localObject1).append(paramArrayList.toString());
      QLog.d("MSF.C.StatReport", 1, ((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject1 = this.Q.getSsoListManager().f();
      paramArrayList = (ArrayList)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramArrayList = "policy_default";
      }
      ((HashMap)localObject2).put("policy_id", paramArrayList);
    }
    catch (Exception paramArrayList)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("get policy_id error ");
      ((StringBuilder)localObject1).append(paramArrayList.toString());
      QLog.d("MSF.C.StatReport", 1, ((StringBuilder)localObject1).toString());
    }
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("get report status ");
      paramArrayList.append((String)((HashMap)localObject2).get("param_runStatus"));
      QLog.d("MSF.C.StatReport", 2, paramArrayList.toString());
      paramArrayList = new StringBuilder();
      paramArrayList.append("get report new status ");
      paramArrayList.append(String.valueOf(n.n));
      QLog.d("MSF.C.StatReport", 2, paramArrayList.toString());
    }
    paramInt = NetConnInfoCenter.getActiveNetIpFamily(true);
    paramArrayList = new StringBuilder();
    paramArrayList.append(paramInt);
    paramArrayList.append("");
    ((HashMap)localObject2).put("param_activeIpFamily", paramArrayList.toString());
    ((HashMap)localObject2).put("IPv6_from_server", String.valueOf(this.Q.getSsoListManager().d()));
    if (paramLong3 != -1L)
    {
      paramLong1 = paramLong3 + paramLong1;
      a("msf_connAndRecv", paramBoolean1, paramLong1, 0L, (Map)localObject2, false, false);
      paramInt = this.Q.sender.b.f();
      if (paramInt == 1)
      {
        a("msf_connAndRecv_ipv4", paramBoolean1, paramLong1, 0L, (Map)localObject2, false, false);
        return;
      }
      if (paramInt == 2) {
        a("msf_connAndRecv_ipv6", paramBoolean1, paramLong1, 0L, (Map)localObject2, false, false);
      }
    }
    else
    {
      a("msf_connAndRecv", paramBoolean1, paramLong1, 0L, (Map)localObject2, false, false);
      paramInt = this.Q.sender.b.f();
      if (paramInt == 1)
      {
        a("msf_connAndRecv_ipv4", paramBoolean1, paramLong1, 0L, (Map)localObject2, false, false);
        return;
      }
      if (paramInt == 2) {
        a("msf_connAndRecv_ipv6", paramBoolean1, paramLong1, 0L, (Map)localObject2, false, false);
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
    paramd = new StringBuilder();
    paramd.append("");
    paramd.append(paramLong1);
    paramd = paramd.toString();
    parama = new StringBuilder();
    parama.append(paramd);
    parama.append("|");
    paramd = parama.toString();
    parama = new StringBuilder();
    parama.append(paramd);
    parama.append(paramString1);
    paramd = parama.toString();
    parama = new StringBuilder();
    parama.append(paramd);
    parama.append("|");
    paramd = parama.toString();
    parama = new StringBuilder();
    parama.append(paramd);
    parama.append(paramString2);
    localHashMap.put("param_connectContinuanceTime", parama.toString());
    try
    {
      localHashMap.put("param_uin", MsfService.getCore().getAccountCenter().i());
    }
    catch (Exception paramd)
    {
      QLog.d("MSF.C.StatReport", 1, "getMainAccout error!", paramd);
    }
    if (r())
    {
      a("dim.Msf.BG.ConnClose", paramBoolean, paramLong1, 0, localHashMap, false, false);
      return;
    }
    a("dim.Msf.ConnClose", paramBoolean, paramLong1, 0, localHashMap, false, false);
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ssolist", paramString);
    paramString = new StringBuilder();
    paramString.append("");
    paramString.append(paramLong);
    localHashMap.put("SSOListToConnectEndTime", paramString.toString());
    a("msf_justGetSSOListButCannotConn", paramBoolean, paramLong, 0L, localHashMap, true, false);
  }
  
  public void a(boolean paramBoolean1, long paramLong1, boolean paramBoolean2, long paramLong2, boolean paramBoolean3, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("address", paramString);
    localHashMap.put("dualCostV4", String.valueOf(paramLong1));
    localHashMap.put("succV4", String.valueOf(paramBoolean2));
    localHashMap.put("dualCostV6", String.valueOf(paramLong2));
    localHashMap.put("succV6", String.valueOf(paramBoolean3));
    localHashMap.put("succip", String.valueOf(paramString));
    if (MsfService.getCore().getStatReporter() != null) {
      MsfService.getCore().getStatReporter().a("EvtDual", paramBoolean1, 0L, 0L, localHashMap, false, false);
    }
  }
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (!this.aa) {
      this.aa = true;
    }
    for (;;)
    {
      try
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(MsfCore.sCore.getAccountCenter().i());
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(String.valueOf(System.currentTimeMillis()));
        ((StringBuilder)localObject).append("_");
        if (paramBoolean) {
          str = paramToServiceMsg.getShortStringForLog();
        } else {
          str = paramFromServiceMsg.getShortStringForLog();
        }
        ((StringBuilder)localObject).append(str);
        String str = ((StringBuilder)localObject).toString();
        localObject = new HashMap();
        ((HashMap)localObject).put("uin", MsfCore.sCore.getAccountCenter().i());
        ((HashMap)localObject).put("time", String.valueOf(System.currentTimeMillis()));
        ((HashMap)localObject).put("msg", str);
        str = "null";
        if (paramFromServiceMsg == null) {
          break label237;
        }
        paramFromServiceMsg = paramFromServiceMsg.getStringForLog();
        ((HashMap)localObject).put("from", paramFromServiceMsg);
        paramFromServiceMsg = str;
        if (paramToServiceMsg != null) {
          paramFromServiceMsg = paramToServiceMsg.getStringForLog();
        }
        ((HashMap)localObject).put("to", paramFromServiceMsg);
        if (MsfService.getCore().getStatReporter() != null)
        {
          MsfService.getCore().getStatReporter().a("msf.cmd.Evt10008", true, 0L, 0L, (Map)localObject, false, false);
          return;
        }
      }
      catch (Throwable paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
      return;
      label237:
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
      localHashMap.put("param_imei", o.d());
      a("dim.Msf.RenewToken_3", paramBoolean, paramLong1, paramLong2, localHashMap, false, false);
    }
  }
  
  public void a(boolean paramBoolean, String paramString, Object paramObject) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong, ArrayList paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    if ((!paramBoolean3) && (paramArrayList.size() > 0))
    {
      localHashMap.put("param_Reason", String.valueOf(((com.tencent.mobileqq.msf.core.net.a)paramArrayList.get(paramArrayList.size() - 1)).e));
      if (((com.tencent.mobileqq.msf.core.net.a)paramArrayList.get(paramArrayList.size() - 1)).e == x.m)
      {
        i1 = 1;
        break label116;
      }
      if (((com.tencent.mobileqq.msf.core.net.a)paramArrayList.get(paramArrayList.size() - 1)).e == x.i)
      {
        i1 = 0;
        i2 = 1;
        break label119;
      }
    }
    int i1 = 0;
    label116:
    int i2 = 0;
    label119:
    localHashMap.put("param_GatewayIp", ac.q());
    localHashMap.put("param_FailCode", String.valueOf(paramArrayList.size()));
    Object localObject = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      com.tencent.mobileqq.msf.core.net.a locala = (com.tencent.mobileqq.msf.core.net.a)paramArrayList.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(locala.toString());
      localStringBuilder.append("|");
      ((StringBuilder)localObject).append(localStringBuilder.toString());
    }
    localObject = ((StringBuilder)localObject).toString();
    paramArrayList = (ArrayList)localObject;
    if (((String)localObject).endsWith("|")) {
      paramArrayList = ((String)localObject).substring(0, ((String)localObject).length() - 1);
    }
    localHashMap.put("param_connResult", paramArrayList);
    if (!paramBoolean3)
    {
      localHashMap.put("param_localIp", o.n());
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
      if (r())
      {
        a("dim.Msf.BG.ConnDefaultElapsedTime", paramBoolean3, paramLong, 0, localHashMap, false, false);
        return;
      }
      a("dim.Msf.ConnDefaultElapsedTime", paramBoolean3, paramLong, 0, localHashMap, false, false);
      return;
    }
    if (r())
    {
      if (i1 != 0)
      {
        a("dim.Msf.BG.ConnFailByUnreachable", paramBoolean3, paramLong, 0, localHashMap, false, false);
        return;
      }
      if (i2 != 0)
      {
        a("dim.Msf.BG.ConnFailByPermission", paramBoolean3, paramLong, 0, localHashMap, false, false);
        return;
      }
      a("dim.Msf.BG.ConnElapsedTime", paramBoolean3, paramLong, 0, localHashMap, false, false);
      return;
    }
    if (i1 != 0)
    {
      a("dim.Msf.ConnFailByUnreachable", paramBoolean3, paramLong, 0, localHashMap, false, false);
      return;
    }
    if (i2 != 0)
    {
      a("dim.Msf.ConnFailByPermission", paramBoolean3, paramLong, 0, localHashMap, false, false);
      return;
    }
    a("dim.Msf.ConnElapsedTime", paramBoolean3, paramLong, 0, localHashMap, false, false);
  }
  
  void b()
  {
    if (!this.ak.a)
    {
      QLog.d("MSF.C.StatReport", 1, "doCrashControl crash control is off..");
      return;
    }
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("msf_crashcontrol", 0);
    if (localSharedPreferences != null)
    {
      long l1 = localSharedPreferences.getLong("starttime", 0L);
      int i1 = localSharedPreferences.getInt("crashcount", 0);
      long l2 = System.currentTimeMillis();
      Object localObject = this.al;
      ((StringBuilder)localObject).append("doCrashControl startTime=");
      ((StringBuilder)localObject).append(am.format(new Date(l1)));
      ((StringBuilder)localObject).append(",currenttime=");
      ((StringBuilder)localObject).append(am.format(new Date(l2)));
      ((StringBuilder)localObject).append(",crashCount=");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("\n");
      if ((l1 > 0L) && (l2 > l1) && (i1 >= 0) && (l2 - l1 <= this.ak.b * 1000))
      {
        i1 += 1;
      }
      else
      {
        l1 = l2;
        i1 = 1;
      }
      if (i1 > this.ak.c) {
        this.Z = true;
      }
      if (this.Z)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doCrashControl crashCount=");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(",shouldStopMsf=");
        ((StringBuilder)localObject).append(this.Z);
        QLog.d("MSF.C.StatReport", 1, ((StringBuilder)localObject).toString());
        localObject = BaseApplication.getContext();
        ((Context)localObject).stopService(new Intent((Context)localObject, MsfService.class));
      }
      localObject = this.al;
      ((StringBuilder)localObject).append("doCrashControl shouldStopMsf=");
      ((StringBuilder)localObject).append(this.Z);
      ((StringBuilder)localObject).append("\n");
      localSharedPreferences.edit().putLong("starttime", l1).putInt("crashcount", i1).putBoolean("shouldStopMsf", this.Z).commit();
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_");
      localStringBuilder.append(String.valueOf(System.currentTimeMillis()));
      localStringBuilder.append("_");
      localStringBuilder.append(u.b(paramToServiceMsg));
      localStringBuilder.append("_");
      localStringBuilder.append(u.a(paramFromServiceMsg));
      paramToServiceMsg = localStringBuilder.toString();
      paramFromServiceMsg = new HashMap();
      paramFromServiceMsg.put("errmsg", paramToServiceMsg);
      a("msf_sendMsgToApp_processIsNull", true, 0L, 0L, paramFromServiceMsg, false, false);
      return;
    }
    catch (Throwable paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
    }
  }
  
  public void b(String paramString)
  {
    if (!this.ab) {
      try
      {
        String str = MsfCore.sCore.getAccountCenter().i();
        if (TextUtils.isEmpty(str)) {
          return;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(String.valueOf(System.currentTimeMillis()));
        str = ((StringBuilder)localObject).toString();
        localObject = new HashMap();
        ((HashMap)localObject).put("uin", MsfCore.sCore.getAccountCenter().i());
        ((HashMap)localObject).put("msg", str);
        ((HashMap)localObject).put("sockImpl", paramString);
        ((HashMap)localObject).put("androidVer", String.valueOf(Build.VERSION.SDK_INT));
        a("msf_monitor_invalidSocket", true, 0L, 0L, (Map)localObject, false, false);
        return;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void b(boolean paramBoolean, long paramLong, String paramString)
  {
    int i1 = this.Q.sender.b.l().j();
    String str;
    if (i1 == 1) {
      str = "EvtConnV4";
    } else if (i1 == 2) {
      str = "EvtConnV6";
    } else {
      str = "EvtConn";
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("address", paramString);
    localHashMap.put("connCost", String.valueOf(paramLong));
    localHashMap.put("supportIpfamily", String.valueOf(NetConnInfoCenter.getActiveNetIpFamily(false)));
    if (MsfService.getCore().getStatReporter() != null) {
      MsfService.getCore().getStatReporter().a(str, paramBoolean, 0L, 0L, localHashMap, false, false);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    Object localObject = this.Q;
    if ((localObject != null) && (((MsfCore)localObject).sender != null) && (this.Q.sender.b != null))
    {
      int i1 = this.Q.sender.b.l().j();
      int i2 = NetConnInfoCenter.getActiveNetIpFamily(false);
      HashMap localHashMap = new HashMap();
      localHashMap.put("activeIpfamily", String.valueOf(i2));
      if (i1 == 1) {
        localObject = "EvtRegisterProxySuccV4";
      } else if (i1 == 2) {
        localObject = "EvtRegisterProxySuccV6";
      } else {
        localObject = "EvtRegisterProxySucc";
      }
      if (MsfService.getCore().getStatReporter() != null) {
        MsfService.getCore().getStatReporter().a((String)localObject, paramBoolean, 0L, 0L, localHashMap, false, false);
      }
    }
  }
  
  public final boolean c()
  {
    return V.get();
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.Q != null)
    {
      HashMap localHashMap = new HashMap();
      if (MsfService.getCore().getStatReporter() != null) {
        MsfService.getCore().getStatReporter().a("EvtDeepSleep", paramBoolean, 0L, 0L, localHashMap, false, false);
      }
    }
  }
  
  public final boolean d()
  {
    return W.get();
  }
  
  public void e()
  {
    if (W.get()) {
      return;
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = new l(this);
    try
    {
      localObject2 = new CrashStrategyBean();
      ((CrashStrategyBean)localObject2).setUploadSpotCrash(false);
      ((CrashStrategyBean)localObject2).setMaxStackFrame(6);
      CrashReport.initCrashReport(BaseApplication.getContext(), (CrashHandleListener)localObject1, null, false, (CrashStrategyBean)localObject2);
      localObject1 = BaseApplication.getContext().getDir("tombs", 0).getAbsolutePath();
      CrashReport.initNativeCrashReport(BaseApplication.getContext(), (String)localObject1, true);
      CrashReport.filterSysLog(true, true);
      W.set(true);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("init RQD finished, cost=");
        ((StringBuilder)localObject1).append(System.currentTimeMillis() - l1);
        QLog.d("MSF.C.StatReport", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = this.al;
      ((StringBuilder)localObject1).append("\nCurrent process id=");
      ((StringBuilder)localObject1).append(Process.myPid());
    }
    catch (Throwable localThrowable)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("init RQD error ");
      ((StringBuilder)localObject2).append(localThrowable);
      QLog.w("MSF.C.StatReport", 1, ((StringBuilder)localObject2).toString(), localThrowable);
    }
    BaseApplication.getContext().getMSFInterfaceAdapter().clearStartupPatchFailCount();
  }
  
  public void e(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if (MsfService.getCore().getStatReporter() != null) {
      MsfService.getCore().getStatReporter().a("msf_send_can_retry_msg", paramBoolean, 0L, 0L, localHashMap, false, false);
    }
  }
  
  public void f()
  {
    long l1;
    boolean bool;
    if (!V.get())
    {
      ag = com.tencent.mobileqq.msf.core.a.a.m();
      try
      {
        SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("msf_crashcontrol", 0);
        if ((localSharedPreferences != null) && (localSharedPreferences.getBoolean("shouldStopMsf", false)))
        {
          a("actMsfStopMsf", true, 0L, 0L, null, true, false);
          localSharedPreferences.edit().putBoolean("shouldStopMsf", false).commit();
        }
      }
      catch (Throwable localThrowable)
      {
        break label196;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      l1 = System.currentTimeMillis();
      BaseApplication.getContext().startBeacon();
      ANRReport.stopANRMonitor();
      X.start();
      V.set(true);
      if (o.k != 0) {
        break label236;
      }
      bool = false;
    }
    for (;;)
    {
      a("dim.Msf.IMEIReading", bool, o.k, 0L, null, false, false);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("init beacon finished, cost=");
        localStringBuilder1.append(System.currentTimeMillis() - l1);
        QLog.d("MSF.C.StatReport", 2, localStringBuilder1.toString());
        return;
        label196:
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("init beacon error ");
        localStringBuilder2.append(localStringBuilder1);
        QLog.w("MSF.C.StatReport", 1, localStringBuilder2.toString(), localStringBuilder1);
      }
      return;
      label236:
      bool = true;
    }
  }
  
  String g()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
    if (localNetworkInfo != null)
    {
      int i4 = (byte)localNetworkInfo.isAvailable();
      boolean bool = localNetworkInfo.isConnected();
      int i3 = 0;
      int i2 = 0;
      if (bool) {
        i1 = 2;
      } else {
        i1 = 0;
      }
      int i5 = (byte)i1;
      int i1 = i3;
      if (NetConnInfoCenter.isMobileNetworkInfo(localNetworkInfo))
      {
        i1 = i2;
        if (((TelephonyManager)BaseApplication.getContext().getSystemService("phone")).getDataState() == 2) {
          i1 = 4;
        }
        i1 = (byte)i1;
      }
      return String.valueOf((byte)(i5 | i4 | i1));
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
    MsfCore localMsfCore = this.Q;
    if ((localMsfCore != null) && (localMsfCore.sender != null) && (this.Q.sender.b != null)) {
      a(this.Q.sender.b.l().l(), this.Q.sender.b.l().k(), this.Q.sender.b.l().j());
    }
  }
  
  public void l()
  {
    HashMap localHashMap = new HashMap();
    if (MsfService.getCore().getStatReporter() != null) {
      MsfService.getCore().getStatReporter().a("msf_close_socket_by_deep_sleep", true, 0L, 0L, localHashMap, false, false);
    }
  }
  
  public void m()
  {
    HashMap localHashMap = new HashMap();
    if (MsfService.getCore().getStatReporter() != null) {
      MsfService.getCore().getStatReporter().a("msf_enable_retry_by_deep_sleep", true, 0L, 0L, localHashMap, false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.j
 * JD-Core Version:    0.7.0.1
 */