package rx.internal.util;

import rx.Single;
import rx.Single.OnSubscribe;
import rx.SingleSubscriber;
import rx.functions.Func1;

class ScalarSynchronousSingle$2
  implements Single.OnSubscribe<R>
{
  ScalarSynchronousSingle$2(ScalarSynchronousSingle paramScalarSynchronousSingle, Func1 paramFunc1) {}
  
  public void call(SingleSubscriber<? super R> paramSingleSubscriber)
  {
    Single localSingle = (Single)this.val$func.call(this.this$0.value);
    if ((localSingle instanceof ScalarSynchronousSingle))
    {
      paramSingleSubscriber.onSuccess(((ScalarSynchronousSingle)localSingle).value);
      return;
    }
    ScalarSynchronousSingle.2.1 local1 = new ScalarSynchronousSingle.2.1(this, paramSingleSubscriber);
    paramSingleSubscriber.add(local1);
    localSingle.unsafeSubscribe(local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.util.ScalarSynchronousSingle.2
 * JD-Core Version:    0.7.0.1
 */