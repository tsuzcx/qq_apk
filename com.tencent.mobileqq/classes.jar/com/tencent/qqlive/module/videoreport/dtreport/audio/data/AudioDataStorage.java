package com.tencent.qqlive.module.videoreport.dtreport.audio.data;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.data.VideoReportDataStorage;

class AudioDataStorage
{
  private static final VideoReportDataStorage<AudioEntity> DATA_MAP = new VideoReportDataStorage();
  
  static AudioEntity getData(@NonNull Object paramObject)
  {
    return (AudioEntity)DATA_MAP.getData(paramObject);
  }
  
  static void setData(@NonNull Object paramObject, @NonNull AudioEntity paramAudioEntity)
  {
    DATA_MAP.setData(paramObject, paramAudioEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.data.AudioDataStorage
 * JD-Core Version:    0.7.0.1
 */