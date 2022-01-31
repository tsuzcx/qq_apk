package rx.internal.operators;

import rx.Notification;
import rx.Observable;
import rx.functions.Func1;

public final class OnSubscribeRedo$RedoFinite
  implements Func1<Observable<? extends Notification<?>>, Observable<?>>
{
  final long count;
  
  public OnSubscribeRedo$RedoFinite(long paramLong)
  {
    this.count = paramLong;
  }
  
  public Observable<?> call(Observable<? extends Notification<?>> paramObservable)
  {
    return paramObservable.map(new OnSubscribeRedo.RedoFinite.1(this)).dematerialize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeRedo.RedoFinite
 * JD-Core Version:    0.7.0.1
 */