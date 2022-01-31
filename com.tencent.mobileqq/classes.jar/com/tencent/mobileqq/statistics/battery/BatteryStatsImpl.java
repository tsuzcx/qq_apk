package com.tencent.mobileqq.statistics.battery;

import aili;
import ailj;
import ailk;
import ailm;
import ailn;
import ailo;
import ailr;
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
    //   123: iload 12
    //   125: istore 9
    //   127: iload 11
    //   129: istore 8
    //   131: aload 25
    //   133: ldc 243
    //   135: ldc 245
    //   137: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   140: pop
    //   141: sipush 500
    //   144: istore 7
    //   146: iconst_0
    //   147: istore 10
    //   149: iload 12
    //   151: istore 9
    //   153: iload 11
    //   155: istore 8
    //   157: aload 19
    //   159: invokeinterface 251 1 0
    //   164: astore 23
    //   166: iload 6
    //   168: istore 9
    //   170: iload 5
    //   172: istore 8
    //   174: aload 23
    //   176: invokeinterface 257 1 0
    //   181: ifeq +5888 -> 6069
    //   184: iload 6
    //   186: istore 9
    //   188: iload 5
    //   190: istore 8
    //   192: aload 23
    //   194: invokeinterface 261 1 0
    //   199: checkcast 263	java/io/File
    //   202: astore 19
    //   204: new 265	java/io/FileInputStream
    //   207: dup
    //   208: aload 19
    //   210: invokespecial 268	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   213: astore 21
    //   215: new 270	java/io/BufferedReader
    //   218: dup
    //   219: new 272	java/io/InputStreamReader
    //   222: dup
    //   223: aload 21
    //   225: invokespecial 275	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   228: invokespecial 278	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   231: astore 20
    //   233: iload 7
    //   235: istore 12
    //   237: iload 10
    //   239: istore 7
    //   241: iload 7
    //   243: istore 18
    //   245: iload 6
    //   247: istore 17
    //   249: iload 5
    //   251: istore 13
    //   253: iload 12
    //   255: istore 14
    //   257: iload 6
    //   259: istore 8
    //   261: iload 5
    //   263: istore 11
    //   265: aload 20
    //   267: invokevirtual 281	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   270: astore 22
    //   272: aload 22
    //   274: ifnull +5788 -> 6062
    //   277: iload 12
    //   279: iconst_1
    //   280: isub
    //   281: istore 15
    //   283: iload 15
    //   285: ifgt +283 -> 568
    //   288: iload 15
    //   290: istore 10
    //   292: aload 21
    //   294: ifnull +16 -> 310
    //   297: iload 6
    //   299: istore 9
    //   301: iload 5
    //   303: istore 8
    //   305: aload 21
    //   307: invokevirtual 286	java/io/InputStream:close	()V
    //   310: aload 20
    //   312: ifnull +5731 -> 6043
    //   315: iload 6
    //   317: istore 9
    //   319: iload 5
    //   321: istore 8
    //   323: aload 20
    //   325: invokevirtual 287	java/io/BufferedReader:close	()V
    //   328: iload 10
    //   330: istore 8
    //   332: iload 6
    //   334: istore 9
    //   336: iload 5
    //   338: istore 6
    //   340: iload 9
    //   342: istore 5
    //   344: iload 6
    //   346: iconst_2
    //   347: if_icmplt +5479 -> 5826
    //   350: iload 5
    //   352: iconst_2
    //   353: if_icmplt +5473 -> 5826
    //   356: ldc 190
    //   358: iconst_1
    //   359: new 135	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   366: ldc_w 290
    //   369: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: iload 6
    //   374: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   377: ldc_w 295
    //   380: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: iload 5
    //   385: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: iload 6
    //   396: ifgt +8 -> 404
    //   399: iload 5
    //   401: ifle -378 -> 23
    //   404: new 199	org/json/JSONObject
    //   407: dup
    //   408: invokespecial 200	org/json/JSONObject:<init>	()V
    //   411: astore 19
    //   413: new 199	org/json/JSONObject
    //   416: dup
    //   417: invokespecial 200	org/json/JSONObject:<init>	()V
    //   420: astore 20
    //   422: aload 20
    //   424: ldc_w 297
    //   427: invokestatic 301	com/tencent/mfsdk/MagnifierSDK:a	()Ljava/lang/String;
    //   430: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   433: pop
    //   434: aload 20
    //   436: ldc_w 303
    //   439: bipush 124
    //   441: invokestatic 307	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   444: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   447: pop
    //   448: aload 19
    //   450: ldc_w 309
    //   453: aload 20
    //   455: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   458: pop
    //   459: aload 19
    //   461: ldc_w 311
    //   464: bipush 124
    //   466: invokevirtual 225	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   469: pop
    //   470: aload 19
    //   472: ldc_w 313
    //   475: aload 25
    //   477: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   480: pop
    //   481: invokestatic 233	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   484: aconst_null
    //   485: invokevirtual 237	com/tencent/common/app/BaseApplicationImpl:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   488: checkcast 239	com/tencent/mobileqq/app/QQAppInterface
    //   491: astore 20
    //   493: aload 20
    //   495: ifnull +5528 -> 6023
    //   498: aload 20
    //   500: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   503: invokestatic 319	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   506: lstore_1
    //   507: new 321	com/tencent/mfsdk/collector/ResultObject
    //   510: dup
    //   511: iconst_0
    //   512: ldc_w 323
    //   515: iconst_1
    //   516: lconst_1
    //   517: lconst_1
    //   518: aload 19
    //   520: iconst_1
    //   521: iconst_1
    //   522: lload_1
    //   523: invokespecial 326	com/tencent/mfsdk/collector/ResultObject:<init>	(ILjava/lang/String;ZJJLorg/json/JSONObject;ZZJ)V
    //   526: invokestatic 331	com/tencent/mfsdk/reporter/ReporterMachine:a	(Lcom/tencent/mfsdk/collector/ResultObject;)V
    //   529: ldc 190
    //   531: iconst_1
    //   532: ldc_w 333
    //   535: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   538: invokestatic 339	java/lang/Math:random	()D
    //   541: ldc2_w 340
    //   544: dcmpg
    //   545: ifge -522 -> 23
    //   548: invokestatic 347	com/tencent/mobileqq/mqsafeedit/BaseApplication:getContext	()Landroid/content/Context;
    //   551: invokestatic 352	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   554: aconst_null
    //   555: ldc_w 354
    //   558: iconst_1
    //   559: lconst_0
    //   560: lconst_0
    //   561: aload 24
    //   563: aconst_null
    //   564: invokevirtual 357	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   567: return
    //   568: iload 7
    //   570: istore 18
    //   572: iload 6
    //   574: istore 17
    //   576: iload 5
    //   578: istore 13
    //   580: iload 15
    //   582: istore 14
    //   584: iload 6
    //   586: istore 8
    //   588: iload 5
    //   590: istore 11
    //   592: aload 22
    //   594: ldc_w 359
    //   597: invokevirtual 363	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   600: astore 26
    //   602: aload 26
    //   604: iconst_1
    //   605: aaload
    //   606: astore 27
    //   608: iload 7
    //   610: istore 16
    //   612: iload 6
    //   614: istore 9
    //   616: iload 5
    //   618: istore 10
    //   620: iload 6
    //   622: istore 8
    //   624: iload 5
    //   626: istore 11
    //   628: aload 27
    //   630: ldc_w 365
    //   633: invokevirtual 368	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   636: ifeq +13 -> 649
    //   639: iload 15
    //   641: istore 12
    //   643: iload 5
    //   645: iconst_2
    //   646: if_icmpgt -405 -> 241
    //   649: iload 7
    //   651: istore 16
    //   653: iload 6
    //   655: istore 9
    //   657: iload 5
    //   659: istore 10
    //   661: iload 6
    //   663: istore 8
    //   665: iload 5
    //   667: istore 11
    //   669: aload 27
    //   671: ldc_w 370
    //   674: invokevirtual 368	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   677: ifeq +13 -> 690
    //   680: iload 15
    //   682: istore 12
    //   684: iload 6
    //   686: iconst_2
    //   687: if_icmpgt -446 -> 241
    //   690: iload 7
    //   692: istore 16
    //   694: iload 6
    //   696: istore 9
    //   698: iload 5
    //   700: istore 10
    //   702: iload 6
    //   704: istore 8
    //   706: iload 5
    //   708: istore 11
    //   710: aload 25
    //   712: aload 27
    //   714: invokevirtual 373	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   717: ifne +888 -> 1605
    //   720: iload 7
    //   722: istore 16
    //   724: iload 6
    //   726: istore 9
    //   728: iload 5
    //   730: istore 10
    //   732: iload 6
    //   734: istore 8
    //   736: iload 5
    //   738: istore 11
    //   740: new 375	org/json/JSONArray
    //   743: dup
    //   744: invokespecial 376	org/json/JSONArray:<init>	()V
    //   747: astore 19
    //   749: iload 7
    //   751: istore 16
    //   753: iload 6
    //   755: istore 9
    //   757: iload 5
    //   759: istore 10
    //   761: iload 6
    //   763: istore 8
    //   765: iload 5
    //   767: istore 11
    //   769: aload 25
    //   771: aload 27
    //   773: aload 19
    //   775: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   778: pop
    //   779: iload 7
    //   781: istore 16
    //   783: iload 6
    //   785: istore 9
    //   787: iload 5
    //   789: istore 10
    //   791: iload 6
    //   793: istore 8
    //   795: iload 5
    //   797: istore 11
    //   799: aload 26
    //   801: iconst_0
    //   802: aaload
    //   803: invokestatic 379	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   806: invokevirtual 383	java/lang/Long:longValue	()J
    //   809: ldc2_w 384
    //   812: ldiv
    //   813: l2i
    //   814: istore 17
    //   816: iload 7
    //   818: istore 16
    //   820: iload 6
    //   822: istore 9
    //   824: iload 5
    //   826: istore 10
    //   828: iload 6
    //   830: istore 8
    //   832: iload 5
    //   834: istore 11
    //   836: aload 27
    //   838: ldc_w 387
    //   841: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   844: ifne +34 -> 878
    //   847: iload 7
    //   849: istore 16
    //   851: iload 6
    //   853: istore 9
    //   855: iload 5
    //   857: istore 10
    //   859: iload 6
    //   861: istore 8
    //   863: iload 5
    //   865: istore 11
    //   867: aload 27
    //   869: ldc_w 393
    //   872: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   875: ifeq +852 -> 1727
    //   878: iload 7
    //   880: istore 16
    //   882: iload 6
    //   884: istore 9
    //   886: iload 5
    //   888: istore 10
    //   890: iload 6
    //   892: istore 8
    //   894: iload 5
    //   896: istore 11
    //   898: aload 27
    //   900: ldc_w 387
    //   903: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   906: ifeq +731 -> 1637
    //   909: iload 5
    //   911: iconst_1
    //   912: iadd
    //   913: istore 14
    //   915: iload 6
    //   917: istore 13
    //   919: iload 7
    //   921: istore 16
    //   923: iload 13
    //   925: istore 9
    //   927: iload 14
    //   929: istore 10
    //   931: iload 13
    //   933: istore 8
    //   935: iload 14
    //   937: istore 11
    //   939: new 199	org/json/JSONObject
    //   942: dup
    //   943: invokespecial 200	org/json/JSONObject:<init>	()V
    //   946: astore 28
    //   948: iload 7
    //   950: istore 16
    //   952: iload 13
    //   954: istore 9
    //   956: iload 14
    //   958: istore 10
    //   960: iload 13
    //   962: istore 8
    //   964: iload 14
    //   966: istore 11
    //   968: aload 28
    //   970: ldc_w 395
    //   973: aload 26
    //   975: iconst_2
    //   976: aaload
    //   977: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   980: pop
    //   981: iload 7
    //   983: istore 16
    //   985: iload 13
    //   987: istore 9
    //   989: iload 14
    //   991: istore 10
    //   993: iload 13
    //   995: istore 8
    //   997: iload 14
    //   999: istore 11
    //   1001: aload 28
    //   1003: ldc 205
    //   1005: aload 26
    //   1007: iconst_3
    //   1008: aaload
    //   1009: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1012: pop
    //   1013: iload 7
    //   1015: istore 16
    //   1017: iload 13
    //   1019: istore 9
    //   1021: iload 14
    //   1023: istore 10
    //   1025: iload 13
    //   1027: istore 8
    //   1029: iload 14
    //   1031: istore 11
    //   1033: aload 28
    //   1035: ldc_w 397
    //   1038: iload 17
    //   1040: invokevirtual 225	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1043: pop
    //   1044: iload 7
    //   1046: istore 16
    //   1048: iload 13
    //   1050: istore 9
    //   1052: iload 14
    //   1054: istore 10
    //   1056: iload 13
    //   1058: istore 8
    //   1060: iload 14
    //   1062: istore 11
    //   1064: aload 26
    //   1066: arraylength
    //   1067: iconst_5
    //   1068: if_icmplt +36 -> 1104
    //   1071: iload 7
    //   1073: istore 16
    //   1075: iload 13
    //   1077: istore 9
    //   1079: iload 14
    //   1081: istore 10
    //   1083: iload 13
    //   1085: istore 8
    //   1087: iload 14
    //   1089: istore 11
    //   1091: aload 28
    //   1093: ldc_w 399
    //   1096: aload 26
    //   1098: iconst_3
    //   1099: aaload
    //   1100: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1103: pop
    //   1104: iload 7
    //   1106: istore 16
    //   1108: iload 13
    //   1110: istore 9
    //   1112: iload 14
    //   1114: istore 10
    //   1116: iload 13
    //   1118: istore 8
    //   1120: iload 14
    //   1122: istore 11
    //   1124: aload 19
    //   1126: aload 28
    //   1128: invokevirtual 402	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   1131: pop
    //   1132: iload 13
    //   1134: istore 6
    //   1136: iload 14
    //   1138: istore 5
    //   1140: iload 15
    //   1142: istore 12
    //   1144: iload 7
    //   1146: istore 16
    //   1148: iload 13
    //   1150: istore 9
    //   1152: iload 14
    //   1154: istore 10
    //   1156: iload 13
    //   1158: istore 8
    //   1160: iload 14
    //   1162: istore 11
    //   1164: aload 24
    //   1166: new 135	java/lang/StringBuilder
    //   1169: dup
    //   1170: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   1173: aload 27
    //   1175: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: ldc_w 404
    //   1181: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1184: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1187: invokevirtual 407	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1190: ifne -949 -> 241
    //   1193: iload 7
    //   1195: istore 16
    //   1197: iload 13
    //   1199: istore 9
    //   1201: iload 14
    //   1203: istore 10
    //   1205: iload 13
    //   1207: istore 8
    //   1209: iload 14
    //   1211: istore 11
    //   1213: aload 24
    //   1215: new 135	java/lang/StringBuilder
    //   1218: dup
    //   1219: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   1222: aload 27
    //   1224: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1227: ldc_w 409
    //   1230: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1233: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1236: iload 17
    //   1238: invokestatic 307	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1241: invokevirtual 412	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1244: pop
    //   1245: iload 7
    //   1247: istore 16
    //   1249: iload 13
    //   1251: istore 9
    //   1253: iload 14
    //   1255: istore 10
    //   1257: iload 13
    //   1259: istore 8
    //   1261: iload 14
    //   1263: istore 11
    //   1265: aload 24
    //   1267: new 135	java/lang/StringBuilder
    //   1270: dup
    //   1271: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   1274: aload 27
    //   1276: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1279: ldc_w 404
    //   1282: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1288: aload 26
    //   1290: iconst_2
    //   1291: aaload
    //   1292: invokevirtual 412	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1295: pop
    //   1296: iload 7
    //   1298: istore 16
    //   1300: iload 13
    //   1302: istore 9
    //   1304: iload 14
    //   1306: istore 10
    //   1308: iload 13
    //   1310: istore 8
    //   1312: iload 14
    //   1314: istore 11
    //   1316: aload 24
    //   1318: new 135	java/lang/StringBuilder
    //   1321: dup
    //   1322: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   1325: aload 27
    //   1327: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1330: ldc_w 414
    //   1333: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1336: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1339: aload 26
    //   1341: iconst_3
    //   1342: aaload
    //   1343: invokevirtual 412	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1346: pop
    //   1347: iload 13
    //   1349: istore 8
    //   1351: iload 14
    //   1353: istore 11
    //   1355: aload 26
    //   1357: iconst_2
    //   1358: aaload
    //   1359: invokestatic 379	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1362: invokevirtual 383	java/lang/Long:longValue	()J
    //   1365: ldc2_w 415
    //   1368: lmul
    //   1369: aload 26
    //   1371: iconst_3
    //   1372: aaload
    //   1373: invokestatic 379	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1376: invokevirtual 383	java/lang/Long:longValue	()J
    //   1379: ldiv
    //   1380: lstore_1
    //   1381: lload_1
    //   1382: l2i
    //   1383: istore 5
    //   1385: iload 7
    //   1387: istore 16
    //   1389: iload 13
    //   1391: istore 9
    //   1393: iload 14
    //   1395: istore 10
    //   1397: iload 13
    //   1399: istore 8
    //   1401: iload 14
    //   1403: istore 11
    //   1405: aload 24
    //   1407: new 135	java/lang/StringBuilder
    //   1410: dup
    //   1411: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   1414: aload 27
    //   1416: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1419: ldc_w 418
    //   1422: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1428: iload 5
    //   1430: invokestatic 307	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1433: invokevirtual 412	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1436: pop
    //   1437: iload 13
    //   1439: istore 6
    //   1441: iload 14
    //   1443: istore 5
    //   1445: iload 15
    //   1447: istore 12
    //   1449: goto -1208 -> 241
    //   1452: astore 19
    //   1454: iload 16
    //   1456: istore 18
    //   1458: iload 9
    //   1460: istore 17
    //   1462: iload 10
    //   1464: istore 13
    //   1466: iload 15
    //   1468: istore 14
    //   1470: iload 9
    //   1472: istore 8
    //   1474: iload 10
    //   1476: istore 11
    //   1478: ldc 190
    //   1480: iconst_2
    //   1481: new 135	java/lang/StringBuilder
    //   1484: dup
    //   1485: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   1488: ldc_w 420
    //   1491: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1494: aload 22
    //   1496: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1499: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1502: invokestatic 422	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1505: iload 16
    //   1507: istore 7
    //   1509: iload 9
    //   1511: istore 6
    //   1513: iload 10
    //   1515: istore 5
    //   1517: iload 15
    //   1519: istore 12
    //   1521: goto -1280 -> 241
    //   1524: astore 22
    //   1526: iload 18
    //   1528: istore 7
    //   1530: iload 17
    //   1532: istore 6
    //   1534: aload 20
    //   1536: astore 19
    //   1538: iload 14
    //   1540: istore 8
    //   1542: iload 13
    //   1544: istore 5
    //   1546: aload 21
    //   1548: astore 20
    //   1550: aload 22
    //   1552: astore 21
    //   1554: invokestatic 425	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1557: ifeq +13 -> 1570
    //   1560: ldc 190
    //   1562: iconst_2
    //   1563: ldc 132
    //   1565: aload 21
    //   1567: invokestatic 428	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1570: aload 20
    //   1572: ifnull +8 -> 1580
    //   1575: aload 20
    //   1577: invokevirtual 286	java/io/InputStream:close	()V
    //   1580: aload 19
    //   1582: ifnull +4446 -> 6028
    //   1585: aload 19
    //   1587: invokevirtual 287	java/io/BufferedReader:close	()V
    //   1590: iload 5
    //   1592: istore 9
    //   1594: iload 6
    //   1596: istore 5
    //   1598: iload 9
    //   1600: istore 6
    //   1602: goto -1258 -> 344
    //   1605: iload 7
    //   1607: istore 16
    //   1609: iload 6
    //   1611: istore 9
    //   1613: iload 5
    //   1615: istore 10
    //   1617: iload 6
    //   1619: istore 8
    //   1621: iload 5
    //   1623: istore 11
    //   1625: aload 25
    //   1627: aload 27
    //   1629: invokevirtual 432	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1632: astore 19
    //   1634: goto -855 -> 779
    //   1637: iload 6
    //   1639: istore 13
    //   1641: iload 5
    //   1643: istore 14
    //   1645: iload 7
    //   1647: istore 16
    //   1649: iload 6
    //   1651: istore 9
    //   1653: iload 5
    //   1655: istore 10
    //   1657: iload 6
    //   1659: istore 8
    //   1661: iload 5
    //   1663: istore 11
    //   1665: aload 27
    //   1667: ldc_w 393
    //   1670: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1673: ifeq -754 -> 919
    //   1676: iload 6
    //   1678: iconst_1
    //   1679: iadd
    //   1680: istore 13
    //   1682: iload 5
    //   1684: istore 14
    //   1686: goto -767 -> 919
    //   1689: astore 19
    //   1691: iload 7
    //   1693: istore 16
    //   1695: iload 13
    //   1697: istore 9
    //   1699: iload 14
    //   1701: istore 10
    //   1703: iload 13
    //   1705: istore 8
    //   1707: iload 14
    //   1709: istore 11
    //   1711: ldc 190
    //   1713: iconst_2
    //   1714: ldc 132
    //   1716: aload 19
    //   1718: invokestatic 434	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1721: iconst_m1
    //   1722: istore 5
    //   1724: goto -339 -> 1385
    //   1727: iload 7
    //   1729: istore 16
    //   1731: iload 6
    //   1733: istore 9
    //   1735: iload 5
    //   1737: istore 10
    //   1739: iload 6
    //   1741: istore 8
    //   1743: iload 5
    //   1745: istore 11
    //   1747: aload 27
    //   1749: ldc_w 436
    //   1752: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1755: ifne +34 -> 1789
    //   1758: iload 7
    //   1760: istore 16
    //   1762: iload 6
    //   1764: istore 9
    //   1766: iload 5
    //   1768: istore 10
    //   1770: iload 6
    //   1772: istore 8
    //   1774: iload 5
    //   1776: istore 11
    //   1778: aload 27
    //   1780: ldc_w 438
    //   1783: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1786: ifeq +637 -> 2423
    //   1789: iload 7
    //   1791: istore 16
    //   1793: iload 6
    //   1795: istore 9
    //   1797: iload 5
    //   1799: istore 10
    //   1801: iload 6
    //   1803: istore 8
    //   1805: iload 5
    //   1807: istore 11
    //   1809: new 199	org/json/JSONObject
    //   1812: dup
    //   1813: invokespecial 200	org/json/JSONObject:<init>	()V
    //   1816: astore 28
    //   1818: iload 7
    //   1820: istore 16
    //   1822: iload 6
    //   1824: istore 9
    //   1826: iload 5
    //   1828: istore 10
    //   1830: iload 6
    //   1832: istore 8
    //   1834: iload 5
    //   1836: istore 11
    //   1838: aload 28
    //   1840: ldc_w 397
    //   1843: iload 17
    //   1845: invokevirtual 225	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1848: pop
    //   1849: iload 7
    //   1851: istore 16
    //   1853: iload 6
    //   1855: istore 9
    //   1857: iload 5
    //   1859: istore 10
    //   1861: iload 6
    //   1863: istore 8
    //   1865: iload 5
    //   1867: istore 11
    //   1869: aload 28
    //   1871: ldc_w 440
    //   1874: aload 26
    //   1876: iconst_2
    //   1877: aaload
    //   1878: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1881: pop
    //   1882: iload 7
    //   1884: istore 16
    //   1886: iload 6
    //   1888: istore 9
    //   1890: iload 5
    //   1892: istore 10
    //   1894: iload 6
    //   1896: istore 8
    //   1898: iload 5
    //   1900: istore 11
    //   1902: aload 28
    //   1904: ldc_w 442
    //   1907: aload 26
    //   1909: iconst_3
    //   1910: aaload
    //   1911: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1914: pop
    //   1915: iload 7
    //   1917: istore 16
    //   1919: iload 6
    //   1921: istore 9
    //   1923: iload 5
    //   1925: istore 10
    //   1927: iload 6
    //   1929: istore 8
    //   1931: iload 5
    //   1933: istore 11
    //   1935: aload 28
    //   1937: ldc_w 444
    //   1940: aload 26
    //   1942: iconst_4
    //   1943: aaload
    //   1944: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1947: pop
    //   1948: iload 7
    //   1950: istore 16
    //   1952: iload 6
    //   1954: istore 9
    //   1956: iload 5
    //   1958: istore 10
    //   1960: iload 6
    //   1962: istore 8
    //   1964: iload 5
    //   1966: istore 11
    //   1968: aload 28
    //   1970: ldc_w 446
    //   1973: aload 26
    //   1975: iconst_5
    //   1976: aaload
    //   1977: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1980: pop
    //   1981: iload 7
    //   1983: istore 16
    //   1985: iload 6
    //   1987: istore 9
    //   1989: iload 5
    //   1991: istore 10
    //   1993: iload 6
    //   1995: istore 8
    //   1997: iload 5
    //   1999: istore 11
    //   2001: aload 19
    //   2003: aload 28
    //   2005: invokevirtual 402	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   2008: pop
    //   2009: iload 15
    //   2011: istore 12
    //   2013: iload 7
    //   2015: istore 16
    //   2017: iload 6
    //   2019: istore 9
    //   2021: iload 5
    //   2023: istore 10
    //   2025: iload 6
    //   2027: istore 8
    //   2029: iload 5
    //   2031: istore 11
    //   2033: aload 24
    //   2035: new 135	java/lang/StringBuilder
    //   2038: dup
    //   2039: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   2042: aload 27
    //   2044: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2047: ldc_w 409
    //   2050: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2053: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2056: invokevirtual 407	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2059: ifne -1818 -> 241
    //   2062: iload 7
    //   2064: istore 16
    //   2066: iload 6
    //   2068: istore 9
    //   2070: iload 5
    //   2072: istore 10
    //   2074: iload 6
    //   2076: istore 8
    //   2078: iload 5
    //   2080: istore 11
    //   2082: aload 24
    //   2084: new 135	java/lang/StringBuilder
    //   2087: dup
    //   2088: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   2091: aload 27
    //   2093: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2096: ldc_w 409
    //   2099: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2102: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2105: iload 17
    //   2107: invokestatic 307	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2110: invokevirtual 412	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2113: pop
    //   2114: iload 7
    //   2116: istore 16
    //   2118: iload 6
    //   2120: istore 9
    //   2122: iload 5
    //   2124: istore 10
    //   2126: iload 6
    //   2128: istore 8
    //   2130: iload 5
    //   2132: istore 11
    //   2134: aload 24
    //   2136: new 135	java/lang/StringBuilder
    //   2139: dup
    //   2140: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   2143: aload 27
    //   2145: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2148: ldc_w 448
    //   2151: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2154: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2157: aload 26
    //   2159: iconst_2
    //   2160: aaload
    //   2161: invokevirtual 412	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2164: pop
    //   2165: iload 7
    //   2167: istore 16
    //   2169: iload 6
    //   2171: istore 9
    //   2173: iload 5
    //   2175: istore 10
    //   2177: iload 6
    //   2179: istore 8
    //   2181: iload 5
    //   2183: istore 11
    //   2185: aload 24
    //   2187: new 135	java/lang/StringBuilder
    //   2190: dup
    //   2191: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   2194: aload 27
    //   2196: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2199: ldc_w 450
    //   2202: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2205: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2208: aload 26
    //   2210: iconst_3
    //   2211: aaload
    //   2212: invokevirtual 412	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2215: pop
    //   2216: iload 7
    //   2218: istore 16
    //   2220: iload 6
    //   2222: istore 9
    //   2224: iload 5
    //   2226: istore 10
    //   2228: iload 6
    //   2230: istore 8
    //   2232: iload 5
    //   2234: istore 11
    //   2236: aload 24
    //   2238: new 135	java/lang/StringBuilder
    //   2241: dup
    //   2242: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   2245: aload 27
    //   2247: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2250: ldc_w 452
    //   2253: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2256: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2259: aload 26
    //   2261: iconst_4
    //   2262: aaload
    //   2263: invokevirtual 412	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2266: pop
    //   2267: iload 7
    //   2269: istore 16
    //   2271: iload 6
    //   2273: istore 9
    //   2275: iload 5
    //   2277: istore 10
    //   2279: iload 6
    //   2281: istore 8
    //   2283: iload 5
    //   2285: istore 11
    //   2287: aload 24
    //   2289: new 135	java/lang/StringBuilder
    //   2292: dup
    //   2293: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   2296: aload 27
    //   2298: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2301: ldc_w 454
    //   2304: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2307: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2310: aload 26
    //   2312: iconst_5
    //   2313: aaload
    //   2314: invokevirtual 412	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2317: pop
    //   2318: iload 15
    //   2320: istore 12
    //   2322: goto -2081 -> 241
    //   2325: astore 19
    //   2327: iload 11
    //   2329: istore 5
    //   2331: iload 8
    //   2333: istore 6
    //   2335: aload 21
    //   2337: ifnull +16 -> 2353
    //   2340: iload 6
    //   2342: istore 9
    //   2344: iload 5
    //   2346: istore 8
    //   2348: aload 21
    //   2350: invokevirtual 286	java/io/InputStream:close	()V
    //   2353: aload 20
    //   2355: ifnull +16 -> 2371
    //   2358: iload 6
    //   2360: istore 9
    //   2362: iload 5
    //   2364: istore 8
    //   2366: aload 20
    //   2368: invokevirtual 287	java/io/BufferedReader:close	()V
    //   2371: iload 6
    //   2373: istore 9
    //   2375: iload 5
    //   2377: istore 8
    //   2379: aload 19
    //   2381: athrow
    //   2382: astore 19
    //   2384: iload 9
    //   2386: istore 7
    //   2388: iload 7
    //   2390: istore 5
    //   2392: iload 8
    //   2394: istore 6
    //   2396: invokestatic 425	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2399: ifeq -2043 -> 356
    //   2402: ldc 190
    //   2404: iconst_2
    //   2405: ldc 132
    //   2407: aload 19
    //   2409: invokestatic 428	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2412: iload 7
    //   2414: istore 5
    //   2416: iload 8
    //   2418: istore 6
    //   2420: goto -2064 -> 356
    //   2423: iload 7
    //   2425: istore 16
    //   2427: iload 6
    //   2429: istore 9
    //   2431: iload 5
    //   2433: istore 10
    //   2435: iload 6
    //   2437: istore 8
    //   2439: iload 5
    //   2441: istore 11
    //   2443: aload 27
    //   2445: ldc_w 456
    //   2448: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2451: ifne +282 -> 2733
    //   2454: iload 7
    //   2456: istore 16
    //   2458: iload 6
    //   2460: istore 9
    //   2462: iload 5
    //   2464: istore 10
    //   2466: iload 6
    //   2468: istore 8
    //   2470: iload 5
    //   2472: istore 11
    //   2474: aload 27
    //   2476: ldc_w 458
    //   2479: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2482: ifne +251 -> 2733
    //   2485: iload 7
    //   2487: istore 16
    //   2489: iload 6
    //   2491: istore 9
    //   2493: iload 5
    //   2495: istore 10
    //   2497: iload 6
    //   2499: istore 8
    //   2501: iload 5
    //   2503: istore 11
    //   2505: aload 27
    //   2507: ldc_w 460
    //   2510: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2513: ifne +220 -> 2733
    //   2516: iload 7
    //   2518: istore 16
    //   2520: iload 6
    //   2522: istore 9
    //   2524: iload 5
    //   2526: istore 10
    //   2528: iload 6
    //   2530: istore 8
    //   2532: iload 5
    //   2534: istore 11
    //   2536: aload 27
    //   2538: ldc_w 462
    //   2541: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2544: ifne +189 -> 2733
    //   2547: iload 7
    //   2549: istore 16
    //   2551: iload 6
    //   2553: istore 9
    //   2555: iload 5
    //   2557: istore 10
    //   2559: iload 6
    //   2561: istore 8
    //   2563: iload 5
    //   2565: istore 11
    //   2567: aload 27
    //   2569: ldc_w 464
    //   2572: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2575: ifne +158 -> 2733
    //   2578: iload 7
    //   2580: istore 16
    //   2582: iload 6
    //   2584: istore 9
    //   2586: iload 5
    //   2588: istore 10
    //   2590: iload 6
    //   2592: istore 8
    //   2594: iload 5
    //   2596: istore 11
    //   2598: aload 27
    //   2600: ldc_w 466
    //   2603: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2606: ifne +127 -> 2733
    //   2609: iload 7
    //   2611: istore 16
    //   2613: iload 6
    //   2615: istore 9
    //   2617: iload 5
    //   2619: istore 10
    //   2621: iload 6
    //   2623: istore 8
    //   2625: iload 5
    //   2627: istore 11
    //   2629: aload 27
    //   2631: ldc_w 468
    //   2634: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2637: ifne +96 -> 2733
    //   2640: iload 7
    //   2642: istore 16
    //   2644: iload 6
    //   2646: istore 9
    //   2648: iload 5
    //   2650: istore 10
    //   2652: iload 6
    //   2654: istore 8
    //   2656: iload 5
    //   2658: istore 11
    //   2660: aload 27
    //   2662: ldc_w 470
    //   2665: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2668: ifne +65 -> 2733
    //   2671: iload 7
    //   2673: istore 16
    //   2675: iload 6
    //   2677: istore 9
    //   2679: iload 5
    //   2681: istore 10
    //   2683: iload 6
    //   2685: istore 8
    //   2687: iload 5
    //   2689: istore 11
    //   2691: aload 27
    //   2693: ldc_w 472
    //   2696: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2699: ifne +34 -> 2733
    //   2702: iload 7
    //   2704: istore 16
    //   2706: iload 6
    //   2708: istore 9
    //   2710: iload 5
    //   2712: istore 10
    //   2714: iload 6
    //   2716: istore 8
    //   2718: iload 5
    //   2720: istore 11
    //   2722: aload 27
    //   2724: ldc_w 474
    //   2727: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2730: ifeq +287 -> 3017
    //   2733: iload 7
    //   2735: istore 16
    //   2737: iload 6
    //   2739: istore 9
    //   2741: iload 5
    //   2743: istore 10
    //   2745: iload 6
    //   2747: istore 8
    //   2749: iload 5
    //   2751: istore 11
    //   2753: new 199	org/json/JSONObject
    //   2756: dup
    //   2757: invokespecial 200	org/json/JSONObject:<init>	()V
    //   2760: astore 28
    //   2762: iload 7
    //   2764: istore 16
    //   2766: iload 6
    //   2768: istore 9
    //   2770: iload 5
    //   2772: istore 10
    //   2774: iload 6
    //   2776: istore 8
    //   2778: iload 5
    //   2780: istore 11
    //   2782: aload 28
    //   2784: ldc_w 397
    //   2787: iload 17
    //   2789: invokevirtual 225	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2792: pop
    //   2793: iload 7
    //   2795: istore 16
    //   2797: iload 6
    //   2799: istore 9
    //   2801: iload 5
    //   2803: istore 10
    //   2805: iload 6
    //   2807: istore 8
    //   2809: iload 5
    //   2811: istore 11
    //   2813: aload 28
    //   2815: ldc_w 476
    //   2818: aload 26
    //   2820: iconst_2
    //   2821: aaload
    //   2822: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2825: pop
    //   2826: iload 7
    //   2828: istore 16
    //   2830: iload 6
    //   2832: istore 9
    //   2834: iload 5
    //   2836: istore 10
    //   2838: iload 6
    //   2840: istore 8
    //   2842: iload 5
    //   2844: istore 11
    //   2846: aload 19
    //   2848: aload 28
    //   2850: invokevirtual 402	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   2853: pop
    //   2854: iload 15
    //   2856: istore 12
    //   2858: iload 7
    //   2860: istore 16
    //   2862: iload 6
    //   2864: istore 9
    //   2866: iload 5
    //   2868: istore 10
    //   2870: iload 6
    //   2872: istore 8
    //   2874: iload 5
    //   2876: istore 11
    //   2878: aload 24
    //   2880: new 135	java/lang/StringBuilder
    //   2883: dup
    //   2884: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   2887: aload 27
    //   2889: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2892: ldc_w 478
    //   2895: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2898: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2901: invokevirtual 407	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2904: ifne -2663 -> 241
    //   2907: iload 7
    //   2909: istore 16
    //   2911: iload 6
    //   2913: istore 9
    //   2915: iload 5
    //   2917: istore 10
    //   2919: iload 6
    //   2921: istore 8
    //   2923: iload 5
    //   2925: istore 11
    //   2927: aload 24
    //   2929: new 135	java/lang/StringBuilder
    //   2932: dup
    //   2933: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   2936: aload 27
    //   2938: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2941: ldc_w 478
    //   2944: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2947: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2950: aload 26
    //   2952: iconst_2
    //   2953: aaload
    //   2954: invokevirtual 412	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2957: pop
    //   2958: iload 7
    //   2960: istore 16
    //   2962: iload 6
    //   2964: istore 9
    //   2966: iload 5
    //   2968: istore 10
    //   2970: iload 6
    //   2972: istore 8
    //   2974: iload 5
    //   2976: istore 11
    //   2978: aload 24
    //   2980: new 135	java/lang/StringBuilder
    //   2983: dup
    //   2984: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   2987: aload 27
    //   2989: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2992: ldc_w 409
    //   2995: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2998: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3001: iload 17
    //   3003: invokestatic 307	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   3006: invokevirtual 412	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3009: pop
    //   3010: iload 15
    //   3012: istore 12
    //   3014: goto -2773 -> 241
    //   3017: iload 7
    //   3019: istore 16
    //   3021: iload 6
    //   3023: istore 9
    //   3025: iload 5
    //   3027: istore 10
    //   3029: iload 6
    //   3031: istore 8
    //   3033: iload 5
    //   3035: istore 11
    //   3037: aload 27
    //   3039: ldc_w 480
    //   3042: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3045: ifne +96 -> 3141
    //   3048: iload 7
    //   3050: istore 16
    //   3052: iload 6
    //   3054: istore 9
    //   3056: iload 5
    //   3058: istore 10
    //   3060: iload 6
    //   3062: istore 8
    //   3064: iload 5
    //   3066: istore 11
    //   3068: aload 27
    //   3070: ldc_w 482
    //   3073: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3076: ifne +65 -> 3141
    //   3079: iload 7
    //   3081: istore 16
    //   3083: iload 6
    //   3085: istore 9
    //   3087: iload 5
    //   3089: istore 10
    //   3091: iload 6
    //   3093: istore 8
    //   3095: iload 5
    //   3097: istore 11
    //   3099: aload 27
    //   3101: ldc_w 484
    //   3104: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3107: ifne +34 -> 3141
    //   3110: iload 7
    //   3112: istore 16
    //   3114: iload 6
    //   3116: istore 9
    //   3118: iload 5
    //   3120: istore 10
    //   3122: iload 6
    //   3124: istore 8
    //   3126: iload 5
    //   3128: istore 11
    //   3130: aload 27
    //   3132: ldc_w 486
    //   3135: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3138: ifeq +558 -> 3696
    //   3141: iload 7
    //   3143: istore 16
    //   3145: iload 6
    //   3147: istore 9
    //   3149: iload 5
    //   3151: istore 10
    //   3153: iload 6
    //   3155: istore 8
    //   3157: iload 5
    //   3159: istore 11
    //   3161: new 199	org/json/JSONObject
    //   3164: dup
    //   3165: invokespecial 200	org/json/JSONObject:<init>	()V
    //   3168: astore 28
    //   3170: iload 7
    //   3172: istore 16
    //   3174: iload 6
    //   3176: istore 9
    //   3178: iload 5
    //   3180: istore 10
    //   3182: iload 6
    //   3184: istore 8
    //   3186: iload 5
    //   3188: istore 11
    //   3190: aload_0
    //   3191: aload 26
    //   3193: iconst_2
    //   3194: aload 26
    //   3196: arraylength
    //   3197: iconst_2
    //   3198: isub
    //   3199: invokespecial 488	com/tencent/mobileqq/statistics/battery/BatteryStatsImpl:a	([Ljava/lang/String;II)Ljava/lang/String;
    //   3202: astore 29
    //   3204: iload 7
    //   3206: istore 16
    //   3208: iload 6
    //   3210: istore 9
    //   3212: iload 5
    //   3214: istore 10
    //   3216: iload 6
    //   3218: istore 8
    //   3220: iload 5
    //   3222: istore 11
    //   3224: aload 27
    //   3226: ldc_w 484
    //   3229: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3232: ifne +34 -> 3266
    //   3235: iload 7
    //   3237: istore 16
    //   3239: iload 6
    //   3241: istore 9
    //   3243: iload 5
    //   3245: istore 10
    //   3247: iload 6
    //   3249: istore 8
    //   3251: iload 5
    //   3253: istore 11
    //   3255: aload 27
    //   3257: ldc_w 486
    //   3260: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3263: ifeq +364 -> 3627
    //   3266: iload 7
    //   3268: istore 16
    //   3270: iload 6
    //   3272: istore 9
    //   3274: iload 5
    //   3276: istore 10
    //   3278: iload 6
    //   3280: istore 8
    //   3282: iload 5
    //   3284: istore 11
    //   3286: aload 28
    //   3288: ldc_w 490
    //   3291: aload 29
    //   3293: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3296: pop
    //   3297: iload 7
    //   3299: istore 16
    //   3301: iload 6
    //   3303: istore 9
    //   3305: iload 5
    //   3307: istore 10
    //   3309: iload 6
    //   3311: istore 8
    //   3313: iload 5
    //   3315: istore 11
    //   3317: new 375	org/json/JSONArray
    //   3320: dup
    //   3321: invokespecial 376	org/json/JSONArray:<init>	()V
    //   3324: astore 27
    //   3326: iload 7
    //   3328: istore 16
    //   3330: iload 6
    //   3332: istore 9
    //   3334: iload 5
    //   3336: istore 10
    //   3338: iload 6
    //   3340: istore 8
    //   3342: iload 5
    //   3344: istore 11
    //   3346: aload 28
    //   3348: ldc_w 492
    //   3351: aload 27
    //   3353: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3356: pop
    //   3357: iload 7
    //   3359: istore 16
    //   3361: iload 6
    //   3363: istore 9
    //   3365: iload 5
    //   3367: istore 10
    //   3369: iload 6
    //   3371: istore 8
    //   3373: iload 5
    //   3375: istore 11
    //   3377: aload 26
    //   3379: aload 26
    //   3381: arraylength
    //   3382: iconst_1
    //   3383: isub
    //   3384: aaload
    //   3385: ldc 119
    //   3387: invokevirtual 363	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   3390: astore 26
    //   3392: iload 7
    //   3394: istore 16
    //   3396: iload 6
    //   3398: istore 9
    //   3400: iload 5
    //   3402: istore 10
    //   3404: iload 6
    //   3406: istore 8
    //   3408: iload 5
    //   3410: istore 11
    //   3412: aload 26
    //   3414: arraylength
    //   3415: istore 13
    //   3417: iconst_0
    //   3418: istore 12
    //   3420: iload 12
    //   3422: iload 13
    //   3424: if_icmpge +237 -> 3661
    //   3427: iload 7
    //   3429: istore 16
    //   3431: iload 6
    //   3433: istore 9
    //   3435: iload 5
    //   3437: istore 10
    //   3439: iload 6
    //   3441: istore 8
    //   3443: iload 5
    //   3445: istore 11
    //   3447: aload 26
    //   3449: iload 12
    //   3451: aaload
    //   3452: ldc 176
    //   3454: invokevirtual 363	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   3457: astore 29
    //   3459: aload 29
    //   3461: ifnull +2623 -> 6084
    //   3464: iload 7
    //   3466: istore 16
    //   3468: iload 6
    //   3470: istore 9
    //   3472: iload 5
    //   3474: istore 10
    //   3476: iload 6
    //   3478: istore 8
    //   3480: iload 5
    //   3482: istore 11
    //   3484: aload 29
    //   3486: arraylength
    //   3487: iconst_1
    //   3488: if_icmple +2596 -> 6084
    //   3491: iload 7
    //   3493: istore 16
    //   3495: iload 6
    //   3497: istore 9
    //   3499: iload 5
    //   3501: istore 10
    //   3503: iload 6
    //   3505: istore 8
    //   3507: iload 5
    //   3509: istore 11
    //   3511: new 199	org/json/JSONObject
    //   3514: dup
    //   3515: invokespecial 200	org/json/JSONObject:<init>	()V
    //   3518: astore 30
    //   3520: iload 7
    //   3522: istore 16
    //   3524: iload 6
    //   3526: istore 9
    //   3528: iload 5
    //   3530: istore 10
    //   3532: iload 6
    //   3534: istore 8
    //   3536: iload 5
    //   3538: istore 11
    //   3540: aload 30
    //   3542: ldc_w 397
    //   3545: aload 29
    //   3547: iconst_0
    //   3548: aaload
    //   3549: invokestatic 379	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   3552: invokevirtual 383	java/lang/Long:longValue	()J
    //   3555: ldc2_w 384
    //   3558: ldiv
    //   3559: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   3562: pop
    //   3563: iload 7
    //   3565: istore 16
    //   3567: iload 6
    //   3569: istore 9
    //   3571: iload 5
    //   3573: istore 10
    //   3575: iload 6
    //   3577: istore 8
    //   3579: iload 5
    //   3581: istore 11
    //   3583: aload 30
    //   3585: ldc_w 476
    //   3588: aload 29
    //   3590: iconst_1
    //   3591: aaload
    //   3592: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3595: pop
    //   3596: iload 7
    //   3598: istore 16
    //   3600: iload 6
    //   3602: istore 9
    //   3604: iload 5
    //   3606: istore 10
    //   3608: iload 6
    //   3610: istore 8
    //   3612: iload 5
    //   3614: istore 11
    //   3616: aload 27
    //   3618: aload 30
    //   3620: invokevirtual 402	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   3623: pop
    //   3624: goto +2460 -> 6084
    //   3627: iload 7
    //   3629: istore 16
    //   3631: iload 6
    //   3633: istore 9
    //   3635: iload 5
    //   3637: istore 10
    //   3639: iload 6
    //   3641: istore 8
    //   3643: iload 5
    //   3645: istore 11
    //   3647: aload 28
    //   3649: ldc_w 497
    //   3652: aload 29
    //   3654: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3657: pop
    //   3658: goto -361 -> 3297
    //   3661: iload 7
    //   3663: istore 16
    //   3665: iload 6
    //   3667: istore 9
    //   3669: iload 5
    //   3671: istore 10
    //   3673: iload 6
    //   3675: istore 8
    //   3677: iload 5
    //   3679: istore 11
    //   3681: aload 19
    //   3683: aload 28
    //   3685: invokevirtual 402	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   3688: pop
    //   3689: iload 15
    //   3691: istore 12
    //   3693: goto -3452 -> 241
    //   3696: iload 7
    //   3698: istore 16
    //   3700: iload 6
    //   3702: istore 9
    //   3704: iload 5
    //   3706: istore 10
    //   3708: iload 6
    //   3710: istore 8
    //   3712: iload 5
    //   3714: istore 11
    //   3716: aload 27
    //   3718: ldc_w 499
    //   3721: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3724: ifne +96 -> 3820
    //   3727: iload 7
    //   3729: istore 16
    //   3731: iload 6
    //   3733: istore 9
    //   3735: iload 5
    //   3737: istore 10
    //   3739: iload 6
    //   3741: istore 8
    //   3743: iload 5
    //   3745: istore 11
    //   3747: aload 27
    //   3749: ldc_w 501
    //   3752: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3755: ifne +65 -> 3820
    //   3758: iload 7
    //   3760: istore 16
    //   3762: iload 6
    //   3764: istore 9
    //   3766: iload 5
    //   3768: istore 10
    //   3770: iload 6
    //   3772: istore 8
    //   3774: iload 5
    //   3776: istore 11
    //   3778: aload 27
    //   3780: ldc_w 503
    //   3783: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3786: ifne +34 -> 3820
    //   3789: iload 7
    //   3791: istore 16
    //   3793: iload 6
    //   3795: istore 9
    //   3797: iload 5
    //   3799: istore 10
    //   3801: iload 6
    //   3803: istore 8
    //   3805: iload 5
    //   3807: istore 11
    //   3809: aload 27
    //   3811: ldc_w 505
    //   3814: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3817: ifeq +501 -> 4318
    //   3820: iload 7
    //   3822: istore 16
    //   3824: iload 6
    //   3826: istore 9
    //   3828: iload 5
    //   3830: istore 10
    //   3832: iload 6
    //   3834: istore 8
    //   3836: iload 5
    //   3838: istore 11
    //   3840: new 199	org/json/JSONObject
    //   3843: dup
    //   3844: invokespecial 200	org/json/JSONObject:<init>	()V
    //   3847: astore 28
    //   3849: iload 7
    //   3851: istore 16
    //   3853: iload 6
    //   3855: istore 9
    //   3857: iload 5
    //   3859: istore 10
    //   3861: iload 6
    //   3863: istore 8
    //   3865: iload 5
    //   3867: istore 11
    //   3869: aload 28
    //   3871: ldc_w 476
    //   3874: aload 26
    //   3876: iconst_2
    //   3877: aaload
    //   3878: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3881: pop
    //   3882: iload 7
    //   3884: istore 16
    //   3886: iload 6
    //   3888: istore 9
    //   3890: iload 5
    //   3892: istore 10
    //   3894: iload 6
    //   3896: istore 8
    //   3898: iload 5
    //   3900: istore 11
    //   3902: aload 28
    //   3904: ldc_w 397
    //   3907: iload 17
    //   3909: invokevirtual 225	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   3912: pop
    //   3913: iload 7
    //   3915: istore 16
    //   3917: iload 6
    //   3919: istore 9
    //   3921: iload 5
    //   3923: istore 10
    //   3925: iload 6
    //   3927: istore 8
    //   3929: iload 5
    //   3931: istore 11
    //   3933: aload 28
    //   3935: ldc_w 507
    //   3938: aload 26
    //   3940: iconst_3
    //   3941: aaload
    //   3942: invokestatic 379	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   3945: invokevirtual 383	java/lang/Long:longValue	()J
    //   3948: ldc2_w 384
    //   3951: ldiv
    //   3952: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   3955: pop
    //   3956: iload 7
    //   3958: istore 16
    //   3960: iload 6
    //   3962: istore 9
    //   3964: iload 5
    //   3966: istore 10
    //   3968: iload 6
    //   3970: istore 8
    //   3972: iload 5
    //   3974: istore 11
    //   3976: aload 28
    //   3978: ldc_w 509
    //   3981: aload 26
    //   3983: iconst_4
    //   3984: aaload
    //   3985: invokestatic 379	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   3988: invokevirtual 383	java/lang/Long:longValue	()J
    //   3991: ldc2_w 384
    //   3994: ldiv
    //   3995: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   3998: pop
    //   3999: iload 7
    //   4001: istore 16
    //   4003: iload 6
    //   4005: istore 9
    //   4007: iload 5
    //   4009: istore 10
    //   4011: iload 6
    //   4013: istore 8
    //   4015: iload 5
    //   4017: istore 11
    //   4019: aload 19
    //   4021: aload 28
    //   4023: invokevirtual 402	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   4026: pop
    //   4027: iload 15
    //   4029: istore 12
    //   4031: iload 7
    //   4033: istore 16
    //   4035: iload 6
    //   4037: istore 9
    //   4039: iload 5
    //   4041: istore 10
    //   4043: iload 6
    //   4045: istore 8
    //   4047: iload 5
    //   4049: istore 11
    //   4051: aload 24
    //   4053: new 135	java/lang/StringBuilder
    //   4056: dup
    //   4057: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   4060: aload 27
    //   4062: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4065: ldc_w 478
    //   4068: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4071: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4074: invokevirtual 407	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   4077: ifne -3836 -> 241
    //   4080: iload 7
    //   4082: istore 16
    //   4084: iload 6
    //   4086: istore 9
    //   4088: iload 5
    //   4090: istore 10
    //   4092: iload 6
    //   4094: istore 8
    //   4096: iload 5
    //   4098: istore 11
    //   4100: aload 24
    //   4102: new 135	java/lang/StringBuilder
    //   4105: dup
    //   4106: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   4109: aload 27
    //   4111: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4114: ldc_w 478
    //   4117: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4120: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4123: aload 26
    //   4125: iconst_2
    //   4126: aaload
    //   4127: invokevirtual 412	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4130: pop
    //   4131: iload 7
    //   4133: istore 16
    //   4135: iload 6
    //   4137: istore 9
    //   4139: iload 5
    //   4141: istore 10
    //   4143: iload 6
    //   4145: istore 8
    //   4147: iload 5
    //   4149: istore 11
    //   4151: aload 24
    //   4153: new 135	java/lang/StringBuilder
    //   4156: dup
    //   4157: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   4160: aload 27
    //   4162: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4165: ldc_w 409
    //   4168: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4171: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4174: iload 17
    //   4176: invokestatic 307	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   4179: invokevirtual 412	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4182: pop
    //   4183: iload 7
    //   4185: istore 16
    //   4187: iload 6
    //   4189: istore 9
    //   4191: iload 5
    //   4193: istore 10
    //   4195: iload 6
    //   4197: istore 8
    //   4199: iload 5
    //   4201: istore 11
    //   4203: aload 24
    //   4205: new 135	java/lang/StringBuilder
    //   4208: dup
    //   4209: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   4212: aload 27
    //   4214: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4217: ldc_w 511
    //   4220: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4223: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4226: aload 26
    //   4228: iconst_3
    //   4229: aaload
    //   4230: invokestatic 379	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   4233: invokevirtual 383	java/lang/Long:longValue	()J
    //   4236: ldc2_w 384
    //   4239: ldiv
    //   4240: invokestatic 514	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4243: invokevirtual 412	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4246: pop
    //   4247: iload 7
    //   4249: istore 16
    //   4251: iload 6
    //   4253: istore 9
    //   4255: iload 5
    //   4257: istore 10
    //   4259: iload 6
    //   4261: istore 8
    //   4263: iload 5
    //   4265: istore 11
    //   4267: aload 24
    //   4269: new 135	java/lang/StringBuilder
    //   4272: dup
    //   4273: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   4276: aload 27
    //   4278: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4281: ldc_w 516
    //   4284: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4287: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4290: aload 26
    //   4292: iconst_4
    //   4293: aaload
    //   4294: invokestatic 379	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   4297: invokevirtual 383	java/lang/Long:longValue	()J
    //   4300: ldc2_w 384
    //   4303: ldiv
    //   4304: invokestatic 514	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4307: invokevirtual 412	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4310: pop
    //   4311: iload 15
    //   4313: istore 12
    //   4315: goto -4074 -> 241
    //   4318: iload 7
    //   4320: istore 16
    //   4322: iload 6
    //   4324: istore 9
    //   4326: iload 5
    //   4328: istore 10
    //   4330: iload 6
    //   4332: istore 8
    //   4334: iload 5
    //   4336: istore 11
    //   4338: aload 27
    //   4340: ldc_w 518
    //   4343: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4346: ifne +96 -> 4442
    //   4349: iload 7
    //   4351: istore 16
    //   4353: iload 6
    //   4355: istore 9
    //   4357: iload 5
    //   4359: istore 10
    //   4361: iload 6
    //   4363: istore 8
    //   4365: iload 5
    //   4367: istore 11
    //   4369: aload 27
    //   4371: ldc_w 520
    //   4374: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4377: ifne +65 -> 4442
    //   4380: iload 7
    //   4382: istore 16
    //   4384: iload 6
    //   4386: istore 9
    //   4388: iload 5
    //   4390: istore 10
    //   4392: iload 6
    //   4394: istore 8
    //   4396: iload 5
    //   4398: istore 11
    //   4400: aload 27
    //   4402: ldc_w 522
    //   4405: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4408: ifne +34 -> 4442
    //   4411: iload 7
    //   4413: istore 16
    //   4415: iload 6
    //   4417: istore 9
    //   4419: iload 5
    //   4421: istore 10
    //   4423: iload 6
    //   4425: istore 8
    //   4427: iload 5
    //   4429: istore 11
    //   4431: aload 27
    //   4433: ldc_w 524
    //   4436: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4439: ifeq +539 -> 4978
    //   4442: iload 7
    //   4444: istore 16
    //   4446: iload 6
    //   4448: istore 9
    //   4450: iload 5
    //   4452: istore 10
    //   4454: iload 6
    //   4456: istore 8
    //   4458: iload 5
    //   4460: istore 11
    //   4462: new 199	org/json/JSONObject
    //   4465: dup
    //   4466: invokespecial 200	org/json/JSONObject:<init>	()V
    //   4469: astore 27
    //   4471: iload 7
    //   4473: istore 16
    //   4475: iload 6
    //   4477: istore 9
    //   4479: iload 5
    //   4481: istore 10
    //   4483: iload 6
    //   4485: istore 8
    //   4487: iload 5
    //   4489: istore 11
    //   4491: aload 27
    //   4493: ldc_w 397
    //   4496: iload 17
    //   4498: invokevirtual 225	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   4501: pop
    //   4502: iload 7
    //   4504: istore 16
    //   4506: iload 6
    //   4508: istore 9
    //   4510: iload 5
    //   4512: istore 10
    //   4514: iload 6
    //   4516: istore 8
    //   4518: iload 5
    //   4520: istore 11
    //   4522: aload 27
    //   4524: ldc_w 526
    //   4527: aload 26
    //   4529: iconst_2
    //   4530: aaload
    //   4531: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4534: pop
    //   4535: iload 7
    //   4537: istore 16
    //   4539: iload 6
    //   4541: istore 9
    //   4543: iload 5
    //   4545: istore 10
    //   4547: iload 6
    //   4549: istore 8
    //   4551: iload 5
    //   4553: istore 11
    //   4555: aload 27
    //   4557: ldc_w 528
    //   4560: aload 26
    //   4562: iconst_3
    //   4563: aaload
    //   4564: ldc_w 530
    //   4567: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4570: invokevirtual 533	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4573: pop
    //   4574: iload 7
    //   4576: istore 16
    //   4578: iload 6
    //   4580: istore 9
    //   4582: iload 5
    //   4584: istore 10
    //   4586: iload 6
    //   4588: istore 8
    //   4590: iload 5
    //   4592: istore 11
    //   4594: aload 27
    //   4596: ldc_w 535
    //   4599: aload 26
    //   4601: iconst_4
    //   4602: aaload
    //   4603: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4606: pop
    //   4607: iload 7
    //   4609: istore 16
    //   4611: iload 6
    //   4613: istore 9
    //   4615: iload 5
    //   4617: istore 10
    //   4619: iload 6
    //   4621: istore 8
    //   4623: iload 5
    //   4625: istore 11
    //   4627: new 375	org/json/JSONArray
    //   4630: dup
    //   4631: invokespecial 376	org/json/JSONArray:<init>	()V
    //   4634: astore 28
    //   4636: iload 7
    //   4638: istore 16
    //   4640: iload 6
    //   4642: istore 9
    //   4644: iload 5
    //   4646: istore 10
    //   4648: iload 6
    //   4650: istore 8
    //   4652: iload 5
    //   4654: istore 11
    //   4656: aload 27
    //   4658: ldc_w 492
    //   4661: aload 28
    //   4663: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4666: pop
    //   4667: iload 7
    //   4669: istore 16
    //   4671: iload 6
    //   4673: istore 9
    //   4675: iload 5
    //   4677: istore 10
    //   4679: iload 6
    //   4681: istore 8
    //   4683: iload 5
    //   4685: istore 11
    //   4687: aload 26
    //   4689: iconst_5
    //   4690: aaload
    //   4691: ldc 119
    //   4693: invokevirtual 363	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   4696: astore 26
    //   4698: iload 7
    //   4700: istore 16
    //   4702: iload 6
    //   4704: istore 9
    //   4706: iload 5
    //   4708: istore 10
    //   4710: iload 6
    //   4712: istore 8
    //   4714: iload 5
    //   4716: istore 11
    //   4718: aload 26
    //   4720: arraylength
    //   4721: istore 13
    //   4723: iconst_0
    //   4724: istore 12
    //   4726: iload 12
    //   4728: iload 13
    //   4730: if_icmpge +213 -> 4943
    //   4733: iload 7
    //   4735: istore 16
    //   4737: iload 6
    //   4739: istore 9
    //   4741: iload 5
    //   4743: istore 10
    //   4745: iload 6
    //   4747: istore 8
    //   4749: iload 5
    //   4751: istore 11
    //   4753: aload 26
    //   4755: iload 12
    //   4757: aaload
    //   4758: ldc 176
    //   4760: invokevirtual 363	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   4763: astore 29
    //   4765: aload 29
    //   4767: ifnull +1326 -> 6093
    //   4770: iload 7
    //   4772: istore 16
    //   4774: iload 6
    //   4776: istore 9
    //   4778: iload 5
    //   4780: istore 10
    //   4782: iload 6
    //   4784: istore 8
    //   4786: iload 5
    //   4788: istore 11
    //   4790: aload 29
    //   4792: arraylength
    //   4793: iconst_1
    //   4794: if_icmple +1299 -> 6093
    //   4797: iload 7
    //   4799: istore 16
    //   4801: iload 6
    //   4803: istore 9
    //   4805: iload 5
    //   4807: istore 10
    //   4809: iload 6
    //   4811: istore 8
    //   4813: iload 5
    //   4815: istore 11
    //   4817: new 199	org/json/JSONObject
    //   4820: dup
    //   4821: invokespecial 200	org/json/JSONObject:<init>	()V
    //   4824: astore 30
    //   4826: iload 7
    //   4828: istore 16
    //   4830: iload 6
    //   4832: istore 9
    //   4834: iload 5
    //   4836: istore 10
    //   4838: iload 6
    //   4840: istore 8
    //   4842: iload 5
    //   4844: istore 11
    //   4846: aload 30
    //   4848: ldc_w 397
    //   4851: aload 29
    //   4853: iconst_0
    //   4854: aaload
    //   4855: invokestatic 379	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   4858: invokevirtual 383	java/lang/Long:longValue	()J
    //   4861: ldc2_w 384
    //   4864: ldiv
    //   4865: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   4868: pop
    //   4869: iload 7
    //   4871: istore 16
    //   4873: iload 6
    //   4875: istore 9
    //   4877: iload 5
    //   4879: istore 10
    //   4881: iload 6
    //   4883: istore 8
    //   4885: iload 5
    //   4887: istore 11
    //   4889: aload 30
    //   4891: ldc_w 537
    //   4894: aload 29
    //   4896: iconst_1
    //   4897: aaload
    //   4898: invokestatic 379	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   4901: invokevirtual 383	java/lang/Long:longValue	()J
    //   4904: ldc2_w 384
    //   4907: ldiv
    //   4908: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   4911: pop
    //   4912: iload 7
    //   4914: istore 16
    //   4916: iload 6
    //   4918: istore 9
    //   4920: iload 5
    //   4922: istore 10
    //   4924: iload 6
    //   4926: istore 8
    //   4928: iload 5
    //   4930: istore 11
    //   4932: aload 28
    //   4934: aload 30
    //   4936: invokevirtual 402	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   4939: pop
    //   4940: goto +1153 -> 6093
    //   4943: iload 7
    //   4945: istore 16
    //   4947: iload 6
    //   4949: istore 9
    //   4951: iload 5
    //   4953: istore 10
    //   4955: iload 6
    //   4957: istore 8
    //   4959: iload 5
    //   4961: istore 11
    //   4963: aload 19
    //   4965: aload 27
    //   4967: invokevirtual 402	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   4970: pop
    //   4971: iload 15
    //   4973: istore 12
    //   4975: goto -4734 -> 241
    //   4978: iload 7
    //   4980: istore 16
    //   4982: iload 6
    //   4984: istore 9
    //   4986: iload 5
    //   4988: istore 10
    //   4990: iload 6
    //   4992: istore 8
    //   4994: iload 5
    //   4996: istore 11
    //   4998: aload 27
    //   5000: ldc_w 539
    //   5003: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5006: ifne +65 -> 5071
    //   5009: iload 7
    //   5011: istore 16
    //   5013: iload 6
    //   5015: istore 9
    //   5017: iload 5
    //   5019: istore 10
    //   5021: iload 6
    //   5023: istore 8
    //   5025: iload 5
    //   5027: istore 11
    //   5029: aload 27
    //   5031: ldc_w 541
    //   5034: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5037: ifne +34 -> 5071
    //   5040: iload 7
    //   5042: istore 16
    //   5044: iload 6
    //   5046: istore 9
    //   5048: iload 5
    //   5050: istore 10
    //   5052: iload 6
    //   5054: istore 8
    //   5056: iload 5
    //   5058: istore 11
    //   5060: aload 27
    //   5062: ldc_w 543
    //   5065: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5068: ifeq +257 -> 5325
    //   5071: iload 15
    //   5073: istore 12
    //   5075: iload 7
    //   5077: bipush 10
    //   5079: if_icmpgt -4838 -> 241
    //   5082: iload 7
    //   5084: iconst_1
    //   5085: iadd
    //   5086: istore 7
    //   5088: iload 7
    //   5090: istore 16
    //   5092: iload 6
    //   5094: istore 9
    //   5096: iload 5
    //   5098: istore 10
    //   5100: iload 6
    //   5102: istore 8
    //   5104: iload 5
    //   5106: istore 11
    //   5108: new 199	org/json/JSONObject
    //   5111: dup
    //   5112: invokespecial 200	org/json/JSONObject:<init>	()V
    //   5115: astore 27
    //   5117: iload 7
    //   5119: istore 16
    //   5121: iload 6
    //   5123: istore 9
    //   5125: iload 5
    //   5127: istore 10
    //   5129: iload 6
    //   5131: istore 8
    //   5133: iload 5
    //   5135: istore 11
    //   5137: aload 27
    //   5139: ldc_w 526
    //   5142: aload 26
    //   5144: iconst_3
    //   5145: aaload
    //   5146: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   5149: pop
    //   5150: iload 7
    //   5152: istore 16
    //   5154: iload 6
    //   5156: istore 9
    //   5158: iload 5
    //   5160: istore 10
    //   5162: iload 6
    //   5164: istore 8
    //   5166: iload 5
    //   5168: istore 11
    //   5170: aload 27
    //   5172: ldc_w 535
    //   5175: aload 26
    //   5177: iconst_2
    //   5178: aaload
    //   5179: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   5182: pop
    //   5183: iload 7
    //   5185: istore 16
    //   5187: iload 6
    //   5189: istore 9
    //   5191: iload 5
    //   5193: istore 10
    //   5195: iload 6
    //   5197: istore 8
    //   5199: iload 5
    //   5201: istore 11
    //   5203: aload 27
    //   5205: ldc_w 545
    //   5208: aload 26
    //   5210: iconst_4
    //   5211: aaload
    //   5212: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   5215: pop
    //   5216: iload 7
    //   5218: istore 16
    //   5220: iload 6
    //   5222: istore 9
    //   5224: iload 5
    //   5226: istore 10
    //   5228: iload 6
    //   5230: istore 8
    //   5232: iload 5
    //   5234: istore 11
    //   5236: aload 27
    //   5238: ldc_w 397
    //   5241: iload 17
    //   5243: invokevirtual 225	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   5246: pop
    //   5247: iload 7
    //   5249: istore 16
    //   5251: iload 6
    //   5253: istore 9
    //   5255: iload 5
    //   5257: istore 10
    //   5259: iload 6
    //   5261: istore 8
    //   5263: iload 5
    //   5265: istore 11
    //   5267: aload 27
    //   5269: ldc_w 537
    //   5272: aload 26
    //   5274: iconst_5
    //   5275: aaload
    //   5276: invokestatic 379	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   5279: invokevirtual 383	java/lang/Long:longValue	()J
    //   5282: ldc2_w 384
    //   5285: ldiv
    //   5286: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   5289: pop
    //   5290: iload 7
    //   5292: istore 16
    //   5294: iload 6
    //   5296: istore 9
    //   5298: iload 5
    //   5300: istore 10
    //   5302: iload 6
    //   5304: istore 8
    //   5306: iload 5
    //   5308: istore 11
    //   5310: aload 19
    //   5312: aload 27
    //   5314: invokevirtual 402	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   5317: pop
    //   5318: iload 15
    //   5320: istore 12
    //   5322: goto -5081 -> 241
    //   5325: iload 7
    //   5327: istore 16
    //   5329: iload 6
    //   5331: istore 9
    //   5333: iload 5
    //   5335: istore 10
    //   5337: iload 6
    //   5339: istore 8
    //   5341: iload 5
    //   5343: istore 11
    //   5345: aload 27
    //   5347: ldc_w 547
    //   5350: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5353: ifne +162 -> 5515
    //   5356: iload 7
    //   5358: istore 16
    //   5360: iload 6
    //   5362: istore 9
    //   5364: iload 5
    //   5366: istore 10
    //   5368: iload 6
    //   5370: istore 8
    //   5372: iload 5
    //   5374: istore 11
    //   5376: aload 27
    //   5378: ldc_w 549
    //   5381: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5384: ifne +131 -> 5515
    //   5387: iload 7
    //   5389: istore 16
    //   5391: iload 6
    //   5393: istore 9
    //   5395: iload 5
    //   5397: istore 10
    //   5399: iload 6
    //   5401: istore 8
    //   5403: iload 5
    //   5405: istore 11
    //   5407: aload 27
    //   5409: ldc_w 551
    //   5412: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5415: ifne +100 -> 5515
    //   5418: iload 7
    //   5420: istore 16
    //   5422: iload 6
    //   5424: istore 9
    //   5426: iload 5
    //   5428: istore 10
    //   5430: iload 6
    //   5432: istore 8
    //   5434: iload 5
    //   5436: istore 11
    //   5438: aload 27
    //   5440: ldc_w 553
    //   5443: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5446: ifne +69 -> 5515
    //   5449: iload 7
    //   5451: istore 16
    //   5453: iload 6
    //   5455: istore 9
    //   5457: iload 5
    //   5459: istore 10
    //   5461: iload 6
    //   5463: istore 8
    //   5465: iload 5
    //   5467: istore 11
    //   5469: aload 27
    //   5471: ldc_w 555
    //   5474: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5477: ifne +38 -> 5515
    //   5480: iload 15
    //   5482: istore 12
    //   5484: iload 7
    //   5486: istore 16
    //   5488: iload 6
    //   5490: istore 9
    //   5492: iload 5
    //   5494: istore 10
    //   5496: iload 6
    //   5498: istore 8
    //   5500: iload 5
    //   5502: istore 11
    //   5504: aload 27
    //   5506: ldc_w 557
    //   5509: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5512: ifeq -5271 -> 241
    //   5515: iload 7
    //   5517: istore 16
    //   5519: iload 6
    //   5521: istore 9
    //   5523: iload 5
    //   5525: istore 10
    //   5527: iload 6
    //   5529: istore 8
    //   5531: iload 5
    //   5533: istore 11
    //   5535: new 199	org/json/JSONObject
    //   5538: dup
    //   5539: invokespecial 200	org/json/JSONObject:<init>	()V
    //   5542: astore 27
    //   5544: iload 7
    //   5546: istore 16
    //   5548: iload 6
    //   5550: istore 9
    //   5552: iload 5
    //   5554: istore 10
    //   5556: iload 6
    //   5558: istore 8
    //   5560: iload 5
    //   5562: istore 11
    //   5564: aload 27
    //   5566: ldc_w 526
    //   5569: aload 26
    //   5571: iconst_2
    //   5572: aaload
    //   5573: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   5576: pop
    //   5577: iload 7
    //   5579: istore 16
    //   5581: iload 6
    //   5583: istore 9
    //   5585: iload 5
    //   5587: istore 10
    //   5589: iload 6
    //   5591: istore 8
    //   5593: iload 5
    //   5595: istore 11
    //   5597: new 375	org/json/JSONArray
    //   5600: dup
    //   5601: invokespecial 376	org/json/JSONArray:<init>	()V
    //   5604: astore 28
    //   5606: iload 7
    //   5608: istore 16
    //   5610: iload 6
    //   5612: istore 9
    //   5614: iload 5
    //   5616: istore 10
    //   5618: iload 6
    //   5620: istore 8
    //   5622: iload 5
    //   5624: istore 11
    //   5626: aload 27
    //   5628: ldc_w 559
    //   5631: aload 28
    //   5633: invokevirtual 215	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   5636: pop
    //   5637: iload 7
    //   5639: istore 16
    //   5641: iload 6
    //   5643: istore 9
    //   5645: iload 5
    //   5647: istore 10
    //   5649: iload 6
    //   5651: istore 8
    //   5653: iload 5
    //   5655: istore 11
    //   5657: aload 26
    //   5659: iconst_3
    //   5660: aaload
    //   5661: ldc 119
    //   5663: invokevirtual 363	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   5666: astore 26
    //   5668: iload 7
    //   5670: istore 16
    //   5672: iload 6
    //   5674: istore 9
    //   5676: iload 5
    //   5678: istore 10
    //   5680: iload 6
    //   5682: istore 8
    //   5684: iload 5
    //   5686: istore 11
    //   5688: aload 26
    //   5690: arraylength
    //   5691: istore 13
    //   5693: iconst_0
    //   5694: istore 12
    //   5696: iload 12
    //   5698: iload 13
    //   5700: if_icmpge +53 -> 5753
    //   5703: iload 7
    //   5705: istore 16
    //   5707: iload 6
    //   5709: istore 9
    //   5711: iload 5
    //   5713: istore 10
    //   5715: iload 6
    //   5717: istore 8
    //   5719: iload 5
    //   5721: istore 11
    //   5723: aload 28
    //   5725: aload 26
    //   5727: iload 12
    //   5729: aaload
    //   5730: invokestatic 379	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   5733: invokevirtual 383	java/lang/Long:longValue	()J
    //   5736: ldc2_w 384
    //   5739: ldiv
    //   5740: invokevirtual 562	org/json/JSONArray:put	(J)Lorg/json/JSONArray;
    //   5743: pop
    //   5744: iload 12
    //   5746: iconst_1
    //   5747: iadd
    //   5748: istore 12
    //   5750: goto -54 -> 5696
    //   5753: iload 7
    //   5755: istore 16
    //   5757: iload 6
    //   5759: istore 9
    //   5761: iload 5
    //   5763: istore 10
    //   5765: iload 6
    //   5767: istore 8
    //   5769: iload 5
    //   5771: istore 11
    //   5773: aload 19
    //   5775: aload 27
    //   5777: invokevirtual 402	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   5780: pop
    //   5781: iload 15
    //   5783: istore 12
    //   5785: goto -5544 -> 241
    //   5788: astore 19
    //   5790: iload 10
    //   5792: istore 8
    //   5794: iload 5
    //   5796: istore 9
    //   5798: iload 6
    //   5800: istore 5
    //   5802: iload 9
    //   5804: istore 6
    //   5806: goto -5462 -> 344
    //   5809: astore 19
    //   5811: iload 5
    //   5813: istore 9
    //   5815: iload 6
    //   5817: istore 5
    //   5819: iload 9
    //   5821: istore 6
    //   5823: goto -5479 -> 344
    //   5826: iload 6
    //   5828: istore 9
    //   5830: iload 5
    //   5832: istore 6
    //   5834: iload 9
    //   5836: istore 5
    //   5838: iload 7
    //   5840: istore 10
    //   5842: iload 8
    //   5844: istore 7
    //   5846: goto -5680 -> 166
    //   5849: astore 20
    //   5851: ldc 190
    //   5853: iconst_1
    //   5854: new 135	java/lang/StringBuilder
    //   5857: dup
    //   5858: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   5861: ldc_w 564
    //   5864: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5867: lconst_0
    //   5868: invokevirtual 567	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5871: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5874: invokestatic 422	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5877: lconst_0
    //   5878: lstore_1
    //   5879: goto -5372 -> 507
    //   5882: astore 19
    //   5884: invokestatic 425	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5887: ifeq -5349 -> 538
    //   5890: ldc 190
    //   5892: iconst_2
    //   5893: ldc 132
    //   5895: aload 19
    //   5897: invokestatic 428	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   5900: goto -5362 -> 538
    //   5903: astore 19
    //   5905: goto -5595 -> 310
    //   5908: astore 20
    //   5910: goto -4330 -> 1580
    //   5913: astore 21
    //   5915: goto -3562 -> 2353
    //   5918: astore 20
    //   5920: goto -3549 -> 2371
    //   5923: astore 19
    //   5925: iload 6
    //   5927: istore 7
    //   5929: iload 5
    //   5931: istore 8
    //   5933: goto -3545 -> 2388
    //   5936: astore 19
    //   5938: aconst_null
    //   5939: astore 21
    //   5941: aconst_null
    //   5942: astore 20
    //   5944: goto -3609 -> 2335
    //   5947: astore 19
    //   5949: aconst_null
    //   5950: astore 20
    //   5952: goto -3617 -> 2335
    //   5955: astore 23
    //   5957: aload 19
    //   5959: astore 21
    //   5961: aload 20
    //   5963: astore 22
    //   5965: aload 23
    //   5967: astore 19
    //   5969: aload 21
    //   5971: astore 20
    //   5973: aload 22
    //   5975: astore 21
    //   5977: goto -3642 -> 2335
    //   5980: astore 21
    //   5982: aconst_null
    //   5983: astore 19
    //   5985: aconst_null
    //   5986: astore 20
    //   5988: iload 7
    //   5990: istore 8
    //   5992: iload 10
    //   5994: istore 7
    //   5996: goto -4442 -> 1554
    //   5999: astore 22
    //   6001: iload 7
    //   6003: istore 8
    //   6005: aconst_null
    //   6006: astore 19
    //   6008: iload 10
    //   6010: istore 7
    //   6012: aload 21
    //   6014: astore 20
    //   6016: aload 22
    //   6018: astore 21
    //   6020: goto -4466 -> 1554
    //   6023: lconst_0
    //   6024: lstore_1
    //   6025: goto -5518 -> 507
    //   6028: iload 5
    //   6030: istore 9
    //   6032: iload 6
    //   6034: istore 5
    //   6036: iload 9
    //   6038: istore 6
    //   6040: goto -5696 -> 344
    //   6043: iload 10
    //   6045: istore 8
    //   6047: iload 5
    //   6049: istore 9
    //   6051: iload 6
    //   6053: istore 5
    //   6055: iload 9
    //   6057: istore 6
    //   6059: goto -5715 -> 344
    //   6062: iload 12
    //   6064: istore 10
    //   6066: goto -5774 -> 292
    //   6069: iload 5
    //   6071: istore 7
    //   6073: iload 6
    //   6075: istore 5
    //   6077: iload 7
    //   6079: istore 6
    //   6081: goto -5725 -> 356
    //   6084: iload 12
    //   6086: iconst_1
    //   6087: iadd
    //   6088: istore 12
    //   6090: goto -2670 -> 3420
    //   6093: iload 12
    //   6095: iconst_1
    //   6096: iadd
    //   6097: istore 12
    //   6099: goto -1373 -> 4726
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6102	0	this	BatteryStatsImpl
    //   0	6102	1	paramLong1	long
    //   0	6102	3	paramLong2	long
    //   37	6039	5	i	int
    //   43	6037	6	j	int
    //   144	5934	7	k	int
    //   62	5984	8	m	int
    //   58	5998	9	n	int
    //   147	5918	10	i1	int
    //   34	5738	11	i2	int
    //   40	6058	12	i3	int
    //   251	5450	13	i4	int
    //   255	1453	14	i5	int
    //   281	5501	15	i6	int
    //   610	5146	16	i7	int
    //   247	4995	17	i8	int
    //   243	1284	18	i9	int
    //   8	1117	19	localObject1	Object
    //   1452	1	19	localException1	Exception
    //   1536	97	19	localObject2	Object
    //   1689	313	19	localException2	Exception
    //   2325	55	19	localObject3	Object
    //   2382	3392	19	localThrowable1	Throwable
    //   5788	1	19	localException3	Exception
    //   5809	1	19	localException4	Exception
    //   5882	14	19	localException5	Exception
    //   5903	1	19	localException6	Exception
    //   5923	1	19	localThrowable2	Throwable
    //   5936	1	19	localObject4	Object
    //   5947	11	19	localObject5	Object
    //   5967	40	19	localObject6	Object
    //   231	2136	20	localObject7	Object
    //   5849	1	20	localException7	Exception
    //   5908	1	20	localException8	Exception
    //   5918	1	20	localException9	Exception
    //   5942	73	20	localObject8	Object
    //   213	2136	21	localObject9	Object
    //   5913	1	21	localException10	Exception
    //   5939	37	21	localObject10	Object
    //   5980	33	21	localException11	Exception
    //   6018	1	21	localObject11	Object
    //   270	1225	22	str	String
    //   1524	27	22	localException12	Exception
    //   5963	11	22	localObject12	Object
    //   5999	18	22	localException13	Exception
    //   164	29	23	localIterator	Iterator
    //   5955	11	23	localObject13	Object
    //   54	4214	24	localHashMap	java.util.HashMap
    //   31	1595	25	localJSONObject1	JSONObject
    //   600	5126	26	arrayOfString	String[]
    //   606	5170	27	localObject14	Object
    //   946	4778	28	localObject15	Object
    //   3202	1693	29	localObject16	Object
    //   3518	1417	30	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   628	639	1452	java/lang/Exception
    //   669	680	1452	java/lang/Exception
    //   710	720	1452	java/lang/Exception
    //   740	749	1452	java/lang/Exception
    //   769	779	1452	java/lang/Exception
    //   799	816	1452	java/lang/Exception
    //   836	847	1452	java/lang/Exception
    //   867	878	1452	java/lang/Exception
    //   898	909	1452	java/lang/Exception
    //   939	948	1452	java/lang/Exception
    //   968	981	1452	java/lang/Exception
    //   1001	1013	1452	java/lang/Exception
    //   1033	1044	1452	java/lang/Exception
    //   1064	1071	1452	java/lang/Exception
    //   1091	1104	1452	java/lang/Exception
    //   1124	1132	1452	java/lang/Exception
    //   1164	1193	1452	java/lang/Exception
    //   1213	1245	1452	java/lang/Exception
    //   1265	1296	1452	java/lang/Exception
    //   1316	1347	1452	java/lang/Exception
    //   1405	1437	1452	java/lang/Exception
    //   1625	1634	1452	java/lang/Exception
    //   1665	1676	1452	java/lang/Exception
    //   1711	1721	1452	java/lang/Exception
    //   1747	1758	1452	java/lang/Exception
    //   1778	1789	1452	java/lang/Exception
    //   1809	1818	1452	java/lang/Exception
    //   1838	1849	1452	java/lang/Exception
    //   1869	1882	1452	java/lang/Exception
    //   1902	1915	1452	java/lang/Exception
    //   1935	1948	1452	java/lang/Exception
    //   1968	1981	1452	java/lang/Exception
    //   2001	2009	1452	java/lang/Exception
    //   2033	2062	1452	java/lang/Exception
    //   2082	2114	1452	java/lang/Exception
    //   2134	2165	1452	java/lang/Exception
    //   2185	2216	1452	java/lang/Exception
    //   2236	2267	1452	java/lang/Exception
    //   2287	2318	1452	java/lang/Exception
    //   2443	2454	1452	java/lang/Exception
    //   2474	2485	1452	java/lang/Exception
    //   2505	2516	1452	java/lang/Exception
    //   2536	2547	1452	java/lang/Exception
    //   2567	2578	1452	java/lang/Exception
    //   2598	2609	1452	java/lang/Exception
    //   2629	2640	1452	java/lang/Exception
    //   2660	2671	1452	java/lang/Exception
    //   2691	2702	1452	java/lang/Exception
    //   2722	2733	1452	java/lang/Exception
    //   2753	2762	1452	java/lang/Exception
    //   2782	2793	1452	java/lang/Exception
    //   2813	2826	1452	java/lang/Exception
    //   2846	2854	1452	java/lang/Exception
    //   2878	2907	1452	java/lang/Exception
    //   2927	2958	1452	java/lang/Exception
    //   2978	3010	1452	java/lang/Exception
    //   3037	3048	1452	java/lang/Exception
    //   3068	3079	1452	java/lang/Exception
    //   3099	3110	1452	java/lang/Exception
    //   3130	3141	1452	java/lang/Exception
    //   3161	3170	1452	java/lang/Exception
    //   3190	3204	1452	java/lang/Exception
    //   3224	3235	1452	java/lang/Exception
    //   3255	3266	1452	java/lang/Exception
    //   3286	3297	1452	java/lang/Exception
    //   3317	3326	1452	java/lang/Exception
    //   3346	3357	1452	java/lang/Exception
    //   3377	3392	1452	java/lang/Exception
    //   3412	3417	1452	java/lang/Exception
    //   3447	3459	1452	java/lang/Exception
    //   3484	3491	1452	java/lang/Exception
    //   3511	3520	1452	java/lang/Exception
    //   3540	3563	1452	java/lang/Exception
    //   3583	3596	1452	java/lang/Exception
    //   3616	3624	1452	java/lang/Exception
    //   3647	3658	1452	java/lang/Exception
    //   3681	3689	1452	java/lang/Exception
    //   3716	3727	1452	java/lang/Exception
    //   3747	3758	1452	java/lang/Exception
    //   3778	3789	1452	java/lang/Exception
    //   3809	3820	1452	java/lang/Exception
    //   3840	3849	1452	java/lang/Exception
    //   3869	3882	1452	java/lang/Exception
    //   3902	3913	1452	java/lang/Exception
    //   3933	3956	1452	java/lang/Exception
    //   3976	3999	1452	java/lang/Exception
    //   4019	4027	1452	java/lang/Exception
    //   4051	4080	1452	java/lang/Exception
    //   4100	4131	1452	java/lang/Exception
    //   4151	4183	1452	java/lang/Exception
    //   4203	4247	1452	java/lang/Exception
    //   4267	4311	1452	java/lang/Exception
    //   4338	4349	1452	java/lang/Exception
    //   4369	4380	1452	java/lang/Exception
    //   4400	4411	1452	java/lang/Exception
    //   4431	4442	1452	java/lang/Exception
    //   4462	4471	1452	java/lang/Exception
    //   4491	4502	1452	java/lang/Exception
    //   4522	4535	1452	java/lang/Exception
    //   4555	4574	1452	java/lang/Exception
    //   4594	4607	1452	java/lang/Exception
    //   4627	4636	1452	java/lang/Exception
    //   4656	4667	1452	java/lang/Exception
    //   4687	4698	1452	java/lang/Exception
    //   4718	4723	1452	java/lang/Exception
    //   4753	4765	1452	java/lang/Exception
    //   4790	4797	1452	java/lang/Exception
    //   4817	4826	1452	java/lang/Exception
    //   4846	4869	1452	java/lang/Exception
    //   4889	4912	1452	java/lang/Exception
    //   4932	4940	1452	java/lang/Exception
    //   4963	4971	1452	java/lang/Exception
    //   4998	5009	1452	java/lang/Exception
    //   5029	5040	1452	java/lang/Exception
    //   5060	5071	1452	java/lang/Exception
    //   5108	5117	1452	java/lang/Exception
    //   5137	5150	1452	java/lang/Exception
    //   5170	5183	1452	java/lang/Exception
    //   5203	5216	1452	java/lang/Exception
    //   5236	5247	1452	java/lang/Exception
    //   5267	5290	1452	java/lang/Exception
    //   5310	5318	1452	java/lang/Exception
    //   5345	5356	1452	java/lang/Exception
    //   5376	5387	1452	java/lang/Exception
    //   5407	5418	1452	java/lang/Exception
    //   5438	5449	1452	java/lang/Exception
    //   5469	5480	1452	java/lang/Exception
    //   5504	5515	1452	java/lang/Exception
    //   5535	5544	1452	java/lang/Exception
    //   5564	5577	1452	java/lang/Exception
    //   5597	5606	1452	java/lang/Exception
    //   5626	5637	1452	java/lang/Exception
    //   5657	5668	1452	java/lang/Exception
    //   5688	5693	1452	java/lang/Exception
    //   5723	5744	1452	java/lang/Exception
    //   5773	5781	1452	java/lang/Exception
    //   265	272	1524	java/lang/Exception
    //   592	602	1524	java/lang/Exception
    //   1478	1505	1524	java/lang/Exception
    //   1355	1381	1689	java/lang/Exception
    //   265	272	2325	finally
    //   592	602	2325	finally
    //   628	639	2325	finally
    //   669	680	2325	finally
    //   710	720	2325	finally
    //   740	749	2325	finally
    //   769	779	2325	finally
    //   799	816	2325	finally
    //   836	847	2325	finally
    //   867	878	2325	finally
    //   898	909	2325	finally
    //   939	948	2325	finally
    //   968	981	2325	finally
    //   1001	1013	2325	finally
    //   1033	1044	2325	finally
    //   1064	1071	2325	finally
    //   1091	1104	2325	finally
    //   1124	1132	2325	finally
    //   1164	1193	2325	finally
    //   1213	1245	2325	finally
    //   1265	1296	2325	finally
    //   1316	1347	2325	finally
    //   1355	1381	2325	finally
    //   1405	1437	2325	finally
    //   1478	1505	2325	finally
    //   1625	1634	2325	finally
    //   1665	1676	2325	finally
    //   1711	1721	2325	finally
    //   1747	1758	2325	finally
    //   1778	1789	2325	finally
    //   1809	1818	2325	finally
    //   1838	1849	2325	finally
    //   1869	1882	2325	finally
    //   1902	1915	2325	finally
    //   1935	1948	2325	finally
    //   1968	1981	2325	finally
    //   2001	2009	2325	finally
    //   2033	2062	2325	finally
    //   2082	2114	2325	finally
    //   2134	2165	2325	finally
    //   2185	2216	2325	finally
    //   2236	2267	2325	finally
    //   2287	2318	2325	finally
    //   2443	2454	2325	finally
    //   2474	2485	2325	finally
    //   2505	2516	2325	finally
    //   2536	2547	2325	finally
    //   2567	2578	2325	finally
    //   2598	2609	2325	finally
    //   2629	2640	2325	finally
    //   2660	2671	2325	finally
    //   2691	2702	2325	finally
    //   2722	2733	2325	finally
    //   2753	2762	2325	finally
    //   2782	2793	2325	finally
    //   2813	2826	2325	finally
    //   2846	2854	2325	finally
    //   2878	2907	2325	finally
    //   2927	2958	2325	finally
    //   2978	3010	2325	finally
    //   3037	3048	2325	finally
    //   3068	3079	2325	finally
    //   3099	3110	2325	finally
    //   3130	3141	2325	finally
    //   3161	3170	2325	finally
    //   3190	3204	2325	finally
    //   3224	3235	2325	finally
    //   3255	3266	2325	finally
    //   3286	3297	2325	finally
    //   3317	3326	2325	finally
    //   3346	3357	2325	finally
    //   3377	3392	2325	finally
    //   3412	3417	2325	finally
    //   3447	3459	2325	finally
    //   3484	3491	2325	finally
    //   3511	3520	2325	finally
    //   3540	3563	2325	finally
    //   3583	3596	2325	finally
    //   3616	3624	2325	finally
    //   3647	3658	2325	finally
    //   3681	3689	2325	finally
    //   3716	3727	2325	finally
    //   3747	3758	2325	finally
    //   3778	3789	2325	finally
    //   3809	3820	2325	finally
    //   3840	3849	2325	finally
    //   3869	3882	2325	finally
    //   3902	3913	2325	finally
    //   3933	3956	2325	finally
    //   3976	3999	2325	finally
    //   4019	4027	2325	finally
    //   4051	4080	2325	finally
    //   4100	4131	2325	finally
    //   4151	4183	2325	finally
    //   4203	4247	2325	finally
    //   4267	4311	2325	finally
    //   4338	4349	2325	finally
    //   4369	4380	2325	finally
    //   4400	4411	2325	finally
    //   4431	4442	2325	finally
    //   4462	4471	2325	finally
    //   4491	4502	2325	finally
    //   4522	4535	2325	finally
    //   4555	4574	2325	finally
    //   4594	4607	2325	finally
    //   4627	4636	2325	finally
    //   4656	4667	2325	finally
    //   4687	4698	2325	finally
    //   4718	4723	2325	finally
    //   4753	4765	2325	finally
    //   4790	4797	2325	finally
    //   4817	4826	2325	finally
    //   4846	4869	2325	finally
    //   4889	4912	2325	finally
    //   4932	4940	2325	finally
    //   4963	4971	2325	finally
    //   4998	5009	2325	finally
    //   5029	5040	2325	finally
    //   5060	5071	2325	finally
    //   5108	5117	2325	finally
    //   5137	5150	2325	finally
    //   5170	5183	2325	finally
    //   5203	5216	2325	finally
    //   5236	5247	2325	finally
    //   5267	5290	2325	finally
    //   5310	5318	2325	finally
    //   5345	5356	2325	finally
    //   5376	5387	2325	finally
    //   5407	5418	2325	finally
    //   5438	5449	2325	finally
    //   5469	5480	2325	finally
    //   5504	5515	2325	finally
    //   5535	5544	2325	finally
    //   5564	5577	2325	finally
    //   5597	5606	2325	finally
    //   5626	5637	2325	finally
    //   5657	5668	2325	finally
    //   5688	5693	2325	finally
    //   5723	5744	2325	finally
    //   5773	5781	2325	finally
    //   64	75	2382	java/lang/Throwable
    //   83	94	2382	java/lang/Throwable
    //   102	123	2382	java/lang/Throwable
    //   131	141	2382	java/lang/Throwable
    //   157	166	2382	java/lang/Throwable
    //   174	184	2382	java/lang/Throwable
    //   192	204	2382	java/lang/Throwable
    //   305	310	2382	java/lang/Throwable
    //   323	328	2382	java/lang/Throwable
    //   2348	2353	2382	java/lang/Throwable
    //   2366	2371	2382	java/lang/Throwable
    //   2379	2382	2382	java/lang/Throwable
    //   323	328	5788	java/lang/Exception
    //   1585	1590	5809	java/lang/Exception
    //   481	493	5849	java/lang/Exception
    //   498	507	5849	java/lang/Exception
    //   404	481	5882	java/lang/Exception
    //   507	538	5882	java/lang/Exception
    //   5851	5877	5882	java/lang/Exception
    //   305	310	5903	java/lang/Exception
    //   1575	1580	5908	java/lang/Exception
    //   2348	2353	5913	java/lang/Exception
    //   2366	2371	5918	java/lang/Exception
    //   1575	1580	5923	java/lang/Throwable
    //   1585	1590	5923	java/lang/Throwable
    //   204	215	5936	finally
    //   215	233	5947	finally
    //   1554	1570	5955	finally
    //   204	215	5980	java/lang/Exception
    //   215	233	5999	java/lang/Exception
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
          ((aili)localIterator.next()).a(paramBundle);
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
          ((aili)((Iterator)localObject).next()).b();
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
        ((aili)((Iterator)localObject).next()).c();
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
              this.jdField_a_of_type_JavaUtilList.add(new ailk(this, paramMessage[1]));
              this.jdField_a_of_type_JavaUtilList.add(new ailm(this, paramMessage[3]));
              this.jdField_a_of_type_JavaUtilList.add(new ailj(this, paramMessage[4]));
              this.jdField_a_of_type_JavaUtilList.add(new ailo(this, paramMessage[5]));
              this.jdField_a_of_type_JavaUtilList.add(new ailr(this, paramMessage[6]));
              this.jdField_a_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl$GPS = new BatteryStatsImpl.GPS(this, paramMessage[7]);
              this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl$GPS);
              if (!b()) {
                continue;
              }
              this.jdField_a_of_type_JavaUtilList.add(new ailn(this, paramMessage[2]));
              BatteryLog.a(BaseApplicationImpl.sApplication.getProcessName(), this.jdField_a_of_type_Long);
              paramMessage = this.jdField_a_of_type_JavaUtilList.iterator();
              if (!paramMessage.hasNext()) {
                continue;
              }
              localObject4 = (aili)paramMessage.next();
              ((aili)localObject4).a();
              if (!this.jdField_c_of_type_Boolean) {
                continue;
              }
              ((aili)localObject4).d();
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
            ((aili)paramMessage.next()).d();
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
              ((aili)paramMessage.next()).g();
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
                ((aili)paramMessage.next()).e();
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
                ((aili)paramMessage.next()).f();
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