package com.tencent.mobileqq.statistics.battery;

import ahsm;
import ahsn;
import ahso;
import ahsq;
import ahsr;
import ahss;
import ahsv;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class BatteryStatsImpl
  extends BatteryStats
  implements Handler.Callback
{
  private static BatteryStatsImpl jdField_a_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl;
  public static boolean a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "CPU", "流量", "日志", "命令字", "WakeLock", "WIFI", "GPS" };
  private static String[] jdField_b_of_type_ArrayOfJavaLangString = { "android.", "com.android.", "dalvik.", "com.google.", "sun.", "com.qihoo360", "com.lbe", "java." };
  private static String[] jdField_c_of_type_ArrayOfJavaLangString = { BatteryStatsImpl.class.getName() };
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  private BatteryStatsImpl.GPS jdField_a_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl$GPS;
  private BatteryStatsImpl.IBatteryStatsCallback jdField_a_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl$IBatteryStatsCallback;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public static BatteryStatsImpl a()
  {
    if (jdField_a_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl != null) {
      return jdField_a_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl;
    }
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl == null) {
        jdField_a_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl = new BatteryStatsImpl();
      }
      BatteryStatsImpl localBatteryStatsImpl = jdField_a_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl;
      return localBatteryStatsImpl;
    }
    finally {}
  }
  
  private static final String a()
  {
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.batteryCfg.name());
    if ((!TextUtils.isEmpty(str)) && (str.contains("#"))) {
      return str.substring(0, str.indexOf("#"));
    }
    return "";
  }
  
  private final String a(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return paramArrayOfString[paramInt1];
    }
    StringBuilder localStringBuilder = new StringBuilder((paramInt2 - paramInt1) * 10);
    while (paramInt1 < paramInt2 + 1)
    {
      localStringBuilder.append(paramArrayOfString[paramInt1]);
      if (paramInt1 != paramInt2) {
        localStringBuilder.append("|");
      }
      paramInt1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static StringBuilder a()
  {
    StringBuilder localStringBuilder = BatteryLog.a();
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int i = arrayOfStackTraceElement.length - 1;
    if (i >= 0)
    {
      String str = arrayOfStackTraceElement[i].toString();
      if (a(str))
      {
        if (localStringBuilder.length() != 0) {
          break label61;
        }
        localStringBuilder.append("[");
      }
      for (;;)
      {
        localStringBuilder.append(str);
        i -= 1;
        break;
        label61:
        localStringBuilder.append(",");
      }
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.append("]");
    }
    return localStringBuilder;
  }
  
  /* Error */
  private final void a(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: lload_1
    //   1: lload_3
    //   2: ldc2_w 184
    //   5: invokestatic 188	com/tencent/mobileqq/statistics/battery/BatteryLog:a	(JJJ)Ljava/util/List;
    //   8: astore 19
    //   10: aload 19
    //   12: ifnonnull +12 -> 24
    //   15: ldc 190
    //   17: iconst_2
    //   18: ldc 192
    //   20: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: return
    //   24: new 199	org/json/JSONObject
    //   27: dup
    //   28: invokespecial 200	org/json/JSONObject:<init>	()V
    //   31: astore 25
    //   33: iconst_0
    //   34: istore 11
    //   36: iconst_0
    //   37: istore 5
    //   39: iconst_0
    //   40: istore 12
    //   42: iconst_0
    //   43: istore 6
    //   45: new 202	java/util/HashMap
    //   48: dup
    //   49: bipush 40
    //   51: invokespecial 203	java/util/HashMap:<init>	(I)V
    //   54: astore 24
    //   56: iload 12
    //   58: istore 9
    //   60: iload 11
    //   62: istore 8
    //   64: aload 25
    //   66: ldc 205
    //   68: getstatic 211	android/os/Build:MODEL	Ljava/lang/String;
    //   71: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   74: pop
    //   75: iload 12
    //   77: istore 9
    //   79: iload 11
    //   81: istore 8
    //   83: aload 25
    //   85: ldc 217
    //   87: getstatic 222	android/os/Build$VERSION:SDK_INT	I
    //   90: invokevirtual 225	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   93: pop
    //   94: iload 12
    //   96: istore 9
    //   98: iload 11
    //   100: istore 8
    //   102: aload 25
    //   104: ldc 227
    //   106: invokestatic 233	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   109: aconst_null
    //   110: invokevirtual 237	com/tencent/common/app/BaseApplicationImpl:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   113: checkcast 239	com/tencent/mobileqq/app/QQAppInterface
    //   116: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   119: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   122: pop
    //   123: sipush 500
    //   126: istore 7
    //   128: iconst_0
    //   129: istore 10
    //   131: iload 12
    //   133: istore 9
    //   135: iload 11
    //   137: istore 8
    //   139: aload 19
    //   141: invokeinterface 247 1 0
    //   146: astore 23
    //   148: iload 6
    //   150: istore 9
    //   152: iload 5
    //   154: istore 8
    //   156: aload 23
    //   158: invokeinterface 253 1 0
    //   163: ifeq +5888 -> 6051
    //   166: iload 6
    //   168: istore 9
    //   170: iload 5
    //   172: istore 8
    //   174: aload 23
    //   176: invokeinterface 257 1 0
    //   181: checkcast 259	java/io/File
    //   184: astore 19
    //   186: new 261	java/io/FileInputStream
    //   189: dup
    //   190: aload 19
    //   192: invokespecial 264	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   195: astore 21
    //   197: new 266	java/io/BufferedReader
    //   200: dup
    //   201: new 268	java/io/InputStreamReader
    //   204: dup
    //   205: aload 21
    //   207: invokespecial 271	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   210: invokespecial 274	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   213: astore 20
    //   215: iload 7
    //   217: istore 12
    //   219: iload 10
    //   221: istore 7
    //   223: iload 7
    //   225: istore 18
    //   227: iload 6
    //   229: istore 17
    //   231: iload 5
    //   233: istore 13
    //   235: iload 12
    //   237: istore 14
    //   239: iload 6
    //   241: istore 8
    //   243: iload 5
    //   245: istore 11
    //   247: aload 20
    //   249: invokevirtual 277	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   252: astore 22
    //   254: aload 22
    //   256: ifnull +5788 -> 6044
    //   259: iload 12
    //   261: iconst_1
    //   262: isub
    //   263: istore 15
    //   265: iload 15
    //   267: ifgt +283 -> 550
    //   270: iload 15
    //   272: istore 10
    //   274: aload 21
    //   276: ifnull +16 -> 292
    //   279: iload 6
    //   281: istore 9
    //   283: iload 5
    //   285: istore 8
    //   287: aload 21
    //   289: invokevirtual 282	java/io/InputStream:close	()V
    //   292: aload 20
    //   294: ifnull +5731 -> 6025
    //   297: iload 6
    //   299: istore 9
    //   301: iload 5
    //   303: istore 8
    //   305: aload 20
    //   307: invokevirtual 283	java/io/BufferedReader:close	()V
    //   310: iload 10
    //   312: istore 8
    //   314: iload 6
    //   316: istore 9
    //   318: iload 5
    //   320: istore 6
    //   322: iload 9
    //   324: istore 5
    //   326: iload 6
    //   328: iconst_2
    //   329: if_icmplt +5479 -> 5808
    //   332: iload 5
    //   334: iconst_2
    //   335: if_icmplt +5473 -> 5808
    //   338: ldc 190
    //   340: iconst_1
    //   341: new 135	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   348: ldc_w 286
    //   351: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: iload 6
    //   356: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   359: ldc_w 291
    //   362: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: iload 5
    //   367: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   370: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   376: iload 6
    //   378: ifgt +8 -> 386
    //   381: iload 5
    //   383: ifle -360 -> 23
    //   386: new 199	org/json/JSONObject
    //   389: dup
    //   390: invokespecial 200	org/json/JSONObject:<init>	()V
    //   393: astore 19
    //   395: new 199	org/json/JSONObject
    //   398: dup
    //   399: invokespecial 200	org/json/JSONObject:<init>	()V
    //   402: astore 20
    //   404: aload 20
    //   406: ldc_w 293
    //   409: invokestatic 297	com/tencent/mfsdk/MagnifierSDK:a	()Ljava/lang/String;
    //   412: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   415: pop
    //   416: aload 20
    //   418: ldc_w 299
    //   421: bipush 124
    //   423: invokestatic 303	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   426: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   429: pop
    //   430: aload 19
    //   432: ldc_w 305
    //   435: aload 20
    //   437: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   440: pop
    //   441: aload 19
    //   443: ldc_w 307
    //   446: bipush 124
    //   448: invokevirtual 225	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   451: pop
    //   452: aload 19
    //   454: ldc_w 309
    //   457: aload 25
    //   459: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   462: pop
    //   463: invokestatic 233	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   466: aconst_null
    //   467: invokevirtual 237	com/tencent/common/app/BaseApplicationImpl:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   470: checkcast 239	com/tencent/mobileqq/app/QQAppInterface
    //   473: astore 20
    //   475: aload 20
    //   477: ifnull +5528 -> 6005
    //   480: aload 20
    //   482: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   485: invokestatic 315	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   488: lstore_1
    //   489: new 317	com/tencent/mfsdk/collector/ResultObject
    //   492: dup
    //   493: iconst_0
    //   494: ldc_w 319
    //   497: iconst_1
    //   498: lconst_1
    //   499: lconst_1
    //   500: aload 19
    //   502: iconst_1
    //   503: iconst_1
    //   504: lload_1
    //   505: invokespecial 322	com/tencent/mfsdk/collector/ResultObject:<init>	(ILjava/lang/String;ZJJLorg/json/JSONObject;ZZJ)V
    //   508: invokestatic 327	com/tencent/mfsdk/reporter/ReporterMachine:a	(Lcom/tencent/mfsdk/collector/ResultObject;)V
    //   511: ldc 190
    //   513: iconst_1
    //   514: ldc_w 329
    //   517: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   520: invokestatic 335	java/lang/Math:random	()D
    //   523: ldc2_w 336
    //   526: dcmpg
    //   527: ifge -504 -> 23
    //   530: invokestatic 343	com/tencent/mobileqq/mqsafeedit/BaseApplication:getContext	()Landroid/content/Context;
    //   533: invokestatic 348	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   536: aconst_null
    //   537: ldc_w 350
    //   540: iconst_1
    //   541: lconst_0
    //   542: lconst_0
    //   543: aload 24
    //   545: aconst_null
    //   546: invokevirtual 353	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   549: return
    //   550: iload 7
    //   552: istore 18
    //   554: iload 6
    //   556: istore 17
    //   558: iload 5
    //   560: istore 13
    //   562: iload 15
    //   564: istore 14
    //   566: iload 6
    //   568: istore 8
    //   570: iload 5
    //   572: istore 11
    //   574: aload 22
    //   576: ldc_w 355
    //   579: invokevirtual 359	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   582: astore 26
    //   584: aload 26
    //   586: iconst_1
    //   587: aaload
    //   588: astore 27
    //   590: iload 7
    //   592: istore 16
    //   594: iload 6
    //   596: istore 9
    //   598: iload 5
    //   600: istore 10
    //   602: iload 6
    //   604: istore 8
    //   606: iload 5
    //   608: istore 11
    //   610: aload 27
    //   612: ldc_w 361
    //   615: invokevirtual 364	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   618: ifeq +13 -> 631
    //   621: iload 15
    //   623: istore 12
    //   625: iload 5
    //   627: iconst_2
    //   628: if_icmpgt -405 -> 223
    //   631: iload 7
    //   633: istore 16
    //   635: iload 6
    //   637: istore 9
    //   639: iload 5
    //   641: istore 10
    //   643: iload 6
    //   645: istore 8
    //   647: iload 5
    //   649: istore 11
    //   651: aload 27
    //   653: ldc_w 366
    //   656: invokevirtual 364	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   659: ifeq +13 -> 672
    //   662: iload 15
    //   664: istore 12
    //   666: iload 6
    //   668: iconst_2
    //   669: if_icmpgt -446 -> 223
    //   672: iload 7
    //   674: istore 16
    //   676: iload 6
    //   678: istore 9
    //   680: iload 5
    //   682: istore 10
    //   684: iload 6
    //   686: istore 8
    //   688: iload 5
    //   690: istore 11
    //   692: aload 25
    //   694: aload 27
    //   696: invokevirtual 369	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   699: ifne +888 -> 1587
    //   702: iload 7
    //   704: istore 16
    //   706: iload 6
    //   708: istore 9
    //   710: iload 5
    //   712: istore 10
    //   714: iload 6
    //   716: istore 8
    //   718: iload 5
    //   720: istore 11
    //   722: new 371	org/json/JSONArray
    //   725: dup
    //   726: invokespecial 372	org/json/JSONArray:<init>	()V
    //   729: astore 19
    //   731: iload 7
    //   733: istore 16
    //   735: iload 6
    //   737: istore 9
    //   739: iload 5
    //   741: istore 10
    //   743: iload 6
    //   745: istore 8
    //   747: iload 5
    //   749: istore 11
    //   751: aload 25
    //   753: aload 27
    //   755: aload 19
    //   757: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   760: pop
    //   761: iload 7
    //   763: istore 16
    //   765: iload 6
    //   767: istore 9
    //   769: iload 5
    //   771: istore 10
    //   773: iload 6
    //   775: istore 8
    //   777: iload 5
    //   779: istore 11
    //   781: aload 26
    //   783: iconst_0
    //   784: aaload
    //   785: invokestatic 375	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   788: invokevirtual 379	java/lang/Long:longValue	()J
    //   791: ldc2_w 380
    //   794: ldiv
    //   795: l2i
    //   796: istore 17
    //   798: iload 7
    //   800: istore 16
    //   802: iload 6
    //   804: istore 9
    //   806: iload 5
    //   808: istore 10
    //   810: iload 6
    //   812: istore 8
    //   814: iload 5
    //   816: istore 11
    //   818: aload 27
    //   820: ldc_w 383
    //   823: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   826: ifne +34 -> 860
    //   829: iload 7
    //   831: istore 16
    //   833: iload 6
    //   835: istore 9
    //   837: iload 5
    //   839: istore 10
    //   841: iload 6
    //   843: istore 8
    //   845: iload 5
    //   847: istore 11
    //   849: aload 27
    //   851: ldc_w 389
    //   854: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   857: ifeq +852 -> 1709
    //   860: iload 7
    //   862: istore 16
    //   864: iload 6
    //   866: istore 9
    //   868: iload 5
    //   870: istore 10
    //   872: iload 6
    //   874: istore 8
    //   876: iload 5
    //   878: istore 11
    //   880: aload 27
    //   882: ldc_w 383
    //   885: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   888: ifeq +731 -> 1619
    //   891: iload 5
    //   893: iconst_1
    //   894: iadd
    //   895: istore 14
    //   897: iload 6
    //   899: istore 13
    //   901: iload 7
    //   903: istore 16
    //   905: iload 13
    //   907: istore 9
    //   909: iload 14
    //   911: istore 10
    //   913: iload 13
    //   915: istore 8
    //   917: iload 14
    //   919: istore 11
    //   921: new 199	org/json/JSONObject
    //   924: dup
    //   925: invokespecial 200	org/json/JSONObject:<init>	()V
    //   928: astore 28
    //   930: iload 7
    //   932: istore 16
    //   934: iload 13
    //   936: istore 9
    //   938: iload 14
    //   940: istore 10
    //   942: iload 13
    //   944: istore 8
    //   946: iload 14
    //   948: istore 11
    //   950: aload 28
    //   952: ldc_w 391
    //   955: aload 26
    //   957: iconst_2
    //   958: aaload
    //   959: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   962: pop
    //   963: iload 7
    //   965: istore 16
    //   967: iload 13
    //   969: istore 9
    //   971: iload 14
    //   973: istore 10
    //   975: iload 13
    //   977: istore 8
    //   979: iload 14
    //   981: istore 11
    //   983: aload 28
    //   985: ldc 205
    //   987: aload 26
    //   989: iconst_3
    //   990: aaload
    //   991: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   994: pop
    //   995: iload 7
    //   997: istore 16
    //   999: iload 13
    //   1001: istore 9
    //   1003: iload 14
    //   1005: istore 10
    //   1007: iload 13
    //   1009: istore 8
    //   1011: iload 14
    //   1013: istore 11
    //   1015: aload 28
    //   1017: ldc_w 393
    //   1020: iload 17
    //   1022: invokevirtual 225	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1025: pop
    //   1026: iload 7
    //   1028: istore 16
    //   1030: iload 13
    //   1032: istore 9
    //   1034: iload 14
    //   1036: istore 10
    //   1038: iload 13
    //   1040: istore 8
    //   1042: iload 14
    //   1044: istore 11
    //   1046: aload 26
    //   1048: arraylength
    //   1049: iconst_5
    //   1050: if_icmplt +36 -> 1086
    //   1053: iload 7
    //   1055: istore 16
    //   1057: iload 13
    //   1059: istore 9
    //   1061: iload 14
    //   1063: istore 10
    //   1065: iload 13
    //   1067: istore 8
    //   1069: iload 14
    //   1071: istore 11
    //   1073: aload 28
    //   1075: ldc_w 395
    //   1078: aload 26
    //   1080: iconst_3
    //   1081: aaload
    //   1082: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1085: pop
    //   1086: iload 7
    //   1088: istore 16
    //   1090: iload 13
    //   1092: istore 9
    //   1094: iload 14
    //   1096: istore 10
    //   1098: iload 13
    //   1100: istore 8
    //   1102: iload 14
    //   1104: istore 11
    //   1106: aload 19
    //   1108: aload 28
    //   1110: invokevirtual 398	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   1113: pop
    //   1114: iload 13
    //   1116: istore 6
    //   1118: iload 14
    //   1120: istore 5
    //   1122: iload 15
    //   1124: istore 12
    //   1126: iload 7
    //   1128: istore 16
    //   1130: iload 13
    //   1132: istore 9
    //   1134: iload 14
    //   1136: istore 10
    //   1138: iload 13
    //   1140: istore 8
    //   1142: iload 14
    //   1144: istore 11
    //   1146: aload 24
    //   1148: new 135	java/lang/StringBuilder
    //   1151: dup
    //   1152: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   1155: aload 27
    //   1157: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1160: ldc_w 400
    //   1163: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1166: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1169: invokevirtual 403	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1172: ifne -949 -> 223
    //   1175: iload 7
    //   1177: istore 16
    //   1179: iload 13
    //   1181: istore 9
    //   1183: iload 14
    //   1185: istore 10
    //   1187: iload 13
    //   1189: istore 8
    //   1191: iload 14
    //   1193: istore 11
    //   1195: aload 24
    //   1197: new 135	java/lang/StringBuilder
    //   1200: dup
    //   1201: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   1204: aload 27
    //   1206: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1209: ldc_w 405
    //   1212: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1215: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1218: iload 17
    //   1220: invokestatic 303	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1223: invokevirtual 408	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1226: pop
    //   1227: iload 7
    //   1229: istore 16
    //   1231: iload 13
    //   1233: istore 9
    //   1235: iload 14
    //   1237: istore 10
    //   1239: iload 13
    //   1241: istore 8
    //   1243: iload 14
    //   1245: istore 11
    //   1247: aload 24
    //   1249: new 135	java/lang/StringBuilder
    //   1252: dup
    //   1253: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   1256: aload 27
    //   1258: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1261: ldc_w 400
    //   1264: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1267: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1270: aload 26
    //   1272: iconst_2
    //   1273: aaload
    //   1274: invokevirtual 408	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1277: pop
    //   1278: iload 7
    //   1280: istore 16
    //   1282: iload 13
    //   1284: istore 9
    //   1286: iload 14
    //   1288: istore 10
    //   1290: iload 13
    //   1292: istore 8
    //   1294: iload 14
    //   1296: istore 11
    //   1298: aload 24
    //   1300: new 135	java/lang/StringBuilder
    //   1303: dup
    //   1304: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   1307: aload 27
    //   1309: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1312: ldc_w 410
    //   1315: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1318: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1321: aload 26
    //   1323: iconst_3
    //   1324: aaload
    //   1325: invokevirtual 408	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1328: pop
    //   1329: iload 13
    //   1331: istore 8
    //   1333: iload 14
    //   1335: istore 11
    //   1337: aload 26
    //   1339: iconst_2
    //   1340: aaload
    //   1341: invokestatic 375	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1344: invokevirtual 379	java/lang/Long:longValue	()J
    //   1347: ldc2_w 411
    //   1350: lmul
    //   1351: aload 26
    //   1353: iconst_3
    //   1354: aaload
    //   1355: invokestatic 375	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1358: invokevirtual 379	java/lang/Long:longValue	()J
    //   1361: ldiv
    //   1362: lstore_1
    //   1363: lload_1
    //   1364: l2i
    //   1365: istore 5
    //   1367: iload 7
    //   1369: istore 16
    //   1371: iload 13
    //   1373: istore 9
    //   1375: iload 14
    //   1377: istore 10
    //   1379: iload 13
    //   1381: istore 8
    //   1383: iload 14
    //   1385: istore 11
    //   1387: aload 24
    //   1389: new 135	java/lang/StringBuilder
    //   1392: dup
    //   1393: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   1396: aload 27
    //   1398: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1401: ldc_w 414
    //   1404: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1407: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1410: iload 5
    //   1412: invokestatic 303	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1415: invokevirtual 408	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1418: pop
    //   1419: iload 13
    //   1421: istore 6
    //   1423: iload 14
    //   1425: istore 5
    //   1427: iload 15
    //   1429: istore 12
    //   1431: goto -1208 -> 223
    //   1434: astore 19
    //   1436: iload 16
    //   1438: istore 18
    //   1440: iload 9
    //   1442: istore 17
    //   1444: iload 10
    //   1446: istore 13
    //   1448: iload 15
    //   1450: istore 14
    //   1452: iload 9
    //   1454: istore 8
    //   1456: iload 10
    //   1458: istore 11
    //   1460: ldc 190
    //   1462: iconst_2
    //   1463: new 135	java/lang/StringBuilder
    //   1466: dup
    //   1467: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   1470: ldc_w 416
    //   1473: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1476: aload 22
    //   1478: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1481: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1484: invokestatic 418	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1487: iload 16
    //   1489: istore 7
    //   1491: iload 9
    //   1493: istore 6
    //   1495: iload 10
    //   1497: istore 5
    //   1499: iload 15
    //   1501: istore 12
    //   1503: goto -1280 -> 223
    //   1506: astore 22
    //   1508: iload 18
    //   1510: istore 7
    //   1512: iload 17
    //   1514: istore 6
    //   1516: aload 20
    //   1518: astore 19
    //   1520: iload 14
    //   1522: istore 8
    //   1524: iload 13
    //   1526: istore 5
    //   1528: aload 21
    //   1530: astore 20
    //   1532: aload 22
    //   1534: astore 21
    //   1536: invokestatic 421	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1539: ifeq +13 -> 1552
    //   1542: ldc 190
    //   1544: iconst_2
    //   1545: ldc 132
    //   1547: aload 21
    //   1549: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1552: aload 20
    //   1554: ifnull +8 -> 1562
    //   1557: aload 20
    //   1559: invokevirtual 282	java/io/InputStream:close	()V
    //   1562: aload 19
    //   1564: ifnull +4446 -> 6010
    //   1567: aload 19
    //   1569: invokevirtual 283	java/io/BufferedReader:close	()V
    //   1572: iload 5
    //   1574: istore 9
    //   1576: iload 6
    //   1578: istore 5
    //   1580: iload 9
    //   1582: istore 6
    //   1584: goto -1258 -> 326
    //   1587: iload 7
    //   1589: istore 16
    //   1591: iload 6
    //   1593: istore 9
    //   1595: iload 5
    //   1597: istore 10
    //   1599: iload 6
    //   1601: istore 8
    //   1603: iload 5
    //   1605: istore 11
    //   1607: aload 25
    //   1609: aload 27
    //   1611: invokevirtual 428	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1614: astore 19
    //   1616: goto -855 -> 761
    //   1619: iload 6
    //   1621: istore 13
    //   1623: iload 5
    //   1625: istore 14
    //   1627: iload 7
    //   1629: istore 16
    //   1631: iload 6
    //   1633: istore 9
    //   1635: iload 5
    //   1637: istore 10
    //   1639: iload 6
    //   1641: istore 8
    //   1643: iload 5
    //   1645: istore 11
    //   1647: aload 27
    //   1649: ldc_w 389
    //   1652: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1655: ifeq -754 -> 901
    //   1658: iload 6
    //   1660: iconst_1
    //   1661: iadd
    //   1662: istore 13
    //   1664: iload 5
    //   1666: istore 14
    //   1668: goto -767 -> 901
    //   1671: astore 19
    //   1673: iload 7
    //   1675: istore 16
    //   1677: iload 13
    //   1679: istore 9
    //   1681: iload 14
    //   1683: istore 10
    //   1685: iload 13
    //   1687: istore 8
    //   1689: iload 14
    //   1691: istore 11
    //   1693: ldc 190
    //   1695: iconst_2
    //   1696: ldc 132
    //   1698: aload 19
    //   1700: invokestatic 430	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1703: iconst_m1
    //   1704: istore 5
    //   1706: goto -339 -> 1367
    //   1709: iload 7
    //   1711: istore 16
    //   1713: iload 6
    //   1715: istore 9
    //   1717: iload 5
    //   1719: istore 10
    //   1721: iload 6
    //   1723: istore 8
    //   1725: iload 5
    //   1727: istore 11
    //   1729: aload 27
    //   1731: ldc_w 432
    //   1734: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1737: ifne +34 -> 1771
    //   1740: iload 7
    //   1742: istore 16
    //   1744: iload 6
    //   1746: istore 9
    //   1748: iload 5
    //   1750: istore 10
    //   1752: iload 6
    //   1754: istore 8
    //   1756: iload 5
    //   1758: istore 11
    //   1760: aload 27
    //   1762: ldc_w 434
    //   1765: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1768: ifeq +637 -> 2405
    //   1771: iload 7
    //   1773: istore 16
    //   1775: iload 6
    //   1777: istore 9
    //   1779: iload 5
    //   1781: istore 10
    //   1783: iload 6
    //   1785: istore 8
    //   1787: iload 5
    //   1789: istore 11
    //   1791: new 199	org/json/JSONObject
    //   1794: dup
    //   1795: invokespecial 200	org/json/JSONObject:<init>	()V
    //   1798: astore 28
    //   1800: iload 7
    //   1802: istore 16
    //   1804: iload 6
    //   1806: istore 9
    //   1808: iload 5
    //   1810: istore 10
    //   1812: iload 6
    //   1814: istore 8
    //   1816: iload 5
    //   1818: istore 11
    //   1820: aload 28
    //   1822: ldc_w 393
    //   1825: iload 17
    //   1827: invokevirtual 225	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1830: pop
    //   1831: iload 7
    //   1833: istore 16
    //   1835: iload 6
    //   1837: istore 9
    //   1839: iload 5
    //   1841: istore 10
    //   1843: iload 6
    //   1845: istore 8
    //   1847: iload 5
    //   1849: istore 11
    //   1851: aload 28
    //   1853: ldc_w 436
    //   1856: aload 26
    //   1858: iconst_2
    //   1859: aaload
    //   1860: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1863: pop
    //   1864: iload 7
    //   1866: istore 16
    //   1868: iload 6
    //   1870: istore 9
    //   1872: iload 5
    //   1874: istore 10
    //   1876: iload 6
    //   1878: istore 8
    //   1880: iload 5
    //   1882: istore 11
    //   1884: aload 28
    //   1886: ldc_w 438
    //   1889: aload 26
    //   1891: iconst_3
    //   1892: aaload
    //   1893: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1896: pop
    //   1897: iload 7
    //   1899: istore 16
    //   1901: iload 6
    //   1903: istore 9
    //   1905: iload 5
    //   1907: istore 10
    //   1909: iload 6
    //   1911: istore 8
    //   1913: iload 5
    //   1915: istore 11
    //   1917: aload 28
    //   1919: ldc_w 440
    //   1922: aload 26
    //   1924: iconst_4
    //   1925: aaload
    //   1926: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1929: pop
    //   1930: iload 7
    //   1932: istore 16
    //   1934: iload 6
    //   1936: istore 9
    //   1938: iload 5
    //   1940: istore 10
    //   1942: iload 6
    //   1944: istore 8
    //   1946: iload 5
    //   1948: istore 11
    //   1950: aload 28
    //   1952: ldc_w 442
    //   1955: aload 26
    //   1957: iconst_5
    //   1958: aaload
    //   1959: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1962: pop
    //   1963: iload 7
    //   1965: istore 16
    //   1967: iload 6
    //   1969: istore 9
    //   1971: iload 5
    //   1973: istore 10
    //   1975: iload 6
    //   1977: istore 8
    //   1979: iload 5
    //   1981: istore 11
    //   1983: aload 19
    //   1985: aload 28
    //   1987: invokevirtual 398	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   1990: pop
    //   1991: iload 15
    //   1993: istore 12
    //   1995: iload 7
    //   1997: istore 16
    //   1999: iload 6
    //   2001: istore 9
    //   2003: iload 5
    //   2005: istore 10
    //   2007: iload 6
    //   2009: istore 8
    //   2011: iload 5
    //   2013: istore 11
    //   2015: aload 24
    //   2017: new 135	java/lang/StringBuilder
    //   2020: dup
    //   2021: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   2024: aload 27
    //   2026: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2029: ldc_w 405
    //   2032: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2035: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2038: invokevirtual 403	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2041: ifne -1818 -> 223
    //   2044: iload 7
    //   2046: istore 16
    //   2048: iload 6
    //   2050: istore 9
    //   2052: iload 5
    //   2054: istore 10
    //   2056: iload 6
    //   2058: istore 8
    //   2060: iload 5
    //   2062: istore 11
    //   2064: aload 24
    //   2066: new 135	java/lang/StringBuilder
    //   2069: dup
    //   2070: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   2073: aload 27
    //   2075: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2078: ldc_w 405
    //   2081: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2084: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2087: iload 17
    //   2089: invokestatic 303	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2092: invokevirtual 408	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2095: pop
    //   2096: iload 7
    //   2098: istore 16
    //   2100: iload 6
    //   2102: istore 9
    //   2104: iload 5
    //   2106: istore 10
    //   2108: iload 6
    //   2110: istore 8
    //   2112: iload 5
    //   2114: istore 11
    //   2116: aload 24
    //   2118: new 135	java/lang/StringBuilder
    //   2121: dup
    //   2122: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   2125: aload 27
    //   2127: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2130: ldc_w 444
    //   2133: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2136: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2139: aload 26
    //   2141: iconst_2
    //   2142: aaload
    //   2143: invokevirtual 408	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2146: pop
    //   2147: iload 7
    //   2149: istore 16
    //   2151: iload 6
    //   2153: istore 9
    //   2155: iload 5
    //   2157: istore 10
    //   2159: iload 6
    //   2161: istore 8
    //   2163: iload 5
    //   2165: istore 11
    //   2167: aload 24
    //   2169: new 135	java/lang/StringBuilder
    //   2172: dup
    //   2173: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   2176: aload 27
    //   2178: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2181: ldc_w 446
    //   2184: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2187: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2190: aload 26
    //   2192: iconst_3
    //   2193: aaload
    //   2194: invokevirtual 408	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2197: pop
    //   2198: iload 7
    //   2200: istore 16
    //   2202: iload 6
    //   2204: istore 9
    //   2206: iload 5
    //   2208: istore 10
    //   2210: iload 6
    //   2212: istore 8
    //   2214: iload 5
    //   2216: istore 11
    //   2218: aload 24
    //   2220: new 135	java/lang/StringBuilder
    //   2223: dup
    //   2224: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   2227: aload 27
    //   2229: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2232: ldc_w 448
    //   2235: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2238: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2241: aload 26
    //   2243: iconst_4
    //   2244: aaload
    //   2245: invokevirtual 408	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2248: pop
    //   2249: iload 7
    //   2251: istore 16
    //   2253: iload 6
    //   2255: istore 9
    //   2257: iload 5
    //   2259: istore 10
    //   2261: iload 6
    //   2263: istore 8
    //   2265: iload 5
    //   2267: istore 11
    //   2269: aload 24
    //   2271: new 135	java/lang/StringBuilder
    //   2274: dup
    //   2275: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   2278: aload 27
    //   2280: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2283: ldc_w 450
    //   2286: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2289: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2292: aload 26
    //   2294: iconst_5
    //   2295: aaload
    //   2296: invokevirtual 408	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2299: pop
    //   2300: iload 15
    //   2302: istore 12
    //   2304: goto -2081 -> 223
    //   2307: astore 19
    //   2309: iload 11
    //   2311: istore 5
    //   2313: iload 8
    //   2315: istore 6
    //   2317: aload 21
    //   2319: ifnull +16 -> 2335
    //   2322: iload 6
    //   2324: istore 9
    //   2326: iload 5
    //   2328: istore 8
    //   2330: aload 21
    //   2332: invokevirtual 282	java/io/InputStream:close	()V
    //   2335: aload 20
    //   2337: ifnull +16 -> 2353
    //   2340: iload 6
    //   2342: istore 9
    //   2344: iload 5
    //   2346: istore 8
    //   2348: aload 20
    //   2350: invokevirtual 283	java/io/BufferedReader:close	()V
    //   2353: iload 6
    //   2355: istore 9
    //   2357: iload 5
    //   2359: istore 8
    //   2361: aload 19
    //   2363: athrow
    //   2364: astore 19
    //   2366: iload 9
    //   2368: istore 7
    //   2370: iload 7
    //   2372: istore 5
    //   2374: iload 8
    //   2376: istore 6
    //   2378: invokestatic 421	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2381: ifeq -2043 -> 338
    //   2384: ldc 190
    //   2386: iconst_2
    //   2387: ldc 132
    //   2389: aload 19
    //   2391: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2394: iload 7
    //   2396: istore 5
    //   2398: iload 8
    //   2400: istore 6
    //   2402: goto -2064 -> 338
    //   2405: iload 7
    //   2407: istore 16
    //   2409: iload 6
    //   2411: istore 9
    //   2413: iload 5
    //   2415: istore 10
    //   2417: iload 6
    //   2419: istore 8
    //   2421: iload 5
    //   2423: istore 11
    //   2425: aload 27
    //   2427: ldc_w 452
    //   2430: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2433: ifne +282 -> 2715
    //   2436: iload 7
    //   2438: istore 16
    //   2440: iload 6
    //   2442: istore 9
    //   2444: iload 5
    //   2446: istore 10
    //   2448: iload 6
    //   2450: istore 8
    //   2452: iload 5
    //   2454: istore 11
    //   2456: aload 27
    //   2458: ldc_w 454
    //   2461: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2464: ifne +251 -> 2715
    //   2467: iload 7
    //   2469: istore 16
    //   2471: iload 6
    //   2473: istore 9
    //   2475: iload 5
    //   2477: istore 10
    //   2479: iload 6
    //   2481: istore 8
    //   2483: iload 5
    //   2485: istore 11
    //   2487: aload 27
    //   2489: ldc_w 456
    //   2492: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2495: ifne +220 -> 2715
    //   2498: iload 7
    //   2500: istore 16
    //   2502: iload 6
    //   2504: istore 9
    //   2506: iload 5
    //   2508: istore 10
    //   2510: iload 6
    //   2512: istore 8
    //   2514: iload 5
    //   2516: istore 11
    //   2518: aload 27
    //   2520: ldc_w 458
    //   2523: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2526: ifne +189 -> 2715
    //   2529: iload 7
    //   2531: istore 16
    //   2533: iload 6
    //   2535: istore 9
    //   2537: iload 5
    //   2539: istore 10
    //   2541: iload 6
    //   2543: istore 8
    //   2545: iload 5
    //   2547: istore 11
    //   2549: aload 27
    //   2551: ldc_w 460
    //   2554: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2557: ifne +158 -> 2715
    //   2560: iload 7
    //   2562: istore 16
    //   2564: iload 6
    //   2566: istore 9
    //   2568: iload 5
    //   2570: istore 10
    //   2572: iload 6
    //   2574: istore 8
    //   2576: iload 5
    //   2578: istore 11
    //   2580: aload 27
    //   2582: ldc_w 462
    //   2585: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2588: ifne +127 -> 2715
    //   2591: iload 7
    //   2593: istore 16
    //   2595: iload 6
    //   2597: istore 9
    //   2599: iload 5
    //   2601: istore 10
    //   2603: iload 6
    //   2605: istore 8
    //   2607: iload 5
    //   2609: istore 11
    //   2611: aload 27
    //   2613: ldc_w 464
    //   2616: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2619: ifne +96 -> 2715
    //   2622: iload 7
    //   2624: istore 16
    //   2626: iload 6
    //   2628: istore 9
    //   2630: iload 5
    //   2632: istore 10
    //   2634: iload 6
    //   2636: istore 8
    //   2638: iload 5
    //   2640: istore 11
    //   2642: aload 27
    //   2644: ldc_w 466
    //   2647: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2650: ifne +65 -> 2715
    //   2653: iload 7
    //   2655: istore 16
    //   2657: iload 6
    //   2659: istore 9
    //   2661: iload 5
    //   2663: istore 10
    //   2665: iload 6
    //   2667: istore 8
    //   2669: iload 5
    //   2671: istore 11
    //   2673: aload 27
    //   2675: ldc_w 468
    //   2678: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2681: ifne +34 -> 2715
    //   2684: iload 7
    //   2686: istore 16
    //   2688: iload 6
    //   2690: istore 9
    //   2692: iload 5
    //   2694: istore 10
    //   2696: iload 6
    //   2698: istore 8
    //   2700: iload 5
    //   2702: istore 11
    //   2704: aload 27
    //   2706: ldc_w 470
    //   2709: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2712: ifeq +287 -> 2999
    //   2715: iload 7
    //   2717: istore 16
    //   2719: iload 6
    //   2721: istore 9
    //   2723: iload 5
    //   2725: istore 10
    //   2727: iload 6
    //   2729: istore 8
    //   2731: iload 5
    //   2733: istore 11
    //   2735: new 199	org/json/JSONObject
    //   2738: dup
    //   2739: invokespecial 200	org/json/JSONObject:<init>	()V
    //   2742: astore 28
    //   2744: iload 7
    //   2746: istore 16
    //   2748: iload 6
    //   2750: istore 9
    //   2752: iload 5
    //   2754: istore 10
    //   2756: iload 6
    //   2758: istore 8
    //   2760: iload 5
    //   2762: istore 11
    //   2764: aload 28
    //   2766: ldc_w 393
    //   2769: iload 17
    //   2771: invokevirtual 225	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2774: pop
    //   2775: iload 7
    //   2777: istore 16
    //   2779: iload 6
    //   2781: istore 9
    //   2783: iload 5
    //   2785: istore 10
    //   2787: iload 6
    //   2789: istore 8
    //   2791: iload 5
    //   2793: istore 11
    //   2795: aload 28
    //   2797: ldc_w 472
    //   2800: aload 26
    //   2802: iconst_2
    //   2803: aaload
    //   2804: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2807: pop
    //   2808: iload 7
    //   2810: istore 16
    //   2812: iload 6
    //   2814: istore 9
    //   2816: iload 5
    //   2818: istore 10
    //   2820: iload 6
    //   2822: istore 8
    //   2824: iload 5
    //   2826: istore 11
    //   2828: aload 19
    //   2830: aload 28
    //   2832: invokevirtual 398	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   2835: pop
    //   2836: iload 15
    //   2838: istore 12
    //   2840: iload 7
    //   2842: istore 16
    //   2844: iload 6
    //   2846: istore 9
    //   2848: iload 5
    //   2850: istore 10
    //   2852: iload 6
    //   2854: istore 8
    //   2856: iload 5
    //   2858: istore 11
    //   2860: aload 24
    //   2862: new 135	java/lang/StringBuilder
    //   2865: dup
    //   2866: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   2869: aload 27
    //   2871: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2874: ldc_w 474
    //   2877: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2880: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2883: invokevirtual 403	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2886: ifne -2663 -> 223
    //   2889: iload 7
    //   2891: istore 16
    //   2893: iload 6
    //   2895: istore 9
    //   2897: iload 5
    //   2899: istore 10
    //   2901: iload 6
    //   2903: istore 8
    //   2905: iload 5
    //   2907: istore 11
    //   2909: aload 24
    //   2911: new 135	java/lang/StringBuilder
    //   2914: dup
    //   2915: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   2918: aload 27
    //   2920: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2923: ldc_w 474
    //   2926: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2929: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2932: aload 26
    //   2934: iconst_2
    //   2935: aaload
    //   2936: invokevirtual 408	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2939: pop
    //   2940: iload 7
    //   2942: istore 16
    //   2944: iload 6
    //   2946: istore 9
    //   2948: iload 5
    //   2950: istore 10
    //   2952: iload 6
    //   2954: istore 8
    //   2956: iload 5
    //   2958: istore 11
    //   2960: aload 24
    //   2962: new 135	java/lang/StringBuilder
    //   2965: dup
    //   2966: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   2969: aload 27
    //   2971: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2974: ldc_w 405
    //   2977: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2980: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2983: iload 17
    //   2985: invokestatic 303	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2988: invokevirtual 408	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2991: pop
    //   2992: iload 15
    //   2994: istore 12
    //   2996: goto -2773 -> 223
    //   2999: iload 7
    //   3001: istore 16
    //   3003: iload 6
    //   3005: istore 9
    //   3007: iload 5
    //   3009: istore 10
    //   3011: iload 6
    //   3013: istore 8
    //   3015: iload 5
    //   3017: istore 11
    //   3019: aload 27
    //   3021: ldc_w 476
    //   3024: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3027: ifne +96 -> 3123
    //   3030: iload 7
    //   3032: istore 16
    //   3034: iload 6
    //   3036: istore 9
    //   3038: iload 5
    //   3040: istore 10
    //   3042: iload 6
    //   3044: istore 8
    //   3046: iload 5
    //   3048: istore 11
    //   3050: aload 27
    //   3052: ldc_w 478
    //   3055: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3058: ifne +65 -> 3123
    //   3061: iload 7
    //   3063: istore 16
    //   3065: iload 6
    //   3067: istore 9
    //   3069: iload 5
    //   3071: istore 10
    //   3073: iload 6
    //   3075: istore 8
    //   3077: iload 5
    //   3079: istore 11
    //   3081: aload 27
    //   3083: ldc_w 480
    //   3086: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3089: ifne +34 -> 3123
    //   3092: iload 7
    //   3094: istore 16
    //   3096: iload 6
    //   3098: istore 9
    //   3100: iload 5
    //   3102: istore 10
    //   3104: iload 6
    //   3106: istore 8
    //   3108: iload 5
    //   3110: istore 11
    //   3112: aload 27
    //   3114: ldc_w 482
    //   3117: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3120: ifeq +558 -> 3678
    //   3123: iload 7
    //   3125: istore 16
    //   3127: iload 6
    //   3129: istore 9
    //   3131: iload 5
    //   3133: istore 10
    //   3135: iload 6
    //   3137: istore 8
    //   3139: iload 5
    //   3141: istore 11
    //   3143: new 199	org/json/JSONObject
    //   3146: dup
    //   3147: invokespecial 200	org/json/JSONObject:<init>	()V
    //   3150: astore 28
    //   3152: iload 7
    //   3154: istore 16
    //   3156: iload 6
    //   3158: istore 9
    //   3160: iload 5
    //   3162: istore 10
    //   3164: iload 6
    //   3166: istore 8
    //   3168: iload 5
    //   3170: istore 11
    //   3172: aload_0
    //   3173: aload 26
    //   3175: iconst_2
    //   3176: aload 26
    //   3178: arraylength
    //   3179: iconst_2
    //   3180: isub
    //   3181: invokespecial 484	com/tencent/mobileqq/statistics/battery/BatteryStatsImpl:a	([Ljava/lang/String;II)Ljava/lang/String;
    //   3184: astore 29
    //   3186: iload 7
    //   3188: istore 16
    //   3190: iload 6
    //   3192: istore 9
    //   3194: iload 5
    //   3196: istore 10
    //   3198: iload 6
    //   3200: istore 8
    //   3202: iload 5
    //   3204: istore 11
    //   3206: aload 27
    //   3208: ldc_w 480
    //   3211: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3214: ifne +34 -> 3248
    //   3217: iload 7
    //   3219: istore 16
    //   3221: iload 6
    //   3223: istore 9
    //   3225: iload 5
    //   3227: istore 10
    //   3229: iload 6
    //   3231: istore 8
    //   3233: iload 5
    //   3235: istore 11
    //   3237: aload 27
    //   3239: ldc_w 482
    //   3242: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3245: ifeq +364 -> 3609
    //   3248: iload 7
    //   3250: istore 16
    //   3252: iload 6
    //   3254: istore 9
    //   3256: iload 5
    //   3258: istore 10
    //   3260: iload 6
    //   3262: istore 8
    //   3264: iload 5
    //   3266: istore 11
    //   3268: aload 28
    //   3270: ldc_w 486
    //   3273: aload 29
    //   3275: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3278: pop
    //   3279: iload 7
    //   3281: istore 16
    //   3283: iload 6
    //   3285: istore 9
    //   3287: iload 5
    //   3289: istore 10
    //   3291: iload 6
    //   3293: istore 8
    //   3295: iload 5
    //   3297: istore 11
    //   3299: new 371	org/json/JSONArray
    //   3302: dup
    //   3303: invokespecial 372	org/json/JSONArray:<init>	()V
    //   3306: astore 27
    //   3308: iload 7
    //   3310: istore 16
    //   3312: iload 6
    //   3314: istore 9
    //   3316: iload 5
    //   3318: istore 10
    //   3320: iload 6
    //   3322: istore 8
    //   3324: iload 5
    //   3326: istore 11
    //   3328: aload 28
    //   3330: ldc_w 488
    //   3333: aload 27
    //   3335: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3338: pop
    //   3339: iload 7
    //   3341: istore 16
    //   3343: iload 6
    //   3345: istore 9
    //   3347: iload 5
    //   3349: istore 10
    //   3351: iload 6
    //   3353: istore 8
    //   3355: iload 5
    //   3357: istore 11
    //   3359: aload 26
    //   3361: aload 26
    //   3363: arraylength
    //   3364: iconst_1
    //   3365: isub
    //   3366: aaload
    //   3367: ldc 119
    //   3369: invokevirtual 359	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   3372: astore 26
    //   3374: iload 7
    //   3376: istore 16
    //   3378: iload 6
    //   3380: istore 9
    //   3382: iload 5
    //   3384: istore 10
    //   3386: iload 6
    //   3388: istore 8
    //   3390: iload 5
    //   3392: istore 11
    //   3394: aload 26
    //   3396: arraylength
    //   3397: istore 13
    //   3399: iconst_0
    //   3400: istore 12
    //   3402: iload 12
    //   3404: iload 13
    //   3406: if_icmpge +237 -> 3643
    //   3409: iload 7
    //   3411: istore 16
    //   3413: iload 6
    //   3415: istore 9
    //   3417: iload 5
    //   3419: istore 10
    //   3421: iload 6
    //   3423: istore 8
    //   3425: iload 5
    //   3427: istore 11
    //   3429: aload 26
    //   3431: iload 12
    //   3433: aaload
    //   3434: ldc 176
    //   3436: invokevirtual 359	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   3439: astore 29
    //   3441: aload 29
    //   3443: ifnull +2623 -> 6066
    //   3446: iload 7
    //   3448: istore 16
    //   3450: iload 6
    //   3452: istore 9
    //   3454: iload 5
    //   3456: istore 10
    //   3458: iload 6
    //   3460: istore 8
    //   3462: iload 5
    //   3464: istore 11
    //   3466: aload 29
    //   3468: arraylength
    //   3469: iconst_1
    //   3470: if_icmple +2596 -> 6066
    //   3473: iload 7
    //   3475: istore 16
    //   3477: iload 6
    //   3479: istore 9
    //   3481: iload 5
    //   3483: istore 10
    //   3485: iload 6
    //   3487: istore 8
    //   3489: iload 5
    //   3491: istore 11
    //   3493: new 199	org/json/JSONObject
    //   3496: dup
    //   3497: invokespecial 200	org/json/JSONObject:<init>	()V
    //   3500: astore 30
    //   3502: iload 7
    //   3504: istore 16
    //   3506: iload 6
    //   3508: istore 9
    //   3510: iload 5
    //   3512: istore 10
    //   3514: iload 6
    //   3516: istore 8
    //   3518: iload 5
    //   3520: istore 11
    //   3522: aload 30
    //   3524: ldc_w 393
    //   3527: aload 29
    //   3529: iconst_0
    //   3530: aaload
    //   3531: invokestatic 375	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   3534: invokevirtual 379	java/lang/Long:longValue	()J
    //   3537: ldc2_w 380
    //   3540: ldiv
    //   3541: invokevirtual 491	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   3544: pop
    //   3545: iload 7
    //   3547: istore 16
    //   3549: iload 6
    //   3551: istore 9
    //   3553: iload 5
    //   3555: istore 10
    //   3557: iload 6
    //   3559: istore 8
    //   3561: iload 5
    //   3563: istore 11
    //   3565: aload 30
    //   3567: ldc_w 472
    //   3570: aload 29
    //   3572: iconst_1
    //   3573: aaload
    //   3574: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3577: pop
    //   3578: iload 7
    //   3580: istore 16
    //   3582: iload 6
    //   3584: istore 9
    //   3586: iload 5
    //   3588: istore 10
    //   3590: iload 6
    //   3592: istore 8
    //   3594: iload 5
    //   3596: istore 11
    //   3598: aload 27
    //   3600: aload 30
    //   3602: invokevirtual 398	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   3605: pop
    //   3606: goto +2460 -> 6066
    //   3609: iload 7
    //   3611: istore 16
    //   3613: iload 6
    //   3615: istore 9
    //   3617: iload 5
    //   3619: istore 10
    //   3621: iload 6
    //   3623: istore 8
    //   3625: iload 5
    //   3627: istore 11
    //   3629: aload 28
    //   3631: ldc_w 493
    //   3634: aload 29
    //   3636: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3639: pop
    //   3640: goto -361 -> 3279
    //   3643: iload 7
    //   3645: istore 16
    //   3647: iload 6
    //   3649: istore 9
    //   3651: iload 5
    //   3653: istore 10
    //   3655: iload 6
    //   3657: istore 8
    //   3659: iload 5
    //   3661: istore 11
    //   3663: aload 19
    //   3665: aload 28
    //   3667: invokevirtual 398	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   3670: pop
    //   3671: iload 15
    //   3673: istore 12
    //   3675: goto -3452 -> 223
    //   3678: iload 7
    //   3680: istore 16
    //   3682: iload 6
    //   3684: istore 9
    //   3686: iload 5
    //   3688: istore 10
    //   3690: iload 6
    //   3692: istore 8
    //   3694: iload 5
    //   3696: istore 11
    //   3698: aload 27
    //   3700: ldc_w 495
    //   3703: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3706: ifne +96 -> 3802
    //   3709: iload 7
    //   3711: istore 16
    //   3713: iload 6
    //   3715: istore 9
    //   3717: iload 5
    //   3719: istore 10
    //   3721: iload 6
    //   3723: istore 8
    //   3725: iload 5
    //   3727: istore 11
    //   3729: aload 27
    //   3731: ldc_w 497
    //   3734: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3737: ifne +65 -> 3802
    //   3740: iload 7
    //   3742: istore 16
    //   3744: iload 6
    //   3746: istore 9
    //   3748: iload 5
    //   3750: istore 10
    //   3752: iload 6
    //   3754: istore 8
    //   3756: iload 5
    //   3758: istore 11
    //   3760: aload 27
    //   3762: ldc_w 499
    //   3765: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3768: ifne +34 -> 3802
    //   3771: iload 7
    //   3773: istore 16
    //   3775: iload 6
    //   3777: istore 9
    //   3779: iload 5
    //   3781: istore 10
    //   3783: iload 6
    //   3785: istore 8
    //   3787: iload 5
    //   3789: istore 11
    //   3791: aload 27
    //   3793: ldc_w 501
    //   3796: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3799: ifeq +501 -> 4300
    //   3802: iload 7
    //   3804: istore 16
    //   3806: iload 6
    //   3808: istore 9
    //   3810: iload 5
    //   3812: istore 10
    //   3814: iload 6
    //   3816: istore 8
    //   3818: iload 5
    //   3820: istore 11
    //   3822: new 199	org/json/JSONObject
    //   3825: dup
    //   3826: invokespecial 200	org/json/JSONObject:<init>	()V
    //   3829: astore 28
    //   3831: iload 7
    //   3833: istore 16
    //   3835: iload 6
    //   3837: istore 9
    //   3839: iload 5
    //   3841: istore 10
    //   3843: iload 6
    //   3845: istore 8
    //   3847: iload 5
    //   3849: istore 11
    //   3851: aload 28
    //   3853: ldc_w 472
    //   3856: aload 26
    //   3858: iconst_2
    //   3859: aaload
    //   3860: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3863: pop
    //   3864: iload 7
    //   3866: istore 16
    //   3868: iload 6
    //   3870: istore 9
    //   3872: iload 5
    //   3874: istore 10
    //   3876: iload 6
    //   3878: istore 8
    //   3880: iload 5
    //   3882: istore 11
    //   3884: aload 28
    //   3886: ldc_w 393
    //   3889: iload 17
    //   3891: invokevirtual 225	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   3894: pop
    //   3895: iload 7
    //   3897: istore 16
    //   3899: iload 6
    //   3901: istore 9
    //   3903: iload 5
    //   3905: istore 10
    //   3907: iload 6
    //   3909: istore 8
    //   3911: iload 5
    //   3913: istore 11
    //   3915: aload 28
    //   3917: ldc_w 503
    //   3920: aload 26
    //   3922: iconst_3
    //   3923: aaload
    //   3924: invokestatic 375	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   3927: invokevirtual 379	java/lang/Long:longValue	()J
    //   3930: ldc2_w 380
    //   3933: ldiv
    //   3934: invokevirtual 491	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   3937: pop
    //   3938: iload 7
    //   3940: istore 16
    //   3942: iload 6
    //   3944: istore 9
    //   3946: iload 5
    //   3948: istore 10
    //   3950: iload 6
    //   3952: istore 8
    //   3954: iload 5
    //   3956: istore 11
    //   3958: aload 28
    //   3960: ldc_w 505
    //   3963: aload 26
    //   3965: iconst_4
    //   3966: aaload
    //   3967: invokestatic 375	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   3970: invokevirtual 379	java/lang/Long:longValue	()J
    //   3973: ldc2_w 380
    //   3976: ldiv
    //   3977: invokevirtual 491	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   3980: pop
    //   3981: iload 7
    //   3983: istore 16
    //   3985: iload 6
    //   3987: istore 9
    //   3989: iload 5
    //   3991: istore 10
    //   3993: iload 6
    //   3995: istore 8
    //   3997: iload 5
    //   3999: istore 11
    //   4001: aload 19
    //   4003: aload 28
    //   4005: invokevirtual 398	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   4008: pop
    //   4009: iload 15
    //   4011: istore 12
    //   4013: iload 7
    //   4015: istore 16
    //   4017: iload 6
    //   4019: istore 9
    //   4021: iload 5
    //   4023: istore 10
    //   4025: iload 6
    //   4027: istore 8
    //   4029: iload 5
    //   4031: istore 11
    //   4033: aload 24
    //   4035: new 135	java/lang/StringBuilder
    //   4038: dup
    //   4039: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   4042: aload 27
    //   4044: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4047: ldc_w 474
    //   4050: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4053: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4056: invokevirtual 403	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   4059: ifne -3836 -> 223
    //   4062: iload 7
    //   4064: istore 16
    //   4066: iload 6
    //   4068: istore 9
    //   4070: iload 5
    //   4072: istore 10
    //   4074: iload 6
    //   4076: istore 8
    //   4078: iload 5
    //   4080: istore 11
    //   4082: aload 24
    //   4084: new 135	java/lang/StringBuilder
    //   4087: dup
    //   4088: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   4091: aload 27
    //   4093: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4096: ldc_w 474
    //   4099: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4102: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4105: aload 26
    //   4107: iconst_2
    //   4108: aaload
    //   4109: invokevirtual 408	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4112: pop
    //   4113: iload 7
    //   4115: istore 16
    //   4117: iload 6
    //   4119: istore 9
    //   4121: iload 5
    //   4123: istore 10
    //   4125: iload 6
    //   4127: istore 8
    //   4129: iload 5
    //   4131: istore 11
    //   4133: aload 24
    //   4135: new 135	java/lang/StringBuilder
    //   4138: dup
    //   4139: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   4142: aload 27
    //   4144: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4147: ldc_w 405
    //   4150: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4153: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4156: iload 17
    //   4158: invokestatic 303	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   4161: invokevirtual 408	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4164: pop
    //   4165: iload 7
    //   4167: istore 16
    //   4169: iload 6
    //   4171: istore 9
    //   4173: iload 5
    //   4175: istore 10
    //   4177: iload 6
    //   4179: istore 8
    //   4181: iload 5
    //   4183: istore 11
    //   4185: aload 24
    //   4187: new 135	java/lang/StringBuilder
    //   4190: dup
    //   4191: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   4194: aload 27
    //   4196: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4199: ldc_w 507
    //   4202: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4205: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4208: aload 26
    //   4210: iconst_3
    //   4211: aaload
    //   4212: invokestatic 375	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   4215: invokevirtual 379	java/lang/Long:longValue	()J
    //   4218: ldc2_w 380
    //   4221: ldiv
    //   4222: invokestatic 510	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4225: invokevirtual 408	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4228: pop
    //   4229: iload 7
    //   4231: istore 16
    //   4233: iload 6
    //   4235: istore 9
    //   4237: iload 5
    //   4239: istore 10
    //   4241: iload 6
    //   4243: istore 8
    //   4245: iload 5
    //   4247: istore 11
    //   4249: aload 24
    //   4251: new 135	java/lang/StringBuilder
    //   4254: dup
    //   4255: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   4258: aload 27
    //   4260: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4263: ldc_w 512
    //   4266: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4269: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4272: aload 26
    //   4274: iconst_4
    //   4275: aaload
    //   4276: invokestatic 375	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   4279: invokevirtual 379	java/lang/Long:longValue	()J
    //   4282: ldc2_w 380
    //   4285: ldiv
    //   4286: invokestatic 510	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4289: invokevirtual 408	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4292: pop
    //   4293: iload 15
    //   4295: istore 12
    //   4297: goto -4074 -> 223
    //   4300: iload 7
    //   4302: istore 16
    //   4304: iload 6
    //   4306: istore 9
    //   4308: iload 5
    //   4310: istore 10
    //   4312: iload 6
    //   4314: istore 8
    //   4316: iload 5
    //   4318: istore 11
    //   4320: aload 27
    //   4322: ldc_w 514
    //   4325: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4328: ifne +96 -> 4424
    //   4331: iload 7
    //   4333: istore 16
    //   4335: iload 6
    //   4337: istore 9
    //   4339: iload 5
    //   4341: istore 10
    //   4343: iload 6
    //   4345: istore 8
    //   4347: iload 5
    //   4349: istore 11
    //   4351: aload 27
    //   4353: ldc_w 516
    //   4356: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4359: ifne +65 -> 4424
    //   4362: iload 7
    //   4364: istore 16
    //   4366: iload 6
    //   4368: istore 9
    //   4370: iload 5
    //   4372: istore 10
    //   4374: iload 6
    //   4376: istore 8
    //   4378: iload 5
    //   4380: istore 11
    //   4382: aload 27
    //   4384: ldc_w 518
    //   4387: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4390: ifne +34 -> 4424
    //   4393: iload 7
    //   4395: istore 16
    //   4397: iload 6
    //   4399: istore 9
    //   4401: iload 5
    //   4403: istore 10
    //   4405: iload 6
    //   4407: istore 8
    //   4409: iload 5
    //   4411: istore 11
    //   4413: aload 27
    //   4415: ldc_w 520
    //   4418: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4421: ifeq +539 -> 4960
    //   4424: iload 7
    //   4426: istore 16
    //   4428: iload 6
    //   4430: istore 9
    //   4432: iload 5
    //   4434: istore 10
    //   4436: iload 6
    //   4438: istore 8
    //   4440: iload 5
    //   4442: istore 11
    //   4444: new 199	org/json/JSONObject
    //   4447: dup
    //   4448: invokespecial 200	org/json/JSONObject:<init>	()V
    //   4451: astore 27
    //   4453: iload 7
    //   4455: istore 16
    //   4457: iload 6
    //   4459: istore 9
    //   4461: iload 5
    //   4463: istore 10
    //   4465: iload 6
    //   4467: istore 8
    //   4469: iload 5
    //   4471: istore 11
    //   4473: aload 27
    //   4475: ldc_w 393
    //   4478: iload 17
    //   4480: invokevirtual 225	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   4483: pop
    //   4484: iload 7
    //   4486: istore 16
    //   4488: iload 6
    //   4490: istore 9
    //   4492: iload 5
    //   4494: istore 10
    //   4496: iload 6
    //   4498: istore 8
    //   4500: iload 5
    //   4502: istore 11
    //   4504: aload 27
    //   4506: ldc_w 522
    //   4509: aload 26
    //   4511: iconst_2
    //   4512: aaload
    //   4513: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4516: pop
    //   4517: iload 7
    //   4519: istore 16
    //   4521: iload 6
    //   4523: istore 9
    //   4525: iload 5
    //   4527: istore 10
    //   4529: iload 6
    //   4531: istore 8
    //   4533: iload 5
    //   4535: istore 11
    //   4537: aload 27
    //   4539: ldc_w 524
    //   4542: aload 26
    //   4544: iconst_3
    //   4545: aaload
    //   4546: ldc_w 526
    //   4549: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4552: invokevirtual 529	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4555: pop
    //   4556: iload 7
    //   4558: istore 16
    //   4560: iload 6
    //   4562: istore 9
    //   4564: iload 5
    //   4566: istore 10
    //   4568: iload 6
    //   4570: istore 8
    //   4572: iload 5
    //   4574: istore 11
    //   4576: aload 27
    //   4578: ldc_w 531
    //   4581: aload 26
    //   4583: iconst_4
    //   4584: aaload
    //   4585: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4588: pop
    //   4589: iload 7
    //   4591: istore 16
    //   4593: iload 6
    //   4595: istore 9
    //   4597: iload 5
    //   4599: istore 10
    //   4601: iload 6
    //   4603: istore 8
    //   4605: iload 5
    //   4607: istore 11
    //   4609: new 371	org/json/JSONArray
    //   4612: dup
    //   4613: invokespecial 372	org/json/JSONArray:<init>	()V
    //   4616: astore 28
    //   4618: iload 7
    //   4620: istore 16
    //   4622: iload 6
    //   4624: istore 9
    //   4626: iload 5
    //   4628: istore 10
    //   4630: iload 6
    //   4632: istore 8
    //   4634: iload 5
    //   4636: istore 11
    //   4638: aload 27
    //   4640: ldc_w 488
    //   4643: aload 28
    //   4645: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4648: pop
    //   4649: iload 7
    //   4651: istore 16
    //   4653: iload 6
    //   4655: istore 9
    //   4657: iload 5
    //   4659: istore 10
    //   4661: iload 6
    //   4663: istore 8
    //   4665: iload 5
    //   4667: istore 11
    //   4669: aload 26
    //   4671: iconst_5
    //   4672: aaload
    //   4673: ldc 119
    //   4675: invokevirtual 359	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   4678: astore 26
    //   4680: iload 7
    //   4682: istore 16
    //   4684: iload 6
    //   4686: istore 9
    //   4688: iload 5
    //   4690: istore 10
    //   4692: iload 6
    //   4694: istore 8
    //   4696: iload 5
    //   4698: istore 11
    //   4700: aload 26
    //   4702: arraylength
    //   4703: istore 13
    //   4705: iconst_0
    //   4706: istore 12
    //   4708: iload 12
    //   4710: iload 13
    //   4712: if_icmpge +213 -> 4925
    //   4715: iload 7
    //   4717: istore 16
    //   4719: iload 6
    //   4721: istore 9
    //   4723: iload 5
    //   4725: istore 10
    //   4727: iload 6
    //   4729: istore 8
    //   4731: iload 5
    //   4733: istore 11
    //   4735: aload 26
    //   4737: iload 12
    //   4739: aaload
    //   4740: ldc 176
    //   4742: invokevirtual 359	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   4745: astore 29
    //   4747: aload 29
    //   4749: ifnull +1326 -> 6075
    //   4752: iload 7
    //   4754: istore 16
    //   4756: iload 6
    //   4758: istore 9
    //   4760: iload 5
    //   4762: istore 10
    //   4764: iload 6
    //   4766: istore 8
    //   4768: iload 5
    //   4770: istore 11
    //   4772: aload 29
    //   4774: arraylength
    //   4775: iconst_1
    //   4776: if_icmple +1299 -> 6075
    //   4779: iload 7
    //   4781: istore 16
    //   4783: iload 6
    //   4785: istore 9
    //   4787: iload 5
    //   4789: istore 10
    //   4791: iload 6
    //   4793: istore 8
    //   4795: iload 5
    //   4797: istore 11
    //   4799: new 199	org/json/JSONObject
    //   4802: dup
    //   4803: invokespecial 200	org/json/JSONObject:<init>	()V
    //   4806: astore 30
    //   4808: iload 7
    //   4810: istore 16
    //   4812: iload 6
    //   4814: istore 9
    //   4816: iload 5
    //   4818: istore 10
    //   4820: iload 6
    //   4822: istore 8
    //   4824: iload 5
    //   4826: istore 11
    //   4828: aload 30
    //   4830: ldc_w 393
    //   4833: aload 29
    //   4835: iconst_0
    //   4836: aaload
    //   4837: invokestatic 375	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   4840: invokevirtual 379	java/lang/Long:longValue	()J
    //   4843: ldc2_w 380
    //   4846: ldiv
    //   4847: invokevirtual 491	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   4850: pop
    //   4851: iload 7
    //   4853: istore 16
    //   4855: iload 6
    //   4857: istore 9
    //   4859: iload 5
    //   4861: istore 10
    //   4863: iload 6
    //   4865: istore 8
    //   4867: iload 5
    //   4869: istore 11
    //   4871: aload 30
    //   4873: ldc_w 533
    //   4876: aload 29
    //   4878: iconst_1
    //   4879: aaload
    //   4880: invokestatic 375	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   4883: invokevirtual 379	java/lang/Long:longValue	()J
    //   4886: ldc2_w 380
    //   4889: ldiv
    //   4890: invokevirtual 491	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   4893: pop
    //   4894: iload 7
    //   4896: istore 16
    //   4898: iload 6
    //   4900: istore 9
    //   4902: iload 5
    //   4904: istore 10
    //   4906: iload 6
    //   4908: istore 8
    //   4910: iload 5
    //   4912: istore 11
    //   4914: aload 28
    //   4916: aload 30
    //   4918: invokevirtual 398	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   4921: pop
    //   4922: goto +1153 -> 6075
    //   4925: iload 7
    //   4927: istore 16
    //   4929: iload 6
    //   4931: istore 9
    //   4933: iload 5
    //   4935: istore 10
    //   4937: iload 6
    //   4939: istore 8
    //   4941: iload 5
    //   4943: istore 11
    //   4945: aload 19
    //   4947: aload 27
    //   4949: invokevirtual 398	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   4952: pop
    //   4953: iload 15
    //   4955: istore 12
    //   4957: goto -4734 -> 223
    //   4960: iload 7
    //   4962: istore 16
    //   4964: iload 6
    //   4966: istore 9
    //   4968: iload 5
    //   4970: istore 10
    //   4972: iload 6
    //   4974: istore 8
    //   4976: iload 5
    //   4978: istore 11
    //   4980: aload 27
    //   4982: ldc_w 535
    //   4985: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4988: ifne +65 -> 5053
    //   4991: iload 7
    //   4993: istore 16
    //   4995: iload 6
    //   4997: istore 9
    //   4999: iload 5
    //   5001: istore 10
    //   5003: iload 6
    //   5005: istore 8
    //   5007: iload 5
    //   5009: istore 11
    //   5011: aload 27
    //   5013: ldc_w 537
    //   5016: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5019: ifne +34 -> 5053
    //   5022: iload 7
    //   5024: istore 16
    //   5026: iload 6
    //   5028: istore 9
    //   5030: iload 5
    //   5032: istore 10
    //   5034: iload 6
    //   5036: istore 8
    //   5038: iload 5
    //   5040: istore 11
    //   5042: aload 27
    //   5044: ldc_w 539
    //   5047: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5050: ifeq +257 -> 5307
    //   5053: iload 15
    //   5055: istore 12
    //   5057: iload 7
    //   5059: bipush 10
    //   5061: if_icmpgt -4838 -> 223
    //   5064: iload 7
    //   5066: iconst_1
    //   5067: iadd
    //   5068: istore 7
    //   5070: iload 7
    //   5072: istore 16
    //   5074: iload 6
    //   5076: istore 9
    //   5078: iload 5
    //   5080: istore 10
    //   5082: iload 6
    //   5084: istore 8
    //   5086: iload 5
    //   5088: istore 11
    //   5090: new 199	org/json/JSONObject
    //   5093: dup
    //   5094: invokespecial 200	org/json/JSONObject:<init>	()V
    //   5097: astore 27
    //   5099: iload 7
    //   5101: istore 16
    //   5103: iload 6
    //   5105: istore 9
    //   5107: iload 5
    //   5109: istore 10
    //   5111: iload 6
    //   5113: istore 8
    //   5115: iload 5
    //   5117: istore 11
    //   5119: aload 27
    //   5121: ldc_w 522
    //   5124: aload 26
    //   5126: iconst_3
    //   5127: aaload
    //   5128: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   5131: pop
    //   5132: iload 7
    //   5134: istore 16
    //   5136: iload 6
    //   5138: istore 9
    //   5140: iload 5
    //   5142: istore 10
    //   5144: iload 6
    //   5146: istore 8
    //   5148: iload 5
    //   5150: istore 11
    //   5152: aload 27
    //   5154: ldc_w 531
    //   5157: aload 26
    //   5159: iconst_2
    //   5160: aaload
    //   5161: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   5164: pop
    //   5165: iload 7
    //   5167: istore 16
    //   5169: iload 6
    //   5171: istore 9
    //   5173: iload 5
    //   5175: istore 10
    //   5177: iload 6
    //   5179: istore 8
    //   5181: iload 5
    //   5183: istore 11
    //   5185: aload 27
    //   5187: ldc_w 541
    //   5190: aload 26
    //   5192: iconst_4
    //   5193: aaload
    //   5194: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   5197: pop
    //   5198: iload 7
    //   5200: istore 16
    //   5202: iload 6
    //   5204: istore 9
    //   5206: iload 5
    //   5208: istore 10
    //   5210: iload 6
    //   5212: istore 8
    //   5214: iload 5
    //   5216: istore 11
    //   5218: aload 27
    //   5220: ldc_w 393
    //   5223: iload 17
    //   5225: invokevirtual 225	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   5228: pop
    //   5229: iload 7
    //   5231: istore 16
    //   5233: iload 6
    //   5235: istore 9
    //   5237: iload 5
    //   5239: istore 10
    //   5241: iload 6
    //   5243: istore 8
    //   5245: iload 5
    //   5247: istore 11
    //   5249: aload 27
    //   5251: ldc_w 533
    //   5254: aload 26
    //   5256: iconst_5
    //   5257: aaload
    //   5258: invokestatic 375	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   5261: invokevirtual 379	java/lang/Long:longValue	()J
    //   5264: ldc2_w 380
    //   5267: ldiv
    //   5268: invokevirtual 491	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   5271: pop
    //   5272: iload 7
    //   5274: istore 16
    //   5276: iload 6
    //   5278: istore 9
    //   5280: iload 5
    //   5282: istore 10
    //   5284: iload 6
    //   5286: istore 8
    //   5288: iload 5
    //   5290: istore 11
    //   5292: aload 19
    //   5294: aload 27
    //   5296: invokevirtual 398	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   5299: pop
    //   5300: iload 15
    //   5302: istore 12
    //   5304: goto -5081 -> 223
    //   5307: iload 7
    //   5309: istore 16
    //   5311: iload 6
    //   5313: istore 9
    //   5315: iload 5
    //   5317: istore 10
    //   5319: iload 6
    //   5321: istore 8
    //   5323: iload 5
    //   5325: istore 11
    //   5327: aload 27
    //   5329: ldc_w 543
    //   5332: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5335: ifne +162 -> 5497
    //   5338: iload 7
    //   5340: istore 16
    //   5342: iload 6
    //   5344: istore 9
    //   5346: iload 5
    //   5348: istore 10
    //   5350: iload 6
    //   5352: istore 8
    //   5354: iload 5
    //   5356: istore 11
    //   5358: aload 27
    //   5360: ldc_w 545
    //   5363: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5366: ifne +131 -> 5497
    //   5369: iload 7
    //   5371: istore 16
    //   5373: iload 6
    //   5375: istore 9
    //   5377: iload 5
    //   5379: istore 10
    //   5381: iload 6
    //   5383: istore 8
    //   5385: iload 5
    //   5387: istore 11
    //   5389: aload 27
    //   5391: ldc_w 547
    //   5394: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5397: ifne +100 -> 5497
    //   5400: iload 7
    //   5402: istore 16
    //   5404: iload 6
    //   5406: istore 9
    //   5408: iload 5
    //   5410: istore 10
    //   5412: iload 6
    //   5414: istore 8
    //   5416: iload 5
    //   5418: istore 11
    //   5420: aload 27
    //   5422: ldc_w 549
    //   5425: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5428: ifne +69 -> 5497
    //   5431: iload 7
    //   5433: istore 16
    //   5435: iload 6
    //   5437: istore 9
    //   5439: iload 5
    //   5441: istore 10
    //   5443: iload 6
    //   5445: istore 8
    //   5447: iload 5
    //   5449: istore 11
    //   5451: aload 27
    //   5453: ldc_w 551
    //   5456: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5459: ifne +38 -> 5497
    //   5462: iload 15
    //   5464: istore 12
    //   5466: iload 7
    //   5468: istore 16
    //   5470: iload 6
    //   5472: istore 9
    //   5474: iload 5
    //   5476: istore 10
    //   5478: iload 6
    //   5480: istore 8
    //   5482: iload 5
    //   5484: istore 11
    //   5486: aload 27
    //   5488: ldc_w 553
    //   5491: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5494: ifeq -5271 -> 223
    //   5497: iload 7
    //   5499: istore 16
    //   5501: iload 6
    //   5503: istore 9
    //   5505: iload 5
    //   5507: istore 10
    //   5509: iload 6
    //   5511: istore 8
    //   5513: iload 5
    //   5515: istore 11
    //   5517: new 199	org/json/JSONObject
    //   5520: dup
    //   5521: invokespecial 200	org/json/JSONObject:<init>	()V
    //   5524: astore 27
    //   5526: iload 7
    //   5528: istore 16
    //   5530: iload 6
    //   5532: istore 9
    //   5534: iload 5
    //   5536: istore 10
    //   5538: iload 6
    //   5540: istore 8
    //   5542: iload 5
    //   5544: istore 11
    //   5546: aload 27
    //   5548: ldc_w 522
    //   5551: aload 26
    //   5553: iconst_2
    //   5554: aaload
    //   5555: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   5558: pop
    //   5559: iload 7
    //   5561: istore 16
    //   5563: iload 6
    //   5565: istore 9
    //   5567: iload 5
    //   5569: istore 10
    //   5571: iload 6
    //   5573: istore 8
    //   5575: iload 5
    //   5577: istore 11
    //   5579: new 371	org/json/JSONArray
    //   5582: dup
    //   5583: invokespecial 372	org/json/JSONArray:<init>	()V
    //   5586: astore 28
    //   5588: iload 7
    //   5590: istore 16
    //   5592: iload 6
    //   5594: istore 9
    //   5596: iload 5
    //   5598: istore 10
    //   5600: iload 6
    //   5602: istore 8
    //   5604: iload 5
    //   5606: istore 11
    //   5608: aload 27
    //   5610: ldc_w 555
    //   5613: aload 28
    //   5615: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   5618: pop
    //   5619: iload 7
    //   5621: istore 16
    //   5623: iload 6
    //   5625: istore 9
    //   5627: iload 5
    //   5629: istore 10
    //   5631: iload 6
    //   5633: istore 8
    //   5635: iload 5
    //   5637: istore 11
    //   5639: aload 26
    //   5641: iconst_3
    //   5642: aaload
    //   5643: ldc 119
    //   5645: invokevirtual 359	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   5648: astore 26
    //   5650: iload 7
    //   5652: istore 16
    //   5654: iload 6
    //   5656: istore 9
    //   5658: iload 5
    //   5660: istore 10
    //   5662: iload 6
    //   5664: istore 8
    //   5666: iload 5
    //   5668: istore 11
    //   5670: aload 26
    //   5672: arraylength
    //   5673: istore 13
    //   5675: iconst_0
    //   5676: istore 12
    //   5678: iload 12
    //   5680: iload 13
    //   5682: if_icmpge +53 -> 5735
    //   5685: iload 7
    //   5687: istore 16
    //   5689: iload 6
    //   5691: istore 9
    //   5693: iload 5
    //   5695: istore 10
    //   5697: iload 6
    //   5699: istore 8
    //   5701: iload 5
    //   5703: istore 11
    //   5705: aload 28
    //   5707: aload 26
    //   5709: iload 12
    //   5711: aaload
    //   5712: invokestatic 375	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   5715: invokevirtual 379	java/lang/Long:longValue	()J
    //   5718: ldc2_w 380
    //   5721: ldiv
    //   5722: invokevirtual 558	org/json/JSONArray:put	(J)Lorg/json/JSONArray;
    //   5725: pop
    //   5726: iload 12
    //   5728: iconst_1
    //   5729: iadd
    //   5730: istore 12
    //   5732: goto -54 -> 5678
    //   5735: iload 7
    //   5737: istore 16
    //   5739: iload 6
    //   5741: istore 9
    //   5743: iload 5
    //   5745: istore 10
    //   5747: iload 6
    //   5749: istore 8
    //   5751: iload 5
    //   5753: istore 11
    //   5755: aload 19
    //   5757: aload 27
    //   5759: invokevirtual 398	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   5762: pop
    //   5763: iload 15
    //   5765: istore 12
    //   5767: goto -5544 -> 223
    //   5770: astore 19
    //   5772: iload 10
    //   5774: istore 8
    //   5776: iload 5
    //   5778: istore 9
    //   5780: iload 6
    //   5782: istore 5
    //   5784: iload 9
    //   5786: istore 6
    //   5788: goto -5462 -> 326
    //   5791: astore 19
    //   5793: iload 5
    //   5795: istore 9
    //   5797: iload 6
    //   5799: istore 5
    //   5801: iload 9
    //   5803: istore 6
    //   5805: goto -5479 -> 326
    //   5808: iload 6
    //   5810: istore 9
    //   5812: iload 5
    //   5814: istore 6
    //   5816: iload 9
    //   5818: istore 5
    //   5820: iload 7
    //   5822: istore 10
    //   5824: iload 8
    //   5826: istore 7
    //   5828: goto -5680 -> 148
    //   5831: astore 20
    //   5833: ldc 190
    //   5835: iconst_1
    //   5836: new 135	java/lang/StringBuilder
    //   5839: dup
    //   5840: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   5843: ldc_w 560
    //   5846: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5849: lconst_0
    //   5850: invokevirtual 563	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5853: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5856: invokestatic 418	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5859: lconst_0
    //   5860: lstore_1
    //   5861: goto -5372 -> 489
    //   5864: astore 19
    //   5866: invokestatic 421	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5869: ifeq -5349 -> 520
    //   5872: ldc 190
    //   5874: iconst_2
    //   5875: ldc 132
    //   5877: aload 19
    //   5879: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   5882: goto -5362 -> 520
    //   5885: astore 19
    //   5887: goto -5595 -> 292
    //   5890: astore 20
    //   5892: goto -4330 -> 1562
    //   5895: astore 21
    //   5897: goto -3562 -> 2335
    //   5900: astore 20
    //   5902: goto -3549 -> 2353
    //   5905: astore 19
    //   5907: iload 6
    //   5909: istore 7
    //   5911: iload 5
    //   5913: istore 8
    //   5915: goto -3545 -> 2370
    //   5918: astore 19
    //   5920: aconst_null
    //   5921: astore 21
    //   5923: aconst_null
    //   5924: astore 20
    //   5926: goto -3609 -> 2317
    //   5929: astore 19
    //   5931: aconst_null
    //   5932: astore 20
    //   5934: goto -3617 -> 2317
    //   5937: astore 23
    //   5939: aload 19
    //   5941: astore 21
    //   5943: aload 20
    //   5945: astore 22
    //   5947: aload 23
    //   5949: astore 19
    //   5951: aload 21
    //   5953: astore 20
    //   5955: aload 22
    //   5957: astore 21
    //   5959: goto -3642 -> 2317
    //   5962: astore 21
    //   5964: aconst_null
    //   5965: astore 19
    //   5967: aconst_null
    //   5968: astore 20
    //   5970: iload 7
    //   5972: istore 8
    //   5974: iload 10
    //   5976: istore 7
    //   5978: goto -4442 -> 1536
    //   5981: astore 22
    //   5983: iload 7
    //   5985: istore 8
    //   5987: aconst_null
    //   5988: astore 19
    //   5990: iload 10
    //   5992: istore 7
    //   5994: aload 21
    //   5996: astore 20
    //   5998: aload 22
    //   6000: astore 21
    //   6002: goto -4466 -> 1536
    //   6005: lconst_0
    //   6006: lstore_1
    //   6007: goto -5518 -> 489
    //   6010: iload 5
    //   6012: istore 9
    //   6014: iload 6
    //   6016: istore 5
    //   6018: iload 9
    //   6020: istore 6
    //   6022: goto -5696 -> 326
    //   6025: iload 10
    //   6027: istore 8
    //   6029: iload 5
    //   6031: istore 9
    //   6033: iload 6
    //   6035: istore 5
    //   6037: iload 9
    //   6039: istore 6
    //   6041: goto -5715 -> 326
    //   6044: iload 12
    //   6046: istore 10
    //   6048: goto -5774 -> 274
    //   6051: iload 5
    //   6053: istore 7
    //   6055: iload 6
    //   6057: istore 5
    //   6059: iload 7
    //   6061: istore 6
    //   6063: goto -5725 -> 338
    //   6066: iload 12
    //   6068: iconst_1
    //   6069: iadd
    //   6070: istore 12
    //   6072: goto -2670 -> 3402
    //   6075: iload 12
    //   6077: iconst_1
    //   6078: iadd
    //   6079: istore 12
    //   6081: goto -1373 -> 4708
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6084	0	this	BatteryStatsImpl
    //   0	6084	1	paramLong1	long
    //   0	6084	3	paramLong2	long
    //   37	6021	5	i	int
    //   43	6019	6	j	int
    //   126	5934	7	k	int
    //   62	5966	8	m	int
    //   58	5980	9	n	int
    //   129	5918	10	i1	int
    //   34	5720	11	i2	int
    //   40	6040	12	i3	int
    //   233	5450	13	i4	int
    //   237	1453	14	i5	int
    //   263	5501	15	i6	int
    //   592	5146	16	i7	int
    //   229	4995	17	i8	int
    //   225	1284	18	i9	int
    //   8	1099	19	localObject1	Object
    //   1434	1	19	localException1	Exception
    //   1518	97	19	localObject2	Object
    //   1671	313	19	localException2	Exception
    //   2307	55	19	localObject3	Object
    //   2364	3392	19	localThrowable1	Throwable
    //   5770	1	19	localException3	Exception
    //   5791	1	19	localException4	Exception
    //   5864	14	19	localException5	Exception
    //   5885	1	19	localException6	Exception
    //   5905	1	19	localThrowable2	Throwable
    //   5918	1	19	localObject4	Object
    //   5929	11	19	localObject5	Object
    //   5949	40	19	localObject6	Object
    //   213	2136	20	localObject7	Object
    //   5831	1	20	localException7	Exception
    //   5890	1	20	localException8	Exception
    //   5900	1	20	localException9	Exception
    //   5924	73	20	localObject8	Object
    //   195	2136	21	localObject9	Object
    //   5895	1	21	localException10	Exception
    //   5921	37	21	localObject10	Object
    //   5962	33	21	localException11	Exception
    //   6000	1	21	localObject11	Object
    //   252	1225	22	str	String
    //   1506	27	22	localException12	Exception
    //   5945	11	22	localObject12	Object
    //   5981	18	22	localException13	Exception
    //   146	29	23	localIterator	Iterator
    //   5937	11	23	localObject13	Object
    //   54	4196	24	localHashMap	java.util.HashMap
    //   31	1577	25	localJSONObject1	JSONObject
    //   582	5126	26	arrayOfString	String[]
    //   588	5170	27	localObject14	Object
    //   928	4778	28	localObject15	Object
    //   3184	1693	29	localObject16	Object
    //   3500	1417	30	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   610	621	1434	java/lang/Exception
    //   651	662	1434	java/lang/Exception
    //   692	702	1434	java/lang/Exception
    //   722	731	1434	java/lang/Exception
    //   751	761	1434	java/lang/Exception
    //   781	798	1434	java/lang/Exception
    //   818	829	1434	java/lang/Exception
    //   849	860	1434	java/lang/Exception
    //   880	891	1434	java/lang/Exception
    //   921	930	1434	java/lang/Exception
    //   950	963	1434	java/lang/Exception
    //   983	995	1434	java/lang/Exception
    //   1015	1026	1434	java/lang/Exception
    //   1046	1053	1434	java/lang/Exception
    //   1073	1086	1434	java/lang/Exception
    //   1106	1114	1434	java/lang/Exception
    //   1146	1175	1434	java/lang/Exception
    //   1195	1227	1434	java/lang/Exception
    //   1247	1278	1434	java/lang/Exception
    //   1298	1329	1434	java/lang/Exception
    //   1387	1419	1434	java/lang/Exception
    //   1607	1616	1434	java/lang/Exception
    //   1647	1658	1434	java/lang/Exception
    //   1693	1703	1434	java/lang/Exception
    //   1729	1740	1434	java/lang/Exception
    //   1760	1771	1434	java/lang/Exception
    //   1791	1800	1434	java/lang/Exception
    //   1820	1831	1434	java/lang/Exception
    //   1851	1864	1434	java/lang/Exception
    //   1884	1897	1434	java/lang/Exception
    //   1917	1930	1434	java/lang/Exception
    //   1950	1963	1434	java/lang/Exception
    //   1983	1991	1434	java/lang/Exception
    //   2015	2044	1434	java/lang/Exception
    //   2064	2096	1434	java/lang/Exception
    //   2116	2147	1434	java/lang/Exception
    //   2167	2198	1434	java/lang/Exception
    //   2218	2249	1434	java/lang/Exception
    //   2269	2300	1434	java/lang/Exception
    //   2425	2436	1434	java/lang/Exception
    //   2456	2467	1434	java/lang/Exception
    //   2487	2498	1434	java/lang/Exception
    //   2518	2529	1434	java/lang/Exception
    //   2549	2560	1434	java/lang/Exception
    //   2580	2591	1434	java/lang/Exception
    //   2611	2622	1434	java/lang/Exception
    //   2642	2653	1434	java/lang/Exception
    //   2673	2684	1434	java/lang/Exception
    //   2704	2715	1434	java/lang/Exception
    //   2735	2744	1434	java/lang/Exception
    //   2764	2775	1434	java/lang/Exception
    //   2795	2808	1434	java/lang/Exception
    //   2828	2836	1434	java/lang/Exception
    //   2860	2889	1434	java/lang/Exception
    //   2909	2940	1434	java/lang/Exception
    //   2960	2992	1434	java/lang/Exception
    //   3019	3030	1434	java/lang/Exception
    //   3050	3061	1434	java/lang/Exception
    //   3081	3092	1434	java/lang/Exception
    //   3112	3123	1434	java/lang/Exception
    //   3143	3152	1434	java/lang/Exception
    //   3172	3186	1434	java/lang/Exception
    //   3206	3217	1434	java/lang/Exception
    //   3237	3248	1434	java/lang/Exception
    //   3268	3279	1434	java/lang/Exception
    //   3299	3308	1434	java/lang/Exception
    //   3328	3339	1434	java/lang/Exception
    //   3359	3374	1434	java/lang/Exception
    //   3394	3399	1434	java/lang/Exception
    //   3429	3441	1434	java/lang/Exception
    //   3466	3473	1434	java/lang/Exception
    //   3493	3502	1434	java/lang/Exception
    //   3522	3545	1434	java/lang/Exception
    //   3565	3578	1434	java/lang/Exception
    //   3598	3606	1434	java/lang/Exception
    //   3629	3640	1434	java/lang/Exception
    //   3663	3671	1434	java/lang/Exception
    //   3698	3709	1434	java/lang/Exception
    //   3729	3740	1434	java/lang/Exception
    //   3760	3771	1434	java/lang/Exception
    //   3791	3802	1434	java/lang/Exception
    //   3822	3831	1434	java/lang/Exception
    //   3851	3864	1434	java/lang/Exception
    //   3884	3895	1434	java/lang/Exception
    //   3915	3938	1434	java/lang/Exception
    //   3958	3981	1434	java/lang/Exception
    //   4001	4009	1434	java/lang/Exception
    //   4033	4062	1434	java/lang/Exception
    //   4082	4113	1434	java/lang/Exception
    //   4133	4165	1434	java/lang/Exception
    //   4185	4229	1434	java/lang/Exception
    //   4249	4293	1434	java/lang/Exception
    //   4320	4331	1434	java/lang/Exception
    //   4351	4362	1434	java/lang/Exception
    //   4382	4393	1434	java/lang/Exception
    //   4413	4424	1434	java/lang/Exception
    //   4444	4453	1434	java/lang/Exception
    //   4473	4484	1434	java/lang/Exception
    //   4504	4517	1434	java/lang/Exception
    //   4537	4556	1434	java/lang/Exception
    //   4576	4589	1434	java/lang/Exception
    //   4609	4618	1434	java/lang/Exception
    //   4638	4649	1434	java/lang/Exception
    //   4669	4680	1434	java/lang/Exception
    //   4700	4705	1434	java/lang/Exception
    //   4735	4747	1434	java/lang/Exception
    //   4772	4779	1434	java/lang/Exception
    //   4799	4808	1434	java/lang/Exception
    //   4828	4851	1434	java/lang/Exception
    //   4871	4894	1434	java/lang/Exception
    //   4914	4922	1434	java/lang/Exception
    //   4945	4953	1434	java/lang/Exception
    //   4980	4991	1434	java/lang/Exception
    //   5011	5022	1434	java/lang/Exception
    //   5042	5053	1434	java/lang/Exception
    //   5090	5099	1434	java/lang/Exception
    //   5119	5132	1434	java/lang/Exception
    //   5152	5165	1434	java/lang/Exception
    //   5185	5198	1434	java/lang/Exception
    //   5218	5229	1434	java/lang/Exception
    //   5249	5272	1434	java/lang/Exception
    //   5292	5300	1434	java/lang/Exception
    //   5327	5338	1434	java/lang/Exception
    //   5358	5369	1434	java/lang/Exception
    //   5389	5400	1434	java/lang/Exception
    //   5420	5431	1434	java/lang/Exception
    //   5451	5462	1434	java/lang/Exception
    //   5486	5497	1434	java/lang/Exception
    //   5517	5526	1434	java/lang/Exception
    //   5546	5559	1434	java/lang/Exception
    //   5579	5588	1434	java/lang/Exception
    //   5608	5619	1434	java/lang/Exception
    //   5639	5650	1434	java/lang/Exception
    //   5670	5675	1434	java/lang/Exception
    //   5705	5726	1434	java/lang/Exception
    //   5755	5763	1434	java/lang/Exception
    //   247	254	1506	java/lang/Exception
    //   574	584	1506	java/lang/Exception
    //   1460	1487	1506	java/lang/Exception
    //   1337	1363	1671	java/lang/Exception
    //   247	254	2307	finally
    //   574	584	2307	finally
    //   610	621	2307	finally
    //   651	662	2307	finally
    //   692	702	2307	finally
    //   722	731	2307	finally
    //   751	761	2307	finally
    //   781	798	2307	finally
    //   818	829	2307	finally
    //   849	860	2307	finally
    //   880	891	2307	finally
    //   921	930	2307	finally
    //   950	963	2307	finally
    //   983	995	2307	finally
    //   1015	1026	2307	finally
    //   1046	1053	2307	finally
    //   1073	1086	2307	finally
    //   1106	1114	2307	finally
    //   1146	1175	2307	finally
    //   1195	1227	2307	finally
    //   1247	1278	2307	finally
    //   1298	1329	2307	finally
    //   1337	1363	2307	finally
    //   1387	1419	2307	finally
    //   1460	1487	2307	finally
    //   1607	1616	2307	finally
    //   1647	1658	2307	finally
    //   1693	1703	2307	finally
    //   1729	1740	2307	finally
    //   1760	1771	2307	finally
    //   1791	1800	2307	finally
    //   1820	1831	2307	finally
    //   1851	1864	2307	finally
    //   1884	1897	2307	finally
    //   1917	1930	2307	finally
    //   1950	1963	2307	finally
    //   1983	1991	2307	finally
    //   2015	2044	2307	finally
    //   2064	2096	2307	finally
    //   2116	2147	2307	finally
    //   2167	2198	2307	finally
    //   2218	2249	2307	finally
    //   2269	2300	2307	finally
    //   2425	2436	2307	finally
    //   2456	2467	2307	finally
    //   2487	2498	2307	finally
    //   2518	2529	2307	finally
    //   2549	2560	2307	finally
    //   2580	2591	2307	finally
    //   2611	2622	2307	finally
    //   2642	2653	2307	finally
    //   2673	2684	2307	finally
    //   2704	2715	2307	finally
    //   2735	2744	2307	finally
    //   2764	2775	2307	finally
    //   2795	2808	2307	finally
    //   2828	2836	2307	finally
    //   2860	2889	2307	finally
    //   2909	2940	2307	finally
    //   2960	2992	2307	finally
    //   3019	3030	2307	finally
    //   3050	3061	2307	finally
    //   3081	3092	2307	finally
    //   3112	3123	2307	finally
    //   3143	3152	2307	finally
    //   3172	3186	2307	finally
    //   3206	3217	2307	finally
    //   3237	3248	2307	finally
    //   3268	3279	2307	finally
    //   3299	3308	2307	finally
    //   3328	3339	2307	finally
    //   3359	3374	2307	finally
    //   3394	3399	2307	finally
    //   3429	3441	2307	finally
    //   3466	3473	2307	finally
    //   3493	3502	2307	finally
    //   3522	3545	2307	finally
    //   3565	3578	2307	finally
    //   3598	3606	2307	finally
    //   3629	3640	2307	finally
    //   3663	3671	2307	finally
    //   3698	3709	2307	finally
    //   3729	3740	2307	finally
    //   3760	3771	2307	finally
    //   3791	3802	2307	finally
    //   3822	3831	2307	finally
    //   3851	3864	2307	finally
    //   3884	3895	2307	finally
    //   3915	3938	2307	finally
    //   3958	3981	2307	finally
    //   4001	4009	2307	finally
    //   4033	4062	2307	finally
    //   4082	4113	2307	finally
    //   4133	4165	2307	finally
    //   4185	4229	2307	finally
    //   4249	4293	2307	finally
    //   4320	4331	2307	finally
    //   4351	4362	2307	finally
    //   4382	4393	2307	finally
    //   4413	4424	2307	finally
    //   4444	4453	2307	finally
    //   4473	4484	2307	finally
    //   4504	4517	2307	finally
    //   4537	4556	2307	finally
    //   4576	4589	2307	finally
    //   4609	4618	2307	finally
    //   4638	4649	2307	finally
    //   4669	4680	2307	finally
    //   4700	4705	2307	finally
    //   4735	4747	2307	finally
    //   4772	4779	2307	finally
    //   4799	4808	2307	finally
    //   4828	4851	2307	finally
    //   4871	4894	2307	finally
    //   4914	4922	2307	finally
    //   4945	4953	2307	finally
    //   4980	4991	2307	finally
    //   5011	5022	2307	finally
    //   5042	5053	2307	finally
    //   5090	5099	2307	finally
    //   5119	5132	2307	finally
    //   5152	5165	2307	finally
    //   5185	5198	2307	finally
    //   5218	5229	2307	finally
    //   5249	5272	2307	finally
    //   5292	5300	2307	finally
    //   5327	5338	2307	finally
    //   5358	5369	2307	finally
    //   5389	5400	2307	finally
    //   5420	5431	2307	finally
    //   5451	5462	2307	finally
    //   5486	5497	2307	finally
    //   5517	5526	2307	finally
    //   5546	5559	2307	finally
    //   5579	5588	2307	finally
    //   5608	5619	2307	finally
    //   5639	5650	2307	finally
    //   5670	5675	2307	finally
    //   5705	5726	2307	finally
    //   5755	5763	2307	finally
    //   64	75	2364	java/lang/Throwable
    //   83	94	2364	java/lang/Throwable
    //   102	123	2364	java/lang/Throwable
    //   139	148	2364	java/lang/Throwable
    //   156	166	2364	java/lang/Throwable
    //   174	186	2364	java/lang/Throwable
    //   287	292	2364	java/lang/Throwable
    //   305	310	2364	java/lang/Throwable
    //   2330	2335	2364	java/lang/Throwable
    //   2348	2353	2364	java/lang/Throwable
    //   2361	2364	2364	java/lang/Throwable
    //   305	310	5770	java/lang/Exception
    //   1567	1572	5791	java/lang/Exception
    //   463	475	5831	java/lang/Exception
    //   480	489	5831	java/lang/Exception
    //   386	463	5864	java/lang/Exception
    //   489	520	5864	java/lang/Exception
    //   5833	5859	5864	java/lang/Exception
    //   287	292	5885	java/lang/Exception
    //   1557	1562	5890	java/lang/Exception
    //   2330	2335	5895	java/lang/Exception
    //   2348	2353	5900	java/lang/Exception
    //   1557	1562	5905	java/lang/Throwable
    //   1567	1572	5905	java/lang/Throwable
    //   186	197	5918	finally
    //   197	215	5929	finally
    //   1536	1552	5937	finally
    //   186	197	5962	java/lang/Exception
    //   197	215	5981	java/lang/Exception
  }
  
  private void a(String paramString)
  {
    a(paramString, false);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if ((QLog.isColorLevel()) || (paramBoolean)) {
      QLog.d("BatteryStats", 2, paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl$IBatteryStatsCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl$IBatteryStatsCallback.a(paramString);
    }
  }
  
  private void a(String... paramVarArgs)
  {
    if ((this.jdField_a_of_type_Int == 1) && (b())) {
      BatteryLog.a(new Object[] { Long.valueOf(System.currentTimeMillis()), paramVarArgs });
    }
  }
  
  private static boolean a(String paramString)
  {
    String[] arrayOfString = jdField_b_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.startsWith(arrayOfString[i])) {
        return false;
      }
      i += 1;
    }
    arrayOfString = jdField_c_of_type_ArrayOfJavaLangString;
    j = arrayOfString.length;
    i = 0;
    for (;;)
    {
      if (i >= j) {
        break label64;
      }
      if (paramString.contains(arrayOfString[i])) {
        break;
      }
      i += 1;
    }
    label64:
    return true;
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onException: ").append(paramInt1).append(", ").append(paramInt2).append(", ").append(paramInt3).append(",").append(paramString1).append(", ").append(paramString2);
      a(localStringBuilder.toString());
    }
    if ((paramInt1 != 2) && (paramInt1 != 3)) {}
    while (paramInt3 == 1) {
      return;
    }
  }
  
  private void b(String... paramVarArgs)
  {
    if (b()) {
      a(BaseApplicationImpl.sProcessId, paramVarArgs);
    }
    while (c()) {
      return;
    }
    BatteryIPCModule.a().a(paramVarArgs);
  }
  
  private static final boolean b()
  {
    return BaseApplicationImpl.sProcessId == 1;
  }
  
  private static final boolean c()
  {
    return BaseApplicationImpl.sProcessId == 4;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (b())
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      localObject = a().split("\\|");
      if ((localObject.length < 11) || (TextUtils.isEmpty(localObject[10]))) {
        break label64;
      }
    }
    label64:
    for (Object localObject = localObject[10];; localObject = "0.1;0.0002;10;5;10;5;2;0;500;1")
    {
      BackgroundCpuMonitor.a().a((String)localObject);
      return;
      BatteryIPCModule.a().a();
      break;
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2) {}
  
  void a(int paramInt, String... paramVarArgs)
  {
    if (this.jdField_a_of_type_Int != 1) {
      return;
    }
    long l = (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L;
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().waitAppRuntime(null);
    if (localObject != null) {}
    for (localObject = ((QQAppInterface)localObject).getAccount();; localObject = null)
    {
      BatteryLog.b(new Object[] { localObject, Integer.valueOf(paramInt), Long.valueOf(l), paramVarArgs });
      return;
    }
  }
  
  void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Int != 1) {}
    for (;;)
    {
      return;
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((ahsm)localIterator.next()).a(paramBundle);
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception paramBundle) {}
    }
    QLog.d("BatteryStats", 2, "", paramBundle);
  }
  
  public void a(String paramString, Object[] paramArrayOfObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl$GPS != null) {
      this.jdField_a_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl$GPS.a(paramString, paramArrayOfObject);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void c()
  {
    if (this.d) {}
    do
    {
      return;
      this.d = true;
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localObject != null)
      {
        localObject = (PreDownloadScheduler)((QQAppInterface)localObject).getManager(232);
        if (localObject != null) {
          ((PreDownloadScheduler)localObject).c();
        }
      }
      BackgroundCpuMonitor.a().a();
      if (a() == 1)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ahsm)((Iterator)localObject).next()).b();
        }
        if (!this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 300000L);
        }
      }
    } while (this.e);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 200L);
  }
  
  public void d()
  {
    this.d = false;
    BackgroundCpuMonitor.a().b();
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      localObject = (PreDownloadScheduler)((QQAppInterface)localObject).getManager(232);
      if (localObject != null) {
        ((PreDownloadScheduler)localObject).b();
      }
    }
    if (a() == 1)
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ahsm)((Iterator)localObject).next()).c();
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1;
    if (paramMessage.what == 0) {
      if (this.jdField_a_of_type_Int == -1)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        paramMessage = a();
        QLog.d("BatteryStats", 1, "config: " + paramMessage + ", " + true + ", " + false);
        if (TextUtils.isEmpty(paramMessage)) {
          return true;
        }
        localObject1 = null;
        for (;;)
        {
          try
          {
            paramMessage = paramMessage.split("\\|");
          }
          catch (Exception paramMessage)
          {
            SharedPreferences localSharedPreferences;
            String str2;
            String str1;
            float f;
            Object localObject4;
            int j;
            int i;
            Object localObject2 = null;
            paramMessage = null;
            break label1565;
            Object localObject3;
            long l1 = 0L;
            continue;
          }
          try
          {
            if (b()) {
              localObject1 = paramMessage[0].split(";");
            }
          }
          catch (Exception localException1)
          {
            localObject3 = null;
          }
          try
          {
            localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
            l1 = localSharedPreferences.getLong("last_rand_timestamp", 0L);
            str2 = localSharedPreferences.getString("rand_factor", "");
            bool1 = localSharedPreferences.getBoolean("rand_result", false);
            str1 = localObject1[1];
          }
          catch (Exception localException3)
          {
            bool1 = false;
            continue;
          }
          try
          {
            f = Float.valueOf(str1).floatValue();
            localObject4 = String.valueOf(f * 300.0F);
          }
          catch (Exception localException5)
          {
            try
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              i = Integer.valueOf(localObject1[4]).intValue();
              QLog.d("BatteryStats", 1, "clrRatio = " + i);
              if ((Math.abs(System.currentTimeMillis() - l1) <= 86400000L) && (str2.equals(localObject4))) {
                continue;
              }
              QLog.d("BatteryStats", 2, "new random." + str2 + ", " + (String)localObject4);
              if (Math.random() >= i * Float.valueOf((String)localObject4).floatValue()) {
                continue;
              }
              bool1 = true;
              localSharedPreferences.edit().putLong("last_rand_timestamp", System.currentTimeMillis()).putString("rand_factor", (String)localObject4).putBoolean("rand_result", bool1).commit();
              bool2 = new File(Environment.getExternalStorageDirectory().getPath() + "/tencent/AutoTestFlag_01").exists();
              if (!bool2) {
                continue;
              }
              bool1 = false;
              if (!bool1) {
                continue;
              }
              this.jdField_a_of_type_JavaUtilList = new ArrayList(10);
              this.jdField_a_of_type_JavaUtilList.add(new ahso(this, paramMessage[1]));
              this.jdField_a_of_type_JavaUtilList.add(new ahsq(this, paramMessage[3]));
              this.jdField_a_of_type_JavaUtilList.add(new ahsn(this, paramMessage[4]));
              this.jdField_a_of_type_JavaUtilList.add(new ahss(this, paramMessage[5]));
              this.jdField_a_of_type_JavaUtilList.add(new ahsv(this, paramMessage[6]));
              this.jdField_a_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl$GPS = new BatteryStatsImpl.GPS(this, paramMessage[7]);
              this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl$GPS);
              if (!b()) {
                continue;
              }
              this.jdField_a_of_type_JavaUtilList.add(new ahsr(this, paramMessage[2]));
              BatteryLog.a(BaseApplicationImpl.sApplication.getProcessName(), this.jdField_a_of_type_Long);
              paramMessage = this.jdField_a_of_type_JavaUtilList.iterator();
              if (!paramMessage.hasNext()) {
                continue;
              }
              localObject4 = (ahsm)paramMessage.next();
              ((ahsm)localObject4).a();
              if (!this.jdField_c_of_type_Boolean) {
                continue;
              }
              ((ahsm)localObject4).d();
              continue;
              localException5 = localException5;
              localObject4 = str1;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("BatteryStats", 2, "", localException5);
              localObject4 = str1;
            }
            catch (Exception localException4)
            {
              i = j;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("BatteryStats", 2, "", localException4);
              i = j;
              continue;
              bool1 = false;
              continue;
            }
          }
        }
        j = 1;
        i = j;
        for (;;)
        {
          boolean bool2;
          bool1 = true;
        }
        QLog.d("BatteryStats", 2, "start monitor");
        this.jdField_a_of_type_Int = 1;
        if (b())
        {
          l1 = Long.parseLong(localObject1[3]);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, (l1 + 60L) * 1000L);
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 1800000L);
      }
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Int = 0;
      continue;
      if (paramMessage.what == 1)
      {
        this.jdField_c_of_type_Boolean = true;
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          paramMessage = this.jdField_a_of_type_JavaUtilList.iterator();
          while (paramMessage.hasNext()) {
            ((ahsm)paramMessage.next()).d();
          }
        }
      }
      else
      {
        if (paramMessage.what == 2)
        {
          paramMessage = a().split("\\|")[0].split(";");
          long l2;
          if ((paramMessage.length >= 3) && (paramMessage[2].equals("1")))
          {
            paramMessage = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
            l1 = paramMessage.getLong("battery_report_timestamp", 0L);
            if (Math.abs(System.currentTimeMillis() - l1) > 86400000L)
            {
              label951:
              Object localObject5;
              if (this.jdField_a_of_type_Long != 0L)
              {
                l2 = this.jdField_a_of_type_Long - 60000L;
                a(l1, l2);
                if (Math.random() < 0.003333333F)
                {
                  localObject5 = BatteryLog.a(l1, l2, 10, 3000L);
                  if ((localObject5 == null) || (((Pair)localObject5).second == null)) {
                    break label1306;
                  }
                  QLog.e("BatteryStats", 2, "report battery log: " + ((File)((Pair)localObject5).second).getName());
                }
              }
              try
              {
                localObject1 = new JSONObject();
                localObject4 = new JSONObject();
                ((JSONObject)localObject4).put("fileObj1", ((File)((Pair)localObject5).second).getAbsolutePath());
                localObject5 = new JSONObject();
                ((JSONObject)localObject5).put("p_id", MagnifierSDK.a());
                ((JSONObject)localObject5).put("plugin", String.valueOf(16));
                ((JSONObject)localObject1).put("fileObj", localObject4);
                ((JSONObject)localObject1).put("clientinfo", localObject5);
                ((JSONObject)localObject1).put("newplugin", 121);
              }
              catch (Throwable localThrowable)
              {
                for (;;)
                {
                  label1166:
                  label1207:
                  QLog.e("BatteryStats", 1, "report fail.", localThrowable);
                }
              }
              try
              {
                localObject4 = (QQAppInterface)BaseApplicationImpl.getApplication().waitAppRuntime(null);
                if (localObject4 == null) {
                  break;
                }
                l1 = Long.parseLong(((QQAppInterface)localObject4).c());
              }
              catch (Exception localException2)
              {
                QLog.e("BatteryStats", 1, "get uin " + 0L);
                l1 = 0L;
                break label1166;
              }
              ReporterMachine.a(new ResultObject(0, "testcase", true, 1L, 1L, (JSONObject)localObject1, true, true, l1));
              StatisticCollector.a(BaseApplication.getContext()).a(null, "batteryFileRpt", true, 0L, 0L, null, null);
              paramMessage.edit().putLong("battery_report_timestamp", l2).commit();
            }
          }
          for (;;)
          {
            BatteryLog.a(this.jdField_a_of_type_Long - 172800000L);
            this.e = true;
            break;
            l2 = System.currentTimeMillis();
            break label951;
            label1306:
            QLog.d("BatteryStats", 1, "no file to report");
            break label1207;
            QLog.d("BatteryStats", 1, "report interval is short");
            continue;
            QLog.d("BatteryStats", 1, "report switch is off");
          }
        }
        if (paramMessage.what == 3)
        {
          if (this.jdField_a_of_type_JavaUtilList != null)
          {
            paramMessage = this.jdField_a_of_type_JavaUtilList.iterator();
            while (paramMessage.hasNext()) {
              ((ahsm)paramMessage.next()).g();
            }
          }
          this.jdField_a_of_type_Int = 0;
        }
        else if (paramMessage.what == 4)
        {
          if (this.jdField_a_of_type_JavaUtilList != null)
          {
            try
            {
              paramMessage = this.jdField_a_of_type_JavaUtilList.iterator();
              while (paramMessage.hasNext()) {
                ((ahsm)paramMessage.next()).e();
              }
              if (!QLog.isColorLevel()) {
                continue;
              }
            }
            catch (Exception paramMessage) {}
            QLog.d("BatteryStats", 2, "", paramMessage);
          }
        }
        else if (paramMessage.what == 5)
        {
          if (this.jdField_a_of_type_JavaUtilList != null) {
            try
            {
              paramMessage = this.jdField_a_of_type_JavaUtilList.iterator();
              while (paramMessage.hasNext()) {
                ((ahsm)paramMessage.next()).f();
              }
              this.jdField_b_of_type_Boolean = true;
            }
            catch (Exception paramMessage)
            {
              if (QLog.isColorLevel()) {
                QLog.d("BatteryStats", 2, "", paramMessage);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.battery.BatteryStatsImpl
 * JD-Core Version:    0.7.0.1
 */