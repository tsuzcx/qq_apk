package com.tencent.qqlive.module.videoreport.dtreport.video.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.Log;

public class VideoDataManager
{
  private static final String TAG = "AudioDataManager";
  
  private VideoDataManager()
  {
    Log.i("AudioDataManager", "create VideoDataManager!");
  }
  
  public static VideoDataManager getInstance()
  {
    return VideoDataManager.InstanceHolder.sInstance;
  }
  
  public void bindVideoInfo(@NonNull Object paramObject, VideoSession paramVideoSession)
  {
    if (paramVideoSession == null)
    {
      Log.i("AudioDataManager", "entity is null! create default entity!");
      return;
    }
    VideoDataStorage.setData(paramObject, paramVideoSession);
  }
  
  @Nullable
  public VideoSession getVideoInfo(@NonNull Object paramObject)
  {
    paramObject = VideoDataStorage.getData(paramObject);
    if (paramObject == null) {
      Log.e("AudioDataManager", "AudioInfo is null, check'");
    }
    return paramObject;
  }
  
  public void removeVideoInfo(@NonNull Object paramObject)
  {
    VideoDataStorage.removeData(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoDataManager
 * JD-Core Version:    0.7.0.1
 */