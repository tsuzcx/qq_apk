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
    if (paramLong > 0L)
    {
      long l1;
      long l2;
      do
      {
        l1 = get();
        if (l1 == -4611686018427387904L) {
          break label116;
        }
        if (l1 == -9223372036854775808L) {
          return -9223372036854775808L;
        }
        l2 = l1 - paramLong;
        if (l2 < 0L) {
          break;
        }
      } while (!compareAndSet(l1, l2));
      return l2;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("More produced (");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(") than requested (");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(")");
      throw new IllegalStateException(((StringBuilder)localObject).toString());
      label116:
      throw new IllegalStateException("Produced without request");
    }
    Object localObject = new IllegalArgumentException("Cant produce zero or less");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public void request(long paramLong)
  {
    if (paramLong < 0L) {
      return;
    }
    long l3;
    long l1;
    do
    {
      l3 = get();
      if (l3 == -9223372036854775808L) {
        return;
      }
      if ((l3 >= 0L) && (paramLong == 0L)) {
        return;
      }
      if (l3 == -4611686018427387904L)
      {
        l1 = paramLong;
      }
      else
      {
        long l2 = l3 + paramLong;
        l1 = l2;
        if (l2 < 0L) {
          l1 = 9223372036854775807L;
        }
      }
    } while (!compareAndSet(l3, l1));
    this.parent.dispatch();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorPublish.InnerProducer
 * JD-Core Version:    0.7.0.1
 */