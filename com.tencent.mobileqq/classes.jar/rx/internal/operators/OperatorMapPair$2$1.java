package rx.internal.operators;

import rx.functions.Func1;
import rx.functions.Func2;

class OperatorMapPair$2$1
  implements Func1<U, R>
{
  OperatorMapPair$2$1(OperatorMapPair.2 param2, Object paramObject) {}
  
  public R call(U paramU)
  {
    return this.this$1.this$0.resultSelector.call(this.val$outer, paramU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorMapPair.2.1
 * JD-Core Version:    0.7.0.1
 */