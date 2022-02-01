package com.tencent.qapmsdk.common.resource;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/resource/StatCollector;", "Lcom/tencent/qapmsdk/common/resource/ResourceCollector;", "()V", "bytes", "", "curPidStat", "Ljava/io/RandomAccessFile;", "curSysStat", "getStatInfo", "initFile", "", "filePath", "", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class StatCollector
  extends ResourceCollector
{
  public static final StatCollector.Companion Companion = new StatCollector.Companion(null);
  private static final String TAG = "QAPM_common_StatCollector";
  private final long[] bytes = new long[5];
  private RandomAccessFile curPidStat;
  private RandomAccessFile curSysStat;
  
  private final void initFile(String paramString)
  {
    Arrays.fill(getBufferBytes(), (byte)-1);
    RandomAccessFile localRandomAccessFile;
    if (Intrinsics.areEqual(paramString, "/proc/stat"))
    {
      localRandomAccessFile = this.curSysStat;
      if (localRandomAccessFile != null) {
        paramString = localRandomAccessFile;
      } else {
        paramString = openFile(paramString);
      }
      this.curSysStat = paramString;
      paramString = this.curSysStat;
    }
    else if (Intrinsics.areEqual(paramString, ResourceConstant.Companion.getPID_STATS_PATH()))
    {
      localRandomAccessFile = this.curPidStat;
      if (localRandomAccessFile != null) {
        paramString = localRandomAccessFile;
      } else {
        paramString = openFile(paramString);
      }
      this.curPidStat = paramString;
      paramString = this.curPidStat;
    }
    else
    {
      paramString = null;
    }
    if (paramString != null)
    {
      paramString.seek(0L);
      if (paramString.read(getBufferBytes(), 0, getBufferBytes().length) == -1) {
        throw ((Throwable)new IOException("read sys stats error"));
      }
    }
    setCurIndex(0);
    setReachedEof(false);
    setValid(true);
  }
  
  /* Error */
  @org.jetbrains.annotations.Nullable
  public final long[] getStatInfo()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 121	com/tencent/qapmsdk/common/resource/StatCollector:isValid	()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +7 -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: aconst_null
    //   14: areturn
    //   15: aload_0
    //   16: getfield 48	com/tencent/qapmsdk/common/resource/StatCollector:bytes	[J
    //   19: lconst_0
    //   20: invokestatic 124	java/util/Arrays:fill	([JJ)V
    //   23: aload_0
    //   24: invokevirtual 127	com/tencent/qapmsdk/common/resource/StatCollector:getCanReadSys	()Z
    //   27: ifeq +109 -> 136
    //   30: aload_0
    //   31: ldc 61
    //   33: invokespecial 129	com/tencent/qapmsdk/common/resource/StatCollector:initFile	(Ljava/lang/String;)V
    //   36: aload_0
    //   37: invokevirtual 132	com/tencent/qapmsdk/common/resource/StatCollector:peek	()Z
    //   40: ifeq +96 -> 136
    //   43: aload_0
    //   44: bipush 32
    //   46: invokevirtual 136	com/tencent/qapmsdk/common/resource/StatCollector:skipPast	(C)V
    //   49: aload_0
    //   50: bipush 32
    //   52: invokevirtual 136	com/tencent/qapmsdk/common/resource/StatCollector:skipPast	(C)V
    //   55: aload_0
    //   56: invokevirtual 140	com/tencent/qapmsdk/common/resource/StatCollector:readNumber	()J
    //   59: lstore_2
    //   60: aload_0
    //   61: invokevirtual 140	com/tencent/qapmsdk/common/resource/StatCollector:readNumber	()J
    //   64: lstore 4
    //   66: aload_0
    //   67: invokevirtual 140	com/tencent/qapmsdk/common/resource/StatCollector:readNumber	()J
    //   70: lstore 6
    //   72: aload_0
    //   73: invokevirtual 140	com/tencent/qapmsdk/common/resource/StatCollector:readNumber	()J
    //   76: lstore 8
    //   78: aload_0
    //   79: invokevirtual 140	com/tencent/qapmsdk/common/resource/StatCollector:readNumber	()J
    //   82: lstore 10
    //   84: aload_0
    //   85: invokevirtual 140	com/tencent/qapmsdk/common/resource/StatCollector:readNumber	()J
    //   88: lstore 12
    //   90: aload_0
    //   91: invokevirtual 140	com/tencent/qapmsdk/common/resource/StatCollector:readNumber	()J
    //   94: lstore 14
    //   96: aload_0
    //   97: getfield 48	com/tencent/qapmsdk/common/resource/StatCollector:bytes	[J
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
    //   122: getfield 48	com/tencent/qapmsdk/common/resource/StatCollector:bytes	[J
    //   125: iconst_1
    //   126: aload_0
    //   127: getfield 48	com/tencent/qapmsdk/common/resource/StatCollector:bytes	[J
    //   130: iconst_0
    //   131: laload
    //   132: lload 8
    //   134: lsub
    //   135: lastore
    //   136: aload_0
    //   137: invokevirtual 143	com/tencent/qapmsdk/common/resource/StatCollector:getCanReadPid	()Z
    //   140: ifeq +118 -> 258
    //   143: aload_0
    //   144: getstatic 78	com/tencent/qapmsdk/common/resource/ResourceConstant:Companion	Lcom/tencent/qapmsdk/common/resource/ResourceConstant$Companion;
    //   147: invokevirtual 84	com/tencent/qapmsdk/common/resource/ResourceConstant$Companion:getPID_STATS_PATH	()Ljava/lang/String;
    //   150: invokespecial 129	com/tencent/qapmsdk/common/resource/StatCollector:initFile	(Ljava/lang/String;)V
    //   153: aload_0
    //   154: bipush 32
    //   156: bipush 13
    //   158: invokevirtual 147	com/tencent/qapmsdk/common/resource/StatCollector:continueSkipPast	(CI)V
    //   161: aload_0
    //   162: invokevirtual 150	com/tencent/qapmsdk/common/resource/StatCollector:getReachedEof	()Z
    //   165: ifne +31 -> 196
    //   168: aload_0
    //   169: invokevirtual 121	com/tencent/qapmsdk/common/resource/StatCollector:isValid	()Z
    //   172: ifeq +24 -> 196
    //   175: aload_0
    //   176: invokevirtual 140	com/tencent/qapmsdk/common/resource/StatCollector:readNumber	()J
    //   179: lstore_2
    //   180: aload_0
    //   181: invokevirtual 140	com/tencent/qapmsdk/common/resource/StatCollector:readNumber	()J
    //   184: lstore 4
    //   186: aload_0
    //   187: getfield 48	com/tencent/qapmsdk/common/resource/StatCollector:bytes	[J
    //   190: iconst_2
    //   191: lload_2
    //   192: lload 4
    //   194: ladd
    //   195: lastore
    //   196: aload_0
    //   197: bipush 32
    //   199: iconst_4
    //   200: invokevirtual 147	com/tencent/qapmsdk/common/resource/StatCollector:continueSkipPast	(CI)V
    //   203: aload_0
    //   204: invokevirtual 150	com/tencent/qapmsdk/common/resource/StatCollector:getReachedEof	()Z
    //   207: ifne +20 -> 227
    //   210: aload_0
    //   211: invokevirtual 121	com/tencent/qapmsdk/common/resource/StatCollector:isValid	()Z
    //   214: ifeq +13 -> 227
    //   217: aload_0
    //   218: getfield 48	com/tencent/qapmsdk/common/resource/StatCollector:bytes	[J
    //   221: iconst_3
    //   222: aload_0
    //   223: invokevirtual 140	com/tencent/qapmsdk/common/resource/StatCollector:readNumber	()J
    //   226: lastore
    //   227: aload_0
    //   228: bipush 32
    //   230: iconst_3
    //   231: invokevirtual 147	com/tencent/qapmsdk/common/resource/StatCollector:continueSkipPast	(CI)V
    //   234: aload_0
    //   235: invokevirtual 150	com/tencent/qapmsdk/common/resource/StatCollector:getReachedEof	()Z
    //   238: ifne +20 -> 258
    //   241: aload_0
    //   242: invokevirtual 121	com/tencent/qapmsdk/common/resource/StatCollector:isValid	()Z
    //   245: ifeq +13 -> 258
    //   248: aload_0
    //   249: getfield 48	com/tencent/qapmsdk/common/resource/StatCollector:bytes	[J
    //   252: iconst_4
    //   253: aload_0
    //   254: invokevirtual 140	com/tencent/qapmsdk/common/resource/StatCollector:readNumber	()J
    //   257: lastore
    //   258: aload_0
    //   259: iconst_1
    //   260: invokevirtual 115	com/tencent/qapmsdk/common/resource/StatCollector:setValid	(Z)V
    //   263: aload_0
    //   264: getfield 48	com/tencent/qapmsdk/common/resource/StatCollector:bytes	[J
    //   267: astore 16
    //   269: aload_0
    //   270: monitorexit
    //   271: aload 16
    //   273: areturn
    //   274: astore 16
    //   276: aload_0
    //   277: iconst_1
    //   278: invokevirtual 115	com/tencent/qapmsdk/common/resource/StatCollector:setValid	(Z)V
    //   281: aload_0
    //   282: iconst_2
    //   283: anewarray 88	java/io/RandomAccessFile
    //   286: dup
    //   287: iconst_0
    //   288: aload_0
    //   289: getfield 86	com/tencent/qapmsdk/common/resource/StatCollector:curPidStat	Ljava/io/RandomAccessFile;
    //   292: aastore
    //   293: dup
    //   294: iconst_1
    //   295: aload_0
    //   296: getfield 69	com/tencent/qapmsdk/common/resource/StatCollector:curSysStat	Ljava/io/RandomAccessFile;
    //   299: aastore
    //   300: invokestatic 156	kotlin/collections/CollectionsKt:listOf	([Ljava/lang/Object;)Ljava/util/List;
    //   303: invokevirtual 160	com/tencent/qapmsdk/common/resource/StatCollector:closeFile	(Ljava/util/List;)V
    //   306: getstatic 166	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   309: astore 17
    //   311: new 168	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   318: astore 18
    //   320: aload 18
    //   322: aload 16
    //   324: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload 18
    //   330: ldc 175
    //   332: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 17
    //   338: iconst_2
    //   339: anewarray 180	java/lang/String
    //   342: dup
    //   343: iconst_0
    //   344: ldc 33
    //   346: aastore
    //   347: dup
    //   348: iconst_1
    //   349: aload 18
    //   351: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: aastore
    //   355: invokevirtual 187	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
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
    //   309	28	17	localLogger	com.tencent.qapmsdk.common.logger.Logger
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.resource.StatCollector
 * JD-Core Version:    0.7.0.1
 */