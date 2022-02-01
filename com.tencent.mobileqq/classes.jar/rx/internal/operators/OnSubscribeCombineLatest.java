package rx.internal.operators;

import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.FuncN;
import rx.internal.util.RxRingBuffer;

public final class OnSubscribeCombineLatest<T, R>
  implements Observable.OnSubscribe<R>
{
  final int bufferSize;
  final FuncN<? extends R> combiner;
  final boolean delayError;
  final Observable<? extends T>[] sources;
  final Iterable<? extends Observable<? extends T>> sourcesIterable;
  
  public OnSubscribeCombineLatest(Iterable<? extends Observable<? extends T>> paramIterable, FuncN<? extends R> paramFuncN)
  {
    this(null, paramIterable, paramFuncN, RxRingBuffer.SIZE, false);
  }
  
  public OnSubscribeCombineLatest(Observable<? extends T>[] paramArrayOfObservable, Iterable<? extends Observable<? extends T>> paramIterable, FuncN<? extends R> paramFuncN, int paramInt, boolean paramBoolean)
  {
    this.sources = paramArrayOfObservable;
    this.sourcesIterable = paramIterable;
    this.combiner = paramFuncN;
    this.bufferSize = paramInt;
    this.delayError = paramBoolean;
  }
  
  public void call(Subscriber<? super R> paramSubscriber)
  {
    Object localObject1 = this.sources;
    int i;
    if (localObject1 == null)
    {
      Object localObject2 = this.sourcesIterable;
      if ((localObject2 instanceof List))
      {
        localObject1 = (List)localObject2;
        localObject1 = (Observable[])((List)localObject1).toArray(new Observable[((List)localObject1).size()]);
        i = localObject1.length;
      }
      else
      {
        localObject1 = new Observable[8];
        Iterator localIterator = ((Iterable)localObject2).iterator();
        i = 0;
        while (localIterator.hasNext())
        {
          Observable localObservable = (Observable)localIterator.next();
          localObject2 = localObject1;
          if (i == localObject1.length)
          {
            localObject2 = new Observable[(i >> 2) + i];
            System.arraycopy(localObject1, 0, localObject2, 0, i);
          }
          localObject2[i] = localObservable;
          i += 1;
          localObject1 = localObject2;
        }
      }
    }
    else
    {
      i = localObject1.length;
    }
    if (i == 0)
    {
      paramSubscriber.onCompleted();
      return;
    }
    new OnSubscribeCombineLatest.LatestCoordinator(paramSubscriber, this.combiner, i, this.bufferSize, this.delayError).subscribe((Observable[])localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeCombineLatest
 * JD-Core Version:    0.7.0.1
 */