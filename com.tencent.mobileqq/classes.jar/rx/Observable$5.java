package rx;

import rx.functions.Action2;
import rx.functions.Func2;

class Observable$5
  implements Func2<R, T, R>
{
  Observable$5(Observable paramObservable, Action2 paramAction2) {}
  
  public final R call(R paramR, T paramT)
  {
    this.val$collector.call(paramR, paramT);
    return paramR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.Observable.5
 * JD-Core Version:    0.7.0.1
 */