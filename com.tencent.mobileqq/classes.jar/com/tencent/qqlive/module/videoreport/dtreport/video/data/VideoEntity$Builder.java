package com.tencent.qqlive.module.videoreport.dtreport.video.data;

import java.util.HashMap;
import java.util.Map;

public class VideoEntity$Builder
{
  private String contentId;
  private int contentType;
  private int pageId;
  private Map<String, Object> videoCustomParams;
  private long videoDuration;
  
  public Builder addCustomParams(Map<String, ?> paramMap)
  {
    if (paramMap == null) {
      return this;
    }
    if (this.videoCustomParams == null) {
      this.videoCustomParams = new HashMap(1);
    }
    this.videoCustomParams.putAll(paramMap);
    return this;
  }
  
  public VideoEntity build()
  {
    VideoEntity localVideoEntity = new VideoEntity(null);
    VideoEntity.access$102(localVideoEntity, this.contentId);
    VideoEntity.access$202(localVideoEntity, this.contentType);
    VideoEntity.access$302(localVideoEntity, this.videoCustomParams);
    VideoEntity.access$402(localVideoEntity, this.pageId);
    VideoEntity.access$502(localVideoEntity, this.videoDuration);
    return localVideoEntity;
  }
  
  public Builder removeAllCustomParams()
  {
    if (this.videoCustomParams != null) {
      this.videoCustomParams.clear();
    }
    return this;
  }
  
  public Builder removeCustomParam(String paramString)
  {
    if (this.videoCustomParams != null) {
      this.videoCustomParams.remove(paramString);
    }
    return this;
  }
  
  public Builder setContentId(String paramString)
  {
    this.contentId = paramString;
    return this;
  }
  
  public Builder setContentType(int paramInt)
  {
    this.contentType = paramInt;
    return this;
  }
  
  public Builder setPage(Object paramObject)
  {
    if (paramObject == null) {
      return this;
    }
    this.pageId = paramObject.hashCode();
    return this;
  }
  
  public Builder setVideoDuration(int paramInt)
  {
    this.videoDuration = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity.Builder
 * JD-Core Version:    0.7.0.1
 */