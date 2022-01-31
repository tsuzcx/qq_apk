package com.tribe.async.reactive;

import com.tribe.async.utils.AssertUtils;

public class OperatorFilter<T>
  extends Operator<T, T>
{
  private final Predicate<T> mPredicate;
  
  public OperatorFilter(Predicate<T> paramPredicate)
  {
    AssertUtils.checkNotNull(paramPredicate);
    this.mPredicate = paramPredicate;
  }
  
  public Observer<T> apply(Observer<T> paramObserver)
  {
    AssertUtils.checkNotNull(paramObserver);
    return new OperatorFilter.1(this, paramObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tribe.async.reactive.OperatorFilter
 * JD-Core Version:    0.7.0.1
 */