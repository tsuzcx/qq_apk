package com.tencent.upload.utils.pool;

import java.util.concurrent.ThreadPoolExecutor;

public class UploadThreadManager
{
  private static volatile UploadThreadManager sInstance;
  private ThreadPool mDataThreadPool = new ThreadPool(10, 64, "DataThread");
  private ThreadPool mWorkThreadPool = new ThreadPool(4, 8, "UploadThread");
  
  private String getExecutorMessage(ThreadPoolExecutor paramThreadPoolExecutor, String paramString)
  {
    int i = paramThreadPoolExecutor.getActiveCount();
    int j = paramThreadPoolExecutor.getMaximumPoolSize();
    int k = paramThreadPoolExecutor.getPoolSize();
    paramThreadPoolExecutor = new StringBuilder(" Thread pool " + paramString);
    paramThreadPoolExecutor.append(" activeNum: " + i).append(" maxNum: " + j).append(" curNum: " + k);
    return paramThreadPoolExecutor.toString();
  }
  
  public static UploadThreadManager getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new UploadThreadManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  public ThreadPool getDataThreadPool()
  {
    return this.mDataThreadPool;
  }
  
  public ThreadPool getWorkThreadPool()
  {
    return this.mWorkThreadPool;
  }
  
  public String toString()
  {
    String str1 = getExecutorMessage(this.mWorkThreadPool.getExecutor(), "UploadThread");
    String str2 = getExecutorMessage(this.mDataThreadPool.getExecutor(), "DataThread");
    return str1 + str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.utils.pool.UploadThreadManager
 * JD-Core Version:    0.7.0.1
 */