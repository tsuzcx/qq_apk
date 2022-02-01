package com.tencent.mobileqq.winkpublish.model;

public class PublishQueueTaskInfo
{
  public String detail;
  public int leftCount;
  public int progress;
  public long recvDataSize;
  public boolean showHandleProgress;
  public boolean showPreviewIcon;
  public int state;
  public String title;
  public long totalSize;
  public String url;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleQueueTaskInfo [title=");
    localStringBuilder.append(this.title);
    localStringBuilder.append(", detail=");
    localStringBuilder.append(this.detail);
    localStringBuilder.append(", state=");
    localStringBuilder.append(this.state);
    localStringBuilder.append(", recvDataSize=");
    localStringBuilder.append(this.recvDataSize);
    localStringBuilder.append(", totalSize=");
    localStringBuilder.append(this.totalSize);
    localStringBuilder.append(", progress=");
    localStringBuilder.append(this.progress);
    localStringBuilder.append(", url=");
    localStringBuilder.append(this.url);
    localStringBuilder.append(", showVideoPreview=");
    localStringBuilder.append(this.showPreviewIcon);
    localStringBuilder.append(", leftCount=");
    localStringBuilder.append(this.leftCount);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.model.PublishQueueTaskInfo
 * JD-Core Version:    0.7.0.1
 */