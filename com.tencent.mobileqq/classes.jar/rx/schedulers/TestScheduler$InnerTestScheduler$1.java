package rx.schedulers;

import java.util.Queue;
import rx.functions.Action0;

class TestScheduler$InnerTestScheduler$1
  implements Action0
{
  TestScheduler$InnerTestScheduler$1(TestScheduler.InnerTestScheduler paramInnerTestScheduler, TestScheduler.TimedAction paramTimedAction) {}
  
  public void call()
  {
    this.this$1.this$0.queue.remove(this.val$timedAction);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.schedulers.TestScheduler.InnerTestScheduler.1
 * JD-Core Version:    0.7.0.1
 */