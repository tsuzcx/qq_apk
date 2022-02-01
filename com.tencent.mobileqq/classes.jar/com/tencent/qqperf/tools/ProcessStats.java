package com.tencent.qqperf.tools;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Process;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.commonsdk.util.StringUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProcessStats
{
  public static long a;
  public static int b;
  public static ProcessStats.Stats c;
  static int[] d = new int[17];
  static int[] e = new int[17];
  public static int f = -1;
  private static final RecyclablePool g = new RecyclablePool(ProcessStats.Stats.class, 30);
  private static Map<String, ProcessStats.Stats> h;
  private static int i;
  private static long j;
  private static long k;
  
  static
  {
    a = 0L;
    b = 0;
    c = a();
    h = new HashMap(30);
    i = 0;
    j = 0L;
    k = 0L;
  }
  
  public static long a(String paramString)
  {
    paramString = b(paramString);
    if (paramString == null) {
      return -1L;
    }
    return ((Long)paramString[1]).longValue() + ((Long)paramString[2]).longValue();
  }
  
  public static ProcessStats.Stats a()
  {
    return (ProcessStats.Stats)g.obtain(ProcessStats.Stats.class);
  }
  
  /* Error */
  public static final String a(int paramInt)
  {
    // Byte code:
    //   0: new 86	java/lang/StringBuilder
    //   3: dup
    //   4: iload_0
    //   5: bipush 110
    //   7: imul
    //   8: invokespecial 87	java/lang/StringBuilder:<init>	(I)V
    //   11: astore_1
    //   12: ldc 89
    //   14: getstatic 43	com/tencent/qqperf/tools/ProcessStats:c	Lcom/tencent/qqperf/tools/ProcessStats$Stats;
    //   17: iconst_0
    //   18: invokestatic 92	com/tencent/qqperf/tools/ProcessStats:a	(Ljava/lang/String;Lcom/tencent/qqperf/tools/ProcessStats$Stats;Z)V
    //   21: new 86	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   28: astore_2
    //   29: aload_2
    //   30: ldc 95
    //   32: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_2
    //   37: getstatic 43	com/tencent/qqperf/tools/ProcessStats:c	Lcom/tencent/qqperf/tools/ProcessStats$Stats;
    //   40: getfield 101	com/tencent/qqperf/tools/ProcessStats$Stats:b	J
    //   43: invokevirtual 104	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_2
    //   48: ldc 106
    //   50: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_2
    //   55: getstatic 43	com/tencent/qqperf/tools/ProcessStats:c	Lcom/tencent/qqperf/tools/ProcessStats$Stats;
    //   58: getfield 108	com/tencent/qqperf/tools/ProcessStats$Stats:c	J
    //   61: invokevirtual 104	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: ldc 110
    //   67: aload_2
    //   68: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 119	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   74: pop
    //   75: invokestatic 125	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   78: astore_2
    //   79: new 86	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   86: astore_3
    //   87: aload_3
    //   88: ldc 127
    //   90: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_3
    //   95: iload_0
    //   96: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_3
    //   101: ldc 132
    //   103: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: new 134	java/io/BufferedReader
    //   110: dup
    //   111: new 136	java/io/InputStreamReader
    //   114: dup
    //   115: aload_2
    //   116: aload_3
    //   117: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokevirtual 140	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   123: invokevirtual 146	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   126: invokespecial 149	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   129: invokespecial 152	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   132: astore_2
    //   133: aload_2
    //   134: invokevirtual 155	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   137: astore_3
    //   138: aload_3
    //   139: ifnull +19 -> 158
    //   142: aload_1
    //   143: aload_3
    //   144: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_1
    //   149: ldc 157
    //   151: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: goto -22 -> 133
    //   158: ldc 89
    //   160: getstatic 43	com/tencent/qqperf/tools/ProcessStats:c	Lcom/tencent/qqperf/tools/ProcessStats$Stats;
    //   163: iconst_0
    //   164: invokestatic 92	com/tencent/qqperf/tools/ProcessStats:a	(Ljava/lang/String;Lcom/tencent/qqperf/tools/ProcessStats$Stats;Z)V
    //   167: new 86	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   174: astore_2
    //   175: aload_2
    //   176: ldc 95
    //   178: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload_2
    //   183: getstatic 43	com/tencent/qqperf/tools/ProcessStats:c	Lcom/tencent/qqperf/tools/ProcessStats$Stats;
    //   186: getfield 101	com/tencent/qqperf/tools/ProcessStats$Stats:b	J
    //   189: invokevirtual 104	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_2
    //   194: ldc 106
    //   196: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload_2
    //   201: getstatic 43	com/tencent/qqperf/tools/ProcessStats:c	Lcom/tencent/qqperf/tools/ProcessStats$Stats;
    //   204: getfield 108	com/tencent/qqperf/tools/ProcessStats$Stats:c	J
    //   207: invokevirtual 104	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: ldc 110
    //   213: aload_2
    //   214: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 119	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   220: pop
    //   221: aload_1
    //   222: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: astore_1
    //   226: aload_1
    //   227: areturn
    //   228: astore_1
    //   229: aload_1
    //   230: athrow
    //   231: aconst_null
    //   232: areturn
    //   233: astore_1
    //   234: goto -3 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	paramInt	int
    //   11	216	1	localObject1	Object
    //   228	2	1	localObject2	Object
    //   233	1	1	localException	Exception
    //   28	186	2	localObject3	Object
    //   86	58	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   0	133	228	finally
    //   133	138	228	finally
    //   142	155	228	finally
    //   158	226	228	finally
    //   0	133	233	java/lang/Exception
    //   133	138	233	java/lang/Exception
    //   142	155	233	java/lang/Exception
    //   158	226	233	java/lang/Exception
  }
  
  public static final List<String> a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = new HashMap();
    int m;
    if (paramBoolean)
    {
      localObject1 = Thread.currentThread().getThreadGroup();
      localObject3 = new Thread[((ThreadGroup)localObject1).activeCount()];
      ((ThreadGroup)localObject1).enumerate((Thread[])localObject3);
      localObject2 = new HashMap(localObject3.length);
      int n = localObject3.length;
      m = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (m >= n) {
          break;
        }
        localObject1 = localObject3[m];
        if (localObject1 != null) {
          ((Map)localObject2).put(((Thread)localObject1).getName(), localObject1);
        }
        m += 1;
      }
    }
    Object localObject2 = new ArrayList(h.size() / 2);
    Object localObject3 = h.keySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = (String)((Iterator)localObject3).next();
      ProcessStats.Stats localStats = (ProcessStats.Stats)h.get(localObject4);
      if (localStats.f >= paramInt)
      {
        if (paramBoolean) {
          m = 300;
        } else {
          m = 50;
        }
        StringBuilder localStringBuilder = new StringBuilder(m);
        localStringBuilder.append(localStats.a);
        localStringBuilder.append("_");
        localStringBuilder.append((String)localObject4);
        localStringBuilder.append(":");
        localStringBuilder.append(localStats.f);
        localStringBuilder.append("\r\n");
        if (paramBoolean)
        {
          localObject4 = (Thread)((Map)localObject1).get(localStats.a);
          if (localObject4 != null) {
            localStringBuilder.append(Arrays.toString(((Thread)localObject4).getStackTrace()));
          }
          localObject4 = StringUtils.getStringValue(localStringBuilder);
          if (localObject4 != null) {
            ((List)localObject2).add(StringUtils.newStringWithData((char[])localObject4));
          } else {
            ((List)localObject2).add(localStringBuilder.toString());
          }
        }
      }
    }
    if (paramBoolean) {
      ((List)localObject2).add(Arrays.toString(Looper.getMainLooper().getThread().getStackTrace()));
    }
    return localObject2;
  }
  
  public static void a(ProcessStats.Stats paramStats)
  {
    paramStats.recycle();
  }
  
  private static void a(String paramString, ProcessStats.Stats paramStats, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Object[] arrayOfObject = b(paramString);
        paramString = null;
        if (arrayOfObject != null)
        {
          paramString = (String)arrayOfObject[0];
          l1 = ((Long)arrayOfObject[1]).longValue();
          l2 = ((Long)arrayOfObject[2]).longValue();
          if (paramBoolean)
          {
            paramStats.b = l1;
            paramStats.c = l2;
            paramStats.a = paramString;
            return;
          }
          if (paramStats.b == -100L)
          {
            paramStats.d = -100L;
            paramStats.e = -100L;
            return;
          }
          paramStats.d = (l1 - paramStats.b);
          paramStats.e = (l2 - paramStats.c);
          return;
        }
      }
      catch (Exception paramString)
      {
        return;
      }
      long l1 = -100L;
      long l2 = l1;
    }
  }
  
  /* Error */
  public static void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 281	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   3: sipush 1024
    //   6: invokevirtual 285	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   9: astore_3
    //   10: ldc_w 287
    //   13: invokestatic 69	com/tencent/qqperf/tools/ProcessStats:b	(Ljava/lang/String;)[Ljava/lang/Object;
    //   16: astore 4
    //   18: aload 4
    //   20: ifnull +32 -> 52
    //   23: aload 4
    //   25: iconst_1
    //   26: aaload
    //   27: checkcast 73	java/lang/Long
    //   30: invokevirtual 77	java/lang/Long:longValue	()J
    //   33: putstatic 54	com/tencent/qqperf/tools/ProcessStats:j	J
    //   36: aload 4
    //   38: iconst_2
    //   39: aaload
    //   40: checkcast 73	java/lang/Long
    //   43: invokevirtual 77	java/lang/Long:longValue	()J
    //   46: putstatic 56	com/tencent/qqperf/tools/ProcessStats:k	J
    //   49: goto +15 -> 64
    //   52: ldc2_w 70
    //   55: putstatic 54	com/tencent/qqperf/tools/ProcessStats:j	J
    //   58: ldc2_w 70
    //   61: putstatic 56	com/tencent/qqperf/tools/ProcessStats:k	J
    //   64: ldc 89
    //   66: getstatic 43	com/tencent/qqperf/tools/ProcessStats:c	Lcom/tencent/qqperf/tools/ProcessStats$Stats;
    //   69: iconst_1
    //   70: invokestatic 92	com/tencent/qqperf/tools/ProcessStats:a	(Ljava/lang/String;Lcom/tencent/qqperf/tools/ProcessStats$Stats;Z)V
    //   73: iload_0
    //   74: ifeq +128 -> 202
    //   77: getstatic 50	com/tencent/qqperf/tools/ProcessStats:h	Ljava/util/Map;
    //   80: invokeinterface 291 1 0
    //   85: invokeinterface 294 1 0
    //   90: astore 4
    //   92: aload 4
    //   94: invokeinterface 210 1 0
    //   99: ifeq +19 -> 118
    //   102: aload 4
    //   104: invokeinterface 214 1 0
    //   109: checkcast 28	com/tencent/qqperf/tools/ProcessStats$Stats
    //   112: invokestatic 296	com/tencent/qqperf/tools/ProcessStats:a	(Lcom/tencent/qqperf/tools/ProcessStats$Stats;)V
    //   115: goto -23 -> 92
    //   118: getstatic 50	com/tencent/qqperf/tools/ProcessStats:h	Ljava/util/Map;
    //   121: invokeinterface 299 1 0
    //   126: invokestatic 304	android/os/Process:myPid	()I
    //   129: i2l
    //   130: invokestatic 307	com/tencent/qqperf/tools/ProcessStats:a	(J)[Ljava/lang/String;
    //   133: astore 4
    //   135: aload 4
    //   137: ifnull +65 -> 202
    //   140: aload 4
    //   142: arraylength
    //   143: istore_2
    //   144: iconst_0
    //   145: istore_1
    //   146: iload_1
    //   147: iload_2
    //   148: if_icmpge +54 -> 202
    //   151: aload 4
    //   153: iload_1
    //   154: aaload
    //   155: astore 5
    //   157: invokestatic 41	com/tencent/qqperf/tools/ProcessStats:a	()Lcom/tencent/qqperf/tools/ProcessStats$Stats;
    //   160: astore 6
    //   162: aload 5
    //   164: aload 6
    //   166: iconst_1
    //   167: invokestatic 92	com/tencent/qqperf/tools/ProcessStats:a	(Ljava/lang/String;Lcom/tencent/qqperf/tools/ProcessStats$Stats;Z)V
    //   170: getstatic 50	com/tencent/qqperf/tools/ProcessStats:h	Ljava/util/Map;
    //   173: aload 5
    //   175: aload 6
    //   177: invokeinterface 188 3 0
    //   182: pop
    //   183: iload_1
    //   184: iconst_1
    //   185: iadd
    //   186: istore_1
    //   187: goto -41 -> 146
    //   190: astore 4
    //   192: goto +18 -> 210
    //   195: astore 4
    //   197: aload 4
    //   199: invokevirtual 310	java/lang/Exception:printStackTrace	()V
    //   202: invokestatic 281	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   205: aload_3
    //   206: invokevirtual 314	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   209: return
    //   210: invokestatic 281	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   213: aload_3
    //   214: invokevirtual 314	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   217: goto +6 -> 223
    //   220: aload 4
    //   222: athrow
    //   223: goto -3 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	paramBoolean	boolean
    //   145	42	1	m	int
    //   143	6	2	n	int
    //   9	205	3	arrayOfByte	byte[]
    //   16	136	4	localObject1	Object
    //   190	1	4	localObject2	Object
    //   195	26	4	localException	Exception
    //   155	19	5	str	String
    //   160	16	6	localStats	ProcessStats.Stats
    // Exception table:
    //   from	to	target	type
    //   10	18	190	finally
    //   23	49	190	finally
    //   52	64	190	finally
    //   64	73	190	finally
    //   77	92	190	finally
    //   92	115	190	finally
    //   118	135	190	finally
    //   140	144	190	finally
    //   157	183	190	finally
    //   197	202	190	finally
    //   10	18	195	java/lang/Exception
    //   23	49	195	java/lang/Exception
    //   52	64	195	java/lang/Exception
    //   64	73	195	java/lang/Exception
    //   77	92	195	java/lang/Exception
    //   92	115	195	java/lang/Exception
    //   118	135	195	java/lang/Exception
    //   140	144	195	java/lang/Exception
    //   157	183	195	java/lang/Exception
  }
  
  private static final String[] a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/proc/");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("/task");
    localObject = new File(((StringBuilder)localObject).toString());
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory())) {
      return ((File)localObject).list();
    }
    return null;
  }
  
  @SuppressLint({"NewApi"})
  public static final int b()
  {
    if (f == -1) {
      if (Build.VERSION.SDK_INT >= 17) {
        f = Runtime.getRuntime().availableProcessors();
      } else {
        f = c();
      }
    }
    return f;
  }
  
  /* Error */
  public static void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 281	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   3: sipush 1024
    //   6: invokevirtual 285	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   9: astore 5
    //   11: ldc_w 287
    //   14: invokestatic 69	com/tencent/qqperf/tools/ProcessStats:b	(Ljava/lang/String;)[Ljava/lang/Object;
    //   17: astore 6
    //   19: ldc2_w 70
    //   22: lstore_1
    //   23: aload 6
    //   25: ifnull +216 -> 241
    //   28: aload 6
    //   30: iconst_1
    //   31: aaload
    //   32: checkcast 73	java/lang/Long
    //   35: invokevirtual 77	java/lang/Long:longValue	()J
    //   38: lstore_3
    //   39: aload 6
    //   41: iconst_2
    //   42: aaload
    //   43: checkcast 73	java/lang/Long
    //   46: invokevirtual 77	java/lang/Long:longValue	()J
    //   49: lstore_1
    //   50: goto +3 -> 53
    //   53: lload_3
    //   54: lload_1
    //   55: ladd
    //   56: getstatic 56	com/tencent/qqperf/tools/ProcessStats:k	J
    //   59: lsub
    //   60: getstatic 54	com/tencent/qqperf/tools/ProcessStats:j	J
    //   63: lsub
    //   64: lstore_3
    //   65: ldc 89
    //   67: getstatic 43	com/tencent/qqperf/tools/ProcessStats:c	Lcom/tencent/qqperf/tools/ProcessStats$Stats;
    //   70: iconst_0
    //   71: invokestatic 92	com/tencent/qqperf/tools/ProcessStats:a	(Ljava/lang/String;Lcom/tencent/qqperf/tools/ProcessStats$Stats;Z)V
    //   74: iload_0
    //   75: ifeq +89 -> 164
    //   78: getstatic 50	com/tencent/qqperf/tools/ProcessStats:h	Ljava/util/Map;
    //   81: invokeinterface 198 1 0
    //   86: invokeinterface 204 1 0
    //   91: astore 6
    //   93: aload 6
    //   95: invokeinterface 210 1 0
    //   100: ifeq +64 -> 164
    //   103: aload 6
    //   105: invokeinterface 214 1 0
    //   110: checkcast 216	java/lang/String
    //   113: astore 7
    //   115: getstatic 50	com/tencent/qqperf/tools/ProcessStats:h	Ljava/util/Map;
    //   118: aload 7
    //   120: invokeinterface 220 2 0
    //   125: checkcast 28	com/tencent/qqperf/tools/ProcessStats$Stats
    //   128: astore 8
    //   130: aload 7
    //   132: aload 8
    //   134: iconst_0
    //   135: invokestatic 92	com/tencent/qqperf/tools/ProcessStats:a	(Ljava/lang/String;Lcom/tencent/qqperf/tools/ProcessStats$Stats;Z)V
    //   138: aload 8
    //   140: aload 8
    //   142: getfield 274	com/tencent/qqperf/tools/ProcessStats$Stats:e	J
    //   145: aload 8
    //   147: getfield 272	com/tencent/qqperf/tools/ProcessStats$Stats:d	J
    //   150: ladd
    //   151: ldc2_w 348
    //   154: lmul
    //   155: lload_3
    //   156: ldiv
    //   157: l2i
    //   158: putfield 221	com/tencent/qqperf/tools/ProcessStats$Stats:f	I
    //   161: goto -68 -> 93
    //   164: lload_1
    //   165: getstatic 56	com/tencent/qqperf/tools/ProcessStats:k	J
    //   168: lsub
    //   169: ldc2_w 348
    //   172: lmul
    //   173: lload_3
    //   174: ldiv
    //   175: l2i
    //   176: putstatic 38	com/tencent/qqperf/tools/ProcessStats:b	I
    //   179: getstatic 43	com/tencent/qqperf/tools/ProcessStats:c	Lcom/tencent/qqperf/tools/ProcessStats$Stats;
    //   182: getstatic 43	com/tencent/qqperf/tools/ProcessStats:c	Lcom/tencent/qqperf/tools/ProcessStats$Stats;
    //   185: getfield 274	com/tencent/qqperf/tools/ProcessStats$Stats:e	J
    //   188: getstatic 43	com/tencent/qqperf/tools/ProcessStats:c	Lcom/tencent/qqperf/tools/ProcessStats$Stats;
    //   191: getfield 272	com/tencent/qqperf/tools/ProcessStats$Stats:d	J
    //   194: ladd
    //   195: ldc2_w 348
    //   198: lmul
    //   199: lload_3
    //   200: ldiv
    //   201: l2i
    //   202: putfield 221	com/tencent/qqperf/tools/ProcessStats$Stats:f	I
    //   205: invokestatic 354	android/os/SystemClock:uptimeMillis	()J
    //   208: putstatic 36	com/tencent/qqperf/tools/ProcessStats:a	J
    //   211: goto +16 -> 227
    //   214: astore 6
    //   216: invokestatic 281	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   219: aload 5
    //   221: invokevirtual 314	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   224: aload 6
    //   226: athrow
    //   227: invokestatic 281	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   230: aload 5
    //   232: invokevirtual 314	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   235: return
    //   236: astore 6
    //   238: goto -11 -> 227
    //   241: ldc2_w 70
    //   244: lstore_3
    //   245: goto -192 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	paramBoolean	boolean
    //   22	143	1	l1	long
    //   38	207	3	l2	long
    //   9	222	5	arrayOfByte	byte[]
    //   17	87	6	localObject1	Object
    //   214	11	6	localObject2	Object
    //   236	1	6	localException	Exception
    //   113	18	7	str	String
    //   128	18	8	localStats	ProcessStats.Stats
    // Exception table:
    //   from	to	target	type
    //   11	19	214	finally
    //   28	50	214	finally
    //   53	74	214	finally
    //   78	93	214	finally
    //   93	161	214	finally
    //   164	211	214	finally
    //   11	19	236	java/lang/Exception
    //   28	50	236	java/lang/Exception
    //   53	74	236	java/lang/Exception
    //   78	93	236	java/lang/Exception
    //   93	161	236	java/lang/Exception
    //   164	211	236	java/lang/Exception
  }
  
  /* Error */
  public static Object[] b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 357	com/tencent/qqperf/tools/ProcessStats:c	(Ljava/lang/String;)Ljava/io/RandomAccessFile;
    //   4: astore 21
    //   6: invokestatic 281	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   9: sipush 1024
    //   12: invokevirtual 285	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   15: astore 22
    //   17: aload 21
    //   19: lconst_0
    //   20: invokevirtual 363	java/io/RandomAccessFile:seek	(J)V
    //   23: aload 21
    //   25: aload 22
    //   27: invokevirtual 367	java/io/RandomAccessFile:read	([B)I
    //   30: istore 4
    //   32: iconst_0
    //   33: istore_1
    //   34: iconst_0
    //   35: istore_3
    //   36: goto +627 -> 663
    //   39: iload_2
    //   40: istore_1
    //   41: iload_2
    //   42: iload 4
    //   44: if_icmpge +655 -> 699
    //   47: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   50: iload_3
    //   51: iload_2
    //   52: iastore
    //   53: iload_2
    //   54: istore_1
    //   55: goto +644 -> 699
    //   58: iload_1
    //   59: iload 4
    //   61: if_icmpge +660 -> 721
    //   64: getstatic 60	com/tencent/qqperf/tools/ProcessStats:e	[I
    //   67: iload_3
    //   68: iload_1
    //   69: iastore
    //   70: goto +651 -> 721
    //   73: iload_3
    //   74: bipush 17
    //   76: if_icmpne +532 -> 608
    //   79: ldc_w 287
    //   82: aload_0
    //   83: invokevirtual 370	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   86: ifne +213 -> 299
    //   89: new 216	java/lang/String
    //   92: dup
    //   93: aload 22
    //   95: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   98: iconst_1
    //   99: iaload
    //   100: iconst_1
    //   101: iadd
    //   102: getstatic 60	com/tencent/qqperf/tools/ProcessStats:e	[I
    //   105: iconst_1
    //   106: iaload
    //   107: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   110: iconst_1
    //   111: iaload
    //   112: isub
    //   113: iconst_1
    //   114: isub
    //   115: invokespecial 373	java/lang/String:<init>	([BII)V
    //   118: astore 23
    //   120: new 216	java/lang/String
    //   123: dup
    //   124: aload 22
    //   126: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   129: bipush 13
    //   131: iaload
    //   132: getstatic 60	com/tencent/qqperf/tools/ProcessStats:e	[I
    //   135: bipush 13
    //   137: iaload
    //   138: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   141: bipush 13
    //   143: iaload
    //   144: isub
    //   145: invokespecial 373	java/lang/String:<init>	([BII)V
    //   148: invokestatic 376	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   151: lstore 5
    //   153: new 216	java/lang/String
    //   156: dup
    //   157: aload 22
    //   159: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   162: bipush 15
    //   164: iaload
    //   165: getstatic 60	com/tencent/qqperf/tools/ProcessStats:e	[I
    //   168: bipush 15
    //   170: iaload
    //   171: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   174: bipush 15
    //   176: iaload
    //   177: isub
    //   178: invokespecial 373	java/lang/String:<init>	([BII)V
    //   181: invokestatic 376	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   184: lstore 7
    //   186: new 216	java/lang/String
    //   189: dup
    //   190: aload 22
    //   192: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   195: bipush 14
    //   197: iaload
    //   198: getstatic 60	com/tencent/qqperf/tools/ProcessStats:e	[I
    //   201: bipush 14
    //   203: iaload
    //   204: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   207: bipush 14
    //   209: iaload
    //   210: isub
    //   211: invokespecial 373	java/lang/String:<init>	([BII)V
    //   214: invokestatic 376	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   217: lstore 9
    //   219: new 216	java/lang/String
    //   222: dup
    //   223: aload 22
    //   225: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   228: bipush 16
    //   230: iaload
    //   231: getstatic 60	com/tencent/qqperf/tools/ProcessStats:e	[I
    //   234: bipush 16
    //   236: iaload
    //   237: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   240: bipush 16
    //   242: iaload
    //   243: isub
    //   244: invokespecial 373	java/lang/String:<init>	([BII)V
    //   247: invokestatic 376	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   250: lstore 11
    //   252: iconst_3
    //   253: anewarray 4	java/lang/Object
    //   256: astore_0
    //   257: aload_0
    //   258: iconst_0
    //   259: aload 23
    //   261: aastore
    //   262: aload_0
    //   263: iconst_1
    //   264: lload 5
    //   266: lload 7
    //   268: ladd
    //   269: invokestatic 380	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   272: aastore
    //   273: aload_0
    //   274: iconst_2
    //   275: lload 9
    //   277: lload 11
    //   279: ladd
    //   280: invokestatic 380	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   283: aastore
    //   284: invokestatic 281	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   287: aload 22
    //   289: invokevirtual 314	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   292: aload 21
    //   294: invokevirtual 383	java/io/RandomAccessFile:close	()V
    //   297: aload_0
    //   298: areturn
    //   299: new 216	java/lang/String
    //   302: dup
    //   303: aload 22
    //   305: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   308: iconst_4
    //   309: iaload
    //   310: getstatic 60	com/tencent/qqperf/tools/ProcessStats:e	[I
    //   313: iconst_4
    //   314: iaload
    //   315: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   318: iconst_4
    //   319: iaload
    //   320: isub
    //   321: invokespecial 373	java/lang/String:<init>	([BII)V
    //   324: invokestatic 376	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   327: lstore 5
    //   329: new 216	java/lang/String
    //   332: dup
    //   333: aload 22
    //   335: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   338: iconst_1
    //   339: iaload
    //   340: getstatic 60	com/tencent/qqperf/tools/ProcessStats:e	[I
    //   343: iconst_1
    //   344: iaload
    //   345: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   348: iconst_1
    //   349: iaload
    //   350: isub
    //   351: invokespecial 373	java/lang/String:<init>	([BII)V
    //   354: invokestatic 376	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   357: lstore 7
    //   359: new 216	java/lang/String
    //   362: dup
    //   363: aload 22
    //   365: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   368: iconst_2
    //   369: iaload
    //   370: getstatic 60	com/tencent/qqperf/tools/ProcessStats:e	[I
    //   373: iconst_2
    //   374: iaload
    //   375: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   378: iconst_2
    //   379: iaload
    //   380: isub
    //   381: invokespecial 373	java/lang/String:<init>	([BII)V
    //   384: invokestatic 376	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   387: lstore 9
    //   389: new 216	java/lang/String
    //   392: dup
    //   393: aload 22
    //   395: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   398: iconst_3
    //   399: iaload
    //   400: getstatic 60	com/tencent/qqperf/tools/ProcessStats:e	[I
    //   403: iconst_3
    //   404: iaload
    //   405: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   408: iconst_3
    //   409: iaload
    //   410: isub
    //   411: invokespecial 373	java/lang/String:<init>	([BII)V
    //   414: invokestatic 376	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   417: lstore 11
    //   419: new 216	java/lang/String
    //   422: dup
    //   423: aload 22
    //   425: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   428: iconst_5
    //   429: iaload
    //   430: getstatic 60	com/tencent/qqperf/tools/ProcessStats:e	[I
    //   433: iconst_5
    //   434: iaload
    //   435: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   438: iconst_5
    //   439: iaload
    //   440: isub
    //   441: invokespecial 373	java/lang/String:<init>	([BII)V
    //   444: invokestatic 376	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   447: lstore 13
    //   449: new 216	java/lang/String
    //   452: dup
    //   453: aload 22
    //   455: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   458: bipush 6
    //   460: iaload
    //   461: getstatic 60	com/tencent/qqperf/tools/ProcessStats:e	[I
    //   464: bipush 6
    //   466: iaload
    //   467: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   470: bipush 6
    //   472: iaload
    //   473: isub
    //   474: invokespecial 373	java/lang/String:<init>	([BII)V
    //   477: invokestatic 376	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   480: lstore 15
    //   482: new 216	java/lang/String
    //   485: dup
    //   486: aload 22
    //   488: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   491: bipush 7
    //   493: iaload
    //   494: getstatic 60	com/tencent/qqperf/tools/ProcessStats:e	[I
    //   497: bipush 7
    //   499: iaload
    //   500: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   503: bipush 7
    //   505: iaload
    //   506: isub
    //   507: invokespecial 373	java/lang/String:<init>	([BII)V
    //   510: invokestatic 376	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   513: lstore 17
    //   515: new 216	java/lang/String
    //   518: dup
    //   519: aload 22
    //   521: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   524: bipush 8
    //   526: iaload
    //   527: getstatic 60	com/tencent/qqperf/tools/ProcessStats:e	[I
    //   530: bipush 8
    //   532: iaload
    //   533: getstatic 58	com/tencent/qqperf/tools/ProcessStats:d	[I
    //   536: bipush 8
    //   538: iaload
    //   539: isub
    //   540: invokespecial 373	java/lang/String:<init>	([BII)V
    //   543: invokestatic 376	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   546: lstore 19
    //   548: iconst_3
    //   549: anewarray 4	java/lang/Object
    //   552: astore_0
    //   553: aload_0
    //   554: iconst_0
    //   555: ldc_w 385
    //   558: aastore
    //   559: aload_0
    //   560: iconst_1
    //   561: lload 5
    //   563: invokestatic 380	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   566: aastore
    //   567: aload_0
    //   568: iconst_2
    //   569: lload 7
    //   571: lload 9
    //   573: ladd
    //   574: lload 11
    //   576: ladd
    //   577: lload 13
    //   579: ladd
    //   580: lload 15
    //   582: ladd
    //   583: lload 17
    //   585: ladd
    //   586: lload 19
    //   588: ladd
    //   589: invokestatic 380	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   592: aastore
    //   593: invokestatic 281	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   596: aload 22
    //   598: invokevirtual 314	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   601: aload 21
    //   603: invokevirtual 383	java/io/RandomAccessFile:close	()V
    //   606: aload_0
    //   607: areturn
    //   608: invokestatic 281	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   611: aload 22
    //   613: invokevirtual 314	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   616: aload 21
    //   618: invokevirtual 383	java/io/RandomAccessFile:close	()V
    //   621: goto +19 -> 640
    //   624: astore_0
    //   625: invokestatic 281	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   628: aload 22
    //   630: invokevirtual 314	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   633: aload 21
    //   635: invokevirtual 383	java/io/RandomAccessFile:close	()V
    //   638: aload_0
    //   639: athrow
    //   640: aconst_null
    //   641: areturn
    //   642: astore_0
    //   643: goto -35 -> 608
    //   646: astore 21
    //   648: aload_0
    //   649: areturn
    //   650: astore 21
    //   652: aload_0
    //   653: areturn
    //   654: astore_0
    //   655: goto -15 -> 640
    //   658: astore 21
    //   660: goto -22 -> 638
    //   663: iload_1
    //   664: iload 4
    //   666: if_icmpge -593 -> 73
    //   669: iload_3
    //   670: bipush 17
    //   672: if_icmpge -599 -> 73
    //   675: iload_1
    //   676: istore_2
    //   677: iload_2
    //   678: iload 4
    //   680: if_icmpge -641 -> 39
    //   683: aload 22
    //   685: iload_2
    //   686: baload
    //   687: bipush 32
    //   689: if_icmpne -650 -> 39
    //   692: iload_2
    //   693: iconst_1
    //   694: iadd
    //   695: istore_2
    //   696: goto -19 -> 677
    //   699: iload_1
    //   700: iload 4
    //   702: if_icmpge -644 -> 58
    //   705: aload 22
    //   707: iload_1
    //   708: baload
    //   709: bipush 32
    //   711: if_icmpeq -653 -> 58
    //   714: iload_1
    //   715: iconst_1
    //   716: iadd
    //   717: istore_1
    //   718: goto -19 -> 699
    //   721: iload_3
    //   722: iconst_1
    //   723: iadd
    //   724: istore_3
    //   725: goto -62 -> 663
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	728	0	paramString	String
    //   33	685	1	m	int
    //   39	657	2	n	int
    //   35	690	3	i1	int
    //   30	673	4	i2	int
    //   151	411	5	l1	long
    //   184	386	7	l2	long
    //   217	355	9	l3	long
    //   250	325	11	l4	long
    //   447	131	13	l5	long
    //   480	101	15	l6	long
    //   513	71	17	l7	long
    //   546	41	19	l8	long
    //   4	630	21	localRandomAccessFile	RandomAccessFile
    //   646	1	21	localException1	Exception
    //   650	1	21	localException2	Exception
    //   658	1	21	localException3	Exception
    //   15	691	22	arrayOfByte	byte[]
    //   118	142	23	str	String
    // Exception table:
    //   from	to	target	type
    //   17	32	624	finally
    //   47	53	624	finally
    //   64	70	624	finally
    //   79	257	624	finally
    //   262	284	624	finally
    //   299	553	624	finally
    //   559	593	624	finally
    //   17	32	642	java/lang/Exception
    //   47	53	642	java/lang/Exception
    //   64	70	642	java/lang/Exception
    //   79	257	642	java/lang/Exception
    //   262	284	642	java/lang/Exception
    //   299	553	642	java/lang/Exception
    //   559	593	642	java/lang/Exception
    //   292	297	646	java/lang/Exception
    //   601	606	650	java/lang/Exception
    //   616	621	654	java/lang/Exception
    //   633	638	658	java/lang/Exception
  }
  
  private static final int c()
  {
    try
    {
      int m = new File("/sys/devices/system/cpu/").listFiles(new ProcessStats.1CpuFilter()).length;
      return m;
    }
    catch (Exception localException)
    {
      label24:
      break label24;
    }
    return 1;
  }
  
  private static final RandomAccessFile c(String paramString)
  {
    try
    {
      boolean bool = paramString.equals("-2");
      if (bool) {
        return new RandomAccessFile("/proc/stat", "r");
      }
      bool = paramString.equals("-1");
      if (bool)
      {
        paramString = new StringBuilder();
        paramString.append("/proc/");
        paramString.append(Process.myPid());
        paramString.append("/stat");
        return new RandomAccessFile(paramString.toString(), "r");
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/proc/");
      localStringBuilder.append(Process.myPid());
      localStringBuilder.append("/task/");
      localStringBuilder.append(paramString);
      localStringBuilder.append("/stat");
      paramString = new RandomAccessFile(localStringBuilder.toString(), "r");
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.tools.ProcessStats
 * JD-Core Version:    0.7.0.1
 */