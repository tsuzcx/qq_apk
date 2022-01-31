package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

final class CachedObservable$ReplayProducer<T>
  extends AtomicLong
  implements Producer, Subscription
{
  private static final long serialVersionUID = -2557562030197141021L;
  final Subscriber<? super T> child;
  Object[] currentBuffer;
  int currentIndexInBuffer;
  boolean emitting;
  int index;
  boolean missed;
  final CachedObservable.CacheState<T> state;
  
  public CachedObservable$ReplayProducer(Subscriber<? super T> paramSubscriber, CachedObservable.CacheState<T> paramCacheState)
  {
    this.child = paramSubscriber;
    this.state = paramCacheState;
  }
  
  public boolean isUnsubscribed()
  {
    return get() < 0L;
  }
  
  public long produced(long paramLong)
  {
    return addAndGet(-paramLong);
  }
  
  /* Error */
  public void replay()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 55	rx/internal/operators/CachedObservable$ReplayProducer:emitting	Z
    //   6: ifeq +11 -> 17
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 57	rx/internal/operators/CachedObservable$ReplayProducer:missed	Z
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 55	rx/internal/operators/CachedObservable$ReplayProducer:emitting	Z
    //   22: aload_0
    //   23: monitorexit
    //   24: iconst_0
    //   25: istore 7
    //   27: iconst_0
    //   28: istore 8
    //   30: iconst_0
    //   31: istore 6
    //   33: iload 6
    //   35: istore_1
    //   36: aload_0
    //   37: getfield 36	rx/internal/operators/CachedObservable$ReplayProducer:state	Lrx/internal/operators/CachedObservable$CacheState;
    //   40: getfield 63	rx/internal/operators/CachedObservable$CacheState:nl	Lrx/internal/operators/NotificationLite;
    //   43: astore 15
    //   45: iload 6
    //   47: istore_1
    //   48: aload_0
    //   49: getfield 34	rx/internal/operators/CachedObservable$ReplayProducer:child	Lrx/Subscriber;
    //   52: astore 16
    //   54: iload 6
    //   56: istore_1
    //   57: aload_0
    //   58: invokevirtual 45	rx/internal/operators/CachedObservable$ReplayProducer:get	()J
    //   61: lstore 11
    //   63: lload 11
    //   65: lconst_0
    //   66: lcmp
    //   67: iflt +444 -> 511
    //   70: iload 6
    //   72: istore_1
    //   73: aload_0
    //   74: getfield 36	rx/internal/operators/CachedObservable$ReplayProducer:state	Lrx/internal/operators/CachedObservable$CacheState;
    //   77: invokevirtual 67	rx/internal/operators/CachedObservable$CacheState:size	()I
    //   80: istore 9
    //   82: iload 9
    //   84: ifeq +369 -> 453
    //   87: iload 6
    //   89: istore_1
    //   90: aload_0
    //   91: getfield 69	rx/internal/operators/CachedObservable$ReplayProducer:currentBuffer	[Ljava/lang/Object;
    //   94: astore 14
    //   96: aload 14
    //   98: astore 13
    //   100: aload 14
    //   102: ifnonnull +24 -> 126
    //   105: iload 6
    //   107: istore_1
    //   108: aload_0
    //   109: getfield 36	rx/internal/operators/CachedObservable$ReplayProducer:state	Lrx/internal/operators/CachedObservable$CacheState;
    //   112: invokevirtual 73	rx/internal/operators/CachedObservable$CacheState:head	()[Ljava/lang/Object;
    //   115: astore 13
    //   117: iload 6
    //   119: istore_1
    //   120: aload_0
    //   121: aload 13
    //   123: putfield 69	rx/internal/operators/CachedObservable$ReplayProducer:currentBuffer	[Ljava/lang/Object;
    //   126: iload 6
    //   128: istore_1
    //   129: aload 13
    //   131: arraylength
    //   132: iconst_1
    //   133: isub
    //   134: istore 10
    //   136: iload 6
    //   138: istore_1
    //   139: aload_0
    //   140: getfield 75	rx/internal/operators/CachedObservable$ReplayProducer:index	I
    //   143: istore 5
    //   145: iload 6
    //   147: istore_1
    //   148: aload_0
    //   149: getfield 77	rx/internal/operators/CachedObservable$ReplayProducer:currentIndexInBuffer	I
    //   152: istore_2
    //   153: lload 11
    //   155: lconst_0
    //   156: lcmp
    //   157: ifne +355 -> 512
    //   160: aload 13
    //   162: iload_2
    //   163: aaload
    //   164: astore 13
    //   166: iload 6
    //   168: istore_1
    //   169: aload 15
    //   171: aload 13
    //   173: invokevirtual 83	rx/internal/operators/NotificationLite:isCompleted	(Ljava/lang/Object;)Z
    //   176: ifeq +43 -> 219
    //   179: iload 6
    //   181: istore_1
    //   182: aload 16
    //   184: invokevirtual 88	rx/Subscriber:onCompleted	()V
    //   187: iconst_1
    //   188: istore_1
    //   189: aload_0
    //   190: invokevirtual 91	rx/internal/operators/CachedObservable$ReplayProducer:unsubscribe	()V
    //   193: return
    //   194: astore 13
    //   196: iload_1
    //   197: ifne +12 -> 209
    //   200: aload_0
    //   201: monitorenter
    //   202: aload_0
    //   203: iconst_0
    //   204: putfield 55	rx/internal/operators/CachedObservable$ReplayProducer:emitting	Z
    //   207: aload_0
    //   208: monitorexit
    //   209: aload 13
    //   211: athrow
    //   212: astore 13
    //   214: aload_0
    //   215: monitorexit
    //   216: aload 13
    //   218: athrow
    //   219: iload 6
    //   221: istore_1
    //   222: aload 15
    //   224: aload 13
    //   226: invokevirtual 94	rx/internal/operators/NotificationLite:isError	(Ljava/lang/Object;)Z
    //   229: ifeq +224 -> 453
    //   232: iload 6
    //   234: istore_1
    //   235: aload 16
    //   237: aload 15
    //   239: aload 13
    //   241: invokevirtual 98	rx/internal/operators/NotificationLite:getError	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   244: invokevirtual 102	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
    //   247: iconst_1
    //   248: istore_1
    //   249: aload_0
    //   250: invokevirtual 91	rx/internal/operators/CachedObservable$ReplayProducer:unsubscribe	()V
    //   253: return
    //   254: iload 5
    //   256: iload 9
    //   258: if_icmpge +148 -> 406
    //   261: lload 11
    //   263: lconst_0
    //   264: lcmp
    //   265: ifle +141 -> 406
    //   268: iload 6
    //   270: istore_1
    //   271: aload 16
    //   273: invokevirtual 104	rx/Subscriber:isUnsubscribed	()Z
    //   276: ifne +235 -> 511
    //   279: iload_2
    //   280: istore 4
    //   282: aload 14
    //   284: astore 13
    //   286: iload_2
    //   287: iload 10
    //   289: if_icmpne +22 -> 311
    //   292: iload 6
    //   294: istore_1
    //   295: aload 14
    //   297: iload 10
    //   299: aaload
    //   300: checkcast 105	[Ljava/lang/Object;
    //   303: checkcast 105	[Ljava/lang/Object;
    //   306: astore 13
    //   308: iconst_0
    //   309: istore 4
    //   311: aload 13
    //   313: iload 4
    //   315: aaload
    //   316: astore 14
    //   318: iload 6
    //   320: istore_1
    //   321: iload 7
    //   323: istore_2
    //   324: aload 15
    //   326: aload 16
    //   328: aload 14
    //   330: invokevirtual 109	rx/internal/operators/NotificationLite:accept	(Lrx/Observer;Ljava/lang/Object;)Z
    //   333: ifeq +195 -> 528
    //   336: iconst_1
    //   337: istore_2
    //   338: iconst_1
    //   339: istore_1
    //   340: aload_0
    //   341: invokevirtual 91	rx/internal/operators/CachedObservable$ReplayProducer:unsubscribe	()V
    //   344: return
    //   345: astore 13
    //   347: iload_2
    //   348: istore_1
    //   349: aload 13
    //   351: invokestatic 114	rx/exceptions/Exceptions:throwIfFatal	(Ljava/lang/Throwable;)V
    //   354: iconst_1
    //   355: istore_2
    //   356: iload_2
    //   357: istore_1
    //   358: aload_0
    //   359: invokevirtual 91	rx/internal/operators/CachedObservable$ReplayProducer:unsubscribe	()V
    //   362: iload_2
    //   363: istore_1
    //   364: aload 15
    //   366: aload 14
    //   368: invokevirtual 94	rx/internal/operators/NotificationLite:isError	(Ljava/lang/Object;)Z
    //   371: ifne +140 -> 511
    //   374: iload_2
    //   375: istore_1
    //   376: aload 15
    //   378: aload 14
    //   380: invokevirtual 83	rx/internal/operators/NotificationLite:isCompleted	(Ljava/lang/Object;)Z
    //   383: ifne +128 -> 511
    //   386: iload_2
    //   387: istore_1
    //   388: aload 16
    //   390: aload 13
    //   392: aload 15
    //   394: aload 14
    //   396: invokevirtual 118	rx/internal/operators/NotificationLite:getValue	(Ljava/lang/Object;)Ljava/lang/Object;
    //   399: invokestatic 124	rx/exceptions/OnErrorThrowable:addValueAsLastCause	(Ljava/lang/Throwable;Ljava/lang/Object;)Ljava/lang/Throwable;
    //   402: invokevirtual 102	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
    //   405: return
    //   406: iload 6
    //   408: istore_1
    //   409: aload 16
    //   411: invokevirtual 104	rx/Subscriber:isUnsubscribed	()Z
    //   414: ifne +97 -> 511
    //   417: iload 6
    //   419: istore_1
    //   420: aload_0
    //   421: iload 5
    //   423: putfield 75	rx/internal/operators/CachedObservable$ReplayProducer:index	I
    //   426: iload 6
    //   428: istore_1
    //   429: aload_0
    //   430: iload_2
    //   431: putfield 77	rx/internal/operators/CachedObservable$ReplayProducer:currentIndexInBuffer	I
    //   434: iload 6
    //   436: istore_1
    //   437: aload_0
    //   438: aload 14
    //   440: putfield 69	rx/internal/operators/CachedObservable$ReplayProducer:currentBuffer	[Ljava/lang/Object;
    //   443: iload 6
    //   445: istore_1
    //   446: aload_0
    //   447: iload_3
    //   448: i2l
    //   449: invokevirtual 126	rx/internal/operators/CachedObservable$ReplayProducer:produced	(J)J
    //   452: pop2
    //   453: iload 6
    //   455: istore_1
    //   456: aload_0
    //   457: monitorenter
    //   458: iload 8
    //   460: istore_1
    //   461: aload_0
    //   462: getfield 57	rx/internal/operators/CachedObservable$ReplayProducer:missed	Z
    //   465: ifne +23 -> 488
    //   468: iload 8
    //   470: istore_1
    //   471: aload_0
    //   472: iconst_0
    //   473: putfield 55	rx/internal/operators/CachedObservable$ReplayProducer:emitting	Z
    //   476: iconst_1
    //   477: istore_1
    //   478: aload_0
    //   479: monitorexit
    //   480: return
    //   481: astore 13
    //   483: aload_0
    //   484: monitorexit
    //   485: aload 13
    //   487: athrow
    //   488: iload 8
    //   490: istore_1
    //   491: aload_0
    //   492: iconst_0
    //   493: putfield 57	rx/internal/operators/CachedObservable$ReplayProducer:missed	Z
    //   496: iload 8
    //   498: istore_1
    //   499: aload_0
    //   500: monitorexit
    //   501: goto -447 -> 54
    //   504: astore 13
    //   506: aload_0
    //   507: monitorexit
    //   508: aload 13
    //   510: athrow
    //   511: return
    //   512: lload 11
    //   514: lconst_0
    //   515: lcmp
    //   516: ifle -63 -> 453
    //   519: iconst_0
    //   520: istore_3
    //   521: aload 13
    //   523: astore 14
    //   525: goto -271 -> 254
    //   528: iload 5
    //   530: iconst_1
    //   531: iadd
    //   532: istore 5
    //   534: lload 11
    //   536: lconst_1
    //   537: lsub
    //   538: lstore 11
    //   540: iload_3
    //   541: iconst_1
    //   542: iadd
    //   543: istore_3
    //   544: iload 4
    //   546: iconst_1
    //   547: iadd
    //   548: istore_2
    //   549: aload 13
    //   551: astore 14
    //   553: goto -299 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	556	0	this	ReplayProducer
    //   35	464	1	i	int
    //   152	397	2	j	int
    //   447	97	3	k	int
    //   280	268	4	m	int
    //   143	390	5	n	int
    //   31	423	6	i1	int
    //   25	297	7	i2	int
    //   28	469	8	i3	int
    //   80	179	9	i4	int
    //   134	164	10	i5	int
    //   61	478	11	l	long
    //   98	74	13	localObject1	Object
    //   194	16	13	localObject2	Object
    //   212	28	13	localObject3	Object
    //   284	28	13	localObject4	Object
    //   345	46	13	localThrowable	java.lang.Throwable
    //   481	5	13	localObject5	Object
    //   504	46	13	localObject6	Object
    //   94	458	14	localObject7	Object
    //   43	350	15	localNotificationLite	NotificationLite
    //   52	358	16	localSubscriber	Subscriber
    // Exception table:
    //   from	to	target	type
    //   36	45	194	finally
    //   48	54	194	finally
    //   57	63	194	finally
    //   73	82	194	finally
    //   90	96	194	finally
    //   108	117	194	finally
    //   120	126	194	finally
    //   129	136	194	finally
    //   139	145	194	finally
    //   148	153	194	finally
    //   169	179	194	finally
    //   182	187	194	finally
    //   189	193	194	finally
    //   222	232	194	finally
    //   235	247	194	finally
    //   249	253	194	finally
    //   271	279	194	finally
    //   295	308	194	finally
    //   324	336	194	finally
    //   340	344	194	finally
    //   349	354	194	finally
    //   358	362	194	finally
    //   364	374	194	finally
    //   376	386	194	finally
    //   388	405	194	finally
    //   409	417	194	finally
    //   420	426	194	finally
    //   429	434	194	finally
    //   437	443	194	finally
    //   446	453	194	finally
    //   456	458	194	finally
    //   485	488	194	finally
    //   2	16	212	finally
    //   17	24	212	finally
    //   214	216	212	finally
    //   324	336	345	java/lang/Throwable
    //   340	344	345	java/lang/Throwable
    //   461	468	481	finally
    //   471	476	481	finally
    //   478	480	481	finally
    //   483	485	481	finally
    //   491	496	481	finally
    //   499	501	481	finally
    //   202	209	504	finally
    //   506	508	504	finally
  }
  
  public void request(long paramLong)
  {
    long l3;
    long l1;
    do
    {
      l3 = get();
      if (l3 < 0L) {
        return;
      }
      long l2 = l3 + paramLong;
      l1 = l2;
      if (l2 < 0L) {
        l1 = 9223372036854775807L;
      }
    } while (!compareAndSet(l3, l1));
    replay();
  }
  
  public void unsubscribe()
  {
    if ((get() >= 0L) && (getAndSet(-1L) >= 0L)) {
      this.state.removeProducer(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.CachedObservable.ReplayProducer
 * JD-Core Version:    0.7.0.1
 */