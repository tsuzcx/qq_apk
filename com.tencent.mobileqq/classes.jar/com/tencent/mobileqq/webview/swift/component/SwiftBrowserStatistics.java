package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasBaseWebviewUtil;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.injector.ISwiftBrowserStatisticInjector;
import com.tencent.mobileqq.webview.swift.injector.SwiftBrowserStatisticInjectorUtil;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.TbsAccelerator;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class SwiftBrowserStatistics
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
{
  public static long E = 0L;
  public static long F = 0L;
  public static long G = 0L;
  public static boolean H = false;
  public static long I = 0L;
  public static volatile boolean aC = false;
  public static volatile boolean aD = false;
  public static volatile boolean aE = false;
  public static int aJ = 10;
  public static boolean aL = SwiftBrowserStatisticsConfigUtils.b(1, false);
  public static boolean aM = SwiftBrowserStatisticsConfigUtils.b(2, false);
  public static boolean aN = SwiftBrowserStatisticsConfigUtils.b(4, false);
  public static HashMap<String, SwiftBrowserStatistics.AntiPasswdUsage> aX = new HashMap();
  public static long ac;
  public static long ad;
  public static long ae;
  public static long af;
  public static long ag;
  public static long ah;
  public static long ai;
  public long A = 0L;
  public long B = 0L;
  public long C = 0L;
  public long D = 0L;
  public long J = 0L;
  public long K = 0L;
  public long L = 0L;
  public long M = 0L;
  public String N;
  public boolean O = false;
  public long P = 0L;
  public boolean Q = false;
  public long R = 0L;
  public long S = 0L;
  public long T = 0L;
  public long U = 0L;
  public long V = 0L;
  public long W = 0L;
  public long X = 0L;
  public long Y = 0L;
  public long Z = 0L;
  public long a = 0L;
  boolean aA;
  public boolean aB = false;
  public boolean aF = false;
  public boolean aG = false;
  public boolean aH = false;
  public JSONObject aI = null;
  public List<String> aK = new ArrayList();
  public String aO;
  public String aP;
  public int aQ = 0;
  public String aR = "";
  public boolean aS = false;
  public boolean aT = false;
  public boolean aU = false;
  Activity aV;
  public SwiftBrowserStatistics.CrashStepStatsEntry aW = new SwiftBrowserStatistics.CrashStepStatsEntry();
  private SparseArray<String> aY = new SparseArray(8);
  private HashMap<String, Long> aZ = new HashMap(7);
  public long aa = 0L;
  public long ab = 0L;
  public long aj = 0L;
  public long ak = 0L;
  public long al = 0L;
  public long am = 0L;
  public int an = -1;
  public boolean ao = false;
  public boolean ap = false;
  public boolean aq = true;
  public int ar = 0;
  public boolean as = false;
  public boolean at = true;
  public boolean au = true;
  public boolean av;
  public String aw;
  public int ax = 0;
  public boolean ay = false;
  public Runnable az;
  private String ba = "state_activity_init";
  private ISwiftBrowserStatisticInjector bb;
  public long c;
  public long d;
  public long e;
  public boolean f = false;
  public String g = "";
  public long h;
  public long i;
  public long j;
  public long k;
  public long l;
  public long m;
  public long n = 0L;
  public long o = 0L;
  public long p = 0L;
  public long q = 0L;
  public long r = 0L;
  public long s = 0L;
  public long t = 0L;
  public long u = -1L;
  public long v = 0L;
  public long w = 0L;
  public long x = -1L;
  public long y = 0L;
  public long z = 0L;
  
  private void a(Context paramContext, String paramString1, Intent paramIntent, long paramLong, String paramString2)
  {
    ThreadManager.post(new SwiftBrowserStatistics.3(this, paramString1, paramIntent, paramContext, paramLong, paramString2), 5, null, false);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    String str = SwiftWebViewUtils.b(paramString1);
    if (!"http".equals(str))
    {
      if ("https".equals(str)) {
        return;
      }
      if (!aN) {
        return;
      }
      Object localObject;
      if (paramString2 == null) {
        localObject = null;
      } else {
        localObject = Uri.parse(paramString2);
      }
      if (localObject == null) {
        paramString2 = "";
      } else {
        paramString2 = ((Uri)localObject).getHost();
      }
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = ((Uri)localObject).getPath();
      }
      ReportController.b(null, "dc00899", "WV_Analysis", "", "scheme_call", "total", paramInt, 0, paramString2, (String)localObject, str, SwiftWebViewUtils.e(paramString1));
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 2, new Object[] { "reportScheme ", str, " method:", SwiftWebViewUtils.e(paramString1) });
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    try
    {
      if ((TextUtils.isEmpty(paramString2)) && (QLog.isColorLevel()))
      {
        QLog.d("SwiftBrowserStatistics", 2, "curUrl is null");
        return;
      }
      if (!aX.containsKey(paramString2)) {
        aX.put(paramString2, new SwiftBrowserStatistics.AntiPasswdUsage());
      }
      SwiftBrowserStatistics.AntiPasswdUsage localAntiPasswdUsage = (SwiftBrowserStatistics.AntiPasswdUsage)aX.get(paramString2);
      localAntiPasswdUsage.b = paramString2;
      if (!TextUtils.isEmpty(paramString1)) {
        localAntiPasswdUsage.a = paramString1;
      }
      if (!TextUtils.isEmpty(paramString3)) {
        localAntiPasswdUsage.c = paramString3;
      }
      if (!TextUtils.isEmpty(paramString4)) {
        localAntiPasswdUsage.d = paramString4;
      }
      if (paramBoolean1) {
        localAntiPasswdUsage.e = paramBoolean1;
      }
      if (paramBoolean2) {
        localAntiPasswdUsage.f = paramBoolean2;
      }
      localAntiPasswdUsage.g = paramBoolean3;
      aX.put(paramString2, localAntiPasswdUsage);
      return;
    }
    finally {}
  }
  
  public static void c()
  {
    for (;;)
    {
      try
      {
        Object localObject = aX;
        aX = new HashMap();
        localObject = ((HashMap)localObject).values();
        if (localObject != null)
        {
          Iterator localIterator = ((Collection)localObject).iterator();
          if (localIterator.hasNext())
          {
            SwiftBrowserStatistics.AntiPasswdUsage localAntiPasswdUsage = (SwiftBrowserStatistics.AntiPasswdUsage)localIterator.next();
            HashMap localHashMap = new HashMap();
            localHashMap.put("originUrl", localAntiPasswdUsage.a);
            localHashMap.put("curUrl", localAntiPasswdUsage.b);
            if (!TextUtils.isEmpty(localAntiPasswdUsage.c)) {
              localHashMap.put("recognisedText", localAntiPasswdUsage.c);
            }
            boolean bool = localAntiPasswdUsage.e;
            String str2 = "1";
            if (bool) {
              localObject = "1";
            } else {
              localObject = "0";
            }
            localHashMap.put("passwdTyped", localObject);
            if (!localAntiPasswdUsage.f) {
              break label225;
            }
            localObject = str2;
            localHashMap.put("showPasswd", localObject);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "wvAntiPasswd", true, 0L, 0L, localHashMap, "");
            continue;
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("SwiftBrowserStatistics", 2, "nothing to report");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("SwiftBrowserStatistics", 2, localThrowable, new Object[0]);
      }
      return;
      label225:
      String str1 = "0";
    }
  }
  
  public static String f(String paramString)
  {
    if (paramString == null) {
      return "null";
    }
    int i1 = paramString.indexOf('?');
    int i2 = paramString.indexOf('#');
    if (i1 == -1)
    {
      if (i2 == -1) {
        i1 = paramString.length();
      } else {
        i1 = i2;
      }
    }
    else if (i2 != -1) {
      i1 = Math.min(i1, i2);
    }
    if (i1 == 0) {
      return "null";
    }
    return paramString.substring(0, i1);
  }
  
  public static boolean g(String paramString)
  {
    String str = SwiftWebViewUtils.b(paramString);
    if ((!"null".equals(paramString)) && (paramString.length() <= 1024) && (("http".equals(str)) || ("https".equals(str)))) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserStatistics", 2, new Object[] { "not report url:", paramString });
    }
    return false;
  }
  
  public static Bundle h(String paramString)
  {
    for (;;)
    {
      try
      {
        localBundle = new Bundle();
      }
      finally
      {
        Bundle localBundle;
        boolean bool;
        continue;
        throw paramString;
        continue;
        int i1 = 0;
        continue;
        i1 = 0;
        continue;
        i1 = 0;
        continue;
      }
      try
      {
        bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return localBundle;
        }
        if (aX.containsKey(paramString))
        {
          paramString = (SwiftBrowserStatistics.AntiPasswdUsage)aX.get(paramString);
          if (paramString.c != null)
          {
            String[] arrayOfString = paramString.c.split(",");
            ArrayList localArrayList = new ArrayList(arrayOfString.length);
            int i2 = arrayOfString.length;
            i1 = 0;
            if (i1 < i2)
            {
              localArrayList.add(arrayOfString[i1]);
              i1 += 1;
              continue;
            }
            localBundle.putStringArrayList("text_features", localArrayList);
          }
          if (TextUtils.isEmpty(paramString.d)) {
            localBundle.putString("inputText", paramString.d);
          }
          if (!paramString.f) {
            continue;
          }
          i1 = 1;
          localBundle.putInt("passwdShow", i1);
          if (!paramString.e) {
            continue;
          }
          i1 = 1;
          localBundle.putInt("passwdInput", i1);
          if (!paramString.g) {
            continue;
          }
          i1 = 1;
          localBundle.putInt("hasVirtualKB", i1);
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("SwiftBrowserStatistics", 1, paramString, new Object[0]);
      }
    }
    return localBundle;
  }
  
  public String a(TouchWebView paramTouchWebView)
  {
    paramTouchWebView = paramTouchWebView.getPluginEngine();
    if (paramTouchWebView != null)
    {
      paramTouchWebView = paramTouchWebView.b("offline");
      if ((paramTouchWebView != null) && ((paramTouchWebView instanceof OfflinePlugin)))
      {
        paramTouchWebView = (OfflinePlugin)paramTouchWebView;
        break label38;
      }
    }
    paramTouchWebView = null;
    label38:
    if ((paramTouchWebView != null) && (paramTouchWebView.d() != null)) {
      return paramTouchWebView.d();
    }
    return "";
  }
  
  public void a()
  {
    super.a();
    this.aV = this.b.b();
    this.bb = SwiftBrowserStatisticInjectorUtil.a();
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  void a(Context paramContext, SwiftBrowserStatistics.CrashStepStatsEntry paramCrashStepStatsEntry)
  {
    Object localObject = ClubContentJsonTask.e.a;
    paramContext = new File(paramContext.getFilesDir(), (String)localObject);
    if (!paramContext.exists()) {
      return;
    }
    paramContext = FileUtils.readFileContent(paramContext);
    if (TextUtils.isEmpty(paramContext)) {
      return;
    }
    try
    {
      paramContext = new JSONObject(paramContext);
      int i1 = paramContext.getInt("sample_rate");
      SwiftBrowserStatistics.CrashStepStatsEntry.e.put("sample_rate", Integer.valueOf(i1));
      localObject = paramContext.getJSONArray("rules");
      int i2 = ((JSONArray)localObject).length();
      i1 = 0;
      while (i1 < i2)
      {
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i1);
        SwiftBrowserStatistics.CrashStepStatsEntry.e.put(localJSONObject.getString("distUrl"), Integer.valueOf(localJSONObject.getInt("rate")));
        i1 += 1;
      }
      paramCrashStepStatsEntry.f = paramContext.getInt("tail_number");
      return;
    }
    catch (Throwable paramContext)
    {
      if (QLog.isColorLevel())
      {
        paramCrashStepStatsEntry = new StringBuilder();
        paramCrashStepStatsEntry.append("");
        paramCrashStepStatsEntry.append(paramContext);
        QLog.d("QQBrowser", 2, paramCrashStepStatsEntry.toString());
      }
    }
  }
  
  public void a(Context paramContext, String paramString, Intent paramIntent)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.aW.a == null) {
      this.aW.a = paramContext.getSharedPreferences("WebView_Report_Step", 0);
    }
    str3 = "UNKNOWN";
    try
    {
      int i1 = NetworkUtil.getSystemNetwork(paramContext);
      str1 = str3;
      if (i1 != -1)
      {
        str1 = str3;
        if (i1 < AppConstants.NET_TYPE_NAME.length) {
          str1 = AppConstants.NET_TYPE_NAME[i1];
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        String str2 = str3;
      }
    }
    a(paramContext, paramString, paramIntent, System.currentTimeMillis(), str1);
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e0expr(TypeTransformer.java:441)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:710)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(CustomWebView paramCustomWebView, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String... paramVarArgs)
  {
    ThreadManager.post(new SwiftBrowserStatistics.4(this, paramCustomWebView, paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramVarArgs), 5, null, false);
  }
  
  public void a(TouchWebView paramTouchWebView, int paramInt, String paramString1, String paramString2)
  {
    String str2 = a(paramTouchWebView);
    int i1;
    if (paramTouchWebView.getX5WebViewExtension() != null) {
      i1 = 3;
    } else {
      i1 = 1;
    }
    int i2 = 0;
    while (i2 < this.aK.size())
    {
      String str1 = (String)this.aK.get(i2);
      if (i2 == this.aK.size() - 1) {
        localObject1 = String.valueOf(paramInt);
      } else {
        localObject1 = "10001";
      }
      Object localObject2;
      if (str1 != null) {
        localObject2 = str1;
      } else {
        localObject2 = "unknown";
      }
      VasBaseWebviewUtil.reportQBWebInfo(str2, "qbweb_load_redirect", "", ((String)localObject2).replace("|", "%7C"), i1, 0, "0", String.valueOf(this.ax), HttpUtil.getNetWorkTypeByStr(), 0, 0, "", (String)localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("url=");
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append(", rlt=");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("SwiftBrowserStatistics", 2, ((StringBuilder)localObject2).toString());
      }
      i2 += 1;
    }
    this.aK.clear();
    Object localObject1 = this.bb;
    if (localObject1 != null) {
      ((ISwiftBrowserStatisticInjector)localObject1).a(paramTouchWebView, paramInt, paramString1, paramString2);
    }
  }
  
  public void a(TouchWebView paramTouchWebView, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    if (!this.as) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.post(new SwiftBrowserStatistics.2(this, paramString, paramInt, paramString, paramInt), 5, null, false);
  }
  
  public void a(String paramString1, long paramLong, String paramString2)
  {
    Object localObject = this.bb;
    if (localObject != null) {
      ((ISwiftBrowserStatisticInjector)localObject).a(paramString1, paramLong, paramString2, this.aw);
    }
    localObject = this.aO;
    int i3 = this.aS;
    boolean bool = this.aT;
    int i2 = 0;
    int i1;
    if (bool) {
      i1 = 2;
    } else {
      i1 = 0;
    }
    if (this.aU) {
      i2 = 4;
    }
    ReportController.b(null, "dc00899", "WV_Analysis", "", paramString1, (String)localObject, i3 | i1 | i2, (int)paramLong, String.valueOf(this.aQ), this.aR, this.aP, paramString2);
  }
  
  public void a(String paramString1, long paramLong, AppRuntime paramAppRuntime, String paramString2, String paramString3)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      paramString1 = f(paramString1);
      if (!g(paramString1)) {
        return;
      }
      localHashMap.put("url", paramString1);
      localHashMap.put(paramString2, paramString3);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder("reportErrorScene: ");
        paramString1.append(localHashMap);
        QLog.d("SwiftBrowserStatistics", 4, paramString1.toString());
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actWvReportError", true, 0L, 0L, localHashMap, "");
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("SwiftBrowserStatistics", 2, paramString1, new Object[0]);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject("DETAIL");
      boolean bool = localJSONObject.optBoolean("is_first_init_tbs");
      long l1 = localJSONObject.optLong("init_x5_core_begin");
      long l2 = localJSONObject.optLong("init_x5_core_end");
      long l3 = localJSONObject.optLong("webview_init_begin");
      long l4 = localJSONObject.optLong("webview_init_end");
      long l5 = localJSONObject.optLong("tbslog_init_begin");
      long l6 = localJSONObject.optLong("tbslog_init_end");
      long l7 = localJSONObject.optLong("init_all_begin");
      long l8 = localJSONObject.optLong("init_all_end");
      long l9 = localJSONObject.optLong("tbs_load_so_begin");
      long l10 = localJSONObject.optLong("tbs_load_so_end");
      this.z = (l2 - l1);
      this.A = (l4 - l3);
      this.B = (l10 - l9);
      this.C = (l6 - l5);
      this.D = (l8 - l7);
      if (QLog.isColorLevel())
      {
        QLog.d("SwiftBrowserStatistics", 2, new Object[] { "performance: ", paramJSONObject.toString() });
        QLog.d("SwiftBrowserStatistics", 2, new Object[] { "firstInitTbs: ", Boolean.valueOf(bool), " x5core: ", Long.valueOf(this.z), " webview: ", Long.valueOf(this.A), " loadSo:", Long.valueOf(this.B), " tbsLog:", Long.valueOf(this.C), " initAll:", Long.valueOf(this.D) });
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("SwiftBrowserStatistics", 1, new Object[] { "exception ", paramJSONObject.toString() });
    }
  }
  
  public void b()
  {
    ISwiftBrowserStatisticInjector localISwiftBrowserStatisticInjector = this.bb;
    if (localISwiftBrowserStatisticInjector != null) {
      localISwiftBrowserStatisticInjector.a(this.au, this.aw, this.e);
    }
  }
  
  public void b(Intent paramIntent, String paramString)
  {
    if (!aL) {
      return;
    }
    HashMap localHashMap = new HashMap();
    paramString = f(paramString);
    if (!g(paramString)) {
      return;
    }
    localHashMap.put("url", paramString);
    localHashMap.put("source_activity", paramIntent.getStringExtra("SourceActivityName"));
    long l1 = E;
    long l2 = this.J;
    boolean bool2 = true;
    if (l1 > l2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramIntent = this.aZ.keySet().iterator();
    while (paramIntent.hasNext())
    {
      paramString = (String)paramIntent.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((Long)this.aZ.get(paramString)).longValue() - this.J);
      localStringBuilder.append("");
      localHashMap.put(paramString, localStringBuilder.toString());
    }
    localHashMap.put("bounce_rate_state", this.ba);
    paramIntent = new StringBuilder();
    paramIntent.append("");
    paramIntent.append(bool1);
    localHashMap.put("is_cold_launch", paramIntent.toString());
    localHashMap.put("network_type", HttpUtil.getNetWorkTypeByStr());
    paramIntent = new StringBuilder();
    paramIntent.append(Build.MODEL);
    paramIntent.append(Build.VERSION.SDK_INT);
    localHashMap.put("system_os", paramIntent.toString());
    localHashMap.put("QQ_version", AppSetting.i());
    paramIntent = new StringBuilder();
    paramIntent.append(H);
    paramIntent.append("");
    localHashMap.put("use_offline_package", paramIntent.toString());
    paramIntent = new StringBuilder();
    paramIntent.append(this.Q);
    paramIntent.append("");
    localHashMap.put("use_sonic", paramIntent.toString());
    paramIntent = new StringBuilder();
    paramIntent.append("");
    paramIntent.append(aD);
    localHashMap.put("use_pre_load", paramIntent.toString());
    paramIntent = new StringBuilder();
    boolean bool1 = bool2;
    if (I > this.J) {
      bool1 = false;
    }
    paramIntent.append(bool1);
    paramIntent.append("");
    localHashMap.put("is_x5_init", paramIntent.toString());
    paramIntent = new StringBuilder();
    paramIntent.append(this.aQ);
    paramIntent.append("");
    localHashMap.put("core_type", paramIntent.toString());
    localHashMap.put("activity_create_final", String.valueOf(this.L - this.K));
    localHashMap.put("origin_url", this.aO);
    if (this.aK.size() > 0)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("");
      paramIntent.append(this.aK.size());
      localHashMap.put("redirect_time", paramIntent.toString());
      localHashMap.put("first_url", this.aK.get(0));
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder("reportBounceRate: ");
      paramIntent.append(localHashMap);
      QLog.d("SwiftBrowserStatistics", 4, paramIntent.toString());
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "webviewBounceRateCollection", true, 0L, 0L, localHashMap, "");
  }
  
  public void b(String paramString)
  {
    if (!aL) {
      return;
    }
    HashMap localHashMap = new HashMap();
    paramString = f(paramString);
    if (!g(paramString)) {
      return;
    }
    localHashMap.put("url", paramString);
    localHashMap.put("source_activity", this.N);
    localHashMap.put("process_start_spending_time", String.valueOf(this.M));
    localHashMap.put("init_tbs_time", String.valueOf(this.C));
    localHashMap.put("init_x5_core_time", String.valueOf(this.z));
    localHashMap.put("init_x5_webview_time", String.valueOf(this.A));
    localHashMap.put("init_tbs_so_time", String.valueOf(this.B));
    localHashMap.put("init_all_time", String.valueOf(this.D));
    localHashMap.put("activity_on_create_time", String.valueOf(this.K - this.J));
    paramString = new StringBuilder();
    paramString.append("");
    paramString.append(this.O);
    localHashMap.put("is_cold_launch", paramString.toString());
    localHashMap.put("network_type", this.aP);
    paramString = new StringBuilder();
    paramString.append(Build.MODEL);
    paramString.append(Build.VERSION.SDK_INT);
    localHashMap.put("system_os", paramString.toString());
    localHashMap.put("QQ_version", AppSetting.i());
    paramString = new StringBuilder();
    paramString.append(H);
    paramString.append("");
    localHashMap.put("use_offline_package", paramString.toString());
    paramString = new StringBuilder();
    paramString.append(this.Q);
    paramString.append("");
    localHashMap.put("use_sonic", paramString.toString());
    paramString = new StringBuilder();
    paramString.append("");
    paramString.append(aD);
    localHashMap.put("use_pre_load", paramString.toString());
    paramString = new StringBuilder();
    boolean bool;
    if (I > this.J) {
      bool = false;
    } else {
      bool = true;
    }
    paramString.append(bool);
    paramString.append("");
    localHashMap.put("is_x5_init", paramString.toString());
    localHashMap.put("webview_create_time", String.valueOf(this.P));
    localHashMap.put("core_type", String.valueOf(this.aQ));
    localHashMap.put("fragment_create_final", String.valueOf(this.L - this.K));
    localHashMap.put("browser_act_create_cost", String.valueOf(this.L - F));
    if (this.aK.size() > 0)
    {
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append(this.aK.size());
      localHashMap.put("redirect_time", paramString.toString());
      localHashMap.put("first_url", this.aK.get(0));
    }
    localHashMap.put("int_tbs_env", String.valueOf(SwiftWebAccelerator.TbsAccelerator.b));
    localHashMap.put("init_plugin", String.valueOf(G));
    localHashMap.put("fragment_create_time", String.valueOf(this.K - F));
    localHashMap.put("step_initUIFrame", String.valueOf(this.R));
    localHashMap.put("step_initUIContent", String.valueOf(this.T));
    localHashMap.put("step_initTitleBar", String.valueOf(this.S));
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder("webviewSpendingTimeCollection: ");
      paramString.append(localHashMap);
      QLog.d("SwiftBrowserStatistics", 4, paramString.toString());
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "webviewSpendingTimeCollection", true, 0L, 0L, localHashMap, "");
  }
  
  public void c(String paramString)
  {
    if (paramString.equals("state_back"))
    {
      if (!this.ba.equals("state_final")) {
        this.aZ.put("state_back", Long.valueOf(SystemClock.elapsedRealtime()));
      }
      return;
    }
    if (this.aY.size() == 0)
    {
      this.aY.put(0, "state_activity_init");
      this.aY.put(1, "state_activity_create");
      this.aY.put(2, "state_webview_create");
      this.aY.put(3, "state_load_url");
      this.aY.put(4, "state_activity_first_line");
      this.aY.put(5, "state_first_screen");
      this.aY.put(6, "state_page_finished");
      this.aY.put(7, "state_final");
    }
    int i1 = this.aY.indexOfValue(paramString);
    int i2 = this.aY.indexOfValue(this.ba);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setBounceRateState state=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" mCurr=");
      localStringBuilder.append(this.ba);
      QLog.d("SwiftBrowserStatistics", 4, localStringBuilder.toString());
    }
    if (i1 > i2)
    {
      this.ba = paramString;
      this.aZ.put(this.ba, Long.valueOf(SystemClock.elapsedRealtime()));
    }
  }
  
  public void d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (this.ay)
      {
        String str = paramString.getQueryParameter("appid");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((int)((System.nanoTime() - this.l) / 1000000L));
        localStringBuilder.append("");
        ReportController.b(null, "P_CliOper", "Grp_open", "", "time", "wide_time", 0, 1, 0, "", str, localStringBuilder.toString(), paramString.getQueryParameter("group_openid"));
      }
    }
    if (QLog.isDevelopLevel())
    {
      paramString = new StringBuilder();
      paramString.append("web_stay_in_url, cost = ");
      paramString.append((System.nanoTime() - this.l) / 1000000L);
      paramString.append(", url = ");
      paramString.append(Util.b(this.aw, new String[0]));
      paramString.append(", isFromLeba = ");
      paramString.append(this.ao);
      paramString.append(", hasRedDot = ");
      paramString.append(this.ap);
      QLog.d("web_report", 4, paramString.toString());
    }
    if (this.az != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.az);
    }
    paramString = this.bb;
    if (paramString != null) {
      paramString.a(this.au, this.aw);
    }
  }
  
  public void e(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shouldOverrideUrlLoading detect 302, url: ");
    localStringBuilder.append(paramString);
    QLog.i("SwiftBrowserStatistics", 1, localStringBuilder.toString());
    this.x = System.currentTimeMillis();
    this.aq = true;
    this.aK.add(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics
 * JD-Core Version:    0.7.0.1
 */