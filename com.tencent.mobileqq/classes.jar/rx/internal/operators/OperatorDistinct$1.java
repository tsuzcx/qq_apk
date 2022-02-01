package rx.internal.operators;

import java.util.HashSet;
import java.util.Set;
import rx.Subscriber;
import rx.functions.Func1;

class OperatorDistinct$1
  extends Subscriber<T>
{
  Set<U> keyMemory = new HashSet();
  
  OperatorDistinct$1(OperatorDistinct paramOperatorDistinct, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    this.keyMemory = null;
    this.val$child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.keyMemory = null;
    this.val$child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    Object localObject = this.this$0.keySelector.call(paramT);
    if (this.keyMemory.add(localObject))
    {
      this.val$child.onNext(paramT);
      return;
    }
    request(1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorDistinct.1
 * JD-Core Version:    0.7.0.1
 */