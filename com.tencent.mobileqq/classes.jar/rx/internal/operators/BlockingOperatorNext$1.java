package rx.internal.operators;

import java.util.Iterator;
import rx.Observable;

final class BlockingOperatorNext$1
  implements Iterable<T>
{
  BlockingOperatorNext$1(Observable paramObservable) {}
  
  public Iterator<T> iterator()
  {
    BlockingOperatorNext.NextObserver localNextObserver = new BlockingOperatorNext.NextObserver();
    return new BlockingOperatorNext.NextIterator(this.val$items, localNextObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.BlockingOperatorNext.1
 * JD-Core Version:    0.7.0.1
 */