package com.tencent.mobileqq.winkpublish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class PublishUploadTaskResultEvent
  extends SimpleBaseEvent
{
  private String clientKey;
  private String coverUrl;
  private long createTime;
  private String feedId;
  private boolean isSuccess;
  private String missionId;
  private int targetPage;
  
  public PublishUploadTaskResultEvent(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    this.isSuccess = paramBoolean;
    this.missionId = paramString1;
    this.coverUrl = paramString2;
    this.feedId = paramString3;
    this.clientKey = paramString4;
    this.createTime = paramLong;
  }
  
  public String getClientKey()
  {
    return this.clientKey;
  }
  
  public long getCreateTime()
  {
    return this.createTime;
  }
  
  public String getFeedId()
  {
    return this.feedId;
  }
  
  public String getMissionId()
  {
    return this.missionId;
  }
  
  public int getTargetPage()
  {
    return this.targetPage;
  }
  
  public String getUploadCoverUrl()
  {
    return this.coverUrl;
  }
  
  public boolean isUploadSuccess()
  {
    return this.isSuccess;
  }
  
  public void setTargetPage(int paramInt)
  {
    this.targetPage = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PublishUploadTaskResultEvent{isSuccess=");
    localStringBuilder.append(this.isSuccess);
    localStringBuilder.append(", missionId='");
    localStringBuilder.append(this.missionId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", coverUrl='");
    localStringBuilder.append(this.coverUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", feedId='");
    localStringBuilder.append(this.feedId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", clientKey='");
    localStringBuilder.append(this.clientKey);
    localStringBuilder.append('\'');
    localStringBuilder.append(", createTime=");
    localStringBuilder.append(this.createTime);
    localStringBuilder.append(", targetPage=");
    localStringBuilder.append(this.targetPage);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.event.PublishUploadTaskResultEvent
 * JD-Core Version:    0.7.0.1
 */