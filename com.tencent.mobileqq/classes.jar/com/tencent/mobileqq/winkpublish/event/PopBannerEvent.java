package com.tencent.mobileqq.winkpublish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class PopBannerEvent
  extends SimpleBaseEvent
{
  private String clientKey;
  private String coverUrl;
  private long createTime;
  private String feedId;
  private boolean isSuccess;
  private int mCurTab;
  private String missionId;
  
  public PopBannerEvent(String paramString1, boolean paramBoolean, int paramInt, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    this.missionId = paramString1;
    this.isSuccess = paramBoolean;
    this.mCurTab = paramInt;
    this.clientKey = paramString2;
    this.coverUrl = paramString3;
    this.feedId = paramString4;
    this.createTime = paramLong;
  }
  
  public PopBannerEvent(boolean paramBoolean, int paramInt)
  {
    this.isSuccess = paramBoolean;
    this.mCurTab = paramInt;
  }
  
  public String getClientKey()
  {
    return this.clientKey;
  }
  
  public String getCoverUrl()
  {
    return this.coverUrl;
  }
  
  public long getCreateTime()
  {
    return this.createTime;
  }
  
  public int getCurTab()
  {
    return this.mCurTab;
  }
  
  public String getFeedId()
  {
    return this.feedId;
  }
  
  public String getMissionId()
  {
    return this.missionId;
  }
  
  public boolean isSuccess()
  {
    return this.isSuccess;
  }
  
  public void setClientKey(String paramString)
  {
    this.clientKey = paramString;
  }
  
  public void setCoverUrl(String paramString)
  {
    this.coverUrl = paramString;
  }
  
  public void setCreateTime(long paramLong)
  {
    this.createTime = paramLong;
  }
  
  public void setCurTab(int paramInt)
  {
    this.mCurTab = paramInt;
  }
  
  public void setFeedId(String paramString)
  {
    this.feedId = paramString;
  }
  
  public void setMissionId(String paramString)
  {
    this.missionId = paramString;
  }
  
  public void setSuccess(boolean paramBoolean)
  {
    this.isSuccess = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PopBannerEvent{isSuccess=");
    localStringBuilder.append(this.isSuccess);
    localStringBuilder.append(", mCurTab=");
    localStringBuilder.append(this.mCurTab);
    localStringBuilder.append(", clientKey='");
    localStringBuilder.append(this.clientKey);
    localStringBuilder.append('\'');
    localStringBuilder.append(", coverUrl='");
    localStringBuilder.append(this.coverUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", feedId='");
    localStringBuilder.append(this.feedId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", createTime=");
    localStringBuilder.append(this.createTime);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.event.PopBannerEvent
 * JD-Core Version:    0.7.0.1
 */