package rx;

import rx.functions.Func1;

class Observable$13
  implements Func1<T, Boolean>
{
  Observable$13(Observable paramObservable, Class paramClass) {}
  
  public final Boolean call(T paramT)
  {
    return Boolean.valueOf(this.val$klass.isInstance(paramT));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.Observable.13
 * JD-Core Version:    0.7.0.1
 */