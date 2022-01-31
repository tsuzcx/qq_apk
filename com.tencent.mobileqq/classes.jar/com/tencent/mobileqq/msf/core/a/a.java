package com.tencent.mobileqq.msf.core.a;

import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.af;
import com.tencent.mobileqq.msf.core.auth.l;
import com.tencent.mobileqq.msf.core.quic.QuicWrapper;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.report.StrupBuff;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
{
  static AtomicBoolean A = new AtomicBoolean();
  public static final String B = "__loginSdk_iconf_Msf";
  static long C = 0L;
  static long D = 0L;
  static long E = 0L;
  static long F = 0L;
  public static final int G = 100;
  public static long H = 0L;
  public static long I = 0L;
  public static final int J = 1;
  public static final int K = 16;
  private static final byte[] M = { -16, 68, 31, 95, -12, 45, -91, -113, -36, -9, -108, -102, -70, 98, -44, 17 };
  public static final String a = "ConfigService.ClientReq";
  static final String b = "MSF.C.ConfigManager";
  public static final String c = "__loginSdk_iconf_UserConf";
  public static final String d = "__loginSdk_iconf_AppConf";
  public static final String e = "__loginSdk_iconf_UserCommCon";
  public static final String f = "__loginSdk_mobilessotime";
  public static final String g = "__loginSdk_wifissotime";
  public static final String h = "__loginSdk_checkmobilessotime";
  public static final String i = "__loginSdk_checkwifissotime";
  public static final String j = "_msf_isBootingKey";
  public static final int k = 32;
  public static final String l = "__loginSdk_iConfAppidTimeKey";
  public static final String m = "__loginSdk_iConfSdkLastTimeKey";
  public static final String n = "__loginSdk_iConfGetEspLastTimeKe";
  public static final String o = "__msf_isAutoBootKey";
  public static final boolean p = true;
  static ConcurrentHashMap q = new ConcurrentHashMap();
  public static HashSet r = new HashSet();
  public static HashSet s = new HashSet();
  public static boolean t = true;
  public static boolean u = true;
  public static boolean v = true;
  public static int w;
  public static int x;
  public static boolean y = true;
  public CopyOnWriteArrayList L = new CopyOnWriteArrayList();
  MsfCore z;
  
  public a(MsfCore paramMsfCore)
  {
    this.z = paramMsfCore;
  }
  
  public static long A()
  {
    try
    {
      if (q.containsKey("msf_connFastDetectDelay"))
      {
        long l1 = Long.parseLong((String)q.get("msf_connFastDetectDelay"));
        return l1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getConnFastDetectDelay error" + localException);
      }
    }
    return 2000L;
  }
  
  public static long B()
  {
    try
    {
      if (q.containsKey("msf_connFastDetectTimeout"))
      {
        long l1 = Long.parseLong((String)q.get("msf_connFastDetectTimeout"));
        return l1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getConnFastDetectTimeout error" + localException);
      }
    }
    return 10000L;
  }
  
  public static long C()
  {
    try
    {
      if (q.containsKey("msf_autoReconnInterval"))
      {
        long l1 = Long.parseLong((String)q.get("msf_autoReconnInterval"));
        return l1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getAutoReconnInterval error" + localException);
      }
    }
    return 0L;
  }
  
  public static long D()
  {
    try
    {
      if (q.containsKey("msf_checkChangeTokenInterval"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_checkChangeTokenInterval"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getCheckChangeTokenInterval error" + localException);
      }
    }
    return 1800000L;
  }
  
  public static long E()
  {
    try
    {
      if (q.containsKey("msf_ChangeTokenRequestInterval"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_ChangeTokenRequestInterval"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getChangeTokenRequestInterval error" + localException);
      }
    }
    return 1000L;
  }
  
  public static long F()
  {
    try
    {
      if (q.containsKey("msf_quickHeartBeatTimeout"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_quickHeartBeatTimeout"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getHeartBeatTimeout error" + localException);
      }
    }
    return 10000L;
  }
  
  public static long G()
  {
    try
    {
      if (q.containsKey("msf_getQuickHeartBeatReConnInterval"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_getQuickHeartBeatReConnInterval"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getQuickHeartBeatReConnInterval error" + localException);
      }
    }
    return 120000L;
  }
  
  public static int H()
  {
    try
    {
      if (q.containsKey("msf_heartBeatRetrycount"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_heartBeatRetrycount"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getHeartBeatRetryCount error" + localException);
      }
    }
    return 1;
  }
  
  public static int I()
  {
    try
    {
      if (q.containsKey("msf_busPacketTimeoutMaxNum"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_busPacketTimeoutMaxNum"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getBusPacketTimeoutMaxNum error" + localException);
      }
    }
    return 10;
  }
  
  public static long J()
  {
    try
    {
      if (q.containsKey("msf_busCheckServerTimeInterval"))
      {
        long l1 = Long.parseLong((String)q.get("msf_busCheckServerTimeInterval"));
        return l1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getBusPacketTimeoutMaxNum error" + localException);
      }
    }
    return 5000L;
  }
  
  public static long K()
  {
    try
    {
      if (q.containsKey("msf_checkUpdateServerTimeInterval"))
      {
        long l1 = Long.parseLong((String)q.get("msf_checkUpdateServerTimeInterval"));
        return l1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getUpdateServerTimePacketTimeoutMaxNum error" + localException);
      }
    }
    return 72000000L;
  }
  
  public static long L()
  {
    try
    {
      if (q.containsKey("msf_checkUpdateServerTimeExtraInterval"))
      {
        long l1 = Long.parseLong((String)q.get("msf_checkUpdateServerTimeExtraInterval"));
        return l1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getUpdateServerTimePacketTimeoutExtraInterval error" + localException);
      }
    }
    return 7200000L;
  }
  
  public static long M()
  {
    try
    {
      if (q.containsKey("msf_checkServerTimeCompareInterval"))
      {
        long l1 = Long.parseLong((String)q.get("msf_checkServerTimeCompareInterval"));
        return l1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getCheckServerTimeCompareInterval error" + localException);
      }
    }
    return 7200000L;
  }
  
  public static int N()
  {
    try
    {
      if (q.containsKey("msf_heartBeatTimeInterval"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "msf_heartBeatTimeInterval = " + (String)q.get("msf_heartBeatTimeInterval"));
        }
        int i1 = Integer.parseInt((String)q.get("msf_heartBeatTimeInterval"));
        return i1 * 60 * 1000;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.ConfigManager", 4, "getHeartBeatTimeInterval error" + localException);
      }
    }
    return 60000;
  }
  
  public static int O()
  {
    try
    {
      if (q.containsKey("msf_preHeartBeatTimeInterval"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "msf_preHeartBeatTimeInterval = " + (String)q.get("msf_preHeartBeatTimeInterval"));
        }
        int i1 = Integer.parseInt((String)q.get("msf_preHeartBeatTimeInterval"));
        return i1 * 1000;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.ConfigManager", 4, "getPreHeartBeatTimeInterval error" + localException);
      }
    }
    return 10000;
  }
  
  public static boolean P()
  {
    try
    {
      if (q.containsKey("msf_updatehbtimeSwtich"))
      {
        boolean bool = Boolean.parseBoolean((String)q.get("msf_updateHBTimeSwtich"));
        return bool;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getUpdateHBTimeSwtich error" + localException);
      }
    }
    return false;
  }
  
  public static int Q()
  {
    try
    {
      if (q.containsKey("msf_netIdleTimeInterval"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "msf_netIdleTimeInterval = " + (String)q.get("msf_netIdleTimeInterval"));
        }
        int i1 = Integer.parseInt((String)q.get("msf_netIdleTimeInterval"));
        return i1 * 60 * 1000;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.ConfigManager", 4, "getNetIdleTimeInterval error" + localException);
      }
    }
    return 1680000;
  }
  
  public static String R()
  {
    try
    {
      if (q.containsKey("TcpdumpSSOVip_new"))
      {
        String str = (String)q.get("TcpdumpSSOVip_new");
        return str;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getTcpdumpSSOVip error" + localException);
      }
    }
    return null;
  }
  
  public static int S()
  {
    try
    {
      if (q.containsKey("TcpdumpSSOTime"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "TcpdumpSSOTime = " + (String)q.get("TcpdumpSSOTime"));
        }
        int i1 = Integer.parseInt((String)q.get("TcpdumpSSOTime"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.ConfigManager", 4, "getTcpdumpSSOTime error" + localException);
      }
    }
    return 0;
  }
  
  public static int T()
  {
    try
    {
      if (q.containsKey("msf_netWeakTimeInterval"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "msf_netWeakTimeInterval = " + (String)q.get("msf_netWeakTimeInterval"));
        }
        int i1 = Integer.parseInt((String)q.get("msf_netWeakTimeInterval"));
        return i1 * 60 * 1000;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.ConfigManager", 4, "getNetWeakTimeInterval error" + localException);
      }
    }
    return 180000;
  }
  
  public static int U()
  {
    try
    {
      if (q.containsKey("msf_pcactiveretrytimes"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "msf_pcactiveretrytimes = " + (String)q.get("msf_pcactiveretrytimes"));
        }
        int i1 = Integer.parseInt((String)q.get("msf_pcactiveretrytimes"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.ConfigManager", 4, "msf_pcactiveretrytimes error" + localException);
      }
    }
    return 10;
  }
  
  public static int V()
  {
    try
    {
      if (q.containsKey("msf_netWeakExceptionCount"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "msf_netWeakExceptionCount = " + (String)q.get("msf_netWeakExceptionCount"));
        }
        int i1 = Integer.parseInt((String)q.get("msf_netWeakExceptionCount"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.ConfigManager", 4, "getNetWeakExceptionCount error" + localException);
      }
    }
    return 3;
  }
  
  public static long W()
  {
    if (q.containsKey("msf_CallQQIntervTimeOnBoot")) {
      try
      {
        long l1 = Long.parseLong(((String)q.get("msf_CallQQIntervTimeOnBoot")).trim());
        return l1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, " get CallQQIntervTimeOnBoot error " + localNumberFormatException);
        }
      }
    }
    return 0L;
  }
  
  public static String X()
  {
    if (q.containsKey("bigflow2g3g_ver2")) {
      return (String)q.get("bigflow2g3g_ver2");
    }
    return "40";
  }
  
  public static boolean Y()
  {
    if (q.containsKey("msf_StartNoStickyForMSFService")) {
      try
      {
        boolean bool = Boolean.parseBoolean(((String)q.get("msf_StartNoStickyForMSFService")).trim());
        return bool;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, " set msf_StartNoStickyForMSFService error " + localException);
        }
        return false;
      }
    }
    return false;
  }
  
  public static boolean Z()
  {
    if (q.containsKey("msf_quickSendAvailable")) {
      try
      {
        boolean bool = Boolean.parseBoolean(((String)q.get("msf_quickSendAvailable")).trim());
        return bool;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, " set isPermitQuickTimeoutCheck error " + localException);
        }
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  public static void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +29 -> 35
    //   9: ldc 34
    //   11: iconst_2
    //   12: new 175	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 363
    //   22: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: iload_0
    //   26: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: getstatic 118	com/tencent/mobileqq/msf/core/a/a:A	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   38: iload_0
    //   39: invokevirtual 369	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   42: invokestatic 375	com/tencent/mobileqq/msf/core/MsfStore:getNativeConfigStore	()Lcom/tencent/msf/boot/config/NativeConfigStore;
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +15 -> 62
    //   50: invokestatic 375	com/tencent/mobileqq/msf/core/MsfStore:getNativeConfigStore	()Lcom/tencent/msf/boot/config/NativeConfigStore;
    //   53: ldc 58
    //   55: iload_0
    //   56: invokestatic 379	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   59: invokevirtual 385	com/tencent/msf/boot/config/NativeConfigStore:setConfig	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   65: ifeq +29 -> 94
    //   68: ldc 34
    //   70: iconst_2
    //   71: new 175	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   78: ldc_w 387
    //   81: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: iload_0
    //   85: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   88: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: ldc 2
    //   96: monitorexit
    //   97: return
    //   98: astore_1
    //   99: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq -40 -> 62
    //   105: ldc 34
    //   107: iconst_2
    //   108: ldc_w 389
    //   111: aload_1
    //   112: invokestatic 392	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   115: goto -53 -> 62
    //   118: astore_1
    //   119: ldc 2
    //   121: monitorexit
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramBoolean	boolean
    //   45	2	1	localNativeConfigStore	NativeConfigStore
    //   98	14	1	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   118	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   50	62	98	java/lang/UnsatisfiedLinkError
    //   3	35	118	finally
    //   35	46	118	finally
    //   50	62	118	finally
    //   62	94	118	finally
    //   99	115	118	finally
  }
  
  public static boolean a(String paramString)
  {
    if (q.containsKey(paramString + "_isAutoBoot")) {
      try
      {
        boolean bool = Boolean.parseBoolean(((String)q.get(paramString + "_isAutoBoot")).trim());
        return bool;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, paramString + " set isAutoBoot error " + localException);
        }
        return false;
      }
    }
    return true;
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      c.a(new ByteArrayInputStream(("<" + paramString1 + ">" + paramString2 + "</" + paramString1 + ">").getBytes("UTF-8")), q, paramString3);
      return true;
    }
    catch (Exception paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "parse " + paramString1 + "Config error " + paramString2, paramString2);
      }
    }
    return false;
  }
  
  public static int aA()
  {
    if (q.containsKey("msf_StandbyTestSeq")) {
      try
      {
        int i1 = Integer.parseInt(((String)q.get("msf_StandbyTestSeq")).trim());
        return i1;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, " set getStandbyTestSeq error " + localException);
        }
      }
    }
    return 0;
  }
  
  public static long aB()
  {
    try
    {
      if (q.containsKey("msf_tcpDumpTime"))
      {
        long l1 = Long.parseLong((String)q.get("msf_tcpDumpTime"));
        return l1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getTcpDumpTime error" + localException);
      }
    }
    return 600000L;
  }
  
  public static int aC()
  {
    if (q.containsKey("msf_RetryStartProcTimes")) {
      try
      {
        int i1 = Integer.parseInt(((String)q.get("msf_RetryStartProcTimes")).trim());
        return i1;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, " set getRetryStartProcessTimes error " + localException);
        }
      }
    }
    return 100;
  }
  
  public static int aD()
  {
    try
    {
      if (q.containsKey("msf_continueConnInterval"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_continueConnInterval"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getContinueConnInterval error" + localException);
      }
    }
    return 1000;
  }
  
  public static int aE()
  {
    try
    {
      if (q.containsKey("msf_quickSendFastInterval"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_quickSendFastInterval"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getQuickSendFastInterval error" + localException);
      }
    }
    return 15000;
  }
  
  public static int aF()
  {
    try
    {
      if (q.containsKey("msf_quickSendFastTimes"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_quickSendFastTimes"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getQuickSendFastTimes error" + localException);
      }
    }
    return 4;
  }
  
  public static boolean aG()
  {
    try
    {
      if (q.containsKey("msf_forceQuickSend1S"))
      {
        boolean bool = Boolean.parseBoolean((String)q.get("msf_forceQuickSend1S"));
        return bool;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getForceQuickSend1S error" + localException);
      }
    }
    return true;
  }
  
  public static boolean aH()
  {
    try
    {
      if (q.containsKey("msf_applySocketAdaptorFeature"))
      {
        boolean bool = Boolean.parseBoolean((String)q.get("msf_applySocketAdaptorFeature"));
        return bool;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "applySocketAdaptorFeature error" + localException);
      }
    }
    return false;
  }
  
  public static boolean aI()
  {
    try
    {
      if (q.containsKey("msf_innerSwitchForAdaptor"))
      {
        boolean bool = Boolean.parseBoolean((String)q.get("msf_innerSwitchForAdaptor"));
        return bool;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "innerSwitchForAdaptor error" + localException);
      }
    }
    return false;
  }
  
  public static int aJ()
  {
    try
    {
      if (q.containsKey("msf_timeoutPkgToResetMode"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_timeoutPkgToResetMode"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "timeoutPkgToResetMode error" + localException);
      }
    }
    return 100;
  }
  
  public static int aK()
  {
    try
    {
      if (q.containsKey("msf_ExptionCountToResetMode"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_ExptionCountToResetMode"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "ExptionCountToResetMode error" + localException);
      }
    }
    return 15;
  }
  
  public static long aL()
  {
    try
    {
      if (q.containsKey("msf_startHeartBeatProxyInterval"))
      {
        long l1 = Long.parseLong((String)q.get("msf_startHeartBeatProxyInterval"));
        return l1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "startHeartBeatProxyInterval error" + localException);
      }
    }
    return 60000L;
  }
  
  public static int aM()
  {
    try
    {
      if (q.containsKey("msf_ExptionCountToCloseHeartbeat"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_ExptionCountToCloseHeartbeat"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "ExptionCountToCloseHeartbeat error" + localException);
      }
    }
    return 50;
  }
  
  public static int aN()
  {
    try
    {
      if (q.containsKey("msf_ResumeCountLimit"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_ResumeCountLimit"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "ResumeCountLimit error" + localException);
      }
    }
    return 3;
  }
  
  public static long aO()
  {
    try
    {
      if (q.containsKey("msf_hwExceptionCheckInterval"))
      {
        long l1 = Long.parseLong((String)q.get("msf_hwExceptionCheckInterval"));
        return l1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "hwExceptionCheckInterval error" + localException);
      }
    }
    return 7200000L;
  }
  
  public static boolean aP()
  {
    try
    {
      if (q.containsKey("msf_applyHeartbeatProxyFeature"))
      {
        boolean bool = Boolean.parseBoolean((String)q.get("msf_applyHeartbeatProxyFeature"));
        return bool;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "applyHeartbeatProxyFeature error" + localException);
      }
    }
    return false;
  }
  
  public static int aQ()
  {
    try
    {
      if (q.containsKey("msf_retryHeartbeatTestCount"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_retryHeartbeatTestCount"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "retryHeartbeatTestCount error" + localException);
      }
    }
    return 5;
  }
  
  public static int aR()
  {
    try
    {
      if (q.containsKey("msf_SortIpSocketErrorWeight"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_SortIpSocketErrorWeight"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getSortIpSocketErrorWeight error" + localException);
      }
    }
    return 10;
  }
  
  public static int aS()
  {
    try
    {
      if (q.containsKey("msf_SortIpContinueRspTimeoutWeight"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_SortIpContinueRspTimeoutWeight"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getSortIpContinueRspTimeoutWeight error" + localException);
      }
    }
    return 10;
  }
  
  public static int aT()
  {
    try
    {
      if (q.containsKey("msf_SortIpPingTimeoutWeight"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_SortIpPingTimeoutWeight"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getSortIpPingTimeoutWeight error" + localException);
      }
    }
    return 10;
  }
  
  public static int aU()
  {
    try
    {
      if (q.containsKey("msf_SortIpNetDetectFailedWeight"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_SortIpNetDetectFailedWeight"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getSortIpNetDetectFailedWeight error" + localException);
      }
    }
    return 20;
  }
  
  public static int aV()
  {
    try
    {
      if (q.containsKey("msf_SortIpInvalidDataWeight"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_SortIpInvalidDataWeight"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getSortIpInvalidDataWeight error" + localException);
      }
    }
    return 20;
  }
  
  public static int aW()
  {
    try
    {
      if (q.containsKey("msf_SortIpConnFullWeight"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_SortIpConnFullWeight"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getSortIpConnFullWeight error" + localException);
      }
    }
    return 20;
  }
  
  public static boolean aX()
  {
    try
    {
      if (q.containsKey("msf_loginWithPicSt"))
      {
        boolean bool = Boolean.parseBoolean((String)q.get("msf_loginWithPicSt"));
        return bool;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "loginWithPicSt error" + localException);
      }
    }
    return true;
  }
  
  public static int aY()
  {
    try
    {
      if (q.containsKey("msf_SingleWiFiSSIDStoreTimes"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_SingleWiFiSSIDStoreTimes"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getSingleWiFiSSIDStoreTimes error" + localException);
      }
    }
    return 3;
  }
  
  public static long aZ()
  {
    try
    {
      if (q.containsKey("msf_ReportWiFiSSIDInterval"))
      {
        long l1 = Long.parseLong((String)q.get("msf_ReportWiFiSSIDInterval"));
        return l1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getReportWiFiSSIDInterval error" + localException);
      }
    }
    return 72000000L;
  }
  
  public static int aa()
  {
    try
    {
      if (q.containsKey("msf_getHttpRecvTimeout"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "msf_getHttpRecvTimeout = " + (String)q.get("msf_getHttpRecvTimeout"));
        }
        int i1 = Integer.parseInt((String)q.get("msf_getHttpRecvTimeout"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.ConfigManager", 4, "getHttpRecvTimeout error" + localException);
      }
    }
    return 30000;
  }
  
  public static int ab()
  {
    try
    {
      if (q.containsKey("msf_getHttpReSendMessageConcurrentLimit"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "msf_getHttpReSendMessageConcurrentLimit = " + (String)q.get("msf_getHttpReSendMessageConcurrentLimit"));
        }
        int i1 = Integer.parseInt((String)q.get("msf_getHttpReSendMessageConcurrentLimit"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.ConfigManager", 4, "getHttpReSendMessageConcurrentLimit error" + localException);
      }
    }
    return 5;
  }
  
  public static int ac()
  {
    try
    {
      if (q.containsKey("msf_getHttpReSendMessageTimeout"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "msf_getHttpReSendMessageTimeout = " + (String)q.get("msf_getHttpReSendMessageTimeout"));
        }
        int i1 = Integer.parseInt((String)q.get("msf_getHttpReSendMessageTimeout"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.ConfigManager", 4, "getHttpReSendMessageTimeout error" + localException);
      }
    }
    return 30000;
  }
  
  public static String[] ad()
  {
    if (q.containsKey("getQuickSendBlackList")) {
      return ((String)q.get("getQuickSendBlackList")).replaceAll("\\|", "#").split("#");
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.ConfigManager", 2, "getQuickSendBlackList not be found.");
    }
    return null;
  }
  
  public static String ae()
  {
    if (q.containsKey("MsfCrashControlInfo")) {
      return (String)q.get("MsfCrashControlInfo");
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.ConfigManager", 2, "getMsfCrashControlInfo not found");
    }
    return null;
  }
  
  public static String af()
  {
    if (q.containsKey("bigflowwifi_ver2")) {
      return (String)q.get("bigflowwifi_ver2");
    }
    return "20";
  }
  
  public static long ag()
  {
    try
    {
      if (q.containsKey("msf_basicTicketChangeInterval"))
      {
        long l1 = Long.parseLong((String)q.get("msf_basicTicketChangeInterval"));
        return l1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getBasicTicketChangeInterval error" + localException);
      }
    }
    return 0L;
  }
  
  public static long ah()
  {
    try
    {
      if (q.containsKey("msf_webTicketChangeInterval"))
      {
        long l1 = Long.parseLong((String)q.get("msf_webTicketChangeInterval"));
        return l1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getWebTicketChangeInterval error" + localException);
      }
    }
    return 0L;
  }
  
  public static boolean ai()
  {
    if (q.containsKey("msf_basicTicketChangeLimit")) {
      try
      {
        boolean bool = Boolean.parseBoolean(((String)q.get("msf_basicTicketChangeLimit")).trim());
        return bool;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, " set isBasicTicketChangeLimit error " + localException);
        }
        return false;
      }
    }
    return true;
  }
  
  public static boolean aj()
  {
    if (q.containsKey("msf_isReportDataCorrupt")) {
      try
      {
        boolean bool = Boolean.parseBoolean(((String)q.get("msf_isReportDataCorrupt")).trim());
        return bool;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, " set msf_isReportDataCorrupt error " + localException);
        }
        return false;
      }
    }
    return true;
  }
  
  public static boolean ak()
  {
    if (q.containsKey("msf_isDelayChangeWebKey")) {
      try
      {
        boolean bool = Boolean.parseBoolean(((String)q.get("msf_isDelayChangeWebKey")).trim());
        return bool;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, " set msf_isDelayChangeWebKey error " + localException);
        }
        return false;
      }
    }
    return true;
  }
  
  public static boolean al()
  {
    return A.get();
  }
  
  public static String[] au()
  {
    if (q.containsKey("StandbyMode")) {
      return ((String)q.get("StandbyMode")).replaceAll("\\|", ",").split(",");
    }
    QLog.d("MSF.C.ConfigManager", 1, "StandbyMode whitelist not be found.");
    return null;
  }
  
  public static boolean av()
  {
    if (q.containsKey("msf_StandbyModeAvailable")) {
      try
      {
        boolean bool = Boolean.parseBoolean(((String)q.get("msf_StandbyModeAvailable")).trim());
        return bool;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, " set isStandbyModeAvailable error " + localException);
        }
      }
    }
    return false;
  }
  
  public static boolean aw()
  {
    if (q.containsKey("msf_isReqAllFailTest")) {
      try
      {
        boolean bool = Boolean.parseBoolean(((String)q.get("msf_isReqAllFailTest")).trim());
        return bool;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, " set isReqAllFailTest error " + localException);
        }
      }
    }
    return false;
  }
  
  public static CopyOnWriteArrayList ax()
  {
    localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    int i1;
    String[] arrayOfString4;
    com.tencent.mobileqq.msf.core.d locald;
    if (q.containsKey("ydconn")) {
      try
      {
        String[] arrayOfString1 = ((String)q.get("ydconn")).replaceAll("\\|", ",").split(",");
        i1 = 0;
        while (i1 < arrayOfString1.length)
        {
          arrayOfString4 = arrayOfString1[i1].split(":");
          locald = new com.tencent.mobileqq.msf.core.d();
          locald.c(arrayOfString4[0]);
          locald.a(Integer.parseInt(arrayOfString4[1]));
          localCopyOnWriteArrayList.add(locald);
          i1 += 1;
        }
        if (!q.containsKey("ltconn")) {
          break label218;
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    } else {
      try
      {
        String[] arrayOfString2 = ((String)q.get("ltconn")).replaceAll("\\|", ",").split(",");
        i1 = 0;
        while (i1 < arrayOfString2.length)
        {
          arrayOfString4 = arrayOfString2[i1].split(":");
          locald = new com.tencent.mobileqq.msf.core.d();
          locald.c(arrayOfString4[0]);
          locald.a(Integer.parseInt(arrayOfString4[1]));
          localCopyOnWriteArrayList.add(locald);
          i1 += 1;
        }
        if (!q.containsKey("dxconn")) {
          return localCopyOnWriteArrayList;
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
    try
    {
      label218:
      String[] arrayOfString3 = ((String)q.get("dxconn")).replaceAll("\\|", ",").split(",");
      i1 = 0;
      while (i1 < arrayOfString3.length)
      {
        arrayOfString4 = arrayOfString3[i1].split(":");
        locald = new com.tencent.mobileqq.msf.core.d();
        locald.c(arrayOfString4[0]);
        locald.a(Integer.parseInt(arrayOfString4[1]));
        localCopyOnWriteArrayList.add(locald);
        i1 += 1;
      }
      return localCopyOnWriteArrayList;
    }
    catch (Exception localException3)
    {
      localException3.printStackTrace();
    }
  }
  
  public static CopyOnWriteArrayList ay()
  {
    Object localObject = t.e();
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    if (localObject == null) {
      return null;
    }
    if ((((String)localObject).startsWith("460")) || (((String)localObject).startsWith("461"))) {
      if ((((String)localObject).startsWith("46000")) || (((String)localObject).startsWith("46002"))) {
        localObject = "ydconn";
      }
    }
    for (;;)
    {
      if (q.containsKey(localObject)) {
        try
        {
          localObject = ((String)q.get(localObject)).replaceAll("\\|", ",").split(",");
          int i1 = 0;
          for (;;)
          {
            if (i1 < localObject.length)
            {
              String[] arrayOfString = localObject[i1].split(":");
              com.tencent.mobileqq.msf.core.d locald = new com.tencent.mobileqq.msf.core.d();
              locald.c(arrayOfString[0]);
              locald.a(Integer.parseInt(arrayOfString[1]));
              localCopyOnWriteArrayList.add(locald);
              i1 += 1;
              continue;
              if (((String)localObject).startsWith("46001"))
              {
                localObject = "ltconn";
                break;
              }
              if (((String)localObject).startsWith("46003"))
              {
                localObject = "dxconn";
                break;
              }
              return null;
              return null;
            }
          }
          return localCopyOnWriteArrayList;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    for (;;)
    {
      return null;
      QLog.d("MSF.C.ConfigManager", 1, "getReqAllFailDetectXGSSOList not be found.");
    }
  }
  
  public static boolean az()
  {
    if (q.containsKey("msf_StandbyTestAvailable")) {
      try
      {
        boolean bool = Boolean.parseBoolean(((String)q.get("msf_StandbyTestAvailable")).trim());
        return bool;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, " set isStandbyTestAvailable error " + localException);
        }
      }
    }
    return true;
  }
  
  public static int ba()
  {
    try
    {
      if (q.containsKey("msf_aliveSplitLen"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_aliveSplitLen"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getMsfAliveSplitLen error" + localException);
      }
    }
    return 1024;
  }
  
  public static int bb()
  {
    try
    {
      if (q.containsKey("msf_aliveReportMax"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_aliveReportMax"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getMsfAliveReportMax error" + localException);
      }
    }
    return 15360;
  }
  
  public static int bc()
  {
    try
    {
      if (q.containsKey("msf_aliveAutoInterval"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_aliveAutoInterval"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getMsfAliveAutoInterval error" + localException);
      }
    }
    return 7200;
  }
  
  public static boolean bd()
  {
    try
    {
      if (q.containsKey("msf_reportMsfAliveFull"))
      {
        boolean bool = Boolean.parseBoolean((String)q.get("msf_reportMsfAliveFull"));
        return bool;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "reportMsfAliveFull error" + localException);
      }
    }
    return true;
  }
  
  public static int be()
  {
    try
    {
      if (q.containsKey("msf_RandomPushReportBase"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_RandomPushReportBase"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getRandomPushReportBase error" + localException);
      }
    }
    return 1;
  }
  
  public static HashSet bf()
  {
    try
    {
      if (q.containsKey("msf_getPskeyDomains"))
      {
        Object localObject = (String)q.get("msf_getPskeyDomains");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split("#");
          if ((localObject != null) && (localObject.length > 0))
          {
            int i1 = 0;
            while (i1 < localObject.length)
            {
              if (!TextUtils.isEmpty(localObject[i1])) {
                l.c.add(localObject[i1]);
              }
              i1 += 1;
            }
          }
        }
      }
      return l.c;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getPskeyDomains error" + localException);
      }
    }
  }
  
  public static long bg()
  {
    try
    {
      if (q.containsKey("msf_StoreLogcatTriggerInterval"))
      {
        long l1 = Long.parseLong((String)q.get("msf_StoreLogcatTriggerInterval"));
        return l1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getStoreLogcatTriggerInterval error" + localException);
      }
    }
    return 10000L;
  }
  
  public static long bh()
  {
    try
    {
      if (q.containsKey("msf_LogcatStoreInterval"))
      {
        long l1 = Long.parseLong((String)q.get("msf_LogcatStoreInterval"));
        return l1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getLogcatStoreInterval error" + localException);
      }
    }
    return 1800000L;
  }
  
  public static int bi()
  {
    try
    {
      if (q.containsKey("msf_logCompressLevel"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_logCompressLevel"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getLogCompressLevel error" + localException);
      }
    }
    return 9;
  }
  
  public static int bj()
  {
    try
    {
      if (q.containsKey("msf_MSFPullReportBase"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_MSFPullReportBase"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getMSFPullReportBase error" + localException);
      }
    }
    return 1;
  }
  
  public static boolean bk()
  {
    try
    {
      if (q.containsKey("msf_reportPushDetail"))
      {
        boolean bool = Boolean.parseBoolean((String)q.get("msf_reportPushDetail"));
        return bool;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "reportPushDetail error" + localException);
      }
    }
    return true;
  }
  
  public static long bl()
  {
    try
    {
      if (q.containsKey("msf_preDetectionAlarmTimeAlpha"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_preDetectionAlarmTimeAlpha"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getPreDetectionAlarmTimeAlpha error" + localException);
      }
    }
    return 900000L;
  }
  
  public static long bm()
  {
    try
    {
      if (q.containsKey("msf_preDetectionAlarmTimeBeta"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_preDetectionAlarmTimeBeta"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getPreDetectionAlarmTimeBeta error" + localException);
      }
    }
    return 480000L;
  }
  
  public static boolean bn()
  {
    try
    {
      if (q.containsKey("msf_heartBeatSwtich"))
      {
        boolean bool = Boolean.parseBoolean((String)q.get("msf_heartBeatSwtich"));
        return bool;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getHeartBeatSwtich error" + localException);
      }
    }
    return true;
  }
  
  public static boolean bo()
  {
    try
    {
      if (q.containsKey("msf_quickHeartBeatSwitch"))
      {
        boolean bool = Boolean.parseBoolean((String)q.get("msf_quickHeartBeatSwitch"));
        return bool;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getQuickHeartBeatSwitch error" + localException);
      }
    }
    return true;
  }
  
  public static int bp()
  {
    try
    {
      if (q.containsKey("msf_simpleGetTimeoutNumber"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_simpleGetTimeoutNumber"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getSimpleGetTimeoutNumber error" + localException);
      }
    }
    return 5;
  }
  
  public static int bq()
  {
    try
    {
      if (q.containsKey("msf_apptimeout"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_apptimeout"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getAppTimeout error" + localException);
      }
    }
    return 2000;
  }
  
  public static boolean br()
  {
    try
    {
      if (q.containsKey("msf_getAllowWhileIdleSwtich"))
      {
        boolean bool = Boolean.parseBoolean((String)q.get("msf_getAllowWhileIdleSwtich"));
        return bool;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getAllowWhileIdleSwtich error" + localException);
      }
    }
    return true;
  }
  
  public static int bs()
  {
    try
    {
      if (q.containsKey("msf_weaknet_config"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_weaknet_config"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "msf_weaknet_config error" + localException);
      }
    }
    return 0;
  }
  
  public static boolean bt()
  {
    try
    {
      if (q.containsKey("msf_weaknetXGSendMsg"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_weaknetXGSendMsg"));
        return i1 != 0;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getWeaknetXGSendMsg error" + localException);
      }
    }
    return false;
  }
  
  public static boolean bu()
  {
    if ((!"x86".equals(com.tencent.mobileqq.msf.core.c.c(BaseApplication.getContext()))) || (QLog.isColorLevel())) {
      QLog.i("MSF.C.ConfigManager", 2, "isQuicEnabled enabled=" + false + " " + (String)q.get("quic_enable") + " reload=" + QuicWrapper.reload() + " isLoad=" + QuicWrapper.isLoaded);
    }
    return (0 != 0) && (QuicWrapper.reload());
  }
  
  private void bw()
  {
    boolean bool2 = false;
    int i2;
    int i1;
    String str2;
    if (q.containsKey("msf_noReportRdmEvent")) {
      try
      {
        String[] arrayOfString1 = ((String)q.get("msf_noReportRdmEvent")).split(";");
        i2 = arrayOfString1.length;
        i1 = 0;
        while (i1 < i2)
        {
          str2 = arrayOfString1[i1];
          if (!str2.trim().equals(""))
          {
            r.add(str2);
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.ConfigManager", 2, "rdm event " + str2 + " set no report.");
            }
          }
          i1 += 1;
        }
        if (!q.containsKey("msf_needPrintLogCmd")) {
          break label309;
        }
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "set msf_noReportRdmEvent error " + localException1);
        }
      }
    } else {
      try
      {
        String[] arrayOfString2 = ((String)q.get("msf_needPrintLogCmd")).split(";");
        i2 = arrayOfString2.length;
        i1 = 0;
        while (i1 < i2)
        {
          str2 = arrayOfString2[i1];
          if (!str2.trim().equals(""))
          {
            s.add(str2);
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.ConfigManager", 2, "msg " + str2 + " need print log.");
            }
          }
          i1 += 1;
        }
        if (!q.containsKey("msf_AnyPacketAsPushHB")) {}
      }
      catch (Exception localException2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "set msf_noReportRdmEvent error " + localException2);
        }
      }
    }
    label309:
    boolean bool1;
    for (;;)
    {
      try
      {
        str1 = (String)q.get("msf_AnyPacketAsPushHB");
        if (!str1.equals("0")) {
          continue;
        }
        bool1 = false;
        t = bool1;
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "config useAnyPacketAsPushHB " + str1);
        }
      }
      catch (Exception localException3)
      {
        String str1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MSF.C.ConfigManager", 2, "set msf_noReportRdmEvent error " + localException3);
        continue;
        bool1 = true;
        continue;
      }
      if (q.containsKey("msf_preDetectionSupport")) {}
      try
      {
        str1 = (String)q.get("msf_preDetectionSupport");
        if (!str1.equals("0")) {
          continue;
        }
        bool1 = false;
        u = bool1;
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "config msf_preDetectionSupport " + str1);
        }
      }
      catch (Exception localException4)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MSF.C.ConfigManager", 2, "set msf_preDetectionSupport error " + localException4);
        continue;
        bool1 = true;
        continue;
      }
      if (q.containsKey("msf_simpleGetReportSwitch")) {}
      try
      {
        str1 = (String)q.get("msf_simpleGetReportSwitch");
        if (!str1.equals("0")) {
          break label625;
        }
        bool1 = bool2;
        v = bool1;
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "config msf_simpleGetReportSwitch " + str1);
        }
        return;
      }
      catch (Exception localException5)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MSF.C.ConfigManager", 2, "set msf_simpleGetReportSwitch error " + localException5);
      }
      bool1 = true;
    }
    label625:
  }
  
  private void bx()
  {
    try
    {
      String[] arrayOfString = au();
      if ((arrayOfString != null) && (this.z.getStandyModeManager() != null)) {
        this.z.getStandyModeManager().a(arrayOfString);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.ConfigManager", 1, " " + localException, localException);
    }
  }
  
  private void by()
  {
    try
    {
      String[] arrayOfString = c();
      if (arrayOfString != null)
      {
        this.z.sender.i = Integer.parseInt(arrayOfString[0]);
        this.z.sender.j = Integer.parseInt(arrayOfString[1]);
        this.z.sender.n = Integer.parseInt(arrayOfString[2]);
        this.z.sender.l = Integer.parseInt(arrayOfString[3]);
      }
      return;
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          arrayOfString = d();
          this.z.sender.a(arrayOfString);
          try
          {
            this.z.sender.m = Integer.parseInt(e());
            return;
          }
          catch (Exception localException3)
          {
            QLog.d("MSF.C.ConfigManager", 1, " " + localException3, localException3);
          }
          localException1 = localException1;
          QLog.d("MSF.C.ConfigManager", 1, " " + localException1, localException1);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.d("MSF.C.ConfigManager", 1, " " + localException2, localException2);
        }
      }
    }
  }
  
  static String c(String paramString)
  {
    try
    {
      paramString = HexUtil.bytes2HexStr(paramString.getBytes("UTF-8"));
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.ConfigManager", 4, "Str2HexStr error " + paramString, paramString);
      }
    }
    return null;
  }
  
  public static String[] c()
  {
    if (q.containsKey("MultiPkgPara"))
    {
      String[] arrayOfString = ((String)q.get("MultiPkgPara")).replaceAll("\\|", ",").split(",");
      if (arrayOfString.length == 4) {
        return arrayOfString;
      }
    }
    else
    {
      QLog.d("MSF.C.ConfigManager", 1, "login merge configuration not be found.");
    }
    return null;
  }
  
  static String d(String paramString)
  {
    try
    {
      paramString = new String(HexUtil.hexStr2Bytes(paramString), "UTF-8");
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "HexStr2Str error " + paramString, paramString);
      }
    }
    return null;
  }
  
  public static String[] d()
  {
    if (q.containsKey("MultiPkgWL")) {
      return ((String)q.get("MultiPkgWL")).replaceAll("\\|", ",").split(",");
    }
    QLog.d("MSF.C.ConfigManager", 1, "login merge whitelist not be found.");
    return null;
  }
  
  public static Object e(String paramString)
  {
    return q.get(paramString);
  }
  
  public static String e()
  {
    if (q.containsKey("AndroidMergeDuration")) {
      return (String)q.get("AndroidMergeDuration");
    }
    QLog.d("MSF.C.ConfigManager", 1, "login merge duration not be found.");
    return "0";
  }
  
  public static String f()
  {
    if (q.contains("NetFlowMax")) {
      return (String)q.get("NetFlowMax");
    }
    return "10485760";
  }
  
  public static boolean g()
  {
    if (q.containsKey("monitor_ipHostReportSwitch")) {
      try
      {
        boolean bool = Boolean.parseBoolean((String)q.get("monitor_ipHostReportSwitch"));
        return bool;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "get ipHostReportSwitch error " + localException);
        }
      }
    }
    return true;
  }
  
  public static String h()
  {
    if (q.containsKey("msf_locallogtime")) {
      return (String)q.get("msf_locallogtime");
    }
    return "3";
  }
  
  public static String i()
  {
    if (q.containsKey("msf_checkSsoIntervtime")) {
      return (String)q.get("msf_checkSsoIntervtime");
    }
    return "300000";
  }
  
  public static boolean j()
  {
    if (q.containsKey("msf_useLastOpenAddress")) {
      try
      {
        boolean bool = Boolean.parseBoolean((String)q.get("msf_useLastOpenAddress"));
        return bool;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "get useLastOpenAddress error " + localException);
        }
      }
    }
    return false;
  }
  
  public static boolean k()
  {
    if (q.containsKey("msf_limitWtChangetoken")) {
      try
      {
        boolean bool = Boolean.parseBoolean((String)q.get("msf_limitWtChangetoken"));
        return bool;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "get msf_limitWtChangetoken error " + localException);
        }
      }
    }
    return true;
  }
  
  public static boolean l()
  {
    if (q.containsKey("msf_isSetReloadKeyUin")) {
      try
      {
        boolean bool = Boolean.parseBoolean((String)q.get("msf_isSetReloadKeyUin"));
        return bool;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "get msf_isSetReloadKeyUin error " + localException);
        }
      }
    }
    return true;
  }
  
  public static long m()
  {
    try
    {
      if (q.contains("DeepSleepMaxInterval"))
      {
        long l1 = Long.parseLong((String)q.get("DeepSleepMaxInterval"));
        return l1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "get DeepSleepMaxInterval error " + localException);
      }
    }
    return 57600000L;
  }
  
  public static boolean n()
  {
    try
    {
      if (q.containsKey("msf_isUseWtlogin"))
      {
        boolean bool = Boolean.parseBoolean((String)q.get("msf_isUseWtlogin"));
        return bool;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "msf_isUseWtlogin error" + localException);
      }
    }
    return y;
  }
  
  public static long o()
  {
    try
    {
      if (q.containsKey("msf_standbyWaitInterval"))
      {
        long l1 = Long.parseLong((String)q.get("msf_standbyWaitInterval"));
        return l1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "get standbyWaitInterval error" + localException);
      }
    }
    return 30000L;
  }
  
  public static long p()
  {
    try
    {
      if (q.containsKey("msf_compressLogDelay"))
      {
        long l1 = Long.parseLong((String)q.get("msf_compressLogDelay"));
        return l1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "get getCompressLogDelay error" + localException);
      }
    }
    return 60000L;
  }
  
  public static long q()
  {
    try
    {
      if (q.containsKey("msf_LogClearInterval"))
      {
        long l1 = Long.parseLong((String)q.get("msf_LogClearInterval"));
        return l1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "get getLogClearInterval error" + localException);
      }
    }
    return 3600000L;
  }
  
  public static boolean r()
  {
    try
    {
      if (q.containsKey("msf_newLogClearStrategy"))
      {
        boolean bool = Boolean.parseBoolean((String)q.get("msf_newLogClearStrategy"));
        return bool;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getNewLogClearStrategy error" + localException);
      }
    }
    return true;
  }
  
  public static boolean s()
  {
    try
    {
      if (q.containsKey("msf_newLogClearStrategyTest"))
      {
        boolean bool = Boolean.parseBoolean((String)q.get("msf_newLogClearStrategyTest"));
        return bool;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getNewLogClearStrategyTest error" + localException);
      }
    }
    return true;
  }
  
  public static boolean t()
  {
    try
    {
      if (q.containsKey("msf_newLogClearStrategyTestShutdown"))
      {
        boolean bool = Boolean.parseBoolean((String)q.get("msf_newLogClearStrategyTestShutdown"));
        return bool;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getNewLogClearStrategyTestShutdown error" + localException);
      }
    }
    return false;
  }
  
  public static long u()
  {
    try
    {
      if (q.containsKey("msf_pingTimeout"))
      {
        long l1 = Long.parseLong((String)q.get("msf_pingTimeout"));
        return l1 * 1000L;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "get getSSOPingTimeout error" + localException);
      }
    }
    return 12000L;
  }
  
  public static boolean v()
  {
    try
    {
      if (q.containsKey("msf_ssopingavailable"))
      {
        boolean bool = Boolean.parseBoolean((String)q.get("msf_ssopingavailable"));
        return bool;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "get getSSOPingAvailable error" + localException);
      }
    }
    return true;
  }
  
  public static boolean w()
  {
    try
    {
      if (q.containsKey("msf_connFastDetect"))
      {
        boolean bool = Boolean.parseBoolean((String)q.get("msf_connFastDetect"));
        return bool;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "get getConnFastDetectAvailable error" + localException);
      }
    }
    return true;
  }
  
  public static boolean x()
  {
    try
    {
      if (q.containsKey("msf_activePreDetect"))
      {
        boolean bool = Boolean.parseBoolean((String)q.get("msf_activePreDetect"));
        return bool;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getActivePreDetect error" + localException);
      }
    }
    return true;
  }
  
  public static long y()
  {
    try
    {
      if (q.containsKey("msf_preDetectTimeout"))
      {
        int i1 = Integer.parseInt((String)q.get("msf_preDetectTimeout"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "getPreDetectTimeout error" + localException);
      }
    }
    return 10000L;
  }
  
  public static long z()
  {
    if (!x())
    {
      try
      {
        if (q.containsKey("msf_heartBeatTimeout"))
        {
          int i1 = Integer.parseInt((String)q.get("msf_heartBeatTimeout"));
          return i1;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "getHeartBeatTimeout error" + localException);
        }
      }
      return 30000L;
    }
    return y();
  }
  
  public int a(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg.getWupBuffer() != null) && (paramToServiceMsg.getWupBuffer().length > 0)) {}
    for (;;)
    {
      this.z.sendSsoMsg(paramToServiceMsg);
      return paramToServiceMsg.getRequestSsoSeq();
      Object localObject1 = new com.tencent.msf.service.protocol.f.f();
      ((com.tencent.msf.service.protocol.f.f)localObject1).f = 0;
      ((com.tencent.msf.service.protocol.f.f)localObject1).a = new com.tencent.msf.service.protocol.f.b();
      ((com.tencent.msf.service.protocol.f.f)localObject1).d = "";
      ((com.tencent.msf.service.protocol.f.f)localObject1).e = "";
      ((com.tencent.msf.service.protocol.f.f)localObject1).g = new byte[0];
      ((com.tencent.msf.service.protocol.f.f)localObject1).c = new ArrayList();
      ((com.tencent.msf.service.protocol.f.f)localObject1).b = new ArrayList();
      Object localObject2 = new com.tencent.msf.service.protocol.f.d();
      ((com.tencent.msf.service.protocol.f.d)localObject2).e = 0;
      ((com.tencent.msf.service.protocol.f.d)localObject2).d = 0;
      ((com.tencent.msf.service.protocol.f.d)localObject2).c = 0;
      ((com.tencent.msf.service.protocol.f.d)localObject2).a = "";
      ((com.tencent.msf.service.protocol.f.d)localObject2).b = 0L;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject2);
      localObject2 = new UniPacket(true);
      ((UniPacket)localObject2).setEncodeName("utf-8");
      ((UniPacket)localObject2).setRequestId(0);
      ((UniPacket)localObject2).setServantName("KQQ.ConfigService.ConfigServantObj");
      ((UniPacket)localObject2).setFuncName("ClientReq");
      ((UniPacket)localObject2).put("iCmdType", Integer.valueOf(64));
      ((UniPacket)localObject2).put("ReqUserInfo", localObject1);
      localObject1 = new com.tencent.msf.service.protocol.f.e();
      ((com.tencent.msf.service.protocol.f.e)localObject1).a = localArrayList;
      ((UniPacket)localObject2).put("GetResourceReqV2", localObject1);
      paramToServiceMsg.putWupBuffer(((UniPacket)localObject2).encode());
    }
  }
  
  public int a(HashMap paramHashMap, String paramString)
    throws Exception
  {
    paramHashMap = a(paramString, paramHashMap);
    paramString = new ToServiceMsg("", "0", "CliLogSvc.UploadReq");
    paramString.setAppId(this.z.sender.j());
    paramString.setRequestSsoSeq(MsfCore.getNextSeq());
    paramString.setTimeout(30000L);
    paramString.setNeedCallback(false);
    paramString.putWupBuffer(paramHashMap);
    return this.z.sendSsoMsg(paramString);
  }
  
  public void a()
  {
    b();
  }
  
  public void a(int paramInt, String paramString1, long paramLong, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    paramString1 = new b(this, paramBoolean2, paramString1, paramInt, paramLong, paramBoolean1, paramString2);
    paramString1.setName("checkSsoByHttpThread");
    paramString1.start();
  }
  
  public void a(com.tencent.msf.service.protocol.e.f paramf, FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.ConfigManager", 2, "recvServerConfig: " + paramf);
    }
    if (paramf == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "configInfo.iUpdateType is null , return");
      }
    }
    label280:
    label359:
    label631:
    label889:
    do
    {
      String str3;
      do
      {
        do
        {
          do
          {
            return;
            if (paramf.a == 1) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("MSF.C.ConfigManager", 2, "configInfo.iUpdateType is " + paramf.a + " , return");
          return;
          str3 = paramf.d;
          if ((str3 != null) && (str3.length() != 0)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("MSF.C.ConfigManager", 2, "handle config, res.sConf null, return");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "handle sConf " + paramf.d);
        }
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "handle sEspConf " + paramf.f);
        }
        String str4 = "";
        i1 = str3.indexOf("<MSF>");
        i2 = str3.indexOf("</MSF>");
        if ((i1 == -1) || (i2 == -1) || (i1 >= i2))
        {
          str1 = str4;
          paramToServiceMsg = str3;
          if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.ConfigManager", 2, "handle config MSF null, skip");
            paramToServiceMsg = str3;
            str1 = str4;
          }
          i1 = paramToServiceMsg.indexOf("<quic_enable>");
          i2 = paramToServiceMsg.indexOf("</quic_enable>");
          if ((i1 <= 0) || (i2 <= 0) || (i1 > i2)) {
            break label533;
          }
          str3 = paramToServiceMsg.substring("<quic_enable>".length() + i1, i2);
          QLog.d("MSF.C.ConfigManager", 1, "parse config str_quic_enable: " + str3);
          if ((str1 != null) && (str1.length() != 0)) {
            break label545;
          }
        }
        for (;;)
        {
          if ((paramf.b != 0) && (x != paramf.b)) {
            break label631;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.ConfigManager", 2, "handle config,  iGetSdkLastTime is obsolete, skip...");
          }
          if ((paramf.g != 0) && (w != paramf.g)) {
            break label889;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.ConfigManager", 2, "handle config, iGetAppidTime is obsolete, skip...");
          }
          paramToServiceMsg = paramf.f;
          if ((paramToServiceMsg != null) && (paramToServiceMsg.length() != 0)) {
            break label1139;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MSF.C.ConfigManager", 2, "handle config, res.sEspConf null, return");
          return;
          str1 = str3.substring("<MSF>".length() + i1, i2);
          paramToServiceMsg = str3.substring(0, i1) + str3.substring("</MSF>".length() + i2, str3.length());
          break label280;
          QLog.d("MSF.C.ConfigManager", 1, "parse quic_enable config error");
          break label359;
          if (a("msfConfig", str1, ""))
          {
            str1 = c(str1);
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.ConfigManager", 2, "recv config str_msf: " + str1);
            }
            MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_iconf_Msf", str1);
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.ConfigManager", 2, "parse msfConf error , skip store.");
          }
        }
        x = paramf.b;
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.ConfigManager", 4, "save confReq iGetSdkNewTime" + paramf.b);
        }
        MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_iConfSdkLastTimeKey", String.valueOf(paramf.b));
        i1 = paramToServiceMsg.indexOf("<CommConf>");
        i2 = paramToServiceMsg.indexOf("</CommConf>");
        if ((i1 != -1) && (i2 != -1) && (i1 < i2)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MSF.C.ConfigManager", 2, "handle config CommConf error");
      return;
      String str1 = paramToServiceMsg.substring("<CommConf>".length() + i1, i2);
      if ((str1 == null) || (str1.length() == 0)) {
        MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_iconf_UserCommCon", "");
      }
      for (;;)
      {
        try
        {
          MsfSdkUtils.writeServerConfig("com.tencent.mobileqq", 0, str1, this.z.sender.i());
        }
        catch (IOException localIOException)
        {
          QLog.e("MSF.C.ConfigManager", 1, "write config error " + localIOException);
        }
        break;
        if (a("commConfig", localIOException, ""))
        {
          str3 = c(localIOException);
          MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_iconf_UserCommCon", str3);
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("MSF.C.ConfigManager", 2, "parse commonConf error , skip store.");
        }
      }
      w = paramf.g;
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.ConfigManager", 4, "save confReq getiConfAppidTimeKey" + paramf.g);
      }
      MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_iConfAppidTimeKey", String.valueOf(paramf.g));
      i1 = paramToServiceMsg.indexOf("<APPIDConf>");
      i2 = paramToServiceMsg.indexOf("</APPIDConf>");
      if ((i1 != -1) && (i2 != -1) && (i1 < i2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    label533:
    label545:
    QLog.d("MSF.C.ConfigManager", 2, "handle config APPIDConf error");
    return;
    paramToServiceMsg = paramToServiceMsg.substring("<APPIDConf>".length() + i1, i2);
    if ((paramToServiceMsg == null) || (paramToServiceMsg.length() == 0)) {
      MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_iconf_AppConf", "");
    }
    for (;;)
    {
      try
      {
        MsfSdkUtils.writeServerConfig("com.tencent.mobileqq", 2, paramToServiceMsg, this.z.sender.i());
      }
      catch (IOException paramToServiceMsg)
      {
        QLog.e("MSF.C.ConfigManager", 1, "write config error " + paramToServiceMsg);
      }
      break;
      if (a("appidConf", paramToServiceMsg, ""))
      {
        str2 = c(paramToServiceMsg);
        MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_iconf_AppConf", str2);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.ConfigManager", 2, "parse appidConf error , skip store.");
      }
    }
    label1139:
    String str2 = "";
    int i1 = paramToServiceMsg.indexOf("<UserConf>");
    int i2 = paramToServiceMsg.indexOf("</UserConf>");
    if ((i1 == -1) || (i2 == -1) || (i1 >= i2))
    {
      paramToServiceMsg = str2;
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.ConfigManager", 2, "handle config UserConf skip");
        paramToServiceMsg = str2;
      }
    }
    for (;;)
    {
      if ((paramToServiceMsg == null) || (paramToServiceMsg.length() == 0)) {}
      try
      {
        for (;;)
        {
          MsfSdkUtils.writeServerConfig("com.tencent.mobileqq", 1, paramToServiceMsg, this.z.sender.i());
          MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_iConfGetEspLastTimeKe", String.valueOf(paramf.e));
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.ConfigManager", 4, "save confReq getiConfGetEspLastTimeKey" + paramf.e);
          }
          bw();
          by();
          bx();
          this.z.quicksender.b();
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.ConfigManager", 2, "handle server config ok");
          }
          CodecWarpper.getFileStoreKey();
          return;
          paramToServiceMsg = paramToServiceMsg.substring("<UserConf>".length() + i1, i2);
          break;
          if (a("userConf", paramToServiceMsg, paramFromServiceMsg.getUin() + "_"))
          {
            str2 = c(paramToServiceMsg);
            MsfStore.getNativeConfigStore().n_setConfig(paramFromServiceMsg.getUin() + "_" + "__loginSdk_iconf_UserConf", str2);
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.ConfigManager", 2, "parse userConfig error , skip store.");
          }
        }
      }
      catch (IOException paramFromServiceMsg)
      {
        for (;;)
        {
          QLog.e("MSF.C.ConfigManager", 1, "write config error " + paramFromServiceMsg);
        }
      }
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    Object localObject1 = new com.tencent.msf.service.protocol.d.b();
    paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
    Object localObject2 = new byte[paramFromServiceMsg.length - 4];
    System.arraycopy(paramFromServiceMsg, 4, localObject2, 0, paramFromServiceMsg.length - 4);
    ((com.tencent.msf.service.protocol.d.b)localObject1).readFrom(new JceInputStream((byte[])localObject2));
    long l1 = System.currentTimeMillis() / 1000L;
    paramFromServiceMsg = ((com.tencent.msf.service.protocol.d.b)localObject1).a.iterator();
    while (paramFromServiceMsg.hasNext())
    {
      localObject1 = (com.tencent.msf.service.protocol.d.a)paramFromServiceMsg.next();
      if ((localObject1 != null) && (((com.tencent.msf.service.protocol.d.a)localObject1).b > 0) && (((com.tencent.msf.service.protocol.d.a)localObject1).b <= 1800))
      {
        localObject2 = new String(((com.tencent.msf.service.protocol.d.a)localObject1).a);
        Object localObject3 = ((String)localObject2).substring(0, ((String)localObject2).indexOf(".") + 1);
        Iterator localIterator = this.L.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (((String)localObject2).equals(locala.c)) {
            this.L.remove(locala);
          } else if (((((String)localObject2).endsWith(".*")) || (locala.c.endsWith(".*"))) && (locala.c.startsWith((String)localObject3))) {
            this.L.remove(locala);
          }
        }
        localObject3 = new a();
        ((a)localObject3).c = ((String)localObject2);
        ((a)localObject3).a = l1;
        ((a)localObject3).b = ((com.tencent.msf.service.protocol.d.a)localObject1);
        this.L.add(localObject3);
        QLog.d("MSF.C.ConfigManager", 1, "recved OverloadPushNotify cmd: " + (String)localObject2 + " delaySecs = " + ((com.tencent.msf.service.protocol.d.a)localObject1).b + " timeReced: " + l1 + " tips: " + ((com.tencent.msf.service.protocol.d.a)localObject1).e);
      }
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    QLog.i("MSF.C.ConfigManager", 1, "handleConfig before quic_enable=" + e("quic_enable"));
    if (!paramFromServiceMsg.isSuccess())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "wait " + paramToServiceMsg + " timeout.");
      }
      return;
    }
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("UTF-8");
    localUniPacket.decode(paramFromServiceMsg.getWupBuffer());
    int i1 = ((Integer)localUniPacket.getByClass("iCmdType", Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.ConfigManager", 2, "handle check ConfigResp ." + i1);
    }
    if (i1 == 16) {}
    for (;;)
    {
      QLog.i("MSF.C.ConfigManager", 1, "handleConfig after quic_enable=" + e("quic_enable"));
      return;
      if (i1 == 32) {
        a((com.tencent.msf.service.protocol.e.f)localUniPacket.getByClass("SDKConfRes", new com.tencent.msf.service.protocol.e.f()), paramFromServiceMsg, paramToServiceMsg);
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, long paramLong)
  {
    if (ap())
    {
      if (!NetConnInfoCenter.isMobileConn()) {
        break label79;
      }
      C = paramLong;
      MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_checkmobilessotime", String.valueOf(C));
      E = C + 3600000L;
      aq();
    }
    try
    {
      a(paramToServiceMsg.getAppId(), paramToServiceMsg.getUin(), 60000L, NetConnInfoCenter.isWifiConn(), "", false);
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          a(paramToServiceMsg.getUin(), 60000);
          return;
          label79:
          if (NetConnInfoCenter.isWifiConn())
          {
            D = paramLong;
            MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_checkwifissotime", String.valueOf(D));
            F = D + 3600000L;
            ar();
            continue;
            localException = localException;
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.ConfigManager", 2, localException.toString(), localException);
            }
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("MSF.C.ConfigManager", 2, paramToServiceMsg.toString(), paramToServiceMsg);
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = as();
    ToServiceMsg localToServiceMsg = new ToServiceMsg("", paramString, "ConfigService.ClientReq");
    localToServiceMsg.setMsfCommand(MsfCommand._msf_getConfig);
    localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
    if (this.z.getMsfAppid() == -1) {}
    for (int i1 = 100;; i1 = this.z.getMsfAppid())
    {
      localToServiceMsg.setAppId(i1);
      localToServiceMsg.putWupBuffer(arrayOfByte);
      localToServiceMsg.setTimeout(paramInt);
      this.z.sender.b(localToServiceMsg);
      QLog.d("MSF.C.ConfigManager", 1, "send checkConfig uin=" + MsfSdkUtils.getShortUin(paramString) + " appid=" + i1);
      return;
    }
  }
  
  byte[] a(String paramString, HashMap paramHashMap)
  {
    StrupBuff localStrupBuff = new StrupBuff();
    localStrupBuff.prefix = paramString;
    localStrupBuff.logstring = new HashMap(paramHashMap);
    localStrupBuff.encoding = 2;
    paramString = new UniPacket(true);
    paramString.setRequestId(MsfCore.getNextSeq());
    paramString.setEncodeName("utf-8");
    paramString.setServantName("QQService.CliLogSvc.MainServantObj");
    paramString.setFuncName("UploadReq");
    paramString.put("Data", localStrupBuff);
    return paramString.encode();
  }
  
  public String am()
  {
    return d(MsfStore.getNativeConfigStore().getConfig("__loginSdk_iconf_UserCommCon"));
  }
  
  public String an()
  {
    return d(MsfStore.getNativeConfigStore().getConfig("__loginSdk_iconf_AppConf"));
  }
  
  public String ao()
  {
    return d(MsfStore.getNativeConfigStore().getConfig("__loginSdk_iconf_Msf"));
  }
  
  public boolean ap()
  {
    long l1 = System.currentTimeMillis();
    if (NetConnInfoCenter.isMobileConn()) {
      if (C != 0L) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return true;
              if (E != 0L) {
                break;
              }
            } while (l1 - C >= 43200000L);
            return false;
          } while (l1 >= E);
          return false;
          if (!NetConnInfoCenter.isWifiConn()) {
            break;
          }
        } while (D == 0L);
        if (F != 0L) {
          break;
        }
      } while (l1 - D >= 43200000L);
      return false;
    } while (l1 >= F);
    return false;
    return false;
  }
  
  public void aq()
  {
    MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_mobilessotime", String.valueOf(E));
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.ConfigManager", 2, "save next get mobile sso time is " + this.z.timeFormatter.format(Long.valueOf(E)));
    }
  }
  
  public void ar()
  {
    MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_wifissotime", String.valueOf(F));
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.ConfigManager", 2, "save next get Wifi sso time is " + this.z.timeFormatter.format(Long.valueOf(F)));
    }
  }
  
  public byte[] as()
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setServantName("KQQ.ConfigService.ConfigServantObj");
    localUniPacket.setFuncName("ClientReq");
    localUniPacket.put("iCmdType", Integer.valueOf(32));
    com.tencent.msf.service.protocol.e.e locale = new com.tencent.msf.service.protocol.e.e();
    Object localObject2 = MsfStore.getNativeConfigStore().getConfig("__loginSdk_iConfAppidTimeKey");
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject1 = "1";
    }
    w = Integer.parseInt((String)localObject1);
    if (w == 0) {
      w = 1;
    }
    localObject2 = MsfStore.getNativeConfigStore().getConfig("__loginSdk_iConfSdkLastTimeKey");
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject1 = "0";
    }
    x = Integer.parseInt((String)localObject1);
    localObject2 = MsfStore.getNativeConfigStore().getConfig("__loginSdk_iConfGetEspLastTimeKe");
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject1 = "0";
    }
    int i1 = Integer.parseInt((String)localObject1);
    locale.e = w;
    locale.b = x;
    locale.d = i1;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.ConfigManager", 2, "load confReq iGetAppidTime" + locale.e + " iGetSdkLastTime:" + locale.b + " iGetEspLastTime:" + locale.d);
    }
    localObject2 = this.z.getAccountCenter().d();
    Object localObject1 = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject2).next();
      ((ArrayList)localObject1).add(localSimpleAccount.getUin());
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "checkConfig uin=" + localSimpleAccount.getUin());
      }
    }
    locale.c = ((ArrayList)localObject1);
    localUniPacket.put("SDKConfReq", locale);
    return localUniPacket.encode();
  }
  
  public ConcurrentHashMap at()
  {
    return q;
  }
  
  public int b(ToServiceMsg paramToServiceMsg)
  {
    byte b1 = ((Byte)paramToServiceMsg.getAttributes().get("to_report_type")).byteValue();
    String str = (String)paramToServiceMsg.getAttributes().get("to_report_content");
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setRequestId(MsfCore.getNextSeq());
    localUniPacket.setServantName("KQQ.ConfigService.ConfigServantObj");
    localUniPacket.setFuncName("ClientReportReq");
    com.tencent.msf.service.protocol.e.a locala = new com.tencent.msf.service.protocol.e.a();
    locala.a = b1;
    try
    {
      locala.c = str.getBytes("utf-8");
      localUniPacket.put("ClientReportReq", locala);
      paramToServiceMsg.putWupBuffer(localUniPacket.encode());
      return this.z.sendSsoMsg(paramToServiceMsg);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
  
  public String b(String paramString)
  {
    return d(MsfStore.getNativeConfigStore().getConfig(paramString + "_" + "__loginSdk_iconf_UserConf"));
  }
  
  protected void b()
  {
    String str1 = MsfStore.getNativeConfigStore().getConfig("__loginSdk_checkmobilessotime");
    if (str1 != null)
    {
      localObject = str1;
      if (str1.length() != 0) {}
    }
    else
    {
      localObject = "0";
    }
    C = Long.parseLong((String)localObject);
    str1 = MsfStore.getNativeConfigStore().getConfig("__loginSdk_checkwifissotime");
    if (str1 != null)
    {
      localObject = str1;
      if (str1.length() != 0) {}
    }
    else
    {
      localObject = "0";
    }
    D = Long.parseLong((String)localObject);
    str1 = MsfStore.getNativeConfigStore().getConfig("__loginSdk_mobilessotime");
    if (str1 != null)
    {
      localObject = str1;
      if (str1.length() != 0) {}
    }
    else
    {
      localObject = "0";
    }
    E = Long.parseLong((String)localObject);
    str1 = MsfStore.getNativeConfigStore().getConfig("__loginSdk_wifissotime");
    if (str1 != null)
    {
      localObject = str1;
      if (str1.length() != 0) {}
    }
    else
    {
      localObject = "0";
    }
    F = Long.parseLong((String)localObject);
    str1 = MsfStore.getNativeConfigStore().getConfig("_msf_isBootingKey");
    if (str1 != null)
    {
      localObject = str1;
      if (str1.length() != 0) {}
    }
    else
    {
      localObject = "false";
    }
    a(Boolean.parseBoolean((String)localObject));
    Object localObject = ao();
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      a("msfConfig", (String)localObject, "");
    }
    localObject = am();
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      a("commonConfig", (String)localObject, "");
    }
    localObject = an();
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      a("appidConfig", (String)localObject, "");
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.ConfigManager", 4, (String)localObject);
    }
    localObject = this.z.getAccountCenter().c().iterator();
    while (((Iterator)localObject).hasNext())
    {
      str1 = (String)((Iterator)localObject).next();
      String str2 = b(str1);
      if ((str2 != null) && (str2.length() > 0)) {
        a("userConfig", str2, str1 + "_");
      }
    }
    bw();
  }
  
  public String c(ToServiceMsg paramToServiceMsg)
  {
    switch (((Integer)paramToServiceMsg.getAttributes().get("to_getServerConfig_type")).intValue())
    {
    default: 
      return null;
    case 0: 
      return am();
    case 1: 
      return b(paramToServiceMsg.getUin());
    }
    return an();
  }
  
  public class a
  {
    public long a;
    public com.tencent.msf.service.protocol.d.a b;
    public String c;
    private boolean e;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.a.a
 * JD-Core Version:    0.7.0.1
 */