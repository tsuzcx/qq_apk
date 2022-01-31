package org.hamcrest;

public abstract class Condition<T>
{
  public static final Condition.NotMatched<Object> NOT_MATCHED = new Condition.NotMatched(null);
  
  public static <T> Condition<T> matched(T paramT, Description paramDescription)
  {
    return new Condition.Matched(paramT, paramDescription, null);
  }
  
  public static <T> Condition<T> notMatched()
  {
    return NOT_MATCHED;
  }
  
  public abstract <U> Condition<U> and(Condition.Step<? super T, U> paramStep);
  
  public final boolean matching(Matcher<T> paramMatcher)
  {
    return matching(paramMatcher, "");
  }
  
  public abstract boolean matching(Matcher<T> paramMatcher, String paramString);
  
  public final <U> Condition<U> then(Condition.Step<? super T, U> paramStep)
  {
    return and(paramStep);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.Condition
 * JD-Core Version:    0.7.0.1
 */