package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

class OperatorDebounceWithSelector$1
  extends Subscriber<T>
{
  final Subscriber<?> self = this;
  final OperatorDebounceWithTime.DebounceState<T> state = new OperatorDebounceWithTime.DebounceState();
  
  OperatorDebounceWithSelector$1(OperatorDebounceWithSelector paramOperatorDebounceWithSelector, Subscriber paramSubscriber, SerializedSubscriber paramSerializedSubscriber, SerialSubscription paramSerialSubscription)
  {
    super(paramSubscriber);
  }
  
  public void onCompleted()
  {
    this.state.emitAndComplete(this.val$s, this);
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$s.onError(paramThrowable);
    unsubscribe();
    this.state.clear();
  }
  
  public void onNext(T paramT)
  {
    try
    {
      Observable localObservable = (Observable)this.this$0.selector.call(paramT);
      paramT = new OperatorDebounceWithSelector.1.1(this, this.state.next(paramT));
      this.val$ssub.set(paramT);
      localObservable.unsafeSubscribe(paramT);
      return;
    }
    catch (Throwable paramT)
    {
      Exceptions.throwOrReport(paramT, this);
    }
  }
  
  public void onStart()
  {
    request(9223372036854775807L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorDebounceWithSelector.1
 * JD-Core Version:    0.7.0.1
 */