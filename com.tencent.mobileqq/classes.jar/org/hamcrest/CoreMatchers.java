package org.hamcrest;

import org.hamcrest.core.AllOf;
import org.hamcrest.core.AnyOf;
import org.hamcrest.core.CombinableMatcher;
import org.hamcrest.core.CombinableMatcher.CombinableBothMatcher;
import org.hamcrest.core.CombinableMatcher.CombinableEitherMatcher;
import org.hamcrest.core.DescribedAs;
import org.hamcrest.core.Every;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsAnything;
import org.hamcrest.core.IsCollectionContaining;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsInstanceOf;
import org.hamcrest.core.IsNot;
import org.hamcrest.core.IsNull;
import org.hamcrest.core.IsSame;
import org.hamcrest.core.StringContains;
import org.hamcrest.core.StringEndsWith;
import org.hamcrest.core.StringStartsWith;

public class CoreMatchers
{
  public static <T> Matcher<T> allOf(Iterable<Matcher<? super T>> paramIterable)
  {
    return AllOf.allOf(paramIterable);
  }
  
  public static <T> Matcher<T> allOf(Matcher<? super T> paramMatcher1, Matcher<? super T> paramMatcher2)
  {
    return AllOf.allOf(paramMatcher1, paramMatcher2);
  }
  
  public static <T> Matcher<T> allOf(Matcher<? super T> paramMatcher1, Matcher<? super T> paramMatcher2, Matcher<? super T> paramMatcher3)
  {
    return AllOf.allOf(paramMatcher1, paramMatcher2, paramMatcher3);
  }
  
  public static <T> Matcher<T> allOf(Matcher<? super T> paramMatcher1, Matcher<? super T> paramMatcher2, Matcher<? super T> paramMatcher3, Matcher<? super T> paramMatcher4)
  {
    return AllOf.allOf(paramMatcher1, paramMatcher2, paramMatcher3, paramMatcher4);
  }
  
  public static <T> Matcher<T> allOf(Matcher<? super T> paramMatcher1, Matcher<? super T> paramMatcher2, Matcher<? super T> paramMatcher3, Matcher<? super T> paramMatcher4, Matcher<? super T> paramMatcher5)
  {
    return AllOf.allOf(paramMatcher1, paramMatcher2, paramMatcher3, paramMatcher4, paramMatcher5);
  }
  
  public static <T> Matcher<T> allOf(Matcher<? super T> paramMatcher1, Matcher<? super T> paramMatcher2, Matcher<? super T> paramMatcher3, Matcher<? super T> paramMatcher4, Matcher<? super T> paramMatcher5, Matcher<? super T> paramMatcher6)
  {
    return AllOf.allOf(paramMatcher1, paramMatcher2, paramMatcher3, paramMatcher4, paramMatcher5, paramMatcher6);
  }
  
  public static <T> Matcher<T> allOf(Matcher<? super T>... paramVarArgs)
  {
    return AllOf.allOf(paramVarArgs);
  }
  
  public static <T> Matcher<T> any(Class<T> paramClass)
  {
    return IsInstanceOf.any(paramClass);
  }
  
  public static <T> AnyOf<T> anyOf(Iterable<Matcher<? super T>> paramIterable)
  {
    return AnyOf.anyOf(paramIterable);
  }
  
  public static <T> AnyOf<T> anyOf(Matcher<T> paramMatcher, Matcher<? super T> paramMatcher1)
  {
    return AnyOf.anyOf(paramMatcher, paramMatcher1);
  }
  
  public static <T> AnyOf<T> anyOf(Matcher<T> paramMatcher, Matcher<? super T> paramMatcher1, Matcher<? super T> paramMatcher2)
  {
    return AnyOf.anyOf(paramMatcher, paramMatcher1, paramMatcher2);
  }
  
  public static <T> AnyOf<T> anyOf(Matcher<T> paramMatcher, Matcher<? super T> paramMatcher1, Matcher<? super T> paramMatcher2, Matcher<? super T> paramMatcher3)
  {
    return AnyOf.anyOf(paramMatcher, paramMatcher1, paramMatcher2, paramMatcher3);
  }
  
  public static <T> AnyOf<T> anyOf(Matcher<T> paramMatcher, Matcher<? super T> paramMatcher1, Matcher<? super T> paramMatcher2, Matcher<? super T> paramMatcher3, Matcher<? super T> paramMatcher4)
  {
    return AnyOf.anyOf(paramMatcher, paramMatcher1, paramMatcher2, paramMatcher3, paramMatcher4);
  }
  
