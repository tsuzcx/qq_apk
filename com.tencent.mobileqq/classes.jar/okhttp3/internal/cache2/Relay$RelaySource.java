package okhttp3.internal.cache2;

import java.io.RandomAccessFile;
import okhttp3.internal.Util;
import okio.Source;
import okio.Timeout;

class Relay$RelaySource
  implements Source
{
  private FileOperator fileOperator = new FileOperator(this.this$0.file.getChannel());
  private long sourcePos;
  private final Timeout timeout = new Timeout();
  
  Relay$RelaySource(Relay paramRelay) {}
  
  public void close()
  {
    if (this.fileOperator == null) {
      return;
    }
    RandomAccessFile localRandomAccessFile = null;
    this.fileOperator = null;
    synchronized (this.this$0)
    {
      Relay localRelay2 = this.this$0;
      localRelay2.sourceCount -= 1;
      if (this.this$0.sourceCount == 0)
      {
        localRandomAccessFile = this.this$0.file;
        this.this$0.file = null;
      }
      if (localRandomAccessFile != null) {
        Util.closeQuietly(localRandomAccessFile);
      }
      return;
    }
  }
  
  /* Error */
  public long read(okio.Buffer paramBuffer, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	okhttp3/internal/cache2/Relay$RelaySource:fileOperator	Lokhttp3/internal/cache2/FileOperator;
    //   4: ifnull +535 -> 539
    //   7: aload_0
    //   8: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   11: astore 9
    //   13: aload 9
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield 61	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
    //   20: lstore 7
    //   22: aload_0
    //   23: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   26: getfield 64	okhttp3/internal/cache2/Relay:upstreamPos	J
    //   29: lstore 5
    //   31: lload 7
    //   33: lload 5
    //   35: lcmp
    //   36: ifne +63 -> 99
    //   39: aload_0
    //   40: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   43: getfield 68	okhttp3/internal/cache2/Relay:complete	Z
    //   46: ifeq +10 -> 56
    //   49: aload 9
    //   51: monitorexit
    //   52: ldc2_w 69
    //   55: lreturn
    //   56: aload_0
    //   57: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   60: getfield 74	okhttp3/internal/cache2/Relay:upstreamReader	Ljava/lang/Thread;
    //   63: ifnull +17 -> 80
    //   66: aload_0
    //   67: getfield 26	okhttp3/internal/cache2/Relay$RelaySource:timeout	Lokio/Timeout;
    //   70: aload_0
    //   71: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   74: invokevirtual 78	okio/Timeout:waitUntilNotified	(Ljava/lang/Object;)V
    //   77: goto -61 -> 16
    //   80: aload_0
    //   81: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   84: invokestatic 84	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   87: putfield 74	okhttp3/internal/cache2/Relay:upstreamReader	Ljava/lang/Thread;
    //   90: iconst_1
    //   91: istore 4
    //   93: aload 9
    //   95: monitorexit
    //   96: goto +34 -> 130
    //   99: lload 5
    //   101: aload_0
    //   102: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   105: getfield 88	okhttp3/internal/cache2/Relay:buffer	Lokio/Buffer;
    //   108: invokevirtual 94	okio/Buffer:size	()J
    //   111: lsub
    //   112: lstore 7
    //   114: aload_0
    //   115: getfield 61	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
    //   118: lload 7
    //   120: lcmp
    //   121: ifge +365 -> 486
    //   124: aload 9
    //   126: monitorexit
    //   127: iconst_2
    //   128: istore 4
    //   130: iload 4
    //   132: iconst_2
    //   133: if_icmpne +44 -> 177
    //   136: lload_2
    //   137: lload 5
    //   139: aload_0
    //   140: getfield 61	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
    //   143: lsub
    //   144: invokestatic 100	java/lang/Math:min	(JJ)J
    //   147: lstore_2
    //   148: aload_0
    //   149: getfield 45	okhttp3/internal/cache2/Relay$RelaySource:fileOperator	Lokhttp3/internal/cache2/FileOperator;
    //   152: aload_0
    //   153: getfield 61	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
    //   156: ldc2_w 101
    //   159: ladd
    //   160: aload_1
    //   161: lload_2
    //   162: invokevirtual 105	okhttp3/internal/cache2/FileOperator:read	(JLokio/Buffer;J)V
    //   165: aload_0
    //   166: aload_0
    //   167: getfield 61	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
    //   170: lload_2
    //   171: ladd
    //   172: putfield 61	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
    //   175: lload_2
    //   176: lreturn
    //   177: aload_0
    //   178: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   181: getfield 109	okhttp3/internal/cache2/Relay:upstream	Lokio/Source;
    //   184: aload_0
    //   185: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   188: getfield 112	okhttp3/internal/cache2/Relay:upstreamBuffer	Lokio/Buffer;
    //   191: aload_0
    //   192: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   195: getfield 115	okhttp3/internal/cache2/Relay:bufferMaxSize	J
    //   198: invokeinterface 117 4 0
    //   203: lstore 7
    //   205: lload 7
    //   207: ldc2_w 69
    //   210: lcmp
    //   211: ifne +47 -> 258
    //   214: aload_0
    //   215: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   218: lload 5
    //   220: invokevirtual 121	okhttp3/internal/cache2/Relay:commit	(J)V
    //   223: aload_0
    //   224: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   227: astore_1
    //   228: aload_1
    //   229: monitorenter
    //   230: aload_0
    //   231: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   234: aconst_null
    //   235: putfield 74	okhttp3/internal/cache2/Relay:upstreamReader	Ljava/lang/Thread;
    //   238: aload_0
    //   239: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   242: invokevirtual 124	java/lang/Object:notifyAll	()V
    //   245: aload_1
    //   246: monitorexit
    //   247: ldc2_w 69
    //   250: lreturn
    //   251: astore 9
    //   253: aload_1
    //   254: monitorexit
    //   255: aload 9
    //   257: athrow
    //   258: lload 7
    //   260: lload_2
    //   261: invokestatic 100	java/lang/Math:min	(JJ)J
    //   264: lstore_2
    //   265: aload_0
    //   266: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   269: getfield 112	okhttp3/internal/cache2/Relay:upstreamBuffer	Lokio/Buffer;
    //   272: aload_1
    //   273: lconst_0
    //   274: lload_2
    //   275: invokevirtual 128	okio/Buffer:copyTo	(Lokio/Buffer;JJ)Lokio/Buffer;
    //   278: pop
    //   279: aload_0
    //   280: aload_0
    //   281: getfield 61	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
    //   284: lload_2
    //   285: ladd
    //   286: putfield 61	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
    //   289: aload_0
    //   290: getfield 45	okhttp3/internal/cache2/Relay$RelaySource:fileOperator	Lokhttp3/internal/cache2/FileOperator;
    //   293: lload 5
    //   295: ldc2_w 101
    //   298: ladd
    //   299: aload_0
    //   300: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   303: getfield 112	okhttp3/internal/cache2/Relay:upstreamBuffer	Lokio/Buffer;
    //   306: invokevirtual 132	okio/Buffer:clone	()Lokio/Buffer;
    //   309: lload 7
    //   311: invokevirtual 135	okhttp3/internal/cache2/FileOperator:write	(JLokio/Buffer;J)V
    //   314: aload_0
    //   315: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   318: astore_1
    //   319: aload_1
    //   320: monitorenter
    //   321: aload_0
    //   322: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   325: getfield 88	okhttp3/internal/cache2/Relay:buffer	Lokio/Buffer;
    //   328: aload_0
    //   329: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   332: getfield 112	okhttp3/internal/cache2/Relay:upstreamBuffer	Lokio/Buffer;
    //   335: lload 7
    //   337: invokevirtual 138	okio/Buffer:write	(Lokio/Buffer;J)V
    //   340: aload_0
    //   341: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   344: getfield 88	okhttp3/internal/cache2/Relay:buffer	Lokio/Buffer;
    //   347: invokevirtual 94	okio/Buffer:size	()J
    //   350: aload_0
    //   351: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   354: getfield 115	okhttp3/internal/cache2/Relay:bufferMaxSize	J
    //   357: lcmp
    //   358: ifle +31 -> 389
    //   361: aload_0
    //   362: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   365: getfield 88	okhttp3/internal/cache2/Relay:buffer	Lokio/Buffer;
    //   368: aload_0
    //   369: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   372: getfield 88	okhttp3/internal/cache2/Relay:buffer	Lokio/Buffer;
    //   375: invokevirtual 94	okio/Buffer:size	()J
    //   378: aload_0
    //   379: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   382: getfield 115	okhttp3/internal/cache2/Relay:bufferMaxSize	J
    //   385: lsub
    //   386: invokevirtual 141	okio/Buffer:skip	(J)V
    //   389: aload_0
    //   390: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   393: astore 9
    //   395: aload 9
    //   397: aload 9
    //   399: getfield 64	okhttp3/internal/cache2/Relay:upstreamPos	J
    //   402: lload 7
    //   404: ladd
    //   405: putfield 64	okhttp3/internal/cache2/Relay:upstreamPos	J
    //   408: aload_1
    //   409: monitorexit
    //   410: aload_0
    //   411: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   414: astore_1
    //   415: aload_1
    //   416: monitorenter
    //   417: aload_0
    //   418: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   421: aconst_null
    //   422: putfield 74	okhttp3/internal/cache2/Relay:upstreamReader	Ljava/lang/Thread;
    //   425: aload_0
    //   426: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   429: invokevirtual 124	java/lang/Object:notifyAll	()V
    //   432: aload_1
    //   433: monitorexit
    //   434: lload_2
    //   435: lreturn
    //   436: astore 9
    //   438: aload_1
    //   439: monitorexit
    //   440: aload 9
    //   442: athrow
    //   443: astore 9
    //   445: aload_1
    //   446: monitorexit
    //   447: aload 9
    //   449: athrow
    //   450: astore 9
    //   452: aload_0
    //   453: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   456: astore_1
    //   457: aload_1
    //   458: monitorenter
    //   459: aload_0
    //   460: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   463: aconst_null
    //   464: putfield 74	okhttp3/internal/cache2/Relay:upstreamReader	Ljava/lang/Thread;
    //   467: aload_0
    //   468: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   471: invokevirtual 124	java/lang/Object:notifyAll	()V
    //   474: aload_1
    //   475: monitorexit
    //   476: aload 9
    //   478: athrow
    //   479: astore 9
    //   481: aload_1
    //   482: monitorexit
    //   483: aload 9
    //   485: athrow
    //   486: lload_2
    //   487: lload 5
    //   489: aload_0
    //   490: getfield 61	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
    //   493: lsub
    //   494: invokestatic 100	java/lang/Math:min	(JJ)J
    //   497: lstore_2
    //   498: aload_0
    //   499: getfield 18	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
    //   502: getfield 88	okhttp3/internal/cache2/Relay:buffer	Lokio/Buffer;
    //   505: aload_1
    //   506: aload_0
    //   507: getfield 61	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
    //   510: lload 7
    //   512: lsub
    //   513: lload_2
    //   514: invokevirtual 128	okio/Buffer:copyTo	(Lokio/Buffer;JJ)Lokio/Buffer;
    //   517: pop
    //   518: aload_0
    //   519: aload_0
    //   520: getfield 61	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
    //   523: lload_2
    //   524: ladd
    //   525: putfield 61	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
    //   528: aload 9
    //   530: monitorexit
    //   531: lload_2
    //   532: lreturn
    //   533: astore_1
    //   534: aload 9
    //   536: monitorexit
    //   537: aload_1
    //   538: athrow
    //   539: new 143	java/lang/IllegalStateException
    //   542: dup
    //   543: ldc 145
    //   545: invokespecial 148	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   548: astore_1
    //   549: goto +5 -> 554
    //   552: aload_1
    //   553: athrow
    //   554: goto -2 -> 552
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	557	0	this	RelaySource
    //   0	557	1	paramBuffer	okio.Buffer
    //   0	557	2	paramLong	long
    //   91	43	4	i	int
    //   29	459	5	l1	long
    //   20	491	7	l2	long
    //   11	114	9	localRelay1	Relay
    //   251	5	9	localObject1	Object
    //   393	5	9	localRelay2	Relay
    //   436	5	9	localObject2	Object
    //   443	5	9	localObject3	Object
    //   450	27	9	localObject4	Object
    //   479	56	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   230	247	251	finally
    //   253	255	251	finally
    //   417	434	436	finally
    //   438	440	436	finally
    //   321	389	443	finally
    //   389	410	443	finally
    //   445	447	443	finally
    //   177	205	450	finally
    //   214	223	450	finally
    //   258	321	450	finally
    //   447	450	450	finally
    //   459	476	479	finally
    //   481	483	479	finally
    //   16	31	533	finally
    //   39	52	533	finally
    //   56	77	533	finally
    //   80	90	533	finally
    //   93	96	533	finally
    //   99	127	533	finally
    //   486	531	533	finally
    //   534	537	533	finally
  }
  
  public Timeout timeout()
  {
    return this.timeout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.cache2.Relay.RelaySource
 * JD-Core Version:    0.7.0.1
 */