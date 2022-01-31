package org.junit.internal.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class ThrowableCauseMatcher<T extends Throwable>
  extends TypeSafeMatcher<T>
{
  private final Matcher<? extends Throwable> causeMatcher;
  
  public ThrowableCauseMatcher(Matcher<? extends Throwable> paramMatcher)
  {
    this.causeMatcher = paramMatcher;
  }
  
  @Factory
  public static <T extends Throwable> Matcher<T> hasCause(Matcher<? extends Throwable> paramMatcher)
  {
    return new ThrowableCauseMatcher(paramMatcher);
  }
  
  protected void describeMismatchSafely(T paramT, Description paramDescription)
  {
    paramDescription.appendText("cause ");
    this.causeMatcher.describeMismatch(paramT.getCause(), paramDescription);
  }
  
  public void describeTo(Description paramDescription)
  {
    paramDescription.appendText("exception with cause ");
    paramDescription.appendDescriptionOf(this.causeMatcher);
  }
  
  protected boolean matchesSafely(T paramT)
  {
    return this.causeMatcher.matches(paramT.getCause());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.junit.internal.matchers.ThrowableCauseMatcher
 * JD-Core Version:    0.7.0.1
 */