package org.hamcrest.core;

import org.hamcrest.Matcher;

public final class CombinableMatcher$CombinableBothMatcher<X>
{
  private final Matcher<? super X> first;
  
  public CombinableMatcher$CombinableBothMatcher(Matcher<? super X> paramMatcher)
  {
    this.first = paramMatcher;
  }
  
  public CombinableMatcher<X> and(Matcher<? super X> paramMatcher)
  {
    return new CombinableMatcher(this.first).and(paramMatcher);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.core.CombinableMatcher.CombinableBothMatcher
 * JD-Core Version:    0.7.0.1
 */