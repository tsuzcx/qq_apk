package rx.internal.operators;

import rx.Producer;
import rx.Subscriber;
import rx.internal.producers.ProducerArbiter;

final class OperatorSwitch$InnerSubscriber<T>
  extends Subscriber<T>
{
  private final long id;
  private final OperatorSwitch.SwitchSubscriber<T> parent;
  
  OperatorSwitch$InnerSubscriber(long paramLong, OperatorSwitch.SwitchSubscriber<T> paramSwitchSubscriber)
  {
    this.id = paramLong;
    this.parent = paramSwitchSubscriber;
  }
  
  public void onCompleted()
  {
    this.parent.complete(this.id);
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.parent.error(paramThrowable, this.id);
  }
  
  public void onNext(T paramT)
  {
    this.parent.emit(paramT, this.id);
  }
  
  public void setProducer(Producer paramProducer)
  {
    this.parent.arbiter.setProducer(paramProducer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorSwitch.InnerSubscriber
 * JD-Core Version:    0.7.0.1
 */