  public static <T> AnyOf<T> anyOf(Matcher<T> paramMatcher, Matcher<? super T> paramMatcher1, Matcher<? super T> paramMatcher2, Matcher<? super T> paramMatcher3, Matcher<? super T> paramMatcher4, Matcher<? super T> paramMatcher5)
  {
    return AnyOf.anyOf(paramMatcher, paramMatcher1, paramMatcher2, paramMatcher3, paramMatcher4, paramMatcher5);
  }
  
  public static <T> AnyOf<T> anyOf(Matcher<? super T>... paramVarArgs)
  {
    return AnyOf.anyOf(paramVarArgs);
  }
  
  public static Matcher<Object> anything()
  {
    return IsAnything.anything();
  }
  
  public static Matcher<Object> anything(String paramString)
  {
    return IsAnything.anything(paramString);
  }
  
  public static <LHS> CombinableMatcher.CombinableBothMatcher<LHS> both(Matcher<? super LHS> paramMatcher)
  {
    return CombinableMatcher.both(paramMatcher);
  }
  
  public static Matcher<String> containsString(String paramString)
  {
    return StringContains.containsString(paramString);
  }
  
  public static <T> Matcher<T> describedAs(String paramString, Matcher<T> paramMatcher, Object... paramVarArgs)
  {
    return DescribedAs.describedAs(paramString, paramMatcher, paramVarArgs);
  }
  
  public static <LHS> CombinableMatcher.CombinableEitherMatcher<LHS> either(Matcher<? super LHS> paramMatcher)
  {
    return CombinableMatcher.either(paramMatcher);
  }
  
  public static Matcher<String> endsWith(String paramString)
  {
    return StringEndsWith.endsWith(paramString);
  }
  
  public static <T> Matcher<T> equalTo(T paramT)
  {
    return IsEqual.equalTo(paramT);
  }
  
  public static <U> Matcher<Iterable<U>> everyItem(Matcher<U> paramMatcher)
  {
    return Every.everyItem(paramMatcher);
  }
  
  public static <T> Matcher<Iterable<? super T>> hasItem(T paramT)
  {
    return IsCollectionContaining.hasItem(paramT);
  }
  
  public static <T> Matcher<Iterable<? super T>> hasItem(Matcher<? super T> paramMatcher)
  {
    return IsCollectionContaining.hasItem(paramMatcher);
  }
  
  public static <T> Matcher<Iterable<T>> hasItems(T... paramVarArgs)
  {
    return IsCollectionContaining.hasItems(paramVarArgs);
  }
  
  public static <T> Matcher<Iterable<T>> hasItems(Matcher<? super T>... paramVarArgs)
  {
    return IsCollectionContaining.hasItems(paramVarArgs);
  }
  
  public static <T> Matcher<T> instanceOf(Class<?> paramClass)
  {
    return IsInstanceOf.instanceOf(paramClass);
  }
  
  public static <T> Matcher<T> is(Class<T> paramClass)
  {
    return Is.is(paramClass);
  }
  
  public static <T> Matcher<T> is(T paramT)
  {
    return Is.is(paramT);
  }
  
  public static <T> Matcher<T> is(Matcher<T> paramMatcher)
  {
    return Is.is(paramMatcher);
  }
  
  public static <T> Matcher<T> isA(Class<T> paramClass)
  {
    return Is.isA(paramClass);
  }
  
  public static <T> Matcher<T> not(T paramT)
  {
    return IsNot.not(paramT);
  }
  
  public static <T> Matcher<T> not(Matcher<T> paramMatcher)
  {
    return IsNot.not(paramMatcher);
  }
  
  public static Matcher<Object> notNullValue()
  {
    return IsNull.notNullValue();
  }
  
  public static <T> Matcher<T> notNullValue(Class<T> paramClass)
  {
    return IsNull.notNullValue(paramClass);
  }
  
  public static Matcher<Object> nullValue()
  {
    return IsNull.nullValue();
  }
  
  public static <T> Matcher<T> nullValue(Class<T> paramClass)
  {
    return IsNull.nullValue(paramClass);
  }
  
  public static <T> Matcher<T> sameInstance(T paramT)
  {
    return IsSame.sameInstance(paramT);
  }
  
  public static Matcher<String> startsWith(String paramString)
  {
    return StringStartsWith.startsWith(paramString);
  }
  
  public static <T> Matcher<T> theInstance(T paramT)
  {
    return IsSame.theInstance(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.CoreMatchers
 * JD-Core Version:    0.7.0.1
 */