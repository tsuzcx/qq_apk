package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;

final class OnSubscribeRange$RangeProducer
  extends AtomicLong
  implements Producer
{
  private static final long serialVersionUID = 4114392207069098388L;
  private final Subscriber<? super Integer> childSubscriber;
  private long currentIndex;
  private final int endOfRange;
  
  OnSubscribeRange$RangeProducer(Subscriber<? super Integer> paramSubscriber, int paramInt1, int paramInt2)
  {
    this.childSubscriber = paramSubscriber;
    this.currentIndex = paramInt1;
    this.endOfRange = paramInt2;
  }
  
  void fastpath()
  {
    long l2 = this.endOfRange;
    Subscriber localSubscriber = this.childSubscriber;
    for (long l1 = this.currentIndex; l1 != l2 + 1L; l1 += 1L)
    {
      if (localSubscriber.isUnsubscribed()) {
        return;
      }
      localSubscriber.onNext(Integer.valueOf((int)l1));
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
    long l4 = this.endOfRange + 1L;
    long l1 = this.currentIndex;
    Subscriber localSubscriber = this.childSubscriber;
    long l2;
    do
    {
      l2 = 0L;
      long l3;
      do
      {
        while ((l2 != paramLong) && (l1 != l4))
        {
          if (localSubscriber.isUnsubscribed()) {
            return;
          }
          localSubscriber.onNext(Integer.valueOf((int)l1));
          l1 += 1L;
          l2 += 1L;
        }
        if (localSubscriber.isUnsubscribed()) {
          return;
        }
        if (l1 == l4)
        {
          localSubscriber.onCompleted();
          return;
        }
        l3 = get();
        paramLong = l3;
      } while (l3 != l2);
      this.currentIndex = l1;
      l2 = addAndGet(-l2);
      paramLong = l2;
    } while (l2 != 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeRange.RangeProducer
 * JD-Core Version:    0.7.0.1
 */