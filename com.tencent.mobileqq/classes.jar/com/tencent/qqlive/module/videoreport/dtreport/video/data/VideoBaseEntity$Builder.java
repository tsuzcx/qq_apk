package com.tencent.qqlive.module.videoreport.dtreport.video.data;

import java.util.HashMap;
import java.util.Map;

public class VideoBaseEntity$Builder
{
  protected int contentType;
  protected String identifier;
  protected boolean isBizReady = true;
  protected boolean isIgnoreReport = false;
  protected int pageId;
  protected Map<String, Object> videoCustomParams;
  protected int videoDuration;
  
  public VideoBaseEntity$Builder() {}
  
  public VideoBaseEntity$Builder(VideoBaseEntity paramVideoBaseEntity)
  {
    this.identifier = paramVideoBaseEntity.identifier;
    this.contentType = paramVideoBaseEntity.contentType;
    this.videoCustomParams = paramVideoBaseEntity.videoCustomParams;
    this.pageId = paramVideoBaseEntity.pageId;
    this.videoDuration = paramVideoBaseEntity.videoDuration;
    this.isBizReady = paramVideoBaseEntity.isBizReady;
    this.isIgnoreReport = paramVideoBaseEntity.isIgnoreReport;
  }
  
  public Builder addCustomParams(Map<String, ?> paramMap)
  {
    if (paramMap == null) {
      return this;
    }
    if (this.videoCustomParams == null) {
      this.videoCustomParams = new HashMap(paramMap.size());
    }
    this.videoCustomParams.putAll(paramMap);
    return this;
  }
  
  public Builder bizReady(boolean paramBoolean)
  {
    this.isBizReady = paramBoolean;
    return this;
  }
  
  public VideoBaseEntity build()
  {
    VideoBaseEntity localVideoBaseEntity = new VideoBaseEntity();
    localVideoBaseEntity.identifier = this.identifier;
    localVideoBaseEntity.contentType = this.contentType;
    localVideoBaseEntity.videoCustomParams = this.videoCustomParams;
    localVideoBaseEntity.pageId = this.pageId;
    localVideoBaseEntity.videoDuration = this.videoDuration;
    localVideoBaseEntity.isBizReady = this.isBizReady;
    localVideoBaseEntity.isIgnoreReport = this.isIgnoreReport;
    return localVideoBaseEntity;
  }
  
  public Builder ignoreReport(boolean paramBoolean)
  {
    this.isIgnoreReport = paramBoolean;
    return this;
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
  
  public Builder setContentType(int paramInt)
  {
    this.contentType = paramInt;
    return this;
  }
  
  public Builder setIdentifier(String paramString)
  {
    this.identifier = paramString;
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
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity.Builder
 * JD-Core Version:    0.7.0.1
 */