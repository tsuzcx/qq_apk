package org.junit.internal.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class ThrowableMessageMatcher<T extends Throwable>
  extends TypeSafeMatcher<T>
{
  private final Matcher<String> matcher;
  
  public ThrowableMessageMatcher(Matcher<String> paramMatcher)
  {
    this.matcher = paramMatcher;
  }
  
  @Factory
  public static <T extends Throwable> Matcher<T> hasMessage(Matcher<String> paramMatcher)
  {
    return new ThrowableMessageMatcher(paramMatcher);
  }
  
  protected void describeMismatchSafely(T paramT, Description paramDescription)
  {
    paramDescription.appendText("message ");
    this.matcher.describeMismatch(paramT.getMessage(), paramDescription);
  }
  
  public void describeTo(Description paramDescription)
  {
    paramDescription.appendText("exception with message ");
    paramDescription.appendDescriptionOf(this.matcher);
  }
  
  protected boolean matchesSafely(T paramT)
  {
    return this.matcher.matches(paramT.getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.internal.matchers.ThrowableMessageMatcher
 * JD-Core Version:    0.7.0.1
 */