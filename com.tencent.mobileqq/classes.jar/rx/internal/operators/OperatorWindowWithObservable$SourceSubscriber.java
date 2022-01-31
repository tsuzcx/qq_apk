package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

final class OperatorWindowWithObservable$SourceSubscriber<T>
  extends Subscriber<T>
{
  final Subscriber<? super Observable<T>> child;
  Observer<T> consumer;
  boolean emitting;
  final Object guard;
  Observable<T> producer;
  List<Object> queue;
  
  public OperatorWindowWithObservable$SourceSubscriber(Subscriber<? super Observable<T>> paramSubscriber)
  {
    this.child = new SerializedSubscriber(paramSubscriber);
    this.guard = new Object();
  }
  
  void complete()
  {
    Observer localObserver = this.consumer;
    this.consumer = null;
    this.producer = null;
    if (localObserver != null) {
      localObserver.onCompleted();
    }
    this.child.onCompleted();
    unsubscribe();
  }
  
  void createNewWindow()
  {
    UnicastSubject localUnicastSubject = UnicastSubject.create();
    this.consumer = localUnicastSubject;
    this.producer = localUnicastSubject;
  }
  
  void drain(List<Object> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = paramList.next();
        if (localObject == OperatorWindowWithObservable.NEXT_SUBJECT)
        {
          replaceSubject();
        }
        else
        {
          if (OperatorWindowWithObservable.nl.isError(localObject))
          {
            error(OperatorWindowWithObservable.nl.getError(localObject));
            return;
          }
          if (OperatorWindowWithObservable.nl.isCompleted(localObject))
          {
            complete();
            return;
          }
          emitValue(localObject);
        }
      }
    }
  }
  
  void emitValue(T paramT)
  {
    Observer localObserver = this.consumer;
    if (localObserver != null) {
      localObserver.onNext(paramT);
    }
  }
  
  void error(Throwable paramThrowable)
  {
    Observer localObserver = this.consumer;
    this.consumer = null;
    this.producer = null;
    if (localObserver != null) {
      localObserver.onError(paramThrowable);
    }
    this.child.onError(paramThrowable);
    unsubscribe();
  }
  
  public void onCompleted()
  {
    List localList;
    synchronized (this.guard)
    {
      if (this.emitting)
      {
        if (this.queue == null) {
          this.queue = new ArrayList();
        }
        this.queue.add(OperatorWindowWithObservable.nl.completed());
        return;
      }
      localList = this.queue;
      this.queue = null;
      this.emitting = true;
    }
    try
    {
      drain(localList);
      complete();
      return;
    }
    catch (Throwable localThrowable)
    {
      error(localThrowable);
    }
    localObject2 = finally;
    throw localObject2;
  }
  
  public void onError(Throwable paramThrowable)
  {
    synchronized (this.guard)
    {
      if (this.emitting)
      {
        this.queue = Collections.singletonList(OperatorWindowWithObservable.nl.error(paramThrowable));
        return;
      }
      this.queue = null;
      this.emitting = true;
      error(paramThrowable);
      return;
    }
  }
  
  /* Error */
  public void onNext(T arg1)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: aload_0
    //   7: getfield 37	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:guard	Ljava/lang/Object;
    //   10: astore 8
    //   12: aload 8
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 127	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:emitting	Z
    //   19: ifeq +36 -> 55
    //   22: aload_0
    //   23: getfield 129	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:queue	Ljava/util/List;
    //   26: ifnonnull +14 -> 40
    //   29: aload_0
    //   30: new 131	java/util/ArrayList
    //   33: dup
    //   34: invokespecial 132	java/util/ArrayList:<init>	()V
    //   37: putfield 129	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:queue	Ljava/util/List;
    //   40: aload_0
    //   41: getfield 129	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:queue	Ljava/util/List;
    //   44: aload_1
    //   45: invokeinterface 138 2 0
    //   50: pop
    //   51: aload 8
    //   53: monitorexit
    //   54: return
    //   55: aload_0
    //   56: getfield 129	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:queue	Ljava/util/List;
    //   59: astore 7
    //   61: aload_0
    //   62: aconst_null
    //   63: putfield 129	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:queue	Ljava/util/List;
    //   66: aload_0
    //   67: iconst_1
    //   68: putfield 127	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:emitting	Z
    //   71: aload 8
    //   73: monitorexit
    //   74: iconst_1
    //   75: istore_2
    //   76: aload_0
    //   77: aload 7
    //   79: invokevirtual 140	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:drain	(Ljava/util/List;)V
    //   82: iload_2
    //   83: istore_3
    //   84: iload_2
    //   85: ifeq +10 -> 95
    //   88: aload_0
    //   89: aload_1
    //   90: invokevirtual 114	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:emitValue	(Ljava/lang/Object;)V
    //   93: iconst_0
    //   94: istore_3
    //   95: aload_0
    //   96: getfield 37	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:guard	Ljava/lang/Object;
    //   99: astore 8
    //   101: aload 8
    //   103: monitorenter
    //   104: aload_0
    //   105: getfield 129	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:queue	Ljava/util/List;
    //   108: astore 7
    //   110: aload_0
    //   111: aconst_null
    //   112: putfield 129	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:queue	Ljava/util/List;
    //   115: aload 7
    //   117: ifnonnull +52 -> 169
    //   120: aload_0
    //   121: iconst_0
    //   122: putfield 127	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:emitting	Z
    //   125: iload 4
    //   127: istore_3
    //   128: aload 8
    //   130: monitorexit
    //   131: return
    //   132: iload_2
    //   133: istore_3
    //   134: aload 8
    //   136: monitorexit
    //   137: aload_1
    //   138: athrow
    //   139: astore_1
    //   140: iload_2
    //   141: ifne +20 -> 161
    //   144: aload_0
    //   145: getfield 37	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:guard	Ljava/lang/Object;
    //   148: astore 7
    //   150: aload 7
    //   152: monitorenter
    //   153: aload_0
    //   154: iconst_0
    //   155: putfield 127	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:emitting	Z
    //   158: aload 7
    //   160: monitorexit
    //   161: aload_1
    //   162: athrow
    //   163: astore_1
    //   164: aload 8
    //   166: monitorexit
    //   167: aload_1
    //   168: athrow
    //   169: aload 8
    //   171: monitorexit
    //   172: aload_0
    //   173: getfield 32	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:child	Lrx/Subscriber;
    //   176: invokevirtual 152	rx/Subscriber:isUnsubscribed	()Z
    //   179: istore 6
    //   181: iload_3
    //   182: istore_2
    //   183: iload 6
    //   185: ifeq -109 -> 76
    //   188: aload_0
    //   189: getfield 37	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:guard	Ljava/lang/Object;
    //   192: astore_1
    //   193: aload_1
    //   194: monitorenter
    //   195: aload_0
    //   196: iconst_0
    //   197: putfield 127	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:emitting	Z
    //   200: aload_1
    //   201: monitorexit
    //   202: return
    //   203: astore 7
    //   205: aload_1
    //   206: monitorexit
    //   207: aload 7
    //   209: athrow
    //   210: astore_1
    //   211: aload 7
    //   213: monitorexit
    //   214: aload_1
    //   215: athrow
    //   216: astore_1
    //   217: iload 5
    //   219: istore_2
    //   220: goto -80 -> 140
    //   223: astore_1
    //   224: iconst_0
    //   225: istore_2
    //   226: goto -94 -> 132
    //   229: astore_1
    //   230: iload_3
    //   231: istore_2
    //   232: goto -100 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	this	SourceSubscriber
    //   75	157	2	i	int
    //   83	148	3	j	int
    //   1	125	4	k	int
    //   4	214	5	m	int
    //   179	5	6	bool	boolean
    //   59	100	7	localObject1	Object
    //   203	9	7	localObject2	Object
    //   10	160	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   137	139	139	finally
    //   15	40	163	finally
    //   40	54	163	finally
    //   55	74	163	finally
    //   164	167	163	finally
    //   195	202	203	finally
    //   205	207	203	finally
    //   153	161	210	finally
    //   211	214	210	finally
    //   76	82	216	finally
    //   88	93	216	finally
    //   95	104	216	finally
    //   172	181	216	finally
    //   104	115	223	finally
    //   120	125	223	finally
    //   169	172	223	finally
    //   128	131	229	finally
    //   134	137	229	finally
  }
  
  public void onStart()
  {
    request(9223372036854775807L);
  }
  
  void replaceSubject()
  {
    Observer localObserver = this.consumer;
    if (localObserver != null) {
      localObserver.onCompleted();
    }
    createNewWindow();
    this.child.onNext(this.producer);
  }
  
  /* Error */
  void replaceWindow()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 4
    //   5: aload_0
    //   6: getfield 37	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:guard	Ljava/lang/Object;
    //   9: astore 7
    //   11: aload 7
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 127	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:emitting	Z
    //   18: ifeq +38 -> 56
    //   21: aload_0
    //   22: getfield 129	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:queue	Ljava/util/List;
    //   25: ifnonnull +14 -> 39
    //   28: aload_0
    //   29: new 131	java/util/ArrayList
    //   32: dup
    //   33: invokespecial 132	java/util/ArrayList:<init>	()V
    //   36: putfield 129	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:queue	Ljava/util/List;
    //   39: aload_0
    //   40: getfield 129	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:queue	Ljava/util/List;
    //   43: getstatic 84	rx/internal/operators/OperatorWindowWithObservable:NEXT_SUBJECT	Ljava/lang/Object;
    //   46: invokeinterface 138 2 0
    //   51: pop
    //   52: aload 7
    //   54: monitorexit
    //   55: return
    //   56: aload_0
    //   57: getfield 129	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:queue	Ljava/util/List;
    //   60: astore 6
    //   62: aload_0
    //   63: aconst_null
    //   64: putfield 129	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:queue	Ljava/util/List;
    //   67: aload_0
    //   68: iconst_1
    //   69: putfield 127	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:emitting	Z
    //   72: aload 7
    //   74: monitorexit
    //   75: iconst_1
    //   76: istore_1
    //   77: aload_0
    //   78: aload 6
    //   80: invokevirtual 140	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:drain	(Ljava/util/List;)V
    //   83: iload_1
    //   84: istore_2
    //   85: iload_1
    //   86: ifeq +9 -> 95
    //   89: aload_0
    //   90: invokevirtual 87	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:replaceSubject	()V
    //   93: iconst_0
    //   94: istore_2
    //   95: aload_0
    //   96: getfield 37	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:guard	Ljava/lang/Object;
    //   99: astore 7
    //   101: aload 7
    //   103: monitorenter
    //   104: aload_0
    //   105: getfield 129	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:queue	Ljava/util/List;
    //   108: astore 6
    //   110: aload_0
    //   111: aconst_null
    //   112: putfield 129	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:queue	Ljava/util/List;
    //   115: aload 6
    //   117: ifnonnull +56 -> 173
    //   120: aload_0
    //   121: iconst_0
    //   122: putfield 127	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:emitting	Z
    //   125: iload_3
    //   126: istore_2
    //   127: aload 7
    //   129: monitorexit
    //   130: return
    //   131: iload_1
    //   132: istore_2
    //   133: aload 7
    //   135: monitorexit
    //   136: aload 6
    //   138: athrow
    //   139: astore 6
    //   141: iload_1
    //   142: ifne +20 -> 162
    //   145: aload_0
    //   146: getfield 37	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:guard	Ljava/lang/Object;
    //   149: astore 7
    //   151: aload 7
    //   153: monitorenter
    //   154: aload_0
    //   155: iconst_0
    //   156: putfield 127	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:emitting	Z
    //   159: aload 7
    //   161: monitorexit
    //   162: aload 6
    //   164: athrow
    //   165: astore 6
    //   167: aload 7
    //   169: monitorexit
    //   170: aload 6
    //   172: athrow
    //   173: aload 7
    //   175: monitorexit
    //   176: aload_0
    //   177: getfield 32	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:child	Lrx/Subscriber;
    //   180: invokevirtual 152	rx/Subscriber:isUnsubscribed	()Z
    //   183: istore 5
    //   185: iload_2
    //   186: istore_1
    //   187: iload 5
    //   189: ifeq -112 -> 77
    //   192: aload_0
    //   193: getfield 37	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:guard	Ljava/lang/Object;
    //   196: astore 6
    //   198: aload 6
    //   200: monitorenter
    //   201: aload_0
    //   202: iconst_0
    //   203: putfield 127	rx/internal/operators/OperatorWindowWithObservable$SourceSubscriber:emitting	Z
    //   206: aload 6
    //   208: monitorexit
    //   209: return
    //   210: astore 7
    //   212: aload 6
    //   214: monitorexit
    //   215: aload 7
    //   217: athrow
    //   218: astore 6
    //   220: aload 7
    //   222: monitorexit
    //   223: aload 6
    //   225: athrow
    //   226: astore 6
    //   228: iload 4
    //   230: istore_1
    //   231: goto -90 -> 141
    //   234: astore 6
    //   236: iconst_0
    //   237: istore_1
    //   238: goto -107 -> 131
    //   241: astore 6
    //   243: iload_2
    //   244: istore_1
    //   245: goto -114 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	this	SourceSubscriber
    //   76	169	1	i	int
    //   84	160	2	j	int
    //   1	125	3	k	int
    //   3	226	4	m	int
    //   183	5	5	bool	boolean
    //   60	77	6	localList	List
    //   139	24	6	localObject1	Object
    //   165	6	6	localObject2	Object
    //   218	6	6	localObject4	Object
    //   226	1	6	localObject5	Object
    //   234	1	6	localObject6	Object
    //   241	1	6	localObject7	Object
    //   9	165	7	localObject8	Object
    //   210	11	7	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   136	139	139	finally
    //   14	39	165	finally
    //   39	55	165	finally
    //   56	75	165	finally
    //   167	170	165	finally
    //   201	209	210	finally
    //   212	215	210	finally
    //   154	162	218	finally
    //   220	223	218	finally
    //   77	83	226	finally
    //   89	93	226	finally
    //   95	104	226	finally
    //   176	185	226	finally
    //   104	115	234	finally
    //   120	125	234	finally
    //   173	176	234	finally
    //   127	130	241	finally
    //   133	136	241	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithObservable.SourceSubscriber
 * JD-Core Version:    0.7.0.1
 */