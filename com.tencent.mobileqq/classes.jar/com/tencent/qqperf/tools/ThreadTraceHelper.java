package com.tencent.qqperf.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.MobileQQ;

public class ThreadTraceHelper
{
  private static String a;
  private static ThreadTraceHelper.TraceFileObserver b = new ThreadTraceHelper.TraceFileObserver("/data/anr/traces.txt", 8);
  private static long c = -1L;
  private static String d = null;
  private static HashMap<Long, String> e = new HashMap(30);
  private static Object f = new Object();
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      d();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(a);
      ((StringBuilder)localObject1).append("msftrace/");
      localObject1 = new File(((StringBuilder)localObject1).toString());
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdirs();
      }
      paramContext = paramContext.getSharedPreferences("unified_monitor", 0);
      int j = paramContext.getInt("key_crash_count", 0);
      int i = j;
      if (paramContext.contains("key_dumping"))
      {
        paramContext.edit().remove("key_dumping");
        localObject1 = paramContext.edit();
        i = j + 1;
        ((SharedPreferences.Editor)localObject1).putInt("key_crash_count", i);
        paramContext.edit().commit();
      }
      j = 1;
      if (i >= 3)
      {
        QLog.e("UnifiedMonitor.Trace", 1, "dumpTraces crash protect");
        return 2;
      }
      localObject1 = new File("/data/anr/traces.txt");
      long l1 = ((File)localObject1).length();
      boolean bool;
      if ((((File)localObject1).exists()) && (((File)localObject1).canRead()) && (l1 != 0L))
      {
        paramContext.edit().putBoolean("key_dumping", true).commit();
        b.startWatching();
        long l2 = SystemClock.uptimeMillis();
        QLog.e("UnifiedMonitor.Trace", 1, "dumpTraces send signal");
        Process.sendSignal(Process.myPid(), 3);
        try
        {
          synchronized (b)
          {
            b.wait(20000L);
          }
          long l3;
          bool = ((File)localObject1).exists();
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          b.stopWatching();
          paramContext.edit().remove("key_dumping").putInt("key_crash_count", 0).commit();
          paramContext = new StringBuilder();
          paramContext.append("dumpTraces wait traces for ");
          paramContext.append(SystemClock.uptimeMillis() - l2);
          paramContext.append("ms");
          QLog.d("UnifiedMonitor.Trace", 1, paramContext.toString());
          l2 = ((File)localObject1).length();
          if (l2 > l1)
          {
            l3 = l2 - l1;
            if (l3 <= 409600L)
            {
              bool = a((File)localObject1, l1, l3, new File(paramString1), paramString2);
              paramContext = new StringBuilder();
              paramContext.append("dumpTraces result = ");
              paramContext.append(bool);
              QLog.e("UnifiedMonitor.Trace", 1, paramContext.toString());
              if (bool) {
                i = j;
              } else {
                i = 6;
              }
              return i;
            }
          }
          paramContext = new StringBuilder();
          paramContext.append("dumpTraces bad size ");
          paramContext.append(l1);
          paramContext.append(", ");
          paramContext.append(l2);
          QLog.e("UnifiedMonitor.Trace", 1, paramContext.toString());
          if (l2 <= l1) {
            i = 4;
          } else {
            i = 5;
          }
          return i;
        }
      }
      paramContext = new StringBuilder();
      paramContext.append(", len = ");
      paramContext.append(l1);
      QLog.e("UnifiedMonitor.Trace", 1, new Object[] { "dumpTraces no permission read file, exist = ", Boolean.valueOf(bool), paramContext.toString() });
      return 3;
    }
    finally {}
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("|transTid=");
    localStringBuilder.append(c);
    localStringBuilder.append("|transTname=");
    localStringBuilder.append(d);
    localStringBuilder.append("|transWaiting=");
    synchronized (f)
    {
      Iterator localIterator = e.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append(localEntry.getKey());
        localStringBuilder.append(",");
        localStringBuilder.append((String)localEntry.getValue());
        localStringBuilder.append(";");
      }
      return localStringBuilder.toString();
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public static String a(String paramString)
  {
    d();
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(a);
    if (4 == MobileQQ.sProcessId) {
      localStringBuilder.append("msftrace/");
    }
    localStringBuilder.append("traces_");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".txt");
    return localStringBuilder.toString();
  }
  
  public static void a(long paramLong)
  {
    synchronized (f)
    {
      e.remove(Long.valueOf(paramLong));
      return;
    }
  }
  
  public static void a(long paramLong, String paramString)
  {
    c = paramLong;
    d = paramString;
  }
  
  public static void a(Context paramContext)
  {
    d();
    Object localObject1 = new File(a);
    int i;
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        int k = localObject1.length;
        i = 0;
        while (i < k)
        {
          Object localObject2 = localObject1[i];
          int j;
          if ((localObject2.isFile()) && (!TextUtils.isEmpty(localObject2.getName())) && (localObject2.getName().startsWith("traces_"))) {
            j = 1;
          } else {
            j = 0;
          }
          if ((j != 0) && (Math.abs(localObject2.lastModified() - System.currentTimeMillis()) > 86400000L)) {
            localObject2.delete();
          }
          i += 1;
        }
      }
    }
    paramContext = paramContext.getSharedPreferences("unified_monitor", 0);
    if (paramContext.contains("key_dumping"))
    {
      i = paramContext.getInt("key_crash_count", 0);
      paramContext.edit().remove("key_dumping");
      paramContext.edit().putInt("key_crash_count", i + 1);
      paramContext.edit().commit();
      QLog.d("UnifiedMonitor.Trace", 1, "cleanTraceFile, check crash true");
    }
  }
  
  /* Error */
  private static boolean a(File paramFile1, long paramLong1, long paramLong2, File paramFile2, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 283	java/io/File:isFile	()Z
    //   4: ifeq +256 -> 260
    //   7: aconst_null
    //   8: astore 9
    //   10: aload 5
    //   12: invokevirtual 75	java/io/File:exists	()Z
    //   15: ifeq +9 -> 24
    //   18: aload 5
    //   20: invokevirtual 309	java/io/File:delete	()Z
    //   23: pop
    //   24: new 317	java/io/FileOutputStream
    //   27: dup
    //   28: aload 5
    //   30: invokespecial 320	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   33: astore 8
    //   35: new 322	java/io/FileInputStream
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 323	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   43: astore_0
    //   44: aload_0
    //   45: invokevirtual 326	java/io/FileInputStream:available	()I
    //   48: i2l
    //   49: lload_1
    //   50: lcmp
    //   51: ifle +9 -> 60
    //   54: aload_0
    //   55: lload_1
    //   56: invokevirtual 329	java/io/FileInputStream:skip	(J)J
    //   59: pop2
    //   60: sipush 4096
    //   63: newarray byte
    //   65: astore 9
    //   67: aload_0
    //   68: aload 9
    //   70: invokevirtual 333	java/io/FileInputStream:read	([B)I
    //   73: istore 7
    //   75: iload 7
    //   77: iconst_m1
    //   78: if_icmpeq +16 -> 94
    //   81: aload 8
    //   83: aload 9
    //   85: iconst_0
    //   86: iload 7
    //   88: invokevirtual 337	java/io/FileOutputStream:write	([BII)V
    //   91: goto -24 -> 67
    //   94: aload 6
    //   96: ifnull +24 -> 120
    //   99: aload 8
    //   101: ldc_w 339
    //   104: invokevirtual 343	java/lang/String:getBytes	()[B
    //   107: invokevirtual 346	java/io/FileOutputStream:write	([B)V
    //   110: aload 8
    //   112: aload 6
    //   114: invokevirtual 343	java/lang/String:getBytes	()[B
    //   117: invokevirtual 346	java/io/FileOutputStream:write	([B)V
    //   120: aload 8
    //   122: invokevirtual 349	java/io/FileOutputStream:flush	()V
    //   125: aload 8
    //   127: invokevirtual 352	java/io/FileOutputStream:close	()V
    //   130: aload_0
    //   131: invokevirtual 353	java/io/FileInputStream:close	()V
    //   134: goto +126 -> 260
    //   137: astore 5
    //   139: aload 8
    //   141: astore 6
    //   143: goto +93 -> 236
    //   146: astore 6
    //   148: goto +18 -> 166
    //   151: astore 5
    //   153: aconst_null
    //   154: astore_0
    //   155: aload 8
    //   157: astore 6
    //   159: goto +77 -> 236
    //   162: astore 6
    //   164: aconst_null
    //   165: astore_0
    //   166: aload 6
    //   168: astore 9
    //   170: aload 8
    //   172: astore 6
    //   174: goto +26 -> 200
    //   177: astore 5
    //   179: aconst_null
    //   180: astore 6
    //   182: aload 6
    //   184: astore_0
    //   185: goto +51 -> 236
    //   188: astore 8
    //   190: aconst_null
    //   191: astore_0
    //   192: aload 9
    //   194: astore 6
    //   196: aload 8
    //   198: astore 9
    //   200: aload 9
    //   202: invokevirtual 354	java/io/IOException:printStackTrace	()V
    //   205: aload 5
    //   207: invokevirtual 309	java/io/File:delete	()Z
    //   210: pop
    //   211: aload 6
    //   213: ifnull +11 -> 224
    //   216: aload 6
    //   218: invokevirtual 352	java/io/FileOutputStream:close	()V
    //   221: goto +3 -> 224
    //   224: aload_0
    //   225: ifnull +7 -> 232
    //   228: aload_0
    //   229: invokevirtual 353	java/io/FileInputStream:close	()V
    //   232: iconst_0
    //   233: ireturn
    //   234: astore 5
    //   236: aload 6
    //   238: ifnull +11 -> 249
    //   241: aload 6
    //   243: invokevirtual 352	java/io/FileOutputStream:close	()V
    //   246: goto +3 -> 249
    //   249: aload_0
    //   250: ifnull +7 -> 257
    //   253: aload_0
    //   254: invokevirtual 353	java/io/FileInputStream:close	()V
    //   257: aload 5
    //   259: athrow
    //   260: iconst_1
    //   261: ireturn
    //   262: astore 5
    //   264: goto -134 -> 130
    //   267: astore_0
    //   268: goto -8 -> 260
    //   271: astore 5
    //   273: goto -62 -> 211
    //   276: astore 5
    //   278: goto -54 -> 224
    //   281: astore_0
    //   282: iconst_0
    //   283: ireturn
    //   284: astore 6
    //   286: goto -37 -> 249
    //   289: astore_0
    //   290: goto -33 -> 257
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramFile1	File
    //   0	293	1	paramLong1	long
    //   0	293	3	paramLong2	long
    //   0	293	5	paramFile2	File
    //   0	293	6	paramString	String
    //   73	14	7	i	int
    //   33	138	8	localFileOutputStream	java.io.FileOutputStream
    //   188	9	8	localIOException	java.io.IOException
    //   8	193	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   44	60	137	finally
    //   60	67	137	finally
    //   67	75	137	finally
    //   81	91	137	finally
    //   99	120	137	finally
    //   120	125	137	finally
    //   44	60	146	java/io/IOException
    //   60	67	146	java/io/IOException
    //   67	75	146	java/io/IOException
    //   81	91	146	java/io/IOException
    //   99	120	146	java/io/IOException
    //   120	125	146	java/io/IOException
    //   35	44	151	finally
    //   35	44	162	java/io/IOException
    //   10	24	177	finally
    //   24	35	177	finally
    //   10	24	188	java/io/IOException
    //   24	35	188	java/io/IOException
    //   200	205	234	finally
    //   205	211	234	finally
    //   125	130	262	java/io/IOException
    //   130	134	267	java/io/IOException
    //   205	211	271	java/lang/Exception
    //   216	221	276	java/io/IOException
    //   228	232	281	java/io/IOException
    //   241	246	284	java/io/IOException
    //   253	257	289	java/io/IOException
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 64	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 7
    //   10: aconst_null
    //   11: astore 6
    //   13: aconst_null
    //   14: astore 5
    //   16: aload 5
    //   18: astore_0
    //   19: aload 7
    //   21: invokevirtual 75	java/io/File:exists	()Z
    //   24: ifeq +12 -> 36
    //   27: aload 5
    //   29: astore_0
    //   30: aload 7
    //   32: invokevirtual 309	java/io/File:delete	()Z
    //   35: pop
    //   36: aload 5
    //   38: astore_0
    //   39: new 317	java/io/FileOutputStream
    //   42: dup
    //   43: aload 7
    //   45: invokespecial 320	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   48: astore 5
    //   50: invokestatic 360	java/lang/Thread:activeCount	()I
    //   53: anewarray 357	java/lang/Thread
    //   56: astore_0
    //   57: aload_0
    //   58: invokestatic 364	java/lang/Thread:enumerate	([Ljava/lang/Thread;)I
    //   61: pop
    //   62: iconst_0
    //   63: istore_2
    //   64: aload_0
    //   65: arraylength
    //   66: istore_3
    //   67: iload_2
    //   68: iload_3
    //   69: if_icmpge +229 -> 298
    //   72: aload_0
    //   73: iload_2
    //   74: aaload
    //   75: astore 6
    //   77: aload 6
    //   79: ifnull +351 -> 430
    //   82: aload 5
    //   84: ldc_w 366
    //   87: invokevirtual 343	java/lang/String:getBytes	()[B
    //   90: invokevirtual 346	java/io/FileOutputStream:write	([B)V
    //   93: aload 5
    //   95: aload 6
    //   97: invokevirtual 367	java/lang/Thread:getName	()Ljava/lang/String;
    //   100: invokevirtual 343	java/lang/String:getBytes	()[B
    //   103: invokevirtual 346	java/io/FileOutputStream:write	([B)V
    //   106: aload 5
    //   108: ldc_w 339
    //   111: invokevirtual 343	java/lang/String:getBytes	()[B
    //   114: invokevirtual 346	java/io/FileOutputStream:write	([B)V
    //   117: new 53	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   124: astore 8
    //   126: aload 8
    //   128: ldc_w 369
    //   131: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload 8
    //   137: aload 6
    //   139: invokevirtual 373	java/lang/Thread:getState	()Ljava/lang/Thread$State;
    //   142: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 5
    //   148: aload 8
    //   150: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokevirtual 343	java/lang/String:getBytes	()[B
    //   156: invokevirtual 346	java/io/FileOutputStream:write	([B)V
    //   159: aload 5
    //   161: ldc_w 339
    //   164: invokevirtual 343	java/lang/String:getBytes	()[B
    //   167: invokevirtual 346	java/io/FileOutputStream:write	([B)V
    //   170: new 53	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   177: astore 8
    //   179: aload 8
    //   181: ldc_w 375
    //   184: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 8
    //   190: aload 6
    //   192: invokevirtual 378	java/lang/Thread:getId	()J
    //   195: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload 5
    //   201: aload 8
    //   203: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokevirtual 343	java/lang/String:getBytes	()[B
    //   209: invokevirtual 346	java/io/FileOutputStream:write	([B)V
    //   212: aload 5
    //   214: ldc_w 339
    //   217: invokevirtual 343	java/lang/String:getBytes	()[B
    //   220: invokevirtual 346	java/io/FileOutputStream:write	([B)V
    //   223: aload 6
    //   225: invokevirtual 381	java/lang/Thread:isAlive	()Z
    //   228: ifeq +202 -> 430
    //   231: aload 6
    //   233: invokevirtual 385	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   236: astore 6
    //   238: aload 6
    //   240: arraylength
    //   241: istore 4
    //   243: iconst_0
    //   244: istore_3
    //   245: iload_3
    //   246: iload 4
    //   248: if_icmpge +36 -> 284
    //   251: aload 5
    //   253: aload 6
    //   255: iload_3
    //   256: aaload
    //   257: invokevirtual 388	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   260: invokevirtual 343	java/lang/String:getBytes	()[B
    //   263: invokevirtual 346	java/io/FileOutputStream:write	([B)V
    //   266: aload 5
    //   268: ldc_w 339
    //   271: invokevirtual 343	java/lang/String:getBytes	()[B
    //   274: invokevirtual 346	java/io/FileOutputStream:write	([B)V
    //   277: iload_3
    //   278: iconst_1
    //   279: iadd
    //   280: istore_3
    //   281: goto -36 -> 245
    //   284: aload 5
    //   286: ldc_w 339
    //   289: invokevirtual 343	java/lang/String:getBytes	()[B
    //   292: invokevirtual 346	java/io/FileOutputStream:write	([B)V
    //   295: goto +135 -> 430
    //   298: aload 5
    //   300: ldc_w 339
    //   303: invokevirtual 343	java/lang/String:getBytes	()[B
    //   306: invokevirtual 346	java/io/FileOutputStream:write	([B)V
    //   309: aload 5
    //   311: aload_1
    //   312: invokevirtual 343	java/lang/String:getBytes	()[B
    //   315: invokevirtual 346	java/io/FileOutputStream:write	([B)V
    //   318: aload 5
    //   320: invokevirtual 349	java/io/FileOutputStream:flush	()V
    //   323: aload 5
    //   325: invokevirtual 352	java/io/FileOutputStream:close	()V
    //   328: iconst_1
    //   329: ireturn
    //   330: astore_0
    //   331: goto +66 -> 397
    //   334: astore_0
    //   335: aload 5
    //   337: astore_1
    //   338: aload_0
    //   339: astore 5
    //   341: goto +17 -> 358
    //   344: astore_1
    //   345: aload_0
    //   346: astore 5
    //   348: aload_1
    //   349: astore_0
    //   350: goto +47 -> 397
    //   353: astore 5
    //   355: aload 6
    //   357: astore_1
    //   358: aload_1
    //   359: astore_0
    //   360: invokestatic 391	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq +16 -> 379
    //   366: aload_1
    //   367: astore_0
    //   368: ldc 119
    //   370: iconst_2
    //   371: ldc_w 393
    //   374: aload 5
    //   376: invokestatic 396	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   379: aload_1
    //   380: astore_0
    //   381: aload 7
    //   383: invokevirtual 309	java/io/File:delete	()Z
    //   386: pop
    //   387: aload_1
    //   388: ifnull +7 -> 395
    //   391: aload_1
    //   392: invokevirtual 352	java/io/FileOutputStream:close	()V
    //   395: iconst_0
    //   396: ireturn
    //   397: aload 5
    //   399: ifnull +8 -> 407
    //   402: aload 5
    //   404: invokevirtual 352	java/io/FileOutputStream:close	()V
    //   407: goto +5 -> 412
    //   410: aload_0
    //   411: athrow
    //   412: goto -2 -> 410
    //   415: astore_0
    //   416: goto -88 -> 328
    //   419: astore_0
    //   420: goto -33 -> 387
    //   423: astore_0
    //   424: iconst_0
    //   425: ireturn
    //   426: astore_1
    //   427: goto -20 -> 407
    //   430: iload_2
    //   431: iconst_1
    //   432: iadd
    //   433: istore_2
    //   434: goto -370 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	437	0	paramString1	String
    //   0	437	1	paramString2	String
    //   63	371	2	i	int
    //   66	215	3	j	int
    //   241	8	4	k	int
    //   14	333	5	localObject	Object
    //   353	50	5	localException	Exception
    //   11	345	6	arrayOfStackTraceElement	java.lang.StackTraceElement[]
    //   8	374	7	localFile	File
    //   124	78	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   50	62	330	finally
    //   64	67	330	finally
    //   82	243	330	finally
    //   251	277	330	finally
    //   284	295	330	finally
    //   298	323	330	finally
    //   50	62	334	java/lang/Exception
    //   64	67	334	java/lang/Exception
    //   82	243	334	java/lang/Exception
    //   251	277	334	java/lang/Exception
    //   284	295	334	java/lang/Exception
    //   298	323	334	java/lang/Exception
    //   19	27	344	finally
    //   30	36	344	finally
    //   39	50	344	finally
    //   360	366	344	finally
    //   368	379	344	finally
    //   381	387	344	finally
    //   19	27	353	java/lang/Exception
    //   30	36	353	java/lang/Exception
    //   39	50	353	java/lang/Exception
    //   323	328	415	java/io/IOException
    //   381	387	419	java/lang/Exception
    //   391	395	423	java/io/IOException
    //   402	407	426	java/io/IOException
  }
  
  public static String b()
  {
    if (1 == MobileQQ.sProcessId) {
      return "|process=QQ";
    }
    if (4 == MobileQQ.sProcessId) {
      return "|process=MSF";
    }
    if (2 == MobileQQ.sProcessId) {
      return "|process=qzone";
    }
    return "|process=other";
  }
  
  public static ArrayList<String> b(Context paramContext)
  {
    d();
    ArrayList localArrayList = new ArrayList(10);
    paramContext = paramContext.getSharedPreferences("unified_monitor", 0);
    long l2 = paramContext.getLong("last_report_trace_file", 0L);
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(a);
    ((StringBuilder)localObject1).append("msftrace/");
    localObject1 = new File(((StringBuilder)localObject1).toString());
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        int n = localObject1.length;
        int j = 0;
        for (int i = 0;; i = k)
        {
          k = i;
          if (j >= n) {
            break;
          }
          Object localObject2 = localObject1[j];
          Object localObject3 = localObject2.getName();
          int m;
          if ((localObject2.isFile()) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).startsWith("traces_"))) {
            m = 1;
          } else {
            m = 0;
          }
          k = i;
          if (m != 0)
          {
            try
            {
              localObject3 = ((String)localObject3).split("_");
              if ((localObject3 != null) && (localObject3.length > 2)) {
                l2 = Long.valueOf(localObject3[1]).longValue();
              }
            }
            catch (Exception localException)
            {
              if (QLog.isColorLevel()) {
                QLog.e("UnifiedMonitor.Trace", 2, "parse trace file time exception : ", localException);
              }
              l2 = 0L;
            }
            if ((l2 > 0L) && (l2 > l1))
            {
              localArrayList.add(localObject2.getAbsolutePath());
              k = i + 1;
            }
            else
            {
              k = i;
              if (Math.abs(l2 - System.currentTimeMillis()) > 172800000L)
              {
                localObject2.delete();
                k = i;
              }
            }
          }
          j += 1;
        }
      }
    }
    int k = 0;
    if (k > 0)
    {
      paramContext.edit().putLong("last_report_trace_file", System.currentTimeMillis()).commit();
      QLog.e("UnifiedMonitor.Trace", 1, new Object[] { "report msf trace stack time = ", Long.valueOf(System.currentTimeMillis()), ",report file count=", Integer.valueOf(k) });
    }
    return localArrayList;
  }
  
  public static void b(long paramLong, String paramString)
  {
    synchronized (f)
    {
      e.put(Long.valueOf(paramLong), paramString);
      return;
    }
  }
  
  private static void d()
  {
    if (TextUtils.isEmpty(a)) {}
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
      localStringBuilder.append("/tencent/msflogs/");
      localStringBuilder.append("com.tencent.mobileqq".replace(".", "/"));
      localStringBuilder.append("/");
      a = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder;
      label72:
      break label72;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("/sdcard/tencent/msflogs/");
    localStringBuilder.append("com.tencent.mobileqq".replace(".", "/"));
    localStringBuilder.append("/");
    a = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.tools.ThreadTraceHelper
 * JD-Core Version:    0.7.0.1
 */