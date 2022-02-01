package rx.internal.operators;

import java.util.Iterator;
import rx.Observable;

final class BlockingOperatorMostRecent$1
  implements Iterable<T>
{
  BlockingOperatorMostRecent$1(Object paramObject, Observable paramObservable) {}
  
  public Iterator<T> iterator()
  {
    BlockingOperatorMostRecent.MostRecentObserver localMostRecentObserver = new BlockingOperatorMostRecent.MostRecentObserver(this.val$initialValue);
    this.val$source.subscribe(localMostRecentObserver);
    return localMostRecentObserver.getIterable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.BlockingOperatorMostRecent.1
 * JD-Core Version:    0.7.0.1
 */