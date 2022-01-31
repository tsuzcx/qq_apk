package rx.internal.operators;

import java.util.Map;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

class OperatorToMap$1
  extends Subscriber<T>
{
  private Map<K, V> map = this.val$fLocalMap;
  
  OperatorToMap$1(OperatorToMap paramOperatorToMap, Subscriber paramSubscriber1, Map paramMap, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    Map localMap = this.map;
    this.map = null;
    this.val$subscriber.onNext(localMap);
    this.val$subscriber.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.map = null;
    this.val$subscriber.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    try
    {
      Object localObject = this.this$0.keySelector.call(paramT);
      paramT = this.this$0.valueSelector.call(paramT);
      this.map.put(localObject, paramT);
      return;
    }
    catch (Throwable paramT)
    {
      Exceptions.throwOrReport(paramT, this.val$subscriber);
    }
  }
  
  public void onStart()
  {
    request(9223372036854775807L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorToMap.1
 * JD-Core Version:    0.7.0.1
 */