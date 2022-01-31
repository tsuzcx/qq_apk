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
    }
    finally {}
    this.terminated = true;
    if (this.emitting)
    {
      SerializedObserver.FastList localFastList = this.queue;
      Object localObject2 = localFastList;
      if (localFastList == null)
      {
        localObject2 = new SerializedObserver.FastList();
        this.queue = ((SerializedObserver.FastList)localObject2);
      }
      ((SerializedObserver.FastList)localObject2).add(this.nl.completed());
      return;
    }
    this.emitting = true;
    this.actual.onCompleted();
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
    }
    finally {}
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
    }
    finally {}
    SerializedObserver.FastList localFastList2;
    SerializedObserver.FastList localFastList1;
    if (this.emitting)
    {
      localFastList2 = this.queue;
      localFastList1 = localFastList2;
      if (localFastList2 == null)
      {
        localFastList1 = new SerializedObserver.FastList();
        this.queue = localFastList1;
      }
      localFastList1.add(this.nl.next(paramT));
      return;
    }
    this.emitting = true;
    int i;
    try
    {
      this.actual.onNext(paramT);
      do
      {
        i = 0;
      } while (i >= 1024);
      try
      {
        localFastList1 = this.queue;
        if (localFastList1 == null)
        {
          this.emitting = false;
          return;
        }
      }
      finally {}
      this.queue = null;
    }
    catch (Throwable localThrowable1)
    {
      this.terminated = true;
      Exceptions.throwOrReport(localThrowable1, this.actual, paramT);
      return;
    }
    Object[] arrayOfObject = localThrowable1.array;
    int k = arrayOfObject.length;
    int j = 0;
    for (;;)
    {
      if (j < k)
      {
        localFastList2 = arrayOfObject[j];
        if (localFastList2 != null) {}
      }
      else
      {
        i += 1;
        break;
      }
      try
      {
        if (this.nl.accept(this.actual, localFastList2))
        {
          this.terminated = true;
          return;
        }
      }
      catch (Throwable localThrowable2)
      {
        this.terminated = true;
        Exceptions.throwIfFatal(localThrowable2);
        this.actual.onError(OnErrorThrowable.addValueAsLastCause(localThrowable2, paramT));
        return;
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.observers.SerializedObserver
 * JD-Core Version:    0.7.0.1
 */