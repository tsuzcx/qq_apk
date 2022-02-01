package com.tencent.mobileqq.winkpublish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class WinkDraftStatusEvent
  extends SimpleBaseEvent
{
  public static final int TOAST_STATUS_NO_POP = 1;
  public static final int TOAST_STATUS_POPPED = 2;
  public static final int TOAST_STATUS_UN_DEFINED = -1;
  public static final int UPLOAD_STATUS_FAILED = 3;
  public static final int UPLOAD_STATUS_PUBLISHING = 2;
  public static final int UPLOAD_STATUS_SUCCESS = 4;
  public static final int UPLOAD_STATUS_UN_DEFINED = -1;
  public static final int UPLOAD_STATUS_UPLOADING = 1;
  private String missionId;
  private int toastStatus = -1;
  private int uploadStatus = -1;
  
  public WinkDraftStatusEvent(int paramInt)
  {
    this.uploadStatus = paramInt;
  }
  
  public WinkDraftStatusEvent(String paramString)
  {
    this.missionId = paramString;
  }
  
  public String getMissionId()
  {
    return this.missionId;
  }
  
  public int getToastStatus()
  {
    return this.toastStatus;
  }
  
  public int getUploadStatus()
  {
    return this.uploadStatus;
  }
  
  public void setMissionId(String paramString)
  {
    this.missionId = paramString;
  }
  
  public void setToastStatus(int paramInt)
  {
    this.toastStatus = paramInt;
  }
  
  public void setUploadStatus(int paramInt)
  {
    this.uploadStatus = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WinkDraftStatusEvent{missionId='");
    localStringBuilder.append(this.missionId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uploadStatus=");
    localStringBuilder.append(this.uploadStatus);
    localStringBuilder.append(", toastStatus=");
    localStringBuilder.append(this.toastStatus);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.event.WinkDraftStatusEvent
 * JD-Core Version:    0.7.0.1
 */