package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.Completable.CompletableSubscriber;
import rx.Subscription;
import rx.subscriptions.SerialSubscription;

final class CompletableOnSubscribeConcatIterable$ConcatInnerSubscriber
  extends AtomicInteger
  implements Completable.CompletableSubscriber
{
  private static final long serialVersionUID = -7965400327305809232L;
  final Completable.CompletableSubscriber actual;
  int index;
  final SerialSubscription sd;
  final Iterator<? extends Completable> sources;
  
  public CompletableOnSubscribeConcatIterable$ConcatInnerSubscriber(Completable.CompletableSubscriber paramCompletableSubscriber, Iterator<? extends Completable> paramIterator)
  {
    this.actual = paramCompletableSubscriber;
    this.sources = paramIterator;
    this.sd = new SerialSubscription();
  }
  
  void next()
  {
    if (this.sd.isUnsubscribed()) {}
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while (getAndIncrement() != 0) {}
        localIterator = this.sources;
      } while (this.sd.isUnsubscribed());
      try
      {
        boolean bool = localIterator.hasNext();
        if (!bool)
        {
          this.actual.onCompleted();
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        this.actual.onError(localThrowable1);
        return;
      }
      Completable localCompletable;
      try
      {
        localCompletable = (Completable)localThrowable1.next();
        if (localCompletable == null)
        {
          this.actual.onError(new NullPointerException("The completable returned is null"));
          return;
        }
      }
      catch (Throwable localThrowable2)
      {
        this.actual.onError(localThrowable2);
        return;
      }
      localCompletable.subscribe(this);
    } while (decrementAndGet() != 0);
  }
  
  public void onCompleted()
  {
    next();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.actual.onError(paramThrowable);
  }
  
  public void onSubscribe(Subscription paramSubscription)
  {
    this.sd.set(paramSubscription);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.CompletableOnSubscribeConcatIterable.ConcatInnerSubscriber
 * JD-Core Version:    0.7.0.1
 */