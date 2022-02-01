package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

final class OperatorReplay$InnerProducer<T>
  extends AtomicLong
  implements Producer, Subscription
{
  static final long UNSUBSCRIBED = -9223372036854775808L;
  private static final long serialVersionUID = -4453897557930727610L;
  final Subscriber<? super T> child;
  boolean emitting;
  Object index;
  boolean missed;
  final OperatorReplay.ReplaySubscriber<T> parent;
  final AtomicLong totalRequested;
  
  public OperatorReplay$InnerProducer(OperatorReplay.ReplaySubscriber<T> paramReplaySubscriber, Subscriber<? super T> paramSubscriber)
  {
    this.parent = paramReplaySubscriber;
    this.child = paramSubscriber;
    this.totalRequested = new AtomicLong();
  }
  
  void addTotalRequested(long paramLong)
  {
    long l3;
    long l1;
    do
    {
      l3 = this.totalRequested.get();
      long l2 = l3 + paramLong;
      l1 = l2;
      if (l2 < 0L) {
        l1 = 9223372036854775807L;
      }
    } while (!this.totalRequested.compareAndSet(l3, l1));
  }
  
  <U> U index()
  {
    return this.index;
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
    long l3;
    long l1;
    do
    {
      l3 = get();
      if ((l3 == -9223372036854775808L) || ((l3 >= 0L) && (paramLong == 0L))) {
        break;
      }
      long l2 = l3 + paramLong;
      l1 = l2;
      if (l2 < 0L) {
        l1 = 9223372036854775807L;
      }
    } while (!compareAndSet(l3, l1));
    addTotalRequested(paramLong);
    this.parent.manageRequests();
    this.parent.buffer.replay(this);
  }
  
  public void unsubscribe()
  {
    if ((get() != -9223372036854775808L) && (getAndSet(-9223372036854775808L) != -9223372036854775808L))
    {
      this.parent.remove(this);
      this.parent.manageRequests();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorReplay.InnerProducer
 * JD-Core Version:    0.7.0.1
 */