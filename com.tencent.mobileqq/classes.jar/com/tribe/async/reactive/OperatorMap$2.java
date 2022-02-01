package com.tribe.async.reactive;

import android.support.annotation.NonNull;

class OperatorMap$2
  extends SimpleObserver<UP>
{
  OperatorMap$2(OperatorMap paramOperatorMap, Observer paramObserver) {}
  
  public void onCancel()
  {
    OperatorMap.access$000(this.this$0).cancel();
  }
  
  public void onComplete()
  {
    this.val$downObserver.onComplete();
  }
  
  public void onError(@NonNull Error paramError)
  {
    OperatorMap.access$000(this.this$0).error(paramError);
  }
  
  public void onNext(UP paramUP)
  {
    OperatorMap.access$000(this.this$0).apply(paramUP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tribe.async.reactive.OperatorMap.2
 * JD-Core Version:    0.7.0.1
 */