package rx.subjects;

import java.util.ArrayList;
import java.util.List;
import rx.Observer;
import rx.internal.operators.NotificationLite;

public final class SubjectSubscriptionManager$SubjectObserver<T>
  implements Observer<T>
{
  final Observer<? super T> actual;
  protected volatile boolean caughtUp;
  boolean emitting;
  boolean fastPath;
  boolean first = true;
  private volatile Object index;
  List<Object> queue;
  
  public SubjectSubscriptionManager$SubjectObserver(Observer<? super T> paramObserver)
  {
    this.actual = paramObserver;
  }
  
  protected void accept(Object paramObject, NotificationLite<T> paramNotificationLite)
  {
    if (paramObject != null) {
      paramNotificationLite.accept(this.actual, paramObject);
    }
  }
  
  protected void emitFirst(Object paramObject, NotificationLite<T> paramNotificationLite)
  {
    boolean bool = false;
    try
    {
      if ((!this.first) || (this.emitting)) {
        return;
      }
      this.first = false;
      if (paramObject != null) {
        bool = true;
      }
      this.emitting = bool;
      if (paramObject != null)
      {
        emitLoop(null, paramObject, paramNotificationLite);
        return;
      }
    }
    finally {}
  }
  
  /* Error */
  protected void emitLoop(List<Object> paramList, Object paramObject, NotificationLite<T> paramNotificationLite)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 7
    //   6: iconst_1
    //   7: istore 4
    //   9: aload_1
    //   10: ifnull +54 -> 64
    //   13: aload_1
    //   14: invokeinterface 53 1 0
    //   19: astore_1
    //   20: aload_1
    //   21: invokeinterface 59 1 0
    //   26: ifeq +38 -> 64
    //   29: aload_0
    //   30: aload_1
    //   31: invokeinterface 63 1 0
    //   36: aload_3
    //   37: invokevirtual 65	rx/subjects/SubjectSubscriptionManager$SubjectObserver:accept	(Ljava/lang/Object;Lrx/internal/operators/NotificationLite;)V
    //   40: goto -20 -> 20
    //   43: astore_1
    //   44: iload 7
    //   46: istore 4
    //   48: iload 4
    //   50: ifne +12 -> 62
    //   53: aload_0
    //   54: monitorenter
    //   55: aload_0
    //   56: iconst_0
    //   57: putfield 43	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    //   64: iload 4
    //   66: istore 5
    //   68: iload 4
    //   70: ifeq +12 -> 82
    //   73: aload_0
    //   74: aload_2
    //   75: aload_3
    //   76: invokevirtual 65	rx/subjects/SubjectSubscriptionManager$SubjectObserver:accept	(Ljava/lang/Object;Lrx/internal/operators/NotificationLite;)V
    //   79: iconst_0
    //   80: istore 5
    //   82: aload_0
    //   83: monitorenter
    //   84: aload_0
    //   85: getfield 67	rx/subjects/SubjectSubscriptionManager$SubjectObserver:queue	Ljava/util/List;
    //   88: astore_1
    //   89: aload_0
    //   90: aconst_null
    //   91: putfield 67	rx/subjects/SubjectSubscriptionManager$SubjectObserver:queue	Ljava/util/List;
    //   94: aload_1
    //   95: ifnonnull +15 -> 110
    //   98: aload_0
    //   99: iconst_0
    //   100: putfield 43	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
    //   103: iload 6
    //   105: istore 5
    //   107: aload_0
    //   108: monitorexit
    //   109: return
    //   110: aload_0
    //   111: monitorexit
    //   112: iload 5
    //   114: istore 4
    //   116: goto -107 -> 9
    //   119: astore_1
    //   120: iconst_0
    //   121: istore 4
    //   123: iload 4
    //   125: istore 5
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_1
    //   130: athrow
    //   131: astore_1
    //   132: goto -84 -> 48
    //   135: astore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    //   140: astore_1
    //   141: iload 5
    //   143: istore 4
    //   145: goto -22 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	SubjectObserver
    //   0	148	1	paramList	List<Object>
    //   0	148	2	paramObject	Object
    //   0	148	3	paramNotificationLite	NotificationLite<T>
    //   7	137	4	i	int
    //   66	76	5	j	int
    //   1	103	6	k	int
    //   4	41	7	m	int
    // Exception table:
    //   from	to	target	type
    //   13	20	43	finally
    //   20	40	43	finally
    //   73	79	43	finally
    //   82	84	43	finally
    //   84	94	119	finally
    //   98	103	119	finally
    //   110	112	119	finally
    //   129	131	131	finally
    //   55	62	135	finally
    //   136	138	135	finally
    //   107	109	140	finally
    //   127	129	140	finally
  }
  
  protected void emitNext(Object paramObject, NotificationLite<T> paramNotificationLite)
  {
    if (!this.fastPath) {}
    try
    {
      this.first = false;
      if (this.emitting)
      {
        if (this.queue == null) {
          this.queue = new ArrayList();
        }
        this.queue.add(paramObject);
        return;
      }
      this.fastPath = true;
      paramNotificationLite.accept(this.actual, paramObject);
      return;
    }
    finally {}
  }
  
  protected Observer<? super T> getActual()
  {
    return this.actual;
  }
  
  public <I> I index()
  {
    return this.index;
  }
  
  public void index(Object paramObject)
  {
    this.index = paramObject;
  }
  
  public void onCompleted()
  {
    this.actual.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.actual.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.actual.onNext(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.subjects.SubjectSubscriptionManager.SubjectObserver
 * JD-Core Version:    0.7.0.1
 */