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
  private static long jdField_a_of_type_Long = 1800000L;
  private static volatile FDStats jdField_a_of_type_ComTencentMobileqqStatisticsFDStats;
  static String jdField_a_of_type_JavaLangString;
  private static ThreadLocal<SimpleDateFormat> jdField_a_of_type_JavaLangThreadLocal = new FDStats.1();
  private static final int[] jdField_a_of_type_ArrayOfInt = { 4113, 4113, 4097, 4097 };
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "/proc/net/tcp6", "/proc/net/udp6", "/proc/net/tcp", "/proc/net/udp" };
  private static String e;
  private int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private FDStatsInspector jdField_a_of_type_ComTencentMobileqqStatisticsFDStatsInspector;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private FdCounter jdField_a_of_type_ComTencentQqperfMonitorFdFdCounter;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private String d;
  
  private FDStats()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/proc/");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append("/fd");
    this.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("ls -l ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    this.jdField_c_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentMobileqqStatisticsFDStatsInspector = new FDStatsInspector();
    this.jdField_a_of_type_ComTencentQqperfMonitorFdFdCounter = new FdCounter();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
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
        long l = Long.valueOf(paramFile.substring(0, paramFile.length() - 4)).longValue();
        return l;
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
    if (jdField_a_of_type_ComTencentMobileqqStatisticsFDStats == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqStatisticsFDStats == null)
        {
          jdField_a_of_type_ComTencentMobileqqStatisticsFDStats = new FDStats();
          if (QQCrashReportManager.jdField_a_of_type_ComTencentQqperfMonitorCrashQQCrashCallback == null) {
            QQCrashReportManager.jdField_a_of_type_ComTencentQqperfMonitorCrashQQCrashCallback = jdField_a_of_type_ComTencentMobileqqStatisticsFDStats;
          }
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqStatisticsFDStats;
  }
  
  /* Error */
  private String a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 194	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: astore 11
    //   5: new 75	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 196
    //   11: invokespecial 199	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: astore 15
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield 71	com/tencent/mobileqq/statistics/FDStats:jdField_b_of_type_Int	I
    //   21: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   24: lstore 7
    //   26: new 206	com/tencent/mobileqq/statistics/FDStatsTree
    //   29: dup
    //   30: invokespecial 207	com/tencent/mobileqq/statistics/FDStatsTree:<init>	()V
    //   33: astore 14
    //   35: aload 11
    //   37: aload_1
    //   38: invokevirtual 211	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   41: invokevirtual 217	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   44: astore_1
    //   45: new 219	java/io/BufferedReader
    //   48: dup
    //   49: new 221	java/io/InputStreamReader
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 224	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   57: invokespecial 227	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   60: astore 11
    //   62: aload 11
    //   64: invokevirtual 230	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   67: astore 13
    //   69: aload 13
    //   71: ifnull +139 -> 210
    //   74: aload 13
    //   76: ldc 232
    //   78: invokevirtual 235	java/lang/String:indexOf	(Ljava/lang/String;)I
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
    //   100: invokevirtual 157	java/lang/String:length	()I
    //   103: invokevirtual 160	java/lang/String:substring	(II)Ljava/lang/String;
    //   106: astore 12
    //   108: aload 14
    //   110: aload 12
    //   112: invokevirtual 237	com/tencent/mobileqq/statistics/FDStatsTree:a	(Ljava/lang/String;)V
    //   115: new 75	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   122: astore 13
    //   124: aload 13
    //   126: aload 12
    //   128: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 13
    //   134: ldc 239
    //   136: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 15
    //   142: aload 13
    //   144: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_0
    //   152: aload_0
    //   153: getfield 71	com/tencent/mobileqq/statistics/FDStats:jdField_b_of_type_Int	I
    //   156: iconst_1
    //   157: iadd
    //   158: putfield 71	com/tencent/mobileqq/statistics/FDStats:jdField_b_of_type_Int	I
    //   161: iload_3
    //   162: ifeq -100 -> 62
    //   165: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq -106 -> 62
    //   171: new 75	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   178: astore 13
    //   180: aload 13
    //   182: aload 12
    //   184: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 13
    //   190: ldc 239
    //   192: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: ldc 247
    //   198: iconst_2
    //   199: aload 13
    //   201: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 250	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: goto -145 -> 62
    //   210: aload_0
    //   211: getfield 71	com/tencent/mobileqq/statistics/FDStats:jdField_b_of_type_Int	I
    //   214: ifne +259 -> 473
    //   217: new 131	java/io/File
    //   220: dup
    //   221: aload_0
    //   222: getfield 99	com/tencent/mobileqq/statistics/FDStats:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   225: invokespecial 251	java/io/File:<init>	(Ljava/lang/String;)V
    //   228: astore 12
    //   230: aload 12
    //   232: invokevirtual 255	java/io/File:list	()[Ljava/lang/String;
    //   235: ifnonnull +45 -> 280
    //   238: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq +39 -> 280
    //   244: new 75	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   251: astore 13
    //   253: aload 13
    //   255: ldc_w 257
    //   258: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 13
    //   264: iconst_0
    //   265: invokevirtual 260	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: ldc 247
    //   271: iconst_2
    //   272: aload 13
    //   274: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 250	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: getstatic 265	android/os/Build$VERSION:SDK_INT	I
    //   283: bipush 21
    //   285: if_icmplt +1244 -> 1529
    //   288: iconst_1
    //   289: istore 4
    //   291: goto +3 -> 294
    //   294: aload 12
    //   296: invokevirtual 269	java/io/File:listFiles	()[Ljava/io/File;
    //   299: astore 13
    //   301: aload 13
    //   303: ifnull +170 -> 473
    //   306: new 75	java/lang/StringBuilder
    //   309: dup
    //   310: sipush 200
    //   313: invokespecial 272	java/lang/StringBuilder:<init>	(I)V
    //   316: astore 14
    //   318: aload 14
    //   320: ldc_w 274
    //   323: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: iconst_0
    //   328: istore 5
    //   330: iconst_0
    //   331: istore 6
    //   333: iload 5
    //   335: aload 13
    //   337: arraylength
    //   338: if_icmpge +119 -> 457
    //   341: aload 13
    //   343: iload 5
    //   345: aaload
    //   346: astore 16
    //   348: iload 4
    //   350: ifeq +16 -> 366
    //   353: aload 16
    //   355: invokevirtual 277	java/io/File:getPath	()Ljava/lang/String;
    //   358: invokestatic 283	android/system/Os:readlink	(Ljava/lang/String;)Ljava/lang/String;
    //   361: astore 12
    //   363: goto +10 -> 373
    //   366: aload 16
    //   368: invokevirtual 286	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   371: astore 12
    //   373: new 75	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   380: astore 17
    //   382: aload 17
    //   384: aload 12
    //   386: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload 17
    //   392: ldc 239
    //   394: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload 15
    //   400: aload 17
    //   402: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: goto +29 -> 438
    //   412: aload 14
    //   414: ldc_w 288
    //   417: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: aload 14
    //   423: aload 16
    //   425: invokevirtual 277	java/io/File:getPath	()Ljava/lang/String;
    //   428: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: iload 6
    //   434: iconst_1
    //   435: iadd
    //   436: istore 6
    //   438: aload_0
    //   439: aload_0
    //   440: getfield 71	com/tencent/mobileqq/statistics/FDStats:jdField_b_of_type_Int	I
    //   443: iconst_1
    //   444: iadd
    //   445: putfield 71	com/tencent/mobileqq/statistics/FDStats:jdField_b_of_type_Int	I
    //   448: iload 5
    //   450: iconst_1
    //   451: iadd
    //   452: istore 5
    //   454: goto -121 -> 333
    //   457: iload 6
    //   459: ifle +14 -> 473
    //   462: ldc 247
    //   464: iconst_2
    //   465: aload 15
    //   467: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: invokestatic 290	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   473: new 75	java/lang/StringBuilder
    //   476: dup
    //   477: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   480: astore 12
    //   482: aload 12
    //   484: ldc_w 292
    //   487: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: pop
    //   491: aload 12
    //   493: aload_0
    //   494: getfield 71	com/tencent/mobileqq/statistics/FDStats:jdField_b_of_type_Int	I
    //   497: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload 15
    //   503: aload 12
    //   505: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: pop
    //   512: new 75	java/lang/StringBuilder
    //   515: dup
    //   516: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   519: astore 12
    //   521: aload 12
    //   523: ldc_w 294
    //   526: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload 12
    //   532: aload_0
    //   533: getfield 69	com/tencent/mobileqq/statistics/FDStats:jdField_a_of_type_Int	I
    //   536: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   539: pop
    //   540: aload 15
    //   542: aload 12
    //   544: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: new 75	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   558: astore 12
    //   560: aload 12
    //   562: ldc_w 296
    //   565: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: aload 12
    //   571: ldc_w 298
    //   574: lload 7
    //   576: invokestatic 304	android/text/format/DateFormat:format	(Ljava/lang/CharSequence;J)Ljava/lang/CharSequence;
    //   579: invokeinterface 307 1 0
    //   584: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: pop
    //   588: aload 15
    //   590: aload 12
    //   592: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: aload 15
    //   601: ldc_w 309
    //   604: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: new 75	java/lang/StringBuilder
    //   611: dup
    //   612: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   615: astore 12
    //   617: aload 12
    //   619: ldc_w 311
    //   622: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: pop
    //   626: aload 12
    //   628: invokestatic 316	com/tencent/common/config/AppSetting:g	()Ljava/lang/String;
    //   631: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: aload 15
    //   637: aload 12
    //   639: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   642: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: pop
    //   646: new 75	java/lang/StringBuilder
    //   649: dup
    //   650: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   653: astore 12
    //   655: aload 12
    //   657: ldc_w 318
    //   660: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: pop
    //   664: aload 12
    //   666: iconst_2
    //   667: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: aload 12
    //   673: ldc_w 320
    //   676: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: pop
    //   680: aload 12
    //   682: aload_0
    //   683: getfield 73	com/tencent/mobileqq/statistics/FDStats:jdField_c_of_type_Int	I
    //   686: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   689: pop
    //   690: aload 12
    //   692: ldc 239
    //   694: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: pop
    //   698: aload 15
    //   700: aload 12
    //   702: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: pop
    //   709: aload 11
    //   711: invokevirtual 323	java/io/BufferedReader:close	()V
    //   714: aload_1
    //   715: ifnull +270 -> 985
    //   718: aload_1
    //   719: invokevirtual 326	java/io/InputStream:close	()V
    //   722: goto +263 -> 985
    //   725: astore 12
    //   727: goto +739 -> 1466
    //   730: astore 14
    //   732: goto +46 -> 778
    //   735: astore 14
    //   737: goto +148 -> 885
    //   740: astore 12
    //   742: goto +23 -> 765
    //   745: astore 14
    //   747: aconst_null
    //   748: astore 11
    //   750: goto +28 -> 778
    //   753: astore 14
    //   755: aconst_null
    //   756: astore 11
    //   758: goto +127 -> 885
    //   761: astore 12
    //   763: aconst_null
    //   764: astore_1
    //   765: aconst_null
    //   766: astore 11
    //   768: goto +698 -> 1466
    //   771: astore 14
    //   773: aconst_null
    //   774: astore 11
    //   776: aconst_null
    //   777: astore_1
    //   778: aload 11
    //   780: astore 13
    //   782: aload_1
    //   783: astore 12
    //   785: new 75	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   792: astore 16
    //   794: aload 11
    //   796: astore 13
    //   798: aload_1
    //   799: astore 12
    //   801: aload 16
    //   803: ldc_w 328
    //   806: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: pop
    //   810: aload 11
    //   812: astore 13
    //   814: aload_1
    //   815: astore 12
    //   817: aload 16
    //   819: aload 14
    //   821: invokevirtual 329	java/lang/NullPointerException:toString	()Ljava/lang/String;
    //   824: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: pop
    //   828: aload 11
    //   830: astore 13
    //   832: aload_1
    //   833: astore 12
    //   835: ldc 247
    //   837: iconst_2
    //   838: aload 16
    //   840: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   843: invokestatic 290	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   846: aload 11
    //   848: astore 13
    //   850: aload_1
    //   851: astore 12
    //   853: aload_0
    //   854: iconst_0
    //   855: putfield 71	com/tencent/mobileqq/statistics/FDStats:jdField_b_of_type_Int	I
    //   858: aload 11
    //   860: ifnull +11 -> 871
    //   863: aload 11
    //   865: invokevirtual 323	java/io/BufferedReader:close	()V
    //   868: goto +3 -> 871
    //   871: aload_1
    //   872: ifnull +113 -> 985
    //   875: goto -157 -> 718
    //   878: astore 14
    //   880: aconst_null
    //   881: astore 11
    //   883: aconst_null
    //   884: astore_1
    //   885: aload 11
    //   887: astore 13
    //   889: aload_1
    //   890: astore 12
    //   892: new 75	java/lang/StringBuilder
    //   895: dup
    //   896: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   899: astore 16
    //   901: aload 11
    //   903: astore 13
    //   905: aload_1
    //   906: astore 12
    //   908: aload 16
    //   910: ldc_w 331
    //   913: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: pop
    //   917: aload 11
    //   919: astore 13
    //   921: aload_1
    //   922: astore 12
    //   924: aload 16
    //   926: aload 14
    //   928: invokevirtual 332	java/io/IOException:toString	()Ljava/lang/String;
    //   931: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: pop
    //   935: aload 11
    //   937: astore 13
    //   939: aload_1
    //   940: astore 12
    //   942: ldc 247
    //   944: iconst_2
    //   945: aload 16
    //   947: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   950: invokestatic 290	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   953: aload 11
    //   955: astore 13
    //   957: aload_1
    //   958: astore 12
    //   960: aload_0
    //   961: iconst_0
    //   962: putfield 71	com/tencent/mobileqq/statistics/FDStats:jdField_b_of_type_Int	I
    //   965: aload 11
    //   967: ifnull +11 -> 978
    //   970: aload 11
    //   972: invokevirtual 323	java/io/BufferedReader:close	()V
    //   975: goto +3 -> 978
    //   978: aload_1
    //   979: ifnull +6 -> 985
    //   982: goto -264 -> 718
    //   985: new 334	com/tencent/qqperf/monitor/fd/FdTrie
    //   988: dup
    //   989: invokespecial 335	com/tencent/qqperf/monitor/fd/FdTrie:<init>	()V
    //   992: astore_1
    //   993: aload 15
    //   995: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   998: ldc_w 337
    //   1001: invokevirtual 341	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1004: astore 11
    //   1006: aload 11
    //   1008: arraylength
    //   1009: istore 5
    //   1011: iconst_0
    //   1012: istore 4
    //   1014: iload 4
    //   1016: iload 5
    //   1018: if_icmpge +21 -> 1039
    //   1021: aload_1
    //   1022: aload 11
    //   1024: iload 4
    //   1026: aaload
    //   1027: invokevirtual 342	com/tencent/qqperf/monitor/fd/FdTrie:a	(Ljava/lang/String;)V
    //   1030: iload 4
    //   1032: iconst_1
    //   1033: iadd
    //   1034: istore 4
    //   1036: goto -22 -> 1014
    //   1039: aload_0
    //   1040: aload_0
    //   1041: getfield 113	com/tencent/mobileqq/statistics/FDStats:jdField_a_of_type_ComTencentQqperfMonitorFdFdCounter	Lcom/tencent/qqperf/monitor/fd/FdCounter;
    //   1044: aload_1
    //   1045: invokevirtual 345	com/tencent/qqperf/monitor/fd/FdCounter:a	(Lcom/tencent/qqperf/monitor/fd/FdTrie;)Ljava/lang/String;
    //   1048: putfield 347	com/tencent/mobileqq/statistics/FDStats:d	Ljava/lang/String;
    //   1051: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1054: ifeq +38 -> 1092
    //   1057: new 75	java/lang/StringBuilder
    //   1060: dup
    //   1061: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   1064: astore_1
    //   1065: aload_1
    //   1066: ldc_w 349
    //   1069: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: pop
    //   1073: aload_1
    //   1074: aload_0
    //   1075: getfield 347	com/tencent/mobileqq/statistics/FDStats:d	Ljava/lang/String;
    //   1078: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: pop
    //   1082: ldc 247
    //   1084: iconst_2
    //   1085: aload_1
    //   1086: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1089: invokestatic 352	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1092: getstatic 354	com/tencent/mobileqq/statistics/FDStats:e	Ljava/lang/String;
    //   1095: ifnonnull +37 -> 1132
    //   1098: new 75	java/lang/StringBuilder
    //   1101: dup
    //   1102: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   1105: astore_1
    //   1106: aload_1
    //   1107: invokestatic 360	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1110: invokevirtual 364	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   1113: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1116: pop
    //   1117: aload_1
    //   1118: ldc_w 369
    //   1121: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1124: pop
    //   1125: aload_1
    //   1126: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1129: putstatic 354	com/tencent/mobileqq/statistics/FDStats:e	Ljava/lang/String;
    //   1132: invokestatic 360	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1135: ldc_w 371
    //   1138: iconst_0
    //   1139: invokevirtual 375	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1142: astore_1
    //   1143: aload_0
    //   1144: getfield 71	com/tencent/mobileqq/statistics/FDStats:jdField_b_of_type_Int	I
    //   1147: ifne +75 -> 1222
    //   1150: aload_1
    //   1151: ldc_w 377
    //   1154: lconst_0
    //   1155: invokeinterface 383 4 0
    //   1160: lstore 9
    //   1162: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   1165: lload 9
    //   1167: lsub
    //   1168: ldc2_w 384
    //   1171: lcmp
    //   1172: ifle +95 -> 1267
    //   1175: invokestatic 360	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1178: invokevirtual 389	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   1181: invokestatic 395	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1184: aconst_null
    //   1185: ldc_w 397
    //   1188: iconst_1
    //   1189: lconst_0
    //   1190: lconst_0
    //   1191: aconst_null
    //   1192: aconst_null
    //   1193: invokevirtual 401	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1196: aload_1
    //   1197: invokeinterface 405 1 0
    //   1202: ldc_w 377
    //   1205: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   1208: invokeinterface 411 4 0
    //   1213: invokeinterface 414 1 0
    //   1218: pop
    //   1219: goto +48 -> 1267
    //   1222: new 416	java/util/HashMap
    //   1225: dup
    //   1226: iconst_1
    //   1227: invokespecial 417	java/util/HashMap:<init>	(I)V
    //   1230: astore_1
    //   1231: aload_1
    //   1232: ldc_w 419
    //   1235: aload_0
    //   1236: getfield 71	com/tencent/mobileqq/statistics/FDStats:jdField_b_of_type_Int	I
    //   1239: invokestatic 421	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1242: invokevirtual 425	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1245: pop
    //   1246: invokestatic 360	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1249: invokevirtual 389	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   1252: invokestatic 395	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1255: aconst_null
    //   1256: ldc_w 427
    //   1259: iconst_1
    //   1260: lconst_0
    //   1261: lconst_0
    //   1262: aload_1
    //   1263: aconst_null
    //   1264: invokevirtual 401	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1267: iload_2
    //   1268: ifeq +139 -> 1407
    //   1271: invokestatic 432	com/tencent/mobileqq/statistics/FDStatsHooker:getAllStackTrace	()Ljava/lang/String;
    //   1274: astore_1
    //   1275: aload_1
    //   1276: invokestatic 438	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1279: ifne +19 -> 1298
    //   1282: aload 15
    //   1284: ldc_w 440
    //   1287: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: pop
    //   1291: aload 15
    //   1293: aload_1
    //   1294: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1297: pop
    //   1298: new 416	java/util/HashMap
    //   1301: dup
    //   1302: iconst_1
    //   1303: invokespecial 417	java/util/HashMap:<init>	(I)V
    //   1306: astore 11
    //   1308: aload_1
    //   1309: invokestatic 438	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1312: ifeq +10 -> 1322
    //   1315: ldc_w 442
    //   1318: astore_1
    //   1319: goto +11 -> 1330
    //   1322: aload_1
    //   1323: invokevirtual 157	java/lang/String:length	()I
    //   1326: invokestatic 421	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1329: astore_1
    //   1330: aload 11
    //   1332: ldc_w 444
    //   1335: aload_1
    //   1336: invokevirtual 425	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1339: pop
    //   1340: invokestatic 360	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1343: invokevirtual 389	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   1346: invokestatic 395	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1349: aconst_null
    //   1350: ldc_w 446
    //   1353: iconst_1
    //   1354: lconst_0
    //   1355: lconst_0
    //   1356: aload 11
    //   1358: aconst_null
    //   1359: invokevirtual 401	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1362: new 75	java/lang/StringBuilder
    //   1365: dup
    //   1366: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   1369: astore_1
    //   1370: aload_1
    //   1371: getstatic 354	com/tencent/mobileqq/statistics/FDStats:e	Ljava/lang/String;
    //   1374: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1377: pop
    //   1378: aload_1
    //   1379: lload 7
    //   1381: invokevirtual 449	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1384: pop
    //   1385: aload_1
    //   1386: ldc 146
    //   1388: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: pop
    //   1392: aload_1
    //   1393: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1396: astore_1
    //   1397: aload_0
    //   1398: aload_1
    //   1399: aload 15
    //   1401: invokespecial 452	com/tencent/mobileqq/statistics/FDStats:a	(Ljava/lang/String;Ljava/lang/StringBuilder;)V
    //   1404: goto +5 -> 1409
    //   1407: aconst_null
    //   1408: astore_1
    //   1409: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1412: ifeq +39 -> 1451
    //   1415: new 75	java/lang/StringBuilder
    //   1418: dup
    //   1419: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   1422: astore 11
    //   1424: aload 11
    //   1426: ldc_w 454
    //   1429: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1432: pop
    //   1433: aload 11
    //   1435: iload_2
    //   1436: invokevirtual 260	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1439: pop
    //   1440: ldc 247
    //   1442: iconst_2
    //   1443: aload 11
    //   1445: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1448: invokestatic 250	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1451: aload_1
    //   1452: areturn
    //   1453: astore 14
    //   1455: aload 13
    //   1457: astore 11
    //   1459: aload 12
    //   1461: astore_1
    //   1462: aload 14
    //   1464: astore 12
    //   1466: aload 11
    //   1468: ifnull +11 -> 1479
    //   1471: aload 11
    //   1473: invokevirtual 323	java/io/BufferedReader:close	()V
    //   1476: goto +3 -> 1479
    //   1479: aload_1
    //   1480: ifnull +7 -> 1487
    //   1483: aload_1
    //   1484: invokevirtual 326	java/io/InputStream:close	()V
    //   1487: goto +6 -> 1493
    //   1490: aload 12
    //   1492: athrow
    //   1493: goto -3 -> 1490
    //   1496: astore 12
    //   1498: goto -1086 -> 412
    //   1501: astore 11
    //   1503: goto -789 -> 714
    //   1506: astore_1
    //   1507: goto -522 -> 985
    //   1510: astore 11
    //   1512: goto -641 -> 871
    //   1515: astore 11
    //   1517: goto -539 -> 978
    //   1520: astore 11
    //   1522: goto -43 -> 1479
    //   1525: astore_1
    //   1526: goto -39 -> 1487
    //   1529: iconst_0
    //   1530: istore 4
    //   1532: goto -1238 -> 294
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1535	0	this	FDStats
    //   0	1535	1	paramString	String
    //   0	1535	2	paramBoolean1	boolean
    //   0	1535	3	paramBoolean2	boolean
    //   81	1450	4	i	int
    //   328	691	5	j	int
    //   331	127	6	k	int
    //   24	1356	7	l1	long
    //   1160	6	9	l2	long
    //   3	1469	11	localObject1	Object
    //   1501	1	11	localIOException1	java.io.IOException
    //   1510	1	11	localIOException2	java.io.IOException
    //   1515	1	11	localIOException3	java.io.IOException
    //   1520	1	11	localIOException4	java.io.IOException
    //   85	616	12	localObject2	Object
    //   725	1	12	localObject3	Object
    //   740	1	12	localObject4	Object
    //   761	1	12	localObject5	Object
    //   783	708	12	localObject6	Object
    //   1496	1	12	localThrowable	Throwable
    //   67	1389	13	localObject7	Object
    //   33	389	14	localObject8	Object
    //   730	1	14	localNullPointerException1	NullPointerException
    //   735	1	14	localIOException5	java.io.IOException
    //   745	1	14	localNullPointerException2	NullPointerException
    //   753	1	14	localIOException6	java.io.IOException
    //   771	49	14	localNullPointerException3	NullPointerException
    //   878	49	14	localIOException7	java.io.IOException
    //   1453	10	14	localObject9	Object
    //   14	1386	15	localStringBuilder1	StringBuilder
    //   346	600	16	localStringBuilder2	StringBuilder
    //   380	21	17	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   62	69	725	finally
    //   74	83	725	finally
    //   92	108	725	finally
    //   108	161	725	finally
    //   165	207	725	finally
    //   210	280	725	finally
    //   280	288	725	finally
    //   294	301	725	finally
    //   306	327	725	finally
    //   333	341	725	finally
    //   353	363	725	finally
    //   366	373	725	finally
    //   373	409	725	finally
    //   412	432	725	finally
    //   438	448	725	finally
    //   462	473	725	finally
    //   473	709	725	finally
    //   62	69	730	java/lang/NullPointerException
    //   74	83	730	java/lang/NullPointerException
    //   92	108	730	java/lang/NullPointerException
    //   108	161	730	java/lang/NullPointerException
    //   165	207	730	java/lang/NullPointerException
    //   210	280	730	java/lang/NullPointerException
    //   280	288	730	java/lang/NullPointerException
    //   294	301	730	java/lang/NullPointerException
    //   306	327	730	java/lang/NullPointerException
    //   333	341	730	java/lang/NullPointerException
    //   353	363	730	java/lang/NullPointerException
    //   366	373	730	java/lang/NullPointerException
    //   373	409	730	java/lang/NullPointerException
    //   412	432	730	java/lang/NullPointerException
    //   438	448	730	java/lang/NullPointerException
    //   462	473	730	java/lang/NullPointerException
    //   473	709	730	java/lang/NullPointerException
    //   62	69	735	java/io/IOException
    //   74	83	735	java/io/IOException
    //   92	108	735	java/io/IOException
    //   108	161	735	java/io/IOException
    //   165	207	735	java/io/IOException
    //   210	280	735	java/io/IOException
    //   280	288	735	java/io/IOException
    //   294	301	735	java/io/IOException
    //   306	327	735	java/io/IOException
    //   333	341	735	java/io/IOException
    //   353	363	735	java/io/IOException
    //   366	373	735	java/io/IOException
    //   373	409	735	java/io/IOException
    //   412	432	735	java/io/IOException
    //   438	448	735	java/io/IOException
    //   462	473	735	java/io/IOException
    //   473	709	735	java/io/IOException
    //   45	62	740	finally
    //   45	62	745	java/lang/NullPointerException
    //   45	62	753	java/io/IOException
    //   35	45	761	finally
    //   35	45	771	java/lang/NullPointerException
    //   35	45	878	java/io/IOException
    //   785	794	1453	finally
    //   801	810	1453	finally
    //   817	828	1453	finally
    //   835	846	1453	finally
    //   853	858	1453	finally
    //   892	901	1453	finally
    //   908	917	1453	finally
    //   924	935	1453	finally
    //   942	953	1453	finally
    //   960	965	1453	finally
    //   353	363	1496	java/lang/Throwable
    //   366	373	1496	java/lang/Throwable
    //   373	409	1496	java/lang/Throwable
    //   709	714	1501	java/io/IOException
    //   718	722	1506	java/io/IOException
    //   863	868	1510	java/io/IOException
    //   970	975	1515	java/io/IOException
    //   1471	1476	1520	java/io/IOException
    //   1483	1487	1525	java/io/IOException
  }
  
  /* Error */
  private void a(String paramString, StringBuilder paramStringBuilder)
  {
    // Byte code:
    //   0: new 131	java/io/File
    //   3: dup
    //   4: getstatic 354	com/tencent/mobileqq/statistics/FDStats:e	Ljava/lang/String;
    //   7: invokespecial 251	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore 5
    //   12: new 131	java/io/File
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 251	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore 6
    //   22: aconst_null
    //   23: astore 4
    //   25: aconst_null
    //   26: astore_3
    //   27: aload_3
    //   28: astore_1
    //   29: aload 5
    //   31: invokevirtual 461	java/io/File:exists	()Z
    //   34: ifne +11 -> 45
    //   37: aload_3
    //   38: astore_1
    //   39: aload 5
    //   41: invokevirtual 464	java/io/File:mkdirs	()Z
    //   44: pop
    //   45: aload_3
    //   46: astore_1
    //   47: aload 6
    //   49: invokevirtual 461	java/io/File:exists	()Z
    //   52: ifne +11 -> 63
    //   55: aload_3
    //   56: astore_1
    //   57: aload 6
    //   59: invokevirtual 467	java/io/File:createNewFile	()Z
    //   62: pop
    //   63: aload_3
    //   64: astore_1
    //   65: new 469	java/io/BufferedWriter
    //   68: dup
    //   69: new 471	java/io/FileWriter
    //   72: dup
    //   73: aload 6
    //   75: iconst_1
    //   76: invokespecial 474	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   79: sipush 8192
    //   82: invokespecial 477	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   85: astore_3
    //   86: aload_3
    //   87: aload_2
    //   88: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokevirtual 480	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   94: aload_3
    //   95: invokevirtual 483	java/io/BufferedWriter:flush	()V
    //   98: aload_3
    //   99: invokevirtual 484	java/io/BufferedWriter:close	()V
    //   102: return
    //   103: astore_2
    //   104: aload_3
    //   105: astore_1
    //   106: goto +47 -> 153
    //   109: astore_1
    //   110: aload_3
    //   111: astore_2
    //   112: aload_1
    //   113: astore_3
    //   114: goto +11 -> 125
    //   117: astore_2
    //   118: goto +35 -> 153
    //   121: astore_3
    //   122: aload 4
    //   124: astore_2
    //   125: aload_2
    //   126: astore_1
    //   127: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq +14 -> 144
    //   133: aload_2
    //   134: astore_1
    //   135: ldc 247
    //   137: iconst_2
    //   138: ldc 196
    //   140: aload_3
    //   141: invokestatic 487	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   144: aload_2
    //   145: ifnull +7 -> 152
    //   148: aload_2
    //   149: invokevirtual 484	java/io/BufferedWriter:close	()V
    //   152: return
    //   153: aload_1
    //   154: ifnull +7 -> 161
    //   157: aload_1
    //   158: invokevirtual 484	java/io/BufferedWriter:close	()V
    //   161: aload_2
    //   162: athrow
    //   163: astore_1
    //   164: return
    //   165: astore_1
    //   166: goto -5 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	FDStats
    //   0	169	1	paramString	String
    //   0	169	2	paramStringBuilder	StringBuilder
    //   26	88	3	localObject1	Object
    //   121	20	3	localThrowable	Throwable
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
    //   135	144	117	finally
    //   29	37	121	java/lang/Throwable
    //   39	45	121	java/lang/Throwable
    //   47	55	121	java/lang/Throwable
    //   57	63	121	java/lang/Throwable
    //   65	86	121	java/lang/Throwable
    //   98	102	163	java/io/IOException
    //   148	152	163	java/io/IOException
    //   157	161	165	java/io/IOException
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
        break label52;
      }
      QLog.d("FDStats", 2, "deleteFDFiles");
      return;
    }
    catch (Exception paramString)
    {
      label43:
      label52:
      break label43;
    }
    QLog.e("FDStats", 2, "deleteFDFiles");
  }
  
  private void i()
  {
    long l1 = System.currentTimeMillis();
    File localFile = new File(this.jdField_b_of_type_JavaLangString);
    Object localObject2;
    if ((localFile.list() == null) && (QLog.isColorLevel()))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkFDCount file:");
      ((StringBuilder)localObject2).append(false);
      QLog.d("FDStats", 2, ((StringBuilder)localObject2).toString());
    }
    int i;
    int j;
    try
    {
      i = localFile.list().length;
      try
      {
        QQCrashReportManager.jdField_a_of_type_Int = i;
        QQCrashReportManager.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_c_of_type_Int = 0;
        j = i;
      }
      catch (NullPointerException localNullPointerException1) {}
      j = i;
    }
    catch (NullPointerException localNullPointerException2)
    {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      QLog.e("FDStats", 2, localNullPointerException2.toString());
      j = i;
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
    if (j == 0)
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
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        localObject2 = new HashMap(1);
        ((HashMap)localObject2).put("count", String.valueOf(j));
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication().getApplicationContext()).collectPerformance(null, "fdCountSuccess", true, 0L, 0L, (HashMap)localObject2, null);
      }
    }
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean)) {
      return;
    }
    long l2 = System.currentTimeMillis();
    long l3 = ((SharedPreferences)localObject1).getLong("key_last_report", 0L);
    long l4 = ((SharedPreferences)localObject1).getLong("key_last_threadhold_report", 0L);
    if (j >= 800)
    {
      i = ((SharedPreferences)localObject1).getInt("key_last_threadhold_size", 0);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("lastReportTime:");
        ((StringBuilder)localObject2).append(l3);
        ((StringBuilder)localObject2).append(" lastThreadHoldTime:");
        ((StringBuilder)localObject2).append(l4);
        ((StringBuilder)localObject2).append(" lastSize:");
        ((StringBuilder)localObject2).append(i);
        QLog.d("FDStats", 2, ((StringBuilder)localObject2).toString());
      }
      if ((Math.abs(l2 - l4) <= 86400000L) && (j - i < 100))
      {
        i = 0;
      }
      else
      {
        a(this.jdField_c_of_type_JavaLangString, true, false);
        a(true);
        ((SharedPreferences)localObject1).edit().putLong("key_last_threadhold_report", l2).commit();
        ((SharedPreferences)localObject1).edit().putInt("key_last_threadhold_size", j).commit();
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          localObject1 = Message.obtain();
          ((Message)localObject1).obj = Long.valueOf(l3);
          ((Message)localObject1).what = 1004;
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject1, 500L);
        }
        i = 1;
      }
    }
    else if ((Math.abs(l2 - l3) > 43200000L) && (j > 800))
    {
      localObject1 = this.jdField_c_of_type_JavaLangString;
      int k = 1;
      a((String)localObject1, true, false);
      localObject1 = this.jdField_a_of_type_AndroidOsHandler;
      i = k;
      if (localObject1 != null)
      {
        ((Handler)localObject1).sendEmptyMessage(1002);
        i = k;
      }
    }
    else
    {
      i = 0;
    }
    if ((j > 900) && (i != 0))
    {
      localObject1 = this.jdField_a_of_type_AndroidOsHandler;
      if (localObject1 != null) {
        ((Handler)localObject1).sendEmptyMessage(1005);
      }
    }
    l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkFDCount count:");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append(" time:");
      ((StringBuilder)localObject1).append(l2 - l1);
      QLog.d("FDStats", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  /* Error */
  private void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 575	com/tencent/mobileqq/statistics/FDStats:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   6: ifnull +37 -> 43
    //   9: aload_0
    //   10: getfield 575	com/tencent/mobileqq/statistics/FDStats:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   13: invokevirtual 580	com/tencent/mobileqq/utils/QQCustomDialog:isShowing	()Z
    //   16: ifeq +27 -> 43
    //   19: aload_0
    //   20: getfield 575	com/tencent/mobileqq/statistics/FDStats:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   23: invokevirtual 583	com/tencent/mobileqq/utils/QQCustomDialog:dismiss	()V
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield 575	com/tencent/mobileqq/statistics/FDStats:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   31: goto +12 -> 43
    //   34: astore_1
    //   35: goto +11 -> 46
    //   38: astore_1
    //   39: aload_1
    //   40: invokevirtual 586	java/lang/Exception:printStackTrace	()V
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
    Object localObject3 = e;
    Object localObject2 = null;
    Object localObject1 = null;
    if (localObject3 == null) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        localObject3 = new ArrayList();
        Object localObject4 = new File(e);
        if (!((File)localObject4).exists()) {
          return null;
        }
        localObject4 = ((File)localObject4).listFiles();
        int k = localObject4.length;
        int j = 0;
        i = 0;
        if (i < k)
        {
          File localFile = localObject4[i];
          if (localFile.getName().contains(".zip")) {
            break label369;
          }
          long l = a(localFile, false);
          if ((l == -1L) || (l >= paramLong2) || (l <= paramLong1)) {
            break label369;
          }
          ((List)localObject3).add(localFile.getAbsolutePath());
          break label369;
        }
        if (jdField_a_of_type_JavaLangString != null)
        {
          localObject4 = new File(jdField_a_of_type_JavaLangString);
          if (((File)localObject4).exists())
          {
            localObject4 = ((File)localObject4).listFiles();
            k = localObject4.length;
            i = j;
            if (i < k)
            {
              ((List)localObject3).add(localObject4[i].getAbsolutePath());
              i += 1;
              continue;
            }
          }
        }
        if (((List)localObject3).size() > 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(e);
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
            b(e);
            b(jdField_a_of_type_JavaLangString);
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
      label369:
      i += 1;
    }
  }
  
  final String a()
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
  
  String a(Date paramDate)
  {
    try
    {
      paramDate = ((SimpleDateFormat)jdField_a_of_type_JavaLangThreadLocal.get()).format(paramDate);
      return paramDate;
    }
    catch (Exception paramDate)
    {
      label16:
      break label16;
    }
    return "";
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        e();
        if (this.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FDStats", 2, "already start");
          }
          return;
        }
        Object localObject1 = a();
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            Object localObject3 = ((String)localObject1).split(";");
            localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
            long l = ((SharedPreferences)localObject1).getLong("last_rand_timestamp", 0L);
            String str = ((SharedPreferences)localObject1).getString("rand_factor", "");
            localObject3 = localObject3[1];
            if ((Math.abs(System.currentTimeMillis() - l) > 43200000L) || (!str.equals(localObject3))) {
              ((SharedPreferences)localObject1).edit().putLong("last_rand_timestamp", System.currentTimeMillis()).putString("rand_factor", (String)localObject3).commit();
            }
            if (Math.random() >= Float.valueOf((String)localObject3).floatValue()) {
              break label280;
            }
            bool = true;
            if (bool) {
              f();
            }
            QLog.d("FDStats", 1, new Object[] { "enable background, enableHook:", Boolean.valueOf(bool), " new random.", str, ", ", localObject3 });
            this.jdField_b_of_type_Boolean = false;
            this.jdField_c_of_type_Boolean = true;
            this.jdField_a_of_type_Boolean = true;
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
      label280:
      boolean bool = false;
    }
  }
  
  void a(long paramLong)
  {
    Object localObject = e;
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
        int k = localObject.length;
        int j = 0;
        int i = 0;
        if (i < k)
        {
          File localFile = localObject[i];
          long l = a(localFile, true);
          if ((l != -1L) && (l < paramLong)) {
            localFile.delete();
          }
        }
        else if (jdField_a_of_type_JavaLangString != null)
        {
          localObject = new File(jdField_a_of_type_JavaLangString);
          if ((((File)localObject).exists()) && (paramLong > 0L) && (System.currentTimeMillis() - paramLong > 86400000L))
          {
            localObject = ((File)localObject).listFiles();
            k = localObject.length;
            i = j;
            if (i < k)
            {
              localObject[i].delete();
              i += 1;
              continue;
            }
          }
        }
        StringBuilder localStringBuilder;
        i += 1;
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
      h();
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
            ((JSONObject)localObject2).put("p_id", MagnifierSDK.b());
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
        localObject1 = a(new Date(QQCrashReportManager.jdField_a_of_type_Long));
        CaughtExceptionReport.a(new Exception(String.format("FDStats countLastChecked: %d at %s", new Object[] { Integer.valueOf(QQCrashReportManager.jdField_a_of_type_Int), localObject1 })), this.d);
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
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      localMessage = Message.obtain();
      localMessage.obj = Long.valueOf(l3);
      localMessage.what = 1004;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 500L);
    }
  }
  
  public void b()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(1006);
    }
  }
  
  /* Error */
  void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 69	com/tencent/mobileqq/statistics/FDStats:jdField_a_of_type_Int	I
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: invokestatic 194	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   11: astore_1
    //   12: aconst_null
    //   13: astore 4
    //   15: aconst_null
    //   16: astore 5
    //   18: aload_1
    //   19: iconst_3
    //   20: anewarray 40	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: ldc_w 794
    //   28: aastore
    //   29: dup
    //   30: iconst_1
    //   31: ldc_w 796
    //   34: aastore
    //   35: dup
    //   36: iconst_2
    //   37: ldc_w 798
    //   40: aastore
    //   41: invokevirtual 801	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   44: astore_1
    //   45: aload_1
    //   46: ifnull +113 -> 159
    //   49: aload_1
    //   50: invokevirtual 217	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   53: astore_1
    //   54: aload_1
    //   55: astore_3
    //   56: new 219	java/io/BufferedReader
    //   59: dup
    //   60: new 221	java/io/InputStreamReader
    //   63: dup
    //   64: aload_1
    //   65: invokespecial 224	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   68: sipush 7777
    //   71: invokespecial 804	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   74: astore_2
    //   75: aload_2
    //   76: invokevirtual 230	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   79: astore 5
    //   81: aload_1
    //   82: astore_3
    //   83: aload_2
    //   84: astore 4
    //   86: aload 5
    //   88: ifnull +76 -> 164
    //   91: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +36 -> 130
    //   97: new 75	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   104: astore_3
    //   105: aload_3
    //   106: ldc_w 806
    //   109: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_3
    //   114: aload 5
    //   116: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: ldc 247
    //   122: iconst_2
    //   123: aload_3
    //   124: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 250	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aload_0
    //   131: aload 5
    //   133: invokestatic 809	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   136: putfield 69	com/tencent/mobileqq/statistics/FDStats:jdField_a_of_type_Int	I
    //   139: goto -64 -> 75
    //   142: astore_3
    //   143: goto +103 -> 246
    //   146: astore_3
    //   147: aload_2
    //   148: astore 5
    //   150: aload_3
    //   151: astore_2
    //   152: goto +47 -> 199
    //   155: astore_2
    //   156: goto +43 -> 199
    //   159: aconst_null
    //   160: astore_3
    //   161: aload_3
    //   162: astore 4
    //   164: aload 4
    //   166: ifnull +11 -> 177
    //   169: aload 4
    //   171: invokevirtual 323	java/io/BufferedReader:close	()V
    //   174: goto +3 -> 177
    //   177: aload_3
    //   178: ifnull +57 -> 235
    //   181: aload_3
    //   182: astore_1
    //   183: aload_1
    //   184: invokevirtual 326	java/io/InputStream:close	()V
    //   187: return
    //   188: astore_3
    //   189: aconst_null
    //   190: astore_1
    //   191: aload_1
    //   192: astore_2
    //   193: goto +53 -> 246
    //   196: astore_2
    //   197: aconst_null
    //   198: astore_1
    //   199: aload_1
    //   200: astore_3
    //   201: aload 5
    //   203: astore 4
    //   205: ldc 247
    //   207: iconst_1
    //   208: ldc_w 331
    //   211: aload_2
    //   212: invokestatic 713	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   215: aload 5
    //   217: ifnull +11 -> 228
    //   220: aload 5
    //   222: invokevirtual 323	java/io/BufferedReader:close	()V
    //   225: goto +3 -> 228
    //   228: aload_1
    //   229: ifnull +6 -> 235
    //   232: goto -49 -> 183
    //   235: return
    //   236: astore 5
    //   238: aload 4
    //   240: astore_2
    //   241: aload_3
    //   242: astore_1
    //   243: aload 5
    //   245: astore_3
    //   246: aload_2
    //   247: ifnull +10 -> 257
    //   250: aload_2
    //   251: invokevirtual 323	java/io/BufferedReader:close	()V
    //   254: goto +3 -> 257
    //   257: aload_1
    //   258: ifnull +7 -> 265
    //   261: aload_1
    //   262: invokevirtual 326	java/io/InputStream:close	()V
    //   265: goto +5 -> 270
    //   268: aload_3
    //   269: athrow
    //   270: goto -2 -> 268
    //   273: astore_1
    //   274: goto -97 -> 177
    //   277: astore_1
    //   278: return
    //   279: astore_2
    //   280: goto -52 -> 228
    //   283: astore_2
    //   284: goto -27 -> 257
    //   287: astore_1
    //   288: goto -23 -> 265
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	this	FDStats
    //   11	251	1	localObject1	Object
    //   273	1	1	localIOException1	java.io.IOException
    //   277	1	1	localIOException2	java.io.IOException
    //   287	1	1	localIOException3	java.io.IOException
    //   74	78	2	localObject2	Object
    //   155	1	2	localThrowable1	Throwable
    //   192	1	2	localObject3	Object
    //   196	16	2	localThrowable2	Throwable
    //   240	11	2	localObject4	Object
    //   279	1	2	localIOException4	java.io.IOException
    //   283	1	2	localIOException5	java.io.IOException
    //   55	69	3	localObject5	Object
    //   142	1	3	localObject6	Object
    //   146	5	3	localThrowable3	Throwable
    //   160	22	3	localObject7	Object
    //   188	1	3	localObject8	Object
    //   200	69	3	localObject9	Object
    //   13	226	4	localObject10	Object
    //   16	205	5	localObject11	Object
    //   236	8	5	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   75	81	142	finally
    //   91	130	142	finally
    //   130	139	142	finally
    //   75	81	146	java/lang/Throwable
    //   91	130	146	java/lang/Throwable
    //   130	139	146	java/lang/Throwable
    //   56	75	155	java/lang/Throwable
    //   18	45	188	finally
    //   49	54	188	finally
    //   18	45	196	java/lang/Throwable
    //   49	54	196	java/lang/Throwable
    //   56	75	236	finally
    //   205	215	236	finally
    //   169	174	273	java/io/IOException
    //   183	187	277	java/io/IOException
    //   220	225	279	java/io/IOException
    //   250	254	283	java/io/IOException
    //   261	265	287	java/io/IOException
  }
  
  void d() {}
  
  void e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/tencent/MobileQQ/fdmon/");
    b(localStringBuilder.toString());
  }
  
  void f()
  {
    
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (FDNative.b()))
    {
      QuickAuthorityConfBean localQuickAuthorityConfBean = (QuickAuthorityConfBean)QConfigManager.a().a(546);
      boolean bool;
      if ((localQuickAuthorityConfBean != null) && (localQuickAuthorityConfBean.d == 1)) {
        bool = true;
      } else {
        bool = false;
      }
      int i;
      if (localQuickAuthorityConfBean != null) {
        i = localQuickAuthorityConfBean.d;
      } else {
        i = 0;
      }
      QLog.d("FDStats", 1, new Object[] { "startHook shouldHook:", Boolean.valueOf(bool), " fdSwitch:", Integer.valueOf(i) });
      if (bool)
      {
        i = new Random().nextInt(3);
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
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        QLog.d("FDStats", 1, new Object[] { "fd hook start mode:", Integer.valueOf(i) });
      }
    }
  }
  
  void g()
  {
    if (jdField_a_of_type_JavaLangString == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getPath());
      ((StringBuilder)localObject).append("/tencent/MobileQQ/fdbc/");
      jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    }
    Object localObject = new File(jdField_a_of_type_JavaLangString);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    FDNative.a().a(jdField_a_of_type_JavaLangString);
  }
  
  public void h()
  {
    g();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1003: 
    default: 
      break;
    case 1006: 
      i();
      break;
    case 1005: 
      d();
      break;
    case 1004: 
      a(((Long)paramMessage.obj).longValue());
      break;
    case 1002: 
      a(false);
      break;
    case 1001: 
      i();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 120000L);
      break;
    case 1000: 
      c();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 120000L);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.FDStats
 * JD-Core Version:    0.7.0.1
 */