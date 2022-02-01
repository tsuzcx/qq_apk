package com.tencent.xaction.impl;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.tencent.xaction.log.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/impl/MemoryLruCacheImpl$Companion;", "", "()V", "BUFFER_SIZE", "", "ONE_M_SIZE", "", "availClassSize", "cachedTotalMemory", "sysTotalMemory", "getAvailClassSize", "context", "Landroid/content/Context;", "getSystemAvaialbeMemory", "getSystemTotalMemory", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class MemoryLruCacheImpl$Companion
{
  /* Error */
  public final long a()
  {
    // Byte code:
    //   0: invokestatic 44	com/tencent/xaction/impl/MemoryLruCacheImpl:b	()J
    //   3: lconst_0
    //   4: lcmp
    //   5: ifne +190 -> 195
    //   8: aconst_null
    //   9: checkcast 46	java/io/FileReader
    //   12: astore_2
    //   13: aconst_null
    //   14: checkcast 48	java/io/BufferedReader
    //   17: astore_1
    //   18: new 46	java/io/FileReader
    //   21: dup
    //   22: ldc 50
    //   24: invokespecial 53	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   27: astore_3
    //   28: new 48	java/io/BufferedReader
    //   31: dup
    //   32: aload_3
    //   33: checkcast 55	java/io/Reader
    //   36: sipush 4096
    //   39: invokespecial 58	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   42: astore_2
    //   43: aload_2
    //   44: invokevirtual 62	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +104 -> 153
    //   52: aload_1
    //   53: checkcast 64	java/lang/CharSequence
    //   56: astore_1
    //   57: new 66	kotlin/text/Regex
    //   60: dup
    //   61: ldc 68
    //   63: invokespecial 69	kotlin/text/Regex:<init>	(Ljava/lang/String;)V
    //   66: aload_1
    //   67: iconst_0
    //   68: invokevirtual 73	kotlin/text/Regex:split	(Ljava/lang/CharSequence;I)Ljava/util/List;
    //   71: checkcast 75	java/util/Collection
    //   74: iconst_0
    //   75: anewarray 77	java/lang/String
    //   78: invokeinterface 81 2 0
    //   83: astore_1
    //   84: aload_1
    //   85: ifnonnull +48 -> 133
    //   88: new 83	kotlin/TypeCastException
    //   91: dup
    //   92: ldc 85
    //   94: invokespecial 86	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   97: athrow
    //   98: astore_1
    //   99: aload_2
    //   100: astore_1
    //   101: lconst_0
    //   102: invokestatic 90	com/tencent/xaction/impl/MemoryLruCacheImpl:c	(J)V
    //   105: aload_1
    //   106: ifnull +7 -> 113
    //   109: aload_1
    //   110: invokevirtual 93	java/io/BufferedReader:close	()V
    //   113: aload_3
    //   114: ifnull +7 -> 121
    //   117: aload_3
    //   118: invokevirtual 94	java/io/FileReader:close	()V
    //   121: invokestatic 44	com/tencent/xaction/impl/MemoryLruCacheImpl:b	()J
    //   124: lconst_0
    //   125: lcmp
    //   126: ifne +69 -> 195
    //   129: ldc2_w 95
    //   132: lreturn
    //   133: aload_1
    //   134: checkcast 98	[Ljava/lang/String;
    //   137: iconst_1
    //   138: aaload
    //   139: invokestatic 104	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   142: invokevirtual 107	java/lang/Long:longValue	()J
    //   145: sipush 1024
    //   148: i2l
    //   149: lmul
    //   150: invokestatic 90	com/tencent/xaction/impl/MemoryLruCacheImpl:c	(J)V
    //   153: aload_2
    //   154: invokevirtual 93	java/io/BufferedReader:close	()V
    //   157: aload_3
    //   158: invokevirtual 94	java/io/FileReader:close	()V
    //   161: goto -40 -> 121
    //   164: astore_1
    //   165: goto -44 -> 121
    //   168: astore 4
    //   170: aload_2
    //   171: astore_3
    //   172: aload_1
    //   173: astore_2
    //   174: aload 4
    //   176: astore_1
    //   177: aload_2
    //   178: ifnull +7 -> 185
    //   181: aload_2
    //   182: invokevirtual 93	java/io/BufferedReader:close	()V
    //   185: aload_3
    //   186: ifnull +7 -> 193
    //   189: aload_3
    //   190: invokevirtual 94	java/io/FileReader:close	()V
    //   193: aload_1
    //   194: athrow
    //   195: invokestatic 44	com/tencent/xaction/impl/MemoryLruCacheImpl:b	()J
    //   198: lreturn
    //   199: astore_2
    //   200: goto -7 -> 193
    //   203: astore 4
    //   205: aload_1
    //   206: astore_2
    //   207: aload 4
    //   209: astore_1
    //   210: goto -33 -> 177
    //   213: astore_1
    //   214: goto -37 -> 177
    //   217: astore 4
    //   219: aload_1
    //   220: astore_2
    //   221: aload 4
    //   223: astore_1
    //   224: goto -47 -> 177
    //   227: astore_1
    //   228: goto -107 -> 121
    //   231: astore_3
    //   232: aload_2
    //   233: astore_3
    //   234: goto -133 -> 101
    //   237: astore_2
    //   238: goto -137 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	Companion
    //   17	68	1	localObject1	Object
    //   98	1	1	localException1	Exception
    //   100	34	1	localObject2	Object
    //   164	9	1	localException2	Exception
    //   176	34	1	localObject3	Object
    //   213	7	1	localObject4	Object
    //   223	1	1	localObject5	Object
    //   227	1	1	localException3	Exception
    //   12	170	2	localObject6	Object
    //   199	1	2	localException4	Exception
    //   206	27	2	localObject7	Object
    //   237	1	2	localException5	Exception
    //   27	163	3	localObject8	Object
    //   231	1	3	localException6	Exception
    //   233	1	3	localObject9	Object
    //   168	7	4	localObject10	Object
    //   203	5	4	localObject11	Object
    //   217	5	4	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   43	48	98	java/lang/Exception
    //   52	84	98	java/lang/Exception
    //   88	98	98	java/lang/Exception
    //   133	153	98	java/lang/Exception
    //   153	161	164	java/lang/Exception
    //   18	28	168	finally
    //   181	185	199	java/lang/Exception
    //   189	193	199	java/lang/Exception
    //   28	43	203	finally
    //   43	48	213	finally
    //   52	84	213	finally
    //   88	98	213	finally
    //   133	153	213	finally
    //   101	105	217	finally
    //   109	113	227	java/lang/Exception
    //   117	121	227	java/lang/Exception
    //   18	28	231	java/lang/Exception
    //   28	43	237	java/lang/Exception
  }
  
  public final long a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (MemoryLruCacheImpl.a() > 0L) {
      return MemoryLruCacheImpl.a();
    }
    long l1 = ((Companion)this).a();
    MemoryLruCacheImpl.b(l1);
    long l2 = ((Companion)this).b(paramContext);
    l1 = (l1 * 3 + l2 * 7) / 10;
    l2 = Runtime.getRuntime().maxMemory();
    if (l1 <= 157286400L) {
      MemoryLruCacheImpl.a(Math.min(25165824L, l2));
    }
    for (;;)
    {
      return MemoryLruCacheImpl.a();
      if (l1 <= 262144000L) {
        MemoryLruCacheImpl.a(Math.min(37748736L, l2));
      } else if (l1 <= 419430400L) {
        MemoryLruCacheImpl.a(Math.min(67108864L, l2));
      } else if (l1 <= 524288000L) {
        MemoryLruCacheImpl.a(Math.min(134217728L, l2));
      } else {
        MemoryLruCacheImpl.a(Math.min(268435456L, l2));
      }
    }
  }
  
  public final long b(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = paramContext.getSystemService("activity");
    if (paramContext == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
    }
    paramContext = (ActivityManager)paramContext;
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    try
    {
      paramContext.getMemoryInfo(localMemoryInfo);
      long l = localMemoryInfo.availMem;
      return l;
    }
    catch (Exception paramContext)
    {
      QLog.d("MemoryLruCacheImpl", 2, "getSystemAvaialbeMemory call the getMemoryInfo method failed:", (Throwable)paramContext);
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.impl.MemoryLruCacheImpl.Companion
 * JD-Core Version:    0.7.0.1
 */