package com.tencent.tav.decoder;

import com.tencent.tav.coremedia.CMTime;

class VideoDecoder$SampleTime
{
  private CMTime cmTime;
  private long timeUs;
  
  private VideoDecoder$SampleTime(VideoDecoder paramVideoDecoder) {}
  
  private void fixCMTime()
  {
    if (!this.cmTime.smallThan(CMTime.CMTimeZero)) {
      return;
    }
    this.cmTime = CMTime.fromUs(VideoDecoder.access$1100(this.this$0));
  }
  
  public String toString()
  {
    return "SampleTime{cmTime=" + this.cmTime + ", timeUs=" + this.timeUs + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoDecoder.SampleTime
 * JD-Core Version:    0.7.0.1
 */