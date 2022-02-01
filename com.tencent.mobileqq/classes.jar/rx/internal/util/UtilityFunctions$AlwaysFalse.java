package rx.internal.util;

import rx.functions.Func1;

 enum UtilityFunctions$AlwaysFalse
  implements Func1<Object, Boolean>
{
  INSTANCE;
  
  private UtilityFunctions$AlwaysFalse() {}
  
  public Boolean call(Object paramObject)
  {
    return Boolean.valueOf(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.util.UtilityFunctions.AlwaysFalse
 * JD-Core Version:    0.7.0.1
 */