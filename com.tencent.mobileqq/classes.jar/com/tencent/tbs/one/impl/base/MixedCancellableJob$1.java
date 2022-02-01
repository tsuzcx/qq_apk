package com.tencent.tbs.one.impl.base;

class MixedCancellableJob$1
  extends ProgressiveCallback<T>
{
  MixedCancellableJob$1(MixedCancellableJob paramMixedCancellableJob, boolean paramBoolean) {}
  
  public void onCompleted(T paramT)
  {
    this.this$0.finish(paramT);
  }
  
  public void onError(int paramInt, String paramString, Throwable paramThrowable)
  {
    Logging.i(paramString, new Object[] { paramThrowable });
    if ((this.val$isLastJob) || (this.this$0.isCancelled()))
    {
      this.this$0.fail(paramInt, paramString, paramThrowable);
      return;
    }
    MixedCancellableJob.access$000(this.this$0);
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2)
  {
    this.this$0.setProgress(paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.base.MixedCancellableJob.1
 * JD-Core Version:    0.7.0.1
 */