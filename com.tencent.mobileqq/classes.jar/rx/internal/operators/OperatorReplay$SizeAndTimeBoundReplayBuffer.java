package rx.internal.operators;

import rx.Scheduler;
import rx.schedulers.Timestamped;

final class OperatorReplay$SizeAndTimeBoundReplayBuffer<T>
  extends OperatorReplay.BoundedReplayBuffer<T>
{
  private static final long serialVersionUID = 3457957419649567404L;
  final int limit;
  final long maxAgeInMillis;
  final Scheduler scheduler;
  
  public OperatorReplay$SizeAndTimeBoundReplayBuffer(int paramInt, long paramLong, Scheduler paramScheduler)
  {
    this.scheduler = paramScheduler;
    this.limit = paramInt;
    this.maxAgeInMillis = paramLong;
  }
  
  Object enterTransform(Object paramObject)
  {
    return new Timestamped(this.scheduler.now(), paramObject);
  }
  
  Object leaveTransform(Object paramObject)
  {
    return ((Timestamped)paramObject).getValue();
  }
  
  void truncate()
  {
    long l1 = this.scheduler.now();
    long l2 = this.maxAgeInMillis;
    Object localObject2 = (OperatorReplay.Node)get();
    Object localObject1 = (OperatorReplay.Node)((OperatorReplay.Node)localObject2).get();
    int i = 0;
    while (localObject1 != null)
    {
      OperatorReplay.Node localNode;
      if (this.size > this.limit)
      {
        i += 1;
        this.size -= 1;
        localNode = (OperatorReplay.Node)((OperatorReplay.Node)localObject1).get();
        localObject2 = localObject1;
        localObject1 = localNode;
      }
      else
      {
        if (((Timestamped)((OperatorReplay.Node)localObject1).value).getTimestampMillis() > l1 - l2) {
          break;
        }
        i += 1;
        this.size -= 1;
        localNode = (OperatorReplay.Node)((OperatorReplay.Node)localObject1).get();
        localObject2 = localObject1;
        localObject1 = localNode;
      }
    }
    if (i != 0) {
      setFirst((OperatorReplay.Node)localObject2);
    }
  }
  
  void truncateFinal()
  {
    long l1 = this.scheduler.now();
    long l2 = this.maxAgeInMillis;
    Object localObject2 = (OperatorReplay.Node)get();
    Object localObject1 = (OperatorReplay.Node)((OperatorReplay.Node)localObject2).get();
    int i = 0;
    while ((localObject1 != null) && (this.size > 1) && (((Timestamped)((OperatorReplay.Node)localObject1).value).getTimestampMillis() <= l1 - l2))
    {
      i += 1;
      this.size -= 1;
      OperatorReplay.Node localNode = (OperatorReplay.Node)((OperatorReplay.Node)localObject1).get();
      localObject2 = localObject1;
      localObject1 = localNode;
    }
    if (i != 0) {
      setFirst((OperatorReplay.Node)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorReplay.SizeAndTimeBoundReplayBuffer
 * JD-Core Version:    0.7.0.1
 */