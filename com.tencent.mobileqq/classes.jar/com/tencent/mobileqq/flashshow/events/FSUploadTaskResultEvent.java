package com.tencent.mobileqq.flashshow.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class FSUploadTaskResultEvent
  extends SimpleBaseEvent
{
  private String clientKey;
  private String coverUrl;
  private long createTime;
  private String feedId;
  private boolean isSuccess;
  
  public FSUploadTaskResultEvent(boolean paramBoolean, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    this.isSuccess = paramBoolean;
    this.coverUrl = paramString1;
    this.feedId = paramString2;
    this.clientKey = paramString3;
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
  
  public String getUploadCoverUrl()
  {
    return this.coverUrl;
  }
  
  public boolean isUploadSuccess()
  {
    return this.isSuccess;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.events.FSUploadTaskResultEvent
 * JD-Core Version:    0.7.0.1
 */