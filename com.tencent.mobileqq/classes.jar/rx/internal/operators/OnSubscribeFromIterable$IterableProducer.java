package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;

final class OnSubscribeFromIterable$IterableProducer<T>
  extends AtomicLong
  implements Producer
{
  private static final long serialVersionUID = -8730475647105475802L;
  private final Iterator<? extends T> it;
  private final Subscriber<? super T> o;
  
  OnSubscribeFromIterable$IterableProducer(Subscriber<? super T> paramSubscriber, Iterator<? extends T> paramIterator)
  {
    this.o = paramSubscriber;
    this.it = paramIterator;
  }
  
  void fastpath()
  {
    Subscriber localSubscriber = this.o;
    Iterator localIterator = this.it;
    for (;;)
    {
      if (localSubscriber.isUnsubscribed()) {
        return;
      }
      if (!localIterator.hasNext()) {
        break;
      }
      localSubscriber.onNext(localIterator.next());
    }
    if (!localSubscriber.isUnsubscribed()) {
      localSubscriber.onCompleted();
    }
  }
  
  public void request(long paramLong)
  {
    if (get() == 9223372036854775807L) {
      return;
    }
    if ((paramLong == 9223372036854775807L) && (compareAndSet(0L, 9223372036854775807L)))
    {
      fastpath();
      return;
    }
    if ((paramLong > 0L) && (BackpressureUtils.getAndAddRequest(this, paramLong) == 0L)) {
      slowpath(paramLong);
    }
  }
  
  void slowpath(long paramLong)
  {
    Subscriber localSubscriber = this.o;
    Iterator localIterator = this.it;
    long l;
    do
    {
      l = paramLong;
      for (;;)
      {
        if (localSubscriber.isUnsubscribed()) {
          return;
        }
        if (!localIterator.hasNext()) {
          break label74;
        }
        l -= 1L;
        if (l < 0L) {
          break;
        }
        localSubscriber.onNext(localIterator.next());
      }
      l = addAndGet(-paramLong);
      paramLong = l;
    } while (l != 0L);
    return;
    label74:
    if (!localSubscriber.isUnsubscribed()) {
      localSubscriber.onCompleted();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeFromIterable.IterableProducer
 * JD-Core Version:    0.7.0.1
 */