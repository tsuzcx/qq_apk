package com.tencent.mobileqq.profilecard.bussiness.circle;

import feedcloud.FeedCloudRead.StGetMainPageRsp;

class ProfileCircleComponent$ProfileCircleCacheBean
{
  private long mStartTime;
  private FeedCloudRead.StGetMainPageRsp mUserInfo = new FeedCloudRead.StGetMainPageRsp();
  
  ProfileCircleComponent$ProfileCircleCacheBean(FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp, long paramLong)
  {
    this.mUserInfo.set(paramStGetMainPageRsp);
    this.mStartTime = paramLong;
  }
  
  public long getStartTime()
  {
    return this.mStartTime;
  }
  
  public FeedCloudRead.StGetMainPageRsp getUserInfo()
  {
    return this.mUserInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.circle.ProfileCircleComponent.ProfileCircleCacheBean
 * JD-Core Version:    0.7.0.1
 */