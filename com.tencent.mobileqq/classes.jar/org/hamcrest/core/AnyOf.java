package org.hamcrest.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class AnyOf<T>
  extends ShortcutCombination<T>
{
  public AnyOf(Iterable<Matcher<? super T>> paramIterable)
  {
    super(paramIterable);
  }
  
  @Factory
  public static <T> AnyOf<T> anyOf(Iterable<Matcher<? super T>> paramIterable)
  {
    return new AnyOf(paramIterable);
  }
  
  @Factory
  public static <T> AnyOf<T> anyOf(Matcher<T> paramMatcher, Matcher<? super T> paramMatcher1)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMatcher);
    localArrayList.add(paramMatcher1);
    return anyOf(localArrayList);
  }
  
  @Factory
  public static <T> AnyOf<T> anyOf(Matcher<T> paramMatcher, Matcher<? super T> paramMatcher1, Matcher<? super T> paramMatcher2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMatcher);
    localArrayList.add(paramMatcher1);
    localArrayList.add(paramMatcher2);
    return anyOf(localArrayList);
  }
  
  @Factory
  public static <T> AnyOf<T> anyOf(Matcher<T> paramMatcher, Matcher<? super T> paramMatcher1, Matcher<? super T> paramMatcher2, Matcher<? super T> paramMatcher3)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMatcher);
    localArrayList.add(paramMatcher1);
    localArrayList.add(paramMatcher2);
    localArrayList.add(paramMatcher3);
    return anyOf(localArrayList);
  }
  
  @Factory
  public static <T> AnyOf<T> anyOf(Matcher<T> paramMatcher, Matcher<? super T> paramMatcher1, Matcher<? super T> paramMatcher2, Matcher<? super T> paramMatcher3, Matcher<? super T> paramMatcher4)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMatcher);
    localArrayList.add(paramMatcher1);
    localArrayList.add(paramMatcher2);
    localArrayList.add(paramMatcher3);
    localArrayList.add(paramMatcher4);
    return anyOf(localArrayList);
  }
  
  @Factory
  public static <T> AnyOf<T> anyOf(Matcher<T> paramMatcher, Matcher<? super T> paramMatcher1, Matcher<? super T> paramMatcher2, Matcher<? super T> paramMatcher3, Matcher<? super T> paramMatcher4, Matcher<? super T> paramMatcher5)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMatcher);
    localArrayList.add(paramMatcher1);
    localArrayList.add(paramMatcher2);
    localArrayList.add(paramMatcher3);
    localArrayList.add(paramMatcher4);
    localArrayList.add(paramMatcher5);
    return anyOf(localArrayList);
  }
  
  @Factory
  public static <T> AnyOf<T> anyOf(Matcher<? super T>... paramVarArgs)
  {
    return anyOf(Arrays.asList(paramVarArgs));
  }
  
  public void describeTo(Description paramDescription)
  {
    describeTo(paramDescription, "or");
  }
  
  public boolean matches(Object paramObject)
  {
    return matches(paramObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.core.AnyOf
 * JD-Core Version:    0.7.0.1
 */