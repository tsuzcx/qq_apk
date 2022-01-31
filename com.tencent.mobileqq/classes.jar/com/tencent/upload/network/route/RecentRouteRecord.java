package com.tencent.upload.network.route;

import java.io.Serializable;

public class RecentRouteRecord
  implements Serializable
{
  private UploadRoute mRecentRoute = null;
  private long mTimeStamp = 0L;
  
  public UploadRoute getRecentRoute()
  {
    return this.mRecentRoute;
  }
  
  public long getTimeStamp()
  {
    return this.mTimeStamp;
  }
  
  public void setRecentRoute(UploadRoute paramUploadRoute)
  {
    this.mRecentRoute = paramUploadRoute;
  }
  
  public void setTimeStamp(long paramLong)
  {
    this.mTimeStamp = paramLong;
  }
  
  public String toString()
  {
    return "mRecentRoute = " + this.mRecentRoute + ",mTimeStamp = " + this.mTimeStamp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.network.route.RecentRouteRecord
 * JD-Core Version:    0.7.0.1
 */