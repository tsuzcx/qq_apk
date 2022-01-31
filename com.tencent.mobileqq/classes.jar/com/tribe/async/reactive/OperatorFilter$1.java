package com.tribe.async.reactive;

import android.support.annotation.NonNull;

class OperatorFilter$1
  extends SimpleObserver<T>
{
  OperatorFilter$1(OperatorFilter paramOperatorFilter, Observer paramObserver) {}
  
  public void onComplete()
  {
    this.val$downObserver.onComplete();
  }
  
  public void onError(@NonNull Error paramError)
  {
    this.val$downObserver.onError(paramError);
  }
  
  public void onNext(T paramT)
  {
    if (OperatorFilter.access$000(this.this$0).test(paramT)) {
      this.val$downObserver.onNext(paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tribe.async.reactive.OperatorFilter.1
 * JD-Core Version:    0.7.0.1
 */