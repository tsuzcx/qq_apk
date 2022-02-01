package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.producers.SingleDelayedProducer;

class OperatorToObservableSortedList$2
  extends Subscriber<T>
{
  boolean completed;
  List<T> list = new ArrayList(this.this$0.initialCapacity);
  
  OperatorToObservableSortedList$2(OperatorToObservableSortedList paramOperatorToObservableSortedList, SingleDelayedProducer paramSingleDelayedProducer, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    if (!this.completed)
    {
      this.completed = true;
      List localList = this.list;
      this.list = null;
      try
      {
        Collections.sort(localList, this.this$0.sortFunction);
        this.val$producer.setValue(localList);
        return;
      }
      catch (Throwable localThrowable)
      {
        Exceptions.throwOrReport(localThrowable, this);
      }
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    if (!this.completed) {
      this.list.add(paramT);
    }
  }
  
  public void onStart()
  {
    request(9223372036854775807L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorToObservableSortedList.2
 * JD-Core Version:    0.7.0.1
 */