package rx;

import rx.functions.Func2;

final class Observable$3
  implements Func2<T, T, Boolean>
{
  public final Boolean call(T paramT1, T paramT2)
  {
    if (paramT1 == null)
    {
      boolean bool;
      if (paramT2 == null) {
        bool = true;
      } else {
        bool = false;
      }
      return Boolean.valueOf(bool);
    }
    return Boolean.valueOf(paramT1.equals(paramT2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.Observable.3
 * JD-Core Version:    0.7.0.1
 */