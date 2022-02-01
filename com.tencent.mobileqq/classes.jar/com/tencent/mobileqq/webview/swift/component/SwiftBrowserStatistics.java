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
  public static long B = 0L;
  public static long C = 0L;
  public static long D = 0L;
  public static long E = 0L;
  public static long V = 0L;
  public static long W = 0L;
  public static long X = 0L;
  public static long Y = 0L;
  public static long Z = 0L;
  public static HashMap<String, SwiftBrowserStatistics.AntiPasswdUsage> a;
  public static long aa = 0L;
  public static long ab = 0L;
  public static boolean b = false;
  public static int d = 10;
  public static volatile boolean o = false;
  public static volatile boolean p = false;
  public static volatile boolean q = false;
  public static boolean u;
  public static boolean v;
  public static boolean w;
  public long A = 0L;
  public long F = 0L;
  public long G = 0L;
  public long H = 0L;
  public long I = 0L;
  public long J = 0L;
  public long K = 0L;
  public long L = 0L;
  public long M = 0L;
  public long N = 0L;
  public long O = 0L;
  public long P = 0L;
  public long Q = 0L;
  public long R = 0L;
  public long S = 0L;
  public long T = 0L;
  public long U = 0L;
  public int a;
  public long a;
  Activity jdField_a_of_type_AndroidAppActivity;
  private SparseArray<String> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(8);
  public SwiftBrowserStatistics.CrashStepStatsEntry a;
  private ISwiftBrowserStatisticInjector jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorISwiftBrowserStatisticInjector;
  public Runnable a;
  public String a;
  public List<String> a;
  public JSONObject a;
  public boolean a;
  public long ac = 0L;
  public long ad = 0L;
  public long ae = 0L;
  public long af = 0L;
  public int b;
  public long b;
  public String b;
  private HashMap<String, Long> b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public long d;
  public String d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public boolean e;
  public long f;
  public String f;
  public boolean f;
  public long g;
  private String g;
  public boolean g;
  public long h;
  public boolean h = false;
  public long i;
  public boolean i;
  public long j;
  public boolean j = true;
  public long k = 0L;
  public boolean k;
  public long l;
  public boolean l;
  public long m = 0L;
  boolean m;
  public long n;
  public boolean n;
  public long o = 0L;
  public long p;
  public long q = 0L;
  public long r;
  public boolean r;
  public long s;
  public boolean s;
  public long t;
  public boolean t;
  public long u;
  public long v;
  public long w;
  public long x;
  public boolean x;
  public long y;
  public boolean y;
  public long z;
  public boolean z;
  
  static
  {
    jdField_u_of_type_Boolean = SwiftBrowserStatisticsConfigUtils.b(1, false);
    jdField_v_of_type_Boolean = SwiftBrowserStatisticsConfigUtils.b(2, false);
    jdField_w_of_type_Boolean = SwiftBrowserStatisticsConfigUtils.b(4, false);
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public SwiftBrowserStatistics()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_l_of_type_Long = 0L;
    this.jdField_n_of_type_Long = 0L;
    this.jdField_p_of_type_Long = 0L;
    this.jdField_r_of_type_Long = -1L;
    this.jdField_s_of_type_Long = 0L;
    this.jdField_t_of_type_Long = 0L;
    this.jdField_u_of_type_Long = -1L;
    this.jdField_v_of_type_Long = 0L;
    this.jdField_w_of_type_Long = 0L;
    this.jdField_x_of_type_Long = 0L;
    this.jdField_y_of_type_Long = 0L;
    this.jdField_z_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap(7);
    this.jdField_g_of_type_JavaLangString = "state_activity_init";
    this.jdField_a_of_type_Int = -1;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 0;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 0;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_r_of_type_Boolean = false;
    this.jdField_s_of_type_Boolean = false;
    this.jdField_t_of_type_Boolean = false;
    this.jdField_a_of_type_OrgJsonJSONObject = null;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_x_of_type_Boolean = false;
    this.jdField_y_of_type_Boolean = false;
    this.jdField_z_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry = new SwiftBrowserStatistics.CrashStepStatsEntry();
  }
  
  public static Bundle a(String paramString)
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
        if (jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
        {
          paramString = (SwiftBrowserStatistics.AntiPasswdUsage)jdField_a_of_type_JavaUtilHashMap.get(paramString);
          if (paramString.jdField_c_of_type_JavaLangString != null)
          {
            String[] arrayOfString = paramString.jdField_c_of_type_JavaLangString.split(",");
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
          if (TextUtils.isEmpty(paramString.jdField_d_of_type_JavaLangString)) {
            localBundle.putString("inputText", paramString.jdField_d_of_type_JavaLangString);
          }
          if (!paramString.jdField_b_of_type_Boolean) {
            continue;
          }
          i1 = 1;
          localBundle.putInt("passwdShow", i1);
          if (!paramString.jdField_a_of_type_Boolean) {
            continue;
          }
          i1 = 1;
          localBundle.putInt("passwdInput", i1);
          if (!paramString.jdField_c_of_type_Boolean) {
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
  
  public static String a(String paramString)
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
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    String str = SwiftWebViewUtils.b(paramString1);
    if (!"http".equals(str))
    {
      if ("https".equals(str)) {
        return;
      }
      if (!jdField_w_of_type_Boolean) {
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
      ReportController.b(null, "dc00899", "WV_Analysis", "", "scheme_call", "total", paramInt, 0, paramString2, (String)localObject, str, SwiftWebViewUtils.d(paramString1));
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 2, new Object[] { "reportScheme ", str, " method:", SwiftWebViewUtils.d(paramString1) });
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
      if (!jdField_a_of_type_JavaUtilHashMap.containsKey(paramString2)) {
        jdField_a_of_type_JavaUtilHashMap.put(paramString2, new SwiftBrowserStatistics.AntiPasswdUsage());
      }
      SwiftBrowserStatistics.AntiPasswdUsage localAntiPasswdUsage = (SwiftBrowserStatistics.AntiPasswdUsage)jdField_a_of_type_JavaUtilHashMap.get(paramString2);
      localAntiPasswdUsage.jdField_b_of_type_JavaLangString = paramString2;
      if (!TextUtils.isEmpty(paramString1)) {
        localAntiPasswdUsage.jdField_a_of_type_JavaLangString = paramString1;
      }
      if (!TextUtils.isEmpty(paramString3)) {
        localAntiPasswdUsage.jdField_c_of_type_JavaLangString = paramString3;
      }
      if (!TextUtils.isEmpty(paramString4)) {
        localAntiPasswdUsage.jdField_d_of_type_JavaLangString = paramString4;
      }
      if (paramBoolean1) {
        localAntiPasswdUsage.jdField_a_of_type_Boolean = paramBoolean1;
      }
      if (paramBoolean2) {
        localAntiPasswdUsage.jdField_b_of_type_Boolean = paramBoolean2;
      }
      localAntiPasswdUsage.jdField_c_of_type_Boolean = paramBoolean3;
      jdField_a_of_type_JavaUtilHashMap.put(paramString2, localAntiPasswdUsage);
      return;
    }
    finally {}
  }
  
  public static boolean a(String paramString)
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
  
  public static void c()
  {
    for (;;)
    {
      try
      {
        Object localObject = jdField_a_of_type_JavaUtilHashMap;
        jdField_a_of_type_JavaUtilHashMap = new HashMap();
        localObject = ((HashMap)localObject).values();
        if (localObject != null)
        {
          Iterator localIterator = ((Collection)localObject).iterator();
          if (localIterator.hasNext())
          {
            SwiftBrowserStatistics.AntiPasswdUsage localAntiPasswdUsage = (SwiftBrowserStatistics.AntiPasswdUsage)localIterator.next();
            HashMap localHashMap = new HashMap();
            localHashMap.put("originUrl", localAntiPasswdUsage.jdField_a_of_type_JavaLangString);
            localHashMap.put("curUrl", localAntiPasswdUsage.jdField_b_of_type_JavaLangString);
            if (!TextUtils.isEmpty(localAntiPasswdUsage.jdField_c_of_type_JavaLangString)) {
              localHashMap.put("recognisedText", localAntiPasswdUsage.jdField_c_of_type_JavaLangString);
            }
            boolean bool = localAntiPasswdUsage.jdField_a_of_type_Boolean;
            String str2 = "1";
            if (bool) {
              localObject = "1";
            } else {
              localObject = "0";
            }
            localHashMap.put("passwdTyped", localObject);
            if (!localAntiPasswdUsage.jdField_b_of_type_Boolean) {
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
  
  public String a(TouchWebView paramTouchWebView)
  {
    paramTouchWebView = paramTouchWebView.getPluginEngine();
    if (paramTouchWebView != null)
    {
      paramTouchWebView = paramTouchWebView.a("offline");
      if ((paramTouchWebView != null) && ((paramTouchWebView instanceof OfflinePlugin)))
      {
        paramTouchWebView = (OfflinePlugin)paramTouchWebView;
        break label38;
      }
    }
    paramTouchWebView = null;
    label38:
    if ((paramTouchWebView != null) && (paramTouchWebView.a() != null)) {
      return paramTouchWebView.a();
    }
    return "";
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorISwiftBrowserStatisticInjector = SwiftBrowserStatisticInjectorUtil.a();
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  void a(Context paramContext, SwiftBrowserStatistics.CrashStepStatsEntry paramCrashStepStatsEntry)
  {
    Object localObject = ClubContentJsonTask.e.jdField_a_of_type_JavaLangString;
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
      SwiftBrowserStatistics.CrashStepStatsEntry.jdField_a_of_type_JavaUtilHashMap.put("sample_rate", Integer.valueOf(i1));
      localObject = paramContext.getJSONArray("rules");
      int i2 = ((JSONArray)localObject).length();
      i1 = 0;
      while (i1 < i2)
      {
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i1);
        SwiftBrowserStatistics.CrashStepStatsEntry.jdField_a_of_type_JavaUtilHashMap.put(localJSONObject.getString("distUrl"), Integer.valueOf(localJSONObject.getInt("rate")));
        i1 += 1;
      }
      paramCrashStepStatsEntry.jdField_c_of_type_Int = paramContext.getInt("tail_number");
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
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_AndroidContentSharedPreferences = paramContext.getSharedPreferences("WebView_Report_Step", 0);
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
    ThreadManager.post(new SwiftBrowserStatistics.3(this, paramString, paramIntent, paramContext, System.currentTimeMillis(), str1), 5, null, false);
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
    while (i2 < this.jdField_a_of_type_JavaUtilList.size())
    {
      String str1 = (String)this.jdField_a_of_type_JavaUtilList.get(i2);
      if (i2 == this.jdField_a_of_type_JavaUtilList.size() - 1) {
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
      VasBaseWebviewUtil.reportQBWebInfo(str2, "qbweb_load_redirect", "", ((String)localObject2).replace("|", "%7C"), i1, 0, "0", String.valueOf(this.jdField_c_of_type_Int), HttpUtil.getNetWorkTypeByStr(), 0, 0, "", (String)localObject1);
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
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorISwiftBrowserStatisticInjector;
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
    if (!this.h) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.post(new SwiftBrowserStatistics.2(this, paramString, paramInt, paramString, paramInt), 5, null, false);
  }
  
  public void a(String paramString1, long paramLong, String paramString2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorISwiftBrowserStatisticInjector;
    if (localObject != null) {
      ((ISwiftBrowserStatisticInjector)localObject).a(paramString1, paramLong, paramString2, this.jdField_c_of_type_JavaLangString);
    }
    localObject = this.jdField_d_of_type_JavaLangString;
    int i3 = this.jdField_x_of_type_Boolean;
    boolean bool = this.jdField_y_of_type_Boolean;
    int i2 = 0;
    int i1;
    if (bool) {
      i1 = 2;
    } else {
      i1 = 0;
    }
    if (this.jdField_z_of_type_Boolean) {
      i2 = 4;
    }
    ReportController.b(null, "dc00899", "WV_Analysis", "", paramString1, (String)localObject, i3 | i1 | i2, (int)paramLong, String.valueOf(this.jdField_e_of_type_Int), this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, paramString2);
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
      paramString1 = a(paramString1);
      if (!a(paramString1)) {
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
      this.jdField_w_of_type_Long = (l2 - l1);
      this.jdField_x_of_type_Long = (l4 - l3);
      this.jdField_y_of_type_Long = (l10 - l9);
      this.jdField_z_of_type_Long = (l6 - l5);
      this.A = (l8 - l7);
      if (QLog.isColorLevel())
      {
        QLog.d("SwiftBrowserStatistics", 2, new Object[] { "performance: ", paramJSONObject.toString() });
        QLog.d("SwiftBrowserStatistics", 2, new Object[] { "firstInitTbs: ", Boolean.valueOf(bool), " x5core: ", Long.valueOf(this.jdField_w_of_type_Long), " webview: ", Long.valueOf(this.jdField_x_of_type_Long), " loadSo:", Long.valueOf(this.jdField_y_of_type_Long), " tbsLog:", Long.valueOf(this.jdField_z_of_type_Long), " initAll:", Long.valueOf(this.A) });
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
    ISwiftBrowserStatisticInjector localISwiftBrowserStatisticInjector = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorISwiftBrowserStatisticInjector;
    if (localISwiftBrowserStatisticInjector != null) {
      localISwiftBrowserStatisticInjector.a(this.j, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Long);
    }
  }
  
  public void b(Intent paramIntent, String paramString)
  {
    if (!jdField_u_of_type_Boolean) {
      return;
    }
    HashMap localHashMap = new HashMap();
    paramString = a(paramString);
    if (!a(paramString)) {
      return;
    }
    localHashMap.put("url", paramString);
    localHashMap.put("source_activity", paramIntent.getStringExtra("SourceActivityName"));
    long l1 = B;
    long l2 = this.F;
    boolean bool2 = true;
    if (l1 > l2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramIntent = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
    while (paramIntent.hasNext())
    {
      paramString = (String)paramIntent.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((Long)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).longValue() - this.F);
      localStringBuilder.append("");
      localHashMap.put(paramString, localStringBuilder.toString());
    }
    localHashMap.put("bounce_rate_state", this.jdField_g_of_type_JavaLangString);
    paramIntent = new StringBuilder();
    paramIntent.append("");
    paramIntent.append(bool1);
    localHashMap.put("is_cold_launch", paramIntent.toString());
    localHashMap.put("network_type", HttpUtil.getNetWorkTypeByStr());
    paramIntent = new StringBuilder();
    paramIntent.append(Build.MODEL);
    paramIntent.append(Build.VERSION.SDK_INT);
    localHashMap.put("system_os", paramIntent.toString());
    localHashMap.put("QQ_version", AppSetting.g());
    paramIntent = new StringBuilder();
    paramIntent.append(jdField_b_of_type_Boolean);
    paramIntent.append("");
    localHashMap.put("use_offline_package", paramIntent.toString());
    paramIntent = new StringBuilder();
    paramIntent.append(this.jdField_d_of_type_Boolean);
    paramIntent.append("");
    localHashMap.put("use_sonic", paramIntent.toString());
    paramIntent = new StringBuilder();
    paramIntent.append("");
    paramIntent.append(jdField_p_of_type_Boolean);
    localHashMap.put("use_pre_load", paramIntent.toString());
    paramIntent = new StringBuilder();
    boolean bool1 = bool2;
    if (E > this.F) {
      bool1 = false;
    }
    paramIntent.append(bool1);
    paramIntent.append("");
    localHashMap.put("is_x5_init", paramIntent.toString());
    paramIntent = new StringBuilder();
    paramIntent.append(this.jdField_e_of_type_Int);
    paramIntent.append("");
    localHashMap.put("core_type", paramIntent.toString());
    localHashMap.put("activity_create_final", String.valueOf(this.H - this.G));
    localHashMap.put("origin_url", this.jdField_d_of_type_JavaLangString);
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("");
      paramIntent.append(this.jdField_a_of_type_JavaUtilList.size());
      localHashMap.put("redirect_time", paramIntent.toString());
      localHashMap.put("first_url", this.jdField_a_of_type_JavaUtilList.get(0));
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
    if (!jdField_u_of_type_Boolean) {
      return;
    }
    HashMap localHashMap = new HashMap();
    paramString = a(paramString);
    if (!a(paramString)) {
      return;
    }
    localHashMap.put("url", paramString);
    localHashMap.put("source_activity", this.jdField_b_of_type_JavaLangString);
    localHashMap.put("process_start_spending_time", String.valueOf(this.I));
    localHashMap.put("init_tbs_time", String.valueOf(this.jdField_z_of_type_Long));
    localHashMap.put("init_x5_core_time", String.valueOf(this.jdField_w_of_type_Long));
    localHashMap.put("init_x5_webview_time", String.valueOf(this.jdField_x_of_type_Long));
    localHashMap.put("init_tbs_so_time", String.valueOf(this.jdField_y_of_type_Long));
    localHashMap.put("init_all_time", String.valueOf(this.A));
    localHashMap.put("activity_on_create_time", String.valueOf(this.G - this.F));
    paramString = new StringBuilder();
    paramString.append("");
    paramString.append(this.jdField_c_of_type_Boolean);
    localHashMap.put("is_cold_launch", paramString.toString());
    localHashMap.put("network_type", this.jdField_e_of_type_JavaLangString);
    paramString = new StringBuilder();
    paramString.append(Build.MODEL);
    paramString.append(Build.VERSION.SDK_INT);
    localHashMap.put("system_os", paramString.toString());
    localHashMap.put("QQ_version", AppSetting.g());
    paramString = new StringBuilder();
    paramString.append(jdField_b_of_type_Boolean);
    paramString.append("");
    localHashMap.put("use_offline_package", paramString.toString());
    paramString = new StringBuilder();
    paramString.append(this.jdField_d_of_type_Boolean);
    paramString.append("");
    localHashMap.put("use_sonic", paramString.toString());
    paramString = new StringBuilder();
    paramString.append("");
    paramString.append(jdField_p_of_type_Boolean);
    localHashMap.put("use_pre_load", paramString.toString());
    paramString = new StringBuilder();
    boolean bool;
    if (E > this.F) {
      bool = false;
    } else {
      bool = true;
    }
    paramString.append(bool);
    paramString.append("");
    localHashMap.put("is_x5_init", paramString.toString());
    localHashMap.put("webview_create_time", String.valueOf(this.J));
    localHashMap.put("core_type", String.valueOf(this.jdField_e_of_type_Int));
    localHashMap.put("fragment_create_final", String.valueOf(this.H - this.G));
    localHashMap.put("browser_act_create_cost", String.valueOf(this.H - C));
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append(this.jdField_a_of_type_JavaUtilList.size());
      localHashMap.put("redirect_time", paramString.toString());
      localHashMap.put("first_url", this.jdField_a_of_type_JavaUtilList.get(0));
    }
    localHashMap.put("int_tbs_env", String.valueOf(SwiftWebAccelerator.TbsAccelerator.jdField_a_of_type_Long));
    localHashMap.put("init_plugin", String.valueOf(D));
    localHashMap.put("fragment_create_time", String.valueOf(this.G - C));
    localHashMap.put("step_initUIFrame", String.valueOf(this.K));
    localHashMap.put("step_initUIContent", String.valueOf(this.M));
    localHashMap.put("step_initTitleBar", String.valueOf(this.L));
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
      if (!this.jdField_g_of_type_JavaLangString.equals("state_final")) {
        this.jdField_b_of_type_JavaUtilHashMap.put("state_back", Long.valueOf(SystemClock.elapsedRealtime()));
      }
      return;
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray.size() == 0)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(0, "state_activity_init");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(1, "state_activity_create");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(2, "state_webview_create");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(3, "state_load_url");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(4, "state_activity_first_line");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(5, "state_first_screen");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(6, "state_page_finished");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(7, "state_final");
    }
    int i1 = this.jdField_a_of_type_AndroidUtilSparseArray.indexOfValue(paramString);
    int i2 = this.jdField_a_of_type_AndroidUtilSparseArray.indexOfValue(this.jdField_g_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setBounceRateState state=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" mCurr=");
      localStringBuilder.append(this.jdField_g_of_type_JavaLangString);
      QLog.d("SwiftBrowserStatistics", 4, localStringBuilder.toString());
    }
    if (i1 > i2)
    {
      this.jdField_g_of_type_JavaLangString = paramString;
      this.jdField_b_of_type_JavaUtilHashMap.put(this.jdField_g_of_type_JavaLangString, Long.valueOf(SystemClock.elapsedRealtime()));
    }
  }
  
  public void d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (this.jdField_l_of_type_Boolean)
      {
        String str = paramString.getQueryParameter("appid");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((int)((System.nanoTime() - this.jdField_i_of_type_Long) / 1000000L));
        localStringBuilder.append("");
        ReportController.b(null, "P_CliOper", "Grp_open", "", "time", "wide_time", 0, 1, 0, "", str, localStringBuilder.toString(), paramString.getQueryParameter("group_openid"));
      }
    }
    if (QLog.isDevelopLevel())
    {
      paramString = new StringBuilder();
      paramString.append("web_stay_in_url, cost = ");
      paramString.append((System.nanoTime() - this.jdField_i_of_type_Long) / 1000000L);
      paramString.append(", url = ");
      paramString.append(Util.b(this.jdField_c_of_type_JavaLangString, new String[0]));
      paramString.append(", isFromLeba = ");
      paramString.append(this.jdField_e_of_type_Boolean);
      paramString.append(", hasRedDot = ");
      paramString.append(this.jdField_f_of_type_Boolean);
      QLog.d("web_report", 4, paramString.toString());
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorISwiftBrowserStatisticInjector;
    if (paramString != null) {
      paramString.a(this.j, this.jdField_c_of_type_JavaLangString);
    }
  }
  
  public void e(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shouldOverrideUrlLoading detect 302, url: ");
    localStringBuilder.append(paramString);
    QLog.i("SwiftBrowserStatistics", 1, localStringBuilder.toString());
    this.jdField_u_of_type_Long = System.currentTimeMillis();
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList.add(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics
 * JD-Core Version:    0.7.0.1
 */