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
    try
    {
      if ((this.first) && (!this.emitting))
      {
        boolean bool = false;
        this.first = false;
        if (paramObject != null) {
          bool = true;
        }
        this.emitting = bool;
        if (paramObject != null) {
          emitLoop(null, paramObject, paramNotificationLite);
        }
        return;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  protected void emitLoop(List<Object> paramList, Object paramObject, NotificationLite<T> paramNotificationLite)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: iconst_1
    //   4: istore 4
    //   6: aload_1
    //   7: ifnull +33 -> 40
    //   10: aload_1
    //   11: invokeinterface 53 1 0
    //   16: astore_1
    //   17: aload_1
    //   18: invokeinterface 59 1 0
    //   23: ifeq +17 -> 40
    //   26: aload_0
    //   27: aload_1
    //   28: invokeinterface 63 1 0
    //   33: aload_3
    //   34: invokevirtual 65	rx/subjects/SubjectSubscriptionManager$SubjectObserver:accept	(Ljava/lang/Object;Lrx/internal/operators/NotificationLite;)V
    //   37: goto -20 -> 17
    //   40: iload 4
    //   42: istore 5
    //   44: iload 4
    //   46: ifeq +12 -> 58
    //   49: aload_0
    //   50: aload_2
    //   51: aload_3
    //   52: invokevirtual 65	rx/subjects/SubjectSubscriptionManager$SubjectObserver:accept	(Ljava/lang/Object;Lrx/internal/operators/NotificationLite;)V
    //   55: iconst_0
    //   56: istore 5
    //   58: aload_0
    //   59: monitorenter
    //   60: aload_0
    //   61: getfield 67	rx/subjects/SubjectSubscriptionManager$SubjectObserver:queue	Ljava/util/List;
    //   64: astore_1
    //   65: aload_0
    //   66: aconst_null
    //   67: putfield 67	rx/subjects/SubjectSubscriptionManager$SubjectObserver:queue	Ljava/util/List;
    //   70: aload_1
    //   71: ifnonnull +15 -> 86
    //   74: aload_0
    //   75: iconst_0
    //   76: putfield 43	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
    //   79: iload 6
    //   81: istore 5
    //   83: aload_0
    //   84: monitorexit
    //   85: return
    //   86: aload_0
    //   87: monitorexit
    //   88: iload 5
    //   90: istore 4
    //   92: goto -86 -> 6
    //   95: astore_1
    //   96: iconst_0
    //   97: istore 4
    //   99: iload 4
    //   101: istore 5
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    //   107: astore_1
    //   108: goto +11 -> 119
    //   111: astore_1
    //   112: iload 5
    //   114: istore 4
    //   116: goto -17 -> 99
    //   119: iload 4
    //   121: ifne +20 -> 141
    //   124: aload_0
    //   125: monitorenter
    //   126: aload_0
    //   127: iconst_0
    //   128: putfield 43	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
    //   131: aload_0
    //   132: monitorexit
    //   133: goto +8 -> 141
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_1
    //   140: athrow
    //   141: goto +5 -> 146
    //   144: aload_1
    //   145: athrow
    //   146: goto -2 -> 144
    //   149: astore_1
    //   150: iconst_0
    //   151: istore 4
    //   153: goto -34 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	SubjectObserver
    //   0	156	1	paramList	List<Object>
    //   0	156	2	paramObject	Object
    //   0	156	3	paramNotificationLite	NotificationLite<T>
    //   4	148	4	i	int
    //   42	71	5	j	int
    //   1	79	6	k	int
    // Exception table:
    //   from	to	target	type
    //   60	70	95	finally
    //   74	79	95	finally
    //   86	88	95	finally
    //   105	107	107	finally
    //   83	85	111	finally
    //   103	105	111	finally
    //   126	133	136	finally
    //   137	139	136	finally
    //   10	17	149	finally
    //   17	37	149	finally
    //   49	55	149	finally
    //   58	60	149	finally
  }
  
  protected void emitNext(Object paramObject, NotificationLite<T> paramNotificationLite)
  {
    if (!this.fastPath) {
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
      }
      finally {}
    }
    paramNotificationLite.accept(this.actual, paramObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.subjects.SubjectSubscriptionManager.SubjectObserver
 * JD-Core Version:    0.7.0.1
 */