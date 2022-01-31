package rx.internal.operators;

import java.util.Iterator;
import rx.Observable;

public final class BlockingOperatorToIterator
{
  private BlockingOperatorToIterator()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> Iterator<T> toIterator(Observable<? extends T> paramObservable)
  {
    BlockingOperatorToIterator.SubscriberIterator localSubscriberIterator = new BlockingOperatorToIterator.SubscriberIterator();
    paramObservable.materialize().subscribe(localSubscriberIterator);
    return localSubscriberIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.BlockingOperatorToIterator
 * JD-Core Version:    0.7.0.1
 */