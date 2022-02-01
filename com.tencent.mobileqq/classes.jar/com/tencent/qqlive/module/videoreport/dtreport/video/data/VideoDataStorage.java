package com.tencent.qqlive.module.videoreport.dtreport.video.data;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.data.VideoReportDataStorage;

class VideoDataStorage
{
  private static final VideoReportDataStorage<VideoSession> DATA_MAP = new VideoReportDataStorage();
  
  static VideoSession getData(@NonNull Object paramObject)
  {
    return (VideoSession)DATA_MAP.getData(paramObject);
  }
  
  static void removeData(@NonNull Object paramObject)
  {
    DATA_MAP.removeData(paramObject);
  }
  
  static void setData(@NonNull Object paramObject, @NonNull VideoSession paramVideoSession)
  {
    DATA_MAP.setData(paramObject, paramVideoSession);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoDataStorage
 * JD-Core Version:    0.7.0.1
 */