package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import rx.Notification;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.util.RxRingBuffer;

public final class BlockingOperatorToIterator$SubscriberIterator<T>
  extends Subscriber<Notification<? extends T>>
  implements Iterator<T>
{
  static final int LIMIT = RxRingBuffer.SIZE * 3 / 4;
  private Notification<? extends T> buf;
  private final BlockingQueue<Notification<? extends T>> notifications = new LinkedBlockingQueue();
  private int received;
  
  private Notification<? extends T> take()
  {
    try
    {
      Notification localNotification = (Notification)this.notifications.poll();
      if (localNotification != null) {
        return localNotification;
      }
      localNotification = (Notification)this.notifications.take();
      return localNotification;
    }
    catch (InterruptedException localInterruptedException)
    {
      unsubscribe();
      throw Exceptions.propagate(localInterruptedException);
    }
  }
  
  public boolean hasNext()
  {
    if (this.buf == null)
    {
      this.buf = take();
      this.received += 1;
      int i = this.received;
      if (i >= LIMIT)
      {
        request(i);
        this.received = 0;
      }
    }
    if (!this.buf.isOnError()) {
      return this.buf.isOnCompleted() ^ true;
    }
    throw Exceptions.propagate(this.buf.getThrowable());
  }
  
  public T next()
  {
    if (hasNext())
    {
      Object localObject = this.buf.getValue();
      this.buf = null;
      return localObject;
    }
    throw new NoSuchElementException();
  }
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable)
  {
    this.notifications.offer(Notification.createOnError(paramThrowable));
  }
  
  public void onNext(Notification<? extends T> paramNotification)
  {
    this.notifications.offer(paramNotification);
  }
  
  public void onStart()
  {
    request(RxRingBuffer.SIZE);
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Read-only iterator");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.BlockingOperatorToIterator.SubscriberIterator
 * JD-Core Version:    0.7.0.1
 */