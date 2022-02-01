package com.tencent.rmonitor.resource.collector;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/resource/collector/StatCollector;", "Lcom/tencent/rmonitor/resource/collector/ResourceCollector;", "()V", "bytes", "", "curPidStat", "Ljava/io/RandomAccessFile;", "curSysStat", "getStatInfo", "initFile", "", "filePath", "", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class StatCollector
  extends ResourceCollector
{
  public static final StatCollector.Companion a = new StatCollector.Companion(null);
  private RandomAccessFile c;
  private RandomAccessFile d;
  private final long[] e = new long[5];
  
  private final void b(String paramString)
  {
    Arrays.fill(h(), (byte)-1);
    RandomAccessFile localRandomAccessFile;
    if (Intrinsics.areEqual(paramString, "/proc/stat"))
    {
      localRandomAccessFile = this.d;
      if (localRandomAccessFile != null) {
        paramString = localRandomAccessFile;
      } else {
        paramString = a(paramString);
      }
      this.d = paramString;
      paramString = this.d;
    }
    else if (Intrinsics.areEqual(paramString, ResourceConstant.a.a()))
    {
      localRandomAccessFile = this.c;
      if (localRandomAccessFile != null) {
        paramString = localRandomAccessFile;
      } else {
        paramString = a(paramString);
      }
      this.c = paramString;
      paramString = this.c;
    }
    else
    {
      paramString = null;
    }
    if (paramString != null)
    {
      paramString.seek(0L);
      if (paramString.read(h(), 0, h().length) == -1) {
        throw ((Throwable)new IOException("read sys stats error"));
      }
    }
    a(0);
    b(false);
    a(true);
  }
  
  /* Error */
  @org.jetbrains.annotations.Nullable
  public final long[] a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 116	com/tencent/rmonitor/resource/collector/StatCollector:c	()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +7 -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: aconst_null
    //   14: areturn
    //   15: aload_0
    //   16: getfield 48	com/tencent/rmonitor/resource/collector/StatCollector:e	[J
    //   19: lconst_0
    //   20: invokestatic 119	java/util/Arrays:fill	([JJ)V
    //   23: aload_0
    //   24: invokevirtual 122	com/tencent/rmonitor/resource/collector/StatCollector:f	()Z
    //   27: ifeq +109 -> 136
    //   30: aload_0
    //   31: ldc 62
    //   33: invokespecial 124	com/tencent/rmonitor/resource/collector/StatCollector:b	(Ljava/lang/String;)V
    //   36: aload_0
    //   37: invokevirtual 126	com/tencent/rmonitor/resource/collector/StatCollector:k	()Z
    //   40: ifeq +96 -> 136
    //   43: aload_0
    //   44: bipush 32
    //   46: invokevirtual 129	com/tencent/rmonitor/resource/collector/StatCollector:a	(C)V
    //   49: aload_0
    //   50: bipush 32
    //   52: invokevirtual 129	com/tencent/rmonitor/resource/collector/StatCollector:a	(C)V
    //   55: aload_0
    //   56: invokevirtual 133	com/tencent/rmonitor/resource/collector/StatCollector:i	()J
    //   59: lstore_2
    //   60: aload_0
    //   61: invokevirtual 133	com/tencent/rmonitor/resource/collector/StatCollector:i	()J
    //   64: lstore 4
    //   66: aload_0
    //   67: invokevirtual 133	com/tencent/rmonitor/resource/collector/StatCollector:i	()J
    //   70: lstore 6
    //   72: aload_0
    //   73: invokevirtual 133	com/tencent/rmonitor/resource/collector/StatCollector:i	()J
    //   76: lstore 8
    //   78: aload_0
    //   79: invokevirtual 133	com/tencent/rmonitor/resource/collector/StatCollector:i	()J
    //   82: lstore 10
    //   84: aload_0
    //   85: invokevirtual 133	com/tencent/rmonitor/resource/collector/StatCollector:i	()J
    //   88: lstore 12
    //   90: aload_0
    //   91: invokevirtual 133	com/tencent/rmonitor/resource/collector/StatCollector:i	()J
    //   94: lstore 14
    //   96: aload_0
    //   97: getfield 48	com/tencent/rmonitor/resource/collector/StatCollector:e	[J
    //   100: iconst_0
    //   101: lload_2
    //   102: lload 4
    //   104: ladd
    //   105: lload 6
    //   107: ladd
    //   108: lload 8
    //   110: ladd
    //   111: lload 10
    //   113: ladd
    //   114: lload 12
    //   116: ladd
    //   117: lload 14
    //   119: ladd
    //   120: lastore
    //   121: aload_0
    //   122: getfield 48	com/tencent/rmonitor/resource/collector/StatCollector:e	[J
    //   125: iconst_1
    //   126: aload_0
    //   127: getfield 48	com/tencent/rmonitor/resource/collector/StatCollector:e	[J
    //   130: iconst_0
    //   131: laload
    //   132: lload 8
    //   134: lsub
    //   135: lastore
    //   136: aload_0
    //   137: invokevirtual 136	com/tencent/rmonitor/resource/collector/StatCollector:g	()Z
    //   140: ifeq +118 -> 258
    //   143: aload_0
    //   144: getstatic 78	com/tencent/rmonitor/resource/collector/ResourceConstant:a	Lcom/tencent/rmonitor/resource/collector/ResourceConstant$Companion;
    //   147: invokevirtual 83	com/tencent/rmonitor/resource/collector/ResourceConstant$Companion:a	()Ljava/lang/String;
    //   150: invokespecial 124	com/tencent/rmonitor/resource/collector/StatCollector:b	(Ljava/lang/String;)V
    //   153: aload_0
    //   154: bipush 32
    //   156: bipush 13
    //   158: invokevirtual 139	com/tencent/rmonitor/resource/collector/StatCollector:a	(CI)V
    //   161: aload_0
    //   162: invokevirtual 141	com/tencent/rmonitor/resource/collector/StatCollector:d	()Z
    //   165: ifne +31 -> 196
    //   168: aload_0
    //   169: invokevirtual 116	com/tencent/rmonitor/resource/collector/StatCollector:c	()Z
    //   172: ifeq +24 -> 196
    //   175: aload_0
    //   176: invokevirtual 133	com/tencent/rmonitor/resource/collector/StatCollector:i	()J
    //   179: lstore_2
    //   180: aload_0
    //   181: invokevirtual 133	com/tencent/rmonitor/resource/collector/StatCollector:i	()J
    //   184: lstore 4
    //   186: aload_0
    //   187: getfield 48	com/tencent/rmonitor/resource/collector/StatCollector:e	[J
    //   190: iconst_2
    //   191: lload_2
    //   192: lload 4
    //   194: ladd
    //   195: lastore
    //   196: aload_0
    //   197: bipush 32
    //   199: iconst_4
    //   200: invokevirtual 139	com/tencent/rmonitor/resource/collector/StatCollector:a	(CI)V
    //   203: aload_0
    //   204: invokevirtual 141	com/tencent/rmonitor/resource/collector/StatCollector:d	()Z
    //   207: ifne +20 -> 227
    //   210: aload_0
    //   211: invokevirtual 116	com/tencent/rmonitor/resource/collector/StatCollector:c	()Z
    //   214: ifeq +13 -> 227
    //   217: aload_0
    //   218: getfield 48	com/tencent/rmonitor/resource/collector/StatCollector:e	[J
    //   221: iconst_3
    //   222: aload_0
    //   223: invokevirtual 133	com/tencent/rmonitor/resource/collector/StatCollector:i	()J
    //   226: lastore
    //   227: aload_0
    //   228: bipush 32
    //   230: iconst_3
    //   231: invokevirtual 139	com/tencent/rmonitor/resource/collector/StatCollector:a	(CI)V
    //   234: aload_0
    //   235: invokevirtual 141	com/tencent/rmonitor/resource/collector/StatCollector:d	()Z
    //   238: ifne +20 -> 258
    //   241: aload_0
    //   242: invokevirtual 116	com/tencent/rmonitor/resource/collector/StatCollector:c	()Z
    //   245: ifeq +13 -> 258
    //   248: aload_0
    //   249: getfield 48	com/tencent/rmonitor/resource/collector/StatCollector:e	[J
    //   252: iconst_4
    //   253: aload_0
    //   254: invokevirtual 133	com/tencent/rmonitor/resource/collector/StatCollector:i	()J
    //   257: lastore
    //   258: aload_0
    //   259: iconst_1
    //   260: invokevirtual 111	com/tencent/rmonitor/resource/collector/StatCollector:a	(Z)V
    //   263: aload_0
    //   264: getfield 48	com/tencent/rmonitor/resource/collector/StatCollector:e	[J
    //   267: astore 16
    //   269: aload_0
    //   270: monitorexit
    //   271: aload 16
    //   273: areturn
    //   274: astore 16
    //   276: aload_0
    //   277: iconst_1
    //   278: invokevirtual 111	com/tencent/rmonitor/resource/collector/StatCollector:a	(Z)V
    //   281: aload_0
    //   282: iconst_2
    //   283: anewarray 87	java/io/RandomAccessFile
    //   286: dup
    //   287: iconst_0
    //   288: aload_0
    //   289: getfield 85	com/tencent/rmonitor/resource/collector/StatCollector:c	Ljava/io/RandomAccessFile;
    //   292: aastore
    //   293: dup
    //   294: iconst_1
    //   295: aload_0
    //   296: getfield 70	com/tencent/rmonitor/resource/collector/StatCollector:d	Ljava/io/RandomAccessFile;
    //   299: aastore
    //   300: invokestatic 147	kotlin/collections/CollectionsKt:listOf	([Ljava/lang/Object;)Ljava/util/List;
    //   303: invokevirtual 150	com/tencent/rmonitor/resource/collector/StatCollector:a	(Ljava/util/List;)V
    //   306: getstatic 155	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   309: astore 17
    //   311: new 157	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   318: astore 18
    //   320: aload 18
    //   322: aload 16
    //   324: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload 18
    //   330: ldc 164
    //   332: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 17
    //   338: iconst_2
    //   339: anewarray 169	java/lang/String
    //   342: dup
    //   343: iconst_0
    //   344: ldc 171
    //   346: aastore
    //   347: dup
    //   348: iconst_1
    //   349: aload 18
    //   351: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: aastore
    //   355: invokevirtual 177	com/tencent/rmonitor/common/logger/Logger:d	([Ljava/lang/String;)V
    //   358: aload_0
    //   359: monitorexit
    //   360: aconst_null
    //   361: areturn
    //   362: astore 16
    //   364: aload_0
    //   365: monitorexit
    //   366: aload 16
    //   368: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	StatCollector
    //   6	2	1	bool	boolean
    //   59	133	2	l1	long
    //   64	129	4	l2	long
    //   70	36	6	l3	long
    //   76	57	8	l4	long
    //   82	30	10	l5	long
    //   88	27	12	l6	long
    //   94	24	14	l7	long
    //   267	5	16	arrayOfLong	long[]
    //   274	49	16	localIOException	IOException
    //   362	5	16	localObject	java.lang.Object
    //   309	28	17	localLogger	com.tencent.rmonitor.common.logger.Logger
    //   318	32	18	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   23	136	274	java/io/IOException
    //   136	196	274	java/io/IOException
    //   196	227	274	java/io/IOException
    //   227	258	274	java/io/IOException
    //   2	7	362	finally
    //   15	23	362	finally
    //   23	136	362	finally
    //   136	196	362	finally
    //   196	227	362	finally
    //   227	258	362	finally
    //   258	269	362	finally
    //   276	358	362	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.collector.StatCollector
 * JD-Core Version:    0.7.0.1
 */