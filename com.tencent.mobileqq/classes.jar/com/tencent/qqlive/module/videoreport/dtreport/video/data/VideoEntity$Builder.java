package com.tencent.qqlive.module.videoreport.dtreport.video.data;

import android.view.View;
import java.util.Map;

public class VideoEntity$Builder
  extends VideoBaseEntity.Builder
{
  private String contentId;
  
  public VideoEntity$Builder() {}
  
  public VideoEntity$Builder(VideoEntity paramVideoEntity)
  {
    super(paramVideoEntity);
    this.contentId = VideoEntity.access$000(paramVideoEntity);
  }
  
  public Builder addCustomParams(Map<String, ?> paramMap)
  {
    super.addCustomParams(paramMap);
    return this;
  }
  
  public Builder bizReady(boolean paramBoolean)
  {
    super.bizReady(paramBoolean);
    return this;
  }
  
  public VideoEntity build()
  {
    VideoEntity localVideoEntity = new VideoEntity(null);
    localVideoEntity.identifier = this.identifier;
    VideoEntity.access$002(localVideoEntity, this.contentId);
    localVideoEntity.contentType = this.contentType;
    localVideoEntity.videoCustomParams = this.videoCustomParams;
    localVideoEntity.pageId = this.pageId;
    localVideoEntity.videoDuration = this.videoDuration;
    localVideoEntity.isBizReady = this.isBizReady;
    localVideoEntity.isIgnoreReport = this.isIgnoreReport;
    localVideoEntity.videoView = this.videoView;
    return localVideoEntity;
  }
  
  public Builder ignoreReport(boolean paramBoolean)
  {
    super.ignoreReport(paramBoolean);
    return this;
  }
  
  public Builder removeAllCustomParams()
  {
    super.removeAllCustomParams();
    return this;
  }
  
  public Builder removeCustomParam(String paramString)
  {
    super.removeCustomParam(paramString);
    return this;
  }
  
  public Builder setContentId(String paramString)
  {
    this.contentId = paramString;
    return this;
  }
  
  public Builder setContentType(int paramInt)
  {
    super.setContentType(paramInt);
    return this;
  }
  
  public Builder setIdentifier(String paramString)
  {
    super.setIdentifier(paramString);
    return this;
  }
  
  public Builder setPage(Object paramObject)
  {
    super.setPage(paramObject);
    return this;
  }
  
  public Builder setVideoDuration(int paramInt)
  {
    super.setVideoDuration(paramInt);
    return this;
  }
  
  public Builder setVideoView(View paramView)
  {
    super.setVideoView(paramView);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity.Builder
 * JD-Core Version:    0.7.0.1
 */