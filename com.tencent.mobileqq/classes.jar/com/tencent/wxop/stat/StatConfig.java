package com.tencent.wxop.stat;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.a.a.a.a.c;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.common.l;
import com.tencent.wxop.stat.common.q;
import java.net.URI;
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
  private static int F;
  private static long G;
  private static long H;
  private static volatile String I = "http://pingma.qq.com:80/mstat/report";
  private static int J = 0;
  private static volatile int K = 0;
  private static int L = 20;
  private static int M = 0;
  private static boolean N = false;
  private static int O = 4096;
  private static boolean P = false;
  private static String Q = null;
  private static boolean R = false;
  private static g S = null;
  static f a;
  static f b;
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
  static boolean l = true;
  static int m = 0;
  static long n = 10000L;
  static int o = 512;
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
    a = new f(2);
    b = new f(1);
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
    h = 100;
    i = 10000L;
    F = 1024;
    j = true;
    G = 0L;
    H = 300000L;
    isAutoExceptionCaught = true;
    k = "pingma.qq.com:80";
  }
  
  static int a()
  {
    return v;
  }
  
  static String a(String paramString1, String paramString2)
  {
    try
    {
      String str = b.b.getString(paramString1);
      if (str != null) {
        paramString2 = str;
      }
      return paramString2;
    }
    catch (Throwable localThrowable)
    {
      p.w("can't find custom key:" + paramString1);
    }
    return paramString2;
  }
  
  static void a(int paramInt)
  {
    try
    {
      K = paramInt;
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
    q.b(i.a(), c, paramLong);
    setEnableStatService(false);
    p.warn("MTA is disable for current SDK version");
  }
  
  static void a(Context paramContext, f paramf)
  {
    if (paramf.a == b.a)
    {
      b = paramf;
      a(paramf.b);
      if (!b.b.isNull("iplist")) {
        a.a(paramContext).a(b.b.getString("iplist"));
      }
    }
    while (paramf.a != a.a) {
      return;
    }
    a = paramf;
  }
  
  static void a(Context paramContext, f paramf, JSONObject paramJSONObject)
  {
    int i1 = 0;
    label210:
    for (;;)
    {
      try
      {
        Iterator localIterator = paramJSONObject.keys();
        if (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if (str.equalsIgnoreCase("v"))
          {
            int i2 = paramJSONObject.getInt(str);
            if (paramf.d == i2) {
              break label210;
            }
            i1 = 1;
            paramf.d = i2;
            continue;
          }
          if (str.equalsIgnoreCase("c"))
          {
            str = paramJSONObject.getString("c");
            if (str.length() <= 0) {
              continue;
            }
            paramf.b = new JSONObject(str);
            continue;
          }
        }
      }
      catch (JSONException paramContext)
      {
        String str;
        p.e(paramContext);
        return;
        if (!str.equalsIgnoreCase("m")) {
          continue;
        }
        paramf.c = paramJSONObject.getString("m");
        continue;
      }
      catch (Throwable paramContext)
      {
        p.e(paramContext);
        return;
      }
      if (i1 == 1)
      {
        paramJSONObject = au.a(i.a());
        if (paramJSONObject != null) {
          paramJSONObject.a(paramf);
        }
        if (paramf.a == b.a)
        {
          a(paramf.b);
          b(paramf.b);
        }
      }
      a(paramContext, paramf);
      return;
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
  
  static boolean a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (!paramJSONObject.isNull(paramString1))
    {
      paramJSONObject = paramJSONObject.optString(paramString1);
      if ((l.c(paramString2)) && (l.c(paramJSONObject)) && (paramString2.equalsIgnoreCase(paramJSONObject))) {
        return true;
      }
    }
    return false;
  }
  
  static void b()
  {
    M += 1;
  }
  
  static void b(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    M = paramInt;
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
        if (!l.c(paramJSONObject)) {
          break;
        }
        paramJSONObject = new JSONObject(paramJSONObject);
        if (paramJSONObject.length() == 0) {
          return;
        }
        if (!paramJSONObject.isNull("sm"))
        {
          localObject = paramJSONObject.get("sm");
          if (!(localObject instanceof Integer)) {
            break label531;
          }
          i1 = ((Integer)localObject).intValue();
          if (i1 > 0)
          {
            if (isDebugEnable()) {
              p.i("match sleepTime:" + i1 + " minutes");
            }
            long l1 = System.currentTimeMillis();
            long l2 = i1 * 60 * 1000;
            q.b(paramContext, d, l1 + l2);
            setEnableStatService(false);
            p.warn("MTA is disable for current SDK version");
          }
        }
        if (!a(paramJSONObject, "sv", "2.0.4")) {
          break label554;
        }
        p.i("match sdk version:2.0.4");
        i1 = 1;
        if (a(paramJSONObject, "md", Build.MODEL))
        {
          p.i("match MODEL:" + Build.MODEL);
          i1 = 1;
        }
        if (a(paramJSONObject, "av", l.h(paramContext)))
        {
          p.i("match app version:" + l.h(paramContext));
          i1 = 1;
        }
        if (a(paramJSONObject, "mf", Build.MANUFACTURER))
        {
          p.i("match MANUFACTURER:" + Build.MANUFACTURER);
          i1 = 1;
        }
        if (a(paramJSONObject, "osv", Build.VERSION.SDK_INT))
        {
          p.i("match android SDK version:" + Build.VERSION.SDK_INT);
          i1 = 1;
        }
        if (a(paramJSONObject, "ov", Build.VERSION.SDK_INT))
        {
          p.i("match android SDK version:" + Build.VERSION.SDK_INT);
          i1 = 1;
        }
        if (a(paramJSONObject, "ui", au.a(paramContext).b(paramContext).b()))
        {
          p.i("match imei:" + au.a(paramContext).b(paramContext).b());
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
        a(l.b("2.0.4"));
        return;
      }
      catch (Exception paramContext)
      {
        p.e(paramContext);
        return;
      }
      label531:
      if ((localObject instanceof String))
      {
        i1 = Integer.valueOf((String)localObject).intValue();
        continue;
        label554:
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
        b(i.a(), paramJSONObject);
        paramJSONObject = paramJSONObject.getString(c);
        if (isDebugEnable()) {
          p.d("hibernateVer:" + paramJSONObject + ", current version:2.0.4");
        }
        long l1 = l.b(paramJSONObject);
        if (l.b("2.0.4") <= l1)
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
    return M;
  }
  
  public static String getAppKey(Context paramContext)
  {
    try
    {
      paramContext = B;
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static int getCurSessionStatReportCount()
  {
    return K;
  }
  
  public static g getCustomLogger()
  {
    return S;
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
    if (Q == null) {
      Q = q.a(paramContext, "MTA_CUSTOM_UID", "");
    }
    return Q;
  }
  
  public static long getFlushDBSpaceMS()
  {
    return n;
  }
  
  public static String getInstallChannel(Context paramContext)
  {
    try
    {
      paramContext = C;
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static String getLocalMidOnly(Context paramContext)
  {
    if (paramContext != null) {
      return com.tencent.a.a.a.a.g.C(paramContext).p().a();
    }
    return "0";
  }
  
  public static int getMaxBatchReportCount()
  {
    return y;
  }
  
  public static int getMaxDaySessionNumbers()
  {
    return L;
  }
  
  public static int getMaxImportantDataSendRetryCount()
  {
    return x;
  }
  
  public static int getMaxParallelTimmingEvents()
  {
    return F;
  }
  
  public static int getMaxReportEventLength()
  {
    return O;
  }
  
  public static int getMaxSendRetryCount()
  {
    return w;
  }
  
  public static int getMaxSessionStatReportCount()
  {
    return J;
  }
  
  public static int getMaxStoreEventCount()
  {
    return u;
  }
  
  public static String getMid(Context paramContext)
  {
    return getLocalMidOnly(paramContext);
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
  
  public static String getQQ(Context paramContext)
  {
    return q.a(paramContext, "mta.acc.qq", f);
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
    return I;
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
    return P;
  }
  
  public static boolean isEnableSmartReporting()
  {
    return j;
  }
  
  public static boolean isEnableStatService()
  {
    return s;
  }
  
  public static boolean isReportEventsByOrder()
  {
    return l;
  }
  
  public static boolean isXGProMode()
  {
    return R;
  }
  
  public static void setAppKey(Context paramContext, String paramString)
  {
    if (paramContext == null)
    {
      p.error("ctx in StatConfig.setAppKey() is null");
      return;
    }
    if ((paramString == null) || (paramString.length() > 256))
    {
      p.error("appkey in StatConfig.setAppKey() is null or exceed 256 bytes");
      return;
    }
    B = paramString;
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
  
  public static void setAutoExceptionCaught(boolean paramBoolean)
  {
    isAutoExceptionCaught = paramBoolean;
  }
  
  public static void setCustomLogger(g paramg)
  {
    S = paramg;
  }
  
  public static void setCustomUserId(Context paramContext, String paramString)
  {
    if (paramContext == null)
    {
      p.error("Context for setCustomUid is null.");
      return;
    }
    q.b(paramContext, "MTA_CUSTOM_UID", paramString);
    Q = paramString;
  }
  
  public static void setDebugEnable(boolean paramBoolean)
  {
    r = paramBoolean;
    l.b().setDebugEnable(paramBoolean);
  }
  
  public static void setEnableConcurrentProcess(boolean paramBoolean)
  {
    P = paramBoolean;
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
  }
  
  public static void setInstallChannel(String paramString)
  {
    C = paramString;
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
    L = paramInt;
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
    F = paramInt;
  }
  
  public static void setMaxReportEventLength(int paramInt)
  {
    if (paramInt <= 0)
    {
      p.error("maxReportEventLength on setMaxReportEventLength() must greater than 0.");
      return;
    }
    O = paramInt;
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
    J = paramInt;
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
    q.b(paramContext, "mta.acc.qq", paramString);
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
  
  public static void setStatReportUrl(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      p.error("statReportUrl cannot be null or empty.");
    }
    for (;;)
    {
      return;
      I = paramString;
      try
      {
        k = new URI(I).getHost();
        if (!isDebugEnable()) {
          continue;
        }
        p.i("url:" + I + ", domain:" + k);
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
  
  public static void setXGProMode(boolean paramBoolean)
  {
    R = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.StatConfig
 * JD-Core Version:    0.7.0.1
 */