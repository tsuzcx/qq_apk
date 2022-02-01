package com.tencent.qqperf.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
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
  private static long jdField_a_of_type_Long;
  private static ThreadTraceHelper.TraceFileObserver jdField_a_of_type_ComTencentQqperfToolsThreadTraceHelper$TraceFileObserver;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static String jdField_a_of_type_JavaLangString = null;
  private static HashMap<Long, String> jdField_a_of_type_JavaUtilHashMap;
  private static String b;
  
  static
  {
    jdField_a_of_type_ComTencentQqperfToolsThreadTraceHelper$TraceFileObserver = new ThreadTraceHelper.TraceFileObserver("/data/anr/traces.txt", 8);
    jdField_a_of_type_Long = -1L;
    b = null;
    jdField_a_of_type_JavaUtilHashMap = new HashMap(30);
  }
  
  /* Error */
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: invokestatic 49	com/tencent/qqperf/tools/ThreadTraceHelper:a	()V
    //   9: new 51	java/io/File
    //   12: dup
    //   13: new 53	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   20: getstatic 16	com/tencent/qqperf/tools/ThreadTraceHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   23: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 60
    //   28: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore 11
    //   39: aload 11
    //   41: invokevirtual 71	java/io/File:exists	()Z
    //   44: ifne +9 -> 53
    //   47: aload 11
    //   49: invokevirtual 74	java/io/File:mkdirs	()Z
    //   52: pop
    //   53: aload_0
    //   54: ldc 76
    //   56: iconst_0
    //   57: invokevirtual 82	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   60: astore_0
    //   61: aload_0
    //   62: ldc 84
    //   64: iconst_0
    //   65: invokeinterface 90 3 0
    //   70: istore 5
    //   72: iload 5
    //   74: istore_3
    //   75: aload_0
    //   76: ldc 92
    //   78: invokeinterface 96 2 0
    //   83: ifeq +53 -> 136
    //   86: aload_0
    //   87: invokeinterface 100 1 0
    //   92: ldc 92
    //   94: invokeinterface 106 2 0
    //   99: pop
    //   100: aload_0
    //   101: invokeinterface 100 1 0
    //   106: astore 11
    //   108: iload 5
    //   110: iconst_1
    //   111: iadd
    //   112: istore_3
    //   113: aload 11
    //   115: ldc 84
    //   117: iload_3
    //   118: invokeinterface 110 3 0
    //   123: pop
    //   124: aload_0
    //   125: invokeinterface 100 1 0
    //   130: invokeinterface 113 1 0
    //   135: pop
    //   136: iload_3
    //   137: iconst_3
    //   138: if_icmplt +18 -> 156
    //   141: ldc 115
    //   143: iconst_1
    //   144: ldc 117
    //   146: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: iconst_2
    //   150: istore_3
    //   151: ldc 2
    //   153: monitorexit
    //   154: iload_3
    //   155: ireturn
    //   156: new 51	java/io/File
    //   159: dup
    //   160: ldc 20
    //   162: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   165: astore 11
    //   167: aload 11
    //   169: invokevirtual 127	java/io/File:length	()J
    //   172: lstore 6
    //   174: aload 11
    //   176: invokevirtual 71	java/io/File:exists	()Z
    //   179: ifeq +18 -> 197
    //   182: aload 11
    //   184: invokevirtual 130	java/io/File:canRead	()Z
    //   187: ifeq +10 -> 197
    //   190: lload 6
    //   192: lconst_0
    //   193: lcmp
    //   194: ifne +57 -> 251
    //   197: ldc 115
    //   199: iconst_1
    //   200: iconst_3
    //   201: anewarray 4	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: ldc 132
    //   208: aastore
    //   209: dup
    //   210: iconst_1
    //   211: aload 11
    //   213: invokevirtual 71	java/io/File:exists	()Z
    //   216: invokestatic 138	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   219: aastore
    //   220: dup
    //   221: iconst_2
    //   222: new 53	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   229: ldc 140
    //   231: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: lload 6
    //   236: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   239: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: aastore
    //   243: invokestatic 146	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   246: iconst_3
    //   247: istore_3
    //   248: goto -97 -> 151
    //   251: aload_0
    //   252: invokeinterface 100 1 0
    //   257: ldc 92
    //   259: iconst_1
    //   260: invokeinterface 150 3 0
    //   265: invokeinterface 113 1 0
    //   270: pop
    //   271: getstatic 26	com/tencent/qqperf/tools/ThreadTraceHelper:jdField_a_of_type_ComTencentQqperfToolsThreadTraceHelper$TraceFileObserver	Lcom/tencent/qqperf/tools/ThreadTraceHelper$TraceFileObserver;
    //   274: invokevirtual 153	com/tencent/qqperf/tools/ThreadTraceHelper$TraceFileObserver:startWatching	()V
    //   277: invokestatic 158	android/os/SystemClock:uptimeMillis	()J
    //   280: lstore 8
    //   282: ldc 115
    //   284: iconst_1
    //   285: ldc 160
    //   287: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: invokestatic 166	android/os/Process:myPid	()I
    //   293: iconst_3
    //   294: invokestatic 170	android/os/Process:sendSignal	(II)V
    //   297: getstatic 26	com/tencent/qqperf/tools/ThreadTraceHelper:jdField_a_of_type_ComTencentQqperfToolsThreadTraceHelper$TraceFileObserver	Lcom/tencent/qqperf/tools/ThreadTraceHelper$TraceFileObserver;
    //   300: astore 12
    //   302: aload 12
    //   304: monitorenter
    //   305: getstatic 26	com/tencent/qqperf/tools/ThreadTraceHelper:jdField_a_of_type_ComTencentQqperfToolsThreadTraceHelper$TraceFileObserver	Lcom/tencent/qqperf/tools/ThreadTraceHelper$TraceFileObserver;
    //   308: ldc2_w 171
    //   311: invokevirtual 176	java/lang/Object:wait	(J)V
    //   314: aload 12
    //   316: monitorexit
    //   317: getstatic 26	com/tencent/qqperf/tools/ThreadTraceHelper:jdField_a_of_type_ComTencentQqperfToolsThreadTraceHelper$TraceFileObserver	Lcom/tencent/qqperf/tools/ThreadTraceHelper$TraceFileObserver;
    //   320: invokevirtual 179	com/tencent/qqperf/tools/ThreadTraceHelper$TraceFileObserver:stopWatching	()V
    //   323: aload_0
    //   324: invokeinterface 100 1 0
    //   329: ldc 92
    //   331: invokeinterface 106 2 0
    //   336: ldc 84
    //   338: iconst_0
    //   339: invokeinterface 110 3 0
    //   344: invokeinterface 113 1 0
    //   349: pop
    //   350: ldc 115
    //   352: iconst_1
    //   353: new 53	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   360: ldc 181
    //   362: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokestatic 158	android/os/SystemClock:uptimeMillis	()J
    //   368: lload 8
    //   370: lsub
    //   371: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   374: ldc 183
    //   376: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   385: aload 11
    //   387: invokevirtual 127	java/io/File:length	()J
    //   390: lstore 8
    //   392: lload 8
    //   394: lload 6
    //   396: lcmp
    //   397: ifle +15 -> 412
    //   400: lload 8
    //   402: lload 6
    //   404: lsub
    //   405: ldc2_w 187
    //   408: lcmp
    //   409: ifle +81 -> 490
    //   412: ldc 115
    //   414: iconst_1
    //   415: new 53	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   422: ldc 190
    //   424: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: lload 6
    //   429: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   432: ldc 192
    //   434: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: lload 8
    //   439: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   442: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   448: lload 8
    //   450: lload 6
    //   452: lcmp
    //   453: ifgt +32 -> 485
    //   456: iconst_4
    //   457: istore_3
    //   458: goto -307 -> 151
    //   461: astore 13
    //   463: aload 12
    //   465: monitorexit
    //   466: aload 13
    //   468: athrow
    //   469: astore 12
    //   471: aload 12
    //   473: invokevirtual 195	java/lang/InterruptedException:printStackTrace	()V
    //   476: goto -159 -> 317
    //   479: astore_0
    //   480: ldc 2
    //   482: monitorexit
    //   483: aload_0
    //   484: athrow
    //   485: iconst_5
    //   486: istore_3
    //   487: goto -336 -> 151
    //   490: aload 11
    //   492: lload 6
    //   494: lload 8
    //   496: lload 6
    //   498: lsub
    //   499: new 51	java/io/File
    //   502: dup
    //   503: aload_1
    //   504: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   507: aload_2
    //   508: invokestatic 198	com/tencent/qqperf/tools/ThreadTraceHelper:a	(Ljava/io/File;JJLjava/io/File;Ljava/lang/String;)Z
    //   511: istore 10
    //   513: ldc 115
    //   515: iconst_1
    //   516: new 53	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   523: ldc 200
    //   525: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: iload 10
    //   530: invokevirtual 203	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   533: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   539: iload 4
    //   541: istore_3
    //   542: iload 10
    //   544: ifne -393 -> 151
    //   547: bipush 6
    //   549: istore_3
    //   550: goto -399 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	553	0	paramContext	Context
    //   0	553	1	paramString1	String
    //   0	553	2	paramString2	String
    //   74	476	3	i	int
    //   1	539	4	j	int
    //   70	42	5	k	int
    //   172	325	6	l1	long
    //   280	215	8	l2	long
    //   511	32	10	bool	boolean
    //   37	454	11	localObject1	Object
    //   469	3	12	localInterruptedException	java.lang.InterruptedException
    //   461	6	13	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   305	317	461	finally
    //   463	466	461	finally
    //   297	305	469	java/lang/InterruptedException
    //   466	469	469	java/lang/InterruptedException
    //   6	53	479	finally
    //   53	72	479	finally
    //   75	108	479	finally
    //   113	136	479	finally
    //   141	149	479	finally
    //   156	190	479	finally
    //   197	246	479	finally
    //   251	297	479	finally
    //   297	305	479	finally
    //   317	392	479	finally
    //   412	448	479	finally
    //   466	469	479	finally
    //   471	476	479	finally
    //   490	539	479	finally
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("|transTid=").append(jdField_a_of_type_Long);
    localStringBuilder.append("|transTname=").append(b);
    localStringBuilder.append("|transWaiting=");
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append(localEntry.getKey()).append(",").append((String)localEntry.getValue());
        localStringBuilder.append(";");
      }
    }
    return localObject2.toString();
  }
  
  public static String a(String paramString)
  {
    a();
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    if (4 == MobileQQ.sProcessId) {
      localStringBuilder.append("msftrace/");
    }
    localStringBuilder.append("traces_").append(System.currentTimeMillis()).append("_").append(paramString).append(".txt");
    return localStringBuilder.toString();
  }
  
  public static ArrayList<String> a(Context paramContext)
  {
    a();
    ArrayList localArrayList = new ArrayList(10);
    paramContext = paramContext.getSharedPreferences("unified_monitor", 0);
    long l2 = paramContext.getLong("last_report_trace_file", 0L);
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    Object localObject1 = new File(jdField_a_of_type_JavaLangString + "msftrace/");
    int j = 0;
    int i = 0;
    int k = j;
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      k = j;
      if (localObject1 != null)
      {
        int m = localObject1.length;
        j = 0;
        k = i;
        if (j < m)
        {
          Object localObject2 = localObject1[j];
          Object localObject3 = localObject2.getName();
          label163:
          long l3;
          if ((localObject2.isFile()) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).startsWith("traces_")))
          {
            k = 1;
            if (k != 0) {
              l3 = 0L;
            }
          }
          else
          {
            try
            {
              localObject3 = ((String)localObject3).split("_");
              l2 = l3;
              if (localObject3 != null)
              {
                l2 = l3;
                if (localObject3.length > 2) {
                  l2 = Long.valueOf(localObject3[1]).longValue();
                }
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                l2 = l3;
                if (QLog.isColorLevel())
                {
                  QLog.e("UnifiedMonitor.Trace", 2, "parse trace file time exception : ", localException);
                  l2 = l3;
                }
              }
              if (Math.abs(l2 - System.currentTimeMillis()) <= 172800000L) {
                break label306;
              }
              localObject2.delete();
            }
            if ((l2 > 0L) && (l2 > l1))
            {
              localArrayList.add(localObject2.getAbsolutePath());
              i += 1;
            }
          }
          label306:
          for (;;)
          {
            j += 1;
            break;
            k = 0;
            break label163;
          }
        }
      }
    }
    if (k > 0)
    {
      paramContext.edit().putLong("last_report_trace_file", System.currentTimeMillis()).commit();
      QLog.e("UnifiedMonitor.Trace", 1, new Object[] { "report msf trace stack time = ", Long.valueOf(System.currentTimeMillis()), ",report file count=", Integer.valueOf(k) });
    }
    return localArrayList;
  }
  
  private static void a()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {}
    try
    {
      jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/" + "com.tencent.mobileqq".replace(".", "/") + "/");
      return;
    }
    catch (Exception localException)
    {
      jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath("/sdcard/tencent/msflogs/" + "com.tencent.mobileqq".replace(".", "/") + "/");
    }
  }
  
  public static void a(long paramLong)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
      return;
    }
  }
  
  public static void a(long paramLong, String paramString)
  {
    jdField_a_of_type_Long = paramLong;
    b = paramString;
  }
  
  public static void a(Context paramContext)
  {
    a();
    Object localObject1 = new File(jdField_a_of_type_JavaLangString);
    int i;
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        int k = localObject1.length;
        i = 0;
        if (i < k)
        {
          Object localObject2 = localObject1[i];
          if ((localObject2.isFile()) && (!TextUtils.isEmpty(localObject2.getName())) && (localObject2.getName().startsWith("traces_"))) {}
          for (int j = 1;; j = 0)
          {
            if ((j != 0) && (Math.abs(localObject2.lastModified() - System.currentTimeMillis()) > 86400000L)) {
              localObject2.delete();
            }
            i += 1;
            break;
          }
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
    //   0: aconst_null
    //   1: astore 10
    //   3: aload_0
    //   4: invokevirtual 287	java/io/File:isFile	()Z
    //   7: ifeq +183 -> 190
    //   10: aload 5
    //   12: invokevirtual 71	java/io/File:exists	()Z
    //   15: ifeq +9 -> 24
    //   18: aload 5
    //   20: invokevirtual 334	java/io/File:delete	()Z
    //   23: pop
    //   24: new 396	java/io/FileOutputStream
    //   27: dup
    //   28: aload 5
    //   30: invokespecial 399	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   33: astore 8
    //   35: new 401	java/io/FileInputStream
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 402	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   43: astore 9
    //   45: aload 9
    //   47: invokevirtual 405	java/io/FileInputStream:available	()I
    //   50: i2l
    //   51: lload_1
    //   52: lcmp
    //   53: ifle +10 -> 63
    //   56: aload 9
    //   58: lload_1
    //   59: invokevirtual 408	java/io/FileInputStream:skip	(J)J
    //   62: pop2
    //   63: sipush 4096
    //   66: newarray byte
    //   68: astore_0
    //   69: aload 9
    //   71: aload_0
    //   72: invokevirtual 412	java/io/FileInputStream:read	([B)I
    //   75: istore 7
    //   77: iload 7
    //   79: iconst_m1
    //   80: if_icmpeq +59 -> 139
    //   83: aload 8
    //   85: aload_0
    //   86: iconst_0
    //   87: iload 7
    //   89: invokevirtual 416	java/io/FileOutputStream:write	([BII)V
    //   92: goto -23 -> 69
    //   95: astore 10
    //   97: aload 9
    //   99: astore 6
    //   101: aload 8
    //   103: astore_0
    //   104: aload 10
    //   106: astore 8
    //   108: aload 8
    //   110: invokevirtual 417	java/io/IOException:printStackTrace	()V
    //   113: aload 5
    //   115: invokevirtual 334	java/io/File:delete	()Z
    //   118: pop
    //   119: aload_0
    //   120: ifnull +7 -> 127
    //   123: aload_0
    //   124: invokevirtual 420	java/io/FileOutputStream:close	()V
    //   127: aload 6
    //   129: ifnull +8 -> 137
    //   132: aload 6
    //   134: invokevirtual 421	java/io/FileInputStream:close	()V
    //   137: iconst_0
    //   138: ireturn
    //   139: aload 6
    //   141: ifnull +24 -> 165
    //   144: aload 8
    //   146: ldc_w 423
    //   149: invokevirtual 427	java/lang/String:getBytes	()[B
    //   152: invokevirtual 430	java/io/FileOutputStream:write	([B)V
    //   155: aload 8
    //   157: aload 6
    //   159: invokevirtual 427	java/lang/String:getBytes	()[B
    //   162: invokevirtual 430	java/io/FileOutputStream:write	([B)V
    //   165: aload 8
    //   167: invokevirtual 433	java/io/FileOutputStream:flush	()V
    //   170: aload 8
    //   172: ifnull +8 -> 180
    //   175: aload 8
    //   177: invokevirtual 420	java/io/FileOutputStream:close	()V
    //   180: aload 9
    //   182: ifnull +8 -> 190
    //   185: aload 9
    //   187: invokevirtual 421	java/io/FileInputStream:close	()V
    //   190: iconst_1
    //   191: ireturn
    //   192: astore_0
    //   193: aconst_null
    //   194: astore 5
    //   196: aconst_null
    //   197: astore 8
    //   199: aload 8
    //   201: ifnull +8 -> 209
    //   204: aload 8
    //   206: invokevirtual 420	java/io/FileOutputStream:close	()V
    //   209: aload 5
    //   211: ifnull +8 -> 219
    //   214: aload 5
    //   216: invokevirtual 421	java/io/FileInputStream:close	()V
    //   219: aload_0
    //   220: athrow
    //   221: astore_0
    //   222: goto -42 -> 180
    //   225: astore_0
    //   226: goto -36 -> 190
    //   229: astore 5
    //   231: goto -112 -> 119
    //   234: astore_0
    //   235: goto -108 -> 127
    //   238: astore_0
    //   239: iconst_0
    //   240: ireturn
    //   241: astore 6
    //   243: goto -34 -> 209
    //   246: astore 5
    //   248: goto -29 -> 219
    //   251: astore_0
    //   252: aconst_null
    //   253: astore 5
    //   255: goto -56 -> 199
    //   258: astore_0
    //   259: aload 9
    //   261: astore 5
    //   263: goto -64 -> 199
    //   266: astore 9
    //   268: aload_0
    //   269: astore 8
    //   271: aload 6
    //   273: astore 5
    //   275: aload 9
    //   277: astore_0
    //   278: goto -79 -> 199
    //   281: astore 8
    //   283: aconst_null
    //   284: astore_0
    //   285: aload 10
    //   287: astore 6
    //   289: goto -181 -> 108
    //   292: astore 6
    //   294: aload 8
    //   296: astore_0
    //   297: aload 6
    //   299: astore 8
    //   301: aload 10
    //   303: astore 6
    //   305: goto -197 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	paramFile1	File
    //   0	308	1	paramLong1	long
    //   0	308	3	paramLong2	long
    //   0	308	5	paramFile2	File
    //   0	308	6	paramString	String
    //   75	13	7	i	int
    //   33	237	8	localObject1	Object
    //   281	14	8	localIOException1	java.io.IOException
    //   299	1	8	str	String
    //   43	217	9	localFileInputStream	java.io.FileInputStream
    //   266	10	9	localObject2	Object
    //   1	1	10	localObject3	Object
    //   95	207	10	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   45	63	95	java/io/IOException
    //   63	69	95	java/io/IOException
    //   69	77	95	java/io/IOException
    //   83	92	95	java/io/IOException
    //   144	165	95	java/io/IOException
    //   165	170	95	java/io/IOException
    //   10	24	192	finally
    //   24	35	192	finally
    //   175	180	221	java/io/IOException
    //   185	190	225	java/io/IOException
    //   113	119	229	java/lang/Exception
    //   123	127	234	java/io/IOException
    //   132	137	238	java/io/IOException
    //   204	209	241	java/io/IOException
    //   214	219	246	java/io/IOException
    //   35	45	251	finally
    //   45	63	258	finally
    //   63	69	258	finally
    //   69	77	258	finally
    //   83	92	258	finally
    //   144	165	258	finally
    //   165	170	258	finally
    //   108	113	266	finally
    //   113	119	266	finally
    //   10	24	281	java/io/IOException
    //   24	35	281	java/io/IOException
    //   35	45	292	java/io/IOException
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: new 51	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 8
    //   16: aload 8
    //   18: invokevirtual 71	java/io/File:exists	()Z
    //   21: ifeq +9 -> 30
    //   24: aload 8
    //   26: invokevirtual 334	java/io/File:delete	()Z
    //   29: pop
    //   30: new 396	java/io/FileOutputStream
    //   33: dup
    //   34: aload 8
    //   36: invokespecial 399	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   39: astore 6
    //   41: invokestatic 439	java/lang/Thread:activeCount	()I
    //   44: anewarray 436	java/lang/Thread
    //   47: astore_0
    //   48: aload_0
    //   49: invokestatic 443	java/lang/Thread:enumerate	([Ljava/lang/Thread;)I
    //   52: pop
    //   53: iconst_0
    //   54: istore_2
    //   55: iload_2
    //   56: aload_0
    //   57: arraylength
    //   58: if_icmpge +209 -> 267
    //   61: aload_0
    //   62: iload_2
    //   63: aaload
    //   64: astore 7
    //   66: aload 7
    //   68: ifnull +328 -> 396
    //   71: aload 6
    //   73: ldc_w 445
    //   76: invokevirtual 427	java/lang/String:getBytes	()[B
    //   79: invokevirtual 430	java/io/FileOutputStream:write	([B)V
    //   82: aload 6
    //   84: aload 7
    //   86: invokevirtual 446	java/lang/Thread:getName	()Ljava/lang/String;
    //   89: invokevirtual 427	java/lang/String:getBytes	()[B
    //   92: invokevirtual 430	java/io/FileOutputStream:write	([B)V
    //   95: aload 6
    //   97: ldc_w 423
    //   100: invokevirtual 427	java/lang/String:getBytes	()[B
    //   103: invokevirtual 430	java/io/FileOutputStream:write	([B)V
    //   106: aload 6
    //   108: new 53	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   115: ldc_w 448
    //   118: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload 7
    //   123: invokevirtual 452	java/lang/Thread:getState	()Ljava/lang/Thread$State;
    //   126: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokevirtual 427	java/lang/String:getBytes	()[B
    //   135: invokevirtual 430	java/io/FileOutputStream:write	([B)V
    //   138: aload 6
    //   140: ldc_w 423
    //   143: invokevirtual 427	java/lang/String:getBytes	()[B
    //   146: invokevirtual 430	java/io/FileOutputStream:write	([B)V
    //   149: aload 6
    //   151: new 53	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 454
    //   161: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload 7
    //   166: invokevirtual 457	java/lang/Thread:getId	()J
    //   169: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   172: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokevirtual 427	java/lang/String:getBytes	()[B
    //   178: invokevirtual 430	java/io/FileOutputStream:write	([B)V
    //   181: aload 6
    //   183: ldc_w 423
    //   186: invokevirtual 427	java/lang/String:getBytes	()[B
    //   189: invokevirtual 430	java/io/FileOutputStream:write	([B)V
    //   192: aload 7
    //   194: invokevirtual 460	java/lang/Thread:isAlive	()Z
    //   197: ifeq +199 -> 396
    //   200: aload 7
    //   202: invokevirtual 464	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   205: astore 7
    //   207: aload 7
    //   209: arraylength
    //   210: istore 4
    //   212: iconst_0
    //   213: istore_3
    //   214: iload_3
    //   215: iload 4
    //   217: if_icmpge +36 -> 253
    //   220: aload 6
    //   222: aload 7
    //   224: iload_3
    //   225: aaload
    //   226: invokevirtual 467	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   229: invokevirtual 427	java/lang/String:getBytes	()[B
    //   232: invokevirtual 430	java/io/FileOutputStream:write	([B)V
    //   235: aload 6
    //   237: ldc_w 423
    //   240: invokevirtual 427	java/lang/String:getBytes	()[B
    //   243: invokevirtual 430	java/io/FileOutputStream:write	([B)V
    //   246: iload_3
    //   247: iconst_1
    //   248: iadd
    //   249: istore_3
    //   250: goto -36 -> 214
    //   253: aload 6
    //   255: ldc_w 423
    //   258: invokevirtual 427	java/lang/String:getBytes	()[B
    //   261: invokevirtual 430	java/io/FileOutputStream:write	([B)V
    //   264: goto +132 -> 396
    //   267: aload 6
    //   269: ldc_w 423
    //   272: invokevirtual 427	java/lang/String:getBytes	()[B
    //   275: invokevirtual 430	java/io/FileOutputStream:write	([B)V
    //   278: aload 6
    //   280: aload_1
    //   281: invokevirtual 427	java/lang/String:getBytes	()[B
    //   284: invokevirtual 430	java/io/FileOutputStream:write	([B)V
    //   287: aload 6
    //   289: invokevirtual 433	java/io/FileOutputStream:flush	()V
    //   292: aload 6
    //   294: ifnull +8 -> 302
    //   297: aload 6
    //   299: invokevirtual 420	java/io/FileOutputStream:close	()V
    //   302: iconst_1
    //   303: istore 5
    //   305: iload 5
    //   307: ireturn
    //   308: astore_1
    //   309: aload 7
    //   311: astore_0
    //   312: invokestatic 318	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   315: ifeq +13 -> 328
    //   318: ldc 115
    //   320: iconst_2
    //   321: ldc_w 469
    //   324: aload_1
    //   325: invokestatic 471	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   328: aload 8
    //   330: invokevirtual 334	java/io/File:delete	()Z
    //   333: pop
    //   334: aload_0
    //   335: ifnull -30 -> 305
    //   338: aload_0
    //   339: invokevirtual 420	java/io/FileOutputStream:close	()V
    //   342: iconst_0
    //   343: ireturn
    //   344: astore_0
    //   345: iconst_0
    //   346: ireturn
    //   347: astore_0
    //   348: aconst_null
    //   349: astore_1
    //   350: aload_1
    //   351: ifnull +7 -> 358
    //   354: aload_1
    //   355: invokevirtual 420	java/io/FileOutputStream:close	()V
    //   358: aload_0
    //   359: athrow
    //   360: astore_0
    //   361: goto -59 -> 302
    //   364: astore_1
    //   365: goto -31 -> 334
    //   368: astore_1
    //   369: goto -11 -> 358
    //   372: astore_0
    //   373: aload 6
    //   375: astore_1
    //   376: goto -26 -> 350
    //   379: astore 6
    //   381: aload_0
    //   382: astore_1
    //   383: aload 6
    //   385: astore_0
    //   386: goto -36 -> 350
    //   389: astore_1
    //   390: aload 6
    //   392: astore_0
    //   393: goto -81 -> 312
    //   396: iload_2
    //   397: iconst_1
    //   398: iadd
    //   399: istore_2
    //   400: goto -345 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	paramString1	String
    //   0	403	1	paramString2	String
    //   54	346	2	i	int
    //   213	37	3	j	int
    //   210	8	4	k	int
    //   1	305	5	bool	boolean
    //   39	335	6	localFileOutputStream	java.io.FileOutputStream
    //   379	12	6	localObject	Object
    //   4	306	7	arrayOfStackTraceElement	java.lang.StackTraceElement[]
    //   14	315	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   16	30	308	java/lang/Exception
    //   30	41	308	java/lang/Exception
    //   338	342	344	java/io/IOException
    //   16	30	347	finally
    //   30	41	347	finally
    //   297	302	360	java/io/IOException
    //   328	334	364	java/lang/Exception
    //   354	358	368	java/io/IOException
    //   41	53	372	finally
    //   55	61	372	finally
    //   71	212	372	finally
    //   220	246	372	finally
    //   253	264	372	finally
    //   267	292	372	finally
    //   312	328	379	finally
    //   328	334	379	finally
    //   41	53	389	java/lang/Exception
    //   55	61	389	java/lang/Exception
    //   71	212	389	java/lang/Exception
    //   220	246	389	java/lang/Exception
    //   253	264	389	java/lang/Exception
    //   267	292	389	java/lang/Exception
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
  
  public static void b(long paramLong, String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.tools.ThreadTraceHelper
 * JD-Core Version:    0.7.0.1
 */