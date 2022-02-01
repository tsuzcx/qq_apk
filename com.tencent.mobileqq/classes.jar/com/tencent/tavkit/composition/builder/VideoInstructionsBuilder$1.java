package com.tencent.tavkit.composition.builder;

import com.tencent.tav.coremedia.CMTime;
import java.util.Comparator;

final class VideoInstructionsBuilder$1
  implements Comparator<CMTime>
{
  public int compare(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    return (int)paramCMTime1.sub(paramCMTime2).getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.VideoInstructionsBuilder.1
 * JD-Core Version:    0.7.0.1
 */