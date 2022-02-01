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
  public static int a;
  public static long a;
  private static final RecyclablePool jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(ProcessStats.Stats.class, 30);
  public static ProcessStats.Stats a;
  private static Map<String, ProcessStats.Stats> jdField_a_of_type_JavaUtilMap;
  static int[] jdField_a_of_type_ArrayOfInt;
  public static int b;
  private static long jdField_b_of_type_Long;
  static int[] jdField_b_of_type_ArrayOfInt;
  private static int jdField_c_of_type_Int;
  private static long jdField_c_of_type_Long;
  
  static
  {
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_ComTencentQqperfToolsProcessStats$Stats = a();
    jdField_a_of_type_JavaUtilMap = new HashMap(30);
    jdField_c_of_type_Int = 0;
    jdField_b_of_type_Long = 0L;
    jdField_c_of_type_Long = 0L;
    jdField_a_of_type_ArrayOfInt = new int[17];
    jdField_b_of_type_ArrayOfInt = new int[17];
    jdField_b_of_type_Int = -1;
  }
  
  @SuppressLint({"NewApi"})
  public static final int a()
  {
    if (jdField_b_of_type_Int == -1) {
      if (Build.VERSION.SDK_INT >= 17) {
        jdField_b_of_type_Int = Runtime.getRuntime().availableProcessors();
      } else {
        jdField_b_of_type_Int = b();
      }
    }
    return jdField_b_of_type_Int;
  }
  
  public static long a(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return -1L;
    }
    return ((Long)paramString[1]).longValue() + ((Long)paramString[2]).longValue();
  }
  
  public static ProcessStats.Stats a()
  {
    return (ProcessStats.Stats)jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.obtain(ProcessStats.Stats.class);
  }
  
  private static final RandomAccessFile a(String paramString)
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
  
  /* Error */
  public static final String a(int paramInt)
  {
    // Byte code:
    //   0: new 120	java/lang/StringBuilder
    //   3: dup
    //   4: iload_0
    //   5: bipush 110
    //   7: imul
    //   8: invokespecial 151	java/lang/StringBuilder:<init>	(I)V
    //   11: astore_1
    //   12: ldc 118
    //   14: getstatic 35	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ComTencentQqperfToolsProcessStats$Stats	Lcom/tencent/qqperf/tools/ProcessStats$Stats;
    //   17: iconst_0
    //   18: invokestatic 154	com/tencent/qqperf/tools/ProcessStats:a	(Ljava/lang/String;Lcom/tencent/qqperf/tools/ProcessStats$Stats;Z)V
    //   21: new 120	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   28: astore_2
    //   29: aload_2
    //   30: ldc 156
    //   32: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_2
    //   37: getstatic 35	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ComTencentQqperfToolsProcessStats$Stats	Lcom/tencent/qqperf/tools/ProcessStats$Stats;
    //   40: getfield 157	com/tencent/qqperf/tools/ProcessStats$Stats:jdField_a_of_type_Long	J
    //   43: invokevirtual 160	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_2
    //   48: ldc 162
    //   50: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_2
    //   55: getstatic 35	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ComTencentQqperfToolsProcessStats$Stats	Lcom/tencent/qqperf/tools/ProcessStats$Stats;
    //   58: getfield 163	com/tencent/qqperf/tools/ProcessStats$Stats:jdField_b_of_type_Long	J
    //   61: invokevirtual 160	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: ldc 165
    //   67: aload_2
    //   68: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 171	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   74: pop
    //   75: invokestatic 72	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   78: astore_2
    //   79: new 120	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   86: astore_3
    //   87: aload_3
    //   88: ldc 173
    //   90: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_3
    //   95: iload_0
    //   96: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_3
    //   101: ldc 175
    //   103: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: new 177	java/io/BufferedReader
    //   110: dup
    //   111: new 179	java/io/InputStreamReader
    //   114: dup
    //   115: aload_2
    //   116: aload_3
    //   117: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokevirtual 183	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   123: invokevirtual 189	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   126: invokespecial 192	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   129: invokespecial 195	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   132: astore_2
    //   133: aload_2
    //   134: invokevirtual 198	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   137: astore_3
    //   138: aload_3
    //   139: ifnull +19 -> 158
    //   142: aload_1
    //   143: aload_3
    //   144: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_1
    //   149: ldc 200
    //   151: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: goto -22 -> 133
    //   158: ldc 118
    //   160: getstatic 35	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ComTencentQqperfToolsProcessStats$Stats	Lcom/tencent/qqperf/tools/ProcessStats$Stats;
    //   163: iconst_0
    //   164: invokestatic 154	com/tencent/qqperf/tools/ProcessStats:a	(Ljava/lang/String;Lcom/tencent/qqperf/tools/ProcessStats$Stats;Z)V
    //   167: new 120	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   174: astore_2
    //   175: aload_2
    //   176: ldc 156
    //   178: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload_2
    //   183: getstatic 35	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ComTencentQqperfToolsProcessStats$Stats	Lcom/tencent/qqperf/tools/ProcessStats$Stats;
    //   186: getfield 157	com/tencent/qqperf/tools/ProcessStats$Stats:jdField_a_of_type_Long	J
    //   189: invokevirtual 160	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_2
    //   194: ldc 162
    //   196: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload_2
    //   201: getstatic 35	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ComTencentQqperfToolsProcessStats$Stats	Lcom/tencent/qqperf/tools/ProcessStats$Stats;
    //   204: getfield 163	com/tencent/qqperf/tools/ProcessStats$Stats:jdField_b_of_type_Long	J
    //   207: invokevirtual 160	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: ldc 165
    //   213: aload_2
    //   214: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 171	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   220: pop
    //   221: aload_1
    //   222: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    int i;
    if (paramBoolean)
    {
      localObject1 = Thread.currentThread().getThreadGroup();
      localObject3 = new Thread[((ThreadGroup)localObject1).activeCount()];
      ((ThreadGroup)localObject1).enumerate((Thread[])localObject3);
      localObject2 = new HashMap(localObject3.length);
      int j = localObject3.length;
      i = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= j) {
          break;
        }
        localObject1 = localObject3[i];
        if (localObject1 != null) {
          ((Map)localObject2).put(((Thread)localObject1).getName(), localObject1);
        }
        i += 1;
      }
    }
    Object localObject2 = new ArrayList(jdField_a_of_type_JavaUtilMap.size() / 2);
    Object localObject3 = jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = (String)((Iterator)localObject3).next();
      ProcessStats.Stats localStats = (ProcessStats.Stats)jdField_a_of_type_JavaUtilMap.get(localObject4);
      if (localStats.jdField_a_of_type_Int >= paramInt)
      {
        if (paramBoolean) {
          i = 300;
        } else {
          i = 50;
        }
        StringBuilder localStringBuilder = new StringBuilder(i);
        localStringBuilder.append(localStats.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("_");
        localStringBuilder.append((String)localObject4);
        localStringBuilder.append(":");
        localStringBuilder.append(localStats.jdField_a_of_type_Int);
        localStringBuilder.append("\r\n");
        if (paramBoolean)
        {
          localObject4 = (Thread)((Map)localObject1).get(localStats.jdField_a_of_type_JavaLangString);
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
        Object[] arrayOfObject = a(paramString);
        paramString = null;
        if (arrayOfObject != null)
        {
          paramString = (String)arrayOfObject[0];
          l1 = ((Long)arrayOfObject[1]).longValue();
          l2 = ((Long)arrayOfObject[2]).longValue();
          if (paramBoolean)
          {
            paramStats.jdField_a_of_type_Long = l1;
            paramStats.jdField_b_of_type_Long = l2;
            paramStats.jdField_a_of_type_JavaLangString = paramString;
            return;
          }
          if (paramStats.jdField_a_of_type_Long == -100L)
          {
            paramStats.jdField_c_of_type_Long = -100L;
            paramStats.d = -100L;
            return;
          }
          paramStats.jdField_c_of_type_Long = (l1 - paramStats.jdField_a_of_type_Long);
          paramStats.d = (l2 - paramStats.jdField_b_of_type_Long);
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
    //   0: invokestatic 319	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   3: sipush 1024
    //   6: invokevirtual 323	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   9: astore_3
    //   10: ldc 101
    //   12: invokestatic 82	com/tencent/qqperf/tools/ProcessStats:a	(Ljava/lang/String;)[Ljava/lang/Object;
    //   15: astore 4
    //   17: aload 4
    //   19: ifnull +32 -> 51
    //   22: aload 4
    //   24: iconst_1
    //   25: aaload
    //   26: checkcast 86	java/lang/Long
    //   29: invokevirtual 90	java/lang/Long:longValue	()J
    //   32: putstatic 46	com/tencent/qqperf/tools/ProcessStats:jdField_b_of_type_Long	J
    //   35: aload 4
    //   37: iconst_2
    //   38: aaload
    //   39: checkcast 86	java/lang/Long
    //   42: invokevirtual 90	java/lang/Long:longValue	()J
    //   45: putstatic 48	com/tencent/qqperf/tools/ProcessStats:jdField_c_of_type_Long	J
    //   48: goto +15 -> 63
    //   51: ldc2_w 83
    //   54: putstatic 46	com/tencent/qqperf/tools/ProcessStats:jdField_b_of_type_Long	J
    //   57: ldc2_w 83
    //   60: putstatic 48	com/tencent/qqperf/tools/ProcessStats:jdField_c_of_type_Long	J
    //   63: ldc 118
    //   65: getstatic 35	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ComTencentQqperfToolsProcessStats$Stats	Lcom/tencent/qqperf/tools/ProcessStats$Stats;
    //   68: iconst_1
    //   69: invokestatic 154	com/tencent/qqperf/tools/ProcessStats:a	(Ljava/lang/String;Lcom/tencent/qqperf/tools/ProcessStats$Stats;Z)V
    //   72: iload_0
    //   73: ifeq +128 -> 201
    //   76: getstatic 42	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   79: invokeinterface 327 1 0
    //   84: invokeinterface 330 1 0
    //   89: astore 4
    //   91: aload 4
    //   93: invokeinterface 252 1 0
    //   98: ifeq +19 -> 117
    //   101: aload 4
    //   103: invokeinterface 256 1 0
    //   108: checkcast 20	com/tencent/qqperf/tools/ProcessStats$Stats
    //   111: invokestatic 332	com/tencent/qqperf/tools/ProcessStats:a	(Lcom/tencent/qqperf/tools/ProcessStats$Stats;)V
    //   114: goto -23 -> 91
    //   117: getstatic 42	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   120: invokeinterface 335 1 0
    //   125: invokestatic 132	android/os/Process:myPid	()I
    //   128: i2l
    //   129: invokestatic 338	com/tencent/qqperf/tools/ProcessStats:a	(J)[Ljava/lang/String;
    //   132: astore 4
    //   134: aload 4
    //   136: ifnull +65 -> 201
    //   139: aload 4
    //   141: arraylength
    //   142: istore_2
    //   143: iconst_0
    //   144: istore_1
    //   145: iload_1
    //   146: iload_2
    //   147: if_icmpge +54 -> 201
    //   150: aload 4
    //   152: iload_1
    //   153: aaload
    //   154: astore 5
    //   156: invokestatic 33	com/tencent/qqperf/tools/ProcessStats:a	()Lcom/tencent/qqperf/tools/ProcessStats$Stats;
    //   159: astore 6
    //   161: aload 5
    //   163: aload 6
    //   165: iconst_1
    //   166: invokestatic 154	com/tencent/qqperf/tools/ProcessStats:a	(Ljava/lang/String;Lcom/tencent/qqperf/tools/ProcessStats$Stats;Z)V
    //   169: getstatic 42	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   172: aload 5
    //   174: aload 6
    //   176: invokeinterface 230 3 0
    //   181: pop
    //   182: iload_1
    //   183: iconst_1
    //   184: iadd
    //   185: istore_1
    //   186: goto -41 -> 145
    //   189: astore 4
    //   191: goto +18 -> 209
    //   194: astore 4
    //   196: aload 4
    //   198: invokevirtual 339	java/lang/Exception:printStackTrace	()V
    //   201: invokestatic 319	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   204: aload_3
    //   205: invokevirtual 343	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   208: return
    //   209: invokestatic 319	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   212: aload_3
    //   213: invokevirtual 343	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   216: goto +6 -> 222
    //   219: aload 4
    //   221: athrow
    //   222: goto -3 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	paramBoolean	boolean
    //   144	42	1	i	int
    //   142	6	2	j	int
    //   9	204	3	arrayOfByte	byte[]
    //   15	136	4	localObject1	Object
    //   189	1	4	localObject2	Object
    //   194	26	4	localException	Exception
    //   154	19	5	str	String
    //   159	16	6	localStats	ProcessStats.Stats
    // Exception table:
    //   from	to	target	type
    //   10	17	189	finally
    //   22	48	189	finally
    //   51	63	189	finally
    //   63	72	189	finally
    //   76	91	189	finally
    //   91	114	189	finally
    //   117	134	189	finally
    //   139	143	189	finally
    //   156	182	189	finally
    //   196	201	189	finally
    //   10	17	194	java/lang/Exception
    //   22	48	194	java/lang/Exception
    //   51	63	194	java/lang/Exception
    //   63	72	194	java/lang/Exception
    //   76	91	194	java/lang/Exception
    //   91	114	194	java/lang/Exception
    //   117	134	194	java/lang/Exception
    //   139	143	194	java/lang/Exception
    //   156	182	194	java/lang/Exception
  }
  
  /* Error */
  public static Object[] a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 345	com/tencent/qqperf/tools/ProcessStats:a	(Ljava/lang/String;)Ljava/io/RandomAccessFile;
    //   4: astore 21
    //   6: invokestatic 319	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   9: sipush 1024
    //   12: invokevirtual 323	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   15: astore 22
    //   17: aload 21
    //   19: lconst_0
    //   20: invokevirtual 349	java/io/RandomAccessFile:seek	(J)V
    //   23: aload 21
    //   25: aload 22
    //   27: invokevirtual 353	java/io/RandomAccessFile:read	([B)I
    //   30: istore 4
    //   32: iconst_0
    //   33: istore_1
    //   34: iconst_0
    //   35: istore_3
    //   36: goto +626 -> 662
    //   39: iload_2
    //   40: istore_1
    //   41: iload_2
    //   42: iload 4
    //   44: if_icmpge +654 -> 698
    //   47: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   50: iload_3
    //   51: iload_2
    //   52: iastore
    //   53: iload_2
    //   54: istore_1
    //   55: goto +643 -> 698
    //   58: iload_1
    //   59: iload 4
    //   61: if_icmpge +659 -> 720
    //   64: getstatic 52	com/tencent/qqperf/tools/ProcessStats:jdField_b_of_type_ArrayOfInt	[I
    //   67: iload_3
    //   68: iload_1
    //   69: iastore
    //   70: goto +650 -> 720
    //   73: iload_3
    //   74: bipush 17
    //   76: if_icmpne +531 -> 607
    //   79: ldc 101
    //   81: aload_0
    //   82: invokevirtual 107	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: ifne +213 -> 298
    //   88: new 103	java/lang/String
    //   91: dup
    //   92: aload 22
    //   94: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   97: iconst_1
    //   98: iaload
    //   99: iconst_1
    //   100: iadd
    //   101: getstatic 52	com/tencent/qqperf/tools/ProcessStats:jdField_b_of_type_ArrayOfInt	[I
    //   104: iconst_1
    //   105: iaload
    //   106: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   109: iconst_1
    //   110: iaload
    //   111: isub
    //   112: iconst_1
    //   113: isub
    //   114: invokespecial 356	java/lang/String:<init>	([BII)V
    //   117: astore 23
    //   119: new 103	java/lang/String
    //   122: dup
    //   123: aload 22
    //   125: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   128: bipush 13
    //   130: iaload
    //   131: getstatic 52	com/tencent/qqperf/tools/ProcessStats:jdField_b_of_type_ArrayOfInt	[I
    //   134: bipush 13
    //   136: iaload
    //   137: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   140: bipush 13
    //   142: iaload
    //   143: isub
    //   144: invokespecial 356	java/lang/String:<init>	([BII)V
    //   147: invokestatic 359	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   150: lstore 5
    //   152: new 103	java/lang/String
    //   155: dup
    //   156: aload 22
    //   158: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   161: bipush 15
    //   163: iaload
    //   164: getstatic 52	com/tencent/qqperf/tools/ProcessStats:jdField_b_of_type_ArrayOfInt	[I
    //   167: bipush 15
    //   169: iaload
    //   170: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   173: bipush 15
    //   175: iaload
    //   176: isub
    //   177: invokespecial 356	java/lang/String:<init>	([BII)V
    //   180: invokestatic 359	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   183: lstore 7
    //   185: new 103	java/lang/String
    //   188: dup
    //   189: aload 22
    //   191: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   194: bipush 14
    //   196: iaload
    //   197: getstatic 52	com/tencent/qqperf/tools/ProcessStats:jdField_b_of_type_ArrayOfInt	[I
    //   200: bipush 14
    //   202: iaload
    //   203: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   206: bipush 14
    //   208: iaload
    //   209: isub
    //   210: invokespecial 356	java/lang/String:<init>	([BII)V
    //   213: invokestatic 359	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   216: lstore 9
    //   218: new 103	java/lang/String
    //   221: dup
    //   222: aload 22
    //   224: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   227: bipush 16
    //   229: iaload
    //   230: getstatic 52	com/tencent/qqperf/tools/ProcessStats:jdField_b_of_type_ArrayOfInt	[I
    //   233: bipush 16
    //   235: iaload
    //   236: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   239: bipush 16
    //   241: iaload
    //   242: isub
    //   243: invokespecial 356	java/lang/String:<init>	([BII)V
    //   246: invokestatic 359	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   249: lstore 11
    //   251: iconst_3
    //   252: anewarray 4	java/lang/Object
    //   255: astore_0
    //   256: aload_0
    //   257: iconst_0
    //   258: aload 23
    //   260: aastore
    //   261: aload_0
    //   262: iconst_1
    //   263: lload 5
    //   265: lload 7
    //   267: ladd
    //   268: invokestatic 363	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   271: aastore
    //   272: aload_0
    //   273: iconst_2
    //   274: lload 9
    //   276: lload 11
    //   278: ladd
    //   279: invokestatic 363	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   282: aastore
    //   283: invokestatic 319	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   286: aload 22
    //   288: invokevirtual 343	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   291: aload 21
    //   293: invokevirtual 366	java/io/RandomAccessFile:close	()V
    //   296: aload_0
    //   297: areturn
    //   298: new 103	java/lang/String
    //   301: dup
    //   302: aload 22
    //   304: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   307: iconst_4
    //   308: iaload
    //   309: getstatic 52	com/tencent/qqperf/tools/ProcessStats:jdField_b_of_type_ArrayOfInt	[I
    //   312: iconst_4
    //   313: iaload
    //   314: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   317: iconst_4
    //   318: iaload
    //   319: isub
    //   320: invokespecial 356	java/lang/String:<init>	([BII)V
    //   323: invokestatic 359	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   326: lstore 5
    //   328: new 103	java/lang/String
    //   331: dup
    //   332: aload 22
    //   334: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   337: iconst_1
    //   338: iaload
    //   339: getstatic 52	com/tencent/qqperf/tools/ProcessStats:jdField_b_of_type_ArrayOfInt	[I
    //   342: iconst_1
    //   343: iaload
    //   344: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   347: iconst_1
    //   348: iaload
    //   349: isub
    //   350: invokespecial 356	java/lang/String:<init>	([BII)V
    //   353: invokestatic 359	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   356: lstore 7
    //   358: new 103	java/lang/String
    //   361: dup
    //   362: aload 22
    //   364: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   367: iconst_2
    //   368: iaload
    //   369: getstatic 52	com/tencent/qqperf/tools/ProcessStats:jdField_b_of_type_ArrayOfInt	[I
    //   372: iconst_2
    //   373: iaload
    //   374: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   377: iconst_2
    //   378: iaload
    //   379: isub
    //   380: invokespecial 356	java/lang/String:<init>	([BII)V
    //   383: invokestatic 359	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   386: lstore 9
    //   388: new 103	java/lang/String
    //   391: dup
    //   392: aload 22
    //   394: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   397: iconst_3
    //   398: iaload
    //   399: getstatic 52	com/tencent/qqperf/tools/ProcessStats:jdField_b_of_type_ArrayOfInt	[I
    //   402: iconst_3
    //   403: iaload
    //   404: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   407: iconst_3
    //   408: iaload
    //   409: isub
    //   410: invokespecial 356	java/lang/String:<init>	([BII)V
    //   413: invokestatic 359	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   416: lstore 11
    //   418: new 103	java/lang/String
    //   421: dup
    //   422: aload 22
    //   424: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   427: iconst_5
    //   428: iaload
    //   429: getstatic 52	com/tencent/qqperf/tools/ProcessStats:jdField_b_of_type_ArrayOfInt	[I
    //   432: iconst_5
    //   433: iaload
    //   434: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   437: iconst_5
    //   438: iaload
    //   439: isub
    //   440: invokespecial 356	java/lang/String:<init>	([BII)V
    //   443: invokestatic 359	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   446: lstore 13
    //   448: new 103	java/lang/String
    //   451: dup
    //   452: aload 22
    //   454: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   457: bipush 6
    //   459: iaload
    //   460: getstatic 52	com/tencent/qqperf/tools/ProcessStats:jdField_b_of_type_ArrayOfInt	[I
    //   463: bipush 6
    //   465: iaload
    //   466: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   469: bipush 6
    //   471: iaload
    //   472: isub
    //   473: invokespecial 356	java/lang/String:<init>	([BII)V
    //   476: invokestatic 359	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   479: lstore 15
    //   481: new 103	java/lang/String
    //   484: dup
    //   485: aload 22
    //   487: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   490: bipush 7
    //   492: iaload
    //   493: getstatic 52	com/tencent/qqperf/tools/ProcessStats:jdField_b_of_type_ArrayOfInt	[I
    //   496: bipush 7
    //   498: iaload
    //   499: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   502: bipush 7
    //   504: iaload
    //   505: isub
    //   506: invokespecial 356	java/lang/String:<init>	([BII)V
    //   509: invokestatic 359	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   512: lstore 17
    //   514: new 103	java/lang/String
    //   517: dup
    //   518: aload 22
    //   520: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   523: bipush 8
    //   525: iaload
    //   526: getstatic 52	com/tencent/qqperf/tools/ProcessStats:jdField_b_of_type_ArrayOfInt	[I
    //   529: bipush 8
    //   531: iaload
    //   532: getstatic 50	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ArrayOfInt	[I
    //   535: bipush 8
    //   537: iaload
    //   538: isub
    //   539: invokespecial 356	java/lang/String:<init>	([BII)V
    //   542: invokestatic 359	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   545: lstore 19
    //   547: iconst_3
    //   548: anewarray 4	java/lang/Object
    //   551: astore_0
    //   552: aload_0
    //   553: iconst_0
    //   554: ldc_w 368
    //   557: aastore
    //   558: aload_0
    //   559: iconst_1
    //   560: lload 5
    //   562: invokestatic 363	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   565: aastore
    //   566: aload_0
    //   567: iconst_2
    //   568: lload 7
    //   570: lload 9
    //   572: ladd
    //   573: lload 11
    //   575: ladd
    //   576: lload 13
    //   578: ladd
    //   579: lload 15
    //   581: ladd
    //   582: lload 17
    //   584: ladd
    //   585: lload 19
    //   587: ladd
    //   588: invokestatic 363	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   591: aastore
    //   592: invokestatic 319	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   595: aload 22
    //   597: invokevirtual 343	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   600: aload 21
    //   602: invokevirtual 366	java/io/RandomAccessFile:close	()V
    //   605: aload_0
    //   606: areturn
    //   607: invokestatic 319	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   610: aload 22
    //   612: invokevirtual 343	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   615: aload 21
    //   617: invokevirtual 366	java/io/RandomAccessFile:close	()V
    //   620: goto +19 -> 639
    //   623: astore_0
    //   624: invokestatic 319	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   627: aload 22
    //   629: invokevirtual 343	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   632: aload 21
    //   634: invokevirtual 366	java/io/RandomAccessFile:close	()V
    //   637: aload_0
    //   638: athrow
    //   639: aconst_null
    //   640: areturn
    //   641: astore_0
    //   642: goto -35 -> 607
    //   645: astore 21
    //   647: aload_0
    //   648: areturn
    //   649: astore 21
    //   651: aload_0
    //   652: areturn
    //   653: astore_0
    //   654: goto -15 -> 639
    //   657: astore 21
    //   659: goto -22 -> 637
    //   662: iload_1
    //   663: iload 4
    //   665: if_icmpge -592 -> 73
    //   668: iload_3
    //   669: bipush 17
    //   671: if_icmpge -598 -> 73
    //   674: iload_1
    //   675: istore_2
    //   676: iload_2
    //   677: iload 4
    //   679: if_icmpge -640 -> 39
    //   682: aload 22
    //   684: iload_2
    //   685: baload
    //   686: bipush 32
    //   688: if_icmpne -649 -> 39
    //   691: iload_2
    //   692: iconst_1
    //   693: iadd
    //   694: istore_2
    //   695: goto -19 -> 676
    //   698: iload_1
    //   699: iload 4
    //   701: if_icmpge -643 -> 58
    //   704: aload 22
    //   706: iload_1
    //   707: baload
    //   708: bipush 32
    //   710: if_icmpeq -652 -> 58
    //   713: iload_1
    //   714: iconst_1
    //   715: iadd
    //   716: istore_1
    //   717: goto -19 -> 698
    //   720: iload_3
    //   721: iconst_1
    //   722: iadd
    //   723: istore_3
    //   724: goto -62 -> 662
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	727	0	paramString	String
    //   33	684	1	i	int
    //   39	656	2	j	int
    //   35	689	3	k	int
    //   30	672	4	m	int
    //   150	411	5	l1	long
    //   183	386	7	l2	long
    //   216	355	9	l3	long
    //   249	325	11	l4	long
    //   446	131	13	l5	long
    //   479	101	15	l6	long
    //   512	71	17	l7	long
    //   545	41	19	l8	long
    //   4	629	21	localRandomAccessFile	RandomAccessFile
    //   645	1	21	localException1	Exception
    //   649	1	21	localException2	Exception
    //   657	1	21	localException3	Exception
    //   15	690	22	arrayOfByte	byte[]
    //   117	142	23	str	String
    // Exception table:
    //   from	to	target	type
    //   17	32	623	finally
    //   47	53	623	finally
    //   64	70	623	finally
    //   79	256	623	finally
    //   261	283	623	finally
    //   298	552	623	finally
    //   558	592	623	finally
    //   17	32	641	java/lang/Exception
    //   47	53	641	java/lang/Exception
    //   64	70	641	java/lang/Exception
    //   79	256	641	java/lang/Exception
    //   261	283	641	java/lang/Exception
    //   298	552	641	java/lang/Exception
    //   558	592	641	java/lang/Exception
    //   291	296	645	java/lang/Exception
    //   600	605	649	java/lang/Exception
    //   615	620	653	java/lang/Exception
    //   632	637	657	java/lang/Exception
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
  
  private static final int b()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new ProcessStats.1CpuFilter()).length;
      return i;
    }
    catch (Exception localException)
    {
      label24:
      break label24;
    }
    return 1;
  }
  
  /* Error */
  public static void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 319	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   3: sipush 1024
    //   6: invokevirtual 323	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   9: astore 5
    //   11: ldc 101
    //   13: invokestatic 82	com/tencent/qqperf/tools/ProcessStats:a	(Ljava/lang/String;)[Ljava/lang/Object;
    //   16: astore 6
    //   18: ldc2_w 83
    //   21: lstore_1
    //   22: aload 6
    //   24: ifnull +216 -> 240
    //   27: aload 6
    //   29: iconst_1
    //   30: aaload
    //   31: checkcast 86	java/lang/Long
    //   34: invokevirtual 90	java/lang/Long:longValue	()J
    //   37: lstore_3
    //   38: aload 6
    //   40: iconst_2
    //   41: aaload
    //   42: checkcast 86	java/lang/Long
    //   45: invokevirtual 90	java/lang/Long:longValue	()J
    //   48: lstore_1
    //   49: goto +3 -> 52
    //   52: lload_3
    //   53: lload_1
    //   54: ladd
    //   55: getstatic 48	com/tencent/qqperf/tools/ProcessStats:jdField_c_of_type_Long	J
    //   58: lsub
    //   59: getstatic 46	com/tencent/qqperf/tools/ProcessStats:jdField_b_of_type_Long	J
    //   62: lsub
    //   63: lstore_3
    //   64: ldc 118
    //   66: getstatic 35	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ComTencentQqperfToolsProcessStats$Stats	Lcom/tencent/qqperf/tools/ProcessStats$Stats;
    //   69: iconst_0
    //   70: invokestatic 154	com/tencent/qqperf/tools/ProcessStats:a	(Ljava/lang/String;Lcom/tencent/qqperf/tools/ProcessStats$Stats;Z)V
    //   73: iload_0
    //   74: ifeq +89 -> 163
    //   77: getstatic 42	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   80: invokeinterface 240 1 0
    //   85: invokeinterface 246 1 0
    //   90: astore 6
    //   92: aload 6
    //   94: invokeinterface 252 1 0
    //   99: ifeq +64 -> 163
    //   102: aload 6
    //   104: invokeinterface 256 1 0
    //   109: checkcast 103	java/lang/String
    //   112: astore 7
    //   114: getstatic 42	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   117: aload 7
    //   119: invokeinterface 260 2 0
    //   124: checkcast 20	com/tencent/qqperf/tools/ProcessStats$Stats
    //   127: astore 8
    //   129: aload 7
    //   131: aload 8
    //   133: iconst_0
    //   134: invokestatic 154	com/tencent/qqperf/tools/ProcessStats:a	(Ljava/lang/String;Lcom/tencent/qqperf/tools/ProcessStats$Stats;Z)V
    //   137: aload 8
    //   139: aload 8
    //   141: getfield 312	com/tencent/qqperf/tools/ProcessStats$Stats:d	J
    //   144: aload 8
    //   146: getfield 310	com/tencent/qqperf/tools/ProcessStats$Stats:jdField_c_of_type_Long	J
    //   149: ladd
    //   150: ldc2_w 395
    //   153: lmul
    //   154: lload_3
    //   155: ldiv
    //   156: l2i
    //   157: putfield 261	com/tencent/qqperf/tools/ProcessStats$Stats:jdField_a_of_type_Int	I
    //   160: goto -68 -> 92
    //   163: lload_1
    //   164: getstatic 48	com/tencent/qqperf/tools/ProcessStats:jdField_c_of_type_Long	J
    //   167: lsub
    //   168: ldc2_w 395
    //   171: lmul
    //   172: lload_3
    //   173: ldiv
    //   174: l2i
    //   175: putstatic 30	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_Int	I
    //   178: getstatic 35	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ComTencentQqperfToolsProcessStats$Stats	Lcom/tencent/qqperf/tools/ProcessStats$Stats;
    //   181: getstatic 35	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ComTencentQqperfToolsProcessStats$Stats	Lcom/tencent/qqperf/tools/ProcessStats$Stats;
    //   184: getfield 312	com/tencent/qqperf/tools/ProcessStats$Stats:d	J
    //   187: getstatic 35	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_ComTencentQqperfToolsProcessStats$Stats	Lcom/tencent/qqperf/tools/ProcessStats$Stats;
    //   190: getfield 310	com/tencent/qqperf/tools/ProcessStats$Stats:jdField_c_of_type_Long	J
    //   193: ladd
    //   194: ldc2_w 395
    //   197: lmul
    //   198: lload_3
    //   199: ldiv
    //   200: l2i
    //   201: putfield 261	com/tencent/qqperf/tools/ProcessStats$Stats:jdField_a_of_type_Int	I
    //   204: invokestatic 401	android/os/SystemClock:uptimeMillis	()J
    //   207: putstatic 28	com/tencent/qqperf/tools/ProcessStats:jdField_a_of_type_Long	J
    //   210: goto +16 -> 226
    //   213: astore 6
    //   215: invokestatic 319	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   218: aload 5
    //   220: invokevirtual 343	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   223: aload 6
    //   225: athrow
    //   226: invokestatic 319	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   229: aload 5
    //   231: invokevirtual 343	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   234: return
    //   235: astore 6
    //   237: goto -11 -> 226
    //   240: ldc2_w 83
    //   243: lstore_3
    //   244: goto -192 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	paramBoolean	boolean
    //   21	143	1	l1	long
    //   37	207	3	l2	long
    //   9	221	5	arrayOfByte	byte[]
    //   16	87	6	localObject1	Object
    //   213	11	6	localObject2	Object
    //   235	1	6	localException	Exception
    //   112	18	7	str	String
    //   127	18	8	localStats	ProcessStats.Stats
    // Exception table:
    //   from	to	target	type
    //   11	18	213	finally
    //   27	49	213	finally
    //   52	73	213	finally
    //   77	92	213	finally
    //   92	160	213	finally
    //   163	210	213	finally
    //   11	18	235	java/lang/Exception
    //   27	49	235	java/lang/Exception
    //   52	73	235	java/lang/Exception
    //   77	92	235	java/lang/Exception
    //   92	160	235	java/lang/Exception
    //   163	210	235	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.tools.ProcessStats
 * JD-Core Version:    0.7.0.1
 */