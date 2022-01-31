package com.tencent.mobileqq.log;

import aech;
import android.content.Context;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class VipWebViewReportLog
{
  public static int a;
  private static Context jdField_a_of_type_AndroidContentContext;
  public static final String a;
  static Thread jdField_a_of_type_JavaLangThread;
  public static Set a;
  public static AtomicInteger a;
  private static AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  public static boolean a;
  private static int b;
  public static final String b;
  public static boolean b;
  private static int c;
  public static String c;
  private static int d;
  public static String d;
  public static String e;
  public static String f;
  
  static
  {
    jdField_a_of_type_JavaLangString = VipWebViewReportLog.class.getSimpleName();
    jdField_a_of_type_JavaUtilSet = new HashSet();
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
    jdField_b_of_type_JavaLangString = AppConstants.aJ + "WebViewCheck" + File.separator;
    jdField_d_of_type_JavaLangString = "null";
    e = "null";
    f = "null";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  public static void a()
  {
    if ((jdField_a_of_type_JavaLangThread == null) || (!jdField_a_of_type_JavaLangThread.isAlive()))
    {
      jdField_a_of_type_JavaLangThread = ThreadManager.newFreeThread(new aech(), "WebviewLoadConfig", 8);
      if (QLog.isColorLevel()) {
        QLog.d("WebCoreDump", 1, "ready to load config at:" + System.currentTimeMillis());
      }
      jdField_a_of_type_JavaLangThread.start();
    }
  }
  
  public static void a(Context paramContext, AppRuntime paramAppRuntime)
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebCoreDump", 2, "VipWebViewReportLog init by context=" + paramContext + ", AppInterface=" + paramAppRuntime);
      }
      jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
      jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
      jdField_d_of_type_Int = jdField_b_of_type_Int;
      a();
    }
  }
  
  private static void a(TelephonyManager paramTelephonyManager)
  {
    if (paramTelephonyManager == null) {}
    NetworkInfo localNetworkInfo;
    do
    {
      return;
      jdField_d_of_type_JavaLangString = "null";
      e = "null";
      f = "null";
      localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    } while ((localNetworkInfo == null) || (!localNetworkInfo.isAvailable()));
    switch (localNetworkInfo.getType())
    {
    case 7: 
    case 8: 
    default: 
      e = "unknown";
      f = "unknown";
      return;
    case 9: 
      e = "cable";
      return;
    case 1: 
    case 6: 
      e = "WIFI";
      return;
    }
    jdField_d_of_type_JavaLangString = paramTelephonyManager.getNetworkOperatorName();
    switch (paramTelephonyManager.getNetworkType())
    {
    default: 
      e = "2G";
      f = "unknown";
      return;
    case 13: 
      e = "4G";
      f = "LTE";
      return;
    case 3: 
      e = "3G";
      f = "UMTS";
      return;
    case 5: 
      e = "3G";
      f = "EVDO_0";
      return;
    case 6: 
      e = "3G";
      f = "EVDO_A";
      return;
    case 8: 
      e = "3G";
      f = "SDPA";
      return;
    case 9: 
      e = "3G";
      f = "HSUPA";
      return;
    case 10: 
      e = "3G";
      f = "HSPA";
      return;
    case 12: 
      e = "3G";
      f = "EVDO_B";
      return;
    case 14: 
      e = "3G";
      f = "EHRPD";
      return;
    case 15: 
      e = "3G";
      f = "HSPAP";
      return;
    case 1: 
      e = "2G";
      f = "GPRS";
      return;
    case 2: 
      e = "2G";
      f = "EDGE";
      return;
    case 4: 
      e = "2G";
      f = "CDMA";
      return;
    case 7: 
      e = "2G";
      f = "1xRTT";
      return;
    case 11: 
      e = "2G";
      f = "IDEN";
      return;
    }
    e = "2G";
    f = "unknown";
  }
  
  /* Error */
  public static void a(com.tencent.smtt.export.external.interfaces.ConsoleMessage paramConsoleMessage)
  {
    // Byte code:
    //   0: getstatic 87	com/tencent/mobileqq/log/VipWebViewReportLog:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   3: ifnonnull +4 -> 7
    //   6: return
    //   7: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifne +30 -> 40
    //   13: getstatic 84	com/tencent/mobileqq/log/VipWebViewReportLog:jdField_d_of_type_Int	I
    //   16: getstatic 39	com/tencent/mobileqq/log/VipWebViewReportLog:jdField_c_of_type_Int	I
    //   19: if_icmpne +9 -> 28
    //   22: getstatic 222	com/tencent/mobileqq/log/VipWebViewReportLog:jdField_a_of_type_Boolean	Z
    //   25: ifeq +649 -> 674
    //   28: aload_0
    //   29: invokeinterface 228 1 0
    //   34: getstatic 234	com/tencent/smtt/export/external/interfaces/ConsoleMessage$MessageLevel:ERROR	Lcom/tencent/smtt/export/external/interfaces/ConsoleMessage$MessageLevel;
    //   37: if_acmpne +637 -> 674
    //   40: new 41	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   47: ldc 236
    //   49: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 238
    //   54: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore_1
    //   61: new 41	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   68: aload_1
    //   69: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 240
    //   74: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: astore_1
    //   81: new 41	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   88: aload_1
    //   89: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc 242
    //   94: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: astore_1
    //   101: new 41	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   108: aload_1
    //   109: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: ldc 244
    //   114: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: getstatic 249	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   120: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore_1
    //   127: getstatic 87	com/tencent/mobileqq/log/VipWebViewReportLog:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   130: invokevirtual 254	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   133: astore_2
    //   134: new 41	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   141: aload_1
    //   142: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc_w 256
    //   148: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_2
    //   152: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: astore_1
    //   159: aload_0
    //   160: invokeinterface 259 1 0
    //   165: ifnull +381 -> 546
    //   168: new 41	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   175: aload_1
    //   176: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: ldc_w 261
    //   182: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload_0
    //   186: invokeinterface 259 1 0
    //   191: invokestatic 267	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   194: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: astore_1
    //   201: new 41	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   208: aload_1
    //   209: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: ldc_w 269
    //   215: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_0
    //   219: invokeinterface 272 1 0
    //   224: invokestatic 278	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   227: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: astore_1
    //   234: aload_0
    //   235: invokeinterface 281 1 0
    //   240: ifnull +330 -> 570
    //   243: new 41	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   250: aload_1
    //   251: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: ldc_w 283
    //   257: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload_0
    //   261: invokeinterface 281 1 0
    //   266: invokestatic 267	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   269: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: astore_1
    //   276: new 41	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   283: aload_1
    //   284: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: ldc_w 285
    //   290: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokestatic 121	java/lang/System:currentTimeMillis	()J
    //   296: invokevirtual 124	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   299: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: astore_1
    //   303: getstatic 287	com/tencent/mobileqq/log/VipWebViewReportLog:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   306: ifnull +288 -> 594
    //   309: new 41	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   316: aload_1
    //   317: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: ldc_w 289
    //   323: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: getstatic 287	com/tencent/mobileqq/log/VipWebViewReportLog:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   329: invokestatic 267	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   332: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: astore_1
    //   339: aload_0
    //   340: invokeinterface 228 1 0
    //   345: ifnull +273 -> 618
    //   348: new 41	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   355: aload_1
    //   356: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc_w 291
    //   362: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload_0
    //   366: invokeinterface 228 1 0
    //   371: invokevirtual 292	com/tencent/smtt/export/external/interfaces/ConsoleMessage$MessageLevel:toString	()Ljava/lang/String;
    //   374: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: astore_0
    //   381: new 41	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   388: aload_0
    //   389: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: ldc_w 294
    //   395: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: getstatic 299	android/os/Build:MODEL	Ljava/lang/String;
    //   401: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: astore_0
    //   408: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   411: ifeq +231 -> 642
    //   414: new 41	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   421: aload_0
    //   422: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: ldc_w 301
    //   428: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: astore_0
    //   435: getstatic 150	com/tencent/mobileqq/log/VipWebViewReportLog:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   438: ldc_w 303
    //   441: invokevirtual 307	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   444: checkcast 175	android/telephony/TelephonyManager
    //   447: invokestatic 309	com/tencent/mobileqq/log/VipWebViewReportLog:a	(Landroid/telephony/TelephonyManager;)V
    //   450: new 41	java/lang/StringBuilder
    //   453: dup
    //   454: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   457: aload_0
    //   458: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: ldc_w 311
    //   464: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: getstatic 67	com/tencent/mobileqq/log/VipWebViewReportLog:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   470: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: astore_0
    //   477: new 41	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   484: aload_0
    //   485: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: ldc_w 313
    //   491: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: getstatic 69	com/tencent/mobileqq/log/VipWebViewReportLog:e	Ljava/lang/String;
    //   497: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: astore_0
    //   504: new 41	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   511: aload_0
    //   512: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: ldc_w 315
    //   518: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: getstatic 71	com/tencent/mobileqq/log/VipWebViewReportLog:f	Ljava/lang/String;
    //   524: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: astore_0
    //   531: getstatic 28	com/tencent/mobileqq/log/VipWebViewReportLog:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   534: iconst_1
    //   535: aload_0
    //   536: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   539: return
    //   540: astore_0
    //   541: aload_0
    //   542: invokevirtual 318	java/lang/Exception:printStackTrace	()V
    //   545: return
    //   546: new 41	java/lang/StringBuilder
    //   549: dup
    //   550: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   553: aload_1
    //   554: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: ldc_w 320
    //   560: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: astore_1
    //   567: goto -366 -> 201
    //   570: new 41	java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   577: aload_1
    //   578: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: ldc_w 322
    //   584: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: astore_1
    //   591: goto -315 -> 276
    //   594: new 41	java/lang/StringBuilder
    //   597: dup
    //   598: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   601: aload_1
    //   602: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: ldc_w 324
    //   608: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: astore_1
    //   615: goto -276 -> 339
    //   618: new 41	java/lang/StringBuilder
    //   621: dup
    //   622: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   625: aload_1
    //   626: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: ldc_w 326
    //   632: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   638: astore_0
    //   639: goto -258 -> 381
    //   642: new 41	java/lang/StringBuilder
    //   645: dup
    //   646: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   649: aload_0
    //   650: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: ldc_w 328
    //   656: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   662: astore_0
    //   663: goto -228 -> 435
    //   666: astore_1
    //   667: aload_1
    //   668: invokevirtual 318	java/lang/Exception:printStackTrace	()V
    //   671: goto -221 -> 450
    //   674: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	675	0	paramConsoleMessage	com.tencent.smtt.export.external.interfaces.ConsoleMessage
    //   60	566	1	str1	String
    //   666	2	1	localException	Exception
    //   133	19	2	str2	String
    // Exception table:
    //   from	to	target	type
    //   0	6	540	java/lang/Exception
    //   7	28	540	java/lang/Exception
    //   28	40	540	java/lang/Exception
    //   40	201	540	java/lang/Exception
    //   201	276	540	java/lang/Exception
    //   276	339	540	java/lang/Exception
    //   339	381	540	java/lang/Exception
    //   381	435	540	java/lang/Exception
    //   450	539	540	java/lang/Exception
    //   546	567	540	java/lang/Exception
    //   570	591	540	java/lang/Exception
    //   594	615	540	java/lang/Exception
    //   618	639	540	java/lang/Exception
    //   642	663	540	java/lang/Exception
    //   667	671	540	java/lang/Exception
    //   435	450	666	java/lang/Exception
  }
  
  public static void a(JSONObject paramJSONObject, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(4096);
    if ("null".equals(e)) {}
    try
    {
      a((TelephonyManager)jdField_a_of_type_AndroidContentContext.getSystemService("phone"));
      localStringBuilder.append("==> SUMMARY INFO <==\nNET_TYPE:").append(e).append("\n").append("ERROR_CODE:").append(paramInt).append("\n");
      if (paramJSONObject != null)
      {
        long l2 = paramJSONObject.optLong("dns_start");
        long l8 = paramJSONObject.optLong("dns_end");
        l3 = paramJSONObject.optLong("connect_start");
        long l9 = paramJSONObject.optLong("connect_end");
        l4 = paramJSONObject.optLong("ssl_handshake_start");
        long l10 = paramJSONObject.optLong("ssl_handshake_end");
        l5 = paramJSONObject.optLong("send_start");
        long l11 = paramJSONObject.optLong("send_end");
        l6 = paramJSONObject.optLong("recv_start");
        l7 = paramJSONObject.optLong("recv_end");
        if (0L != l2)
        {
          l1 = l2;
          localStringBuilder.append("DNS cost=").append(l8 - l2).append("\n");
          localStringBuilder.append("Create connect cost=").append(l9 - l3).append("\n");
          localStringBuilder.append("SSL handshake cost=").append(l10 - l4).append("\n");
          localStringBuilder.append("Send cost=").append(l11 - l5).append("\n");
          localStringBuilder.append("Receive cost=").append(l7 - l6).append("\n");
          localStringBuilder.append("Total Duration=").append(l7 - l1).append("\n");
          localStringBuilder.append("Original Data:\n").append(paramJSONObject);
        }
      }
      else
      {
        QLog.d("WebCoreDump", 1, localStringBuilder.toString());
        if (paramWebResourceRequest == null) {
          break label732;
        }
        localStringBuilder.setLength(0);
        localStringBuilder.append("HAS_GESTURE:" + paramWebResourceRequest.hasGesture() + "\n");
        localStringBuilder.append("IS_FOR_MAINFRAME:" + paramWebResourceRequest.isForMainFrame() + "\n");
        localStringBuilder.append(paramWebResourceRequest.getMethod()).append(" ").append(paramWebResourceRequest.getUrl()).append("\n");
        paramJSONObject = paramWebResourceRequest.getRequestHeaders();
        if ((paramJSONObject == null) || (paramJSONObject.size() <= 0)) {
          break label702;
        }
        paramWebResourceRequest = paramJSONObject.keySet().iterator();
        for (;;)
        {
          if (!paramWebResourceRequest.hasNext()) {
            break label702;
          }
          String str = (String)paramWebResourceRequest.next();
          if (!str.equalsIgnoreCase("cookie")) {
            break;
          }
          localStringBuilder.append(str + ":" + Util.c((String)paramJSONObject.get(str), new String[0]) + "\n");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l3;
        long l4;
        long l5;
        long l6;
        long l7;
        long l1;
        localException.printStackTrace();
        continue;
        if (0L != l3)
        {
          l1 = l3;
        }
        else if (0L != l4)
        {
          l1 = l4;
        }
        else if (0L != l5)
        {
          l1 = l5;
        }
        else if (0L != l6)
        {
          l1 = l6;
        }
        else
        {
          l1 = l7;
          continue;
          localStringBuilder.append(localException + ":" + (String)paramJSONObject.get(localException) + "\n");
        }
      }
      label702:
      QLog.d("WebCoreDump", 1, "-->HTTP REQUEST\n" + localStringBuilder.toString());
      label732:
      if (paramWebResourceResponse != null)
      {
        localStringBuilder.setLength(0);
        localStringBuilder.append("STATUS_CODE:" + paramWebResourceResponse.getStatusCode() + "\n").append("CONTENT_ENCODING:" + paramWebResourceResponse.getEncoding() + "\n").append("MIME_TYPE:" + paramWebResourceResponse.getMimeType() + "\n").append("REASON_PHRASE:" + paramWebResourceResponse.getReasonPhrase() + "\n");
        paramJSONObject = paramWebResourceResponse.getResponseHeaders();
        if ((paramJSONObject != null) && (paramJSONObject.size() > 0))
        {
          paramWebResourceRequest = paramJSONObject.keySet().iterator();
          while (paramWebResourceRequest.hasNext())
          {
            paramWebResourceResponse = (String)paramWebResourceRequest.next();
            localStringBuilder.append(paramWebResourceResponse + ":" + (String)paramJSONObject.get(paramWebResourceResponse) + "\n");
          }
        }
        QLog.d("WebCoreDump", 1, "<--HTTP RESPONSE\n" + localStringBuilder.toString());
      }
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0;
  }
  
  public static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((!TextUtils.isEmpty(str)) && (paramString.contains(str)))
        {
          QLog.d("WebCoreDump", 1, "-->url:" + Util.b(paramString, new String[0]) + " is in white list");
          return true;
        }
      }
    }
    QLog.d("WebCoreDump", 1, "-->url:" + Util.b(paramString, new String[0]) + " is not in white list");
    return false;
  }
  
  public static void b()
  {
    if (jdField_d_of_type_Int == jdField_b_of_type_Int) {}
  }
  
  public static boolean b()
  {
    QLog.d("WebCoreDump", 1, "-->uin in white list:" + jdField_b_of_type_Boolean);
    return jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.log.VipWebViewReportLog
 * JD-Core Version:    0.7.0.1
 */