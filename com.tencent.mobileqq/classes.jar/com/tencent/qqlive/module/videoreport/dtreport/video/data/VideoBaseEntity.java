package com.tencent.qqlive.module.videoreport.dtreport.video.data;

import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Log;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoBaseEntity
{
  private static final String TAG = "VideoBaseEntity";
  protected int contentType = -1;
  protected String identifier;
  protected boolean isBizReady = true;
  protected boolean isIgnoreReport = false;
  protected int pageId = 0;
  protected Map<String, Object> videoCustomParams;
  protected int videoDuration = 0;
  protected WeakReference<View> videoView;
  
  public VideoBaseEntity()
  {
    Log.i("VideoBaseEntity", "VideoBaseEntity create!");
  }
  
  public int getContentType()
  {
    return this.contentType;
  }
  
  public String getIdentifier()
  {
    return this.identifier;
  }
  
  @Nullable
  public int getPageId()
  {
    return this.pageId;
  }
  
  public Map<String, Object> getVideoCustomParams()
  {
    if (this.videoCustomParams == null) {
      this.videoCustomParams = new ConcurrentHashMap();
    }
    return this.videoCustomParams;
  }
  
  public long getVideoDuration()
  {
    return this.videoDuration;
  }
  
  public WeakReference<View> getVideoView()
  {
    return this.videoView;
  }
  
  public boolean isBizReady()
  {
    return this.isBizReady;
  }
  
  public boolean isIgnoreReport()
  {
    return this.isIgnoreReport;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity
 * JD-Core Version:    0.7.0.1
 */