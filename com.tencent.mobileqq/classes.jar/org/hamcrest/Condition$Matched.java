package org.hamcrest;

final class Condition$Matched<T>
  extends Condition<T>
{
  private final Description mismatch;
  private final T theValue;
  
  private Condition$Matched(T paramT, Description paramDescription)
  {
    super(null);
    this.theValue = paramT;
    this.mismatch = paramDescription;
  }
  
  public <U> Condition<U> and(Condition.Step<? super T, U> paramStep)
  {
    return paramStep.apply(this.theValue, this.mismatch);
  }
  
  public boolean matching(Matcher<T> paramMatcher, String paramString)
  {
    if (paramMatcher.matches(this.theValue)) {
      return true;
    }
    this.mismatch.appendText(paramString);
    paramMatcher.describeMismatch(this.theValue, this.mismatch);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.Condition.Matched
 * JD-Core Version:    0.7.0.1
 */