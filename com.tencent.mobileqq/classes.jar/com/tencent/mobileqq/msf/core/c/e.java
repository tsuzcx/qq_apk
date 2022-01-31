package com.tencent.mobileqq.msf.core.c;

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
import com.tencent.mobileqq.msf.core.ag;
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
import java.util.Iterator;
import java.util.Set;

public class e
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
  private e.a s;
  private long t;
  private final int u = 4;
  
  public e(MsfCore paramMsfCore, Context paramContext)
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
  public static com.tencent.qphone.base.util.QLog.a a(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc 8
    //   2: iconst_1
    //   3: ldc 133
    //   5: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: getstatic 140	com/tencent/mobileqq/msf/core/c/e:y	Landroid/database/sqlite/SQLiteDatabase;
    //   11: ifnonnull +12 -> 23
    //   14: invokestatic 145	com/tencent/mobileqq/msf/core/c/d:a	()Lcom/tencent/mobileqq/msf/core/c/d;
    //   17: invokevirtual 149	com/tencent/mobileqq/msf/core/c/d:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   20: putstatic 140	com/tencent/mobileqq/msf/core/c/e:y	Landroid/database/sqlite/SQLiteDatabase;
    //   23: getstatic 140	com/tencent/mobileqq/msf/core/c/e:y	Landroid/database/sqlite/SQLiteDatabase;
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
    //   105: ifnonnull +21 -> 126
    //   108: aload 7
    //   110: ifnull +10 -> 120
    //   113: aload 7
    //   115: invokeinterface 184 1 0
    //   120: aconst_null
    //   121: astore 6
    //   123: aload 6
    //   125: areturn
    //   126: aload 7
    //   128: astore 6
    //   130: new 186	java/io/File
    //   133: dup
    //   134: invokestatic 190	com/tencent/qphone/base/util/QLog:getLogPath	()Ljava/lang/String;
    //   137: invokespecial 191	java/io/File:<init>	(Ljava/lang/String;)V
    //   140: astore 8
    //   142: aload 7
    //   144: astore 6
    //   146: aload 8
    //   148: invokevirtual 195	java/io/File:exists	()Z
    //   151: istore 5
    //   153: iload 5
    //   155: istore 4
    //   157: iload 5
    //   159: ifne +14 -> 173
    //   162: aload 7
    //   164: astore 6
    //   166: aload 8
    //   168: invokevirtual 198	java/io/File:mkdirs	()Z
    //   171: istore 4
    //   173: iload 4
    //   175: ifne +17 -> 192
    //   178: aload 7
    //   180: ifnull +10 -> 190
    //   183: aload 7
    //   185: invokeinterface 184 1 0
    //   190: aconst_null
    //   191: areturn
    //   192: aload 7
    //   194: astore 6
    //   196: new 200	com/tencent/qphone/base/util/QLog$a
    //   199: dup
    //   200: aload 8
    //   202: ldc 202
    //   204: invokespecial 205	com/tencent/qphone/base/util/QLog$a:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   207: astore 8
    //   209: aload 7
    //   211: astore 6
    //   213: new 207	java/io/BufferedWriter
    //   216: dup
    //   217: new 209	java/io/OutputStreamWriter
    //   220: dup
    //   221: new 211	java/io/FileOutputStream
    //   224: dup
    //   225: aload 8
    //   227: invokespecial 214	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   230: invokespecial 217	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   233: invokespecial 220	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   236: astore 9
    //   238: aload 7
    //   240: astore 6
    //   242: aload 7
    //   244: invokeinterface 223 1 0
    //   249: pop
    //   250: lconst_0
    //   251: lstore_0
    //   252: aload 7
    //   254: astore 6
    //   256: aload 7
    //   258: invokeinterface 226 1 0
    //   263: ifne +244 -> 507
    //   266: aload 7
    //   268: astore 6
    //   270: aload 9
    //   272: new 228	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   279: aload 7
    //   281: iconst_0
    //   282: invokeinterface 233 2 0
    //   287: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: ldc 239
    //   292: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload 7
    //   297: iconst_1
    //   298: invokeinterface 233 2 0
    //   303: invokestatic 245	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   306: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc 239
    //   311: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload 7
    //   316: iconst_2
    //   317: invokeinterface 249 2 0
    //   322: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   325: ldc 239
    //   327: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload 7
    //   332: iconst_3
    //   333: invokeinterface 256 2 0
    //   338: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   341: ldc 239
    //   343: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: aload 7
    //   348: iconst_4
    //   349: invokeinterface 233 2 0
    //   354: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: ldc 239
    //   359: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload 7
    //   364: iconst_5
    //   365: invokeinterface 256 2 0
    //   370: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   373: ldc 239
    //   375: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: aload 7
    //   380: bipush 6
    //   382: invokeinterface 233 2 0
    //   387: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: ldc 239
    //   392: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: getstatic 71	com/tencent/mobileqq/msf/core/c/e:g	Ljava/text/SimpleDateFormat;
    //   398: aload 7
    //   400: bipush 7
    //   402: invokeinterface 249 2 0
    //   407: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   410: invokevirtual 268	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   413: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: ldc_w 270
    //   419: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokevirtual 276	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   428: aload 7
    //   430: astore 6
    //   432: lload_0
    //   433: aload 7
    //   435: iconst_2
    //   436: invokeinterface 249 2 0
    //   441: ladd
    //   442: lstore_0
    //   443: aload 7
    //   445: astore 6
    //   447: aload 7
    //   449: invokeinterface 279 1 0
    //   454: pop
    //   455: goto -203 -> 252
    //   458: astore 8
    //   460: aload 7
    //   462: astore 6
    //   464: ldc 8
    //   466: iconst_1
    //   467: new 228	java/lang/StringBuilder
    //   470: dup
    //   471: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   474: ldc_w 281
    //   477: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: aload 8
    //   482: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   485: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: aload 8
    //   490: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   493: aload 7
    //   495: ifnull +10 -> 505
    //   498: aload 7
    //   500: invokeinterface 184 1 0
    //   505: aconst_null
    //   506: areturn
    //   507: aload 7
    //   509: astore 6
    //   511: aload 9
    //   513: new 228	java/lang/StringBuilder
    //   516: dup
    //   517: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   520: ldc_w 289
    //   523: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: lload_0
    //   527: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   530: ldc_w 291
    //   533: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: invokevirtual 276	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   542: aload 7
    //   544: astore 6
    //   546: aload 9
    //   548: invokevirtual 294	java/io/BufferedWriter:flush	()V
    //   551: aload 7
    //   553: astore 6
    //   555: aload 9
    //   557: invokevirtual 295	java/io/BufferedWriter:close	()V
    //   560: aload 8
    //   562: astore 6
    //   564: aload 7
    //   566: ifnull -443 -> 123
    //   569: aload 7
    //   571: invokeinterface 184 1 0
    //   576: aload 8
    //   578: areturn
    //   579: astore 7
    //   581: aconst_null
    //   582: astore 6
    //   584: aload 6
    //   586: ifnull +10 -> 596
    //   589: aload 6
    //   591: invokeinterface 184 1 0
    //   596: aload 7
    //   598: athrow
    //   599: astore 7
    //   601: goto -17 -> 584
    //   604: astore 8
    //   606: aconst_null
    //   607: astore 7
    //   609: goto -149 -> 460
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	612	0	paramLong1	long
    //   0	612	2	paramLong2	long
    //   155	19	4	bool1	boolean
    //   151	7	5	bool2	boolean
    //   121	469	6	localObject1	Object
    //   101	469	7	localCursor	android.database.Cursor
    //   579	18	7	localObject2	Object
    //   599	1	7	localObject3	Object
    //   607	1	7	localObject4	Object
    //   140	86	8	localObject5	Object
    //   458	119	8	localException1	Exception
    //   604	1	8	localException2	Exception
    //   236	320	9	localBufferedWriter	BufferedWriter
    // Exception table:
    //   from	to	target	type
    //   130	142	458	java/lang/Exception
    //   146	153	458	java/lang/Exception
    //   166	173	458	java/lang/Exception
    //   196	209	458	java/lang/Exception
    //   213	238	458	java/lang/Exception
    //   242	250	458	java/lang/Exception
    //   256	266	458	java/lang/Exception
    //   270	428	458	java/lang/Exception
    //   432	443	458	java/lang/Exception
    //   447	455	458	java/lang/Exception
    //   511	542	458	java/lang/Exception
    //   546	551	458	java/lang/Exception
    //   555	560	458	java/lang/Exception
    //   8	23	579	finally
    //   23	103	579	finally
    //   130	142	599	finally
    //   146	153	599	finally
    //   166	173	599	finally
    //   196	209	599	finally
    //   213	238	599	finally
    //   242	250	599	finally
    //   256	266	599	finally
    //   270	428	599	finally
    //   432	443	599	finally
    //   447	455	599	finally
    //   464	493	599	finally
    //   511	542	599	finally
    //   546	551	599	finally
    //   555	560	599	finally
    //   8	23	604	java/lang/Exception
    //   23	103	604	java/lang/Exception
  }
  
  private PrintWriter a(Calendar paramCalendar)
  {
    Object localObject6 = null;
    for (;;)
    {
      try
      {
        localObject3 = Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/com/tencent/mobileqq/netflow/";
        localObject1 = new File((String)localObject3);
        if (!((File)localObject1).exists()) {
          ((File)localObject1).mkdirs();
        }
        localObject4 = new SimpleDateFormat("yy.MM.dd");
        localObject2 = "10000";
        localObject1 = localObject2;
        if (this.i != null)
        {
          localObject1 = localObject2;
          if (this.i.sender != null)
          {
            localObject1 = localObject2;
            if (this.i.sender.j().length() > 4) {
              localObject1 = this.i.sender.j();
            }
          }
        }
        localObject1 = (String)localObject3 + (String)localObject1 + "_" + ((SimpleDateFormat)localObject4).format(paramCalendar.getTime()) + ".log";
        localObject2 = new File((String)localObject1);
        if (((File)localObject2).exists()) {
          ((File)localObject2).delete();
        }
        localObject2 = new PrintWriter(new BufferedWriter(new FileWriter((String)localObject1, true)));
        localObject1 = localObject2;
        if (localObject2 == null) {
          break label565;
        }
      }
      catch (Exception localException2)
      {
        Object localObject3;
        Object localObject4;
        Object localObject2;
        Object localObject5;
        paramCalendar = null;
        continue;
      }
      for (;;)
      {
        try
        {
          localObject3 = BaseApplication.getContext().getPackageManager();
          localObject1 = ((PackageManager)localObject3).getPackageInfo("com.tencent.mobileqq", 128);
          localObject1 = ((PackageInfo)localObject1).versionName + "." + ((PackageInfo)localObject1).versionCode;
        }
        catch (Exception localException4)
        {
          localObject1 = null;
          break;
        }
        try
        {
          localObject4 = ((PackageManager)localObject3).getApplicationInfo("com.tencent.mobileqq", 128).metaData.get("com.tencent.rdm.uuid").toString();
          localObject5 = localObject1;
        }
        catch (Exception localException3)
        {
          break;
        }
      }
      try
      {
        ((PrintWriter)localObject2).print("header|");
        ((PrintWriter)localObject2).print(localObject5 + "|");
        ((PrintWriter)localObject2).print("fd2cc8f9|");
        ((PrintWriter)localObject2).print("pub" + "|");
        ((PrintWriter)localObject2).print((String)localObject4 + "|");
        ((PrintWriter)localObject2).print(Build.MANUFACTURER + "|");
        ((PrintWriter)localObject2).print(Build.MODEL + "|");
        ((PrintWriter)localObject2).print(Build.VERSION.SDK_INT + "|");
        ((PrintWriter)localObject2).print(paramCalendar.getTimeInMillis() + "|");
        ((PrintWriter)localObject2).print("1.0|\r\n");
        ((PrintWriter)localObject2).flush();
        return localObject2;
      }
      catch (Exception localException1)
      {
        paramCalendar = (Calendar)localObject2;
        localObject1 = paramCalendar;
        if (!QLog.isColorLevel()) {
          break label565;
        }
      }
      localObject5 = localObject1;
      localObject4 = localObject6;
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.MonitorNetFlowStore", 2, "initNetflowHead addHead fail!", (Throwable)localObject3);
        localObject5 = localObject1;
        localObject4 = localObject6;
        continue;
        QLog.d("MSF.C.MonitorNetFlowStore", 2, "save netflow exception!", localException1);
        return paramCalendar;
      }
    }
    label565:
    return localObject1;
  }
  
  private String a(String paramString)
  {
    if (paramString != null)
    {
      String str;
      if (paramString.equals("com.tencent.mobileqq")) {
        str = "1";
      }
      do
      {
        return str;
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
      } while (!paramString.endsWith("TMAssistantDownloadSDKService"));
      return "11";
    }
    return "0";
  }
  
  private void a(Context paramContext)
  {
    this.n = (MsfSdkUtils.getProcessName(paramContext) + "_" + getClass().hashCode());
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
  
  private void a(HashMap paramHashMap1, HashMap paramHashMap2)
  {
    label835:
    label879:
    try
    {
      if (y == null) {
        y = d.a().getWritableDatabase();
      }
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.MonitorNetFlowStore", 2, "write data : " + paramHashMap1.size() + " | read data : " + paramHashMap2.size() + ", starting to store.");
      }
      y.beginTransaction();
      Object localObject1 = paramHashMap1.keySet().iterator();
      Object localObject2;
      long l2;
      for (int i1 = 0; ((Iterator)localObject1).hasNext(); i1 = (int)(((b)paramHashMap1.get(localObject2)).f + l2))
      {
        localObject2 = (String)((Iterator)localObject1).next();
        b localb = (b)paramHashMap1.get(localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.MonitorNetFlowStore", 2, "mType|" + localb.h + "|" + localb.c + "|" + localb.b + "|" + localb.d + "|write|" + localb.f + "|" + localb.g + "|" + localb.i + "|" + localb.a);
        }
        if (localb.k > 0L) {
          l1 = localb.k;
        }
        y.execSQL("insert into dataflow(processName, uin, ip, refer, port, flag, buffersize, networktype, mType, curtime, status) values(?,?,?,?,?,?,?,?,?,?,?)", new Object[] { localb.a, this.i.sender.j(), localb.b, localb.c, Integer.valueOf(localb.d), Integer.valueOf(localb.e), Long.valueOf(localb.f), Integer.valueOf(localb.g), localb.h, Long.valueOf(l1), Byte.valueOf(localb.i) });
        l2 = i1;
      }
      paramHashMap1 = paramHashMap2.keySet().iterator();
      for (int i2 = 0; paramHashMap1.hasNext(); i2 = (int)(((b)paramHashMap2.get(localObject1)).f + l2))
      {
        localObject1 = (String)paramHashMap1.next();
        localObject2 = (b)paramHashMap2.get(localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.MonitorNetFlowStore", 2, "mType|" + ((b)localObject2).h + "|" + ((b)localObject2).c + "|" + ((b)localObject2).b + "|" + ((b)localObject2).d + "|read|" + ((b)localObject2).f + "|" + ((b)localObject2).g + "|" + ((b)localObject2).i + "|" + ((b)localObject2).a);
        }
        if (((b)localObject2).k > 0L) {
          l1 = ((b)localObject2).k;
        }
        y.execSQL("insert into dataflow(processName, uin, ip, refer, port, flag, buffersize, networktype, mType, curtime, status) values(?,?,?,?,?,?,?,?,?,?,?)", new Object[] { ((b)localObject2).a, this.i.sender.j(), ((b)localObject2).b, ((b)localObject2).c, Integer.valueOf(((b)localObject2).d), Integer.valueOf(((b)localObject2).e), Long.valueOf(((b)localObject2).f), Integer.valueOf(((b)localObject2).g), ((b)localObject2).h, Long.valueOf(l1), Byte.valueOf(((b)localObject2).i) });
        l2 = i2;
      }
      y.setTransactionSuccessful();
      y.endTransaction();
      QLog.d("MSF.C.MonitorNetFlowStore", 1, "write data lenth : " + i1 + " | read data lenth : " + i2 + ", has been stored.");
      if (y == null) {
        break label835;
      }
      y.close();
    }
    catch (Exception paramHashMap1)
    {
      for (;;)
      {
        QLog.e("MSF.C.MonitorNetFlowStore", 1, "data store failed.", paramHashMap1);
        if (y != null) {
          y.close();
        }
      }
    }
    finally
    {
      if (y == null) {
        break label879;
      }
      y.close();
      y = null;
    }
    y = null;
  }
  
  public static void b(long paramLong)
  {
    try
    {
      if (y == null) {
        y = d.a().getWritableDatabase();
      }
      int i1 = y.delete("dataflow", "curtime < ?", new String[] { String.valueOf(paramLong) });
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.MonitorNetFlowStore", 4, "delete netflow " + i1 + " record.");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.MonitorNetFlowStore", 1, "delete expire data failed. " + localException, localException);
    }
  }
  
  /* Error */
  public HashMap a(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 94	com/tencent/mobileqq/msf/core/c/e:j	Landroid/content/Context;
    //   3: invokevirtual 636	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   6: ldc_w 638
    //   9: invokevirtual 644	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: astore 16
    //   14: new 646	java/util/Properties
    //   17: dup
    //   18: invokespecial 647	java/util/Properties:<init>	()V
    //   21: astore 18
    //   23: aload 18
    //   25: aload 16
    //   27: invokevirtual 651	java/util/Properties:loadFromXML	(Ljava/io/InputStream;)V
    //   30: invokestatic 655	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   33: astore 12
    //   35: aload 12
    //   37: bipush 6
    //   39: aload 12
    //   41: bipush 6
    //   43: invokevirtual 657	java/util/Calendar:get	(I)I
    //   46: iconst_1
    //   47: isub
    //   48: invokevirtual 661	java/util/Calendar:set	(II)V
    //   51: aload 12
    //   53: bipush 11
    //   55: iconst_0
    //   56: invokevirtual 661	java/util/Calendar:set	(II)V
    //   59: aload 12
    //   61: bipush 12
    //   63: iconst_0
    //   64: invokevirtual 661	java/util/Calendar:set	(II)V
    //   67: aload 12
    //   69: bipush 13
    //   71: iconst_0
    //   72: invokevirtual 661	java/util/Calendar:set	(II)V
    //   75: aload 12
    //   77: bipush 14
    //   79: iconst_0
    //   80: invokevirtual 661	java/util/Calendar:set	(II)V
    //   83: aload 12
    //   85: invokevirtual 423	java/util/Calendar:getTimeInMillis	()J
    //   88: lstore_1
    //   89: lload_1
    //   90: ldc2_w 662
    //   93: ladd
    //   94: lstore 8
    //   96: getstatic 140	com/tencent/mobileqq/msf/core/c/e:y	Landroid/database/sqlite/SQLiteDatabase;
    //   99: ifnonnull +12 -> 111
    //   102: invokestatic 145	com/tencent/mobileqq/msf/core/c/d:a	()Lcom/tencent/mobileqq/msf/core/c/d;
    //   105: invokevirtual 149	com/tencent/mobileqq/msf/core/c/d:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   108: putstatic 140	com/tencent/mobileqq/msf/core/c/e:y	Landroid/database/sqlite/SQLiteDatabase;
    //   111: new 77	java/util/HashMap
    //   114: dup
    //   115: invokespecial 78	java/util/HashMap:<init>	()V
    //   118: astore 17
    //   120: iconst_0
    //   121: istore 4
    //   123: iload 4
    //   125: iconst_5
    //   126: if_icmpge +1361 -> 1487
    //   129: iload_3
    //   130: ifeq +101 -> 231
    //   133: getstatic 140	com/tencent/mobileqq/msf/core/c/e:y	Landroid/database/sqlite/SQLiteDatabase;
    //   136: ldc 28
    //   138: bipush 6
    //   140: anewarray 151	java/lang/String
    //   143: dup
    //   144: iconst_0
    //   145: ldc 153
    //   147: aastore
    //   148: dup
    //   149: iconst_1
    //   150: ldc 155
    //   152: aastore
    //   153: dup
    //   154: iconst_2
    //   155: ldc 157
    //   157: aastore
    //   158: dup
    //   159: iconst_3
    //   160: ldc 161
    //   162: aastore
    //   163: dup
    //   164: iconst_4
    //   165: ldc 163
    //   167: aastore
    //   168: dup
    //   169: iconst_5
    //   170: ldc_w 665
    //   173: aastore
    //   174: ldc_w 667
    //   177: iconst_3
    //   178: anewarray 151	java/lang/String
    //   181: dup
    //   182: iconst_0
    //   183: lload_1
    //   184: invokestatic 173	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   187: aastore
    //   188: dup
    //   189: iconst_1
    //   190: lload 8
    //   192: invokestatic 173	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   195: aastore
    //   196: dup
    //   197: iconst_2
    //   198: iload 4
    //   200: invokestatic 669	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   203: aastore
    //   204: aconst_null
    //   205: aconst_null
    //   206: aconst_null
    //   207: invokevirtual 179	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   210: astore 13
    //   212: aload 13
    //   214: ifnonnull +113 -> 327
    //   217: aload 13
    //   219: ifnull +10 -> 229
    //   222: aload 13
    //   224: invokeinterface 184 1 0
    //   229: aconst_null
    //   230: areturn
    //   231: getstatic 140	com/tencent/mobileqq/msf/core/c/e:y	Landroid/database/sqlite/SQLiteDatabase;
    //   234: ldc 28
    //   236: bipush 6
    //   238: anewarray 151	java/lang/String
    //   241: dup
    //   242: iconst_0
    //   243: ldc 153
    //   245: aastore
    //   246: dup
    //   247: iconst_1
    //   248: ldc 155
    //   250: aastore
    //   251: dup
    //   252: iconst_2
    //   253: ldc 157
    //   255: aastore
    //   256: dup
    //   257: iconst_3
    //   258: ldc 161
    //   260: aastore
    //   261: dup
    //   262: iconst_4
    //   263: ldc 163
    //   265: aastore
    //   266: dup
    //   267: iconst_5
    //   268: ldc_w 665
    //   271: aastore
    //   272: ldc_w 671
    //   275: iconst_5
    //   276: anewarray 151	java/lang/String
    //   279: dup
    //   280: iconst_0
    //   281: lload_1
    //   282: invokestatic 173	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   285: aastore
    //   286: dup
    //   287: iconst_1
    //   288: lload 8
    //   290: invokestatic 173	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   293: aastore
    //   294: dup
    //   295: iconst_2
    //   296: iconst_2
    //   297: invokestatic 669	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   300: aastore
    //   301: dup
    //   302: iconst_3
    //   303: iconst_3
    //   304: invokestatic 669	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   307: aastore
    //   308: dup
    //   309: iconst_4
    //   310: iload 4
    //   312: invokestatic 669	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   315: aastore
    //   316: aconst_null
    //   317: aconst_null
    //   318: aconst_null
    //   319: invokevirtual 179	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   322: astore 13
    //   324: goto -112 -> 212
    //   327: aload 13
    //   329: invokeinterface 223 1 0
    //   334: pop
    //   335: iload 4
    //   337: ifne +565 -> 902
    //   340: iconst_1
    //   341: istore 6
    //   343: aload 13
    //   345: invokeinterface 226 1 0
    //   350: ifne +1428 -> 1778
    //   353: aload 13
    //   355: iconst_0
    //   356: invokeinterface 233 2 0
    //   361: astore 14
    //   363: aload 13
    //   365: iconst_1
    //   366: invokeinterface 233 2 0
    //   371: astore 19
    //   373: aload 13
    //   375: iconst_2
    //   376: invokeinterface 249 2 0
    //   381: lstore 10
    //   383: aload 13
    //   385: iconst_3
    //   386: invokeinterface 233 2 0
    //   391: astore 12
    //   393: aload 13
    //   395: iconst_4
    //   396: invokeinterface 256 2 0
    //   401: istore 7
    //   403: iload 7
    //   405: iconst_3
    //   406: if_icmpeq +503 -> 909
    //   409: iload 7
    //   411: iconst_2
    //   412: if_icmpeq +497 -> 909
    //   415: iconst_1
    //   416: istore 5
    //   418: aload 14
    //   420: ldc_w 453
    //   423: invokevirtual 445	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   426: ifne +1396 -> 1822
    //   429: aload 12
    //   431: ldc_w 673
    //   434: invokevirtual 437	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   437: ifne +1385 -> 1822
    //   440: aload 12
    //   442: ldc_w 675
    //   445: invokevirtual 437	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   448: ifne +1374 -> 1822
    //   451: aload 12
    //   453: ldc_w 677
    //   456: invokevirtual 437	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   459: ifne +1363 -> 1822
    //   462: aload 14
    //   464: ldc_w 449
    //   467: invokevirtual 445	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   470: ifeq +461 -> 931
    //   473: aload 12
    //   475: ldc 11
    //   477: invokevirtual 680	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   480: ifeq +537 -> 1017
    //   483: aload 18
    //   485: new 228	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   492: ldc 11
    //   494: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: iload 5
    //   499: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   502: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokevirtual 681	java/util/Properties:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   508: checkcast 151	java/lang/String
    //   511: astore 14
    //   513: aload 17
    //   515: aload 19
    //   517: invokevirtual 684	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   520: ifeq +779 -> 1299
    //   523: aload 17
    //   525: aload 19
    //   527: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   530: checkcast 686	android/util/SparseArray
    //   533: iload 6
    //   535: invokevirtual 689	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   538: ifnonnull +29 -> 567
    //   541: new 77	java/util/HashMap
    //   544: dup
    //   545: invokespecial 78	java/util/HashMap:<init>	()V
    //   548: astore 15
    //   550: aload 17
    //   552: aload 19
    //   554: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   557: checkcast 686	android/util/SparseArray
    //   560: iload 6
    //   562: aload 15
    //   564: invokevirtual 693	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   567: aload 14
    //   569: ifnonnull +584 -> 1153
    //   572: new 228	java/lang/StringBuilder
    //   575: dup
    //   576: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   579: astore 20
    //   581: iload 5
    //   583: iconst_1
    //   584: if_icmpne +1244 -> 1828
    //   587: ldc_w 695
    //   590: astore 15
    //   592: aload 20
    //   594: aload 15
    //   596: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: aload 12
    //   601: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: ldc_w 697
    //   607: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: astore 12
    //   615: aload 17
    //   617: aload 19
    //   619: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   622: checkcast 686	android/util/SparseArray
    //   625: iload 6
    //   627: invokevirtual 689	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   630: checkcast 77	java/util/HashMap
    //   633: aload 12
    //   635: invokevirtual 684	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   638: ifeq +412 -> 1050
    //   641: aload 17
    //   643: aload 19
    //   645: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   648: checkcast 686	android/util/SparseArray
    //   651: iload 6
    //   653: invokevirtual 689	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   656: checkcast 77	java/util/HashMap
    //   659: astore 15
    //   661: aload 15
    //   663: aload 12
    //   665: aload 15
    //   667: aload 12
    //   669: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   672: checkcast 261	java/lang/Long
    //   675: invokevirtual 700	java/lang/Long:longValue	()J
    //   678: lload 10
    //   680: ladd
    //   681: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   684: invokevirtual 703	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   687: pop
    //   688: aload 17
    //   690: aload 19
    //   692: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   695: checkcast 686	android/util/SparseArray
    //   698: iload 6
    //   700: aload 15
    //   702: invokevirtual 693	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   705: iload_3
    //   706: ifeq +19 -> 725
    //   709: aload 14
    //   711: ifnull +14 -> 725
    //   714: aload 14
    //   716: ldc_w 695
    //   719: invokevirtual 680	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   722: ifne +18 -> 740
    //   725: iload_3
    //   726: ifeq +105 -> 831
    //   729: aload 12
    //   731: ldc_w 695
    //   734: invokevirtual 680	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   737: ifeq +94 -> 831
    //   740: aload 17
    //   742: aload 19
    //   744: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   747: checkcast 686	android/util/SparseArray
    //   750: iload 6
    //   752: invokevirtual 689	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   755: checkcast 77	java/util/HashMap
    //   758: astore 12
    //   760: aload 12
    //   762: ifnonnull +1063 -> 1825
    //   765: new 77	java/util/HashMap
    //   768: dup
    //   769: invokespecial 78	java/util/HashMap:<init>	()V
    //   772: astore 12
    //   774: aload 12
    //   776: ldc_w 705
    //   779: invokevirtual 684	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   782: ifeq +671 -> 1453
    //   785: aload 12
    //   787: ldc_w 705
    //   790: lload 10
    //   792: aload 12
    //   794: ldc_w 705
    //   797: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   800: checkcast 261	java/lang/Long
    //   803: invokevirtual 700	java/lang/Long:longValue	()J
    //   806: ladd
    //   807: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   810: invokevirtual 703	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   813: pop
    //   814: aload 17
    //   816: aload 19
    //   818: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   821: checkcast 686	android/util/SparseArray
    //   824: iload 6
    //   826: aload 12
    //   828: invokevirtual 693	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   831: aload 13
    //   833: invokeinterface 279 1 0
    //   838: pop
    //   839: goto -496 -> 343
    //   842: astore 14
    //   844: aload 13
    //   846: astore 12
    //   848: aload 14
    //   850: astore 13
    //   852: ldc 8
    //   854: iconst_1
    //   855: new 228	java/lang/StringBuilder
    //   858: dup
    //   859: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   862: ldc_w 707
    //   865: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: aload 13
    //   870: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   873: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   876: aload 13
    //   878: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   881: aload 12
    //   883: ifnull +10 -> 893
    //   886: aload 12
    //   888: invokeinterface 184 1 0
    //   893: iload 4
    //   895: iconst_1
    //   896: iadd
    //   897: istore 4
    //   899: goto -776 -> 123
    //   902: iload 4
    //   904: istore 6
    //   906: goto -563 -> 343
    //   909: iload 7
    //   911: iconst_2
    //   912: if_icmpeq +13 -> 925
    //   915: iload 7
    //   917: istore 5
    //   919: iload 7
    //   921: iconst_3
    //   922: if_icmpne -504 -> 418
    //   925: iconst_2
    //   926: istore 5
    //   928: goto -510 -> 418
    //   931: aload 14
    //   933: ldc_w 709
    //   936: invokevirtual 445	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   939: ifeq +11 -> 950
    //   942: ldc_w 441
    //   945: astore 12
    //   947: goto -474 -> 473
    //   950: aload 14
    //   952: ldc_w 711
    //   955: invokevirtual 715	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   958: ifeq +864 -> 1822
    //   961: aload 14
    //   963: ldc_w 711
    //   966: invokevirtual 719	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   969: istore 7
    //   971: new 228	java/lang/StringBuilder
    //   974: dup
    //   975: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   978: aload 14
    //   980: iload 7
    //   982: iconst_1
    //   983: iadd
    //   984: iload 7
    //   986: iconst_2
    //   987: iadd
    //   988: invokevirtual 723	java/lang/String:substring	(II)Ljava/lang/String;
    //   991: invokevirtual 726	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   994: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   997: aload 14
    //   999: iload 7
    //   1001: iconst_2
    //   1002: iadd
    //   1003: invokevirtual 728	java/lang/String:substring	(I)Ljava/lang/String;
    //   1006: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1012: astore 12
    //   1014: goto -541 -> 473
    //   1017: aload 18
    //   1019: new 228	java/lang/StringBuilder
    //   1022: dup
    //   1023: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1026: aload 12
    //   1028: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1031: iload 5
    //   1033: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1036: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1039: invokevirtual 681	java/util/Properties:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1042: checkcast 151	java/lang/String
    //   1045: astore 14
    //   1047: goto -534 -> 513
    //   1050: aload 17
    //   1052: aload 19
    //   1054: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1057: checkcast 686	android/util/SparseArray
    //   1060: iload 6
    //   1062: invokevirtual 689	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1065: checkcast 77	java/util/HashMap
    //   1068: astore 15
    //   1070: aload 15
    //   1072: aload 12
    //   1074: lload 10
    //   1076: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1079: invokevirtual 703	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1082: pop
    //   1083: aload 17
    //   1085: aload 19
    //   1087: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1090: checkcast 686	android/util/SparseArray
    //   1093: iload 6
    //   1095: aload 15
    //   1097: invokevirtual 693	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1100: goto -395 -> 705
    //   1103: astore 12
    //   1105: aload 13
    //   1107: ifnull +10 -> 1117
    //   1110: aload 13
    //   1112: invokeinterface 184 1 0
    //   1117: aload 12
    //   1119: athrow
    //   1120: astore 12
    //   1122: ldc 8
    //   1124: iconst_1
    //   1125: new 228	java/lang/StringBuilder
    //   1128: dup
    //   1129: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1132: ldc_w 730
    //   1135: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1138: aload 12
    //   1140: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1143: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1146: aload 12
    //   1148: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1151: aconst_null
    //   1152: areturn
    //   1153: aload 17
    //   1155: aload 19
    //   1157: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1160: checkcast 686	android/util/SparseArray
    //   1163: iload 6
    //   1165: invokevirtual 689	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1168: checkcast 77	java/util/HashMap
    //   1171: aload 14
    //   1173: invokevirtual 684	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1176: ifeq +70 -> 1246
    //   1179: aload 17
    //   1181: aload 19
    //   1183: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1186: checkcast 686	android/util/SparseArray
    //   1189: iload 6
    //   1191: invokevirtual 689	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1194: checkcast 77	java/util/HashMap
    //   1197: astore 15
    //   1199: aload 15
    //   1201: aload 14
    //   1203: aload 15
    //   1205: aload 14
    //   1207: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1210: checkcast 261	java/lang/Long
    //   1213: invokevirtual 700	java/lang/Long:longValue	()J
    //   1216: lload 10
    //   1218: ladd
    //   1219: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1222: invokevirtual 703	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1225: pop
    //   1226: aload 17
    //   1228: aload 19
    //   1230: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1233: checkcast 686	android/util/SparseArray
    //   1236: iload 6
    //   1238: aload 15
    //   1240: invokevirtual 693	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1243: goto -538 -> 705
    //   1246: aload 17
    //   1248: aload 19
    //   1250: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1253: checkcast 686	android/util/SparseArray
    //   1256: iload 6
    //   1258: invokevirtual 689	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1261: checkcast 77	java/util/HashMap
    //   1264: astore 15
    //   1266: aload 15
    //   1268: aload 14
    //   1270: lload 10
    //   1272: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1275: invokevirtual 703	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1278: pop
    //   1279: aload 17
    //   1281: aload 19
    //   1283: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1286: checkcast 686	android/util/SparseArray
    //   1289: iload 6
    //   1291: aload 15
    //   1293: invokevirtual 693	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1296: goto -591 -> 705
    //   1299: aload 14
    //   1301: ifnonnull +99 -> 1400
    //   1304: new 228	java/lang/StringBuilder
    //   1307: dup
    //   1308: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1311: astore 20
    //   1313: iload 5
    //   1315: iconst_1
    //   1316: if_icmpne +520 -> 1836
    //   1319: ldc_w 695
    //   1322: astore 15
    //   1324: aload 20
    //   1326: aload 15
    //   1328: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1331: aload 12
    //   1333: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1336: ldc_w 697
    //   1339: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1342: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1345: astore 12
    //   1347: new 77	java/util/HashMap
    //   1350: dup
    //   1351: invokespecial 78	java/util/HashMap:<init>	()V
    //   1354: astore 15
    //   1356: aload 15
    //   1358: aload 12
    //   1360: lload 10
    //   1362: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1365: invokevirtual 703	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1368: pop
    //   1369: new 686	android/util/SparseArray
    //   1372: dup
    //   1373: invokespecial 731	android/util/SparseArray:<init>	()V
    //   1376: astore 20
    //   1378: aload 20
    //   1380: iload 6
    //   1382: aload 15
    //   1384: invokevirtual 693	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1387: aload 17
    //   1389: aload 19
    //   1391: aload 20
    //   1393: invokevirtual 703	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1396: pop
    //   1397: goto -692 -> 705
    //   1400: new 77	java/util/HashMap
    //   1403: dup
    //   1404: invokespecial 78	java/util/HashMap:<init>	()V
    //   1407: astore 15
    //   1409: aload 15
    //   1411: aload 14
    //   1413: lload 10
    //   1415: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1418: invokevirtual 703	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1421: pop
    //   1422: new 686	android/util/SparseArray
    //   1425: dup
    //   1426: invokespecial 731	android/util/SparseArray:<init>	()V
    //   1429: astore 20
    //   1431: aload 20
    //   1433: iload 6
    //   1435: aload 15
    //   1437: invokevirtual 693	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1440: aload 17
    //   1442: aload 19
    //   1444: aload 20
    //   1446: invokevirtual 703	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1449: pop
    //   1450: goto -745 -> 705
    //   1453: aload 12
    //   1455: ldc_w 705
    //   1458: lload 10
    //   1460: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1463: invokevirtual 703	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1466: pop
    //   1467: aload 17
    //   1469: aload 19
    //   1471: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1474: checkcast 686	android/util/SparseArray
    //   1477: iload 6
    //   1479: aload 12
    //   1481: invokevirtual 693	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1484: goto -653 -> 831
    //   1487: aload 17
    //   1489: invokevirtual 535	java/util/HashMap:keySet	()Ljava/util/Set;
    //   1492: invokeinterface 541 1 0
    //   1497: astore 12
    //   1499: aload 12
    //   1501: invokeinterface 546 1 0
    //   1506: ifeq +264 -> 1770
    //   1509: aload 12
    //   1511: invokeinterface 550 1 0
    //   1516: checkcast 151	java/lang/String
    //   1519: astore 13
    //   1521: iconst_1
    //   1522: istore 4
    //   1524: iload 4
    //   1526: iconst_5
    //   1527: if_icmpge -28 -> 1499
    //   1530: aload 17
    //   1532: aload 13
    //   1534: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1537: checkcast 686	android/util/SparseArray
    //   1540: iload 4
    //   1542: invokevirtual 689	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1545: checkcast 77	java/util/HashMap
    //   1548: astore 14
    //   1550: aload 14
    //   1552: ifnonnull +6 -> 1558
    //   1555: goto +289 -> 1844
    //   1558: aload 14
    //   1560: invokevirtual 535	java/util/HashMap:keySet	()Ljava/util/Set;
    //   1563: invokeinterface 541 1 0
    //   1568: astore 14
    //   1570: aload 14
    //   1572: invokeinterface 546 1 0
    //   1577: ifeq +267 -> 1844
    //   1580: aload 14
    //   1582: invokeinterface 550 1 0
    //   1587: checkcast 151	java/lang/String
    //   1590: astore 15
    //   1592: iload_3
    //   1593: ifeq +90 -> 1683
    //   1596: ldc 8
    //   1598: iconst_1
    //   1599: new 228	java/lang/StringBuilder
    //   1602: dup
    //   1603: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1606: ldc_w 733
    //   1609: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1612: aload 13
    //   1614: invokestatic 245	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   1617: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1620: ldc_w 735
    //   1623: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1626: aload 15
    //   1628: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1631: ldc_w 737
    //   1634: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1637: aload 17
    //   1639: aload 13
    //   1641: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1644: checkcast 686	android/util/SparseArray
    //   1647: iload 4
    //   1649: invokevirtual 689	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1652: checkcast 77	java/util/HashMap
    //   1655: aload 15
    //   1657: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1660: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1663: ldc_w 737
    //   1666: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1669: iload 4
    //   1671: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1674: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1677: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1680: goto -110 -> 1570
    //   1683: ldc 8
    //   1685: iconst_1
    //   1686: new 228	java/lang/StringBuilder
    //   1689: dup
    //   1690: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1693: ldc_w 739
    //   1696: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1699: aload 13
    //   1701: invokestatic 245	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   1704: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1707: ldc_w 735
    //   1710: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1713: aload 15
    //   1715: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1718: ldc_w 737
    //   1721: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1724: aload 17
    //   1726: aload 13
    //   1728: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1731: checkcast 686	android/util/SparseArray
    //   1734: iload 4
    //   1736: invokevirtual 689	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1739: checkcast 77	java/util/HashMap
    //   1742: aload 15
    //   1744: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1747: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1750: ldc_w 737
    //   1753: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1756: iload 4
    //   1758: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1761: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1764: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1767: goto -197 -> 1570
    //   1770: aload 16
    //   1772: invokevirtual 742	java/io/InputStream:close	()V
    //   1775: aload 17
    //   1777: areturn
    //   1778: aload 13
    //   1780: ifnull -887 -> 893
    //   1783: aload 13
    //   1785: invokeinterface 184 1 0
    //   1790: goto -897 -> 893
    //   1793: astore 12
    //   1795: aconst_null
    //   1796: astore 13
    //   1798: goto -693 -> 1105
    //   1801: astore 14
    //   1803: aload 12
    //   1805: astore 13
    //   1807: aload 14
    //   1809: astore 12
    //   1811: goto -706 -> 1105
    //   1814: astore 13
    //   1816: aconst_null
    //   1817: astore 12
    //   1819: goto -967 -> 852
    //   1822: goto -1349 -> 473
    //   1825: goto -1051 -> 774
    //   1828: ldc_w 744
    //   1831: astore 15
    //   1833: goto -1241 -> 592
    //   1836: ldc_w 744
    //   1839: astore 15
    //   1841: goto -517 -> 1324
    //   1844: iload 4
    //   1846: iconst_1
    //   1847: iadd
    //   1848: istore 4
    //   1850: goto -326 -> 1524
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1853	0	this	e
    //   0	1853	1	paramLong	long
    //   0	1853	3	paramBoolean	boolean
    //   121	1728	4	i1	int
    //   416	901	5	i2	int
    //   341	1137	6	i3	int
    //   401	602	7	i4	int
    //   94	195	8	l1	long
    //   381	1078	10	l2	long
    //   33	1040	12	localObject1	Object
    //   1103	15	12	localObject2	Object
    //   1120	212	12	localException1	Exception
    //   1345	165	12	localObject3	Object
    //   1793	11	12	localObject4	Object
    //   1809	9	12	localObject5	Object
    //   210	1596	13	localObject6	Object
    //   1814	1	13	localException2	Exception
    //   361	354	14	str1	String
    //   842	156	14	localException3	Exception
    //   1045	536	14	localObject7	Object
    //   1801	7	14	localObject8	Object
    //   548	1292	15	localObject9	Object
    //   12	1759	16	localInputStream	java.io.InputStream
    //   118	1658	17	localHashMap	HashMap
    //   21	997	18	localProperties	java.util.Properties
    //   371	1099	19	str2	String
    //   579	866	20	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   327	335	842	java/lang/Exception
    //   343	403	842	java/lang/Exception
    //   418	473	842	java/lang/Exception
    //   473	513	842	java/lang/Exception
    //   513	567	842	java/lang/Exception
    //   572	581	842	java/lang/Exception
    //   592	705	842	java/lang/Exception
    //   714	725	842	java/lang/Exception
    //   729	740	842	java/lang/Exception
    //   740	760	842	java/lang/Exception
    //   765	774	842	java/lang/Exception
    //   774	831	842	java/lang/Exception
    //   831	839	842	java/lang/Exception
    //   931	942	842	java/lang/Exception
    //   950	1014	842	java/lang/Exception
    //   1017	1047	842	java/lang/Exception
    //   1050	1100	842	java/lang/Exception
    //   1153	1243	842	java/lang/Exception
    //   1246	1296	842	java/lang/Exception
    //   1304	1313	842	java/lang/Exception
    //   1324	1397	842	java/lang/Exception
    //   1400	1450	842	java/lang/Exception
    //   1453	1484	842	java/lang/Exception
    //   327	335	1103	finally
    //   343	403	1103	finally
    //   418	473	1103	finally
    //   473	513	1103	finally
    //   513	567	1103	finally
    //   572	581	1103	finally
    //   592	705	1103	finally
    //   714	725	1103	finally
    //   729	740	1103	finally
    //   740	760	1103	finally
    //   765	774	1103	finally
    //   774	831	1103	finally
    //   831	839	1103	finally
    //   931	942	1103	finally
    //   950	1014	1103	finally
    //   1017	1047	1103	finally
    //   1050	1100	1103	finally
    //   1153	1243	1103	finally
    //   1246	1296	1103	finally
    //   1304	1313	1103	finally
    //   1324	1397	1103	finally
    //   1400	1450	1103	finally
    //   1453	1484	1103	finally
    //   0	89	1120	java/lang/Exception
    //   96	111	1120	java/lang/Exception
    //   111	120	1120	java/lang/Exception
    //   222	229	1120	java/lang/Exception
    //   886	893	1120	java/lang/Exception
    //   1110	1117	1120	java/lang/Exception
    //   1117	1120	1120	java/lang/Exception
    //   1487	1499	1120	java/lang/Exception
    //   1499	1521	1120	java/lang/Exception
    //   1530	1550	1120	java/lang/Exception
    //   1558	1570	1120	java/lang/Exception
    //   1570	1592	1120	java/lang/Exception
    //   1596	1680	1120	java/lang/Exception
    //   1683	1767	1120	java/lang/Exception
    //   1770	1775	1120	java/lang/Exception
    //   1783	1790	1120	java/lang/Exception
    //   133	212	1793	finally
    //   231	324	1793	finally
    //   852	881	1801	finally
    //   133	212	1814	java/lang/Exception
    //   231	324	1814	java/lang/Exception
  }
  
  public void a()
  {
    if (this.p)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.MonitorNetFlowStore", 2, Thread.currentThread().getName() + " insertSocketDataFlow writeSize=" + this.k.size() + " readSize=" + this.l.size());
      }
      if (this.k.size() + this.l.size() > 0)
      {
        if (this.s == null) {
          this.s = new e.a(this);
        }
        this.r.post(this.s);
      }
    }
  }
  
  public void a(long paramLong)
  {
    Intent localIntent = new Intent(this.n);
    localIntent.setAction(this.n);
    this.o = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, localIntent, 0);
    this.m = ((AlarmManager)BaseApplication.getContext().getSystemService("alarm"));
    if (QLog.isColorLevel()) {
      this.m.setRepeating(0, paramLong, 300000L, this.o);
    }
    for (;;)
    {
      QLog.d("MSF.C.MonitorNetFlowStore", 1, "register " + this.n.hashCode() + " alarm alive send at " + g.format(Long.valueOf(paramLong)));
      return;
      this.m.setRepeating(0, paramLong, 600000L, this.o);
    }
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.MonitorNetFlowStore", 2, "receive broadcast : " + paramIntent.getAction() + ", start to store socket flow at " + g.format(Long.valueOf(System.currentTimeMillis())));
    }
    a();
  }
  
  public void a(b paramb)
  {
    b localb;
    for (;;)
    {
      try
      {
        int i1 = paramb.e;
        switch (i1)
        {
        }
      }
      catch (Exception paramb)
      {
        QLog.d("MSF.C.MonitorNetFlowStore", 1, "MonitorDataFlow cache failed.", paramb);
        continue;
        this.k.put(paramb.h + paramb.g + paramb.i, paramb);
        continue;
      }
      if ((this.p) && ((this.k.size() + this.l.size() >= 100) || (System.currentTimeMillis() - this.t >= 300000L))) {
        a();
      }
      return;
      synchronized (this.k)
      {
        localb = (b)this.k.get(paramb.h + paramb.g + paramb.i);
        if (localb != null) {
          this.k.put(paramb.h + paramb.g + paramb.i, localb.a(paramb.f));
        }
      }
    }
    for (;;)
    {
      synchronized (this.l)
      {
        localb = (b)this.l.get(paramb.h + paramb.g + paramb.i);
        if (localb != null) {
          this.l.put(paramb.h + paramb.g + paramb.i, localb.a(paramb.f));
        }
      }
      this.l.put(paramb.h + paramb.g + paramb.i, paramb);
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
    //   0: getstatic 94	com/tencent/mobileqq/msf/core/c/e:j	Landroid/content/Context;
    //   3: invokevirtual 636	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   6: ldc_w 638
    //   9: invokevirtual 644	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: astore 16
    //   14: new 646	java/util/Properties
    //   17: dup
    //   18: invokespecial 647	java/util/Properties:<init>	()V
    //   21: astore 17
    //   23: aload 17
    //   25: aload 16
    //   27: invokevirtual 651	java/util/Properties:loadFromXML	(Ljava/io/InputStream;)V
    //   30: invokestatic 655	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   33: astore 11
    //   35: aload 11
    //   37: bipush 6
    //   39: aload 11
    //   41: bipush 6
    //   43: invokevirtual 657	java/util/Calendar:get	(I)I
    //   46: iconst_1
    //   47: isub
    //   48: invokevirtual 661	java/util/Calendar:set	(II)V
    //   51: aload 11
    //   53: bipush 11
    //   55: iconst_0
    //   56: invokevirtual 661	java/util/Calendar:set	(II)V
    //   59: aload 11
    //   61: bipush 12
    //   63: iconst_0
    //   64: invokevirtual 661	java/util/Calendar:set	(II)V
    //   67: aload 11
    //   69: bipush 13
    //   71: iconst_0
    //   72: invokevirtual 661	java/util/Calendar:set	(II)V
    //   75: aload 11
    //   77: bipush 14
    //   79: iconst_0
    //   80: invokevirtual 661	java/util/Calendar:set	(II)V
    //   83: aload 11
    //   85: invokevirtual 423	java/util/Calendar:getTimeInMillis	()J
    //   88: lstore_1
    //   89: lload_1
    //   90: ldc2_w 662
    //   93: ladd
    //   94: lstore 7
    //   96: getstatic 140	com/tencent/mobileqq/msf/core/c/e:y	Landroid/database/sqlite/SQLiteDatabase;
    //   99: ifnonnull +12 -> 111
    //   102: invokestatic 145	com/tencent/mobileqq/msf/core/c/d:a	()Lcom/tencent/mobileqq/msf/core/c/d;
    //   105: invokevirtual 149	com/tencent/mobileqq/msf/core/c/d:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   108: putstatic 140	com/tencent/mobileqq/msf/core/c/e:y	Landroid/database/sqlite/SQLiteDatabase;
    //   111: iload_3
    //   112: ifeq +117 -> 229
    //   115: getstatic 140	com/tencent/mobileqq/msf/core/c/e:y	Landroid/database/sqlite/SQLiteDatabase;
    //   118: ldc 28
    //   120: bipush 10
    //   122: anewarray 151	java/lang/String
    //   125: dup
    //   126: iconst_0
    //   127: ldc 153
    //   129: aastore
    //   130: dup
    //   131: iconst_1
    //   132: ldc 155
    //   134: aastore
    //   135: dup
    //   136: iconst_2
    //   137: ldc_w 825
    //   140: aastore
    //   141: dup
    //   142: iconst_3
    //   143: ldc 157
    //   145: aastore
    //   146: dup
    //   147: iconst_4
    //   148: ldc 161
    //   150: aastore
    //   151: dup
    //   152: iconst_5
    //   153: ldc 163
    //   155: aastore
    //   156: dup
    //   157: bipush 6
    //   159: ldc_w 665
    //   162: aastore
    //   163: dup
    //   164: bipush 7
    //   166: ldc 159
    //   168: aastore
    //   169: dup
    //   170: bipush 8
    //   172: ldc 165
    //   174: aastore
    //   175: dup
    //   176: bipush 9
    //   178: ldc 167
    //   180: aastore
    //   181: ldc 169
    //   183: iconst_2
    //   184: anewarray 151	java/lang/String
    //   187: dup
    //   188: iconst_0
    //   189: lload_1
    //   190: invokestatic 173	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   193: aastore
    //   194: dup
    //   195: iconst_1
    //   196: lload 7
    //   198: invokestatic 173	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   201: aastore
    //   202: aconst_null
    //   203: aconst_null
    //   204: aconst_null
    //   205: invokevirtual 179	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   208: astore 13
    //   210: aload 13
    //   212: ifnonnull +130 -> 342
    //   215: aload 13
    //   217: ifnull +10 -> 227
    //   220: aload 13
    //   222: invokeinterface 184 1 0
    //   227: aconst_null
    //   228: areturn
    //   229: getstatic 140	com/tencent/mobileqq/msf/core/c/e:y	Landroid/database/sqlite/SQLiteDatabase;
    //   232: ldc 28
    //   234: bipush 10
    //   236: anewarray 151	java/lang/String
    //   239: dup
    //   240: iconst_0
    //   241: ldc 153
    //   243: aastore
    //   244: dup
    //   245: iconst_1
    //   246: ldc 155
    //   248: aastore
    //   249: dup
    //   250: iconst_2
    //   251: ldc_w 825
    //   254: aastore
    //   255: dup
    //   256: iconst_3
    //   257: ldc 157
    //   259: aastore
    //   260: dup
    //   261: iconst_4
    //   262: ldc 161
    //   264: aastore
    //   265: dup
    //   266: iconst_5
    //   267: ldc 163
    //   269: aastore
    //   270: dup
    //   271: bipush 6
    //   273: ldc_w 665
    //   276: aastore
    //   277: dup
    //   278: bipush 7
    //   280: ldc 159
    //   282: aastore
    //   283: dup
    //   284: bipush 8
    //   286: ldc 165
    //   288: aastore
    //   289: dup
    //   290: bipush 9
    //   292: ldc 167
    //   294: aastore
    //   295: ldc_w 861
    //   298: iconst_4
    //   299: anewarray 151	java/lang/String
    //   302: dup
    //   303: iconst_0
    //   304: lload_1
    //   305: invokestatic 173	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   308: aastore
    //   309: dup
    //   310: iconst_1
    //   311: lload 7
    //   313: invokestatic 173	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   316: aastore
    //   317: dup
    //   318: iconst_2
    //   319: iconst_2
    //   320: invokestatic 669	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   323: aastore
    //   324: dup
    //   325: iconst_3
    //   326: iconst_3
    //   327: invokestatic 669	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   330: aastore
    //   331: aconst_null
    //   332: aconst_null
    //   333: aconst_null
    //   334: invokevirtual 179	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   337: astore 13
    //   339: goto -129 -> 210
    //   342: new 77	java/util/HashMap
    //   345: dup
    //   346: invokespecial 78	java/util/HashMap:<init>	()V
    //   349: astore 18
    //   351: iload_3
    //   352: ifeq +1922 -> 2274
    //   355: aload_0
    //   356: aload 11
    //   358: invokespecial 863	com/tencent/mobileqq/msf/core/c/e:a	(Ljava/util/Calendar;)Ljava/io/PrintWriter;
    //   361: astore 15
    //   363: aload 13
    //   365: invokeinterface 223 1 0
    //   370: pop
    //   371: lconst_0
    //   372: lstore_1
    //   373: aload 13
    //   375: invokeinterface 226 1 0
    //   380: ifne +1520 -> 1900
    //   383: aload 13
    //   385: iconst_0
    //   386: invokeinterface 233 2 0
    //   391: astore 14
    //   393: aload 13
    //   395: iconst_1
    //   396: invokeinterface 233 2 0
    //   401: astore 19
    //   403: aload 13
    //   405: iconst_2
    //   406: invokeinterface 233 2 0
    //   411: astore 20
    //   413: aload 13
    //   415: iconst_3
    //   416: invokeinterface 249 2 0
    //   421: lstore 7
    //   423: aload 13
    //   425: iconst_4
    //   426: invokeinterface 233 2 0
    //   431: astore 11
    //   433: aload 13
    //   435: iconst_5
    //   436: invokeinterface 256 2 0
    //   441: istore 4
    //   443: aload 13
    //   445: bipush 6
    //   447: invokeinterface 256 2 0
    //   452: istore 5
    //   454: aload 13
    //   456: bipush 7
    //   458: invokeinterface 256 2 0
    //   463: istore 6
    //   465: aload 13
    //   467: bipush 8
    //   469: invokeinterface 233 2 0
    //   474: astore 12
    //   476: aload 13
    //   478: bipush 9
    //   480: invokeinterface 249 2 0
    //   485: lstore 9
    //   487: iload 4
    //   489: iconst_3
    //   490: if_icmpeq +769 -> 1259
    //   493: iload 4
    //   495: iconst_2
    //   496: if_icmpeq +763 -> 1259
    //   499: iconst_1
    //   500: istore 4
    //   502: lload_1
    //   503: lload 7
    //   505: ladd
    //   506: lstore_1
    //   507: iload_3
    //   508: ifeq +278 -> 786
    //   511: aload 15
    //   513: ifnull +273 -> 786
    //   516: aload 15
    //   518: ldc_w 865
    //   521: invokevirtual 403	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   524: aload 15
    //   526: new 228	java/lang/StringBuilder
    //   529: dup
    //   530: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   533: aload_0
    //   534: aload 14
    //   536: invokespecial 867	com/tencent/mobileqq/msf/core/c/e:a	(Ljava/lang/String;)Ljava/lang/String;
    //   539: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: ldc 239
    //   544: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokevirtual 403	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   553: aload 15
    //   555: new 228	java/lang/StringBuilder
    //   558: dup
    //   559: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   562: aload 19
    //   564: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: ldc 239
    //   569: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: invokevirtual 403	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   578: aload 15
    //   580: new 228	java/lang/StringBuilder
    //   583: dup
    //   584: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   587: iload 5
    //   589: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   592: ldc 239
    //   594: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokevirtual 403	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   603: aload 15
    //   605: new 228	java/lang/StringBuilder
    //   608: dup
    //   609: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   612: aload 11
    //   614: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: ldc 239
    //   619: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokevirtual 403	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   628: aload 15
    //   630: new 228	java/lang/StringBuilder
    //   633: dup
    //   634: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   637: lload 7
    //   639: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   642: ldc 239
    //   644: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   650: invokevirtual 403	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   653: aload 15
    //   655: new 228	java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   662: iload 6
    //   664: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   667: ldc 239
    //   669: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: invokevirtual 403	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   678: aload 15
    //   680: new 228	java/lang/StringBuilder
    //   683: dup
    //   684: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   687: lload 9
    //   689: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   692: ldc 239
    //   694: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: invokevirtual 403	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   703: aload 15
    //   705: new 228	java/lang/StringBuilder
    //   708: dup
    //   709: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   712: iload 4
    //   714: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   717: ldc 239
    //   719: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   725: invokevirtual 403	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   728: aload 15
    //   730: new 228	java/lang/StringBuilder
    //   733: dup
    //   734: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   737: aload 20
    //   739: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: ldc 239
    //   744: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   750: invokevirtual 403	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   753: aload 15
    //   755: new 228	java/lang/StringBuilder
    //   758: dup
    //   759: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   762: aload 12
    //   764: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: ldc 239
    //   769: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   775: invokevirtual 403	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   778: aload 15
    //   780: ldc_w 291
    //   783: invokevirtual 403	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   786: aload 11
    //   788: astore 12
    //   790: aload 14
    //   792: ldc_w 453
    //   795: invokevirtual 445	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   798: ifne +63 -> 861
    //   801: aload 11
    //   803: astore 12
    //   805: aload 11
    //   807: ldc_w 673
    //   810: invokevirtual 437	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   813: ifne +48 -> 861
    //   816: aload 11
    //   818: astore 12
    //   820: aload 11
    //   822: ldc_w 675
    //   825: invokevirtual 437	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   828: ifne +33 -> 861
    //   831: aload 11
    //   833: astore 12
    //   835: aload 11
    //   837: ldc_w 677
    //   840: invokevirtual 437	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   843: ifne +18 -> 861
    //   846: aload 14
    //   848: ldc_w 449
    //   851: invokevirtual 445	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   854: ifeq +423 -> 1277
    //   857: aload 11
    //   859: astore 12
    //   861: aload 12
    //   863: ldc 11
    //   865: invokevirtual 680	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   868: ifeq +499 -> 1367
    //   871: aload 17
    //   873: new 228	java/lang/StringBuilder
    //   876: dup
    //   877: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   880: ldc 11
    //   882: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: iload 4
    //   887: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   890: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   893: invokevirtual 681	java/util/Properties:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   896: checkcast 151	java/lang/String
    //   899: astore 11
    //   901: aload 18
    //   903: aload 19
    //   905: invokevirtual 684	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   908: ifeq +692 -> 1600
    //   911: aload 11
    //   913: ifnonnull +511 -> 1424
    //   916: new 228	java/lang/StringBuilder
    //   919: dup
    //   920: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   923: astore 21
    //   925: iload 4
    //   927: iconst_1
    //   928: if_icmpne +1352 -> 2280
    //   931: ldc_w 695
    //   934: astore 14
    //   936: aload 21
    //   938: aload 14
    //   940: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: aload 12
    //   945: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: ldc_w 697
    //   951: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   954: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   957: astore 14
    //   959: aload 14
    //   961: astore 12
    //   963: iload_3
    //   964: ifne +75 -> 1039
    //   967: aload 14
    //   969: astore 12
    //   971: lload 7
    //   973: ldc2_w 868
    //   976: lcmp
    //   977: ifle +62 -> 1039
    //   980: aload 14
    //   982: astore 12
    //   984: aload 20
    //   986: ifnull +53 -> 1039
    //   989: aload 14
    //   991: astore 12
    //   993: aload 20
    //   995: invokestatic 874	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   998: ifne +41 -> 1039
    //   1001: aload 14
    //   1003: astore 12
    //   1005: invokestatic 878	com/tencent/mobileqq/msf/core/a/a:g	()Z
    //   1008: ifeq +31 -> 1039
    //   1011: new 228	java/lang/StringBuilder
    //   1014: dup
    //   1015: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1018: aload 14
    //   1020: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1023: ldc_w 880
    //   1026: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: aload 20
    //   1031: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1037: astore 12
    //   1039: aload 18
    //   1041: aload 19
    //   1043: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1046: checkcast 77	java/util/HashMap
    //   1049: aload 12
    //   1051: invokevirtual 684	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1054: ifeq +346 -> 1400
    //   1057: aload 18
    //   1059: aload 19
    //   1061: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1064: checkcast 77	java/util/HashMap
    //   1067: aload 12
    //   1069: aload 18
    //   1071: aload 19
    //   1073: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1076: checkcast 77	java/util/HashMap
    //   1079: aload 12
    //   1081: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1084: checkcast 261	java/lang/Long
    //   1087: invokevirtual 700	java/lang/Long:longValue	()J
    //   1090: lload 7
    //   1092: ladd
    //   1093: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1096: invokevirtual 703	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1099: pop
    //   1100: iload_3
    //   1101: ifeq +19 -> 1120
    //   1104: aload 11
    //   1106: ifnull +14 -> 1120
    //   1109: aload 11
    //   1111: ldc_w 695
    //   1114: invokevirtual 680	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1117: ifne +18 -> 1135
    //   1120: iload_3
    //   1121: ifeq +78 -> 1199
    //   1124: aload 12
    //   1126: ldc_w 695
    //   1129: invokevirtual 680	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1132: ifeq +67 -> 1199
    //   1135: aload 18
    //   1137: aload 19
    //   1139: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1142: checkcast 77	java/util/HashMap
    //   1145: ldc_w 705
    //   1148: invokevirtual 684	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1151: ifeq +707 -> 1858
    //   1154: aload 18
    //   1156: aload 19
    //   1158: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1161: checkcast 77	java/util/HashMap
    //   1164: ldc_w 705
    //   1167: aload 18
    //   1169: aload 19
    //   1171: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1174: checkcast 77	java/util/HashMap
    //   1177: ldc_w 705
    //   1180: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1183: checkcast 261	java/lang/Long
    //   1186: invokevirtual 700	java/lang/Long:longValue	()J
    //   1189: lload 7
    //   1191: ladd
    //   1192: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1195: invokevirtual 703	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1198: pop
    //   1199: aload 13
    //   1201: invokeinterface 279 1 0
    //   1206: pop
    //   1207: goto -834 -> 373
    //   1210: astore 12
    //   1212: aload 13
    //   1214: astore 11
    //   1216: ldc 8
    //   1218: iconst_1
    //   1219: new 228	java/lang/StringBuilder
    //   1222: dup
    //   1223: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1226: ldc_w 730
    //   1229: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1232: aload 12
    //   1234: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1237: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1240: aload 12
    //   1242: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1245: aload 11
    //   1247: ifnull +10 -> 1257
    //   1250: aload 11
    //   1252: invokeinterface 184 1 0
    //   1257: aconst_null
    //   1258: areturn
    //   1259: iload 4
    //   1261: iconst_2
    //   1262: if_icmpeq +9 -> 1271
    //   1265: iload 4
    //   1267: iconst_3
    //   1268: if_icmpne +1003 -> 2271
    //   1271: iconst_2
    //   1272: istore 4
    //   1274: goto -772 -> 502
    //   1277: aload 14
    //   1279: ldc_w 709
    //   1282: invokevirtual 445	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1285: ifeq +11 -> 1296
    //   1288: ldc_w 441
    //   1291: astore 12
    //   1293: goto -432 -> 861
    //   1296: aload 11
    //   1298: astore 12
    //   1300: aload 14
    //   1302: ldc_w 711
    //   1305: invokevirtual 715	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1308: ifeq -447 -> 861
    //   1311: aload 14
    //   1313: ldc_w 711
    //   1316: invokevirtual 719	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1319: istore 5
    //   1321: new 228	java/lang/StringBuilder
    //   1324: dup
    //   1325: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1328: aload 14
    //   1330: iload 5
    //   1332: iconst_1
    //   1333: iadd
    //   1334: iload 5
    //   1336: iconst_2
    //   1337: iadd
    //   1338: invokevirtual 723	java/lang/String:substring	(II)Ljava/lang/String;
    //   1341: invokevirtual 726	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   1344: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1347: aload 14
    //   1349: iload 5
    //   1351: iconst_2
    //   1352: iadd
    //   1353: invokevirtual 728	java/lang/String:substring	(I)Ljava/lang/String;
    //   1356: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1359: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1362: astore 12
    //   1364: goto -503 -> 861
    //   1367: aload 17
    //   1369: new 228	java/lang/StringBuilder
    //   1372: dup
    //   1373: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1376: aload 12
    //   1378: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1381: iload 4
    //   1383: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1386: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1389: invokevirtual 681	java/util/Properties:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1392: checkcast 151	java/lang/String
    //   1395: astore 11
    //   1397: goto -496 -> 901
    //   1400: aload 18
    //   1402: aload 19
    //   1404: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1407: checkcast 77	java/util/HashMap
    //   1410: aload 12
    //   1412: lload 7
    //   1414: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1417: invokevirtual 703	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1420: pop
    //   1421: goto -321 -> 1100
    //   1424: aload 11
    //   1426: astore 14
    //   1428: iload_3
    //   1429: ifne +75 -> 1504
    //   1432: aload 11
    //   1434: astore 14
    //   1436: lload 7
    //   1438: ldc2_w 868
    //   1441: lcmp
    //   1442: ifle +62 -> 1504
    //   1445: aload 11
    //   1447: astore 14
    //   1449: aload 20
    //   1451: ifnull +53 -> 1504
    //   1454: aload 11
    //   1456: astore 14
    //   1458: aload 20
    //   1460: invokestatic 874	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1463: ifne +41 -> 1504
    //   1466: aload 11
    //   1468: astore 14
    //   1470: invokestatic 878	com/tencent/mobileqq/msf/core/a/a:g	()Z
    //   1473: ifeq +31 -> 1504
    //   1476: new 228	java/lang/StringBuilder
    //   1479: dup
    //   1480: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1483: aload 11
    //   1485: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1488: ldc_w 880
    //   1491: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1494: aload 20
    //   1496: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1499: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1502: astore 14
    //   1504: aload 18
    //   1506: aload 19
    //   1508: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1511: checkcast 77	java/util/HashMap
    //   1514: aload 14
    //   1516: invokevirtual 684	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1519: ifeq +53 -> 1572
    //   1522: aload 18
    //   1524: aload 19
    //   1526: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1529: checkcast 77	java/util/HashMap
    //   1532: aload 14
    //   1534: aload 18
    //   1536: aload 19
    //   1538: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1541: checkcast 77	java/util/HashMap
    //   1544: aload 14
    //   1546: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1549: checkcast 261	java/lang/Long
    //   1552: invokevirtual 700	java/lang/Long:longValue	()J
    //   1555: lload 7
    //   1557: ladd
    //   1558: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1561: invokevirtual 703	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1564: pop
    //   1565: aload 14
    //   1567: astore 11
    //   1569: goto -469 -> 1100
    //   1572: aload 18
    //   1574: aload 19
    //   1576: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1579: checkcast 77	java/util/HashMap
    //   1582: aload 14
    //   1584: lload 7
    //   1586: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1589: invokevirtual 703	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1592: pop
    //   1593: aload 14
    //   1595: astore 11
    //   1597: goto -497 -> 1100
    //   1600: aload 11
    //   1602: ifnonnull +161 -> 1763
    //   1605: new 228	java/lang/StringBuilder
    //   1608: dup
    //   1609: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1612: astore 21
    //   1614: iload 4
    //   1616: iconst_1
    //   1617: if_icmpne +671 -> 2288
    //   1620: ldc_w 695
    //   1623: astore 14
    //   1625: aload 21
    //   1627: aload 14
    //   1629: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1632: aload 12
    //   1634: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1637: ldc_w 697
    //   1640: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1643: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1646: astore 14
    //   1648: aload 14
    //   1650: astore 12
    //   1652: iload_3
    //   1653: ifne +75 -> 1728
    //   1656: aload 14
    //   1658: astore 12
    //   1660: lload 7
    //   1662: ldc2_w 868
    //   1665: lcmp
    //   1666: ifle +62 -> 1728
    //   1669: aload 14
    //   1671: astore 12
    //   1673: aload 20
    //   1675: ifnull +53 -> 1728
    //   1678: aload 14
    //   1680: astore 12
    //   1682: aload 20
    //   1684: invokestatic 874	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1687: ifne +41 -> 1728
    //   1690: aload 14
    //   1692: astore 12
    //   1694: invokestatic 878	com/tencent/mobileqq/msf/core/a/a:g	()Z
    //   1697: ifeq +31 -> 1728
    //   1700: new 228	java/lang/StringBuilder
    //   1703: dup
    //   1704: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1707: aload 14
    //   1709: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1712: ldc_w 880
    //   1715: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1718: aload 20
    //   1720: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1723: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1726: astore 12
    //   1728: new 77	java/util/HashMap
    //   1731: dup
    //   1732: invokespecial 78	java/util/HashMap:<init>	()V
    //   1735: astore 14
    //   1737: aload 14
    //   1739: aload 12
    //   1741: lload 7
    //   1743: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1746: invokevirtual 703	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1749: pop
    //   1750: aload 18
    //   1752: aload 19
    //   1754: aload 14
    //   1756: invokevirtual 703	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1759: pop
    //   1760: goto -660 -> 1100
    //   1763: iload_3
    //   1764: ifne +504 -> 2268
    //   1767: lload 7
    //   1769: ldc2_w 868
    //   1772: lcmp
    //   1773: ifle +495 -> 2268
    //   1776: aload 20
    //   1778: ifnull +490 -> 2268
    //   1781: aload 20
    //   1783: invokestatic 874	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1786: ifne +482 -> 2268
    //   1789: invokestatic 878	com/tencent/mobileqq/msf/core/a/a:g	()Z
    //   1792: ifeq +476 -> 2268
    //   1795: new 228	java/lang/StringBuilder
    //   1798: dup
    //   1799: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1802: aload 11
    //   1804: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1807: ldc_w 880
    //   1810: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1813: aload 20
    //   1815: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1818: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1821: astore 11
    //   1823: new 77	java/util/HashMap
    //   1826: dup
    //   1827: invokespecial 78	java/util/HashMap:<init>	()V
    //   1830: astore 14
    //   1832: aload 14
    //   1834: aload 11
    //   1836: lload 7
    //   1838: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1841: invokevirtual 703	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1844: pop
    //   1845: aload 18
    //   1847: aload 19
    //   1849: aload 14
    //   1851: invokevirtual 703	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1854: pop
    //   1855: goto -755 -> 1100
    //   1858: aload 18
    //   1860: aload 19
    //   1862: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1865: checkcast 77	java/util/HashMap
    //   1868: ldc_w 705
    //   1871: lload 7
    //   1873: invokestatic 264	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1876: invokevirtual 703	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1879: pop
    //   1880: goto -681 -> 1199
    //   1883: astore 11
    //   1885: aload 13
    //   1887: ifnull +10 -> 1897
    //   1890: aload 13
    //   1892: invokeinterface 184 1 0
    //   1897: aload 11
    //   1899: athrow
    //   1900: aload 15
    //   1902: ifnull +101 -> 2003
    //   1905: lload_1
    //   1906: lconst_0
    //   1907: lcmp
    //   1908: ifle +34 -> 1942
    //   1911: aload 15
    //   1913: new 228	java/lang/StringBuilder
    //   1916: dup
    //   1917: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1920: ldc_w 882
    //   1923: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1926: lload_1
    //   1927: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1930: ldc_w 291
    //   1933: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1936: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1939: invokevirtual 403	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   1942: aload 15
    //   1944: new 228	java/lang/StringBuilder
    //   1947: dup
    //   1948: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1951: ldc_w 884
    //   1954: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1957: invokestatic 889	android/os/Process:myUid	()I
    //   1960: invokestatic 894	android/net/TrafficStats:getUidRxBytes	(I)J
    //   1963: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1966: ldc_w 896
    //   1969: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1972: invokestatic 889	android/os/Process:myUid	()I
    //   1975: invokestatic 899	android/net/TrafficStats:getUidTxBytes	(I)J
    //   1978: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1981: ldc_w 291
    //   1984: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1987: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1990: invokevirtual 403	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   1993: aload 15
    //   1995: invokevirtual 426	java/io/PrintWriter:flush	()V
    //   1998: aload 15
    //   2000: invokevirtual 900	java/io/PrintWriter:close	()V
    //   2003: aload 18
    //   2005: invokevirtual 535	java/util/HashMap:keySet	()Ljava/util/Set;
    //   2008: invokeinterface 541 1 0
    //   2013: astore 11
    //   2015: aload 11
    //   2017: invokeinterface 546 1 0
    //   2022: ifeq +197 -> 2219
    //   2025: aload 11
    //   2027: invokeinterface 550 1 0
    //   2032: checkcast 151	java/lang/String
    //   2035: astore 12
    //   2037: aload 18
    //   2039: aload 12
    //   2041: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2044: checkcast 77	java/util/HashMap
    //   2047: invokevirtual 535	java/util/HashMap:keySet	()Ljava/util/Set;
    //   2050: invokeinterface 541 1 0
    //   2055: astore 14
    //   2057: aload 14
    //   2059: invokeinterface 546 1 0
    //   2064: ifeq -49 -> 2015
    //   2067: aload 14
    //   2069: invokeinterface 550 1 0
    //   2074: checkcast 151	java/lang/String
    //   2077: astore 15
    //   2079: iload_3
    //   2080: ifeq +71 -> 2151
    //   2083: ldc 8
    //   2085: iconst_1
    //   2086: new 228	java/lang/StringBuilder
    //   2089: dup
    //   2090: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   2093: ldc_w 902
    //   2096: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2099: aload 12
    //   2101: invokestatic 245	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   2104: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2107: ldc_w 735
    //   2110: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2113: aload 15
    //   2115: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2118: ldc_w 737
    //   2121: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2124: aload 18
    //   2126: aload 12
    //   2128: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2131: checkcast 77	java/util/HashMap
    //   2134: aload 15
    //   2136: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2139: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2142: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2145: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2148: goto -91 -> 2057
    //   2151: ldc 8
    //   2153: iconst_1
    //   2154: new 228	java/lang/StringBuilder
    //   2157: dup
    //   2158: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   2161: ldc_w 904
    //   2164: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2167: aload 12
    //   2169: invokestatic 245	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   2172: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2175: ldc_w 735
    //   2178: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2181: aload 15
    //   2183: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2186: ldc_w 737
    //   2189: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2192: aload 18
    //   2194: aload 12
    //   2196: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2199: checkcast 77	java/util/HashMap
    //   2202: aload 15
    //   2204: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2207: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2210: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2213: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2216: goto -159 -> 2057
    //   2219: aload 16
    //   2221: invokevirtual 742	java/io/InputStream:close	()V
    //   2224: aload 13
    //   2226: ifnull +10 -> 2236
    //   2229: aload 13
    //   2231: invokeinterface 184 1 0
    //   2236: aload 18
    //   2238: areturn
    //   2239: astore 11
    //   2241: aconst_null
    //   2242: astore 13
    //   2244: goto -359 -> 1885
    //   2247: astore 12
    //   2249: aload 11
    //   2251: astore 13
    //   2253: aload 12
    //   2255: astore 11
    //   2257: goto -372 -> 1885
    //   2260: astore 12
    //   2262: aconst_null
    //   2263: astore 11
    //   2265: goto -1049 -> 1216
    //   2268: goto -445 -> 1823
    //   2271: goto -1769 -> 502
    //   2274: aconst_null
    //   2275: astore 15
    //   2277: goto -1914 -> 363
    //   2280: ldc_w 744
    //   2283: astore 14
    //   2285: goto -1349 -> 936
    //   2288: ldc_w 744
    //   2291: astore 14
    //   2293: goto -668 -> 1625
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2296	0	this	e
    //   0	2296	1	paramLong	long
    //   0	2296	3	paramBoolean	boolean
    //   441	1177	4	i1	int
    //   452	901	5	i2	int
    //   463	200	6	i3	int
    //   94	1778	7	l1	long
    //   485	203	9	l2	long
    //   33	1802	11	localObject1	Object
    //   1883	15	11	localObject2	Object
    //   2013	13	11	localIterator	Iterator
    //   2239	11	11	localObject3	Object
    //   2255	9	11	localObject4	Object
    //   474	651	12	localObject5	Object
    //   1210	31	12	localException1	Exception
    //   1291	904	12	localObject6	Object
    //   2247	7	12	localObject7	Object
    //   2260	1	12	localException2	Exception
    //   208	2044	13	localObject8	Object
    //   391	1901	14	localObject9	Object
    //   361	1915	15	localObject10	Object
    //   12	2208	16	localInputStream	java.io.InputStream
    //   21	1347	17	localProperties	java.util.Properties
    //   349	1888	18	localHashMap	HashMap
    //   401	1460	19	str1	String
    //   411	1403	20	str2	String
    //   923	703	21	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   342	351	1210	java/lang/Exception
    //   355	363	1210	java/lang/Exception
    //   363	371	1210	java/lang/Exception
    //   373	487	1210	java/lang/Exception
    //   516	786	1210	java/lang/Exception
    //   790	801	1210	java/lang/Exception
    //   805	816	1210	java/lang/Exception
    //   820	831	1210	java/lang/Exception
    //   835	857	1210	java/lang/Exception
    //   861	901	1210	java/lang/Exception
    //   901	911	1210	java/lang/Exception
    //   916	925	1210	java/lang/Exception
    //   936	959	1210	java/lang/Exception
    //   993	1001	1210	java/lang/Exception
    //   1005	1039	1210	java/lang/Exception
    //   1039	1100	1210	java/lang/Exception
    //   1109	1120	1210	java/lang/Exception
    //   1124	1135	1210	java/lang/Exception
    //   1135	1199	1210	java/lang/Exception
    //   1199	1207	1210	java/lang/Exception
    //   1277	1288	1210	java/lang/Exception
    //   1300	1364	1210	java/lang/Exception
    //   1367	1397	1210	java/lang/Exception
    //   1400	1421	1210	java/lang/Exception
    //   1458	1466	1210	java/lang/Exception
    //   1470	1504	1210	java/lang/Exception
    //   1504	1565	1210	java/lang/Exception
    //   1572	1593	1210	java/lang/Exception
    //   1605	1614	1210	java/lang/Exception
    //   1625	1648	1210	java/lang/Exception
    //   1682	1690	1210	java/lang/Exception
    //   1694	1728	1210	java/lang/Exception
    //   1728	1760	1210	java/lang/Exception
    //   1781	1823	1210	java/lang/Exception
    //   1823	1855	1210	java/lang/Exception
    //   1858	1880	1210	java/lang/Exception
    //   1911	1942	1210	java/lang/Exception
    //   1942	2003	1210	java/lang/Exception
    //   2003	2015	1210	java/lang/Exception
    //   2015	2057	1210	java/lang/Exception
    //   2057	2079	1210	java/lang/Exception
    //   2083	2148	1210	java/lang/Exception
    //   2151	2216	1210	java/lang/Exception
    //   2219	2224	1210	java/lang/Exception
    //   342	351	1883	finally
    //   355	363	1883	finally
    //   363	371	1883	finally
    //   373	487	1883	finally
    //   516	786	1883	finally
    //   790	801	1883	finally
    //   805	816	1883	finally
    //   820	831	1883	finally
    //   835	857	1883	finally
    //   861	901	1883	finally
    //   901	911	1883	finally
    //   916	925	1883	finally
    //   936	959	1883	finally
    //   993	1001	1883	finally
    //   1005	1039	1883	finally
    //   1039	1100	1883	finally
    //   1109	1120	1883	finally
    //   1124	1135	1883	finally
    //   1135	1199	1883	finally
    //   1199	1207	1883	finally
    //   1277	1288	1883	finally
    //   1300	1364	1883	finally
    //   1367	1397	1883	finally
    //   1400	1421	1883	finally
    //   1458	1466	1883	finally
    //   1470	1504	1883	finally
    //   1504	1565	1883	finally
    //   1572	1593	1883	finally
    //   1605	1614	1883	finally
    //   1625	1648	1883	finally
    //   1682	1690	1883	finally
    //   1694	1728	1883	finally
    //   1728	1760	1883	finally
    //   1781	1823	1883	finally
    //   1823	1855	1883	finally
    //   1858	1880	1883	finally
    //   1911	1942	1883	finally
    //   1942	2003	1883	finally
    //   2003	2015	1883	finally
    //   2015	2057	1883	finally
    //   2057	2079	1883	finally
    //   2083	2148	1883	finally
    //   2151	2216	1883	finally
    //   2219	2224	1883	finally
    //   0	89	2239	finally
    //   96	111	2239	finally
    //   115	210	2239	finally
    //   229	339	2239	finally
    //   1216	1245	2247	finally
    //   0	89	2260	java/lang/Exception
    //   96	111	2260	java/lang/Exception
    //   115	210	2260	java/lang/Exception
    //   229	339	2260	java/lang/Exception
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.e
 * JD-Core Version:    0.7.0.1
 */