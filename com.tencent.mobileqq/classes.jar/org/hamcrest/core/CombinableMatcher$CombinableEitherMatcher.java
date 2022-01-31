package org.hamcrest.core;

import org.hamcrest.Matcher;

public final class CombinableMatcher$CombinableEitherMatcher<X>
{
  private final Matcher<? super X> first;
  
  public CombinableMatcher$CombinableEitherMatcher(Matcher<? super X> paramMatcher)
  {
    this.first = paramMatcher;
  }
  
  public CombinableMatcher<X> or(Matcher<? super X> paramMatcher)
  {
    return new CombinableMatcher(this.first).or(paramMatcher);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.core.CombinableMatcher.CombinableEitherMatcher
 * JD-Core Version:    0.7.0.1
 */