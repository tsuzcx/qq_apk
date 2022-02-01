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
    long l1 = this.currentIndex;
    if (l1 != l2 + 1L) {
      if (!localSubscriber.isUnsubscribed()) {}
    }
    while (localSubscriber.isUnsubscribed())
    {
      return;
      localSubscriber.onNext(Integer.valueOf((int)l1));
      l1 += 1L;
      break;
    }
    localSubscriber.onCompleted();
  }
  
  public void request(long paramLong)
  {
    if (get() == 9223372036854775807L) {}
    do
    {
      return;
      if ((paramLong == 9223372036854775807L) && (compareAndSet(0L, 9223372036854775807L)))
      {
        fastpath();
        return;
      }
    } while ((paramLong <= 0L) || (BackpressureUtils.getAndAddRequest(this, paramLong) != 0L));
    slowpath(paramLong);
  }
  
  void slowpath(long paramLong)
  {
    long l4 = this.endOfRange + 1L;
    long l2 = this.currentIndex;
    Subscriber localSubscriber = this.childSubscriber;
    long l1 = 0L;
    for (;;)
    {
      if ((l1 != paramLong) && (l2 != l4)) {
        if (!localSubscriber.isUnsubscribed()) {}
      }
      do
      {
        do
        {
          return;
          localSubscriber.onNext(Integer.valueOf((int)l2));
          l2 += 1L;
          l1 += 1L;
          break;
        } while (localSubscriber.isUnsubscribed());
        if (l2 == l4)
        {
          localSubscriber.onCompleted();
          return;
        }
        long l3 = get();
        paramLong = l3;
        if (l3 != l1) {
          break;
        }
        this.currentIndex = l2;
        paramLong = addAndGet(-l1);
      } while (paramLong == 0L);
      l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeRange.RangeProducer
 * JD-Core Version:    0.7.0.1
 */