package org.hamcrest.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class IsCollectionContaining<T>
  extends TypeSafeDiagnosingMatcher<Iterable<? super T>>
{
  private final Matcher<? super T> elementMatcher;
  
  public IsCollectionContaining(Matcher<? super T> paramMatcher)
  {
    this.elementMatcher = paramMatcher;
  }
  
  @Factory
  public static <T> Matcher<Iterable<? super T>> hasItem(T paramT)
  {
    return new IsCollectionContaining(IsEqual.equalTo(paramT));
  }
  
  @Factory
  public static <T> Matcher<Iterable<? super T>> hasItem(Matcher<? super T> paramMatcher)
  {
    return new IsCollectionContaining(paramMatcher);
  }
  
  @Factory
  public static <T> Matcher<Iterable<T>> hasItems(T... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(hasItem(paramVarArgs[i]));
      i += 1;
    }
    return AllOf.allOf(localArrayList);
  }
  
  @Factory
  public static <T> Matcher<Iterable<T>> hasItems(Matcher<? super T>... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new IsCollectionContaining(paramVarArgs[i]));
      i += 1;
    }
    return AllOf.allOf(localArrayList);
  }
  
  public void describeTo(Description paramDescription)
  {
    paramDescription.appendText("a collection containing ").appendDescriptionOf(this.elementMatcher);
  }
  
  protected boolean matchesSafely(Iterable<? super T> paramIterable, Description paramDescription)
  {
    paramIterable = paramIterable.iterator();
    for (int i = 0; paramIterable.hasNext(); i = 1)
    {
      Object localObject = paramIterable.next();
      if (this.elementMatcher.matches(localObject)) {
        return true;
      }
      if (i != 0) {
        paramDescription.appendText(", ");
      }
      this.elementMatcher.describeMismatch(localObject, paramDescription);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.core.IsCollectionContaining
 * JD-Core Version:    0.7.0.1
 */