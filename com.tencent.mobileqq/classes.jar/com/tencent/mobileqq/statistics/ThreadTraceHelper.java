package com.tencent.mobileqq.statistics;

import ahsd;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ThreadTraceHelper
{
  private static long jdField_a_of_type_Long;
  private static ahsd jdField_a_of_type_Ahsd;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final String jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/" + "com.tencent.mobileqq".replace(".", "/") + "/";
  private static HashMap jdField_a_of_type_JavaUtilHashMap;
  private static String b;
  
  static
  {
    jdField_a_of_type_Ahsd = new ahsd("/data/anr/traces.txt", 8);
    jdField_a_of_type_Long = -1L;
    jdField_a_of_type_JavaUtilHashMap = new HashMap(30);
  }
  
  /* Error */
  static int a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: new 26	java/io/File
    //   9: dup
    //   10: new 15	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   17: getstatic 53	com/tencent/mobileqq/statistics/ThreadTraceHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   20: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 82
    //   25: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: astore 11
    //   36: aload 11
    //   38: invokevirtual 89	java/io/File:exists	()Z
    //   41: ifne +9 -> 50
    //   44: aload 11
    //   46: invokevirtual 92	java/io/File:mkdirs	()Z
    //   49: pop
    //   50: aload_0
    //   51: ldc 94
    //   53: iconst_0
    //   54: invokevirtual 100	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   57: astore_0
    //   58: aload_0
    //   59: ldc 102
    //   61: iconst_0
    //   62: invokeinterface 108 3 0
    //   67: istore 5
    //   69: iload 5
    //   71: istore_3
    //   72: aload_0
    //   73: ldc 110
    //   75: invokeinterface 114 2 0
    //   80: ifeq +53 -> 133
    //   83: aload_0
    //   84: invokeinterface 118 1 0
    //   89: ldc 110
    //   91: invokeinterface 124 2 0
    //   96: pop
    //   97: aload_0
    //   98: invokeinterface 118 1 0
    //   103: astore 11
    //   105: iload 5
    //   107: iconst_1
    //   108: iadd
    //   109: istore_3
    //   110: aload 11
    //   112: ldc 102
    //   114: iload_3
    //   115: invokeinterface 128 3 0
    //   120: pop
    //   121: aload_0
    //   122: invokeinterface 118 1 0
    //   127: invokeinterface 131 1 0
    //   132: pop
    //   133: iload_3
    //   134: iconst_3
    //   135: if_icmplt +18 -> 153
    //   138: ldc 133
    //   140: iconst_1
    //   141: ldc 135
    //   143: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   146: iconst_2
    //   147: istore_3
    //   148: ldc 2
    //   150: monitorexit
    //   151: iload_3
    //   152: ireturn
    //   153: new 26	java/io/File
    //   156: dup
    //   157: ldc 57
    //   159: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   162: astore 11
    //   164: aload 11
    //   166: invokevirtual 145	java/io/File:length	()J
    //   169: lstore 6
    //   171: aload 11
    //   173: invokevirtual 89	java/io/File:exists	()Z
    //   176: ifeq +18 -> 194
    //   179: aload 11
    //   181: invokevirtual 148	java/io/File:canRead	()Z
    //   184: ifeq +10 -> 194
    //   187: lload 6
    //   189: lconst_0
    //   190: lcmp
    //   191: ifne +57 -> 248
    //   194: ldc 133
    //   196: iconst_1
    //   197: iconst_3
    //   198: anewarray 4	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: ldc 150
    //   205: aastore
    //   206: dup
    //   207: iconst_1
    //   208: aload 11
    //   210: invokevirtual 89	java/io/File:exists	()Z
    //   213: invokestatic 156	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   216: aastore
    //   217: dup
    //   218: iconst_2
    //   219: new 15	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   226: ldc 158
    //   228: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: lload 6
    //   233: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   236: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: aastore
    //   240: invokestatic 164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   243: iconst_3
    //   244: istore_3
    //   245: goto -97 -> 148
    //   248: aload_0
    //   249: invokeinterface 118 1 0
    //   254: ldc 110
    //   256: iconst_1
    //   257: invokeinterface 168 3 0
    //   262: invokeinterface 131 1 0
    //   267: pop
    //   268: getstatic 62	com/tencent/mobileqq/statistics/ThreadTraceHelper:jdField_a_of_type_Ahsd	Lahsd;
    //   271: invokevirtual 171	ahsd:startWatching	()V
    //   274: invokestatic 176	android/os/SystemClock:uptimeMillis	()J
    //   277: lstore 8
    //   279: ldc 133
    //   281: iconst_1
    //   282: ldc 178
    //   284: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: invokestatic 184	android/os/Process:myPid	()I
    //   290: iconst_3
    //   291: invokestatic 188	android/os/Process:sendSignal	(II)V
    //   294: getstatic 62	com/tencent/mobileqq/statistics/ThreadTraceHelper:jdField_a_of_type_Ahsd	Lahsd;
    //   297: astore 12
    //   299: aload 12
    //   301: monitorenter
    //   302: getstatic 62	com/tencent/mobileqq/statistics/ThreadTraceHelper:jdField_a_of_type_Ahsd	Lahsd;
    //   305: ldc2_w 189
    //   308: invokevirtual 194	java/lang/Object:wait	(J)V
    //   311: aload 12
    //   313: monitorexit
    //   314: getstatic 62	com/tencent/mobileqq/statistics/ThreadTraceHelper:jdField_a_of_type_Ahsd	Lahsd;
    //   317: invokevirtual 197	ahsd:stopWatching	()V
    //   320: aload_0
    //   321: invokeinterface 118 1 0
    //   326: ldc 110
    //   328: invokeinterface 124 2 0
    //   333: ldc 102
    //   335: iconst_0
    //   336: invokeinterface 128 3 0
    //   341: invokeinterface 131 1 0
    //   346: pop
    //   347: ldc 133
    //   349: iconst_1
    //   350: new 15	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   357: ldc 199
    //   359: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokestatic 176	android/os/SystemClock:uptimeMillis	()J
    //   365: lload 8
    //   367: lsub
    //   368: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   371: ldc 201
    //   373: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 204	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   382: aload 11
    //   384: invokevirtual 145	java/io/File:length	()J
    //   387: lstore 8
    //   389: lload 8
    //   391: lload 6
    //   393: lcmp
    //   394: ifle +15 -> 409
    //   397: lload 8
    //   399: lload 6
    //   401: lsub
    //   402: ldc2_w 205
    //   405: lcmp
    //   406: ifle +81 -> 487
    //   409: ldc 133
    //   411: iconst_1
    //   412: new 15	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   419: ldc 208
    //   421: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: lload 6
    //   426: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   429: ldc 210
    //   431: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: lload 8
    //   436: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   439: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: lload 8
    //   447: lload 6
    //   449: lcmp
    //   450: ifgt +32 -> 482
    //   453: iconst_4
    //   454: istore_3
    //   455: goto -307 -> 148
    //   458: astore 13
    //   460: aload 12
    //   462: monitorexit
    //   463: aload 13
    //   465: athrow
    //   466: astore 12
    //   468: aload 12
    //   470: invokevirtual 213	java/lang/InterruptedException:printStackTrace	()V
    //   473: goto -159 -> 314
    //   476: astore_0
    //   477: ldc 2
    //   479: monitorexit
    //   480: aload_0
    //   481: athrow
    //   482: iconst_5
    //   483: istore_3
    //   484: goto -336 -> 148
    //   487: aload 11
    //   489: lload 6
    //   491: lload 8
    //   493: lload 6
    //   495: lsub
    //   496: new 26	java/io/File
    //   499: dup
    //   500: aload_1
    //   501: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   504: aload_2
    //   505: invokestatic 216	com/tencent/mobileqq/statistics/ThreadTraceHelper:a	(Ljava/io/File;JJLjava/io/File;Ljava/lang/String;)Z
    //   508: istore 10
    //   510: ldc 133
    //   512: iconst_1
    //   513: new 15	java/lang/StringBuilder
    //   516: dup
    //   517: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   520: ldc 218
    //   522: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: iload 10
    //   527: invokevirtual 221	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   530: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   536: iload 4
    //   538: istore_3
    //   539: iload 10
    //   541: ifne -393 -> 148
    //   544: bipush 6
    //   546: istore_3
    //   547: goto -399 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	550	0	paramContext	Context
    //   0	550	1	paramString1	String
    //   0	550	2	paramString2	String
    //   71	476	3	i	int
    //   1	536	4	j	int
    //   67	42	5	k	int
    //   169	325	6	l1	long
    //   277	215	8	l2	long
    //   508	32	10	bool	boolean
    //   34	454	11	localObject1	Object
    //   466	3	12	localInterruptedException	java.lang.InterruptedException
    //   458	6	13	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   302	314	458	finally
    //   460	463	458	finally
    //   294	302	466	java/lang/InterruptedException
    //   463	466	466	java/lang/InterruptedException
    //   6	50	476	finally
    //   50	69	476	finally
    //   72	105	476	finally
    //   110	133	476	finally
    //   138	146	476	finally
    //   153	187	476	finally
    //   194	243	476	finally
    //   248	294	476	finally
    //   294	302	476	finally
    //   314	389	476	finally
    //   409	445	476	finally
    //   463	466	476	finally
    //   468	473	476	finally
    //   487	536	476	finally
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
  
  static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    if (4 == BaseApplicationImpl.sProcessId) {
      localStringBuilder.append("msftrace/");
    }
    localStringBuilder.append("traces_").append(System.currentTimeMillis()).append("_").append(paramString).append(".txt");
    return localStringBuilder.toString();
  }
  
  static ArrayList a(Context paramContext)
  {
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
          label160:
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
                break label303;
              }
              localObject2.delete();
            }
            if ((l2 > 0L) && (l2 > l1))
            {
              localArrayList.add(localObject2.getAbsolutePath());
              i += 1;
            }
          }
          label303:
          for (;;)
          {
            j += 1;
            break;
            k = 0;
            break label160;
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
  
  static void a(Context paramContext)
  {
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
    //   4: invokevirtual 305	java/io/File:isFile	()Z
    //   7: ifeq +183 -> 190
    //   10: aload 5
    //   12: invokevirtual 89	java/io/File:exists	()Z
    //   15: ifeq +9 -> 24
    //   18: aload 5
    //   20: invokevirtual 352	java/io/File:delete	()Z
    //   23: pop
    //   24: new 384	java/io/FileOutputStream
    //   27: dup
    //   28: aload 5
    //   30: invokespecial 387	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   33: astore 8
    //   35: new 389	java/io/FileInputStream
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 390	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   43: astore 9
    //   45: aload 9
    //   47: invokevirtual 393	java/io/FileInputStream:available	()I
    //   50: i2l
    //   51: lload_1
    //   52: lcmp
    //   53: ifle +10 -> 63
    //   56: aload 9
    //   58: lload_1
    //   59: invokevirtual 396	java/io/FileInputStream:skip	(J)J
    //   62: pop2
    //   63: sipush 4096
    //   66: newarray byte
    //   68: astore_0
    //   69: aload 9
    //   71: aload_0
    //   72: invokevirtual 400	java/io/FileInputStream:read	([B)I
    //   75: istore 7
    //   77: iload 7
    //   79: iconst_m1
    //   80: if_icmpeq +59 -> 139
    //   83: aload 8
    //   85: aload_0
    //   86: iconst_0
    //   87: iload 7
    //   89: invokevirtual 404	java/io/FileOutputStream:write	([BII)V
    //   92: goto -23 -> 69
    //   95: astore 10
    //   97: aload 9
    //   99: astore 6
    //   101: aload 8
    //   103: astore_0
    //   104: aload 10
    //   106: astore 8
    //   108: aload 8
    //   110: invokevirtual 405	java/io/IOException:printStackTrace	()V
    //   113: aload 5
    //   115: invokevirtual 352	java/io/File:delete	()Z
    //   118: pop
    //   119: aload_0
    //   120: ifnull +7 -> 127
    //   123: aload_0
    //   124: invokevirtual 408	java/io/FileOutputStream:close	()V
    //   127: aload 6
    //   129: ifnull +8 -> 137
    //   132: aload 6
    //   134: invokevirtual 409	java/io/FileInputStream:close	()V
    //   137: iconst_0
    //   138: ireturn
    //   139: aload 6
    //   141: ifnull +24 -> 165
    //   144: aload 8
    //   146: ldc_w 411
    //   149: invokevirtual 415	java/lang/String:getBytes	()[B
    //   152: invokevirtual 418	java/io/FileOutputStream:write	([B)V
    //   155: aload 8
    //   157: aload 6
    //   159: invokevirtual 415	java/lang/String:getBytes	()[B
    //   162: invokevirtual 418	java/io/FileOutputStream:write	([B)V
    //   165: aload 8
    //   167: invokevirtual 421	java/io/FileOutputStream:flush	()V
    //   170: aload 8
    //   172: ifnull +8 -> 180
    //   175: aload 8
    //   177: invokevirtual 408	java/io/FileOutputStream:close	()V
    //   180: aload 9
    //   182: ifnull +8 -> 190
    //   185: aload 9
    //   187: invokevirtual 409	java/io/FileInputStream:close	()V
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
    //   206: invokevirtual 408	java/io/FileOutputStream:close	()V
    //   209: aload 5
    //   211: ifnull +8 -> 219
    //   214: aload 5
    //   216: invokevirtual 409	java/io/FileInputStream:close	()V
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
  static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: new 26	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 8
    //   16: aload 8
    //   18: invokevirtual 89	java/io/File:exists	()Z
    //   21: ifeq +9 -> 30
    //   24: aload 8
    //   26: invokevirtual 352	java/io/File:delete	()Z
    //   29: pop
    //   30: new 384	java/io/FileOutputStream
    //   33: dup
    //   34: aload 8
    //   36: invokespecial 387	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   39: astore 6
    //   41: invokestatic 427	java/lang/Thread:activeCount	()I
    //   44: anewarray 424	java/lang/Thread
    //   47: astore_0
    //   48: aload_0
    //   49: invokestatic 431	java/lang/Thread:enumerate	([Ljava/lang/Thread;)I
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
    //   73: ldc_w 433
    //   76: invokevirtual 415	java/lang/String:getBytes	()[B
    //   79: invokevirtual 418	java/io/FileOutputStream:write	([B)V
    //   82: aload 6
    //   84: aload 7
    //   86: invokevirtual 434	java/lang/Thread:getName	()Ljava/lang/String;
    //   89: invokevirtual 415	java/lang/String:getBytes	()[B
    //   92: invokevirtual 418	java/io/FileOutputStream:write	([B)V
    //   95: aload 6
    //   97: ldc_w 411
    //   100: invokevirtual 415	java/lang/String:getBytes	()[B
    //   103: invokevirtual 418	java/io/FileOutputStream:write	([B)V
    //   106: aload 6
    //   108: new 15	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   115: ldc_w 436
    //   118: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload 7
    //   123: invokevirtual 440	java/lang/Thread:getState	()Ljava/lang/Thread$State;
    //   126: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokevirtual 415	java/lang/String:getBytes	()[B
    //   135: invokevirtual 418	java/io/FileOutputStream:write	([B)V
    //   138: aload 6
    //   140: ldc_w 411
    //   143: invokevirtual 415	java/lang/String:getBytes	()[B
    //   146: invokevirtual 418	java/io/FileOutputStream:write	([B)V
    //   149: aload 6
    //   151: new 15	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 442
    //   161: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload 7
    //   166: invokevirtual 445	java/lang/Thread:getId	()J
    //   169: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   172: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokevirtual 415	java/lang/String:getBytes	()[B
    //   178: invokevirtual 418	java/io/FileOutputStream:write	([B)V
    //   181: aload 6
    //   183: ldc_w 411
    //   186: invokevirtual 415	java/lang/String:getBytes	()[B
    //   189: invokevirtual 418	java/io/FileOutputStream:write	([B)V
    //   192: aload 7
    //   194: invokevirtual 448	java/lang/Thread:isAlive	()Z
    //   197: ifeq +199 -> 396
    //   200: aload 7
    //   202: invokevirtual 452	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
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
    //   226: invokevirtual 455	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   229: invokevirtual 415	java/lang/String:getBytes	()[B
    //   232: invokevirtual 418	java/io/FileOutputStream:write	([B)V
    //   235: aload 6
    //   237: ldc_w 411
    //   240: invokevirtual 415	java/lang/String:getBytes	()[B
    //   243: invokevirtual 418	java/io/FileOutputStream:write	([B)V
    //   246: iload_3
    //   247: iconst_1
    //   248: iadd
    //   249: istore_3
    //   250: goto -36 -> 214
    //   253: aload 6
    //   255: ldc_w 411
    //   258: invokevirtual 415	java/lang/String:getBytes	()[B
    //   261: invokevirtual 418	java/io/FileOutputStream:write	([B)V
    //   264: goto +132 -> 396
    //   267: aload 6
    //   269: ldc_w 411
    //   272: invokevirtual 415	java/lang/String:getBytes	()[B
    //   275: invokevirtual 418	java/io/FileOutputStream:write	([B)V
    //   278: aload 6
    //   280: aload_1
    //   281: invokevirtual 415	java/lang/String:getBytes	()[B
    //   284: invokevirtual 418	java/io/FileOutputStream:write	([B)V
    //   287: aload 6
    //   289: invokevirtual 421	java/io/FileOutputStream:flush	()V
    //   292: aload 6
    //   294: ifnull +8 -> 302
    //   297: aload 6
    //   299: invokevirtual 408	java/io/FileOutputStream:close	()V
    //   302: iconst_1
    //   303: istore 5
    //   305: iload 5
    //   307: ireturn
    //   308: astore_1
    //   309: aload 7
    //   311: astore_0
    //   312: invokestatic 336	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   315: ifeq +13 -> 328
    //   318: ldc 133
    //   320: iconst_2
    //   321: ldc_w 457
    //   324: aload_1
    //   325: invokestatic 459	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   328: aload 8
    //   330: invokevirtual 352	java/io/File:delete	()Z
    //   333: pop
    //   334: aload_0
    //   335: ifnull -30 -> 305
    //   338: aload_0
    //   339: invokevirtual 408	java/io/FileOutputStream:close	()V
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
    //   355: invokevirtual 408	java/io/FileOutputStream:close	()V
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
    if (1 == BaseApplicationImpl.sProcessId) {
      return "|process=QQ";
    }
    if (4 == BaseApplicationImpl.sProcessId) {
      return "|process=MSF";
    }
    if (2 == BaseApplicationImpl.sProcessId) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ThreadTraceHelper
 * JD-Core Version:    0.7.0.1
 */