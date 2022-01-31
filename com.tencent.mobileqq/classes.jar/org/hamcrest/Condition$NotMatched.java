package org.hamcrest;

final class Condition$NotMatched<T>
  extends Condition<T>
{
  private Condition$NotMatched()
  {
    super(null);
  }
  
  public <U> Condition<U> and(Condition.Step<? super T, U> paramStep)
  {
    return notMatched();
  }
  
  public boolean matching(Matcher<T> paramMatcher, String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.Condition.NotMatched
 * JD-Core Version:    0.7.0.1
 */