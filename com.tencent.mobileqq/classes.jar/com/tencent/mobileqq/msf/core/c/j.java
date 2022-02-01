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
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.feedback.anr.ANRReport;
import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.feedback.eup.CrashStrategyBean;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.ac;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.msf.core.i;
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
import java.util.List;
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
  static HashSet R = null;
  public static volatile boolean S = false;
  static long T = 0L;
  static long U = 0L;
  static AtomicBoolean V;
  static AtomicBoolean W;
  static Thread X = new k("MsfCheckDeepSleepThread");
  static final String a = "MSF.C.StatReport";
  private static LinkedBlockingQueue ac = new LinkedBlockingQueue(100);
  private static ConcurrentHashMap ad = new ConcurrentHashMap();
  private static long ae = 3600000L;
  private static final int af = 5000;
  private static final Object ag;
  private static final Object ah;
  private static SimpleDateFormat ak = new SimpleDateFormat("MM.dd HH:mm:ss.SSS");
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
  private j.b ai = new j.b();
  private StringBuilder aj = new StringBuilder("\nMsf Crash Control info:\n");
  
  static
  {
    S = false;
    T = 0L;
    U = 0L;
    V = new AtomicBoolean(false);
    W = new AtomicBoolean(false);
    ag = new Object();
    ah = new Object();
  }
  
  public j(MsfCore paramMsfCore)
  {
    this.Q = paramMsfCore;
  }
  
  public static byte a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    int i2 = 0;
    int i3;
    label26:
    int i4;
    if (r())
    {
      i1 = 1;
      i3 = (byte)i1;
      if (!q()) {
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
          Iterator localIterator = ad.entrySet().iterator();
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
      if (s()) {
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
    Iterator localIterator = ad.entrySet().iterator();
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
    Map localMap;
    for (;;)
    {
      if (!ac.isEmpty())
      {
        RdmReq localRdmReq;
        StringBuilder localStringBuilder;
        long l1;
        long l2;
        label70:
        int i1;
        try
        {
          localRdmReq = (RdmReq)ac.take();
          if (localRdmReq != null)
          {
            localStringBuilder = new StringBuilder();
            localMap = localRdmReq.params;
            if (localMap != null) {
              l1 = SystemClock.elapsedRealtime();
            }
          }
        }
        catch (Exception localException) {}
      }
    }
    try
    {
      l2 = Long.parseLong((String)localMap.get("param_reportTime"));
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label70;
    }
    l2 = l1 - localRdmReq.elapse;
    i1 = a(paramBoolean, l2, l1);
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
    if (TextUtils.isEmpty(localException.appKey)) {
      UserAction.onUserAction(localException.eventName, localException.isSucceed, localException.elapse, localException.size, localMap, localException.isRealTime, localException.isImmediatelyUpload);
    }
    while (QLog.isColorLevel())
    {
      QLog.d("MSF.C.StatReport", 2, "report RQD IMEI:" + o.d() + " " + localException.toString());
      break;
      UserAction.onUserActionToTunnel(localException.appKey, localException.eventName, localException.isSucceed, localException.elapse, localException.size, localMap, localException.isRealTime, localException.isImmediatelyUpload);
    }
    synchronized (ah)
    {
      ah.notifyAll();
      return;
    }
  }
  
  private static boolean q()
  {
    return !MsfSdkUtils.isTopActivity(BaseApplication.getContext());
  }
  
  private static boolean r()
  {
    return !MsfSdkUtils.isScreenOn(BaseApplication.getContext());
  }
  
  private static boolean s()
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
      this.ai.a = ((JSONObject)localObject).getBoolean("control_switch");
      this.ai.b = ((JSONObject)localObject).getInt("control_window");
      this.ai.c = ((JSONObject)localObject).getInt("control_freq");
      localObject = this.aj.append("initCrashControl");
      ((StringBuilder)localObject).append(",controlJson=").append(str);
      ((StringBuilder)localObject).append(",switch=").append(this.ai.a);
      ((StringBuilder)localObject).append(",window=").append(this.ai.b);
      ((StringBuilder)localObject).append(",Freq=").append(this.ai.c);
      ((StringBuilder)localObject).append("\n");
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        this.ai.a();
        QLog.d("MSF.C.StatReport", 1, "initCrashControl parse json throws an exception, so reset.");
      }
    }
  }
  
  public void a(long paramLong)
  {
    int i1 = this.Q.sender.b.l().j();
    String str = "msf_send_msg";
    if (i1 == 1) {
      str = "msf_IPv4_send_msg";
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      if (MsfService.getCore().getStatReporter() != null) {
        MsfService.getCore().getStatReporter().a(str, true, paramLong, 0L, localHashMap, false, false);
      }
      return;
      if (i1 == 2) {
        str = "msf_IPv6_send_msg";
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
      String str = String.valueOf(System.currentTimeMillis() + "_" + paramString1 + "_" + paramString2 + " " + paramString3 + "_" + paramString4);
      HashMap localHashMap = new HashMap();
      localHashMap.put("uin", String.valueOf(paramString1));
      localHashMap.put("type", String.valueOf(paramString3));
      localHashMap.put("msg", String.valueOf(str));
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
  
  /* Error */
  public void a(String arg1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, Map paramMap, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 770	com/tencent/mobileqq/msf/core/c/j:c	()Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: getstatic 184	com/tencent/mobileqq/msf/core/c/j:S	Z
    //   11: ifeq +11 -> 22
    //   14: iconst_0
    //   15: putstatic 184	com/tencent/mobileqq/msf/core/c/j:S	Z
    //   18: aload_0
    //   19: invokevirtual 772	com/tencent/mobileqq/msf/core/c/j:h	()V
    //   22: getstatic 774	com/tencent/mobileqq/msf/core/a/a:s	Ljava/util/HashSet;
    //   25: aload_2
    //   26: invokevirtual 780	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   29: ifeq +36 -> 65
    //   32: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq -28 -> 7
    //   38: ldc 63
    //   40: iconst_2
    //   41: new 229	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 285	java/lang/StringBuilder:<init>	()V
    //   48: aload_2
    //   49: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc_w 782
    //   55: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: return
    //   65: aload 8
    //   67: ifnull +254 -> 321
    //   70: iload_3
    //   71: ifne +62 -> 133
    //   74: aload_0
    //   75: getfield 240	com/tencent/mobileqq/msf/core/c/j:Q	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   78: ifnull +55 -> 133
    //   81: aload_0
    //   82: getfield 240	com/tencent/mobileqq/msf/core/c/j:Q	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   85: getfield 596	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ac;
    //   88: ifnull +45 -> 133
    //   91: aload_0
    //   92: getfield 240	com/tencent/mobileqq/msf/core/c/j:Q	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   95: getfield 596	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ac;
    //   98: getfield 601	com/tencent/mobileqq/msf/core/ac:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   101: ifnull +32 -> 133
    //   104: aload 8
    //   106: ldc 132
    //   108: aload_0
    //   109: getfield 240	com/tencent/mobileqq/msf/core/c/j:Q	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   112: getfield 596	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ac;
    //   115: getfield 601	com/tencent/mobileqq/msf/core/ac:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   118: invokevirtual 606	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
    //   121: invokevirtual 783	com/tencent/mobileqq/msf/core/net/m:c	()Z
    //   124: invokestatic 473	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   127: invokeinterface 430 3 0
    //   132: pop
    //   133: aload 8
    //   135: ldc_w 785
    //   138: invokestatic 787	com/tencent/mobileqq/msf/core/o:l	()Ljava/lang/String;
    //   141: invokeinterface 430 3 0
    //   146: pop
    //   147: invokestatic 693	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getSystemNetworkType	()I
    //   150: istore 12
    //   152: aload 8
    //   154: ldc_w 789
    //   157: iload 12
    //   159: invokestatic 374	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   162: invokeinterface 430 3 0
    //   167: pop
    //   168: aload 8
    //   170: getstatic 703	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   173: invokeinterface 792 2 0
    //   178: ifeq +345 -> 523
    //   181: aload 8
    //   183: getstatic 703	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   186: invokeinterface 438 2 0
    //   191: pop
    //   192: aload 8
    //   194: ldc 147
    //   196: getstatic 794	com/tencent/mobileqq/msf/core/ac:E	Ljava/lang/String;
    //   199: invokeinterface 430 3 0
    //   204: pop
    //   205: aload 8
    //   207: ldc_w 796
    //   210: invokestatic 798	com/tencent/mobileqq/msf/core/ac:q	()Ljava/lang/String;
    //   213: invokeinterface 430 3 0
    //   218: pop
    //   219: aload 8
    //   221: ldc 20
    //   223: invokeinterface 792 2 0
    //   228: ifne +19 -> 247
    //   231: aload 8
    //   233: ldc 20
    //   235: invokestatic 414	android/os/SystemClock:elapsedRealtime	()J
    //   238: invokestatic 435	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   241: invokeinterface 430 3 0
    //   246: pop
    //   247: aload_0
    //   248: getfield 240	com/tencent/mobileqq/msf/core/c/j:Q	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   251: invokevirtual 802	com/tencent/mobileqq/msf/core/MsfCore:getSsoListManager	()Lcom/tencent/mobileqq/msf/core/a/c;
    //   254: invokevirtual 806	com/tencent/mobileqq/msf/core/a/c:d	()Z
    //   257: istore 13
    //   259: aload_0
    //   260: getfield 240	com/tencent/mobileqq/msf/core/c/j:Q	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   263: getfield 596	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ac;
    //   266: getfield 601	com/tencent/mobileqq/msf/core/ac:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   269: invokevirtual 807	com/tencent/mobileqq/msf/core/net/n:f	()I
    //   272: istore 12
    //   274: iload 13
    //   276: ifeq +268 -> 544
    //   279: iconst_1
    //   280: invokestatic 374	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   283: astore 14
    //   285: aload 8
    //   287: ldc 32
    //   289: aload 14
    //   291: invokeinterface 430 3 0
    //   296: pop
    //   297: iload 12
    //   299: iconst_2
    //   300: if_icmpne +253 -> 553
    //   303: iconst_1
    //   304: invokestatic 374	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   307: astore 14
    //   309: aload 8
    //   311: ldc 39
    //   313: aload 14
    //   315: invokeinterface 430 3 0
    //   320: pop
    //   321: new 405	com/tencent/mobileqq/msf/sdk/RdmReq
    //   324: dup
    //   325: invokespecial 808	com/tencent/mobileqq/msf/sdk/RdmReq:<init>	()V
    //   328: astore 14
    //   330: aload 14
    //   332: aload_2
    //   333: putfield 455	com/tencent/mobileqq/msf/sdk/RdmReq:eventName	Ljava/lang/String;
    //   336: aload 14
    //   338: lload 4
    //   340: putfield 427	com/tencent/mobileqq/msf/sdk/RdmReq:elapse	J
    //   343: aload 14
    //   345: lload 6
    //   347: putfield 478	com/tencent/mobileqq/msf/sdk/RdmReq:size	J
    //   350: aload 14
    //   352: iload_3
    //   353: putfield 470	com/tencent/mobileqq/msf/sdk/RdmReq:isSucceed	Z
    //   356: aload 14
    //   358: iload 9
    //   360: putfield 481	com/tencent/mobileqq/msf/sdk/RdmReq:isRealTime	Z
    //   363: aload 14
    //   365: iload 11
    //   367: putfield 811	com/tencent/mobileqq/msf/sdk/RdmReq:isMerge	Z
    //   370: aload 14
    //   372: aload 8
    //   374: putfield 409	com/tencent/mobileqq/msf/sdk/RdmReq:params	Ljava/util/Map;
    //   377: aload 14
    //   379: aload_1
    //   380: putfield 490	com/tencent/mobileqq/msf/sdk/RdmReq:appKey	Ljava/lang/String;
    //   383: aload 14
    //   385: iload 10
    //   387: putfield 498	com/tencent/mobileqq/msf/sdk/RdmReq:isImmediatelyUpload	Z
    //   390: getstatic 172	com/tencent/mobileqq/msf/core/c/j:ac	Ljava/util/concurrent/LinkedBlockingQueue;
    //   393: aload 14
    //   395: invokevirtual 814	java/util/concurrent/LinkedBlockingQueue:offer	(Ljava/lang/Object;)Z
    //   398: ifne -391 -> 7
    //   401: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   404: ifeq +12 -> 416
    //   407: ldc 63
    //   409: iconst_2
    //   410: ldc_w 816
    //   413: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   416: getstatic 200	com/tencent/mobileqq/msf/core/c/j:ag	Ljava/lang/Object;
    //   419: astore_1
    //   420: aload_1
    //   421: monitorenter
    //   422: getstatic 200	com/tencent/mobileqq/msf/core/c/j:ag	Ljava/lang/Object;
    //   425: invokevirtual 517	java/lang/Object:notifyAll	()V
    //   428: aload_1
    //   429: monitorexit
    //   430: invokestatic 822	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   433: invokestatic 825	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   436: if_acmpeq -429 -> 7
    //   439: getstatic 202	com/tencent/mobileqq/msf/core/c/j:ah	Ljava/lang/Object;
    //   442: astore_1
    //   443: aload_1
    //   444: monitorenter
    //   445: getstatic 202	com/tencent/mobileqq/msf/core/c/j:ah	Ljava/lang/Object;
    //   448: ldc2_w 826
    //   451: invokevirtual 830	java/lang/Object:wait	(J)V
    //   454: getstatic 172	com/tencent/mobileqq/msf/core/c/j:ac	Ljava/util/concurrent/LinkedBlockingQueue;
    //   457: aload 14
    //   459: invokevirtual 814	java/util/concurrent/LinkedBlockingQueue:offer	(Ljava/lang/Object;)Z
    //   462: ifne +18 -> 480
    //   465: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   468: ifeq +12 -> 480
    //   471: ldc 63
    //   473: iconst_2
    //   474: ldc_w 832
    //   477: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   480: aload_1
    //   481: monitorexit
    //   482: return
    //   483: astore_2
    //   484: aload_1
    //   485: monitorexit
    //   486: aload_2
    //   487: athrow
    //   488: astore_1
    //   489: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   492: ifeq -485 -> 7
    //   495: ldc 63
    //   497: iconst_2
    //   498: new 229	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 285	java/lang/StringBuilder:<init>	()V
    //   505: ldc_w 447
    //   508: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_1
    //   512: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: aload_1
    //   519: invokestatic 450	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   522: return
    //   523: iload 12
    //   525: ifne -333 -> 192
    //   528: aload 8
    //   530: ldc 144
    //   532: ldc_w 834
    //   535: invokeinterface 430 3 0
    //   540: pop
    //   541: goto -349 -> 192
    //   544: iconst_0
    //   545: invokestatic 374	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   548: astore 14
    //   550: goto -265 -> 285
    //   553: iconst_0
    //   554: invokestatic 374	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   557: astore 14
    //   559: goto -250 -> 309
    //   562: astore_2
    //   563: aload_1
    //   564: monitorexit
    //   565: aload_2
    //   566: athrow
    //   567: astore_2
    //   568: aload_2
    //   569: invokevirtual 835	java/lang/InterruptedException:printStackTrace	()V
    //   572: goto -118 -> 454
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	575	0	this	j
    //   0	575	2	paramString2	String
    //   0	575	3	paramBoolean1	boolean
    //   0	575	4	paramLong1	long
    //   0	575	6	paramLong2	long
    //   0	575	8	paramMap	Map
    //   0	575	9	paramBoolean2	boolean
    //   0	575	10	paramBoolean3	boolean
    //   0	575	11	paramBoolean4	boolean
    //   150	374	12	i1	int
    //   257	18	13	bool	boolean
    //   283	275	14	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   445	454	483	finally
    //   454	480	483	finally
    //   480	482	483	finally
    //   484	486	483	finally
    //   568	572	483	finally
    //   74	133	488	java/lang/Exception
    //   133	192	488	java/lang/Exception
    //   192	247	488	java/lang/Exception
    //   247	274	488	java/lang/Exception
    //   279	285	488	java/lang/Exception
    //   285	297	488	java/lang/Exception
    //   303	309	488	java/lang/Exception
    //   309	321	488	java/lang/Exception
    //   321	416	488	java/lang/Exception
    //   416	422	488	java/lang/Exception
    //   430	445	488	java/lang/Exception
    //   486	488	488	java/lang/Exception
    //   528	541	488	java/lang/Exception
    //   544	550	488	java/lang/Exception
    //   565	567	488	java/lang/Exception
    //   422	430	562	finally
    //   563	565	562	finally
    //   445	454	567	java/lang/InterruptedException
  }
  
  public void a(String paramString, boolean paramBoolean, long paramLong1, int paramInt, long paramLong2)
  {
    if (NetConnInfoCenter.isWifiOrMobileConn())
    {
      if (R == null) {
        R = new HashSet();
      }
      if (!R.contains(paramString)) {}
    }
    else
    {
      return;
    }
    R.add(paramString);
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uin", paramString);
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    a("dim.Msf.UserGrayfail", paramBoolean, paramLong1, paramLong2, localHashMap, false, false);
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
      if (r()) {
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
    localHashMap.put("param_NowLocalIp", ac.F);
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
      if (r()) {
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
    if (r())
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
    label1138:
    do
    {
      do
      {
        do
        {
          return;
        } while (paramArrayList.size() <= 0);
        Object localObject1 = "" + this.Q.getMsfAppid();
        localObject1 = (String)localObject1 + "|1";
        localObject2 = com.tencent.mobileqq.msf.core.c.f(BaseApplication.getContext()) + "." + com.tencent.mobileqq.msf.core.c.e(BaseApplication.getContext());
        localObject1 = (String)localObject1 + "|" + (String)localObject2;
        localObject2 = (com.tencent.mobileqq.msf.core.net.a)paramArrayList.get(paramArrayList.size() - 1);
        localObject2 = (String)localObject1 + "|" + ((com.tencent.mobileqq.msf.core.net.a)localObject2).g;
        localObject1 = o.e();
        if ((localObject1 != null) && (((String)localObject1).length() >= 5))
        {
          localObject2 = (String)localObject2 + "|" + ((String)localObject1).substring(0, 3);
          localObject1 = (String)localObject2 + ":" + ((String)localObject1).substring(3, 5);
          localObject2 = o.i();
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
                    localObject1 = this.Q.getSsoListManager().f();
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
                  ((HashMap)localObject2).put("IPv6_from_server", String.valueOf(this.Q.getSsoListManager().d()));
                  if (paramLong3 == -1L) {
                    break label1138;
                  }
                  a("msf_connAndRecv", paramBoolean1, paramLong1 + paramLong3, 0L, (Map)localObject2, false, false);
                  paramInt = this.Q.sender.b.f();
                  if (paramInt != 1) {
                    break label1114;
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
      paramInt = this.Q.sender.b.f();
      if (paramInt == 1)
      {
        a("msf_connAndRecv_ipv4", paramBoolean1, paramLong1, 0L, (Map)localObject2, false, false);
        return;
      }
    } while (paramInt != 2);
    label1114:
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
      if (r())
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
            break label218;
          }
          paramFromServiceMsg = paramFromServiceMsg.getStringForLog();
          ((HashMap)localObject1).put("from", paramFromServiceMsg);
          if (paramToServiceMsg != null)
          {
            paramToServiceMsg = paramToServiceMsg.getStringForLog();
            ((HashMap)localObject1).put("to", paramToServiceMsg);
            if (MsfService.getCore().getStatReporter() == null) {
              break label217;
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
      label217:
      label218:
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
      localHashMap.put("param_GatewayIp", ac.q());
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
    if (!this.ai.a) {
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
    this.aj.append("doCrashControl startTime=").append(ak.format(new Date(l1))).append(",currenttime=").append(ak.format(new Date(l2))).append(",crashCount=").append(i1).append("\n");
    if ((l1 <= 0L) || (l2 <= l1) || (i1 < 0) || (l2 - l1 > this.ai.b * 1000))
    {
      i1 = 1;
      l1 = l2;
    }
    for (;;)
    {
      if (i1 > this.ai.c) {
        this.Z = true;
      }
      if (this.Z)
      {
        QLog.d("MSF.C.StatReport", 1, "doCrashControl crashCount=" + i1 + ",shouldStopMsf=" + this.Z);
        BaseApplication localBaseApplication = BaseApplication.getContext();
        localBaseApplication.stopService(new Intent(localBaseApplication, MsfService.class));
      }
      this.aj.append("doCrashControl shouldStopMsf=").append(this.Z).append("\n");
      localSharedPreferences.edit().putLong("starttime", l1).putInt("crashcount", i1).putBoolean("shouldStopMsf", this.Z).commit();
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
      paramToServiceMsg = str + "_" + String.valueOf(System.currentTimeMillis()) + "_" + u.b(paramToServiceMsg) + "_" + u.a(paramFromServiceMsg);
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
        str = str + "_" + String.valueOf(System.currentTimeMillis());
        HashMap localHashMap = new HashMap();
        localHashMap.put("uin", MsfCore.sCore.getAccountCenter().i());
        localHashMap.put("msg", str);
        localHashMap.put("sockImpl", paramString);
        localHashMap.put("androidVer", String.valueOf(Build.VERSION.SDK_INT));
        a("msf_monitor_invalidSocket", true, 0L, 0L, localHashMap, false, false);
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
    String str = "EvtConn";
    if (i1 == 1) {
      str = "EvtConnV4";
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("address", paramString);
      localHashMap.put("connCost", String.valueOf(paramLong));
      localHashMap.put("supportIpfamily", String.valueOf(NetConnInfoCenter.getActiveNetIpFamily(false)));
      if (MsfService.getCore().getStatReporter() != null) {
        MsfService.getCore().getStatReporter().a(str, paramBoolean, 0L, 0L, localHashMap, false, false);
      }
      return;
      if (i1 == 2) {
        str = "EvtConnV6";
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    int i1;
    HashMap localHashMap;
    String str;
    if ((this.Q != null) && (this.Q.sender != null) && (this.Q.sender.b != null))
    {
      i1 = this.Q.sender.b.l().j();
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
    Object localObject = new l(this);
    try
    {
      CrashStrategyBean localCrashStrategyBean = new CrashStrategyBean();
      localCrashStrategyBean.setUploadSpotCrash(false);
      localCrashStrategyBean.setMaxStackFrame(6);
      CrashReport.initCrashReport(BaseApplication.getContext(), (CrashHandleListener)localObject, null, false, localCrashStrategyBean);
      localObject = BaseApplication.getContext().getDir("tombs", 0).getAbsolutePath();
      CrashReport.initNativeCrashReport(BaseApplication.getContext(), (String)localObject, true);
      CrashReport.filterSysLog(true, true);
      W.set(true);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.StatReport", 2, "init RQD finished, cost=" + (System.currentTimeMillis() - l1));
      }
      this.aj.append("\nCurrent process id=").append(Process.myPid());
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.w("MSF.C.StatReport", 1, "init RQD error " + localThrowable, localThrowable);
      }
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
    if (!V.get()) {
      ae = com.tencent.mobileqq.msf.core.a.a.m();
    }
    try
    {
      localObject = BaseApplication.getContext().getSharedPreferences("msf_crashcontrol", 0);
      if ((localObject != null) && (((SharedPreferences)localObject).getBoolean("shouldStopMsf", false)))
      {
        a("actMsfStopMsf", true, 0L, 0L, null, true, false);
        ((SharedPreferences)localObject).edit().putBoolean("shouldStopMsf", false).commit();
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      Iterator localIterator;
      QLog.w("MSF.C.StatReport", 1, "init beacon error " + localThrowable, localThrowable);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break label270;
      }
      QLog.d("MSF.C.StatReport", 2, "registerTunnel, size = " + localException.size());
      ANRReport.stopANRMonitor();
      X.start();
      V.set(true);
      if (o.k != 0) {
        break label347;
      }
    }
    long l1 = System.currentTimeMillis();
    com.tencent.beacon.upload.UploadStrategy.DEFAULT_SENSOR_ENABLE = false;
    UserAction.initUserAction(BaseApplication.getContext(), true, 1200L);
    localObject = BaseApplication.getContext().getAppData("channel_id");
    if ((localObject != null) && ((localObject instanceof String))) {
      UserAction.setChannelID((String)localObject);
    }
    UserAction.closeUseInfoEvent();
    UserAction.setAutoLaunchEventUsable(true);
    if (i.a().f())
    {
      localObject = BaseApplication.getContext().getRegisterBeaconTunnel();
      localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext()) {
        UserAction.registerTunnel((TunnelInfo)localIterator.next());
      }
    }
    label270:
    label347:
    for (boolean bool = false;; bool = true)
    {
      a("dim.Msf.IMEIReading", bool, o.k, 0L, null, false, false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MSF.C.StatReport", 2, "init beacon finished, cost=" + (System.currentTimeMillis() - l1));
      return;
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
    if ((this.Q != null) && (this.Q.sender != null) && (this.Q.sender.b != null)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.j
 * JD-Core Version:    0.7.0.1
 */