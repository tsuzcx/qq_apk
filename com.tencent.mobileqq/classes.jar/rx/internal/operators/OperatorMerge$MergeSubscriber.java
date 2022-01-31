package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import rx.Observable;
import rx.Subscriber;
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
    //   0: iconst_0
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 9
    //   6: iload 9
    //   8: istore_1
    //   9: aload_0
    //   10: getfield 54	rx/internal/operators/OperatorMerge$MergeSubscriber:child	Lrx/Subscriber;
    //   13: astore 19
    //   15: iload 9
    //   17: istore_1
    //   18: aload_0
    //   19: invokevirtual 161	rx/internal/operators/OperatorMerge$MergeSubscriber:checkTerminate	()Z
    //   22: ifeq +4 -> 26
    //   25: return
    //   26: iload 9
    //   28: istore_1
    //   29: aload_0
    //   30: getfield 163	rx/internal/operators/OperatorMerge$MergeSubscriber:queue	Ljava/util/Queue;
    //   33: astore 18
    //   35: iload 9
    //   37: istore_1
    //   38: aload_0
    //   39: getfield 165	rx/internal/operators/OperatorMerge$MergeSubscriber:producer	Lrx/internal/operators/OperatorMerge$MergeProducer;
    //   42: invokevirtual 170	rx/internal/operators/OperatorMerge$MergeProducer:get	()J
    //   45: lstore 12
    //   47: lload 12
    //   49: ldc2_w 77
    //   52: lcmp
    //   53: ifne +163 -> 216
    //   56: iconst_1
    //   57: istore 6
    //   59: goto +839 -> 898
    //   62: lload 12
    //   64: lconst_0
    //   65: lcmp
    //   66: ifle +865 -> 931
    //   69: iload 9
    //   71: istore_1
    //   72: aload 18
    //   74: invokeinterface 174 1 0
    //   79: astore 17
    //   81: iload 9
    //   83: istore_1
    //   84: aload_0
    //   85: invokevirtual 161	rx/internal/operators/OperatorMerge$MergeSubscriber:checkTerminate	()Z
    //   88: ifne +809 -> 897
    //   91: aload 17
    //   93: ifnonnull +129 -> 222
    //   96: goto +835 -> 931
    //   99: iload 9
    //   101: istore_1
    //   102: aload_0
    //   103: getfield 176	rx/internal/operators/OperatorMerge$MergeSubscriber:done	Z
    //   106: istore 16
    //   108: iload 9
    //   110: istore_1
    //   111: aload_0
    //   112: getfield 163	rx/internal/operators/OperatorMerge$MergeSubscriber:queue	Ljava/util/Queue;
    //   115: astore 17
    //   117: iload 9
    //   119: istore_1
    //   120: aload_0
    //   121: getfield 73	rx/internal/operators/OperatorMerge$MergeSubscriber:innerSubscribers	[Lrx/internal/operators/OperatorMerge$InnerSubscriber;
    //   124: astore 20
    //   126: iload 9
    //   128: istore_1
    //   129: aload 20
    //   131: arraylength
    //   132: istore 11
    //   134: iload 16
    //   136: ifeq +207 -> 343
    //   139: aload 17
    //   141: ifnull +16 -> 157
    //   144: iload 9
    //   146: istore_1
    //   147: aload 17
    //   149: invokeinterface 146 1 0
    //   154: ifeq +189 -> 343
    //   157: iload 11
    //   159: ifne +184 -> 343
    //   162: iload 9
    //   164: istore_1
    //   165: aload_0
    //   166: getfield 95	rx/internal/operators/OperatorMerge$MergeSubscriber:errors	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   169: astore 17
    //   171: aload 17
    //   173: ifnull +16 -> 189
    //   176: iload 9
    //   178: istore_1
    //   179: aload 17
    //   181: invokeinterface 146 1 0
    //   186: ifeq +149 -> 335
    //   189: iload 9
    //   191: istore_1
    //   192: aload 19
    //   194: invokevirtual 179	rx/Subscriber:onCompleted	()V
    //   197: return
    //   198: astore 17
    //   200: iload_1
    //   201: ifne +12 -> 213
    //   204: aload_0
    //   205: monitorenter
    //   206: aload_0
    //   207: iconst_0
    //   208: putfield 154	rx/internal/operators/OperatorMerge$MergeSubscriber:emitting	Z
    //   211: aload_0
    //   212: monitorexit
    //   213: aload 17
    //   215: athrow
    //   216: iconst_0
    //   217: istore 6
    //   219: goto +679 -> 898
    //   222: iload 9
    //   224: istore_1
    //   225: aload_0
    //   226: getfield 66	rx/internal/operators/OperatorMerge$MergeSubscriber:nl	Lrx/internal/operators/NotificationLite;
    //   229: aload 17
    //   231: invokevirtual 183	rx/internal/operators/NotificationLite:getValue	(Ljava/lang/Object;)Ljava/lang/Object;
    //   234: astore 20
    //   236: iload 9
    //   238: istore_1
    //   239: aload 19
    //   241: aload 20
    //   243: invokevirtual 187	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   246: lload 12
    //   248: lconst_1
    //   249: lsub
    //   250: lstore 12
    //   252: iload_3
    //   253: iconst_1
    //   254: iadd
    //   255: istore_3
    //   256: iload_2
    //   257: iconst_1
    //   258: iadd
    //   259: istore_2
    //   260: goto -198 -> 62
    //   263: astore 20
    //   265: iload 9
    //   267: istore_1
    //   268: aload_0
    //   269: getfield 56	rx/internal/operators/OperatorMerge$MergeSubscriber:delayErrors	Z
    //   272: ifne +29 -> 301
    //   275: iload 9
    //   277: istore_1
    //   278: aload 20
    //   280: invokestatic 192	rx/exceptions/Exceptions:throwIfFatal	(Ljava/lang/Throwable;)V
    //   283: iconst_1
    //   284: istore_2
    //   285: iload_2
    //   286: istore_1
    //   287: aload_0
    //   288: invokevirtual 151	rx/internal/operators/OperatorMerge$MergeSubscriber:unsubscribe	()V
    //   291: iload_2
    //   292: istore_1
    //   293: aload 19
    //   295: aload 20
    //   297: invokevirtual 114	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
    //   300: return
    //   301: iload 9
    //   303: istore_1
    //   304: aload_0
    //   305: invokevirtual 196	rx/internal/operators/OperatorMerge$MergeSubscriber:getOrCreateErrorQueue	()Ljava/util/Queue;
    //   308: aload 20
    //   310: invokeinterface 200 2 0
    //   315: pop
    //   316: goto -70 -> 246
    //   319: iload 9
    //   321: istore_1
    //   322: aload_0
    //   323: getfield 165	rx/internal/operators/OperatorMerge$MergeSubscriber:producer	Lrx/internal/operators/OperatorMerge$MergeProducer;
    //   326: iload_3
    //   327: invokevirtual 204	rx/internal/operators/OperatorMerge$MergeProducer:produced	(I)J
    //   330: lstore 12
    //   332: goto +613 -> 945
    //   335: iload 9
    //   337: istore_1
    //   338: aload_0
    //   339: invokespecial 148	rx/internal/operators/OperatorMerge$MergeSubscriber:reportError	()V
    //   342: return
    //   343: iload 11
    //   345: ifle +534 -> 879
    //   348: iload 9
    //   350: istore_1
    //   351: aload_0
    //   352: getfield 206	rx/internal/operators/OperatorMerge$MergeSubscriber:lastId	J
    //   355: lstore 14
    //   357: iload 9
    //   359: istore_1
    //   360: aload_0
    //   361: getfield 208	rx/internal/operators/OperatorMerge$MergeSubscriber:lastIndex	I
    //   364: istore 4
    //   366: iload 11
    //   368: iload 4
    //   370: if_icmple +602 -> 972
    //   373: iload 9
    //   375: istore_1
    //   376: iload 4
    //   378: istore_3
    //   379: aload 20
    //   381: iload 4
    //   383: aaload
    //   384: getfield 211	rx/internal/operators/OperatorMerge$InnerSubscriber:id	J
    //   387: lload 14
    //   389: lcmp
    //   390: ifeq +600 -> 990
    //   393: goto +579 -> 972
    //   396: iload 4
    //   398: iload 11
    //   400: if_icmpge +19 -> 419
    //   403: iload 9
    //   405: istore_1
    //   406: aload 20
    //   408: iload_3
    //   409: aaload
    //   410: getfield 211	rx/internal/operators/OperatorMerge$InnerSubscriber:id	J
    //   413: lload 14
    //   415: lcmp
    //   416: ifne +636 -> 1052
    //   419: iload 9
    //   421: istore_1
    //   422: aload_0
    //   423: iload_3
    //   424: putfield 208	rx/internal/operators/OperatorMerge$MergeSubscriber:lastIndex	I
    //   427: iload 9
    //   429: istore_1
    //   430: aload_0
    //   431: aload 20
    //   433: iload_3
    //   434: aaload
    //   435: getfield 211	rx/internal/operators/OperatorMerge$InnerSubscriber:id	J
    //   438: putfield 206	rx/internal/operators/OperatorMerge$MergeSubscriber:lastId	J
    //   441: goto +549 -> 990
    //   444: iload 8
    //   446: iload 11
    //   448: if_icmpge +428 -> 876
    //   451: iload 9
    //   453: istore_1
    //   454: aload_0
    //   455: invokevirtual 161	rx/internal/operators/OperatorMerge$MergeSubscriber:checkTerminate	()Z
    //   458: ifne +439 -> 897
    //   461: aload 20
    //   463: iload 7
    //   465: aaload
    //   466: astore 21
    //   468: aconst_null
    //   469: astore 18
    //   471: lload 12
    //   473: lstore 14
    //   475: goto +528 -> 1003
    //   478: aload 18
    //   480: astore 17
    //   482: lload 12
    //   484: lconst_0
    //   485: lcmp
    //   486: ifle +32 -> 518
    //   489: iload 9
    //   491: istore_1
    //   492: aload_0
    //   493: invokevirtual 161	rx/internal/operators/OperatorMerge$MergeSubscriber:checkTerminate	()Z
    //   496: ifne +401 -> 897
    //   499: iload 9
    //   501: istore_1
    //   502: aload 21
    //   504: getfield 214	rx/internal/operators/OperatorMerge$InnerSubscriber:queue	Lrx/internal/util/RxRingBuffer;
    //   507: astore 17
    //   509: aload 17
    //   511: ifnonnull +205 -> 716
    //   514: aload 18
    //   516: astore 17
    //   518: iload 4
    //   520: ifle +493 -> 1013
    //   523: iload 6
    //   525: ifne +287 -> 812
    //   528: iload 9
    //   530: istore_1
    //   531: aload_0
    //   532: getfield 165	rx/internal/operators/OperatorMerge$MergeSubscriber:producer	Lrx/internal/operators/OperatorMerge$MergeProducer;
    //   535: iload 4
    //   537: invokevirtual 204	rx/internal/operators/OperatorMerge$MergeProducer:produced	(I)J
    //   540: lstore 12
    //   542: iload 9
    //   544: istore_1
    //   545: aload 21
    //   547: iload 4
    //   549: i2l
    //   550: invokevirtual 217	rx/internal/operators/OperatorMerge$InnerSubscriber:requestMore	(J)V
    //   553: goto +460 -> 1013
    //   556: iload 9
    //   558: istore_1
    //   559: aload 21
    //   561: getfield 218	rx/internal/operators/OperatorMerge$InnerSubscriber:done	Z
    //   564: istore 16
    //   566: iload 9
    //   568: istore_1
    //   569: aload 21
    //   571: getfield 214	rx/internal/operators/OperatorMerge$InnerSubscriber:queue	Lrx/internal/util/RxRingBuffer;
    //   574: astore 17
    //   576: iload_2
    //   577: istore 4
    //   579: iload_3
    //   580: istore 5
    //   582: iload 16
    //   584: ifeq +452 -> 1036
    //   587: aload 17
    //   589: ifnull +20 -> 609
    //   592: iload 9
    //   594: istore_1
    //   595: iload_2
    //   596: istore 4
    //   598: iload_3
    //   599: istore 5
    //   601: aload 17
    //   603: invokevirtual 221	rx/internal/util/RxRingBuffer:isEmpty	()Z
    //   606: ifeq +430 -> 1036
    //   609: iload 9
    //   611: istore_1
    //   612: aload_0
    //   613: aload 21
    //   615: invokevirtual 224	rx/internal/operators/OperatorMerge$MergeSubscriber:removeInner	(Lrx/internal/operators/OperatorMerge$InnerSubscriber;)V
    //   618: iload 9
    //   620: istore_1
    //   621: aload_0
    //   622: invokevirtual 161	rx/internal/operators/OperatorMerge$MergeSubscriber:checkTerminate	()Z
    //   625: ifne +272 -> 897
    //   628: iload_3
    //   629: iconst_1
    //   630: iadd
    //   631: istore 5
    //   633: iconst_1
    //   634: istore 4
    //   636: goto +400 -> 1036
    //   639: iload 9
    //   641: istore_1
    //   642: aload_0
    //   643: iload 7
    //   645: putfield 208	rx/internal/operators/OperatorMerge$MergeSubscriber:lastIndex	I
    //   648: iload 9
    //   650: istore_1
    //   651: aload_0
    //   652: aload 20
    //   654: iload 7
    //   656: aaload
    //   657: getfield 211	rx/internal/operators/OperatorMerge$InnerSubscriber:id	J
    //   660: putfield 206	rx/internal/operators/OperatorMerge$MergeSubscriber:lastId	J
    //   663: iload_3
    //   664: ifle +12 -> 676
    //   667: iload 9
    //   669: istore_1
    //   670: aload_0
    //   671: iload_3
    //   672: i2l
    //   673: invokevirtual 82	rx/internal/operators/OperatorMerge$MergeSubscriber:request	(J)V
    //   676: iload_2
    //   677: ifne -662 -> 15
    //   680: iload 9
    //   682: istore_1
    //   683: aload_0
    //   684: monitorenter
    //   685: iload 10
    //   687: istore_1
    //   688: aload_0
    //   689: getfield 156	rx/internal/operators/OperatorMerge$MergeSubscriber:missed	Z
    //   692: ifne +161 -> 853
    //   695: iconst_1
    //   696: istore_2
    //   697: iload_2
    //   698: istore_1
    //   699: aload_0
    //   700: iconst_0
    //   701: putfield 154	rx/internal/operators/OperatorMerge$MergeSubscriber:emitting	Z
    //   704: iload_2
    //   705: istore_1
    //   706: aload_0
    //   707: monitorexit
    //   708: return
    //   709: astore 17
    //   711: aload_0
    //   712: monitorexit
    //   713: aload 17
    //   715: athrow
    //   716: iload 9
    //   718: istore_1
    //   719: aload 17
    //   721: invokevirtual 225	rx/internal/util/RxRingBuffer:poll	()Ljava/lang/Object;
    //   724: astore 18
    //   726: aload 18
    //   728: astore 17
    //   730: aload 18
    //   732: ifnull -214 -> 518
    //   735: iload 9
    //   737: istore_1
    //   738: aload_0
    //   739: getfield 66	rx/internal/operators/OperatorMerge$MergeSubscriber:nl	Lrx/internal/operators/NotificationLite;
    //   742: aload 18
    //   744: invokevirtual 183	rx/internal/operators/NotificationLite:getValue	(Ljava/lang/Object;)Ljava/lang/Object;
    //   747: astore 17
    //   749: iload 9
    //   751: istore_1
    //   752: aload 19
    //   754: aload 17
    //   756: invokevirtual 187	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   759: iload 4
    //   761: iconst_1
    //   762: iadd
    //   763: istore 4
    //   765: lload 12
    //   767: lconst_1
    //   768: lsub
    //   769: lstore 12
    //   771: goto -293 -> 478
    //   774: astore 17
    //   776: iconst_1
    //   777: istore_2
    //   778: iload_2
    //   779: istore_1
    //   780: aload 17
    //   782: invokestatic 192	rx/exceptions/Exceptions:throwIfFatal	(Ljava/lang/Throwable;)V
    //   785: aload 19
    //   787: aload 17
    //   789: invokevirtual 114	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
    //   792: iload_2
    //   793: istore_1
    //   794: aload_0
    //   795: invokevirtual 151	rx/internal/operators/OperatorMerge$MergeSubscriber:unsubscribe	()V
    //   798: return
    //   799: astore 17
    //   801: iload_2
    //   802: istore_1
    //   803: aload_0
    //   804: invokevirtual 151	rx/internal/operators/OperatorMerge$MergeSubscriber:unsubscribe	()V
    //   807: iload_2
    //   808: istore_1
    //   809: aload 17
    //   811: athrow
    //   812: ldc2_w 77
    //   815: lstore 12
    //   817: goto -275 -> 542
    //   820: iload 7
    //   822: iconst_1
    //   823: iadd
    //   824: istore_2
    //   825: iload_2
    //   826: istore_1
    //   827: iload_2
    //   828: iload 11
    //   830: if_icmpne +5 -> 835
    //   833: iconst_0
    //   834: istore_1
    //   835: iload 8
    //   837: iconst_1
    //   838: iadd
    //   839: istore 8
    //   841: iload 4
    //   843: istore_2
    //   844: iload 5
    //   846: istore_3
    //   847: iload_1
    //   848: istore 7
    //   850: goto -406 -> 444
    //   853: iload 10
    //   855: istore_1
    //   856: aload_0
    //   857: iconst_0
    //   858: putfield 156	rx/internal/operators/OperatorMerge$MergeSubscriber:missed	Z
    //   861: iload 10
    //   863: istore_1
    //   864: aload_0
    //   865: monitorexit
    //   866: goto -851 -> 15
    //   869: astore 17
    //   871: aload_0
    //   872: monitorexit
    //   873: aload 17
    //   875: athrow
    //   876: goto -237 -> 639
    //   879: iconst_0
    //   880: istore_1
    //   881: iload_2
    //   882: istore_3
    //   883: iload_1
    //   884: istore_2
    //   885: goto -222 -> 663
    //   888: lload 14
    //   890: lstore 12
    //   892: iload_1
    //   893: istore_2
    //   894: goto -795 -> 99
    //   897: return
    //   898: iconst_0
    //   899: istore_2
    //   900: iconst_0
    //   901: istore_1
    //   902: lload 12
    //   904: lstore 14
    //   906: aload 18
    //   908: ifnull -20 -> 888
    //   911: lload 12
    //   913: lstore 14
    //   915: iload_2
    //   916: istore_1
    //   917: iconst_0
    //   918: istore_3
    //   919: aconst_null
    //   920: astore 17
    //   922: iload_1
    //   923: istore_2
    //   924: lload 14
    //   926: lstore 12
    //   928: goto -866 -> 62
    //   931: iload_3
    //   932: ifle +13 -> 945
    //   935: iload 6
    //   937: ifeq -618 -> 319
    //   940: ldc2_w 77
    //   943: lstore 12
    //   945: iload_2
    //   946: istore_1
    //   947: lload 12
    //   949: lstore 14
    //   951: lload 12
    //   953: lconst_0
    //   954: lcmp
    //   955: ifeq -67 -> 888
    //   958: iload_2
    //   959: istore_1
    //   960: lload 12
    //   962: lstore 14
    //   964: aload 17
    //   966: ifnonnull -49 -> 917
    //   969: goto -870 -> 99
    //   972: iload 4
    //   974: istore_3
    //   975: iload 11
    //   977: iload 4
    //   979: if_icmpgt +5 -> 984
    //   982: iconst_0
    //   983: istore_3
    //   984: iconst_0
    //   985: istore 4
    //   987: goto -591 -> 396
    //   990: iload_3
    //   991: istore 7
    //   993: iload_2
    //   994: istore_3
    //   995: iconst_0
    //   996: istore 8
    //   998: iconst_0
    //   999: istore_2
    //   1000: goto -556 -> 444
    //   1003: iconst_0
    //   1004: istore 4
    //   1006: lload 14
    //   1008: lstore 12
    //   1010: goto -532 -> 478
    //   1013: lload 12
    //   1015: lconst_0
    //   1016: lcmp
    //   1017: ifeq -461 -> 556
    //   1020: aload 17
    //   1022: astore 18
    //   1024: lload 12
    //   1026: lstore 14
    //   1028: aload 17
    //   1030: ifnonnull -27 -> 1003
    //   1033: goto -477 -> 556
    //   1036: lload 12
    //   1038: lconst_0
    //   1039: lcmp
    //   1040: ifne -220 -> 820
    //   1043: iload 4
    //   1045: istore_2
    //   1046: iload 5
    //   1048: istore_3
    //   1049: goto -410 -> 639
    //   1052: iload_3
    //   1053: iconst_1
    //   1054: iadd
    //   1055: istore_1
    //   1056: iload_1
    //   1057: istore_3
    //   1058: iload_1
    //   1059: iload 11
    //   1061: if_icmpne +5 -> 1066
    //   1064: iconst_0
    //   1065: istore_3
    //   1066: iload 4
    //   1068: iconst_1
    //   1069: iadd
    //   1070: istore 4
    //   1072: goto -676 -> 396
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1075	0	this	MergeSubscriber
    //   8	1054	1	i	int
    //   256	790	2	j	int
    //   252	814	3	k	int
    //   364	707	4	m	int
    //   580	467	5	n	int
    //   57	879	6	i1	int
    //   463	529	7	i2	int
    //   444	553	8	i3	int
    //   4	746	9	i4	int
    //   1	861	10	i5	int
    //   132	930	11	i6	int
    //   45	992	12	l1	long
    //   355	672	14	l2	long
    //   106	477	16	bool	boolean
    //   79	101	17	localObject1	Object
    //   198	32	17	localObject2	Object
    //   480	122	17	localObject3	Object
    //   709	11	17	localObject4	Object
    //   728	27	17	localObject5	Object
    //   774	14	17	localThrowable1	Throwable
    //   799	11	17	localObject6	Object
    //   869	5	17	localObject7	Object
    //   920	109	17	localObject8	Object
    //   33	990	18	localObject9	Object
    //   13	773	19	localSubscriber	Subscriber
    //   124	118	20	localObject10	Object
    //   263	390	20	localThrowable2	Throwable
    //   466	148	21	localInnerSubscriber	OperatorMerge.InnerSubscriber
    // Exception table:
    //   from	to	target	type
    //   9	15	198	finally
    //   18	25	198	finally
    //   29	35	198	finally
    //   38	47	198	finally
    //   72	81	198	finally
    //   84	91	198	finally
    //   102	108	198	finally
    //   111	117	198	finally
    //   120	126	198	finally
    //   129	134	198	finally
    //   147	157	198	finally
    //   165	171	198	finally
    //   179	189	198	finally
    //   192	197	198	finally
    //   225	236	198	finally
    //   239	246	198	finally
    //   268	275	198	finally
    //   278	283	198	finally
    //   287	291	198	finally
    //   293	300	198	finally
    //   304	316	198	finally
    //   322	332	198	finally
    //   338	342	198	finally
    //   351	357	198	finally
    //   360	366	198	finally
    //   379	393	198	finally
    //   406	419	198	finally
    //   422	427	198	finally
    //   430	441	198	finally
    //   454	461	198	finally
    //   492	499	198	finally
    //   502	509	198	finally
    //   531	542	198	finally
    //   545	553	198	finally
    //   559	566	198	finally
    //   569	576	198	finally
    //   601	609	198	finally
    //   612	618	198	finally
    //   621	628	198	finally
    //   642	648	198	finally
    //   651	663	198	finally
    //   670	676	198	finally
    //   683	685	198	finally
    //   713	716	198	finally
    //   719	726	198	finally
    //   738	749	198	finally
    //   752	759	198	finally
    //   780	785	198	finally
    //   794	798	198	finally
    //   803	807	198	finally
    //   809	812	198	finally
    //   239	246	263	java/lang/Throwable
    //   688	695	709	finally
    //   699	704	709	finally
    //   706	708	709	finally
    //   711	713	709	finally
    //   856	861	709	finally
    //   864	866	709	finally
    //   752	759	774	java/lang/Throwable
    //   785	792	799	finally
    //   206	213	869	finally
    //   871	873	869	finally
  }
  
  /* Error */
  protected void emitScalar(T paramT, long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: getfield 54	rx/internal/operators/OperatorMerge$MergeSubscriber:child	Lrx/Subscriber;
    //   7: aload_1
    //   8: invokevirtual 187	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   11: lload_2
    //   12: ldc2_w 77
    //   15: lcmp
    //   16: ifeq +12 -> 28
    //   19: aload_0
    //   20: getfield 165	rx/internal/operators/OperatorMerge$MergeSubscriber:producer	Lrx/internal/operators/OperatorMerge$MergeProducer;
    //   23: iconst_1
    //   24: invokevirtual 204	rx/internal/operators/OperatorMerge$MergeProducer:produced	(I)J
    //   27: pop2
    //   28: aload_0
    //   29: getfield 229	rx/internal/operators/OperatorMerge$MergeSubscriber:scalarEmissionCount	I
    //   32: iconst_1
    //   33: iadd
    //   34: istore 5
    //   36: iload 5
    //   38: aload_0
    //   39: getfield 76	rx/internal/operators/OperatorMerge$MergeSubscriber:scalarEmissionLimit	I
    //   42: if_icmpne +88 -> 130
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 229	rx/internal/operators/OperatorMerge$MergeSubscriber:scalarEmissionCount	I
    //   50: aload_0
    //   51: iload 5
    //   53: i2l
    //   54: invokevirtual 230	rx/internal/operators/OperatorMerge$MergeSubscriber:requestMore	(J)V
    //   57: aload_0
    //   58: monitorenter
    //   59: aload_0
    //   60: getfield 156	rx/internal/operators/OperatorMerge$MergeSubscriber:missed	Z
    //   63: ifne +76 -> 139
    //   66: aload_0
    //   67: iconst_0
    //   68: putfield 154	rx/internal/operators/OperatorMerge$MergeSubscriber:emitting	Z
    //   71: aload_0
    //   72: monitorexit
    //   73: return
    //   74: astore_1
    //   75: aload_0
    //   76: getfield 56	rx/internal/operators/OperatorMerge$MergeSubscriber:delayErrors	Z
    //   79: ifne +37 -> 116
    //   82: aload_1
    //   83: invokestatic 192	rx/exceptions/Exceptions:throwIfFatal	(Ljava/lang/Throwable;)V
    //   86: aload_0
    //   87: invokevirtual 151	rx/internal/operators/OperatorMerge$MergeSubscriber:unsubscribe	()V
    //   90: aload_0
    //   91: aload_1
    //   92: invokevirtual 231	rx/internal/operators/OperatorMerge$MergeSubscriber:onError	(Ljava/lang/Throwable;)V
    //   95: return
    //   96: astore_1
    //   97: iconst_1
    //   98: istore 4
    //   100: iload 4
    //   102: ifne +12 -> 114
    //   105: aload_0
    //   106: monitorenter
    //   107: aload_0
    //   108: iconst_0
    //   109: putfield 154	rx/internal/operators/OperatorMerge$MergeSubscriber:emitting	Z
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_1
    //   115: athrow
    //   116: aload_0
    //   117: invokevirtual 196	rx/internal/operators/OperatorMerge$MergeSubscriber:getOrCreateErrorQueue	()Ljava/util/Queue;
    //   120: aload_1
    //   121: invokeinterface 200 2 0
    //   126: pop
    //   127: goto -116 -> 11
    //   130: aload_0
    //   131: iload 5
    //   133: putfield 229	rx/internal/operators/OperatorMerge$MergeSubscriber:scalarEmissionCount	I
    //   136: goto -79 -> 57
    //   139: aload_0
    //   140: iconst_0
    //   141: putfield 156	rx/internal/operators/OperatorMerge$MergeSubscriber:missed	Z
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_0
    //   147: invokevirtual 159	rx/internal/operators/OperatorMerge$MergeSubscriber:emitLoop	()V
    //   150: return
    //   151: astore_1
    //   152: aload_0
    //   153: monitorexit
    //   154: aload_1
    //   155: athrow
    //   156: astore_1
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_1
    //   160: athrow
    //   161: astore_1
    //   162: goto -62 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	MergeSubscriber
    //   0	165	1	paramT	T
    //   0	165	2	paramLong	long
    //   1	100	4	i	int
    //   34	98	5	j	int
    // Exception table:
    //   from	to	target	type
    //   3	11	74	java/lang/Throwable
    //   86	95	96	finally
    //   154	156	96	finally
    //   59	73	151	finally
    //   139	146	151	finally
    //   152	154	151	finally
    //   107	114	156	finally
    //   157	159	156	finally
    //   3	11	161	finally
    //   19	28	161	finally
    //   28	57	161	finally
    //   57	59	161	finally
    //   75	86	161	finally
    //   116	127	161	finally
    //   130	136	161	finally
  }
  
  /* Error */
  protected void emitScalar(OperatorMerge.InnerSubscriber<T> paramInnerSubscriber, T paramT, long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: getfield 54	rx/internal/operators/OperatorMerge$MergeSubscriber:child	Lrx/Subscriber;
    //   7: aload_2
    //   8: invokevirtual 187	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   11: lload_3
    //   12: ldc2_w 77
    //   15: lcmp
    //   16: ifeq +12 -> 28
    //   19: aload_0
    //   20: getfield 165	rx/internal/operators/OperatorMerge$MergeSubscriber:producer	Lrx/internal/operators/OperatorMerge$MergeProducer;
    //   23: iconst_1
    //   24: invokevirtual 204	rx/internal/operators/OperatorMerge$MergeProducer:produced	(I)J
    //   27: pop2
    //   28: aload_1
    //   29: lconst_1
    //   30: invokevirtual 217	rx/internal/operators/OperatorMerge$InnerSubscriber:requestMore	(J)V
    //   33: aload_0
    //   34: monitorenter
    //   35: aload_0
    //   36: getfield 156	rx/internal/operators/OperatorMerge$MergeSubscriber:missed	Z
    //   39: ifne +71 -> 110
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield 154	rx/internal/operators/OperatorMerge$MergeSubscriber:emitting	Z
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: astore_2
    //   51: aload_0
    //   52: getfield 56	rx/internal/operators/OperatorMerge$MergeSubscriber:delayErrors	Z
    //   55: ifne +37 -> 92
    //   58: aload_2
    //   59: invokestatic 192	rx/exceptions/Exceptions:throwIfFatal	(Ljava/lang/Throwable;)V
    //   62: aload_1
    //   63: invokevirtual 234	rx/internal/operators/OperatorMerge$InnerSubscriber:unsubscribe	()V
    //   66: aload_1
    //   67: aload_2
    //   68: invokevirtual 235	rx/internal/operators/OperatorMerge$InnerSubscriber:onError	(Ljava/lang/Throwable;)V
    //   71: return
    //   72: astore_1
    //   73: iconst_1
    //   74: istore 5
    //   76: iload 5
    //   78: ifne +12 -> 90
    //   81: aload_0
    //   82: monitorenter
    //   83: aload_0
    //   84: iconst_0
    //   85: putfield 154	rx/internal/operators/OperatorMerge$MergeSubscriber:emitting	Z
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    //   92: aload_0
    //   93: invokevirtual 196	rx/internal/operators/OperatorMerge$MergeSubscriber:getOrCreateErrorQueue	()Ljava/util/Queue;
    //   96: aload_2
    //   97: invokeinterface 200 2 0
    //   102: pop
    //   103: goto -92 -> 11
    //   106: astore_1
    //   107: goto -31 -> 76
    //   110: aload_0
    //   111: iconst_0
    //   112: putfield 156	rx/internal/operators/OperatorMerge$MergeSubscriber:missed	Z
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_0
    //   118: invokevirtual 159	rx/internal/operators/OperatorMerge$MergeSubscriber:emitLoop	()V
    //   121: return
    //   122: astore_1
    //   123: aload_0
    //   124: monitorexit
    //   125: aload_1
    //   126: athrow
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	MergeSubscriber
    //   0	132	1	paramInnerSubscriber	OperatorMerge.InnerSubscriber<T>
    //   0	132	2	paramT	T
    //   0	132	3	paramLong	long
    //   1	76	5	i	int
    // Exception table:
    //   from	to	target	type
    //   3	11	50	java/lang/Throwable
    //   62	71	72	finally
    //   125	127	72	finally
    //   3	11	106	finally
    //   19	28	106	finally
    //   28	35	106	finally
    //   51	62	106	finally
    //   92	103	106	finally
    //   35	49	122	finally
    //   110	117	122	finally
    //   123	125	122	finally
    //   83	90	127	finally
    //   128	130	127	finally
  }
  
  CompositeSubscription getOrCreateComposite()
  {
    CompositeSubscription localCompositeSubscription1 = this.subscriptions;
    CompositeSubscription localCompositeSubscription2 = localCompositeSubscription1;
    if (localCompositeSubscription1 == null) {}
    for (;;)
    {
      try
      {
        localCompositeSubscription1 = this.subscriptions;
        if (localCompositeSubscription1 == null)
        {
          localCompositeSubscription1 = new CompositeSubscription();
          this.subscriptions = localCompositeSubscription1;
          i = 1;
          localCompositeSubscription2 = localCompositeSubscription1;
          if (i != 0)
          {
            add(localCompositeSubscription1);
            localCompositeSubscription2 = localCompositeSubscription1;
          }
          return localCompositeSubscription2;
        }
      }
      finally {}
      int i = 0;
    }
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
    int i;
    if (localQueue == null)
    {
      i = this.maxConcurrent;
      if (i != 2147483647) {
        break label71;
      }
      localObject = new SpscUnboundedAtomicArrayQueue(RxRingBuffer.SIZE);
    }
    for (;;)
    {
      this.queue = ((Queue)localObject);
      if (((Queue)localObject).offer(paramT)) {
        break;
      }
      unsubscribe();
      onError(OnErrorThrowable.addValueAsLastCause(new MissingBackpressureException(), paramT));
      return;
      label71:
      if (Pow2.isPowerOfTwo(i))
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
    catch (MissingBackpressureException paramT)
    {
      paramInnerSubscriber.unsubscribe();
      paramInnerSubscriber.onError(paramT);
      return;
    }
    catch (IllegalStateException paramT)
    {
      while (paramInnerSubscriber.isUnsubscribed()) {}
      paramInnerSubscriber.unsubscribe();
      paramInnerSubscriber.onError(paramT);
    }
  }
  
  void removeInner(OperatorMerge.InnerSubscriber<T> paramInnerSubscriber)
  {
    int i = 0;
    ??? = paramInnerSubscriber.queue;
    if (??? != null) {
      ((RxRingBuffer)???).release();
    }
    this.subscriptions.remove(paramInnerSubscriber);
    for (;;)
    {
      OperatorMerge.InnerSubscriber[] arrayOfInnerSubscriber;
      int j;
      synchronized (this.innerGuard)
      {
        arrayOfInnerSubscriber = this.innerSubscribers;
        j = arrayOfInnerSubscriber.length;
        if (i >= j) {
          break label131;
        }
        if (!paramInnerSubscriber.equals(arrayOfInnerSubscriber[i])) {
          break label136;
        }
        if (i < 0) {
          return;
        }
        if (j == 1)
        {
          this.innerSubscribers = EMPTY;
          return;
        }
      }
      paramInnerSubscriber = new OperatorMerge.InnerSubscriber[j - 1];
      System.arraycopy(arrayOfInnerSubscriber, 0, paramInnerSubscriber, 0, i);
      System.arraycopy(arrayOfInnerSubscriber, i + 1, paramInnerSubscriber, i, j - i - 1);
      this.innerSubscribers = paramInnerSubscriber;
      return;
      label131:
      i = -1;
      continue;
      label136:
      i += 1;
    }
  }
  
  public void requestMore(long paramLong)
  {
    request(paramLong);
  }
  
  void tryEmit(T paramT)
  {
    int i = 0;
    int j = 0;
    long l2 = this.producer.get();
    long l1 = l2;
    if (l2 != 0L) {}
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
      if (i != 0)
      {
        emitScalar(paramT, l1);
        return;
      }
    }
    finally {}
    queueScalar(paramT);
  }
  
  void tryEmit(OperatorMerge.InnerSubscriber<T> paramInnerSubscriber, T paramT)
  {
    int i = 0;
    int j = 0;
    long l2 = this.producer.get();
    long l1 = l2;
    if (l2 != 0L) {}
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
      if (i != 0)
      {
        emitScalar(paramInnerSubscriber, paramT, l1);
        return;
      }
    }
    finally {}
    queueScalar(paramInnerSubscriber, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorMerge.MergeSubscriber
 * JD-Core Version:    0.7.0.1
 */