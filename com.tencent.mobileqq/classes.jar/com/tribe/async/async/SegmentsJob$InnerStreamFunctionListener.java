package com.tribe.async.async;

import com.tribe.async.reactive.StreamFunction.StreamFunctionListener;

class SegmentsJob$InnerStreamFunctionListener
  implements StreamFunction.StreamFunctionListener<OUT>
{
  private SegmentsJob$InnerStreamFunctionListener(SegmentsJob paramSegmentsJob) {}
  
  public void onCancel() {}
  
  public void onError(Error paramError)
  {
    SegmentsJob.access$202(this.this$0, paramError);
  }
  
  public void onResult(OUT paramOUT)
  {
    SegmentsJob.access$102(this.this$0, paramOUT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tribe.async.async.SegmentsJob.InnerStreamFunctionListener
 * JD-Core Version:    0.7.0.1
 */