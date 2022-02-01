package rx.internal.operators;

final class OperatorReplay$SizeBoundReplayBuffer<T>
  extends OperatorReplay.BoundedReplayBuffer<T>
{
  private static final long serialVersionUID = -5898283885385201806L;
  final int limit;
  
  public OperatorReplay$SizeBoundReplayBuffer(int paramInt)
  {
    this.limit = paramInt;
  }
  
  void truncate()
  {
    if (this.size > this.limit) {
      removeFirst();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorReplay.SizeBoundReplayBuffer
 * JD-Core Version:    0.7.0.1
 */