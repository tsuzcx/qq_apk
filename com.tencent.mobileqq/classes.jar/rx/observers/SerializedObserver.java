package rx.observers;

import rx.Observer;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;

public class SerializedObserver<T>
  implements Observer<T>
{
  private static final int MAX_DRAIN_ITERATION = 1024;
  private final Observer<? super T> actual;
  private boolean emitting;
  private final NotificationLite<T> nl = NotificationLite.instance();
  private SerializedObserver.FastList queue;
  private volatile boolean terminated;
  
  public SerializedObserver(Observer<? super T> paramObserver)
  {
    this.actual = paramObserver;
  }
  
  public void onCompleted()
  {
    if (this.terminated) {
      return;
    }
    try
    {
      if (this.terminated) {
        return;
      }
      this.terminated = true;
      if (this.emitting)
      {
        SerializedObserver.FastList localFastList2 = this.queue;
        SerializedObserver.FastList localFastList1 = localFastList2;
        if (localFastList2 == null)
        {
          localFastList1 = new SerializedObserver.FastList();
          this.queue = localFastList1;
        }
        localFastList1.add(this.nl.completed());
        return;
      }
      this.emitting = true;
      this.actual.onCompleted();
      return;
    }
    finally {}
  }
  
  public void onError(Throwable paramThrowable)
  {
    Exceptions.throwIfFatal(paramThrowable);
    if (this.terminated) {
      return;
    }
    try
    {
      if (this.terminated) {
        return;
      }
      this.terminated = true;
      if (this.emitting)
      {
        SerializedObserver.FastList localFastList2 = this.queue;
        SerializedObserver.FastList localFastList1 = localFastList2;
        if (localFastList2 == null)
        {
          localFastList1 = new SerializedObserver.FastList();
          this.queue = localFastList1;
        }
        localFastList1.add(this.nl.error(paramThrowable));
        return;
      }
      this.emitting = true;
      this.actual.onError(paramThrowable);
      return;
    }
    finally {}
  }
  
  public void onNext(T paramT)
  {
    if (this.terminated) {
      return;
    }
    try
    {
      if (this.terminated) {
        return;
      }
      SerializedObserver.FastList localFastList;
      Object localObject;
      if (this.emitting)
      {
        localFastList = this.queue;
        localObject = localFastList;
        if (localFastList == null)
        {
          localObject = new SerializedObserver.FastList();
          this.queue = ((SerializedObserver.FastList)localObject);
        }
        ((SerializedObserver.FastList)localObject).add(this.nl.next(paramT));
        return;
      }
      this.emitting = true;
      try
      {
        this.actual.onNext(paramT);
        int i = 0;
        while (i < 1024) {
          try
          {
            localObject = this.queue;
            if (localObject == null)
            {
              this.emitting = false;
              return;
            }
            this.queue = null;
            localObject = ((SerializedObserver.FastList)localObject).array;
            int k = localObject.length;
            int j = 0;
            while (j < k)
            {
              localFastList = localObject[j];
              if (localFastList != null) {
                try
                {
                  if (this.nl.accept(this.actual, localFastList))
                  {
                    this.terminated = true;
                    return;
                  }
                  j += 1;
                }
                catch (Throwable localThrowable1)
                {
                  this.terminated = true;
                  Exceptions.throwIfFatal(localThrowable1);
                  this.actual.onError(OnErrorThrowable.addValueAsLastCause(localThrowable1, paramT));
                  return;
                }
              }
            }
            i += 1;
          }
          finally {}
        }
        paramT = finally;
      }
      catch (Throwable localThrowable2)
      {
        this.terminated = true;
        Exceptions.throwOrReport(localThrowable2, this.actual, paramT);
        return;
      }
      throw paramT;
    }
    finally {}
    for (;;) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.observers.SerializedObserver
 * JD-Core Version:    0.7.0.1
 */