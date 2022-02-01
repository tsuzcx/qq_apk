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
      Object localObject = this.sources.iterator();
      if (localObject == null)
      {
        paramCompletableSubscriber.onSubscribe(Subscriptions.unsubscribed());
        paramCompletableSubscriber.onError(new NullPointerException("The iterator returned is null"));
        return;
      }
      localObject = new CompletableOnSubscribeConcatIterable.ConcatInnerSubscriber(paramCompletableSubscriber, (Iterator)localObject);
      paramCompletableSubscriber.onSubscribe(((CompletableOnSubscribeConcatIterable.ConcatInnerSubscriber)localObject).sd);
      ((CompletableOnSubscribeConcatIterable.ConcatInnerSubscriber)localObject).next();
      return;
    }
    catch (Throwable localThrowable)
    {
      paramCompletableSubscriber.onSubscribe(Subscriptions.unsubscribed());
      paramCompletableSubscriber.onError(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.CompletableOnSubscribeConcatIterable
 * JD-Core Version:    0.7.0.1
 */