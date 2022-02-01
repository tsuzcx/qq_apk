package com.tencent.mobileqq.statistics;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.QuickAuthorityConfBean;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.monitor.crash.QQCrashCallback;
import com.tencent.qqperf.monitor.crash.QQCrashReportManager;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import com.tencent.qqperf.monitor.fd.FdCounter;
import com.tencent.qqperf.repoter.ReporterMachine;
import com.tencent.qqperf.repoter.ResultObject;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class FDStats
  implements Handler.Callback, QQCrashCallback
{
  static String b;
  private static long c = 1800000L;
  private static volatile FDStats d;
  private static ThreadLocal<SimpleDateFormat> e = new FDStats.1();
  private static String s;
  private static final String[] t = { "/proc/net/tcp6", "/proc/net/udp6", "/proc/net/tcp", "/proc/net/udp" };
  private static final int[] u = { 4113, 4113, 4097, 4097 };
  AtomicBoolean a = new AtomicBoolean(false);
  private String f;
  private String g;
  private Handler h;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private int l = 0;
  private int m = 0;
  private int n = 0;
  private QQCustomDialog o;
  private FDStatsInspector p;
  private String q;
  private FdCounter r;
  
  private FDStats()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/proc/");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append("/fd");
    this.f = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("ls -l ");
    localStringBuilder.append(this.f);
    this.g = localStringBuilder.toString();
    this.p = new FDStatsInspector();
    this.r = new FdCounter();
    this.h = new Handler(ThreadManager.getFileThreadLooper(), this);
  }
  
  static long a(File paramFile, boolean paramBoolean)
  {
    paramFile = paramFile.getName();
    try
    {
      paramFile = paramFile.substring(paramFile.lastIndexOf("/") + 1);
      if ((!paramFile.endsWith(".txt")) && ((!paramBoolean) || (!paramFile.endsWith(".zip"))))
      {
        if (paramFile.endsWith(".socket")) {
          return Long.valueOf(paramFile.substring(0, paramFile.length() - 7)).longValue();
        }
      }
      else
      {
        long l1 = Long.valueOf(paramFile.substring(0, paramFile.length() - 4)).longValue();
        return l1;
      }
    }
    catch (Exception paramFile)
    {
      label91:
      break label91;
    }
    return -1L;
  }
  
  public static FDStats a()
  {
    if (d == null) {
      try
      {
        if (d == null)
        {
          d = new FDStats();
          if (QQCrashReportManager.e == null) {
            QQCrashReportManager.e = d;
          }
        }
      }
      finally {}
    }
    return d;
  }
  
  /* Error */
  private String a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 210	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: astore 11
    //   5: new 91	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 212
    //   11: invokespecial 215	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: astore 15
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield 87	com/tencent/mobileqq/statistics/FDStats:m	I
    //   21: invokestatic 220	java/lang/System:currentTimeMillis	()J
    //   24: lstore 7
    //   26: new 222	com/tencent/mobileqq/statistics/FDStatsTree
    //   29: dup
    //   30: invokespecial 223	com/tencent/mobileqq/statistics/FDStatsTree:<init>	()V
    //   33: astore 14
    //   35: aload 11
    //   37: aload_1
    //   38: invokevirtual 227	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   41: invokevirtual 233	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   44: astore_1
    //   45: new 235	java/io/BufferedReader
    //   48: dup
    //   49: new 237	java/io/InputStreamReader
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 240	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   57: invokespecial 243	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   60: astore 11
    //   62: aload 11
    //   64: invokevirtual 246	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   67: astore 13
    //   69: aload 13
    //   71: ifnull +140 -> 211
    //   74: aload 13
    //   76: ldc 248
    //   78: invokevirtual 251	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   81: istore 4
    //   83: aload 13
    //   85: astore 12
    //   87: iload 4
    //   89: ifle +19 -> 108
    //   92: aload 13
    //   94: iload 4
    //   96: iconst_2
    //   97: iadd
    //   98: aload 13
    //   100: invokevirtual 173	java/lang/String:length	()I
    //   103: invokevirtual 176	java/lang/String:substring	(II)Ljava/lang/String;
    //   106: astore 12
    //   108: aload 14
    //   110: aload 12
    //   112: invokevirtual 253	com/tencent/mobileqq/statistics/FDStatsTree:a	(Ljava/lang/String;)V
    //   115: new 91	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   122: astore 13
    //   124: aload 13
    //   126: aload 12
    //   128: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 13
    //   134: ldc 255
    //   136: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 15
    //   142: aload 13
    //   144: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_0
    //   152: aload_0
    //   153: getfield 87	com/tencent/mobileqq/statistics/FDStats:m	I
    //   156: iconst_1
    //   157: iadd
    //   158: putfield 87	com/tencent/mobileqq/statistics/FDStats:m	I
    //   161: iload_3
    //   162: ifeq -100 -> 62
    //   165: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq -106 -> 62
    //   171: new 91	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   178: astore 13
    //   180: aload 13
    //   182: aload 12
    //   184: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 13
    //   190: ldc 255
    //   192: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: ldc_w 263
    //   199: iconst_2
    //   200: aload 13
    //   202: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 266	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: goto -146 -> 62
    //   211: aload_0
    //   212: getfield 87	com/tencent/mobileqq/statistics/FDStats:m	I
    //   215: ifne +261 -> 476
    //   218: new 147	java/io/File
    //   221: dup
    //   222: aload_0
    //   223: getfield 115	com/tencent/mobileqq/statistics/FDStats:f	Ljava/lang/String;
    //   226: invokespecial 267	java/io/File:<init>	(Ljava/lang/String;)V
    //   229: astore 12
    //   231: aload 12
    //   233: invokevirtual 271	java/io/File:list	()[Ljava/lang/String;
    //   236: ifnonnull +46 -> 282
    //   239: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   242: ifeq +40 -> 282
    //   245: new 91	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   252: astore 13
    //   254: aload 13
    //   256: ldc_w 273
    //   259: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload 13
    //   265: iconst_0
    //   266: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: ldc_w 263
    //   273: iconst_2
    //   274: aload 13
    //   276: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 266	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: getstatic 281	android/os/Build$VERSION:SDK_INT	I
    //   285: bipush 21
    //   287: if_icmplt +1249 -> 1536
    //   290: iconst_1
    //   291: istore 4
    //   293: goto +3 -> 296
    //   296: aload 12
    //   298: invokevirtual 285	java/io/File:listFiles	()[Ljava/io/File;
    //   301: astore 13
    //   303: aload 13
    //   305: ifnull +171 -> 476
    //   308: new 91	java/lang/StringBuilder
    //   311: dup
    //   312: sipush 200
    //   315: invokespecial 288	java/lang/StringBuilder:<init>	(I)V
    //   318: astore 14
    //   320: aload 14
    //   322: ldc_w 290
    //   325: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: iconst_0
    //   330: istore 5
    //   332: iconst_0
    //   333: istore 6
    //   335: iload 5
    //   337: aload 13
    //   339: arraylength
    //   340: if_icmpge +119 -> 459
    //   343: aload 13
    //   345: iload 5
    //   347: aaload
    //   348: astore 16
    //   350: iload 4
    //   352: ifeq +16 -> 368
    //   355: aload 16
    //   357: invokevirtual 293	java/io/File:getPath	()Ljava/lang/String;
    //   360: invokestatic 299	android/system/Os:readlink	(Ljava/lang/String;)Ljava/lang/String;
    //   363: astore 12
    //   365: goto +10 -> 375
    //   368: aload 16
    //   370: invokevirtual 302	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   373: astore 12
    //   375: new 91	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   382: astore 17
    //   384: aload 17
    //   386: aload 12
    //   388: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload 17
    //   394: ldc 255
    //   396: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload 15
    //   402: aload 17
    //   404: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: goto +29 -> 440
    //   414: aload 14
    //   416: ldc_w 304
    //   419: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload 14
    //   425: aload 16
    //   427: invokevirtual 293	java/io/File:getPath	()Ljava/lang/String;
    //   430: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: iload 6
    //   436: iconst_1
    //   437: iadd
    //   438: istore 6
    //   440: aload_0
    //   441: aload_0
    //   442: getfield 87	com/tencent/mobileqq/statistics/FDStats:m	I
    //   445: iconst_1
    //   446: iadd
    //   447: putfield 87	com/tencent/mobileqq/statistics/FDStats:m	I
    //   450: iload 5
    //   452: iconst_1
    //   453: iadd
    //   454: istore 5
    //   456: goto -121 -> 335
    //   459: iload 6
    //   461: ifle +15 -> 476
    //   464: ldc_w 263
    //   467: iconst_2
    //   468: aload 15
    //   470: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 306	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: new 91	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   483: astore 12
    //   485: aload 12
    //   487: ldc_w 308
    //   490: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload 12
    //   496: aload_0
    //   497: getfield 87	com/tencent/mobileqq/statistics/FDStats:m	I
    //   500: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: aload 15
    //   506: aload 12
    //   508: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: new 91	java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   522: astore 12
    //   524: aload 12
    //   526: ldc_w 310
    //   529: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload 12
    //   535: aload_0
    //   536: getfield 85	com/tencent/mobileqq/statistics/FDStats:l	I
    //   539: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: aload 15
    //   545: aload 12
    //   547: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: new 91	java/lang/StringBuilder
    //   557: dup
    //   558: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   561: astore 12
    //   563: aload 12
    //   565: ldc_w 312
    //   568: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: aload 12
    //   574: ldc_w 314
    //   577: lload 7
    //   579: invokestatic 320	android/text/format/DateFormat:format	(Ljava/lang/CharSequence;J)Ljava/lang/CharSequence;
    //   582: invokeinterface 323 1 0
    //   587: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: aload 15
    //   593: aload 12
    //   595: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: aload 15
    //   604: ldc_w 325
    //   607: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: new 91	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   618: astore 12
    //   620: aload 12
    //   622: ldc_w 327
    //   625: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: aload 12
    //   631: invokestatic 331	com/tencent/common/config/AppSetting:i	()Ljava/lang/String;
    //   634: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: pop
    //   638: aload 15
    //   640: aload 12
    //   642: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   645: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: pop
    //   649: new 91	java/lang/StringBuilder
    //   652: dup
    //   653: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   656: astore 12
    //   658: aload 12
    //   660: ldc_w 333
    //   663: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: pop
    //   667: aload 12
    //   669: iconst_2
    //   670: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   673: pop
    //   674: aload 12
    //   676: ldc_w 335
    //   679: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: pop
    //   683: aload 12
    //   685: aload_0
    //   686: getfield 89	com/tencent/mobileqq/statistics/FDStats:n	I
    //   689: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   692: pop
    //   693: aload 12
    //   695: ldc 255
    //   697: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: pop
    //   701: aload 15
    //   703: aload 12
    //   705: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   708: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: pop
    //   712: aload 11
    //   714: invokevirtual 338	java/io/BufferedReader:close	()V
    //   717: aload_1
    //   718: ifnull +272 -> 990
    //   721: aload_1
    //   722: invokevirtual 341	java/io/InputStream:close	()V
    //   725: goto +265 -> 990
    //   728: astore 12
    //   730: goto +743 -> 1473
    //   733: astore 14
    //   735: goto +46 -> 781
    //   738: astore 14
    //   740: goto +149 -> 889
    //   743: astore 12
    //   745: goto +23 -> 768
    //   748: astore 14
    //   750: aconst_null
    //   751: astore 11
    //   753: goto +28 -> 781
    //   756: astore 14
    //   758: aconst_null
    //   759: astore 11
    //   761: goto +128 -> 889
    //   764: astore 12
    //   766: aconst_null
    //   767: astore_1
    //   768: aconst_null
    //   769: astore 11
    //   771: goto +702 -> 1473
    //   774: astore 14
    //   776: aconst_null
    //   777: astore 11
    //   779: aconst_null
    //   780: astore_1
    //   781: aload 11
    //   783: astore 13
    //   785: aload_1
    //   786: astore 12
    //   788: new 91	java/lang/StringBuilder
    //   791: dup
    //   792: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   795: astore 16
    //   797: aload 11
    //   799: astore 13
    //   801: aload_1
    //   802: astore 12
    //   804: aload 16
    //   806: ldc_w 343
    //   809: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: pop
    //   813: aload 11
    //   815: astore 13
    //   817: aload_1
    //   818: astore 12
    //   820: aload 16
    //   822: aload 14
    //   824: invokevirtual 344	java/lang/NullPointerException:toString	()Ljava/lang/String;
    //   827: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: pop
    //   831: aload 11
    //   833: astore 13
    //   835: aload_1
    //   836: astore 12
    //   838: ldc_w 263
    //   841: iconst_2
    //   842: aload 16
    //   844: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   847: invokestatic 306	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   850: aload 11
    //   852: astore 13
    //   854: aload_1
    //   855: astore 12
    //   857: aload_0
    //   858: iconst_0
    //   859: putfield 87	com/tencent/mobileqq/statistics/FDStats:m	I
    //   862: aload 11
    //   864: ifnull +11 -> 875
    //   867: aload 11
    //   869: invokevirtual 338	java/io/BufferedReader:close	()V
    //   872: goto +3 -> 875
    //   875: aload_1
    //   876: ifnull +114 -> 990
    //   879: goto -158 -> 721
    //   882: astore 14
    //   884: aconst_null
    //   885: astore 11
    //   887: aconst_null
    //   888: astore_1
    //   889: aload 11
    //   891: astore 13
    //   893: aload_1
    //   894: astore 12
    //   896: new 91	java/lang/StringBuilder
    //   899: dup
    //   900: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   903: astore 16
    //   905: aload 11
    //   907: astore 13
    //   909: aload_1
    //   910: astore 12
    //   912: aload 16
    //   914: ldc_w 346
    //   917: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: pop
    //   921: aload 11
    //   923: astore 13
    //   925: aload_1
    //   926: astore 12
    //   928: aload 16
    //   930: aload 14
    //   932: invokevirtual 347	java/io/IOException:toString	()Ljava/lang/String;
    //   935: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: pop
    //   939: aload 11
    //   941: astore 13
    //   943: aload_1
    //   944: astore 12
    //   946: ldc_w 263
    //   949: iconst_2
    //   950: aload 16
    //   952: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   955: invokestatic 306	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   958: aload 11
    //   960: astore 13
    //   962: aload_1
    //   963: astore 12
    //   965: aload_0
    //   966: iconst_0
    //   967: putfield 87	com/tencent/mobileqq/statistics/FDStats:m	I
    //   970: aload 11
    //   972: ifnull +11 -> 983
    //   975: aload 11
    //   977: invokevirtual 338	java/io/BufferedReader:close	()V
    //   980: goto +3 -> 983
    //   983: aload_1
    //   984: ifnull +6 -> 990
    //   987: goto -266 -> 721
    //   990: new 349	com/tencent/qqperf/monitor/fd/FdTrie
    //   993: dup
    //   994: invokespecial 350	com/tencent/qqperf/monitor/fd/FdTrie:<init>	()V
    //   997: astore_1
    //   998: aload 15
    //   1000: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1003: ldc_w 352
    //   1006: invokevirtual 356	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1009: astore 11
    //   1011: aload 11
    //   1013: arraylength
    //   1014: istore 5
    //   1016: iconst_0
    //   1017: istore 4
    //   1019: iload 4
    //   1021: iload 5
    //   1023: if_icmpge +21 -> 1044
    //   1026: aload_1
    //   1027: aload 11
    //   1029: iload 4
    //   1031: aaload
    //   1032: invokevirtual 358	com/tencent/qqperf/monitor/fd/FdTrie:b	(Ljava/lang/String;)V
    //   1035: iload 4
    //   1037: iconst_1
    //   1038: iadd
    //   1039: istore 4
    //   1041: goto -22 -> 1019
    //   1044: aload_0
    //   1045: aload_0
    //   1046: getfield 129	com/tencent/mobileqq/statistics/FDStats:r	Lcom/tencent/qqperf/monitor/fd/FdCounter;
    //   1049: aload_1
    //   1050: invokevirtual 361	com/tencent/qqperf/monitor/fd/FdCounter:a	(Lcom/tencent/qqperf/monitor/fd/FdTrie;)Ljava/lang/String;
    //   1053: putfield 363	com/tencent/mobileqq/statistics/FDStats:q	Ljava/lang/String;
    //   1056: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1059: ifeq +39 -> 1098
    //   1062: new 91	java/lang/StringBuilder
    //   1065: dup
    //   1066: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1069: astore_1
    //   1070: aload_1
    //   1071: ldc_w 365
    //   1074: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: pop
    //   1078: aload_1
    //   1079: aload_0
    //   1080: getfield 363	com/tencent/mobileqq/statistics/FDStats:q	Ljava/lang/String;
    //   1083: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: pop
    //   1087: ldc_w 263
    //   1090: iconst_2
    //   1091: aload_1
    //   1092: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1095: invokestatic 367	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1098: getstatic 369	com/tencent/mobileqq/statistics/FDStats:s	Ljava/lang/String;
    //   1101: ifnonnull +37 -> 1138
    //   1104: new 91	java/lang/StringBuilder
    //   1107: dup
    //   1108: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1111: astore_1
    //   1112: aload_1
    //   1113: invokestatic 375	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1116: invokevirtual 379	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   1119: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1122: pop
    //   1123: aload_1
    //   1124: ldc_w 384
    //   1127: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1130: pop
    //   1131: aload_1
    //   1132: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1135: putstatic 369	com/tencent/mobileqq/statistics/FDStats:s	Ljava/lang/String;
    //   1138: invokestatic 375	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1141: ldc_w 386
    //   1144: iconst_0
    //   1145: invokevirtual 390	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1148: astore_1
    //   1149: aload_0
    //   1150: getfield 87	com/tencent/mobileqq/statistics/FDStats:m	I
    //   1153: ifne +75 -> 1228
    //   1156: aload_1
    //   1157: ldc_w 392
    //   1160: lconst_0
    //   1161: invokeinterface 398 4 0
    //   1166: lstore 9
    //   1168: invokestatic 220	java/lang/System:currentTimeMillis	()J
    //   1171: lload 9
    //   1173: lsub
    //   1174: ldc2_w 399
    //   1177: lcmp
    //   1178: ifle +95 -> 1273
    //   1181: invokestatic 375	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1184: invokevirtual 404	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   1187: invokestatic 410	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1190: aconst_null
    //   1191: ldc_w 412
    //   1194: iconst_1
    //   1195: lconst_0
    //   1196: lconst_0
    //   1197: aconst_null
    //   1198: aconst_null
    //   1199: invokevirtual 416	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1202: aload_1
    //   1203: invokeinterface 420 1 0
    //   1208: ldc_w 392
    //   1211: invokestatic 220	java/lang/System:currentTimeMillis	()J
    //   1214: invokeinterface 426 4 0
    //   1219: invokeinterface 429 1 0
    //   1224: pop
    //   1225: goto +48 -> 1273
    //   1228: new 431	java/util/HashMap
    //   1231: dup
    //   1232: iconst_1
    //   1233: invokespecial 432	java/util/HashMap:<init>	(I)V
    //   1236: astore_1
    //   1237: aload_1
    //   1238: ldc_w 434
    //   1241: aload_0
    //   1242: getfield 87	com/tencent/mobileqq/statistics/FDStats:m	I
    //   1245: invokestatic 436	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1248: invokevirtual 440	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1251: pop
    //   1252: invokestatic 375	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1255: invokevirtual 404	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   1258: invokestatic 410	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1261: aconst_null
    //   1262: ldc_w 442
    //   1265: iconst_1
    //   1266: lconst_0
    //   1267: lconst_0
    //   1268: aload_1
    //   1269: aconst_null
    //   1270: invokevirtual 416	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1273: iload_2
    //   1274: ifeq +139 -> 1413
    //   1277: invokestatic 447	com/tencent/mobileqq/statistics/FDStatsHooker:getAllStackTrace	()Ljava/lang/String;
    //   1280: astore_1
    //   1281: aload_1
    //   1282: invokestatic 453	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1285: ifne +19 -> 1304
    //   1288: aload 15
    //   1290: ldc_w 455
    //   1293: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1296: pop
    //   1297: aload 15
    //   1299: aload_1
    //   1300: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1303: pop
    //   1304: new 431	java/util/HashMap
    //   1307: dup
    //   1308: iconst_1
    //   1309: invokespecial 432	java/util/HashMap:<init>	(I)V
    //   1312: astore 11
    //   1314: aload_1
    //   1315: invokestatic 453	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1318: ifeq +10 -> 1328
    //   1321: ldc_w 457
    //   1324: astore_1
    //   1325: goto +11 -> 1336
    //   1328: aload_1
    //   1329: invokevirtual 173	java/lang/String:length	()I
    //   1332: invokestatic 436	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1335: astore_1
    //   1336: aload 11
    //   1338: ldc_w 459
    //   1341: aload_1
    //   1342: invokevirtual 440	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1345: pop
    //   1346: invokestatic 375	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1349: invokevirtual 404	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   1352: invokestatic 410	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1355: aconst_null
    //   1356: ldc_w 461
    //   1359: iconst_1
    //   1360: lconst_0
    //   1361: lconst_0
    //   1362: aload 11
    //   1364: aconst_null
    //   1365: invokevirtual 416	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1368: new 91	java/lang/StringBuilder
    //   1371: dup
    //   1372: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1375: astore_1
    //   1376: aload_1
    //   1377: getstatic 369	com/tencent/mobileqq/statistics/FDStats:s	Ljava/lang/String;
    //   1380: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1383: pop
    //   1384: aload_1
    //   1385: lload 7
    //   1387: invokevirtual 464	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1390: pop
    //   1391: aload_1
    //   1392: ldc 162
    //   1394: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1397: pop
    //   1398: aload_1
    //   1399: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1402: astore_1
    //   1403: aload_0
    //   1404: aload_1
    //   1405: aload 15
    //   1407: invokespecial 467	com/tencent/mobileqq/statistics/FDStats:a	(Ljava/lang/String;Ljava/lang/StringBuilder;)V
    //   1410: goto +5 -> 1415
    //   1413: aconst_null
    //   1414: astore_1
    //   1415: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1418: ifeq +40 -> 1458
    //   1421: new 91	java/lang/StringBuilder
    //   1424: dup
    //   1425: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1428: astore 11
    //   1430: aload 11
    //   1432: ldc_w 469
    //   1435: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1438: pop
    //   1439: aload 11
    //   1441: iload_2
    //   1442: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1445: pop
    //   1446: ldc_w 263
    //   1449: iconst_2
    //   1450: aload 11
    //   1452: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1455: invokestatic 266	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1458: aload_1
    //   1459: areturn
    //   1460: astore 14
    //   1462: aload 13
    //   1464: astore 11
    //   1466: aload 12
    //   1468: astore_1
    //   1469: aload 14
    //   1471: astore 12
    //   1473: aload 11
    //   1475: ifnull +11 -> 1486
    //   1478: aload 11
    //   1480: invokevirtual 338	java/io/BufferedReader:close	()V
    //   1483: goto +3 -> 1486
    //   1486: aload_1
    //   1487: ifnull +7 -> 1494
    //   1490: aload_1
    //   1491: invokevirtual 341	java/io/InputStream:close	()V
    //   1494: goto +6 -> 1500
    //   1497: aload 12
    //   1499: athrow
    //   1500: goto -3 -> 1497
    //   1503: astore 12
    //   1505: goto -1091 -> 414
    //   1508: astore 11
    //   1510: goto -793 -> 717
    //   1513: astore_1
    //   1514: goto -524 -> 990
    //   1517: astore 11
    //   1519: goto -644 -> 875
    //   1522: astore 11
    //   1524: goto -541 -> 983
    //   1527: astore 11
    //   1529: goto -43 -> 1486
    //   1532: astore_1
    //   1533: goto -39 -> 1494
    //   1536: iconst_0
    //   1537: istore 4
    //   1539: goto -1243 -> 296
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1542	0	this	FDStats
    //   0	1542	1	paramString	String
    //   0	1542	2	paramBoolean1	boolean
    //   0	1542	3	paramBoolean2	boolean
    //   81	1457	4	i1	int
    //   330	694	5	i2	int
    //   333	127	6	i3	int
    //   24	1362	7	l1	long
    //   1166	6	9	l2	long
    //   3	1476	11	localObject1	Object
    //   1508	1	11	localIOException1	java.io.IOException
    //   1517	1	11	localIOException2	java.io.IOException
    //   1522	1	11	localIOException3	java.io.IOException
    //   1527	1	11	localIOException4	java.io.IOException
    //   85	619	12	localObject2	Object
    //   728	1	12	localObject3	Object
    //   743	1	12	localObject4	Object
    //   764	1	12	localObject5	Object
    //   786	712	12	localObject6	Object
    //   1503	1	12	localThrowable	Throwable
    //   67	1396	13	localObject7	Object
    //   33	391	14	localObject8	Object
    //   733	1	14	localNullPointerException1	NullPointerException
    //   738	1	14	localIOException5	java.io.IOException
    //   748	1	14	localNullPointerException2	NullPointerException
    //   756	1	14	localIOException6	java.io.IOException
    //   774	49	14	localNullPointerException3	NullPointerException
    //   882	49	14	localIOException7	java.io.IOException
    //   1460	10	14	localObject9	Object
    //   14	1392	15	localStringBuilder1	StringBuilder
    //   348	603	16	localStringBuilder2	StringBuilder
    //   382	21	17	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   62	69	728	finally
    //   74	83	728	finally
    //   92	108	728	finally
    //   108	161	728	finally
    //   165	208	728	finally
    //   211	282	728	finally
    //   282	290	728	finally
    //   296	303	728	finally
    //   308	329	728	finally
    //   335	343	728	finally
    //   355	365	728	finally
    //   368	375	728	finally
    //   375	411	728	finally
    //   414	434	728	finally
    //   440	450	728	finally
    //   464	476	728	finally
    //   476	712	728	finally
    //   62	69	733	java/lang/NullPointerException
    //   74	83	733	java/lang/NullPointerException
    //   92	108	733	java/lang/NullPointerException
    //   108	161	733	java/lang/NullPointerException
    //   165	208	733	java/lang/NullPointerException
    //   211	282	733	java/lang/NullPointerException
    //   282	290	733	java/lang/NullPointerException
    //   296	303	733	java/lang/NullPointerException
    //   308	329	733	java/lang/NullPointerException
    //   335	343	733	java/lang/NullPointerException
    //   355	365	733	java/lang/NullPointerException
    //   368	375	733	java/lang/NullPointerException
    //   375	411	733	java/lang/NullPointerException
    //   414	434	733	java/lang/NullPointerException
    //   440	450	733	java/lang/NullPointerException
    //   464	476	733	java/lang/NullPointerException
    //   476	712	733	java/lang/NullPointerException
    //   62	69	738	java/io/IOException
    //   74	83	738	java/io/IOException
    //   92	108	738	java/io/IOException
    //   108	161	738	java/io/IOException
    //   165	208	738	java/io/IOException
    //   211	282	738	java/io/IOException
    //   282	290	738	java/io/IOException
    //   296	303	738	java/io/IOException
    //   308	329	738	java/io/IOException
    //   335	343	738	java/io/IOException
    //   355	365	738	java/io/IOException
    //   368	375	738	java/io/IOException
    //   375	411	738	java/io/IOException
    //   414	434	738	java/io/IOException
    //   440	450	738	java/io/IOException
    //   464	476	738	java/io/IOException
    //   476	712	738	java/io/IOException
    //   45	62	743	finally
    //   45	62	748	java/lang/NullPointerException
    //   45	62	756	java/io/IOException
    //   35	45	764	finally
    //   35	45	774	java/lang/NullPointerException
    //   35	45	882	java/io/IOException
    //   788	797	1460	finally
    //   804	813	1460	finally
    //   820	831	1460	finally
    //   838	850	1460	finally
    //   857	862	1460	finally
    //   896	905	1460	finally
    //   912	921	1460	finally
    //   928	939	1460	finally
    //   946	958	1460	finally
    //   965	970	1460	finally
    //   355	365	1503	java/lang/Throwable
    //   368	375	1503	java/lang/Throwable
    //   375	411	1503	java/lang/Throwable
    //   712	717	1508	java/io/IOException
    //   721	725	1513	java/io/IOException
    //   867	872	1517	java/io/IOException
    //   975	980	1522	java/io/IOException
    //   1478	1483	1527	java/io/IOException
    //   1490	1494	1532	java/io/IOException
  }
  
  /* Error */
  private void a(String paramString, StringBuilder paramStringBuilder)
  {
    // Byte code:
    //   0: new 147	java/io/File
    //   3: dup
    //   4: getstatic 369	com/tencent/mobileqq/statistics/FDStats:s	Ljava/lang/String;
    //   7: invokespecial 267	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore 5
    //   12: new 147	java/io/File
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 267	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore 6
    //   22: aconst_null
    //   23: astore 4
    //   25: aconst_null
    //   26: astore_3
    //   27: aload_3
    //   28: astore_1
    //   29: aload 5
    //   31: invokevirtual 475	java/io/File:exists	()Z
    //   34: ifne +11 -> 45
    //   37: aload_3
    //   38: astore_1
    //   39: aload 5
    //   41: invokevirtual 478	java/io/File:mkdirs	()Z
    //   44: pop
    //   45: aload_3
    //   46: astore_1
    //   47: aload 6
    //   49: invokevirtual 475	java/io/File:exists	()Z
    //   52: ifne +11 -> 63
    //   55: aload_3
    //   56: astore_1
    //   57: aload 6
    //   59: invokevirtual 481	java/io/File:createNewFile	()Z
    //   62: pop
    //   63: aload_3
    //   64: astore_1
    //   65: new 483	java/io/BufferedWriter
    //   68: dup
    //   69: new 485	java/io/FileWriter
    //   72: dup
    //   73: aload 6
    //   75: iconst_1
    //   76: invokespecial 488	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   79: sipush 8192
    //   82: invokespecial 491	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   85: astore_3
    //   86: aload_3
    //   87: aload_2
    //   88: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokevirtual 494	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   94: aload_3
    //   95: invokevirtual 497	java/io/BufferedWriter:flush	()V
    //   98: aload_3
    //   99: invokevirtual 498	java/io/BufferedWriter:close	()V
    //   102: return
    //   103: astore_2
    //   104: aload_3
    //   105: astore_1
    //   106: goto +48 -> 154
    //   109: astore_1
    //   110: aload_3
    //   111: astore_2
    //   112: aload_1
    //   113: astore_3
    //   114: goto +11 -> 125
    //   117: astore_2
    //   118: goto +36 -> 154
    //   121: astore_3
    //   122: aload 4
    //   124: astore_2
    //   125: aload_2
    //   126: astore_1
    //   127: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq +15 -> 145
    //   133: aload_2
    //   134: astore_1
    //   135: ldc_w 263
    //   138: iconst_2
    //   139: ldc 212
    //   141: aload_3
    //   142: invokestatic 501	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   145: aload_2
    //   146: ifnull +7 -> 153
    //   149: aload_2
    //   150: invokevirtual 498	java/io/BufferedWriter:close	()V
    //   153: return
    //   154: aload_1
    //   155: ifnull +7 -> 162
    //   158: aload_1
    //   159: invokevirtual 498	java/io/BufferedWriter:close	()V
    //   162: aload_2
    //   163: athrow
    //   164: astore_1
    //   165: return
    //   166: astore_1
    //   167: goto -5 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	FDStats
    //   0	170	1	paramString	String
    //   0	170	2	paramStringBuilder	StringBuilder
    //   26	88	3	localObject1	Object
    //   121	21	3	localThrowable	Throwable
    //   23	100	4	localObject2	Object
    //   10	30	5	localFile1	File
    //   20	54	6	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   86	98	103	finally
    //   86	98	109	java/lang/Throwable
    //   29	37	117	finally
    //   39	45	117	finally
    //   47	55	117	finally
    //   57	63	117	finally
    //   65	86	117	finally
    //   127	133	117	finally
    //   135	145	117	finally
    //   29	37	121	java/lang/Throwable
    //   39	45	121	java/lang/Throwable
    //   47	55	121	java/lang/Throwable
    //   57	63	121	java/lang/Throwable
    //   65	86	121	java/lang/Throwable
    //   98	102	164	java/io/IOException
    //   149	153	164	java/io/IOException
    //   158	162	166	java/io/IOException
  }
  
  private void b(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (!new File(paramString).exists()) {
        return;
      }
      FileUtils.deleteFilesInDirectory(paramString);
      if (!QLog.isColorLevel()) {
        break label54;
      }
      QLog.d("FDStats", 2, "deleteFDFiles");
      return;
    }
    catch (Exception paramString)
    {
      label44:
      label54:
      break label44;
    }
    QLog.e("FDStats", 2, "deleteFDFiles");
  }
  
  private void k()
  {
    long l1 = System.currentTimeMillis();
    File localFile = new File(this.f);
    Object localObject2;
    if ((localFile.list() == null) && (QLog.isColorLevel()))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkFDCount file:");
      ((StringBuilder)localObject2).append(false);
      QLog.d("FDStats", 2, ((StringBuilder)localObject2).toString());
    }
    int i1;
    int i2;
    try
    {
      i1 = localFile.list().length;
      try
      {
        QQCrashReportManager.b = i1;
        QQCrashReportManager.c = System.currentTimeMillis();
        this.n = 0;
        i2 = i1;
      }
      catch (NullPointerException localNullPointerException1) {}
      i2 = i1;
    }
    catch (NullPointerException localNullPointerException2)
    {
      i1 = 0;
    }
    if (QLog.isColorLevel())
    {
      QLog.e("FDStats", 2, localNullPointerException2.toString());
      i2 = i1;
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
    if (i2 == 0)
    {
      l2 = ((SharedPreferences)localObject1).getLong("key_last_count_failed_time", 0L);
      if ((System.currentTimeMillis() - l2 > 86400000L) && (l2 != 0L))
      {
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication().getApplicationContext()).collectPerformance(null, "fdCountFailed", true, 0L, 0L, null, null);
        ((SharedPreferences)localObject1).edit().putLong("key_last_count_failed_time", System.currentTimeMillis()).commit();
      }
    }
    else
    {
      if (Math.random() <= 0.001D) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        localObject2 = new HashMap(1);
        ((HashMap)localObject2).put("count", String.valueOf(i2));
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication().getApplicationContext()).collectPerformance(null, "fdCountSuccess", true, 0L, 0L, (HashMap)localObject2, null);
      }
    }
    if ((!this.j) && (!this.k)) {
      return;
    }
    long l2 = System.currentTimeMillis();
    long l3 = ((SharedPreferences)localObject1).getLong("key_last_report", 0L);
    long l4 = ((SharedPreferences)localObject1).getLong("key_last_threadhold_report", 0L);
    if (i2 >= 800)
    {
      i1 = ((SharedPreferences)localObject1).getInt("key_last_threadhold_size", 0);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("lastReportTime:");
        ((StringBuilder)localObject2).append(l3);
        ((StringBuilder)localObject2).append(" lastThreadHoldTime:");
        ((StringBuilder)localObject2).append(l4);
        ((StringBuilder)localObject2).append(" lastSize:");
        ((StringBuilder)localObject2).append(i1);
        QLog.d("FDStats", 2, ((StringBuilder)localObject2).toString());
      }
      if ((Math.abs(l2 - l4) <= 86400000L) && (i2 - i1 < 100))
      {
        i1 = 0;
      }
      else
      {
        a(this.g, true, false);
        a(true);
        ((SharedPreferences)localObject1).edit().putLong("key_last_threadhold_report", l2).commit();
        ((SharedPreferences)localObject1).edit().putInt("key_last_threadhold_size", i2).commit();
        if (this.h != null)
        {
          localObject1 = Message.obtain();
          ((Message)localObject1).obj = Long.valueOf(l3);
          ((Message)localObject1).what = 1004;
          this.h.sendMessageDelayed((Message)localObject1, 500L);
        }
        i1 = 1;
      }
    }
    else if ((Math.abs(l2 - l3) > 43200000L) && (i2 > 800))
    {
      localObject1 = this.g;
      int i3 = 1;
      a((String)localObject1, true, false);
      localObject1 = this.h;
      i1 = i3;
      if (localObject1 != null)
      {
        ((Handler)localObject1).sendEmptyMessage(1002);
        i1 = i3;
      }
    }
    else
    {
      i1 = 0;
    }
    if ((i2 > 900) && (i1 != 0))
    {
      localObject1 = this.h;
      if (localObject1 != null) {
        ((Handler)localObject1).sendEmptyMessage(1005);
      }
    }
    l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkFDCount count:");
      ((StringBuilder)localObject1).append(i2);
      ((StringBuilder)localObject1).append(" time:");
      ((StringBuilder)localObject1).append(l2 - l1);
      QLog.d("FDStats", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  /* Error */
  private void l()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 590	com/tencent/mobileqq/statistics/FDStats:o	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   6: ifnull +37 -> 43
    //   9: aload_0
    //   10: getfield 590	com/tencent/mobileqq/statistics/FDStats:o	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   13: invokevirtual 595	com/tencent/mobileqq/utils/QQCustomDialog:isShowing	()Z
    //   16: ifeq +27 -> 43
    //   19: aload_0
    //   20: getfield 590	com/tencent/mobileqq/statistics/FDStats:o	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   23: invokevirtual 598	com/tencent/mobileqq/utils/QQCustomDialog:dismiss	()V
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield 590	com/tencent/mobileqq/statistics/FDStats:o	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   31: goto +12 -> 43
    //   34: astore_1
    //   35: goto +11 -> 46
    //   38: astore_1
    //   39: aload_1
    //   40: invokevirtual 601	java/lang/Exception:printStackTrace	()V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	FDStats
    //   34	1	1	localObject	Object
    //   38	11	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	31	34	finally
    //   39	43	34	finally
    //   2	31	38	java/lang/Exception
  }
  
  File a(long paramLong1, long paramLong2)
  {
    Object localObject3 = s;
    Object localObject2 = null;
    Object localObject1 = null;
    if (localObject3 == null) {
      return null;
    }
    for (;;)
    {
      int i1;
      try
      {
        localObject3 = new ArrayList();
        Object localObject4 = new File(s);
        if (!((File)localObject4).exists()) {
          return null;
        }
        localObject4 = ((File)localObject4).listFiles();
        int i3 = localObject4.length;
        int i2 = 0;
        i1 = 0;
        if (i1 < i3)
        {
          File localFile = localObject4[i1];
          if (localFile.getName().contains(".zip")) {
            break label371;
          }
          long l1 = a(localFile, false);
          if ((l1 == -1L) || (l1 >= paramLong2) || (l1 <= paramLong1)) {
            break label371;
          }
          ((List)localObject3).add(localFile.getAbsolutePath());
          break label371;
        }
        if (b != null)
        {
          localObject4 = new File(b);
          if (((File)localObject4).exists())
          {
            localObject4 = ((File)localObject4).listFiles();
            i3 = localObject4.length;
            i1 = i2;
            if (i1 < i3)
            {
              ((List)localObject3).add(localObject4[i1].getAbsolutePath());
              i1 += 1;
              continue;
            }
          }
        }
        if (((List)localObject3).size() > 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(s);
          ((StringBuilder)localObject2).append(paramLong2);
          ((StringBuilder)localObject2).append(".zip");
          localObject2 = ((StringBuilder)localObject2).toString();
          if (FileUtils.zipFiles((List)localObject3, (String)localObject2))
          {
            localObject2 = new File((String)localObject2);
            try
            {
              boolean bool = ((File)localObject2).exists();
              if (!bool) {
                return null;
              }
              return localObject2;
            }
            catch (Throwable localThrowable1)
            {
              localObject1 = localObject2;
            }
          }
          else
          {
            QLog.e("FDStats", 2, "zip fail");
            b(s);
            b(b);
            return null;
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d("FDStats", 2, "", localThrowable2);
          localObject2 = localObject1;
        }
      }
      return localObject2;
      label371:
      i1 += 1;
    }
  }
  
  String a(Date paramDate)
  {
    try
    {
      paramDate = ((SimpleDateFormat)e.get()).format(paramDate);
      return paramDate;
    }
    catch (Exception paramDate)
    {
      label16:
      break label16;
    }
    return "";
  }
  
  void a(long paramLong)
  {
    Object localObject = s;
    if (localObject == null) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject = new File((String)localObject);
        if (!((File)localObject).exists()) {
          return;
        }
        localObject = ((File)localObject).listFiles();
        int i3 = localObject.length;
        int i2 = 0;
        int i1 = 0;
        if (i1 < i3)
        {
          File localFile = localObject[i1];
          long l1 = a(localFile, true);
          if ((l1 != -1L) && (l1 < paramLong)) {
            localFile.delete();
          }
        }
        else if (b != null)
        {
          localObject = new File(b);
          if ((((File)localObject).exists()) && (paramLong > 0L) && (System.currentTimeMillis() - paramLong > 86400000L))
          {
            localObject = ((File)localObject).listFiles();
            i3 = localObject.length;
            i1 = i2;
            if (i1 < i3)
            {
              localObject[i1].delete();
              i1 += 1;
              continue;
            }
          }
        }
        StringBuilder localStringBuilder;
        i1 += 1;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FDStats", 2, "", localThrowable);
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("cleanStorage ");
          localStringBuilder.append(paramLong);
          QLog.d("FDStats", 2, localStringBuilder.toString());
        }
        return;
      }
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      j();
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("FDStats", 1, "analyseCurFD on crash error", paramString);
    }
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
    long l2 = 0L;
    long l3 = ((SharedPreferences)localObject1).getLong("key_last_report", 0L);
    long l1 = System.currentTimeMillis();
    if ((Math.abs(l1 - l3) > 43200000L) || (paramBoolean))
    {
      Object localObject2 = a(l3, l1);
      if (localObject2 != null)
      {
        ((SharedPreferences)localObject1).edit().putLong("key_last_report", l1).commit();
        for (;;)
        {
          try
          {
            localObject1 = new JSONObject();
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("fileObj1", ((File)localObject2).getAbsolutePath());
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("p_id", MagnifierSDK.m());
            ((JSONObject)localObject2).put("plugin", String.valueOf(137));
            ((JSONObject)localObject2).put("newplugin", String.valueOf(137));
            ((JSONObject)localObject1).put("newplugin", String.valueOf(137));
            ((JSONObject)localObject1).put("fileObj", localJSONObject);
            ((JSONObject)localObject1).put("clientinfo", localObject2);
          }
          catch (Throwable localThrowable)
          {
            QLog.e("FDStats", 2, "report fail.", localThrowable);
          }
          try
          {
            localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().waitAppRuntime(null);
            l1 = l2;
            if (localObject2 != null) {
              l1 = Long.parseLong(((QQAppInterface)localObject2).getCurrentUin());
            }
          }
          catch (Exception localException)
          {
            Message localMessage;
            continue;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("reportFileToAPM get uin ");
          ((StringBuilder)localObject2).append(0L);
          QLog.e("FDStats", 2, ((StringBuilder)localObject2).toString());
          l1 = l2;
        }
        ReporterMachine.a(new ResultObject(0, "testcase", true, 1L, 1L, (JSONObject)localObject1, true, true, l1));
        localObject1 = a(new Date(QQCrashReportManager.c));
        CaughtExceptionReport.a(new Exception(String.format("FDStats countLastChecked: %d at %s", new Object[] { Integer.valueOf(QQCrashReportManager.b), localObject1 })), this.q);
        if (QLog.isColorLevel()) {
          QLog.d("FDStats", 2, "reportFileToAPM");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("FDStats", 2, "no file to report");
        }
        localThrowable.edit().putLong("key_last_report", l1).commit();
      }
    }
    if (this.h != null)
    {
      localMessage = Message.obtain();
      localMessage.obj = Long.valueOf(l3);
      localMessage.what = 1004;
      this.h.sendMessageDelayed(localMessage, 500L);
    }
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        g();
        if (this.i)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FDStats", 2, "already start");
          }
          return;
        }
        Object localObject1 = c();
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            Object localObject3 = ((String)localObject1).split(";");
            localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
            long l1 = ((SharedPreferences)localObject1).getLong("last_rand_timestamp", 0L);
            String str = ((SharedPreferences)localObject1).getString("rand_factor", "");
            localObject3 = localObject3[1];
            if ((Math.abs(System.currentTimeMillis() - l1) > 43200000L) || (!str.equals(localObject3))) {
              ((SharedPreferences)localObject1).edit().putLong("last_rand_timestamp", System.currentTimeMillis()).putString("rand_factor", (String)localObject3).commit();
            }
            if (Math.random() >= Float.valueOf((String)localObject3).floatValue()) {
              break label283;
            }
            bool = true;
            if (bool) {
              h();
            }
            QLog.d("FDStats", 1, new Object[] { "enable background, enableHook:", Boolean.valueOf(bool), " new random.", str, ", ", localObject3 });
            this.j = false;
            this.k = true;
            this.i = true;
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FDStats", 2, localException.toString());
          }
        }
        return;
      }
      finally {}
      label283:
      boolean bool = false;
    }
  }
  
  final String c()
  {
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.batteryCfg.name());
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("#")))
    {
      localObject = ((String)localObject).split("#");
      if (localObject.length > 2) {
        return localObject[2];
      }
    }
    return "";
  }
  
  public void d()
  {
    if (!this.k) {
      return;
    }
    Handler localHandler = this.h;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(1006);
    }
  }
  
  /* Error */
  void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 85	com/tencent/mobileqq/statistics/FDStats:l	I
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: invokestatic 210	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   11: astore_1
    //   12: aconst_null
    //   13: astore 4
    //   15: aconst_null
    //   16: astore 5
    //   18: aload_1
    //   19: iconst_3
    //   20: anewarray 56	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: ldc_w 806
    //   28: aastore
    //   29: dup
    //   30: iconst_1
    //   31: ldc_w 808
    //   34: aastore
    //   35: dup
    //   36: iconst_2
    //   37: ldc_w 810
    //   40: aastore
    //   41: invokevirtual 813	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   44: astore_1
    //   45: aload_1
    //   46: ifnull +114 -> 160
    //   49: aload_1
    //   50: invokevirtual 233	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   53: astore_1
    //   54: aload_1
    //   55: astore_3
    //   56: new 235	java/io/BufferedReader
    //   59: dup
    //   60: new 237	java/io/InputStreamReader
    //   63: dup
    //   64: aload_1
    //   65: invokespecial 240	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   68: sipush 7777
    //   71: invokespecial 816	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   74: astore_2
    //   75: aload_2
    //   76: invokevirtual 246	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   79: astore 5
    //   81: aload_1
    //   82: astore_3
    //   83: aload_2
    //   84: astore 4
    //   86: aload 5
    //   88: ifnull +77 -> 165
    //   91: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +37 -> 131
    //   97: new 91	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   104: astore_3
    //   105: aload_3
    //   106: ldc_w 818
    //   109: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_3
    //   114: aload 5
    //   116: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: ldc_w 263
    //   123: iconst_2
    //   124: aload_3
    //   125: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 266	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload_0
    //   132: aload 5
    //   134: invokestatic 821	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   137: putfield 85	com/tencent/mobileqq/statistics/FDStats:l	I
    //   140: goto -65 -> 75
    //   143: astore_3
    //   144: goto +104 -> 248
    //   147: astore_3
    //   148: aload_2
    //   149: astore 5
    //   151: aload_3
    //   152: astore_2
    //   153: goto +47 -> 200
    //   156: astore_2
    //   157: goto +43 -> 200
    //   160: aconst_null
    //   161: astore_3
    //   162: aload_3
    //   163: astore 4
    //   165: aload 4
    //   167: ifnull +11 -> 178
    //   170: aload 4
    //   172: invokevirtual 338	java/io/BufferedReader:close	()V
    //   175: goto +3 -> 178
    //   178: aload_3
    //   179: ifnull +58 -> 237
    //   182: aload_3
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 341	java/io/InputStream:close	()V
    //   188: return
    //   189: astore_3
    //   190: aconst_null
    //   191: astore_1
    //   192: aload_1
    //   193: astore_2
    //   194: goto +54 -> 248
    //   197: astore_2
    //   198: aconst_null
    //   199: astore_1
    //   200: aload_1
    //   201: astore_3
    //   202: aload 5
    //   204: astore 4
    //   206: ldc_w 263
    //   209: iconst_1
    //   210: ldc_w 346
    //   213: aload_2
    //   214: invokestatic 654	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   217: aload 5
    //   219: ifnull +11 -> 230
    //   222: aload 5
    //   224: invokevirtual 338	java/io/BufferedReader:close	()V
    //   227: goto +3 -> 230
    //   230: aload_1
    //   231: ifnull +6 -> 237
    //   234: goto -50 -> 184
    //   237: return
    //   238: astore 5
    //   240: aload 4
    //   242: astore_2
    //   243: aload_3
    //   244: astore_1
    //   245: aload 5
    //   247: astore_3
    //   248: aload_2
    //   249: ifnull +10 -> 259
    //   252: aload_2
    //   253: invokevirtual 338	java/io/BufferedReader:close	()V
    //   256: goto +3 -> 259
    //   259: aload_1
    //   260: ifnull +7 -> 267
    //   263: aload_1
    //   264: invokevirtual 341	java/io/InputStream:close	()V
    //   267: goto +5 -> 272
    //   270: aload_3
    //   271: athrow
    //   272: goto -2 -> 270
    //   275: astore_1
    //   276: goto -98 -> 178
    //   279: astore_1
    //   280: return
    //   281: astore_2
    //   282: goto -52 -> 230
    //   285: astore_2
    //   286: goto -27 -> 259
    //   289: astore_1
    //   290: goto -23 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	FDStats
    //   11	253	1	localObject1	Object
    //   275	1	1	localIOException1	java.io.IOException
    //   279	1	1	localIOException2	java.io.IOException
    //   289	1	1	localIOException3	java.io.IOException
    //   74	79	2	localObject2	Object
    //   156	1	2	localThrowable1	Throwable
    //   193	1	2	localObject3	Object
    //   197	17	2	localThrowable2	Throwable
    //   242	11	2	localObject4	Object
    //   281	1	2	localIOException4	java.io.IOException
    //   285	1	2	localIOException5	java.io.IOException
    //   55	70	3	localObject5	Object
    //   143	1	3	localObject6	Object
    //   147	5	3	localThrowable3	Throwable
    //   161	22	3	localObject7	Object
    //   189	1	3	localObject8	Object
    //   201	70	3	localObject9	Object
    //   13	228	4	localObject10	Object
    //   16	207	5	localObject11	Object
    //   238	8	5	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   75	81	143	finally
    //   91	131	143	finally
    //   131	140	143	finally
    //   75	81	147	java/lang/Throwable
    //   91	131	147	java/lang/Throwable
    //   131	140	147	java/lang/Throwable
    //   56	75	156	java/lang/Throwable
    //   18	45	189	finally
    //   49	54	189	finally
    //   18	45	197	java/lang/Throwable
    //   49	54	197	java/lang/Throwable
    //   56	75	238	finally
    //   206	217	238	finally
    //   170	175	275	java/io/IOException
    //   184	188	279	java/io/IOException
    //   222	227	281	java/io/IOException
    //   252	256	285	java/io/IOException
    //   263	267	289	java/io/IOException
  }
  
  void f() {}
  
  void g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/tencent/MobileQQ/fdmon/");
    b(localStringBuilder.toString());
  }
  
  void h()
  {
    
    if ((!this.a.get()) && (FDNative.c()))
    {
      QuickAuthorityConfBean localQuickAuthorityConfBean = (QuickAuthorityConfBean)QConfigManager.b().b(546);
      boolean bool;
      if ((localQuickAuthorityConfBean != null) && (localQuickAuthorityConfBean.d == 1)) {
        bool = true;
      } else {
        bool = false;
      }
      int i1;
      if (localQuickAuthorityConfBean != null) {
        i1 = localQuickAuthorityConfBean.d;
      } else {
        i1 = 0;
      }
      QLog.d("FDStats", 1, new Object[] { "startHook shouldHook:", Boolean.valueOf(bool), " fdSwitch:", Integer.valueOf(i1) });
      if (bool)
      {
        i1 = new Random().nextInt(3);
        FDNative.a();
        FDNative.nativeInit(false, true, 1);
        FDNative.a();
        FDNative.nativeRegister(".*\\.so$");
        FDNative.a();
        FDNative.nativeIgnore(".*/libjavacore.so$");
        FDNative.a();
        FDNative.nativeIgnore(".*/libEGL.so$");
        FDNative.a();
        FDNative.nativeIgnore(".*/libsqlite.so$");
        FDNative.a();
        FDNative.nativeIgnore(".*/libsqlite_qq.so$");
        FDNative.a();
        FDNative.nativeIgnore(".*/libBugly-rqd.so$");
        FDNative.a();
        FDNative.nativeStart();
        this.a.set(true);
        QLog.d("FDStats", 1, new Object[] { "fd hook start mode:", Integer.valueOf(i1) });
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1003: 
    default: 
      break;
    case 1006: 
      k();
      break;
    case 1005: 
      f();
      break;
    case 1004: 
      a(((Long)paramMessage.obj).longValue());
      break;
    case 1002: 
      a(false);
      break;
    case 1001: 
      k();
      this.h.sendEmptyMessageDelayed(1001, 120000L);
      break;
    case 1000: 
      e();
      this.h.sendEmptyMessageDelayed(1001, 120000L);
    }
    return true;
  }
  
  void i()
  {
    if (b == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getPath());
      ((StringBuilder)localObject).append("/tencent/MobileQQ/fdbc/");
      b = ((StringBuilder)localObject).toString();
    }
    Object localObject = new File(b);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    FDNative.a().a(b);
  }
  
  public void j()
  {
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.FDStats
 * JD-Core Version:    0.7.0.1
 */