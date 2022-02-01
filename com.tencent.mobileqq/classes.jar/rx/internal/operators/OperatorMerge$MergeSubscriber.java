package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.atomic.SpscExactAtomicArrayQueue;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.Pow2;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.subscriptions.CompositeSubscription;

final class OperatorMerge$MergeSubscriber<T>
  extends Subscriber<Observable<? extends T>>
{
  static final OperatorMerge.InnerSubscriber<?>[] EMPTY = new OperatorMerge.InnerSubscriber[0];
  final Subscriber<? super T> child;
  final boolean delayErrors;
  volatile boolean done;
  boolean emitting;
  volatile ConcurrentLinkedQueue<Throwable> errors;
  final Object innerGuard;
  volatile OperatorMerge.InnerSubscriber<?>[] innerSubscribers;
  long lastId;
  int lastIndex;
  final int maxConcurrent;
  boolean missed;
  final NotificationLite<T> nl;
  OperatorMerge.MergeProducer<T> producer;
  volatile Queue<Object> queue;
  int scalarEmissionCount;
  final int scalarEmissionLimit;
  volatile CompositeSubscription subscriptions;
  long uniqueId;
  
  public OperatorMerge$MergeSubscriber(Subscriber<? super T> paramSubscriber, boolean paramBoolean, int paramInt)
  {
    this.child = paramSubscriber;
    this.delayErrors = paramBoolean;
    this.maxConcurrent = paramInt;
    this.nl = NotificationLite.instance();
    this.innerGuard = new Object();
    this.innerSubscribers = EMPTY;
    if (paramInt == 2147483647)
    {
      this.scalarEmissionLimit = 2147483647;
      request(9223372036854775807L);
      return;
    }
    this.scalarEmissionLimit = Math.max(1, paramInt >> 1);
    request(paramInt);
  }
  
  private void reportError()
  {
    ArrayList localArrayList = new ArrayList(this.errors);
    if (localArrayList.size() == 1)
    {
      this.child.onError((Throwable)localArrayList.get(0));
      return;
    }
    this.child.onError(new CompositeException(localArrayList));
  }
  
  void addInner(OperatorMerge.InnerSubscriber<T> paramInnerSubscriber)
  {
    getOrCreateComposite().add(paramInnerSubscriber);
    synchronized (this.innerGuard)
    {
      OperatorMerge.InnerSubscriber[] arrayOfInnerSubscriber1 = this.innerSubscribers;
      int i = arrayOfInnerSubscriber1.length;
      OperatorMerge.InnerSubscriber[] arrayOfInnerSubscriber2 = new OperatorMerge.InnerSubscriber[i + 1];
      System.arraycopy(arrayOfInnerSubscriber1, 0, arrayOfInnerSubscriber2, 0, i);
      arrayOfInnerSubscriber2[i] = paramInnerSubscriber;
      this.innerSubscribers = arrayOfInnerSubscriber2;
      return;
    }
  }
  
  boolean checkTerminate()
  {
    if (this.child.isUnsubscribed()) {
      return true;
    }
    ConcurrentLinkedQueue localConcurrentLinkedQueue = this.errors;
    if ((!this.delayErrors) && (localConcurrentLinkedQueue != null) && (!localConcurrentLinkedQueue.isEmpty())) {
      try
      {
        reportError();
        return true;
      }
      finally
      {
        unsubscribe();
      }
    }
    return false;
  }
  
  void emit()
  {
    try
    {
      if (this.emitting)
      {
        this.missed = true;
        return;
      }
      this.emitting = true;
      emitLoop();
      return;
    }
    finally {}
  }
  
  /* Error */
  void emitLoop()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	rx/internal/operators/OperatorMerge$MergeSubscriber:child	Lrx/Subscriber;
    //   4: astore 14
    //   6: aload_0
    //   7: invokevirtual 161	rx/internal/operators/OperatorMerge$MergeSubscriber:checkTerminate	()Z
    //   10: ifeq +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 163	rx/internal/operators/OperatorMerge$MergeSubscriber:queue	Ljava/util/Queue;
    //   18: astore 16
    //   20: aload_0
    //   21: getfield 165	rx/internal/operators/OperatorMerge$MergeSubscriber:producer	Lrx/internal/operators/OperatorMerge$MergeProducer;
    //   24: invokevirtual 170	rx/internal/operators/OperatorMerge$MergeProducer:get	()J
    //   27: lstore 9
    //   29: lload 9
    //   31: ldc2_w 77
    //   34: lcmp
    //   35: ifne +625 -> 660
    //   38: iconst_1
    //   39: istore 5
    //   41: goto +622 -> 663
    //   44: lload 9
    //   46: lconst_0
    //   47: lcmp
    //   48: ifle +657 -> 705
    //   51: aload 16
    //   53: invokeinterface 174 1 0
    //   58: astore 15
    //   60: aload_0
    //   61: invokevirtual 161	rx/internal/operators/OperatorMerge$MergeSubscriber:checkTerminate	()Z
    //   64: ifeq +616 -> 680
    //   67: return
    //   68: aload_0
    //   69: getfield 66	rx/internal/operators/OperatorMerge$MergeSubscriber:nl	Lrx/internal/operators/NotificationLite;
    //   72: aload 15
    //   74: invokevirtual 178	rx/internal/operators/NotificationLite:getValue	(Ljava/lang/Object;)Ljava/lang/Object;
    //   77: astore 17
    //   79: aload 14
    //   81: aload 17
    //   83: invokevirtual 182	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   86: goto +602 -> 688
    //   89: astore 17
    //   91: aload_0
    //   92: getfield 56	rx/internal/operators/OperatorMerge$MergeSubscriber:delayErrors	Z
    //   95: ifne +27 -> 122
    //   98: aload 17
    //   100: invokestatic 187	rx/exceptions/Exceptions:throwIfFatal	(Ljava/lang/Throwable;)V
    //   103: aload_0
    //   104: invokevirtual 151	rx/internal/operators/OperatorMerge$MergeSubscriber:unsubscribe	()V
    //   107: aload 14
    //   109: aload 17
    //   111: invokevirtual 114	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
    //   114: return
    //   115: astore 14
    //   117: iconst_1
    //   118: istore_1
    //   119: goto +509 -> 628
    //   122: aload_0
    //   123: invokevirtual 191	rx/internal/operators/OperatorMerge$MergeSubscriber:getOrCreateErrorQueue	()Ljava/util/Queue;
    //   126: aload 17
    //   128: invokeinterface 195 2 0
    //   133: pop
    //   134: goto +554 -> 688
    //   137: aload_0
    //   138: getfield 165	rx/internal/operators/OperatorMerge$MergeSubscriber:producer	Lrx/internal/operators/OperatorMerge$MergeProducer;
    //   141: iload_1
    //   142: invokevirtual 199	rx/internal/operators/OperatorMerge$MergeProducer:produced	(I)J
    //   145: lstore 9
    //   147: goto +572 -> 719
    //   150: aload_0
    //   151: getfield 201	rx/internal/operators/OperatorMerge$MergeSubscriber:done	Z
    //   154: istore 13
    //   156: aload_0
    //   157: getfield 163	rx/internal/operators/OperatorMerge$MergeSubscriber:queue	Ljava/util/Queue;
    //   160: astore 15
    //   162: aload_0
    //   163: getfield 73	rx/internal/operators/OperatorMerge$MergeSubscriber:innerSubscribers	[Lrx/internal/operators/OperatorMerge$InnerSubscriber;
    //   166: astore 17
    //   168: aload 17
    //   170: arraylength
    //   171: istore 8
    //   173: iload 13
    //   175: ifeq +58 -> 233
    //   178: aload 15
    //   180: ifnull +13 -> 193
    //   183: aload 15
    //   185: invokeinterface 146 1 0
    //   190: ifeq +43 -> 233
    //   193: iload 8
    //   195: ifne +38 -> 233
    //   198: aload_0
    //   199: getfield 95	rx/internal/operators/OperatorMerge$MergeSubscriber:errors	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   202: astore 15
    //   204: aload 15
    //   206: ifnull +21 -> 227
    //   209: aload 15
    //   211: invokeinterface 146 1 0
    //   216: ifeq +6 -> 222
    //   219: goto +8 -> 227
    //   222: aload_0
    //   223: invokespecial 148	rx/internal/operators/OperatorMerge$MergeSubscriber:reportError	()V
    //   226: return
    //   227: aload 14
    //   229: invokevirtual 204	rx/Subscriber:onCompleted	()V
    //   232: return
    //   233: iload 8
    //   235: ifle +686 -> 921
    //   238: aload_0
    //   239: getfield 206	rx/internal/operators/OperatorMerge$MergeSubscriber:lastId	J
    //   242: lstore 9
    //   244: aload_0
    //   245: getfield 208	rx/internal/operators/OperatorMerge$MergeSubscriber:lastIndex	I
    //   248: istore_3
    //   249: iload 8
    //   251: iload_3
    //   252: if_icmple +508 -> 760
    //   255: iload_3
    //   256: istore_2
    //   257: aload 17
    //   259: iload_3
    //   260: aaload
    //   261: getfield 211	rx/internal/operators/OperatorMerge$InnerSubscriber:id	J
    //   264: lload 9
    //   266: lcmp
    //   267: ifeq +530 -> 797
    //   270: goto +490 -> 760
    //   273: iload_3
    //   274: iload 8
    //   276: if_icmpge +19 -> 295
    //   279: aload 17
    //   281: iload_2
    //   282: aaload
    //   283: getfield 211	rx/internal/operators/OperatorMerge$InnerSubscriber:id	J
    //   286: lload 9
    //   288: lcmp
    //   289: ifne +486 -> 775
    //   292: goto +3 -> 295
    //   295: aload_0
    //   296: iload_2
    //   297: putfield 208	rx/internal/operators/OperatorMerge$MergeSubscriber:lastIndex	I
    //   300: aload_0
    //   301: aload 17
    //   303: iload_2
    //   304: aaload
    //   305: getfield 211	rx/internal/operators/OperatorMerge$InnerSubscriber:id	J
    //   308: putfield 206	rx/internal/operators/OperatorMerge$MergeSubscriber:lastId	J
    //   311: goto +486 -> 797
    //   314: iload 6
    //   316: iload 8
    //   318: if_icmpge +598 -> 916
    //   321: aload_0
    //   322: invokevirtual 161	rx/internal/operators/OperatorMerge$MergeSubscriber:checkTerminate	()Z
    //   325: ifeq +491 -> 816
    //   328: return
    //   329: aload 15
    //   331: astore 16
    //   333: lload 9
    //   335: lconst_0
    //   336: lcmp
    //   337: ifle +494 -> 831
    //   340: aload_0
    //   341: invokevirtual 161	rx/internal/operators/OperatorMerge$MergeSubscriber:checkTerminate	()Z
    //   344: ifeq +4 -> 348
    //   347: return
    //   348: aload 18
    //   350: getfield 214	rx/internal/operators/OperatorMerge$InnerSubscriber:queue	Lrx/internal/util/RxRingBuffer;
    //   353: astore 16
    //   355: aload 16
    //   357: ifnonnull +10 -> 367
    //   360: aload 15
    //   362: astore 16
    //   364: goto +467 -> 831
    //   367: aload 16
    //   369: invokevirtual 217	rx/internal/util/RxRingBuffer:poll	()Ljava/lang/Object;
    //   372: astore 15
    //   374: aload 15
    //   376: ifnonnull +10 -> 386
    //   379: aload 15
    //   381: astore 16
    //   383: goto +448 -> 831
    //   386: aload_0
    //   387: getfield 66	rx/internal/operators/OperatorMerge$MergeSubscriber:nl	Lrx/internal/operators/NotificationLite;
    //   390: aload 15
    //   392: invokevirtual 178	rx/internal/operators/NotificationLite:getValue	(Ljava/lang/Object;)Ljava/lang/Object;
    //   395: astore 16
    //   397: aload 14
    //   399: aload 16
    //   401: invokevirtual 182	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   404: lload 9
    //   406: lconst_1
    //   407: lsub
    //   408: lstore 9
    //   410: iload_1
    //   411: iconst_1
    //   412: iadd
    //   413: istore_1
    //   414: goto -85 -> 329
    //   417: astore 15
    //   419: aload 15
    //   421: invokestatic 187	rx/exceptions/Exceptions:throwIfFatal	(Ljava/lang/Throwable;)V
    //   424: aload 14
    //   426: aload 15
    //   428: invokevirtual 114	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
    //   431: aload_0
    //   432: invokevirtual 151	rx/internal/operators/OperatorMerge$MergeSubscriber:unsubscribe	()V
    //   435: return
    //   436: astore 14
    //   438: aload_0
    //   439: invokevirtual 151	rx/internal/operators/OperatorMerge$MergeSubscriber:unsubscribe	()V
    //   442: aload 14
    //   444: athrow
    //   445: iload_1
    //   446: ifle +396 -> 842
    //   449: iload 5
    //   451: ifne +383 -> 834
    //   454: aload_0
    //   455: getfield 165	rx/internal/operators/OperatorMerge$MergeSubscriber:producer	Lrx/internal/operators/OperatorMerge$MergeProducer;
    //   458: iload_1
    //   459: invokevirtual 199	rx/internal/operators/OperatorMerge$MergeProducer:produced	(I)J
    //   462: lstore 9
    //   464: goto +3 -> 467
    //   467: aload 18
    //   469: iload_1
    //   470: i2l
    //   471: invokevirtual 220	rx/internal/operators/OperatorMerge$InnerSubscriber:requestMore	(J)V
    //   474: goto +368 -> 842
    //   477: aload 18
    //   479: getfield 221	rx/internal/operators/OperatorMerge$InnerSubscriber:done	Z
    //   482: istore 13
    //   484: aload 18
    //   486: getfield 214	rx/internal/operators/OperatorMerge$InnerSubscriber:queue	Lrx/internal/util/RxRingBuffer;
    //   489: astore 15
    //   491: iload_2
    //   492: istore 4
    //   494: iload_3
    //   495: istore_1
    //   496: iload 13
    //   498: ifeq +373 -> 871
    //   501: aload 15
    //   503: ifnull +16 -> 519
    //   506: iload_2
    //   507: istore 4
    //   509: iload_3
    //   510: istore_1
    //   511: aload 15
    //   513: invokevirtual 222	rx/internal/util/RxRingBuffer:isEmpty	()Z
    //   516: ifeq +355 -> 871
    //   519: aload_0
    //   520: aload 18
    //   522: invokevirtual 225	rx/internal/operators/OperatorMerge$MergeSubscriber:removeInner	(Lrx/internal/operators/OperatorMerge$InnerSubscriber;)V
    //   525: aload_0
    //   526: invokevirtual 161	rx/internal/operators/OperatorMerge$MergeSubscriber:checkTerminate	()Z
    //   529: ifeq +335 -> 864
    //   532: return
    //   533: aload_0
    //   534: iload 7
    //   536: putfield 208	rx/internal/operators/OperatorMerge$MergeSubscriber:lastIndex	I
    //   539: aload_0
    //   540: aload 17
    //   542: iload 7
    //   544: aaload
    //   545: getfield 211	rx/internal/operators/OperatorMerge$InnerSubscriber:id	J
    //   548: putfield 206	rx/internal/operators/OperatorMerge$MergeSubscriber:lastId	J
    //   551: goto +3 -> 554
    //   554: iload_1
    //   555: ifle +371 -> 926
    //   558: aload_0
    //   559: iload_1
    //   560: i2l
    //   561: invokevirtual 82	rx/internal/operators/OperatorMerge$MergeSubscriber:request	(J)V
    //   564: goto +362 -> 926
    //   567: aload_0
    //   568: monitorenter
    //   569: aload_0
    //   570: getfield 156	rx/internal/operators/OperatorMerge$MergeSubscriber:missed	Z
    //   573: istore 13
    //   575: iload 13
    //   577: ifne +18 -> 595
    //   580: aload_0
    //   581: iconst_0
    //   582: putfield 154	rx/internal/operators/OperatorMerge$MergeSubscriber:emitting	Z
    //   585: aload_0
    //   586: monitorexit
    //   587: return
    //   588: astore 14
    //   590: iconst_1
    //   591: istore_1
    //   592: goto +17 -> 609
    //   595: aload_0
    //   596: iconst_0
    //   597: putfield 156	rx/internal/operators/OperatorMerge$MergeSubscriber:missed	Z
    //   600: aload_0
    //   601: monitorexit
    //   602: goto +328 -> 930
    //   605: astore 14
    //   607: iconst_0
    //   608: istore_1
    //   609: aload_0
    //   610: monitorexit
    //   611: aload 14
    //   613: athrow
    //   614: astore 14
    //   616: goto +12 -> 628
    //   619: astore 14
    //   621: goto -12 -> 609
    //   624: astore 14
    //   626: iconst_0
    //   627: istore_1
    //   628: iload_1
    //   629: ifne +22 -> 651
    //   632: aload_0
    //   633: monitorenter
    //   634: aload_0
    //   635: iconst_0
    //   636: putfield 154	rx/internal/operators/OperatorMerge$MergeSubscriber:emitting	Z
    //   639: aload_0
    //   640: monitorexit
    //   641: goto +10 -> 651
    //   644: astore 14
    //   646: aload_0
    //   647: monitorexit
    //   648: aload 14
    //   650: athrow
    //   651: goto +6 -> 657
    //   654: aload 14
    //   656: athrow
    //   657: goto -3 -> 654
    //   660: iconst_0
    //   661: istore 5
    //   663: aload 16
    //   665: ifnull +86 -> 751
    //   668: iconst_0
    //   669: istore_1
    //   670: iload_1
    //   671: istore_2
    //   672: aconst_null
    //   673: astore 15
    //   675: iconst_0
    //   676: istore_1
    //   677: goto -633 -> 44
    //   680: aload 15
    //   682: ifnonnull -614 -> 68
    //   685: goto +20 -> 705
    //   688: iload_2
    //   689: iconst_1
    //   690: iadd
    //   691: istore_2
    //   692: iload_1
    //   693: iconst_1
    //   694: iadd
    //   695: istore_1
    //   696: lload 9
    //   698: lconst_1
    //   699: lsub
    //   700: lstore 9
    //   702: goto -658 -> 44
    //   705: iload_1
    //   706: ifle +13 -> 719
    //   709: iload 5
    //   711: ifeq -574 -> 137
    //   714: ldc2_w 77
    //   717: lstore 9
    //   719: lload 9
    //   721: lstore 11
    //   723: iload_2
    //   724: istore_1
    //   725: lload 9
    //   727: lconst_0
    //   728: lcmp
    //   729: ifeq -579 -> 150
    //   732: aload 15
    //   734: ifnonnull +12 -> 746
    //   737: lload 9
    //   739: lstore 11
    //   741: iload_2
    //   742: istore_1
    //   743: goto -593 -> 150
    //   746: iload_2
    //   747: istore_1
    //   748: goto -78 -> 670
    //   751: iconst_0
    //   752: istore_1
    //   753: lload 9
    //   755: lstore 11
    //   757: goto -607 -> 150
    //   760: iload_3
    //   761: istore_2
    //   762: iload 8
    //   764: iload_3
    //   765: if_icmpgt +5 -> 770
    //   768: iconst_0
    //   769: istore_2
    //   770: iconst_0
    //   771: istore_3
    //   772: goto -499 -> 273
    //   775: iload_2
    //   776: iconst_1
    //   777: iadd
    //   778: istore_2
    //   779: iload_2
    //   780: iload 8
    //   782: if_icmpne +8 -> 790
    //   785: iconst_0
    //   786: istore_2
    //   787: goto +3 -> 790
    //   790: iload_3
    //   791: iconst_1
    //   792: iadd
    //   793: istore_3
    //   794: goto -521 -> 273
    //   797: iconst_0
    //   798: istore 6
    //   800: iconst_0
    //   801: istore_3
    //   802: iload_2
    //   803: istore 7
    //   805: iload_3
    //   806: istore_2
    //   807: lload 11
    //   809: lstore 9
    //   811: iload_1
    //   812: istore_3
    //   813: goto -499 -> 314
    //   816: aload 17
    //   818: iload 7
    //   820: aaload
    //   821: astore 18
    //   823: aconst_null
    //   824: astore 15
    //   826: iconst_0
    //   827: istore_1
    //   828: goto -499 -> 329
    //   831: goto -386 -> 445
    //   834: ldc2_w 77
    //   837: lstore 9
    //   839: goto -372 -> 467
    //   842: lload 9
    //   844: lconst_0
    //   845: lcmp
    //   846: ifeq -369 -> 477
    //   849: aload 16
    //   851: ifnonnull +6 -> 857
    //   854: goto -377 -> 477
    //   857: aload 16
    //   859: astore 15
    //   861: goto -35 -> 826
    //   864: iload_3
    //   865: iconst_1
    //   866: iadd
    //   867: istore_1
    //   868: iconst_1
    //   869: istore 4
    //   871: lload 9
    //   873: lconst_0
    //   874: lcmp
    //   875: ifne +9 -> 884
    //   878: iload 4
    //   880: istore_2
    //   881: goto -348 -> 533
    //   884: iload 7
    //   886: iconst_1
    //   887: iadd
    //   888: istore_3
    //   889: iload_3
    //   890: istore_2
    //   891: iload_3
    //   892: iload 8
    //   894: if_icmpne +5 -> 899
    //   897: iconst_0
    //   898: istore_2
    //   899: iload 6
    //   901: iconst_1
    //   902: iadd
    //   903: istore 6
    //   905: iload_2
    //   906: istore 7
    //   908: iload 4
    //   910: istore_2
    //   911: iload_1
    //   912: istore_3
    //   913: goto -599 -> 314
    //   916: iload_3
    //   917: istore_1
    //   918: goto -385 -> 533
    //   921: iconst_0
    //   922: istore_2
    //   923: goto -369 -> 554
    //   926: iload_2
    //   927: ifeq -360 -> 567
    //   930: goto -924 -> 6
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	933	0	this	MergeSubscriber
    //   118	800	1	i	int
    //   256	671	2	j	int
    //   248	669	3	k	int
    //   492	417	4	m	int
    //   39	671	5	n	int
    //   314	590	6	i1	int
    //   534	373	7	i2	int
    //   171	724	8	i3	int
    //   27	845	9	l1	long
    //   721	87	11	l2	long
    //   154	422	13	bool	boolean
    //   4	104	14	localSubscriber	Subscriber
    //   115	310	14	localObject1	Object
    //   436	7	14	localObject2	Object
    //   588	1	14	localObject3	Object
    //   605	7	14	localObject4	Object
    //   614	1	14	localObject5	Object
    //   619	1	14	localObject6	Object
    //   624	1	14	localObject7	Object
    //   644	11	14	localObject8	Object
    //   58	333	15	localObject9	Object
    //   417	10	15	localThrowable1	Throwable
    //   489	371	15	localObject10	Object
    //   18	840	16	localObject11	Object
    //   77	5	17	localObject12	Object
    //   89	38	17	localThrowable2	Throwable
    //   166	651	17	arrayOfInnerSubscriber	OperatorMerge.InnerSubscriber[]
    //   348	474	18	localInnerSubscriber	OperatorMerge.InnerSubscriber
    // Exception table:
    //   from	to	target	type
    //   79	86	89	java/lang/Throwable
    //   103	114	115	finally
    //   419	424	115	finally
    //   431	435	115	finally
    //   438	445	115	finally
    //   397	404	417	java/lang/Throwable
    //   424	431	436	finally
    //   580	587	588	finally
    //   569	575	605	finally
    //   595	602	605	finally
    //   611	614	614	finally
    //   609	611	619	finally
    //   0	6	624	finally
    //   6	13	624	finally
    //   14	29	624	finally
    //   51	67	624	finally
    //   68	79	624	finally
    //   79	86	624	finally
    //   91	103	624	finally
    //   122	134	624	finally
    //   137	147	624	finally
    //   150	173	624	finally
    //   183	193	624	finally
    //   198	204	624	finally
    //   209	219	624	finally
    //   222	226	624	finally
    //   227	232	624	finally
    //   238	249	624	finally
    //   257	270	624	finally
    //   279	292	624	finally
    //   295	311	624	finally
    //   321	328	624	finally
    //   340	347	624	finally
    //   348	355	624	finally
    //   367	374	624	finally
    //   386	397	624	finally
    //   397	404	624	finally
    //   454	464	624	finally
    //   467	474	624	finally
    //   477	491	624	finally
    //   511	519	624	finally
    //   519	532	624	finally
    //   533	551	624	finally
    //   558	564	624	finally
    //   567	569	624	finally
    //   634	641	644	finally
    //   646	648	644	finally
  }
  
  /* Error */
  protected void emitScalar(T paramT, long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: getfield 54	rx/internal/operators/OperatorMerge$MergeSubscriber:child	Lrx/Subscriber;
    //   7: aload_1
    //   8: invokevirtual 182	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   11: goto +47 -> 58
    //   14: astore_1
    //   15: iconst_0
    //   16: istore 4
    //   18: goto +129 -> 147
    //   21: astore_1
    //   22: aload_0
    //   23: getfield 56	rx/internal/operators/OperatorMerge$MergeSubscriber:delayErrors	Z
    //   26: ifne +21 -> 47
    //   29: aload_1
    //   30: invokestatic 187	rx/exceptions/Exceptions:throwIfFatal	(Ljava/lang/Throwable;)V
    //   33: aload_0
    //   34: invokevirtual 151	rx/internal/operators/OperatorMerge$MergeSubscriber:unsubscribe	()V
    //   37: aload_0
    //   38: aload_1
    //   39: invokevirtual 228	rx/internal/operators/OperatorMerge$MergeSubscriber:onError	(Ljava/lang/Throwable;)V
    //   42: return
    //   43: astore_1
    //   44: goto +103 -> 147
    //   47: aload_0
    //   48: invokevirtual 191	rx/internal/operators/OperatorMerge$MergeSubscriber:getOrCreateErrorQueue	()Ljava/util/Queue;
    //   51: aload_1
    //   52: invokeinterface 195 2 0
    //   57: pop
    //   58: lload_2
    //   59: ldc2_w 77
    //   62: lcmp
    //   63: ifeq +12 -> 75
    //   66: aload_0
    //   67: getfield 165	rx/internal/operators/OperatorMerge$MergeSubscriber:producer	Lrx/internal/operators/OperatorMerge$MergeProducer;
    //   70: iconst_1
    //   71: invokevirtual 199	rx/internal/operators/OperatorMerge$MergeProducer:produced	(I)J
    //   74: pop2
    //   75: aload_0
    //   76: getfield 230	rx/internal/operators/OperatorMerge$MergeSubscriber:scalarEmissionCount	I
    //   79: iconst_1
    //   80: iadd
    //   81: istore 5
    //   83: iload 5
    //   85: aload_0
    //   86: getfield 76	rx/internal/operators/OperatorMerge$MergeSubscriber:scalarEmissionLimit	I
    //   89: if_icmpne +18 -> 107
    //   92: aload_0
    //   93: iconst_0
    //   94: putfield 230	rx/internal/operators/OperatorMerge$MergeSubscriber:scalarEmissionCount	I
    //   97: aload_0
    //   98: iload 5
    //   100: i2l
    //   101: invokevirtual 231	rx/internal/operators/OperatorMerge$MergeSubscriber:requestMore	(J)V
    //   104: goto +9 -> 113
    //   107: aload_0
    //   108: iload 5
    //   110: putfield 230	rx/internal/operators/OperatorMerge$MergeSubscriber:scalarEmissionCount	I
    //   113: aload_0
    //   114: monitorenter
    //   115: aload_0
    //   116: getfield 156	rx/internal/operators/OperatorMerge$MergeSubscriber:missed	Z
    //   119: ifne +11 -> 130
    //   122: aload_0
    //   123: iconst_0
    //   124: putfield 154	rx/internal/operators/OperatorMerge$MergeSubscriber:emitting	Z
    //   127: aload_0
    //   128: monitorexit
    //   129: return
    //   130: aload_0
    //   131: iconst_0
    //   132: putfield 156	rx/internal/operators/OperatorMerge$MergeSubscriber:missed	Z
    //   135: aload_0
    //   136: monitorexit
    //   137: aload_0
    //   138: invokevirtual 159	rx/internal/operators/OperatorMerge$MergeSubscriber:emitLoop	()V
    //   141: return
    //   142: astore_1
    //   143: aload_0
    //   144: monitorexit
    //   145: aload_1
    //   146: athrow
    //   147: iload 4
    //   149: ifne +20 -> 169
    //   152: aload_0
    //   153: monitorenter
    //   154: aload_0
    //   155: iconst_0
    //   156: putfield 154	rx/internal/operators/OperatorMerge$MergeSubscriber:emitting	Z
    //   159: aload_0
    //   160: monitorexit
    //   161: goto +8 -> 169
    //   164: astore_1
    //   165: aload_0
    //   166: monitorexit
    //   167: aload_1
    //   168: athrow
    //   169: aload_1
    //   170: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	MergeSubscriber
    //   0	171	1	paramT	T
    //   0	171	2	paramLong	long
    //   1	147	4	i	int
    //   81	28	5	j	int
    // Exception table:
    //   from	to	target	type
    //   3	11	14	finally
    //   22	33	14	finally
    //   47	58	14	finally
    //   66	75	14	finally
    //   75	104	14	finally
    //   107	113	14	finally
    //   113	115	14	finally
    //   3	11	21	java/lang/Throwable
    //   33	42	43	finally
    //   145	147	43	finally
    //   115	129	142	finally
    //   130	137	142	finally
    //   143	145	142	finally
    //   154	161	164	finally
    //   165	167	164	finally
  }
  
  /* Error */
  protected void emitScalar(OperatorMerge.InnerSubscriber<T> paramInnerSubscriber, T paramT, long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: aload_0
    //   4: getfield 54	rx/internal/operators/OperatorMerge$MergeSubscriber:child	Lrx/Subscriber;
    //   7: aload_2
    //   8: invokevirtual 182	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   11: goto +47 -> 58
    //   14: astore_1
    //   15: iconst_0
    //   16: istore 5
    //   18: goto +96 -> 114
    //   21: astore_2
    //   22: aload_0
    //   23: getfield 56	rx/internal/operators/OperatorMerge$MergeSubscriber:delayErrors	Z
    //   26: ifne +21 -> 47
    //   29: aload_2
    //   30: invokestatic 187	rx/exceptions/Exceptions:throwIfFatal	(Ljava/lang/Throwable;)V
    //   33: aload_1
    //   34: invokevirtual 234	rx/internal/operators/OperatorMerge$InnerSubscriber:unsubscribe	()V
    //   37: aload_1
    //   38: aload_2
    //   39: invokevirtual 235	rx/internal/operators/OperatorMerge$InnerSubscriber:onError	(Ljava/lang/Throwable;)V
    //   42: return
    //   43: astore_1
    //   44: goto +70 -> 114
    //   47: aload_0
    //   48: invokevirtual 191	rx/internal/operators/OperatorMerge$MergeSubscriber:getOrCreateErrorQueue	()Ljava/util/Queue;
    //   51: aload_2
    //   52: invokeinterface 195 2 0
    //   57: pop
    //   58: lload_3
    //   59: ldc2_w 77
    //   62: lcmp
    //   63: ifeq +12 -> 75
    //   66: aload_0
    //   67: getfield 165	rx/internal/operators/OperatorMerge$MergeSubscriber:producer	Lrx/internal/operators/OperatorMerge$MergeProducer;
    //   70: iconst_1
    //   71: invokevirtual 199	rx/internal/operators/OperatorMerge$MergeProducer:produced	(I)J
    //   74: pop2
    //   75: aload_1
    //   76: lconst_1
    //   77: invokevirtual 220	rx/internal/operators/OperatorMerge$InnerSubscriber:requestMore	(J)V
    //   80: aload_0
    //   81: monitorenter
    //   82: aload_0
    //   83: getfield 156	rx/internal/operators/OperatorMerge$MergeSubscriber:missed	Z
    //   86: ifne +11 -> 97
    //   89: aload_0
    //   90: iconst_0
    //   91: putfield 154	rx/internal/operators/OperatorMerge$MergeSubscriber:emitting	Z
    //   94: aload_0
    //   95: monitorexit
    //   96: return
    //   97: aload_0
    //   98: iconst_0
    //   99: putfield 156	rx/internal/operators/OperatorMerge$MergeSubscriber:missed	Z
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_0
    //   105: invokevirtual 159	rx/internal/operators/OperatorMerge$MergeSubscriber:emitLoop	()V
    //   108: return
    //   109: astore_1
    //   110: aload_0
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: iload 5
    //   116: ifne +20 -> 136
    //   119: aload_0
    //   120: monitorenter
    //   121: aload_0
    //   122: iconst_0
    //   123: putfield 154	rx/internal/operators/OperatorMerge$MergeSubscriber:emitting	Z
    //   126: aload_0
    //   127: monitorexit
    //   128: goto +8 -> 136
    //   131: astore_1
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_1
    //   135: athrow
    //   136: aload_1
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	MergeSubscriber
    //   0	138	1	paramInnerSubscriber	OperatorMerge.InnerSubscriber<T>
    //   0	138	2	paramT	T
    //   0	138	3	paramLong	long
    //   1	114	5	i	int
    // Exception table:
    //   from	to	target	type
    //   3	11	14	finally
    //   22	33	14	finally
    //   47	58	14	finally
    //   66	75	14	finally
    //   75	82	14	finally
    //   3	11	21	java/lang/Throwable
    //   33	42	43	finally
    //   112	114	43	finally
    //   82	96	109	finally
    //   97	104	109	finally
    //   110	112	109	finally
    //   121	128	131	finally
    //   132	134	131	finally
  }
  
  CompositeSubscription getOrCreateComposite()
  {
    Object localObject = this.subscriptions;
    if (localObject == null)
    {
      int i = 0;
      try
      {
        CompositeSubscription localCompositeSubscription2 = this.subscriptions;
        localObject = localCompositeSubscription2;
        if (localCompositeSubscription2 == null)
        {
          localObject = new CompositeSubscription();
          this.subscriptions = ((CompositeSubscription)localObject);
          i = 1;
        }
        if (i != 0) {
          add((Subscription)localObject);
        }
        return localObject;
      }
      finally {}
    }
    return localCompositeSubscription1;
  }
  
  Queue<Throwable> getOrCreateErrorQueue()
  {
    Object localObject = this.errors;
    if (localObject == null) {
      try
      {
        ConcurrentLinkedQueue localConcurrentLinkedQueue = this.errors;
        localObject = localConcurrentLinkedQueue;
        if (localConcurrentLinkedQueue == null)
        {
          localObject = new ConcurrentLinkedQueue();
          this.errors = ((ConcurrentLinkedQueue)localObject);
        }
        return localObject;
      }
      finally {}
    }
    return localQueue;
  }
  
  public void onCompleted()
  {
    this.done = true;
    emit();
  }
  
  public void onError(Throwable paramThrowable)
  {
    getOrCreateErrorQueue().offer(paramThrowable);
    this.done = true;
    emit();
  }
  
  public void onNext(Observable<? extends T> paramObservable)
  {
    if (paramObservable == null) {
      return;
    }
    if ((paramObservable instanceof ScalarSynchronousObservable))
    {
      tryEmit(((ScalarSynchronousObservable)paramObservable).get());
      return;
    }
    long l = this.uniqueId;
    this.uniqueId = (1L + l);
    OperatorMerge.InnerSubscriber localInnerSubscriber = new OperatorMerge.InnerSubscriber(this, l);
    addInner(localInnerSubscriber);
    paramObservable.unsafeSubscribe(localInnerSubscriber);
    emit();
  }
  
  protected void queueScalar(T paramT)
  {
    Queue localQueue = this.queue;
    Object localObject = localQueue;
    if (localQueue == null)
    {
      int i = this.maxConcurrent;
      if (i == 2147483647) {
        localObject = new SpscUnboundedAtomicArrayQueue(RxRingBuffer.SIZE);
      } else if (Pow2.isPowerOfTwo(i))
      {
        if (UnsafeAccess.isUnsafeAvailable()) {
          localObject = new SpscArrayQueue(i);
        } else {
          localObject = new SpscAtomicArrayQueue(i);
        }
      }
      else {
        localObject = new SpscExactAtomicArrayQueue(i);
      }
      this.queue = ((Queue)localObject);
    }
    if (!((Queue)localObject).offer(paramT))
    {
      unsubscribe();
      onError(OnErrorThrowable.addValueAsLastCause(new MissingBackpressureException(), paramT));
      return;
    }
    emit();
  }
  
  protected void queueScalar(OperatorMerge.InnerSubscriber<T> paramInnerSubscriber, T paramT)
  {
    RxRingBuffer localRxRingBuffer2 = paramInnerSubscriber.queue;
    RxRingBuffer localRxRingBuffer1 = localRxRingBuffer2;
    if (localRxRingBuffer2 == null)
    {
      localRxRingBuffer1 = RxRingBuffer.getSpscInstance();
      paramInnerSubscriber.add(localRxRingBuffer1);
      paramInnerSubscriber.queue = localRxRingBuffer1;
    }
    try
    {
      localRxRingBuffer1.onNext(this.nl.next(paramT));
      emit();
      return;
    }
    catch (IllegalStateException paramT)
    {
      if (!paramInnerSubscriber.isUnsubscribed())
      {
        paramInnerSubscriber.unsubscribe();
        paramInnerSubscriber.onError(paramT);
      }
      return;
    }
    catch (MissingBackpressureException paramT)
    {
      paramInnerSubscriber.unsubscribe();
      paramInnerSubscriber.onError(paramT);
    }
  }
  
  void removeInner(OperatorMerge.InnerSubscriber<T> paramInnerSubscriber)
  {
    ??? = paramInnerSubscriber.queue;
    if (??? != null) {
      ((RxRingBuffer)???).release();
    }
    this.subscriptions.remove(paramInnerSubscriber);
    int i;
    label153:
    synchronized (this.innerGuard)
    {
      OperatorMerge.InnerSubscriber[] arrayOfInnerSubscriber = this.innerSubscribers;
      int m = arrayOfInnerSubscriber.length;
      int k = -1;
      i = 0;
      int j = k;
      if (i < m)
      {
        if (!paramInnerSubscriber.equals(arrayOfInnerSubscriber[i])) {
          break label153;
        }
        j = i;
      }
      if (j < 0) {
        return;
      }
      if (m == 1)
      {
        this.innerSubscribers = EMPTY;
        return;
      }
      paramInnerSubscriber = new OperatorMerge.InnerSubscriber[m - 1];
      System.arraycopy(arrayOfInnerSubscriber, 0, paramInnerSubscriber, 0, j);
      System.arraycopy(arrayOfInnerSubscriber, j + 1, paramInnerSubscriber, j, m - j - 1);
      this.innerSubscribers = paramInnerSubscriber;
      return;
    }
  }
  
  public void requestMore(long paramLong)
  {
    request(paramLong);
  }
  
  void tryEmit(T paramT)
  {
    long l2 = this.producer.get();
    int i = 0;
    int j = 0;
    long l1 = l2;
    if (l2 != 0L) {
      try
      {
        l1 = this.producer.get();
        i = j;
        if (!this.emitting)
        {
          i = j;
          if (l1 != 0L)
          {
            this.emitting = true;
            i = 1;
          }
        }
      }
      finally {}
    }
    if (i != 0)
    {
      emitScalar(paramT, l1);
      return;
    }
    queueScalar(paramT);
  }
  
  void tryEmit(OperatorMerge.InnerSubscriber<T> paramInnerSubscriber, T paramT)
  {
    long l2 = this.producer.get();
    int i = 0;
    int j = 0;
    long l1 = l2;
    if (l2 != 0L) {
      try
      {
        l1 = this.producer.get();
        i = j;
        if (!this.emitting)
        {
          i = j;
          if (l1 != 0L)
          {
            this.emitting = true;
            i = 1;
          }
        }
      }
      finally {}
    }
    if (i != 0)
    {
      emitScalar(paramInnerSubscriber, paramT, l1);
      return;
    }
    queueScalar(paramInnerSubscriber, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorMerge.MergeSubscriber
 * JD-Core Version:    0.7.0.1
 */