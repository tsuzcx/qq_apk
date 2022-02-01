package com.tribe.async.reactive;

public abstract interface StreamFunction$StreamFunctionListener<OUT>
{
  public abstract void onCancel();
  
  public abstract void onError(Error paramError);
  
  public abstract void onResult(OUT paramOUT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tribe.async.reactive.StreamFunction.StreamFunctionListener
 * JD-Core Version:    0.7.0.1
 */