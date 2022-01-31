package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import rx.Notification;
import rx.Subscriber;
import rx.exceptions.Exceptions;

final class BlockingOperatorLatest$LatestObserverIterator<T>
  extends Subscriber<Notification<? extends T>>
  implements Iterator<T>
{
  Notification<? extends T> iNotif;
  final Semaphore notify = new Semaphore(0);
  final AtomicReference<Notification<? extends T>> value = new AtomicReference();
  
  public boolean hasNext()
  {
    if ((this.iNotif != null) && (this.iNotif.isOnError())) {
      throw Exceptions.propagate(this.iNotif.getThrowable());
    }
    if (((this.iNotif == null) || (!this.iNotif.isOnCompleted())) && (this.iNotif == null)) {
      try
      {
        this.notify.acquire();
        this.iNotif = ((Notification)this.value.getAndSet(null));
        if (this.iNotif.isOnError()) {
          throw Exceptions.propagate(this.iNotif.getThrowable());
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        unsubscribe();
        Thread.currentThread().interrupt();
        this.iNotif = Notification.createOnError(localInterruptedException);
        throw Exceptions.propagate(localInterruptedException);
      }
    }
    return !this.iNotif.isOnCompleted();
  }
  
  public T next()
  {
    if ((hasNext()) && (this.iNotif.isOnNext()))
    {
      Object localObject = this.iNotif.getValue();
      this.iNotif = null;
      return localObject;
    }
    throw new NoSuchElementException();
  }
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable) {}
  
  public void onNext(Notification<? extends T> paramNotification)
  {
    if (this.value.getAndSet(paramNotification) == null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.notify.release();
      }
      return;
    }
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Read-only iterator.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.BlockingOperatorLatest.LatestObserverIterator
 * JD-Core Version:    0.7.0.1
 */