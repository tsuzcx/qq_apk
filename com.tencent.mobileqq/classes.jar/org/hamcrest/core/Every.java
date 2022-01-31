package org.hamcrest.core;

import java.util.Iterator;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class Every<T>
  extends TypeSafeDiagnosingMatcher<Iterable<T>>
{
  private final Matcher<? super T> matcher;
  
  public Every(Matcher<? super T> paramMatcher)
  {
    this.matcher = paramMatcher;
  }
  
  @Factory
  public static <U> Matcher<Iterable<U>> everyItem(Matcher<U> paramMatcher)
  {
    return new Every(paramMatcher);
  }
  
  public void describeTo(Description paramDescription)
  {
    paramDescription.appendText("every item is ").appendDescriptionOf(this.matcher);
  }
  
  public boolean matchesSafely(Iterable<T> paramIterable, Description paramDescription)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (!this.matcher.matches(localObject))
      {
        paramDescription.appendText("an item ");
        this.matcher.describeMismatch(localObject, paramDescription);
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.core.Every
 * JD-Core Version:    0.7.0.1
 */