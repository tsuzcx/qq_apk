package rx.internal.util;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.annotations.Experimental;

@Experimental
public final class BackpressureDrainManager
  extends AtomicLong
  implements Producer
{
  protected final BackpressureDrainManager.BackpressureQueueCallback actual;
  protected boolean emitting;
  protected Throwable exception;
  protected volatile boolean terminated;
  
  public BackpressureDrainManager(BackpressureDrainManager.BackpressureQueueCallback paramBackpressureQueueCallback)
  {
    this.actual = paramBackpressureQueueCallback;
  }
  
  /* Error */
  public final void drain()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	rx/internal/util/BackpressureDrainManager:emitting	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 25	rx/internal/util/BackpressureDrainManager:emitting	Z
    //   17: aload_0
    //   18: getfield 27	rx/internal/util/BackpressureDrainManager:terminated	Z
    //   21: istore 6
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_0
    //   26: invokevirtual 31	rx/internal/util/BackpressureDrainManager:get	()J
    //   29: lstore 8
    //   31: iconst_0
    //   32: istore 5
    //   34: iconst_0
    //   35: istore 4
    //   37: iload 4
    //   39: istore_1
    //   40: aload_0
    //   41: getfield 21	rx/internal/util/BackpressureDrainManager:actual	Lrx/internal/util/BackpressureDrainManager$BackpressureQueueCallback;
    //   44: astore 12
    //   46: goto +259 -> 305
    //   49: iload 6
    //   51: ifeq +135 -> 186
    //   54: iload 4
    //   56: istore_1
    //   57: aload 12
    //   59: invokeinterface 37 1 0
    //   64: ifnonnull +42 -> 106
    //   67: iconst_1
    //   68: istore_1
    //   69: aload 12
    //   71: aload_0
    //   72: getfield 39	rx/internal/util/BackpressureDrainManager:exception	Ljava/lang/Throwable;
    //   75: invokeinterface 43 2 0
    //   80: return
    //   81: astore 12
    //   83: iload_1
    //   84: ifne +12 -> 96
    //   87: aload_0
    //   88: monitorenter
    //   89: aload_0
    //   90: iconst_0
    //   91: putfield 25	rx/internal/util/BackpressureDrainManager:emitting	Z
    //   94: aload_0
    //   95: monitorexit
    //   96: aload 12
    //   98: athrow
    //   99: astore 12
    //   101: aload_0
    //   102: monitorexit
    //   103: aload 12
    //   105: athrow
    //   106: lload 8
    //   108: lconst_0
    //   109: lcmp
    //   110: ifne +76 -> 186
    //   113: iload 4
    //   115: istore_1
    //   116: aload_0
    //   117: monitorenter
    //   118: iload 5
    //   120: istore_1
    //   121: aload_0
    //   122: getfield 27	rx/internal/util/BackpressureDrainManager:terminated	Z
    //   125: istore 6
    //   127: iload 5
    //   129: istore_1
    //   130: aload 12
    //   132: invokeinterface 37 1 0
    //   137: ifnull +98 -> 235
    //   140: iconst_1
    //   141: istore_3
    //   142: iload 5
    //   144: istore_1
    //   145: aload_0
    //   146: invokevirtual 31	rx/internal/util/BackpressureDrainManager:get	()J
    //   149: ldc2_w 44
    //   152: lcmp
    //   153: ifne +100 -> 253
    //   156: iload_3
    //   157: ifne +83 -> 240
    //   160: iload 6
    //   162: ifne +78 -> 240
    //   165: iconst_1
    //   166: istore_2
    //   167: iload_2
    //   168: istore_1
    //   169: aload_0
    //   170: iconst_0
    //   171: putfield 25	rx/internal/util/BackpressureDrainManager:emitting	Z
    //   174: iload_2
    //   175: istore_1
    //   176: aload_0
    //   177: monitorexit
    //   178: return
    //   179: astore 12
    //   181: aload_0
    //   182: monitorexit
    //   183: aload 12
    //   185: athrow
    //   186: iload 4
    //   188: istore_1
    //   189: aload 12
    //   191: invokeinterface 48 1 0
    //   196: astore 13
    //   198: aload 13
    //   200: ifnull -87 -> 113
    //   203: iload 4
    //   205: istore_1
    //   206: aload 12
    //   208: aload 13
    //   210: invokeinterface 52 2 0
    //   215: istore 7
    //   217: iload 7
    //   219: ifne +85 -> 304
    //   222: lload 8
    //   224: lconst_1
    //   225: lsub
    //   226: lstore 8
    //   228: iload_2
    //   229: iconst_1
    //   230: iadd
    //   231: istore_2
    //   232: goto +75 -> 307
    //   235: iconst_0
    //   236: istore_3
    //   237: goto -95 -> 142
    //   240: ldc2_w 44
    //   243: lstore 8
    //   245: iload 5
    //   247: istore_1
    //   248: aload_0
    //   249: monitorexit
    //   250: goto +55 -> 305
    //   253: iload 5
    //   255: istore_1
    //   256: aload_0
    //   257: iload_2
    //   258: ineg
    //   259: i2l
    //   260: invokevirtual 56	rx/internal/util/BackpressureDrainManager:addAndGet	(J)J
    //   263: lstore 10
    //   265: lload 10
    //   267: lconst_0
    //   268: lcmp
    //   269: ifeq +53 -> 322
    //   272: lload 10
    //   274: lstore 8
    //   276: iload_3
    //   277: ifne -32 -> 245
    //   280: goto +42 -> 322
    //   283: iconst_1
    //   284: istore_2
    //   285: iload_2
    //   286: istore_1
    //   287: aload_0
    //   288: iconst_0
    //   289: putfield 25	rx/internal/util/BackpressureDrainManager:emitting	Z
    //   292: iload_2
    //   293: istore_1
    //   294: aload_0
    //   295: monitorexit
    //   296: return
    //   297: astore 12
    //   299: aload_0
    //   300: monitorexit
    //   301: aload 12
    //   303: athrow
    //   304: return
    //   305: iconst_0
    //   306: istore_2
    //   307: lload 8
    //   309: lconst_0
    //   310: lcmp
    //   311: ifgt -262 -> 49
    //   314: iload 6
    //   316: ifeq -203 -> 113
    //   319: goto -270 -> 49
    //   322: iload 6
    //   324: ifeq -41 -> 283
    //   327: lload 10
    //   329: lstore 8
    //   331: iload_3
    //   332: ifeq -87 -> 245
    //   335: goto -52 -> 283
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	this	BackpressureDrainManager
    //   39	255	1	i	int
    //   166	141	2	j	int
    //   141	191	3	k	int
    //   35	169	4	m	int
    //   32	222	5	n	int
    //   21	302	6	bool1	boolean
    //   215	3	7	bool2	boolean
    //   29	301	8	l1	long
    //   263	65	10	l2	long
    //   44	26	12	localBackpressureQueueCallback	BackpressureDrainManager.BackpressureQueueCallback
    //   81	16	12	localObject1	java.lang.Object
    //   99	32	12	localObject2	java.lang.Object
    //   179	28	12	localObject3	java.lang.Object
    //   297	5	12	localObject4	java.lang.Object
    //   196	13	13	localObject5	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   40	46	81	finally
    //   57	67	81	finally
    //   69	80	81	finally
    //   116	118	81	finally
    //   183	186	81	finally
    //   189	198	81	finally
    //   206	217	81	finally
    //   2	11	99	finally
    //   12	25	99	finally
    //   101	103	99	finally
    //   121	127	179	finally
    //   130	140	179	finally
    //   145	156	179	finally
    //   169	174	179	finally
    //   176	178	179	finally
    //   181	183	179	finally
    //   248	250	179	finally
    //   256	265	179	finally
    //   287	292	179	finally
    //   294	296	179	finally
    //   89	96	297	finally
    //   299	301	297	finally
  }
  
  public final boolean isTerminated()
  {
    return this.terminated;
  }
  
  public final void request(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    label31:
    label70:
    label98:
    for (;;)
    {
      long l2 = get();
      if (l2 == 0L) {}
      for (int i = 1; l2 == 9223372036854775807L; i = 0)
      {
        if (i == 0) {
          break label70;
        }
        drain();
        return;
      }
      long l1;
      if (paramLong == 9223372036854775807L)
      {
        l1 = paramLong;
        i = 1;
      }
      for (;;)
      {
        if (!compareAndSet(l2, l1)) {
          break label98;
        }
        break label31;
        break;
        if (l2 > 9223372036854775807L - paramLong) {
          l1 = 9223372036854775807L;
        } else {
          l1 = l2 + paramLong;
        }
      }
    }
  }
  
  public final void terminate()
  {
    this.terminated = true;
  }
  
  public final void terminate(Throwable paramThrowable)
  {
    if (!this.terminated)
    {
      this.exception = paramThrowable;
      this.terminated = true;
    }
  }
  
  public final void terminateAndDrain()
  {
    this.terminated = true;
    drain();
  }
  
  public final void terminateAndDrain(Throwable paramThrowable)
  {
    if (!this.terminated)
    {
      this.exception = paramThrowable;
      this.terminated = true;
      drain();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.util.BackpressureDrainManager
 * JD-Core Version:    0.7.0.1
 */