package rx;

import rx.internal.util.SubscriptionList;

public abstract class Subscriber<T>
  implements Observer<T>, Subscription
{
  private static final Long NOT_SET = Long.valueOf(-9223372036854775808L);
  private Producer producer;
  private long requested = NOT_SET.longValue();
  private final Subscriber<?> subscriber;
  private final SubscriptionList subscriptions;
  
  protected Subscriber()
  {
    this(null, false);
  }
  
  protected Subscriber(Subscriber<?> paramSubscriber)
  {
    this(paramSubscriber, true);
  }
  
  protected Subscriber(Subscriber<?> paramSubscriber, boolean paramBoolean)
  {
    this.subscriber = paramSubscriber;
    if ((paramBoolean) && (paramSubscriber != null)) {
      paramSubscriber = paramSubscriber.subscriptions;
    } else {
      paramSubscriber = new SubscriptionList();
    }
    this.subscriptions = paramSubscriber;
  }
  
  private void addToRequested(long paramLong)
  {
    if (this.requested == NOT_SET.longValue())
    {
      this.requested = paramLong;
      return;
    }
    paramLong = this.requested + paramLong;
    if (paramLong < 0L)
    {
      this.requested = 9223372036854775807L;
      return;
    }
    this.requested = paramLong;
  }
  
  public final void add(Subscription paramSubscription)
  {
    this.subscriptions.add(paramSubscription);
  }
  
  public final boolean isUnsubscribed()
  {
    return this.subscriptions.isUnsubscribed();
  }
  
  public void onStart() {}
  
  protected final void request(long paramLong)
  {
    if (paramLong >= 0L) {
      try
      {
        if (this.producer != null)
        {
          Producer localProducer = this.producer;
          localProducer.request(paramLong);
          return;
        }
        addToRequested(paramLong);
        return;
      }
      finally {}
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("number requested cannot be negative: ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setProducer(Producer paramProducer)
  {
    for (;;)
    {
      try
      {
        long l = this.requested;
        this.producer = paramProducer;
        if ((this.subscriber != null) && (l == NOT_SET.longValue()))
        {
          i = 1;
          if (i != 0)
          {
            this.subscriber.setProducer(this.producer);
            return;
          }
          if (l == NOT_SET.longValue())
          {
            this.producer.request(9223372036854775807L);
            return;
          }
          this.producer.request(l);
          return;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public final void unsubscribe()
  {
    this.subscriptions.unsubscribe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.Subscriber
 * JD-Core Version:    0.7.0.1
 */