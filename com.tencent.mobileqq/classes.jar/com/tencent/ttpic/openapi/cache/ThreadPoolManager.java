package com.tencent.ttpic.openapi.cache;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public enum ThreadPoolManager
{
  private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
  private static final int CPU_COUNT;
  private volatile Executor cachedThreadPool;
  private volatile ScheduledExecutorService scheduledThreadPoolExecutor;
  private volatile Executor singleThreadExecutor;
  private volatile Executor singleThreadScheduledExecutor;
  
  static
  {
    $VALUES = new ThreadPoolManager[] { INSTANCE };
    CPU_COUNT = Runtime.getRuntime().availableProcessors();
  }
  
  private ThreadPoolManager() {}
  
  public static ThreadPoolManager getInstance()
  {
    return INSTANCE;
  }
  
  public Executor getCachedThreadPool()
  {
    if (this.cachedThreadPool == null) {}
    try
    {
      if (this.cachedThreadPool == null) {
        this.cachedThreadPool = Executors.newCachedThreadPool();
      }
      return this.cachedThreadPool;
    }
    finally {}
  }
  
  public ScheduledExecutorService getScheduledThreadPoolExecutor()
  {
    if (this.scheduledThreadPoolExecutor == null) {}
    try
    {
      if (this.scheduledThreadPoolExecutor == null) {
        this.scheduledThreadPoolExecutor = Executors.newScheduledThreadPool(CORE_POOL_SIZE);
      }
      return this.scheduledThreadPoolExecutor;
    }
    finally {}
  }
  
  public Executor getSingleThreadExecutor()
  {
    if (this.singleThreadExecutor == null) {}
    try
    {
      if (this.singleThreadExecutor == null) {
        this.singleThreadExecutor = Executors.newSingleThreadExecutor();
      }
      return this.singleThreadExecutor;
    }
    finally {}
  }
  
  public Executor getSingleThreadScheduledExecutor()
  {
    if (this.singleThreadScheduledExecutor == null) {}
    try
    {
      if (this.singleThreadScheduledExecutor == null) {
        this.singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
      }
      return this.singleThreadScheduledExecutor;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.cache.ThreadPoolManager
 * JD-Core Version:    0.7.0.1
 */