package com.tribe.async.reactive;

class OperatorMap$1
  implements StreamFunction.StreamFunctionListener<DOWN>
{
  OperatorMap$1(OperatorMap paramOperatorMap, Observer paramObserver) {}
  
  public void onCancel()
  {
    this.val$downObserver.onCancel();
  }
  
  public void onError(Error paramError)
  {
    this.val$downObserver.onError(paramError);
  }
  
  public void onResult(DOWN paramDOWN)
  {
    this.val$downObserver.onNext(paramDOWN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.reactive.OperatorMap.1
 * JD-Core Version:    0.7.0.1
 */