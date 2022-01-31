package org.hamcrest.core;

import java.util.Iterator;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

abstract class ShortcutCombination<T>
  extends BaseMatcher<T>
{
  private final Iterable<Matcher<? super T>> matchers;
  
  public ShortcutCombination(Iterable<Matcher<? super T>> paramIterable)
  {
    this.matchers = paramIterable;
  }
  
  public abstract void describeTo(Description paramDescription);
  
  public void describeTo(Description paramDescription, String paramString)
  {
    paramDescription.appendList("(", " " + paramString + " ", ")", this.matchers);
  }
  
  public abstract boolean matches(Object paramObject);
  
  protected boolean matches(Object paramObject, boolean paramBoolean)
  {
    Iterator localIterator = this.matchers.iterator();
    while (localIterator.hasNext()) {
      if (((Matcher)localIterator.next()).matches(paramObject) == paramBoolean) {
        return paramBoolean;
      }
    }
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false) {
      return paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.core.ShortcutCombination
 * JD-Core Version:    0.7.0.1
 */