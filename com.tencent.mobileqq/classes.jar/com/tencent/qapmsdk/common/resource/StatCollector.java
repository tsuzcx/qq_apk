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
      if (localRandomAccessFile != null)
      {
        paramString = localRandomAccessFile;
        this.curSysStat = paramString;
        paramString = this.curSysStat;
      }
    }
    for (;;)
    {
      if (paramString == null) {
        break label139;
      }
      paramString.seek(0L);
      if (paramString.read(getBufferBytes(), 0, getBufferBytes().length) != -1) {
        break label139;
      }
      throw ((Throwable)new IOException("read sys stats error"));
      paramString = openFile(paramString);
      break;
      if (Intrinsics.areEqual(paramString, ResourceConstant.Companion.getPID_STATS_PATH()))
      {
        localRandomAccessFile = this.curPidStat;
        if (localRandomAccessFile != null) {}
        for (paramString = localRandomAccessFile;; paramString = openFile(paramString))
        {
          this.curPidStat = paramString;
          paramString = this.curPidStat;
          break;
        }
      }
      paramString = null;
    }
    label139:
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
    //   8: ifne +11 -> 19
    //   11: aconst_null
    //   12: astore 16
    //   14: aload_0
    //   15: monitorexit
    //   16: aload 16
    //   18: areturn
    //   19: aload_0
    //   20: getfield 48	com/tencent/qapmsdk/common/resource/StatCollector:bytes	[J
    //   23: lconst_0
    //   24: invokestatic 124	java/util/Arrays:fill	([JJ)V
    //   27: aload_0
    //   28: invokevirtual 127	com/tencent/qapmsdk/common/resource/StatCollector:getCanReadSys	()Z
    //   31: ifeq +109 -> 140
    //   34: aload_0
    //   35: ldc 61
    //   37: invokespecial 129	com/tencent/qapmsdk/common/resource/StatCollector:initFile	(Ljava/lang/String;)V
    //   40: aload_0
    //   41: invokevirtual 132	com/tencent/qapmsdk/common/resource/StatCollector:peek	()Z
    //   44: ifeq +96 -> 140
    //   47: aload_0
    //   48: bipush 32
    //   50: invokevirtual 136	com/tencent/qapmsdk/common/resource/StatCollector:skipPast	(C)V
    //   53: aload_0
    //   54: bipush 32
    //   56: invokevirtual 136	com/tencent/qapmsdk/common/resource/StatCollector:skipPast	(C)V
    //   59: aload_0
    //   60: invokevirtual 140	com/tencent/qapmsdk/common/resource/StatCollector:readNumber	()J
    //   63: lstore_2
    //   64: aload_0
    //   65: invokevirtual 140	com/tencent/qapmsdk/common/resource/StatCollector:readNumber	()J
    //   68: lstore 4
    //   70: aload_0
    //   71: invokevirtual 140	com/tencent/qapmsdk/common/resource/StatCollector:readNumber	()J
    //   74: lstore 6
    //   76: aload_0
    //   77: invokevirtual 140	com/tencent/qapmsdk/common/resource/StatCollector:readNumber	()J
    //   80: lstore 8
    //   82: aload_0
    //   83: invokevirtual 140	com/tencent/qapmsdk/common/resource/StatCollector:readNumber	()J
    //   86: lstore 10
    //   88: aload_0
    //   89: invokevirtual 140	com/tencent/qapmsdk/common/resource/StatCollector:readNumber	()J
    //   92: lstore 12
    //   94: aload_0
    //   95: invokevirtual 140	com/tencent/qapmsdk/common/resource/StatCollector:readNumber	()J
    //   98: lstore 14
    //   100: aload_0
    //   101: getfield 48	com/tencent/qapmsdk/common/resource/StatCollector:bytes	[J
    //   104: iconst_0
    //   105: lload_2
    //   106: lload 4
    //   108: ladd
    //   109: lload 6
    //   111: ladd
    //   112: lload 8
    //   114: ladd
    //   115: lload 10
    //   117: ladd
    //   118: lload 12
    //   120: ladd
    //   121: lload 14
    //   123: ladd
    //   124: lastore
    //   125: aload_0
    //   126: getfield 48	com/tencent/qapmsdk/common/resource/StatCollector:bytes	[J
    //   129: iconst_1
    //   130: aload_0
    //   131: getfield 48	com/tencent/qapmsdk/common/resource/StatCollector:bytes	[J
    //   134: iconst_0
    //   135: laload
    //   136: lload 8
    //   138: lsub
    //   139: lastore
    //   140: aload_0
    //   141: invokevirtual 143	com/tencent/qapmsdk/common/resource/StatCollector:getCanReadPid	()Z
    //   144: ifeq +118 -> 262
    //   147: aload_0
    //   148: getstatic 96	com/tencent/qapmsdk/common/resource/ResourceConstant:Companion	Lcom/tencent/qapmsdk/common/resource/ResourceConstant$Companion;
    //   151: invokevirtual 102	com/tencent/qapmsdk/common/resource/ResourceConstant$Companion:getPID_STATS_PATH	()Ljava/lang/String;
    //   154: invokespecial 129	com/tencent/qapmsdk/common/resource/StatCollector:initFile	(Ljava/lang/String;)V
    //   157: aload_0
    //   158: bipush 32
    //   160: bipush 13
    //   162: invokevirtual 147	com/tencent/qapmsdk/common/resource/StatCollector:continueSkipPast	(CI)V
    //   165: aload_0
    //   166: invokevirtual 150	com/tencent/qapmsdk/common/resource/StatCollector:getReachedEof	()Z
    //   169: ifne +31 -> 200
    //   172: aload_0
    //   173: invokevirtual 121	com/tencent/qapmsdk/common/resource/StatCollector:isValid	()Z
    //   176: ifeq +24 -> 200
    //   179: aload_0
    //   180: invokevirtual 140	com/tencent/qapmsdk/common/resource/StatCollector:readNumber	()J
    //   183: lstore_2
    //   184: aload_0
    //   185: invokevirtual 140	com/tencent/qapmsdk/common/resource/StatCollector:readNumber	()J
    //   188: lstore 4
    //   190: aload_0
    //   191: getfield 48	com/tencent/qapmsdk/common/resource/StatCollector:bytes	[J
    //   194: iconst_2
    //   195: lload_2
    //   196: lload 4
    //   198: ladd
    //   199: lastore
    //   200: aload_0
    //   201: bipush 32
    //   203: iconst_4
    //   204: invokevirtual 147	com/tencent/qapmsdk/common/resource/StatCollector:continueSkipPast	(CI)V
    //   207: aload_0
    //   208: invokevirtual 150	com/tencent/qapmsdk/common/resource/StatCollector:getReachedEof	()Z
    //   211: ifne +20 -> 231
    //   214: aload_0
    //   215: invokevirtual 121	com/tencent/qapmsdk/common/resource/StatCollector:isValid	()Z
    //   218: ifeq +13 -> 231
    //   221: aload_0
    //   222: getfield 48	com/tencent/qapmsdk/common/resource/StatCollector:bytes	[J
    //   225: iconst_3
    //   226: aload_0
    //   227: invokevirtual 140	com/tencent/qapmsdk/common/resource/StatCollector:readNumber	()J
    //   230: lastore
    //   231: aload_0
    //   232: bipush 32
    //   234: iconst_3
    //   235: invokevirtual 147	com/tencent/qapmsdk/common/resource/StatCollector:continueSkipPast	(CI)V
    //   238: aload_0
    //   239: invokevirtual 150	com/tencent/qapmsdk/common/resource/StatCollector:getReachedEof	()Z
    //   242: ifne +20 -> 262
    //   245: aload_0
    //   246: invokevirtual 121	com/tencent/qapmsdk/common/resource/StatCollector:isValid	()Z
    //   249: ifeq +13 -> 262
    //   252: aload_0
    //   253: getfield 48	com/tencent/qapmsdk/common/resource/StatCollector:bytes	[J
    //   256: iconst_4
    //   257: aload_0
    //   258: invokevirtual 140	com/tencent/qapmsdk/common/resource/StatCollector:readNumber	()J
    //   261: lastore
    //   262: aload_0
    //   263: iconst_1
    //   264: invokevirtual 115	com/tencent/qapmsdk/common/resource/StatCollector:setValid	(Z)V
    //   267: aload_0
    //   268: getfield 48	com/tencent/qapmsdk/common/resource/StatCollector:bytes	[J
    //   271: astore 16
    //   273: goto -259 -> 14
    //   276: astore 16
    //   278: aload_0
    //   279: iconst_1
    //   280: invokevirtual 115	com/tencent/qapmsdk/common/resource/StatCollector:setValid	(Z)V
    //   283: aload_0
    //   284: iconst_2
    //   285: anewarray 71	java/io/RandomAccessFile
    //   288: dup
    //   289: iconst_0
    //   290: aload_0
    //   291: getfield 104	com/tencent/qapmsdk/common/resource/StatCollector:curPidStat	Ljava/io/RandomAccessFile;
    //   294: aastore
    //   295: dup
    //   296: iconst_1
    //   297: aload_0
    //   298: getfield 69	com/tencent/qapmsdk/common/resource/StatCollector:curSysStat	Ljava/io/RandomAccessFile;
    //   301: aastore
    //   302: invokestatic 156	kotlin/collections/CollectionsKt:listOf	([Ljava/lang/Object;)Ljava/util/List;
    //   305: invokevirtual 160	com/tencent/qapmsdk/common/resource/StatCollector:closeFile	(Ljava/util/List;)V
    //   308: getstatic 166	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   311: iconst_2
    //   312: anewarray 168	java/lang/String
    //   315: dup
    //   316: iconst_0
    //   317: ldc 33
    //   319: aastore
    //   320: dup
    //   321: iconst_1
    //   322: new 170	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   329: aload 16
    //   331: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   334: ldc 177
    //   336: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: aastore
    //   343: invokevirtual 187	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   346: aconst_null
    //   347: astore 16
    //   349: goto -335 -> 14
    //   352: astore 16
    //   354: aload_0
    //   355: monitorexit
    //   356: aload 16
    //   358: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	StatCollector
    //   6	2	1	bool	boolean
    //   63	133	2	l1	long
    //   68	129	4	l2	long
    //   74	36	6	l3	long
    //   80	57	8	l4	long
    //   86	30	10	l5	long
    //   92	27	12	l6	long
    //   98	24	14	l7	long
    //   12	260	16	arrayOfLong	long[]
    //   276	54	16	localIOException	IOException
    //   347	1	16	localObject1	java.lang.Object
    //   352	5	16	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   27	140	276	java/io/IOException
    //   140	200	276	java/io/IOException
    //   200	231	276	java/io/IOException
    //   231	262	276	java/io/IOException
    //   2	7	352	finally
    //   19	27	352	finally
    //   27	140	352	finally
    //   140	200	352	finally
    //   200	231	352	finally
    //   231	262	352	finally
    //   262	273	352	finally
    //   278	346	352	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.common.resource.StatCollector
 * JD-Core Version:    0.7.0.1
 */