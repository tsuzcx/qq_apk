package rx.internal.operators;

import java.util.Iterator;
import rx.Completable;
import rx.Completable.CompletableOnSubscribe;
import rx.Completable.CompletableSubscriber;
import rx.subscriptions.Subscriptions;

public final class CompletableOnSubscribeConcatIterable
  implements Completable.CompletableOnSubscribe
{
  final Iterable<? extends Completable> sources;
  
  public CompletableOnSubscribeConcatIterable(Iterable<? extends Completable> paramIterable)
  {
    this.sources = paramIterable;
  }
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    try
    {
      Iterator localIterator = this.sources.iterator();
      if (localIterator == null)
      {
        paramCompletableSubscriber.onSubscribe(Subscriptions.unsubscribed());
        paramCompletableSubscriber.onError(new NullPointerException("The iterator returned is null"));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      paramCompletableSubscriber.onSubscribe(Subscriptions.unsubscribed());
      paramCompletableSubscriber.onError(localThrowable);
      return;
    }
    CompletableOnSubscribeConcatIterable.ConcatInnerSubscriber localConcatInnerSubscriber = new CompletableOnSubscribeConcatIterable.ConcatInnerSubscriber(paramCompletableSubscriber, localThrowable);
    paramCompletableSubscriber.onSubscribe(localConcatInnerSubscriber.sd);
    localConcatInnerSubscriber.next();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.CompletableOnSubscribeConcatIterable
 * JD-Core Version:    0.7.0.1
 */