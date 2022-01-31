package com.tribe.async.reactive;

import android.support.annotation.NonNull;
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
  
  public Observer<T> apply(final Observer<T> paramObserver)
  {
    AssertUtils.checkNotNull(paramObserver);
    new SimpleObserver()
    {
      public void onComplete()
      {
        paramObserver.onComplete();
      }
      
      public void onError(@NonNull Error paramAnonymousError)
      {
        paramObserver.onError(paramAnonymousError);
      }
      
      public void onNext(T paramAnonymousT)
      {
        if (OperatorFilter.this.mPredicate.test(paramAnonymousT)) {
          paramObserver.onNext(paramAnonymousT);
        }
      }
    };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.reactive.OperatorFilter
 * JD-Core Version:    0.7.0.1
 */