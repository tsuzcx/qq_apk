package com.tencent.weiyun.utils.thread;

public abstract interface ThreadPool$Job<T>
{
  public abstract T run(ThreadPool.JobContext paramJobContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.utils.thread.ThreadPool.Job
 * JD-Core Version:    0.7.0.1
 */