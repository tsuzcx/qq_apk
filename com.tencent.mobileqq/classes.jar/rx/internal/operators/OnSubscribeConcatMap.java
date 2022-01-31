package rx.internal.operators;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
import rx.observers.SerializedSubscriber;

public final class OnSubscribeConcatMap<T, R>
  implements Observable.OnSubscribe<R>
{
  public static final int BOUNDARY = 1;
  public static final int END = 2;
  public static final int IMMEDIATE = 0;
  final int delayErrorMode;
  final Func1<? super T, ? extends Observable<? extends R>> mapper;
  final int prefetch;
  final Observable<? extends T> source;
  
  public OnSubscribeConcatMap(Observable<? extends T> paramObservable, Func1<? super T, ? extends Observable<? extends R>> paramFunc1, int paramInt1, int paramInt2)
  {
    this.source = paramObservable;
    this.mapper = paramFunc1;
    this.prefetch = paramInt1;
    this.delayErrorMode = paramInt2;
  }
  
  public void call(Subscriber<? super R> paramSubscriber)
  {
    if (this.delayErrorMode == 0) {}
    for (Object localObject = new SerializedSubscriber(paramSubscriber);; localObject = paramSubscriber)
    {
      localObject = new OnSubscribeConcatMap.ConcatMapSubscriber((Subscriber)localObject, this.mapper, this.prefetch, this.delayErrorMode);
      paramSubscriber.add((Subscription)localObject);
      paramSubscriber.add(((OnSubscribeConcatMap.ConcatMapSubscriber)localObject).inner);
      paramSubscriber.setProducer(new OnSubscribeConcatMap.1(this, (OnSubscribeConcatMap.ConcatMapSubscriber)localObject));
      if (!paramSubscriber.isUnsubscribed()) {
        this.source.unsafeSubscribe((Subscriber)localObject);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeConcatMap
 * JD-Core Version:    0.7.0.1
 */