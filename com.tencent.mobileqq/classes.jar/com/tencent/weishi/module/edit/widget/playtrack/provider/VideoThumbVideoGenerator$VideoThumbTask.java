package com.tencent.weishi.module.edit.widget.playtrack.provider;

import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CMTime;

class VideoThumbVideoGenerator$VideoThumbTask
  implements Comparable<VideoThumbTask>
{
  private long requestTimeMs;
  private CMTime startTime;
  
  VideoThumbVideoGenerator$VideoThumbTask(long paramLong, CMTime paramCMTime)
  {
    this.requestTimeMs = paramLong;
    this.startTime = paramCMTime;
  }
  
  public int compareTo(@NonNull VideoThumbTask paramVideoThumbTask)
  {
    return (int)(paramVideoThumbTask.requestTimeMs - this.requestTimeMs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbVideoGenerator.VideoThumbTask
 * JD-Core Version:    0.7.0.1
 */