package rx.internal.operators;

import rx.Subscriber;

class OperatorDebounceWithSelector$1$1
  extends Subscriber<U>
{
  OperatorDebounceWithSelector$1$1(OperatorDebounceWithSelector.1 param1, int paramInt) {}
  
  public void onCompleted()
  {
    this.this$1.state.emit(this.val$index, this.this$1.val$s, this.this$1.self);
    unsubscribe();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.this$1.self.onError(paramThrowable);
  }
  
  public void onNext(U paramU)
  {
    onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorDebounceWithSelector.1.1
 * JD-Core Version:    0.7.0.1
 */