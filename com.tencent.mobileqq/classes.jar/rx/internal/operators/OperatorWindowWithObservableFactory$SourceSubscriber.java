package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func0;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

final class OperatorWindowWithObservableFactory$SourceSubscriber<T, U>
  extends Subscriber<T>
{
  final Subscriber<? super Observable<T>> child;
  Observer<T> consumer;
  boolean emitting;
  final Object guard;
  final Func0<? extends Observable<? extends U>> otherFactory;
  Observable<T> producer;
  List<Object> queue;
  final SerialSubscription ssub;
  
  public OperatorWindowWithObservableFactory$SourceSubscriber(Subscriber<? super Observable<T>> paramSubscriber, Func0<? extends Observable<? extends U>> paramFunc0)
  {
    this.child = new SerializedSubscriber(paramSubscriber);
    this.guard = new Object();
    this.ssub = new SerialSubscription();
    this.otherFactory = paramFunc0;
    add(this.ssub);
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
    Object localObject = UnicastSubject.create();
    this.consumer = ((Observer)localObject);
    this.producer = ((Observable)localObject);
    try
    {
      localObject = (Observable)this.otherFactory.call();
      OperatorWindowWithObservableFactory.BoundarySubscriber localBoundarySubscriber = new OperatorWindowWithObservableFactory.BoundarySubscriber(this.child, this);
      this.ssub.set(localBoundarySubscriber);
      ((Observable)localObject).unsafeSubscribe(localBoundarySubscriber);
      return;
    }
    catch (Throwable localThrowable)
    {
      this.child.onError(localThrowable);
      unsubscribe();
    }
  }
  
  void drain(List<Object> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (localObject == OperatorWindowWithObservableFactory.NEXT_SUBJECT)
      {
        replaceSubject();
      }
      else
      {
        if (OperatorWindowWithObservableFactory.nl.isError(localObject))
        {
          error(OperatorWindowWithObservableFactory.nl.getError(localObject));
          return;
        }
        if (OperatorWindowWithObservableFactory.nl.isCompleted(localObject))
        {
          complete();
          return;
        }
        emitValue(localObject);
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
    synchronized (this.guard)
    {
      if (this.emitting)
      {
        if (this.queue == null) {
          this.queue = new ArrayList();
        }
        this.queue.add(OperatorWindowWithObservableFactory.nl.completed());
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
        this.queue = Collections.singletonList(OperatorWindowWithObservableFactory.nl.error(paramThrowable));
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
    //   1: getfield 43	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:guard	Ljava/lang/Object;
    //   4: astore 7
    //   6: aload 7
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 163	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:emitting	Z
    //   13: ifeq +36 -> 49
    //   16: aload_0
    //   17: getfield 165	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:queue	Ljava/util/List;
    //   20: ifnonnull +14 -> 34
    //   23: aload_0
    //   24: new 167	java/util/ArrayList
    //   27: dup
    //   28: invokespecial 168	java/util/ArrayList:<init>	()V
    //   31: putfield 165	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:queue	Ljava/util/List;
    //   34: aload_0
    //   35: getfield 165	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:queue	Ljava/util/List;
    //   38: aload_1
    //   39: invokeinterface 173 2 0
    //   44: pop
    //   45: aload 7
    //   47: monitorexit
    //   48: return
    //   49: aload_0
    //   50: getfield 165	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:queue	Ljava/util/List;
    //   53: astore 6
    //   55: aload_0
    //   56: aconst_null
    //   57: putfield 165	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:queue	Ljava/util/List;
    //   60: iconst_1
    //   61: istore 4
    //   63: aload_0
    //   64: iconst_1
    //   65: putfield 163	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:emitting	Z
    //   68: aload 7
    //   70: monitorexit
    //   71: iconst_1
    //   72: istore_2
    //   73: aload_0
    //   74: aload 6
    //   76: invokevirtual 175	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:drain	(Ljava/util/List;)V
    //   79: iload_2
    //   80: istore_3
    //   81: iload_2
    //   82: ifeq +10 -> 92
    //   85: aload_0
    //   86: aload_1
    //   87: invokevirtual 155	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:emitValue	(Ljava/lang/Object;)V
    //   90: iconst_0
    //   91: istore_3
    //   92: aload_0
    //   93: getfield 43	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:guard	Ljava/lang/Object;
    //   96: astore 7
    //   98: aload 7
    //   100: monitorenter
    //   101: aload_0
    //   102: getfield 165	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:queue	Ljava/util/List;
    //   105: astore 6
    //   107: aload_0
    //   108: aconst_null
    //   109: putfield 165	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:queue	Ljava/util/List;
    //   112: aload 6
    //   114: ifnonnull +15 -> 129
    //   117: aload_0
    //   118: iconst_0
    //   119: putfield 163	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:emitting	Z
    //   122: iload 4
    //   124: istore_3
    //   125: aload 7
    //   127: monitorexit
    //   128: return
    //   129: aload 7
    //   131: monitorexit
    //   132: aload_0
    //   133: getfield 38	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:child	Lrx/Subscriber;
    //   136: invokevirtual 187	rx/Subscriber:isUnsubscribed	()Z
    //   139: istore 5
    //   141: iload 5
    //   143: ifeq +25 -> 168
    //   146: aload_0
    //   147: getfield 43	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:guard	Ljava/lang/Object;
    //   150: astore_1
    //   151: aload_1
    //   152: monitorenter
    //   153: aload_0
    //   154: iconst_0
    //   155: putfield 163	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:emitting	Z
    //   158: aload_1
    //   159: monitorexit
    //   160: return
    //   161: astore 6
    //   163: aload_1
    //   164: monitorexit
    //   165: aload 6
    //   167: athrow
    //   168: iload_3
    //   169: istore_2
    //   170: goto -97 -> 73
    //   173: astore_1
    //   174: iconst_0
    //   175: istore_2
    //   176: iload_2
    //   177: istore_3
    //   178: aload 7
    //   180: monitorexit
    //   181: aload_1
    //   182: athrow
    //   183: astore_1
    //   184: goto +12 -> 196
    //   187: astore_1
    //   188: iload_3
    //   189: istore_2
    //   190: goto -14 -> 176
    //   193: astore_1
    //   194: iconst_0
    //   195: istore_2
    //   196: iload_2
    //   197: ifne +29 -> 226
    //   200: aload_0
    //   201: getfield 43	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:guard	Ljava/lang/Object;
    //   204: astore 6
    //   206: aload 6
    //   208: monitorenter
    //   209: aload_0
    //   210: iconst_0
    //   211: putfield 163	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:emitting	Z
    //   214: aload 6
    //   216: monitorexit
    //   217: goto +9 -> 226
    //   220: astore_1
    //   221: aload 6
    //   223: monitorexit
    //   224: aload_1
    //   225: athrow
    //   226: aload_1
    //   227: athrow
    //   228: astore_1
    //   229: aload 7
    //   231: monitorexit
    //   232: goto +5 -> 237
    //   235: aload_1
    //   236: athrow
    //   237: goto -2 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	SourceSubscriber
    //   72	125	2	i	int
    //   80	109	3	j	int
    //   61	62	4	k	int
    //   139	3	5	bool	boolean
    //   53	60	6	localList	List
    //   161	5	6	localObject1	Object
    //   4	226	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   153	160	161	finally
    //   163	165	161	finally
    //   101	112	173	finally
    //   117	122	173	finally
    //   129	132	173	finally
    //   181	183	183	finally
    //   125	128	187	finally
    //   178	181	187	finally
    //   73	79	193	finally
    //   85	90	193	finally
    //   92	101	193	finally
    //   132	141	193	finally
    //   209	217	220	finally
    //   221	224	220	finally
    //   9	34	228	finally
    //   34	48	228	finally
    //   49	60	228	finally
    //   63	71	228	finally
    //   229	232	228	finally
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
    //   0: aload_0
    //   1: getfield 43	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:guard	Ljava/lang/Object;
    //   4: astore 6
    //   6: aload 6
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 163	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:emitting	Z
    //   13: ifeq +38 -> 51
    //   16: aload_0
    //   17: getfield 165	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:queue	Ljava/util/List;
    //   20: ifnonnull +14 -> 34
    //   23: aload_0
    //   24: new 167	java/util/ArrayList
    //   27: dup
    //   28: invokespecial 168	java/util/ArrayList:<init>	()V
    //   31: putfield 165	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:queue	Ljava/util/List;
    //   34: aload_0
    //   35: getfield 165	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:queue	Ljava/util/List;
    //   38: getstatic 126	rx/internal/operators/OperatorWindowWithObservableFactory:NEXT_SUBJECT	Ljava/lang/Object;
    //   41: invokeinterface 173 2 0
    //   46: pop
    //   47: aload 6
    //   49: monitorexit
    //   50: return
    //   51: aload_0
    //   52: getfield 165	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:queue	Ljava/util/List;
    //   55: astore 5
    //   57: aload_0
    //   58: aconst_null
    //   59: putfield 165	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:queue	Ljava/util/List;
    //   62: iconst_1
    //   63: istore_3
    //   64: aload_0
    //   65: iconst_1
    //   66: putfield 163	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:emitting	Z
    //   69: aload 6
    //   71: monitorexit
    //   72: iconst_1
    //   73: istore_1
    //   74: aload_0
    //   75: aload 5
    //   77: invokevirtual 175	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:drain	(Ljava/util/List;)V
    //   80: iload_1
    //   81: istore_2
    //   82: iload_1
    //   83: ifeq +9 -> 92
    //   86: aload_0
    //   87: invokevirtual 129	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:replaceSubject	()V
    //   90: iconst_0
    //   91: istore_2
    //   92: aload_0
    //   93: getfield 43	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:guard	Ljava/lang/Object;
    //   96: astore 6
    //   98: aload 6
    //   100: monitorenter
    //   101: aload_0
    //   102: getfield 165	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:queue	Ljava/util/List;
    //   105: astore 5
    //   107: aload_0
    //   108: aconst_null
    //   109: putfield 165	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:queue	Ljava/util/List;
    //   112: aload 5
    //   114: ifnonnull +14 -> 128
    //   117: aload_0
    //   118: iconst_0
    //   119: putfield 163	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:emitting	Z
    //   122: iload_3
    //   123: istore_2
    //   124: aload 6
    //   126: monitorexit
    //   127: return
    //   128: aload 6
    //   130: monitorexit
    //   131: aload_0
    //   132: getfield 38	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:child	Lrx/Subscriber;
    //   135: invokevirtual 187	rx/Subscriber:isUnsubscribed	()Z
    //   138: istore 4
    //   140: iload 4
    //   142: ifeq +29 -> 171
    //   145: aload_0
    //   146: getfield 43	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:guard	Ljava/lang/Object;
    //   149: astore 5
    //   151: aload 5
    //   153: monitorenter
    //   154: aload_0
    //   155: iconst_0
    //   156: putfield 163	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:emitting	Z
    //   159: aload 5
    //   161: monitorexit
    //   162: return
    //   163: astore 6
    //   165: aload 5
    //   167: monitorexit
    //   168: aload 6
    //   170: athrow
    //   171: iload_2
    //   172: istore_1
    //   173: goto -99 -> 74
    //   176: astore 5
    //   178: iconst_0
    //   179: istore_1
    //   180: iload_1
    //   181: istore_2
    //   182: aload 6
    //   184: monitorexit
    //   185: aload 5
    //   187: athrow
    //   188: astore 5
    //   190: goto +14 -> 204
    //   193: astore 5
    //   195: iload_2
    //   196: istore_1
    //   197: goto -17 -> 180
    //   200: astore 5
    //   202: iconst_0
    //   203: istore_1
    //   204: iload_1
    //   205: ifne +31 -> 236
    //   208: aload_0
    //   209: getfield 43	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:guard	Ljava/lang/Object;
    //   212: astore 6
    //   214: aload 6
    //   216: monitorenter
    //   217: aload_0
    //   218: iconst_0
    //   219: putfield 163	rx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber:emitting	Z
    //   222: aload 6
    //   224: monitorexit
    //   225: goto +11 -> 236
    //   228: astore 5
    //   230: aload 6
    //   232: monitorexit
    //   233: aload 5
    //   235: athrow
    //   236: aload 5
    //   238: athrow
    //   239: astore 5
    //   241: aload 6
    //   243: monitorexit
    //   244: goto +6 -> 250
    //   247: aload 5
    //   249: athrow
    //   250: goto -3 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	SourceSubscriber
    //   73	132	1	i	int
    //   81	115	2	j	int
    //   63	60	3	k	int
    //   138	3	4	bool	boolean
    //   176	10	5	localObject2	Object
    //   188	1	5	localObject3	Object
    //   193	1	5	localObject4	Object
    //   200	1	5	localObject5	Object
    //   228	9	5	localObject6	Object
    //   239	9	5	localObject7	Object
    //   4	125	6	localObject8	Object
    //   163	20	6	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   154	162	163	finally
    //   165	168	163	finally
    //   101	112	176	finally
    //   117	122	176	finally
    //   128	131	176	finally
    //   185	188	188	finally
    //   124	127	193	finally
    //   182	185	193	finally
    //   74	80	200	finally
    //   86	90	200	finally
    //   92	101	200	finally
    //   131	140	200	finally
    //   217	225	228	finally
    //   230	233	228	finally
    //   9	34	239	finally
    //   34	50	239	finally
    //   51	62	239	finally
    //   64	72	239	finally
    //   241	244	239	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithObservableFactory.SourceSubscriber
 * JD-Core Version:    0.7.0.1
 */