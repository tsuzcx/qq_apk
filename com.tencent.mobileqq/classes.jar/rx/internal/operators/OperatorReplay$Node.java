package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;

final class OperatorReplay$Node
  extends AtomicReference<Node>
{
  private static final long serialVersionUID = 245354315435971818L;
  final long index;
  final Object value;
  
  public OperatorReplay$Node(Object paramObject, long paramLong)
  {
    this.value = paramObject;
    this.index = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorReplay.Node
 * JD-Core Version:    0.7.0.1
 */