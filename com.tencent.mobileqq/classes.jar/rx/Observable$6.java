package rx;

import rx.functions.Func1;

class Observable$6
  implements Func1<T, Boolean>
{
  Observable$6(Observable paramObservable, Object paramObject) {}
  
  public final Boolean call(T paramT)
  {
    Object localObject = this.val$element;
    boolean bool;
    if (localObject == null)
    {
      if (paramT == null) {
        bool = true;
      } else {
        bool = false;
      }
    }
    else {
      bool = localObject.equals(paramT);
    }
    return Boolean.valueOf(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.Observable.6
 * JD-Core Version:    0.7.0.1
 */