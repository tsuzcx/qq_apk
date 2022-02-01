package rx.internal.operators;

import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;

final class TakeLastQueueProducer<T>
  extends AtomicLong
  implements Producer
{
  private final Deque<Object> deque;
  private volatile boolean emittingStarted = false;
  private final NotificationLite<T> notification;
  private final Subscriber<? super T> subscriber;
  
  public TakeLastQueueProducer(NotificationLite<T> paramNotificationLite, Deque<Object> paramDeque, Subscriber<? super T> paramSubscriber)
  {
    this.notification = paramNotificationLite;
    this.deque = paramDeque;
    this.subscriber = paramSubscriber;
  }
  
  void emit(long paramLong)
  {
    if (get() == 9223372036854775807L)
    {
      if (paramLong == 0L) {}
      try
      {
        Iterator localIterator = this.deque.iterator();
        if (localIterator.hasNext())
        {
          localObject3 = localIterator.next();
          bool = this.subscriber.isUnsubscribed();
          if (!bool) {}
        }
        while (paramLong != 0L)
        {
          Object localObject3;
          boolean bool;
          return;
          this.notification.accept(this.subscriber, localObject3);
          break;
        }
      }
      catch (Throwable localThrowable)
      {
        Exceptions.throwOrReport(localThrowable, this.subscriber);
        return;
        return;
      }
      finally
      {
        this.deque.clear();
      }
    }
    label205:
    long l;
    do
    {
      paramLong = get();
      int i = 0;
      for (;;)
      {
        paramLong -= 1L;
        if (paramLong < 0L) {
          break label205;
        }
        Object localObject2 = this.deque.poll();
        if (localObject2 == null) {
          break label205;
        }
        if ((this.subscriber.isUnsubscribed()) || (this.notification.accept(this.subscriber, localObject2))) {
          break;
        }
        i += 1;
      }
      do
      {
        paramLong = get();
        l = paramLong - i;
        if (paramLong == 9223372036854775807L) {
          break;
        }
      } while (!compareAndSet(paramLong, l));
    } while (l != 0L);
  }
  
  public void request(long paramLong)
  {
    if (get() == 9223372036854775807L) {}
    for (;;)
    {
      return;
      if (paramLong == 9223372036854775807L) {}
      for (paramLong = getAndSet(9223372036854775807L); this.emittingStarted; paramLong = BackpressureUtils.getAndAddRequest(this, paramLong))
      {
        emit(paramLong);
        return;
      }
    }
  }
  
  void startEmitting()
  {
    if (!this.emittingStarted)
    {
      this.emittingStarted = true;
      emit(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.TakeLastQueueProducer
 * JD-Core Version:    0.7.0.1
 */