package rx.internal.operators;

import rx.Completable;
import rx.Completable.CompletableOnSubscribe;
import rx.Completable.CompletableSubscriber;
import rx.Observable;

public final class CompletableOnSubscribeConcat
  implements Completable.CompletableOnSubscribe
{
  final int prefetch;
  final Observable<? extends Completable> sources;
  
  public CompletableOnSubscribeConcat(Observable<? extends Completable> paramObservable, int paramInt)
  {
    this.sources = paramObservable;
    this.prefetch = paramInt;
  }
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    CompletableOnSubscribeConcat.CompletableConcatSubscriber localCompletableConcatSubscriber = new CompletableOnSubscribeConcat.CompletableConcatSubscriber(paramCompletableSubscriber, this.prefetch);
    paramCompletableSubscriber.onSubscribe(localCompletableConcatSubscriber);
    this.sources.subscribe(localCompletableConcatSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.CompletableOnSubscribeConcat
 * JD-Core Version:    0.7.0.1
 */