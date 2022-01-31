package com.tencent.weiyun.utils.thread;

import java.util.concurrent.atomic.AtomicLong;

class PriorityThreadPool$PriorityJob<T>
  implements ThreadPool.Job<T>, Comparable<PriorityJob>
{
  private static final AtomicLong SEQ = new AtomicLong(0L);
  private final boolean mFifo;
  private final ThreadPool.Job<T> mJob;
  private final int mPriority;
  private final long mSeqNum;
  
  public PriorityThreadPool$PriorityJob(ThreadPool.Job<T> paramJob, int paramInt, boolean paramBoolean)
  {
    this.mJob = paramJob;
    this.mPriority = paramInt;
    this.mFifo = paramBoolean;
    this.mSeqNum = SEQ.getAndIncrement();
  }
  
  private int subCompareTo(PriorityJob paramPriorityJob)
  {
    int i;
    if (this.mSeqNum < paramPriorityJob.mSeqNum) {
      i = -1;
    }
    while (this.mFifo)
    {
      return i;
      if (this.mSeqNum > paramPriorityJob.mSeqNum) {
        i = 1;
      } else {
        i = 0;
      }
    }
    return -i;
  }
  
  public int compareTo(PriorityJob paramPriorityJob)
  {
    if (this.mPriority > paramPriorityJob.mPriority) {
      return -1;
    }
    if (this.mPriority < paramPriorityJob.mPriority) {
      return 1;
    }
    return subCompareTo(paramPriorityJob);
  }
  
  public T run(ThreadPool.JobContext paramJobContext)
  {
    return this.mJob.run(paramJobContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weiyun.utils.thread.PriorityThreadPool.PriorityJob
 * JD-Core Version:    0.7.0.1
 */