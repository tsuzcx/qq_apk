package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

final class OnSubscribePublishMulticast$PublishProducer<T>
  extends AtomicLong
  implements Producer, Subscription
{
  private static final long serialVersionUID = 960704844171597367L;
  final Subscriber<? super T> actual;
  final AtomicBoolean once;
  final OnSubscribePublishMulticast<T> parent;
  
  public OnSubscribePublishMulticast$PublishProducer(Subscriber<? super T> paramSubscriber, OnSubscribePublishMulticast<T> paramOnSubscribePublishMulticast)
  {
    this.actual = paramSubscriber;
    this.parent = paramOnSubscribePublishMulticast;
    this.once = new AtomicBoolean();
  }
  
  public boolean isUnsubscribed()
  {
    return this.once.get();
  }
  
  public void request(long paramLong)
  {
    if (paramLong >= 0L)
    {
      if (paramLong != 0L)
      {
        BackpressureUtils.getAndAddRequest(this, paramLong);
        this.parent.drain();
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("n >= 0 required but it was ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void unsubscribe()
  {
    if (this.once.compareAndSet(false, true)) {
      this.parent.remove(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OnSubscribePublishMulticast.PublishProducer
 * JD-Core Version:    0.7.0.1
 */