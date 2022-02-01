package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import rx.Completable;
import rx.Completable.CompletableOnSubscribe;
import rx.Completable.CompletableSubscriber;
import rx.Observable;
import rx.exceptions.CompositeException;

public final class CompletableOnSubscribeMerge
  implements Completable.CompletableOnSubscribe
{
  final boolean delayErrors;
  final int maxConcurrency;
  final Observable<? extends Completable> source;
  
  public CompletableOnSubscribeMerge(Observable<? extends Completable> paramObservable, int paramInt, boolean paramBoolean)
  {
    this.source = paramObservable;
    this.maxConcurrency = paramInt;
    this.delayErrors = paramBoolean;
  }
  
  public static Throwable collectErrors(Queue<Throwable> paramQueue)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      Throwable localThrowable = (Throwable)paramQueue.poll();
      if (localThrowable == null) {
        break;
      }
      localArrayList.add(localThrowable);
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    if (localArrayList.size() == 1) {
      return (Throwable)localArrayList.get(0);
    }
    return new CompositeException(localArrayList);
  }
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    CompletableOnSubscribeMerge.CompletableMergeSubscriber localCompletableMergeSubscriber = new CompletableOnSubscribeMerge.CompletableMergeSubscriber(paramCompletableSubscriber, this.maxConcurrency, this.delayErrors);
    paramCompletableSubscriber.onSubscribe(localCompletableMergeSubscriber);
    this.source.subscribe(localCompletableMergeSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.CompletableOnSubscribeMerge
 * JD-Core Version:    0.7.0.1
 */