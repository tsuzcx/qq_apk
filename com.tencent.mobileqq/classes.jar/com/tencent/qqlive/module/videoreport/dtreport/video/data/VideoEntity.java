package com.tencent.qqlive.module.videoreport.dtreport.video.data;

import com.tencent.qqlive.module.videoreport.Log;

public class VideoEntity
  extends VideoBaseEntity
{
  private static final String TAG = "VideoEntity";
  private String contentId = "";
  
  private VideoEntity()
  {
    Log.i("VideoEntity", "VideoEntity create!");
  }
  
  public String getContentId()
  {
    return this.contentId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity
 * JD-Core Version:    0.7.0.1
 */