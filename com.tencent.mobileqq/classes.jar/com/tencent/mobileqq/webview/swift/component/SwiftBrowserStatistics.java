package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.managers.PushNoticeManager;
import com.tencent.mobileqq.notification.modularize.PushUtil;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.PushReportController;
import com.tencent.mobileqq.statistics.PushReportController.PushReportItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.TbsAccelerator;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class SwiftBrowserStatistics
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
{
  public static long B;
  public static long C;
  public static long D;
  public static long E;
  public static long V;
  public static long W;
  public static long X;
  public static long Y;
  public static long Z;
  public static HashMap<String, SwiftBrowserStatistics.AntiPasswdUsage> a;
  public static long aa;
  public static long ab;
  public static boolean b;
  public static int d;
  public static volatile boolean r;
  public static volatile boolean s;
  public static volatile boolean t;
  public static boolean x;
  public static boolean y;
  public static boolean z;
  public long A;
  public boolean A;
  public boolean B;
  public boolean C;
  private boolean D;
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
  private int f;
  public long f;
  public String f;
  public boolean f;
  private int g;
  public long g;
  public String g;
  public boolean g;
  private int jdField_h_of_type_Int;
  public long h;
  private String jdField_h_of_type_JavaLangString = "state_activity_init";
  public boolean h;
  public long i;
  private String i;
  public boolean i;
  public long j;
  private String j;
  public boolean j;
  public long k;
  private String k;
  public boolean k;
  public long l;
  public boolean l;
  public long m;
  public boolean m;
  public long n;
  public boolean n;
  public long o;
  public boolean o;
  public long p;
  boolean p;
  public long q;
  public boolean q;
  public long r;
  public long s;
  public long t;
  public long u;
  public boolean u;
  public long v;
  public boolean v;
  public long w;
  public boolean w;
  public long x;
  public long y;
  public long z;
  
  static
  {
    jdField_B_of_type_Long = 0L;
    jdField_C_of_type_Long = 0L;
    jdField_D_of_type_Long = 0L;
    jdField_b_of_type_Boolean = false;
    E = 0L;
    V = 0L;
    W = 0L;
    X = 0L;
    Y = 0L;
    Z = 0L;
    aa = 0L;
    ab = 0L;
    jdField_r_of_type_Boolean = false;
    jdField_s_of_type_Boolean = false;
    jdField_t_of_type_Boolean = false;
    jdField_d_of_type_Int = 10;
    jdField_x_of_type_Boolean = SwiftBrowserStatisticsConfigUtils.b(1, false);
    jdField_y_of_type_Boolean = SwiftBrowserStatisticsConfigUtils.b(2, false);
    jdField_z_of_type_Boolean = SwiftBrowserStatisticsConfigUtils.b(4, false);
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public SwiftBrowserStatistics()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_k_of_type_Long = 0L;
    this.jdField_l_of_type_Long = 0L;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_n_of_type_Long = 0L;
    this.jdField_o_of_type_Long = 0L;
    this.jdField_p_of_type_Long = 0L;
    this.jdField_q_of_type_Long = 0L;
    this.jdField_r_of_type_Long = -1L;
    this.jdField_s_of_type_Long = 0L;
    this.jdField_t_of_type_Long = 0L;
    this.jdField_u_of_type_Long = -1L;
    this.jdField_v_of_type_Long = 0L;
    this.jdField_w_of_type_Long = 0L;
    this.jdField_x_of_type_Long = 0L;
    this.jdField_y_of_type_Long = 0L;
    this.jdField_z_of_type_Long = 0L;
    this.jdField_A_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap(7);
    this.jdField_a_of_type_Int = -1;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 0;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = true;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 0;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_u_of_type_Boolean = false;
    this.jdField_v_of_type_Boolean = false;
    this.jdField_w_of_type_Boolean = false;
    this.jdField_a_of_type_OrgJsonJSONObject = null;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_e_of_type_Int = 0;
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_A_of_type_Boolean = false;
    this.jdField_B_of_type_Boolean = false;
    this.jdField_C_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry = new SwiftBrowserStatistics.CrashStepStatsEntry();
  }
  
  /* Error */
  public static Bundle a(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 289	android/os/Bundle
    //   6: dup
    //   7: invokespecial 290	android/os/Bundle:<init>	()V
    //   10: astore 4
    //   12: aload_0
    //   13: invokestatic 296	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: istore_3
    //   17: iload_3
    //   18: ifeq +9 -> 27
    //   21: ldc 2
    //   23: monitorexit
    //   24: aload 4
    //   26: areturn
    //   27: getstatic 126	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   30: aload_0
    //   31: invokevirtual 300	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   34: ifeq +159 -> 193
    //   37: getstatic 126	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   40: aload_0
    //   41: invokevirtual 304	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 306	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$AntiPasswdUsage
    //   47: astore_0
    //   48: aload_0
    //   49: getfield 308	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$AntiPasswdUsage:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   52: ifnull +65 -> 117
    //   55: aload_0
    //   56: getfield 308	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$AntiPasswdUsage:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   59: ldc_w 310
    //   62: invokevirtual 316	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   65: astore 5
    //   67: new 266	java/util/ArrayList
    //   70: dup
    //   71: aload 5
    //   73: arraylength
    //   74: invokespecial 317	java/util/ArrayList:<init>	(I)V
    //   77: astore 6
    //   79: aload 5
    //   81: arraylength
    //   82: istore_2
    //   83: iconst_0
    //   84: istore_1
    //   85: iload_1
    //   86: iload_2
    //   87: if_icmpge +20 -> 107
    //   90: aload 6
    //   92: aload 5
    //   94: iload_1
    //   95: aaload
    //   96: invokevirtual 320	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   99: pop
    //   100: iload_1
    //   101: iconst_1
    //   102: iadd
    //   103: istore_1
    //   104: goto -19 -> 85
    //   107: aload 4
    //   109: ldc_w 322
    //   112: aload 6
    //   114: invokevirtual 326	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   117: aload_0
    //   118: getfield 328	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$AntiPasswdUsage:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   121: invokestatic 296	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   124: ifeq +15 -> 139
    //   127: aload 4
    //   129: ldc_w 330
    //   132: aload_0
    //   133: getfield 328	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$AntiPasswdUsage:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   136: invokevirtual 334	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_0
    //   140: getfield 335	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$AntiPasswdUsage:jdField_b_of_type_Boolean	Z
    //   143: ifeq +53 -> 196
    //   146: iconst_1
    //   147: istore_1
    //   148: aload 4
    //   150: ldc_w 337
    //   153: iload_1
    //   154: invokevirtual 341	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   157: aload_0
    //   158: getfield 342	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$AntiPasswdUsage:jdField_a_of_type_Boolean	Z
    //   161: ifeq +40 -> 201
    //   164: iconst_1
    //   165: istore_1
    //   166: aload 4
    //   168: ldc_w 344
    //   171: iload_1
    //   172: invokevirtual 341	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   175: aload_0
    //   176: getfield 345	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$AntiPasswdUsage:jdField_c_of_type_Boolean	Z
    //   179: ifeq +27 -> 206
    //   182: iconst_1
    //   183: istore_1
    //   184: aload 4
    //   186: ldc_w 347
    //   189: iload_1
    //   190: invokevirtual 341	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   193: goto -172 -> 21
    //   196: iconst_0
    //   197: istore_1
    //   198: goto -50 -> 148
    //   201: iconst_0
    //   202: istore_1
    //   203: goto -37 -> 166
    //   206: iconst_0
    //   207: istore_1
    //   208: goto -24 -> 184
    //   211: astore_0
    //   212: ldc_w 349
    //   215: iconst_1
    //   216: aload_0
    //   217: iconst_0
    //   218: anewarray 351	java/lang/Object
    //   221: invokestatic 356	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   224: goto -31 -> 193
    //   227: astore_0
    //   228: ldc 2
    //   230: monitorexit
    //   231: aload_0
    //   232: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	paramString	String
    //   84	124	1	i1	int
    //   82	6	2	i2	int
    //   16	2	3	bool	boolean
    //   10	175	4	localBundle	Bundle
    //   65	28	5	arrayOfString	String[]
    //   77	36	6	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   12	17	211	java/lang/Throwable
    //   27	83	211	java/lang/Throwable
    //   90	100	211	java/lang/Throwable
    //   107	117	211	java/lang/Throwable
    //   117	139	211	java/lang/Throwable
    //   139	146	211	java/lang/Throwable
    //   148	164	211	java/lang/Throwable
    //   166	182	211	java/lang/Throwable
    //   184	193	211	java/lang/Throwable
    //   3	12	227	finally
    //   12	17	227	finally
    //   27	83	227	finally
    //   90	100	227	finally
    //   107	117	227	finally
    //   117	139	227	finally
    //   139	146	227	finally
    //   148	164	227	finally
    //   166	182	227	finally
    //   184	193	227	finally
    //   212	224	227	finally
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
      i1 = i2;
      if (i2 == -1) {
        i1 = paramString.length();
      }
    }
    while (i1 == 0)
    {
      return "null";
      if (i2 != -1) {
        i1 = Math.min(i1, i2);
      }
    }
    return paramString.substring(0, i1);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    String str = SwiftWebViewUtils.a(paramString1);
    if (("http".equals(str)) || ("https".equals(str))) {
      break label28;
    }
    label28:
    while (!jdField_z_of_type_Boolean) {
      return;
    }
    if (paramString2 == null)
    {
      localObject = null;
      label41:
      if (localObject != null) {
        break label133;
      }
      paramString2 = "";
      label48:
      if (localObject != null) {
        break label141;
      }
    }
    label133:
    label141:
    for (Object localObject = "";; localObject = ((Uri)localObject).getPath())
    {
      ReportController.b(null, "dc00899", "WV_Analysis", "", "scheme_call", "total", paramInt, 0, paramString2, (String)localObject, str, SwiftWebViewUtils.c(paramString1));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SwiftBrowserStatistics", 2, new Object[] { "reportScheme ", str, " method:", SwiftWebViewUtils.c(paramString1) });
      return;
      localObject = Uri.parse(paramString2);
      break label41;
      paramString2 = ((Uri)localObject).getHost();
      break label48;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      TroopMemberApiClient localTroopMemberApiClient = TroopMemberApiClient.a();
      localTroopMemberApiClient.a();
      Bundle localBundle = a(paramString2);
      localBundle.putString("uin", paramString4);
      if (!TextUtils.isEmpty(paramString3)) {
        localBundle.putString("title", paramString3);
      }
      localTroopMemberApiClient.a(2, paramString2, paramString1, localBundle);
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("SwiftBrowserStatistics", 1, paramString1, new Object[0]);
    }
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic 296	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +23 -> 30
    //   10: invokestatic 411	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +17 -> 30
    //   16: ldc_w 349
    //   19: iconst_2
    //   20: ldc_w 451
    //   23: invokestatic 454	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: ldc 2
    //   28: monitorexit
    //   29: return
    //   30: getstatic 126	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   33: aload_1
    //   34: invokevirtual 300	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   37: ifne +18 -> 55
    //   40: getstatic 126	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   43: aload_1
    //   44: new 306	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$AntiPasswdUsage
    //   47: dup
    //   48: invokespecial 455	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$AntiPasswdUsage:<init>	()V
    //   51: invokevirtual 459	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: getstatic 126	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   58: aload_1
    //   59: invokevirtual 304	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   62: checkcast 306	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$AntiPasswdUsage
    //   65: astore 7
    //   67: aload 7
    //   69: aload_1
    //   70: putfield 460	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$AntiPasswdUsage:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   73: aload_0
    //   74: invokestatic 296	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   77: ifne +9 -> 86
    //   80: aload 7
    //   82: aload_0
    //   83: putfield 462	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$AntiPasswdUsage:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   86: aload_2
    //   87: invokestatic 296	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   90: ifne +9 -> 99
    //   93: aload 7
    //   95: aload_2
    //   96: putfield 308	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$AntiPasswdUsage:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   99: aload_3
    //   100: invokestatic 296	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   103: ifne +9 -> 112
    //   106: aload 7
    //   108: aload_3
    //   109: putfield 328	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$AntiPasswdUsage:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   112: iload 4
    //   114: ifeq +10 -> 124
    //   117: aload 7
    //   119: iload 4
    //   121: putfield 342	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$AntiPasswdUsage:jdField_a_of_type_Boolean	Z
    //   124: iload 5
    //   126: ifeq +10 -> 136
    //   129: aload 7
    //   131: iload 5
    //   133: putfield 335	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$AntiPasswdUsage:jdField_b_of_type_Boolean	Z
    //   136: aload 7
    //   138: iload 6
    //   140: putfield 345	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$AntiPasswdUsage:jdField_c_of_type_Boolean	Z
    //   143: getstatic 126	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   146: aload_1
    //   147: aload 7
    //   149: invokevirtual 459	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   152: pop
    //   153: goto -127 -> 26
    //   156: astore_0
    //   157: ldc 2
    //   159: monitorexit
    //   160: aload_0
    //   161: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramString1	String
    //   0	162	1	paramString2	String
    //   0	162	2	paramString3	String
    //   0	162	3	paramString4	String
    //   0	162	4	paramBoolean1	boolean
    //   0	162	5	paramBoolean2	boolean
    //   0	162	6	paramBoolean3	boolean
    //   65	83	7	localAntiPasswdUsage	SwiftBrowserStatistics.AntiPasswdUsage
    // Exception table:
    //   from	to	target	type
    //   3	26	156	finally
    //   30	55	156	finally
    //   55	86	156	finally
    //   86	99	156	finally
    //   99	112	156	finally
    //   117	124	156	finally
    //   129	136	156	finally
    //   136	153	156	finally
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = true;
    String str = SwiftWebViewUtils.a(paramString);
    boolean bool1;
    if ((!"null".equals(paramString)) && (paramString.length() <= 1024))
    {
      bool1 = bool2;
      if (!"http".equals(str))
      {
        bool1 = bool2;
        if ("https".equals(str)) {}
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 2, new Object[] { "not report url:", paramString });
      }
      bool1 = false;
    }
    return bool1;
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
            if (localAntiPasswdUsage.jdField_a_of_type_Boolean)
            {
              localObject = "1";
              localHashMap.put("passwdTyped", localObject);
              if (!localAntiPasswdUsage.jdField_b_of_type_Boolean) {
                break label204;
              }
              localObject = "1";
              localHashMap.put("showPasswd", localObject);
              StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "wvAntiPasswd", true, 0L, 0L, localHashMap, "");
            }
          }
          else
          {
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("SwiftBrowserStatistics", 2, localThrowable, new Object[0]);
      }
      do
      {
        str = "0";
        break;
      } while (!QLog.isColorLevel());
      QLog.d("SwiftBrowserStatistics", 2, "nothing to report");
      return;
      label204:
      String str = "0";
    }
  }
  
  private void d()
  {
    if (!PushReportController.jdField_a_of_type_Boolean)
    {
      PushReportController.PushReportItem localPushReportItem = new PushReportController.PushReportItem();
      localPushReportItem.jdField_e_of_type_JavaLangString = "0X8009242";
      localPushReportItem.jdField_d_of_type_JavaLangString = "离开点击Push";
      PushReportController.a(this.jdField_d_of_type_JavaLangString, localPushReportItem);
      PushReportController.a(null, localPushReportItem);
      PushReportController.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void e()
  {
    if (!PushReportController.jdField_a_of_type_Boolean) {
      PushNoticeManager.a(null, this.jdField_i_of_type_JavaLangString, this.jdField_j_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, "0X8009242", "离开点击Push");
    }
  }
  
  public BusinessInfoCheckUpdate.TimeRspBody a(AppInterface paramAppInterface)
  {
    if ((paramAppInterface == null) || (paramAppInterface.getApplication() == null)) {}
    for (;;)
    {
      return null;
      Object localObject = paramAppInterface.getApplication().getFilesDir();
      paramAppInterface = paramAppInterface.getCurrentAccountUin();
      paramAppInterface = new File((File)localObject, "BusinessInfoCheckUpdateItem_new_1_" + paramAppInterface);
      if (!paramAppInterface.exists()) {}
      try
      {
        paramAppInterface.createNewFile();
        paramAppInterface = FileUtils.a(paramAppInterface);
        if (paramAppInterface != null) {
          localObject = new BusinessInfoCheckUpdate.TimeRspBody();
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          try
          {
            ((BusinessInfoCheckUpdate.TimeRspBody)localObject).mergeFrom(paramAppInterface);
            return localObject;
          }
          catch (Exception paramAppInterface)
          {
            paramAppInterface.printStackTrace();
          }
          localIOException = localIOException;
          localIOException.printStackTrace();
        }
      }
    }
    return null;
  }
  
  String a(boolean paramBoolean, AppRuntime paramAppRuntime)
  {
    if (!paramBoolean) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramAppRuntime instanceof AppInterface)) {}
    for (paramAppRuntime = (AppInterface)paramAppRuntime;; paramAppRuntime = null)
    {
      if (paramAppRuntime == null) {
        return "";
      }
      String str = paramAppRuntime.getApp().getSharedPreferences("redTouchPref", 4).getString("lastClickPath", "");
      if (!"".equals(str))
      {
        paramAppRuntime = a(paramAppRuntime);
        if (paramAppRuntime == null) {
          break label212;
        }
        paramAppRuntime = paramAppRuntime.rptMsgAppInfo.get();
        if (paramAppRuntime == null) {
          break label212;
        }
        Iterator localIterator = paramAppRuntime.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          paramAppRuntime = (BusinessInfoCheckUpdate.AppInfo)localIterator.next();
        } while (!paramAppRuntime.path.get().equals(str));
      }
      for (;;)
      {
        if (paramAppRuntime != null)
        {
          paramAppRuntime = paramAppRuntime.missions.get();
          if (paramAppRuntime != null)
          {
            int i1 = 0;
            while (i1 < paramAppRuntime.size())
            {
              localStringBuilder.append((String)paramAppRuntime.get(i1));
              if (i1 != paramAppRuntime.size() - 1) {
                localStringBuilder.append("_");
              }
              i1 += 1;
            }
          }
        }
        return localStringBuilder.toString();
        label212:
        paramAppRuntime = null;
      }
    }
  }
  
  public void a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + localAppRuntime.getLongAccountUin(), 4);
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_d_of_type_Long;
      ReportController.b(null, "dc00899", "grp_lbs", "", this.jdField_a_of_type_JavaLangString, "visit_time", 0, 1, 0, "" + localSharedPreferences.getInt("charm_level", 0), "" + localSharedPreferences.getInt("gender", 0), "" + (l1 - l2), "");
    }
    if (((this.jdField_g_of_type_Boolean) || (this.jdField_D_of_type_Boolean)) && (!this.jdField_k_of_type_Boolean) && (!PushReportController.jdField_a_of_type_Boolean)) {
      ThreadManager.getFileThreadHandler().postDelayed(new SwiftBrowserStatistics.2(this, localAppRuntime), 1000L);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    super.a(paramInt, paramBundle);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      label73:
      long l1;
      long l2;
      int i1;
      if (this.jdField_k_of_type_Long > 0L)
      {
        paramInt = (int)((this.jdField_i_of_type_Long - this.jdField_k_of_type_Long) / 1000000L);
        if (this.jdField_i_of_type_Boolean)
        {
          paramBundle = HttpUtil.getNetWorkType() + "";
          l1 = System.currentTimeMillis();
          l2 = this.jdField_l_of_type_Long;
          if (!((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isPreloadWebProcess()) {
            break label291;
          }
          i1 = 1;
          label132:
          if (!this.jdField_w_of_type_Boolean) {
            break label296;
          }
        }
      }
      label291:
      label296:
      for (int i2 = 1;; i2 = 0)
      {
        ReportController.b(null, "P_CliOper", "Vip_SummaryCard", "", "0X8004FFD", "0X8004FFD", 0, 1, 0, paramBundle, String.valueOf(l1 - l2), String.valueOf(i1), String.valueOf(i2));
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("web_report", 4, "web_before_create, cost = " + paramInt + ", url = " + Util.b(this.jdField_d_of_type_JavaLangString, new String[0]) + ", isFromLeba = " + this.jdField_e_of_type_Boolean + ", hasRedDot = " + this.jdField_f_of_type_Boolean + ", isProgressCreate = " + jdField_s_of_type_Boolean + ", flag=" + this.jdField_c_of_type_Int);
        return;
        paramInt = 0;
        break label73;
        i1 = 0;
        break label132;
      }
      if (QLog.isColorLevel()) {
        QLog.i("GOTOWEB", 2, "onQQBrowserResume() time = " + System.currentTimeMillis());
      }
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      return;
      a();
      return;
      if ((paramBundle != null) && (paramBundle.containsKey("url")))
      {
        d(paramBundle.getString("url"));
        return;
        if ((paramBundle != null) && (paramBundle.containsKey("url")))
        {
          a(paramBundle.getString("url"));
          return;
          if ((paramBundle != null) && (paramBundle.containsKey("url"))) {}
          for (paramBundle = paramBundle.getString("url"); !TextUtils.isEmpty(paramBundle); paramBundle = "")
          {
            a((TouchWebView)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a(), paramBundle);
            return;
          }
        }
      }
    }
  }
  
  void a(Context paramContext, SwiftBrowserStatistics.CrashStepStatsEntry paramCrashStepStatsEntry)
  {
    paramContext = new File(paramContext.getFilesDir(), ClubContentJsonTask.e.jdField_a_of_type_JavaLangString);
    if (!paramContext.exists()) {}
    do
    {
      do
      {
        return;
        paramContext = FileUtils.a(paramContext);
      } while (TextUtils.isEmpty(paramContext));
      try
      {
        paramContext = new JSONObject(paramContext);
        int i1 = paramContext.getInt("sample_rate");
        SwiftBrowserStatistics.CrashStepStatsEntry.jdField_a_of_type_JavaUtilHashMap.put("sample_rate", Integer.valueOf(i1));
        JSONArray localJSONArray = paramContext.getJSONArray("rules");
        int i2 = localJSONArray.length();
        i1 = 0;
        while (i1 < i2)
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i1);
          SwiftBrowserStatistics.CrashStepStatsEntry.jdField_a_of_type_JavaUtilHashMap.put(localJSONObject.getString("distUrl"), Integer.valueOf(localJSONObject.getInt("rate")));
          i1 += 1;
        }
        paramCrashStepStatsEntry.jdField_c_of_type_Int = paramContext.getInt("tail_number");
        return;
      }
      catch (Throwable paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.d("QQBrowser", 2, "" + paramContext);
  }
  
  public void a(Context paramContext, String paramString, Intent paramIntent)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_AndroidContentSharedPreferences = paramContext.getSharedPreferences("WebView_Report_Step", 0);
    }
    String str3 = "UNKNOWN";
    try
    {
      int i1 = NetworkUtil.a(paramContext);
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
        String str2 = "UNKNOWN";
      }
    }
    ThreadManager.post(new SwiftBrowserStatistics.4(this, paramString, paramIntent, paramContext, System.currentTimeMillis(), str1), 5, null, false);
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    this.jdField_i_of_type_Long = System.nanoTime();
    this.jdField_c_of_type_Long = paramIntent.getLongExtra("qqBrowserActivityCreateTime", -1L);
    if (this.jdField_c_of_type_Long <= 0L) {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
    }
    this.G = SystemClock.elapsedRealtime();
    QLog.e("SwiftBrowserStatistics", 1, "onCreate mOnCreateMilliTimeStamp = " + this.jdField_c_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
    this.jdField_b_of_type_Long = paramIntent.getLongExtra("startOpenPageTime", -1L);
    QLog.e("SwiftBrowserStatistics", 1, "onCreate mClickTime = " + this.jdField_b_of_type_Long);
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("op_type");
    this.jdField_p_of_type_Boolean = paramIntent.getBooleanExtra("reportMsfLog", false);
    this.jdField_n_of_type_Boolean = paramIntent.getBooleanExtra("fromAio", false);
    paramIntent.getBooleanExtra("fromPublicAccount", false);
    if (this.jdField_b_of_type_Long == -1L) {
      this.jdField_b_of_type_Long = this.jdField_c_of_type_Long;
    }
    GameCenterActivity.a(paramString, 1, false, false);
    this.jdField_k_of_type_Long = paramIntent.getLongExtra("plugin_start_time", 0L);
    this.jdField_l_of_type_Long = paramIntent.getLongExtra("click_start_time", 0L);
    this.jdField_q_of_type_Boolean = paramIntent.getBooleanExtra("FORCE_BLANK_SCREEN_REPORTE", false);
    if (this.jdField_k_of_type_Long > 0L) {
      paramIntent.putExtra("plugin_start_time", 0L);
    }
    if (this.jdField_l_of_type_Long > 0L) {
      paramIntent.putExtra("click_start_time", 0L);
    }
    this.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("is_from_leba", false);
    this.jdField_f_of_type_Boolean = paramIntent.getBooleanExtra("has_red_dot", false);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Boolean = this.jdField_f_of_type_Boolean;
    boolean bool;
    label354:
    int i1;
    label538:
    int i2;
    label548:
    int i3;
    label558:
    long l1;
    if (paramIntent.getIntExtra("uintype", -1) == 1030)
    {
      bool = true;
      this.jdField_g_of_type_Boolean = bool;
      if (paramIntent.getIntExtra("uintype", -1) != 1035) {
        break label952;
      }
      bool = true;
      this.jdField_D_of_type_Boolean = bool;
      this.jdField_i_of_type_JavaLangString = paramIntent.getStringExtra("push_notice_service_id");
      this.jdField_j_of_type_JavaLangString = paramIntent.getStringExtra("push_notice_content_id");
      this.jdField_f_of_type_Int = paramIntent.getIntExtra("KEY_MAIN_BUSINESS_ID", -1);
      this.jdField_g_of_type_Int = paramIntent.getIntExtra("KEY_SUB_BUSINESS_ID", 0);
      this.jdField_h_of_type_Int = paramIntent.getIntExtra("KEY_PUSH_ID", 0);
      this.jdField_k_of_type_JavaLangString = paramIntent.getStringExtra("KEY_PUSH_TRIGGER_INFO");
      PushUtil.a(this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, this.jdField_h_of_type_Int, this.jdField_k_of_type_JavaLangString);
      if ((this.jdField_g_of_type_Boolean) || (this.jdField_D_of_type_Boolean)) {
        PushReportController.jdField_a_of_type_Boolean = false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("GOTOWEB", 2, "onQQBrowserCreate() time = " + this.jdField_i_of_type_Long);
      }
      if (WebAccelerateHelper.isWebViewCache)
      {
        this.jdField_w_of_type_Boolean = true;
        QLog.d("SwiftBrowserStatistics", 1, "onCreate, isWebViewCache = true");
      }
      this.N = System.currentTimeMillis();
      if (!jdField_s_of_type_Boolean) {
        break label958;
      }
      i1 = 1;
      if (!this.jdField_e_of_type_Boolean) {
        break label963;
      }
      i2 = 1;
      if (!this.jdField_f_of_type_Boolean) {
        break label969;
      }
      i3 = 1;
      this.jdField_c_of_type_Int = (i3 + ((i1 << 2) + (i2 << 1)));
      this.jdField_e_of_type_JavaLangString = a(paramString);
      this.jdField_f_of_type_JavaLangString = HttpUtil.getNetWorkTypeByStr();
      if (jdField_x_of_type_Boolean)
      {
        if (this.jdField_l_of_type_Long <= 0L) {
          break label975;
        }
        l1 = this.jdField_c_of_type_Long - this.jdField_l_of_type_Long;
        label614:
        a("process_init", l1, "0");
      }
      this.F = paramIntent.getLongExtra("StartClickTime", 0L);
      paramIntent.removeExtra("StartClickTime");
      if ((this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_AndroidAppActivity.getIntent() != null)) {
        this.jdField_a_of_type_AndroidAppActivity.getIntent().removeExtra("StartClickTime");
      }
      this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("SourceActivityName");
      if (this.F <= 0L)
      {
        this.F = this.G;
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserStatistics", 4, "reportTime mClickUrlMilliTime=" + this.F);
        }
        a(paramString, "ClickTime", this.F + "");
      }
      if (this.G - this.F > 10000L) {
        a(paramString, "CreateActivity", this.G - this.F + "");
      }
      if (jdField_B_of_type_Long <= this.F) {
        break label981;
      }
      bool = true;
      label834:
      this.jdField_c_of_type_Boolean = bool;
      if (!this.jdField_c_of_type_Boolean) {
        break label987;
      }
    }
    label952:
    label958:
    label963:
    label969:
    label975:
    label981:
    label987:
    for (this.I = (jdField_B_of_type_Long - this.F);; this.I = 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 2, new Object[] { "mClickUrlMilliTime: ", Long.valueOf(this.F), " mSourceActivityClassName:", this.jdField_c_of_type_JavaLangString, " mProcessLaunchMilliTime:", Long.valueOf(jdField_B_of_type_Long), " mIsColdLaunch:", Boolean.valueOf(this.jdField_c_of_type_Boolean) });
      }
      jdField_a_of_type_JavaUtilHashMap.clear();
      return;
      bool = false;
      break;
      bool = false;
      break label354;
      i1 = 0;
      break label538;
      i2 = 0;
      break label548;
      i3 = 0;
      break label558;
      l1 = 0L;
      break label614;
      bool = false;
      break label834;
    }
  }
  
  public void a(TouchWebView paramTouchWebView, int paramInt, String paramString1, String paramString2)
  {
    Object localObject = paramTouchWebView.getPluginEngine();
    if (localObject != null)
    {
      localObject = ((WebViewPluginEngine)localObject).a("offline");
      if ((localObject == null) || (!(localObject instanceof OfflinePlugin))) {}
    }
    for (localObject = (OfflinePlugin)localObject;; localObject = null)
    {
      if ((localObject != null) && (((OfflinePlugin)localObject).a() != null)) {}
      for (localObject = ((OfflinePlugin)localObject).a();; localObject = "")
      {
        int i1;
        int i2;
        label74:
        String str2;
        if (paramTouchWebView.getX5WebViewExtension() != null)
        {
          i1 = 3;
          i2 = 0;
          if (i2 >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label250;
          }
          str2 = (String)this.jdField_a_of_type_JavaUtilList.get(i2);
          if (i2 != this.jdField_a_of_type_JavaUtilList.size() - 1) {
            break label235;
          }
          paramTouchWebView = String.valueOf(paramInt);
          label125:
          if (str2 == null) {
            break label242;
          }
        }
        label235:
        label242:
        for (String str1 = str2;; str1 = "unknown")
        {
          VasWebviewUtil.reportQBWebInfo((String)localObject, "qbweb_load_redirect", "", str1.replace("|", "%7C"), i1, 0, "0", String.valueOf(this.jdField_c_of_type_Int), HttpUtil.getNetWorkTypeByStr(), 0, 0, "", paramTouchWebView);
          if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserStatistics", 2, "url=" + str2 + ", rlt=" + paramTouchWebView);
          }
          i2 += 1;
          break label74;
          i1 = 1;
          break;
          paramTouchWebView = "10001";
          break label125;
        }
        label250:
        this.jdField_a_of_type_JavaUtilList.clear();
        if (TenDocLogReportHelper.a(paramString2)) {
          TenDocLogReportHelper.a(null, TenDocLogReportHelper.c(paramString2), "0X8009E9F", "fail", TenDocLogReportHelper.d(paramString2), "err=" + paramInt);
        }
        TenDocLogReportHelper.b(paramString2, "SwiftBrowserStatistics", "web_loaded_url_err", "errorCode = " + paramInt + " description = " + paramString1);
        TenDocLogReportHelper.b(paramString2, "SwiftBrowserStatistics", "failingUrl", paramString2);
        TenDocLogReportHelper.b(paramString2, "SwiftBrowserStatistics", "cookie");
        return;
      }
    }
  }
  
  public void a(TouchWebView paramTouchWebView, String paramString)
  {
    if (paramTouchWebView == null) {
      return;
    }
    Object localObject1 = paramTouchWebView.getPluginEngine();
    if (localObject1 != null)
    {
      localObject1 = ((WebViewPluginEngine)localObject1).a("offline");
      if ((localObject1 == null) || (!(localObject1 instanceof OfflinePlugin))) {}
    }
    for (localObject1 = (OfflinePlugin)localObject1;; localObject1 = null)
    {
      if ((localObject1 != null) && (((OfflinePlugin)localObject1).a() != null)) {}
      for (localObject1 = ((OfflinePlugin)localObject1).a();; localObject1 = "")
      {
        long l1;
        try
        {
          if ((this.jdField_d_of_type_JavaLangString.startsWith("http://")) || (paramString.startsWith("http://")))
          {
            localObject2 = new HashMap(2);
            ((HashMap)localObject2).put("url", paramString);
            ((HashMap)localObject2).put("first_url", this.jdField_d_of_type_JavaLangString);
            if ((this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_AndroidAppActivity.getIntent() != null))
            {
              localObject3 = this.jdField_a_of_type_AndroidAppActivity.getIntent();
              i1 = ((Intent)localObject3).getIntExtra("articalChannelId", 100);
              boolean bool = ((Intent)localObject3).getBooleanExtra("fromAio", false);
              localObject3 = ((Intent)localObject3).getStringExtra("SourceActivityName");
              ((HashMap)localObject2).put("fromChannel", String.valueOf(i1));
              ((HashMap)localObject2).put("fromAIO", String.valueOf(bool));
              ((HashMap)localObject2).put("fromAct", localObject3);
            }
            StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "actWVHttpReport", true, 0L, 0L, (HashMap)localObject2, "");
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Object localObject2;
            Object localObject3;
            QLog.e("SwiftBrowserStatistics", 1, localThrowable, new Object[0]);
            continue;
            int i1 = 0;
            continue;
            int i2 = 0;
            continue;
            i1 = 1;
            continue;
            paramTouchWebView = "unknown";
          }
          this.jdField_a_of_type_JavaUtilList.clear();
          if ((!this.jdField_j_of_type_Boolean) || (!this.jdField_n_of_type_Boolean) || (this.jdField_o_of_type_Boolean)) {
            break label792;
          }
          this.jdField_o_of_type_Boolean = true;
          if (paramString == null) {
            break label880;
          }
          paramTouchWebView = paramString;
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "msg_webview_url", "msg_webview_pvqq", 0, 1, 0, Util.b(URLEncoder.encode(paramTouchWebView), new String[0]), "", "", "" + this.jdField_c_of_type_Int);
        }
        if ((this.jdField_i_of_type_Boolean) && (this.jdField_k_of_type_Boolean) && (!this.jdField_l_of_type_Boolean))
        {
          localObject2 = HttpUtil.getNetWorkType() + "";
          l1 = (System.nanoTime() - this.jdField_j_of_type_Long) / 1000000L;
          if (!((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isPreloadWebProcess()) {
            break label670;
          }
          i1 = 1;
          localObject3 = new StringBuilder();
          if (!this.jdField_w_of_type_Boolean) {
            break label675;
          }
          i2 = 1;
          ReportController.b(null, "P_CliOper", "Vip_SummaryCard", "", "0X8004FFE", "0X8004FFE", 0, 1, 0, (String)localObject2, String.valueOf(l1), String.valueOf(i1), String.valueOf(i2) + ", " + (String)localObject1);
          if (QLog.isDevelopLevel()) {
            QLog.d("web_report", 4, "web_load_url, cost = " + (System.nanoTime() - this.jdField_j_of_type_Long) / 1000000L + ", url = " + Util.b(this.jdField_d_of_type_JavaLangString, new String[0]) + ", isFromLeba = " + this.jdField_e_of_type_Boolean + ", hasRedDot = " + this.jdField_f_of_type_Boolean + ", " + (String)localObject1);
          }
        }
        if ((this.jdField_k_of_type_Boolean) && (!this.jdField_l_of_type_Boolean))
        {
          b(paramString);
          if (paramTouchWebView.getX5WebViewExtension() != null)
          {
            i1 = 3;
            localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
            for (;;)
            {
              if (!((Iterator)localObject3).hasNext()) {
                break label693;
              }
              localObject2 = (String)((Iterator)localObject3).next();
              if (localObject2 == null) {
                break;
              }
              paramTouchWebView = (TouchWebView)localObject2;
              VasWebviewUtil.reportQBWebInfo((String)localObject1, "qbweb_load_redirect", "", paramTouchWebView.replace("|", "%7C"), i1, 0, "0", String.valueOf(this.jdField_c_of_type_Int), HttpUtil.getNetWorkTypeByStr(), 0, 0, "", "10000");
              if (QLog.isColorLevel()) {
                QLog.d("SwiftBrowserStatistics", 2, "url=" + (String)localObject2 + ", rlt=" + "10000");
              }
            }
          }
        }
        label670:
        label675:
        label693:
        while (TenDocLogReportHelper.a(paramString))
        {
          l1 = TenDocLogReportHelper.a(String.valueOf(this.jdField_j_of_type_Long));
          paramTouchWebView = TenDocLogReportHelper.d(paramString);
          paramString = TenDocLogReportHelper.c(paramString);
          if (l1 != 0L)
          {
            TenDocLogReportHelper.a(null, paramString, "0X8009E9F", "success", paramTouchWebView, "");
            TenDocLogReportHelper.a(null, paramString, "0X8009E9E", String.valueOf(l1), paramTouchWebView, "");
          }
          if (!TextUtils.isEmpty(paramString)) {
            break label887;
          }
          TenDocLogReportHelper.a("SwiftBrowserStatistics", "url_load_time", String.valueOf(l1));
          return;
          label880:
          paramTouchWebView = "unknown";
        }
        label792:
        break;
        label887:
        TenDocLogReportHelper.a("SwiftBrowserStatistics", "url_load_time", String.valueOf(l1), paramString);
        return;
      }
    }
  }
  
  public void a(TouchWebView paramTouchWebView, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String... paramVarArgs)
  {
    ThreadManager.post(new SwiftBrowserStatistics.5(this, paramTouchWebView, paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramVarArgs), 5, null, false);
  }
  
  public void a(String paramString)
  {
    if ("about:blank".equalsIgnoreCase(paramString)) {
      break label10;
    }
    label10:
    while (!this.jdField_j_of_type_Boolean) {
      return;
    }
    this.jdField_j_of_type_Long = System.nanoTime();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Long = System.currentTimeMillis();
    this.ac = (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Long - this.jdField_b_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser_report", 2, "try report web status, onPageStarted,  step: " + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Int + ", asyncMode: " + this.jdField_b_of_type_Int + ", stepTime: " + this.ac + ", totalTime: " + (System.currentTimeMillis() - this.jdField_b_of_type_Long) + "\n" + paramString);
    }
    int i3;
    String str1;
    String str2;
    int i1;
    if ((this.jdField_i_of_type_Boolean) && (!this.jdField_l_of_type_Boolean))
    {
      i3 = (int)((this.jdField_j_of_type_Long - this.jdField_i_of_type_Long) / 1000000L);
      str1 = HttpUtil.getNetWorkType() + "";
      str2 = "" + i3;
      if (!((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isPreloadWebProcess()) {
        break label460;
      }
      i1 = 1;
      label245:
      if (!this.jdField_w_of_type_Boolean) {
        break label465;
      }
    }
    label460:
    label465:
    for (int i2 = 1;; i2 = 0)
    {
      ReportController.b(null, "P_CliOper", "Vip_SummaryCard", "", "0X8004F62", "0X8004F62", 0, 1, 0, str1, str2, String.valueOf(i1), String.valueOf(i2));
      if (QLog.isDevelopLevel()) {
        QLog.d("web_report", 4, "web_before_load_url, cost = " + i3 + ", url = " + Util.b(this.jdField_d_of_type_JavaLangString, new String[0]) + ", isFromLeba = " + this.jdField_e_of_type_Boolean + ", hasRedDot = " + this.jdField_f_of_type_Boolean);
      }
      if (!this.jdField_l_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilList.add(paramString);
      }
      if ((this.jdField_p_of_type_Boolean) && (this.jdField_a_of_type_JavaLangRunnable == null))
      {
        this.jdField_a_of_type_JavaLangRunnable = new SwiftBrowserStatistics.1(this);
        ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      }
      this.jdField_h_of_type_Long = System.currentTimeMillis();
      if (!TenDocLogReportHelper.a(paramString)) {
        break;
      }
      TenDocLogReportHelper.a("SwiftBrowserStatistics", "onPageStarted_url", paramString);
      TenDocLogReportHelper.a(String.valueOf(this.jdField_j_of_type_Long));
      return;
      i1 = 0;
      break label245;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt == 0) {}
    while ((!this.jdField_i_of_type_Boolean) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    ThreadManager.post(new SwiftBrowserStatistics.3(this, paramString, paramInt, paramString, paramInt), 5, null, false);
  }
  
  public void a(String paramString1, long paramLong, String paramString2)
  {
    if ((TenDocLogReportHelper.a(this.jdField_d_of_type_JavaLangString)) && (TextUtils.equals(paramString1, "webview_init"))) {
      TenDocLogReportHelper.a(null, TenDocLogReportHelper.c(this.jdField_d_of_type_JavaLangString), "0X8009E9D", String.valueOf(paramLong), TenDocLogReportHelper.d(this.jdField_d_of_type_JavaLangString), "err=" + paramString2);
    }
    TenDocLogReportHelper.b(this.jdField_d_of_type_JavaLangString, "SwiftBrowserStatistics", paramString1, String.valueOf(paramLong));
    String str = this.jdField_e_of_type_JavaLangString;
    int i1;
    int i2;
    if (this.jdField_A_of_type_Boolean)
    {
      i1 = 1;
      if (!this.jdField_B_of_type_Boolean) {
        break label166;
      }
      i2 = 2;
      label107:
      if (!this.jdField_C_of_type_Boolean) {
        break label172;
      }
    }
    label166:
    label172:
    for (int i3 = 4;; i3 = 0)
    {
      ReportController.b(null, "dc00899", "WV_Analysis", "", paramString1, str, i2 | i1 | i3, (int)paramLong, String.valueOf(this.jdField_e_of_type_Int), this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, paramString2);
      return;
      i1 = 0;
      break;
      i2 = 0;
      break label107;
    }
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
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 4, "reportErrorScene: " + localHashMap);
      }
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "actWvReportError", true, 0L, 0L, localHashMap, "");
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("SwiftBrowserStatistics", 2, paramString1, new Object[0]);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
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
        this.jdField_A_of_type_Long = (l8 - l7);
        if (QLog.isColorLevel())
        {
          QLog.d("SwiftBrowserStatistics", 2, new Object[] { "performance: ", paramJSONObject.toString() });
          QLog.d("SwiftBrowserStatistics", 2, new Object[] { "firstInitTbs: ", Boolean.valueOf(bool), " x5core: ", Long.valueOf(this.jdField_w_of_type_Long), " webview: ", Long.valueOf(this.jdField_x_of_type_Long), " loadSo:", Long.valueOf(this.jdField_y_of_type_Long), " tbsLog:", Long.valueOf(this.jdField_z_of_type_Long), " initAll:", Long.valueOf(this.jdField_A_of_type_Long) });
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("SwiftBrowserStatistics", 1, new Object[] { "exception ", paramJSONObject.toString() });
      }
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
  }
  
  public void b(Intent paramIntent, String paramString)
  {
    if (!jdField_x_of_type_Boolean) {}
    HashMap localHashMap;
    do
    {
      return;
      localHashMap = new HashMap();
      paramString = a(paramString);
    } while (!a(paramString));
    localHashMap.put("url", paramString);
    localHashMap.put("source_activity", paramIntent.getStringExtra("SourceActivityName"));
    if (jdField_B_of_type_Long > this.F) {}
    for (boolean bool = true;; bool = false)
    {
      paramIntent = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
      while (paramIntent.hasNext())
      {
        paramString = (String)paramIntent.next();
        localHashMap.put(paramString, ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).longValue() - this.F + "");
      }
    }
    localHashMap.put("bounce_rate_state", this.jdField_h_of_type_JavaLangString);
    localHashMap.put("is_cold_launch", "" + bool);
    localHashMap.put("network_type", HttpUtil.getNetWorkTypeByStr());
    localHashMap.put("system_os", Build.MODEL + Build.VERSION.SDK_INT);
    localHashMap.put("QQ_version", AppSetting.g());
    localHashMap.put("use_offline_package", jdField_b_of_type_Boolean + "");
    localHashMap.put("use_sonic", this.jdField_d_of_type_Boolean + "");
    localHashMap.put("use_pre_load", "" + jdField_s_of_type_Boolean);
    paramIntent = new StringBuilder();
    if (E > this.F) {}
    for (bool = false;; bool = true)
    {
      localHashMap.put("is_x5_init", bool + "");
      localHashMap.put("core_type", this.jdField_e_of_type_Int + "");
      localHashMap.put("activity_create_final", String.valueOf(this.H - this.G));
      localHashMap.put("origin_url", this.jdField_e_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localHashMap.put("redirect_time", "" + this.jdField_a_of_type_JavaUtilList.size());
        localHashMap.put("first_url", this.jdField_a_of_type_JavaUtilList.get(0));
      }
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 4, "reportBounceRate: " + localHashMap);
      }
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "webviewBounceRateCollection", true, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  public void b(String paramString)
  {
    if (!jdField_x_of_type_Boolean) {}
    HashMap localHashMap;
    do
    {
      return;
      localHashMap = new HashMap();
      paramString = a(paramString);
    } while (!a(paramString));
    localHashMap.put("url", paramString);
    localHashMap.put("source_activity", this.jdField_c_of_type_JavaLangString);
    localHashMap.put("process_start_spending_time", String.valueOf(this.I));
    localHashMap.put("init_tbs_time", String.valueOf(this.jdField_z_of_type_Long));
    localHashMap.put("init_x5_core_time", String.valueOf(this.jdField_w_of_type_Long));
    localHashMap.put("init_x5_webview_time", String.valueOf(this.jdField_x_of_type_Long));
    localHashMap.put("init_tbs_so_time", String.valueOf(this.jdField_y_of_type_Long));
    localHashMap.put("init_all_time", String.valueOf(this.jdField_A_of_type_Long));
    localHashMap.put("activity_on_create_time", String.valueOf(this.G - this.F));
    localHashMap.put("is_cold_launch", "" + this.jdField_c_of_type_Boolean);
    localHashMap.put("network_type", this.jdField_f_of_type_JavaLangString);
    localHashMap.put("system_os", Build.MODEL + Build.VERSION.SDK_INT);
    localHashMap.put("QQ_version", AppSetting.g());
    localHashMap.put("use_offline_package", jdField_b_of_type_Boolean + "");
    localHashMap.put("use_sonic", this.jdField_d_of_type_Boolean + "");
    localHashMap.put("use_pre_load", "" + jdField_s_of_type_Boolean);
    paramString = new StringBuilder();
    if (E > this.F) {}
    for (boolean bool = false;; bool = true)
    {
      localHashMap.put("is_x5_init", bool + "");
      localHashMap.put("webview_create_time", String.valueOf(this.J));
      localHashMap.put("core_type", String.valueOf(this.jdField_e_of_type_Int));
      localHashMap.put("fragment_create_final", String.valueOf(this.H - this.G));
      localHashMap.put("browser_act_create_cost", String.valueOf(this.H - jdField_C_of_type_Long));
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localHashMap.put("redirect_time", "" + this.jdField_a_of_type_JavaUtilList.size());
        localHashMap.put("first_url", this.jdField_a_of_type_JavaUtilList.get(0));
      }
      localHashMap.put("int_tbs_env", String.valueOf(SwiftWebAccelerator.TbsAccelerator.jdField_a_of_type_Long));
      localHashMap.put("init_plugin", String.valueOf(jdField_D_of_type_Long));
      localHashMap.put("fragment_create_time", String.valueOf(this.G - jdField_C_of_type_Long));
      localHashMap.put("step_initUIFrame", String.valueOf(this.K));
      localHashMap.put("step_initUIContent", String.valueOf(this.M));
      localHashMap.put("step_initTitleBar", String.valueOf(this.L));
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 4, "webviewSpendingTimeCollection: " + localHashMap);
      }
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "webviewSpendingTimeCollection", true, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  public void c(String paramString)
  {
    if (paramString.equals("state_back")) {
      if (!this.jdField_h_of_type_JavaLangString.equals("state_final")) {
        this.jdField_b_of_type_JavaUtilHashMap.put("state_back", Long.valueOf(SystemClock.elapsedRealtime()));
      }
    }
    int i1;
    int i2;
    do
    {
      return;
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
      i1 = this.jdField_a_of_type_AndroidUtilSparseArray.indexOfValue(paramString);
      i2 = this.jdField_a_of_type_AndroidUtilSparseArray.indexOfValue(this.jdField_h_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 4, "setBounceRateState state=" + paramString + " mCurr=" + this.jdField_h_of_type_JavaLangString);
      }
    } while (i1 <= i2);
    this.jdField_h_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_JavaUtilHashMap.put(this.jdField_h_of_type_JavaLangString, Long.valueOf(SystemClock.elapsedRealtime()));
  }
  
  public void d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (this.jdField_m_of_type_Boolean) {
        ReportController.b(null, "P_CliOper", "Grp_open", "", "time", "wide_time", 0, 1, 0, "", paramString.getQueryParameter("appid"), (int)((System.nanoTime() - this.jdField_i_of_type_Long) / 1000000L) + "", paramString.getQueryParameter("group_openid"));
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("web_report", 4, "web_stay_in_url, cost = " + (System.nanoTime() - this.jdField_i_of_type_Long) / 1000000L + ", url = " + Util.b(this.jdField_d_of_type_JavaLangString, new String[0]) + ", isFromLeba = " + this.jdField_e_of_type_Boolean + ", hasRedDot = " + this.jdField_f_of_type_Boolean);
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if ((this.jdField_g_of_type_Boolean) && (!this.jdField_k_of_type_Boolean)) {
      d();
    }
  }
  
  public void e(String paramString)
  {
    QLog.i("SwiftBrowserStatistics", 1, "shouldOverrideUrlLoading detect 302, url: " + paramString);
    this.jdField_u_of_type_Long = System.currentTimeMillis();
    this.jdField_h_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList.add(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics
 * JD-Core Version:    0.7.0.1
 */