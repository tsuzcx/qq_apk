package com.tencent.weiyun.transmission.utils;

import com.tencent.weiyun.transmission.utils.thread.ThreadPool;

public class ThreadPoolWrapper
{
  private static final int DEFAULT_SIZE = 6;
  private final String mName;
  private ThreadPool mThreadPool;
  
  public ThreadPoolWrapper(String paramString)
  {
    this.mName = paramString;
    this.mThreadPool = new ThreadPool(this.mName, 6);
  }
  
  /* Error */
  public void submit(com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job<java.lang.Void> paramJob)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/tencent/weiyun/transmission/utils/ThreadPoolWrapper:mThreadPool	Lcom/tencent/weiyun/transmission/utils/thread/ThreadPool;
    //   6: aload_1
    //   7: invokevirtual 33	com/tencent/weiyun/transmission/utils/thread/ThreadPool:submit	(Lcom/tencent/weiyun/transmission/utils/thread/ThreadPool$Job;)Lcom/tencent/weiyun/transmission/utils/thread/Future;
    //   10: pop
    //   11: goto +8 -> 19
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: astore_1
    //   23: goto -4 -> 19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	26	0	this	ThreadPoolWrapper
    //   0	26	1	paramJob	com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job<java.lang.Void>
    // Exception table:
    //   from	to	target	type
    //   2	11	14	finally
    //   2	11	22	java/util/concurrent/RejectedExecutionException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.transmission.utils.ThreadPoolWrapper
 * JD-Core Version:    0.7.0.1
 */