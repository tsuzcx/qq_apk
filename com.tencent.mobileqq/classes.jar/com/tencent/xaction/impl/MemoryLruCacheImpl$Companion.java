package com.tencent.xaction.impl;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.tencent.xaction.log.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/impl/MemoryLruCacheImpl$Companion;", "", "()V", "BUFFER_SIZE", "", "ONE_M_SIZE", "", "availClassSize", "cachedTotalMemory", "sysTotalMemory", "getAvailClassSize", "context", "Landroid/content/Context;", "getSystemAvaialbeMemory", "getSystemTotalMemory", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class MemoryLruCacheImpl$Companion
{
  /* Error */
  public final long a()
  {
    // Byte code:
    //   0: invokestatic 44	com/tencent/xaction/impl/MemoryLruCacheImpl:b	()J
    //   3: lconst_0
    //   4: lcmp
    //   5: ifne +226 -> 231
    //   8: aconst_null
    //   9: checkcast 46	java/io/FileReader
    //   12: astore 5
    //   14: aconst_null
    //   15: checkcast 48	java/io/BufferedReader
    //   18: astore_1
    //   19: aload_1
    //   20: astore_3
    //   21: aload 5
    //   23: astore 4
    //   25: new 46	java/io/FileReader
    //   28: dup
    //   29: ldc 50
    //   31: invokespecial 53	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   34: astore_2
    //   35: new 48	java/io/BufferedReader
    //   38: dup
    //   39: aload_2
    //   40: checkcast 55	java/io/Reader
    //   43: sipush 4096
    //   46: invokespecial 58	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   49: astore_3
    //   50: aload_3
    //   51: invokevirtual 62	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore_1
    //   55: aload_1
    //   56: ifnull +72 -> 128
    //   59: aload_1
    //   60: checkcast 64	java/lang/CharSequence
    //   63: astore_1
    //   64: new 66	kotlin/text/Regex
    //   67: dup
    //   68: ldc 68
    //   70: invokespecial 69	kotlin/text/Regex:<init>	(Ljava/lang/String;)V
    //   73: aload_1
    //   74: iconst_0
    //   75: invokevirtual 73	kotlin/text/Regex:split	(Ljava/lang/CharSequence;I)Ljava/util/List;
    //   78: checkcast 75	java/util/Collection
    //   81: iconst_0
    //   82: anewarray 77	java/lang/String
    //   85: invokeinterface 81 2 0
    //   90: astore_1
    //   91: aload_1
    //   92: ifnull +26 -> 118
    //   95: aload_1
    //   96: checkcast 83	[Ljava/lang/String;
    //   99: iconst_1
    //   100: aaload
    //   101: invokestatic 89	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   104: invokevirtual 92	java/lang/Long:longValue	()J
    //   107: sipush 1024
    //   110: i2l
    //   111: lmul
    //   112: invokestatic 96	com/tencent/xaction/impl/MemoryLruCacheImpl:c	(J)V
    //   115: goto +13 -> 128
    //   118: new 98	kotlin/TypeCastException
    //   121: dup
    //   122: ldc 100
    //   124: invokespecial 101	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   127: athrow
    //   128: aload_3
    //   129: invokevirtual 104	java/io/BufferedReader:close	()V
    //   132: aload_2
    //   133: invokevirtual 105	java/io/FileReader:close	()V
    //   136: goto +65 -> 201
    //   139: astore_1
    //   140: goto +73 -> 213
    //   143: aload_3
    //   144: astore_1
    //   145: goto +7 -> 152
    //   148: astore_3
    //   149: goto +16 -> 165
    //   152: goto +24 -> 176
    //   155: astore 5
    //   157: aload 4
    //   159: astore_2
    //   160: aload_3
    //   161: astore_1
    //   162: aload 5
    //   164: astore_3
    //   165: aload_3
    //   166: astore 4
    //   168: aload_1
    //   169: astore_3
    //   170: aload 4
    //   172: astore_1
    //   173: goto +40 -> 213
    //   176: aload_1
    //   177: astore_3
    //   178: aload_2
    //   179: astore 4
    //   181: lconst_0
    //   182: invokestatic 96	com/tencent/xaction/impl/MemoryLruCacheImpl:c	(J)V
    //   185: aload_1
    //   186: ifnull +7 -> 193
    //   189: aload_1
    //   190: invokevirtual 104	java/io/BufferedReader:close	()V
    //   193: aload_2
    //   194: ifnull +7 -> 201
    //   197: aload_2
    //   198: invokevirtual 105	java/io/FileReader:close	()V
    //   201: invokestatic 44	com/tencent/xaction/impl/MemoryLruCacheImpl:b	()J
    //   204: lconst_0
    //   205: lcmp
    //   206: ifne +25 -> 231
    //   209: ldc2_w 106
    //   212: lreturn
    //   213: aload_3
    //   214: ifnull +7 -> 221
    //   217: aload_3
    //   218: invokevirtual 104	java/io/BufferedReader:close	()V
    //   221: aload_2
    //   222: ifnull +7 -> 229
    //   225: aload_2
    //   226: invokevirtual 105	java/io/FileReader:close	()V
    //   229: aload_1
    //   230: athrow
    //   231: invokestatic 44	com/tencent/xaction/impl/MemoryLruCacheImpl:b	()J
    //   234: lreturn
    //   235: astore_2
    //   236: aload 5
    //   238: astore_2
    //   239: goto -63 -> 176
    //   242: astore_3
    //   243: goto -91 -> 152
    //   246: astore_1
    //   247: goto -104 -> 143
    //   250: astore_1
    //   251: goto -50 -> 201
    //   254: astore_2
    //   255: goto -26 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	Companion
    //   18	78	1	localObject1	Object
    //   139	1	1	localObject2	Object
    //   144	86	1	localObject3	Object
    //   246	1	1	localException1	Exception
    //   250	1	1	localException2	Exception
    //   34	192	2	localObject4	Object
    //   235	1	2	localException3	Exception
    //   238	1	2	localObject5	Object
    //   254	1	2	localException4	Exception
    //   20	124	3	localObject6	Object
    //   148	13	3	localObject7	Object
    //   164	54	3	localObject8	Object
    //   242	1	3	localException5	Exception
    //   23	157	4	localObject9	Object
    //   12	10	5	localFileReader	java.io.FileReader
    //   155	82	5	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   50	55	139	finally
    //   59	91	139	finally
    //   95	115	139	finally
    //   118	128	139	finally
    //   35	50	148	finally
    //   25	35	155	finally
    //   181	185	155	finally
    //   25	35	235	java/lang/Exception
    //   35	50	242	java/lang/Exception
    //   50	55	246	java/lang/Exception
    //   59	91	246	java/lang/Exception
    //   95	115	246	java/lang/Exception
    //   118	128	246	java/lang/Exception
    //   128	136	250	java/lang/Exception
    //   189	193	250	java/lang/Exception
    //   197	201	250	java/lang/Exception
    //   217	221	254	java/lang/Exception
    //   225	229	254	java/lang/Exception
  }
  
  public final long a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (MemoryLruCacheImpl.a() > 0L) {
      return MemoryLruCacheImpl.a();
    }
    Companion localCompanion = (Companion)this;
    long l1 = localCompanion.a();
    MemoryLruCacheImpl.b(l1);
    long l2 = localCompanion.b(paramContext);
    l1 = (l1 * 3 + l2 * 7) / 10;
    l2 = Runtime.getRuntime().maxMemory();
    if (l1 <= 157286400L) {
      MemoryLruCacheImpl.a(Math.min(25165824L, l2));
    } else if (l1 <= 262144000L) {
      MemoryLruCacheImpl.a(Math.min(37748736L, l2));
    } else if (l1 <= 419430400L) {
      MemoryLruCacheImpl.a(Math.min(67108864L, l2));
    } else if (l1 <= 524288000L) {
      MemoryLruCacheImpl.a(Math.min(134217728L, l2));
    } else {
      MemoryLruCacheImpl.a(Math.min(268435456L, l2));
    }
    return MemoryLruCacheImpl.a();
  }
  
  public final long b(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = paramContext.getSystemService("activity");
    if (paramContext != null)
    {
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
        return -1L;
      }
    }
    throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.impl.MemoryLruCacheImpl.Companion
 * JD-Core Version:    0.7.0.1
 */