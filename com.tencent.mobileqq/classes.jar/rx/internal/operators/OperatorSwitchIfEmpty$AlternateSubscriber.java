package rx.internal.operators;

import rx.Producer;
import rx.Subscriber;
import rx.internal.producers.ProducerArbiter;

final class OperatorSwitchIfEmpty$AlternateSubscriber<T>
  extends Subscriber<T>
{
  private final ProducerArbiter arbiter;
  private final Subscriber<? super T> child;
  
  OperatorSwitchIfEmpty$AlternateSubscriber(Subscriber<? super T> paramSubscriber, ProducerArbiter paramProducerArbiter)
  {
    this.child = paramSubscriber;
    this.arbiter = paramProducerArbiter;
  }
  
  public void onCompleted()
  {
    this.child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.child.onNext(paramT);
    this.arbiter.produced(1L);
  }
  
  public void setProducer(Producer paramProducer)
  {
    this.arbiter.setProducer(paramProducer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorSwitchIfEmpty.AlternateSubscriber
 * JD-Core Version:    0.7.0.1
 */