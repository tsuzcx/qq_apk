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
    Object localObject = this.sources;
    int i;
    label80:
    Observable localObservable;
    if (localObject == null)
    {
      if ((this.sourcesIterable instanceof List))
      {
        localObject = (List)this.sourcesIterable;
        localObject = (Observable[])((List)localObject).toArray(new Observable[((List)localObject).size()]);
        i = localObject.length;
        if (i != 0) {
          break label151;
        }
        paramSubscriber.onCompleted();
        return;
      }
      localObject = new Observable[8];
      Iterator localIterator = this.sourcesIterable.iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        localObservable = (Observable)localIterator.next();
        if (i != localObject.length) {
          break label177;
        }
        Observable[] arrayOfObservable = new Observable[(i >> 2) + i];
        System.arraycopy(localObject, 0, arrayOfObservable, 0, i);
        localObject = arrayOfObservable;
      }
    }
    label151:
    label177:
    for (;;)
    {
      localObject[i] = localObservable;
      i += 1;
      break label80;
      break;
      i = localObject.length;
      break;
      new OnSubscribeCombineLatest.LatestCoordinator(paramSubscriber, this.combiner, i, this.bufferSize, this.delayError).subscribe((Observable[])localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeCombineLatest
 * JD-Core Version:    0.7.0.1
 */