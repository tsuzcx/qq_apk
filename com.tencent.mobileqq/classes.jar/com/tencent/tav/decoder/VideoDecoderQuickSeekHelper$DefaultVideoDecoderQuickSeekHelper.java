package com.tencent.tav.decoder;

public class VideoDecoderQuickSeekHelper$DefaultVideoDecoderQuickSeekHelper
  extends VideoDecoderQuickSeekHelper
{
  public VideoDecoderQuickSeekHelper$DefaultVideoDecoderQuickSeekHelper()
  {
    super(null);
  }
  
  public boolean isCanQuicklyFinish(long paramLong1, long paramLong2)
  {
    return false;
  }
  
  public boolean isCanSkipCurDecoder(long paramLong1, long paramLong2)
  {
    return false;
  }
  
  public boolean isCareForSeekTime()
  {
    return false;
  }
  
  public void setLastReadSampleTime(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoDecoderQuickSeekHelper.DefaultVideoDecoderQuickSeekHelper
 * JD-Core Version:    0.7.0.1
 */