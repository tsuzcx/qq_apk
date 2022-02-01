package rx.internal.operators;

import java.util.Iterator;
import rx.Subscriber;

final class BlockingOperatorMostRecent$MostRecentObserver<T>
  extends Subscriber<T>
{
  final NotificationLite<T> nl = NotificationLite.instance();
  volatile Object value = this.nl.next(paramT);
  
  BlockingOperatorMostRecent$MostRecentObserver(T paramT) {}
  
  public Iterator<T> getIterable()
  {
    return new BlockingOperatorMostRecent.MostRecentObserver.1(this);
  }
  
  public void onCompleted()
  {
    this.value = this.nl.completed();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.value = this.nl.error(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.value = this.nl.next(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.BlockingOperatorMostRecent.MostRecentObserver
 * JD-Core Version:    0.7.0.1
 */