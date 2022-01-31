package com.tencent.plato.sdk.utils.watcher;

public class WatchListener
{
  private long mCancelledRequests;
  private long mFailedRequests;
  private long mRequestTotalTime;
  private long mStartRequests;
  private long mSuccessedRequests;
  
  public long getAverageRequestTime()
  {
    long l1 = 0L;
    long l2 = getCompletedRequests();
    if (l2 > 0L) {
      l1 = this.mRequestTotalTime / l2;
    }
    return l1;
  }
  
  public long getCancelledRequests()
  {
    return this.mCancelledRequests;
  }
  
  public long getCompletedRequests()
  {
    return this.mSuccessedRequests + this.mCancelledRequests + this.mFailedRequests;
  }
  
  public long getTotalRequests()
  {
    return this.mStartRequests;
  }
  
  public void initData()
  {
    this.mRequestTotalTime = 0L;
    this.mStartRequests = 0L;
    this.mSuccessedRequests = 0L;
    this.mFailedRequests = 0L;
    this.mCancelledRequests = 0L;
  }
  
  public void reportCancelltion(long paramLong)
  {
    this.mCancelledRequests += 1L;
    this.mRequestTotalTime += paramLong;
  }
  
  public void reportFailure(long paramLong)
  {
    this.mFailedRequests += 1L;
    this.mRequestTotalTime += paramLong;
  }
  
  public void reportStart()
  {
    this.mStartRequests += 1L;
  }
  
  public void reportSuccess(long paramLong)
  {
    this.mRequestTotalTime += paramLong;
    this.mSuccessedRequests += 1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.utils.watcher.WatchListener
 * JD-Core Version:    0.7.0.1
 */