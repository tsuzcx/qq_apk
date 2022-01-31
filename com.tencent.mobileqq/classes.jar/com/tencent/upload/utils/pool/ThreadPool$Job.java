package com.tencent.upload.utils.pool;

public abstract interface ThreadPool$Job<T>
{
  public abstract T run(ThreadPool.JobContext paramJobContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.utils.pool.ThreadPool.Job
 * JD-Core Version:    0.7.0.1
 */