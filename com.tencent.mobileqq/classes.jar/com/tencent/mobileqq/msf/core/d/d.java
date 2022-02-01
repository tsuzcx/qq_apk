package com.tencent.mobileqq.msf.core.d;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.ad;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat;
import com.tencent.mobileqq.msf.sdk.utils.b;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class d
  extends BroadcastReceiver
{
  public static final String a = "MSF.C.MonitorNetFlowStore";
  static final String b = "SQQzoneSvcDev";
  public static final String c = "MONITOR_NetflowRdmReport";
  public static final String d = "MONITOR_NetflowRdmReportwithStatus";
  public static final String e = "MONITOR_NetflowRdmReport_TIME";
  public static final int f = 1;
  static SimpleDateFormat g = new SimpleDateFormat("dd HH:mm:ss");
  static final String h = "dataflow";
  private static Context j;
  private static final int v = 100;
  private static final int w = 10485760;
  private static final int x = 300000;
  private static SQLiteDatabase y;
  private MsfCore i;
  private HashMap k = new HashMap();
  private HashMap l = new HashMap();
  private AlarmManager m;
  private String n = "";
  private PendingIntent o;
  private boolean p = true;
  private HandlerThread q;
  private Handler r;
  private d.a s;
  private long t;
  private final int u = 4;
  
  public d(MsfCore paramMsfCore, Context paramContext)
  {
    this.i = paramMsfCore;
    j = paramContext;
    if (this.p)
    {
      this.q = new HandlerThread("monitor_dataflow_write_thread");
      this.q.setPriority(4);
      this.q.start();
      this.r = new Handler(this.q.getLooper());
      this.t = System.currentTimeMillis();
    }
  }
  
  /* Error */
  public static com.tencent.qphone.base.util.QLog.LogFile a(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc 8
    //   2: iconst_1
    //   3: ldc 133
    //   5: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: getstatic 140	com/tencent/mobileqq/msf/core/d/d:y	Landroid/database/sqlite/SQLiteDatabase;
    //   11: ifnonnull +12 -> 23
    //   14: invokestatic 145	com/tencent/mobileqq/msf/core/d/c:a	()Lcom/tencent/mobileqq/msf/core/d/c;
    //   17: invokevirtual 149	com/tencent/mobileqq/msf/core/d/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   20: putstatic 140	com/tencent/mobileqq/msf/core/d/d:y	Landroid/database/sqlite/SQLiteDatabase;
    //   23: getstatic 140	com/tencent/mobileqq/msf/core/d/d:y	Landroid/database/sqlite/SQLiteDatabase;
    //   26: ldc 28
    //   28: bipush 8
    //   30: anewarray 151	java/lang/String
    //   33: dup
    //   34: iconst_0
    //   35: ldc 153
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: ldc 155
    //   42: aastore
    //   43: dup
    //   44: iconst_2
    //   45: ldc 157
    //   47: aastore
    //   48: dup
    //   49: iconst_3
    //   50: ldc 159
    //   52: aastore
    //   53: dup
    //   54: iconst_4
    //   55: ldc 161
    //   57: aastore
    //   58: dup
    //   59: iconst_5
    //   60: ldc 163
    //   62: aastore
    //   63: dup
    //   64: bipush 6
    //   66: ldc 165
    //   68: aastore
    //   69: dup
    //   70: bipush 7
    //   72: ldc 167
    //   74: aastore
    //   75: ldc 169
    //   77: iconst_2
    //   78: anewarray 151	java/lang/String
    //   81: dup
    //   82: iconst_0
    //   83: lload_0
    //   84: invokestatic 173	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   87: aastore
    //   88: dup
    //   89: iconst_1
    //   90: lload_2
    //   91: invokestatic 173	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   94: aastore
    //   95: aconst_null
    //   96: aconst_null
    //   97: aconst_null
    //   98: invokevirtual 179	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   101: astore 7
    //   103: aload 7
    //   105: ifnonnull +17 -> 122
    //   108: aload 7
    //   110: ifnull +10 -> 120
    //   113: aload 7
    //   115: invokeinterface 184 1 0
    //   120: aconst_null
    //   121: areturn
    //   122: aload 7
    //   124: astore 6
    //   126: new 186	java/io/File
    //   129: dup
    //   130: invokestatic 190	com/tencent/qphone/base/util/QLog:getLogPath	()Ljava/lang/String;
    //   133: invokespecial 191	java/io/File:<init>	(Ljava/lang/String;)V
    //   136: astore 8
    //   138: aload 7
    //   140: astore 6
    //   142: aload 8
    //   144: invokevirtual 195	java/io/File:exists	()Z
    //   147: istore 5
    //   149: iload 5
    //   151: istore 4
    //   153: iload 5
    //   155: ifne +14 -> 169
    //   158: aload 7
    //   160: astore 6
    //   162: aload 8
    //   164: invokevirtual 198	java/io/File:mkdirs	()Z
    //   167: istore 4
    //   169: iload 4
    //   171: ifne +17 -> 188
    //   174: aload 7
    //   176: ifnull +10 -> 186
    //   179: aload 7
    //   181: invokeinterface 184 1 0
    //   186: aconst_null
    //   187: areturn
    //   188: aload 7
    //   190: astore 6
    //   192: new 200	com/tencent/qphone/base/util/QLog$LogFile
    //   195: dup
    //   196: aload 8
    //   198: ldc 202
    //   200: invokespecial 205	com/tencent/qphone/base/util/QLog$LogFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   203: astore 8
    //   205: aload 7
    //   207: astore 6
    //   209: new 207	java/io/BufferedWriter
    //   212: dup
    //   213: new 209	java/io/OutputStreamWriter
    //   216: dup
    //   217: new 211	java/io/FileOutputStream
    //   220: dup
    //   221: aload 8
    //   223: invokespecial 214	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   226: invokespecial 217	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   229: invokespecial 220	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   232: astore 9
    //   234: aload 7
    //   236: astore 6
    //   238: aload 7
    //   240: invokeinterface 223 1 0
    //   245: pop
    //   246: lconst_0
    //   247: lstore_0
    //   248: aload 7
    //   250: astore 6
    //   252: aload 7
    //   254: invokeinterface 226 1 0
    //   259: ifne +315 -> 574
    //   262: aload 7
    //   264: astore 6
    //   266: new 228	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   273: astore 10
    //   275: aload 7
    //   277: astore 6
    //   279: aload 10
    //   281: aload 7
    //   283: iconst_0
    //   284: invokeinterface 233 2 0
    //   289: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 7
    //   295: astore 6
    //   297: aload 10
    //   299: ldc 239
    //   301: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 7
    //   307: astore 6
    //   309: aload 10
    //   311: aload 7
    //   313: iconst_1
    //   314: invokeinterface 233 2 0
    //   319: invokestatic 245	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   322: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload 7
    //   328: astore 6
    //   330: aload 10
    //   332: ldc 239
    //   334: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload 7
    //   340: astore 6
    //   342: aload 10
    //   344: aload 7
    //   346: iconst_2
    //   347: invokeinterface 249 2 0
    //   352: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload 7
    //   358: astore 6
    //   360: aload 10
    //   362: ldc 239
    //   364: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload 7
    //   370: astore 6
    //   372: aload 10
    //   374: aload 7
    //   376: iconst_3
    //   377: invokeinterface 256 2 0
    //   382: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload 7
    //   388: astore 6
    //   390: aload 10
    //   392: ldc 239
    //   394: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload 7
    //   400: astore 6
    //   402: aload 10
    //   404: aload 7
    //   406: iconst_4
    //   407: invokeinterface 233 2 0
    //   412: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload 7
    //   418: astore 6
    //   420: aload 10
    //   422: ldc 239
    //   424: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload 7
    //   430: astore 6
    //   432: aload 10
    //   434: aload 7
    //   436: iconst_5
    //   437: invokeinterface 256 2 0
    //   442: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload 7
    //   448: astore 6
    //   450: aload 10
    //   452: ldc 239
    //   454: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload 7
    //   460: astore 6
    //   462: aload 10
    //   464: aload 7
    //   466: bipush 6
    //   468: invokeinterface 233 2 0
    //   473: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 7
    //   479: astore 6
    //   481: aload 10
    //   483: ldc 239
    //   485: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: pop
    //   489: aload 7
    //   491: astore 6
    //   493: aload 10
    //   495: getstatic 71	com/tencent/mobileqq/msf/core/d/d:g	Ljava/text/SimpleDateFormat;
    //   498: aload 7
    //   500: bipush 7
    //   502: invokeinterface 249 2 0
    //   507: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   510: invokevirtual 268	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   513: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: aload 7
    //   519: astore 6
    //   521: aload 10
    //   523: ldc_w 270
    //   526: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload 7
    //   532: astore 6
    //   534: aload 9
    //   536: aload 10
    //   538: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: invokevirtual 276	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   544: aload 7
    //   546: astore 6
    //   548: lload_0
    //   549: aload 7
    //   551: iconst_2
    //   552: invokeinterface 249 2 0
    //   557: ladd
    //   558: lstore_0
    //   559: aload 7
    //   561: astore 6
    //   563: aload 7
    //   565: invokeinterface 279 1 0
    //   570: pop
    //   571: goto -323 -> 248
    //   574: aload 7
    //   576: astore 6
    //   578: new 228	java/lang/StringBuilder
    //   581: dup
    //   582: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   585: astore 10
    //   587: aload 7
    //   589: astore 6
    //   591: aload 10
    //   593: ldc_w 281
    //   596: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: aload 7
    //   602: astore 6
    //   604: aload 10
    //   606: lload_0
    //   607: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: aload 7
    //   613: astore 6
    //   615: aload 10
    //   617: ldc_w 283
    //   620: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: pop
    //   624: aload 7
    //   626: astore 6
    //   628: aload 9
    //   630: aload 10
    //   632: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokevirtual 276	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   638: aload 7
    //   640: astore 6
    //   642: aload 9
    //   644: invokevirtual 286	java/io/BufferedWriter:flush	()V
    //   647: aload 7
    //   649: astore 6
    //   651: aload 9
    //   653: invokevirtual 287	java/io/BufferedWriter:close	()V
    //   656: aload 7
    //   658: ifnull +10 -> 668
    //   661: aload 7
    //   663: invokeinterface 184 1 0
    //   668: aload 8
    //   670: areturn
    //   671: astore 8
    //   673: goto +16 -> 689
    //   676: astore 6
    //   678: aconst_null
    //   679: astore 7
    //   681: goto +87 -> 768
    //   684: astore 8
    //   686: aconst_null
    //   687: astore 7
    //   689: aload 7
    //   691: astore 6
    //   693: new 228	java/lang/StringBuilder
    //   696: dup
    //   697: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   700: astore 9
    //   702: aload 7
    //   704: astore 6
    //   706: aload 9
    //   708: ldc_w 289
    //   711: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: pop
    //   715: aload 7
    //   717: astore 6
    //   719: aload 9
    //   721: aload 8
    //   723: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   726: pop
    //   727: aload 7
    //   729: astore 6
    //   731: ldc 8
    //   733: iconst_1
    //   734: aload 9
    //   736: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   739: aload 8
    //   741: invokestatic 295	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   744: aload 7
    //   746: ifnull +10 -> 756
    //   749: aload 7
    //   751: invokeinterface 184 1 0
    //   756: aconst_null
    //   757: areturn
    //   758: astore 8
    //   760: aload 6
    //   762: astore 7
    //   764: aload 8
    //   766: astore 6
    //   768: aload 7
    //   770: ifnull +10 -> 780
    //   773: aload 7
    //   775: invokeinterface 184 1 0
    //   780: goto +6 -> 786
    //   783: aload 6
    //   785: athrow
    //   786: goto -3 -> 783
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	789	0	paramLong1	long
    //   0	789	2	paramLong2	long
    //   151	19	4	bool1	boolean
    //   147	7	5	bool2	boolean
    //   124	526	6	localObject1	Object
    //   676	1	6	localObject2	Object
    //   691	93	6	localObject3	Object
    //   101	673	7	localObject4	Object
    //   136	533	8	localObject5	Object
    //   671	1	8	localException1	Exception
    //   684	56	8	localException2	Exception
    //   758	7	8	localObject6	Object
    //   232	503	9	localObject7	Object
    //   273	358	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   126	138	671	java/lang/Exception
    //   142	149	671	java/lang/Exception
    //   162	169	671	java/lang/Exception
    //   192	205	671	java/lang/Exception
    //   209	234	671	java/lang/Exception
    //   238	246	671	java/lang/Exception
    //   252	262	671	java/lang/Exception
    //   266	275	671	java/lang/Exception
    //   279	293	671	java/lang/Exception
    //   297	305	671	java/lang/Exception
    //   309	326	671	java/lang/Exception
    //   330	338	671	java/lang/Exception
    //   342	356	671	java/lang/Exception
    //   360	368	671	java/lang/Exception
    //   372	386	671	java/lang/Exception
    //   390	398	671	java/lang/Exception
    //   402	416	671	java/lang/Exception
    //   420	428	671	java/lang/Exception
    //   432	446	671	java/lang/Exception
    //   450	458	671	java/lang/Exception
    //   462	477	671	java/lang/Exception
    //   481	489	671	java/lang/Exception
    //   493	517	671	java/lang/Exception
    //   521	530	671	java/lang/Exception
    //   534	544	671	java/lang/Exception
    //   548	559	671	java/lang/Exception
    //   563	571	671	java/lang/Exception
    //   578	587	671	java/lang/Exception
    //   591	600	671	java/lang/Exception
    //   604	611	671	java/lang/Exception
    //   615	624	671	java/lang/Exception
    //   628	638	671	java/lang/Exception
    //   642	647	671	java/lang/Exception
    //   651	656	671	java/lang/Exception
    //   8	23	676	finally
    //   23	103	676	finally
    //   8	23	684	java/lang/Exception
    //   23	103	684	java/lang/Exception
    //   126	138	758	finally
    //   142	149	758	finally
    //   162	169	758	finally
    //   192	205	758	finally
    //   209	234	758	finally
    //   238	246	758	finally
    //   252	262	758	finally
    //   266	275	758	finally
    //   279	293	758	finally
    //   297	305	758	finally
    //   309	326	758	finally
    //   330	338	758	finally
    //   342	356	758	finally
    //   360	368	758	finally
    //   372	386	758	finally
    //   390	398	758	finally
    //   402	416	758	finally
    //   420	428	758	finally
    //   432	446	758	finally
    //   450	458	758	finally
    //   462	477	758	finally
    //   481	489	758	finally
    //   493	517	758	finally
    //   521	530	758	finally
    //   534	544	758	finally
    //   548	559	758	finally
    //   563	571	758	finally
    //   578	587	758	finally
    //   591	600	758	finally
    //   604	611	758	finally
    //   615	624	758	finally
    //   628	638	758	finally
    //   642	647	758	finally
    //   651	656	758	finally
    //   693	702	758	finally
    //   706	715	758	finally
    //   719	727	758	finally
    //   731	744	758	finally
  }
  
  private PrintWriter a(Calendar paramCalendar)
  {
    Object localObject5 = null;
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getPath());
      ((StringBuilder)localObject1).append("/tencent/msflogs/com/tencent/mobileqq/netflow/");
      Object localObject3 = ((StringBuilder)localObject1).toString();
      localObject1 = new File((String)localObject3);
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdirs();
      }
      Object localObject4 = new SimpleDateFormat("yy.MM.dd");
      Object localObject2 = "10000";
      localObject1 = localObject2;
      if (this.i != null)
      {
        localObject1 = localObject2;
        if (this.i.sender != null)
        {
          localObject1 = localObject2;
          if (this.i.sender.l().length() > 4) {
            localObject1 = this.i.sender.l();
          }
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject3);
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(((SimpleDateFormat)localObject4).format(paramCalendar.getTime()));
      ((StringBuilder)localObject2).append(".log");
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new File((String)localObject1);
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      PrintWriter localPrintWriter = new PrintWriter(new BufferedWriter(new FileWriter((String)localObject1, true)));
      try
      {
        localObject2 = BaseApplication.getContext().getPackageManager();
        localObject1 = ((PackageManager)localObject2).getPackageInfo("com.tencent.mobileqq", 128);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((PackageInfo)localObject1).versionName);
        ((StringBuilder)localObject3).append(".");
        ((StringBuilder)localObject3).append(((PackageInfo)localObject1).versionCode);
        localObject1 = ((StringBuilder)localObject3).toString();
        try
        {
          localObject2 = ((PackageManager)localObject2).getApplicationInfo("com.tencent.mobileqq", 128).metaData.get("com.tencent.rdm.uuid").toString();
          localObject4 = localObject1;
        }
        catch (Exception localException3) {}
        localObject2 = localObject5;
      }
      catch (Exception localException4)
      {
        localObject1 = null;
      }
      localObject4 = localObject1;
      try
      {
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.C.MonitorNetFlowStore", 2, "initNetflowHead addHead fail!", localException4);
          localObject4 = localObject1;
          localObject2 = localObject5;
        }
        localPrintWriter.print("header|");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject4);
        ((StringBuilder)localObject1).append("|");
        localPrintWriter.print(((StringBuilder)localObject1).toString());
        localPrintWriter.print("846a9bfd|");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("pub");
        ((StringBuilder)localObject1).append("|");
        localPrintWriter.print(((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("|");
        localPrintWriter.print(((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(Build.MANUFACTURER);
        ((StringBuilder)localObject1).append("|");
        localPrintWriter.print(((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(Build.MODEL);
        ((StringBuilder)localObject1).append("|");
        localPrintWriter.print(((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(Build.VERSION.SDK_INT);
        ((StringBuilder)localObject1).append("|");
        localPrintWriter.print(((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramCalendar.getTimeInMillis());
        ((StringBuilder)localObject1).append("|");
        localPrintWriter.print(((StringBuilder)localObject1).toString());
        localPrintWriter.print("1.0|\r\n");
        localPrintWriter.flush();
        return localPrintWriter;
      }
      catch (Exception localException1)
      {
        paramCalendar = localPrintWriter;
      }
      if (!QLog.isColorLevel()) {
        return paramCalendar;
      }
    }
    catch (Exception localException2)
    {
      paramCalendar = null;
    }
    QLog.d("MSF.C.MonitorNetFlowStore", 2, "save netflow exception!", localException2);
    return paramCalendar;
  }
  
  private String a(String paramString)
  {
    String str;
    if (paramString != null)
    {
      if (paramString.equals("com.tencent.mobileqq")) {
        return "1";
      }
      if (paramString.endsWith("qzone")) {
        return "2";
      }
      if (paramString.endsWith("web")) {
        return "3";
      }
      if (paramString.endsWith("MSF")) {
        return "4";
      }
      if (paramString.endsWith("nearby")) {
        return "5";
      }
      if (paramString.endsWith("lola")) {
        return "6";
      }
      if (paramString.endsWith("tool")) {
        return "7";
      }
      if (paramString.endsWith("qzonelive")) {
        return "8";
      }
      if (paramString.endsWith("peak")) {
        return "9";
      }
      if (paramString.endsWith("readinjoy")) {
        return "10";
      }
      str = paramString;
      if (paramString.endsWith("TMAssistantDownloadSDKService")) {
        return "11";
      }
    }
    else
    {
      str = "0";
    }
    return str;
  }
  
  private void a(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MsfSdkUtils.getProcessName(paramContext));
    localStringBuilder.append("_");
    localStringBuilder.append(getClass().hashCode());
    this.n = localStringBuilder.toString();
    paramContext = new IntentFilter();
    paramContext.addAction(this.n);
    BaseApplication.getContext().registerReceiver(this, paramContext);
    if (QLog.isColorLevel())
    {
      a(System.currentTimeMillis() + 300000L);
      return;
    }
    a(System.currentTimeMillis() + 600000L);
  }
  
  /* Error */
  private void a(HashMap paramHashMap1, HashMap paramHashMap2)
  {
    // Byte code:
    //   0: getstatic 140	com/tencent/mobileqq/msf/core/d/d:y	Landroid/database/sqlite/SQLiteDatabase;
    //   3: ifnonnull +12 -> 15
    //   6: invokestatic 145	com/tencent/mobileqq/msf/core/d/c:a	()Lcom/tencent/mobileqq/msf/core/d/c;
    //   9: invokevirtual 149	com/tencent/mobileqq/msf/core/d/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   12: putstatic 140	com/tencent/mobileqq/msf/core/d/d:y	Landroid/database/sqlite/SQLiteDatabase;
    //   15: invokestatic 125	java/lang/System:currentTimeMillis	()J
    //   18: lstore 5
    //   20: invokestatic 401	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +70 -> 93
    //   26: new 228	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   33: astore 8
    //   35: aload 8
    //   37: ldc_w 521
    //   40: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 8
    //   46: aload_1
    //   47: invokevirtual 524	java/util/HashMap:size	()I
    //   50: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 8
    //   56: ldc_w 526
    //   59: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 8
    //   65: aload_2
    //   66: invokevirtual 524	java/util/HashMap:size	()I
    //   69: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 8
    //   75: ldc_w 528
    //   78: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: ldc 8
    //   84: iconst_2
    //   85: aload 8
    //   87: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: getstatic 140	com/tencent/mobileqq/msf/core/d/d:y	Landroid/database/sqlite/SQLiteDatabase;
    //   96: invokevirtual 531	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   99: aload_1
    //   100: invokevirtual 535	java/util/HashMap:keySet	()Ljava/util/Set;
    //   103: invokeinterface 541 1 0
    //   108: astore 9
    //   110: iconst_0
    //   111: istore_3
    //   112: aload 9
    //   114: invokeinterface 546 1 0
    //   119: istore 7
    //   121: ldc_w 548
    //   124: astore 8
    //   126: iload 7
    //   128: ifeq +376 -> 504
    //   131: aload 9
    //   133: invokeinterface 552 1 0
    //   138: checkcast 151	java/lang/String
    //   141: astore 8
    //   143: aload_1
    //   144: aload 8
    //   146: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   149: checkcast 557	com/tencent/mobileqq/msf/sdk/utils/b
    //   152: astore 10
    //   154: invokestatic 401	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   157: ifeq +876 -> 1033
    //   160: new 228	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   167: astore 11
    //   169: aload 11
    //   171: ldc_w 548
    //   174: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 11
    //   180: aload 10
    //   182: getfield 559	com/tencent/mobileqq/msf/sdk/utils/b:h	Ljava/lang/String;
    //   185: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 11
    //   191: ldc 239
    //   193: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 11
    //   199: aload 10
    //   201: getfield 561	com/tencent/mobileqq/msf/sdk/utils/b:c	Ljava/lang/String;
    //   204: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 11
    //   210: ldc 239
    //   212: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 11
    //   218: aload 10
    //   220: getfield 563	com/tencent/mobileqq/msf/sdk/utils/b:b	Ljava/lang/String;
    //   223: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 11
    //   229: ldc 239
    //   231: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 11
    //   237: aload 10
    //   239: getfield 565	com/tencent/mobileqq/msf/sdk/utils/b:d	I
    //   242: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload 11
    //   248: ldc_w 567
    //   251: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload 11
    //   257: aload 10
    //   259: getfield 569	com/tencent/mobileqq/msf/sdk/utils/b:f	J
    //   262: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 11
    //   268: ldc 239
    //   270: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 11
    //   276: aload 10
    //   278: getfield 571	com/tencent/mobileqq/msf/sdk/utils/b:g	I
    //   281: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload 11
    //   287: ldc 239
    //   289: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 11
    //   295: aload 10
    //   297: getfield 574	com/tencent/mobileqq/msf/sdk/utils/b:i	B
    //   300: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload 11
    //   306: ldc 239
    //   308: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 11
    //   314: aload 10
    //   316: getfield 576	com/tencent/mobileqq/msf/sdk/utils/b:a	Ljava/lang/String;
    //   319: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: ldc 8
    //   325: iconst_2
    //   326: aload 11
    //   328: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   334: goto +3 -> 337
    //   337: aload 10
    //   339: getfield 578	com/tencent/mobileqq/msf/sdk/utils/b:k	J
    //   342: lconst_0
    //   343: lcmp
    //   344: ifle +692 -> 1036
    //   347: aload 10
    //   349: getfield 578	com/tencent/mobileqq/msf/sdk/utils/b:k	J
    //   352: lstore 5
    //   354: goto +3 -> 357
    //   357: getstatic 140	com/tencent/mobileqq/msf/core/d/d:y	Landroid/database/sqlite/SQLiteDatabase;
    //   360: ldc_w 580
    //   363: bipush 11
    //   365: anewarray 397	java/lang/Object
    //   368: dup
    //   369: iconst_0
    //   370: aload 10
    //   372: getfield 576	com/tencent/mobileqq/msf/sdk/utils/b:a	Ljava/lang/String;
    //   375: aastore
    //   376: dup
    //   377: iconst_1
    //   378: aload_0
    //   379: getfield 92	com/tencent/mobileqq/msf/core/d/d:i	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   382: getfield 317	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   385: invokevirtual 321	com/tencent/mobileqq/msf/core/ad:l	()Ljava/lang/String;
    //   388: aastore
    //   389: dup
    //   390: iconst_2
    //   391: aload 10
    //   393: getfield 563	com/tencent/mobileqq/msf/sdk/utils/b:b	Ljava/lang/String;
    //   396: aastore
    //   397: dup
    //   398: iconst_3
    //   399: aload 10
    //   401: getfield 561	com/tencent/mobileqq/msf/sdk/utils/b:c	Ljava/lang/String;
    //   404: aastore
    //   405: dup
    //   406: iconst_4
    //   407: aload 10
    //   409: getfield 565	com/tencent/mobileqq/msf/sdk/utils/b:d	I
    //   412: invokestatic 585	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   415: aastore
    //   416: dup
    //   417: iconst_5
    //   418: aload 10
    //   420: getfield 587	com/tencent/mobileqq/msf/sdk/utils/b:e	I
    //   423: invokestatic 585	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   426: aastore
    //   427: dup
    //   428: bipush 6
    //   430: aload 10
    //   432: getfield 569	com/tencent/mobileqq/msf/sdk/utils/b:f	J
    //   435: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   438: aastore
    //   439: dup
    //   440: bipush 7
    //   442: aload 10
    //   444: getfield 571	com/tencent/mobileqq/msf/sdk/utils/b:g	I
    //   447: invokestatic 585	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   450: aastore
    //   451: dup
    //   452: bipush 8
    //   454: aload 10
    //   456: getfield 559	com/tencent/mobileqq/msf/sdk/utils/b:h	Ljava/lang/String;
    //   459: aastore
    //   460: dup
    //   461: bipush 9
    //   463: lload 5
    //   465: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   468: aastore
    //   469: dup
    //   470: bipush 10
    //   472: aload 10
    //   474: getfield 574	com/tencent/mobileqq/msf/sdk/utils/b:i	B
    //   477: invokestatic 592	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   480: aastore
    //   481: invokevirtual 596	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   484: iload_3
    //   485: i2l
    //   486: aload_1
    //   487: aload 8
    //   489: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   492: checkcast 557	com/tencent/mobileqq/msf/sdk/utils/b
    //   495: getfield 569	com/tencent/mobileqq/msf/sdk/utils/b:f	J
    //   498: ladd
    //   499: l2i
    //   500: istore_3
    //   501: goto -389 -> 112
    //   504: aload_2
    //   505: invokevirtual 535	java/util/HashMap:keySet	()Ljava/util/Set;
    //   508: invokeinterface 541 1 0
    //   513: astore 9
    //   515: iconst_0
    //   516: istore 4
    //   518: aload 8
    //   520: astore_1
    //   521: aload 9
    //   523: invokeinterface 546 1 0
    //   528: ifeq +370 -> 898
    //   531: aload 9
    //   533: invokeinterface 552 1 0
    //   538: checkcast 151	java/lang/String
    //   541: astore 8
    //   543: aload_2
    //   544: aload 8
    //   546: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   549: checkcast 557	com/tencent/mobileqq/msf/sdk/utils/b
    //   552: astore 10
    //   554: invokestatic 401	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   557: ifeq +175 -> 732
    //   560: new 228	java/lang/StringBuilder
    //   563: dup
    //   564: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   567: astore 11
    //   569: aload 11
    //   571: aload_1
    //   572: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: pop
    //   576: aload 11
    //   578: aload 10
    //   580: getfield 559	com/tencent/mobileqq/msf/sdk/utils/b:h	Ljava/lang/String;
    //   583: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: pop
    //   587: aload 11
    //   589: ldc 239
    //   591: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: pop
    //   595: aload 11
    //   597: aload 10
    //   599: getfield 561	com/tencent/mobileqq/msf/sdk/utils/b:c	Ljava/lang/String;
    //   602: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: pop
    //   606: aload 11
    //   608: ldc 239
    //   610: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: pop
    //   614: aload 11
    //   616: aload 10
    //   618: getfield 563	com/tencent/mobileqq/msf/sdk/utils/b:b	Ljava/lang/String;
    //   621: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: pop
    //   625: aload 11
    //   627: ldc 239
    //   629: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: pop
    //   633: aload 11
    //   635: aload 10
    //   637: getfield 565	com/tencent/mobileqq/msf/sdk/utils/b:d	I
    //   640: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   643: pop
    //   644: aload 11
    //   646: ldc_w 598
    //   649: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: pop
    //   653: aload 11
    //   655: aload 10
    //   657: getfield 569	com/tencent/mobileqq/msf/sdk/utils/b:f	J
    //   660: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   663: pop
    //   664: aload 11
    //   666: ldc 239
    //   668: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: pop
    //   672: aload 11
    //   674: aload 10
    //   676: getfield 571	com/tencent/mobileqq/msf/sdk/utils/b:g	I
    //   679: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   682: pop
    //   683: aload 11
    //   685: ldc 239
    //   687: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: pop
    //   691: aload 11
    //   693: aload 10
    //   695: getfield 574	com/tencent/mobileqq/msf/sdk/utils/b:i	B
    //   698: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   701: pop
    //   702: aload 11
    //   704: ldc 239
    //   706: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: pop
    //   710: aload 11
    //   712: aload 10
    //   714: getfield 576	com/tencent/mobileqq/msf/sdk/utils/b:a	Ljava/lang/String;
    //   717: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: pop
    //   721: ldc 8
    //   723: iconst_2
    //   724: aload 11
    //   726: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   729: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   732: aload 10
    //   734: getfield 578	com/tencent/mobileqq/msf/sdk/utils/b:k	J
    //   737: lconst_0
    //   738: lcmp
    //   739: ifle +10 -> 749
    //   742: aload 10
    //   744: getfield 578	com/tencent/mobileqq/msf/sdk/utils/b:k	J
    //   747: lstore 5
    //   749: getstatic 140	com/tencent/mobileqq/msf/core/d/d:y	Landroid/database/sqlite/SQLiteDatabase;
    //   752: ldc_w 580
    //   755: bipush 11
    //   757: anewarray 397	java/lang/Object
    //   760: dup
    //   761: iconst_0
    //   762: aload 10
    //   764: getfield 576	com/tencent/mobileqq/msf/sdk/utils/b:a	Ljava/lang/String;
    //   767: aastore
    //   768: dup
    //   769: iconst_1
    //   770: aload_0
    //   771: getfield 92	com/tencent/mobileqq/msf/core/d/d:i	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   774: getfield 317	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   777: invokevirtual 321	com/tencent/mobileqq/msf/core/ad:l	()Ljava/lang/String;
    //   780: aastore
    //   781: dup
    //   782: iconst_2
    //   783: aload 10
    //   785: getfield 563	com/tencent/mobileqq/msf/sdk/utils/b:b	Ljava/lang/String;
    //   788: aastore
    //   789: dup
    //   790: iconst_3
    //   791: aload 10
    //   793: getfield 561	com/tencent/mobileqq/msf/sdk/utils/b:c	Ljava/lang/String;
    //   796: aastore
    //   797: dup
    //   798: iconst_4
    //   799: aload 10
    //   801: getfield 565	com/tencent/mobileqq/msf/sdk/utils/b:d	I
    //   804: invokestatic 585	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   807: aastore
    //   808: dup
    //   809: iconst_5
    //   810: aload 10
    //   812: getfield 587	com/tencent/mobileqq/msf/sdk/utils/b:e	I
    //   815: invokestatic 585	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   818: aastore
    //   819: dup
    //   820: bipush 6
    //   822: aload 10
    //   824: getfield 569	com/tencent/mobileqq/msf/sdk/utils/b:f	J
    //   827: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   830: aastore
    //   831: dup
    //   832: bipush 7
    //   834: aload 10
    //   836: getfield 571	com/tencent/mobileqq/msf/sdk/utils/b:g	I
    //   839: invokestatic 585	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   842: aastore
    //   843: dup
    //   844: bipush 8
    //   846: aload 10
    //   848: getfield 559	com/tencent/mobileqq/msf/sdk/utils/b:h	Ljava/lang/String;
    //   851: aastore
    //   852: dup
    //   853: bipush 9
    //   855: lload 5
    //   857: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   860: aastore
    //   861: dup
    //   862: bipush 10
    //   864: aload 10
    //   866: getfield 574	com/tencent/mobileqq/msf/sdk/utils/b:i	B
    //   869: invokestatic 592	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   872: aastore
    //   873: invokevirtual 596	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   876: iload 4
    //   878: i2l
    //   879: aload_2
    //   880: aload 8
    //   882: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   885: checkcast 557	com/tencent/mobileqq/msf/sdk/utils/b
    //   888: getfield 569	com/tencent/mobileqq/msf/sdk/utils/b:f	J
    //   891: ladd
    //   892: l2i
    //   893: istore 4
    //   895: goto -374 -> 521
    //   898: getstatic 140	com/tencent/mobileqq/msf/core/d/d:y	Landroid/database/sqlite/SQLiteDatabase;
    //   901: invokevirtual 601	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   904: getstatic 140	com/tencent/mobileqq/msf/core/d/d:y	Landroid/database/sqlite/SQLiteDatabase;
    //   907: invokevirtual 604	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   910: new 228	java/lang/StringBuilder
    //   913: dup
    //   914: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   917: astore_1
    //   918: aload_1
    //   919: ldc_w 606
    //   922: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   925: pop
    //   926: aload_1
    //   927: iload_3
    //   928: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   931: pop
    //   932: aload_1
    //   933: ldc_w 608
    //   936: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: pop
    //   940: aload_1
    //   941: iload 4
    //   943: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   946: pop
    //   947: aload_1
    //   948: ldc_w 610
    //   951: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   954: pop
    //   955: ldc 8
    //   957: iconst_1
    //   958: aload_1
    //   959: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   962: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   965: getstatic 140	com/tencent/mobileqq/msf/core/d/d:y	Landroid/database/sqlite/SQLiteDatabase;
    //   968: astore_1
    //   969: aload_1
    //   970: ifnull +38 -> 1008
    //   973: aload_1
    //   974: invokevirtual 611	android/database/sqlite/SQLiteDatabase:close	()V
    //   977: aconst_null
    //   978: putstatic 140	com/tencent/mobileqq/msf/core/d/d:y	Landroid/database/sqlite/SQLiteDatabase;
    //   981: return
    //   982: astore_1
    //   983: goto +26 -> 1009
    //   986: astore_1
    //   987: ldc 8
    //   989: iconst_1
    //   990: ldc_w 613
    //   993: aload_1
    //   994: invokestatic 615	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   997: getstatic 140	com/tencent/mobileqq/msf/core/d/d:y	Landroid/database/sqlite/SQLiteDatabase;
    //   1000: astore_1
    //   1001: aload_1
    //   1002: ifnull +6 -> 1008
    //   1005: goto -32 -> 973
    //   1008: return
    //   1009: getstatic 140	com/tencent/mobileqq/msf/core/d/d:y	Landroid/database/sqlite/SQLiteDatabase;
    //   1012: astore_2
    //   1013: aload_2
    //   1014: ifnull +11 -> 1025
    //   1017: aload_2
    //   1018: invokevirtual 611	android/database/sqlite/SQLiteDatabase:close	()V
    //   1021: aconst_null
    //   1022: putstatic 140	com/tencent/mobileqq/msf/core/d/d:y	Landroid/database/sqlite/SQLiteDatabase;
    //   1025: goto +5 -> 1030
    //   1028: aload_1
    //   1029: athrow
    //   1030: goto -2 -> 1028
    //   1033: goto -696 -> 337
    //   1036: goto -679 -> 357
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1039	0	this	d
    //   0	1039	1	paramHashMap1	HashMap
    //   0	1039	2	paramHashMap2	HashMap
    //   111	817	3	i1	int
    //   516	426	4	i2	int
    //   18	838	5	l1	long
    //   119	8	7	bool	boolean
    //   33	848	8	localObject	Object
    //   108	424	9	localIterator	java.util.Iterator
    //   152	713	10	localb	b
    //   167	558	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	15	982	finally
    //   15	93	982	finally
    //   93	110	982	finally
    //   112	121	982	finally
    //   131	334	982	finally
    //   337	354	982	finally
    //   357	501	982	finally
    //   504	515	982	finally
    //   521	732	982	finally
    //   732	749	982	finally
    //   749	895	982	finally
    //   898	965	982	finally
    //   987	997	982	finally
    //   0	15	986	java/lang/Exception
    //   15	93	986	java/lang/Exception
    //   93	110	986	java/lang/Exception
    //   112	121	986	java/lang/Exception
    //   131	334	986	java/lang/Exception
    //   337	354	986	java/lang/Exception
    //   357	501	986	java/lang/Exception
    //   504	515	986	java/lang/Exception
    //   521	732	986	java/lang/Exception
    //   732	749	986	java/lang/Exception
    //   749	895	986	java/lang/Exception
    //   898	965	986	java/lang/Exception
  }
  
  public static void b(long paramLong)
  {
    try
    {
      if (y == null) {
        y = c.a().getWritableDatabase();
      }
      int i1 = y.delete("dataflow", "curtime < ?", new String[] { String.valueOf(paramLong) });
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("delete netflow ");
        localStringBuilder1.append(i1);
        localStringBuilder1.append(" record.");
        QLog.d("MSF.C.MonitorNetFlowStore", 4, localStringBuilder1.toString());
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("delete expire data failed. ");
      localStringBuilder2.append(localException);
      QLog.d("MSF.C.MonitorNetFlowStore", 1, localStringBuilder2.toString(), localException);
    }
  }
  
  /* Error */
  public HashMap a(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 94	com/tencent/mobileqq/msf/core/d/d:j	Landroid/content/Context;
    //   3: invokevirtual 636	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   6: ldc_w 638
    //   9: invokevirtual 644	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: astore 22
    //   14: new 646	java/util/Properties
    //   17: dup
    //   18: invokespecial 647	java/util/Properties:<init>	()V
    //   21: astore 24
    //   23: aload 24
    //   25: aload 22
    //   27: invokevirtual 651	java/util/Properties:loadFromXML	(Ljava/io/InputStream;)V
    //   30: invokestatic 655	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   33: astore 18
    //   35: aload 18
    //   37: bipush 6
    //   39: aload 18
    //   41: bipush 6
    //   43: invokevirtual 657	java/util/Calendar:get	(I)I
    //   46: iconst_1
    //   47: isub
    //   48: invokevirtual 661	java/util/Calendar:set	(II)V
    //   51: aload 18
    //   53: bipush 11
    //   55: iconst_0
    //   56: invokevirtual 661	java/util/Calendar:set	(II)V
    //   59: aload 18
    //   61: bipush 12
    //   63: iconst_0
    //   64: invokevirtual 661	java/util/Calendar:set	(II)V
    //   67: aload 18
    //   69: bipush 13
    //   71: iconst_0
    //   72: invokevirtual 661	java/util/Calendar:set	(II)V
    //   75: aload 18
    //   77: bipush 14
    //   79: iconst_0
    //   80: invokevirtual 661	java/util/Calendar:set	(II)V
    //   83: aload 18
    //   85: invokevirtual 428	java/util/Calendar:getTimeInMillis	()J
    //   88: lstore 9
    //   90: ldc2_w 662
    //   93: lload 9
    //   95: ladd
    //   96: lstore_1
    //   97: getstatic 140	com/tencent/mobileqq/msf/core/d/d:y	Landroid/database/sqlite/SQLiteDatabase;
    //   100: ifnonnull +12 -> 112
    //   103: invokestatic 145	com/tencent/mobileqq/msf/core/d/c:a	()Lcom/tencent/mobileqq/msf/core/d/c;
    //   106: invokevirtual 149	com/tencent/mobileqq/msf/core/d/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   109: putstatic 140	com/tencent/mobileqq/msf/core/d/d:y	Landroid/database/sqlite/SQLiteDatabase;
    //   112: new 77	java/util/HashMap
    //   115: dup
    //   116: invokespecial 78	java/util/HashMap:<init>	()V
    //   119: astore 23
    //   121: iconst_0
    //   122: istore 4
    //   124: iload 4
    //   126: iconst_5
    //   127: if_icmpge +1529 -> 1656
    //   130: iload_3
    //   131: ifeq +90 -> 221
    //   134: getstatic 140	com/tencent/mobileqq/msf/core/d/d:y	Landroid/database/sqlite/SQLiteDatabase;
    //   137: ldc 28
    //   139: bipush 6
    //   141: anewarray 151	java/lang/String
    //   144: dup
    //   145: iconst_0
    //   146: ldc 153
    //   148: aastore
    //   149: dup
    //   150: iconst_1
    //   151: ldc 155
    //   153: aastore
    //   154: dup
    //   155: iconst_2
    //   156: ldc 157
    //   158: aastore
    //   159: dup
    //   160: iconst_3
    //   161: ldc 161
    //   163: aastore
    //   164: dup
    //   165: iconst_4
    //   166: ldc 163
    //   168: aastore
    //   169: dup
    //   170: iconst_5
    //   171: ldc_w 665
    //   174: aastore
    //   175: ldc_w 667
    //   178: iconst_3
    //   179: anewarray 151	java/lang/String
    //   182: dup
    //   183: iconst_0
    //   184: lload 9
    //   186: invokestatic 173	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   189: aastore
    //   190: dup
    //   191: iconst_1
    //   192: lload_1
    //   193: invokestatic 173	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   196: aastore
    //   197: dup
    //   198: iconst_2
    //   199: iload 4
    //   201: invokestatic 669	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   204: aastore
    //   205: aconst_null
    //   206: aconst_null
    //   207: aconst_null
    //   208: invokevirtual 179	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   211: astore 18
    //   213: goto +101 -> 314
    //   216: astore 19
    //   218: goto +1345 -> 1563
    //   221: getstatic 140	com/tencent/mobileqq/msf/core/d/d:y	Landroid/database/sqlite/SQLiteDatabase;
    //   224: ldc 28
    //   226: bipush 6
    //   228: anewarray 151	java/lang/String
    //   231: dup
    //   232: iconst_0
    //   233: ldc 153
    //   235: aastore
    //   236: dup
    //   237: iconst_1
    //   238: ldc 155
    //   240: aastore
    //   241: dup
    //   242: iconst_2
    //   243: ldc 157
    //   245: aastore
    //   246: dup
    //   247: iconst_3
    //   248: ldc 161
    //   250: aastore
    //   251: dup
    //   252: iconst_4
    //   253: ldc 163
    //   255: aastore
    //   256: dup
    //   257: iconst_5
    //   258: ldc_w 665
    //   261: aastore
    //   262: ldc_w 671
    //   265: iconst_5
    //   266: anewarray 151	java/lang/String
    //   269: dup
    //   270: iconst_0
    //   271: lload 9
    //   273: invokestatic 173	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   276: aastore
    //   277: dup
    //   278: iconst_1
    //   279: lload_1
    //   280: invokestatic 173	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   283: aastore
    //   284: dup
    //   285: iconst_2
    //   286: iconst_2
    //   287: invokestatic 669	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   290: aastore
    //   291: dup
    //   292: iconst_3
    //   293: iconst_3
    //   294: invokestatic 669	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   297: aastore
    //   298: dup
    //   299: iconst_4
    //   300: iload 4
    //   302: invokestatic 669	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   305: aastore
    //   306: aconst_null
    //   307: aconst_null
    //   308: aconst_null
    //   309: invokevirtual 179	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   312: astore 18
    //   314: aload 18
    //   316: ifnonnull +17 -> 333
    //   319: aload 18
    //   321: ifnull +10 -> 331
    //   324: aload 18
    //   326: invokeinterface 184 1 0
    //   331: aconst_null
    //   332: areturn
    //   333: lload 9
    //   335: lstore 13
    //   337: lload_1
    //   338: lstore 11
    //   340: aload 18
    //   342: invokeinterface 223 1 0
    //   347: pop
    //   348: iload 4
    //   350: ifne +1696 -> 2046
    //   353: iconst_1
    //   354: istore 6
    //   356: goto +3 -> 359
    //   359: lload 9
    //   361: lstore 13
    //   363: lload_1
    //   364: lstore 11
    //   366: aload 18
    //   368: invokeinterface 226 1 0
    //   373: ifne +1120 -> 1493
    //   376: lload 9
    //   378: lstore 13
    //   380: lload_1
    //   381: lstore 11
    //   383: aload 18
    //   385: iconst_0
    //   386: invokeinterface 233 2 0
    //   391: astore 21
    //   393: lload 9
    //   395: lstore 13
    //   397: lload_1
    //   398: lstore 11
    //   400: aload 18
    //   402: iconst_1
    //   403: invokeinterface 233 2 0
    //   408: astore 25
    //   410: lload 9
    //   412: lstore 13
    //   414: lload_1
    //   415: lstore 11
    //   417: aload 18
    //   419: iconst_2
    //   420: invokeinterface 249 2 0
    //   425: lstore 15
    //   427: aload 18
    //   429: iconst_3
    //   430: invokeinterface 233 2 0
    //   435: astore 20
    //   437: aload 18
    //   439: iconst_4
    //   440: invokeinterface 256 2 0
    //   445: istore 7
    //   447: iload 7
    //   449: iconst_3
    //   450: if_icmpeq +1603 -> 2053
    //   453: iload 7
    //   455: iconst_2
    //   456: if_icmpeq +1597 -> 2053
    //   459: iconst_1
    //   460: istore 5
    //   462: goto +3 -> 465
    //   465: aload 20
    //   467: astore 19
    //   469: aload 21
    //   471: ldc_w 453
    //   474: invokevirtual 445	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   477: ifne +1598 -> 2075
    //   480: aload 20
    //   482: astore 19
    //   484: aload 20
    //   486: ldc_w 673
    //   489: invokevirtual 437	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   492: ifne +1583 -> 2075
    //   495: aload 20
    //   497: astore 19
    //   499: aload 20
    //   501: ldc_w 675
    //   504: invokevirtual 437	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   507: ifne +1568 -> 2075
    //   510: aload 20
    //   512: astore 19
    //   514: aload 20
    //   516: ldc_w 677
    //   519: invokevirtual 437	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   522: ifne +1553 -> 2075
    //   525: aload 21
    //   527: ldc_w 449
    //   530: invokevirtual 445	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   533: ifeq +10 -> 543
    //   536: aload 20
    //   538: astore 19
    //   540: goto +1535 -> 2075
    //   543: aload 21
    //   545: ldc_w 679
    //   548: invokevirtual 445	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   551: ifeq +11 -> 562
    //   554: ldc_w 441
    //   557: astore 19
    //   559: goto +1516 -> 2075
    //   562: aload 20
    //   564: astore 19
    //   566: aload 21
    //   568: ldc_w 681
    //   571: invokevirtual 685	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   574: ifeq +1501 -> 2075
    //   577: aload 21
    //   579: ldc_w 681
    //   582: invokevirtual 689	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   585: istore 7
    //   587: new 228	java/lang/StringBuilder
    //   590: dup
    //   591: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   594: astore 19
    //   596: iload 7
    //   598: iconst_2
    //   599: iadd
    //   600: istore 8
    //   602: aload 19
    //   604: aload 21
    //   606: iload 7
    //   608: iconst_1
    //   609: iadd
    //   610: iload 8
    //   612: invokevirtual 693	java/lang/String:substring	(II)Ljava/lang/String;
    //   615: invokevirtual 696	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   618: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: aload 19
    //   624: aload 21
    //   626: iload 8
    //   628: invokevirtual 698	java/lang/String:substring	(I)Ljava/lang/String;
    //   631: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: aload 19
    //   637: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   640: astore 19
    //   642: aload 19
    //   644: ldc 11
    //   646: invokevirtual 701	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   649: ifeq +46 -> 695
    //   652: new 228	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   659: astore 20
    //   661: aload 20
    //   663: ldc 11
    //   665: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: aload 20
    //   671: iload 5
    //   673: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   676: pop
    //   677: aload 24
    //   679: aload 20
    //   681: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   684: invokevirtual 702	java/util/Properties:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   687: checkcast 151	java/lang/String
    //   690: astore 20
    //   692: goto +43 -> 735
    //   695: new 228	java/lang/StringBuilder
    //   698: dup
    //   699: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   702: astore 20
    //   704: aload 20
    //   706: aload 19
    //   708: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: pop
    //   712: aload 20
    //   714: iload 5
    //   716: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   719: pop
    //   720: aload 24
    //   722: aload 20
    //   724: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   727: invokevirtual 702	java/util/Properties:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   730: checkcast 151	java/lang/String
    //   733: astore 20
    //   735: aload 23
    //   737: aload 25
    //   739: invokevirtual 705	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   742: istore 17
    //   744: iload 17
    //   746: ifeq +399 -> 1145
    //   749: aload 23
    //   751: aload 25
    //   753: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   756: checkcast 707	android/util/SparseArray
    //   759: iload 6
    //   761: invokevirtual 710	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   764: ifnonnull +29 -> 793
    //   767: new 77	java/util/HashMap
    //   770: dup
    //   771: invokespecial 78	java/util/HashMap:<init>	()V
    //   774: astore 21
    //   776: aload 23
    //   778: aload 25
    //   780: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   783: checkcast 707	android/util/SparseArray
    //   786: iload 6
    //   788: aload 21
    //   790: invokevirtual 714	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   793: aload 20
    //   795: ifnonnull +204 -> 999
    //   798: new 228	java/lang/StringBuilder
    //   801: dup
    //   802: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   805: astore 26
    //   807: iload 5
    //   809: iconst_1
    //   810: if_icmpne +1268 -> 2078
    //   813: ldc_w 716
    //   816: astore 21
    //   818: goto +3 -> 821
    //   821: aload 26
    //   823: aload 21
    //   825: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: pop
    //   829: aload 26
    //   831: aload 19
    //   833: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: pop
    //   837: aload 26
    //   839: ldc_w 718
    //   842: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: pop
    //   846: aload 26
    //   848: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   851: astore 19
    //   853: aload 23
    //   855: aload 25
    //   857: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   860: checkcast 707	android/util/SparseArray
    //   863: iload 6
    //   865: invokevirtual 710	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   868: checkcast 77	java/util/HashMap
    //   871: aload 19
    //   873: invokevirtual 705	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   876: ifeq +70 -> 946
    //   879: aload 23
    //   881: aload 25
    //   883: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   886: checkcast 707	android/util/SparseArray
    //   889: iload 6
    //   891: invokevirtual 710	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   894: checkcast 77	java/util/HashMap
    //   897: astore 21
    //   899: aload 21
    //   901: aload 19
    //   903: aload 21
    //   905: aload 19
    //   907: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   910: checkcast 261	java/lang/Long
    //   913: invokevirtual 721	java/lang/Long:longValue	()J
    //   916: lload 15
    //   918: ladd
    //   919: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   922: invokevirtual 724	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   925: pop
    //   926: aload 23
    //   928: aload 25
    //   930: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   933: checkcast 707	android/util/SparseArray
    //   936: iload 6
    //   938: aload 21
    //   940: invokevirtual 714	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   943: goto +365 -> 1308
    //   946: aload 23
    //   948: aload 25
    //   950: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   953: checkcast 707	android/util/SparseArray
    //   956: iload 6
    //   958: invokevirtual 710	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   961: checkcast 77	java/util/HashMap
    //   964: astore 21
    //   966: aload 21
    //   968: aload 19
    //   970: lload 15
    //   972: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   975: invokevirtual 724	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   978: pop
    //   979: aload 23
    //   981: aload 25
    //   983: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   986: checkcast 707	android/util/SparseArray
    //   989: iload 6
    //   991: aload 21
    //   993: invokevirtual 714	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   996: goto +312 -> 1308
    //   999: aload 23
    //   1001: aload 25
    //   1003: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1006: checkcast 707	android/util/SparseArray
    //   1009: iload 6
    //   1011: invokevirtual 710	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1014: checkcast 77	java/util/HashMap
    //   1017: aload 20
    //   1019: invokevirtual 705	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1022: ifeq +70 -> 1092
    //   1025: aload 23
    //   1027: aload 25
    //   1029: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1032: checkcast 707	android/util/SparseArray
    //   1035: iload 6
    //   1037: invokevirtual 710	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1040: checkcast 77	java/util/HashMap
    //   1043: astore 21
    //   1045: aload 21
    //   1047: aload 20
    //   1049: aload 21
    //   1051: aload 20
    //   1053: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1056: checkcast 261	java/lang/Long
    //   1059: invokevirtual 721	java/lang/Long:longValue	()J
    //   1062: lload 15
    //   1064: ladd
    //   1065: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1068: invokevirtual 724	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1071: pop
    //   1072: aload 23
    //   1074: aload 25
    //   1076: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1079: checkcast 707	android/util/SparseArray
    //   1082: iload 6
    //   1084: aload 21
    //   1086: invokevirtual 714	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1089: goto +219 -> 1308
    //   1092: aload 23
    //   1094: aload 25
    //   1096: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1099: checkcast 707	android/util/SparseArray
    //   1102: iload 6
    //   1104: invokevirtual 710	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1107: checkcast 77	java/util/HashMap
    //   1110: astore 21
    //   1112: aload 21
    //   1114: aload 20
    //   1116: lload 15
    //   1118: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1121: invokevirtual 724	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1124: pop
    //   1125: aload 23
    //   1127: aload 25
    //   1129: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1132: checkcast 707	android/util/SparseArray
    //   1135: iload 6
    //   1137: aload 21
    //   1139: invokevirtual 714	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1142: goto +166 -> 1308
    //   1145: aload 20
    //   1147: ifnonnull +111 -> 1258
    //   1150: new 228	java/lang/StringBuilder
    //   1153: dup
    //   1154: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1157: astore 26
    //   1159: iload 5
    //   1161: iconst_1
    //   1162: if_icmpne +924 -> 2086
    //   1165: ldc_w 716
    //   1168: astore 21
    //   1170: goto +3 -> 1173
    //   1173: aload 26
    //   1175: aload 21
    //   1177: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1180: pop
    //   1181: aload 26
    //   1183: aload 19
    //   1185: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1188: pop
    //   1189: aload 26
    //   1191: ldc_w 718
    //   1194: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1197: pop
    //   1198: aload 26
    //   1200: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1203: astore 19
    //   1205: new 77	java/util/HashMap
    //   1208: dup
    //   1209: invokespecial 78	java/util/HashMap:<init>	()V
    //   1212: astore 21
    //   1214: aload 21
    //   1216: aload 19
    //   1218: lload 15
    //   1220: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1223: invokevirtual 724	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1226: pop
    //   1227: new 707	android/util/SparseArray
    //   1230: dup
    //   1231: invokespecial 725	android/util/SparseArray:<init>	()V
    //   1234: astore 26
    //   1236: aload 26
    //   1238: iload 6
    //   1240: aload 21
    //   1242: invokevirtual 714	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1245: aload 23
    //   1247: aload 25
    //   1249: aload 26
    //   1251: invokevirtual 724	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1254: pop
    //   1255: goto +53 -> 1308
    //   1258: new 77	java/util/HashMap
    //   1261: dup
    //   1262: invokespecial 78	java/util/HashMap:<init>	()V
    //   1265: astore 21
    //   1267: aload 21
    //   1269: aload 20
    //   1271: lload 15
    //   1273: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1276: invokevirtual 724	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1279: pop
    //   1280: new 707	android/util/SparseArray
    //   1283: dup
    //   1284: invokespecial 725	android/util/SparseArray:<init>	()V
    //   1287: astore 26
    //   1289: aload 26
    //   1291: iload 6
    //   1293: aload 21
    //   1295: invokevirtual 714	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1298: aload 23
    //   1300: aload 25
    //   1302: aload 26
    //   1304: invokevirtual 724	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1307: pop
    //   1308: iload_3
    //   1309: ifeq +19 -> 1328
    //   1312: aload 20
    //   1314: ifnull +14 -> 1328
    //   1317: aload 20
    //   1319: ldc_w 716
    //   1322: invokevirtual 701	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1325: ifne +18 -> 1343
    //   1328: iload_3
    //   1329: ifeq +143 -> 1472
    //   1332: aload 19
    //   1334: ldc_w 716
    //   1337: invokevirtual 701	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1340: ifeq +132 -> 1472
    //   1343: aload 23
    //   1345: aload 25
    //   1347: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1350: checkcast 707	android/util/SparseArray
    //   1353: iload 6
    //   1355: invokevirtual 710	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1358: checkcast 77	java/util/HashMap
    //   1361: astore 20
    //   1363: aload 20
    //   1365: astore 19
    //   1367: aload 20
    //   1369: ifnonnull +12 -> 1381
    //   1372: new 77	java/util/HashMap
    //   1375: dup
    //   1376: invokespecial 78	java/util/HashMap:<init>	()V
    //   1379: astore 19
    //   1381: aload 19
    //   1383: ldc_w 727
    //   1386: invokevirtual 705	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1389: ifeq +52 -> 1441
    //   1392: aload 19
    //   1394: ldc_w 727
    //   1397: aload 19
    //   1399: ldc_w 727
    //   1402: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1405: checkcast 261	java/lang/Long
    //   1408: invokevirtual 721	java/lang/Long:longValue	()J
    //   1411: lload 15
    //   1413: ladd
    //   1414: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1417: invokevirtual 724	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1420: pop
    //   1421: aload 23
    //   1423: aload 25
    //   1425: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1428: checkcast 707	android/util/SparseArray
    //   1431: iload 6
    //   1433: aload 19
    //   1435: invokevirtual 714	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1438: goto +34 -> 1472
    //   1441: aload 19
    //   1443: ldc_w 727
    //   1446: lload 15
    //   1448: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1451: invokevirtual 724	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1454: pop
    //   1455: aload 23
    //   1457: aload 25
    //   1459: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1462: checkcast 707	android/util/SparseArray
    //   1465: iload 6
    //   1467: aload 19
    //   1469: invokevirtual 714	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1472: aload 18
    //   1474: invokeinterface 279 1 0
    //   1479: pop
    //   1480: goto -1121 -> 359
    //   1483: astore 19
    //   1485: goto +58 -> 1543
    //   1488: astore 19
    //   1490: goto +53 -> 1543
    //   1493: lload 9
    //   1495: lstore 11
    //   1497: lload_1
    //   1498: lstore 13
    //   1500: lload 11
    //   1502: lstore 9
    //   1504: lload 13
    //   1506: lstore_1
    //   1507: aload 18
    //   1509: ifnull +585 -> 2094
    //   1512: aload 18
    //   1514: invokeinterface 184 1 0
    //   1519: lload 11
    //   1521: lstore 9
    //   1523: lload 13
    //   1525: lstore_1
    //   1526: goto +568 -> 2094
    //   1529: astore 19
    //   1531: goto +110 -> 1641
    //   1534: astore 19
    //   1536: lload 13
    //   1538: lstore 9
    //   1540: lload 11
    //   1542: lstore_1
    //   1543: lload 9
    //   1545: lstore 11
    //   1547: lload_1
    //   1548: lstore 13
    //   1550: goto +23 -> 1573
    //   1553: astore 19
    //   1555: aconst_null
    //   1556: astore 18
    //   1558: goto +83 -> 1641
    //   1561: astore 19
    //   1563: aconst_null
    //   1564: astore 18
    //   1566: lload_1
    //   1567: lstore 13
    //   1569: lload 9
    //   1571: lstore 11
    //   1573: new 228	java/lang/StringBuilder
    //   1576: dup
    //   1577: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1580: astore 20
    //   1582: aload 20
    //   1584: ldc_w 729
    //   1587: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1590: pop
    //   1591: aload 20
    //   1593: aload 19
    //   1595: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1598: pop
    //   1599: ldc 8
    //   1601: iconst_1
    //   1602: aload 20
    //   1604: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1607: aload 19
    //   1609: invokestatic 295	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1612: lload 11
    //   1614: lstore 9
    //   1616: lload 13
    //   1618: lstore_1
    //   1619: aload 18
    //   1621: ifnull +473 -> 2094
    //   1624: aload 18
    //   1626: invokeinterface 184 1 0
    //   1631: lload 11
    //   1633: lstore 9
    //   1635: lload 13
    //   1637: lstore_1
    //   1638: goto +456 -> 2094
    //   1641: aload 18
    //   1643: ifnull +10 -> 1653
    //   1646: aload 18
    //   1648: invokeinterface 184 1 0
    //   1653: aload 19
    //   1655: athrow
    //   1656: aload 23
    //   1658: invokevirtual 535	java/util/HashMap:keySet	()Ljava/util/Set;
    //   1661: invokeinterface 541 1 0
    //   1666: astore 18
    //   1668: aload 18
    //   1670: invokeinterface 546 1 0
    //   1675: ifeq +320 -> 1995
    //   1678: aload 18
    //   1680: invokeinterface 552 1 0
    //   1685: checkcast 151	java/lang/String
    //   1688: astore 19
    //   1690: iconst_1
    //   1691: istore 4
    //   1693: iload 4
    //   1695: iconst_5
    //   1696: if_icmpge -28 -> 1668
    //   1699: aload 23
    //   1701: aload 19
    //   1703: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1706: checkcast 707	android/util/SparseArray
    //   1709: iload 4
    //   1711: invokevirtual 710	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1714: checkcast 77	java/util/HashMap
    //   1717: astore 20
    //   1719: aload 20
    //   1721: ifnonnull +6 -> 1727
    //   1724: goto +384 -> 2108
    //   1727: aload 20
    //   1729: invokevirtual 535	java/util/HashMap:keySet	()Ljava/util/Set;
    //   1732: invokeinterface 541 1 0
    //   1737: astore 20
    //   1739: aload 20
    //   1741: invokeinterface 546 1 0
    //   1746: ifeq +362 -> 2108
    //   1749: aload 20
    //   1751: invokeinterface 552 1 0
    //   1756: checkcast 151	java/lang/String
    //   1759: astore 21
    //   1761: iload_3
    //   1762: ifeq +118 -> 1880
    //   1765: new 228	java/lang/StringBuilder
    //   1768: dup
    //   1769: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1772: astore 24
    //   1774: aload 24
    //   1776: ldc_w 731
    //   1779: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1782: pop
    //   1783: aload 24
    //   1785: aload 19
    //   1787: invokestatic 245	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   1790: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1793: pop
    //   1794: aload 24
    //   1796: ldc_w 733
    //   1799: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1802: pop
    //   1803: aload 24
    //   1805: aload 21
    //   1807: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1810: pop
    //   1811: aload 24
    //   1813: ldc_w 735
    //   1816: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1819: pop
    //   1820: aload 24
    //   1822: aload 23
    //   1824: aload 19
    //   1826: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1829: checkcast 707	android/util/SparseArray
    //   1832: iload 4
    //   1834: invokevirtual 710	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1837: checkcast 77	java/util/HashMap
    //   1840: aload 21
    //   1842: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1845: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1848: pop
    //   1849: aload 24
    //   1851: ldc_w 735
    //   1854: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1857: pop
    //   1858: aload 24
    //   1860: iload 4
    //   1862: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1865: pop
    //   1866: ldc 8
    //   1868: iconst_1
    //   1869: aload 24
    //   1871: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1874: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1877: goto -138 -> 1739
    //   1880: new 228	java/lang/StringBuilder
    //   1883: dup
    //   1884: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1887: astore 24
    //   1889: aload 24
    //   1891: ldc_w 737
    //   1894: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1897: pop
    //   1898: aload 24
    //   1900: aload 19
    //   1902: invokestatic 245	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   1905: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1908: pop
    //   1909: aload 24
    //   1911: ldc_w 733
    //   1914: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1917: pop
    //   1918: aload 24
    //   1920: aload 21
    //   1922: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1925: pop
    //   1926: aload 24
    //   1928: ldc_w 735
    //   1931: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1934: pop
    //   1935: aload 24
    //   1937: aload 23
    //   1939: aload 19
    //   1941: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1944: checkcast 707	android/util/SparseArray
    //   1947: iload 4
    //   1949: invokevirtual 710	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1952: checkcast 77	java/util/HashMap
    //   1955: aload 21
    //   1957: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1960: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1963: pop
    //   1964: aload 24
    //   1966: ldc_w 735
    //   1969: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1972: pop
    //   1973: aload 24
    //   1975: iload 4
    //   1977: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1980: pop
    //   1981: ldc 8
    //   1983: iconst_1
    //   1984: aload 24
    //   1986: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1989: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1992: goto -253 -> 1739
    //   1995: aload 22
    //   1997: invokevirtual 740	java/io/InputStream:close	()V
    //   2000: aload 23
    //   2002: areturn
    //   2003: astore 18
    //   2005: new 228	java/lang/StringBuilder
    //   2008: dup
    //   2009: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   2012: astore 19
    //   2014: aload 19
    //   2016: ldc_w 742
    //   2019: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2022: pop
    //   2023: aload 19
    //   2025: aload 18
    //   2027: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2030: pop
    //   2031: ldc 8
    //   2033: iconst_1
    //   2034: aload 19
    //   2036: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2039: aload 18
    //   2041: invokestatic 295	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2044: aconst_null
    //   2045: areturn
    //   2046: iload 4
    //   2048: istore 6
    //   2050: goto -1691 -> 359
    //   2053: iload 7
    //   2055: iconst_2
    //   2056: if_icmpeq +13 -> 2069
    //   2059: iload 7
    //   2061: istore 5
    //   2063: iload 7
    //   2065: iconst_3
    //   2066: if_icmpne -1601 -> 465
    //   2069: iconst_2
    //   2070: istore 5
    //   2072: goto -1607 -> 465
    //   2075: goto -1433 -> 642
    //   2078: ldc_w 744
    //   2081: astore 21
    //   2083: goto -1262 -> 821
    //   2086: ldc_w 744
    //   2089: astore 21
    //   2091: goto -918 -> 1173
    //   2094: iload 4
    //   2096: iconst_1
    //   2097: iadd
    //   2098: istore 4
    //   2100: goto -1976 -> 124
    //   2103: astore 19
    //   2105: goto -464 -> 1641
    //   2108: iload 4
    //   2110: iconst_1
    //   2111: iadd
    //   2112: istore 4
    //   2114: goto -421 -> 1693
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2117	0	this	d
    //   0	2117	1	paramLong	long
    //   0	2117	3	paramBoolean	boolean
    //   122	1991	4	i1	int
    //   460	1611	5	i2	int
    //   354	1695	6	i3	int
    //   445	1622	7	i4	int
    //   600	27	8	i5	int
    //   88	1546	9	l1	long
    //   338	1294	11	l2	long
    //   335	1301	13	l3	long
    //   425	1022	15	l4	long
    //   742	3	17	bool	boolean
    //   33	1646	18	localObject1	Object
    //   2003	37	18	localException1	Exception
    //   216	1	19	localException2	Exception
    //   467	1001	19	localObject2	Object
    //   1483	1	19	localException3	Exception
    //   1488	1	19	localException4	Exception
    //   1529	1	19	localObject3	Object
    //   1534	1	19	localException5	Exception
    //   1553	1	19	localObject4	Object
    //   1561	93	19	localException6	Exception
    //   1688	347	19	localObject5	Object
    //   2103	1	19	localObject6	Object
    //   435	1315	20	localObject7	Object
    //   391	1699	21	localObject8	Object
    //   12	1984	22	localInputStream	java.io.InputStream
    //   119	1882	23	localHashMap	HashMap
    //   21	1964	24	localObject9	Object
    //   408	1050	25	str	String
    //   805	498	26	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   134	213	216	java/lang/Exception
    //   437	447	1483	java/lang/Exception
    //   469	480	1483	java/lang/Exception
    //   484	495	1483	java/lang/Exception
    //   499	510	1483	java/lang/Exception
    //   514	536	1483	java/lang/Exception
    //   543	554	1483	java/lang/Exception
    //   566	596	1483	java/lang/Exception
    //   602	642	1483	java/lang/Exception
    //   642	692	1483	java/lang/Exception
    //   695	735	1483	java/lang/Exception
    //   735	744	1483	java/lang/Exception
    //   749	793	1483	java/lang/Exception
    //   798	807	1483	java/lang/Exception
    //   821	943	1483	java/lang/Exception
    //   946	996	1483	java/lang/Exception
    //   999	1089	1483	java/lang/Exception
    //   1092	1142	1483	java/lang/Exception
    //   1150	1159	1483	java/lang/Exception
    //   1173	1255	1483	java/lang/Exception
    //   1258	1308	1483	java/lang/Exception
    //   1317	1328	1483	java/lang/Exception
    //   1332	1343	1483	java/lang/Exception
    //   1343	1363	1483	java/lang/Exception
    //   1372	1381	1483	java/lang/Exception
    //   1381	1438	1483	java/lang/Exception
    //   1441	1472	1483	java/lang/Exception
    //   1472	1480	1483	java/lang/Exception
    //   427	437	1488	java/lang/Exception
    //   340	348	1529	finally
    //   366	376	1529	finally
    //   383	393	1529	finally
    //   400	410	1529	finally
    //   417	427	1529	finally
    //   427	437	1529	finally
    //   437	447	1529	finally
    //   469	480	1529	finally
    //   484	495	1529	finally
    //   499	510	1529	finally
    //   514	536	1529	finally
    //   543	554	1529	finally
    //   566	596	1529	finally
    //   602	642	1529	finally
    //   642	692	1529	finally
    //   695	735	1529	finally
    //   735	744	1529	finally
    //   749	793	1529	finally
    //   798	807	1529	finally
    //   821	943	1529	finally
    //   946	996	1529	finally
    //   999	1089	1529	finally
    //   1092	1142	1529	finally
    //   1150	1159	1529	finally
    //   1173	1255	1529	finally
    //   1258	1308	1529	finally
    //   1317	1328	1529	finally
    //   1332	1343	1529	finally
    //   1343	1363	1529	finally
    //   1372	1381	1529	finally
    //   1381	1438	1529	finally
    //   1441	1472	1529	finally
    //   1472	1480	1529	finally
    //   340	348	1534	java/lang/Exception
    //   366	376	1534	java/lang/Exception
    //   383	393	1534	java/lang/Exception
    //   400	410	1534	java/lang/Exception
    //   417	427	1534	java/lang/Exception
    //   134	213	1553	finally
    //   221	314	1553	finally
    //   221	314	1561	java/lang/Exception
    //   0	90	2003	java/lang/Exception
    //   97	112	2003	java/lang/Exception
    //   112	121	2003	java/lang/Exception
    //   324	331	2003	java/lang/Exception
    //   1512	1519	2003	java/lang/Exception
    //   1624	1631	2003	java/lang/Exception
    //   1646	1653	2003	java/lang/Exception
    //   1653	1656	2003	java/lang/Exception
    //   1656	1668	2003	java/lang/Exception
    //   1668	1690	2003	java/lang/Exception
    //   1699	1719	2003	java/lang/Exception
    //   1727	1739	2003	java/lang/Exception
    //   1739	1761	2003	java/lang/Exception
    //   1765	1877	2003	java/lang/Exception
    //   1880	1992	2003	java/lang/Exception
    //   1995	2000	2003	java/lang/Exception
    //   1573	1612	2103	finally
  }
  
  public void a()
  {
    if (this.p)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(Thread.currentThread().getName());
        localStringBuilder.append(" insertSocketDataFlow writeSize=");
        localStringBuilder.append(this.k.size());
        localStringBuilder.append(" readSize=");
        localStringBuilder.append(this.l.size());
        QLog.d("MSF.C.MonitorNetFlowStore", 2, localStringBuilder.toString());
      }
      if (this.k.size() + this.l.size() > 0)
      {
        if (this.s == null) {
          this.s = new d.a(this);
        }
        this.r.post(this.s);
      }
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject = new Intent(this.n);
    ((Intent)localObject).setAction(this.n);
    this.o = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, (Intent)localObject, 0);
    this.m = ((AlarmManager)BaseApplication.getContext().getSystemService("alarm"));
    if (QLog.isColorLevel()) {
      this.m.setRepeating(0, paramLong, 300000L, this.o);
    } else {
      this.m.setRepeating(0, paramLong, 600000L, this.o);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("register ");
    ((StringBuilder)localObject).append(this.n.hashCode());
    ((StringBuilder)localObject).append(" alarm alive send at ");
    ((StringBuilder)localObject).append(g.format(Long.valueOf(paramLong)));
    QLog.d("MSF.C.MonitorNetFlowStore", 1, ((StringBuilder)localObject).toString());
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("receive broadcast : ");
      paramContext.append(paramIntent.getAction());
      paramContext.append(", start to store socket flow at ");
      paramContext.append(g.format(Long.valueOf(System.currentTimeMillis())));
      QLog.d("MSF.C.MonitorNetFlowStore", 2, paramContext.toString());
    }
    a();
  }
  
  public void a(b paramb)
  {
    try
    {
      int i1 = paramb.e;
      Object localObject1;
      Object localObject2;
      StringBuilder localStringBuilder;
      if (i1 != 0)
      {
        if (i1 == 1) {
          synchronized (this.l)
          {
            localObject1 = this.l;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(paramb.h);
            ((StringBuilder)localObject2).append(paramb.g);
            ((StringBuilder)localObject2).append(paramb.i);
            localObject1 = (b)((HashMap)localObject1).get(((StringBuilder)localObject2).toString());
            if (localObject1 != null)
            {
              localObject2 = this.l;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramb.h);
              localStringBuilder.append(paramb.g);
              localStringBuilder.append(paramb.i);
              ((HashMap)localObject2).put(localStringBuilder.toString(), ((b)localObject1).a(paramb.f));
            }
            else
            {
              localObject1 = this.l;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(paramb.h);
              ((StringBuilder)localObject2).append(paramb.g);
              ((StringBuilder)localObject2).append(paramb.i);
              ((HashMap)localObject1).put(((StringBuilder)localObject2).toString(), paramb);
            }
          }
        }
      }
      else {
        synchronized (this.k)
        {
          localObject1 = this.k;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramb.h);
          ((StringBuilder)localObject2).append(paramb.g);
          ((StringBuilder)localObject2).append(paramb.i);
          localObject1 = (b)((HashMap)localObject1).get(((StringBuilder)localObject2).toString());
          if (localObject1 != null)
          {
            localObject2 = this.k;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramb.h);
            localStringBuilder.append(paramb.g);
            localStringBuilder.append(paramb.i);
            ((HashMap)localObject2).put(localStringBuilder.toString(), ((b)localObject1).a(paramb.f));
          }
          else
          {
            localObject1 = this.k;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(paramb.h);
            ((StringBuilder)localObject2).append(paramb.g);
            ((StringBuilder)localObject2).append(paramb.i);
            ((HashMap)localObject1).put(((StringBuilder)localObject2).toString(), paramb);
          }
        }
      }
      return;
    }
    catch (Exception paramb)
    {
      QLog.d("MSF.C.MonitorNetFlowStore", 1, "MonitorDataFlow cache failed.", paramb);
      if ((this.p) && ((this.k.size() + this.l.size() >= 100) || (System.currentTimeMillis() - this.t >= 300000L))) {
        a();
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      paramToServiceMsg = paramToServiceMsg.extraData;
      b localb = new b(paramToServiceMsg.getString("ip"), paramToServiceMsg.getString("refer"), paramToServiceMsg.getInt("port"), paramToServiceMsg.getInt("flag"), paramToServiceMsg.getLong("buffersize"), paramToServiceMsg.getInt("networktype"));
      localb.a = paramToServiceMsg.getString("processName");
      localb.i = paramToServiceMsg.getByte("status");
      localb.k = paramToServiceMsg.getLong("updatetime");
      if (paramToServiceMsg.getString("mType").startsWith("LongConn")) {
        localb.i = BaseApplication.monitor.getSTATUS();
      }
      localb.h = paramToServiceMsg.getString("mType");
      a(localb);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.d("MSF.C.MonitorNetFlowStore", 1, "ToServiceMsg analysis error.", paramToServiceMsg);
    }
  }
  
  /* Error */
  public HashMap b(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 8
    //   2: astore 13
    //   4: ldc_w 727
    //   7: astore 18
    //   9: ldc 239
    //   11: astore 23
    //   13: getstatic 94	com/tencent/mobileqq/msf/core/d/d:j	Landroid/content/Context;
    //   16: invokevirtual 636	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   19: ldc_w 638
    //   22: invokevirtual 644	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   25: astore 20
    //   27: new 646	java/util/Properties
    //   30: dup
    //   31: invokespecial 647	java/util/Properties:<init>	()V
    //   34: astore 24
    //   36: aload 24
    //   38: aload 20
    //   40: invokevirtual 651	java/util/Properties:loadFromXML	(Ljava/io/InputStream;)V
    //   43: invokestatic 655	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   46: astore 16
    //   48: aload 16
    //   50: bipush 6
    //   52: aload 16
    //   54: bipush 6
    //   56: invokevirtual 657	java/util/Calendar:get	(I)I
    //   59: iconst_1
    //   60: isub
    //   61: invokevirtual 661	java/util/Calendar:set	(II)V
    //   64: aload 16
    //   66: bipush 11
    //   68: iconst_0
    //   69: invokevirtual 661	java/util/Calendar:set	(II)V
    //   72: aload 16
    //   74: bipush 12
    //   76: iconst_0
    //   77: invokevirtual 661	java/util/Calendar:set	(II)V
    //   80: aload 16
    //   82: bipush 13
    //   84: iconst_0
    //   85: invokevirtual 661	java/util/Calendar:set	(II)V
    //   88: aload 16
    //   90: bipush 14
    //   92: iconst_0
    //   93: invokevirtual 661	java/util/Calendar:set	(II)V
    //   96: aload 16
    //   98: invokevirtual 428	java/util/Calendar:getTimeInMillis	()J
    //   101: lstore_1
    //   102: ldc2_w 662
    //   105: lload_1
    //   106: ladd
    //   107: lstore 8
    //   109: getstatic 140	com/tencent/mobileqq/msf/core/d/d:y	Landroid/database/sqlite/SQLiteDatabase;
    //   112: astore 14
    //   114: aload 14
    //   116: ifnonnull +15 -> 131
    //   119: invokestatic 145	com/tencent/mobileqq/msf/core/d/c:a	()Lcom/tencent/mobileqq/msf/core/d/c;
    //   122: invokevirtual 149	com/tencent/mobileqq/msf/core/d/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   125: putstatic 140	com/tencent/mobileqq/msf/core/d/d:y	Landroid/database/sqlite/SQLiteDatabase;
    //   128: goto +3 -> 131
    //   131: iload_3
    //   132: ifeq +101 -> 233
    //   135: getstatic 140	com/tencent/mobileqq/msf/core/d/d:y	Landroid/database/sqlite/SQLiteDatabase;
    //   138: ldc 28
    //   140: bipush 10
    //   142: anewarray 151	java/lang/String
    //   145: dup
    //   146: iconst_0
    //   147: ldc 153
    //   149: aastore
    //   150: dup
    //   151: iconst_1
    //   152: ldc 155
    //   154: aastore
    //   155: dup
    //   156: iconst_2
    //   157: ldc_w 825
    //   160: aastore
    //   161: dup
    //   162: iconst_3
    //   163: ldc 157
    //   165: aastore
    //   166: dup
    //   167: iconst_4
    //   168: ldc 161
    //   170: aastore
    //   171: dup
    //   172: iconst_5
    //   173: ldc 163
    //   175: aastore
    //   176: dup
    //   177: bipush 6
    //   179: ldc_w 665
    //   182: aastore
    //   183: dup
    //   184: bipush 7
    //   186: ldc 159
    //   188: aastore
    //   189: dup
    //   190: bipush 8
    //   192: ldc 165
    //   194: aastore
    //   195: dup
    //   196: bipush 9
    //   198: ldc 167
    //   200: aastore
    //   201: ldc 169
    //   203: iconst_2
    //   204: anewarray 151	java/lang/String
    //   207: dup
    //   208: iconst_0
    //   209: lload_1
    //   210: invokestatic 173	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   213: aastore
    //   214: dup
    //   215: iconst_1
    //   216: lload 8
    //   218: invokestatic 173	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   221: aastore
    //   222: aconst_null
    //   223: aconst_null
    //   224: aconst_null
    //   225: invokevirtual 179	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   228: astore 14
    //   230: goto +113 -> 343
    //   233: getstatic 140	com/tencent/mobileqq/msf/core/d/d:y	Landroid/database/sqlite/SQLiteDatabase;
    //   236: ldc 28
    //   238: bipush 10
    //   240: anewarray 151	java/lang/String
    //   243: dup
    //   244: iconst_0
    //   245: ldc 153
    //   247: aastore
    //   248: dup
    //   249: iconst_1
    //   250: ldc 155
    //   252: aastore
    //   253: dup
    //   254: iconst_2
    //   255: ldc_w 825
    //   258: aastore
    //   259: dup
    //   260: iconst_3
    //   261: ldc 157
    //   263: aastore
    //   264: dup
    //   265: iconst_4
    //   266: ldc 161
    //   268: aastore
    //   269: dup
    //   270: iconst_5
    //   271: ldc 163
    //   273: aastore
    //   274: dup
    //   275: bipush 6
    //   277: ldc_w 665
    //   280: aastore
    //   281: dup
    //   282: bipush 7
    //   284: ldc 159
    //   286: aastore
    //   287: dup
    //   288: bipush 8
    //   290: ldc 165
    //   292: aastore
    //   293: dup
    //   294: bipush 9
    //   296: ldc 167
    //   298: aastore
    //   299: ldc_w 861
    //   302: iconst_4
    //   303: anewarray 151	java/lang/String
    //   306: dup
    //   307: iconst_0
    //   308: lload_1
    //   309: invokestatic 173	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   312: aastore
    //   313: dup
    //   314: iconst_1
    //   315: lload 8
    //   317: invokestatic 173	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   320: aastore
    //   321: dup
    //   322: iconst_2
    //   323: iconst_2
    //   324: invokestatic 669	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   327: aastore
    //   328: dup
    //   329: iconst_3
    //   330: iconst_3
    //   331: invokestatic 669	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   334: aastore
    //   335: aconst_null
    //   336: aconst_null
    //   337: aconst_null
    //   338: invokevirtual 179	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   341: astore 14
    //   343: aload 14
    //   345: ifnonnull +17 -> 362
    //   348: aload 14
    //   350: ifnull +10 -> 360
    //   353: aload 14
    //   355: invokeinterface 184 1 0
    //   360: aconst_null
    //   361: areturn
    //   362: aload 13
    //   364: astore 15
    //   366: aload 14
    //   368: astore 17
    //   370: new 77	java/util/HashMap
    //   373: dup
    //   374: invokespecial 78	java/util/HashMap:<init>	()V
    //   377: astore 21
    //   379: lconst_0
    //   380: lstore_1
    //   381: iload_3
    //   382: ifeq +27 -> 409
    //   385: aload 13
    //   387: astore 15
    //   389: aload 14
    //   391: astore 17
    //   393: aload_0
    //   394: aload 16
    //   396: invokespecial 863	com/tencent/mobileqq/msf/core/d/d:a	(Ljava/util/Calendar;)Ljava/io/PrintWriter;
    //   399: astore 22
    //   401: goto +11 -> 412
    //   404: astore 13
    //   406: goto +2976 -> 3382
    //   409: aconst_null
    //   410: astore 22
    //   412: aload 13
    //   414: astore 15
    //   416: aload 14
    //   418: astore 17
    //   420: aload 14
    //   422: invokeinterface 223 1 0
    //   427: pop
    //   428: aload 13
    //   430: astore 15
    //   432: aload 14
    //   434: astore 17
    //   436: aload 14
    //   438: invokeinterface 226 1 0
    //   443: istore 12
    //   445: iload 12
    //   447: ifne +2200 -> 2647
    //   450: aload 13
    //   452: astore 15
    //   454: aload 14
    //   456: astore 17
    //   458: aload 14
    //   460: iconst_0
    //   461: invokeinterface 233 2 0
    //   466: astore 16
    //   468: aload 13
    //   470: astore 15
    //   472: aload 14
    //   474: astore 17
    //   476: aload 14
    //   478: iconst_1
    //   479: invokeinterface 233 2 0
    //   484: astore 26
    //   486: aload 13
    //   488: astore 15
    //   490: aload 14
    //   492: astore 17
    //   494: aload 14
    //   496: iconst_2
    //   497: invokeinterface 233 2 0
    //   502: astore 25
    //   504: aload 14
    //   506: astore 17
    //   508: aload 14
    //   510: iconst_3
    //   511: invokeinterface 249 2 0
    //   516: lstore 8
    //   518: aload 14
    //   520: astore 17
    //   522: aload 14
    //   524: iconst_4
    //   525: invokeinterface 233 2 0
    //   530: astore 15
    //   532: aload 14
    //   534: astore 17
    //   536: aload 14
    //   538: iconst_5
    //   539: invokeinterface 256 2 0
    //   544: istore 5
    //   546: aload 14
    //   548: astore 17
    //   550: aload 14
    //   552: bipush 6
    //   554: invokeinterface 256 2 0
    //   559: istore 6
    //   561: aload 14
    //   563: astore 17
    //   565: aload 14
    //   567: bipush 7
    //   569: invokeinterface 256 2 0
    //   574: istore 7
    //   576: aload 14
    //   578: astore 17
    //   580: aload 14
    //   582: bipush 8
    //   584: invokeinterface 233 2 0
    //   589: astore 19
    //   591: aload 14
    //   593: astore 17
    //   595: aload 14
    //   597: bipush 9
    //   599: invokeinterface 249 2 0
    //   604: lstore 10
    //   606: iload 5
    //   608: iconst_3
    //   609: if_icmpeq +2870 -> 3479
    //   612: iload 5
    //   614: iconst_2
    //   615: if_icmpeq +2864 -> 3479
    //   618: iconst_1
    //   619: istore 4
    //   621: goto +3 -> 624
    //   624: lload_1
    //   625: lload 8
    //   627: ladd
    //   628: lstore_1
    //   629: iload_3
    //   630: ifeq +2874 -> 3504
    //   633: aload 22
    //   635: ifnull +2869 -> 3504
    //   638: aload 14
    //   640: astore 17
    //   642: aload 22
    //   644: ldc_w 865
    //   647: invokevirtual 408	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   650: aload 14
    //   652: astore 17
    //   654: new 228	java/lang/StringBuilder
    //   657: dup
    //   658: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   661: astore 27
    //   663: aload 14
    //   665: astore 17
    //   667: aload 27
    //   669: aload_0
    //   670: aload 16
    //   672: invokespecial 867	com/tencent/mobileqq/msf/core/d/d:a	(Ljava/lang/String;)Ljava/lang/String;
    //   675: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: pop
    //   679: aload 14
    //   681: astore 17
    //   683: aload 27
    //   685: aload 23
    //   687: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: pop
    //   691: aload 14
    //   693: astore 17
    //   695: aload 22
    //   697: aload 27
    //   699: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   702: invokevirtual 408	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   705: aload 14
    //   707: astore 17
    //   709: new 228	java/lang/StringBuilder
    //   712: dup
    //   713: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   716: astore 27
    //   718: aload 14
    //   720: astore 17
    //   722: aload 27
    //   724: aload 26
    //   726: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: pop
    //   730: aload 14
    //   732: astore 17
    //   734: aload 27
    //   736: aload 23
    //   738: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: pop
    //   742: aload 14
    //   744: astore 17
    //   746: aload 22
    //   748: aload 27
    //   750: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   753: invokevirtual 408	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   756: aload 14
    //   758: astore 17
    //   760: new 228	java/lang/StringBuilder
    //   763: dup
    //   764: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   767: astore 27
    //   769: aload 14
    //   771: astore 17
    //   773: aload 27
    //   775: iload 6
    //   777: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   780: pop
    //   781: aload 14
    //   783: astore 17
    //   785: aload 27
    //   787: aload 23
    //   789: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: pop
    //   793: aload 14
    //   795: astore 17
    //   797: aload 22
    //   799: aload 27
    //   801: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   804: invokevirtual 408	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   807: aload 14
    //   809: astore 17
    //   811: new 228	java/lang/StringBuilder
    //   814: dup
    //   815: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   818: astore 27
    //   820: aload 14
    //   822: astore 17
    //   824: aload 27
    //   826: aload 15
    //   828: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: pop
    //   832: aload 14
    //   834: astore 17
    //   836: aload 27
    //   838: aload 23
    //   840: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: pop
    //   844: aload 14
    //   846: astore 17
    //   848: aload 22
    //   850: aload 27
    //   852: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   855: invokevirtual 408	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   858: aload 14
    //   860: astore 17
    //   862: new 228	java/lang/StringBuilder
    //   865: dup
    //   866: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   869: astore 27
    //   871: aload 14
    //   873: astore 17
    //   875: aload 27
    //   877: lload 8
    //   879: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   882: pop
    //   883: aload 14
    //   885: astore 17
    //   887: aload 27
    //   889: aload 23
    //   891: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: pop
    //   895: aload 14
    //   897: astore 17
    //   899: aload 22
    //   901: aload 27
    //   903: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   906: invokevirtual 408	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   909: aload 14
    //   911: astore 17
    //   913: new 228	java/lang/StringBuilder
    //   916: dup
    //   917: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   920: astore 27
    //   922: aload 14
    //   924: astore 17
    //   926: aload 27
    //   928: iload 7
    //   930: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   933: pop
    //   934: aload 14
    //   936: astore 17
    //   938: aload 27
    //   940: aload 23
    //   942: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   945: pop
    //   946: aload 14
    //   948: astore 17
    //   950: aload 22
    //   952: aload 27
    //   954: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   957: invokevirtual 408	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   960: aload 14
    //   962: astore 17
    //   964: new 228	java/lang/StringBuilder
    //   967: dup
    //   968: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   971: astore 27
    //   973: aload 14
    //   975: astore 17
    //   977: aload 27
    //   979: lload 10
    //   981: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   984: pop
    //   985: aload 14
    //   987: astore 17
    //   989: aload 27
    //   991: aload 23
    //   993: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: pop
    //   997: aload 14
    //   999: astore 17
    //   1001: aload 22
    //   1003: aload 27
    //   1005: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1008: invokevirtual 408	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   1011: aload 14
    //   1013: astore 17
    //   1015: new 228	java/lang/StringBuilder
    //   1018: dup
    //   1019: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1022: astore 27
    //   1024: aload 14
    //   1026: astore 17
    //   1028: aload 27
    //   1030: iload 4
    //   1032: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1035: pop
    //   1036: aload 14
    //   1038: astore 17
    //   1040: aload 27
    //   1042: aload 23
    //   1044: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: pop
    //   1048: aload 14
    //   1050: astore 17
    //   1052: aload 22
    //   1054: aload 27
    //   1056: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1059: invokevirtual 408	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   1062: aload 14
    //   1064: astore 17
    //   1066: new 228	java/lang/StringBuilder
    //   1069: dup
    //   1070: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1073: astore 27
    //   1075: aload 14
    //   1077: astore 17
    //   1079: aload 27
    //   1081: aload 25
    //   1083: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: pop
    //   1087: aload 14
    //   1089: astore 17
    //   1091: aload 27
    //   1093: aload 23
    //   1095: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: pop
    //   1099: aload 14
    //   1101: astore 17
    //   1103: aload 22
    //   1105: aload 27
    //   1107: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1110: invokevirtual 408	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   1113: aload 14
    //   1115: astore 17
    //   1117: new 228	java/lang/StringBuilder
    //   1120: dup
    //   1121: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1124: astore 27
    //   1126: aload 14
    //   1128: astore 17
    //   1130: aload 27
    //   1132: aload 19
    //   1134: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1137: pop
    //   1138: aload 14
    //   1140: astore 17
    //   1142: aload 27
    //   1144: aload 23
    //   1146: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1149: pop
    //   1150: aload 14
    //   1152: astore 17
    //   1154: aload 22
    //   1156: aload 27
    //   1158: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1161: invokevirtual 408	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   1164: aload 14
    //   1166: astore 17
    //   1168: aload 22
    //   1170: ldc_w 283
    //   1173: invokevirtual 408	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   1176: goto +3 -> 1179
    //   1179: aload 14
    //   1181: astore 17
    //   1183: aload 16
    //   1185: ldc_w 453
    //   1188: invokevirtual 445	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1191: ifne +2316 -> 3507
    //   1194: aload 14
    //   1196: astore 17
    //   1198: aload 15
    //   1200: ldc_w 673
    //   1203: invokevirtual 437	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1206: ifne +2301 -> 3507
    //   1209: aload 14
    //   1211: astore 17
    //   1213: aload 15
    //   1215: ldc_w 675
    //   1218: invokevirtual 437	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1221: ifne +2286 -> 3507
    //   1224: aload 14
    //   1226: astore 17
    //   1228: aload 15
    //   1230: ldc_w 677
    //   1233: invokevirtual 437	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1236: ifne +2271 -> 3507
    //   1239: aload 14
    //   1241: astore 17
    //   1243: aload 16
    //   1245: ldc_w 449
    //   1248: invokevirtual 445	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1251: ifeq +6 -> 1257
    //   1254: goto +2253 -> 3507
    //   1257: aload 14
    //   1259: astore 17
    //   1261: aload 16
    //   1263: ldc_w 679
    //   1266: invokevirtual 445	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1269: ifeq +11 -> 1280
    //   1272: ldc_w 441
    //   1275: astore 16
    //   1277: goto +106 -> 1383
    //   1280: aload 14
    //   1282: astore 17
    //   1284: aload 16
    //   1286: ldc_w 681
    //   1289: invokevirtual 685	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1292: ifeq +2215 -> 3507
    //   1295: aload 14
    //   1297: astore 17
    //   1299: aload 16
    //   1301: ldc_w 681
    //   1304: invokevirtual 689	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1307: istore 5
    //   1309: aload 14
    //   1311: astore 17
    //   1313: new 228	java/lang/StringBuilder
    //   1316: dup
    //   1317: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1320: astore 15
    //   1322: iload 5
    //   1324: iconst_2
    //   1325: iadd
    //   1326: istore 6
    //   1328: aload 14
    //   1330: astore 17
    //   1332: aload 15
    //   1334: aload 16
    //   1336: iload 5
    //   1338: iconst_1
    //   1339: iadd
    //   1340: iload 6
    //   1342: invokevirtual 693	java/lang/String:substring	(II)Ljava/lang/String;
    //   1345: invokevirtual 696	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   1348: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1351: pop
    //   1352: aload 14
    //   1354: astore 17
    //   1356: aload 15
    //   1358: aload 16
    //   1360: iload 6
    //   1362: invokevirtual 698	java/lang/String:substring	(I)Ljava/lang/String;
    //   1365: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: pop
    //   1369: aload 14
    //   1371: astore 17
    //   1373: aload 15
    //   1375: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1378: astore 16
    //   1380: goto +3 -> 1383
    //   1383: aload 14
    //   1385: astore 17
    //   1387: aload 16
    //   1389: ldc 11
    //   1391: invokevirtual 701	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1394: ifeq +62 -> 1456
    //   1397: aload 14
    //   1399: astore 17
    //   1401: new 228	java/lang/StringBuilder
    //   1404: dup
    //   1405: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1408: astore 15
    //   1410: aload 14
    //   1412: astore 17
    //   1414: aload 15
    //   1416: ldc 11
    //   1418: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1421: pop
    //   1422: aload 14
    //   1424: astore 17
    //   1426: aload 15
    //   1428: iload 4
    //   1430: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1433: pop
    //   1434: aload 14
    //   1436: astore 17
    //   1438: aload 24
    //   1440: aload 15
    //   1442: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1445: invokevirtual 702	java/util/Properties:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1448: checkcast 151	java/lang/String
    //   1451: astore 15
    //   1453: goto +59 -> 1512
    //   1456: aload 14
    //   1458: astore 17
    //   1460: new 228	java/lang/StringBuilder
    //   1463: dup
    //   1464: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1467: astore 15
    //   1469: aload 14
    //   1471: astore 17
    //   1473: aload 15
    //   1475: aload 16
    //   1477: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1480: pop
    //   1481: aload 14
    //   1483: astore 17
    //   1485: aload 15
    //   1487: iload 4
    //   1489: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1492: pop
    //   1493: aload 14
    //   1495: astore 17
    //   1497: aload 24
    //   1499: aload 15
    //   1501: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1504: invokevirtual 702	java/util/Properties:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1507: checkcast 151	java/lang/String
    //   1510: astore 15
    //   1512: aload 14
    //   1514: astore 17
    //   1516: aload 21
    //   1518: aload 26
    //   1520: invokevirtual 705	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1523: istore 12
    //   1525: iload 12
    //   1527: ifeq +533 -> 2060
    //   1530: aload 15
    //   1532: ifnonnull +299 -> 1831
    //   1535: aload 14
    //   1537: astore 17
    //   1539: new 228	java/lang/StringBuilder
    //   1542: dup
    //   1543: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1546: astore 27
    //   1548: iload 4
    //   1550: iconst_1
    //   1551: if_icmpne +1963 -> 3514
    //   1554: ldc_w 716
    //   1557: astore 19
    //   1559: goto +3 -> 1562
    //   1562: aload 14
    //   1564: astore 17
    //   1566: aload 27
    //   1568: aload 19
    //   1570: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1573: pop
    //   1574: aload 14
    //   1576: astore 17
    //   1578: aload 27
    //   1580: aload 16
    //   1582: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1585: pop
    //   1586: aload 14
    //   1588: astore 17
    //   1590: aload 27
    //   1592: ldc_w 718
    //   1595: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1598: pop
    //   1599: aload 14
    //   1601: astore 17
    //   1603: aload 27
    //   1605: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1608: astore 19
    //   1610: aload 19
    //   1612: astore 16
    //   1614: iload_3
    //   1615: ifne +116 -> 1731
    //   1618: aload 19
    //   1620: astore 16
    //   1622: lload 8
    //   1624: ldc2_w 868
    //   1627: lcmp
    //   1628: ifle +103 -> 1731
    //   1631: aload 19
    //   1633: astore 16
    //   1635: aload 25
    //   1637: ifnull +94 -> 1731
    //   1640: aload 19
    //   1642: astore 16
    //   1644: aload 14
    //   1646: astore 17
    //   1648: aload 25
    //   1650: invokestatic 874	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1653: ifne +78 -> 1731
    //   1656: aload 19
    //   1658: astore 16
    //   1660: aload 14
    //   1662: astore 17
    //   1664: invokestatic 878	com/tencent/mobileqq/msf/core/a/a:g	()Z
    //   1667: ifeq +64 -> 1731
    //   1670: aload 14
    //   1672: astore 17
    //   1674: new 228	java/lang/StringBuilder
    //   1677: dup
    //   1678: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1681: astore 16
    //   1683: aload 14
    //   1685: astore 17
    //   1687: aload 16
    //   1689: aload 19
    //   1691: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1694: pop
    //   1695: aload 14
    //   1697: astore 17
    //   1699: aload 16
    //   1701: ldc_w 880
    //   1704: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1707: pop
    //   1708: aload 14
    //   1710: astore 17
    //   1712: aload 16
    //   1714: aload 25
    //   1716: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1719: pop
    //   1720: aload 14
    //   1722: astore 17
    //   1724: aload 16
    //   1726: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1729: astore 16
    //   1731: aload 14
    //   1733: astore 17
    //   1735: aload 21
    //   1737: aload 26
    //   1739: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1742: checkcast 77	java/util/HashMap
    //   1745: aload 16
    //   1747: invokevirtual 705	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1750: ifeq +53 -> 1803
    //   1753: aload 14
    //   1755: astore 17
    //   1757: aload 21
    //   1759: aload 26
    //   1761: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1764: checkcast 77	java/util/HashMap
    //   1767: aload 16
    //   1769: aload 21
    //   1771: aload 26
    //   1773: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1776: checkcast 77	java/util/HashMap
    //   1779: aload 16
    //   1781: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1784: checkcast 261	java/lang/Long
    //   1787: invokevirtual 721	java/lang/Long:longValue	()J
    //   1790: lload 8
    //   1792: ladd
    //   1793: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1796: invokevirtual 724	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1799: pop
    //   1800: goto +677 -> 2477
    //   1803: aload 14
    //   1805: astore 17
    //   1807: aload 21
    //   1809: aload 26
    //   1811: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1814: checkcast 77	java/util/HashMap
    //   1817: aload 16
    //   1819: lload 8
    //   1821: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1824: invokevirtual 724	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1827: pop
    //   1828: goto +649 -> 2477
    //   1831: aload 15
    //   1833: astore 19
    //   1835: iload_3
    //   1836: ifne +116 -> 1952
    //   1839: aload 15
    //   1841: astore 19
    //   1843: lload 8
    //   1845: ldc2_w 868
    //   1848: lcmp
    //   1849: ifle +103 -> 1952
    //   1852: aload 15
    //   1854: astore 19
    //   1856: aload 25
    //   1858: ifnull +94 -> 1952
    //   1861: aload 15
    //   1863: astore 19
    //   1865: aload 14
    //   1867: astore 17
    //   1869: aload 25
    //   1871: invokestatic 874	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1874: ifne +78 -> 1952
    //   1877: aload 15
    //   1879: astore 19
    //   1881: aload 14
    //   1883: astore 17
    //   1885: invokestatic 878	com/tencent/mobileqq/msf/core/a/a:g	()Z
    //   1888: ifeq +64 -> 1952
    //   1891: aload 14
    //   1893: astore 17
    //   1895: new 228	java/lang/StringBuilder
    //   1898: dup
    //   1899: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1902: astore 19
    //   1904: aload 14
    //   1906: astore 17
    //   1908: aload 19
    //   1910: aload 15
    //   1912: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1915: pop
    //   1916: aload 14
    //   1918: astore 17
    //   1920: aload 19
    //   1922: ldc_w 880
    //   1925: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1928: pop
    //   1929: aload 14
    //   1931: astore 17
    //   1933: aload 19
    //   1935: aload 25
    //   1937: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1940: pop
    //   1941: aload 14
    //   1943: astore 17
    //   1945: aload 19
    //   1947: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1950: astore 19
    //   1952: aload 14
    //   1954: astore 17
    //   1956: aload 21
    //   1958: aload 26
    //   1960: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1963: checkcast 77	java/util/HashMap
    //   1966: aload 19
    //   1968: invokevirtual 705	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1971: ifeq +57 -> 2028
    //   1974: aload 14
    //   1976: astore 17
    //   1978: aload 21
    //   1980: aload 26
    //   1982: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1985: checkcast 77	java/util/HashMap
    //   1988: aload 19
    //   1990: aload 21
    //   1992: aload 26
    //   1994: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1997: checkcast 77	java/util/HashMap
    //   2000: aload 19
    //   2002: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2005: checkcast 261	java/lang/Long
    //   2008: invokevirtual 721	java/lang/Long:longValue	()J
    //   2011: lload 8
    //   2013: ladd
    //   2014: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2017: invokevirtual 724	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2020: pop
    //   2021: aload 19
    //   2023: astore 15
    //   2025: goto +452 -> 2477
    //   2028: aload 14
    //   2030: astore 17
    //   2032: aload 21
    //   2034: aload 26
    //   2036: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2039: checkcast 77	java/util/HashMap
    //   2042: aload 19
    //   2044: lload 8
    //   2046: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2049: invokevirtual 724	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2052: pop
    //   2053: aload 19
    //   2055: astore 15
    //   2057: goto +420 -> 2477
    //   2060: aload 15
    //   2062: ifnonnull +246 -> 2308
    //   2065: aload 14
    //   2067: astore 17
    //   2069: new 228	java/lang/StringBuilder
    //   2072: dup
    //   2073: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   2076: astore 27
    //   2078: iload 4
    //   2080: iconst_1
    //   2081: if_icmpne +1441 -> 3522
    //   2084: ldc_w 716
    //   2087: astore 19
    //   2089: goto +3 -> 2092
    //   2092: aload 14
    //   2094: astore 17
    //   2096: aload 27
    //   2098: aload 19
    //   2100: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2103: pop
    //   2104: aload 14
    //   2106: astore 17
    //   2108: aload 27
    //   2110: aload 16
    //   2112: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2115: pop
    //   2116: aload 14
    //   2118: astore 17
    //   2120: aload 27
    //   2122: ldc_w 718
    //   2125: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2128: pop
    //   2129: aload 14
    //   2131: astore 17
    //   2133: aload 27
    //   2135: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2138: astore 19
    //   2140: aload 19
    //   2142: astore 16
    //   2144: iload_3
    //   2145: ifne +116 -> 2261
    //   2148: aload 19
    //   2150: astore 16
    //   2152: lload 8
    //   2154: ldc2_w 868
    //   2157: lcmp
    //   2158: ifle +103 -> 2261
    //   2161: aload 19
    //   2163: astore 16
    //   2165: aload 25
    //   2167: ifnull +94 -> 2261
    //   2170: aload 19
    //   2172: astore 16
    //   2174: aload 14
    //   2176: astore 17
    //   2178: aload 25
    //   2180: invokestatic 874	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2183: ifne +78 -> 2261
    //   2186: aload 19
    //   2188: astore 16
    //   2190: aload 14
    //   2192: astore 17
    //   2194: invokestatic 878	com/tencent/mobileqq/msf/core/a/a:g	()Z
    //   2197: ifeq +64 -> 2261
    //   2200: aload 14
    //   2202: astore 17
    //   2204: new 228	java/lang/StringBuilder
    //   2207: dup
    //   2208: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   2211: astore 16
    //   2213: aload 14
    //   2215: astore 17
    //   2217: aload 16
    //   2219: aload 19
    //   2221: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2224: pop
    //   2225: aload 14
    //   2227: astore 17
    //   2229: aload 16
    //   2231: ldc_w 880
    //   2234: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2237: pop
    //   2238: aload 14
    //   2240: astore 17
    //   2242: aload 16
    //   2244: aload 25
    //   2246: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2249: pop
    //   2250: aload 14
    //   2252: astore 17
    //   2254: aload 16
    //   2256: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2259: astore 16
    //   2261: aload 14
    //   2263: astore 17
    //   2265: new 77	java/util/HashMap
    //   2268: dup
    //   2269: invokespecial 78	java/util/HashMap:<init>	()V
    //   2272: astore 19
    //   2274: aload 14
    //   2276: astore 17
    //   2278: aload 19
    //   2280: aload 16
    //   2282: lload 8
    //   2284: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2287: invokevirtual 724	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2290: pop
    //   2291: aload 14
    //   2293: astore 17
    //   2295: aload 21
    //   2297: aload 26
    //   2299: aload 19
    //   2301: invokevirtual 724	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2304: pop
    //   2305: goto +172 -> 2477
    //   2308: aload 15
    //   2310: astore 19
    //   2312: iload_3
    //   2313: ifne +116 -> 2429
    //   2316: aload 15
    //   2318: astore 19
    //   2320: lload 8
    //   2322: ldc2_w 868
    //   2325: lcmp
    //   2326: ifle +103 -> 2429
    //   2329: aload 15
    //   2331: astore 19
    //   2333: aload 25
    //   2335: ifnull +94 -> 2429
    //   2338: aload 15
    //   2340: astore 19
    //   2342: aload 14
    //   2344: astore 17
    //   2346: aload 25
    //   2348: invokestatic 874	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2351: ifne +78 -> 2429
    //   2354: aload 15
    //   2356: astore 19
    //   2358: aload 14
    //   2360: astore 17
    //   2362: invokestatic 878	com/tencent/mobileqq/msf/core/a/a:g	()Z
    //   2365: ifeq +64 -> 2429
    //   2368: aload 14
    //   2370: astore 17
    //   2372: new 228	java/lang/StringBuilder
    //   2375: dup
    //   2376: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   2379: astore 19
    //   2381: aload 14
    //   2383: astore 17
    //   2385: aload 19
    //   2387: aload 15
    //   2389: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2392: pop
    //   2393: aload 14
    //   2395: astore 17
    //   2397: aload 19
    //   2399: ldc_w 880
    //   2402: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2405: pop
    //   2406: aload 14
    //   2408: astore 17
    //   2410: aload 19
    //   2412: aload 25
    //   2414: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2417: pop
    //   2418: aload 14
    //   2420: astore 17
    //   2422: aload 19
    //   2424: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2427: astore 19
    //   2429: aload 14
    //   2431: astore 17
    //   2433: new 77	java/util/HashMap
    //   2436: dup
    //   2437: invokespecial 78	java/util/HashMap:<init>	()V
    //   2440: astore 15
    //   2442: aload 14
    //   2444: astore 17
    //   2446: aload 15
    //   2448: aload 19
    //   2450: lload 8
    //   2452: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2455: invokevirtual 724	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2458: pop
    //   2459: aload 14
    //   2461: astore 17
    //   2463: aload 21
    //   2465: aload 26
    //   2467: aload 15
    //   2469: invokevirtual 724	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2472: pop
    //   2473: aload 19
    //   2475: astore 15
    //   2477: iload_3
    //   2478: ifeq +23 -> 2501
    //   2481: aload 15
    //   2483: ifnull +18 -> 2501
    //   2486: aload 14
    //   2488: astore 17
    //   2490: aload 15
    //   2492: ldc_w 716
    //   2495: invokevirtual 701	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2498: ifne +22 -> 2520
    //   2501: iload_3
    //   2502: ifeq +1028 -> 3530
    //   2505: aload 14
    //   2507: astore 17
    //   2509: aload 16
    //   2511: ldc_w 716
    //   2514: invokevirtual 701	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2517: ifeq +1013 -> 3530
    //   2520: aload 14
    //   2522: astore 17
    //   2524: aload 21
    //   2526: aload 26
    //   2528: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2531: checkcast 77	java/util/HashMap
    //   2534: astore 16
    //   2536: aload 18
    //   2538: astore 15
    //   2540: aload 14
    //   2542: astore 17
    //   2544: aload 16
    //   2546: aload 15
    //   2548: invokevirtual 705	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2551: ifeq +53 -> 2604
    //   2554: aload 14
    //   2556: astore 17
    //   2558: aload 21
    //   2560: aload 26
    //   2562: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2565: checkcast 77	java/util/HashMap
    //   2568: aload 15
    //   2570: aload 21
    //   2572: aload 26
    //   2574: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2577: checkcast 77	java/util/HashMap
    //   2580: aload 15
    //   2582: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2585: checkcast 261	java/lang/Long
    //   2588: invokevirtual 721	java/lang/Long:longValue	()J
    //   2591: lload 8
    //   2593: ladd
    //   2594: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2597: invokevirtual 724	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2600: pop
    //   2601: goto +31 -> 2632
    //   2604: aload 14
    //   2606: astore 17
    //   2608: aload 21
    //   2610: aload 26
    //   2612: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2615: checkcast 77	java/util/HashMap
    //   2618: aload 15
    //   2620: lload 8
    //   2622: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2625: invokevirtual 724	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2628: pop
    //   2629: goto +3 -> 2632
    //   2632: aload 14
    //   2634: astore 17
    //   2636: aload 14
    //   2638: invokeinterface 279 1 0
    //   2643: pop
    //   2644: goto -2216 -> 428
    //   2647: aload 13
    //   2649: astore 16
    //   2651: aload 22
    //   2653: ifnull +205 -> 2858
    //   2656: lload_1
    //   2657: lconst_0
    //   2658: lcmp
    //   2659: ifle +67 -> 2726
    //   2662: aload 14
    //   2664: astore 17
    //   2666: new 228	java/lang/StringBuilder
    //   2669: dup
    //   2670: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   2673: astore 15
    //   2675: aload 14
    //   2677: astore 17
    //   2679: aload 15
    //   2681: ldc_w 882
    //   2684: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2687: pop
    //   2688: aload 14
    //   2690: astore 17
    //   2692: aload 15
    //   2694: lload_1
    //   2695: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2698: pop
    //   2699: aload 14
    //   2701: astore 17
    //   2703: aload 15
    //   2705: ldc_w 283
    //   2708: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2711: pop
    //   2712: aload 14
    //   2714: astore 17
    //   2716: aload 22
    //   2718: aload 15
    //   2720: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2723: invokevirtual 408	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   2726: aload 14
    //   2728: astore 17
    //   2730: new 228	java/lang/StringBuilder
    //   2733: dup
    //   2734: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   2737: astore 15
    //   2739: aload 14
    //   2741: astore 17
    //   2743: aload 15
    //   2745: ldc_w 884
    //   2748: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2751: pop
    //   2752: aload 14
    //   2754: astore 17
    //   2756: aload 15
    //   2758: invokestatic 889	android/os/Process:myUid	()I
    //   2761: invokestatic 894	android/net/TrafficStats:getUidRxBytes	(I)J
    //   2764: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2767: pop
    //   2768: aload 14
    //   2770: astore 17
    //   2772: aload 15
    //   2774: ldc_w 896
    //   2777: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2780: pop
    //   2781: aload 14
    //   2783: astore 17
    //   2785: aload 15
    //   2787: invokestatic 889	android/os/Process:myUid	()I
    //   2790: invokestatic 899	android/net/TrafficStats:getUidTxBytes	(I)J
    //   2793: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2796: pop
    //   2797: aload 14
    //   2799: astore 17
    //   2801: aload 15
    //   2803: ldc_w 283
    //   2806: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2809: pop
    //   2810: aload 14
    //   2812: astore 17
    //   2814: aload 22
    //   2816: aload 15
    //   2818: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2821: invokevirtual 408	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   2824: aload 14
    //   2826: astore 17
    //   2828: aload 22
    //   2830: invokevirtual 431	java/io/PrintWriter:flush	()V
    //   2833: aload 14
    //   2835: astore 17
    //   2837: aload 22
    //   2839: invokevirtual 900	java/io/PrintWriter:close	()V
    //   2842: goto +16 -> 2858
    //   2845: astore 16
    //   2847: aload 13
    //   2849: astore 15
    //   2851: aload 16
    //   2853: astore 13
    //   2855: goto +527 -> 3382
    //   2858: aload 16
    //   2860: astore 15
    //   2862: aload 14
    //   2864: astore 17
    //   2866: aload 21
    //   2868: invokevirtual 535	java/util/HashMap:keySet	()Ljava/util/Set;
    //   2871: invokeinterface 541 1 0
    //   2876: astore 18
    //   2878: aload 16
    //   2880: astore 15
    //   2882: aload 14
    //   2884: astore 17
    //   2886: aload 18
    //   2888: invokeinterface 546 1 0
    //   2893: ifeq +429 -> 3322
    //   2896: aload 16
    //   2898: astore 15
    //   2900: aload 14
    //   2902: astore 17
    //   2904: aload 18
    //   2906: invokeinterface 552 1 0
    //   2911: checkcast 151	java/lang/String
    //   2914: astore 19
    //   2916: aload 16
    //   2918: astore 15
    //   2920: aload 14
    //   2922: astore 17
    //   2924: aload 21
    //   2926: aload 19
    //   2928: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2931: checkcast 77	java/util/HashMap
    //   2934: invokevirtual 535	java/util/HashMap:keySet	()Ljava/util/Set;
    //   2937: invokeinterface 541 1 0
    //   2942: astore 22
    //   2944: aload 16
    //   2946: astore 13
    //   2948: aload 13
    //   2950: astore 16
    //   2952: aload 13
    //   2954: astore 15
    //   2956: aload 14
    //   2958: astore 17
    //   2960: aload 22
    //   2962: invokeinterface 546 1 0
    //   2967: ifeq -89 -> 2878
    //   2970: aload 13
    //   2972: astore 15
    //   2974: aload 14
    //   2976: astore 17
    //   2978: aload 22
    //   2980: invokeinterface 552 1 0
    //   2985: checkcast 151	java/lang/String
    //   2988: astore 23
    //   2990: iload_3
    //   2991: ifeq +173 -> 3164
    //   2994: aload 13
    //   2996: astore 15
    //   2998: aload 14
    //   3000: astore 17
    //   3002: new 228	java/lang/StringBuilder
    //   3005: dup
    //   3006: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   3009: astore 16
    //   3011: aload 13
    //   3013: astore 15
    //   3015: aload 14
    //   3017: astore 17
    //   3019: aload 16
    //   3021: ldc_w 902
    //   3024: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3027: pop
    //   3028: aload 13
    //   3030: astore 15
    //   3032: aload 14
    //   3034: astore 17
    //   3036: aload 16
    //   3038: aload 19
    //   3040: invokestatic 245	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   3043: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3046: pop
    //   3047: aload 13
    //   3049: astore 15
    //   3051: aload 14
    //   3053: astore 17
    //   3055: aload 16
    //   3057: ldc_w 733
    //   3060: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3063: pop
    //   3064: aload 13
    //   3066: astore 15
    //   3068: aload 14
    //   3070: astore 17
    //   3072: aload 16
    //   3074: aload 23
    //   3076: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3079: pop
    //   3080: aload 13
    //   3082: astore 15
    //   3084: aload 14
    //   3086: astore 17
    //   3088: aload 16
    //   3090: ldc_w 735
    //   3093: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3096: pop
    //   3097: aload 13
    //   3099: astore 15
    //   3101: aload 14
    //   3103: astore 17
    //   3105: aload 16
    //   3107: aload 21
    //   3109: aload 19
    //   3111: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3114: checkcast 77	java/util/HashMap
    //   3117: aload 23
    //   3119: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3122: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3125: pop
    //   3126: aload 13
    //   3128: astore 15
    //   3130: aload 14
    //   3132: astore 17
    //   3134: aload 16
    //   3136: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3139: astore 23
    //   3141: aload 13
    //   3143: astore 16
    //   3145: aload 16
    //   3147: astore 15
    //   3149: aload 14
    //   3151: astore 17
    //   3153: aload 16
    //   3155: iconst_1
    //   3156: aload 23
    //   3158: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3161: goto +372 -> 3533
    //   3164: aload 13
    //   3166: astore 16
    //   3168: aload 16
    //   3170: astore 15
    //   3172: aload 14
    //   3174: astore 17
    //   3176: new 228	java/lang/StringBuilder
    //   3179: dup
    //   3180: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   3183: astore 24
    //   3185: aload 16
    //   3187: astore 15
    //   3189: aload 14
    //   3191: astore 17
    //   3193: aload 24
    //   3195: ldc_w 904
    //   3198: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3201: pop
    //   3202: aload 16
    //   3204: astore 15
    //   3206: aload 14
    //   3208: astore 17
    //   3210: aload 24
    //   3212: aload 19
    //   3214: invokestatic 245	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   3217: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3220: pop
    //   3221: aload 16
    //   3223: astore 15
    //   3225: aload 14
    //   3227: astore 17
    //   3229: aload 24
    //   3231: ldc_w 733
    //   3234: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3237: pop
    //   3238: aload 16
    //   3240: astore 15
    //   3242: aload 14
    //   3244: astore 17
    //   3246: aload 24
    //   3248: aload 23
    //   3250: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3253: pop
    //   3254: aload 16
    //   3256: astore 15
    //   3258: aload 14
    //   3260: astore 17
    //   3262: aload 24
    //   3264: ldc_w 735
    //   3267: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3270: pop
    //   3271: aload 16
    //   3273: astore 15
    //   3275: aload 14
    //   3277: astore 17
    //   3279: aload 24
    //   3281: aload 21
    //   3283: aload 19
    //   3285: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3288: checkcast 77	java/util/HashMap
    //   3291: aload 23
    //   3293: invokevirtual 555	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3296: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3299: pop
    //   3300: aload 16
    //   3302: astore 15
    //   3304: aload 14
    //   3306: astore 17
    //   3308: aload 16
    //   3310: iconst_1
    //   3311: aload 24
    //   3313: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3316: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3319: goto +214 -> 3533
    //   3322: aload 16
    //   3324: astore 15
    //   3326: aload 14
    //   3328: astore 17
    //   3330: aload 20
    //   3332: invokevirtual 740	java/io/InputStream:close	()V
    //   3335: aload 14
    //   3337: ifnull +10 -> 3347
    //   3340: aload 14
    //   3342: invokeinterface 184 1 0
    //   3347: aload 21
    //   3349: areturn
    //   3350: astore 13
    //   3352: goto +10 -> 3362
    //   3355: astore 13
    //   3357: goto +5 -> 3362
    //   3360: astore 13
    //   3362: goto +20 -> 3382
    //   3365: astore 13
    //   3367: aconst_null
    //   3368: astore 17
    //   3370: goto +83 -> 3453
    //   3373: astore 13
    //   3375: ldc 8
    //   3377: astore 15
    //   3379: aconst_null
    //   3380: astore 14
    //   3382: aload 14
    //   3384: astore 17
    //   3386: new 228	java/lang/StringBuilder
    //   3389: dup
    //   3390: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   3393: astore 16
    //   3395: aload 14
    //   3397: astore 17
    //   3399: aload 16
    //   3401: ldc_w 742
    //   3404: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3407: pop
    //   3408: aload 14
    //   3410: astore 17
    //   3412: aload 16
    //   3414: aload 13
    //   3416: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3419: pop
    //   3420: aload 14
    //   3422: astore 17
    //   3424: aload 15
    //   3426: iconst_1
    //   3427: aload 16
    //   3429: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3432: aload 13
    //   3434: invokestatic 295	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3437: aload 14
    //   3439: ifnull +10 -> 3449
    //   3442: aload 14
    //   3444: invokeinterface 184 1 0
    //   3449: aconst_null
    //   3450: areturn
    //   3451: astore 13
    //   3453: aload 17
    //   3455: ifnull +10 -> 3465
    //   3458: aload 17
    //   3460: invokeinterface 184 1 0
    //   3465: goto +6 -> 3471
    //   3468: aload 13
    //   3470: athrow
    //   3471: goto -3 -> 3468
    //   3474: astore 13
    //   3476: goto -101 -> 3375
    //   3479: iload 5
    //   3481: iconst_2
    //   3482: if_icmpeq +16 -> 3498
    //   3485: iload 5
    //   3487: istore 4
    //   3489: iload 5
    //   3491: iconst_3
    //   3492: if_icmpne -2868 -> 624
    //   3495: goto +3 -> 3498
    //   3498: iconst_2
    //   3499: istore 4
    //   3501: goto -2877 -> 624
    //   3504: goto -2325 -> 1179
    //   3507: aload 15
    //   3509: astore 16
    //   3511: goto -2128 -> 1383
    //   3514: ldc_w 744
    //   3517: astore 19
    //   3519: goto -1957 -> 1562
    //   3522: ldc_w 744
    //   3525: astore 19
    //   3527: goto -1435 -> 2092
    //   3530: goto -898 -> 2632
    //   3533: goto -585 -> 2948
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3536	0	this	d
    //   0	3536	1	paramLong	long
    //   0	3536	3	paramBoolean	boolean
    //   619	2881	4	i1	int
    //   544	2949	5	i2	int
    //   559	802	6	i3	int
    //   574	355	7	i4	int
    //   107	2514	8	l1	long
    //   604	376	10	l2	long
    //   443	1083	12	bool	boolean
    //   2	384	13	str1	String
    //   404	2444	13	localException1	Exception
    //   2853	312	13	localObject1	Object
    //   3350	1	13	localException2	Exception
    //   3355	1	13	localException3	Exception
    //   3360	1	13	localException4	Exception
    //   3365	1	13	localObject2	Object
    //   3373	60	13	localException5	Exception
    //   3451	18	13	localObject3	Object
    //   3474	1	13	localException6	Exception
    //   112	3331	14	localObject4	Object
    //   364	3144	15	localObject5	Object
    //   46	2604	16	localObject6	Object
    //   2845	100	16	localException7	Exception
    //   2950	560	16	localObject7	Object
    //   368	3091	17	localObject8	Object
    //   7	2898	18	localObject9	Object
    //   589	2937	19	localObject10	Object
    //   25	3306	20	localInputStream	java.io.InputStream
    //   377	2971	21	localHashMap	HashMap
    //   399	2580	22	localObject11	Object
    //   11	3281	23	str2	String
    //   34	3278	24	localObject12	Object
    //   502	1911	25	str3	String
    //   484	2127	26	str4	String
    //   661	1473	27	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   393	401	404	java/lang/Exception
    //   458	468	404	java/lang/Exception
    //   476	486	404	java/lang/Exception
    //   494	504	404	java/lang/Exception
    //   508	518	2845	java/lang/Exception
    //   522	532	2845	java/lang/Exception
    //   536	546	2845	java/lang/Exception
    //   550	561	2845	java/lang/Exception
    //   565	576	2845	java/lang/Exception
    //   580	591	2845	java/lang/Exception
    //   595	606	2845	java/lang/Exception
    //   642	650	2845	java/lang/Exception
    //   654	663	2845	java/lang/Exception
    //   667	679	2845	java/lang/Exception
    //   683	691	2845	java/lang/Exception
    //   695	705	2845	java/lang/Exception
    //   709	718	2845	java/lang/Exception
    //   722	730	2845	java/lang/Exception
    //   734	742	2845	java/lang/Exception
    //   746	756	2845	java/lang/Exception
    //   760	769	2845	java/lang/Exception
    //   773	781	2845	java/lang/Exception
    //   785	793	2845	java/lang/Exception
    //   797	807	2845	java/lang/Exception
    //   811	820	2845	java/lang/Exception
    //   824	832	2845	java/lang/Exception
    //   836	844	2845	java/lang/Exception
    //   848	858	2845	java/lang/Exception
    //   862	871	2845	java/lang/Exception
    //   875	883	2845	java/lang/Exception
    //   887	895	2845	java/lang/Exception
    //   899	909	2845	java/lang/Exception
    //   913	922	2845	java/lang/Exception
    //   926	934	2845	java/lang/Exception
    //   938	946	2845	java/lang/Exception
    //   950	960	2845	java/lang/Exception
    //   964	973	2845	java/lang/Exception
    //   977	985	2845	java/lang/Exception
    //   989	997	2845	java/lang/Exception
    //   1001	1011	2845	java/lang/Exception
    //   1015	1024	2845	java/lang/Exception
    //   1028	1036	2845	java/lang/Exception
    //   1040	1048	2845	java/lang/Exception
    //   1052	1062	2845	java/lang/Exception
    //   1066	1075	2845	java/lang/Exception
    //   1079	1087	2845	java/lang/Exception
    //   1091	1099	2845	java/lang/Exception
    //   1103	1113	2845	java/lang/Exception
    //   1117	1126	2845	java/lang/Exception
    //   1130	1138	2845	java/lang/Exception
    //   1142	1150	2845	java/lang/Exception
    //   1154	1164	2845	java/lang/Exception
    //   1168	1176	2845	java/lang/Exception
    //   1183	1194	2845	java/lang/Exception
    //   1198	1209	2845	java/lang/Exception
    //   1213	1224	2845	java/lang/Exception
    //   1228	1239	2845	java/lang/Exception
    //   1243	1254	2845	java/lang/Exception
    //   1261	1272	2845	java/lang/Exception
    //   1284	1295	2845	java/lang/Exception
    //   1299	1309	2845	java/lang/Exception
    //   1313	1322	2845	java/lang/Exception
    //   1332	1352	2845	java/lang/Exception
    //   1356	1369	2845	java/lang/Exception
    //   1373	1380	2845	java/lang/Exception
    //   1387	1397	2845	java/lang/Exception
    //   1401	1410	2845	java/lang/Exception
    //   1414	1422	2845	java/lang/Exception
    //   1426	1434	2845	java/lang/Exception
    //   1438	1453	2845	java/lang/Exception
    //   1460	1469	2845	java/lang/Exception
    //   1473	1481	2845	java/lang/Exception
    //   1485	1493	2845	java/lang/Exception
    //   1497	1512	2845	java/lang/Exception
    //   1516	1525	2845	java/lang/Exception
    //   1539	1548	2845	java/lang/Exception
    //   1566	1574	2845	java/lang/Exception
    //   1578	1586	2845	java/lang/Exception
    //   1590	1599	2845	java/lang/Exception
    //   1603	1610	2845	java/lang/Exception
    //   1648	1656	2845	java/lang/Exception
    //   1664	1670	2845	java/lang/Exception
    //   1674	1683	2845	java/lang/Exception
    //   1687	1695	2845	java/lang/Exception
    //   1699	1708	2845	java/lang/Exception
    //   1712	1720	2845	java/lang/Exception
    //   1724	1731	2845	java/lang/Exception
    //   1735	1753	2845	java/lang/Exception
    //   1757	1800	2845	java/lang/Exception
    //   1807	1828	2845	java/lang/Exception
    //   1869	1877	2845	java/lang/Exception
    //   1885	1891	2845	java/lang/Exception
    //   1895	1904	2845	java/lang/Exception
    //   1908	1916	2845	java/lang/Exception
    //   1920	1929	2845	java/lang/Exception
    //   1933	1941	2845	java/lang/Exception
    //   1945	1952	2845	java/lang/Exception
    //   1956	1974	2845	java/lang/Exception
    //   1978	2021	2845	java/lang/Exception
    //   2032	2053	2845	java/lang/Exception
    //   2069	2078	2845	java/lang/Exception
    //   2096	2104	2845	java/lang/Exception
    //   2108	2116	2845	java/lang/Exception
    //   2120	2129	2845	java/lang/Exception
    //   2133	2140	2845	java/lang/Exception
    //   2178	2186	2845	java/lang/Exception
    //   2194	2200	2845	java/lang/Exception
    //   2204	2213	2845	java/lang/Exception
    //   2217	2225	2845	java/lang/Exception
    //   2229	2238	2845	java/lang/Exception
    //   2242	2250	2845	java/lang/Exception
    //   2254	2261	2845	java/lang/Exception
    //   2265	2274	2845	java/lang/Exception
    //   2278	2291	2845	java/lang/Exception
    //   2295	2305	2845	java/lang/Exception
    //   2346	2354	2845	java/lang/Exception
    //   2362	2368	2845	java/lang/Exception
    //   2372	2381	2845	java/lang/Exception
    //   2385	2393	2845	java/lang/Exception
    //   2397	2406	2845	java/lang/Exception
    //   2410	2418	2845	java/lang/Exception
    //   2422	2429	2845	java/lang/Exception
    //   2433	2442	2845	java/lang/Exception
    //   2446	2459	2845	java/lang/Exception
    //   2463	2473	2845	java/lang/Exception
    //   2490	2501	2845	java/lang/Exception
    //   2509	2520	2845	java/lang/Exception
    //   2524	2536	2845	java/lang/Exception
    //   2544	2554	2845	java/lang/Exception
    //   2558	2601	2845	java/lang/Exception
    //   2608	2629	2845	java/lang/Exception
    //   2636	2644	2845	java/lang/Exception
    //   2666	2675	2845	java/lang/Exception
    //   2679	2688	2845	java/lang/Exception
    //   2692	2699	2845	java/lang/Exception
    //   2703	2712	2845	java/lang/Exception
    //   2716	2726	2845	java/lang/Exception
    //   2730	2739	2845	java/lang/Exception
    //   2743	2752	2845	java/lang/Exception
    //   2756	2768	2845	java/lang/Exception
    //   2772	2781	2845	java/lang/Exception
    //   2785	2797	2845	java/lang/Exception
    //   2801	2810	2845	java/lang/Exception
    //   2814	2824	2845	java/lang/Exception
    //   2828	2833	2845	java/lang/Exception
    //   2837	2842	2845	java/lang/Exception
    //   3153	3161	3350	java/lang/Exception
    //   3176	3185	3350	java/lang/Exception
    //   3193	3202	3350	java/lang/Exception
    //   3210	3221	3350	java/lang/Exception
    //   3229	3238	3350	java/lang/Exception
    //   3246	3254	3350	java/lang/Exception
    //   3262	3271	3350	java/lang/Exception
    //   3279	3300	3350	java/lang/Exception
    //   3308	3319	3350	java/lang/Exception
    //   3330	3335	3350	java/lang/Exception
    //   2866	2878	3355	java/lang/Exception
    //   2886	2896	3355	java/lang/Exception
    //   2904	2916	3355	java/lang/Exception
    //   2924	2944	3355	java/lang/Exception
    //   2960	2970	3355	java/lang/Exception
    //   2978	2990	3355	java/lang/Exception
    //   3002	3011	3355	java/lang/Exception
    //   3019	3028	3355	java/lang/Exception
    //   3036	3047	3355	java/lang/Exception
    //   3055	3064	3355	java/lang/Exception
    //   3072	3080	3355	java/lang/Exception
    //   3088	3097	3355	java/lang/Exception
    //   3105	3126	3355	java/lang/Exception
    //   3134	3141	3355	java/lang/Exception
    //   370	379	3360	java/lang/Exception
    //   420	428	3360	java/lang/Exception
    //   436	445	3360	java/lang/Exception
    //   13	102	3365	finally
    //   109	114	3365	finally
    //   119	128	3365	finally
    //   135	230	3365	finally
    //   233	343	3365	finally
    //   13	102	3373	java/lang/Exception
    //   109	114	3373	java/lang/Exception
    //   233	343	3373	java/lang/Exception
    //   370	379	3451	finally
    //   393	401	3451	finally
    //   420	428	3451	finally
    //   436	445	3451	finally
    //   458	468	3451	finally
    //   476	486	3451	finally
    //   494	504	3451	finally
    //   508	518	3451	finally
    //   522	532	3451	finally
    //   536	546	3451	finally
    //   550	561	3451	finally
    //   565	576	3451	finally
    //   580	591	3451	finally
    //   595	606	3451	finally
    //   642	650	3451	finally
    //   654	663	3451	finally
    //   667	679	3451	finally
    //   683	691	3451	finally
    //   695	705	3451	finally
    //   709	718	3451	finally
    //   722	730	3451	finally
    //   734	742	3451	finally
    //   746	756	3451	finally
    //   760	769	3451	finally
    //   773	781	3451	finally
    //   785	793	3451	finally
    //   797	807	3451	finally
    //   811	820	3451	finally
    //   824	832	3451	finally
    //   836	844	3451	finally
    //   848	858	3451	finally
    //   862	871	3451	finally
    //   875	883	3451	finally
    //   887	895	3451	finally
    //   899	909	3451	finally
    //   913	922	3451	finally
    //   926	934	3451	finally
    //   938	946	3451	finally
    //   950	960	3451	finally
    //   964	973	3451	finally
    //   977	985	3451	finally
    //   989	997	3451	finally
    //   1001	1011	3451	finally
    //   1015	1024	3451	finally
    //   1028	1036	3451	finally
    //   1040	1048	3451	finally
    //   1052	1062	3451	finally
    //   1066	1075	3451	finally
    //   1079	1087	3451	finally
    //   1091	1099	3451	finally
    //   1103	1113	3451	finally
    //   1117	1126	3451	finally
    //   1130	1138	3451	finally
    //   1142	1150	3451	finally
    //   1154	1164	3451	finally
    //   1168	1176	3451	finally
    //   1183	1194	3451	finally
    //   1198	1209	3451	finally
    //   1213	1224	3451	finally
    //   1228	1239	3451	finally
    //   1243	1254	3451	finally
    //   1261	1272	3451	finally
    //   1284	1295	3451	finally
    //   1299	1309	3451	finally
    //   1313	1322	3451	finally
    //   1332	1352	3451	finally
    //   1356	1369	3451	finally
    //   1373	1380	3451	finally
    //   1387	1397	3451	finally
    //   1401	1410	3451	finally
    //   1414	1422	3451	finally
    //   1426	1434	3451	finally
    //   1438	1453	3451	finally
    //   1460	1469	3451	finally
    //   1473	1481	3451	finally
    //   1485	1493	3451	finally
    //   1497	1512	3451	finally
    //   1516	1525	3451	finally
    //   1539	1548	3451	finally
    //   1566	1574	3451	finally
    //   1578	1586	3451	finally
    //   1590	1599	3451	finally
    //   1603	1610	3451	finally
    //   1648	1656	3451	finally
    //   1664	1670	3451	finally
    //   1674	1683	3451	finally
    //   1687	1695	3451	finally
    //   1699	1708	3451	finally
    //   1712	1720	3451	finally
    //   1724	1731	3451	finally
    //   1735	1753	3451	finally
    //   1757	1800	3451	finally
    //   1807	1828	3451	finally
    //   1869	1877	3451	finally
    //   1885	1891	3451	finally
    //   1895	1904	3451	finally
    //   1908	1916	3451	finally
    //   1920	1929	3451	finally
    //   1933	1941	3451	finally
    //   1945	1952	3451	finally
    //   1956	1974	3451	finally
    //   1978	2021	3451	finally
    //   2032	2053	3451	finally
    //   2069	2078	3451	finally
    //   2096	2104	3451	finally
    //   2108	2116	3451	finally
    //   2120	2129	3451	finally
    //   2133	2140	3451	finally
    //   2178	2186	3451	finally
    //   2194	2200	3451	finally
    //   2204	2213	3451	finally
    //   2217	2225	3451	finally
    //   2229	2238	3451	finally
    //   2242	2250	3451	finally
    //   2254	2261	3451	finally
    //   2265	2274	3451	finally
    //   2278	2291	3451	finally
    //   2295	2305	3451	finally
    //   2346	2354	3451	finally
    //   2362	2368	3451	finally
    //   2372	2381	3451	finally
    //   2385	2393	3451	finally
    //   2397	2406	3451	finally
    //   2410	2418	3451	finally
    //   2422	2429	3451	finally
    //   2433	2442	3451	finally
    //   2446	2459	3451	finally
    //   2463	2473	3451	finally
    //   2490	2501	3451	finally
    //   2509	2520	3451	finally
    //   2524	2536	3451	finally
    //   2544	2554	3451	finally
    //   2558	2601	3451	finally
    //   2608	2629	3451	finally
    //   2636	2644	3451	finally
    //   2666	2675	3451	finally
    //   2679	2688	3451	finally
    //   2692	2699	3451	finally
    //   2703	2712	3451	finally
    //   2716	2726	3451	finally
    //   2730	2739	3451	finally
    //   2743	2752	3451	finally
    //   2756	2768	3451	finally
    //   2772	2781	3451	finally
    //   2785	2797	3451	finally
    //   2801	2810	3451	finally
    //   2814	2824	3451	finally
    //   2828	2833	3451	finally
    //   2837	2842	3451	finally
    //   2866	2878	3451	finally
    //   2886	2896	3451	finally
    //   2904	2916	3451	finally
    //   2924	2944	3451	finally
    //   2960	2970	3451	finally
    //   2978	2990	3451	finally
    //   3002	3011	3451	finally
    //   3019	3028	3451	finally
    //   3036	3047	3451	finally
    //   3055	3064	3451	finally
    //   3072	3080	3451	finally
    //   3088	3097	3451	finally
    //   3105	3126	3451	finally
    //   3134	3141	3451	finally
    //   3153	3161	3451	finally
    //   3176	3185	3451	finally
    //   3193	3202	3451	finally
    //   3210	3221	3451	finally
    //   3229	3238	3451	finally
    //   3246	3254	3451	finally
    //   3262	3271	3451	finally
    //   3279	3300	3451	finally
    //   3308	3319	3451	finally
    //   3330	3335	3451	finally
    //   3386	3395	3451	finally
    //   3399	3408	3451	finally
    //   3412	3420	3451	finally
    //   3424	3437	3451	finally
    //   119	128	3474	java/lang/Exception
    //   135	230	3474	java/lang/Exception
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.d.d
 * JD-Core Version:    0.7.0.1
 */