package com.tribe.async.parallel;

import com.tribe.async.reactive.StreamFunction.StreamFunctionListener;

class ParallelDataPusher$1
  implements StreamFunction.StreamFunctionListener<OUT>
{
  ParallelDataPusher$1(ParallelDataPusher paramParallelDataPusher, Observer paramObserver) {}
  
  public void onCancel()
  {
    this.val$observer.onStreamCancel();
  }
  
  public void onError(Error paramError)
  {
    this.val$observer.onOneFunctionErr(Integer.valueOf(ParallelDataPusher.access$000(this.this$0).hashCode()), paramError);
  }
  
  public void onResult(OUT paramOUT)
  {
    this.val$observer.onOneFunctionSuc(Integer.valueOf(ParallelDataPusher.access$000(this.this$0).hashCode()), paramOUT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tribe.async.parallel.ParallelDataPusher.1
 * JD-Core Version:    0.7.0.1
 */