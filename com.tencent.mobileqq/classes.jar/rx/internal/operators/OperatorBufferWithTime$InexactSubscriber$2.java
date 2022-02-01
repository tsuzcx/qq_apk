package rx.internal.operators;

import java.util.List;
import rx.functions.Action0;

class OperatorBufferWithTime$InexactSubscriber$2
  implements Action0
{
  OperatorBufferWithTime$InexactSubscriber$2(OperatorBufferWithTime.InexactSubscriber paramInexactSubscriber, List paramList) {}
  
  public void call()
  {
    this.this$1.emitChunk(this.val$chunk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorBufferWithTime.InexactSubscriber.2
 * JD-Core Version:    0.7.0.1
 */