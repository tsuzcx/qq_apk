package com.tribe.async.reactive;

import com.tribe.async.utils.AssertUtils;

public abstract class StreamFunction<IN, OUT>
  implements AsyncFunction<IN>
{
  private StreamFunction.StreamFunctionListener<OUT> mDownListener;
  private volatile boolean mIsCanceled;
  
  public final void apply(IN paramIN)
  {
    this.mIsCanceled = false;
    call(paramIN);
  }
  
  protected abstract void call(IN paramIN);
  
  public final void cancel()
  {
    this.mIsCanceled = true;
    if (this.mDownListener != null) {
      this.mDownListener.onCancel();
    }
    onCancel();
  }
  
  protected void error(Error paramError)
  {
    notifyError(paramError);
  }
  
  public boolean isCanceled()
  {
    return this.mIsCanceled;
  }
  
  public void notifyError(Error paramError)
  {
    AssertUtils.checkNotNull(paramError);
    if (this.mDownListener == null) {
      AssertUtils.fail("Please call observe first.", new Object[0]);
    }
    this.mDownListener.onError(paramError);
  }
  
  public void notifyResult(OUT paramOUT)
  {
    if (this.mDownListener == null) {
      AssertUtils.fail("Please call observe first.", new Object[0]);
    }
    this.mDownListener.onResult(paramOUT);
  }
  
  public final void observe(StreamFunction.StreamFunctionListener<OUT> paramStreamFunctionListener)
  {
    this.mDownListener = paramStreamFunctionListener;
  }
  
  protected void onCancel() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tribe.async.reactive.StreamFunction
 * JD-Core Version:    0.7.0.1
 */