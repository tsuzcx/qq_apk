package com.tencent.tav.decoder;

import com.tencent.tav.coremedia.CMTime;

class AudioDecoder$PendingFrame
{
  public CMTime frameTime = CMTime.CMTimeZero;
  public boolean isFirst = false;
  public CMTime seekStartTime = CMTime.CMTimeZero;
  public long timeOffset = 0L;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioDecoder.PendingFrame
 * JD-Core Version:    0.7.0.1
 */