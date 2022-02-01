package rx.internal.operators;

import rx.functions.Action0;

class OperatorWindowWithTime$InexactSubscriber$2
  implements Action0
{
  OperatorWindowWithTime$InexactSubscriber$2(OperatorWindowWithTime.InexactSubscriber paramInexactSubscriber, OperatorWindowWithTime.CountedSerializedSubject paramCountedSerializedSubject) {}
  
  public void call()
  {
    this.this$1.terminateChunk(this.val$chunk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithTime.InexactSubscriber.2
 * JD-Core Version:    0.7.0.1
 */