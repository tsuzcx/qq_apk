package com.tencent.tbs.one.impl.base;

class ExclusiveJob$1
  implements Runnable
{
  ExclusiveJob$1(ExclusiveJob paramExclusiveJob) {}
  
  public void run()
  {
    try
    {
      ExclusiveJob.access$002(this.this$0, ProcessLock.acquire(ExclusiveJob.access$100(this.this$0), new ExclusiveJob.1.1(this), ExclusiveJob.access$200(this.this$0)));
      this.this$0.onLockGranted();
      return;
    }
    catch (Exception localException)
    {
      this.this$0.onLockTimeout(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.base.ExclusiveJob.1
 * JD-Core Version:    0.7.0.1
 */