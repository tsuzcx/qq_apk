package rx.internal.util;

import rx.functions.Func1;

public final class UtilityFunctions
{
  private static final UtilityFunctions.NullFunction NULL_FUNCTION = new UtilityFunctions.NullFunction();
  
  public static <T> Func1<? super T, Boolean> alwaysFalse()
  {
    return UtilityFunctions.AlwaysFalse.INSTANCE;
  }
  
  public static <T> Func1<? super T, Boolean> alwaysTrue()
  {
    return UtilityFunctions.AlwaysTrue.INSTANCE;
  }
  
  public static <T> Func1<T, T> identity()
  {
    return new UtilityFunctions.1();
  }
  
  public static <T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, R> UtilityFunctions.NullFunction<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, R> returnNull()
  {
    return NULL_FUNCTION;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.util.UtilityFunctions
 * JD-Core Version:    0.7.0.1
 */