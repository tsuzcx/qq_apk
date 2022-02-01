package com.tencent.mobileqq.flashshow.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class FSFeedEvent
  extends SimpleBaseEvent
{
  public static final int STATE_DELETE = 1;
  public static final int STATE_DELETE_BY_UIN = 2;
  public static final int STATE_LOAD_FOLLOWED_FEED_BY_UIN = 3;
  private String mFeedId;
  private int mStatus;
  private String mUin;
  
  public FSFeedEvent(int paramInt)
  {
    this.mStatus = paramInt;
  }
  
  public FSFeedEvent(int paramInt, String paramString)
  {
    this.mStatus = paramInt;
    this.mFeedId = paramString;
  }
  
  public String getFeedId()
  {
    return this.mFeedId;
  }
  
  public int getStatus()
  {
    return this.mStatus;
  }
  
  public String getUin()
  {
    return this.mUin;
  }
  
  public FSFeedEvent setFeedId(String paramString)
  {
    this.mFeedId = paramString;
    return this;
  }
  
  public FSFeedEvent setStatus(int paramInt)
  {
    this.mStatus = paramInt;
    return this;
  }
  
  public FSFeedEvent setUin(String paramString)
  {
    this.mUin = paramString;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FSFeedEvent{mStatus=");
    localStringBuilder.append(this.mStatus);
    localStringBuilder.append(", mFeedId='");
    localStringBuilder.append(this.mFeedId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mUin='");
    localStringBuilder.append(this.mUin);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.events.FSFeedEvent
 * JD-Core Version:    0.7.0.1
 */