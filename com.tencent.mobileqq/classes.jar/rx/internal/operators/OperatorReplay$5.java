package rx.internal.operators;

import rx.functions.Func0;

final class OperatorReplay$5
  implements Func0<OperatorReplay.ReplayBuffer<T>>
{
  OperatorReplay$5(int paramInt) {}
  
  public OperatorReplay.ReplayBuffer<T> call()
  {
    return new OperatorReplay.SizeBoundReplayBuffer(this.val$bufferSize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorReplay.5
 * JD-Core Version:    0.7.0.1
 */