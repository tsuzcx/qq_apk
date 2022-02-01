package com.tencent.qqlive.module.videoreport.dtreport.video.data;

import android.support.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.Log;
import java.util.HashMap;
import java.util.Map;

public class VideoEntity
{
  private static final String TAG = "VideoEntity";
  private String contentId = "";
  private int contentType = -1;
  private int pageId = 0;
  private Map<String, Object> videoCustomParams;
  private long videoDuration = 0L;
  
  private VideoEntity()
  {
    Log.i("VideoEntity", "VideoEntity create!");
  }
  
  public String getContentId()
  {
    return this.contentId;
  }
  
  public int getContentType()
  {
    return this.contentType;
  }
  
  @Nullable
  public int getPageId()
  {
    return this.pageId;
  }
  
  public Map<String, Object> getVideoCustomParams()
  {
    if (this.videoCustomParams == null) {
      this.videoCustomParams = new HashMap();
    }
    return this.videoCustomParams;
  }
  
  public long getVideoDuration()
  {
    return this.videoDuration;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity
 * JD-Core Version:    0.7.0.1
 */