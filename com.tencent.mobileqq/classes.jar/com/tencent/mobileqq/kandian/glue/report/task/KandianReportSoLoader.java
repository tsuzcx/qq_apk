package com.tencent.mobileqq.kandian.glue.report.task;

import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class KandianReportSoLoader
{
  private static String a;
  private static String b;
  private static String c;
  private static String d;
  private static boolean e = false;
  private static int f = -1;
  
  static
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(OfflineEnvHelper.b("3454"));
      localStringBuilder.append("3454");
      a = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir().getParent());
      localStringBuilder.append("/txlib/kandianreport");
      b = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append("/so_config.json");
      c = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(b);
      localStringBuilder.append("/so_config.json");
      d = localStringBuilder.toString();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("kandianreport.KandianReportSoLoader", 2, localThrowable.getLocalizedMessage());
    }
  }
  
  public static void a(Runnable paramRunnable)
  {
    Boolean localBoolean = Boolean.valueOf(true);
    if (((Boolean)RIJSPUtils.b("qq_is_reinstall", localBoolean)).booleanValue())
    {
      RIJSPUtils.a("qq_is_reinstall", Boolean.valueOf(false));
      try
      {
        if (new File(c).exists()) {
          RIJSPUtils.a("kd_fc_so_download", localBoolean);
        }
      }
      catch (Exception localException)
      {
        QLog.d("kandianreport.KandianReportSoLoader", 1, "check local offline file fail!");
        localException.printStackTrace();
      }
    }
    QLog.d("kandianreport.KandianReportSoLoader", 1, "download so files now");
    TaskOfflineUtils.a("3454", 1, new KandianReportSoLoader.1(paramRunnable));
  }
  
  public static void a(String paramString)
  {
    if (TaskManager.b)
    {
      QLog.d("kandianreport.KandianReportSoLoader", 1, paramString);
      HashMap localHashMap = new HashMap();
      AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
      if (localAppRuntime != null) {
        localHashMap.put("uin", localAppRuntime.getAccount());
      }
      localHashMap.put("log", paramString);
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(null, "kandianreportdataframe", true, 1L, 0L, localHashMap, null);
      TaskException.b(paramString);
    }
  }
  
  public static boolean a()
  {
    return e;
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    boolean bool1 = FileUtils.copyFile(paramString1, paramString2);
    StringBuilder localStringBuilder;
    if (!bool1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("copy file result false ");
      localStringBuilder.append(paramString1);
      a(localStringBuilder.toString());
    }
    else if (!new File(paramString2).exists())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("copy file result true but still not found ");
      localStringBuilder.append(paramString1);
      a(localStringBuilder.toString());
      bool1 = false;
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("copy file result success and found ");
      localStringBuilder.append(paramString1);
      a(localStringBuilder.toString());
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = b(paramString1, paramString2);
      if (!bool2)
      {
        paramString2 = new StringBuilder();
        paramString2.append("double copy file result false fail ");
        paramString2.append(paramString1);
        a(paramString2.toString());
      }
      else if (!new File(paramString2).exists())
      {
        paramString2 = new StringBuilder();
        paramString2.append("double copy file result true but still not found ");
        paramString2.append(paramString1);
        a(paramString2.toString());
        bool2 = false;
      }
    }
    paramString1 = new StringBuilder();
    paramString1.append("copy file final result");
    paramString1.append(bool2);
    QLog.d("kandianreport.KandianReportSoLoader", 1, paramString1.toString());
    return bool2;
  }
  
  public static int b()
  {
    return f;
  }
  
  /* Error */
  public static void b(Runnable paramRunnable)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 205	com/tencent/mobileqq/kandian/glue/report/task/KandianReportSoLoader:a	()Z
    //   6: ifeq +17 -> 23
    //   9: aload_0
    //   10: ifnull +9 -> 19
    //   13: aload_0
    //   14: invokeinterface 210 1 0
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: invokestatic 212	com/tencent/mobileqq/kandian/glue/report/task/KandianReportSoLoader:e	()Z
    //   26: ifne +21 -> 47
    //   29: ldc 68
    //   31: iconst_1
    //   32: ldc 214
    //   34: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: getstatic 41	com/tencent/mobileqq/kandian/glue/report/task/KandianReportSoLoader:a	Ljava/lang/String;
    //   40: invokestatic 217	com/tencent/mobileqq/utils/FileUtils:deleteDirectory	(Ljava/lang/String;)V
    //   43: ldc 2
    //   45: monitorexit
    //   46: return
    //   47: ldc 68
    //   49: iconst_1
    //   50: ldc 219
    //   52: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: new 53	java/io/File
    //   58: dup
    //   59: getstatic 64	com/tencent/mobileqq/kandian/glue/report/task/KandianReportSoLoader:c	Ljava/lang/String;
    //   62: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   65: invokevirtual 110	java/io/File:exists	()Z
    //   68: istore_2
    //   69: new 21	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   76: astore_3
    //   77: aload_3
    //   78: ldc 221
    //   80: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_3
    //   85: iload_2
    //   86: invokevirtual 202	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_3
    //   91: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 187	com/tencent/mobileqq/kandian/glue/report/task/KandianReportSoLoader:a	(Ljava/lang/String;)V
    //   97: iload_2
    //   98: ifne +21 -> 119
    //   101: ldc 68
    //   103: iconst_1
    //   104: ldc 223
    //   106: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: getstatic 41	com/tencent/mobileqq/kandian/glue/report/task/KandianReportSoLoader:a	Ljava/lang/String;
    //   112: invokestatic 217	com/tencent/mobileqq/utils/FileUtils:deleteDirectory	(Ljava/lang/String;)V
    //   115: ldc 2
    //   117: monitorexit
    //   118: return
    //   119: new 225	org/json/JSONObject
    //   122: dup
    //   123: new 227	java/io/FileInputStream
    //   126: dup
    //   127: getstatic 64	com/tencent/mobileqq/kandian/glue/report/task/KandianReportSoLoader:c	Ljava/lang/String;
    //   130: invokespecial 228	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   133: invokestatic 231	com/tencent/mobileqq/kandian/glue/report/task/TaskOfflineUtils:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   136: invokespecial 232	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   139: ldc 234
    //   141: invokevirtual 238	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   144: checkcast 240	org/json/JSONArray
    //   147: astore_3
    //   148: aload_3
    //   149: ifnull +395 -> 544
    //   152: aload_3
    //   153: invokevirtual 243	org/json/JSONArray:length	()I
    //   156: istore_1
    //   157: iload_1
    //   158: ifle +386 -> 544
    //   161: ldc 245
    //   163: invokestatic 250	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   166: goto +502 -> 668
    //   169: astore 4
    //   171: new 21	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   178: astore 5
    //   180: aload 5
    //   182: ldc 252
    //   184: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 5
    //   190: aload 4
    //   192: invokevirtual 255	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   195: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: ldc 68
    //   201: iconst_1
    //   202: aload 5
    //   204: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   210: new 21	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   217: astore 5
    //   219: aload 5
    //   221: ldc 252
    //   223: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 5
    //   229: aload 4
    //   231: invokevirtual 255	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   234: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 5
    //   240: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 256	com/tencent/mobileqq/kandian/glue/report/task/TaskException:a	(Ljava/lang/String;)V
    //   246: goto +422 -> 668
    //   249: iload_1
    //   250: aload_3
    //   251: invokevirtual 243	org/json/JSONArray:length	()I
    //   254: if_icmpge +258 -> 512
    //   257: aload_3
    //   258: iload_1
    //   259: invokevirtual 260	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   262: astore 4
    //   264: new 21	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   271: astore 5
    //   273: aload 5
    //   275: getstatic 60	com/tencent/mobileqq/kandian/glue/report/task/KandianReportSoLoader:b	Ljava/lang/String;
    //   278: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload 5
    //   284: ldc_w 262
    //   287: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload 5
    //   293: ldc_w 264
    //   296: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload 5
    //   302: ldc_w 262
    //   305: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload 5
    //   311: aload 4
    //   313: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 5
    //   319: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: astore 5
    //   324: aload 5
    //   326: invokestatic 268	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   329: ifne +134 -> 463
    //   332: new 21	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   339: astore 6
    //   341: aload 6
    //   343: getstatic 41	com/tencent/mobileqq/kandian/glue/report/task/KandianReportSoLoader:a	Ljava/lang/String;
    //   346: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload 6
    //   352: ldc_w 262
    //   355: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload 6
    //   361: aload 4
    //   363: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload 6
    //   369: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: aload 5
    //   374: invokestatic 270	com/tencent/mobileqq/kandian/glue/report/task/KandianReportSoLoader:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   377: ifne +49 -> 426
    //   380: new 21	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   387: astore 6
    //   389: aload 6
    //   391: ldc_w 272
    //   394: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload 6
    //   400: aload 4
    //   402: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: ldc 68
    //   408: iconst_1
    //   409: aload 6
    //   411: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: getstatic 41	com/tencent/mobileqq/kandian/glue/report/task/KandianReportSoLoader:a	Ljava/lang/String;
    //   420: invokestatic 217	com/tencent/mobileqq/utils/FileUtils:deleteDirectory	(Ljava/lang/String;)V
    //   423: goto +40 -> 463
    //   426: new 21	java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   433: astore 6
    //   435: aload 6
    //   437: ldc_w 274
    //   440: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload 6
    //   446: aload 4
    //   448: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: ldc 68
    //   454: iconst_1
    //   455: aload 6
    //   457: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   460: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   463: aload 5
    //   465: invokestatic 277	java/lang/System:load	(Ljava/lang/String;)V
    //   468: new 21	java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   475: astore 4
    //   477: aload 4
    //   479: ldc_w 279
    //   482: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: aload 4
    //   488: aload 5
    //   490: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: ldc 68
    //   496: iconst_1
    //   497: aload 4
    //   499: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   505: iload_1
    //   506: iconst_1
    //   507: iadd
    //   508: istore_1
    //   509: goto -260 -> 249
    //   512: iconst_1
    //   513: putstatic 177	com/tencent/mobileqq/kandian/glue/report/task/KandianReportSoLoader:e	Z
    //   516: aconst_null
    //   517: ldc_w 281
    //   520: ldc_w 283
    //   523: ldc_w 283
    //   526: iconst_0
    //   527: iconst_0
    //   528: ldc_w 281
    //   531: ldc_w 281
    //   534: ldc_w 281
    //   537: ldc_w 285
    //   540: iconst_0
    //   541: invokestatic 290	com/tencent/mobileqq/kandian/biz/common/api/impl/PublicAccountReportUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   544: ldc 26
    //   546: iconst_1
    //   547: invokestatic 293	com/tencent/mobileqq/kandian/glue/report/task/TaskOfflineUtils:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/kandian/glue/report/task/TaskOfflineUtils$ConfigData;
    //   550: getfield 297	com/tencent/mobileqq/kandian/glue/report/task/TaskOfflineUtils$ConfigData:b	I
    //   553: putstatic 81	com/tencent/mobileqq/kandian/glue/report/task/KandianReportSoLoader:f	I
    //   556: ldc_w 299
    //   559: invokestatic 187	com/tencent/mobileqq/kandian/glue/report/task/KandianReportSoLoader:a	(Ljava/lang/String;)V
    //   562: aload_0
    //   563: ifnull +90 -> 653
    //   566: aload_0
    //   567: invokeinterface 210 1 0
    //   572: goto +81 -> 653
    //   575: astore_0
    //   576: goto +81 -> 657
    //   579: astore_0
    //   580: new 21	java/lang/StringBuilder
    //   583: dup
    //   584: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   587: astore_3
    //   588: aload_3
    //   589: ldc_w 301
    //   592: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: pop
    //   596: aload_3
    //   597: aload_0
    //   598: invokevirtual 255	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   601: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: pop
    //   605: ldc 68
    //   607: iconst_1
    //   608: aload_3
    //   609: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   615: new 21	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   622: astore_3
    //   623: aload_3
    //   624: ldc_w 301
    //   627: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: pop
    //   631: aload_3
    //   632: aload_0
    //   633: invokevirtual 255	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   636: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: pop
    //   640: aload_3
    //   641: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: invokestatic 256	com/tencent/mobileqq/kandian/glue/report/task/TaskException:a	(Ljava/lang/String;)V
    //   647: getstatic 41	com/tencent/mobileqq/kandian/glue/report/task/KandianReportSoLoader:a	Ljava/lang/String;
    //   650: invokestatic 217	com/tencent/mobileqq/utils/FileUtils:deleteDirectory	(Ljava/lang/String;)V
    //   653: ldc 2
    //   655: monitorexit
    //   656: return
    //   657: ldc 2
    //   659: monitorexit
    //   660: goto +5 -> 665
    //   663: aload_0
    //   664: athrow
    //   665: goto -2 -> 663
    //   668: iconst_0
    //   669: istore_1
    //   670: goto -421 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	673	0	paramRunnable	Runnable
    //   156	514	1	i	int
    //   68	30	2	bool	boolean
    //   76	565	3	localObject1	Object
    //   169	61	4	localThrowable	Throwable
    //   262	236	4	localObject2	Object
    //   178	311	5	localObject3	Object
    //   339	117	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   161	166	169	java/lang/Throwable
    //   3	9	575	finally
    //   13	19	575	finally
    //   23	43	575	finally
    //   47	97	575	finally
    //   101	115	575	finally
    //   119	148	575	finally
    //   152	157	575	finally
    //   161	166	575	finally
    //   171	246	575	finally
    //   249	423	575	finally
    //   426	463	575	finally
    //   463	505	575	finally
    //   512	544	575	finally
    //   544	562	575	finally
    //   566	572	575	finally
    //   580	653	575	finally
    //   3	9	579	java/lang/Throwable
    //   13	19	579	java/lang/Throwable
    //   23	43	579	java/lang/Throwable
    //   47	97	579	java/lang/Throwable
    //   101	115	579	java/lang/Throwable
    //   119	148	579	java/lang/Throwable
    //   152	157	579	java/lang/Throwable
    //   171	246	579	java/lang/Throwable
    //   249	423	579	java/lang/Throwable
    //   426	463	579	java/lang/Throwable
    //   463	505	579	java/lang/Throwable
    //   512	544	579	java/lang/Throwable
    //   544	562	579	java/lang/Throwable
    //   566	572	579	java/lang/Throwable
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    try
    {
      File localFile = new File(paramString1);
      Object localObject = new File(paramString2);
      if (!localFile.exists())
      {
        paramString2 = new StringBuilder();
        paramString2.append("copy file result false not found ");
        paramString2.append(paramString1);
        QLog.d("kandianreport.KandianReportSoLoader", 1, paramString2.toString());
        return false;
      }
      paramString1 = (String)localObject;
      if (!((File)localObject).exists()) {
        paramString1 = FileUtils.createFile(paramString2);
      }
      if (localFile.getAbsolutePath().toString().equals(paramString1.getAbsolutePath().toString())) {
        return true;
      }
      paramString2 = new FileInputStream(localFile);
      paramString1 = new FileOutputStream(paramString1);
      localObject = new byte[1024];
      for (;;)
      {
        int i = paramString2.read((byte[])localObject);
        if (i <= 0) {
          break;
        }
        paramString1.write((byte[])localObject, 0, i);
      }
      paramString2.close();
      paramString1.close();
      return true;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
    return false;
  }
  
  public static String c()
  {
    return b;
  }
  
  public static boolean d()
  {
    return new File(c).exists();
  }
  
  public static boolean e()
  {
    Object localObject = Boolean.valueOf(false);
    boolean bool1 = ((Boolean)RIJSPUtils.b("kd_fc_so_copy", localObject)).booleanValue();
    boolean bool2 = new File(d).exists();
    boolean bool4 = ((Boolean)RIJSPUtils.b("kd_fc_so_download", localObject)).booleanValue();
    boolean bool3 = new File(c).exists();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("copy flag: ");
    ((StringBuilder)localObject).append(bool1);
    QLog.d("kandianreport.KandianReportSoLoader", 1, ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("actual copy state: ");
    ((StringBuilder)localObject).append(bool2);
    QLog.d("kandianreport.KandianReportSoLoader", 1, ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("download flag: ");
    ((StringBuilder)localObject).append(bool4);
    QLog.d("kandianreport.KandianReportSoLoader", 1, ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("actual download state: ");
    ((StringBuilder)localObject).append(bool3);
    QLog.d("kandianreport.KandianReportSoLoader", 1, ((StringBuilder)localObject).toString());
    if (bool1 != bool2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("copy state is wrong ");
      ((StringBuilder)localObject).append(bool1);
      TaskException.b(((StringBuilder)localObject).toString());
    }
    if (bool4 != bool3)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("download state is wrong ");
      ((StringBuilder)localObject).append(bool4);
      TaskException.b(((StringBuilder)localObject).toString());
    }
    if (bool3) {
      try
      {
        if (!OfflineSecurity.a(a, "3454"))
        {
          a("checkSoFileIsReady: verification failed");
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("kandianreport.KandianReportSoLoader", 1, localThrowable, new Object[0]);
        return false;
      }
    }
    bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (bool3)
      {
        QLog.d("kandianreport.KandianReportSoLoader", 1, "download success but not copy");
        bool1 = n();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("copy result: ");
        localStringBuilder.append(bool1);
        QLog.d("kandianreport.KandianReportSoLoader", 1, localStringBuilder.toString());
        if (!OfflineSecurity.a(a, "3454"))
        {
          a("checkSoFileIsReady: verification failed");
          return false;
        }
      }
    }
    if (bool1) {
      return m();
    }
    return bool1;
  }
  
  public static void f()
  {
    a(null);
  }
  
  public static void g()
  {
    try
    {
      b(null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static boolean m()
  {
    if (!new File(c).exists()) {
      return false;
    }
    try
    {
      Object localObject = (JSONArray)new JSONObject(TaskOfflineUtils.a(new FileInputStream(c))).get("so_name");
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        String str = ((JSONArray)localObject).getString(i);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(b);
        localStringBuilder.append("/");
        localStringBuilder.append(str);
        if (!new File(localStringBuilder.toString()).exists())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(" not found");
          QLog.d("kandianreport.KandianReportSoLoader", 1, ((StringBuilder)localObject).toString());
          return false;
        }
        i += 1;
      }
      QLog.d("kandianreport.KandianReportSoLoader", 1, "so verify pass");
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("kandianreport.KandianReportSoLoader", 1, localThrowable.getMessage());
    }
    return false;
  }
  
  private static boolean n()
  {
    for (;;)
    {
      try
      {
        RIJSPUtils.a("kd_fc_so_copy", Boolean.valueOf(false));
        localObject1 = (JSONArray)new JSONObject(TaskOfflineUtils.a(new FileInputStream(c))).get("so_name");
        if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
          continue;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("so config copy ");
        ((StringBuilder)localObject3).append(((JSONArray)localObject1).toString());
        QLog.d("kandianreport.KandianReportSoLoader", 1, ((StringBuilder)localObject3).toString());
        if (!a(c, d))
        {
          QLog.d("kandianreport.KandianReportSoLoader", 1, "so config copy fail");
          return false;
        }
        localObject3 = OfflineSecurity.a(c);
        localObject4 = OfflineSecurity.a(d);
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("so config copy success: ");
        ((StringBuilder)localObject5).append((String)localObject3);
        ((StringBuilder)localObject5).append(" ");
        ((StringBuilder)localObject5).append((String)localObject4);
        a(((StringBuilder)localObject5).toString());
        if (localObject3 == null) {
          continue;
        }
        if (((String)localObject3).equals(localObject4)) {
          continue;
        }
      }
      finally
      {
        Object localObject1;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        boolean bool;
        continue;
        throw localObject2;
        continue;
        int i = 0;
        continue;
      }
      if (i >= ((JSONArray)localObject1).length()) {
        continue;
      }
      localObject3 = ((JSONArray)localObject1).getString(i);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(a);
      ((StringBuilder)localObject4).append("/");
      ((StringBuilder)localObject4).append((String)localObject3);
      localObject4 = ((StringBuilder)localObject4).toString();
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(b);
      ((StringBuilder)localObject5).append("/");
      ((StringBuilder)localObject5).append((String)localObject3);
      localObject5 = ((StringBuilder)localObject5).toString();
      if (!a((String)localObject4, (String)localObject5))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("jscjni copy fail ");
        ((StringBuilder)localObject1).append((String)localObject3);
        QLog.d("kandianreport.KandianReportSoLoader", 1, ((StringBuilder)localObject1).toString());
        return false;
      }
      localObject3 = OfflineSecurity.a((String)localObject4);
      localObject4 = OfflineSecurity.a((String)localObject5);
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("so copy success: ");
      ((StringBuilder)localObject5).append((String)localObject3);
      ((StringBuilder)localObject5).append(" ");
      ((StringBuilder)localObject5).append((String)localObject4);
      a(((StringBuilder)localObject5).toString());
      if (localObject3 == null) {
        continue;
      }
      bool = ((String)localObject3).equals(localObject4);
      if (!bool) {
        continue;
      }
      i += 1;
    }
    return false;
    RIJSPUtils.a("kd_fc_so_copy", Boolean.valueOf(true));
    return true;
    return false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.KandianReportSoLoader
 * JD-Core Version:    0.7.0.1
 */