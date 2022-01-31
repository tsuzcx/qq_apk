package com.tencent.mobileqq.msf.core.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.ag;
import com.tencent.mobileqq.msf.core.auth.l;
import com.tencent.mobileqq.msf.core.quic.QuicWrapper;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.g;
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
  static AtomicBoolean B = new AtomicBoolean();
  public static final String C = "__loginSdk_iconf_Msf";
  static long D = 0L;
  static long E = 0L;
  static long F = 0L;
  static long G = 0L;
  public static final int H = 100;
  public static final int I = 1;
  public static final int J = 16;
  public static final String a = "ConfigService.ClientReq";
  public static final String b = "ResourceConfig.ClientReq";
  static final String c = "MSF.C.ConfigManager";
  public static final String d = "__loginSdk_iconf_UserConf";
  public static final String e = "__loginSdk_iconf_AppConf";
  public static final String f = "__loginSdk_iconf_UserCommCon";
  public static final String g = "__loginSdk_mobilessotime";
  public static final String h = "__loginSdk_wifissotime";
  public static final String i = "__loginSdk_checkmobilessotime";
  public static final String j = "__loginSdk_checkwifissotime";
  public static final String k = "_msf_isBootingKey";
  public static final int l = 32;
  public static final String m = "__loginSdk_iConfAppidTimeKey";
  public static final String n = "__loginSdk_iConfSdkLastTimeKey";
  public static final String o = "__loginSdk_iConfGetEspLastTimeKe";
  public static final String p = "__msf_isAutoBootKey";
  public static final boolean q = true;
  static ConcurrentHashMap r = new ConcurrentHashMap();
  public static HashSet s = new HashSet();
  public static HashSet t = new HashSet();
  public static boolean u = true;
  public static boolean v = true;
  public static boolean w = true;
  public static int x;
  public static int y;
  public static boolean z = true;
  MsfCore A;
  public CopyOnWriteArrayList K = new CopyOnWriteArrayList();
  
  public a(MsfCore paramMsfCore)
  {
    this.A = paramMsfCore;
  }
  
  public static long A()
  {
    if (!x())
    {
      try
      {
        if (r.containsKey("msf_heartBeatTimeout"))
        {
          int i1 = Integer.parseInt((String)r.get("msf_heartBeatTimeout"));
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
    return z();
  }
  
  public static long B()
  {
    try
    {
      if (r.containsKey("msf_connFastDetectDelay"))
      {
        long l1 = Long.parseLong((String)r.get("msf_connFastDetectDelay"));
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
  
  public static long C()
  {
    try
    {
      if (r.containsKey("msf_connFastDetectTimeout"))
      {
        long l1 = Long.parseLong((String)r.get("msf_connFastDetectTimeout"));
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
  
  public static long D()
  {
    try
    {
      if (r.containsKey("msf_autoReconnInterval"))
      {
        long l1 = Long.parseLong((String)r.get("msf_autoReconnInterval"));
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
  
  public static long E()
  {
    try
    {
      if (r.containsKey("msf_checkChangeTokenInterval"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_checkChangeTokenInterval"));
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
  
  public static long F()
  {
    try
    {
      if (r.containsKey("msf_ChangeTokenRequestInterval"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_ChangeTokenRequestInterval"));
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
  
  public static long G()
  {
    try
    {
      if (r.containsKey("msf_quickHeartBeatTimeout"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_quickHeartBeatTimeout"));
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
  
  public static long H()
  {
    try
    {
      if (r.containsKey("msf_getQuickHeartBeatReConnInterval"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_getQuickHeartBeatReConnInterval"));
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
  
  public static int I()
  {
    try
    {
      if (r.containsKey("msf_heartBeatRetrycount"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_heartBeatRetrycount"));
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
  
  public static int J()
  {
    try
    {
      if (r.containsKey("msf_busPacketTimeoutMaxNum"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_busPacketTimeoutMaxNum"));
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
  
  public static long K()
  {
    try
    {
      if (r.containsKey("msf_busCheckServerTimeInterval"))
      {
        long l1 = Long.parseLong((String)r.get("msf_busCheckServerTimeInterval"));
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
  
  public static long L()
  {
    try
    {
      if (r.containsKey("msf_checkUpdateServerTimeInterval"))
      {
        long l1 = Long.parseLong((String)r.get("msf_checkUpdateServerTimeInterval"));
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
  
  public static long M()
  {
    try
    {
      if (r.containsKey("msf_checkUpdateServerTimeExtraInterval"))
      {
        long l1 = Long.parseLong((String)r.get("msf_checkUpdateServerTimeExtraInterval"));
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
  
  public static long N()
  {
    try
    {
      if (r.containsKey("msf_checkServerTimeCompareInterval"))
      {
        long l1 = Long.parseLong((String)r.get("msf_checkServerTimeCompareInterval"));
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
  
  public static int O()
  {
    try
    {
      if (r.containsKey("msf_heartBeatTimeInterval"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "msf_heartBeatTimeInterval = " + (String)r.get("msf_heartBeatTimeInterval"));
        }
        int i1 = Integer.parseInt((String)r.get("msf_heartBeatTimeInterval"));
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
  
  public static int P()
  {
    try
    {
      if (r.containsKey("msf_preHeartBeatTimeInterval"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "msf_preHeartBeatTimeInterval = " + (String)r.get("msf_preHeartBeatTimeInterval"));
        }
        int i1 = Integer.parseInt((String)r.get("msf_preHeartBeatTimeInterval"));
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
  
  public static boolean Q()
  {
    try
    {
      if (r.containsKey("msf_updatehbtimeSwtich"))
      {
        boolean bool = Boolean.parseBoolean((String)r.get("msf_updateHBTimeSwtich"));
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
  
  public static int R()
  {
    try
    {
      if (r.containsKey("msf_netIdleTimeInterval"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "msf_netIdleTimeInterval = " + (String)r.get("msf_netIdleTimeInterval"));
        }
        int i1 = Integer.parseInt((String)r.get("msf_netIdleTimeInterval"));
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
  
  public static String S()
  {
    try
    {
      if (r.containsKey("TcpdumpSSOVip_new"))
      {
        String str = (String)r.get("TcpdumpSSOVip_new");
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
  
  public static int T()
  {
    try
    {
      if (r.containsKey("TcpdumpSSOTime"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "TcpdumpSSOTime = " + (String)r.get("TcpdumpSSOTime"));
        }
        int i1 = Integer.parseInt((String)r.get("TcpdumpSSOTime"));
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
  
  public static int U()
  {
    try
    {
      if (r.containsKey("msf_netWeakTimeInterval"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "msf_netWeakTimeInterval = " + (String)r.get("msf_netWeakTimeInterval"));
        }
        int i1 = Integer.parseInt((String)r.get("msf_netWeakTimeInterval"));
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
  
  public static int V()
  {
    try
    {
      if (r.containsKey("msf_pcactiveretrytimes"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "msf_pcactiveretrytimes = " + (String)r.get("msf_pcactiveretrytimes"));
        }
        int i1 = Integer.parseInt((String)r.get("msf_pcactiveretrytimes"));
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
  
  public static int W()
  {
    try
    {
      if (r.containsKey("msf_netWeakExceptionCount"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "msf_netWeakExceptionCount = " + (String)r.get("msf_netWeakExceptionCount"));
        }
        int i1 = Integer.parseInt((String)r.get("msf_netWeakExceptionCount"));
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
  
  public static long X()
  {
    if (r.containsKey("msf_CallQQIntervTimeOnBoot")) {
      try
      {
        long l1 = Long.parseLong(((String)r.get("msf_CallQQIntervTimeOnBoot")).trim());
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
  
  public static String Y()
  {
    if (r.containsKey("bigflow2g3g_ver2")) {
      return (String)r.get("bigflow2g3g_ver2");
    }
    return "40";
  }
  
  public static boolean Z()
  {
    if (r.containsKey("msf_StartNoStickyForMSFService")) {
      try
      {
        boolean bool = Boolean.parseBoolean(((String)r.get("msf_StartNoStickyForMSFService")).trim());
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
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "msfCore setAutoStaring " + paramBoolean);
      }
      B.set(paramBoolean);
      if (MsfStore.getNativeConfigStore() != null) {
        MsfStore.getNativeConfigStore().setConfig("_msf_isBootingKey", String.valueOf(paramBoolean));
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "storeAutoStaring " + paramBoolean);
      }
      return;
    }
    finally {}
  }
  
  public static boolean a(String paramString)
  {
    if (r.containsKey(paramString + "_isAutoBoot")) {
      try
      {
        boolean bool = Boolean.parseBoolean(((String)r.get(paramString + "_isAutoBoot")).trim());
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
      b.a(new ByteArrayInputStream(("<" + paramString1 + ">" + paramString2 + "</" + paramString1 + ">").getBytes("UTF-8")), r, paramString3);
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
  
  public static boolean aA()
  {
    if (r.containsKey("msf_StandbyTestAvailable")) {
      try
      {
        boolean bool = Boolean.parseBoolean(((String)r.get("msf_StandbyTestAvailable")).trim());
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
  
  public static int aB()
  {
    if (r.containsKey("msf_StandbyTestSeq")) {
      try
      {
        int i1 = Integer.parseInt(((String)r.get("msf_StandbyTestSeq")).trim());
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
  
  public static long aC()
  {
    try
    {
      if (r.containsKey("msf_tcpDumpTime"))
      {
        long l1 = Long.parseLong((String)r.get("msf_tcpDumpTime"));
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
  
  public static int aD()
  {
    if (r.containsKey("msf_RetryStartProcTimes")) {
      try
      {
        int i1 = Integer.parseInt(((String)r.get("msf_RetryStartProcTimes")).trim());
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
  
  public static int aE()
  {
    try
    {
      if (r.containsKey("msf_continueConnInterval"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_continueConnInterval"));
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
  
  public static int aF()
  {
    try
    {
      if (r.containsKey("msf_quickSendFastInterval"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_quickSendFastInterval"));
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
  
  public static int aG()
  {
    try
    {
      if (r.containsKey("msf_quickSendFastTimes"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_quickSendFastTimes"));
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
  
  public static boolean aH()
  {
    try
    {
      if (r.containsKey("msf_forceQuickSend1S"))
      {
        boolean bool = Boolean.parseBoolean((String)r.get("msf_forceQuickSend1S"));
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
  
  public static boolean aI()
  {
    try
    {
      if (r.containsKey("msf_applySocketAdaptorFeature"))
      {
        boolean bool = Boolean.parseBoolean((String)r.get("msf_applySocketAdaptorFeature"));
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
  
  public static boolean aJ()
  {
    try
    {
      if (r.containsKey("msf_innerSwitchForAdaptor"))
      {
        boolean bool = Boolean.parseBoolean((String)r.get("msf_innerSwitchForAdaptor"));
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
  
  public static int aK()
  {
    try
    {
      if (r.containsKey("msf_timeoutPkgToResetMode"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_timeoutPkgToResetMode"));
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
  
  public static int aL()
  {
    try
    {
      if (r.containsKey("msf_ExptionCountToResetMode"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_ExptionCountToResetMode"));
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
  
  public static long aM()
  {
    try
    {
      if (r.containsKey("msf_startHeartBeatProxyInterval"))
      {
        long l1 = Long.parseLong((String)r.get("msf_startHeartBeatProxyInterval"));
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
  
  public static int aN()
  {
    try
    {
      if (r.containsKey("msf_ExptionCountToCloseHeartbeat"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_ExptionCountToCloseHeartbeat"));
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
  
  public static int aO()
  {
    try
    {
      if (r.containsKey("msf_ResumeCountLimit"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_ResumeCountLimit"));
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
  
  public static long aP()
  {
    try
    {
      if (r.containsKey("msf_hwExceptionCheckInterval"))
      {
        long l1 = Long.parseLong((String)r.get("msf_hwExceptionCheckInterval"));
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
  
  public static boolean aQ()
  {
    try
    {
      if (r.containsKey("msf_applyHeartbeatProxyFeature"))
      {
        boolean bool = Boolean.parseBoolean((String)r.get("msf_applyHeartbeatProxyFeature"));
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
  
  public static int aR()
  {
    try
    {
      if (r.containsKey("msf_retryHeartbeatTestCount"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_retryHeartbeatTestCount"));
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
  
  public static int aS()
  {
    try
    {
      if (r.containsKey("msf_SortIpSocketErrorWeight"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_SortIpSocketErrorWeight"));
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
  
  public static int aT()
  {
    try
    {
      if (r.containsKey("msf_SortIpContinueRspTimeoutWeight"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_SortIpContinueRspTimeoutWeight"));
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
  
  public static int aU()
  {
    try
    {
      if (r.containsKey("msf_SortIpPingTimeoutWeight"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_SortIpPingTimeoutWeight"));
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
  
  public static int aV()
  {
    try
    {
      if (r.containsKey("msf_SortIpNetDetectFailedWeight"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_SortIpNetDetectFailedWeight"));
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
  
  public static int aW()
  {
    try
    {
      if (r.containsKey("msf_SortIpInvalidDataWeight"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_SortIpInvalidDataWeight"));
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
  
  public static int aX()
  {
    try
    {
      if (r.containsKey("msf_SortIpConnFullWeight"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_SortIpConnFullWeight"));
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
  
  public static boolean aY()
  {
    try
    {
      if (r.containsKey("msf_loginWithPicSt"))
      {
        boolean bool = Boolean.parseBoolean((String)r.get("msf_loginWithPicSt"));
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
  
  public static int aZ()
  {
    try
    {
      if (r.containsKey("msf_SingleWiFiSSIDStoreTimes"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_SingleWiFiSSIDStoreTimes"));
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
  
  public static boolean aa()
  {
    if (r.containsKey("msf_quickSendAvailable")) {
      try
      {
        boolean bool = Boolean.parseBoolean(((String)r.get("msf_quickSendAvailable")).trim());
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
  
  public static int ab()
  {
    try
    {
      if (r.containsKey("msf_getHttpRecvTimeout"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "msf_getHttpRecvTimeout = " + (String)r.get("msf_getHttpRecvTimeout"));
        }
        int i1 = Integer.parseInt((String)r.get("msf_getHttpRecvTimeout"));
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
  
  public static int ac()
  {
    try
    {
      if (r.containsKey("msf_getHttpReSendMessageConcurrentLimit"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "msf_getHttpReSendMessageConcurrentLimit = " + (String)r.get("msf_getHttpReSendMessageConcurrentLimit"));
        }
        int i1 = Integer.parseInt((String)r.get("msf_getHttpReSendMessageConcurrentLimit"));
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
  
  public static int ad()
  {
    try
    {
      if (r.containsKey("msf_getHttpReSendMessageTimeout"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "msf_getHttpReSendMessageTimeout = " + (String)r.get("msf_getHttpReSendMessageTimeout"));
        }
        int i1 = Integer.parseInt((String)r.get("msf_getHttpReSendMessageTimeout"));
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
  
  public static String[] ae()
  {
    if (r.containsKey("getQuickSendBlackList")) {
      return ((String)r.get("getQuickSendBlackList")).replaceAll("\\|", "#").split("#");
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.ConfigManager", 2, "getQuickSendBlackList not be found.");
    }
    return null;
  }
  
  public static String af()
  {
    if (r.containsKey("MsfCrashControlInfo")) {
      return (String)r.get("MsfCrashControlInfo");
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.ConfigManager", 2, "getMsfCrashControlInfo not found");
    }
    return null;
  }
  
  public static String ag()
  {
    if (r.containsKey("bigflowwifi_ver2")) {
      return (String)r.get("bigflowwifi_ver2");
    }
    return "20";
  }
  
  public static long ah()
  {
    try
    {
      if (r.containsKey("msf_basicTicketChangeInterval"))
      {
        long l1 = Long.parseLong((String)r.get("msf_basicTicketChangeInterval"));
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
  
  public static long ai()
  {
    try
    {
      if (r.containsKey("msf_webTicketChangeInterval"))
      {
        long l1 = Long.parseLong((String)r.get("msf_webTicketChangeInterval"));
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
  
  public static boolean aj()
  {
    if (r.containsKey("msf_basicTicketChangeLimit")) {
      try
      {
        boolean bool = Boolean.parseBoolean(((String)r.get("msf_basicTicketChangeLimit")).trim());
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
  
  public static boolean ak()
  {
    if (r.containsKey("msf_isReportDataCorrupt")) {
      try
      {
        boolean bool = Boolean.parseBoolean(((String)r.get("msf_isReportDataCorrupt")).trim());
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
  
  public static boolean al()
  {
    if (r.containsKey("msf_isDelayChangeWebKey")) {
      try
      {
        boolean bool = Boolean.parseBoolean(((String)r.get("msf_isDelayChangeWebKey")).trim());
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
  
  public static boolean am()
  {
    return B.get();
  }
  
  public static String[] av()
  {
    if (r.containsKey("StandbyMode")) {
      return ((String)r.get("StandbyMode")).replaceAll("\\|", ",").split(",");
    }
    QLog.d("MSF.C.ConfigManager", 1, "StandbyMode whitelist not be found.");
    return null;
  }
  
  public static boolean aw()
  {
    if (r.containsKey("msf_StandbyModeAvailable")) {
      try
      {
        boolean bool = Boolean.parseBoolean(((String)r.get("msf_StandbyModeAvailable")).trim());
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
  
  public static boolean ax()
  {
    if (r.containsKey("msf_isReqAllFailTest")) {
      try
      {
        boolean bool = Boolean.parseBoolean(((String)r.get("msf_isReqAllFailTest")).trim());
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
  
  public static CopyOnWriteArrayList ay()
  {
    localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    int i1;
    String[] arrayOfString4;
    com.tencent.mobileqq.msf.core.d locald;
    if (r.containsKey("ydconn")) {
      try
      {
        String[] arrayOfString1 = ((String)r.get("ydconn")).replaceAll("\\|", ",").split(",");
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
        if (!r.containsKey("ltconn")) {
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
        String[] arrayOfString2 = ((String)r.get("ltconn")).replaceAll("\\|", ",").split(",");
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
        if (!r.containsKey("dxconn")) {
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
      String[] arrayOfString3 = ((String)r.get("dxconn")).replaceAll("\\|", ",").split(",");
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
  
  public static CopyOnWriteArrayList az()
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
      if (r.containsKey(localObject)) {
        try
        {
          localObject = ((String)r.get(localObject)).replaceAll("\\|", ",").split(",");
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
  
  public static long ba()
  {
    try
    {
      if (r.containsKey("msf_ReportWiFiSSIDInterval"))
      {
        long l1 = Long.parseLong((String)r.get("msf_ReportWiFiSSIDInterval"));
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
  
  public static int bb()
  {
    try
    {
      if (r.containsKey("msf_aliveSplitLen"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_aliveSplitLen"));
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
  
  public static int bc()
  {
    try
    {
      if (r.containsKey("msf_aliveReportMax"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_aliveReportMax"));
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
  
  public static int bd()
  {
    try
    {
      if (r.containsKey("msf_aliveAutoInterval"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_aliveAutoInterval"));
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
  
  public static boolean be()
  {
    try
    {
      if (r.containsKey("msf_reportMsfAliveFull"))
      {
        boolean bool = Boolean.parseBoolean((String)r.get("msf_reportMsfAliveFull"));
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
  
  public static int bf()
  {
    try
    {
      if (r.containsKey("msf_RandomPushReportBase"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_RandomPushReportBase"));
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
  
  public static HashSet bg()
  {
    try
    {
      if (r.containsKey("msf_getPskeyDomains"))
      {
        Object localObject = (String)r.get("msf_getPskeyDomains");
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
  
  public static long bh()
  {
    try
    {
      if (r.containsKey("msf_StoreLogcatTriggerInterval"))
      {
        long l1 = Long.parseLong((String)r.get("msf_StoreLogcatTriggerInterval"));
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
  
  public static long bi()
  {
    try
    {
      if (r.containsKey("msf_LogcatStoreInterval"))
      {
        long l1 = Long.parseLong((String)r.get("msf_LogcatStoreInterval"));
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
  
  public static int bj()
  {
    try
    {
      if (r.containsKey("msf_logCompressLevel"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_logCompressLevel"));
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
  
  public static int bk()
  {
    try
    {
      if (r.containsKey("msf_MSFPullReportBase"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_MSFPullReportBase"));
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
  
  public static boolean bl()
  {
    try
    {
      if (r.containsKey("msf_reportPushDetail"))
      {
        boolean bool = Boolean.parseBoolean((String)r.get("msf_reportPushDetail"));
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
  
  public static long bm()
  {
    try
    {
      if (r.containsKey("msf_preDetectionAlarmTimeAlpha"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_preDetectionAlarmTimeAlpha"));
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
  
  public static long bn()
  {
    try
    {
      if (r.containsKey("msf_preDetectionAlarmTimeBeta"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_preDetectionAlarmTimeBeta"));
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
  
  public static boolean bo()
  {
    try
    {
      if (r.containsKey("msf_heartBeatSwtich"))
      {
        boolean bool = Boolean.parseBoolean((String)r.get("msf_heartBeatSwtich"));
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
  
  public static boolean bp()
  {
    try
    {
      if (r.containsKey("msf_quickHeartBeatSwitch"))
      {
        boolean bool = Boolean.parseBoolean((String)r.get("msf_quickHeartBeatSwitch"));
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
  
  public static int bq()
  {
    try
    {
      if (r.containsKey("msf_simpleGetTimeoutNumber"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_simpleGetTimeoutNumber"));
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
  
  public static int br()
  {
    try
    {
      if (r.containsKey("msf_apptimeout"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_apptimeout"));
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
  
  public static boolean bs()
  {
    try
    {
      if (r.containsKey("msf_getAllowWhileIdleSwtich"))
      {
        boolean bool = Boolean.parseBoolean((String)r.get("msf_getAllowWhileIdleSwtich"));
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
  
  public static int bt()
  {
    try
    {
      if (r.containsKey("msf_weaknet_config"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_weaknet_config"));
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
  
  public static boolean bu()
  {
    try
    {
      if (r.containsKey("msf_weaknetXGSendMsg"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_weaknetXGSendMsg"));
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
  
  public static boolean bv()
  {
    if ((!"x86".equals(com.tencent.mobileqq.msf.core.c.c(BaseApplication.getContext()))) || (QLog.isColorLevel())) {
      QLog.i("MSF.C.ConfigManager", 2, "isQuicEnabled enabled=" + false + " " + (String)r.get("quic_enable") + " reload=" + QuicWrapper.reload() + " isLoad=" + QuicWrapper.isLoaded);
    }
    return (0 != 0) && (QuicWrapper.reload());
  }
  
  public static int bw()
  {
    int i1 = g.j;
    try
    {
      if (r.containsKey("jobscheduler_enable")) {
        i1 = Integer.parseInt((String)r.get("jobscheduler_enable"));
      }
      QLog.d("MSF.C.ConfigManager", 1, new Object[] { "MSF_Alive_Log get config jobscheduler_enable=", Integer.valueOf(i1) });
      return i1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "MSF_Alive_Log get jobscheduler_enable error" + localException);
        }
        i1 = 0;
      }
    }
  }
  
  private void bx()
  {
    boolean bool2 = false;
    int i2;
    int i1;
    String str2;
    if (r.containsKey("msf_noReportRdmEvent")) {
      try
      {
        String[] arrayOfString1 = ((String)r.get("msf_noReportRdmEvent")).split(";");
        i2 = arrayOfString1.length;
        i1 = 0;
        while (i1 < i2)
        {
          str2 = arrayOfString1[i1];
          if (!str2.trim().equals(""))
          {
            s.add(str2);
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.ConfigManager", 2, "rdm event " + str2 + " set no report.");
            }
          }
          i1 += 1;
        }
        if (!r.containsKey("msf_needPrintLogCmd")) {
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
        String[] arrayOfString2 = ((String)r.get("msf_needPrintLogCmd")).split(";");
        i2 = arrayOfString2.length;
        i1 = 0;
        while (i1 < i2)
        {
          str2 = arrayOfString2[i1];
          if (!str2.trim().equals(""))
          {
            t.add(str2);
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.ConfigManager", 2, "msg " + str2 + " need print log.");
            }
          }
          i1 += 1;
        }
        if (!r.containsKey("msf_AnyPacketAsPushHB")) {}
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
        str1 = (String)r.get("msf_AnyPacketAsPushHB");
        if (!str1.equals("0")) {
          continue;
        }
        bool1 = false;
        u = bool1;
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
      if (r.containsKey("msf_preDetectionSupport")) {}
      try
      {
        str1 = (String)r.get("msf_preDetectionSupport");
        if (!str1.equals("0")) {
          continue;
        }
        bool1 = false;
        v = bool1;
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
      if (r.containsKey("msf_simpleGetReportSwitch")) {}
      try
      {
        str1 = (String)r.get("msf_simpleGetReportSwitch");
        if (!str1.equals("0")) {
          break label625;
        }
        bool1 = bool2;
        w = bool1;
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
  
  private void by()
  {
    try
    {
      String[] arrayOfString = av();
      if ((arrayOfString != null) && (this.A.getStandyModeManager() != null)) {
        this.A.getStandyModeManager().a(arrayOfString);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.ConfigManager", 1, " " + localException, localException);
    }
  }
  
  private void bz()
  {
    try
    {
      String[] arrayOfString = c();
      if (arrayOfString != null)
      {
        this.A.sender.j = Integer.parseInt(arrayOfString[0]);
        this.A.sender.k = Integer.parseInt(arrayOfString[1]);
        this.A.sender.o = Integer.parseInt(arrayOfString[2]);
        this.A.sender.m = Integer.parseInt(arrayOfString[3]);
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
          this.A.sender.a(arrayOfString);
          try
          {
            this.A.sender.n = Integer.parseInt(e());
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
    if (r.containsKey("MultiPkgPara"))
    {
      String[] arrayOfString = ((String)r.get("MultiPkgPara")).replaceAll("\\|", ",").split(",");
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
    if (r.containsKey("MultiPkgWL")) {
      return ((String)r.get("MultiPkgWL")).replaceAll("\\|", ",").split(",");
    }
    QLog.d("MSF.C.ConfigManager", 1, "login merge whitelist not be found.");
    return null;
  }
  
  public static Object e(String paramString)
  {
    return r.get(paramString);
  }
  
  public static String e()
  {
    if (r.containsKey("AndroidMergeDuration")) {
      return (String)r.get("AndroidMergeDuration");
    }
    QLog.d("MSF.C.ConfigManager", 1, "login merge duration not be found.");
    return "0";
  }
  
  public static String f()
  {
    if (r.contains("NetFlowMax")) {
      return (String)r.get("NetFlowMax");
    }
    return "10485760";
  }
  
  public static boolean g()
  {
    if (r.containsKey("monitor_ipHostReportSwitch")) {
      try
      {
        boolean bool = Boolean.parseBoolean((String)r.get("monitor_ipHostReportSwitch"));
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
    if (r.containsKey("msf_locallogtime")) {
      return (String)r.get("msf_locallogtime");
    }
    return "3";
  }
  
  public static String i()
  {
    if (r.containsKey("msf_checkSsoIntervtime")) {
      return (String)r.get("msf_checkSsoIntervtime");
    }
    return "300000";
  }
  
  public static boolean j()
  {
    if (r.containsKey("msf_useLastOpenAddress")) {
      try
      {
        boolean bool = Boolean.parseBoolean((String)r.get("msf_useLastOpenAddress"));
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
    if (r.containsKey("msf_limitWtChangetoken")) {
      try
      {
        boolean bool = Boolean.parseBoolean((String)r.get("msf_limitWtChangetoken"));
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
    if (r.containsKey("msf_isSetReloadKeyUin")) {
      try
      {
        boolean bool = Boolean.parseBoolean((String)r.get("msf_isSetReloadKeyUin"));
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
      if (r.contains("DeepSleepMaxInterval"))
      {
        long l1 = Long.parseLong((String)r.get("DeepSleepMaxInterval"));
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
      if (r.containsKey("msf_isUseWtlogin"))
      {
        boolean bool = Boolean.parseBoolean((String)r.get("msf_isUseWtlogin"));
        return bool;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "msf_isUseWtlogin error" + localException);
      }
    }
    return z;
  }
  
  public static long o()
  {
    try
    {
      if (r.containsKey("msf_standbyWaitInterval"))
      {
        long l1 = Long.parseLong((String)r.get("msf_standbyWaitInterval"));
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
      if (r.containsKey("msf_compressLogDelay"))
      {
        long l1 = Long.parseLong((String)r.get("msf_compressLogDelay"));
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
      if (r.containsKey("msf_LogClearInterval"))
      {
        long l1 = Long.parseLong((String)r.get("msf_LogClearInterval"));
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
      if (r.containsKey("msf_newLogClearStrategy"))
      {
        boolean bool = Boolean.parseBoolean((String)r.get("msf_newLogClearStrategy"));
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
      if (r.containsKey("msf_newLogClearStrategyTest"))
      {
        boolean bool = Boolean.parseBoolean((String)r.get("msf_newLogClearStrategyTest"));
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
      if (r.containsKey("msf_newLogClearStrategyTestShutdown"))
      {
        boolean bool = Boolean.parseBoolean((String)r.get("msf_newLogClearStrategyTestShutdown"));
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
      if (r.containsKey("msf_pingTimeout"))
      {
        long l1 = Long.parseLong((String)r.get("msf_pingTimeout"));
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
      if (r.containsKey("msf_ssopingavailable"))
      {
        boolean bool = Boolean.parseBoolean((String)r.get("msf_ssopingavailable"));
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
      if (r.containsKey("msf_connFastDetect"))
      {
        boolean bool = Boolean.parseBoolean((String)r.get("msf_connFastDetect"));
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
      if (r.containsKey("msf_activePreDetect"))
      {
        boolean bool = Boolean.parseBoolean((String)r.get("msf_activePreDetect"));
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
  
  public static boolean y()
  {
    boolean bool1 = false;
    try
    {
      if (Build.VERSION.SDK_INT < 28)
      {
        bool1 = false;
      }
      else if (!r.containsKey("msf_reconnWhenMobileToWifi"))
      {
        bool1 = false;
      }
      else
      {
        boolean bool2 = Boolean.parseBoolean((String)r.get("msf_reconnWhenMobileToWifi"));
        if (!bool2) {
          bool1 = false;
        } else {
          bool1 = true;
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.ConfigManager", 2, "getReconnWhenMobileToWiFi error" + localException);
        return false;
      }
    }
    return bool1;
  }
  
  public static long z()
  {
    try
    {
      if (r.containsKey("msf_preDetectTimeout"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_preDetectTimeout"));
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
  
  public int a(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg.getWupBuffer() != null) && (paramToServiceMsg.getWupBuffer().length > 0)) {}
    for (;;)
    {
      this.A.sendSsoMsg(paramToServiceMsg);
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
  {
    paramHashMap = a(paramString, paramHashMap);
    paramString = new ToServiceMsg("", "0", "CliLogSvc.UploadReq");
    paramString.setAppId(this.A.sender.k());
    paramString.setRequestSsoSeq(MsfCore.getNextSeq());
    paramString.setTimeout(30000L);
    paramString.setNeedCallback(false);
    paramString.putWupBuffer(paramHashMap);
    return this.A.sendSsoMsg(paramString);
  }
  
  public void a()
  {
    b();
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
          if ((paramf.b != 0) && (y != paramf.b)) {
            break label631;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.ConfigManager", 2, "handle config,  iGetSdkLastTime is obsolete, skip...");
          }
          if ((paramf.g != 0) && (x != paramf.g)) {
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
        y = paramf.b;
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
          MsfSdkUtils.writeServerConfig("com.tencent.mobileqq", 0, str1, this.A.sender.j());
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
      x = paramf.g;
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
        MsfSdkUtils.writeServerConfig("com.tencent.mobileqq", 2, paramToServiceMsg, this.A.sender.j());
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
          MsfSdkUtils.writeServerConfig("com.tencent.mobileqq", 1, paramToServiceMsg, this.A.sender.j());
          MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_iConfGetEspLastTimeKe", String.valueOf(paramf.e));
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.ConfigManager", 4, "save confReq getiConfGetEspLastTimeKey" + paramf.e);
          }
          bx();
          bz();
          by();
          this.A.quicksender.b();
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
        Iterator localIterator = this.K.iterator();
        while (localIterator.hasNext())
        {
          a.a locala = (a.a)localIterator.next();
          if (((String)localObject2).equals(locala.c)) {
            this.K.remove(locala);
          } else if (((((String)localObject2).endsWith(".*")) || (locala.c.endsWith(".*"))) && (locala.c.startsWith((String)localObject3))) {
            this.K.remove(locala);
          }
        }
        localObject3 = new a.a(this);
        ((a.a)localObject3).c = ((String)localObject2);
        ((a.a)localObject3).a = l1;
        ((a.a)localObject3).b = ((com.tencent.msf.service.protocol.d.a)localObject1);
        this.K.add(localObject3);
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
    if (aq())
    {
      if (!NetConnInfoCenter.isMobileConn()) {
        break label85;
      }
      D = paramLong;
      MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_checkmobilessotime", String.valueOf(D));
      F = D + 3600000L;
      ar();
    }
    try
    {
      this.A.getSsoListManager().a(paramToServiceMsg.getAppId(), paramToServiceMsg.getUin(), 60000L, NetConnInfoCenter.isWifiConn(), "", false);
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          a(paramToServiceMsg.getUin(), 60000);
          return;
          label85:
          if (NetConnInfoCenter.isWifiConn())
          {
            E = paramLong;
            MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_checkwifissotime", String.valueOf(E));
            G = E + 3600000L;
            as();
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
    byte[] arrayOfByte = at();
    ToServiceMsg localToServiceMsg = new ToServiceMsg("", paramString, "ConfigService.ClientReq");
    localToServiceMsg.setMsfCommand(MsfCommand._msf_getConfig);
    localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
    if (this.A.getMsfAppid() == -1) {}
    for (int i1 = 100;; i1 = this.A.getMsfAppid())
    {
      localToServiceMsg.setAppId(i1);
      localToServiceMsg.putWupBuffer(arrayOfByte);
      localToServiceMsg.setTimeout(paramInt);
      this.A.sender.b(localToServiceMsg);
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
  
  public String an()
  {
    return d(MsfStore.getNativeConfigStore().getConfig("__loginSdk_iconf_UserCommCon"));
  }
  
  public String ao()
  {
    return d(MsfStore.getNativeConfigStore().getConfig("__loginSdk_iconf_AppConf"));
  }
  
  public String ap()
  {
    return d(MsfStore.getNativeConfigStore().getConfig("__loginSdk_iconf_Msf"));
  }
  
  public boolean aq()
  {
    long l1 = System.currentTimeMillis();
    if (NetConnInfoCenter.isMobileConn()) {
      if (D != 0L) {}
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
              if (F != 0L) {
                break;
              }
            } while (l1 - D >= 43200000L);
            return false;
          } while (l1 >= F);
          return false;
          if (!NetConnInfoCenter.isWifiConn()) {
            break;
          }
        } while (E == 0L);
        if (G != 0L) {
          break;
        }
      } while (l1 - E >= 43200000L);
      return false;
    } while (l1 >= G);
    return false;
    return false;
  }
  
  public void ar()
  {
    MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_mobilessotime", String.valueOf(F));
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.ConfigManager", 2, "save next get mobile sso time is " + this.A.timeFormatter.format(Long.valueOf(F)));
    }
  }
  
  public void as()
  {
    MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_wifissotime", String.valueOf(G));
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.ConfigManager", 2, "save next get Wifi sso time is " + this.A.timeFormatter.format(Long.valueOf(G)));
    }
  }
  
  public byte[] at()
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
    x = Integer.parseInt((String)localObject1);
    if (x == 0) {
      x = 1;
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
    y = Integer.parseInt((String)localObject1);
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
    locale.e = x;
    locale.b = y;
    locale.d = i1;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.ConfigManager", 2, "load confReq iGetAppidTime" + locale.e + " iGetSdkLastTime:" + locale.b + " iGetEspLastTime:" + locale.d);
    }
    localObject2 = this.A.getAccountCenter().d();
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
  
  public ConcurrentHashMap au()
  {
    return r;
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
      return this.A.sendSsoMsg(paramToServiceMsg);
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
    D = Long.parseLong((String)localObject);
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
    E = Long.parseLong((String)localObject);
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
    F = Long.parseLong((String)localObject);
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
    G = Long.parseLong((String)localObject);
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
    Object localObject = ap();
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      a("msfConfig", (String)localObject, "");
    }
    localObject = an();
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      a("commonConfig", (String)localObject, "");
    }
    localObject = ao();
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      a("appidConfig", (String)localObject, "");
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.ConfigManager", 4, (String)localObject);
    }
    localObject = this.A.getAccountCenter().c().iterator();
    while (((Iterator)localObject).hasNext())
    {
      str1 = (String)((Iterator)localObject).next();
      String str2 = b(str1);
      if ((str2 != null) && (str2.length() > 0)) {
        a("userConfig", str2, str1 + "_");
      }
    }
    bx();
  }
  
  public String c(ToServiceMsg paramToServiceMsg)
  {
    switch (((Integer)paramToServiceMsg.getAttributes().get("to_getServerConfig_type")).intValue())
    {
    default: 
      return null;
    case 0: 
      return an();
    case 1: 
      return b(paramToServiceMsg.getUin());
    }
    return ao();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.a.a
 * JD-Core Version:    0.7.0.1
 */