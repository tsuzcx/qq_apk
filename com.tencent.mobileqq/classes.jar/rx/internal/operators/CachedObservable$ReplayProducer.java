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
    //   6: istore 9
    //   8: iconst_1
    //   9: istore 6
    //   11: iconst_1
    //   12: istore 5
    //   14: iload 9
    //   16: ifeq +11 -> 27
    //   19: aload_0
    //   20: iconst_1
    //   21: putfield 57	rx/internal/operators/CachedObservable$ReplayProducer:missed	Z
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: iconst_1
    //   29: putfield 55	rx/internal/operators/CachedObservable$ReplayProducer:emitting	Z
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_0
    //   35: getfield 36	rx/internal/operators/CachedObservable$ReplayProducer:state	Lrx/internal/operators/CachedObservable$CacheState;
    //   38: getfield 63	rx/internal/operators/CachedObservable$CacheState:nl	Lrx/internal/operators/NotificationLite;
    //   41: astore 14
    //   43: aload_0
    //   44: getfield 34	rx/internal/operators/CachedObservable$ReplayProducer:child	Lrx/Subscriber;
    //   47: astore 15
    //   49: aload_0
    //   50: invokevirtual 45	rx/internal/operators/CachedObservable$ReplayProducer:get	()J
    //   53: lstore 10
    //   55: lload 10
    //   57: lconst_0
    //   58: lcmp
    //   59: ifge +4 -> 63
    //   62: return
    //   63: aload_0
    //   64: getfield 36	rx/internal/operators/CachedObservable$ReplayProducer:state	Lrx/internal/operators/CachedObservable$CacheState;
    //   67: invokevirtual 67	rx/internal/operators/CachedObservable$CacheState:size	()I
    //   70: istore 7
    //   72: iload 7
    //   74: ifeq +344 -> 418
    //   77: aload_0
    //   78: getfield 69	rx/internal/operators/CachedObservable$ReplayProducer:currentBuffer	[Ljava/lang/Object;
    //   81: astore 13
    //   83: aload 13
    //   85: astore 12
    //   87: aload 13
    //   89: ifnonnull +18 -> 107
    //   92: aload_0
    //   93: getfield 36	rx/internal/operators/CachedObservable$ReplayProducer:state	Lrx/internal/operators/CachedObservable$CacheState;
    //   96: invokevirtual 73	rx/internal/operators/CachedObservable$CacheState:head	()[Ljava/lang/Object;
    //   99: astore 12
    //   101: aload_0
    //   102: aload 12
    //   104: putfield 69	rx/internal/operators/CachedObservable$ReplayProducer:currentBuffer	[Ljava/lang/Object;
    //   107: aload 12
    //   109: arraylength
    //   110: iconst_1
    //   111: isub
    //   112: istore 8
    //   114: aload_0
    //   115: getfield 75	rx/internal/operators/CachedObservable$ReplayProducer:index	I
    //   118: istore_3
    //   119: aload_0
    //   120: getfield 77	rx/internal/operators/CachedObservable$ReplayProducer:currentIndexInBuffer	I
    //   123: istore_1
    //   124: lload 10
    //   126: lconst_0
    //   127: lcmp
    //   128: ifne +62 -> 190
    //   131: aload 12
    //   133: iload_1
    //   134: aaload
    //   135: astore 12
    //   137: aload 14
    //   139: aload 12
    //   141: invokevirtual 83	rx/internal/operators/NotificationLite:isCompleted	(Ljava/lang/Object;)Z
    //   144: ifeq +16 -> 160
    //   147: aload 15
    //   149: invokevirtual 88	rx/Subscriber:onCompleted	()V
    //   152: iload 5
    //   154: istore_1
    //   155: aload_0
    //   156: invokevirtual 91	rx/internal/operators/CachedObservable$ReplayProducer:unsubscribe	()V
    //   159: return
    //   160: aload 14
    //   162: aload 12
    //   164: invokevirtual 94	rx/internal/operators/NotificationLite:isError	(Ljava/lang/Object;)Z
    //   167: ifeq +251 -> 418
    //   170: aload 15
    //   172: aload 14
    //   174: aload 12
    //   176: invokevirtual 98	rx/internal/operators/NotificationLite:getError	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   179: invokevirtual 102	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
    //   182: iload 5
    //   184: istore_1
    //   185: aload_0
    //   186: invokevirtual 91	rx/internal/operators/CachedObservable$ReplayProducer:unsubscribe	()V
    //   189: return
    //   190: lload 10
    //   192: lconst_0
    //   193: lcmp
    //   194: ifle +224 -> 418
    //   197: iconst_0
    //   198: istore_2
    //   199: aload 12
    //   201: astore 13
    //   203: iload_3
    //   204: iload 7
    //   206: if_icmpge +180 -> 386
    //   209: lload 10
    //   211: lconst_0
    //   212: lcmp
    //   213: ifle +173 -> 386
    //   216: aload 15
    //   218: invokevirtual 104	rx/Subscriber:isUnsubscribed	()Z
    //   221: ifeq +4 -> 225
    //   224: return
    //   225: aload 13
    //   227: astore 12
    //   229: iload_1
    //   230: istore 4
    //   232: iload_1
    //   233: iload 8
    //   235: if_icmpne +19 -> 254
    //   238: aload 13
    //   240: iload 8
    //   242: aaload
    //   243: checkcast 105	[Ljava/lang/Object;
    //   246: checkcast 105	[Ljava/lang/Object;
    //   249: astore 12
    //   251: iconst_0
    //   252: istore 4
    //   254: aload 12
    //   256: iload 4
    //   258: aaload
    //   259: astore 13
    //   261: aload 14
    //   263: aload 15
    //   265: aload 13
    //   267: invokevirtual 109	rx/internal/operators/NotificationLite:accept	(Lrx/Observer;Ljava/lang/Object;)Z
    //   270: istore 9
    //   272: iload 9
    //   274: ifeq +18 -> 292
    //   277: iload 5
    //   279: istore_1
    //   280: aload_0
    //   281: invokevirtual 91	rx/internal/operators/CachedObservable$ReplayProducer:unsubscribe	()V
    //   284: return
    //   285: astore 12
    //   287: iconst_1
    //   288: istore_1
    //   289: goto +33 -> 322
    //   292: iload 4
    //   294: iconst_1
    //   295: iadd
    //   296: istore_1
    //   297: iload_3
    //   298: iconst_1
    //   299: iadd
    //   300: istore_3
    //   301: lload 10
    //   303: lconst_1
    //   304: lsub
    //   305: lstore 10
    //   307: iload_2
    //   308: iconst_1
    //   309: iadd
    //   310: istore_2
    //   311: aload 12
    //   313: astore 13
    //   315: goto -112 -> 203
    //   318: astore 12
    //   320: iconst_0
    //   321: istore_1
    //   322: aload 12
    //   324: invokestatic 114	rx/exceptions/Exceptions:throwIfFatal	(Ljava/lang/Throwable;)V
    //   327: iload 5
    //   329: istore_1
    //   330: aload_0
    //   331: invokevirtual 91	rx/internal/operators/CachedObservable$ReplayProducer:unsubscribe	()V
    //   334: iload 5
    //   336: istore_1
    //   337: aload 14
    //   339: aload 13
    //   341: invokevirtual 94	rx/internal/operators/NotificationLite:isError	(Ljava/lang/Object;)Z
    //   344: ifne +36 -> 380
    //   347: iload 5
    //   349: istore_1
    //   350: aload 14
    //   352: aload 13
    //   354: invokevirtual 83	rx/internal/operators/NotificationLite:isCompleted	(Ljava/lang/Object;)Z
    //   357: ifne +23 -> 380
    //   360: iload 5
    //   362: istore_1
    //   363: aload 15
    //   365: aload 12
    //   367: aload 14
    //   369: aload 13
    //   371: invokevirtual 118	rx/internal/operators/NotificationLite:getValue	(Ljava/lang/Object;)Ljava/lang/Object;
    //   374: invokestatic 124	rx/exceptions/OnErrorThrowable:addValueAsLastCause	(Ljava/lang/Throwable;Ljava/lang/Object;)Ljava/lang/Throwable;
    //   377: invokevirtual 102	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
    //   380: return
    //   381: astore 12
    //   383: goto +92 -> 475
    //   386: aload 15
    //   388: invokevirtual 104	rx/Subscriber:isUnsubscribed	()Z
    //   391: ifeq +4 -> 395
    //   394: return
    //   395: aload_0
    //   396: iload_3
    //   397: putfield 75	rx/internal/operators/CachedObservable$ReplayProducer:index	I
    //   400: aload_0
    //   401: iload_1
    //   402: putfield 77	rx/internal/operators/CachedObservable$ReplayProducer:currentIndexInBuffer	I
    //   405: aload_0
    //   406: aload 13
    //   408: putfield 69	rx/internal/operators/CachedObservable$ReplayProducer:currentBuffer	[Ljava/lang/Object;
    //   411: aload_0
    //   412: iload_2
    //   413: i2l
    //   414: invokevirtual 126	rx/internal/operators/CachedObservable$ReplayProducer:produced	(J)J
    //   417: pop2
    //   418: aload_0
    //   419: monitorenter
    //   420: aload_0
    //   421: getfield 57	rx/internal/operators/CachedObservable$ReplayProducer:missed	Z
    //   424: ifne +14 -> 438
    //   427: aload_0
    //   428: iconst_0
    //   429: putfield 55	rx/internal/operators/CachedObservable$ReplayProducer:emitting	Z
    //   432: iload 6
    //   434: istore_2
    //   435: aload_0
    //   436: monitorexit
    //   437: return
    //   438: aload_0
    //   439: iconst_0
    //   440: putfield 57	rx/internal/operators/CachedObservable$ReplayProducer:missed	Z
    //   443: aload_0
    //   444: monitorexit
    //   445: goto -396 -> 49
    //   448: astore 12
    //   450: iconst_0
    //   451: istore_1
    //   452: iload_1
    //   453: istore_2
    //   454: aload_0
    //   455: monitorexit
    //   456: aload 12
    //   458: athrow
    //   459: astore 12
    //   461: goto +14 -> 475
    //   464: astore 12
    //   466: iload_2
    //   467: istore_1
    //   468: goto -16 -> 452
    //   471: astore 12
    //   473: iconst_0
    //   474: istore_1
    //   475: iload_1
    //   476: ifne +22 -> 498
    //   479: aload_0
    //   480: monitorenter
    //   481: aload_0
    //   482: iconst_0
    //   483: putfield 55	rx/internal/operators/CachedObservable$ReplayProducer:emitting	Z
    //   486: aload_0
    //   487: monitorexit
    //   488: goto +10 -> 498
    //   491: astore 12
    //   493: aload_0
    //   494: monitorexit
    //   495: aload 12
    //   497: athrow
    //   498: aload 12
    //   500: athrow
    //   501: astore 12
    //   503: aload_0
    //   504: monitorexit
    //   505: goto +6 -> 511
    //   508: aload 12
    //   510: athrow
    //   511: goto -3 -> 508
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	514	0	this	ReplayProducer
    //   123	353	1	i	int
    //   198	269	2	j	int
    //   118	279	3	k	int
    //   230	66	4	m	int
    //   12	349	5	n	int
    //   9	424	6	i1	int
    //   70	137	7	i2	int
    //   112	129	8	i3	int
    //   6	267	9	bool	boolean
    //   53	253	10	l	long
    //   85	170	12	localObject1	Object
    //   285	27	12	localThrowable1	java.lang.Throwable
    //   318	48	12	localThrowable2	java.lang.Throwable
    //   381	1	12	localObject2	Object
    //   448	9	12	localObject3	Object
    //   459	1	12	localObject4	Object
    //   464	1	12	localObject5	Object
    //   471	1	12	localObject6	Object
    //   491	8	12	localObject7	Object
    //   501	8	12	localObject8	Object
    //   81	326	13	localObject9	Object
    //   41	327	14	localNotificationLite	NotificationLite
    //   47	340	15	localSubscriber	Subscriber
    // Exception table:
    //   from	to	target	type
    //   280	284	285	java/lang/Throwable
    //   261	272	318	java/lang/Throwable
    //   322	327	381	finally
    //   420	432	448	finally
    //   438	445	448	finally
    //   155	159	459	finally
    //   185	189	459	finally
    //   280	284	459	finally
    //   330	334	459	finally
    //   337	347	459	finally
    //   350	360	459	finally
    //   363	380	459	finally
    //   456	459	459	finally
    //   435	437	464	finally
    //   454	456	464	finally
    //   34	49	471	finally
    //   49	55	471	finally
    //   63	72	471	finally
    //   77	83	471	finally
    //   92	107	471	finally
    //   107	124	471	finally
    //   137	152	471	finally
    //   160	182	471	finally
    //   216	224	471	finally
    //   238	251	471	finally
    //   261	272	471	finally
    //   386	394	471	finally
    //   395	418	471	finally
    //   418	420	471	finally
    //   481	488	491	finally
    //   493	495	491	finally
    //   2	8	501	finally
    //   19	26	501	finally
    //   27	34	501	finally
    //   503	505	501	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.CachedObservable.ReplayProducer
 * JD-Core Version:    0.7.0.1
 */