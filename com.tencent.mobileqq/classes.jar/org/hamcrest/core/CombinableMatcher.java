package org.hamcrest.core;

import java.util.ArrayList;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class CombinableMatcher<T>
  extends TypeSafeDiagnosingMatcher<T>
{
  private final Matcher<? super T> matcher;
  
  public CombinableMatcher(Matcher<? super T> paramMatcher)
  {
    this.matcher = paramMatcher;
  }
  
  @Factory
  public static <LHS> CombinableMatcher.CombinableBothMatcher<LHS> both(Matcher<? super LHS> paramMatcher)
  {
    return new CombinableMatcher.CombinableBothMatcher(paramMatcher);
  }
  
  @Factory
  public static <LHS> CombinableMatcher.CombinableEitherMatcher<LHS> either(Matcher<? super LHS> paramMatcher)
  {
    return new CombinableMatcher.CombinableEitherMatcher(paramMatcher);
  }
  
  private ArrayList<Matcher<? super T>> templatedListWith(Matcher<? super T> paramMatcher)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.matcher);
    localArrayList.add(paramMatcher);
    return localArrayList;
  }
  
  public CombinableMatcher<T> and(Matcher<? super T> paramMatcher)
  {
    return new CombinableMatcher(new AllOf(templatedListWith(paramMatcher)));
  }
  
  public void describeTo(Description paramDescription)
  {
    paramDescription.appendDescriptionOf(this.matcher);
  }
  
  public boolean matchesSafely(T paramT, Description paramDescription)
  {
    if (!this.matcher.matches(paramT))
    {
      this.matcher.describeMismatch(paramT, paramDescription);
      return false;
    }
    return true;
  }
  
  public CombinableMatcher<T> or(Matcher<? super T> paramMatcher)
  {
    return new CombinableMatcher(new AnyOf(templatedListWith(paramMatcher)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.core.CombinableMatcher
 * JD-Core Version:    0.7.0.1
 */