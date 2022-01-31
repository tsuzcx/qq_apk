package rx.internal.operators;

import rx.Subscriber;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;

final class OnSubscribeCombineLatest$CombinerSubscriber<T, R>
  extends Subscriber<T>
{
  boolean done;
  final int index;
  final NotificationLite<T> nl;
  final OnSubscribeCombineLatest.LatestCoordinator<T, R> parent;
  
  public OnSubscribeCombineLatest$CombinerSubscriber(OnSubscribeCombineLatest.LatestCoordinator<T, R> paramLatestCoordinator, int paramInt)
  {
    this.parent = paramLatestCoordinator;
    this.index = paramInt;
    this.nl = NotificationLite.instance();
    request(paramLatestCoordinator.bufferSize);
  }
  
  public void onCompleted()
  {
    if (this.done) {
      return;
    }
    this.done = true;
    this.parent.combine(null, this.index);
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.done)
    {
      RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
      return;
    }
    this.parent.onError(paramThrowable);
    this.done = true;
    this.parent.combine(null, this.index);
  }
  
  public void onNext(T paramT)
  {
    if (this.done) {
      return;
    }
    this.parent.combine(this.nl.next(paramT), this.index);
  }
  
  public void requestMore(long paramLong)
  {
    request(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeCombineLatest.CombinerSubscriber
 * JD-Core Version:    0.7.0.1
 */