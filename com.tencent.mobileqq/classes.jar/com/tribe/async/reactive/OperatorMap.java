package com.tribe.async.reactive;

import com.tribe.async.utils.AssertUtils;

class OperatorMap<UP, DOWN>
  extends Operator<UP, DOWN>
{
  private final StreamFunction<UP, DOWN> mTransform;
  
  public OperatorMap(StreamFunction<UP, DOWN> paramStreamFunction)
  {
    AssertUtils.checkNotNull(paramStreamFunction);
    this.mTransform = paramStreamFunction;
  }
  
  public Observer<UP> apply(Observer<DOWN> paramObserver)
  {
    AssertUtils.checkNotNull(paramObserver);
    this.mTransform.observe(new OperatorMap.1(this, paramObserver));
    return new OperatorMap.2(this, paramObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tribe.async.reactive.OperatorMap
 * JD-Core Version:    0.7.0.1
 */