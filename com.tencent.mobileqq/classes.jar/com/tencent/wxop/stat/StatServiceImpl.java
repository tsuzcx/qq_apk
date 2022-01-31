package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.common.b;
import com.tencent.wxop.stat.common.e;
import com.tencent.wxop.stat.event.c;
import com.tencent.wxop.stat.event.h;
import com.tencent.wxop.stat.event.k;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class StatServiceImpl
{
  static volatile int a;
  static volatile long b;
  static volatile long c = 0L;
  private static e d;
  private static volatile Map<c, Long> e = new ConcurrentHashMap();
  private static volatile Map<String, Properties> f = new ConcurrentHashMap();
  private static volatile Map<Integer, Integer> g = new ConcurrentHashMap(10);
  private static volatile long h = 0L;
  private static volatile long i = 0L;
  private static volatile long j = 0L;
  private static String k = "";
  private static volatile int l = 0;
  private static volatile String m = "";
  private static volatile String n = "";
  private static Map<String, Long> o = new ConcurrentHashMap();
  private static Map<String, Long> p = new ConcurrentHashMap();
  private static StatLogger q = com.tencent.wxop.stat.common.l.b();
  private static Thread.UncaughtExceptionHandler r = null;
  private static volatile boolean s = true;
  private static Context t;
  
  static
  {
    a = 0;
    b = 0L;
    t = null;
  }
  
  static int a(Context paramContext, boolean paramBoolean, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    int i2 = 1;
    long l1 = System.currentTimeMillis();
    if ((paramBoolean) && (l1 - i >= StatConfig.getSessionTimoutMillis())) {}
    for (int i1 = 1;; i1 = 0)
    {
      i = l1;
      if (j == 0L) {
        j = com.tencent.wxop.stat.common.l.c();
      }
      if (l1 >= j)
      {
        j = com.tencent.wxop.stat.common.l.c();
        if (au.a(paramContext).b(paramContext).d() != 1) {
          au.a(paramContext).b(paramContext).a(1);
        }
        StatConfig.b(0);
        a = 0;
        k = com.tencent.wxop.stat.common.l.a(0);
        i1 = 1;
      }
      String str = k;
      if (com.tencent.wxop.stat.common.l.a(paramStatSpecifyReportedInfo)) {
        str = paramStatSpecifyReportedInfo.getAppKey() + k;
      }
      if (!p.containsKey(str)) {
        i1 = i2;
      }
      for (;;)
      {
        if (i1 != 0)
        {
          if (com.tencent.wxop.stat.common.l.a(paramStatSpecifyReportedInfo)) {
            break label232;
          }
          if (StatConfig.c() >= StatConfig.getMaxDaySessionNumbers()) {
            break label221;
          }
          com.tencent.wxop.stat.common.l.v(paramContext);
          a(paramContext, null);
        }
        for (;;)
        {
          p.put(str, Long.valueOf(1L));
          if (s)
          {
            testSpeed(paramContext);
            s = false;
          }
          return l;
          label221:
          q.e("Exceed StatConfig.getMaxDaySessionNumbers().");
          continue;
          label232:
          a(paramContext, paramStatSpecifyReportedInfo);
        }
      }
    }
  }
  
  static void a(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((d != null) || (!b(paramContext))) {
          continue;
        }
        paramContext = paramContext.getApplicationContext();
        t = paramContext;
        d = new e();
        k = com.tencent.wxop.stat.common.l.a(0);
        h = System.currentTimeMillis() + StatConfig.i;
        d.a(new l(paramContext));
      }
      finally {}
    }
  }
  
  static void a(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (c(paramContext) != null)
    {
      if (StatConfig.isDebugEnable()) {
        q.d("start new session.");
      }
      if ((paramStatSpecifyReportedInfo == null) || (l == 0)) {
        l = com.tencent.wxop.stat.common.l.a();
      }
      StatConfig.a(0);
      StatConfig.b();
      new aq(new k(paramContext, l, b(), paramStatSpecifyReportedInfo)).a();
    }
  }
  
  static void a(Context paramContext, Throwable paramThrowable)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.reportSdkSelfException() can not be null!");
        return;
      }
    } while (c(paramContext) == null);
    d.a(new q(paramContext, paramThrowable));
  }
  
  static boolean a()
  {
    if (a >= 2)
    {
      b = System.currentTimeMillis();
      return true;
    }
    return false;
  }
  
  static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  static JSONObject b()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      if (StatConfig.b.d != 0) {
        localJSONObject2.put("v", StatConfig.b.d);
      }
      localJSONObject1.put(Integer.toString(StatConfig.b.a), localJSONObject2);
      localJSONObject2 = new JSONObject();
      if (StatConfig.a.d != 0) {
        localJSONObject2.put("v", StatConfig.a.d);
      }
      localJSONObject1.put(Integer.toString(StatConfig.a.a), localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      q.e(localJSONException);
    }
    return localJSONObject1;
  }
  
  private static void b(Context paramContext, StatAccount paramStatAccount, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    try
    {
      new aq(new com.tencent.wxop.stat.event.a(paramContext, a(paramContext, false, paramStatSpecifyReportedInfo), paramStatAccount, paramStatSpecifyReportedInfo)).a();
      return;
    }
    catch (Throwable paramStatAccount)
    {
      q.e(paramStatAccount);
      a(paramContext, paramStatAccount);
    }
  }
  
  static boolean b(Context paramContext)
  {
    boolean bool2 = false;
    long l1 = com.tencent.wxop.stat.common.q.a(paramContext, StatConfig.c, 0L);
    long l2 = com.tencent.wxop.stat.common.l.b("2.0.4");
    boolean bool1 = true;
    if (l2 <= l1)
    {
      q.error("MTA is disable for current version:" + l2 + ",wakeup version:" + l1);
      bool1 = false;
    }
    l1 = com.tencent.wxop.stat.common.q.a(paramContext, StatConfig.d, 0L);
    if (l1 > System.currentTimeMillis())
    {
      q.error("MTA is disable for current time:" + System.currentTimeMillis() + ",wakeup time:" + l1);
      bool1 = bool2;
    }
    for (;;)
    {
      StatConfig.setEnableStatService(bool1);
      return bool1;
    }
  }
  
  /* Error */
  static e c(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 189	com/tencent/wxop/stat/StatServiceImpl:d	Lcom/tencent/wxop/stat/common/e;
    //   3: ifnonnull +21 -> 24
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 189	com/tencent/wxop/stat/StatServiceImpl:d	Lcom/tencent/wxop/stat/common/e;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnonnull +7 -> 21
    //   17: aload_0
    //   18: invokestatic 341	com/tencent/wxop/stat/StatServiceImpl:a	(Landroid/content/Context;)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: getstatic 189	com/tencent/wxop/stat/StatServiceImpl:d	Lcom/tencent/wxop/stat/common/e;
    //   27: areturn
    //   28: astore_0
    //   29: getstatic 80	com/tencent/wxop/stat/StatServiceImpl:q	Lcom/tencent/wxop/stat/common/StatLogger;
    //   32: aload_0
    //   33: invokevirtual 343	com/tencent/wxop/stat/common/StatLogger:error	(Ljava/lang/Throwable;)V
    //   36: iconst_0
    //   37: invokestatic 339	com/tencent/wxop/stat/StatConfig:setEnableStatService	(Z)V
    //   40: goto -19 -> 21
    //   43: astore_0
    //   44: ldc 2
    //   46: monitorexit
    //   47: aload_0
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	paramContext	Context
    //   12	2	1	locale	e
    // Exception table:
    //   from	to	target	type
    //   17	21	28	java/lang/Throwable
    //   9	13	43	finally
    //   17	21	43	finally
    //   21	24	43	finally
    //   29	40	43	finally
    //   44	47	43	finally
  }
  
  static void c()
  {
    a = 0;
    b = 0L;
  }
  
  public static void commitEvents(Context paramContext, int paramInt)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      if (StatConfig.isDebugEnable()) {
        q.i("commitEvents, maxNumber=" + paramInt);
      }
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.commitEvents() can not be null!");
        return;
      }
      if ((paramInt < -1) || (paramInt == 0))
      {
        q.error("The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.");
        return;
      }
    } while ((!a.a(t).f()) || (c(paramContext) == null));
    d.a(new ad(paramContext, paramInt));
  }
  
  static void d()
  {
    a += 1;
    b = System.currentTimeMillis();
    flushDataToDB(t);
  }
  
  static void d(Context paramContext)
  {
    if (!StatConfig.isEnableStatService()) {
      return;
    }
    paramContext = getContext(paramContext);
    if (paramContext == null)
    {
      q.error("The Context of StatService.sendNetworkDetector() can not be null!");
      return;
    }
    try
    {
      h localh = new h(paramContext);
      i.b(paramContext).a(localh, new t());
      return;
    }
    catch (Throwable paramContext)
    {
      q.e(paramContext);
    }
  }
  
  static void e(Context paramContext)
  {
    c = System.currentTimeMillis() + 60000 * StatConfig.getSendPeriodMinutes();
    com.tencent.wxop.stat.common.q.b(paramContext, "last_period_ts", c);
    commitEvents(paramContext, -1);
  }
  
  public static void flushDataToDB(Context paramContext)
  {
    if (!StatConfig.isEnableStatService()) {}
    while (StatConfig.m <= 0) {
      return;
    }
    paramContext = getContext(paramContext);
    if (paramContext == null)
    {
      q.error("The Context of StatService.testSpeed() can not be null!");
      return;
    }
    au.a(paramContext).c();
  }
  
  public static Properties getCommonKeyValueForKVEvent(String paramString)
  {
    return (Properties)f.get(paramString);
  }
  
  public static Context getContext(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext;
    }
    return t;
  }
  
  public static void onLowMemory(Context paramContext)
  {
    if (!StatConfig.isEnableStatService()) {}
    while (c(getContext(paramContext)) == null) {
      return;
    }
    d.a(new o(paramContext));
  }
  
  public static void onPause(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    while (c(paramContext) == null) {
      return;
    }
    d.a(new m(paramContext, paramStatSpecifyReportedInfo));
  }
  
  public static void onResume(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    while (c(paramContext) == null) {
      return;
    }
    d.a(new aj(paramContext, paramStatSpecifyReportedInfo));
  }
  
  public static void onStop(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
    } while (c(paramContext) == null);
    d.a(new n(paramContext));
  }
  
  public static void reportAccount(Context paramContext, StatAccount paramStatAccount, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.e("context is null in reportAccount.");
        return;
      }
    } while (c(paramContext) == null);
    d.a(new al(paramStatAccount, paramContext, paramStatSpecifyReportedInfo));
  }
  
  public static void reportAppMonitorStat(Context paramContext, StatAppMonitor paramStatAppMonitor, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.reportAppMonitorStat() can not be null!");
        return;
      }
      if (paramStatAppMonitor == null)
      {
        q.error("The StatAppMonitor of StatService.reportAppMonitorStat() can not be null!");
        return;
      }
      if (paramStatAppMonitor.getInterfaceName() == null)
      {
        q.error("The interfaceName of StatAppMonitor on StatService.reportAppMonitorStat() can not be null!");
        return;
      }
      paramStatAppMonitor = paramStatAppMonitor.clone();
    } while (c(paramContext) == null);
    d.a(new aa(paramContext, paramStatSpecifyReportedInfo, paramStatAppMonitor));
  }
  
  public static void reportError(Context paramContext, String paramString, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.reportError() can not be null!");
        return;
      }
    } while (c(paramContext) == null);
    d.a(new p(paramString, paramContext, paramStatSpecifyReportedInfo));
  }
  
  public static void reportException(Context paramContext, Throwable paramThrowable, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.reportException() can not be null!");
        return;
      }
    } while (c(paramContext) == null);
    d.a(new r(paramThrowable, paramContext, paramStatSpecifyReportedInfo));
  }
  
  public static void reportGameUser(Context paramContext, StatGameUser paramStatGameUser, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.reportGameUser() can not be null!");
        return;
      }
    } while (c(paramContext) == null);
    d.a(new am(paramStatGameUser, paramContext, paramStatSpecifyReportedInfo));
  }
  
  public static void reportQQ(Context paramContext, String paramString, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("context is null in reportQQ()");
        return;
      }
    } while (c(paramContext) == null);
    d.a(new ak(paramString, paramContext, paramStatSpecifyReportedInfo));
  }
  
  public static void setCommonKeyValueForKVEvent(String paramString, Properties paramProperties)
  {
    if (com.tencent.wxop.stat.common.l.c(paramString))
    {
      if ((paramProperties != null) && (paramProperties.size() > 0))
      {
        f.put(paramString, (Properties)paramProperties.clone());
        return;
      }
      f.remove(paramString);
      return;
    }
    q.e("event_id or commonProp for setCommonKeyValueForKVEvent is invalid.");
  }
  
  public static void setContext(Context paramContext)
  {
    if (paramContext != null) {
      t = paramContext.getApplicationContext();
    }
  }
  
  public static void setEnvAttributes(Context paramContext, Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() > 512))
    {
      q.error("The map in setEnvAttributes can't be null or its size can't exceed 512.");
      return;
    }
    try
    {
      b.a(paramContext, paramMap);
      return;
    }
    catch (JSONException paramContext)
    {
      q.e(paramContext);
    }
  }
  
  public static void startNewSession(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.startNewSession() can not be null!");
        return;
      }
    } while (c(paramContext) == null);
    d.a(new ai(paramContext, paramStatSpecifyReportedInfo));
  }
  
  public static boolean startStatService(Context paramContext, String paramString1, String paramString2, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    for (;;)
    {
      try
      {
        if (!StatConfig.isEnableStatService())
        {
          q.error("MTA StatService is disable.");
          return false;
        }
        if (!StatConfig.isDebugEnable()) {
          break label219;
        }
        q.d("MTA SDK version, current: " + "2.0.4" + " ,required: " + paramString2);
      }
      catch (Throwable paramContext)
      {
        q.e(paramContext);
        return false;
      }
      q.error("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
      StatConfig.setEnableStatService(false);
      return false;
      label219:
      do
      {
        if (com.tencent.wxop.stat.common.l.b("2.0.4") < com.tencent.wxop.stat.common.l.b(paramString2))
        {
          paramContext = "MTA SDK version conflicted, current: " + "2.0.4" + ",required: " + paramString2;
          paramContext = paramContext + ". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/";
          q.error(paramContext);
          StatConfig.setEnableStatService(false);
          return false;
        }
        paramString2 = StatConfig.getInstallChannel(paramContext);
        if ((paramString2 == null) || (paramString2.length() == 0)) {
          StatConfig.setInstallChannel("-");
        }
        if (paramString1 != null) {
          StatConfig.setAppKey(paramContext, paramString1);
        }
        if (c(paramContext) != null) {
          d.a(new an(paramContext, paramStatSpecifyReportedInfo));
        }
        return true;
        if (paramContext == null) {
          break;
        }
      } while (paramString2 != null);
    }
  }
  
  public static void stopSession()
  {
    i = 0L;
  }
  
  public static void testSpeed(Context paramContext)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.testSpeed() can not be null!");
        return;
      }
    } while (c(paramContext) == null);
    d.a(new ae(paramContext));
  }
  
  public static void testSpeed(Context paramContext, Map<String, Integer> paramMap, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.testSpeed() can not be null!");
        return;
      }
      if ((paramMap == null) || (paramMap.size() == 0))
      {
        q.error("The domainMap of StatService.testSpeed() can not be null or empty!");
        return;
      }
      paramMap = new HashMap(paramMap);
    } while (c(paramContext) == null);
    d.a(new af(paramContext, paramMap, paramStatSpecifyReportedInfo));
  }
  
  public static void trackBeginPage(Context paramContext, String paramString, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if ((paramContext == null) || (paramString == null) || (paramString.length() == 0))
      {
        q.error("The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
        return;
      }
      paramString = new String(paramString);
    } while (c(paramContext) == null);
    d.a(new w(paramString, paramContext, paramStatSpecifyReportedInfo));
  }
  
  public static void trackCustomBeginEvent(Context paramContext, String paramString, StatSpecifyReportedInfo paramStatSpecifyReportedInfo, String... paramVarArgs)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.trackCustomBeginEvent() can not be null!");
        return;
      }
      paramStatSpecifyReportedInfo = new c(paramString, paramVarArgs, null);
    } while (c(paramContext) == null);
    d.a(new v(paramString, paramStatSpecifyReportedInfo, paramContext));
  }
  
  public static void trackCustomBeginKVEvent(Context paramContext, String paramString, Properties paramProperties, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.trackCustomBeginEvent() can not be null!");
        return;
      }
      paramProperties = new c(paramString, null, paramProperties);
    } while (c(paramContext) == null);
    d.a(new y(paramString, paramProperties, paramContext));
  }
  
  public static void trackCustomEndEvent(Context paramContext, String paramString, StatSpecifyReportedInfo paramStatSpecifyReportedInfo, String... paramVarArgs)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.trackCustomEndEvent() can not be null!");
        return;
      }
      paramVarArgs = new c(paramString, paramVarArgs, null);
    } while (c(paramContext) == null);
    d.a(new x(paramString, paramVarArgs, paramContext, paramStatSpecifyReportedInfo));
  }
  
  public static void trackCustomEndKVEvent(Context paramContext, String paramString, Properties paramProperties, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.trackCustomEndEvent() can not be null!");
        return;
      }
      paramProperties = new c(paramString, null, paramProperties);
    } while (c(paramContext) == null);
    d.a(new z(paramString, paramProperties, paramContext, paramStatSpecifyReportedInfo));
  }
  
  public static void trackCustomEvent(Context paramContext, String paramString, StatSpecifyReportedInfo paramStatSpecifyReportedInfo, String... paramVarArgs)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.trackCustomEvent() can not be null!");
        return;
      }
      if (a(paramString))
      {
        q.error("The event_id of StatService.trackCustomEvent() can not be null or empty.");
        return;
      }
      paramString = new c(paramString, paramVarArgs, null);
    } while (c(paramContext) == null);
    d.a(new s(paramContext, paramStatSpecifyReportedInfo, paramString));
  }
  
  public static void trackCustomKVEvent(Context paramContext, String paramString, Properties paramProperties, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.trackCustomEvent() can not be null!");
        return;
      }
      if (a(paramString))
      {
        q.error("The event_id of StatService.trackCustomEvent() can not be null or empty.");
        return;
      }
      paramString = new c(paramString, null, paramProperties);
    } while (c(paramContext) == null);
    d.a(new u(paramContext, paramStatSpecifyReportedInfo, paramString));
  }
  
  public static void trackCustomKVTimeIntervalEvent(Context paramContext, String paramString, Properties paramProperties, int paramInt, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.trackCustomEndEvent() can not be null!");
        return;
      }
      if (a(paramString))
      {
        q.error("The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
        return;
      }
      paramString = new c(paramString, null, paramProperties);
    } while (c(paramContext) == null);
    d.a(new ac(paramContext, paramStatSpecifyReportedInfo, paramString, paramInt));
  }
  
  public static void trackCustomTimeIntervalEvent(Context paramContext, int paramInt, String paramString, String... paramVarArgs)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      if (paramInt <= 0)
      {
        q.error("The intervalSecond of StatService.trackCustomTimeIntervalEvent() can must bigger than 0!");
        return;
      }
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.trackCustomTimeIntervalEvent() can not be null!");
        return;
      }
    } while (c(paramContext) == null);
    d.a(new ab());
  }
  
  public static void trackEndPage(Context paramContext, String paramString, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if ((paramContext == null) || (paramString == null) || (paramString.length() == 0))
      {
        q.error("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
        return;
      }
      paramString = new String(paramString);
    } while (c(paramContext) == null);
    d.a(new ah(paramContext, paramString, paramStatSpecifyReportedInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.StatServiceImpl
 * JD-Core Version:    0.7.0.1
 */