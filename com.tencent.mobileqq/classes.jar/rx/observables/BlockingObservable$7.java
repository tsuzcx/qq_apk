package rx.observables;

import java.util.concurrent.BlockingQueue;
import rx.functions.Action0;

class BlockingObservable$7
  implements Action0
{
  BlockingObservable$7(BlockingObservable paramBlockingObservable, BlockingQueue paramBlockingQueue) {}
  
  public void call()
  {
    this.val$queue.offer(BlockingObservable.UNSUBSCRIBE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.observables.BlockingObservable.7
 * JD-Core Version:    0.7.0.1
 */