package rx;

import rx.functions.Func1;

class Observable$6
  implements Func1<T, Boolean>
{
  Observable$6(Observable paramObservable, Object paramObject) {}
  
  public final Boolean call(T paramT)
  {
    boolean bool;
    if (this.val$element == null) {
      if (paramT == null) {
        bool = true;
      }
    }
    for (;;)
    {
      return Boolean.valueOf(bool);
      bool = false;
      continue;
      bool = this.val$element.equals(paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.Observable.6
 * JD-Core Version:    0.7.0.1
 */