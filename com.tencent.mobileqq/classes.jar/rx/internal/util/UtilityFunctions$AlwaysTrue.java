package rx.internal.util;

import rx.functions.Func1;

 enum UtilityFunctions$AlwaysTrue
  implements Func1<Object, Boolean>
{
  INSTANCE;
  
  private UtilityFunctions$AlwaysTrue() {}
  
  public Boolean call(Object paramObject)
  {
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.util.UtilityFunctions.AlwaysTrue
 * JD-Core Version:    0.7.0.1
 */