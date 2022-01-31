package com.tribe.async.reactive;

import android.support.annotation.NonNull;
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
  
  public Observer<UP> apply(final Observer<DOWN> paramObserver)
  {
    AssertUtils.checkNotNull(paramObserver);
    this.mTransform.observe(new StreamFunction.StreamFunctionListener()
    {
      public void onCancel()
      {
        paramObserver.onCancel();
      }
      
      public void onError(Error paramAnonymousError)
      {
        paramObserver.onError(paramAnonymousError);
      }
      
      public void onResult(DOWN paramAnonymousDOWN)
      {
        paramObserver.onNext(paramAnonymousDOWN);
      }
    });
    new SimpleObserver()
    {
      public void onCancel()
      {
        OperatorMap.this.mTransform.cancel();
      }
      
      public void onComplete()
      {
        paramObserver.onComplete();
      }
      
      public void onError(@NonNull Error paramAnonymousError)
      {
        OperatorMap.this.mTransform.error(paramAnonymousError);
      }
      
      public void onNext(UP paramAnonymousUP)
      {
        OperatorMap.this.mTransform.apply(paramAnonymousUP);
      }
    };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.reactive.OperatorMap
 * JD-Core Version:    0.7.0.1
 */