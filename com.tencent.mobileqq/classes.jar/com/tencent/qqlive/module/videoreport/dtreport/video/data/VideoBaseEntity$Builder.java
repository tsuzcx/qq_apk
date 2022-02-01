package com.tencent.qqlive.module.videoreport.dtreport.video.data;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoBaseEntity$Builder
{
  protected int contentType;
  protected String identifier;
  protected boolean isBizReady = true;
  protected boolean isIgnoreReport = false;
  protected int pageId;
  protected Map<String, Object> videoCustomParams;
  protected int videoDuration;
  protected WeakReference<View> videoView;
  
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
    this.videoView = paramVideoBaseEntity.videoView;
  }
  
  public Builder addCustomParams(Map<String, ?> paramMap)
  {
    if (paramMap == null) {
      return this;
    }
    if (this.videoCustomParams == null) {
      this.videoCustomParams = new ConcurrentHashMap(paramMap.size());
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
    localVideoBaseEntity.videoView = this.videoView;
    return localVideoBaseEntity;
  }
  
  public Builder ignoreReport(boolean paramBoolean)
  {
    this.isIgnoreReport = paramBoolean;
    return this;
  }
  
  public Builder removeAllCustomParams()
  {
    Map localMap = this.videoCustomParams;
    if (localMap != null) {
      localMap.clear();
    }
    return this;
  }
  
  public Builder removeCustomParam(String paramString)
  {
    Map localMap = this.videoCustomParams;
    if (localMap != null) {
      localMap.remove(paramString);
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
  
  public Builder setVideoView(View paramView)
  {
    if (paramView != null) {
      this.videoView = new WeakReference(paramView);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity.Builder
 * JD-Core Version:    0.7.0.1
 */