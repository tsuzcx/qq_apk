package com.tencent.mobileqq.winkpublish.model;

public class DraftBean
  implements Comparable<DraftBean>
{
  private boolean canSelect;
  private String clientKey;
  private String content;
  private String coverUrl;
  private long createTime;
  private boolean isSelected;
  private int mediaType;
  private String missionId;
  private String originPath;
  private int picCount;
  private int toastStatus;
  private int uploadStatus;
  private int videoCount;
  
  public int compareTo(DraftBean paramDraftBean)
  {
    if (paramDraftBean != null) {
      return (int)(paramDraftBean.getCreateTime() - getCreateTime());
    }
    throw new ClassCastException("can't trans to DraftBean...");
  }
  
  public String getClientKey()
  {
    return this.clientKey;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public String getCoverUrl()
  {
    return this.coverUrl;
  }
  
  public long getCreateTime()
  {
    return this.createTime;
  }
  
  public int getMediaType()
  {
    return this.mediaType;
  }
  
  public String getMissionId()
  {
    return this.missionId;
  }
  
  public String getOriginPath()
  {
    return this.originPath;
  }
  
  public int getPicCount()
  {
    return this.picCount;
  }
  
  public int getToastStatus()
  {
    return this.toastStatus;
  }
  
  public int getUploadStatus()
  {
    return this.uploadStatus;
  }
  
  public int getVideoCount()
  {
    return this.videoCount;
  }
  
  public boolean isCanSelect()
  {
    return this.canSelect;
  }
  
  public boolean isSelected()
  {
    return this.isSelected;
  }
  
  public void setCanSelect(boolean paramBoolean)
  {
    this.canSelect = paramBoolean;
  }
  
  public void setClientKey(String paramString)
  {
    this.clientKey = paramString;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setCoverUrl(String paramString)
  {
    this.coverUrl = paramString;
  }
  
  public void setCreateTime(long paramLong)
  {
    this.createTime = paramLong;
  }
  
  public void setMediaType(int paramInt)
  {
    this.mediaType = paramInt;
  }
  
  public void setMissionId(String paramString)
  {
    this.missionId = paramString;
  }
  
  public DraftBean setOriginPath(String paramString)
  {
    this.originPath = paramString;
    return this;
  }
  
  public void setPicCount(int paramInt)
  {
    this.picCount = paramInt;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.isSelected = paramBoolean;
  }
  
  public void setToastStatus(int paramInt)
  {
    this.toastStatus = paramInt;
  }
  
  public void setUploadStatus(int paramInt)
  {
    this.uploadStatus = paramInt;
  }
  
  public void setVideoCount(int paramInt)
  {
    this.videoCount = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DraftBean{uploadStatus=");
    localStringBuilder.append(this.uploadStatus);
    localStringBuilder.append(", toastStatus=");
    localStringBuilder.append(this.toastStatus);
    localStringBuilder.append(", missionId='");
    localStringBuilder.append(this.missionId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", content='");
    localStringBuilder.append(this.content);
    localStringBuilder.append('\'');
    localStringBuilder.append(", createTime=");
    localStringBuilder.append(this.createTime);
    localStringBuilder.append(", coverUrl='");
    localStringBuilder.append(this.coverUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", picCount=");
    localStringBuilder.append(this.picCount);
    localStringBuilder.append(", videoCount=");
    localStringBuilder.append(this.videoCount);
    localStringBuilder.append(", originPath='");
    localStringBuilder.append(this.originPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mediaType=");
    localStringBuilder.append(this.mediaType);
    localStringBuilder.append(", clientKey='");
    localStringBuilder.append(this.clientKey);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.model.DraftBean
 * JD-Core Version:    0.7.0.1
 */