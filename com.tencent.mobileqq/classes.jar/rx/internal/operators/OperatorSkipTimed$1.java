package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.functions.Action0;

class OperatorSkipTimed$1
  implements Action0
{
  OperatorSkipTimed$1(OperatorSkipTimed paramOperatorSkipTimed, AtomicBoolean paramAtomicBoolean) {}
  
  public void call()
  {
    this.val$gate.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorSkipTimed.1
 * JD-Core Version:    0.7.0.1
 */