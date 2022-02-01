package com.tencent.mobileqq.vip;

import android.content.Context;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.mobileqq.apollo.api.statistics.trace.ITraceReportHelper;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.utils.HttpDownloadUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqsharpP.QQSharpPUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

public class DownloaderFactory
  implements Manager
{
  static ConnectivityManager jdField_a_of_type_AndroidNetConnectivityManager = null;
  private static Map<String, Integer> jdField_a_of_type_JavaUtilMap = new DownloaderFactory.2();
  public static ConcurrentHashMap<Integer, DownloaderInterface> a;
  public static volatile boolean a;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  public static ConcurrentHashMap<String, Integer> b;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    b = null;
    jdField_a_of_type_ArrayOfInt = WebpSoLoader.a();
  }
  
  public DownloaderFactory(AppRuntime paramAppRuntime)
  {
    b = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    if (jdField_a_of_type_AndroidNetConnectivityManager == null) {
      jdField_a_of_type_AndroidNetConnectivityManager = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
    }
  }
  
  /* Error */
  public static int a(DownloadTask paramDownloadTask, String paramString, Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 73
    //   8: iconst_2
    //   9: ldc 75
    //   11: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: bipush 254
    //   16: istore 4
    //   18: aload_0
    //   19: invokevirtual 84	com/tencent/mobileqq/vip/DownloadTask:a	()Lcom/tencent/mobileqq/vip/DownloadListener;
    //   22: ifnonnull +14 -> 36
    //   25: aload_0
    //   26: new 86	com/tencent/mobileqq/vip/DownloaderFactory$1
    //   29: dup
    //   30: invokespecial 87	com/tencent/mobileqq/vip/DownloaderFactory$1:<init>	()V
    //   33: invokevirtual 90	com/tencent/mobileqq/vip/DownloadTask:a	(Lcom/tencent/mobileqq/vip/DownloadListener;)V
    //   36: aload_1
    //   37: ifnull +26 -> 63
    //   40: aload_0
    //   41: getfield 93	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo	Lcom/tencent/mobileqq/vip/DownloadTask$ReportInfo;
    //   44: getfield 98	com/tencent/mobileqq/vip/DownloadTask$ReportInfo:a	J
    //   47: lconst_0
    //   48: lcmp
    //   49: ifge +14 -> 63
    //   52: aload_0
    //   53: getfield 93	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo	Lcom/tencent/mobileqq/vip/DownloadTask$ReportInfo;
    //   56: aload_1
    //   57: invokestatic 104	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   60: putfield 98	com/tencent/mobileqq/vip/DownloadTask$ReportInfo:a	J
    //   63: aload_0
    //   64: ifnull +7492 -> 7556
    //   67: iload 4
    //   69: istore_3
    //   70: ldc 106
    //   72: invokestatic 112	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   75: checkcast 106	com/tencent/mobileqq/apollo/api/uitls/IApolloUtil
    //   78: astore 42
    //   80: iload 4
    //   82: istore_3
    //   83: aload 42
    //   85: aload_0
    //   86: invokeinterface 116 2 0
    //   91: iload 4
    //   93: istore_3
    //   94: aload 42
    //   96: aload_0
    //   97: invokeinterface 119 2 0
    //   102: iconst_m1
    //   103: istore 4
    //   105: iload 4
    //   107: istore_3
    //   108: aload_0
    //   109: invokevirtual 122	com/tencent/mobileqq/vip/DownloadTask:c	()Z
    //   112: ifne +59 -> 171
    //   115: iload 4
    //   117: istore_3
    //   118: aload_0
    //   119: bipush 147
    //   121: putfield 125	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   124: iload 4
    //   126: istore_3
    //   127: aload_0
    //   128: invokevirtual 128	com/tencent/mobileqq/vip/DownloadTask:f	()V
    //   131: iload 4
    //   133: istore_3
    //   134: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq +7425 -> 7562
    //   140: iload 4
    //   142: istore_3
    //   143: ldc 73
    //   145: iconst_2
    //   146: new 130	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   153: ldc 133
    //   155: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_0
    //   159: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: goto +7394 -> 7562
    //   171: iload 4
    //   173: istore_3
    //   174: new 146	org/apache/http/params/BasicHttpParams
    //   177: dup
    //   178: invokespecial 147	org/apache/http/params/BasicHttpParams:<init>	()V
    //   181: astore 43
    //   183: iload 4
    //   185: istore_3
    //   186: aload 43
    //   188: ldc 149
    //   190: sipush 10000
    //   193: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   196: invokeinterface 161 3 0
    //   201: pop
    //   202: iload 4
    //   204: istore_3
    //   205: aload 43
    //   207: ldc 163
    //   209: aload_0
    //   210: getfield 166	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Int	I
    //   213: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   216: invokeinterface 161 3 0
    //   221: pop
    //   222: iload 4
    //   224: istore_3
    //   225: aload_0
    //   226: getfield 169	com/tencent/mobileqq/vip/DownloadTask:n	Z
    //   229: ifeq +7341 -> 7570
    //   232: ldc 171
    //   234: astore 30
    //   236: iload 4
    //   238: istore_3
    //   239: aload 43
    //   241: ldc 173
    //   243: aload 30
    //   245: invokeinterface 161 3 0
    //   250: pop
    //   251: iload 4
    //   253: istore_3
    //   254: aload_0
    //   255: getfield 176	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   258: ifnull +18 -> 276
    //   261: iload 4
    //   263: istore_3
    //   264: aload_0
    //   265: getfield 176	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   268: invokeinterface 182 1 0
    //   273: ifgt +59 -> 332
    //   276: iload 4
    //   278: istore_3
    //   279: aload_0
    //   280: bipush 149
    //   282: putfield 125	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   285: iload 4
    //   287: istore_3
    //   288: aload_0
    //   289: invokevirtual 128	com/tencent/mobileqq/vip/DownloadTask:f	()V
    //   292: iload 4
    //   294: istore_3
    //   295: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   298: ifeq +7270 -> 7568
    //   301: iload 4
    //   303: istore_3
    //   304: ldc 73
    //   306: iconst_2
    //   307: new 130	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   314: ldc 184
    //   316: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_0
    //   320: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: goto +7239 -> 7568
    //   332: iload 4
    //   334: istore_3
    //   335: aload_0
    //   336: getfield 176	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   339: invokeinterface 182 1 0
    //   344: istore 9
    //   346: iconst_0
    //   347: istore 13
    //   349: iload 4
    //   351: istore_3
    //   352: getstatic 189	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   355: istore 4
    //   357: iconst_1
    //   358: iload 4
    //   360: if_icmpne +1408 -> 1768
    //   363: iconst_1
    //   364: istore 14
    //   366: iconst_0
    //   367: istore 10
    //   369: aconst_null
    //   370: astore 30
    //   372: iconst_m1
    //   373: istore 7
    //   375: aconst_null
    //   376: astore 31
    //   378: aconst_null
    //   379: astore 32
    //   381: sipush 2048
    //   384: istore_3
    //   385: iload 7
    //   387: istore 4
    //   389: iload 10
    //   391: aload_0
    //   392: getfield 176	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   395: invokeinterface 182 1 0
    //   400: if_icmpge +6463 -> 6863
    //   403: iconst_m1
    //   404: istore 4
    //   406: iload 4
    //   408: istore 7
    //   410: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   413: lstore 26
    //   415: iconst_m1
    //   416: istore 5
    //   418: iload 4
    //   420: istore 7
    //   422: new 4	java/lang/Object
    //   425: dup
    //   426: invokespecial 41	java/lang/Object:<init>	()V
    //   429: astore 46
    //   431: iload 4
    //   433: istore 7
    //   435: new 197	java/util/HashMap
    //   438: dup
    //   439: invokespecial 198	java/util/HashMap:<init>	()V
    //   442: astore 44
    //   444: iload 4
    //   446: istore 7
    //   448: aload_0
    //   449: getfield 176	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   452: iload 10
    //   454: invokeinterface 202 2 0
    //   459: checkcast 204	java/lang/String
    //   462: astore 34
    //   464: iload 4
    //   466: istore 7
    //   468: aload_0
    //   469: aload 34
    //   471: putfield 207	com/tencent/mobileqq/vip/DownloadTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   474: iload 4
    //   476: istore 7
    //   478: aload_0
    //   479: getfield 210	com/tencent/mobileqq/vip/DownloadTask:jdField_g_of_type_Int	I
    //   482: iconst_3
    //   483: if_icmpne +75 -> 558
    //   486: iload 14
    //   488: ifeq +70 -> 558
    //   491: iload 4
    //   493: istore 7
    //   495: ldc 212
    //   497: invokestatic 112	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   500: checkcast 212	com/tencent/mobileqq/apollo/api/statistics/trace/ITraceReportHelper
    //   503: astore 33
    //   505: iload 4
    //   507: istore 7
    //   509: aload 33
    //   511: bipush 30
    //   513: aconst_null
    //   514: aload_0
    //   515: getfield 207	com/tencent/mobileqq/vip/DownloadTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   518: invokeinterface 216 4 0
    //   523: iload 4
    //   525: istore 7
    //   527: aload 33
    //   529: bipush 30
    //   531: aload_0
    //   532: getfield 207	com/tencent/mobileqq/vip/DownloadTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   535: sipush 300
    //   538: invokeinterface 220 4 0
    //   543: iload 4
    //   545: istore 7
    //   547: aload 42
    //   549: aload_0
    //   550: getfield 207	com/tencent/mobileqq/vip/DownloadTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   553: invokeinterface 224 2 0
    //   558: iload 4
    //   560: istore 7
    //   562: aload_0
    //   563: getfield 225	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   566: aload 34
    //   568: invokeinterface 230 2 0
    //   573: checkcast 232	java/io/File
    //   576: astore 40
    //   578: ldc 234
    //   580: astore 35
    //   582: aload 40
    //   584: ifnull +6201 -> 6785
    //   587: iload 4
    //   589: istore 7
    //   591: aload 40
    //   593: invokevirtual 238	java/io/File:getParentFile	()Ljava/io/File;
    //   596: astore 47
    //   598: iload 4
    //   600: istore 7
    //   602: aload_0
    //   603: getfield 241	com/tencent/mobileqq/vip/DownloadTask:h	Z
    //   606: ifeq +1168 -> 1774
    //   609: iload 4
    //   611: istore 7
    //   613: new 232	java/io/File
    //   616: dup
    //   617: aload 47
    //   619: new 130	java/lang/StringBuilder
    //   622: dup
    //   623: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   626: aload 40
    //   628: invokevirtual 244	java/io/File:getName	()Ljava/lang/String;
    //   631: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: ldc 246
    //   636: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: invokestatic 249	java/lang/System:nanoTime	()J
    //   642: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   645: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: invokespecial 255	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   651: astore 39
    //   653: aload 34
    //   655: astore 33
    //   657: iload 4
    //   659: istore 7
    //   661: aload_0
    //   662: getfield 257	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   665: invokestatic 263	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   668: ifne +18 -> 686
    //   671: iload 4
    //   673: istore 7
    //   675: aload_0
    //   676: getfield 257	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   679: aload 34
    //   681: invokestatic 269	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   684: astore 33
    //   686: iload 4
    //   688: istore 7
    //   690: new 271	com/tencent/mobileqq/emoticon/DownloadInfo
    //   693: dup
    //   694: aload 33
    //   696: aconst_null
    //   697: iconst_0
    //   698: invokespecial 274	com/tencent/mobileqq/emoticon/DownloadInfo:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   701: astore 41
    //   703: aload 33
    //   705: astore 35
    //   707: iconst_m1
    //   708: istore 11
    //   710: aload 32
    //   712: astore 33
    //   714: iconst_m1
    //   715: istore 5
    //   717: iconst_0
    //   718: istore 6
    //   720: lconst_0
    //   721: lstore 20
    //   723: lconst_0
    //   724: lstore 18
    //   726: aload 31
    //   728: astore 32
    //   730: aload 30
    //   732: astore 34
    //   734: aload 35
    //   736: astore 30
    //   738: iload 5
    //   740: istore 4
    //   742: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   745: lstore 28
    //   747: iload 5
    //   749: istore 4
    //   751: new 130	java/lang/StringBuilder
    //   754: dup
    //   755: ldc_w 276
    //   758: invokespecial 278	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   761: ldc_w 280
    //   764: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: aload_0
    //   768: getfield 169	com/tencent/mobileqq/vip/DownloadTask:n	Z
    //   771: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   774: ldc_w 285
    //   777: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: aload_0
    //   781: getfield 288	com/tencent/mobileqq/vip/DownloadTask:p	Z
    //   784: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   787: ldc_w 290
    //   790: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: aload_0
    //   794: getfield 292	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_Int	I
    //   797: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   800: ldc_w 297
    //   803: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: aload_0
    //   807: getfield 300	com/tencent/mobileqq/vip/DownloadTask:s	Z
    //   810: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   813: astore 45
    //   815: iconst_0
    //   816: istore 8
    //   818: iconst_0
    //   819: istore 7
    //   821: iconst_0
    //   822: istore 12
    //   824: iconst_0
    //   825: istore 15
    //   827: iconst_0
    //   828: istore 16
    //   830: aload 30
    //   832: astore 36
    //   834: aload 30
    //   836: astore 35
    //   838: iload 7
    //   840: istore 4
    //   842: aload 41
    //   844: invokevirtual 303	com/tencent/mobileqq/emoticon/DownloadInfo:clearParams	()V
    //   847: iconst_1
    //   848: istore 13
    //   850: aload 47
    //   852: ifnull +964 -> 1816
    //   855: aload 30
    //   857: astore 36
    //   859: aload 30
    //   861: astore 35
    //   863: iload 7
    //   865: istore 4
    //   867: aload 47
    //   869: invokevirtual 306	java/io/File:exists	()Z
    //   872: ifeq +27 -> 899
    //   875: aload 30
    //   877: astore 36
    //   879: aload 30
    //   881: astore 35
    //   883: iload 7
    //   885: istore 4
    //   887: aload 47
    //   889: invokevirtual 309	java/io/File:isDirectory	()Z
    //   892: istore 13
    //   894: iload 13
    //   896: ifne +920 -> 1816
    //   899: iload 13
    //   901: ifne +21 -> 922
    //   904: aload 30
    //   906: astore 36
    //   908: aload 30
    //   910: astore 35
    //   912: iload 7
    //   914: istore 4
    //   916: aload 47
    //   918: invokevirtual 312	java/io/File:delete	()Z
    //   921: pop
    //   922: aload 30
    //   924: astore 36
    //   926: aload 30
    //   928: astore 35
    //   930: iload 7
    //   932: istore 4
    //   934: aload 47
    //   936: invokevirtual 315	java/io/File:mkdirs	()Z
    //   939: ifne +877 -> 1816
    //   942: iconst_1
    //   943: istore 4
    //   945: iconst_1
    //   946: istore 12
    //   948: bipush 153
    //   950: istore 8
    //   952: aload 30
    //   954: astore 36
    //   956: aload 30
    //   958: astore 35
    //   960: aload_0
    //   961: bipush 153
    //   963: putfield 125	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   966: iload 12
    //   968: istore 5
    //   970: iload 8
    //   972: istore 4
    //   974: iload 8
    //   976: istore 7
    //   978: aload 45
    //   980: ldc_w 317
    //   983: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: aload 47
    //   988: invokevirtual 320	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   991: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   994: ldc_w 322
    //   997: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1000: invokestatic 326	com/tencent/mobileqq/util/Utils:a	()Z
    //   1003: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1006: ldc_w 328
    //   1009: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: invokestatic 330	com/tencent/mobileqq/util/Utils:b	()J
    //   1015: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1018: pop
    //   1019: iload 12
    //   1021: istore 5
    //   1023: iload 8
    //   1025: istore 4
    //   1027: iload 8
    //   1029: istore 7
    //   1031: new 332	java/lang/Exception
    //   1034: dup
    //   1035: ldc_w 334
    //   1038: invokespecial 335	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1041: athrow
    //   1042: astore 35
    //   1044: iload_3
    //   1045: istore 8
    //   1047: aload 33
    //   1049: astore 31
    //   1051: aload 34
    //   1053: astore 33
    //   1055: iload 4
    //   1057: istore_3
    //   1058: iload 16
    //   1060: istore 13
    //   1062: iload 5
    //   1064: istore 4
    //   1066: iload 6
    //   1068: istore 5
    //   1070: aload 35
    //   1072: astore 34
    //   1074: iconst_0
    //   1075: istore 6
    //   1077: aload 30
    //   1079: astore 38
    //   1081: aload 31
    //   1083: astore 35
    //   1085: aload 32
    //   1087: astore 37
    //   1089: aload 33
    //   1091: astore 36
    //   1093: iload_3
    //   1094: istore 7
    //   1096: aload 34
    //   1098: instanceof 337
    //   1101: ifne +6477 -> 7578
    //   1104: aload 30
    //   1106: astore 38
    //   1108: aload 31
    //   1110: astore 35
    //   1112: aload 32
    //   1114: astore 37
    //   1116: aload 33
    //   1118: astore 36
    //   1120: iload_3
    //   1121: istore 7
    //   1123: aload 34
    //   1125: instanceof 339
    //   1128: ifne +6450 -> 7578
    //   1131: aload 30
    //   1133: astore 38
    //   1135: aload 31
    //   1137: astore 35
    //   1139: aload 32
    //   1141: astore 37
    //   1143: aload 33
    //   1145: astore 36
    //   1147: iload_3
    //   1148: istore 7
    //   1150: aload 34
    //   1152: instanceof 341
    //   1155: ifeq +6 -> 1161
    //   1158: goto +6420 -> 7578
    //   1161: aload 30
    //   1163: astore 38
    //   1165: aload 31
    //   1167: astore 35
    //   1169: aload 32
    //   1171: astore 37
    //   1173: aload 33
    //   1175: astore 36
    //   1177: iload_3
    //   1178: istore 7
    //   1180: aload 34
    //   1182: instanceof 343
    //   1185: ifeq +5297 -> 6482
    //   1188: aload 30
    //   1190: astore 38
    //   1192: aload 31
    //   1194: astore 35
    //   1196: aload 32
    //   1198: astore 37
    //   1200: aload 33
    //   1202: astore 36
    //   1204: iload_3
    //   1205: istore 7
    //   1207: aload_0
    //   1208: bipush 145
    //   1210: putfield 125	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   1213: aload 30
    //   1215: astore 38
    //   1217: aload 31
    //   1219: astore 35
    //   1221: aload 32
    //   1223: astore 37
    //   1225: aload 33
    //   1227: astore 36
    //   1229: iload_3
    //   1230: istore 7
    //   1232: aload_0
    //   1233: aload 34
    //   1235: invokevirtual 346	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1238: putfield 348	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1241: iload 13
    //   1243: ifne +37 -> 1280
    //   1246: iload 6
    //   1248: ifeq +32 -> 1280
    //   1251: iload 5
    //   1253: ifeq +5475 -> 6728
    //   1256: aload 30
    //   1258: astore 38
    //   1260: aload 31
    //   1262: astore 35
    //   1264: aload 32
    //   1266: astore 37
    //   1268: aload 33
    //   1270: astore 36
    //   1272: iload_3
    //   1273: istore 7
    //   1275: aload_0
    //   1276: iconst_1
    //   1277: putfield 350	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Boolean	Z
    //   1280: aload 30
    //   1282: astore 38
    //   1284: aload 31
    //   1286: astore 35
    //   1288: aload 32
    //   1290: astore 37
    //   1292: aload 33
    //   1294: astore 36
    //   1296: iload_3
    //   1297: istore 7
    //   1299: aload 45
    //   1301: ldc_w 352
    //   1304: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: invokestatic 355	com/tencent/mobileqq/utils/FileUtils:a	()Z
    //   1310: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1313: ldc_w 357
    //   1316: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1319: invokestatic 360	com/tencent/mobileqq/utils/FileUtils:c	()F
    //   1322: ldc_w 361
    //   1325: fdiv
    //   1326: invokevirtual 364	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1329: pop
    //   1330: aload 30
    //   1332: astore 38
    //   1334: aload 31
    //   1336: astore 35
    //   1338: aload 32
    //   1340: astore 37
    //   1342: aload 33
    //   1344: astore 36
    //   1346: iload_3
    //   1347: istore 7
    //   1349: aload 45
    //   1351: ldc_w 366
    //   1354: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1357: aload 34
    //   1359: invokevirtual 346	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1362: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1365: pop
    //   1366: iload_3
    //   1367: istore 7
    //   1369: invokestatic 371	android/net/TrafficStats:clearThreadStatsTag	()V
    //   1372: iload_3
    //   1373: istore 7
    //   1375: ldc 73
    //   1377: iconst_1
    //   1378: new 130	java/lang/StringBuilder
    //   1381: dup
    //   1382: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   1385: aload 45
    //   1387: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1390: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1393: ldc_w 373
    //   1396: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   1402: lload 28
    //   1404: lsub
    //   1405: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1408: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1411: invokestatic 376	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1414: iload_3
    //   1415: istore 7
    //   1417: aload_0
    //   1418: getfield 210	com/tencent/mobileqq/vip/DownloadTask:jdField_g_of_type_Int	I
    //   1421: iconst_3
    //   1422: if_icmpne +73 -> 1495
    //   1425: iload 14
    //   1427: ifeq +68 -> 1495
    //   1430: iload_3
    //   1431: istore 7
    //   1433: ldc 212
    //   1435: invokestatic 112	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1438: checkcast 212	com/tencent/mobileqq/apollo/api/statistics/trace/ITraceReportHelper
    //   1441: bipush 30
    //   1443: aload_0
    //   1444: getfield 207	com/tencent/mobileqq/vip/DownloadTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1447: sipush 300
    //   1450: iconst_1
    //   1451: anewarray 4	java/lang/Object
    //   1454: dup
    //   1455: iconst_0
    //   1456: new 130	java/lang/StringBuilder
    //   1459: dup
    //   1460: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   1463: aload 45
    //   1465: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1468: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1471: ldc_w 373
    //   1474: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1477: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   1480: lload 28
    //   1482: lsub
    //   1483: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1486: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1489: aastore
    //   1490: invokeinterface 380 5 0
    //   1495: iload_3
    //   1496: istore 7
    //   1498: aload_0
    //   1499: aload_2
    //   1500: iload_3
    //   1501: aload 40
    //   1503: aload 41
    //   1505: invokestatic 383	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Landroid/content/Context;ILjava/io/File;Lcom/tencent/mobileqq/emoticon/DownloadInfo;)V
    //   1508: iload_3
    //   1509: istore 7
    //   1511: new 130	java/lang/StringBuilder
    //   1514: dup
    //   1515: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   1518: astore 35
    //   1520: iload_3
    //   1521: istore 7
    //   1523: aload 41
    //   1525: getfield 386	com/tencent/mobileqq/emoticon/DownloadInfo:isHttps	Z
    //   1528: ifeq +5227 -> 6755
    //   1531: ldc_w 388
    //   1534: astore 34
    //   1536: iload_3
    //   1537: istore 7
    //   1539: aload 35
    //   1541: aload 34
    //   1543: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1546: astore 35
    //   1548: iload_3
    //   1549: istore 7
    //   1551: aload 41
    //   1553: getfield 391	com/tencent/mobileqq/emoticon/DownloadInfo:isIPUrl	Z
    //   1556: ifeq +5207 -> 6763
    //   1559: ldc_w 393
    //   1562: astore 34
    //   1564: iload_3
    //   1565: istore 7
    //   1567: aload 35
    //   1569: aload 34
    //   1571: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1574: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1577: astore 34
    //   1579: iload_3
    //   1580: istore 7
    //   1582: aload 33
    //   1584: aload 32
    //   1586: aload 31
    //   1588: aload 30
    //   1590: invokestatic 396	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lorg/apache/http/HttpEntity;Ljava/io/InputStream;Ljava/io/BufferedOutputStream;Ljava/lang/String;)V
    //   1593: iload 8
    //   1595: istore 6
    //   1597: aload 31
    //   1599: astore 35
    //   1601: iload 11
    //   1603: iconst_1
    //   1604: iadd
    //   1605: istore 11
    //   1607: aload 30
    //   1609: astore 36
    //   1611: iload 5
    //   1613: istore 8
    //   1615: aload 32
    //   1617: astore 30
    //   1619: aload 33
    //   1621: astore 31
    //   1623: iload 4
    //   1625: istore 7
    //   1627: iload 11
    //   1629: istore 5
    //   1631: aload 35
    //   1633: astore 33
    //   1635: iload 6
    //   1637: istore 4
    //   1639: aload 36
    //   1641: astore 32
    //   1643: iload_3
    //   1644: ifeq +34 -> 1678
    //   1647: iload 7
    //   1649: ifne +29 -> 1678
    //   1652: iload_3
    //   1653: istore 7
    //   1655: iload 5
    //   1657: aload_0
    //   1658: getfield 292	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_Int	I
    //   1661: if_icmpge +17 -> 1678
    //   1664: iload_3
    //   1665: istore 7
    //   1667: aload_0
    //   1668: invokevirtual 398	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   1671: istore 15
    //   1673: iload 15
    //   1675: ifeq +5848 -> 7523
    //   1678: aload 34
    //   1680: astore 35
    //   1682: aload 32
    //   1684: astore 34
    //   1686: aload 31
    //   1688: astore 32
    //   1690: aload 30
    //   1692: astore 31
    //   1694: aload 33
    //   1696: astore 30
    //   1698: aload_0
    //   1699: invokevirtual 400	com/tencent/mobileqq/vip/DownloadTask:e	()V
    //   1702: aload_0
    //   1703: aload_1
    //   1704: aload_2
    //   1705: iload_3
    //   1706: iload 13
    //   1708: iload 14
    //   1710: lload 26
    //   1712: iload 5
    //   1714: lload 18
    //   1716: lload 20
    //   1718: aload 44
    //   1720: aload 34
    //   1722: aload 35
    //   1724: invokestatic 403	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Ljava/lang/String;Landroid/content/Context;IZZJIJJLjava/util/HashMap;Ljava/lang/String;Ljava/lang/String;)V
    //   1727: iload_3
    //   1728: ifne +5120 -> 6848
    //   1731: iload 9
    //   1733: iconst_1
    //   1734: isub
    //   1735: istore 5
    //   1737: iload 10
    //   1739: iconst_1
    //   1740: iadd
    //   1741: istore 10
    //   1743: aload 32
    //   1745: astore 33
    //   1747: iload_3
    //   1748: istore 7
    //   1750: iload 4
    //   1752: istore_3
    //   1753: aload 30
    //   1755: astore 32
    //   1757: aload 33
    //   1759: astore 30
    //   1761: iload 5
    //   1763: istore 9
    //   1765: goto -1380 -> 385
    //   1768: iconst_0
    //   1769: istore 14
    //   1771: goto -1405 -> 366
    //   1774: iload 4
    //   1776: istore 7
    //   1778: new 232	java/io/File
    //   1781: dup
    //   1782: aload 47
    //   1784: new 130	java/lang/StringBuilder
    //   1787: dup
    //   1788: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   1791: aload 40
    //   1793: invokevirtual 244	java/io/File:getName	()Ljava/lang/String;
    //   1796: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1799: ldc_w 405
    //   1802: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1805: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1808: invokespecial 255	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1811: astore 39
    //   1813: goto -1160 -> 653
    //   1816: aload 30
    //   1818: astore 36
    //   1820: aload 30
    //   1822: astore 35
    //   1824: iload 7
    //   1826: istore 4
    //   1828: getstatic 20	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   1831: ifnonnull +29 -> 1860
    //   1834: aload 30
    //   1836: astore 36
    //   1838: aload 30
    //   1840: astore 35
    //   1842: iload 7
    //   1844: istore 4
    //   1846: invokestatic 52	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1849: ldc 54
    //   1851: invokevirtual 58	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1854: checkcast 60	android/net/ConnectivityManager
    //   1857: putstatic 20	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   1860: aload 30
    //   1862: astore 36
    //   1864: aload 30
    //   1866: astore 35
    //   1868: iload 7
    //   1870: istore 4
    //   1872: invokestatic 411	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   1875: astore 37
    //   1877: aload 37
    //   1879: ifnonnull +361 -> 2240
    //   1882: bipush 152
    //   1884: istore 8
    //   1886: aload 30
    //   1888: astore 36
    //   1890: aload 30
    //   1892: astore 35
    //   1894: iload 7
    //   1896: istore 4
    //   1898: aload_0
    //   1899: bipush 152
    //   1901: putfield 125	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   1904: iload 12
    //   1906: istore 5
    //   1908: iload 8
    //   1910: istore 4
    //   1912: iload 8
    //   1914: istore 7
    //   1916: aload 45
    //   1918: ldc_w 413
    //   1921: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1924: pop
    //   1925: iload 12
    //   1927: istore 5
    //   1929: iload 8
    //   1931: istore 4
    //   1933: iload 8
    //   1935: istore 7
    //   1937: new 332	java/lang/Exception
    //   1940: dup
    //   1941: ldc_w 415
    //   1944: invokespecial 335	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1947: athrow
    //   1948: astore_1
    //   1949: iload 7
    //   1951: istore 5
    //   1953: iload 5
    //   1955: istore 4
    //   1957: invokestatic 371	android/net/TrafficStats:clearThreadStatsTag	()V
    //   1960: iload 5
    //   1962: istore 4
    //   1964: ldc 73
    //   1966: iconst_1
    //   1967: new 130	java/lang/StringBuilder
    //   1970: dup
    //   1971: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   1974: aload 45
    //   1976: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1979: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1982: ldc_w 373
    //   1985: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1988: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   1991: lload 28
    //   1993: lsub
    //   1994: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1997: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2000: invokestatic 376	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2003: iload 5
    //   2005: istore 4
    //   2007: aload_0
    //   2008: getfield 210	com/tencent/mobileqq/vip/DownloadTask:jdField_g_of_type_Int	I
    //   2011: iconst_3
    //   2012: if_icmpne +74 -> 2086
    //   2015: iload 14
    //   2017: ifeq +69 -> 2086
    //   2020: iload 5
    //   2022: istore 4
    //   2024: ldc 212
    //   2026: invokestatic 112	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2029: checkcast 212	com/tencent/mobileqq/apollo/api/statistics/trace/ITraceReportHelper
    //   2032: bipush 30
    //   2034: aload_0
    //   2035: getfield 207	com/tencent/mobileqq/vip/DownloadTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2038: sipush 300
    //   2041: iconst_1
    //   2042: anewarray 4	java/lang/Object
    //   2045: dup
    //   2046: iconst_0
    //   2047: new 130	java/lang/StringBuilder
    //   2050: dup
    //   2051: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   2054: aload 45
    //   2056: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2059: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2062: ldc_w 373
    //   2065: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2068: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   2071: lload 28
    //   2073: lsub
    //   2074: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2077: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2080: aastore
    //   2081: invokeinterface 380 5 0
    //   2086: iload 5
    //   2088: istore 4
    //   2090: aload_0
    //   2091: aload_2
    //   2092: iload 5
    //   2094: aload 40
    //   2096: aload 41
    //   2098: invokestatic 383	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Landroid/content/Context;ILjava/io/File;Lcom/tencent/mobileqq/emoticon/DownloadInfo;)V
    //   2101: iload 5
    //   2103: istore 4
    //   2105: new 130	java/lang/StringBuilder
    //   2108: dup
    //   2109: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   2112: astore_2
    //   2113: iload 5
    //   2115: istore 4
    //   2117: aload 41
    //   2119: getfield 386	com/tencent/mobileqq/emoticon/DownloadInfo:isHttps	Z
    //   2122: ifeq +4649 -> 6771
    //   2125: ldc_w 388
    //   2128: astore_0
    //   2129: iload 5
    //   2131: istore 4
    //   2133: aload_2
    //   2134: aload_0
    //   2135: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2138: astore_2
    //   2139: iload 5
    //   2141: istore 4
    //   2143: aload 41
    //   2145: getfield 391	com/tencent/mobileqq/emoticon/DownloadInfo:isIPUrl	Z
    //   2148: ifeq +4630 -> 6778
    //   2151: ldc_w 393
    //   2154: astore_0
    //   2155: iload 5
    //   2157: istore 4
    //   2159: aload_2
    //   2160: aload_0
    //   2161: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2164: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2167: pop
    //   2168: iload 5
    //   2170: istore 4
    //   2172: aload 34
    //   2174: aload 32
    //   2176: aload 33
    //   2178: aload 30
    //   2180: invokestatic 396	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lorg/apache/http/HttpEntity;Ljava/io/InputStream;Ljava/io/BufferedOutputStream;Ljava/lang/String;)V
    //   2183: iload 5
    //   2185: istore 4
    //   2187: aload_1
    //   2188: athrow
    //   2189: astore_0
    //   2190: iload 4
    //   2192: istore_3
    //   2193: ldc 73
    //   2195: iconst_1
    //   2196: aload_0
    //   2197: invokevirtual 346	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   2200: invokestatic 417	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2203: iload_3
    //   2204: istore 4
    //   2206: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2209: ifeq +5356 -> 7565
    //   2212: ldc 73
    //   2214: iconst_2
    //   2215: new 130	java/lang/StringBuilder
    //   2218: dup
    //   2219: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   2222: ldc_w 419
    //   2225: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2228: iload_3
    //   2229: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2232: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2235: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2238: iload_3
    //   2239: ireturn
    //   2240: aload 30
    //   2242: astore 31
    //   2244: aload 30
    //   2246: astore 36
    //   2248: aload 30
    //   2250: astore 35
    //   2252: iload 7
    //   2254: istore 4
    //   2256: aload_0
    //   2257: getfield 422	com/tencent/mobileqq/vip/DownloadTask:q	Z
    //   2260: ifeq +122 -> 2382
    //   2263: aload 30
    //   2265: astore 31
    //   2267: aload 30
    //   2269: astore 36
    //   2271: aload 30
    //   2273: astore 35
    //   2275: iload 7
    //   2277: istore 4
    //   2279: aload 30
    //   2281: ldc_w 424
    //   2284: invokevirtual 427	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2287: ifne +95 -> 2382
    //   2290: aload 30
    //   2292: astore 36
    //   2294: aload 30
    //   2296: astore 35
    //   2298: iload 7
    //   2300: istore 4
    //   2302: new 429	java/util/Random
    //   2305: dup
    //   2306: aload_1
    //   2307: invokestatic 433	com/tencent/mobileqq/qcall/UinUtils:a	(Ljava/lang/String;)J
    //   2310: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   2313: lor
    //   2314: invokespecial 436	java/util/Random:<init>	(J)V
    //   2317: invokevirtual 439	java/util/Random:nextInt	()I
    //   2320: istore 12
    //   2322: aload 30
    //   2324: astore 36
    //   2326: aload 30
    //   2328: astore 35
    //   2330: iload 7
    //   2332: istore 4
    //   2334: aload 30
    //   2336: invokestatic 442	com/tencent/mobileqq/vip/DownloaderFactory:b	(Ljava/lang/String;)Z
    //   2339: ifeq +390 -> 2729
    //   2342: aload 30
    //   2344: astore 36
    //   2346: aload 30
    //   2348: astore 35
    //   2350: iload 7
    //   2352: istore 4
    //   2354: new 130	java/lang/StringBuilder
    //   2357: dup
    //   2358: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   2361: aload 30
    //   2363: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2366: ldc_w 444
    //   2369: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2372: iload 12
    //   2374: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2377: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2380: astore 31
    //   2382: aload 31
    //   2384: astore 36
    //   2386: aload 31
    //   2388: astore 35
    //   2390: iload 7
    //   2392: istore 4
    //   2394: ldc 106
    //   2396: invokestatic 112	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2399: checkcast 106	com/tencent/mobileqq/apollo/api/uitls/IApolloUtil
    //   2402: aload 31
    //   2404: invokeinterface 448 2 0
    //   2409: astore 30
    //   2411: aload 30
    //   2413: astore 36
    //   2415: aload 30
    //   2417: astore 35
    //   2419: iload 7
    //   2421: istore 4
    //   2423: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2426: ifeq +42 -> 2468
    //   2429: aload 30
    //   2431: astore 36
    //   2433: aload 30
    //   2435: astore 35
    //   2437: iload 7
    //   2439: istore 4
    //   2441: ldc 73
    //   2443: iconst_2
    //   2444: new 130	java/lang/StringBuilder
    //   2447: dup
    //   2448: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   2451: ldc_w 450
    //   2454: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2457: aload 30
    //   2459: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2462: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2465: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2468: aload 30
    //   2470: astore 36
    //   2472: aload 30
    //   2474: astore 35
    //   2476: iload 7
    //   2478: istore 4
    //   2480: aload_0
    //   2481: getfield 452	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Int	I
    //   2484: sipush 302
    //   2487: if_icmpne +5029 -> 7516
    //   2490: iload 11
    //   2492: ifne +5024 -> 7516
    //   2495: aload 30
    //   2497: astore 36
    //   2499: aload 30
    //   2501: astore 35
    //   2503: iload 7
    //   2505: istore 4
    //   2507: aload_0
    //   2508: getfield 455	com/tencent/mobileqq/vip/DownloadTask:r	Z
    //   2511: ifeq +5005 -> 7516
    //   2514: aload 30
    //   2516: astore 36
    //   2518: aload 30
    //   2520: astore 35
    //   2522: iload 7
    //   2524: istore 4
    //   2526: aload 30
    //   2528: ldc_w 457
    //   2531: invokevirtual 460	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2534: ifeq +4982 -> 7516
    //   2537: aload 30
    //   2539: astore 36
    //   2541: aload 30
    //   2543: astore 35
    //   2545: iload 7
    //   2547: istore 4
    //   2549: aload_0
    //   2550: iconst_0
    //   2551: putfield 462	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   2554: iconst_1
    //   2555: istore 4
    //   2557: iconst_1
    //   2558: istore 7
    //   2560: aload 30
    //   2562: astore 36
    //   2564: aload 30
    //   2566: astore 35
    //   2568: aload 30
    //   2570: ldc_w 464
    //   2573: ldc_w 466
    //   2576: invokevirtual 469	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2579: astore 30
    //   2581: iload 7
    //   2583: istore 4
    //   2585: new 471	org/apache/http/client/methods/HttpGet
    //   2588: dup
    //   2589: aload 30
    //   2591: invokespecial 472	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   2594: astore 35
    //   2596: aload_0
    //   2597: invokevirtual 475	com/tencent/mobileqq/vip/DownloadTask:a	()Ljava/util/Map;
    //   2600: astore 31
    //   2602: aload 31
    //   2604: ifnull +168 -> 2772
    //   2607: aload 31
    //   2609: invokeinterface 479 1 0
    //   2614: invokeinterface 485 1 0
    //   2619: astore 36
    //   2621: aload 36
    //   2623: invokeinterface 490 1 0
    //   2628: ifeq +144 -> 2772
    //   2631: aload 36
    //   2633: invokeinterface 494 1 0
    //   2638: checkcast 204	java/lang/String
    //   2641: astore 38
    //   2643: aload 31
    //   2645: aload 38
    //   2647: invokeinterface 230 2 0
    //   2652: checkcast 204	java/lang/String
    //   2655: astore 48
    //   2657: aload 35
    //   2659: aload 38
    //   2661: aload 48
    //   2663: invokevirtual 498	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   2666: aload 45
    //   2668: ldc_w 500
    //   2671: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2674: aload 38
    //   2676: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2679: ldc_w 502
    //   2682: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2685: aload 48
    //   2687: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2690: pop
    //   2691: goto -70 -> 2621
    //   2694: astore 35
    //   2696: aload 33
    //   2698: astore 31
    //   2700: aload 34
    //   2702: astore 33
    //   2704: iload 5
    //   2706: istore 7
    //   2708: aload 35
    //   2710: astore 34
    //   2712: iload 6
    //   2714: istore 5
    //   2716: iload 16
    //   2718: istore 13
    //   2720: iload_3
    //   2721: istore 8
    //   2723: iload 7
    //   2725: istore_3
    //   2726: goto -1652 -> 1074
    //   2729: aload 30
    //   2731: astore 36
    //   2733: aload 30
    //   2735: astore 35
    //   2737: iload 7
    //   2739: istore 4
    //   2741: new 130	java/lang/StringBuilder
    //   2744: dup
    //   2745: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   2748: aload 30
    //   2750: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2753: ldc_w 504
    //   2756: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2759: iload 12
    //   2761: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2764: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2767: astore 31
    //   2769: goto -387 -> 2382
    //   2772: aload_0
    //   2773: getfield 507	com/tencent/mobileqq/vip/DownloadTask:k	Z
    //   2776: ifeq +41 -> 2817
    //   2779: getstatic 510	com/tencent/qqsharpP/QQSharpPUtil:jdField_a_of_type_Boolean	Z
    //   2782: ifeq +35 -> 2817
    //   2785: invokestatic 511	com/tencent/qqsharpP/QQSharpPUtil:a	()Z
    //   2788: ifeq +29 -> 2817
    //   2791: aload 35
    //   2793: ldc_w 513
    //   2796: ldc_w 515
    //   2799: invokevirtual 498	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   2802: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2805: ifeq +12 -> 2817
    //   2808: ldc 73
    //   2810: iconst_2
    //   2811: ldc_w 517
    //   2814: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2817: aload_0
    //   2818: getfield 520	com/tencent/mobileqq/vip/DownloadTask:l	Z
    //   2821: ifeq +162 -> 2983
    //   2824: ldc_w 522
    //   2827: invokestatic 112	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2830: checkcast 522	com/tencent/mobileqq/dpc/api/IDPCApi
    //   2833: getstatic 528	com/tencent/mobileqq/dpc/enumname/DPCNames:AcceptType	Lcom/tencent/mobileqq/dpc/enumname/DPCNames;
    //   2836: invokevirtual 531	com/tencent/mobileqq/dpc/enumname/DPCNames:name	()Ljava/lang/String;
    //   2839: invokeinterface 534 2 0
    //   2844: astore 31
    //   2846: aload 31
    //   2848: invokestatic 263	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2851: ifne +1162 -> 4013
    //   2854: aload 31
    //   2856: invokestatic 538	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2859: iconst_1
    //   2860: iand
    //   2861: iconst_1
    //   2862: if_icmpne +1151 -> 4013
    //   2865: aload 35
    //   2867: ldc_w 513
    //   2870: ldc_w 540
    //   2873: invokevirtual 498	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   2876: ldc_w 542
    //   2879: iconst_3
    //   2880: anewarray 4	java/lang/Object
    //   2883: dup
    //   2884: iconst_0
    //   2885: getstatic 31	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_ArrayOfInt	[I
    //   2888: iconst_0
    //   2889: iaload
    //   2890: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2893: aastore
    //   2894: dup
    //   2895: iconst_1
    //   2896: getstatic 31	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_ArrayOfInt	[I
    //   2899: iconst_1
    //   2900: iaload
    //   2901: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2904: aastore
    //   2905: dup
    //   2906: iconst_2
    //   2907: getstatic 31	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_ArrayOfInt	[I
    //   2910: iconst_2
    //   2911: iaload
    //   2912: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2915: aastore
    //   2916: invokestatic 546	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2919: astore 31
    //   2921: aload 35
    //   2923: ldc_w 548
    //   2926: new 130	java/lang/StringBuilder
    //   2929: dup
    //   2930: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   2933: ldc_w 550
    //   2936: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2939: aload 31
    //   2941: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2944: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2947: invokevirtual 498	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   2950: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2953: ifeq +30 -> 2983
    //   2956: ldc 73
    //   2958: iconst_2
    //   2959: new 130	java/lang/StringBuilder
    //   2962: dup
    //   2963: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   2966: ldc_w 552
    //   2969: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2972: aload 30
    //   2974: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2977: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2980: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2983: aload 39
    //   2985: ifnull +80 -> 3065
    //   2988: aload 39
    //   2990: invokevirtual 306	java/io/File:exists	()Z
    //   2993: ifeq +72 -> 3065
    //   2996: aload 39
    //   2998: invokevirtual 555	java/io/File:length	()J
    //   3001: lstore 22
    //   3003: aload 35
    //   3005: ldc_w 557
    //   3008: new 130	java/lang/StringBuilder
    //   3011: dup
    //   3012: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   3015: ldc_w 559
    //   3018: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3021: lload 22
    //   3023: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3026: ldc_w 561
    //   3029: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3032: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3035: invokevirtual 498	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3038: aload 45
    //   3040: new 130	java/lang/StringBuilder
    //   3043: dup
    //   3044: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   3047: ldc_w 563
    //   3050: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3053: lload 22
    //   3055: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3058: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3061: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3064: pop
    //   3065: aload_0
    //   3066: getfield 566	com/tencent/mobileqq/vip/DownloadTask:m	Z
    //   3069: ifne +119 -> 3188
    //   3072: aload_0
    //   3073: getfield 569	com/tencent/mobileqq/vip/DownloadTask:j	Z
    //   3076: ifeq +112 -> 3188
    //   3079: aload 40
    //   3081: ifnull +107 -> 3188
    //   3084: aload 40
    //   3086: invokevirtual 306	java/io/File:exists	()Z
    //   3089: ifeq +99 -> 3188
    //   3092: aload_0
    //   3093: getfield 571	com/tencent/mobileqq/vip/DownloadTask:jdField_i_of_type_Long	J
    //   3096: lconst_0
    //   3097: lcmp
    //   3098: ifle +933 -> 4031
    //   3101: aload_0
    //   3102: getfield 571	com/tencent/mobileqq/vip/DownloadTask:jdField_i_of_type_Long	J
    //   3105: lstore 22
    //   3107: lload 22
    //   3109: lconst_0
    //   3110: lcmp
    //   3111: ifle +77 -> 3188
    //   3114: new 573	java/text/SimpleDateFormat
    //   3117: dup
    //   3118: ldc_w 575
    //   3121: getstatic 581	java/util/Locale:US	Ljava/util/Locale;
    //   3124: invokespecial 584	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   3127: astore 31
    //   3129: aload 31
    //   3131: ldc_w 586
    //   3134: invokestatic 592	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
    //   3137: invokevirtual 596	java/text/SimpleDateFormat:setTimeZone	(Ljava/util/TimeZone;)V
    //   3140: aload 31
    //   3142: new 598	java/util/Date
    //   3145: dup
    //   3146: lload 22
    //   3148: invokespecial 599	java/util/Date:<init>	(J)V
    //   3151: invokevirtual 602	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   3154: astore 31
    //   3156: aload 31
    //   3158: invokestatic 263	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3161: ifne +27 -> 3188
    //   3164: aload 35
    //   3166: ldc_w 604
    //   3169: aload 31
    //   3171: invokevirtual 498	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3174: aload 45
    //   3176: ldc_w 606
    //   3179: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3182: aload 31
    //   3184: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3187: pop
    //   3188: getstatic 22	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_Boolean	Z
    //   3191: ifeq +105 -> 3296
    //   3194: aload_0
    //   3195: getfield 462	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   3198: ifeq +98 -> 3296
    //   3201: aload_0
    //   3202: getfield 608	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   3205: ifeq +91 -> 3296
    //   3208: aload 41
    //   3210: getfield 386	com/tencent/mobileqq/emoticon/DownloadInfo:isHttps	Z
    //   3213: ifne +83 -> 3296
    //   3216: aload 41
    //   3218: invokestatic 611	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/emoticon/DownloadInfo;)V
    //   3221: aload 41
    //   3223: getfield 391	com/tencent/mobileqq/emoticon/DownloadInfo:isIPUrl	Z
    //   3226: ifeq +70 -> 3296
    //   3229: aload 35
    //   3231: new 613	java/net/URI
    //   3234: dup
    //   3235: aload 41
    //   3237: getfield 616	com/tencent/mobileqq/emoticon/DownloadInfo:reqUrl	Ljava/lang/String;
    //   3240: invokespecial 617	java/net/URI:<init>	(Ljava/lang/String;)V
    //   3243: invokevirtual 621	org/apache/http/client/methods/HttpGet:setURI	(Ljava/net/URI;)V
    //   3246: aload 35
    //   3248: ldc_w 623
    //   3251: aload 41
    //   3253: getfield 626	com/tencent/mobileqq/emoticon/DownloadInfo:host	Ljava/lang/String;
    //   3256: invokevirtual 498	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3259: aload 45
    //   3261: ldc_w 628
    //   3264: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3267: aload 41
    //   3269: getfield 626	com/tencent/mobileqq/emoticon/DownloadInfo:host	Ljava/lang/String;
    //   3272: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3275: ldc_w 630
    //   3278: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3281: aload 41
    //   3283: getfield 633	com/tencent/mobileqq/emoticon/DownloadInfo:ip	Ljava/lang/String;
    //   3286: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3289: ldc_w 635
    //   3292: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3295: pop
    //   3296: aload 37
    //   3298: invokevirtual 640	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   3301: invokestatic 645	com/tencent/mobileqq/utils/httputils/PkgTools:getApnType	(Ljava/lang/String;)Ljava/lang/String;
    //   3304: astore 31
    //   3306: aload 31
    //   3308: aload_0
    //   3309: getfield 647	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3312: invokevirtual 651	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3315: ifne +14 -> 3329
    //   3318: aload_0
    //   3319: iconst_0
    //   3320: putfield 350	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Boolean	Z
    //   3323: aload_0
    //   3324: aload 31
    //   3326: putfield 647	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3329: aload 37
    //   3331: invokestatic 656	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   3334: ifeq +707 -> 4041
    //   3337: aload_0
    //   3338: getfield 350	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Boolean	Z
    //   3341: ifne +4166 -> 7507
    //   3344: invokestatic 661	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   3347: astore 31
    //   3349: invokestatic 664	android/net/Proxy:getDefaultPort	()I
    //   3352: istore 7
    //   3354: aload 31
    //   3356: ifnull +4148 -> 7504
    //   3359: iload 7
    //   3361: ifle +4143 -> 7504
    //   3364: aload 43
    //   3366: ldc_w 666
    //   3369: new 668	org/apache/http/HttpHost
    //   3372: dup
    //   3373: aload 31
    //   3375: iload 7
    //   3377: invokespecial 671	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   3380: invokeinterface 161 3 0
    //   3385: pop
    //   3386: iconst_1
    //   3387: istore 6
    //   3389: aload 45
    //   3391: ldc_w 673
    //   3394: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3397: iconst_1
    //   3398: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3401: ldc_w 675
    //   3404: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3407: aload 31
    //   3409: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3412: ldc_w 677
    //   3415: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3418: iload 7
    //   3420: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3423: pop
    //   3424: iload_3
    //   3425: istore 8
    //   3427: iload 6
    //   3429: istore_3
    //   3430: iload 4
    //   3432: istore 7
    //   3434: iload 15
    //   3436: istore 13
    //   3438: aload_0
    //   3439: getfield 288	com/tencent/mobileqq/vip/DownloadTask:p	Z
    //   3442: ifne +34 -> 3476
    //   3445: iload 4
    //   3447: istore 7
    //   3449: iload 15
    //   3451: istore 13
    //   3453: invokestatic 52	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3456: invokestatic 680	com/tencent/mobileqq/utils/NetworkUtil:h	(Landroid/content/Context;)Z
    //   3459: ifeq +17 -> 3476
    //   3462: iload 4
    //   3464: istore 7
    //   3466: iload 15
    //   3468: istore 13
    //   3470: aload 43
    //   3472: iconst_0
    //   3473: invokestatic 686	org/apache/http/client/params/HttpClientParams:setRedirecting	(Lorg/apache/http/params/HttpParams;Z)V
    //   3476: iload 4
    //   3478: istore 7
    //   3480: iload 15
    //   3482: istore 13
    //   3484: aload 43
    //   3486: ldc_w 688
    //   3489: iload 8
    //   3491: invokeinterface 692 3 0
    //   3496: pop
    //   3497: iload 4
    //   3499: istore 7
    //   3501: iload 15
    //   3503: istore 13
    //   3505: aload 35
    //   3507: aload 43
    //   3509: invokevirtual 696	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   3512: iload 4
    //   3514: istore 7
    //   3516: iload 15
    //   3518: istore 13
    //   3520: aload_0
    //   3521: getfield 169	com/tencent/mobileqq/vip/DownloadTask:n	Z
    //   3524: ifeq +527 -> 4051
    //   3527: ldc 171
    //   3529: astore 31
    //   3531: iload 4
    //   3533: istore 7
    //   3535: iload 15
    //   3537: istore 13
    //   3539: aload 35
    //   3541: ldc 173
    //   3543: aload 31
    //   3545: invokevirtual 699	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3548: iload 4
    //   3550: istore 7
    //   3552: iload 15
    //   3554: istore 13
    //   3556: ldc_w 700
    //   3559: invokestatic 704	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   3562: iload 4
    //   3564: istore 7
    //   3566: iload 15
    //   3568: istore 13
    //   3570: getstatic 710	com/tencent/mobileqq/utils/HttpDownloadUtil:client	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   3573: aload 35
    //   3575: invokevirtual 716	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   3578: astore 48
    //   3580: iconst_1
    //   3581: istore 16
    //   3583: iconst_1
    //   3584: istore 17
    //   3586: iconst_1
    //   3587: istore 15
    //   3589: iload 4
    //   3591: istore 7
    //   3593: iload 17
    //   3595: istore 13
    //   3597: aload 48
    //   3599: invokeinterface 722 1 0
    //   3604: invokeinterface 727 1 0
    //   3609: istore 6
    //   3611: iload 4
    //   3613: istore 7
    //   3615: iload 17
    //   3617: istore 13
    //   3619: aload_0
    //   3620: iload 6
    //   3622: putfield 452	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Int	I
    //   3625: iload 4
    //   3627: istore 7
    //   3629: iload 17
    //   3631: istore 13
    //   3633: aload 41
    //   3635: iload 6
    //   3637: putfield 730	com/tencent/mobileqq/emoticon/DownloadInfo:httpRespCode	I
    //   3640: iload 4
    //   3642: istore 7
    //   3644: iload 17
    //   3646: istore 13
    //   3648: aload 45
    //   3650: ldc_w 732
    //   3653: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3656: aload 35
    //   3658: invokevirtual 736	org/apache/http/client/methods/HttpGet:getURI	()Ljava/net/URI;
    //   3661: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3664: ldc_w 738
    //   3667: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3670: iload 6
    //   3672: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3675: ldc_w 740
    //   3678: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3681: pop
    //   3682: iload 4
    //   3684: istore 7
    //   3686: iload 17
    //   3688: istore 13
    //   3690: aload 48
    //   3692: invokeinterface 744 1 0
    //   3697: astore 31
    //   3699: iload 4
    //   3701: istore 7
    //   3703: iload 17
    //   3705: istore 13
    //   3707: aload 31
    //   3709: invokeinterface 747 1 0
    //   3714: ifeq +3874 -> 7588
    //   3717: iload 4
    //   3719: istore 7
    //   3721: iload 17
    //   3723: istore 13
    //   3725: aload 31
    //   3727: invokeinterface 751 1 0
    //   3732: astore 35
    //   3734: iload 4
    //   3736: istore 7
    //   3738: iload 17
    //   3740: istore 13
    //   3742: aload 35
    //   3744: invokeinterface 754 1 0
    //   3749: astore 36
    //   3751: iload 4
    //   3753: istore 7
    //   3755: iload 17
    //   3757: istore 13
    //   3759: ldc_w 756
    //   3762: aload 36
    //   3764: invokevirtual 759	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3767: ifne +174 -> 3941
    //   3770: iload 4
    //   3772: istore 7
    //   3774: iload 17
    //   3776: istore 13
    //   3778: ldc_w 761
    //   3781: aload 36
    //   3783: invokevirtual 759	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3786: ifne +155 -> 3941
    //   3789: iload 4
    //   3791: istore 7
    //   3793: iload 17
    //   3795: istore 13
    //   3797: ldc_w 763
    //   3800: aload 36
    //   3802: invokevirtual 759	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3805: ifne +136 -> 3941
    //   3808: iload 4
    //   3810: istore 7
    //   3812: iload 17
    //   3814: istore 13
    //   3816: ldc_w 765
    //   3819: aload 36
    //   3821: invokevirtual 759	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3824: ifne +117 -> 3941
    //   3827: iload 4
    //   3829: istore 7
    //   3831: iload 17
    //   3833: istore 13
    //   3835: ldc_w 767
    //   3838: aload 36
    //   3840: invokevirtual 759	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3843: ifne +98 -> 3941
    //   3846: iload 4
    //   3848: istore 7
    //   3850: iload 17
    //   3852: istore 13
    //   3854: ldc_w 769
    //   3857: aload 36
    //   3859: invokevirtual 759	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3862: ifne +79 -> 3941
    //   3865: iload 4
    //   3867: istore 7
    //   3869: iload 17
    //   3871: istore 13
    //   3873: ldc_w 771
    //   3876: aload 36
    //   3878: invokevirtual 759	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3881: ifne +60 -> 3941
    //   3884: iload 4
    //   3886: istore 7
    //   3888: iload 17
    //   3890: istore 13
    //   3892: ldc_w 773
    //   3895: aload 36
    //   3897: invokevirtual 759	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3900: ifne +41 -> 3941
    //   3903: iload 4
    //   3905: istore 7
    //   3907: iload 17
    //   3909: istore 13
    //   3911: ldc_w 775
    //   3914: aload 36
    //   3916: invokevirtual 759	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3919: ifne +22 -> 3941
    //   3922: iload 4
    //   3924: istore 7
    //   3926: iload 17
    //   3928: istore 13
    //   3930: ldc_w 777
    //   3933: aload 36
    //   3935: invokevirtual 759	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3938: ifeq -239 -> 3699
    //   3941: iload 4
    //   3943: istore 7
    //   3945: iload 17
    //   3947: istore 13
    //   3949: aload 45
    //   3951: ldc_w 500
    //   3954: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3957: aload 36
    //   3959: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3962: ldc_w 779
    //   3965: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3968: aload 35
    //   3970: invokeinterface 782 1 0
    //   3975: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3978: pop
    //   3979: goto -280 -> 3699
    //   3982: astore 35
    //   3984: iload_3
    //   3985: istore 4
    //   3987: aload 33
    //   3989: astore 31
    //   3991: aload 34
    //   3993: astore 33
    //   3995: iload 5
    //   3997: istore_3
    //   3998: aload 35
    //   4000: astore 34
    //   4002: iload 4
    //   4004: istore 5
    //   4006: iload 7
    //   4008: istore 4
    //   4010: goto -2936 -> 1074
    //   4013: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4016: ifeq -1033 -> 2983
    //   4019: ldc 73
    //   4021: iconst_2
    //   4022: ldc_w 784
    //   4025: invokestatic 787	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4028: goto -1045 -> 2983
    //   4031: aload 40
    //   4033: invokevirtual 790	java/io/File:lastModified	()J
    //   4036: lstore 22
    //   4038: goto -931 -> 3107
    //   4041: sipush 4096
    //   4044: istore 8
    //   4046: iconst_0
    //   4047: istore_3
    //   4048: goto -618 -> 3430
    //   4051: ldc_w 792
    //   4054: astore 31
    //   4056: goto -525 -> 3531
    //   4059: iload 4
    //   4061: istore 7
    //   4063: iload 17
    //   4065: istore 13
    //   4067: aload 48
    //   4069: invokeinterface 796 1 0
    //   4074: astore 31
    //   4076: aload 31
    //   4078: invokeinterface 801 1 0
    //   4083: lstore 24
    //   4085: lload 24
    //   4087: lstore 22
    //   4089: iload 4
    //   4091: istore 6
    //   4093: aload 45
    //   4095: ldc_w 803
    //   4098: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4101: lload 24
    //   4103: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4106: pop
    //   4107: lload 24
    //   4109: lstore 22
    //   4111: iload 4
    //   4113: istore 6
    //   4115: aload 48
    //   4117: ldc_w 805
    //   4120: invokeinterface 809 2 0
    //   4125: astore 34
    //   4127: lload 24
    //   4129: lstore 22
    //   4131: iload 4
    //   4133: istore 6
    //   4135: aload 48
    //   4137: ldc_w 763
    //   4140: invokeinterface 809 2 0
    //   4145: astore 35
    //   4147: aload 34
    //   4149: ifnull +239 -> 4388
    //   4152: lload 24
    //   4154: lstore 22
    //   4156: iload 4
    //   4158: istore 6
    //   4160: aload 34
    //   4162: invokeinterface 782 1 0
    //   4167: ldc_w 811
    //   4170: invokevirtual 815	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   4173: iconst_1
    //   4174: aaload
    //   4175: invokestatic 538	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   4178: i2l
    //   4179: lstore 18
    //   4181: lload 18
    //   4183: lstore 22
    //   4185: iload 4
    //   4187: istore 6
    //   4189: aload 39
    //   4191: invokevirtual 555	java/io/File:length	()J
    //   4194: lstore 24
    //   4196: lload 18
    //   4198: lstore 22
    //   4200: iload 4
    //   4202: istore 6
    //   4204: aload 45
    //   4206: ldc_w 817
    //   4209: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4212: lload 18
    //   4214: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4217: ldc_w 819
    //   4220: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4223: lload 24
    //   4225: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4228: pop
    //   4229: lload 18
    //   4231: lstore 22
    //   4233: iload 4
    //   4235: istore 6
    //   4237: aload_0
    //   4238: getfield 821	com/tencent/mobileqq/vip/DownloadTask:jdField_g_of_type_Boolean	Z
    //   4241: ifne +10 -> 4251
    //   4244: lload 18
    //   4246: lconst_1
    //   4247: lcmp
    //   4248: iflt +38 -> 4286
    //   4251: lload 18
    //   4253: lstore 22
    //   4255: iload 4
    //   4257: istore 6
    //   4259: aload_0
    //   4260: getfield 823	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Long	J
    //   4263: lconst_0
    //   4264: lcmp
    //   4265: ifle +156 -> 4421
    //   4268: lload 18
    //   4270: lstore 22
    //   4272: iload 4
    //   4274: istore 6
    //   4276: lload 18
    //   4278: aload_0
    //   4279: getfield 823	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Long	J
    //   4282: lcmp
    //   4283: ifle +138 -> 4421
    //   4286: iconst_1
    //   4287: istore 6
    //   4289: iconst_1
    //   4290: istore 12
    //   4292: bipush 138
    //   4294: istore 7
    //   4296: lload 18
    //   4298: lstore 22
    //   4300: aload_0
    //   4301: bipush 138
    //   4303: putfield 125	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   4306: iload 12
    //   4308: istore 4
    //   4310: iload 7
    //   4312: istore 5
    //   4314: iload 7
    //   4316: istore 6
    //   4318: aload 45
    //   4320: ldc_w 825
    //   4323: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4326: aload_0
    //   4327: getfield 823	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Long	J
    //   4330: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4333: pop
    //   4334: iload 12
    //   4336: istore 4
    //   4338: iload 7
    //   4340: istore 5
    //   4342: iload 7
    //   4344: istore 6
    //   4346: new 332	java/lang/Exception
    //   4349: dup
    //   4350: ldc_w 827
    //   4353: invokespecial 335	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   4356: athrow
    //   4357: astore 34
    //   4359: iload 5
    //   4361: istore 6
    //   4363: aload 33
    //   4365: astore 35
    //   4367: aload 31
    //   4369: astore 33
    //   4371: iload_3
    //   4372: istore 5
    //   4374: iload 15
    //   4376: istore 13
    //   4378: aload 35
    //   4380: astore 31
    //   4382: iload 6
    //   4384: istore_3
    //   4385: goto -3311 -> 1074
    //   4388: lload 24
    //   4390: lstore 18
    //   4392: aload 35
    //   4394: ifnull -213 -> 4181
    //   4397: lload 24
    //   4399: lstore 22
    //   4401: iload 4
    //   4403: istore 6
    //   4405: aload 35
    //   4407: invokeinterface 782 1 0
    //   4412: invokestatic 538	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   4415: i2l
    //   4416: lstore 18
    //   4418: goto -237 -> 4181
    //   4421: lconst_0
    //   4422: lload 24
    //   4424: lcmp
    //   4425: ifeq +74 -> 4499
    //   4428: lload 24
    //   4430: lload 18
    //   4432: lcmp
    //   4433: iflt +66 -> 4499
    //   4436: lload 18
    //   4438: lstore 22
    //   4440: iload 4
    //   4442: istore 6
    //   4444: aload 39
    //   4446: invokevirtual 312	java/io/File:delete	()Z
    //   4449: pop
    //   4450: bipush 139
    //   4452: istore 7
    //   4454: lload 18
    //   4456: lstore 22
    //   4458: iload 4
    //   4460: istore 6
    //   4462: aload_0
    //   4463: bipush 139
    //   4465: putfield 125	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   4468: iload 7
    //   4470: istore 5
    //   4472: iload 7
    //   4474: istore 6
    //   4476: new 332	java/lang/Exception
    //   4479: dup
    //   4480: ldc_w 829
    //   4483: invokespecial 335	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   4486: athrow
    //   4487: astore_1
    //   4488: iload 6
    //   4490: istore 5
    //   4492: aload 31
    //   4494: astore 34
    //   4496: goto -2543 -> 1953
    //   4499: lload 24
    //   4501: lconst_0
    //   4502: lcmp
    //   4503: ifeq +335 -> 4838
    //   4506: iconst_1
    //   4507: istore 13
    //   4509: lload 18
    //   4511: lstore 22
    //   4513: iload 4
    //   4515: istore 6
    //   4517: new 831	java/io/BufferedOutputStream
    //   4520: dup
    //   4521: new 833	java/io/FileOutputStream
    //   4524: dup
    //   4525: aload 39
    //   4527: iload 13
    //   4529: invokespecial 836	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   4532: invokespecial 839	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   4535: astore 34
    //   4537: aload 48
    //   4539: ldc_w 775
    //   4542: invokeinterface 809 2 0
    //   4547: ifnull +297 -> 4844
    //   4550: ldc 171
    //   4552: aload 48
    //   4554: ldc_w 775
    //   4557: invokeinterface 809 2 0
    //   4562: invokeinterface 782 1 0
    //   4567: invokevirtual 651	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4570: ifeq +274 -> 4844
    //   4573: new 841	java/util/zip/GZIPInputStream
    //   4576: dup
    //   4577: aload 31
    //   4579: invokeinterface 845 1 0
    //   4584: invokespecial 848	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   4587: astore 33
    //   4589: aload 45
    //   4591: ldc_w 850
    //   4594: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4597: pop
    //   4598: aload 33
    //   4600: astore 32
    //   4602: invokestatic 856	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   4605: iload 8
    //   4607: invokevirtual 860	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   4610: astore 36
    //   4612: iconst_0
    //   4613: istore 6
    //   4615: lload 20
    //   4617: lstore 22
    //   4619: aload_0
    //   4620: invokevirtual 398	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   4623: ifne +326 -> 4949
    //   4626: lload 20
    //   4628: lstore 22
    //   4630: aload 32
    //   4632: aload 36
    //   4634: invokevirtual 866	java/io/InputStream:read	([B)I
    //   4637: istore 7
    //   4639: iload 7
    //   4641: iconst_m1
    //   4642: if_icmpeq +307 -> 4949
    //   4645: lload 20
    //   4647: lstore 22
    //   4649: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4652: ifeq +64 -> 4716
    //   4655: lconst_0
    //   4656: lload 24
    //   4658: lcmp
    //   4659: ifne +57 -> 4716
    //   4662: aconst_null
    //   4663: astore 35
    //   4665: iload 7
    //   4667: iconst_4
    //   4668: if_icmple +192 -> 4860
    //   4671: iconst_m1
    //   4672: aload 36
    //   4674: iconst_0
    //   4675: baload
    //   4676: if_icmpne +184 -> 4860
    //   4679: bipush 216
    //   4681: aload 36
    //   4683: iconst_1
    //   4684: baload
    //   4685: if_icmpne +175 -> 4860
    //   4688: ldc_w 868
    //   4691: astore 33
    //   4693: aload 33
    //   4695: ifnull +21 -> 4716
    //   4698: lload 20
    //   4700: lstore 22
    //   4702: aload 45
    //   4704: ldc_w 870
    //   4707: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4710: aload 33
    //   4712: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4715: pop
    //   4716: lload 20
    //   4718: lstore 22
    //   4720: aload 34
    //   4722: aload 36
    //   4724: iconst_0
    //   4725: iload 7
    //   4727: invokevirtual 874	java/io/BufferedOutputStream:write	([BII)V
    //   4730: lload 24
    //   4732: iload 7
    //   4734: i2l
    //   4735: ladd
    //   4736: lstore 24
    //   4738: lload 20
    //   4740: iload 7
    //   4742: i2l
    //   4743: ladd
    //   4744: lstore 20
    //   4746: iload 6
    //   4748: iload 7
    //   4750: iadd
    //   4751: istore 6
    //   4753: lload 18
    //   4755: lconst_0
    //   4756: lcmp
    //   4757: ifle +2744 -> 7501
    //   4760: lload 20
    //   4762: lstore 22
    //   4764: aload_0
    //   4765: getfield 876	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Long	J
    //   4768: lconst_0
    //   4769: lcmp
    //   4770: ifne +17 -> 4787
    //   4773: lload 20
    //   4775: lstore 22
    //   4777: aload_0
    //   4778: lload 18
    //   4780: ldc2_w 877
    //   4783: ldiv
    //   4784: putfield 876	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Long	J
    //   4787: lload 20
    //   4789: lstore 22
    //   4791: iload 6
    //   4793: i2l
    //   4794: aload_0
    //   4795: getfield 876	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Long	J
    //   4798: lcmp
    //   4799: ifge +11 -> 4810
    //   4802: lload 24
    //   4804: lload 18
    //   4806: lcmp
    //   4807: iflt +2694 -> 7501
    //   4810: lload 20
    //   4812: lstore 22
    //   4814: aload_0
    //   4815: lload 18
    //   4817: lload 24
    //   4819: iload 10
    //   4821: invokevirtual 881	com/tencent/mobileqq/vip/DownloadTask:a	(JJI)V
    //   4824: lload 20
    //   4826: lstore 22
    //   4828: aload_0
    //   4829: invokevirtual 883	com/tencent/mobileqq/vip/DownloadTask:b	()V
    //   4832: iconst_0
    //   4833: istore 6
    //   4835: goto -220 -> 4615
    //   4838: iconst_0
    //   4839: istore 13
    //   4841: goto -332 -> 4509
    //   4844: aload 31
    //   4846: invokeinterface 845 1 0
    //   4851: astore 33
    //   4853: aload 33
    //   4855: astore 32
    //   4857: goto -255 -> 4602
    //   4860: iload 7
    //   4862: bipush 8
    //   4864: if_icmple +2743 -> 7607
    //   4867: bipush 137
    //   4869: aload 36
    //   4871: iconst_0
    //   4872: baload
    //   4873: if_icmpne +2734 -> 7607
    //   4876: bipush 80
    //   4878: aload 36
    //   4880: iconst_1
    //   4881: baload
    //   4882: if_icmpne +2725 -> 7607
    //   4885: bipush 78
    //   4887: aload 36
    //   4889: iconst_2
    //   4890: baload
    //   4891: if_icmpne +2716 -> 7607
    //   4894: bipush 71
    //   4896: aload 36
    //   4898: iconst_3
    //   4899: baload
    //   4900: if_icmpne +2707 -> 7607
    //   4903: bipush 13
    //   4905: aload 36
    //   4907: iconst_4
    //   4908: baload
    //   4909: if_icmpne +2698 -> 7607
    //   4912: bipush 10
    //   4914: aload 36
    //   4916: iconst_5
    //   4917: baload
    //   4918: if_icmpne +2689 -> 7607
    //   4921: bipush 26
    //   4923: aload 36
    //   4925: bipush 6
    //   4927: baload
    //   4928: if_icmpne +2679 -> 7607
    //   4931: bipush 10
    //   4933: aload 36
    //   4935: bipush 7
    //   4937: baload
    //   4938: if_icmpne +2669 -> 7607
    //   4941: ldc_w 885
    //   4944: astore 33
    //   4946: goto -253 -> 4693
    //   4949: lload 20
    //   4951: lstore 22
    //   4953: aload 34
    //   4955: invokevirtual 888	java/io/BufferedOutputStream:flush	()V
    //   4958: lload 20
    //   4960: lstore 22
    //   4962: invokestatic 856	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   4965: aload 36
    //   4967: invokevirtual 892	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   4970: lload 20
    //   4972: lstore 22
    //   4974: aload 39
    //   4976: invokevirtual 555	java/io/File:length	()J
    //   4979: lstore 24
    //   4981: lload 20
    //   4983: lstore 22
    //   4985: aload 45
    //   4987: ldc_w 894
    //   4990: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4993: lload 24
    //   4995: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4998: pop
    //   4999: lload 24
    //   5001: lload 18
    //   5003: lcmp
    //   5004: ifeq +80 -> 5084
    //   5007: lload 18
    //   5009: lconst_1
    //   5010: lcmp
    //   5011: ifge +21 -> 5032
    //   5014: lload 20
    //   5016: lstore 22
    //   5018: aload_0
    //   5019: getfield 821	com/tencent/mobileqq/vip/DownloadTask:jdField_g_of_type_Boolean	Z
    //   5022: ifeq +10 -> 5032
    //   5025: lload 24
    //   5027: lconst_0
    //   5028: lcmp
    //   5029: ifgt +55 -> 5084
    //   5032: lload 20
    //   5034: lstore 22
    //   5036: aload 48
    //   5038: ldc_w 775
    //   5041: invokeinterface 809 2 0
    //   5046: ifnull +704 -> 5750
    //   5049: lload 20
    //   5051: lstore 22
    //   5053: ldc 171
    //   5055: aload 48
    //   5057: ldc_w 775
    //   5060: invokeinterface 809 2 0
    //   5065: invokeinterface 782 1 0
    //   5070: invokevirtual 651	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5073: ifeq +677 -> 5750
    //   5076: lload 24
    //   5078: lload 18
    //   5080: lcmp
    //   5081: iflt +669 -> 5750
    //   5084: lload 20
    //   5086: lstore 22
    //   5088: aload_0
    //   5089: iconst_0
    //   5090: putfield 125	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   5093: aload 40
    //   5095: invokevirtual 306	java/io/File:exists	()Z
    //   5098: ifeq +9 -> 5107
    //   5101: aload 40
    //   5103: invokevirtual 312	java/io/File:delete	()Z
    //   5106: pop
    //   5107: aload 39
    //   5109: aload 40
    //   5111: invokevirtual 898	java/io/File:renameTo	(Ljava/io/File;)Z
    //   5114: istore 13
    //   5116: aload 45
    //   5118: ldc_w 900
    //   5121: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5124: iload 13
    //   5126: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5129: pop
    //   5130: aload_0
    //   5131: aload 40
    //   5133: aload 48
    //   5135: invokestatic 903	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Ljava/io/File;Lorg/apache/http/HttpResponse;)V
    //   5138: iconst_0
    //   5139: istore 6
    //   5141: iload 4
    //   5143: istore 5
    //   5145: iload 6
    //   5147: istore 4
    //   5149: iload 4
    //   5151: istore 6
    //   5153: aload 31
    //   5155: astore 33
    //   5157: aload 34
    //   5159: astore 31
    //   5161: iload 5
    //   5163: istore 4
    //   5165: iload 4
    //   5167: istore 5
    //   5169: aload 30
    //   5171: astore 38
    //   5173: aload 31
    //   5175: astore 35
    //   5177: aload 32
    //   5179: astore 37
    //   5181: aload 33
    //   5183: astore 36
    //   5185: iload 6
    //   5187: istore 7
    //   5189: getstatic 24	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   5192: ifnonnull +37 -> 5229
    //   5195: iload 4
    //   5197: istore 5
    //   5199: aload 30
    //   5201: astore 38
    //   5203: aload 31
    //   5205: astore 35
    //   5207: aload 32
    //   5209: astore 37
    //   5211: aload 33
    //   5213: astore 36
    //   5215: iload 6
    //   5217: istore 7
    //   5219: new 43	java/util/concurrent/ConcurrentHashMap
    //   5222: dup
    //   5223: invokespecial 44	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   5226: putstatic 24	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   5229: iload 6
    //   5231: ifeq +1197 -> 6428
    //   5234: iload 4
    //   5236: istore 5
    //   5238: aload 30
    //   5240: astore 38
    //   5242: aload 31
    //   5244: astore 35
    //   5246: aload 32
    //   5248: astore 37
    //   5250: aload 33
    //   5252: astore 36
    //   5254: iload 6
    //   5256: istore 7
    //   5258: aload_0
    //   5259: invokevirtual 398	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   5262: ifne +1166 -> 6428
    //   5265: iload 4
    //   5267: istore 5
    //   5269: aload 30
    //   5271: astore 38
    //   5273: aload 31
    //   5275: astore 35
    //   5277: aload 32
    //   5279: astore 37
    //   5281: aload 33
    //   5283: astore 36
    //   5285: iload 6
    //   5287: istore 7
    //   5289: iload 11
    //   5291: aload_0
    //   5292: getfield 292	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_Int	I
    //   5295: if_icmpge +950 -> 6245
    //   5298: iload 4
    //   5300: istore 5
    //   5302: aload 30
    //   5304: astore 38
    //   5306: aload 31
    //   5308: astore 35
    //   5310: aload 32
    //   5312: astore 37
    //   5314: aload 33
    //   5316: astore 36
    //   5318: iload 6
    //   5320: istore 7
    //   5322: aload 46
    //   5324: monitorenter
    //   5325: sipush 2000
    //   5328: i2l
    //   5329: lstore 22
    //   5331: aload 46
    //   5333: lload 22
    //   5335: invokevirtual 906	java/lang/Object:wait	(J)V
    //   5338: aload 46
    //   5340: monitorexit
    //   5341: iload 4
    //   5343: istore 5
    //   5345: aload 30
    //   5347: astore 38
    //   5349: aload 31
    //   5351: astore 35
    //   5353: aload 32
    //   5355: astore 37
    //   5357: aload 33
    //   5359: astore 36
    //   5361: iload 6
    //   5363: istore 7
    //   5365: aload_0
    //   5366: getfield 125	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   5369: sipush 302
    //   5372: if_icmpne +84 -> 5456
    //   5375: iload 4
    //   5377: istore 5
    //   5379: aload 30
    //   5381: astore 38
    //   5383: aload 31
    //   5385: astore 35
    //   5387: aload 32
    //   5389: astore 37
    //   5391: aload 33
    //   5393: astore 36
    //   5395: iload 6
    //   5397: istore 7
    //   5399: aload 48
    //   5401: ldc_w 769
    //   5404: invokeinterface 809 2 0
    //   5409: astore 34
    //   5411: aload 34
    //   5413: ifnull +43 -> 5456
    //   5416: iload 4
    //   5418: istore 5
    //   5420: aload 30
    //   5422: astore 38
    //   5424: aload 31
    //   5426: astore 35
    //   5428: aload 32
    //   5430: astore 37
    //   5432: aload 33
    //   5434: astore 36
    //   5436: iload 6
    //   5438: istore 7
    //   5440: aload 44
    //   5442: ldc_w 908
    //   5445: aload 34
    //   5447: invokeinterface 782 1 0
    //   5452: invokevirtual 912	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   5455: pop
    //   5456: iload 6
    //   5458: istore 7
    //   5460: invokestatic 371	android/net/TrafficStats:clearThreadStatsTag	()V
    //   5463: iload 6
    //   5465: istore 7
    //   5467: ldc 73
    //   5469: iconst_1
    //   5470: new 130	java/lang/StringBuilder
    //   5473: dup
    //   5474: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   5477: aload 45
    //   5479: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5482: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5485: ldc_w 373
    //   5488: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5491: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   5494: lload 28
    //   5496: lsub
    //   5497: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5500: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5503: invokestatic 376	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5506: iload 6
    //   5508: istore 7
    //   5510: aload_0
    //   5511: getfield 210	com/tencent/mobileqq/vip/DownloadTask:jdField_g_of_type_Int	I
    //   5514: iconst_3
    //   5515: if_icmpne +74 -> 5589
    //   5518: iload 14
    //   5520: ifeq +69 -> 5589
    //   5523: iload 6
    //   5525: istore 7
    //   5527: ldc 212
    //   5529: invokestatic 112	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   5532: checkcast 212	com/tencent/mobileqq/apollo/api/statistics/trace/ITraceReportHelper
    //   5535: bipush 30
    //   5537: aload_0
    //   5538: getfield 207	com/tencent/mobileqq/vip/DownloadTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   5541: sipush 300
    //   5544: iconst_1
    //   5545: anewarray 4	java/lang/Object
    //   5548: dup
    //   5549: iconst_0
    //   5550: new 130	java/lang/StringBuilder
    //   5553: dup
    //   5554: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   5557: aload 45
    //   5559: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5562: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5565: ldc_w 373
    //   5568: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5571: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   5574: lload 28
    //   5576: lsub
    //   5577: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5580: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5583: aastore
    //   5584: invokeinterface 380 5 0
    //   5589: iload 6
    //   5591: istore 7
    //   5593: aload_0
    //   5594: aload_2
    //   5595: iload 6
    //   5597: aload 40
    //   5599: aload 41
    //   5601: invokestatic 383	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Landroid/content/Context;ILjava/io/File;Lcom/tencent/mobileqq/emoticon/DownloadInfo;)V
    //   5604: iload 6
    //   5606: istore 7
    //   5608: new 130	java/lang/StringBuilder
    //   5611: dup
    //   5612: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   5615: astore 35
    //   5617: iload 6
    //   5619: istore 7
    //   5621: aload 41
    //   5623: getfield 386	com/tencent/mobileqq/emoticon/DownloadInfo:isHttps	Z
    //   5626: ifeq +840 -> 6466
    //   5629: ldc_w 388
    //   5632: astore 34
    //   5634: iload 6
    //   5636: istore 7
    //   5638: aload 35
    //   5640: aload 34
    //   5642: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5645: astore 35
    //   5647: iload 6
    //   5649: istore 7
    //   5651: aload 41
    //   5653: getfield 391	com/tencent/mobileqq/emoticon/DownloadInfo:isIPUrl	Z
    //   5656: ifeq +818 -> 6474
    //   5659: ldc_w 393
    //   5662: astore 34
    //   5664: iload 6
    //   5666: istore 7
    //   5668: aload 35
    //   5670: aload 34
    //   5672: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5675: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5678: astore 36
    //   5680: iload 6
    //   5682: istore 7
    //   5684: aload 33
    //   5686: aload 32
    //   5688: aload 31
    //   5690: aload 30
    //   5692: invokestatic 396	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lorg/apache/http/HttpEntity;Ljava/io/InputStream;Ljava/io/BufferedOutputStream;Ljava/lang/String;)V
    //   5695: iload 11
    //   5697: iconst_1
    //   5698: iadd
    //   5699: istore 5
    //   5701: aload 30
    //   5703: astore 35
    //   5705: aload 32
    //   5707: astore 30
    //   5709: aload 33
    //   5711: astore 34
    //   5713: iload 4
    //   5715: istore 7
    //   5717: aload 35
    //   5719: astore 32
    //   5721: iload 8
    //   5723: istore 4
    //   5725: aload 31
    //   5727: astore 33
    //   5729: aload 34
    //   5731: astore 31
    //   5733: iload_3
    //   5734: istore 8
    //   5736: iload 16
    //   5738: istore 13
    //   5740: iload 6
    //   5742: istore_3
    //   5743: aload 36
    //   5745: astore 34
    //   5747: goto -4104 -> 1643
    //   5750: lload 20
    //   5752: lstore 22
    //   5754: aload_0
    //   5755: invokevirtual 398	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   5758: istore 13
    //   5760: iload 13
    //   5762: ifeq +78 -> 5840
    //   5765: iconst_1
    //   5766: istore 6
    //   5768: bipush 150
    //   5770: istore 4
    //   5772: aload_0
    //   5773: bipush 150
    //   5775: putfield 125	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   5778: iload 4
    //   5780: istore 5
    //   5782: aload 45
    //   5784: ldc_w 914
    //   5787: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5790: pop
    //   5791: iload 6
    //   5793: istore 5
    //   5795: goto -646 -> 5149
    //   5798: astore 36
    //   5800: iconst_1
    //   5801: istore 4
    //   5803: aload 34
    //   5805: astore 33
    //   5807: aload 31
    //   5809: astore 35
    //   5811: bipush 150
    //   5813: istore 6
    //   5815: aload 36
    //   5817: astore 34
    //   5819: iload_3
    //   5820: istore 5
    //   5822: iload 15
    //   5824: istore 13
    //   5826: aload 33
    //   5828: astore 31
    //   5830: aload 35
    //   5832: astore 33
    //   5834: iload 6
    //   5836: istore_3
    //   5837: goto -4763 -> 1074
    //   5840: bipush 151
    //   5842: istore 6
    //   5844: lload 20
    //   5846: lstore 22
    //   5848: aload_0
    //   5849: bipush 151
    //   5851: putfield 125	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   5854: iload 6
    //   5856: istore 5
    //   5858: aload 39
    //   5860: invokevirtual 312	java/io/File:delete	()Z
    //   5863: pop
    //   5864: iload 6
    //   5866: istore 5
    //   5868: new 332	java/lang/Exception
    //   5871: dup
    //   5872: ldc_w 916
    //   5875: invokespecial 335	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   5878: athrow
    //   5879: astore 36
    //   5881: aload 34
    //   5883: astore 33
    //   5885: aload 31
    //   5887: astore 35
    //   5889: bipush 151
    //   5891: istore 6
    //   5893: aload 36
    //   5895: astore 34
    //   5897: iload_3
    //   5898: istore 5
    //   5900: iload 15
    //   5902: istore 13
    //   5904: aload 33
    //   5906: astore 31
    //   5908: aload 35
    //   5910: astore 33
    //   5912: iload 6
    //   5914: istore_3
    //   5915: goto -4841 -> 1074
    //   5918: sipush 404
    //   5921: iload 6
    //   5923: if_icmpne +1811 -> 7734
    //   5926: iconst_1
    //   5927: istore 7
    //   5929: iload 17
    //   5931: istore 13
    //   5933: aload_0
    //   5934: iload 6
    //   5936: putfield 125	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   5939: iconst_1
    //   5940: istore 4
    //   5942: aload 33
    //   5944: astore 31
    //   5946: aload 34
    //   5948: astore 33
    //   5950: goto -785 -> 5165
    //   5953: iload 4
    //   5955: istore 7
    //   5957: iload 17
    //   5959: istore 13
    //   5961: aload_0
    //   5962: getfield 288	com/tencent/mobileqq/vip/DownloadTask:p	Z
    //   5965: ifne +93 -> 6058
    //   5968: iconst_1
    //   5969: istore 12
    //   5971: iconst_1
    //   5972: istore 7
    //   5974: iload 17
    //   5976: istore 13
    //   5978: iload 12
    //   5980: istore 4
    //   5982: aload_0
    //   5983: getfield 455	com/tencent/mobileqq/vip/DownloadTask:r	Z
    //   5986: ifeq +26 -> 6012
    //   5989: iload 6
    //   5991: sipush 302
    //   5994: if_icmpeq +1759 -> 7753
    //   5997: iload 12
    //   5999: istore 4
    //   6001: iload 6
    //   6003: sipush 301
    //   6006: if_icmpne +6 -> 6012
    //   6009: goto +1744 -> 7753
    //   6012: iload 4
    //   6014: istore 7
    //   6016: iload 17
    //   6018: istore 13
    //   6020: aload_0
    //   6021: iload 6
    //   6023: putfield 125	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   6026: aload 48
    //   6028: ldc_w 769
    //   6031: invokeinterface 809 2 0
    //   6036: invokeinterface 782 1 0
    //   6041: astore 35
    //   6043: aload 33
    //   6045: astore 31
    //   6047: aload 34
    //   6049: astore 33
    //   6051: aload 35
    //   6053: astore 30
    //   6055: goto -890 -> 5165
    //   6058: sipush 304
    //   6061: iload 6
    //   6063: if_icmpne +30 -> 6093
    //   6066: iload 4
    //   6068: istore 7
    //   6070: iload 17
    //   6072: istore 13
    //   6074: aload_0
    //   6075: iconst_0
    //   6076: putfield 125	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   6079: aload 33
    //   6081: astore 31
    //   6083: aload 34
    //   6085: astore 33
    //   6087: iconst_0
    //   6088: istore 6
    //   6090: goto -925 -> 5165
    //   6093: sipush 416
    //   6096: iload 6
    //   6098: if_icmpne +58 -> 6156
    //   6101: iload 4
    //   6103: istore 7
    //   6105: iload 17
    //   6107: istore 13
    //   6109: aload 39
    //   6111: invokevirtual 306	java/io/File:exists	()Z
    //   6114: ifeq +17 -> 6131
    //   6117: iload 4
    //   6119: istore 7
    //   6121: iload 17
    //   6123: istore 13
    //   6125: aload 39
    //   6127: invokevirtual 312	java/io/File:delete	()Z
    //   6130: pop
    //   6131: iload 4
    //   6133: istore 7
    //   6135: iload 17
    //   6137: istore 13
    //   6139: aload_0
    //   6140: iload 6
    //   6142: putfield 125	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   6145: aload 33
    //   6147: astore 31
    //   6149: aload 34
    //   6151: astore 33
    //   6153: goto -988 -> 5165
    //   6156: iload 4
    //   6158: istore 7
    //   6160: iload 17
    //   6162: istore 13
    //   6164: aload_0
    //   6165: iload 6
    //   6167: putfield 125	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   6170: aload 33
    //   6172: astore 31
    //   6174: aload 34
    //   6176: astore 33
    //   6178: goto -1013 -> 5165
    //   6181: astore 34
    //   6183: ldc 73
    //   6185: iconst_1
    //   6186: new 130	java/lang/StringBuilder
    //   6189: dup
    //   6190: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   6193: ldc_w 918
    //   6196: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6199: aload 30
    //   6201: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6204: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6207: invokestatic 417	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6210: goto -872 -> 5338
    //   6213: astore 34
    //   6215: aload 46
    //   6217: monitorexit
    //   6218: iload 4
    //   6220: istore 5
    //   6222: aload 30
    //   6224: astore 38
    //   6226: aload 31
    //   6228: astore 35
    //   6230: aload 32
    //   6232: astore 37
    //   6234: aload 33
    //   6236: astore 36
    //   6238: iload 6
    //   6240: istore 7
    //   6242: aload 34
    //   6244: athrow
    //   6245: iload 4
    //   6247: istore 5
    //   6249: aload 30
    //   6251: astore 38
    //   6253: aload 31
    //   6255: astore 35
    //   6257: aload 32
    //   6259: astore 37
    //   6261: aload 33
    //   6263: astore 36
    //   6265: iload 6
    //   6267: istore 7
    //   6269: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   6272: ldc2_w 919
    //   6275: ldiv
    //   6276: l2i
    //   6277: istore 12
    //   6279: iload 4
    //   6281: istore 5
    //   6283: aload 30
    //   6285: astore 38
    //   6287: aload 31
    //   6289: astore 35
    //   6291: aload 32
    //   6293: astore 37
    //   6295: aload 33
    //   6297: astore 36
    //   6299: iload 6
    //   6301: istore 7
    //   6303: aload_0
    //   6304: getfield 922	com/tencent/mobileqq/vip/DownloadTask:jdField_c_of_type_Boolean	Z
    //   6307: ifeq +43 -> 6350
    //   6310: iload 4
    //   6312: istore 5
    //   6314: aload 30
    //   6316: astore 38
    //   6318: aload 31
    //   6320: astore 35
    //   6322: aload 32
    //   6324: astore 37
    //   6326: aload 33
    //   6328: astore 36
    //   6330: iload 6
    //   6332: istore 7
    //   6334: getstatic 24	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   6337: aload_0
    //   6338: getfield 924	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6341: iload 12
    //   6343: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6346: invokevirtual 925	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6349: pop
    //   6350: iconst_1
    //   6351: istore 5
    //   6353: aload 30
    //   6355: astore 38
    //   6357: aload 31
    //   6359: astore 35
    //   6361: aload 32
    //   6363: astore 37
    //   6365: aload 33
    //   6367: astore 36
    //   6369: iload 6
    //   6371: istore 7
    //   6373: new 332	java/lang/Exception
    //   6376: dup
    //   6377: new 130	java/lang/StringBuilder
    //   6380: dup
    //   6381: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   6384: ldc_w 927
    //   6387: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6390: aload 30
    //   6392: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6395: ldc_w 929
    //   6398: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6401: aload_0
    //   6402: getfield 462	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   6405: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6408: ldc_w 931
    //   6411: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6414: aload_0
    //   6415: getfield 608	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   6418: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6421: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6424: invokespecial 335	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   6427: athrow
    //   6428: iload 4
    //   6430: istore 5
    //   6432: aload 30
    //   6434: astore 38
    //   6436: aload 31
    //   6438: astore 35
    //   6440: aload 32
    //   6442: astore 37
    //   6444: aload 33
    //   6446: astore 36
    //   6448: iload 6
    //   6450: istore 7
    //   6452: getstatic 24	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   6455: aload_0
    //   6456: getfield 924	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6459: invokevirtual 934	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6462: pop
    //   6463: goto -1122 -> 5341
    //   6466: ldc_w 936
    //   6469: astore 34
    //   6471: goto -837 -> 5634
    //   6474: ldc_w 938
    //   6477: astore 34
    //   6479: goto -815 -> 5664
    //   6482: aload 30
    //   6484: astore 38
    //   6486: aload 31
    //   6488: astore 35
    //   6490: aload 32
    //   6492: astore 37
    //   6494: aload 33
    //   6496: astore 36
    //   6498: iload_3
    //   6499: istore 7
    //   6501: aload 34
    //   6503: instanceof 940
    //   6506: ifeq +31 -> 6537
    //   6509: aload 30
    //   6511: astore 38
    //   6513: aload 31
    //   6515: astore 35
    //   6517: aload 32
    //   6519: astore 37
    //   6521: aload 33
    //   6523: astore 36
    //   6525: iload_3
    //   6526: istore 7
    //   6528: aload_0
    //   6529: bipush 144
    //   6531: putfield 125	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   6534: goto -5321 -> 1213
    //   6537: aload 30
    //   6539: astore 38
    //   6541: aload 31
    //   6543: astore 35
    //   6545: aload 32
    //   6547: astore 37
    //   6549: aload 33
    //   6551: astore 36
    //   6553: iload_3
    //   6554: istore 7
    //   6556: aload 34
    //   6558: instanceof 337
    //   6561: ifne +30 -> 6591
    //   6564: aload 30
    //   6566: astore 38
    //   6568: aload 31
    //   6570: astore 35
    //   6572: aload 32
    //   6574: astore 37
    //   6576: aload 33
    //   6578: astore 36
    //   6580: iload_3
    //   6581: istore 7
    //   6583: aload 34
    //   6585: instanceof 339
    //   6588: ifeq +31 -> 6619
    //   6591: aload 30
    //   6593: astore 38
    //   6595: aload 31
    //   6597: astore 35
    //   6599: aload 32
    //   6601: astore 37
    //   6603: aload 33
    //   6605: astore 36
    //   6607: iload_3
    //   6608: istore 7
    //   6610: aload_0
    //   6611: bipush 143
    //   6613: putfield 125	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   6616: goto -5403 -> 1213
    //   6619: aload 30
    //   6621: astore 38
    //   6623: aload 31
    //   6625: astore 35
    //   6627: aload 32
    //   6629: astore 37
    //   6631: aload 33
    //   6633: astore 36
    //   6635: iload_3
    //   6636: istore 7
    //   6638: aload 34
    //   6640: instanceof 341
    //   6643: ifeq +31 -> 6674
    //   6646: aload 30
    //   6648: astore 38
    //   6650: aload 31
    //   6652: astore 35
    //   6654: aload 32
    //   6656: astore 37
    //   6658: aload 33
    //   6660: astore 36
    //   6662: iload_3
    //   6663: istore 7
    //   6665: aload_0
    //   6666: bipush 142
    //   6668: putfield 125	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   6671: goto -5458 -> 1213
    //   6674: aload 30
    //   6676: astore 38
    //   6678: aload 31
    //   6680: astore 35
    //   6682: aload 32
    //   6684: astore 37
    //   6686: aload 33
    //   6688: astore 36
    //   6690: iload_3
    //   6691: istore 7
    //   6693: aload_0
    //   6694: getfield 125	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   6697: ifne -5484 -> 1213
    //   6700: aload 30
    //   6702: astore 38
    //   6704: aload 31
    //   6706: astore 35
    //   6708: aload 32
    //   6710: astore 37
    //   6712: aload 33
    //   6714: astore 36
    //   6716: iload_3
    //   6717: istore 7
    //   6719: aload_0
    //   6720: bipush 141
    //   6722: putfield 125	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   6725: goto -5512 -> 1213
    //   6728: aload 30
    //   6730: astore 38
    //   6732: aload 31
    //   6734: astore 35
    //   6736: aload 32
    //   6738: astore 37
    //   6740: aload 33
    //   6742: astore 36
    //   6744: iload_3
    //   6745: istore 7
    //   6747: aload_0
    //   6748: iconst_0
    //   6749: putfield 350	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Boolean	Z
    //   6752: goto -5472 -> 1280
    //   6755: ldc_w 936
    //   6758: astore 34
    //   6760: goto -5224 -> 1536
    //   6763: ldc_w 938
    //   6766: astore 34
    //   6768: goto -5204 -> 1564
    //   6771: ldc_w 936
    //   6774: astore_0
    //   6775: goto -4646 -> 2129
    //   6778: ldc_w 938
    //   6781: astore_0
    //   6782: goto -4627 -> 2155
    //   6785: iload 4
    //   6787: istore 7
    //   6789: aload_0
    //   6790: bipush 146
    //   6792: putfield 125	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   6795: iload 4
    //   6797: istore 7
    //   6799: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6802: ifeq +16 -> 6818
    //   6805: iload 4
    //   6807: istore 7
    //   6809: ldc 73
    //   6811: iconst_2
    //   6812: ldc_w 942
    //   6815: invokestatic 787	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   6818: iconst_m1
    //   6819: istore 6
    //   6821: lconst_0
    //   6822: lstore 20
    //   6824: lconst_0
    //   6825: lstore 18
    //   6827: aload 30
    //   6829: astore 33
    //   6831: iload_3
    //   6832: istore 4
    //   6834: aload 32
    //   6836: astore 30
    //   6838: aload 33
    //   6840: astore 32
    //   6842: iload 6
    //   6844: istore_3
    //   6845: goto -5147 -> 1698
    //   6848: aload_0
    //   6849: getfield 945	com/tencent/mobileqq/vip/DownloadTask:o	Z
    //   6852: istore 15
    //   6854: iload 15
    //   6856: iconst_1
    //   6857: if_icmpne +637 -> 7494
    //   6860: iload_3
    //   6861: istore 4
    //   6863: iload 9
    //   6865: ifle +623 -> 7488
    //   6868: iload 4
    //   6870: istore 7
    //   6872: aload_0
    //   6873: getfield 176	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6876: invokeinterface 182 1 0
    //   6881: iconst_1
    //   6882: if_icmple +606 -> 7488
    //   6885: iload 4
    //   6887: istore 7
    //   6889: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6892: ifeq +52 -> 6944
    //   6895: iload 4
    //   6897: istore 7
    //   6899: ldc 73
    //   6901: iconst_2
    //   6902: new 130	java/lang/StringBuilder
    //   6905: dup
    //   6906: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   6909: ldc_w 947
    //   6912: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6915: iload 9
    //   6917: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6920: ldc_w 949
    //   6923: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6926: aload_0
    //   6927: getfield 176	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6930: invokeinterface 182 1 0
    //   6935: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6938: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6941: invokestatic 787	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   6944: iload 4
    //   6946: istore 7
    //   6948: aload_0
    //   6949: bipush 148
    //   6951: putfield 125	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Int	I
    //   6954: iconst_m1
    //   6955: istore_3
    //   6956: aload_0
    //   6957: iload_3
    //   6958: invokestatic 952	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;I)V
    //   6961: goto -4758 -> 2203
    //   6964: astore_0
    //   6965: goto -4772 -> 2193
    //   6968: astore_0
    //   6969: goto -4776 -> 2193
    //   6972: astore_0
    //   6973: iload 7
    //   6975: istore_3
    //   6976: goto -4783 -> 2193
    //   6979: astore_0
    //   6980: goto -4787 -> 2193
    //   6983: astore_1
    //   6984: aload 36
    //   6986: astore 30
    //   6988: goto -5035 -> 1953
    //   6991: astore_1
    //   6992: aload 31
    //   6994: astore 34
    //   6996: goto -5043 -> 1953
    //   6999: astore_1
    //   7000: aload 34
    //   7002: astore 33
    //   7004: aload 31
    //   7006: astore 34
    //   7008: goto -5055 -> 1953
    //   7011: astore_1
    //   7012: aload 33
    //   7014: astore 32
    //   7016: aload 34
    //   7018: astore 33
    //   7020: aload 31
    //   7022: astore 34
    //   7024: goto -5071 -> 1953
    //   7027: astore_1
    //   7028: aload 34
    //   7030: astore 33
    //   7032: aload 31
    //   7034: astore 34
    //   7036: goto -5083 -> 1953
    //   7039: astore_1
    //   7040: iconst_0
    //   7041: istore 5
    //   7043: aload 34
    //   7045: astore 33
    //   7047: aload 31
    //   7049: astore 34
    //   7051: goto -5098 -> 1953
    //   7054: astore_1
    //   7055: aload 34
    //   7057: astore 33
    //   7059: aload 31
    //   7061: astore 34
    //   7063: goto -5110 -> 1953
    //   7066: astore_1
    //   7067: iload 6
    //   7069: istore 5
    //   7071: goto -5118 -> 1953
    //   7074: astore 30
    //   7076: aload 33
    //   7078: astore 31
    //   7080: aload 34
    //   7082: astore 33
    //   7084: iload 5
    //   7086: istore 7
    //   7088: aload 30
    //   7090: astore 34
    //   7092: aload 35
    //   7094: astore 30
    //   7096: iload 6
    //   7098: istore 5
    //   7100: iload 16
    //   7102: istore 13
    //   7104: iload_3
    //   7105: istore 8
    //   7107: iload 7
    //   7109: istore_3
    //   7110: goto -6036 -> 1074
    //   7113: astore 31
    //   7115: iconst_1
    //   7116: istore 7
    //   7118: aload 34
    //   7120: astore 35
    //   7122: iload 5
    //   7124: istore 6
    //   7126: aload 31
    //   7128: astore 34
    //   7130: iload 7
    //   7132: istore 5
    //   7134: iload 16
    //   7136: istore 13
    //   7138: iload_3
    //   7139: istore 8
    //   7141: aload 33
    //   7143: astore 31
    //   7145: aload 35
    //   7147: astore 33
    //   7149: iload 6
    //   7151: istore_3
    //   7152: goto -6078 -> 1074
    //   7155: astore 34
    //   7157: iload_3
    //   7158: istore 6
    //   7160: iload 5
    //   7162: istore_3
    //   7163: aload 33
    //   7165: astore 35
    //   7167: aload 31
    //   7169: astore 33
    //   7171: iload 6
    //   7173: istore 5
    //   7175: iload 15
    //   7177: istore 13
    //   7179: aload 35
    //   7181: astore 31
    //   7183: goto -6109 -> 1074
    //   7186: astore 34
    //   7188: iload 5
    //   7190: istore 7
    //   7192: aload 31
    //   7194: astore 35
    //   7196: iload 6
    //   7198: istore 4
    //   7200: lload 22
    //   7202: lstore 18
    //   7204: iload_3
    //   7205: istore 5
    //   7207: iload 15
    //   7209: istore 13
    //   7211: aload 33
    //   7213: astore 31
    //   7215: aload 35
    //   7217: astore 33
    //   7219: iload 7
    //   7221: istore_3
    //   7222: goto -6148 -> 1074
    //   7225: astore 36
    //   7227: aload 34
    //   7229: astore 33
    //   7231: aload 31
    //   7233: astore 35
    //   7235: iload 5
    //   7237: istore 6
    //   7239: aload 36
    //   7241: astore 34
    //   7243: iload_3
    //   7244: istore 5
    //   7246: iload 15
    //   7248: istore 13
    //   7250: aload 33
    //   7252: astore 31
    //   7254: aload 35
    //   7256: astore 33
    //   7258: iload 6
    //   7260: istore_3
    //   7261: goto -6187 -> 1074
    //   7264: astore 35
    //   7266: aload 33
    //   7268: astore 32
    //   7270: aload 31
    //   7272: astore 33
    //   7274: aload 34
    //   7276: astore 31
    //   7278: iload 5
    //   7280: istore 6
    //   7282: aload 35
    //   7284: astore 34
    //   7286: iload_3
    //   7287: istore 5
    //   7289: iload 15
    //   7291: istore 13
    //   7293: iload 6
    //   7295: istore_3
    //   7296: goto -6222 -> 1074
    //   7299: astore 36
    //   7301: aload 34
    //   7303: astore 33
    //   7305: aload 31
    //   7307: astore 35
    //   7309: iload 5
    //   7311: istore 6
    //   7313: aload 36
    //   7315: astore 34
    //   7317: iload_3
    //   7318: istore 5
    //   7320: iload 15
    //   7322: istore 13
    //   7324: aload 33
    //   7326: astore 31
    //   7328: aload 35
    //   7330: astore 33
    //   7332: iload 6
    //   7334: istore_3
    //   7335: goto -6261 -> 1074
    //   7338: astore 36
    //   7340: lload 22
    //   7342: lstore 20
    //   7344: aload 34
    //   7346: astore 33
    //   7348: aload 31
    //   7350: astore 35
    //   7352: iload 5
    //   7354: istore 6
    //   7356: aload 36
    //   7358: astore 34
    //   7360: iload_3
    //   7361: istore 5
    //   7363: iload 15
    //   7365: istore 13
    //   7367: aload 33
    //   7369: astore 31
    //   7371: aload 35
    //   7373: astore 33
    //   7375: iload 6
    //   7377: istore_3
    //   7378: goto -6304 -> 1074
    //   7381: astore 36
    //   7383: aload 34
    //   7385: astore 33
    //   7387: aload 31
    //   7389: astore 35
    //   7391: iconst_0
    //   7392: istore 6
    //   7394: aload 36
    //   7396: astore 34
    //   7398: iload_3
    //   7399: istore 5
    //   7401: iload 15
    //   7403: istore 13
    //   7405: aload 33
    //   7407: astore 31
    //   7409: aload 35
    //   7411: astore 33
    //   7413: iload 6
    //   7415: istore_3
    //   7416: goto -6342 -> 1074
    //   7419: astore 36
    //   7421: aload 34
    //   7423: astore 33
    //   7425: aload 31
    //   7427: astore 35
    //   7429: iload 5
    //   7431: istore 6
    //   7433: aload 36
    //   7435: astore 34
    //   7437: iconst_1
    //   7438: istore 4
    //   7440: iload_3
    //   7441: istore 5
    //   7443: iload 15
    //   7445: istore 13
    //   7447: aload 33
    //   7449: astore 31
    //   7451: aload 35
    //   7453: astore 33
    //   7455: iload 6
    //   7457: istore_3
    //   7458: goto -6384 -> 1074
    //   7461: astore 35
    //   7463: iload_3
    //   7464: istore 5
    //   7466: aload 33
    //   7468: astore 31
    //   7470: aload 34
    //   7472: astore 33
    //   7474: iload 6
    //   7476: istore_3
    //   7477: aload 35
    //   7479: astore 34
    //   7481: iload 15
    //   7483: istore 13
    //   7485: goto -6411 -> 1074
    //   7488: iload 4
    //   7490: istore_3
    //   7491: goto -535 -> 6956
    //   7494: iload 9
    //   7496: istore 5
    //   7498: goto -5761 -> 1737
    //   7501: goto -2886 -> 4615
    //   7504: goto -4080 -> 3424
    //   7507: iload_3
    //   7508: istore 8
    //   7510: iload 6
    //   7512: istore_3
    //   7513: goto -4083 -> 3430
    //   7516: iload 8
    //   7518: istore 4
    //   7520: goto -4935 -> 2585
    //   7523: iload 5
    //   7525: istore 11
    //   7527: aload 30
    //   7529: astore 35
    //   7531: iload_3
    //   7532: istore 5
    //   7534: iload 4
    //   7536: istore_3
    //   7537: iload 8
    //   7539: istore 6
    //   7541: aload 32
    //   7543: astore 30
    //   7545: aload 31
    //   7547: astore 34
    //   7549: aload 35
    //   7551: astore 32
    //   7553: goto -6815 -> 738
    //   7556: bipush 254
    //   7558: istore_3
    //   7559: goto -5356 -> 2203
    //   7562: iconst_m1
    //   7563: istore 4
    //   7565: iload 4
    //   7567: ireturn
    //   7568: iconst_m1
    //   7569: ireturn
    //   7570: ldc_w 792
    //   7573: astore 30
    //   7575: goto -7339 -> 236
    //   7578: iconst_1
    //   7579: istore 6
    //   7581: goto -6420 -> 1161
    //   7584: astore_1
    //   7585: goto -5632 -> 1953
    //   7588: sipush 200
    //   7591: iload 6
    //   7593: if_icmpeq -3534 -> 4059
    //   7596: sipush 206
    //   7599: iload 6
    //   7601: if_icmpne -1683 -> 5918
    //   7604: goto -3545 -> 4059
    //   7607: aload 35
    //   7609: astore 33
    //   7611: iload 7
    //   7613: bipush 12
    //   7615: if_icmple -2922 -> 4693
    //   7618: aload 35
    //   7620: astore 33
    //   7622: bipush 82
    //   7624: aload 36
    //   7626: iconst_0
    //   7627: baload
    //   7628: if_icmpne -2935 -> 4693
    //   7631: aload 35
    //   7633: astore 33
    //   7635: bipush 73
    //   7637: aload 36
    //   7639: iconst_1
    //   7640: baload
    //   7641: if_icmpne -2948 -> 4693
    //   7644: aload 35
    //   7646: astore 33
    //   7648: bipush 70
    //   7650: aload 36
    //   7652: iconst_2
    //   7653: baload
    //   7654: if_icmpne -2961 -> 4693
    //   7657: aload 35
    //   7659: astore 33
    //   7661: bipush 70
    //   7663: aload 36
    //   7665: iconst_3
    //   7666: baload
    //   7667: if_icmpne -2974 -> 4693
    //   7670: aload 35
    //   7672: astore 33
    //   7674: bipush 87
    //   7676: aload 36
    //   7678: bipush 8
    //   7680: baload
    //   7681: if_icmpne -2988 -> 4693
    //   7684: aload 35
    //   7686: astore 33
    //   7688: bipush 69
    //   7690: aload 36
    //   7692: bipush 9
    //   7694: baload
    //   7695: if_icmpne -3002 -> 4693
    //   7698: aload 35
    //   7700: astore 33
    //   7702: bipush 66
    //   7704: aload 36
    //   7706: bipush 10
    //   7708: baload
    //   7709: if_icmpne -3016 -> 4693
    //   7712: aload 35
    //   7714: astore 33
    //   7716: bipush 80
    //   7718: aload 36
    //   7720: bipush 11
    //   7722: baload
    //   7723: if_icmpne -3030 -> 4693
    //   7726: ldc_w 954
    //   7729: astore 33
    //   7731: goto -3038 -> 4693
    //   7734: sipush 302
    //   7737: iload 6
    //   7739: if_icmpeq -1786 -> 5953
    //   7742: sipush 301
    //   7745: iload 6
    //   7747: if_icmpne -1689 -> 6058
    //   7750: goto -1797 -> 5953
    //   7753: iload 12
    //   7755: istore 4
    //   7757: iload 11
    //   7759: iconst_m1
    //   7760: if_icmpne -1748 -> 6012
    //   7763: iconst_0
    //   7764: istore 4
    //   7766: goto -1754 -> 6012
    //   7769: astore 34
    //   7771: iload 5
    //   7773: istore 4
    //   7775: iload_3
    //   7776: istore 5
    //   7778: iload 15
    //   7780: istore 13
    //   7782: iload 6
    //   7784: istore_3
    //   7785: goto -6711 -> 1074
    //   7788: astore_1
    //   7789: aload 38
    //   7791: astore 30
    //   7793: aload 37
    //   7795: astore 32
    //   7797: iload 7
    //   7799: istore 5
    //   7801: aload 36
    //   7803: astore 34
    //   7805: aload 35
    //   7807: astore 33
    //   7809: goto -5856 -> 1953
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7812	0	paramDownloadTask	DownloadTask
    //   0	7812	1	paramString	String
    //   0	7812	2	paramContext	Context
    //   69	7716	3	i	int
    //   16	7758	4	j	int
    //   416	7384	5	k	int
    //   718	7065	6	m	int
    //   373	7425	7	n	int
    //   816	6722	8	i1	int
    //   344	7151	9	i2	int
    //   367	4453	10	i3	int
    //   708	7053	11	i4	int
    //   822	6932	12	i5	int
    //   347	7434	13	bool1	boolean
    //   364	5155	14	bool2	boolean
    //   825	6954	15	bool3	boolean
    //   828	6307	16	bool4	boolean
    //   3584	2577	17	bool5	boolean
    //   724	6479	18	l1	long
    //   721	6622	20	l2	long
    //   3001	4340	22	l3	long
    //   4083	994	24	l4	long
    //   413	1298	26	l5	long
    //   745	4830	28	l6	long
    //   234	6753	30	localObject1	Object
    //   7074	15	30	localThrowable1	Throwable
    //   7094	698	30	localObject2	Object
    //   376	6703	31	localObject3	Object
    //   7113	14	31	localThrowable2	Throwable
    //   7143	403	31	localObject4	Object
    //   379	7417	32	localObject5	Object
    //   503	7305	33	localObject6	Object
    //   462	3699	34	localObject7	Object
    //   4357	1	34	localThrowable3	Throwable
    //   4494	1681	34	localObject8	Object
    //   6181	1	34	localInterruptedException	java.lang.InterruptedException
    //   6213	30	34	localObject9	Object
    //   6469	660	34	localObject10	Object
    //   7155	1	34	localThrowable4	Throwable
    //   7186	42	34	localThrowable5	Throwable
    //   7241	307	34	localObject11	Object
    //   7769	1	34	localThrowable6	Throwable
    //   7803	1	34	localObject12	Object
    //   580	379	35	localObject13	Object
    //   1042	29	35	localThrowable7	Throwable
    //   1083	1575	35	localObject14	Object
    //   2694	15	35	localThrowable8	Throwable
    //   2735	1234	35	localObject15	Object
    //   3982	17	35	localThrowable9	Throwable
    //   4145	3110	35	localObject16	Object
    //   7264	19	35	localThrowable10	Throwable
    //   7307	145	35	localObject17	Object
    //   7461	17	35	localThrowable11	Throwable
    //   7529	277	35	localObject18	Object
    //   832	4912	36	localObject19	Object
    //   5798	18	36	localThrowable12	Throwable
    //   5879	15	36	localThrowable13	Throwable
    //   6236	749	36	localObject20	Object
    //   7225	15	36	localThrowable14	Throwable
    //   7299	15	36	localThrowable15	Throwable
    //   7338	19	36	localThrowable16	Throwable
    //   7381	14	36	localThrowable17	Throwable
    //   7419	383	36	localThrowable18	Throwable
    //   1087	6707	37	localObject21	Object
    //   1079	6711	38	localObject22	Object
    //   651	5475	39	localFile1	File
    //   576	5022	40	localFile2	File
    //   701	4951	41	localDownloadInfo	DownloadInfo
    //   78	470	42	localIApolloUtil	IApolloUtil
    //   181	3327	43	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    //   442	4999	44	localHashMap	HashMap
    //   813	4970	45	localStringBuilder	java.lang.StringBuilder
    //   429	5787	46	localObject23	Object
    //   596	1187	47	localFile3	File
    //   2655	3372	48	localObject24	Object
    // Exception table:
    //   from	to	target	type
    //   978	1019	1042	java/lang/Throwable
    //   1031	1042	1042	java/lang/Throwable
    //   1916	1925	1042	java/lang/Throwable
    //   1937	1948	1042	java/lang/Throwable
    //   978	1019	1948	finally
    //   1031	1042	1948	finally
    //   1916	1925	1948	finally
    //   1937	1948	1948	finally
    //   742	747	2189	java/lang/Throwable
    //   751	815	2189	java/lang/Throwable
    //   1957	1960	2189	java/lang/Throwable
    //   1964	2003	2189	java/lang/Throwable
    //   2007	2015	2189	java/lang/Throwable
    //   2024	2086	2189	java/lang/Throwable
    //   2090	2101	2189	java/lang/Throwable
    //   2105	2113	2189	java/lang/Throwable
    //   2117	2125	2189	java/lang/Throwable
    //   2133	2139	2189	java/lang/Throwable
    //   2143	2151	2189	java/lang/Throwable
    //   2159	2168	2189	java/lang/Throwable
    //   2172	2183	2189	java/lang/Throwable
    //   2187	2189	2189	java/lang/Throwable
    //   2585	2602	2694	java/lang/Throwable
    //   2607	2621	2694	java/lang/Throwable
    //   2621	2691	2694	java/lang/Throwable
    //   2772	2817	2694	java/lang/Throwable
    //   2817	2983	2694	java/lang/Throwable
    //   2988	3065	2694	java/lang/Throwable
    //   3065	3079	2694	java/lang/Throwable
    //   3084	3107	2694	java/lang/Throwable
    //   3114	3188	2694	java/lang/Throwable
    //   3188	3296	2694	java/lang/Throwable
    //   3296	3329	2694	java/lang/Throwable
    //   3329	3354	2694	java/lang/Throwable
    //   3364	3386	2694	java/lang/Throwable
    //   4013	4028	2694	java/lang/Throwable
    //   4031	4038	2694	java/lang/Throwable
    //   3438	3445	3982	java/lang/Throwable
    //   3453	3462	3982	java/lang/Throwable
    //   3470	3476	3982	java/lang/Throwable
    //   3484	3497	3982	java/lang/Throwable
    //   3505	3512	3982	java/lang/Throwable
    //   3520	3527	3982	java/lang/Throwable
    //   3539	3548	3982	java/lang/Throwable
    //   3556	3562	3982	java/lang/Throwable
    //   3570	3580	3982	java/lang/Throwable
    //   3597	3611	3982	java/lang/Throwable
    //   3619	3625	3982	java/lang/Throwable
    //   3633	3640	3982	java/lang/Throwable
    //   3648	3682	3982	java/lang/Throwable
    //   3690	3699	3982	java/lang/Throwable
    //   3707	3717	3982	java/lang/Throwable
    //   3725	3734	3982	java/lang/Throwable
    //   3742	3751	3982	java/lang/Throwable
    //   3759	3770	3982	java/lang/Throwable
    //   3778	3789	3982	java/lang/Throwable
    //   3797	3808	3982	java/lang/Throwable
    //   3816	3827	3982	java/lang/Throwable
    //   3835	3846	3982	java/lang/Throwable
    //   3854	3865	3982	java/lang/Throwable
    //   3873	3884	3982	java/lang/Throwable
    //   3892	3903	3982	java/lang/Throwable
    //   3911	3922	3982	java/lang/Throwable
    //   3930	3941	3982	java/lang/Throwable
    //   3949	3979	3982	java/lang/Throwable
    //   4067	4076	3982	java/lang/Throwable
    //   5933	5939	3982	java/lang/Throwable
    //   5961	5968	3982	java/lang/Throwable
    //   5982	5989	3982	java/lang/Throwable
    //   6020	6026	3982	java/lang/Throwable
    //   6074	6079	3982	java/lang/Throwable
    //   6109	6117	3982	java/lang/Throwable
    //   6125	6131	3982	java/lang/Throwable
    //   6139	6145	3982	java/lang/Throwable
    //   6164	6170	3982	java/lang/Throwable
    //   4318	4334	4357	java/lang/Throwable
    //   4346	4357	4357	java/lang/Throwable
    //   4476	4487	4357	java/lang/Throwable
    //   4318	4334	4487	finally
    //   4346	4357	4487	finally
    //   4476	4487	4487	finally
    //   5782	5791	5798	java/lang/Throwable
    //   5858	5864	5879	java/lang/Throwable
    //   5868	5879	5879	java/lang/Throwable
    //   5331	5338	6181	java/lang/InterruptedException
    //   5331	5338	6213	finally
    //   5338	5341	6213	finally
    //   6183	6210	6213	finally
    //   6215	6218	6213	finally
    //   6956	6961	6964	java/lang/Throwable
    //   70	80	6968	java/lang/Throwable
    //   83	91	6968	java/lang/Throwable
    //   94	102	6968	java/lang/Throwable
    //   108	115	6968	java/lang/Throwable
    //   118	124	6968	java/lang/Throwable
    //   127	131	6968	java/lang/Throwable
    //   134	140	6968	java/lang/Throwable
    //   143	168	6968	java/lang/Throwable
    //   174	183	6968	java/lang/Throwable
    //   186	202	6968	java/lang/Throwable
    //   205	222	6968	java/lang/Throwable
    //   225	232	6968	java/lang/Throwable
    //   239	251	6968	java/lang/Throwable
    //   254	261	6968	java/lang/Throwable
    //   264	276	6968	java/lang/Throwable
    //   279	285	6968	java/lang/Throwable
    //   288	292	6968	java/lang/Throwable
    //   295	301	6968	java/lang/Throwable
    //   304	329	6968	java/lang/Throwable
    //   335	346	6968	java/lang/Throwable
    //   352	357	6968	java/lang/Throwable
    //   389	403	6972	java/lang/Throwable
    //   410	415	6972	java/lang/Throwable
    //   422	431	6972	java/lang/Throwable
    //   435	444	6972	java/lang/Throwable
    //   448	464	6972	java/lang/Throwable
    //   468	474	6972	java/lang/Throwable
    //   478	486	6972	java/lang/Throwable
    //   495	505	6972	java/lang/Throwable
    //   509	523	6972	java/lang/Throwable
    //   527	543	6972	java/lang/Throwable
    //   547	558	6972	java/lang/Throwable
    //   562	578	6972	java/lang/Throwable
    //   591	598	6972	java/lang/Throwable
    //   602	609	6972	java/lang/Throwable
    //   613	653	6972	java/lang/Throwable
    //   661	671	6972	java/lang/Throwable
    //   675	686	6972	java/lang/Throwable
    //   690	703	6972	java/lang/Throwable
    //   1369	1372	6972	java/lang/Throwable
    //   1375	1414	6972	java/lang/Throwable
    //   1417	1425	6972	java/lang/Throwable
    //   1433	1495	6972	java/lang/Throwable
    //   1498	1508	6972	java/lang/Throwable
    //   1511	1520	6972	java/lang/Throwable
    //   1523	1531	6972	java/lang/Throwable
    //   1539	1548	6972	java/lang/Throwable
    //   1551	1559	6972	java/lang/Throwable
    //   1567	1579	6972	java/lang/Throwable
    //   1582	1593	6972	java/lang/Throwable
    //   1655	1664	6972	java/lang/Throwable
    //   1667	1673	6972	java/lang/Throwable
    //   1778	1813	6972	java/lang/Throwable
    //   5460	5463	6972	java/lang/Throwable
    //   5467	5506	6972	java/lang/Throwable
    //   5510	5518	6972	java/lang/Throwable
    //   5527	5589	6972	java/lang/Throwable
    //   5593	5604	6972	java/lang/Throwable
    //   5608	5617	6972	java/lang/Throwable
    //   5621	5629	6972	java/lang/Throwable
    //   5638	5647	6972	java/lang/Throwable
    //   5651	5659	6972	java/lang/Throwable
    //   5668	5680	6972	java/lang/Throwable
    //   5684	5695	6972	java/lang/Throwable
    //   6789	6795	6972	java/lang/Throwable
    //   6799	6805	6972	java/lang/Throwable
    //   6809	6818	6972	java/lang/Throwable
    //   6872	6885	6972	java/lang/Throwable
    //   6889	6895	6972	java/lang/Throwable
    //   6899	6944	6972	java/lang/Throwable
    //   6948	6954	6972	java/lang/Throwable
    //   1698	1727	6979	java/lang/Throwable
    //   6848	6854	6979	java/lang/Throwable
    //   842	847	6983	finally
    //   867	875	6983	finally
    //   887	894	6983	finally
    //   916	922	6983	finally
    //   934	942	6983	finally
    //   960	966	6983	finally
    //   1828	1834	6983	finally
    //   1846	1860	6983	finally
    //   1872	1877	6983	finally
    //   1898	1904	6983	finally
    //   2256	2263	6983	finally
    //   2279	2290	6983	finally
    //   2302	2322	6983	finally
    //   2334	2342	6983	finally
    //   2354	2382	6983	finally
    //   2394	2411	6983	finally
    //   2423	2429	6983	finally
    //   2441	2468	6983	finally
    //   2480	2490	6983	finally
    //   2507	2514	6983	finally
    //   2526	2537	6983	finally
    //   2549	2554	6983	finally
    //   2568	2581	6983	finally
    //   2741	2769	6983	finally
    //   4076	4085	6991	finally
    //   4093	4107	6991	finally
    //   4115	4127	6991	finally
    //   4135	4147	6991	finally
    //   4160	4181	6991	finally
    //   4189	4196	6991	finally
    //   4204	4229	6991	finally
    //   4237	4244	6991	finally
    //   4259	4268	6991	finally
    //   4276	4286	6991	finally
    //   4300	4306	6991	finally
    //   4405	4418	6991	finally
    //   4444	4450	6991	finally
    //   4462	4468	6991	finally
    //   4517	4537	6991	finally
    //   4537	4589	6999	finally
    //   4844	4853	6999	finally
    //   4589	4598	7011	finally
    //   4602	4612	7027	finally
    //   4619	4626	7027	finally
    //   4630	4639	7027	finally
    //   4649	4655	7027	finally
    //   4702	4716	7027	finally
    //   4720	4730	7027	finally
    //   4764	4773	7027	finally
    //   4777	4787	7027	finally
    //   4791	4802	7027	finally
    //   4814	4824	7027	finally
    //   4828	4832	7027	finally
    //   4953	4958	7027	finally
    //   4962	4970	7027	finally
    //   4974	4981	7027	finally
    //   4985	4999	7027	finally
    //   5018	5025	7027	finally
    //   5036	5049	7027	finally
    //   5053	5076	7027	finally
    //   5088	5093	7027	finally
    //   5754	5760	7027	finally
    //   5772	5778	7027	finally
    //   5848	5854	7027	finally
    //   5093	5107	7039	finally
    //   5107	5138	7039	finally
    //   5782	5791	7054	finally
    //   5858	5864	7054	finally
    //   5868	5879	7054	finally
    //   6026	6043	7066	finally
    //   842	847	7074	java/lang/Throwable
    //   867	875	7074	java/lang/Throwable
    //   887	894	7074	java/lang/Throwable
    //   916	922	7074	java/lang/Throwable
    //   934	942	7074	java/lang/Throwable
    //   960	966	7074	java/lang/Throwable
    //   1828	1834	7074	java/lang/Throwable
    //   1846	1860	7074	java/lang/Throwable
    //   1872	1877	7074	java/lang/Throwable
    //   1898	1904	7074	java/lang/Throwable
    //   2256	2263	7074	java/lang/Throwable
    //   2279	2290	7074	java/lang/Throwable
    //   2302	2322	7074	java/lang/Throwable
    //   2334	2342	7074	java/lang/Throwable
    //   2354	2382	7074	java/lang/Throwable
    //   2394	2411	7074	java/lang/Throwable
    //   2423	2429	7074	java/lang/Throwable
    //   2441	2468	7074	java/lang/Throwable
    //   2480	2490	7074	java/lang/Throwable
    //   2507	2514	7074	java/lang/Throwable
    //   2526	2537	7074	java/lang/Throwable
    //   2549	2554	7074	java/lang/Throwable
    //   2568	2581	7074	java/lang/Throwable
    //   2741	2769	7074	java/lang/Throwable
    //   3389	3424	7113	java/lang/Throwable
    //   4076	4085	7155	java/lang/Throwable
    //   4093	4107	7186	java/lang/Throwable
    //   4115	4127	7186	java/lang/Throwable
    //   4135	4147	7186	java/lang/Throwable
    //   4160	4181	7186	java/lang/Throwable
    //   4189	4196	7186	java/lang/Throwable
    //   4204	4229	7186	java/lang/Throwable
    //   4237	4244	7186	java/lang/Throwable
    //   4259	4268	7186	java/lang/Throwable
    //   4276	4286	7186	java/lang/Throwable
    //   4300	4306	7186	java/lang/Throwable
    //   4405	4418	7186	java/lang/Throwable
    //   4444	4450	7186	java/lang/Throwable
    //   4462	4468	7186	java/lang/Throwable
    //   4517	4537	7186	java/lang/Throwable
    //   4537	4589	7225	java/lang/Throwable
    //   4844	4853	7225	java/lang/Throwable
    //   4589	4598	7264	java/lang/Throwable
    //   4602	4612	7299	java/lang/Throwable
    //   4619	4626	7338	java/lang/Throwable
    //   4630	4639	7338	java/lang/Throwable
    //   4649	4655	7338	java/lang/Throwable
    //   4702	4716	7338	java/lang/Throwable
    //   4720	4730	7338	java/lang/Throwable
    //   4764	4773	7338	java/lang/Throwable
    //   4777	4787	7338	java/lang/Throwable
    //   4791	4802	7338	java/lang/Throwable
    //   4814	4824	7338	java/lang/Throwable
    //   4828	4832	7338	java/lang/Throwable
    //   4953	4958	7338	java/lang/Throwable
    //   4962	4970	7338	java/lang/Throwable
    //   4974	4981	7338	java/lang/Throwable
    //   4985	4999	7338	java/lang/Throwable
    //   5018	5025	7338	java/lang/Throwable
    //   5036	5049	7338	java/lang/Throwable
    //   5053	5076	7338	java/lang/Throwable
    //   5088	5093	7338	java/lang/Throwable
    //   5754	5760	7338	java/lang/Throwable
    //   5848	5854	7338	java/lang/Throwable
    //   5093	5107	7381	java/lang/Throwable
    //   5107	5138	7381	java/lang/Throwable
    //   5772	5778	7419	java/lang/Throwable
    //   6026	6043	7461	java/lang/Throwable
    //   2585	2602	7584	finally
    //   2607	2621	7584	finally
    //   2621	2691	7584	finally
    //   2772	2817	7584	finally
    //   2817	2983	7584	finally
    //   2988	3065	7584	finally
    //   3065	3079	7584	finally
    //   3084	3107	7584	finally
    //   3114	3188	7584	finally
    //   3188	3296	7584	finally
    //   3296	3329	7584	finally
    //   3329	3354	7584	finally
    //   3364	3386	7584	finally
    //   3389	3424	7584	finally
    //   3438	3445	7584	finally
    //   3453	3462	7584	finally
    //   3470	3476	7584	finally
    //   3484	3497	7584	finally
    //   3505	3512	7584	finally
    //   3520	3527	7584	finally
    //   3539	3548	7584	finally
    //   3556	3562	7584	finally
    //   3570	3580	7584	finally
    //   3597	3611	7584	finally
    //   3619	3625	7584	finally
    //   3633	3640	7584	finally
    //   3648	3682	7584	finally
    //   3690	3699	7584	finally
    //   3707	3717	7584	finally
    //   3725	3734	7584	finally
    //   3742	3751	7584	finally
    //   3759	3770	7584	finally
    //   3778	3789	7584	finally
    //   3797	3808	7584	finally
    //   3816	3827	7584	finally
    //   3835	3846	7584	finally
    //   3854	3865	7584	finally
    //   3873	3884	7584	finally
    //   3892	3903	7584	finally
    //   3911	3922	7584	finally
    //   3930	3941	7584	finally
    //   3949	3979	7584	finally
    //   4013	4028	7584	finally
    //   4031	4038	7584	finally
    //   4067	4076	7584	finally
    //   5933	5939	7584	finally
    //   5961	5968	7584	finally
    //   5982	5989	7584	finally
    //   6020	6026	7584	finally
    //   6074	6079	7584	finally
    //   6109	6117	7584	finally
    //   6125	6131	7584	finally
    //   6139	6145	7584	finally
    //   6164	6170	7584	finally
    //   5189	5195	7769	java/lang/Throwable
    //   5219	5229	7769	java/lang/Throwable
    //   5258	5265	7769	java/lang/Throwable
    //   5289	5298	7769	java/lang/Throwable
    //   5322	5325	7769	java/lang/Throwable
    //   5365	5375	7769	java/lang/Throwable
    //   5399	5411	7769	java/lang/Throwable
    //   5440	5456	7769	java/lang/Throwable
    //   6242	6245	7769	java/lang/Throwable
    //   6269	6279	7769	java/lang/Throwable
    //   6303	6310	7769	java/lang/Throwable
    //   6334	6350	7769	java/lang/Throwable
    //   6373	6428	7769	java/lang/Throwable
    //   6452	6463	7769	java/lang/Throwable
    //   1096	1104	7788	finally
    //   1123	1131	7788	finally
    //   1150	1158	7788	finally
    //   1180	1188	7788	finally
    //   1207	1213	7788	finally
    //   1232	1241	7788	finally
    //   1275	1280	7788	finally
    //   1299	1330	7788	finally
    //   1349	1366	7788	finally
    //   5189	5195	7788	finally
    //   5219	5229	7788	finally
    //   5258	5265	7788	finally
    //   5289	5298	7788	finally
    //   5322	5325	7788	finally
    //   5365	5375	7788	finally
    //   5399	5411	7788	finally
    //   5440	5456	7788	finally
    //   6242	6245	7788	finally
    //   6269	6279	7788	finally
    //   6303	6310	7788	finally
    //   6334	6350	7788	finally
    //   6373	6428	7788	finally
    //   6452	6463	7788	finally
    //   6501	6509	7788	finally
    //   6528	6534	7788	finally
    //   6556	6564	7788	finally
    //   6583	6591	7788	finally
    //   6610	6616	7788	finally
    //   6638	6646	7788	finally
    //   6665	6671	7788	finally
    //   6693	6700	7788	finally
    //   6719	6725	7788	finally
    //   6747	6752	7788	finally
  }
  
  public static int a(DownloadTask paramDownloadTask, AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      if ((paramDownloadTask.k) && (!QQSharpPUtil.a(paramAppRuntime.getApplication()))) {
        QLog.e("AIOAudioPanel", 1, "sharpp load error");
      }
      return a(paramDownloadTask, paramAppRuntime.getAccount(), paramAppRuntime.getApplication());
    }
    return a(paramDownloadTask, null, null);
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      String str2 = "http://[^/\\s]*/";
      String str1 = "http://" + paramString2 + "/";
      if (paramString1.startsWith("https"))
      {
        str2 = "https://[^/\\s]*/";
        str1 = "https://" + paramString2 + "/";
      }
      return paramString1.replaceFirst(str2, str1);
    }
    return null;
  }
  
  public static void a(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (TextUtils.isEmpty(paramDownloadInfo.urlOriginal))) {}
    do
    {
      String str1;
      String str2;
      do
      {
        return;
        str1 = InnerDns.getHostFromUrl(paramDownloadInfo.urlOriginal);
        if ((!jdField_a_of_type_JavaUtilMap.containsKey(str1)) || (!paramDownloadInfo.urlOriginal.startsWith("http"))) {
          break;
        }
        str2 = InnerDns.getInstance().reqDns(str1, ((Integer)jdField_a_of_type_JavaUtilMap.get(str1)).intValue());
      } while (TextUtils.isEmpty(str2));
      String str3 = a(paramDownloadInfo.urlOriginal, str2);
      if (!TextUtils.isEmpty(str3))
      {
        paramDownloadInfo.reqUrl = str3;
        paramDownloadInfo.host = str1;
        paramDownloadInfo.ip = str2;
        paramDownloadInfo.isIPUrl = true;
        return;
      }
      paramDownloadInfo.reqUrl = paramDownloadInfo.urlOriginal;
      return;
      HttpDownloadUtils.a(paramDownloadInfo);
    } while (!QLog.isColorLevel());
    QLog.d("DownloaderFactory", 2, "use new httpDNS. url: " + paramDownloadInfo.urlOriginal);
  }
  
  private static void a(DownloadTask paramDownloadTask, int paramInt)
  {
    if ((paramDownloadTask.b()) && (!paramDownloadTask.jdField_i_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DownloaderFactory", 2, "no need to call onDone");
      }
      return;
    }
    if (paramDownloadTask.b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("DownloaderFactory", 2, "canceled");
      }
      paramDownloadTask.a(2);
      paramDownloadTask.c();
      if (QLog.isColorLevel()) {
        QLog.d("DownloaderFactory", 2, "onDoned");
      }
      paramDownloadTask.f();
      return;
    }
    if (paramInt == 0) {}
    for (paramInt = 3;; paramInt = -1)
    {
      paramDownloadTask.a(paramInt);
      break;
    }
  }
  
  private static void a(DownloadTask paramDownloadTask, Context paramContext, int paramInt, File paramFile, DownloadInfo paramDownloadInfo)
  {
    if ((paramInt != 0) && (!paramDownloadTask.b()) && (paramDownloadTask.jdField_e_of_type_Boolean))
    {
      if (!paramDownloadInfo.isIPUrl) {
        break label120;
      }
      if (TextUtils.isEmpty(paramDownloadInfo.ip)) {
        break label92;
      }
      InnerDns.getInstance().reportBadIp(paramDownloadInfo.host, paramDownloadInfo.ip, ((Integer)jdField_a_of_type_JavaUtilMap.get(paramDownloadInfo.host)).intValue());
    }
    for (;;)
    {
      a(paramDownloadInfo.reqUrl, paramFile.getName(), -1, paramContext);
      paramDownloadTask.jdField_d_of_type_Boolean = false;
      return;
      label92:
      FMTSrvAddrProvider localFMTSrvAddrProvider = FMTSrvAddrProvider.getInstance();
      if (localFMTSrvAddrProvider != null) {
        localFMTSrvAddrProvider.onFailed(paramDownloadInfo.domainType, paramDownloadInfo.reqUrl);
      }
    }
    label120:
    paramDownloadTask.jdField_d_of_type_Boolean = true;
  }
  
  private static void a(DownloadTask paramDownloadTask, File paramFile, HttpResponse paramHttpResponse)
  {
    if ((paramDownloadTask.j) && (paramHttpResponse.containsHeader("last-modified")))
    {
      paramHttpResponse = paramHttpResponse.getFirstHeader("last-modified").getValue();
      if (TextUtils.isEmpty(paramHttpResponse)) {}
    }
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("E,d MMM y HH:mm:ss 'GMT'", Locale.US);
      localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
      long l = localSimpleDateFormat.parse(paramHttpResponse).getTime();
      paramFile.setLastModified(l);
      paramDownloadTask.jdField_i_of_type_Long = l;
      if (QLog.isColorLevel()) {
        QLog.d("DownloaderFactory", 2, "doTask |set lastModifyTime=" + l + ",fileName=" + paramFile.getName() + ",lastModify=" + paramFile.lastModified());
      }
      return;
    }
    catch (Exception paramDownloadTask)
    {
      QLog.e("DownloaderFactory", 1, "doTask | set lastModify=" + paramHttpResponse + ",exception msg=" + paramDownloadTask.getMessage());
    }
  }
  
  private static void a(DownloadTask paramDownloadTask, String paramString1, Context paramContext, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, int paramInt2, long paramLong2, long paramLong3, HashMap<String, String> paramHashMap, String paramString2, String paramString3)
  {
    Object localObject = paramHashMap;
    if (paramHashMap == null) {
      localObject = new HashMap();
    }
    ((HashMap)localObject).put("param_Url", paramString2);
    ((HashMap)localObject).put("param_FailCode", String.valueOf(paramDownloadTask.jdField_a_of_type_Int));
    ((HashMap)localObject).put("param_HttpCode", String.valueOf(paramDownloadTask.jdField_f_of_type_Int));
    ((HashMap)localObject).put("param_TryCount", String.valueOf(paramInt2));
    ((HashMap)localObject).put("param_ContentLen", String.valueOf(paramLong2));
    ((HashMap)localObject).put("param_TaskDownSize", String.valueOf(paramDownloadTask.jdField_a_of_type_JavaUtilList.size()));
    ((HashMap)localObject).put("param_BusinessCode", paramDownloadTask.jdField_f_of_type_JavaLangString);
    ((HashMap)localObject).put("param_Executed", Boolean.toString(paramBoolean1));
    ((HashMap)localObject).put("param_UrlType", paramString3);
    paramHashMap = "";
    if (!TextUtils.isEmpty(paramDownloadTask.jdField_b_of_type_JavaLangString))
    {
      ((HashMap)localObject).put("param_ErrMsg", paramDownloadTask.jdField_b_of_type_JavaLangString);
      paramHashMap = paramDownloadTask.jdField_b_of_type_JavaLangString;
    }
    if (paramInt1 == 0) {}
    for (boolean bool = true;; bool = false)
    {
      long l = System.currentTimeMillis();
      if ((paramContext != null) && (!TextUtils.isEmpty(paramString1))) {}
      try
      {
        VasReportUtils.a("downloadfactoryType", paramString2, paramDownloadTask.jdField_a_of_type_Int + "", paramLong2 + "", paramDownloadTask.jdField_f_of_type_JavaLangString, paramBoolean1 + "", paramHashMap, paramString3, "", "8.5.5");
        if ((paramDownloadTask.jdField_g_of_type_Int == 3) && (paramBoolean2))
        {
          paramHashMap = (ITraceReportHelper)QRoute.api(ITraceReportHelper.class);
          paramHashMap.endSpan(30, paramDownloadTask.jdField_c_of_type_JavaLangString, 300, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getTraceDownloadErrCode(paramDownloadTask.jdField_a_of_type_Int), new Object[] { "task done, errCode:", Integer.valueOf(paramDownloadTask.jdField_a_of_type_Int), ",httpCode:", Integer.valueOf(paramDownloadTask.jdField_f_of_type_Int) });
          if (paramDownloadTask.jdField_a_of_type_Int == 0) {
            paramHashMap.endTrace(30, paramDownloadTask.jdField_c_of_type_JavaLangString);
          }
        }
        paramString2 = "VipDownload700";
        paramHashMap = paramString2;
        if (!TextUtils.isEmpty(paramDownloadTask.jdField_f_of_type_JavaLangString))
        {
          paramHashMap = paramString2;
          if (paramDownloadTask.jdField_f_of_type_JavaLangString.contains("apollo"))
          {
            paramHashMap = "CMShowDownload";
            ((HashMap)localObject).put("param_https", String.valueOf(paramDownloadTask.r));
            ((HashMap)localObject).put("param_AddRandom", String.valueOf(paramDownloadTask.q));
          }
        }
        StatisticCollector.getInstance(paramContext).collectPerformance(paramString1, paramHashMap, bool, l - paramLong1, paramLong3, (HashMap)localObject, "", false);
        return;
      }
      catch (Throwable paramDownloadTask) {}
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = Integer.toString(NetworkUtil.a(paramContext));
    if (paramString2 != null) {}
    for (;;)
    {
      ReportController.b(null, "P_CliOper", "VipDownload", "0", "VipDownload", "ip", 0, paramInt, "", paramContext, paramString2, paramString1);
      return;
      paramString2 = "unknow";
    }
  }
  
  private static void a(HttpEntity paramHttpEntity, InputStream paramInputStream, BufferedOutputStream paramBufferedOutputStream, String paramString)
  {
    if (paramHttpEntity != null) {}
    try
    {
      paramHttpEntity.consumeContent();
      if (paramInputStream == null) {}
    }
    catch (Exception paramHttpEntity)
    {
      try
      {
        paramInputStream.close();
        if (paramBufferedOutputStream != null) {}
        try
        {
          paramBufferedOutputStream.close();
          return;
        }
        catch (Exception paramHttpEntity)
        {
          QLog.e("DownloaderFactory", 1, "doTask closeStream | download buffFileOS close io stream exception=" + paramHttpEntity.getMessage() + ", downloadUrl=" + paramString);
        }
        paramHttpEntity = paramHttpEntity;
        QLog.e("DownloaderFactory", 1, "doTask closeStream | download close io stream exception=" + paramHttpEntity.getMessage() + ", downloadUrl=" + paramString);
      }
      catch (Exception paramHttpEntity)
      {
        for (;;)
        {
          QLog.e("DownloaderFactory", 1, "doTask closeStream | download is close io stream exception=" + paramHttpEntity.getMessage() + ", downloadUrl=" + paramString);
        }
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      int i = NetworkUtil.a(paramContext);
      if (QLog.isColorLevel()) {
        QLog.d("DownloaderFactory", 2, "isQualityNetwork type=" + i);
      }
      if ((i != 3) && (i != 4))
      {
        bool1 = bool2;
        if (i != 1) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {
      return false;
    }
    if ((paramDownloadTask.jdField_a_of_type_JavaUtilList == null) || (paramDownloadTask.jdField_a_of_type_JavaUtilMap == null) || (paramDownloadTask.jdField_a_of_type_JavaUtilList.size() < 1) || (paramDownloadTask.jdField_a_of_type_JavaUtilMap.size() < 1) || (TextUtils.isEmpty(paramDownloadTask.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    paramDownloadTask = paramDownloadTask.jdField_a_of_type_JavaUtilList.iterator();
    while (paramDownloadTask.hasNext())
    {
      String str = (String)paramDownloadTask.next();
      if ((TextUtils.isEmpty(str)) || (!URLUtil.isNetworkUrl(str))) {
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  public static boolean a(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_0
    //   4: istore 7
    //   6: iconst_0
    //   7: istore 8
    //   9: iload 8
    //   11: istore 6
    //   13: aload_0
    //   14: ifnull +18 -> 32
    //   17: aload_0
    //   18: invokevirtual 306	java/io/File:exists	()Z
    //   21: istore 6
    //   23: iload 6
    //   25: ifne +13 -> 38
    //   28: iload 8
    //   30: istore 6
    //   32: ldc 2
    //   34: monitorexit
    //   35: iload 6
    //   37: ireturn
    //   38: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   41: lstore 13
    //   43: aload_1
    //   44: invokevirtual 306	java/io/File:exists	()Z
    //   47: ifeq +368 -> 415
    //   50: aload_1
    //   51: invokevirtual 1194	java/io/File:listFiles	()[Ljava/io/File;
    //   54: astore 15
    //   56: iconst_0
    //   57: istore_3
    //   58: iload_3
    //   59: aload 15
    //   61: arraylength
    //   62: if_icmpge +358 -> 420
    //   65: aload 15
    //   67: iload_3
    //   68: aaload
    //   69: astore 16
    //   71: aload 16
    //   73: invokevirtual 309	java/io/File:isDirectory	()Z
    //   76: ifeq +57 -> 133
    //   79: aload 16
    //   81: invokevirtual 1194	java/io/File:listFiles	()[Ljava/io/File;
    //   84: astore 17
    //   86: aload 17
    //   88: ifnull +535 -> 623
    //   91: aload 17
    //   93: arraylength
    //   94: istore 5
    //   96: iconst_0
    //   97: istore 4
    //   99: iload 4
    //   101: iload 5
    //   103: if_icmpge +21 -> 124
    //   106: aload 17
    //   108: iload 4
    //   110: aaload
    //   111: invokevirtual 312	java/io/File:delete	()Z
    //   114: pop
    //   115: iload 4
    //   117: iconst_1
    //   118: iadd
    //   119: istore 4
    //   121: goto -22 -> 99
    //   124: aload 16
    //   126: invokevirtual 312	java/io/File:delete	()Z
    //   129: pop
    //   130: goto +493 -> 623
    //   133: aload 15
    //   135: iload_3
    //   136: aaload
    //   137: invokevirtual 312	java/io/File:delete	()Z
    //   140: pop
    //   141: goto +482 -> 623
    //   144: astore 15
    //   146: ldc 73
    //   148: iconst_2
    //   149: new 130	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 1196
    //   159: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_1
    //   163: invokevirtual 320	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   166: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 15
    //   171: invokevirtual 1067	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   174: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: iload 7
    //   185: istore_2
    //   186: invokestatic 1202	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   189: invokestatic 1205	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   192: if_acmpeq +158 -> 350
    //   195: aload_0
    //   196: invokevirtual 555	java/io/File:length	()J
    //   199: lstore 11
    //   201: aload_0
    //   202: invokevirtual 320	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   205: invokestatic 1210	com/tencent/open/base/MD5Utils:encodeFileHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   208: astore 17
    //   210: aconst_null
    //   211: astore 16
    //   213: lload 11
    //   215: ldc2_w 1211
    //   218: lcmp
    //   219: ifle +277 -> 496
    //   222: ldc2_w 1211
    //   225: lstore 9
    //   227: lload 9
    //   229: l2i
    //   230: newarray char
    //   232: astore 18
    //   234: new 1214	java/io/FileInputStream
    //   237: dup
    //   238: aload_0
    //   239: invokespecial 1217	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   242: astore_0
    //   243: new 1219	java/io/InputStreamReader
    //   246: dup
    //   247: aload_0
    //   248: ldc_w 1221
    //   251: invokespecial 1224	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   254: astore 15
    //   256: aload 15
    //   258: aload 18
    //   260: invokevirtual 1227	java/io/InputStreamReader:read	([C)I
    //   263: pop
    //   264: aload_0
    //   265: ifnull +7 -> 272
    //   268: aload_0
    //   269: invokevirtual 1170	java/io/InputStream:close	()V
    //   272: aload 15
    //   274: ifnull +8 -> 282
    //   277: aload 15
    //   279: invokevirtual 1228	java/io/InputStreamReader:close	()V
    //   282: ldc 73
    //   284: iconst_2
    //   285: new 130	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   292: ldc_w 1196
    //   295: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload_1
    //   299: invokevirtual 320	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   302: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc_w 1230
    //   308: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: lload 11
    //   313: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   316: ldc_w 1232
    //   319: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload 17
    //   324: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: ldc_w 1234
    //   330: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload 18
    //   335: invokestatic 1237	java/lang/String:valueOf	([C)Ljava/lang/String;
    //   338: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: iload 7
    //   349: istore_2
    //   350: iload_2
    //   351: istore 6
    //   353: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq -324 -> 32
    //   359: ldc 73
    //   361: iconst_2
    //   362: new 130	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   369: ldc_w 1239
    //   372: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   378: lload 13
    //   380: lsub
    //   381: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   384: ldc_w 1241
    //   387: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload_1
    //   391: invokevirtual 320	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   394: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: iload_2
    //   404: istore 6
    //   406: goto -374 -> 32
    //   409: astore_0
    //   410: ldc 2
    //   412: monitorexit
    //   413: aload_0
    //   414: athrow
    //   415: aload_1
    //   416: invokevirtual 315	java/io/File:mkdirs	()Z
    //   419: pop
    //   420: aload_0
    //   421: new 130	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   428: aload_1
    //   429: invokevirtual 320	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   432: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: getstatic 1245	java/io/File:separatorChar	C
    //   438: invokevirtual 1248	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   441: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 1253	com/tencent/biz/common/util/ZipUtils:unZipFile	(Ljava/io/File;Ljava/lang/String;)V
    //   447: iload_2
    //   448: ifeq +8 -> 456
    //   451: aload_0
    //   452: invokevirtual 312	java/io/File:delete	()Z
    //   455: pop
    //   456: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq +32 -> 491
    //   462: ldc 73
    //   464: iconst_2
    //   465: new 130	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   472: ldc_w 1255
    //   475: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: aload_1
    //   479: invokevirtual 320	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   482: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   491: iconst_1
    //   492: istore_2
    //   493: goto -143 -> 350
    //   496: lload 11
    //   498: lstore 9
    //   500: goto -273 -> 227
    //   503: astore_0
    //   504: aconst_null
    //   505: astore 15
    //   507: aconst_null
    //   508: astore_0
    //   509: aload 15
    //   511: ifnull +8 -> 519
    //   514: aload 15
    //   516: invokevirtual 1170	java/io/InputStream:close	()V
    //   519: aload_0
    //   520: ifnull -238 -> 282
    //   523: aload_0
    //   524: invokevirtual 1228	java/io/InputStreamReader:close	()V
    //   527: goto -245 -> 282
    //   530: astore_0
    //   531: goto -249 -> 282
    //   534: astore_1
    //   535: aconst_null
    //   536: astore_0
    //   537: aload 16
    //   539: astore 15
    //   541: aload_0
    //   542: ifnull +7 -> 549
    //   545: aload_0
    //   546: invokevirtual 1170	java/io/InputStream:close	()V
    //   549: aload 15
    //   551: ifnull +8 -> 559
    //   554: aload 15
    //   556: invokevirtual 1228	java/io/InputStreamReader:close	()V
    //   559: aload_1
    //   560: athrow
    //   561: astore_0
    //   562: goto -290 -> 272
    //   565: astore_0
    //   566: goto -284 -> 282
    //   569: astore 15
    //   571: goto -52 -> 519
    //   574: astore_0
    //   575: goto -26 -> 549
    //   578: astore_0
    //   579: goto -20 -> 559
    //   582: astore_1
    //   583: aload 16
    //   585: astore 15
    //   587: goto -46 -> 541
    //   590: astore_1
    //   591: goto -50 -> 541
    //   594: astore 15
    //   596: aconst_null
    //   597: astore 16
    //   599: aload_0
    //   600: astore 15
    //   602: aload 16
    //   604: astore_0
    //   605: goto -96 -> 509
    //   608: astore 16
    //   610: aload_0
    //   611: astore 16
    //   613: aload 15
    //   615: astore_0
    //   616: aload 16
    //   618: astore 15
    //   620: goto -111 -> 509
    //   623: iload_3
    //   624: iconst_1
    //   625: iadd
    //   626: istore_3
    //   627: goto -569 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	630	0	paramFile1	File
    //   0	630	1	paramFile2	File
    //   0	630	2	paramBoolean	boolean
    //   57	570	3	i	int
    //   97	23	4	j	int
    //   94	10	5	k	int
    //   11	394	6	bool1	boolean
    //   4	344	7	bool2	boolean
    //   7	22	8	bool3	boolean
    //   225	274	9	l1	long
    //   199	298	11	l2	long
    //   41	338	13	l3	long
    //   54	80	15	arrayOfFile	File[]
    //   144	26	15	localException1	Exception
    //   254	301	15	localObject1	Object
    //   569	1	15	localException2	Exception
    //   585	1	15	localObject2	Object
    //   594	1	15	localException3	Exception
    //   600	19	15	localObject3	Object
    //   69	534	16	localFile1	File
    //   608	1	16	localException4	Exception
    //   611	6	16	localFile2	File
    //   84	239	17	localObject4	Object
    //   232	102	18	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   43	56	144	java/lang/Exception
    //   58	65	144	java/lang/Exception
    //   71	86	144	java/lang/Exception
    //   91	96	144	java/lang/Exception
    //   106	115	144	java/lang/Exception
    //   124	130	144	java/lang/Exception
    //   133	141	144	java/lang/Exception
    //   415	420	144	java/lang/Exception
    //   420	447	144	java/lang/Exception
    //   451	456	144	java/lang/Exception
    //   456	491	144	java/lang/Exception
    //   17	23	409	finally
    //   38	43	409	finally
    //   43	56	409	finally
    //   58	65	409	finally
    //   71	86	409	finally
    //   91	96	409	finally
    //   106	115	409	finally
    //   124	130	409	finally
    //   133	141	409	finally
    //   146	183	409	finally
    //   186	210	409	finally
    //   227	234	409	finally
    //   268	272	409	finally
    //   277	282	409	finally
    //   282	347	409	finally
    //   353	403	409	finally
    //   415	420	409	finally
    //   420	447	409	finally
    //   451	456	409	finally
    //   456	491	409	finally
    //   514	519	409	finally
    //   523	527	409	finally
    //   545	549	409	finally
    //   554	559	409	finally
    //   559	561	409	finally
    //   234	243	503	java/lang/Exception
    //   523	527	530	java/lang/Exception
    //   234	243	534	finally
    //   268	272	561	java/lang/Exception
    //   277	282	565	java/lang/Exception
    //   514	519	569	java/lang/Exception
    //   545	549	574	java/lang/Exception
    //   554	559	578	java/lang/Exception
    //   243	256	582	finally
    //   256	264	590	finally
    //   243	256	594	java/lang/Exception
    //   256	264	608	java/lang/Exception
  }
  
  public static boolean a(String paramString)
  {
    int i;
    if (b.containsKey(paramString)) {
      i = ((Integer)b.get(paramString)).intValue();
    }
    while (i > 0) {
      if ((int)(System.currentTimeMillis() / 1000L) < i + 600)
      {
        return true;
        i = 0;
      }
      else
      {
        b.remove(paramString);
        return false;
      }
    }
    return false;
  }
  
  public static boolean b(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (paramString.indexOf('?') > -1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  /* Error */
  public DownloaderInterface a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: getstatic 46	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   5: ifnull +397 -> 402
    //   8: getstatic 46	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   11: astore_3
    //   12: aload_3
    //   13: monitorenter
    //   14: iload_1
    //   15: tableswitch	default:+33 -> 48, 1:+37->52, 2:+111->126, 3:+180->195, 4:+249->264, 5:+318->333
    //   49: monitorexit
    //   50: aload_2
    //   51: areturn
    //   52: getstatic 46	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   55: iload_1
    //   56: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   59: invokevirtual 1256	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   62: ifeq +20 -> 82
    //   65: getstatic 46	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   68: iload_1
    //   69: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   72: invokevirtual 1257	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   75: checkcast 1263	com/tencent/mobileqq/vip/DownloaderInterface
    //   78: astore_2
    //   79: goto -31 -> 48
    //   82: new 1265	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig
    //   85: dup
    //   86: iconst_0
    //   87: invokespecial 1268	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:<init>	(Z)V
    //   90: astore_2
    //   91: new 1270	com/tencent/mobileqq/vip/QueueDownloader
    //   94: dup
    //   95: invokestatic 1273	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   98: invokevirtual 1277	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   101: aload_2
    //   102: invokespecial 1280	com/tencent/mobileqq/vip/QueueDownloader:<init>	(Lmqq/app/AppRuntime;Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;)V
    //   105: astore_2
    //   106: getstatic 46	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   109: iload_1
    //   110: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: aload_2
    //   114: invokevirtual 925	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   117: pop
    //   118: goto -70 -> 48
    //   121: astore_2
    //   122: aload_3
    //   123: monitorexit
    //   124: aload_2
    //   125: athrow
    //   126: getstatic 46	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   129: iload_1
    //   130: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   133: invokevirtual 1256	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   136: ifeq +20 -> 156
    //   139: getstatic 46	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   142: iload_1
    //   143: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   146: invokevirtual 1257	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   149: checkcast 1263	com/tencent/mobileqq/vip/DownloaderInterface
    //   152: astore_2
    //   153: goto -105 -> 48
    //   156: new 1265	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig
    //   159: dup
    //   160: iconst_0
    //   161: invokespecial 1268	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:<init>	(Z)V
    //   164: astore_2
    //   165: new 1270	com/tencent/mobileqq/vip/QueueDownloader
    //   168: dup
    //   169: invokestatic 1273	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   172: invokevirtual 1277	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   175: aload_2
    //   176: invokespecial 1280	com/tencent/mobileqq/vip/QueueDownloader:<init>	(Lmqq/app/AppRuntime;Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;)V
    //   179: astore_2
    //   180: getstatic 46	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   183: iload_1
    //   184: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   187: aload_2
    //   188: invokevirtual 925	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   191: pop
    //   192: goto -144 -> 48
    //   195: getstatic 46	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   198: iload_1
    //   199: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   202: invokevirtual 1256	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   205: ifeq +20 -> 225
    //   208: getstatic 46	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   211: iload_1
    //   212: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   215: invokevirtual 1257	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   218: checkcast 1263	com/tencent/mobileqq/vip/DownloaderInterface
    //   221: astore_2
    //   222: goto -174 -> 48
    //   225: new 1265	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig
    //   228: dup
    //   229: iconst_0
    //   230: invokespecial 1268	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:<init>	(Z)V
    //   233: astore_2
    //   234: new 1282	com/tencent/mobileqq/apollo/ApolloQueueDownloader
    //   237: dup
    //   238: invokestatic 1273	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   241: invokevirtual 1277	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   244: aload_2
    //   245: invokespecial 1283	com/tencent/mobileqq/apollo/ApolloQueueDownloader:<init>	(Lmqq/app/AppRuntime;Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;)V
    //   248: astore_2
    //   249: getstatic 46	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   252: iload_1
    //   253: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   256: aload_2
    //   257: invokevirtual 925	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   260: pop
    //   261: goto -213 -> 48
    //   264: getstatic 46	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   267: iload_1
    //   268: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   271: invokevirtual 1256	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   274: ifeq +20 -> 294
    //   277: getstatic 46	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   280: iload_1
    //   281: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   284: invokevirtual 1257	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   287: checkcast 1263	com/tencent/mobileqq/vip/DownloaderInterface
    //   290: astore_2
    //   291: goto -243 -> 48
    //   294: new 1265	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig
    //   297: dup
    //   298: iconst_0
    //   299: invokespecial 1268	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:<init>	(Z)V
    //   302: astore_2
    //   303: new 1282	com/tencent/mobileqq/apollo/ApolloQueueDownloader
    //   306: dup
    //   307: invokestatic 1273	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   310: invokevirtual 1277	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   313: aload_2
    //   314: invokespecial 1283	com/tencent/mobileqq/apollo/ApolloQueueDownloader:<init>	(Lmqq/app/AppRuntime;Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;)V
    //   317: astore_2
    //   318: getstatic 46	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   321: iload_1
    //   322: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   325: aload_2
    //   326: invokevirtual 925	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   329: pop
    //   330: goto -282 -> 48
    //   333: getstatic 46	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   336: iload_1
    //   337: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   340: invokevirtual 1256	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   343: ifeq +20 -> 363
    //   346: getstatic 46	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   349: iload_1
    //   350: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   353: invokevirtual 1257	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   356: checkcast 1263	com/tencent/mobileqq/vip/DownloaderInterface
    //   359: astore_2
    //   360: goto -312 -> 48
    //   363: new 1265	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig
    //   366: dup
    //   367: iconst_0
    //   368: invokespecial 1268	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:<init>	(Z)V
    //   371: astore_2
    //   372: new 1270	com/tencent/mobileqq/vip/QueueDownloader
    //   375: dup
    //   376: invokestatic 1273	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   379: invokevirtual 1277	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   382: aload_2
    //   383: invokespecial 1280	com/tencent/mobileqq/vip/QueueDownloader:<init>	(Lmqq/app/AppRuntime;Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;)V
    //   386: astore_2
    //   387: getstatic 46	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   390: iload_1
    //   391: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   394: aload_2
    //   395: invokevirtual 925	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   398: pop
    //   399: goto -351 -> 48
    //   402: aconst_null
    //   403: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	this	DownloaderFactory
    //   0	404	1	paramInt	int
    //   1	113	2	localObject1	Object
    //   121	4	2	localObject2	Object
    //   152	243	2	localObject3	Object
    //   11	112	3	localConcurrentHashMap	ConcurrentHashMap
    // Exception table:
    //   from	to	target	type
    //   48	50	121	finally
    //   52	79	121	finally
    //   82	118	121	finally
    //   122	124	121	finally
    //   126	153	121	finally
    //   156	192	121	finally
    //   195	222	121	finally
    //   225	261	121	finally
    //   264	291	121	finally
    //   294	330	121	finally
    //   333	360	121	finally
    //   363	399	121	finally
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DownloaderFactory", 2, "onDestroy...");
    }
    synchronized (b)
    {
      b.clear();
      synchronized (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        if (localIterator.hasNext()) {
          ((DownloaderInterface)((Map.Entry)localIterator.next()).getValue()).b();
        }
      }
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.DownloaderFactory
 * JD-Core Version:    0.7.0.1
 */