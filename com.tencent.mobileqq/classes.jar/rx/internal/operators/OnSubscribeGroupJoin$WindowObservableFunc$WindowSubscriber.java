package rx.internal.operators;

import rx.Subscriber;
import rx.Subscription;

final class OnSubscribeGroupJoin$WindowObservableFunc$WindowSubscriber
  extends Subscriber<T>
{
  private final Subscription ref;
  final Subscriber<? super T> subscriber;
  
  public OnSubscribeGroupJoin$WindowObservableFunc$WindowSubscriber(Subscriber<? super T> paramSubscriber, Subscription paramSubscription)
  {
    super(paramSubscription);
    this.subscriber = paramSubscription;
    Object localObject;
    this.ref = localObject;
  }
  
  public void onCompleted()
  {
    this.subscriber.onCompleted();
    this.ref.unsubscribe();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.subscriber.onError(paramThrowable);
    this.ref.unsubscribe();
  }
  
  public void onNext(T paramT)
  {
    this.subscriber.onNext(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeGroupJoin.WindowObservableFunc.WindowSubscriber
 * JD-Core Version:    0.7.0.1
 */