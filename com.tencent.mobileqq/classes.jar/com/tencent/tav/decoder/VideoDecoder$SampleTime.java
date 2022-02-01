package com.tencent.tav.decoder;

import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;

class VideoDecoder$SampleTime
{
  private CMSampleState sampleState;
  private long timeUs;
  
  private VideoDecoder$SampleTime(VideoDecoder paramVideoDecoder) {}
  
  private void fixCMTime()
  {
    if (!this.sampleState.getTime().smallThan(CMTime.CMTimeZero)) {
      return;
    }
    this.sampleState = new CMSampleState(CMTime.fromUs(VideoDecoder.access$1000(this.this$0)));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SampleTime{sampleState=");
    localStringBuilder.append(this.sampleState);
    localStringBuilder.append(", timeUs=");
    localStringBuilder.append(this.timeUs);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoDecoder.SampleTime
 * JD-Core Version:    0.7.0.1
 */