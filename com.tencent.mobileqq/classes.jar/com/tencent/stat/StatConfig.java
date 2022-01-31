package com.tencent.stat;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.stat.a.a.c;
import com.tencent.stat.common.DeviceInfo;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.StatPreferences;
import com.tencent.stat.common.Util;
import java.net.URI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class StatConfig
{
  private static String A;
  private static String B;
  private static String C;
  private static String D;
  private static int E;
  private static String F;
  private static int G;
  private static long H;
  private static long I;
  private static volatile String J;
  private static int K;
  private static volatile int L;
  private static int M;
  private static int N;
  private static boolean O;
  private static int P;
  private static boolean Q;
  private static String R;
  private static f S = null;
  private static JSONObject T = null;
  private static String U = null;
  private static JSONObject V = null;
  private static HashSet<String> W = new HashSet();
  static e a;
  static e b;
  static String c;
  static String d;
  static String e;
  static String f;
  static boolean g;
  static int h;
  static long i;
  public static boolean isAutoExceptionCaught;
  static boolean j;
  static volatile String k;
  static boolean l;
  static int m;
  static long n;
  static int o;
  private static StatLogger p = ;
  private static StatReportStrategy q;
  private static boolean r;
  private static boolean s;
  private static int t;
  private static int u;
  private static int v;
  private static int w;
  private static int x;
  private static int y;
  private static int z;
  
  static
  {
    a = new e(2);
    b = new e(1);
    q = StatReportStrategy.APP_LAUNCH;
    r = false;
    s = true;
    t = 30000;
    u = 100000;
    v = 30;
    w = 10;
    x = 100;
    y = 30;
    z = 1;
    c = "__HIBERNATE__";
    d = "__HIBERNATE__TIME";
    e = "__MTA_KILL__";
    A = null;
    D = "mta_channel";
    f = "";
    E = 180;
    g = false;
    h = 1000;
    i = 10000L;
    G = 1024;
    j = true;
    H = 0L;
    I = 300000L;
    isAutoExceptionCaught = true;
    k = "pingma.qq.com:80";
    J = "http://pingma.qq.com:80/mstat/report";
    K = 0;
    L = 0;
    M = 20;
    N = 0;
    O = false;
    P = 4096;
    Q = false;
    R = null;
    l = true;
    m = 0;
    n = 10000L;
    o = 512;
  }
  
  static int a()
  {
    return v;
  }
  
  static String a(Context paramContext)
  {
    return Util.decode(StatPreferences.getString(paramContext, "_mta_ky_tag_", null));
  }
  
  static void a(int paramInt)
  {
    try
    {
      L = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static void a(long paramLong)
  {
    StatPreferences.putLong(g.a(), c, paramLong);
    setEnableStatService(false);
    p.warn("MTA is disable for current SDK version");
  }
  
  static void a(Context paramContext, e parame)
  {
    if (parame.a == b.a)
    {
      b = parame;
      a(b.b);
      if (!b.b.isNull("iplist")) {
        NetworkManager.getInstance(paramContext).updateIpList(b.b.getString("iplist"));
      }
      updateDontReportEventIdsSet(b.b.optString("__DONT_REPORT_EI_LIST__", null));
    }
    while (parame.a != a.a) {
      return;
    }
    a = parame;
  }
  
  static void a(Context paramContext, e parame, JSONObject paramJSONObject)
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        Iterator localIterator = paramJSONObject.keys();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (str.equalsIgnoreCase("v"))
          {
            int i2 = paramJSONObject.getInt(str);
            if (parame.d != i2)
            {
              i1 = 1;
              parame.d = i2;
              break;
            }
          }
          else
          {
            if (str.equalsIgnoreCase("c"))
            {
              str = paramJSONObject.getString("c");
              if (str.length() <= 0) {
                break label216;
              }
              parame.b = new JSONObject(str);
              break label216;
            }
            if (!str.equalsIgnoreCase("m")) {
              break label219;
            }
            parame.c = paramJSONObject.getString("m");
            break label219;
          }
        }
        else
        {
          if (i1 == 1)
          {
            paramJSONObject = af.a(g.a());
            if (paramJSONObject != null) {
              paramJSONObject.a(parame);
            }
            if (parame.a == b.a)
            {
              a(parame.b);
              b(parame.b);
            }
          }
          a(paramContext, parame);
          return;
        }
      }
      catch (JSONException paramContext)
      {
        p.e(paramContext);
        return;
      }
      catch (Throwable paramContext)
      {
        p.e(paramContext);
        return;
      }
    }
    label216:
    label219:
    for (;;)
    {
      break;
    }
  }
  
  static void a(Context paramContext, String paramString)
  {
    if (paramString != null) {
      StatPreferences.putString(paramContext, "_mta_ky_tag_", Util.encode(paramString));
    }
  }
  
  static void a(Context paramContext, JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = paramJSONObject.keys();
        if (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          if (((String)localObject).equalsIgnoreCase(Integer.toString(b.a)))
          {
            localObject = paramJSONObject.getJSONObject((String)localObject);
            a(paramContext, b, (JSONObject)localObject);
          }
        }
        else
        {
          return;
        }
      }
      catch (JSONException paramContext)
      {
        p.e(paramContext);
      }
      do
      {
        if (((String)localObject).equalsIgnoreCase(Integer.toString(a.a)))
        {
          localObject = paramJSONObject.getJSONObject((String)localObject);
          a(paramContext, a, (JSONObject)localObject);
          break;
        }
      } while (!((String)localObject).equalsIgnoreCase("rs"));
      Object localObject = StatReportStrategy.getStatReportStrategy(paramJSONObject.getInt((String)localObject));
      if (localObject != null)
      {
        q = (StatReportStrategy)localObject;
        if (isDebugEnable()) {
          p.d("Change to ReportStrategy:" + ((StatReportStrategy)localObject).name());
        }
      }
    }
  }
  
  static void a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = StatReportStrategy.getStatReportStrategy(paramJSONObject.getInt("rs"));
      if (paramJSONObject != null) {
        setStatSendStrategy(paramJSONObject);
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      while (!isDebugEnable()) {}
      p.i("rs not found.");
    }
  }
  
  static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 >= paramInt2) && (paramInt1 <= paramInt3);
  }
  
  private static boolean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      if (B == null)
      {
        B = paramString;
        return true;
      }
    } while (B.contains(paramString));
    B = B + "|" + paramString;
    return true;
  }
  
  static boolean a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (!paramJSONObject.isNull(paramString1))
    {
      paramJSONObject = paramJSONObject.optString(paramString1);
      if ((StatCommonHelper.isStringValid(paramString2)) && (StatCommonHelper.isStringValid(paramJSONObject)) && (paramString2.equalsIgnoreCase(paramJSONObject))) {
        return true;
      }
    }
    return false;
  }
  
  static void b()
  {
    N += 1;
  }
  
  static void b(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    N = paramInt;
  }
  
  static void b(Context paramContext, JSONObject paramJSONObject)
  {
    for (;;)
    {
      Object localObject;
      int i1;
      try
      {
        paramJSONObject = paramJSONObject.optString(e);
        if (!StatCommonHelper.isStringValid(paramJSONObject)) {
          break;
        }
        paramJSONObject = new JSONObject(paramJSONObject);
        if (paramJSONObject == null) {
          break;
        }
        if (paramJSONObject.length() == 0) {
          return;
        }
        if (!paramJSONObject.isNull("sm"))
        {
          localObject = paramJSONObject.get("sm");
          if (!(localObject instanceof Integer)) {
            break label579;
          }
          i1 = ((Integer)localObject).intValue();
          if (i1 > 0)
          {
            if (isDebugEnable()) {
              p.i("match sleepTime:" + i1 + " minutes");
            }
            long l1 = System.currentTimeMillis();
            long l2 = i1 * 60 * 1000;
            StatPreferences.putLong(paramContext, d, l1 + l2);
            setEnableStatService(false);
            p.warn("MTA is disable for current SDK version");
          }
        }
        if (!a(paramJSONObject, "sv", "2.4.2")) {
          break label602;
        }
        p.i("match sdk version:2.4.2");
        i1 = 1;
        if (a(paramJSONObject, "md", Build.MODEL))
        {
          p.i("match MODEL:" + Build.MODEL);
          i1 = 1;
        }
        if (a(paramJSONObject, "av", StatCommonHelper.getCurAppVersion(paramContext)))
        {
          p.i("match app version:" + StatCommonHelper.getCurAppVersion(paramContext));
          i1 = 1;
        }
        if (a(paramJSONObject, "mf", Build.MANUFACTURER + ""))
        {
          p.i("match MANUFACTURER:" + Build.MANUFACTURER + "");
          i1 = 1;
        }
        if (a(paramJSONObject, "osv", Build.VERSION.SDK_INT + ""))
        {
          p.i("match android SDK version:" + Build.VERSION.SDK_INT);
          i1 = 1;
        }
        if (a(paramJSONObject, "ov", Build.VERSION.SDK_INT + ""))
        {
          p.i("match android SDK version:" + Build.VERSION.SDK_INT);
          i1 = 1;
        }
        if (a(paramJSONObject, "ui", af.a(paramContext).b(paramContext).getImei()))
        {
          p.i("match imei:" + af.a(paramContext).b(paramContext).getImei());
          i1 = 1;
        }
        if (a(paramJSONObject, "mid", getLocalMidOnly(paramContext)))
        {
          p.i("match mid:" + getLocalMidOnly(paramContext));
          i1 = 1;
        }
        if (i1 == 0) {
          break;
        }
        a(StatCommonHelper.getSDKLongVersion("2.4.2"));
        return;
      }
      catch (Exception paramContext)
      {
        p.e(paramContext);
        return;
      }
      label579:
      if ((localObject instanceof String))
      {
        i1 = Integer.valueOf((String)localObject).intValue();
        continue;
        label602:
        i1 = 0;
      }
      else
      {
        i1 = 0;
      }
    }
  }
  
  static void b(JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {}
    for (;;)
    {
      return;
      try
      {
        b(g.a(), paramJSONObject);
        paramJSONObject = paramJSONObject.getString(c);
        if (isDebugEnable()) {
          p.d("hibernateVer:" + paramJSONObject + ", current version:" + "2.4.2");
        }
        long l1 = StatCommonHelper.getSDKLongVersion(paramJSONObject);
        if (StatCommonHelper.getSDKLongVersion("2.4.2") <= l1)
        {
          a(l1);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        p.d("__HIBERNATE__ not found.");
      }
    }
  }
  
  static int c()
  {
    return N;
  }
  
  /* Error */
  public static String getAppKey(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 388	com/tencent/stat/StatConfig:B	Ljava/lang/String;
    //   6: ifnull +12 -> 18
    //   9: getstatic 388	com/tencent/stat/StatConfig:B	Ljava/lang/String;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: aload_0
    //   19: ifnull +16 -> 35
    //   22: getstatic 388	com/tencent/stat/StatConfig:B	Ljava/lang/String;
    //   25: ifnonnull +10 -> 35
    //   28: aload_0
    //   29: invokestatic 507	com/tencent/stat/common/StatCommonHelper:getAppKey	(Landroid/content/Context;)Ljava/lang/String;
    //   32: putstatic 388	com/tencent/stat/StatConfig:B	Ljava/lang/String;
    //   35: getstatic 388	com/tencent/stat/StatConfig:B	Ljava/lang/String;
    //   38: ifnull +15 -> 53
    //   41: getstatic 388	com/tencent/stat/StatConfig:B	Ljava/lang/String;
    //   44: invokevirtual 510	java/lang/String:trim	()Ljava/lang/String;
    //   47: invokevirtual 311	java/lang/String:length	()I
    //   50: ifne +12 -> 62
    //   53: getstatic 73	com/tencent/stat/StatConfig:p	Lcom/tencent/stat/common/StatLogger;
    //   56: ldc_w 512
    //   59: invokevirtual 514	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Object;)V
    //   62: getstatic 388	com/tencent/stat/StatConfig:B	Ljava/lang/String;
    //   65: astore_0
    //   66: goto -53 -> 13
    //   69: astore_0
    //   70: ldc 2
    //   72: monitorexit
    //   73: aload_0
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	13	69	finally
    //   22	35	69	finally
    //   35	53	69	finally
    //   53	62	69	finally
    //   62	66	69	finally
  }
  
  public static String getAppVersion()
  {
    return U;
  }
  
  public static JSONObject getCommonAttr(Context paramContext)
  {
    if (T == null) {
      paramContext = StatPreferences.getString(paramContext, "mta.common.attr.tag", new JSONObject().toString());
    }
    try
    {
      T = new JSONObject(paramContext);
      return T;
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static int getCurSessionStatReportCount()
  {
    return L;
  }
  
  public static JSONObject getCustomGlobalReportContent()
  {
    return V;
  }
  
  public static String getCustomProperty(String paramString)
  {
    try
    {
      paramString = a.b.getString(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      p.e(paramString);
    }
    return null;
  }
  
  public static String getCustomProperty(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = a.b.getString(paramString1);
      if (paramString1 != null) {
        paramString2 = paramString1;
      }
      return paramString2;
    }
    catch (Throwable paramString1)
    {
      p.e(paramString1);
    }
    return paramString2;
  }
  
  public static String getCustomUserId(Context paramContext)
  {
    if (paramContext == null)
    {
      p.error("Context for getCustomUid is null.");
      return null;
    }
    if (R == null) {}
    try
    {
      R = StatPreferences.getString(paramContext, "MTA_CUSTOM_UID", "");
      return R;
    }
    catch (ClassCastException paramContext)
    {
      for (;;)
      {
        p.e(paramContext);
      }
    }
  }
  
  public static long getFlushDBSpaceMS()
  {
    return n;
  }
  
  /* Error */
  public static String getInstallChannel(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 542	com/tencent/stat/StatConfig:C	Ljava/lang/String;
    //   6: ifnull +12 -> 18
    //   9: getstatic 542	com/tencent/stat/StatConfig:C	Ljava/lang/String;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: aload_0
    //   19: getstatic 127	com/tencent/stat/StatConfig:D	Ljava/lang/String;
    //   22: ldc 129
    //   24: invokestatic 211	com/tencent/stat/common/StatPreferences:getString	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   27: putstatic 542	com/tencent/stat/StatConfig:C	Ljava/lang/String;
    //   30: getstatic 542	com/tencent/stat/StatConfig:C	Ljava/lang/String;
    //   33: ifnull +15 -> 48
    //   36: getstatic 542	com/tencent/stat/StatConfig:C	Ljava/lang/String;
    //   39: invokevirtual 510	java/lang/String:trim	()Ljava/lang/String;
    //   42: invokevirtual 311	java/lang/String:length	()I
    //   45: ifne +10 -> 55
    //   48: aload_0
    //   49: invokestatic 544	com/tencent/stat/common/StatCommonHelper:getInstallChannel	(Landroid/content/Context;)Ljava/lang/String;
    //   52: putstatic 542	com/tencent/stat/StatConfig:C	Ljava/lang/String;
    //   55: getstatic 542	com/tencent/stat/StatConfig:C	Ljava/lang/String;
    //   58: ifnull +15 -> 73
    //   61: getstatic 542	com/tencent/stat/StatConfig:C	Ljava/lang/String;
    //   64: invokevirtual 510	java/lang/String:trim	()Ljava/lang/String;
    //   67: invokevirtual 311	java/lang/String:length	()I
    //   70: ifne +12 -> 82
    //   73: getstatic 73	com/tencent/stat/StatConfig:p	Lcom/tencent/stat/common/StatLogger;
    //   76: ldc_w 546
    //   79: invokevirtual 548	com/tencent/stat/common/StatLogger:w	(Ljava/lang/Object;)V
    //   82: getstatic 542	com/tencent/stat/StatConfig:C	Ljava/lang/String;
    //   85: astore_0
    //   86: goto -73 -> 13
    //   89: astore_0
    //   90: ldc 2
    //   92: monitorexit
    //   93: aload_0
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	13	89	finally
    //   18	48	89	finally
    //   48	55	89	finally
    //   55	73	89	finally
    //   73	82	89	finally
    //   82	86	89	finally
  }
  
  public static String getLocalMidOnly(Context paramContext)
  {
    return c.a(paramContext).a();
  }
  
  public static String getMTAPreferencesFileName()
  {
    return F;
  }
  
  public static int getMaxBatchReportCount()
  {
    return y;
  }
  
  public static int getMaxDaySessionNumbers()
  {
    return M;
  }
  
  public static int getMaxImportantDataSendRetryCount()
  {
    return x;
  }
  
  public static int getMaxParallelTimmingEvents()
  {
    return G;
  }
  
  public static int getMaxReportEventLength()
  {
    return P;
  }
  
  public static int getMaxSendRetryCount()
  {
    return w;
  }
  
  public static int getMaxSessionStatReportCount()
  {
    return K;
  }
  
  public static int getMaxStoreEventCount()
  {
    return u;
  }
  
  public static String getMid(Context paramContext)
  {
    return c.a(paramContext).a();
  }
  
  public static long getMsPeriodForMethodsCalledLimitClear()
  {
    return i;
  }
  
  public static int getNumEventsCachedInMemory()
  {
    return m;
  }
  
  public static int getNumEventsCommitPerSec()
  {
    return z;
  }
  
  public static int getNumOfMethodsCalledLimit()
  {
    return h;
  }
  
  public static String getQQ()
  {
    return f;
  }
  
  public static String getQQ(Context paramContext)
  {
    return StatPreferences.getString(paramContext, "mta.acc.qq", f);
  }
  
  public static int getReportCompressedSize()
  {
    return o;
  }
  
  public static int getSendPeriodMinutes()
  {
    return E;
  }
  
  public static int getSessionTimoutMillis()
  {
    return t;
  }
  
  public static String getStatReportHost()
  {
    return k;
  }
  
  public static String getStatReportUrl()
  {
    return J;
  }
  
  public static StatReportStrategy getStatSendStrategy()
  {
    return q;
  }
  
  public static boolean isAutoExceptionCaught()
  {
    return isAutoExceptionCaught;
  }
  
  public static boolean isDebugEnable()
  {
    return r;
  }
  
  public static boolean isEnableConcurrentProcess()
  {
    return Q;
  }
  
  public static boolean isEnableSmartReporting()
  {
    return j;
  }
  
  public static boolean isEnableStatService()
  {
    return s;
  }
  
  public static boolean isEventIdInDontReportEventIdsSet(String paramString)
  {
    if ((W == null) || (W.size() == 0) || (!StatCommonHelper.isStringValid(paramString))) {
      return false;
    }
    return W.contains(paramString.toLowerCase());
  }
  
  public static boolean isReportEventsByOrder()
  {
    return l;
  }
  
  public static void setAppKey(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      p.error("ctx in StatConfig.setAppKey() is null");
    }
    do
    {
      return;
      if ((paramString == null) || (paramString.length() > 256))
      {
        p.error("appkey in StatConfig.setAppKey() is null or exceed 256 bytes");
        return;
      }
      if (B == null) {
        B = a(paramContext);
      }
    } while (!(a(paramString) | a(StatCommonHelper.getAppKey(paramContext))));
    a(paramContext, B);
  }
  
  public static void setAppKey(String paramString)
  {
    if (paramString == null)
    {
      p.error("appkey in StatConfig.setAppKey() is null");
      return;
    }
    if (paramString.length() > 256)
    {
      p.error("The length of appkey cann't exceed 256 bytes.");
      return;
    }
    B = paramString;
  }
  
  public static void setAppVersion(String paramString)
  {
    U = paramString;
  }
  
  public static void setAutoExceptionCaught(boolean paramBoolean)
  {
    isAutoExceptionCaught = paramBoolean;
  }
  
  public static void setCommonAttr(Context paramContext, JSONObject paramJSONObject)
  {
    T = paramJSONObject;
    if (paramJSONObject != null) {}
    for (paramJSONObject = paramJSONObject.toString();; paramJSONObject = new JSONObject().toString())
    {
      StatPreferences.putString(paramContext, "mta.common.attr.tag", paramJSONObject);
      return;
    }
  }
  
  public static void setCustomGlobalReportContent(JSONObject paramJSONObject)
  {
    V = paramJSONObject;
  }
  
  public static void setCustomUserId(Context paramContext, String paramString)
  {
    if (paramContext == null)
    {
      p.error("Context for setCustomUid is null.");
      return;
    }
    StatPreferences.putString(paramContext, "MTA_CUSTOM_UID", paramString);
    R = paramString;
  }
  
  public static void setDebugEnable(boolean paramBoolean)
  {
    r = paramBoolean;
    StatCommonHelper.getLogger().setDebugEnable(paramBoolean);
  }
  
  public static void setEnableConcurrentProcess(boolean paramBoolean)
  {
    Q = paramBoolean;
  }
  
  public static void setEnableSmartReporting(boolean paramBoolean)
  {
    j = paramBoolean;
  }
  
  public static void setEnableStatService(boolean paramBoolean)
  {
    s = paramBoolean;
    if (!paramBoolean) {
      p.warn("!!!!!!MTA StatService has been disabled!!!!!!");
    }
  }
  
  public static void setFlushDBSpaceMS(long paramLong)
  {
    if (paramLong > 0L) {
      n = paramLong;
    }
  }
  
  public static void setInstallChannel(Context paramContext, String paramString)
  {
    if (paramString.length() > 128)
    {
      p.error("the length of installChannel can not exceed the range of 128 bytes.");
      return;
    }
    C = paramString;
    StatPreferences.putString(paramContext, D, paramString);
  }
  
  public static void setInstallChannel(String paramString)
  {
    if (paramString.length() > 128)
    {
      p.error("the length of installChannel can not exceed the range of 128 bytes.");
      return;
    }
    C = paramString;
  }
  
  public static void setMTAPreferencesFileName(String paramString)
  {
    F = paramString;
  }
  
  public static void setMaxBatchReportCount(int paramInt)
  {
    if (!a(paramInt, 2, 1000))
    {
      p.error("setMaxBatchReportCount can not exceed the range of [2,1000].");
      return;
    }
    y = paramInt;
  }
  
  public static void setMaxDaySessionNumbers(int paramInt)
  {
    if (paramInt <= 0)
    {
      p.e("maxDaySessionNumbers must be greater than 0.");
      return;
    }
    M = paramInt;
  }
  
  public static void setMaxImportantDataSendRetryCount(int paramInt)
  {
    if (paramInt > 100) {
      x = paramInt;
    }
  }
  
  public static void setMaxParallelTimmingEvents(int paramInt)
  {
    if (!a(paramInt, 1, 4096))
    {
      p.error("setMaxParallelTimmingEvents can not exceed the range of [1, 4096].");
      return;
    }
    G = paramInt;
  }
  
  public static void setMaxReportEventLength(int paramInt)
  {
    if (paramInt <= 0)
    {
      p.error("maxReportEventLength on setMaxReportEventLength() must greater than 0.");
      return;
    }
    P = paramInt;
  }
  
  public static void setMaxSendRetryCount(int paramInt)
  {
    if (!a(paramInt, 1, 1000))
    {
      p.error("setMaxSendRetryCount can not exceed the range of [1,1000].");
      return;
    }
    w = paramInt;
  }
  
  public static void setMaxSessionStatReportCount(int paramInt)
  {
    if (paramInt < 0)
    {
      p.error("maxSessionStatReportCount cannot be less than 0.");
      return;
    }
    K = paramInt;
  }
  
  public static void setMaxStoreEventCount(int paramInt)
  {
    if (!a(paramInt, 0, 500000))
    {
      p.error("setMaxStoreEventCount can not exceed the range of [0, 500000].");
      return;
    }
    u = paramInt;
  }
  
  public static void setNumEventsCachedInMemory(int paramInt)
  {
    if (paramInt >= 0) {
      m = paramInt;
    }
  }
  
  public static void setNumEventsCommitPerSec(int paramInt)
  {
    if (paramInt > 0) {
      z = paramInt;
    }
  }
  
  public static void setNumOfMethodsCalledLimit(int paramInt, long paramLong)
  {
    h = paramInt;
    if (paramLong >= 1000L) {
      i = paramLong;
    }
  }
  
  public static void setQQ(Context paramContext, String paramString)
  {
    StatPreferences.putString(paramContext, "mta.acc.qq", paramString);
    f = paramString;
  }
  
  public static void setReportCompressedSize(int paramInt)
  {
    if (paramInt > 0) {
      o = paramInt;
    }
  }
  
  public static void setReportEventsByOrder(boolean paramBoolean)
  {
    l = paramBoolean;
  }
  
  public static void setSendPeriodMinutes(int paramInt)
  {
    if (!a(paramInt, 1, 10080))
    {
      p.error("setSendPeriodMinutes can not exceed the range of [1, 7*24*60] minutes.");
      return;
    }
    E = paramInt;
  }
  
  public static void setSessionTimoutMillis(int paramInt)
  {
    if (!a(paramInt, 1000, 86400000))
    {
      p.error("setSessionTimoutMillis can not exceed the range of [1000, 24 * 60 * 60 * 1000].");
      return;
    }
    t = paramInt;
  }
  
  public static void setStatExCallBack(f paramf)
  {
    S = paramf;
  }
  
  public static void setStatReportUrl(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      p.error("statReportUrl cannot be null or empty.");
    }
    for (;;)
    {
      return;
      J = paramString;
      try
      {
        k = new URI(J).getHost();
        if (!isDebugEnable()) {
          continue;
        }
        p.i("url:" + J + ", domain:" + k);
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          p.w(paramString);
        }
      }
    }
  }
  
  public static void setStatSendStrategy(StatReportStrategy paramStatReportStrategy)
  {
    q = paramStatReportStrategy;
    if (paramStatReportStrategy != StatReportStrategy.PERIOD) {
      StatServiceImpl.c = 0L;
    }
    if (isDebugEnable()) {
      p.d("Change to statSendStrategy: " + paramStatReportStrategy);
    }
  }
  
  public static void updateDontReportEventIdsSet(String paramString)
  {
    if (StatCommonHelper.isStringValid(paramString))
    {
      paramString = paramString.toLowerCase().split(";");
      if (paramString.length > 0)
      {
        if (W == null) {
          W = new HashSet(paramString.length);
        }
        W.addAll(Arrays.asList(paramString));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.stat.StatConfig
 * JD-Core Version:    0.7.0.1
 */