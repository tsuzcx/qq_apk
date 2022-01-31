package rx.internal.operators;

import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

class OperatorDebounceWithTime$1
  extends Subscriber<T>
{
  final Subscriber<?> self = this;
  final OperatorDebounceWithTime.DebounceState<T> state = new OperatorDebounceWithTime.DebounceState();
  
  OperatorDebounceWithTime$1(OperatorDebounceWithTime paramOperatorDebounceWithTime, Subscriber paramSubscriber, SerialSubscription paramSerialSubscription, Scheduler.Worker paramWorker, SerializedSubscriber paramSerializedSubscriber)
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
    int i = this.state.next(paramT);
    this.val$ssub.set(this.val$worker.schedule(new OperatorDebounceWithTime.1.1(this, i), this.this$0.timeout, this.this$0.unit));
  }
  
  public void onStart()
  {
    request(9223372036854775807L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorDebounceWithTime.1
 * JD-Core Version:    0.7.0.1
 */