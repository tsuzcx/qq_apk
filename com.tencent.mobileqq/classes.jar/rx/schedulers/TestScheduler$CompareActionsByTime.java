package rx.schedulers;

import java.util.Comparator;

class TestScheduler$CompareActionsByTime
  implements Comparator<TestScheduler.TimedAction>
{
  public int compare(TestScheduler.TimedAction paramTimedAction1, TestScheduler.TimedAction paramTimedAction2)
  {
    if (paramTimedAction1.time == paramTimedAction2.time) {
      if (TestScheduler.TimedAction.access$000(paramTimedAction1) >= TestScheduler.TimedAction.access$000(paramTimedAction2)) {}
    }
    while (paramTimedAction1.time < paramTimedAction2.time)
    {
      return -1;
      if (TestScheduler.TimedAction.access$000(paramTimedAction1) > TestScheduler.TimedAction.access$000(paramTimedAction2)) {
        return 1;
      }
      return 0;
    }
    if (paramTimedAction1.time > paramTimedAction2.time) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.schedulers.TestScheduler.CompareActionsByTime
 * JD-Core Version:    0.7.0.1
 */