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
    if (paramList == null) {}
    Object localObject;
    do
    {
      do
      {
        while (!paramList.hasNext())
        {
          return true;
          paramList = paramList.iterator();
        }
        localObject = paramList.next();
        if (localObject != OperatorWindowWithTime.NEXT_SUBJECT) {
          break;
        }
      } while (replaceSubject());
      return false;
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
    } while (emitValue(localObject));
    return false;
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
    if (localState1.count == this.this$0.size - 1) {
      localState1.consumer.onCompleted();
    }
    for (paramT = localState1.clear();; paramT = localState1.next())
    {
      this.state = paramT;
      return true;
    }
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
    //   0: iconst_1
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_1
    //   4: aload_0
    //   5: getfield 43	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:guard	Ljava/lang/Object;
    //   8: astore 4
    //   10: aload 4
    //   12: monitorenter
    //   13: aload_0
    //   14: getfield 160	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitting	Z
    //   17: ifeq +38 -> 55
    //   20: aload_0
    //   21: getfield 162	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:queue	Ljava/util/List;
    //   24: ifnonnull +14 -> 38
    //   27: aload_0
    //   28: new 164	java/util/ArrayList
    //   31: dup
    //   32: invokespecial 165	java/util/ArrayList:<init>	()V
    //   35: putfield 162	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:queue	Ljava/util/List;
    //   38: aload_0
    //   39: getfield 162	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:queue	Ljava/util/List;
    //   42: getstatic 109	rx/internal/operators/OperatorWindowWithTime:NEXT_SUBJECT	Ljava/lang/Object;
    //   45: invokeinterface 167 2 0
    //   50: pop
    //   51: aload 4
    //   53: monitorexit
    //   54: return
    //   55: aload_0
    //   56: iconst_1
    //   57: putfield 160	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitting	Z
    //   60: aload 4
    //   62: monitorexit
    //   63: aload_0
    //   64: invokevirtual 112	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:replaceSubject	()Z
    //   67: istore_3
    //   68: iload_3
    //   69: ifne +37 -> 106
    //   72: aload_0
    //   73: getfield 43	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:guard	Ljava/lang/Object;
    //   76: astore 4
    //   78: aload 4
    //   80: monitorenter
    //   81: aload_0
    //   82: iconst_0
    //   83: putfield 160	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitting	Z
    //   86: aload 4
    //   88: monitorexit
    //   89: return
    //   90: astore 5
    //   92: aload 4
    //   94: monitorexit
    //   95: aload 5
    //   97: athrow
    //   98: astore 5
    //   100: aload 4
    //   102: monitorexit
    //   103: aload 5
    //   105: athrow
    //   106: aload_0
    //   107: getfield 43	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:guard	Ljava/lang/Object;
    //   110: astore 5
    //   112: aload 5
    //   114: monitorenter
    //   115: aload_0
    //   116: getfield 162	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:queue	Ljava/util/List;
    //   119: astore 4
    //   121: aload 4
    //   123: ifnonnull +46 -> 169
    //   126: aload_0
    //   127: iconst_0
    //   128: putfield 160	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitting	Z
    //   131: aload 5
    //   133: monitorexit
    //   134: return
    //   135: iload_1
    //   136: istore_2
    //   137: aload 5
    //   139: monitorexit
    //   140: aload 4
    //   142: athrow
    //   143: astore 4
    //   145: iload_1
    //   146: ifne +20 -> 166
    //   149: aload_0
    //   150: getfield 43	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:guard	Ljava/lang/Object;
    //   153: astore 5
    //   155: aload 5
    //   157: monitorenter
    //   158: aload_0
    //   159: iconst_0
    //   160: putfield 160	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitting	Z
    //   163: aload 5
    //   165: monitorexit
    //   166: aload 4
    //   168: athrow
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield 162	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:queue	Ljava/util/List;
    //   174: aload 5
    //   176: monitorexit
    //   177: aload_0
    //   178: aload 4
    //   180: invokevirtual 169	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:drain	(Ljava/util/List;)Z
    //   183: istore_3
    //   184: iload_3
    //   185: ifne -79 -> 106
    //   188: aload_0
    //   189: getfield 43	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:guard	Ljava/lang/Object;
    //   192: astore 4
    //   194: aload 4
    //   196: monitorenter
    //   197: aload_0
    //   198: iconst_0
    //   199: putfield 160	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitting	Z
    //   202: aload 4
    //   204: monitorexit
    //   205: return
    //   206: astore 5
    //   208: aload 4
    //   210: monitorexit
    //   211: aload 5
    //   213: athrow
    //   214: astore 4
    //   216: aload 5
    //   218: monitorexit
    //   219: aload 4
    //   221: athrow
    //   222: astore 4
    //   224: goto -79 -> 145
    //   227: astore 4
    //   229: iconst_0
    //   230: istore_1
    //   231: goto -96 -> 135
    //   234: astore 4
    //   236: iload_2
    //   237: istore_1
    //   238: goto -103 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	ExactSubscriber
    //   3	235	1	i	int
    //   1	236	2	j	int
    //   67	118	3	bool	boolean
    //   8	133	4	localObject1	Object
    //   143	36	4	localList	List
    //   214	6	4	localObject3	Object
    //   222	1	4	localObject4	Object
    //   227	1	4	localObject5	Object
    //   234	1	4	localObject6	Object
    //   90	6	5	localObject7	Object
    //   98	6	5	localObject8	Object
    //   110	65	5	localObject9	Object
    //   206	11	5	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   81	89	90	finally
    //   92	95	90	finally
    //   13	38	98	finally
    //   38	54	98	finally
    //   55	63	98	finally
    //   100	103	98	finally
    //   140	143	143	finally
    //   197	205	206	finally
    //   208	211	206	finally
    //   158	166	214	finally
    //   216	219	214	finally
    //   63	68	222	finally
    //   106	115	222	finally
    //   177	184	222	finally
    //   115	121	227	finally
    //   126	131	227	finally
    //   169	177	227	finally
    //   131	134	234	finally
    //   137	140	234	finally
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
        this.queue.add(OperatorWindowWithTime.nl.completed());
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
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_2
    //   4: aload_0
    //   5: getfield 43	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:guard	Ljava/lang/Object;
    //   8: astore 5
    //   10: aload 5
    //   12: monitorenter
    //   13: aload_0
    //   14: getfield 160	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitting	Z
    //   17: ifeq +36 -> 53
    //   20: aload_0
    //   21: getfield 162	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:queue	Ljava/util/List;
    //   24: ifnonnull +14 -> 38
    //   27: aload_0
    //   28: new 164	java/util/ArrayList
    //   31: dup
    //   32: invokespecial 165	java/util/ArrayList:<init>	()V
    //   35: putfield 162	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:queue	Ljava/util/List;
    //   38: aload_0
    //   39: getfield 162	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:queue	Ljava/util/List;
    //   42: aload_1
    //   43: invokeinterface 167 2 0
    //   48: pop
    //   49: aload 5
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: iconst_1
    //   55: putfield 160	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitting	Z
    //   58: aload 5
    //   60: monitorexit
    //   61: aload_0
    //   62: aload_1
    //   63: invokevirtual 138	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitValue	(Ljava/lang/Object;)Z
    //   66: istore 4
    //   68: iload 4
    //   70: ifne +31 -> 101
    //   73: aload_0
    //   74: getfield 43	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:guard	Ljava/lang/Object;
    //   77: astore_1
    //   78: aload_1
    //   79: monitorenter
    //   80: aload_0
    //   81: iconst_0
    //   82: putfield 160	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitting	Z
    //   85: aload_1
    //   86: monitorexit
    //   87: return
    //   88: astore 5
    //   90: aload_1
    //   91: monitorexit
    //   92: aload 5
    //   94: athrow
    //   95: astore_1
    //   96: aload 5
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    //   101: aload_0
    //   102: getfield 43	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:guard	Ljava/lang/Object;
    //   105: astore 5
    //   107: aload 5
    //   109: monitorenter
    //   110: aload_0
    //   111: getfield 162	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:queue	Ljava/util/List;
    //   114: astore_1
    //   115: aload_1
    //   116: ifnonnull +43 -> 159
    //   119: aload_0
    //   120: iconst_0
    //   121: putfield 160	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitting	Z
    //   124: aload 5
    //   126: monitorexit
    //   127: return
    //   128: iload_2
    //   129: istore_3
    //   130: aload 5
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    //   135: astore_1
    //   136: iload_2
    //   137: ifne +20 -> 157
    //   140: aload_0
    //   141: getfield 43	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:guard	Ljava/lang/Object;
    //   144: astore 5
    //   146: aload 5
    //   148: monitorenter
    //   149: aload_0
    //   150: iconst_0
    //   151: putfield 160	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitting	Z
    //   154: aload 5
    //   156: monitorexit
    //   157: aload_1
    //   158: athrow
    //   159: aload_0
    //   160: aconst_null
    //   161: putfield 162	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:queue	Ljava/util/List;
    //   164: aload 5
    //   166: monitorexit
    //   167: aload_0
    //   168: aload_1
    //   169: invokevirtual 169	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:drain	(Ljava/util/List;)Z
    //   172: istore 4
    //   174: iload 4
    //   176: ifne -75 -> 101
    //   179: aload_0
    //   180: getfield 43	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:guard	Ljava/lang/Object;
    //   183: astore_1
    //   184: aload_1
    //   185: monitorenter
    //   186: aload_0
    //   187: iconst_0
    //   188: putfield 160	rx/internal/operators/OperatorWindowWithTime$ExactSubscriber:emitting	Z
    //   191: aload_1
    //   192: monitorexit
    //   193: return
    //   194: astore 5
    //   196: aload_1
    //   197: monitorexit
    //   198: aload 5
    //   200: athrow
    //   201: astore_1
    //   202: aload 5
    //   204: monitorexit
    //   205: aload_1
    //   206: athrow
    //   207: astore_1
    //   208: goto -72 -> 136
    //   211: astore_1
    //   212: iconst_0
    //   213: istore_2
    //   214: goto -86 -> 128
    //   217: astore_1
    //   218: iload_3
    //   219: istore_2
    //   220: goto -92 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	ExactSubscriber
    //   3	217	2	i	int
    //   1	218	3	j	int
    //   66	109	4	bool	boolean
    //   8	51	5	localObject1	Object
    //   88	9	5	localObject2	Object
    //   105	60	5	localObject3	Object
    //   194	9	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   80	87	88	finally
    //   90	92	88	finally
    //   13	38	95	finally
    //   38	52	95	finally
    //   53	61	95	finally
    //   96	99	95	finally
    //   133	135	135	finally
    //   186	193	194	finally
    //   196	198	194	finally
    //   149	157	201	finally
    //   202	205	201	finally
    //   61	68	207	finally
    //   101	110	207	finally
    //   167	174	207	finally
    //   110	115	211	finally
    //   119	124	211	finally
    //   159	167	211	finally
    //   124	127	217	finally
    //   130	133	217	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithTime.ExactSubscriber
 * JD-Core Version:    0.7.0.1
 */