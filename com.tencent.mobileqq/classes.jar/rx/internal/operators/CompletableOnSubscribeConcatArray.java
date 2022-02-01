package rx.internal.operators;

import rx.Completable;
import rx.Completable.CompletableOnSubscribe;
import rx.Completable.CompletableSubscriber;

public final class CompletableOnSubscribeConcatArray
  implements Completable.CompletableOnSubscribe
{
  final Completable[] sources;
  
  public CompletableOnSubscribeConcatArray(Completable[] paramArrayOfCompletable)
  {
    this.sources = paramArrayOfCompletable;
  }
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    CompletableOnSubscribeConcatArray.ConcatInnerSubscriber localConcatInnerSubscriber = new CompletableOnSubscribeConcatArray.ConcatInnerSubscriber(paramCompletableSubscriber, this.sources);
    paramCompletableSubscriber.onSubscribe(localConcatInnerSubscriber.sd);
    localConcatInnerSubscriber.next();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.CompletableOnSubscribeConcatArray
 * JD-Core Version:    0.7.0.1
 */