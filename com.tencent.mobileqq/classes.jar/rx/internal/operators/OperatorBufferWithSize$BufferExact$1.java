package rx.internal.operators;

import rx.Producer;

class OperatorBufferWithSize$BufferExact$1
  implements Producer
{
  OperatorBufferWithSize$BufferExact$1(OperatorBufferWithSize.BufferExact paramBufferExact) {}
  
  public void request(long paramLong)
  {
    if (paramLong >= 0L)
    {
      if (paramLong != 0L)
      {
        paramLong = BackpressureUtils.multiplyCap(paramLong, this.this$0.count);
        OperatorBufferWithSize.BufferExact.access$000(this.this$0, paramLong);
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("n >= required but it was ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorBufferWithSize.BufferExact.1
 * JD-Core Version:    0.7.0.1
 */