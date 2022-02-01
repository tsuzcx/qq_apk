package com.tencent.weishi.module.edit.widget.playtrack.provider;

import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CMTime;

class VideoThumbImageGenerator$ImageThumbTask
  implements Comparable<ImageThumbTask>
{
  private long requestTimeMs;
  private CMTime startTime;
  
  VideoThumbImageGenerator$ImageThumbTask(long paramLong, CMTime paramCMTime)
  {
    this.requestTimeMs = paramLong;
    this.startTime = paramCMTime;
  }
  
  public int compareTo(@NonNull ImageThumbTask paramImageThumbTask)
  {
    return (int)(this.requestTimeMs - paramImageThumbTask.requestTimeMs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbImageGenerator.ImageThumbTask
 * JD-Core Version:    0.7.0.1
 */