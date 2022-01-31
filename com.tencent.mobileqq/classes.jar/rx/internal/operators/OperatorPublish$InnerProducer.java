package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

final class OperatorPublish$InnerProducer<T>
  extends AtomicLong
  implements Producer, Subscription
{
  static final long NOT_REQUESTED = -4611686018427387904L;
  static final long UNSUBSCRIBED = -9223372036854775808L;
  private static final long serialVersionUID = -4453897557930727610L;
  final Subscriber<? super T> child;
  final OperatorPublish.PublishSubscriber<T> parent;
  
  public OperatorPublish$InnerProducer(OperatorPublish.PublishSubscriber<T> paramPublishSubscriber, Subscriber<? super T> paramSubscriber)
  {
    this.parent = paramPublishSubscriber;
    this.child = paramSubscriber;
    lazySet(-4611686018427387904L);
  }
  
  public boolean isUnsubscribed()
  {
    return get() == -9223372036854775808L;
  }
  
  public long produced(long paramLong)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("Cant produce zero or less");
    }
    long l1;
    long l2;
    do
    {
      l1 = get();
      if (l1 == -4611686018427387904L) {
        throw new IllegalStateException("Produced without request");
      }
      if (l1 == -9223372036854775808L) {
        return -9223372036854775808L;
      }
      l2 = l1 - paramLong;
      if (l2 < 0L) {
        throw new IllegalStateException("More produced (" + paramLong + ") than requested (" + l1 + ")");
      }
    } while (!compareAndSet(l1, l2));
    return l2;
  }
  
  public void request(long paramLong)
  {
    if (paramLong < 0L) {
      return;
    }
    for (;;)
    {
      long l3 = get();
      if ((l3 == -9223372036854775808L) || ((l3 >= 0L) && (paramLong == 0L))) {
        break;
      }
      long l1;
      if (l3 == -4611686018427387904L) {
        l1 = paramLong;
      }
      while (compareAndSet(l3, l1))
      {
        this.parent.dispatch();
        return;
        long l2 = l3 + paramLong;
        l1 = l2;
        if (l2 < 0L) {
          l1 = 9223372036854775807L;
        }
      }
    }
  }
  
  public void unsubscribe()
  {
    if ((get() != -9223372036854775808L) && (getAndSet(-9223372036854775808L) != -9223372036854775808L))
    {
      this.parent.remove(this);
      this.parent.dispatch();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorPublish.InnerProducer
 * JD-Core Version:    0.7.0.1
 */