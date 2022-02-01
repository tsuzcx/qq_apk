package rx.internal.operators;

import rx.Observable;
import rx.functions.Func0;

class OperatorBufferWithSingleObservable$1
  implements Func0<Observable<? extends TClosing>>
{
  OperatorBufferWithSingleObservable$1(OperatorBufferWithSingleObservable paramOperatorBufferWithSingleObservable, Observable paramObservable) {}
  
  public Observable<? extends TClosing> call()
  {
    return this.val$bufferClosing;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorBufferWithSingleObservable.1
 * JD-Core Version:    0.7.0.1
 */