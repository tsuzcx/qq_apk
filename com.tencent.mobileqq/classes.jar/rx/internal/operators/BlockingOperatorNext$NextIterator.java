package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import rx.Notification;
import rx.Observable;
import rx.exceptions.Exceptions;

final class BlockingOperatorNext$NextIterator<T>
  implements Iterator<T>
{
  private Throwable error = null;
  private boolean hasNext = true;
  private boolean isNextConsumed = true;
  private final Observable<? extends T> items;
  private T next;
  private final BlockingOperatorNext.NextObserver<T> observer;
  private boolean started = false;
  
  BlockingOperatorNext$NextIterator(Observable<? extends T> paramObservable, BlockingOperatorNext.NextObserver<T> paramNextObserver)
  {
    this.items = paramObservable;
    this.observer = paramNextObserver;
  }
  
  private boolean moveToNext()
  {
    try
    {
      if (!this.started)
      {
        this.started = true;
        this.observer.setWaiting(1);
        this.items.materialize().subscribe(this.observer);
      }
      Notification localNotification = this.observer.takeNext();
      if (localNotification.isOnNext())
      {
        this.isNextConsumed = false;
        this.next = localNotification.getValue();
        return true;
      }
      this.hasNext = false;
      if (localNotification.isOnCompleted()) {
        return false;
      }
      if (localNotification.isOnError())
      {
        this.error = localNotification.getThrowable();
        throw Exceptions.propagate(this.error);
      }
      throw new IllegalStateException("Should not reach here");
    }
    catch (InterruptedException localInterruptedException)
    {
      this.observer.unsubscribe();
      Thread.currentThread().interrupt();
      this.error = localInterruptedException;
      throw Exceptions.propagate(this.error);
    }
  }
  
  public boolean hasNext()
  {
    Throwable localThrowable = this.error;
    if (localThrowable == null)
    {
      if (!this.hasNext) {
        return false;
      }
      if (!this.isNextConsumed) {
        return true;
      }
      return moveToNext();
    }
    throw Exceptions.propagate(localThrowable);
  }
  
  public T next()
  {
    Throwable localThrowable = this.error;
    if (localThrowable == null)
    {
      if (hasNext())
      {
        this.isNextConsumed = true;
        return this.next;
      }
      throw new NoSuchElementException("No more elements");
    }
    throw Exceptions.propagate(localThrowable);
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Read only iterator");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.BlockingOperatorNext.NextIterator
 * JD-Core Version:    0.7.0.1
 */