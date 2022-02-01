package com.tencent.mobileqq.msf.core.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.ad;
import com.tencent.mobileqq.msf.core.auth.l;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.mobileqq.msf.core.quic.QuicWrapper;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.k;
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getHeartBeatTimeout error");
          localStringBuilder.append(localException);
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getConnFastDetectDelay error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getConnFastDetectTimeout error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getAutoReconnInterval error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCheckChangeTokenInterval error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getChangeTokenRequestInterval error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getHeartBeatTimeout error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getQuickHeartBeatReConnInterval error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getHeartBeatRetryCount error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getBusPacketTimeoutMaxNum error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getBusPacketTimeoutMaxNum error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getUpdateServerTimePacketTimeoutMaxNum error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getUpdateServerTimePacketTimeoutExtraInterval error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCheckServerTimeCompareInterval error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("msf_heartBeatTimeInterval = ");
          localStringBuilder1.append((String)r.get("msf_heartBeatTimeInterval"));
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder1.toString());
        }
        int i1 = Integer.parseInt((String)r.get("msf_heartBeatTimeInterval"));
        return i1 * 60 * 1000;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("getHeartBeatTimeInterval error");
        localStringBuilder2.append(localException);
        QLog.d("MSF.C.ConfigManager", 4, localStringBuilder2.toString());
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("msf_preHeartBeatTimeInterval = ");
          localStringBuilder1.append((String)r.get("msf_preHeartBeatTimeInterval"));
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder1.toString());
        }
        int i1 = Integer.parseInt((String)r.get("msf_preHeartBeatTimeInterval"));
        return i1 * 1000;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("getPreHeartBeatTimeInterval error");
        localStringBuilder2.append(localException);
        QLog.d("MSF.C.ConfigManager", 4, localStringBuilder2.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getUpdateHBTimeSwtich error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("msf_netIdleTimeInterval = ");
          localStringBuilder1.append((String)r.get("msf_netIdleTimeInterval"));
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder1.toString());
        }
        int i1 = Integer.parseInt((String)r.get("msf_netIdleTimeInterval"));
        return i1 * 60 * 1000;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("getNetIdleTimeInterval error");
        localStringBuilder2.append(localException);
        QLog.d("MSF.C.ConfigManager", 4, localStringBuilder2.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTcpdumpSSOVip error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("TcpdumpSSOTime = ");
          localStringBuilder1.append((String)r.get("TcpdumpSSOTime"));
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder1.toString());
        }
        int i1 = Integer.parseInt((String)r.get("TcpdumpSSOTime"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("getTcpdumpSSOTime error");
        localStringBuilder2.append(localException);
        QLog.d("MSF.C.ConfigManager", 4, localStringBuilder2.toString());
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("msf_netWeakTimeInterval = ");
          localStringBuilder1.append((String)r.get("msf_netWeakTimeInterval"));
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder1.toString());
        }
        int i1 = Integer.parseInt((String)r.get("msf_netWeakTimeInterval"));
        return i1 * 60 * 1000;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("getNetWeakTimeInterval error");
        localStringBuilder2.append(localException);
        QLog.d("MSF.C.ConfigManager", 4, localStringBuilder2.toString());
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("msf_pcactiveretrytimes = ");
          localStringBuilder1.append((String)r.get("msf_pcactiveretrytimes"));
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder1.toString());
        }
        int i1 = Integer.parseInt((String)r.get("msf_pcactiveretrytimes"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("msf_pcactiveretrytimes error");
        localStringBuilder2.append(localException);
        QLog.d("MSF.C.ConfigManager", 4, localStringBuilder2.toString());
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("msf_netWeakExceptionCount = ");
          localStringBuilder1.append((String)r.get("msf_netWeakExceptionCount"));
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder1.toString());
        }
        int i1 = Integer.parseInt((String)r.get("msf_netWeakExceptionCount"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("getNetWeakExceptionCount error");
        localStringBuilder2.append(localException);
        QLog.d("MSF.C.ConfigManager", 4, localStringBuilder2.toString());
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" get CallQQIntervTimeOnBoot error ");
          localStringBuilder.append(localNumberFormatException);
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" set msf_StartNoStickyForMSFService error ");
          localStringBuilder.append(localException);
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
        }
      }
    }
    return false;
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("msfCore setAutoStaring ");
        localStringBuilder.append(paramBoolean);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
      }
      B.set(paramBoolean);
      if (MsfStore.getNativeConfigStore() != null) {
        MsfStore.getNativeConfigStore().setConfig("_msf_isBootingKey", String.valueOf(paramBoolean));
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("storeAutoStaring ");
        localStringBuilder.append(paramBoolean);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  public static boolean a(String paramString)
  {
    ConcurrentHashMap localConcurrentHashMap = r;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_isAutoBoot");
    if (localConcurrentHashMap.containsKey(localStringBuilder.toString())) {
      try
      {
        localConcurrentHashMap = r;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("_isAutoBoot");
        boolean bool = Boolean.parseBoolean(((String)localConcurrentHashMap.get(localStringBuilder.toString())).trim());
        return bool;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append(" set isAutoBoot error ");
          localStringBuilder.append(localException);
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(">");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("</");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(">");
      b.a(new ByteArrayInputStream(localStringBuilder.toString().getBytes("UTF-8")), r, paramString3);
      return true;
    }
    catch (Exception paramString2)
    {
      if (QLog.isColorLevel())
      {
        paramString3 = new StringBuilder();
        paramString3.append("parse ");
        paramString3.append(paramString1);
        paramString3.append("Config error ");
        paramString3.append(paramString2);
        QLog.d("MSF.C.ConfigManager", 2, paramString3.toString(), paramString2);
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" set isStandbyTestAvailable error ");
          localStringBuilder.append(localException);
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" set getStandbyTestSeq error ");
          localStringBuilder.append(localException);
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTcpDumpTime error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" set getRetryStartProcessTimes error ");
          localStringBuilder.append(localException);
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getContinueConnInterval error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getQuickSendFastInterval error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getQuickSendFastTimes error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getForceQuickSend1S error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("applySocketAdaptorFeature error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("innerSwitchForAdaptor error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("timeoutPkgToResetMode error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ExptionCountToResetMode error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startHeartBeatProxyInterval error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ExptionCountToCloseHeartbeat error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ResumeCountLimit error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("hwExceptionCheckInterval error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("applyHeartbeatProxyFeature error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("retryHeartbeatTestCount error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSortIpSocketErrorWeight error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSortIpContinueRspTimeoutWeight error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSortIpPingTimeoutWeight error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSortIpNetDetectFailedWeight error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSortIpInvalidDataWeight error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSortIpConnFullWeight error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loginWithPicSt error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSingleWiFiSSIDStoreTimes error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" set isPermitQuickTimeoutCheck error ");
          localStringBuilder.append(localException);
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("msf_getHttpRecvTimeout = ");
          localStringBuilder1.append((String)r.get("msf_getHttpRecvTimeout"));
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder1.toString());
        }
        int i1 = Integer.parseInt((String)r.get("msf_getHttpRecvTimeout"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("getHttpRecvTimeout error");
        localStringBuilder2.append(localException);
        QLog.d("MSF.C.ConfigManager", 4, localStringBuilder2.toString());
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("msf_getHttpReSendMessageConcurrentLimit = ");
          localStringBuilder1.append((String)r.get("msf_getHttpReSendMessageConcurrentLimit"));
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder1.toString());
        }
        int i1 = Integer.parseInt((String)r.get("msf_getHttpReSendMessageConcurrentLimit"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("getHttpReSendMessageConcurrentLimit error");
        localStringBuilder2.append(localException);
        QLog.d("MSF.C.ConfigManager", 4, localStringBuilder2.toString());
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("msf_getHttpReSendMessageTimeout = ");
          localStringBuilder1.append((String)r.get("msf_getHttpReSendMessageTimeout"));
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder1.toString());
        }
        int i1 = Integer.parseInt((String)r.get("msf_getHttpReSendMessageTimeout"));
        return i1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("getHttpReSendMessageTimeout error");
        localStringBuilder2.append(localException);
        QLog.d("MSF.C.ConfigManager", 4, localStringBuilder2.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getBasicTicketChangeInterval error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getWebTicketChangeInterval error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" set isBasicTicketChangeLimit error ");
          localStringBuilder.append(localException);
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" set msf_isReportDataCorrupt error ");
          localStringBuilder.append(localException);
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" set msf_isDelayChangeWebKey error ");
          localStringBuilder.append(localException);
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" set isStandbyModeAvailable error ");
          localStringBuilder.append(localException);
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" set isReqAllFailTest error ");
          localStringBuilder.append(localException);
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
    Object localObject = o.e();
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    if (localObject == null) {
      return null;
    }
    if ((!((String)localObject).startsWith("460")) && (!((String)localObject).startsWith("461"))) {
      return null;
    }
    if ((!((String)localObject).startsWith("46000")) && (!((String)localObject).startsWith("46002")))
    {
      if (((String)localObject).startsWith("46001")) {
        localObject = "ltconn";
      } else if (((String)localObject).startsWith("46003")) {
        localObject = "dxconn";
      } else {
        return null;
      }
    }
    else {
      localObject = "ydconn";
    }
    if (r.containsKey(localObject)) {
      try
      {
        localObject = ((String)r.get(localObject)).replaceAll("\\|", ",").split(",");
        int i1 = 0;
        while (i1 < localObject.length)
        {
          String[] arrayOfString = localObject[i1].split(":");
          com.tencent.mobileqq.msf.core.d locald = new com.tencent.mobileqq.msf.core.d();
          locald.c(arrayOfString[0]);
          locald.a(Integer.parseInt(arrayOfString[1]));
          localCopyOnWriteArrayList.add(locald);
          i1 += 1;
        }
        return localCopyOnWriteArrayList;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
    }
    QLog.d("MSF.C.ConfigManager", 1, "getReqAllFailDetectXGSSOList not be found.");
    return null;
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getReportWiFiSSIDInterval error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getMsfAliveSplitLen error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getMsfAliveReportMax error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getMsfAliveAutoInterval error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportMsfAliveFull error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getRandomPushReportBase error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      StringBuilder localStringBuilder;
      return l.c;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getPskeyDomains error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getStoreLogcatTriggerInterval error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getLogcatStoreInterval error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getLogCompressLevel error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getMSFPullReportBase error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportPushDetail error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getPreDetectionAlarmTimeAlpha error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getPreDetectionAlarmTimeBeta error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getHeartBeatSwtich error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getQuickHeartBeatSwitch error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSimpleGetTimeoutNumber error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getAppTimeout error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getAllowWhileIdleSwtich error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("msf_weaknet_config error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
      }
    }
    return 0;
  }
  
  public static boolean bu()
  {
    boolean bool = false;
    try
    {
      if (r.containsKey("msf_weaknetXGSendMsg"))
      {
        int i1 = Integer.parseInt((String)r.get("msf_weaknetXGSendMsg"));
        if (i1 != 0) {
          bool = true;
        }
        return bool;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getWeaknetXGSendMsg error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
      }
    }
    return false;
  }
  
  public static boolean bv()
  {
    "x86".equals(com.tencent.mobileqq.msf.core.c.c(BaseApplication.getContext()));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isQuicEnabled enabled=");
      localStringBuilder.append(false);
      localStringBuilder.append(" ");
      localStringBuilder.append((String)r.get("quic_enable"));
      localStringBuilder.append(" reload=");
      localStringBuilder.append(QuicWrapper.reload());
      localStringBuilder.append(" isLoad=");
      localStringBuilder.append(QuicWrapper.isLoaded);
      QLog.i("MSF.C.ConfigManager", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public static int bw()
  {
    int i1 = k.j;
    try
    {
      if (r.containsKey("jobscheduler_enable")) {
        i1 = Integer.parseInt((String)r.get("jobscheduler_enable"));
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("MSF_Alive_Log get jobscheduler_enable error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
      }
      i1 = 0;
    }
    QLog.d("MSF.C.ConfigManager", 1, new Object[] { "MSF_Alive_Log get config jobscheduler_enable=", Integer.valueOf(i1) });
    return i1;
  }
  
  private void bx()
  {
    int i2;
    int i1;
    Object localObject;
    StringBuilder localStringBuilder;
    if (r.containsKey("msf_noReportRdmEvent")) {
      try
      {
        String[] arrayOfString1 = ((String)r.get("msf_noReportRdmEvent")).split(";");
        i2 = arrayOfString1.length;
        i1 = 0;
        while (i1 < i2)
        {
          localObject = arrayOfString1[i1];
          if (!((String)localObject).trim().equals(""))
          {
            s.add(localObject);
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("rdm event ");
              localStringBuilder.append((String)localObject);
              localStringBuilder.append(" set no report.");
              QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
            }
          }
          i1 += 1;
        }
        if (!r.containsKey("msf_needPrintLogCmd")) {
          break label352;
        }
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("set msf_noReportRdmEvent error ");
          ((StringBuilder)localObject).append(localException1);
          QLog.d("MSF.C.ConfigManager", 2, ((StringBuilder)localObject).toString());
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
          localObject = arrayOfString2[i1];
          if (!((String)localObject).trim().equals(""))
          {
            t.add(localObject);
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("msg ");
              localStringBuilder.append((String)localObject);
              localStringBuilder.append(" need print log.");
              QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
            }
          }
          i1 += 1;
        }
        bool1 = r.containsKey("msf_AnyPacketAsPushHB");
      }
      catch (Exception localException2)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("set msf_noReportRdmEvent error ");
          ((StringBuilder)localObject).append(localException2);
          QLog.d("MSF.C.ConfigManager", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    label352:
    boolean bool1;
    boolean bool2 = true;
    if (bool1) {
      try
      {
        String str1 = (String)r.get("msf_AnyPacketAsPushHB");
        if (!str1.equals("0")) {
          break label767;
        }
        bool1 = false;
        u = bool1;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("config useAnyPacketAsPushHB ");
          ((StringBuilder)localObject).append(str1);
          QLog.d("MSF.C.ConfigManager", 2, ((StringBuilder)localObject).toString());
        }
      }
      catch (Exception localException3)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("set msf_noReportRdmEvent error ");
          ((StringBuilder)localObject).append(localException3);
          QLog.d("MSF.C.ConfigManager", 2, ((StringBuilder)localObject).toString());
        }
      }
    } else if (!r.containsKey("msf_preDetectionSupport")) {}
    for (;;)
    {
      try
      {
        String str2 = (String)r.get("msf_preDetectionSupport");
        if (!str2.equals("0")) {
          break label772;
        }
        bool1 = false;
        v = bool1;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("config msf_preDetectionSupport ");
          ((StringBuilder)localObject).append(str2);
          QLog.d("MSF.C.ConfigManager", 2, ((StringBuilder)localObject).toString());
        }
      }
      catch (Exception localException4)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("set msf_preDetectionSupport error ");
          ((StringBuilder)localObject).append(localException4);
          QLog.d("MSF.C.ConfigManager", 2, ((StringBuilder)localObject).toString());
        }
      }
      if (r.containsKey("msf_simpleGetReportSwitch")) {
        try
        {
          String str3 = (String)r.get("msf_simpleGetReportSwitch");
          bool1 = bool2;
          if (str3.equals("0")) {
            bool1 = false;
          }
          w = bool1;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("config msf_simpleGetReportSwitch ");
            ((StringBuilder)localObject).append(str3);
            QLog.d("MSF.C.ConfigManager", 2, ((StringBuilder)localObject).toString());
            return;
          }
        }
        catch (Exception localException5)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("set msf_simpleGetReportSwitch error ");
            ((StringBuilder)localObject).append(localException5);
            QLog.d("MSF.C.ConfigManager", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
      return;
      label767:
      bool1 = true;
      break;
      label772:
      bool1 = true;
    }
  }
  
  private void by()
  {
    try
    {
      String[] arrayOfString = av();
      if ((arrayOfString != null) && (this.A.getStandyModeManager() != null))
      {
        this.A.getStandyModeManager().a(arrayOfString);
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" ");
      localStringBuilder.append(localException);
      QLog.d("MSF.C.ConfigManager", 1, localStringBuilder.toString(), localException);
    }
  }
  
  private void bz()
  {
    StringBuilder localStringBuilder;
    try
    {
      String[] arrayOfString1 = c();
      if (arrayOfString1 != null)
      {
        this.A.sender.j = Integer.parseInt(arrayOfString1[0]);
        this.A.sender.k = Integer.parseInt(arrayOfString1[1]);
        this.A.sender.o = Integer.parseInt(arrayOfString1[2]);
        this.A.sender.m = Integer.parseInt(arrayOfString1[3]);
      }
    }
    catch (Exception localException1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" ");
      localStringBuilder.append(localException1);
      QLog.d("MSF.C.ConfigManager", 1, localStringBuilder.toString(), localException1);
    }
    try
    {
      String[] arrayOfString2 = d();
      this.A.sender.a(arrayOfString2);
    }
    catch (Exception localException2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" ");
      localStringBuilder.append(localException2);
      QLog.d("MSF.C.ConfigManager", 1, localStringBuilder.toString(), localException2);
    }
    try
    {
      this.A.sender.n = Integer.parseInt(e());
      return;
    }
    catch (Exception localException3)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" ");
      localStringBuilder.append(localException3);
      QLog.d("MSF.C.ConfigManager", 1, localStringBuilder.toString(), localException3);
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
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Str2HexStr error ");
        localStringBuilder.append(paramString);
        QLog.d("MSF.C.ConfigManager", 4, localStringBuilder.toString(), paramString);
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("HexStr2Str error ");
        localStringBuilder.append(paramString);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString(), paramString);
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("get ipHostReportSwitch error ");
          localStringBuilder.append(localException);
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("get useLastOpenAddress error ");
          localStringBuilder.append(localException);
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("get msf_limitWtChangetoken error ");
          localStringBuilder.append(localException);
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("get msf_isSetReloadKeyUin error ");
          localStringBuilder.append(localException);
          QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get DeepSleepMaxInterval error ");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("msf_isUseWtlogin error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get standbyWaitInterval error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get getCompressLogDelay error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get getLogClearInterval error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getNewLogClearStrategy error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getNewLogClearStrategyTest error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getNewLogClearStrategyTestShutdown error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get getSSOPingTimeout error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get getSSOPingAvailable error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get getConnFastDetectAvailable error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getActivePreDetect error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
      }
    }
    return true;
  }
  
  public static boolean y()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 28) {
        return false;
      }
      if (!r.containsKey("msf_reconnWhenMobileToWifi")) {
        return false;
      }
      boolean bool = Boolean.parseBoolean((String)r.get("msf_reconnWhenMobileToWifi"));
      return bool;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getReconnWhenMobileToWiFi error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
      }
    }
    return false;
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getPreDetectTimeout error");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
      }
    }
    return 10000L;
  }
  
  public int a(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg.getWupBuffer() == null) || (paramToServiceMsg.getWupBuffer().length <= 0))
    {
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
    this.A.sendSsoMsg(paramToServiceMsg);
    return paramToServiceMsg.getRequestSsoSeq();
  }
  
  public int a(HashMap paramHashMap, String paramString)
  {
    paramHashMap = a(paramString, paramHashMap);
    paramString = new ToServiceMsg("", "0", "CliLogSvc.UploadReq");
    paramString.setAppId(this.A.sender.m());
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
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("recvServerConfig: ");
      paramToServiceMsg.append(paramf);
      QLog.d("MSF.C.ConfigManager", 2, paramToServiceMsg.toString());
    }
    if (paramf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "configInfo.iUpdateType is null , return");
      }
      return;
    }
    if (paramf.a != 1)
    {
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("configInfo.iUpdateType is ");
        paramFromServiceMsg.append(paramf.a);
        paramFromServiceMsg.append(" , return");
        QLog.d("MSF.C.ConfigManager", 2, paramFromServiceMsg.toString());
      }
      return;
    }
    paramToServiceMsg = paramf.d;
    if ((paramToServiceMsg != null) && (paramToServiceMsg.length() != 0))
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handle sConf ");
        ((StringBuilder)localObject1).append(paramf.d);
        QLog.d("MSF.C.ConfigManager", 2, ((StringBuilder)localObject1).toString());
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handle sEspConf ");
        ((StringBuilder)localObject1).append(paramf.f);
        QLog.d("MSF.C.ConfigManager", 2, ((StringBuilder)localObject1).toString());
      }
      int i1 = paramToServiceMsg.indexOf("<MSF>");
      int i2 = paramToServiceMsg.indexOf("</MSF>");
      Object localObject3 = "";
      Object localObject4;
      if ((i1 != -1) && (i2 != -1) && (i1 < i2))
      {
        localObject1 = paramToServiceMsg.substring(i1 + 5, i2);
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(paramToServiceMsg.substring(0, i1));
        ((StringBuilder)localObject4).append(paramToServiceMsg.substring(i2 + 6, paramToServiceMsg.length()));
        paramToServiceMsg = ((StringBuilder)localObject4).toString();
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, "handle config MSF null, skip");
        }
        localObject1 = "";
      }
      i1 = paramToServiceMsg.indexOf("<quic_enable>");
      i2 = paramToServiceMsg.indexOf("</quic_enable>");
      if ((i1 > 0) && (i2 > 0) && (i1 <= i2))
      {
        localObject4 = paramToServiceMsg.substring(i1 + 13, i2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse config str_quic_enable: ");
        localStringBuilder.append((String)localObject4);
        QLog.d("MSF.C.ConfigManager", 1, localStringBuilder.toString());
      }
      else
      {
        QLog.d("MSF.C.ConfigManager", 1, "parse quic_enable config error");
      }
      if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
        if (a("msfConfig", (String)localObject1, ""))
        {
          localObject1 = c((String)localObject1);
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("recv config str_msf: ");
            ((StringBuilder)localObject4).append((String)localObject1);
            QLog.d("MSF.C.ConfigManager", 2, ((StringBuilder)localObject4).toString());
          }
          MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_iconf_Msf", (String)localObject1);
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("MSF.C.ConfigManager", 2, "parse msfConf error , skip store.");
        }
      }
      if ((paramf.b != 0) && (y != paramf.b))
      {
        y = paramf.b;
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("save confReq iGetSdkNewTime");
          ((StringBuilder)localObject1).append(paramf.b);
          QLog.d("MSF.C.ConfigManager", 4, ((StringBuilder)localObject1).toString());
        }
        MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_iConfSdkLastTimeKey", String.valueOf(paramf.b));
        i1 = paramToServiceMsg.indexOf("<CommConf>");
        i2 = paramToServiceMsg.indexOf("</CommConf>");
        if ((i1 != -1) && (i2 != -1) && (i1 < i2))
        {
          localObject1 = paramToServiceMsg.substring(i1 + 10, i2);
          if ((localObject1 != null) && (((String)localObject1).length() != 0))
          {
            if (a("commConfig", (String)localObject1, ""))
            {
              localObject4 = c((String)localObject1);
              MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_iconf_UserCommCon", (String)localObject4);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("MSF.C.ConfigManager", 2, "parse commonConf error , skip store.");
            }
          }
          else {
            MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_iconf_UserCommCon", "");
          }
          try
          {
            MsfSdkUtils.writeServerConfig("com.tencent.mobileqq", 0, (String)localObject1, this.A.sender.l());
          }
          catch (IOException localIOException)
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("write config error ");
            ((StringBuilder)localObject4).append(localIOException);
            QLog.e("MSF.C.ConfigManager", 1, ((StringBuilder)localObject4).toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("MSF.C.ConfigManager", 2, "handle config CommConf error");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.ConfigManager", 2, "handle config,  iGetSdkLastTime is obsolete, skip...");
      }
      Object localObject2;
      if ((paramf.g != 0) && (x != paramf.g))
      {
        x = paramf.g;
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("save confReq getiConfAppidTimeKey");
          ((StringBuilder)localObject2).append(paramf.g);
          QLog.d("MSF.C.ConfigManager", 4, ((StringBuilder)localObject2).toString());
        }
        MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_iConfAppidTimeKey", String.valueOf(paramf.g));
        i1 = paramToServiceMsg.indexOf("<APPIDConf>");
        i2 = paramToServiceMsg.indexOf("</APPIDConf>");
        if ((i1 != -1) && (i2 != -1) && (i1 < i2))
        {
          paramToServiceMsg = paramToServiceMsg.substring(i1 + 11, i2);
          if ((paramToServiceMsg != null) && (paramToServiceMsg.length() != 0))
          {
            if (a("appidConf", paramToServiceMsg, ""))
            {
              localObject2 = c(paramToServiceMsg);
              MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_iconf_AppConf", (String)localObject2);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("MSF.C.ConfigManager", 2, "parse appidConf error , skip store.");
            }
          }
          else {
            MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_iconf_AppConf", "");
          }
          try
          {
            MsfSdkUtils.writeServerConfig("com.tencent.mobileqq", 2, paramToServiceMsg, this.A.sender.l());
          }
          catch (IOException paramToServiceMsg)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("write config error ");
            ((StringBuilder)localObject2).append(paramToServiceMsg);
            QLog.e("MSF.C.ConfigManager", 1, ((StringBuilder)localObject2).toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("MSF.C.ConfigManager", 2, "handle config APPIDConf error");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.ConfigManager", 2, "handle config, iGetAppidTime is obsolete, skip...");
      }
      paramToServiceMsg = paramf.f;
      if ((paramToServiceMsg != null) && (paramToServiceMsg.length() != 0))
      {
        i1 = paramToServiceMsg.indexOf("<UserConf>");
        i2 = paramToServiceMsg.indexOf("</UserConf>");
        if ((i1 != -1) && (i2 != -1) && (i1 < i2))
        {
          paramToServiceMsg = paramToServiceMsg.substring(i1 + 10, i2);
        }
        else
        {
          paramToServiceMsg = (ToServiceMsg)localObject3;
          if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.ConfigManager", 2, "handle config UserConf skip");
            paramToServiceMsg = (ToServiceMsg)localObject3;
          }
        }
        if ((paramToServiceMsg != null) && (paramToServiceMsg.length() != 0))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramFromServiceMsg.getUin());
          ((StringBuilder)localObject2).append("_");
          if (a("userConf", paramToServiceMsg, ((StringBuilder)localObject2).toString()))
          {
            localObject2 = c(paramToServiceMsg);
            localObject3 = MsfStore.getNativeConfigStore();
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(paramFromServiceMsg.getUin());
            ((StringBuilder)localObject4).append("_");
            ((StringBuilder)localObject4).append("__loginSdk_iconf_UserConf");
            ((NativeConfigStore)localObject3).n_setConfig(((StringBuilder)localObject4).toString(), (String)localObject2);
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.ConfigManager", 2, "parse userConfig error , skip store.");
          }
        }
        try
        {
          MsfSdkUtils.writeServerConfig("com.tencent.mobileqq", 1, paramToServiceMsg, this.A.sender.l());
        }
        catch (IOException paramFromServiceMsg)
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("write config error ");
          paramToServiceMsg.append(paramFromServiceMsg);
          QLog.e("MSF.C.ConfigManager", 1, paramToServiceMsg.toString());
        }
        MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_iConfGetEspLastTimeKe", String.valueOf(paramf.e));
        if (QLog.isDevelopLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("save confReq getiConfGetEspLastTimeKey");
          paramFromServiceMsg.append(paramf.e);
          QLog.d("MSF.C.ConfigManager", 4, paramFromServiceMsg.toString());
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
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.ConfigManager", 2, "handle config, res.sEspConf null, return");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.ConfigManager", 2, "handle config, res.sConf null, return");
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
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("recved OverloadPushNotify cmd: ");
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append(" delaySecs = ");
        ((StringBuilder)localObject3).append(((com.tencent.msf.service.protocol.d.a)localObject1).b);
        ((StringBuilder)localObject3).append(" timeReced: ");
        ((StringBuilder)localObject3).append(l1);
        ((StringBuilder)localObject3).append(" tips: ");
        ((StringBuilder)localObject3).append(((com.tencent.msf.service.protocol.d.a)localObject1).e);
        QLog.d("MSF.C.ConfigManager", 1, ((StringBuilder)localObject3).toString());
      }
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleConfig before quic_enable=");
    ((StringBuilder)localObject).append(e("quic_enable"));
    QLog.i("MSF.C.ConfigManager", 1, ((StringBuilder)localObject).toString());
    if (!paramFromServiceMsg.isSuccess())
    {
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("wait ");
        paramFromServiceMsg.append(paramToServiceMsg);
        paramFromServiceMsg.append(" timeout.");
        QLog.d("MSF.C.ConfigManager", 2, paramFromServiceMsg.toString());
      }
      return;
    }
    localObject = new UniPacket(true);
    ((UniPacket)localObject).setEncodeName("UTF-8");
    ((UniPacket)localObject).decode(paramFromServiceMsg.getWupBuffer());
    int i1 = ((Integer)((UniPacket)localObject).getByClass("iCmdType", Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handle check ConfigResp .");
      localStringBuilder.append(i1);
      QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
    }
    if ((i1 != 16) && (i1 == 32)) {
      a((com.tencent.msf.service.protocol.e.f)((UniPacket)localObject).getByClass("SDKConfRes", new com.tencent.msf.service.protocol.e.f()), paramFromServiceMsg, paramToServiceMsg);
    }
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("handleConfig after quic_enable=");
    paramFromServiceMsg.append(e("quic_enable"));
    QLog.i("MSF.C.ConfigManager", 1, paramFromServiceMsg.toString());
  }
  
  public void a(ToServiceMsg paramToServiceMsg, long paramLong)
  {
    if (aq())
    {
      if (NetConnInfoCenter.isMobileConn())
      {
        D = paramLong;
        MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_checkmobilessotime", String.valueOf(D));
        F = D + 3600000L;
        ar();
      }
      else if (NetConnInfoCenter.isWifiConn())
      {
        E = paramLong;
        MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_checkwifissotime", String.valueOf(E));
        G = E + 3600000L;
        as();
      }
      try
      {
        this.A.getSsoListManager().a(paramToServiceMsg.getAppId(), paramToServiceMsg.getUin(), 60000L, NetConnInfoCenter.isWifiConn(), "", false);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, localException.toString(), localException);
        }
      }
      try
      {
        a(paramToServiceMsg.getUin(), 60000);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.ConfigManager", 2, paramToServiceMsg.toString(), paramToServiceMsg);
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = at();
    ToServiceMsg localToServiceMsg = new ToServiceMsg("", paramString, "ConfigService.ClientReq");
    localToServiceMsg.setMsfCommand(MsfCommand._msf_getConfig);
    localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
    int i1;
    if (this.A.getMsfAppid() == -1) {
      i1 = 100;
    } else {
      i1 = this.A.getMsfAppid();
    }
    localToServiceMsg.setAppId(i1);
    localToServiceMsg.putWupBuffer((byte[])localObject);
    localToServiceMsg.setTimeout(paramInt);
    this.A.sender.b(localToServiceMsg);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("send checkConfig uin=");
    ((StringBuilder)localObject).append(MsfSdkUtils.getShortUin(paramString));
    ((StringBuilder)localObject).append(" appid=");
    ((StringBuilder)localObject).append(i1);
    QLog.d("MSF.C.ConfigManager", 1, ((StringBuilder)localObject).toString());
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
    boolean bool5 = NetConnInfoCenter.isMobileConn();
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    long l2;
    long l3;
    if (bool5)
    {
      l2 = D;
      if (l2 == 0L) {
        return true;
      }
      l3 = F;
      if (l3 == 0L)
      {
        if (l1 - l2 >= 43200000L) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool4;
      if (l1 >= l3) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool3;
    if (NetConnInfoCenter.isWifiConn())
    {
      l2 = E;
      if (l2 == 0L) {
        return true;
      }
      l3 = G;
      if (l3 == 0L)
      {
        bool1 = bool2;
        if (l1 - l2 >= 43200000L) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool3;
      if (l1 >= l3) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void ar()
  {
    MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_mobilessotime", String.valueOf(F));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("save next get mobile sso time is ");
      localStringBuilder.append(this.A.timeFormatter.format(Long.valueOf(F)));
      QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
    }
  }
  
  public void as()
  {
    MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_wifissotime", String.valueOf(G));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("save next get Wifi sso time is ");
      localStringBuilder.append(this.A.timeFormatter.format(Long.valueOf(G)));
      QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("load confReq iGetAppidTime");
      ((StringBuilder)localObject1).append(locale.e);
      ((StringBuilder)localObject1).append(" iGetSdkLastTime:");
      ((StringBuilder)localObject1).append(locale.b);
      ((StringBuilder)localObject1).append(" iGetEspLastTime:");
      ((StringBuilder)localObject1).append(locale.d);
      QLog.d("MSF.C.ConfigManager", 2, ((StringBuilder)localObject1).toString());
    }
    localObject2 = this.A.getAccountCenter().d();
    Object localObject1 = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject2).next();
      ((ArrayList)localObject1).add(localSimpleAccount.getUin());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkConfig uin=");
        localStringBuilder.append(localSimpleAccount.getUin());
        QLog.d("MSF.C.ConfigManager", 2, localStringBuilder.toString());
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
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    localUniPacket.put("ClientReportReq", locala);
    paramToServiceMsg.putWupBuffer(localUniPacket.encode());
    return this.A.sendSsoMsg(paramToServiceMsg);
  }
  
  public String b(String paramString)
  {
    NativeConfigStore localNativeConfigStore = MsfStore.getNativeConfigStore();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("__loginSdk_iconf_UserConf");
    return d(localNativeConfigStore.getConfig(localStringBuilder.toString()));
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
      if ((str2 != null) && (str2.length() > 0))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str1);
        localStringBuilder.append("_");
        a("userConfig", str2, localStringBuilder.toString());
      }
    }
    bx();
  }
  
  public String c(ToServiceMsg paramToServiceMsg)
  {
    int i1 = ((Integer)paramToServiceMsg.getAttributes().get("to_getServerConfig_type")).intValue();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return null;
        }
        return ao();
      }
      return b(paramToServiceMsg.getUin());
    }
    return an();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.a.a
 * JD-Core Version:    0.7.0.1
 */