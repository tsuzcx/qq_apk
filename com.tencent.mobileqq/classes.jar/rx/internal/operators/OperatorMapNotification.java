package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func0;
import rx.functions.Func1;

public final class OperatorMapNotification<T, R>
  implements Observable.Operator<R, T>
{
  final Func0<? extends R> onCompleted;
  final Func1<? super Throwable, ? extends R> onError;
  final Func1<? super T, ? extends R> onNext;
  
  public OperatorMapNotification(Func1<? super T, ? extends R> paramFunc1, Func1<? super Throwable, ? extends R> paramFunc11, Func0<? extends R> paramFunc0)
  {
    this.onNext = paramFunc1;
    this.onError = paramFunc11;
    this.onCompleted = paramFunc0;
  }
  
  public Subscriber<? super T> call(Subscriber<? super R> paramSubscriber)
  {
    OperatorMapNotification.MapNotificationSubscriber localMapNotificationSubscriber = new OperatorMapNotification.MapNotificationSubscriber(paramSubscriber, this.onNext, this.onError, this.onCompleted);
    paramSubscriber.add(localMapNotificationSubscriber);
    paramSubscriber.setProducer(new OperatorMapNotification.1(this, localMapNotificationSubscriber));
    return localMapNotificationSubscriber;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorMapNotification
 * JD-Core Version:    0.7.0.1
 */