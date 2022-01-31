package rx.internal.operators;

import rx.Scheduler;
import rx.functions.Func0;

final class OperatorReplay$6
  implements Func0<OperatorReplay.ReplayBuffer<T>>
{
  OperatorReplay$6(int paramInt, long paramLong, Scheduler paramScheduler) {}
  
  public OperatorReplay.ReplayBuffer<T> call()
  {
    return new OperatorReplay.SizeAndTimeBoundReplayBuffer(this.val$bufferSize, this.val$maxAgeInMillis, this.val$scheduler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorReplay.6
 * JD-Core Version:    0.7.0.1
 */