package rx.schedulers;

import rx.functions.Action0;

final class TrampolineScheduler$TimedAction
  implements Comparable<TimedAction>
{
  final Action0 action;
  final int count;
  final Long execTime;
  
  TrampolineScheduler$TimedAction(Action0 paramAction0, Long paramLong, int paramInt)
  {
    this.action = paramAction0;
    this.execTime = paramLong;
    this.count = paramInt;
  }
  
  public int compareTo(TimedAction paramTimedAction)
  {
    int j = this.execTime.compareTo(paramTimedAction.execTime);
    int i = j;
    if (j == 0) {
      i = TrampolineScheduler.compare(this.count, paramTimedAction.count);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.schedulers.TrampolineScheduler.TimedAction
 * JD-Core Version:    0.7.0.1
 */