package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.Subscriptions;

final class OperatorWindowWithTime$ExactSubscriber
  extends Subscriber<T>
{
  final Subscriber<? super Observable<T>> child;
  boolean emitting;
  final Object guard;
  List<Object> queue;
  volatile OperatorWindowWithTime.State<T> state;
  final Scheduler.Worker worker;
  
  public OperatorWindowWithTime$ExactSubscriber(Subscriber<? super Observable<T>> paramSubscriber, Scheduler.Worker paramWorker)
  {
    this.child = new SerializedSubscriber(paramWorker);
    Object localObject;
    this.worker = localObject;
    this.guard = new Object();
    this.state = OperatorWindowWithTime.State.empty();
    paramWorker.add(Subscriptions.create(new OperatorWindowWithTime.ExactSubscriber.1(this, paramSubscriber)));
  }
  
  void complete()
  {
    Observer localObserver = this.state.consumer;
    this.state = this.state.clear();
    if (localObserver != null) {
      localObserver.onCompleted();
    }
    this.child.onCompleted();
    unsubscribe();
  }
  
  boolean drain(List<Object> paramList)
  {
    if (paramList == null) {
      return true;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (localObject == OperatorWindowWithTime.NEXT_SUBJECT)
      {
        if (!replaceSubject()) {
          return false;
        }
      }
      else
      {
        if (OperatorWindowWithTime.nl.isError(localObject))
        {
          error(OperatorWindowWithTime.nl.getError(localObject));
          return true;
        }
        if (OperatorWindowWithTime.nl.isCompleted(localObject))
        {
          complete();
          return true;
        }
        if (!emitValue(localObject)) {
          return false;
        }
      }
    }
    return true;
  }
  
  boolean emitValue(T paramT)
  {
    OperatorWindowWithTime.State localState2 = this.state;
    OperatorWindowWithTime.State localState1 = localState2;
    if (localState2.consumer == null)
    {
      if (!replaceSubject()) {
        return false;
      }
      localState1 = this.state;
    }
    localState1.consumer.onNext(paramT);
    if (localState1.count == this.this$0.size - 1)
    {
      localState1.consumer.onCompleted();
      paramT = localState1.clear();
    }
    else
    {
      paramT = localState1.next();
    }
    this.state = paramT;
    return true;
  }
  
  void error(Throwable paramThrowable)
  {
    Observer localObserver = this.state.consumer;
    this.state = this.state.clear();
    if (localObserver != null) {
      localObserver.onError(paramThrowable);
    }
    this.child.onError(paramThrowable);
    unsubscribe();
  }
  
  /* Error */
  void nextWindow()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:guard	Ljava/lang/Object;
    //   4: astore 4
    //   6: aload 4
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 160	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitting	Z
    //   13: ifeq +38 -> 51
    //   16: aload_0
    //   17: getfield 162	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:queue	Ljava/util/List;
    //   20: ifnonnull +14 -> 34
    //   23: aload_0
    //   24: new 164	java/util/ArrayList
    //   27: dup
    //   28: invokespecial 165	java/util/ArrayList:<init>	()V
    //   31: putfield 162	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:queue	Ljava/util/List;
    //   34: aload_0
    //   35: getfield 162	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:queue	Ljava/util/List;
    //   38: getstatic 109	rx/internal/operators/OperatorWindowWithTime:NEXT_SUBJECT	Ljava/lang/Object;
    //   41: invokeinterface 167 2 0
    //   46: pop
    //   47: aload 4
    //   49: monitorexit
    //   50: return
    //   51: iconst_1
    //   52: istore_2
    //   53: aload_0
    //   54: iconst_1
    //   55: putfield 160	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitting	Z
    //   58: aload 4
    //   60: monitorexit
    //   61: aload_0
    //   62: invokevirtual 112	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:replaceSubject	()Z
    //   65: istore_3
    //   66: iload_3
    //   67: ifne +29 -> 96
    //   70: aload_0
    //   71: getfield 43	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:guard	Ljava/lang/Object;
    //   74: astore 4
    //   76: aload 4
    //   78: monitorenter
    //   79: aload_0
    //   80: iconst_0
    //   81: putfield 160	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitting	Z
    //   84: aload 4
    //   86: monitorexit
    //   87: return
    //   88: astore 5
    //   90: aload 4
    //   92: monitorexit
    //   93: aload 5
    //   95: athrow
    //   96: aload_0
    //   97: getfield 43	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:guard	Ljava/lang/Object;
    //   100: astore 5
    //   102: aload 5
    //   104: monitorenter
    //   105: aload_0
    //   106: getfield 162	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:queue	Ljava/util/List;
    //   109: astore 4
    //   111: aload 4
    //   113: ifnonnull +12 -> 125
    //   116: aload_0
    //   117: iconst_0
    //   118: putfield 160	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitting	Z
    //   121: aload 5
    //   123: monitorexit
    //   124: return
    //   125: aload_0
    //   126: aconst_null
    //   127: putfield 162	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:queue	Ljava/util/List;
    //   130: aload 5
    //   132: monitorexit
    //   133: aload_0
    //   134: aload 4
    //   136: invokevirtual 169	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:drain	(Ljava/util/List;)Z
    //   139: istore_3
    //   140: iload_3
    //   141: ifne -45 -> 96
    //   144: aload_0
    //   145: getfield 43	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:guard	Ljava/lang/Object;
    //   148: astore 4
    //   150: aload 4
    //   152: monitorenter
    //   153: aload_0
    //   154: iconst_0
    //   155: putfield 160	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitting	Z
    //   158: aload 4
    //   160: monitorexit
    //   161: return
    //   162: astore 5
    //   164: aload 4
    //   166: monitorexit
    //   167: aload 5
    //   169: athrow
    //   170: astore 4
    //   172: iconst_0
    //   173: istore_1
    //   174: iload_1
    //   175: istore_2
    //   176: aload 5
    //   178: monitorexit
    //   179: aload 4
    //   181: athrow
    //   182: astore 4
    //   184: goto +14 -> 198
    //   187: astore 4
    //   189: iload_2
    //   190: istore_1
    //   191: goto -17 -> 174
    //   194: astore 4
    //   196: iconst_0
    //   197: istore_1
    //   198: iload_1
    //   199: ifne +31 -> 230
    //   202: aload_0
    //   203: getfield 43	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:guard	Ljava/lang/Object;
    //   206: astore 5
    //   208: aload 5
    //   210: monitorenter
    //   211: aload_0
    //   212: iconst_0
    //   213: putfield 160	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitting	Z
    //   216: aload 5
    //   218: monitorexit
    //   219: goto +11 -> 230
    //   222: astore 4
    //   224: aload 5
    //   226: monitorexit
    //   227: aload 4
    //   229: athrow
    //   230: aload 4
    //   232: athrow
    //   233: astore 5
    //   235: aload 4
    //   237: monitorexit
    //   238: goto +6 -> 244
    //   241: aload 5
    //   243: athrow
    //   244: goto -3 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	ExactSubscriber
    //   173	26	1	i	int
    //   52	138	2	j	int
    //   65	76	3	bool	boolean
    //   170	10	4	localObject2	Object
    //   182	1	4	localObject3	Object
    //   187	1	4	localObject4	Object
    //   194	1	4	localObject5	Object
    //   222	14	4	localObject6	Object
    //   88	6	5	localObject7	Object
    //   100	31	5	localObject8	Object
    //   162	15	5	localObject9	Object
    //   233	9	5	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   79	87	88	finally
    //   90	93	88	finally
    //   153	161	162	finally
    //   164	167	162	finally
    //   105	111	170	finally
    //   116	121	170	finally
    //   125	133	170	finally
    //   179	182	182	finally
    //   121	124	187	finally
    //   176	179	187	finally
    //   61	66	194	finally
    //   96	105	194	finally
    //   133	140	194	finally
    //   211	219	222	finally
    //   224	227	222	finally
    //   9	34	233	finally
    //   34	50	233	finally
    //   53	61	233	finally
    //   235	238	233	finally
  }
  
  public void onCompleted()
  {
    synchronized (this.guard)
    {
      if (this.emitting)
      {
        if (this.queue == null) {
          this.queue = new ArrayList();
        }
        this.queue.add(OperatorWindowWithTime.nl.completed());
        return;
      }
      List localList = this.queue;
      this.queue = null;
      this.emitting = true;
      try
      {
        drain(localList);
        complete();
        return;
      }
      catch (Throwable localThrowable)
      {
        error(localThrowable);
        return;
      }
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    synchronized (this.guard)
    {
      if (this.emitting)
      {
        this.queue = Collections.singletonList(OperatorWindowWithTime.nl.error(paramThrowable));
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
    //   0: aload_0
    //   1: getfield 43	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:guard	Ljava/lang/Object;
    //   4: astore 5
    //   6: aload 5
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 160	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitting	Z
    //   13: ifeq +36 -> 49
    //   16: aload_0
    //   17: getfield 162	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:queue	Ljava/util/List;
    //   20: ifnonnull +14 -> 34
    //   23: aload_0
    //   24: new 164	java/util/ArrayList
    //   27: dup
    //   28: invokespecial 165	java/util/ArrayList:<init>	()V
    //   31: putfield 162	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:queue	Ljava/util/List;
    //   34: aload_0
    //   35: getfield 162	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:queue	Ljava/util/List;
    //   38: aload_1
    //   39: invokeinterface 167 2 0
    //   44: pop
    //   45: aload 5
    //   47: monitorexit
    //   48: return
    //   49: iconst_1
    //   50: istore_3
    //   51: aload_0
    //   52: iconst_1
    //   53: putfield 160	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitting	Z
    //   56: aload 5
    //   58: monitorexit
    //   59: aload_0
    //   60: aload_1
    //   61: invokevirtual 138	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitValue	(Ljava/lang/Object;)Z
    //   64: istore 4
    //   66: iload 4
    //   68: ifne +25 -> 93
    //   71: aload_0
    //   72: getfield 43	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:guard	Ljava/lang/Object;
    //   75: astore_1
    //   76: aload_1
    //   77: monitorenter
    //   78: aload_0
    //   79: iconst_0
    //   80: putfield 160	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitting	Z
    //   83: aload_1
    //   84: monitorexit
    //   85: return
    //   86: astore 5
    //   88: aload_1
    //   89: monitorexit
    //   90: aload 5
    //   92: athrow
    //   93: aload_0
    //   94: getfield 43	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:guard	Ljava/lang/Object;
    //   97: astore 5
    //   99: aload 5
    //   101: monitorenter
    //   102: aload_0
    //   103: getfield 162	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:queue	Ljava/util/List;
    //   106: astore_1
    //   107: aload_1
    //   108: ifnonnull +12 -> 120
    //   111: aload_0
    //   112: iconst_0
    //   113: putfield 160	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitting	Z
    //   116: aload 5
    //   118: monitorexit
    //   119: return
    //   120: aload_0
    //   121: aconst_null
    //   122: putfield 162	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:queue	Ljava/util/List;
    //   125: aload 5
    //   127: monitorexit
    //   128: aload_0
    //   129: aload_1
    //   130: invokevirtual 169	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:drain	(Ljava/util/List;)Z
    //   133: istore 4
    //   135: iload 4
    //   137: ifne -44 -> 93
    //   140: aload_0
    //   141: getfield 43	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:guard	Ljava/lang/Object;
    //   144: astore_1
    //   145: aload_1
    //   146: monitorenter
    //   147: aload_0
    //   148: iconst_0
    //   149: putfield 160	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitting	Z
    //   152: aload_1
    //   153: monitorexit
    //   154: return
    //   155: astore 5
    //   157: aload_1
    //   158: monitorexit
    //   159: aload 5
    //   161: athrow
    //   162: astore_1
    //   163: iconst_0
    //   164: istore_2
    //   165: iload_2
    //   166: istore_3
    //   167: aload 5
    //   169: monitorexit
    //   170: aload_1
    //   171: athrow
    //   172: astore_1
    //   173: goto +12 -> 185
    //   176: astore_1
    //   177: iload_3
    //   178: istore_2
    //   179: goto -14 -> 165
    //   182: astore_1
    //   183: iconst_0
    //   184: istore_2
    //   185: iload_2
    //   186: ifne +29 -> 215
    //   189: aload_0
    //   190: getfield 43	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:guard	Ljava/lang/Object;
    //   193: astore 5
    //   195: aload 5
    //   197: monitorenter
    //   198: aload_0
    //   199: iconst_0
    //   200: putfield 160	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitting	Z
    //   203: aload 5
    //   205: monitorexit
    //   206: goto +9 -> 215
    //   209: astore_1
    //   210: aload 5
    //   212: monitorexit
    //   213: aload_1
    //   214: athrow
    //   215: aload_1
    //   216: athrow
    //   217: astore_1
    //   218: aload 5
    //   220: monitorexit
    //   221: goto +5 -> 226
    //   224: aload_1
    //   225: athrow
    //   226: goto -2 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	ExactSubscriber
    //   164	22	2	i	int
    //   50	128	3	j	int
    //   64	72	4	bool	boolean
    //   4	53	5	localObject1	Object
    //   86	5	5	localObject2	Object
    //   97	29	5	localObject3	Object
    //   155	13	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   78	85	86	finally
    //   88	90	86	finally
    //   147	154	155	finally
    //   157	159	155	finally
    //   102	107	162	finally
    //   111	116	162	finally
    //   120	128	162	finally
    //   170	172	172	finally
    //   116	119	176	finally
    //   167	170	176	finally
    //   59	66	182	finally
    //   93	102	182	finally
    //   128	135	182	finally
    //   198	206	209	finally
    //   210	213	209	finally
    //   9	34	217	finally
    //   34	48	217	finally
    //   51	59	217	finally
    //   218	221	217	finally
  }
  
  public void onStart()
  {
    request(9223372036854775807L);
  }
  
  boolean replaceSubject()
  {
    Object localObject = this.state.consumer;
    if (localObject != null) {
      ((Observer)localObject).onCompleted();
    }
    if (this.child.isUnsubscribed())
    {
      this.state = this.state.clear();
      unsubscribe();
      return false;
    }
    localObject = UnicastSubject.create();
    this.state = this.state.create((Observer)localObject, (Observable)localObject);
    this.child.onNext(localObject);
    return true;
  }
  
  void scheduleExact()
  {
    this.worker.schedulePeriodically(new OperatorWindowWithTime.ExactSubscriber.2(this), 0L, this.this$0.timespan, this.this$0.unit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithTime.ExactSubscriber
 * JD-Core Version:    0.7.0.1
 */